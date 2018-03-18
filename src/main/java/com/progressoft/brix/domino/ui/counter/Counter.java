package com.progressoft.brix.domino.ui.counter;

import com.google.gwt.user.client.Timer;

public class Counter {

    private Timer timer;
    private final int countFrom;
    private final int countTo;
    private final int interval;
    private final int increment;
    private int currentValue;
    private CountHandler countHandler;

    private Counter(int countFrom, int countTo, int interval, int increment, CountHandler countHandler) {
        this.countFrom = countFrom;
        this.countTo = countTo;
        this.interval = interval;
        this.increment = increment;
        this.countHandler=countHandler;

        initTimer();
    }

    public static CanCountTo countFrom(int countFrom){
        return new CounterBuilder(countFrom);
    }

    private void initTimer() {
        timer = new Timer() {
            @Override
            public void run() {
                if (currentValue < countTo) {
                    currentValue += increment;
                    notifyCount();
                } else {
                    cancel();
                }
            }
        };
    }

    private void notifyCount() {
        if (currentValue <= countTo) {
            countHandler.onCount(currentValue);
        } else {
            countHandler.onCount(countTo);
        }
    }

    public void startCounting() {
        if (timer.isRunning())
            timer.cancel();
        this.currentValue = countFrom;
        countHandler.onCount(countFrom);
        timer.scheduleRepeating(interval);
    }

    @FunctionalInterface
    public interface CountHandler{
        void onCount(int count);
    }

    public interface CanCountTo{
        HasInterval countTo(int countTo);
    }

    public interface HasInterval{
        HasIncrement every(int interval);
    }

    public interface HasIncrement{
        HasCountHandler incrementBy(int increment);
    }

    public interface HasCountHandler{
        Counter onCount(CountHandler handler);
    }

    public static class CounterBuilder implements CanCountTo, HasInterval, HasIncrement, HasCountHandler {

        private int countFrom;
        private int countTo;
        private int interval;
        private int increment;

        private CounterBuilder(int countFrom){
            this.countFrom = countFrom;
        }

        @Override
        public HasInterval countTo(int countTo) {
            this.countTo=countTo;
            return this;
        }

        @Override
        public HasIncrement every(int interval) {
            this.interval=interval;
            return this;
        }

        @Override
        public HasCountHandler incrementBy(int increment) {
            this.increment =increment;
            return this;
        }

        @Override
        public Counter onCount(CountHandler handler) {
            return new Counter(countFrom, countTo, interval, increment, handler);
        }
    }
}
