package org.dominokit.domino.ui.counter;

import org.gwtproject.timer.client.Timer;

/**
 * A component for counting from min to max value with interval and increment
 * <p>
 *     The counter class will allow the user to make a counting trigger that starts from a starting value to an end value.
 *     the increments are controlled with a time interval and the user will be notified through a handler everytime the count it changed
 *
 *     <p>e.g : count from 0 to 100 by 1 increment every 1 second and log the count to the console</p>
 *     <pre>
 *        Counter
 *                 .countFrom(0)
 *                 .countTo(100)
 *                 .every(1000)
 *                 .incrementBy(1)
 *                 .onCount(count -> DomGlobal.console.info(count))
 *                 .startCounting();
 *     </pre>
 * </p>
 */
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

    /**
     * static factory to create a new counter instance with count start
     * @param countFrom int
     * @return {@link CanCountTo}
     */
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

    /**
     * Starts the counter, if the counter is already counting it will reset and start counting from the beginning
     */
    public void startCounting() {
        if (timer.isRunning())
            timer.cancel();
        this.currentValue = countFrom;
        countHandler.onCount(countFrom);
        timer.scheduleRepeating(interval);
    }

    /**
     * An interface to define a handler to be called after each count
     */
    @FunctionalInterface
    public interface CountHandler{
        /**
         *
         * @param count int the current counter value
         */
        void onCount(int count);
    }

    /**
     * An interface to provide the counter end value
     */
    public interface CanCountTo{
        /**
         *
         * @param countTo int , the counter end value
         * @return {@link HasInterval}
         */
        HasInterval countTo(int countTo);
    }

    /**
     * An interface to set the counter count interval
     */
    public interface HasInterval{
        /**
         *
         * @param interval int count interval in milliseconds
         * @return
         */
        HasIncrement every(int interval);
    }

    /**
     * An interface to set the counter increment
     */
    public interface HasIncrement{
        /**
         *
         * @param increment int, the counter increment value
         * @return {@link HasCountHandler}
         */
        HasCountHandler incrementBy(int increment);
    }

    /**
     * An interface to set the count handler
     */
    public interface HasCountHandler{
        /**
         *
         * @param handler {@link CountHandler}
         * @return {@link Counter}
         */
        Counter onCount(CountHandler handler);
    }

    /**
     * A fluent builder to force building a counter with required parameters
     */
    public static class CounterBuilder implements CanCountTo, HasInterval, HasIncrement, HasCountHandler {

        private int countFrom;
        private int countTo;
        private int interval;
        private int increment;

        private CounterBuilder(int countFrom){
            this.countFrom = countFrom;
        }

        /**
         * {@inheritDoc}
         */
        @Override
        public HasInterval countTo(int countTo) {
            this.countTo=countTo;
            return this;
        }

        /**
         * {@inheritDoc}
         */
        @Override
        public HasIncrement every(int interval) {
            this.interval=interval;
            return this;
        }

        /**
         * {@inheritDoc}
         */
        @Override
        public HasCountHandler incrementBy(int increment) {
            this.increment =increment;
            return this;
        }

        /**
         * {@inheritDoc}
         */
        @Override
        public Counter onCount(CountHandler handler) {
            return new Counter(countFrom, countTo, interval, increment, handler);
        }
    }
}
