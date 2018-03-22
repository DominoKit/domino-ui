package org.dominokit.domino.ui.animations;

import org.gwtproject.timer.client.Timer;
import elemental2.dom.EventListener;
import elemental2.dom.HTMLElement;

public class Animation {

    private final CompleteCallback DEFAULT_CALLBACK=element -> {};

    private int duration=800;
    private int delay=0;
    private boolean infinite=false;
    private final HTMLElement element;
    private Transition transition=Transition.BOUNCE;
    private CompleteCallback callback=DEFAULT_CALLBACK;
    private EventListener stopListener;

    public Animation(HTMLElement element) {
        this.element = element;
    }

    public Animation(HTMLElement element, int duration, int delay, boolean infinite) {
        this.element = element;
        this.duration = duration;
        this.delay = delay;
        this.infinite = infinite;
    }

    public static Animation create(HTMLElement element){
        return new Animation(element);
    }

    public Animation duration(int duration){
        this.duration=duration;
        return this;
    }

    public Animation delay(int delay){
        this.delay=delay;
        return this;
    }

    public Animation infinite(){
        this.infinite=true;
        return this;
    }

    public Animation transition(Transition transition){
        this.transition=transition;
        return this;
    }

    public Animation callback(CompleteCallback callback){
        this.callback=callback;
        return this;
    }

    public Animation animate() {
        if(delay>0){
            new Timer() {
                @Override
                public void run() {
                    animateElement();
                }
            }.schedule(delay);
        }else {
            animateElement();
        }

        return this;
    }

    private void animateElement() {
        this.stopListener = evt -> stop();

        element.addEventListener("webkitAnimationEnd", stopListener);
        element.addEventListener("MSAnimationEnd", stopListener);
        element.addEventListener("mozAnimationEnd", stopListener);
        element.addEventListener("oanimationend", stopListener);
        element.addEventListener("animationend", stopListener);

        element.style.transitionDuration=duration+"ms";
        element.style.setProperty("animation-duration", duration+"ms");
        element.style.setProperty("-webkit-animation-duration", duration+"ms");
        if(infinite)
            element.classList.add("infinite");

        element.classList.add("animated");
        element.classList.add("ease-in-out");
        element.classList.add(transition.getStyle());
    }

    public void stop() {
        element.classList.remove(transition.getStyle());
        element.classList.remove("animated");
        element.classList.remove("infinite");
        element.classList.remove("ease-in-out");
        element.style.removeProperty("animation-duration");
        element.style.removeProperty("-webkit-animation-duration");
        element.removeEventListener("webkitAnimationEnd", stopListener);
        element.removeEventListener("MSAnimationEnd", stopListener);
        element.removeEventListener("mozAnimationEnd", stopListener);
        element.removeEventListener("oanimationend", stopListener);
        element.removeEventListener("animationend", stopListener);
        callback.onComplete(element);
    }

    @FunctionalInterface
    public interface CompleteCallback{
        void onComplete(HTMLElement element);
    }
}
