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
 * OptionMeta class.
 *
 * @author vegegoku
 * @version $Id: $Id
 */
public class OptionMeta<V, C extends IsElement<?>, O extends Option<V, C, O>>
    implements ComponentMeta {

  /** Constant <code>OPTION_META="dui-suggest-option-meta"</code> */
  public static final String OPTION_META = "dui-suggest-option-meta";

  private final C component;
  private final O option;

  /**
   * of.
   *
   * @param component a C object
   * @param option a O object
   * @param <V> a V class
   * @param <C> a C class
   * @param <O> a O class
   * @return a {@link org.dominokit.domino.ui.forms.suggest.OptionMeta} object
   */
  public static <V, C extends IsElement<?>, O extends Option<V, C, O>> OptionMeta<V, C, O> of(
      C component, O option) {
    return new OptionMeta<>(component, option);
  }

  /**
   * Constructor for OptionMeta.
   *
   * @param component a C object
   * @param option a O object
   */
  public OptionMeta(C component, O option) {
    this.component = component;
    this.option = option;
  }

  /**
   * get.
   *
   * @param component a {@link org.dominokit.domino.ui.utils.HasMeta} object
   * @param <V> a V class
   * @param <C> a C class
   * @param <O> a O class
   * @return a {@link java.util.Optional} object
   */
  public static <V, C extends IsElement<?>, O extends Option<V, C, O>>
      Optional<OptionMeta<V, C, O>> get(HasMeta<?> component) {
    return component.getMeta(OPTION_META);
  }

  /**
   * Getter for the field <code>component</code>.
   *
   * @return a C object
   */
  public C getComponent() {
    return component;
  }

  /**
   * Getter for the field <code>option</code>.
   *
   * @return a O object
   */
  public O getOption() {
    return option;
  }

  /** {@inheritDoc} */
  @Override
  public String getKey() {
    return OPTION_META;
  }
}
