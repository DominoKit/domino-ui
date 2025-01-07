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
package org.dominokit.domino.ui.forms;

import static java.util.Objects.isNull;
import static java.util.Objects.nonNull;

import elemental2.dom.*;
import java.util.Objects;
import java.util.function.Function;
import jsinterop.base.Js;
import org.dominokit.domino.ui.forms.validations.InputAutoValidator;
import org.dominokit.domino.ui.forms.validations.ValidationResult;
import org.gwtproject.i18n.client.NumberFormat;
import org.gwtproject.i18n.shared.cldr.LocaleInfo;
import org.gwtproject.i18n.shared.cldr.NumberConstants;
import org.jboss.elemento.Elements;
import org.jboss.elemento.EventType;

/**
 * A Base implementation for form inputs that takes/provide numeric values
 *
 * @param <T> The type of the class extending from this base class
 * @param <E> The Numeric type of the component value
 */
public abstract class NumberBox<T extends NumberBox<T, E>, E extends Number>
    extends AbstractValueBox<T, HTMLInputElement, E> {

  private final ChangeHandler<E> formatValueChangeHandler = value -> formatValue();
  private Function<String, E> valueParser = defaultValueParser();

  private String maxValueErrorMessage;
  private String minValueErrorMessage;
  private String invalidFormatMessage;
  private boolean formattingEnabled;
  private String pattern = null;

  /**
   * Create an instance with a label
   *
   * @param label String
   */
  public NumberBox(String label) {
    super("tel", label);
    addValidator(this::validateInputString);
    addValidator(this::validateMaxValue);
    addValidator(this::validateMinValue);

    setAutoValidation(true);
    enableFormatting();

    getInputElement().addEventListener(EventType.keydown, this::onKeyDown);
    getInputElement().addEventListener(EventType.paste, this::onPaste);
  }

  private ValidationResult validateInputString() {
    try {
      tryGetValue();
    } catch (NumberFormatException e) {
      return ValidationResult.invalid(getInvalidFormatMessage());
    }
    return ValidationResult.valid();
  }

  private ValidationResult validateMaxValue() {
    E value = getValue();
    if (nonNull(value) && isExceedMaxValue(value)) {
      return ValidationResult.invalid(getMaxValueErrorMessage());
    }
    return ValidationResult.valid();
  }

  private ValidationResult validateMinValue() {
    E value = getValue();
    if (nonNull(value) && isLowerThanMinValue(value)) {
      return ValidationResult.invalid(getMinValueErrorMessage());
    }
    return ValidationResult.valid();
  }

  protected boolean hasDecimalSeparator() {
    return false;
  }

  protected String createKeyMatch() {
    StringBuilder sB = new StringBuilder();

    sB.append("[0-9");

    NumberConstants numberConstants = LocaleInfo.getCurrentLocale().getNumberConstants();
    sB.append(numberConstants.minusSign());

    if (hasDecimalSeparator()) sB.append(numberConstants.decimalSeparator());

    // If pattern is defined, except predefined digits, decimal separator and minus sign, append all
    // other characters
    if (pattern != null) sB.append(pattern.replaceAll("[0#.-]", ""));

    sB.append(']');

    return sB.toString();
  }

  protected void onKeyDown(Event event) {
    KeyboardEvent keyboardEvent = Js.uncheckedCast(event);
    if (keyboardEvent.key.length() == 1 && !keyboardEvent.key.matches(createKeyMatch())) {
      event.preventDefault();
    }
  }

  protected void onPaste(Event event) {
    ClipboardEvent clipboardEvent = Js.uncheckedCast(event);
    try {
      parseValue(clipboardEvent.clipboardData.getData("text"));
    } catch (NumberFormatException e) {
      event.preventDefault();
    }
  }

  private void formatValue(E value) {
    getInputElement().element().value = nonNull(value) ? getNumberFormat().format(value) : "";
  }

  private void formatValue() {
    try {
      formatValue(tryGetValue());
    } catch (NumberFormatException e) {
      // nothing to format, so we do nothing!
    }
  }

  /** {@inheritDoc} */
  @Override
  protected HTMLInputElement createInputElement(String type) {
    return Elements.input(type).element();
  }

  /** {@inheritDoc} */
  @Override
  protected void doSetValue(E value) {
    if (nonNull(value)) {
      if (this.formattingEnabled) {
        getInputElement().element().value = getNumberFormat().format(value);
      } else {
        getInputElement().element().value = String.valueOf(value);
      }
    } else {
      getInputElement().element().value = "";
    }
  }

  private E tryGetValue() {
    String value = getStringValue();
    if (value.isEmpty()) {
      return null;
    }
    return parseValue(value);
  }

  /** {@inheritDoc} */
  @Override
  public E getValue() {
    try {
      return tryGetValue();
    } catch (NumberFormatException e) {
      invalidate(
          getStringValue().startsWith("-") ? getMinValueErrorMessage() : getMaxValueErrorMessage());
      return null;
    }
  }

  /** {@inheritDoc} */
  @Override
  public boolean isEmpty() {
    String value = getInputElement().element().value;
    return value.isEmpty();
  }

  /** {@inheritDoc} */
  @Override
  public boolean isEmptyIgnoreSpaces() {
    String value = getInputElement().element().value;
    return isEmpty() || value.trim().isEmpty();
  }

  /** {@inheritDoc} */
  @Override
  public String getStringValue() {
    return getInputElement().element().value;
  }

  /**
   * Sets the minimum allowed value for the field
   *
   * @param minValue E minimum value
   * @return same component instance
   */
  public T setMinValue(E minValue) {
    getInputElement().element().min = nonNull(minValue) ? getNumberFormat().format(minValue) : null;
    return (T) this;
  }

  /**
   * Sets the maximum allowed value for the field
   *
   * @param maxValue E maximum value
   * @return same component instance
   */
  public T setMaxValue(E maxValue) {
    getInputElement().element().max = nonNull(maxValue) ? getNumberFormat().format(maxValue) : null;
    return (T) this;
  }

  /**
   * Sets the increment step attribute for the field
   *
   * @see <a href="https://developer.mozilla.org/en-US/docs/Web/HTML/Attributes/step">HTML
   *     attribute: step</a>
   * @param step E numeric value
   * @return same field instance
   */
  public T setStep(E step) {
    getInputElement().element().step = nonNull(step) ? getNumberFormat().format(step) : null;
    return (T) this;
  }

  /**
   * @returnthe maximum allowed value for the field if exists or else return {@link
   *     #defaultMaxValue()}
   */
  public E getMaxValue() {
    String maxValue = getInputElement().element().max;
    if (isNull(maxValue) || maxValue.isEmpty()) {
      return defaultMaxValue();
    }
    return parseValue(maxValue);
  }

  /**
   * @returnthe minimum allowed value for the field if exists or else return {@link
   *     #defaultMinValue()}
   */
  public E getMinValue() {
    String minValue = getInputElement().element().min;
    if (isNull(minValue) || minValue.isEmpty()) {
      return defaultMinValue();
    }
    return parseValue(minValue);
  }

  /**
   * @return the step value for the field if exists or else return null
   * @see #setStep(Number)
   */
  public E getStep() {
    String step = getInputElement().element().step;
    if (isNull(step) || step.isEmpty()) {
      return null;
    }
    return parseValue(step);
  }

  /**
   * @param maxValueErrorMessage String error message to display when the field value is greater
   *     than the maximum value
   * @return same field instance
   */
  public T setMaxValueErrorMessage(String maxValueErrorMessage) {
    this.maxValueErrorMessage = maxValueErrorMessage;
    return (T) this;
  }

  /**
   * @param minValueErrorMessage String error message to display when the field value is less than
   *     the minimum value
   * @return same field instance
   */
  public T setMinValueErrorMessage(String minValueErrorMessage) {
    this.minValueErrorMessage = minValueErrorMessage;
    return (T) this;
  }

  /**
   * @param invalidFormatMessage String error message to display when the field value does not match
   *     the field format
   * @return same field instance
   */
  public T setInvalidFormatMessage(String invalidFormatMessage) {
    this.invalidFormatMessage = invalidFormatMessage;
    return (T) this;
  }

  /**
   * @return String error message to display when the field value is greater than the maximum value
   */
  public String getMaxValueErrorMessage() {
    return isNull(maxValueErrorMessage)
        ? "Maximum allowed value is [" + getMaxValue() + "]"
        : maxValueErrorMessage;
  }

  /** @return String error message to display when the field value is less than the minimum value */
  public String getMinValueErrorMessage() {
    return isNull(minValueErrorMessage)
        ? "Minimum allowed value is [" + getMinValue() + "]"
        : minValueErrorMessage;
  }

  /**
   * @return String error message to display when the field value format does not match the field
   *     format
   */
  public String getInvalidFormatMessage() {
    return isNull(invalidFormatMessage) ? "Invalid number format" : invalidFormatMessage;
  }

  private boolean isExceedMaxValue(E value) {
    E maxValue = getMaxValue();
    if (isNull(maxValue)) return false;
    return isExceedMaxValue(maxValue, value);
  }

  private boolean isLowerThanMinValue(E value) {
    E minValue = getMinValue();
    if (isNull(minValue)) return false;
    return isLowerThanMinValue(minValue, value);
  }

  /**
   * Enables auto formatting the field value to match the pattern specified by {@link
   * #setPattern(String)}
   *
   * @return same field instance
   */
  public T enableFormatting() {
    return setFormattingEnabled(true);
  }

  /**
   * Disable auto formatting the field value to match the pattern specified by {@link
   * #setPattern(String)}
   *
   * @return same field instance
   */
  public T disableFormatting() {
    return setFormattingEnabled(false);
  }

  private T setFormattingEnabled(boolean formattingEnabled) {
    this.formattingEnabled = formattingEnabled;
    if (formattingEnabled) {
      if (!hasChangeHandler(formatValueChangeHandler)) {
        addChangeHandler(formatValueChangeHandler);
      }
    } else {
      removeChangeHandler(formatValueChangeHandler);
    }
    return (T) this;
  }

  /** @return a {@link NumberFormat} instance that should be used to format this field */
  protected NumberFormat getNumberFormat() {
    if (nonNull(getPattern())) {
      return NumberFormat.getFormat(getPattern());
    } else {
      return NumberFormat.getDecimalFormat();
    }
  }

  /** @return String pattern used to format the field value */
  public String getPattern() {
    return pattern;
  }

  /**
   * @param pattern String pattern to format the field value
   * @return same field instance
   */
  public T setPattern(String pattern) {
    if (!Objects.equals(this.pattern, pattern)) {
      // It is important get the current numeric value based on old pattern
      E value = getValue();

      // Update the pattern now and format value with new pattern
      this.pattern = pattern;
      formatValue(value);
    }
    return (T) this;
  }

  public double parseDouble(String value) {
    try {
      return getNumberFormat().parse(value);
    } catch (NumberFormatException e) {
      if (nonNull(getPattern())) {
        return NumberFormat.getDecimalFormat().parse(value);
      }
      throw e;
    }
  }

  /**
   * Reads a String value and convert it to the field number type
   *
   * @param value String numeric value
   * @return E the Numeric value from the input String
   */
  protected E parseValue(String value) {
    return valueParser.apply(value);
  }

  protected abstract Function<String, E> defaultValueParser();

  /** @return E numeric max value as a default in case {@link #setMaxValue(Number)} is not called */
  protected abstract E defaultMaxValue();

  /** @return E numeric min value as a default in case {@link #setMinValue(Number)} is not called */
  protected abstract E defaultMinValue();

  public T setValueParser(Function<String, E> valueParser) {
    if (nonNull(valueParser)) {
      this.valueParser = valueParser;
    }
    return (T) this;
  }

  /**
   * Checks if a a given value is actually greater than the maximum allowed value
   *
   * @param maxValue E numeric value
   * @param value E numeric value
   * @return boolean, true if the value is greater than maxValue
   */
  protected abstract boolean isExceedMaxValue(E maxValue, E value);

  /**
   * Checks if a a given value is actually less than the minimum allowed value
   *
   * @param minValue E numeric value
   * @param value E numeric value
   * @return boolean, true if the value is less than minValue
   */
  protected abstract boolean isLowerThanMinValue(E minValue, E value);

  /** {@inheritDoc} */
  @Override
  protected AutoValidator createAutoValidator(AutoValidate autoValidate) {
    return new InputAutoValidator<>(autoValidate);
  }
}
