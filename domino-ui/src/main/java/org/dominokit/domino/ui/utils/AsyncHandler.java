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
 * An asynchronous handler interface for performing actions asynchronously and notifying completion.
 *
 * @param <T> The type of the field or resource that the handler operates on.
 */
@FunctionalInterface
public interface AsyncHandler<T> {

  /**
   * Applies the asynchronous operation to the specified field or resource and registers a
   * completion handler to be called when the operation is complete.
   *
   * @param field The field or resource on which the asynchronous operation is applied.
   * @param handler The completion handler to be invoked when the operation is complete.
   */
  void apply(T field, CompleteHandler handler);

  /** A functional interface for handling the completion of asynchronous operations. */
  @FunctionalInterface
  interface CompleteHandler {

    /** Called when an asynchronous operation is complete. */
    void onComplete();
  }
}
