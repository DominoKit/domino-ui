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

public class Counter {

  private int count;
  private int min = Integer.MIN_VALUE;
  private int max = Integer.MAX_VALUE;

  public Counter(int count) {
    this.count = count;
  }

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

  public Counter increment() {
    if (count < max) {
      this.count++;
    }
    return this;
  }

  public Counter increment(int increment) {
    if (this.count + increment < max) {
      this.count = this.count + increment;
    } else {
      this.count = max;
    }
    return this;
  }

  public Counter decrement() {
    if (this.count > min) {
      this.count--;
    }
    return this;
  }

  public Counter decrement(int increment) {
    if (this.count - increment < min) {
      this.count = this.count - increment;
    } else {
      this.count = min;
    }
    return this;
  }

  public int get() {
    return this.count;
  }

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
