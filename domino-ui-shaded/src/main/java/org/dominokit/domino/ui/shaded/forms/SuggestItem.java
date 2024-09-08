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

import org.dominokit.domino.ui.shaded.dropdown.DropdownAction;
import org.dominokit.domino.ui.shaded.icons.BaseIcon;
import org.dominokit.domino.ui.shaded.icons.Icons;
import org.dominokit.domino.ui.shaded.style.Color;

/**
 * A component that represent a suggestion in the {@link SuggestBox}
 *
 * @param <T> the type of the SuggestItem value
 */
@Deprecated
public class SuggestItem<T> {

  private DropdownAction<T> element;
  private T value;
  private final String displayValue;

  /**
   * @param value T
   * @param displayValue String
   */
  public SuggestItem(T value, String displayValue) {
    this(value, displayValue, Icons.ALL.text_fields());
  }

  /**
   * @param value T
   * @param displayValue String
   * @param icon {@link org.dominokit.domino.ui.icons.Icon}
   */
  public SuggestItem(T value, String displayValue, BaseIcon<?> icon) {
    element = DropdownAction.create(value, displayValue, icon);
    this.value = value;
    this.displayValue = displayValue;
  }

  /**
   * Creates a SuggestItem with a String value, the same String will be used for displayValue
   *
   * @param value String
   * @return new SuggestItem instance
   */
  public static SuggestItem<String> create(String value) {
    return new SuggestItem<>(value, value);
  }

  /**
   * @param value T
   * @param displayValue String
   * @param <T> the type of the SuggestItem value
   * @return new SuggestItem instance
   */
  public static <T> SuggestItem<T> create(T value, String displayValue) {
    return new SuggestItem<>(value, displayValue);
  }

  /**
   * @param value T
   * @param displayValue String
   * @param icon {@link org.dominokit.domino.ui.icons.Icon}
   * @param <T> the type of the SuggestItem value
   * @return new SuggestItem instance
   */
  public static <T> SuggestItem<T> create(T value, String displayValue, BaseIcon<?> icon) {
    return new SuggestItem<>(value, displayValue, icon);
  }

  /**
   * highlight part of the SuggestItem display string that matches the specified value with the
   * specified color
   *
   * @param value String
   * @param highlightColor {@link Color}
   */
  public void highlight(String value, Color highlightColor) {
    element.highlight(value, highlightColor);
  }

  /** @return the SuggestItem as {@link DropdownAction} */
  public DropdownAction<T> asDropDownAction() {
    return element;
  }

  /** @return the T value of this SuggestItem */
  public T getValue() {
    return element.getValue();
  }

  /** @return String */
  public String getDisplayValue() {
    return displayValue;
  }
}
