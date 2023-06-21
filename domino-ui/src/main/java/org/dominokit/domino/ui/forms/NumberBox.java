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
import jsinterop.base.Js;
import org.dominokit.domino.ui.elements.DivElement;
import org.dominokit.domino.ui.events.EventType;
import org.dominokit.domino.ui.forms.validations.InputAutoValidator;
import org.dominokit.domino.ui.forms.validations.ValidationResult;
import org.dominokit.domino.ui.utils.*;
import org.gwtproject.i18n.client.NumberFormat;
import org.gwtproject.i18n.shared.cldr.LocaleInfo;
import org.gwtproject.i18n.shared.cldr.NumberConstants;

/**
 * A Base implementation for form inputs that takes/provide numeric values
 *
 * @param <T> The type of the class extending from this base class
 * @param <V> The Numeric type of the component value
 * @author vegegoku
 * @version $Id: $Id
 */
public abstract class NumberBox<T extends NumberBox<T, V>, V extends Number>
    extends InputFormField<T, HTMLInputElement, V>
    implements HasMinMaxValue<T, V>, HasStep<T, V>, HasPostfix<T>, HasPrefix<T>, HasPlaceHolder<T> {

  protected final LazyChild<DivElement> prefixElement;
  protected final LazyChild<DivElement> postfixElement;
  private final ChangeListener<V> formatValueChangeListener =
      (oldValue, newValue) -> formatValue(newValue);
  private java.util.function.Function<String, V> valueParser = defaultValueParser();

  private String maxValueErrorMessage;
  private String minValueErrorMessage;
  private String invalidFormatMessage;
  private boolean formattingEnabled;
  private String pattern = null;

  /** Create an instance with a label */
  public NumberBox() {
    super();
    prefixElement = LazyChild.of(div().addCss(dui_field_prefix), wrapperElement);
    postfixElement = LazyChild.of(div().addCss(dui_field_postfix), wrapperElement);
    addValidator(this::validateInputString);
    addValidator(this::validateMaxValue);
    addValidator(this::validateMinValue);

    setAutoValidation(true);
    enableFormatting();

    getInputElement().addEventListener(EventType.keypress, this::onKeyPress);
    getInputElement().addEventListener(EventType.paste, this::onPaste);
  }

  /**
   * Create an instance with a label
   *
   * @param label String
   */
  public NumberBox(String label) {
    this();
    setLabel(label);
  }

  /** {@inheritDoc} */
  @Override
  public String getType() {
    return "tel";
  }

  /** {@inheritDoc} */
  @Override
  protected DominoElement<HTMLInputElement> createInputElement(String type) {
    return input(type).addCss(dui_field_input).toDominoElement();
  }

  private ValidationResult validateInputString(NumberBox<T, V> target) {
    try {
      tryGetValue();
    } catch (NumberFormatException e) {
      return ValidationResult.invalid(getInvalidFormatMessage());
    }
    return ValidationResult.valid();
  }

  private ValidationResult validateMaxValue(NumberBox<T, V> target) {
    V value = getValue();
    if (nonNull(value) && isExceedMaxValue(value)) {
      return ValidationResult.invalid(getMaxValueErrorMessage());
    }
    return ValidationResult.valid();
  }

  private ValidationResult validateMinValue(NumberBox<T, V> target) {
    V value = getValue();
    if (nonNull(value) && isLowerThanMinValue(value)) {
      return ValidationResult.invalid(getMinValueErrorMessage());
    }
    return ValidationResult.valid();
  }

  /**
   * hasDecimalSeparator.
   *
   * @return a boolean
   */
  protected boolean hasDecimalSeparator() {
    return false;
  }

  /**
   * createKeyMatch.
   *
   * @return a {@link java.lang.String} object
   */
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

  /**
   * onKeyPress.
   *
   * @param event a {@link elemental2.dom.Event} object
   */
  protected void onKeyPress(Event event) {
    KeyboardEvent keyboardEvent = Js.uncheckedCast(event);
    if (!keyboardEvent.key.matches(createKeyMatch())) event.preventDefault();
  }

  /**
   * onPaste.
   *
   * @param event a {@link elemental2.dom.Event} object
   */
  protected void onPaste(Event event) {
    ClipboardEvent clipboardEvent = Js.uncheckedCast(event);
    try {
      parseValue(clipboardEvent.clipboardData.getData("text"));
    } catch (NumberFormatException e) {
      event.preventDefault();
    }
  }

  private void formatValue(V value) {
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
  protected void doSetValue(V value) {
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

  private V tryGetValue() {
    String value = getStringValue();
    if (value.isEmpty()) {
      return null;
    }
    return parseValue(value);
  }

  /** {@inheritDoc} */
  @Override
  public V getValue() {
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
   * {@inheritDoc}
   *
   * <p>Sets the minimum allowed value for the field
   */
  @Override
  public T setMinValue(V minValue) {
    getInputElement().element().min = nonNull(minValue) ? getNumberFormat().format(minValue) : null;
    return (T) this;
  }

  /**
   * {@inheritDoc}
   *
   * <p>Sets the maximum allowed value for the field
   */
  @Override
  public T setMaxValue(V maxValue) {
    getInputElement().element().max = nonNull(maxValue) ? getNumberFormat().format(maxValue) : null;
    return (T) this;
  }

  /**
   * {@inheritDoc}
   *
   * <p>Sets the increment step attribute for the field
   *
   * @see <a href="https://developer.mozilla.org/en-US/docs/Web/HTML/Attributes/step">HTML
   *     attribute: step</a>
   */
  @Override
  public T setStep(V step) {
    getInputElement().element().step = nonNull(step) ? getNumberFormat().format(step) : null;
    return (T) this;
  }

  /** {@inheritDoc} */
  @Override
  public V getMaxValue() {
    String maxValue = getInputElement().element().max;
    if (isNull(maxValue) || maxValue.isEmpty()) {
      return defaultMaxValue();
    }
    return parseValue(maxValue);
  }

  /** {@inheritDoc} */
  @Override
  public V getMinValue() {
    String minValue = getInputElement().element().min;
    if (isNull(minValue) || minValue.isEmpty()) {
      return defaultMinValue();
    }
    return parseValue(minValue);
  }

  /** {@inheritDoc} */
  @Override
  public V getStep() {
    String step = getInputElement().element().step;
    if (isNull(step) || step.isEmpty()) {
      return null;
    }
    return parseValue(step);
  }

  /**
   * Setter for the field <code>maxValueErrorMessage</code>.
   *
   * @param maxValueErrorMessage String error message to display when the field value is greater
   *     than the maximum value
   * @return same field instance
   */
  public T setMaxValueErrorMessage(String maxValueErrorMessage) {
    this.maxValueErrorMessage = maxValueErrorMessage;
    return (T) this;
  }

  /**
   * Setter for the field <code>minValueErrorMessage</code>.
   *
   * @param minValueErrorMessage String error message to display when the field value is less than
   *     the minimum value
   * @return same field instance
   */
  public T setMinValueErrorMessage(String minValueErrorMessage) {
    this.minValueErrorMessage = minValueErrorMessage;
    return (T) this;
  }

  /**
   * Setter for the field <code>invalidFormatMessage</code>.
   *
   * @param invalidFormatMessage String error message to display when the field value does not match
   *     the field format
   * @return same field instance
   */
  public T setInvalidFormatMessage(String invalidFormatMessage) {
    this.invalidFormatMessage = invalidFormatMessage;
    return (T) this;
  }

  /**
   * Getter for the field <code>maxValueErrorMessage</code>.
   *
   * @return String error message to display when the field value is greater than the maximum value
   */
  public String getMaxValueErrorMessage() {
    return isNull(maxValueErrorMessage)
        ? "Maximum allowed value is [" + getMaxValue() + "]"
        : maxValueErrorMessage;
  }

  /** @return String error message to display when the field value is less than the minimum value */
  /**
   * Getter for the field <code>minValueErrorMessage</code>.
   *
   * @return a {@link java.lang.String} object
   */
  public String getMinValueErrorMessage() {
    return isNull(minValueErrorMessage)
        ? "Minimum allowed value is [" + getMinValue() + "]"
        : minValueErrorMessage;
  }

  /**
   * Getter for the field <code>invalidFormatMessage</code>.
   *
   * @return String error message to display when the field value format does not match the field
   *     format
   */
  public String getInvalidFormatMessage() {
    return isNull(invalidFormatMessage) ? "Invalid number format" : invalidFormatMessage;
  }

  private boolean isExceedMaxValue(V value) {
    V maxValue = getMaxValue();
    if (isNull(maxValue)) return false;
    return isExceedMaxValue(maxValue, value);
  }

  private boolean isLowerThanMinValue(V value) {
    V minValue = getMinValue();
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
      if (!hasChangeListener(formatValueChangeListener)) {
        addChangeListener(formatValueChangeListener);
      }
    } else {
      removeChangeListener(formatValueChangeListener);
    }
    return (T) this;
  }

  /** @return a {@link NumberFormat} instance that should be used to format this field */
  /**
   * getNumberFormat.
   *
   * @return a {@link org.gwtproject.i18n.client.NumberFormat} object
   */
  protected NumberFormat getNumberFormat() {
    if (nonNull(getPattern())) {
      return NumberFormat.getFormat(getPattern());
    } else {
      return NumberFormat.getDecimalFormat();
    }
  }

  /** @return String pattern used to format the field value */
  /**
   * Getter for the field <code>pattern</code>.
   *
   * @return a {@link java.lang.String} object
   */
  public String getPattern() {
    return pattern;
  }

  /**
   * Setter for the field <code>pattern</code>.
   *
   * @param pattern String pattern to format the field value
   * @return same field instance
   */
  public T setPattern(String pattern) {
    if (!Objects.equals(this.pattern, pattern)) {
      // It is important get the current numeric value based on old pattern
      V value = getValue();

      // Update the pattern now and format value with new pattern
      this.pattern = pattern;
      formatValue(value);
    }
    return (T) this;
  }

  /**
   * parseDouble.
   *
   * @param value a {@link java.lang.String} object
   * @return a double
   */
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

  /** {@inheritDoc} */
  @Override
  public String getPlaceholder() {
    return getInputElement().element().placeholder;
  }

  /** {@inheritDoc} */
  @Override
  public T setPlaceholder(String placeholder) {
    getInputElement().element().placeholder = placeholder;
    return (T) this;
  }

  /**
   * Reads a String value and convert it to the field number type
   *
   * @param value String numeric value
   * @return E the Numeric value from the input String
   */
  protected V parseValue(String value) {
    return valueParser.apply(value);
  }

  /**
   * defaultValueParser.
   *
   * @return a {@link java.util.function.Function} object
   */
  protected abstract java.util.function.Function<String, V> defaultValueParser();

  /** @return E numeric max value as a default in case {@link #setMaxValue(Number)} is not called */
  /**
   * defaultMaxValue.
   *
   * @return a V object
   */
  protected abstract V defaultMaxValue();

  /** @return E numeric min value as a default in case {@link #setMinValue(Number)} is not called */
  /**
   * defaultMinValue.
   *
   * @return a V object
   */
  protected abstract V defaultMinValue();

  /**
   * Setter for the field <code>valueParser</code>.
   *
   * @param valueParser a {@link java.util.function.Function} object
   * @return a T object
   */
  public T setValueParser(java.util.function.Function<String, V> valueParser) {
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
  protected abstract boolean isExceedMaxValue(V maxValue, V value);

  /**
   * Checks if a a given value is actually less than the minimum allowed value
   *
   * @param minValue E numeric value
   * @param value E numeric value
   * @return boolean, true if the value is less than minValue
   */
  protected abstract boolean isLowerThanMinValue(V minValue, V value);

  /** {@inheritDoc} */
  @Override
  public AutoValidator createAutoValidator(ApplyFunction autoValidate) {
    return new InputAutoValidator(autoValidate, getInputElement());
  }

  /** {@inheritDoc} */
  @Override
  public T setPostfix(String postfix) {
    postfixElement.get().setTextContent(postfix);
    return (T) this;
  }

  /** {@inheritDoc} */
  @Override
  public String getPostfix() {
    if (postfixElement.isInitialized()) {
      return postfixElement.get().getTextContent();
    }
    return "";
  }

  /** {@inheritDoc} */
  @Override
  public T setPrefix(String prefix) {
    prefixElement.get().setTextContent(prefix);
    return (T) this;
  }

  /** {@inheritDoc} */
  @Override
  public String getPrefix() {
    if (prefixElement.isInitialized()) {
      return prefixElement.get().getTextContent();
    }
    return "";
  }

  /**
   * Getter for the field <code>prefixElement</code>.
   *
   * @return a {@link org.dominokit.domino.ui.elements.DivElement} object
   */
  public DivElement getPrefixElement() {
    return prefixElement.get();
  }

  /**
   * Getter for the field <code>postfixElement</code>.
   *
   * @return a {@link org.dominokit.domino.ui.elements.DivElement} object
   */
  public DivElement getPostfixElement() {
    return postfixElement.get();
  }

  /**
   * withPrefixElement.
   *
   * @return a T object
   */
  public T withPrefixElement() {
    prefixElement.get();
    return (T) this;
  }

  /**
   * withPrefixElement.
   *
   * @param handler a {@link org.dominokit.domino.ui.utils.ChildHandler} object
   * @return a T object
   */
  public T withPrefixElement(ChildHandler<T, DivElement> handler) {
    handler.apply((T) this, prefixElement.get());
    return (T) this;
  }

  /**
   * withPostfixElement.
   *
   * @return a T object
   */
  public T withPostfixElement() {
    postfixElement.get();
    return (T) this;
  }

  /**
   * withPostfixElement.
   *
   * @param handler a {@link org.dominokit.domino.ui.utils.ChildHandler} object
   * @return a T object
   */
  public T withPostfixElement(ChildHandler<T, DivElement> handler) {
    handler.apply((T) this, postfixElement.get());
    return (T) this;
  }

  /** {@inheritDoc} */
  @Override
  public String getName() {
    return getInputElement().element().name;
  }

  /** {@inheritDoc} */
  @Override
  public T setName(String name) {
    getInputElement().element().name = name;
    return (T) this;
  }
}
