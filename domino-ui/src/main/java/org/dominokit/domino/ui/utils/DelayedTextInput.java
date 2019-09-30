package org.dominokit.domino.ui.utils;

import elemental2.dom.HTMLInputElement;
import jsinterop.base.Js;
import org.gwtproject.timer.client.Timer;
import org.jboss.gwt.elemento.core.EventType;

import static java.util.Objects.isNull;

public class DelayedTextInput {

    private int delay;
    private final HTMLInputElement inputElement;
    private Timer autoActionTimer;
    private DelayedAction delayedAction = () -> {
    };
    private DelayedAction onEnterAction = () -> delayedAction.doAction();

    public static DelayedTextInput create(HTMLInputElement inputElement, int delay, DelayedAction delayedAction) {
        return new DelayedTextInput(inputElement, delay, delayedAction);
    }

    public static DelayedTextInput create(HTMLInputElement inputElement, int delay) {
        return new DelayedTextInput(inputElement, delay);
    }

    public static DelayedTextInput create(DominoElement<HTMLInputElement> inputElement, int delay) {
        return create(inputElement.asElement(), delay);
    }

    public DelayedTextInput(HTMLInputElement inputElement, int delay) {
        this.inputElement = inputElement;
        this.delay = delay;
        prepare();
    }

    public DelayedTextInput(HTMLInputElement inputElement, int delay, DelayedAction delayedAction) {
        this.inputElement = inputElement;
        this.delay = delay;
        this.delayedAction = delayedAction;

        prepare();
    }

    protected void prepare() {
        autoActionTimer = new Timer() {
            @Override
            public void run() {
                DelayedTextInput.this.delayedAction.doAction();
            }
        };

        inputElement.addEventListener("input", evt -> {
            autoActionTimer.cancel();
            autoActionTimer.schedule(this.delay);
        });

        inputElement.addEventListener(EventType.keypress.getName(), evt -> {
            if (ElementUtil.isEnterKey(Js.uncheckedCast(evt))) {
                DelayedTextInput.this.onEnterAction.doAction();
            }
        });
    }

    public DelayedTextInput setDelayedAction(DelayedAction delayedAction) {
        this.delayedAction = delayedAction;
        return this;
    }

    public DelayedAction getOnEnterAction() {
        return onEnterAction;
    }

    public DelayedTextInput setOnEnterAction(DelayedAction onEnterAction) {
        if (isNull(onEnterAction)) {
            this.onEnterAction = delayedAction;
        } else {
            this.onEnterAction = onEnterAction;
        }

        return this;
    }

    public int getDelay() {
        return delay;
    }

    public void setDelay(int delay) {
        this.delay = delay;
    }

    @FunctionalInterface
    public interface DelayedAction {
        void doAction();
    }
}
