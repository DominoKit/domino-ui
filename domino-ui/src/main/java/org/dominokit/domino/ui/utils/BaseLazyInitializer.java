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

import static java.util.Objects.isNull;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * A base class for lazy initialization of objects.
 *
 * @param <T> The type of the subclass extending BaseLazyInitializer.
 */
public abstract class BaseLazyInitializer<T extends BaseLazyInitializer<T>> {

  private LambdaFunction function;
  private LambdaFunction originalFunction;
  private LambdaFunction doOnceFunction;
  private boolean initialized = false;
  private Set<LambdaFunction> functions;
  private Set<LambdaFunction> doOnce;
  private Set<LambdaFunction> doOnReset;

  /**
   * Constructs a BaseLazyInitializer with the given LambdaFunction.
   *
   * @param function The LambdaFunction to initialize the object.
   */
  public BaseLazyInitializer(LambdaFunction function) {
    this.function = function;
    this.originalFunction = function;
    initDoOnce();
  }

  private void initDoOnce() {
    this.doOnceFunction =
        () -> {
          for (LambdaFunction func : getDoOnce()) {
            func.apply();
          }
          this.doOnceFunction = () -> {};
        };
  }

  private Set<LambdaFunction> getDoOnce() {
    if (isNull(doOnce)) {
      this.doOnce = new HashSet<>();
    }
    return doOnce;
  }

  /**
   * Applies the lazy initialization logic.
   *
   * @return This BaseLazyInitializer instance.
   */
  public T apply() {
    if (!initialized) {
      function.apply();
      function = () -> {};
      this.doOnceFunction.apply();
      for (LambdaFunction func : getFunctions()) {
        func.apply();
      }
      this.initialized = true;
    }
    return (T) this;
  }

  private Set<LambdaFunction> getFunctions() {
    if (isNull(this.functions)) {
      this.functions = new HashSet<>();
    }
    return functions;
  }

  /**
   * Executes the given LambdaFunction if the object has already been initialized.
   *
   * @param lambdaFunction The LambdaFunction to execute if initialized.
   * @return This BaseLazyInitializer instance.
   */
  public T ifInitialized(LambdaFunction lambdaFunction) {
    if (isInitialized()) {
      lambdaFunction.apply();
    }
    return (T) this;
  }

  /**
   * Executes the provided LambdaFunctions when the object has been initialized. If the object has
   * not been initialized yet, stores the functions for future execution.
   *
   * @param functions The LambdaFunctions to execute when initialized.
   * @return This BaseLazyInitializer instance.
   */
  public T whenInitialized(LambdaFunction... functions) {
    if (isInitialized()) {
      for (LambdaFunction func : functions) {
        func.apply();
      }
    } else {
      getFunctions().addAll(Arrays.asList(functions));
    }
    return (T) this;
  }

  /**
   * Executes the given LambdaFunction once when the object is initialized. If the object has
   * already been initialized, the function is executed immediately.
   *
   * @param function The LambdaFunction to execute once.
   * @return This BaseLazyInitializer instance.
   */
  public T doOnce(LambdaFunction function) {
    if (isInitialized()) {
      function.apply();
    } else {
      getDoOnce().add(function);
    }
    return (T) this;
  }

  /**
   * Adds a LambdaFunction to be executed when the object is reset.
   *
   * @param function The LambdaFunction to execute on reset.
   * @return This BaseLazyInitializer instance.
   */
  public T onReset(LambdaFunction function) {
    getDoOnReset().add(function);
    return (T) this;
  }

  private Set<LambdaFunction> getDoOnReset() {
    if (isNull(doOnReset)) {
      this.doOnReset = new HashSet<>();
    }
    return doOnReset;
  }

  /**
   * Checks if the object has been initialized.
   *
   * @return True if the object has been initialized, false otherwise.
   */
  public boolean isInitialized() {
    return initialized;
  }

  /**
   * Resets the object to its initial state, allowing it to be initialized again. Executes
   * registered onReset LambdaFunctions.
   */
  public void reset() {
    if (isInitialized()) {
      this.function = this.originalFunction;
      initDoOnce();
      this.initialized = false;
      for (LambdaFunction func : getDoOnReset()) {
        func.apply();
      }
    }
  }
}
