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
package org.dominokit.domino.ui.forms.suggest;

import java.util.Optional;
import org.dominokit.domino.ui.IsElement;
import org.dominokit.domino.ui.utils.ComponentMeta;
import org.dominokit.domino.ui.utils.HasMeta;

/**
 * Represents the metadata associated with an option in a suggest box.
 *
 * @param <V> The type of value associated with the option.
 * @param <C> The type of component associated with the option.
 * @param <O> The type of the option itself.
 */
public class OptionMeta<V, C extends IsElement<?>, O extends Option<V, C, O>>
    implements ComponentMeta {

  /** The key used to store and retrieve option metadata. */
  public static final String OPTION_META = "dui-suggest-option-meta";

  private C component;
  private O option;

  /**
   * Creates and returns an {@code OptionMeta} instance with the specified component and option.
   *
   * @param <V> The type of value associated with the option.
   * @param <C> The type of component associated with the option.
   * @param <O> The type of the option itself.
   * @param component The component associated with the option.
   * @param option The option itself.
   * @return An {@code OptionMeta} instance.
   */
  public static <V, C extends IsElement<?>, O extends Option<V, C, O>> OptionMeta<V, C, O> of(
      C component, O option) {
    return new OptionMeta<>(component, option);
  }

  /**
   * Creates an instance of {@code OptionMeta} with the given component and option.
   *
   * @param component The component associated with the option.
   * @param option The option itself.
   */
  public OptionMeta(C component, O option) {
    this.component = component;
    this.option = option;
  }

  /**
   * Retrieves the {@code OptionMeta} associated with a component that supports metadata.
   *
   * @param <V> The type of value associated with the option.
   * @param <C> The type of component associated with the option.
   * @param <O> The type of the option itself.
   * @param component The component for which to retrieve the option metadata.
   * @return An {@code Optional} containing the {@code OptionMeta}, or an empty {@code Optional} if
   *     not found.
   */
  public static <V, C extends IsElement<?>, O extends Option<V, C, O>>
      Optional<OptionMeta<V, C, O>> get(HasMeta<?> component) {
    return component.getMeta(OPTION_META);
  }

  /**
   * Gets the component associated with this option metadata.
   *
   * @return The component associated with the option.
   */
  public C getComponent() {
    return component;
  }

  /**
   * Gets the option itself.
   *
   * @return The option.
   */
  public O getOption() {
    return option;
  }

  /**
   * Retrieves the key associated with this option metadata.
   *
   * @return The key used to store and retrieve option metadata.
   */
  @Override
  public String getKey() {
    return OPTION_META;
  }

  public void cleanup() {
    this.component = null;
    this.option = null;
  }
}
