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
package org.dominokit.domino.ui.counter;

import static java.util.Objects.isNull;

import org.gwtproject.timer.client.Timer;

/**
 * A component for counting from min to max value with interval and increment
 *
 * <p>The counter class will allow the user to make a counting trigger that starts from a starting
 * value to an end value. the increments are controlled with a time interval and the user will be
 * notified through a handler everytime the count it changed
 *
 * <p>e.g : count from 0 to 100 by 1 increment every 1 second and log the count to the console
 *
 * <pre>
 *     Counter.countFrom(0)
 *          .countTo(100)
 *          .every(1000) // Interval in milliseconds
 *          .incrementBy(1)
 *          .onCount(count-> DomGlobal.console.info("counting:"+count))
 *          .startCounting()
 * </pre>
 */
public class Counter {

  private final int dir;
  private Timer timer;
  private final int countFrom;
  private final int countTo;
  private final int interval;
  private final int step;
  private int currentValue;
  private CountHandler countHandler;
  private CompletionHandler completeHandler;

  private Counter(
      int countFrom,
      int countTo,
      int interval,
      int step,
      CountHandler countHandler,
      CompletionHandler completeHandler) {

    if (step < 0) {
      this.countFrom = countTo;
      this.countTo = countFrom;
    } else {
      this.countFrom = countFrom;
      this.countTo = countTo;
    }

    this.currentValue = this.countFrom;
    this.interval = interval;
    this.step = Math.abs(step);
    this.dir = step > 0 ? Integer.compare(countTo, countFrom) : Integer.compare(countFrom, countTo);
    this.countHandler = countHandler;
    this.completeHandler = completeHandler;

    initTimer();
  }

  /**
   * Factory method to create a new counter instance with a starting value
   *
   * @param countFrom int
   * @return {@link org.dominokit.domino.ui.counter.Counter.CanCountTo}
   */
  public static CanCountTo countFrom(int countFrom) {
    return new CounterBuilder(countFrom);
  }

  private void initTimer() {
    timer =
        new Timer() {
          @Override
          public void run() {
            if (currentValue == countTo) {
              stopCounting();
            } else {
              int next = currentValue + dir * step;
              // clamp so we never go past 'end'
              currentValue = (dir > 0 ? Math.min(next, countTo) : Math.max(next, countTo));
              notifyCount();
            }
          }
        };
  }

  public Counter reset() {
    if (this.timer.isRunning()) {
      this.timer.cancel();
    }
    this.currentValue = countFrom;
    return this;
  }

  private void notifyCount() {
    countHandler.onCount(currentValue);
    if (currentValue == countTo) {
      completeHandler.onCount(this);
    }
  }

  /**
   * Starts the counter, if the counter is already counting it will reset and start counting from
   * the beginning
   */
  public Counter startCounting() {
    if (timer.isRunning()) {
      timer.cancel();
    }
    if (countFrom == countTo) {
      notifyCount();
      return this;
    }

    this.currentValue = countFrom;
    notifyCount();
    timer.scheduleRepeating(interval);
    return this;
  }

  /**
   * Stops the counter if it is running
   *
   * @return same counter instance.
   */
  public Counter stopCounting() {
    if (this.timer.isRunning()) {
      this.timer.cancel();
    }
    return this;
  }

  public Counter onCount(CountHandler countHandler) {
    if (isNull(countHandler)) {
      this.countHandler = (count) -> {};
    }
    this.countHandler = countHandler;
    return this;
  }

  public Counter onCompleted(CompletionHandler completeHandler) {
    if (isNull(completeHandler)) {
      this.completeHandler = (counter) -> {};
    }
    this.completeHandler = completeHandler;
    return this;
  }

  public int getCount() {
    return currentValue;
  }

  public int getDir() {
    return dir;
  }

  public int getCountFrom() {
    return countFrom;
  }

  public int getCountTo() {
    return countTo;
  }

  public int getInterval() {
    return interval;
  }

  public int getStep() {
    return step;
  }

  public int getCurrentValue() {
    return currentValue;
  }

  /** Use to add an implementation of a handler to be called after each count */
  @FunctionalInterface
  public interface CountHandler {
    /** @param count int the current counter value */
    void onCount(int count);
  }

  /** Use to add an implementation of a handler to be called after counting completion */
  @FunctionalInterface
  public interface CompletionHandler {
    /** @param counter the completed counter instance */
    void onCount(Counter counter);
  }

  /** An interface to provide the counter end value */
  public interface CanCountTo {
    /**
     * @param countTo int , the counter end value
     * @return {@link HasInterval}
     */
    HasInterval countTo(int countTo);
  }

  /** An interface to set the counter count interval */
  public interface HasInterval {
    /**
     * @param interval int count interval in milliseconds
     * @return
     */
    HasIncrement every(int interval);
  }

  /** An interface to set the counter increment */
  public interface HasIncrement {
    /**
     * @param increment int, the counter increment value
     * @return {@link Counter}
     */
    Counter step(int increment);
  }

  /** A fluent builder to force building a counter with required parameters */
  public static class CounterBuilder implements CanCountTo, HasInterval, HasIncrement {

    private int countFrom;
    private int countTo;
    private int interval;

    private CounterBuilder(int countFrom) {
      this.countFrom = countFrom;
    }

    /** {@inheritDoc} */
    @Override
    public HasInterval countTo(int countTo) {
      this.countTo = countTo;
      return this;
    }

    /** {@inheritDoc} */
    @Override
    public HasIncrement every(int interval) {
      this.interval = interval;
      return this;
    }

    /** {@inheritDoc} */
    @Override
    public Counter step(int step) {
      return new Counter(countFrom, countTo, interval, step, (count) -> {}, (counter -> {}));
    }
  }

  @Override
  public String toString() {
    return "Counter{"
        + "dir="
        + dir
        + ", countFrom="
        + countFrom
        + ", countTo="
        + countTo
        + ", interval="
        + interval
        + ", step="
        + step
        + ", currentValue="
        + currentValue
        + '}';
  }
}
