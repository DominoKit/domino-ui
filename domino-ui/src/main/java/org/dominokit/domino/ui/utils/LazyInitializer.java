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

import java.util.HashSet;
import java.util.Set;

public class LazyInitializer {

  private LambdaFunction function;
  private LambdaFunction doOnceFunction;
  private boolean initialized = false;
  private Set<LambdaFunction> functions = new HashSet<>();
  private Set<LambdaFunction> doOnce = new HashSet<>();

  public LazyInitializer(LambdaFunction function) {
    this.function = function;
    this.doOnceFunction =
        () -> {
          for (LambdaFunction func : doOnce) {
            func.apply();
          }
          this.doOnceFunction = () -> {};
        };
  }

  public void apply() {
    function.apply();
    function = () -> {};
    this.doOnceFunction.apply();
    for (LambdaFunction func : functions) {
      func.apply();
    }
    this.initialized = true;
  }

  public void ifInitialized(LambdaFunction lambdaFunction) {
    if (isInitialized()) {
      lambdaFunction.apply();
    }
  }

  public void whenInitialized(LambdaFunction function) {
    if (isInitialized()) {
      function.apply();
    } else {
      functions.add(function);
    }
  }

  public void doOnce(LambdaFunction function) {
    if (isInitialized()) {
      function.apply();
    } else {
      doOnce.add(function);
    }
  }

  public boolean isInitialized() {
    return initialized;
  }
}
