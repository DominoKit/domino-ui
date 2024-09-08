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
package org.dominokit.domino.ui.shaded.forms;

/**
 * A component that dynamically loads suggestions from a {@link SuggestBoxStore} while the user is
 * typing
 *
 * @param <T> the type of the SuggestBox value
 */
@Deprecated
public class SuggestBox<T> extends AbstractSuggestBox<SuggestBox<T>, T> {

  /** Creates an instance without a label and a null store */
  public SuggestBox() {
    super();
  }

  /**
   * Creates an instance with a label and a null store
   *
   * @param label String label
   */
  public SuggestBox(String label) {
    super(label);
  }

  /**
   * Creates an instance without a label and initialized with a store
   *
   * @param store {@link SuggestBoxStore}
   */
  public SuggestBox(SuggestBoxStore<T> store) {
    super(store);
  }

  /**
   * Creates an instance with a label and initialized with a store
   *
   * @param label String
   * @param store {@link SuggestBoxStore}
   */
  public SuggestBox(String label, SuggestBoxStore<T> store) {
    super(label, store);
  }

  /**
   * Creates an instance with a label and initialized with the input type and a store
   *
   * @param type String input element type
   * @param label String
   * @param store {@link SuggestBoxStore}
   */
  public SuggestBox(String type, String label, SuggestBoxStore<T> store) {
    super(type, label, store);
  }

  /**
   * Creates an instance without a label and initialized with a store
   *
   * @param store {@link SuggestBoxStore}
   * @param <T> the type of the SuggestBox value
   * @return new SuggestBox instance
   */
  public static <T> SuggestBox<T> create(SuggestBoxStore<T> store) {
    return new SuggestBox<>(store);
  }

  /**
   * Creates an instance with a label and initialized with a store
   *
   * @param label String
   * @param store {@link SuggestBoxStore}
   * @param <T> the type of the SuggestBox value
   * @return new SuggestBox instance
   */
  public static <T> SuggestBox<T> create(String label, SuggestBoxStore<T> store) {
    return new SuggestBox<T>(label, store);
  }
}
