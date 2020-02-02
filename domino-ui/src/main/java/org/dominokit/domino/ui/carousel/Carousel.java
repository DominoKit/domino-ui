package org.dominokit.domino.ui.carousel;

import org.gwtproject.core.client.Scheduler;
import elemental2.dom.HTMLAnchorElement;
import elemental2.dom.HTMLDivElement;
import elemental2.dom.HTMLOListElement;
import org.dominokit.domino.ui.icons.Icons;
import org.dominokit.domino.ui.style.Style;
import org.dominokit.domino.ui.style.Styles;
import org.dominokit.domino.ui.utils.BaseDominoElement;
import org.dominokit.domino.ui.utils.DominoElement;
import org.dominokit.domino.ui.utils.ElementUtil;
import org.dominokit.domino.ui.utils.SwipeUtil;
import org.gwtproject.timer.client.Timer;

import java.util.ArrayList;
import java.util.List;

import static org.dominokit.domino.ui.carousel.CarouselStyles.*;
import static org.jboss.gwt.elemento.core.Elements.*;

public class Carousel extends BaseDominoElement<HTMLDivElement, Carousel> {

    private HTMLOListElement indicatorsElement = ol().css(CAROUSEL_INDICATORS).element();
    private HTMLDivElement slidesElement = div().css(CAROUSEL_INNER).element();
    private boolean autoSlide = false;

    private HTMLAnchorElement prevElement = a()
            .css(LEFT, CAROUSEL_CONTROL)
            .attr("role", "button")
            .add(Icons.ALL.chevron_left()
                    .styler(style -> style
                            .add(Styles.vertical_center)
                            .setFontSize("60px")))
            .element();

    private HTMLAnchorElement nextElement = a()
            .css(RIGHT, CAROUSEL_CONTROL)
            .attr("role", "button")
            .add(Icons.ALL.chevron_right()
                    .styler(style -> style
                            .add(Styles.vertical_center)
                            .setFontSize("60px")))
            .element();

    private HTMLDivElement element = div()
            .add(indicatorsElement)
            .add(slidesElement)
            .add(prevElement)
            .add(nextElement)
            .css(CAROUSEL, SLIDE)
            .element();

    private List<Slide> slides = new ArrayList<>();
    private Slide activeSlide;
    private Slide targetSlide;
    private Timer timer;
    private int autoSlideDuration = 3000;
    private boolean attached = false;

    public Carousel() {
        nextElement.addEventListener("click", evt -> {
            resetTimer();
            nextSlide();
        });
        prevElement.addEventListener("click", evt -> {
            resetTimer();
            prevSlide();
        });
        timer = new Timer() {
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
        timer.cancel();
        timer.scheduleRepeating(autoSlideDuration);
    }

    private void addDetachListener() {
        ElementUtil.onDetach(element(), mutationRecord -> {
            this.attached = false;
            this.stopAutoSlide();
        });
    }

    private void addAttachListener() {
        ElementUtil.onAttach(this.element(), mutationRecord -> {
            this.attached = true;
            if (autoSlide) {
                timer.scheduleRepeating(autoSlideDuration);
            }

            addDetachListener();
        });
    }

    public static Carousel create() {
        return new Carousel();
    }

    /**
     * @deprecated use {@link #appendChild(Slide)}
     */
    @Deprecated
    public Carousel addSlide(Slide slide) {
        return appendChild(slide);
    }


    public Carousel appendChild(Slide slide) {
        getIndicatorsElement().appendChild(slide.getIndicatorElement().element());
        slidesElement.appendChild(slide.element());
        slide.getIndicatorElement().addEventListener("click", evt -> {
            resetTimer();
            gotToSlide(slide, "");
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

        SwipeUtil.addSwipeListener(SwipeUtil.SwipeDirection.LEFT, slide.element(), evt -> {
            nextSlide();
        });

        SwipeUtil.addSwipeListener(SwipeUtil.SwipeDirection.RIGHT, slide.element(), evt -> {
            prevSlide();
        });

        return this;
    }

    private void nextSlide() {
        Slide nextSlide;
        if (slides.indexOf(activeSlide) < slides.size() - 1) {
            nextSlide = slides.get(slides.indexOf(activeSlide) + 1);
        } else {
            nextSlide = slides.get(0);
        }

        gotToSlide(nextSlide, NEXT);
    }

    private void prevSlide() {
        Slide prevSlide;
        if (slides.indexOf(activeSlide) > 0) {
            prevSlide = slides.get(slides.indexOf(activeSlide) - 1);
        } else {
            prevSlide = slides.get(slides.size() - 1);
        }

        gotToSlide(prevSlide, PREV);
    }

    private void gotToSlide(Slide slide, String source) {
        if (!slide.hasActiveStyle()) {
            this.targetSlide = slide;
            slide.getIndicatorElement().style().add(ACTIVE);
            activeSlide.getIndicatorElement().style().remove(ACTIVE);
            slide.style().add(getPostionStyle(slide, source));
            Scheduler.get().scheduleFixedDelay(() -> {
                activeSlide.getIndicatorElement().style().remove(ACTIVE);
                String directionStyle = getDirectionStyle(slide, source);
                Style.of(slide).add(directionStyle);
                Style.of(activeSlide).add(directionStyle);
                return false;
            }, 50);

        }
    }

    private String getPostionStyle(Slide target, String source) {
        if ((slides.indexOf(target) > slides.indexOf(activeSlide) && !PREV.equals(source)) || (NEXT.equals(source))) {
            return NEXT;
        } else {
            return PREV;
        }
    }

    private String getDirectionStyle(Slide target, String source) {
        if ((slides.indexOf(target) > slides.indexOf(activeSlide) && !PREV.equals(source)) || (NEXT.equals(source))) {
            return LEFT;
        } else {
            return RIGHT;
        }
    }

    private void removeMotionStyles() {
        Style.of(activeSlide)
                .remove(LEFT)
                .remove(RIGHT)
                .remove(NEXT)
                .remove(PREV);
        activeSlide.deActivate();
        Style.of(targetSlide)
                .remove(LEFT)
                .remove(RIGHT)
                .remove(NEXT)
                .remove(PREV);

        targetSlide.activate();
        this.activeSlide = targetSlide;
    }

    public Carousel startAutoSlide(int slideDuration) {
        this.autoSlide = true;
        this.autoSlideDuration = slideDuration;
        if (attached) {
            timer.scheduleRepeating(slideDuration);
        }

        return this;
    }

    public Carousel stopAutoSlide() {
        if (timer.isRunning()) {
            timer.cancel();
        }

        addAttachListener();
        return this;
    }

    @Override
    public HTMLDivElement element() {
        return element;
    }

    public DominoElement<HTMLOListElement> getIndicatorsElement() {
        return DominoElement.of(indicatorsElement);
    }

    public DominoElement<HTMLDivElement> getSlidesElement() {
        return DominoElement.of(slidesElement);
    }

    public List<Slide> getSlides() {
        return slides;
    }

    public Slide getActiveSlide() {
        return activeSlide;
    }
}
