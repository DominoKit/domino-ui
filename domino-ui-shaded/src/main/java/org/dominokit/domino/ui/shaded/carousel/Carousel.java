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
package org.dominokit.domino.ui.shaded.carousel;

import static org.dominokit.domino.ui.shaded.carousel.CarouselStyles.*;
import static org.jboss.elemento.Elements.*;

import elemental2.dom.HTMLAnchorElement;
import elemental2.dom.HTMLDivElement;
import elemental2.dom.HTMLOListElement;
import java.util.ArrayList;
import java.util.List;
import org.dominokit.domino.ui.shaded.icons.Icons;
import org.dominokit.domino.ui.shaded.style.Styles;
import org.dominokit.domino.ui.shaded.utils.BaseDominoElement;
import org.dominokit.domino.ui.shaded.utils.DominoElement;
import org.dominokit.domino.ui.shaded.utils.SwipeUtil;
import org.gwtproject.core.client.Scheduler;
import org.gwtproject.timer.client.Timer;

/**
 * A slideshow component for cycling through elements.
 *
 * <p>The component provides APIs for going through all the elements by next/previous indicators.
 * Also, it provides automatic sliding with configurable duration.
 *
 * <p>Customize the component can be done by overwriting classes provided by {@link CarouselStyles}
 *
 * <p>For example:
 *
 * <pre>
 *     Carousel.create()
 *             .appendChild(
 *                 Slide.create(
 *                     GWT.getModuleBaseURL()
 *                         + "/images/image-gallery/11.jpg"))
 *             .appendChild(
 *                 Slide.create(
 *                     GWT.getModuleBaseURL()
 *                         + "/images/image-gallery/12.jpg"))
 *             .appendChild(
 *                 Slide.create(
 *                     GWT.getModuleBaseURL()
 *                         + "/images/image-gallery/19.jpg"))
 *             .appendChild(
 *                 Slide.create(
 *                     GWT.getModuleBaseURL() + "/images/image-gallery/9.jpg"))
 *             .appendChild(
 *                 Slide.create(
 *                     GWT.getModuleBaseURL()
 *                         + "/images/image-gallery/6.jpg")))
 * </pre>
 *
 * @see BaseDominoElement
 * @see CarouselStyles
 */
@Deprecated
public class Carousel extends BaseDominoElement<HTMLDivElement, Carousel> {

  private final HTMLOListElement indicatorsElement =
      DominoElement.of(ol()).css(CAROUSEL_INDICATORS).element();
  private final HTMLDivElement slidesElement =
      DominoElement.of(div()).css(CAROUSEL_INNER).element();
  private boolean autoSlide = false;

  private final HTMLAnchorElement prevElement =
      DominoElement.of(a())
          .css(LEFT, CAROUSEL_CONTROL)
          .attr("role", "button")
          .add(Icons.ALL.chevron_left().addCss(Styles.vertical_center).setFontSize("60px"))
          .element();

  private final HTMLAnchorElement nextElement =
      DominoElement.of(a())
          .css(RIGHT, CAROUSEL_CONTROL)
          .attr("role", "button")
          .add(Icons.ALL.chevron_right().addCss(Styles.vertical_center).setFontSize("60px"))
          .element();

  private final HTMLDivElement element =
      DominoElement.of(div())
          .add(indicatorsElement)
          .add(slidesElement)
          .add(prevElement)
          .add(nextElement)
          .css(CAROUSEL)
          .element();

  private final List<Slide> slides = new ArrayList<>();
  private final Timer timer;
  private Slide activeSlide;
  private Slide targetSlide;
  private int autoSlideDuration = 3000;
  private boolean attached = false;

  public Carousel() {
    nextElement.addEventListener(
        "click",
        evt -> {
          resetTimer();
          nextSlide();
        });
    prevElement.addEventListener(
        "click",
        evt -> {
          resetTimer();
          prevSlide();
        });
    timer =
        new Timer() {
          @Override
          public void run() {
            nextSlide();
          }
        };
    init(this);
    addAttachListener();
    addDetachListener();
  }

  private void resetTimer() {
    if (autoSlide) {
      timer.cancel();
      timer.scheduleRepeating(autoSlideDuration);
    }
  }

  private void addDetachListener() {
    onDetached(
        mutationRecord -> {
          this.attached = false;
          this.stopAutoSlide();
        });
  }

  private void addAttachListener() {
    onAttached(
        mutationRecord -> {
          this.attached = true;
          if (autoSlide) {
            timer.scheduleRepeating(autoSlideDuration);
          }
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
   * Adds new {@link Slide}, event listeners will be added to the slide for removing the motion
   * styles
   *
   * @param slide a {@link Slide} to be added
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
    if (!slide.hasActiveStyle()) {
      this.targetSlide = slide;
      slide.getIndicatorElement().addCss(ACTIVE);
      activeSlide.getIndicatorElement().removeCss(ACTIVE);
      slide.addCss(getPositionStyle(slide, source));
      Scheduler.get()
          .scheduleFixedDelay(
              () -> {
                activeSlide.getIndicatorElement().removeCss(ACTIVE);
                String directionStyle = getDirectionStyle(slide, source);
                slide.addCss(directionStyle);
                activeSlide.addCss(directionStyle);
                return false;
              },
              50);
    }
  }

  private String getPositionStyle(Slide target, String source) {
    if ((slides.indexOf(target) > slides.indexOf(activeSlide) && !PREV.equals(source))
        || (NEXT.equals(source))) {
      return NEXT;
    } else {
      return PREV;
    }
  }

  private String getDirectionStyle(Slide target, String source) {
    if ((slides.indexOf(target) > slides.indexOf(activeSlide) && !PREV.equals(source))
        || (NEXT.equals(source))) {
      return LEFT;
    } else {
      return RIGHT;
    }
  }

  private void removeMotionStyles() {
    activeSlide.removeCss(LEFT).removeCss(RIGHT).removeCss(NEXT).removeCss(PREV);
    activeSlide.deActivate();
    targetSlide.removeCss(LEFT).removeCss(RIGHT).removeCss(NEXT).removeCss(PREV);

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
    return element;
  }

  /** @return the indicator element */
  public DominoElement<HTMLOListElement> getIndicatorsElement() {
    return DominoElement.of(indicatorsElement);
  }

  /** @return the slides element which has all the slides */
  public DominoElement<HTMLDivElement> getSlidesElement() {
    return DominoElement.of(slidesElement);
  }

  /** @return All the added slides */
  public List<Slide> getSlides() {
    return slides;
  }

  /** @return the currently active slide */
  public Slide getActiveSlide() {
    return activeSlide;
  }
}
