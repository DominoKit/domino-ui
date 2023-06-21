/*
 * Copyright © 2019 Dominokit
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.dominokit.domino.ui.carousel;

import static org.dominokit.domino.ui.carousel.CarouselStyles.*;

import elemental2.dom.HTMLDivElement;
import java.util.ArrayList;
import java.util.List;
import org.dominokit.domino.ui.elements.AnchorElement;
import org.dominokit.domino.ui.elements.DivElement;
import org.dominokit.domino.ui.elements.OListElement;
import org.dominokit.domino.ui.icons.lib.Icons;
import org.dominokit.domino.ui.style.CssClass;
import org.dominokit.domino.ui.style.GenericCss;
import org.dominokit.domino.ui.style.SpacingCss;
import org.dominokit.domino.ui.utils.*;
import org.gwtproject.core.client.Scheduler;
import org.gwtproject.timer.client.Timer;

/**
 * A slideshow component for cycling through elements.
 *
 * <p>The component provides APIs for going through all the elements by next/previous indicators.
 * Also, it provides automatic sliding with configurable duration.
 *
 * <p>Customize the component can be done by overwriting classes provided by {@link
 * org.dominokit.domino.ui.carousel.CarouselStyles}
 *
 * @see BaseDominoElement
 * @see CarouselStyles
 * @author vegegoku
 * @version $Id: $Id
 */
public class Carousel extends BaseDominoElement<HTMLDivElement, Carousel> {
  /** Constant <code>NEXT="next"</code> */
  public static final String NEXT = "next";
  /** CSS class for previous indicator */
  public static final String PREV = "prev";

  private final OListElement indicatorsElement;
  private final DivElement slidesElement;
  private boolean autoSlide = false;

  private final AnchorElement prevElement;

  private final AnchorElement nextElement;

  private final DivElement element;

  private final List<Slide> slides = new ArrayList<>();
  private final Timer timer;
  private Slide activeSlide;
  private Slide targetSlide;
  private int autoSlideDuration = 3000;
  private boolean attached = false;

  /** Constructor for Carousel. */
  public Carousel() {

    element =
        div()
            .appendChild(indicatorsElement = ol().addCss(carousel_indicators))
            .appendChild(slidesElement = div().addCss(carousel_inner))
            .appendChild(
                prevElement =
                    a().addCss(slide_left, carousel_control)
                        .setAttribute("role", "button")
                        .appendChild(
                            Icons.chevron_left()
                                .addCss(GenericCss.dui_vertical_center, dui_font_size_12))
                        .addEventListener(
                            "click",
                            evt -> {
                              resetTimer();
                              prevSlide();
                            }))
            .appendChild(
                nextElement =
                    a().addCss(slide_right, carousel_control)
                        .setAttribute("role", "button")
                        .appendChild(
                            Icons.chevron_right()
                                .addCss(
                                    GenericCss.dui_vertical_center, SpacingCss.dui_font_size_12))
                        .addEventListener(
                            "click",
                            evt -> {
                              resetTimer();
                              nextSlide();
                            }))
            .addCss(carousel);
    timer =
        new Timer() {
          @Override
          public void run() {
            nextSlide();
          }
        };
    addAttachListener();
    addDetachListener();
    init(this);
  }

  private void resetTimer() {
    if (autoSlide) {
      timer.cancel();
      timer.scheduleRepeating(autoSlideDuration);
    }
  }

  private void addDetachListener() {
    ElementUtil.onDetach(
        element(),
        mutationRecord -> {
          this.attached = false;
          this.stopAutoSlide();
        });
  }

  private void addAttachListener() {
    ElementUtil.onAttach(
        this.element(),
        mutationRecord -> {
          this.attached = true;
          if (autoSlide) {
            timer.scheduleRepeating(autoSlideDuration);
          }

          addDetachListener();
        });
  }

  /**
   * Creates new carousel
   *
   * @return new instance
   */
  public static Carousel create() {
    return new Carousel();
  }

  /**
   * Adds new {@link org.dominokit.domino.ui.carousel.Slide}, event listeners will be added to the
   * slide for removing the motion styles
   *
   * @param slide a {@link org.dominokit.domino.ui.carousel.Slide} to be added
   * @return same instance
   */
  public Carousel appendChild(Slide slide) {
    getIndicatorsElement().appendChild(slide.getIndicatorElement().element());
    slidesElement.appendChild(slide.element());
    slide
        .getIndicatorElement()
        .addEventListener(
            "click",
            evt -> {
              resetTimer();
              goToSlide(slide, "");
            });

    slide.element().addEventListener("webkitTransitionEnd", evt -> removeMotionStyles());
    slide.element().addEventListener("MSTransitionEnd", evt -> removeMotionStyles());
    slide.element().addEventListener("mozTransitionEnd", evt -> removeMotionStyles());
    slide.element().addEventListener("otransitionend", evt -> removeMotionStyles());
    slide.element().addEventListener("transitionend", evt -> removeMotionStyles());

    if (slides.isEmpty()) {
      slide.activate();
      this.activeSlide = slide;
    }
    slides.add(slide);

    SwipeUtil.addSwipeListener(SwipeUtil.SwipeDirection.LEFT, slide.element(), evt -> nextSlide());
    SwipeUtil.addSwipeListener(SwipeUtil.SwipeDirection.RIGHT, slide.element(), evt -> prevSlide());
    return this;
  }

  private void nextSlide() {
    Slide nextSlide;
    if (slides.indexOf(activeSlide) < slides.size() - 1) {
      nextSlide = slides.get(slides.indexOf(activeSlide) + 1);
    } else {
      nextSlide = slides.get(0);
    }

    goToSlide(nextSlide, NEXT);
  }

  private void prevSlide() {
    Slide prevSlide;
    if (slides.indexOf(activeSlide) > 0) {
      prevSlide = slides.get(slides.indexOf(activeSlide) - 1);
    } else {
      prevSlide = slides.get(slides.size() - 1);
    }

    goToSlide(prevSlide, PREV);
  }

  private void goToSlide(Slide slide, String source) {
    if (!slide.isActive()) {
      this.targetSlide = slide;
      slide.getIndicatorElement().addCss(dui_active);
      activeSlide.getIndicatorElement().removeCss(dui_active);
      slide.addCss(getPositionStyle(slide, source));
      Scheduler.get()
          .scheduleFixedDelay(
              () -> {
                activeSlide.getIndicatorElement().removeCss(dui_active);
                CssClass directionStyle = getDirectionStyle(slide, source);
                slide.addCss(directionStyle);
                activeSlide.addCss(directionStyle);
                return false;
              },
              50);
    }
  }

  private CssClass getPositionStyle(Slide target, String source) {
    if ((slides.indexOf(target) > slides.indexOf(activeSlide) && !PREV.equals(source))
        || (NEXT.equals(source))) {
      return slide_next;
    } else {
      return slide_prev;
    }
  }

  private CssClass getDirectionStyle(Slide target, String source) {
    if ((slides.indexOf(target) > slides.indexOf(activeSlide) && !PREV.equals(source))
        || (NEXT.equals(source))) {
      return slide_left;
    } else {
      return slide_right;
    }
  }

  private void removeMotionStyles() {
    activeSlide
        .removeCss(slide_left)
        .removeCss(slide_right)
        .removeCss(slide_next)
        .removeCss(slide_prev);
    activeSlide.deActivate();
    targetSlide
        .removeCss(slide_left)
        .removeCss(slide_right)
        .removeCss(slide_next)
        .removeCss(slide_prev);

    targetSlide.activate();
    this.activeSlide = targetSlide;
  }

  /**
   * Slides through items every {@code slideDuration}
   *
   * @param slideDuration the time between slide between each element
   * @return same instance
   */
  public Carousel startAutoSlide(int slideDuration) {
    this.autoSlide = true;
    this.autoSlideDuration = slideDuration;
    if (attached) {
      timer.scheduleRepeating(slideDuration);
    }

    return this;
  }

  /**
   * Stops the automatic sliding
   *
   * @return same instance
   */
  public Carousel stopAutoSlide() {
    if (timer.isRunning()) {
      timer.cancel();
    }

    addAttachListener();
    return this;
  }

  /** {@inheritDoc} */
  @Override
  public HTMLDivElement element() {
    return element.element();
  }

  /** @return the indicator element */
  /**
   * Getter for the field <code>indicatorsElement</code>.
   *
   * @return a {@link org.dominokit.domino.ui.elements.OListElement} object
   */
  public OListElement getIndicatorsElement() {
    return indicatorsElement;
  }

  /** @return the slides element which has all the slides */
  /**
   * Getter for the field <code>slidesElement</code>.
   *
   * @return a {@link org.dominokit.domino.ui.elements.DivElement} object
   */
  public DivElement getSlidesElement() {
    return slidesElement;
  }

  /**
   * withSlidesElement.
   *
   * @param handler a {@link org.dominokit.domino.ui.utils.ChildHandler} object
   * @return a {@link org.dominokit.domino.ui.carousel.Carousel} object
   */
  public Carousel withSlidesElement(ChildHandler<Carousel, DivElement> handler) {
    handler.apply(this, slidesElement);
    return this;
  }

  /**
   * withIndicatorsElement.
   *
   * @param handler a {@link org.dominokit.domino.ui.utils.ChildHandler} object
   * @return a {@link org.dominokit.domino.ui.carousel.Carousel} object
   */
  public Carousel withIndicatorsElement(ChildHandler<Carousel, OListElement> handler) {
    handler.apply(this, indicatorsElement);
    return this;
  }

  /**
   * withPreviousElement.
   *
   * @param handler a {@link org.dominokit.domino.ui.utils.ChildHandler} object
   * @return a {@link org.dominokit.domino.ui.carousel.Carousel} object
   */
  public Carousel withPreviousElement(ChildHandler<Carousel, AnchorElement> handler) {
    handler.apply(this, prevElement);
    return this;
  }

  /**
   * withNextElement.
   *
   * @param handler a {@link org.dominokit.domino.ui.utils.ChildHandler} object
   * @return a {@link org.dominokit.domino.ui.carousel.Carousel} object
   */
  public Carousel withNextElement(ChildHandler<Carousel, AnchorElement> handler) {
    handler.apply(this, nextElement);
    return this;
  }

  /** @return All the added slides */
  /**
   * Getter for the field <code>slides</code>.
   *
   * @return a {@link java.util.List} object
   */
  public List<Slide> getSlides() {
    return slides;
  }

  /** @return the currently active slide */
  /**
   * Getter for the field <code>activeSlide</code>.
   *
   * @return a {@link org.dominokit.domino.ui.carousel.Slide} object
   */
  public Slide getActiveSlide() {
    return activeSlide;
  }
}
