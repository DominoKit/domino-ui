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

public class OptionMeta<V, C extends IsElement<?>, O extends Option<V, C, O>>
    implements ComponentMeta {

  public static final String OPTION_META = "dui-suggest-option-meta";
  private final C component;
  private final O option;

  public static <V, C extends IsElement<?>, O extends Option<V, C, O>> OptionMeta<V, C, O> of(
      C component, O option) {
    return new OptionMeta<>(component, option);
  }

  public OptionMeta(C component, O option) {
    this.component = component;
    this.option = option;
  }

  public static <V, C extends IsElement<?>, O extends Option<V, C, O>>
      Optional<OptionMeta<V, C, O>> get(HasMeta<?> component) {
    return component.getMeta(OPTION_META);
  }

  public C getComponent() {
    return component;
  }

  public O getOption() {
    return option;
  }

  @Override
  public String getKey() {
    return OPTION_META;
  }
}
