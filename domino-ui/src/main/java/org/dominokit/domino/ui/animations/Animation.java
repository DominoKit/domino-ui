package org.dominokit.domino.ui.animations;

import elemental2.dom.EventListener;
import elemental2.dom.HTMLElement;
import org.dominokit.domino.ui.utils.BaseDominoElement;
import org.dominokit.domino.ui.utils.DominoElement;
import org.gwtproject.timer.client.Timer;
import org.jboss.gwt.elemento.core.IsElement;

public class Animation {

    private final CompleteCallback DEFAULT_CALLBACK = element -> {
    };
    private final StartHandler DEFAULT_START_HANDLER = element -> {
    };

    private int duration = 800;
    private int delay = 0;
    private boolean infinite = false;
    private final DominoElement<HTMLElement> element;
    private Transition transition = Transition.BOUNCE;
    private CompleteCallback callback = DEFAULT_CALLBACK;
    private StartHandler startHandler = DEFAULT_START_HANDLER;
    private EventListener stopListener;
    private double repeatCount = 1;

    public Animation(HTMLElement element) {
        this.element = DominoElement.of(element);
    }

    public Animation(HTMLElement element, int duration, int delay, boolean infinite) {
        this(element);
        this.duration = duration;
        this.delay = delay;
        this.infinite = infinite;
    }

    public static Animation create(HTMLElement element) {
        return new Animation(element);
    }

    public static Animation create(BaseDominoElement element) {
        return new Animation(element.element());
    }

    public static Animation create(IsElement element) {
        return new Animation(element.element());
    }

    public Animation duration(int duration) {
        this.duration = duration;
        return this;
    }

    public Animation delay(int delay) {
        this.delay = delay;
        return this;
    }

    public Animation infinite() {
        this.infinite = true;
        return this;
    }

    public Animation transition(Transition transition) {
        this.transition = transition;
        return this;
    }

    public Animation repeat(double repeatCount) {
        this.repeatCount = repeatCount;
        return this;
    }

    public Animation callback(CompleteCallback callback) {
        this.callback = callback;
        return this;
    }

    public Animation beforeStart(StartHandler startHandler) {
        this.startHandler = startHandler;
        return this;
    }

    public Animation animate() {
        if (delay > 0) {
            new Timer() {
                @Override
                public void run() {
                    animateElement();
                }
            }.schedule(delay);
        } else {
            animateElement();
        }

        return this;
    }

    private void animateElement() {
        this.startHandler.beforeStart(element.element());
        this.stopListener = evt -> stop();

        element.addEventListener("webkitAnimationEnd", stopListener);
        element.addEventListener("MSAnimationEnd", stopListener);
        element.addEventListener("mozAnimationEnd", stopListener);
        element.addEventListener("oanimationend", stopListener);
        element.addEventListener("animationend", stopListener);

        element.style().setTransitionDuration(duration + "ms");
        element.style().setProperty("animation-duration", duration + "ms");
        element.style().setProperty("-webkit-animation-duration", duration + "ms");
        if (infinite) {
            element.style().add("infinite");
        }

        if (repeatCount != 1) {
            element.style().setProperty("animation-iteration-count", repeatCount+"");
        }

        element.style().add("animated");
        element.style().add("ease-in-out");
        element.style().add(transition.getStyle());
    }

    public void stop() {
        element.style().remove(transition.getStyle());
        element.style().remove("animated");
        element.style().remove("infinite");
        element.style().remove("ease-in-out");
        element.style().removeProperty("animation-duration");
        element.style().removeProperty("-webkit-animation-duration");
        element.removeEventListener("webkitAnimationEnd", stopListener);
        element.removeEventListener("MSAnimationEnd", stopListener);
        element.removeEventListener("mozAnimationEnd", stopListener);
        element.removeEventListener("oanimationend", stopListener);
        element.removeEventListener("animationend", stopListener);
        callback.onComplete(element.element());
    }

    @FunctionalInterface
    public interface CompleteCallback {
        void onComplete(HTMLElement element);
    }

    @FunctionalInterface
    public interface StartHandler {
        void beforeStart(HTMLElement element);
    }
}
