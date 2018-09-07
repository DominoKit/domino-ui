package org.dominokit.domino.ui.carousel;

import com.google.gwt.core.client.Scheduler;
import elemental2.dom.HTMLAnchorElement;
import elemental2.dom.HTMLDivElement;
import elemental2.dom.HTMLOListElement;
import org.dominokit.domino.ui.style.Style;
import org.dominokit.domino.ui.utils.BaseDominoElement;
import org.dominokit.domino.ui.utils.DominoElement;
import org.dominokit.domino.ui.utils.ElementUtil;
import org.dominokit.domino.ui.utils.SwipeUtil;
import org.gwtproject.timer.client.Timer;
import org.jboss.gwt.elemento.core.IsElement;

import java.util.ArrayList;
import java.util.List;

import static org.jboss.gwt.elemento.core.Elements.*;

public class Carousel extends BaseDominoElement<HTMLDivElement, Carousel> {

    private HTMLOListElement indicatorsElement = ol().css("carousel-indicators").asElement();
    private HTMLDivElement slidesElement = div().css("carousel-inner").asElement();
    private boolean autoSlide = false;

    private HTMLAnchorElement prevElement = a()
            .css("left", "carousel-control")
            .attr("role", "button")
            .add(span()
                    .css("glyphicon", "glyphicon-chevron-left")
                    .attr("aria-hidden", "true"))
            .add(span().css("sr-only").textContent("Previous"))
            .asElement();


    private HTMLAnchorElement nextElement = a()
            .css("right", "carousel-control")
            .attr("role", "button")
            .add(span()
                    .css("glyphicon", "glyphicon-chevron-right")
                    .attr("aria-hidden", "true"))
            .add(span().css("sr-only").textContent("Next"))
            .asElement();

    private HTMLDivElement element = div()
            .add(indicatorsElement)
            .add(slidesElement)
            .add(prevElement)
            .add(nextElement)
            .css("carousel", "slide")
            .asElement();


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
        ElementUtil.onDetach(asElement(), mutationRecord -> {
            this.attached = false;
            this.stopAutoSlide();
        });
    }

    private void addAttachListener() {
        ElementUtil.onAttach(this.asElement(), mutationRecord -> {
            this.attached = true;
            if(autoSlide){
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
     * @param slide
     * @return
     */
    @Deprecated
    public Carousel addSlide(Slide slide) {
        return appendChild(slide);
    }


    public Carousel appendChild(Slide slide) {
        getIndicatorsElement().appendChild(slide.getIndicatorElement().asElement());
        slidesElement.appendChild(slide.asElement());
        slide.getIndicatorElement().addEventListener("click", evt -> {
            resetTimer();
            gotToSlide(slide, "");
        });

        slide.asElement().addEventListener("webkitTransitionEnd", evt -> removeMotionStyles());
        slide.asElement().addEventListener("MSTransitionEnd", evt -> removeMotionStyles());
        slide.asElement().addEventListener("mozTransitionEnd", evt -> removeMotionStyles());
        slide.asElement().addEventListener("otransitionend", evt -> removeMotionStyles());
        slide.asElement().addEventListener("transitionend", evt -> removeMotionStyles());

        if (slides.isEmpty()) {
            slide.activate();
            this.activeSlide = slide;
        }
        slides.add(slide);

        SwipeUtil.addSwipeListener(SwipeUtil.SwipeDirection.LEFT, slide.asElement(), evt -> {
            nextSlide();
        });

        SwipeUtil.addSwipeListener(SwipeUtil.SwipeDirection.RIGHT, slide.asElement(), evt -> {
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

        gotToSlide(nextSlide, "next");
    }

    private void prevSlide() {
        Slide prevSlide;
        if (slides.indexOf(activeSlide) > 0) {
            prevSlide = slides.get(slides.indexOf(activeSlide) - 1);
        } else {
            prevSlide = slides.get(slides.size() - 1);
        }

        gotToSlide(prevSlide, "prev");
    }

    private void gotToSlide(Slide slide, String source) {
        if (!slide.hasActiveStyle()) {
            this.targetSlide = slide;
            slide.getIndicatorElement().style().add("active");
            activeSlide.getIndicatorElement().style().remove("active");
            slide.style().add(getPostionStyle(slide, source));
            Scheduler.get().scheduleFixedDelay(() -> {
                activeSlide.getIndicatorElement().style().remove("active");
                String directionStyle = getDirectionStyle(slide, source);
                Style.of(slide).add(directionStyle);
                Style.of(activeSlide).add(directionStyle);
                return false;
            }, 50);

        }
    }

    private String getPostionStyle(Slide target, String source) {
        if ((slides.indexOf(target) > slides.indexOf(activeSlide) && !"prev".equals(source)) || ("next".equals(source) && !"".equals("source"))) {
            return "next";
        } else {
            return "prev";
        }
    }

    private String getDirectionStyle(Slide target, String source) {
        if ((slides.indexOf(target) > slides.indexOf(activeSlide) && !"prev".equals(source)) || ("next".equals(source) && !"".equals("source"))) {
            return "left";
        } else {
            return "right";
        }
    }

    private void removeMotionStyles() {
        Style.of(activeSlide)
                .remove("left")
                .remove("right")
                .remove("next")
                .remove("prev");
        activeSlide.deActivate();
        Style.of(targetSlide)
                .remove("left")
                .remove("right")
                .remove("next")
                .remove("prev");

        targetSlide.activate();
        this.activeSlide = targetSlide;
    }

    public Carousel startAutoSlide(int slideDuration) {
        this.autoSlide = true;
        this.autoSlideDuration = slideDuration;
        if(attached){
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
    public HTMLDivElement asElement() {
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
