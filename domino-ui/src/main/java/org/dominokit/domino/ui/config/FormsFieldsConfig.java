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
package org.dominokit.domino.ui.config;

import static org.dominokit.domino.ui.utils.Domino.*;
import static org.dominokit.domino.ui.utils.ElementsFactory.elements;

import elemental2.dom.HTMLElement;
import java.math.BigDecimal;
import java.util.function.Function;
import java.util.function.Supplier;
import org.dominokit.domino.ui.forms.BigDecimalBox;
import org.dominokit.domino.ui.forms.DoubleBox;
import org.dominokit.domino.ui.forms.FloatBox;
import org.dominokit.domino.ui.forms.IntegerBox;
import org.dominokit.domino.ui.forms.LongBox;
import org.dominokit.domino.ui.forms.ShortBox;
import org.dominokit.domino.ui.icons.Icon;
import org.dominokit.domino.ui.icons.lib.Icons;

/**
 * Implementations of this interface can be used to configure defaults for form fields components
 */
public interface FormsFieldsConfig extends ComponentConfig, CalendarConfig {

  /**
   * Use this method to define the default element to be used as a required indicator in form
   * fields.
   *
   * <p>Defaults to : <b>*</b>
   *
   * @return a {@code Supplier<HTMLElement>}, the supplier should return a new Node instance
   *     everytime it is called.
   */
  default Supplier<HTMLElement> getRequiredIndicator() {
    return () -> elements.span().textContent("*").element();
  }

  /**
   * Use this method to define the default behavior for fixing the error messages space below the
   * field, so it is always reserved, or it should only be available when there is errors.
   *
   * <p>Defaults to : <b>false</b>
   *
   * @return a boolean, <b>true</b> Errors element will take a fixed space even if no errors
   *     reported, <b>false</b> Errors element will only take space when the field has errors.
   */
  default boolean isFixErrorsPosition() {
    return false;
  }

  /**
   * Use this method to define the default behavior for form field to focus on next field on enter
   * key press or not.
   *
   * <p>Defaults to : <b>false</b>
   *
   * @return a boolean, <b>true</b> Press enter on a field will move the focus to the next field,
   *     <b>false</b> Press enter on a field will not move the focus to the next field.
   */
  default boolean isFocusNextFieldOnEnter() {
    return false;
  }

  /**
   * Use this method to enable/disable spellcheck for input fields by default.
   *
   * <p>Defaults to : <b>false</b>
   *
   * @return a boolean, <b>true</b> Enables spellcheck for input fields by default, <b>false</b>
   *     Disables spellcheck for input fields by default.
   */
  default boolean isSpellCheckEnabled() {
    return false;
  }

  /**
   * Use this method to configure fixed the label space even if the field does not have a label.
   *
   * <p>Defaults to : <b>true</b>
   *
   * @return a boolean, <b>true</b> The space for the field label will be preserved even if the
   *     field does not have a label, <b>false</b> The space for the field label will not be
   *     preserved when the field does not have a label.
   */
  default boolean isFixedLabelSpace() {
    return true;
  }

  /**
   * Use this method to define the default implementation for {@link NumberParsers} for number
   * fields.
   *
   * <p>Defaults to : {@link NumberParsers}
   *
   * @return A NumberParsers implementation.
   */
  default NumberParsers getNumberParsers() {
    return new NumberParsers() {};
  }

  /**
   * Use this method to configure if pressing tab while select field is focused will move the focus
   * to the select arrow addon or not.
   *
   * <p>Defaults to : <b>false</b>
   *
   * @return a boolean, <b>true</b> to enable focus on select arrow by pressing tab, <b>false</b>
   *     disable focus on select arrow when pressing tab.
   */
  default boolean isTabFocusSelectArrowEnabled() {
    return false;
  }

  /**
   * Use this method to change the default icon for clearable form fields.
   *
   * @return Icon for clearable fields clear value action.
   */
  default Icon<?> clearableInputDefaultIcon() {
    return Icons.delete();
  }

  /**
   * Use this method to define the default position of the field label, top or left
   *
   * <p>Defaults to : <b>false</b>
   *
   * @return A boolean, <b>true</b> to position the label on the left side of the field,
   *     <b>false</b> position the label on the top of the field.
   */
  default boolean isFormFieldFloatLabelLeft() {
    return false;
  }

  interface NumberParsers {
    default Function<String, BigDecimal> bigDecimalParser(BigDecimalBox field) {
      return value -> BigDecimal.valueOf(field.parseDouble(value));
    }

    default Function<String, Double> doubleParser(DoubleBox field) {
      return field::parseDouble;
    }

    default Function<String, Integer> integerParser(IntegerBox field) {
      return value -> Double.valueOf(field.parseDouble(value)).intValue();
    }

    default Function<String, Float> floatParser(FloatBox field) {
      return value -> Double.valueOf(field.parseDouble(value)).floatValue();
    }

    default Function<String, Long> longParser(LongBox field) {
      return value -> Double.valueOf(field.parseDouble(value)).longValue();
    }

    default Function<String, Short> shortParser(ShortBox field) {
      return value -> Double.valueOf(field.parseDouble(value)).shortValue();
    }
  }
}
