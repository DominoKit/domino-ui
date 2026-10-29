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
 * Functional interface representing a lambda function with no arguments and no return value.
 * Implementations of this interface can be used to define simple one-time operations or actions
 * that can be invoked via the {@link #apply()} method.
 *
 * <p>Example usage:
 *
 * <pre>
 * LambdaFunction myFunction = () -> {
 *     // Perform some action or operation
 *     // ...
 * };
 *
 * // Invoke the lambda function
 * myFunction.apply();
 * </pre>
 *
 * @see <a href="https://docs.oracle.com/javase/tutorial/java/javaOO/lambdaexpressions.html">Lambda
 *     Expressions</a>
 */
@FunctionalInterface
public interface LambdaFunction {

  /** Performs the defined action or operation represented by this lambda function. */
  void apply();
}
