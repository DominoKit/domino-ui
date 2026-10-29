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
package org.dominokit.domino.ui.utils;

/**
 * The {@code Counter} class represents a counter with minimum and maximum limits. It allows
 * incrementing and decrementing within the defined range.
 *
 * <p>By default, a counter is initialized with a value of zero, minimum limit as {@code
 * Integer.MIN_VALUE}, and maximum limit as {@code Integer.MAX_VALUE}.
 *
 * <p>Example Usage:
 *
 * <pre>
 * Counter counter = new Counter(5, 1, 10); // Creates a counter with an initial value of 5,
 *                                          // minimum limit 1, and maximum limit 10.
 * counter.increment(); // Increments the counter by 1.
 * counter.decrement(3); // Decrements the counter by 3.
 * int currentValue = counter.get(); // Retrieves the current value of the counter.
 * </pre>
 */
public class Counter {

  private int count;
  private int min = Integer.MIN_VALUE;
  private int max = Integer.MAX_VALUE;

  /**
   * Constructs a new {@code Counter} with the specified initial count.
   *
   * @param count The initial count value.
   */
  public Counter(int count) {
    this.count = count;
  }

  /**
   * Constructs a new {@code Counter} with the specified initial count, minimum limit, and maximum
   * limit. If the provided count is outside the specified limits, it will be adjusted to the
   * closest limit.
   *
   * @param count The initial count value.
   * @param min The minimum limit for the count.
   * @param max The maximum limit for the count.
   */
  public Counter(int count, int min, int max) {
    this.min = min;
    this.max = max;
    if (count < min) {
      this.count = min;
    } else if (count > max) {
      this.count = max;
    } else {
      this.count = count;
    }
  }

  /**
   * Increments the counter by 1 if the current count is less than the maximum limit.
   *
   * @return This {@code Counter} instance.
   */
  public Counter increment() {
    if (count < max) {
      this.count++;
    }
    return this;
  }

  /**
   * Increments the counter by the specified amount if the resulting count is less than the maximum
   * limit. If the increment exceeds the maximum limit, the count is set to the maximum limit.
   *
   * @param increment The amount to increment the counter by.
   * @return This {@code Counter} instance.
   */
  public Counter increment(int increment) {
    if (this.count + increment < max) {
      this.count = this.count + increment;
    } else {
      this.count = max;
    }
    return this;
  }

  /**
   * Decrements the counter by 1 if the current count is greater than the minimum limit.
   *
   * @return This {@code Counter} instance.
   */
  public Counter decrement() {
    if (this.count > min) {
      this.count--;
    }
    return this;
  }

  /**
   * Decrements the counter by the specified amount if the resulting count is greater than the
   * minimum limit. If the decrement exceeds the minimum limit, the count is set to the minimum
   * limit.
   *
   * @param decrement The amount to decrement the counter by.
   * @return This {@code Counter} instance.
   */
  public Counter decrement(int decrement) {
    if (this.count - decrement < min) {
      this.count = this.count - decrement;
    } else {
      this.count = min;
    }
    return this;
  }

  /**
   * Retrieves the current value of the counter.
   *
   * @return The current count value.
   */
  public int get() {
    return this.count;
  }

  /**
   * Sets the count to the specified value, adjusting it to the closest limit if necessary.
   *
   * @param count The new count value.
   * @return This {@code Counter} instance.
   */
  public Counter set(int count) {
    if (this.count < min) {
      this.count = min;
    } else if (count > max) {
      this.count = max;
    } else {
      this.count = count;
    }
    return this;
  }
}
