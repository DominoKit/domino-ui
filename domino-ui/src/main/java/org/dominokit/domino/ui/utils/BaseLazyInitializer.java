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

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public abstract class BaseLazyInitializer<T extends BaseLazyInitializer<T>> {

  private LambdaFunction function;
  private LambdaFunction originalFunction;
  private LambdaFunction doOnceFunction;
  private boolean initialized = false;
  private Set<LambdaFunction> functions = new HashSet<>();
  private Set<LambdaFunction> doOnce = new HashSet<>();
  private Set<LambdaFunction> doOnReset = new HashSet<>();

  public BaseLazyInitializer(LambdaFunction function) {
    this.function = function;
    this.originalFunction = function;
    initDoOnce();
  }

  private void initDoOnce() {
    this.doOnceFunction =
        () -> {
          for (LambdaFunction func : doOnce) {
            func.apply();
          }
          this.doOnceFunction = () -> {};
        };
  }

  public T apply() {
    if (!initialized) {
      function.apply();
      function = () -> {};
      this.doOnceFunction.apply();
      for (LambdaFunction func : functions) {
        func.apply();
      }
      this.initialized = true;
    }
    return (T) this;
  }

  public T ifInitialized(LambdaFunction lambdaFunction) {
    if (isInitialized()) {
      lambdaFunction.apply();
    }
    return (T) this;
  }

  public T whenInitialized(LambdaFunction... functions) {
    if (isInitialized()) {
      for (LambdaFunction func : functions) {
        func.apply();
      }
    } else {
      this.functions.addAll(Arrays.asList(functions));
    }
    return (T) this;
  }

  public T doOnce(LambdaFunction function) {
    if (isInitialized()) {
      function.apply();
    } else {
      doOnce.add(function);
    }
    return (T) this;
  }

  public T onReset(LambdaFunction function) {
    doOnReset.add(function);
    return (T) this;
  }

  public boolean isInitialized() {
    return initialized;
  }

  public void reset() {
    if (isInitialized()) {
      this.function = this.originalFunction;
      initDoOnce();
      this.initialized = false;
      for (LambdaFunction func : doOnReset) {
        func.apply();
      }
    }
  }
}
