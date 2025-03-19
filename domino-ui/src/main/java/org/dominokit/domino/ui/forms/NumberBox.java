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
import static org.dominokit.domino.ui.utils.Domino.div;
import static org.dominokit.domino.ui.utils.Domino.input;

import elemental2.dom.ClipboardEvent;
import elemental2.dom.Event;
import elemental2.dom.HTMLInputElement;
import elemental2.dom.KeyboardEvent;
import java.util.Objects;
import java.util.function.Function;
import jsinterop.base.Js;
import org.dominokit.domino.ui.elements.DivElement;
import org.dominokit.domino.ui.events.EventType;
import org.dominokit.domino.ui.forms.validations.InputAutoValidator;
import org.dominokit.domino.ui.forms.validations.ValidationResult;
import org.dominokit.domino.ui.utils.ApplyFunction;
import org.dominokit.domino.ui.utils.DominoElement;
import org.dominokit.domino.ui.utils.HasMinMaxValue;
import org.dominokit.domino.ui.utils.HasPlaceHolder;
import org.dominokit.domino.ui.utils.HasPostfix;
import org.dominokit.domino.ui.utils.HasPrefix;
import org.dominokit.domino.ui.utils.HasStep;
import org.dominokit.domino.ui.utils.LazyChild;
import org.dominokit.domino.ui.utils.PostfixElement;
import org.dominokit.domino.ui.utils.PrefixElement;
import org.gwtproject.i18n.client.NumberFormat;
import org.gwtproject.i18n.shared.cldr.LocaleInfo;
import org.gwtproject.i18n.shared.cldr.NumberConstants;

/**
 * An abstract representation of a number input field with various customizations such as min/max
 * values, prefix/postfix elements, and input validation.
 *
 * <p>Usage example:
 *
 * <pre>
 * NumberBox<Double, Double> ageBox = new NumberBox<>("Age");
 * ageBox.setMinValue(0.0);
 * ageBox.setMaxValue(150.0);
 * </pre>
 *
 * @param <T> Concrete type of the NumberBox
 * @param <V> Value type (Number subclass) that this NumberBox supports
 */
public abstract class NumberBox<T extends NumberBox<T, V>, V extends Number>
    extends InputFormField<T, HTMLInputElement, V>
    implements HasMinMaxValue<T, V>, HasStep<T, V>, HasPostfix<T>, HasPrefix<T>, HasPlaceHolder<T> {

  protected final LazyChild<DivElement> prefixElement;
  protected final LazyChild<DivElement> postfixElement;
  private final ChangeListener<V> formatValueChangeListener =
      (oldValue, newValue) -> formatValue(newValue);
  private Function<String, V> valueParser = defaultValueParser();
  private final NumberFormatSupplier defaultFormatSupplier =
      formatPattern -> {
        if (nonNull(getPattern())) {
          return NumberFormat.getFormat(getPattern());
        } else {
          return NumberFormat.getDecimalFormat();
        }
      };
  private NumberFormatSupplier numberFormatSupplier = defaultFormatSupplier;

  private String maxValueErrorMessage;
  private String minValueErrorMessage;
  private String invalidFormatMessage;
  private boolean formattingEnabled;
  private String pattern = null;

  /** Initializes the number box with default configurations. */
  public NumberBox() {
    super();
    prefixElement = LazyChild.of(div().addCss(dui_field_prefix), wrapperElement);
    postfixElement = LazyChild.of(div().addCss(dui_field_postfix), wrapperElement);
    addValidator(this::validateInputString);
    addValidator(this::validateMaxValue);
    addValidator(this::validateMinValue);

    setAutoValidation(true);
    enableFormatting();

    getInputElement().addEventListener(EventType.keydown, this::onKeyDown);
    getInputElement().addEventListener(EventType.paste, this::onPaste);
  }

  /**
   * Initializes the number box with a given label.
   *
   * @param label The label for the number box.
   */
  public NumberBox(String label) {
    this();
    setLabel(label);
  }

  /**
   * Returns the type of the input field. In this case, a telephone input type is returned.
   *
   * @return String representation of the input type.
   */
  @Override
  public String getType() {
    return "tel";
  }

  /**
   * {@inheritDoc}
   *
   * <p>Creates the HTML input element for the number box.
   *
   * @param type Type of the input element.
   * @return A domino element wrapping the created input element.
   */
  @Override
  protected DominoElement<HTMLInputElement> createInputElement(String type) {
    return input(type).addCss(dui_field_input).toDominoElement();
  }

  /**
   * Validates the provided input against standard number formatting.
   *
   * @param target The number box being validated.
   * @return A ValidationResult indicating the success or failure of the validation.
   */
  private ValidationResult validateInputString(NumberBox<T, V> target) {
    try {
      tryGetValue();
    } catch (NumberFormatException e) {
      return ValidationResult.invalid(getInvalidFormatMessage());
    }
    return ValidationResult.valid();
  }

  /**
   * Validates that the number box value does not exceed the defined maximum value.
   *
   * @param target The number box being validated.
   * @return A ValidationResult indicating the success or failure of the validation.
   */
  private ValidationResult validateMaxValue(NumberBox<T, V> target) {
    V value = getValue();
    if (nonNull(value) && isExceedMaxValue(value)) {
      return ValidationResult.invalid(getMaxValueErrorMessage());
    }
    return ValidationResult.valid();
  }

  /**
   * Validates that the number box value is not less than the defined minimum value.
   *
   * @param target The number box being validated.
   * @return A ValidationResult indicating the success or failure of the validation.
   */
  private ValidationResult validateMinValue(NumberBox<T, V> target) {
    V value = getValue();
    if (nonNull(value) && isLowerThanMinValue(value)) {
      return ValidationResult.invalid(getMinValueErrorMessage());
    }
    return ValidationResult.valid();
  }

  /**
   * Determines whether the number box input has a decimal separator.
   *
   * @return True if a decimal separator is present; otherwise, false.
   */
  protected boolean hasDecimalSeparator() {
    return false;
  }

  /**
   * Constructs a regular expression pattern string to match allowed characters for the number box
   * based on the locale and the custom pattern (if defined). The pattern will include numbers,
   * minus sign, decimal separator, and any additional characters from the custom pattern.
   *
   * @return A string representing the regex pattern.
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
   * Handles the "keypress" event for the number box. Only allows key presses that match the pattern
   * created by the {@link #createKeyMatch()} method.
   *
   * @param event The keyboard event associated with the key press.
   */
  protected void onKeyDown(Event event) {
    KeyboardEvent keyboardEvent = Js.uncheckedCast(event);
    if (keyboardEvent.key.length() == 1 && !keyboardEvent.key.matches(createKeyMatch())) {
      event.preventDefault();
    }
  }

  /**
   * Handles the "paste" event for the number box. It ensures that pasted value is of a valid
   * format. If the pasted value is not a valid number, the event is prevented.
   *
   * @param event The clipboard event associated with the paste action.
   */
  protected void onPaste(Event event) {
    ClipboardEvent clipboardEvent = Js.uncheckedCast(event);
    try {
      parseValue(clipboardEvent.clipboardData.getData("text"));
    } catch (NumberFormatException e) {
      event.preventDefault();
    }
  }

  /**
   * Formats the provided value into a string representation and sets it as the value of the input
   * element. If the provided value is null, the input element's value is set to an empty string.
   *
   * @param value The value to be formatted and set in the input element.
   */
  private void formatValue(V value) {
    getInputElement().element().value = nonNull(value) ? getNumberFormat().format(value) : "";
  }

  /**
   * Attempts to retrieve and format the current value of the input element. If the current value is
   * not a valid number format, no action is taken.
   */
  private void formatValue() {
    try {
      formatValue(tryGetValue());
    } catch (NumberFormatException e) {
      // nothing to format, so we do nothing!
    }
  }

  /**
   * Overrides the parent class method to set the value for this number box. Depending on whether
   * formatting is enabled or not, it either formats the number or simply converts it to a string.
   *
   * @param value The numeric value to be set in this box.
   */
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

  /**
   * Attempts to retrieve the current value of the input element and parse it into a numeric value.
   * Returns null if the input element's value is empty.
   *
   * @return The parsed numeric value or null if the input value is empty.
   */
  private V tryGetValue() {
    String value = getStringValue();
    if (value.isEmpty()) {
      return null;
    }
    return parseValue(value);
  }

  /**
   * Retrieves the current value of this number box. If the value cannot be parsed into a valid
   * number format, the field is invalidated with an appropriate error message.
   *
   * @return The current numeric value or null if the value is not a valid number.
   */
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

  /**
   * Determines if the current value of the input element is empty.
   *
   * @return true if the value is empty, false otherwise.
   */
  @Override
  public boolean isEmpty() {
    String value = getInputElement().element().value;
    return value.isEmpty();
  }

  /**
   * Determines if the current value of the input element is empty or just contains white spaces.
   *
   * @return true if the value is empty or contains only white spaces, false otherwise.
   */
  @Override
  public boolean isEmptyIgnoreSpaces() {
    String value = getInputElement().element().value;
    return isEmpty() || value.trim().isEmpty();
  }

  /**
   * Retrieves the current value of this number box as a string.
   *
   * @return The current string value of the input element.
   */
  @Override
  public String getStringValue() {
    return getInputElement().element().value;
  }

  /**
   * Sets the minimum allowed value for this number box. The provided value will be formatted and
   * set as the min attribute of the input element.
   *
   * @param minValue The numeric value to set as the minimum allowable value.
   * @return This instance, to facilitate method chaining.
   */
  @Override
  public T setMinValue(V minValue) {
    getInputElement().element().min = nonNull(minValue) ? getNumberFormat().format(minValue) : null;
    return (T) this;
  }

  /**
   * Sets the maximum allowed value for this number box. The provided value will be formatted and
   * set as the max attribute of the input element.
   *
   * @param maxValue The numeric value to set as the maximum allowable value.
   * @return This instance, to facilitate method chaining.
   */
  @Override
  public T setMaxValue(V maxValue) {
    getInputElement().element().max = nonNull(maxValue) ? getNumberFormat().format(maxValue) : null;
    return (T) this;
  }

  /**
   * Sets the step value, which determines the legal number intervals, for this number box. The
   * provided value will be formatted and set as the step attribute of the input element.
   *
   * @param step The numeric value to set as the step value.
   * @return This instance, to facilitate method chaining.
   */
  @Override
  public T setStep(V step) {
    getInputElement().element().step = nonNull(step) ? getNumberFormat().format(step) : null;
    return (T) this;
  }

  /**
   * Retrieves the maximum value allowed for this number box.
   *
   * @return The current maximum numeric value, or the default maximum value if not set.
   */
  @Override
  public V getMaxValue() {
    String maxValue = getInputElement().element().max;
    if (isNull(maxValue) || maxValue.isEmpty()) {
      return defaultMaxValue();
    }
    return parseValue(maxValue);
  }

  /**
   * Retrieves the minimum value allowed for this number box.
   *
   * @return The current minimum numeric value, or the default minimum value if not set.
   */
  @Override
  public V getMinValue() {
    String minValue = getInputElement().element().min;
    if (isNull(minValue) || minValue.isEmpty()) {
      return defaultMinValue();
    }
    return parseValue(minValue);
  }

  /**
   * Retrieves the current step value of this number box, which determines the legal number
   * intervals.
   *
   * @return The current step numeric value or null if not set.
   */
  @Override
  public V getStep() {
    String step = getInputElement().element().step;
    if (isNull(step) || step.isEmpty()) {
      return null;
    }
    return parseValue(step);
  }

  /**
   * Sets a custom error message to be displayed when the entered number exceeds the maximum allowed
   * value.
   *
   * @param maxValueErrorMessage The custom error message.
   * @return This instance, to facilitate method chaining.
   */
  public T setMaxValueErrorMessage(String maxValueErrorMessage) {
    this.maxValueErrorMessage = maxValueErrorMessage;
    return (T) this;
  }

  /**
   * Sets a custom error message to be displayed when the entered number is below the minimum
   * allowed value.
   *
   * @param minValueErrorMessage The custom error message.
   * @return This instance, to facilitate method chaining.
   */
  public T setMinValueErrorMessage(String minValueErrorMessage) {
    this.minValueErrorMessage = minValueErrorMessage;
    return (T) this;
  }

  /**
   * Sets a custom error message to be displayed when the entered number format is invalid.
   *
   * @param invalidFormatMessage The custom error message.
   * @return This instance, to facilitate method chaining.
   */
  public T setInvalidFormatMessage(String invalidFormatMessage) {
    this.invalidFormatMessage = invalidFormatMessage;
    return (T) this;
  }

  /**
   * Retrieves the custom error message set for exceeding the maximum value or provides a default
   * message.
   *
   * @return The custom or default error message.
   */
  public String getMaxValueErrorMessage() {
    return isNull(maxValueErrorMessage)
        ? "Maximum allowed value is [" + getMaxValue() + "]"
        : maxValueErrorMessage;
  }

  /**
   * Retrieves the custom error message set for being below the minimum value or provides a default
   * message.
   *
   * @return The custom or default error message.
   */
  public String getMinValueErrorMessage() {
    return isNull(minValueErrorMessage)
        ? "Minimum allowed value is [" + getMinValue() + "]"
        : minValueErrorMessage;
  }

  /**
   * Retrieves the custom error message set for invalid number format or provides a default message.
   *
   * @return The custom or default error message.
   */
  public String getInvalidFormatMessage() {
    return isNull(invalidFormatMessage) ? "Invalid number format" : invalidFormatMessage;
  }

  /**
   * Checks if the provided value exceeds the maximum allowed value.
   *
   * @param value The number to check.
   * @return True if the number exceeds the maximum, otherwise false.
   */
  private boolean isExceedMaxValue(V value) {
    V maxValue = getMaxValue();
    if (isNull(maxValue)) return false;
    return isExceedMaxValue(maxValue, value);
  }

  /**
   * Checks if the provided value is below the minimum allowed value.
   *
   * @param value The number to check.
   * @return True if the number is below the minimum, otherwise false.
   */
  private boolean isLowerThanMinValue(V value) {
    V minValue = getMinValue();
    if (isNull(minValue)) return false;
    return isLowerThanMinValue(minValue, value);
  }

  /**
   * Enables the formatting of numbers displayed in the NumberBox.
   *
   * @return This instance, to facilitate method chaining.
   */
  public T enableFormatting() {
    return setFormattingEnabled(true);
  }

  /**
   * Disables the formatting of numbers displayed in the NumberBox.
   *
   * @return This instance, to facilitate method chaining.
   */
  public T disableFormatting() {
    return setFormattingEnabled(false);
  }

  /**
   * Sets whether the formatting of numbers should be enabled or disabled in the NumberBox.
   *
   * @param formattingEnabled A boolean indicating whether formatting should be enabled.
   * @return This instance, to facilitate method chaining.
   */
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

  /**
   * Retrieves the current number format used by this NumberBox. If a custom pattern has been set,
   * that format will be returned; otherwise, the default decimal format will be used.
   *
   * @return The NumberFormat instance corresponding to the current format.
   */
  protected NumberFormat getNumberFormat() {
    return numberFormatSupplier.get(getPattern());
  }

  /**
   * Sets a supplier to use to get a custom number format to be used by this NumberBox. if null is
   * provided, then use default supplier.
   *
   * @return same component.
   */
  public T setNumberFormat(NumberFormatSupplier numberFormatSupplier) {
    if (nonNull(numberFormatSupplier)) {
      this.numberFormatSupplier = numberFormatSupplier;
    } else {
      this.numberFormatSupplier = defaultFormatSupplier;
    }
    return (T) this;
  }

  /**
   * Retrieves the custom pattern used for number formatting in this NumberBox, if any.
   *
   * @return The custom pattern string, or null if none has been set.
   */
  public String getPattern() {
    return pattern;
  }

  /**
   * Sets a custom pattern for number formatting in this NumberBox. After setting the pattern, the
   * current value will be reformatted according to the new pattern.
   *
   * @param pattern The custom pattern string.
   * @return This instance, to facilitate method chaining.
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
   * Attempts to parse a given string into a double value, using the current number format. If
   * parsing fails with the current format and a custom pattern is set, it will try to parse using
   * the default decimal format.
   *
   * @param value The string to parse.
   * @return The parsed double value.
   * @throws NumberFormatException if the string cannot be parsed into a double.
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

  /**
   * Retrieves the placeholder text displayed in the NumberBox when it is empty.
   *
   * @return The placeholder text.
   */
  @Override
  public String getPlaceholder() {
    return getInputElement().element().placeholder;
  }

  /**
   * Sets the placeholder text to be displayed in the NumberBox when it is empty.
   *
   * @param placeholder The desired placeholder text.
   * @return This instance, to facilitate method chaining.
   */
  @Override
  public T setPlaceholder(String placeholder) {
    getInputElement().element().placeholder = placeholder;
    return (T) this;
  }

  /**
   * Parses a given string value into the numeric type (V) of this NumberBox using the current value
   * parser.
   *
   * @param value The string to be parsed.
   * @return The parsed numeric value of type V.
   */
  protected V parseValue(String value) {
    return valueParser.apply(value);
  }

  /**
   * Provides the default function used to parse string values into the numeric type (V) of this
   * NumberBox.
   *
   * @return The default value parsing function.
   */
  protected abstract java.util.function.Function<String, V> defaultValueParser();

  /**
   * Provides the default maximum allowed value for this NumberBox.
   *
   * @return The default maximum value.
   */
  protected abstract V defaultMaxValue();

  /**
   * Provides the default minimum allowed value for this NumberBox.
   *
   * @return The default minimum value.
   */
  protected abstract V defaultMinValue();

  /**
   * Sets a custom parser function to parse string values into the numeric type (V) of this
   * NumberBox. If the provided parser is null, the current parser remains unchanged.
   *
   * @param valueParser The custom value parsing function.
   * @return This instance, to facilitate method chaining.
   */
  public T setValueParser(java.util.function.Function<String, V> valueParser) {
    if (nonNull(valueParser)) {
      this.valueParser = valueParser;
    }
    return (T) this;
  }

  /**
   * Determines if a given value exceeds the specified maximum value.
   *
   * @param maxValue The maximum value to compare against.
   * @param value The value to be checked.
   * @return True if the value exceeds the maximum value; otherwise, false.
   */
  protected abstract boolean isExceedMaxValue(V maxValue, V value);

  /**
   * Determines if a given value is lower than the specified minimum value.
   *
   * @param minValue The minimum value to compare against.
   * @param value The value to be checked.
   * @return True if the value is lower than the minimum value; otherwise, false.
   */
  protected abstract boolean isLowerThanMinValue(V minValue, V value);

  /**
   * Creates an automatic validator for the NumberBox input.
   *
   * @param autoValidate A function to be called when automatic validation is triggered.
   * @return A new instance of the InputAutoValidator for this NumberBox.
   */
  @Override
  public AutoValidator createAutoValidator(ApplyFunction autoValidate) {
    return new InputAutoValidator(autoValidate, getInputElement());
  }

  /**
   * Sets the text content for the postfix element.
   *
   * @param postfix The desired postfix string.
   * @return This instance, to facilitate method chaining.
   */
  @Override
  public T setPostfix(String postfix) {
    postfixElement.get().setTextContent(postfix);
    return (T) this;
  }

  /**
   * Retrieves the text content of the postfix element.
   *
   * @return The postfix text.
   */
  @Override
  public String getPostfix() {
    if (postfixElement.isInitialized()) {
      return postfixElement.get().getTextContent();
    }
    return "";
  }

  /**
   * Sets the text content for the prefix element.
   *
   * @param prefix The desired prefix string.
   * @return This instance, to facilitate method chaining.
   */
  @Override
  public T setPrefix(String prefix) {
    prefixElement.get().setTextContent(prefix);
    return (T) this;
  }

  /**
   * Retrieves the text content of the prefix element.
   *
   * @return The prefix text.
   */
  @Override
  public String getPrefix() {
    if (prefixElement.isInitialized()) {
      return prefixElement.get().getTextContent();
    }
    return "";
  }

  @Override
  public PostfixElement getPostfixElement() {
    return PostfixElement.of(postfixElement.get().element());
  }

  @Override
  public PrefixElement getPrefixElement() {
    return PrefixElement.of(prefixElement.get().element());
  }

  /**
   * Ensures the prefix element is initialized.
   *
   * @return This instance, to facilitate method chaining.
   */
  public T withPrefixElement() {
    prefixElement.get();
    return (T) this;
  }

  /**
   * Ensures the postfix element is initialized.
   *
   * @return This instance, to facilitate method chaining.
   */
  public T withPostfixElement() {
    postfixElement.get();
    return (T) this;
  }

  /**
   * Retrieves the name attribute of the input element.
   *
   * <p>The name attribute specifies the name for an `<input>` element. The name attribute is used
   * to reference elements in a JavaScript, or to reference form data after a form is submitted.
   *
   * @return The name attribute value.
   */
  @Override
  public String getName() {
    return getInputElement().element().name;
  }

  /**
   * Sets the name attribute for the input element.
   *
   * <p>The name attribute specifies the name for an `<input>` element. This can be beneficial when
   * sending data to the server or referencing it in scripts.
   *
   * @param name The desired name attribute value.
   * @return This instance, to facilitate method chaining.
   */
  @Override
  public T setName(String name) {
    getInputElement().element().name = name;
    return (T) this;
  }

  @FunctionalInterface
  public interface NumberFormatSupplier {
    NumberFormat get(String pattern);
  }
}
