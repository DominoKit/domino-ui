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
import static org.dominokit.domino.ui.utils.Domino.*;

import elemental2.dom.HTMLElement;
import elemental2.dom.HTMLFieldSetElement;
import elemental2.dom.Text;
import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;
import org.dominokit.domino.ui.config.FormsFieldsConfig;
import org.dominokit.domino.ui.config.HasComponentConfig;
import org.dominokit.domino.ui.elements.DivElement;
import org.dominokit.domino.ui.elements.FieldSetElement;
import org.dominokit.domino.ui.elements.LabelElement;
import org.dominokit.domino.ui.elements.SpanElement;
import org.dominokit.domino.ui.forms.validations.RequiredValidator;
import org.dominokit.domino.ui.forms.validations.ValidationResult;
import org.dominokit.domino.ui.i18n.FormsLabels;
import org.dominokit.domino.ui.style.BooleanCssClass;
import org.dominokit.domino.ui.utils.*;
import org.gwtproject.editor.client.EditorError;

/**
 * An abstract base class for form elements in the Domino UI framework.
 *
 * <p>AbstractFormElement provides common functionality for form elements, including validation,
 * error handling, labeling, and more. It can be extended to create specific form elements with
 * custom behavior.
 *
 * <p>Usage Example:
 *
 * <pre>
 * // Create a custom form element by extending AbstractFormElement
 * public class MyCustomFormElement extends AbstractFormElement&lt;MyCustomFormElement, String&gt; {
 *
 *     public MyCustomFormElement() {
 *         // Initialize and configure the form element
 *         // ...
 *     }
 *
 *     // Implement any additional methods and behaviors specific to your custom form element
 *     // ...
 * }
 * </pre>
 *
 * @param <T> The concrete form element type.
 * @param <V> The type of the form element's value.
 * @see BaseDominoElement
 */
public abstract class AbstractFormElement<T extends AbstractFormElement<T, V>, V>
    extends BaseDominoElement<HTMLFieldSetElement, T>
    implements FormElement<T, V>, HasComponentConfig<FormsFieldsConfig>, FormsStyles {

  protected final FieldSetElement formElement;
  protected final DivElement bodyElement;
  protected final LazyChild<LabelElement> labelElement;
  protected LazyChild<DominoElement<HTMLElement>> requiredElement;
  protected final DivElement wrapperElement;
  protected final LazyChild<DivElement> messagesWrapper;
  protected final LazyChild<SpanElement> helperTextElement;
  protected Function<String, SpanElement> errorElementSupplier;

  protected Set<Validator<T>> validators = new LinkedHashSet<>();
  protected AutoValidator autoValidator;
  protected final List<String> errors = new ArrayList<>();
  protected String requiredErrorMessage;

  protected final FormsLabels labels = DominoUIConfig.CONFIG.getDominoUILabels();
  protected final RequiredValidator<T> requiredValidator;
  protected Set<ChangeListener<? super V>> changeListeners = new LinkedHashSet<>();
  protected Set<ClearListener<? super V>> clearListeners = new LinkedHashSet<>();
  private boolean autoValidate = false;
  private boolean required = false;
  private boolean changeListenersPaused = false;
  private boolean clearListenersPaused = false;
  private boolean validationsPaused = false;
  private boolean focusValidationPaused = false;
  private boolean emptyAsNull;

  private Text labelText = text();

  protected V defaultValue;
  private boolean showRequiredIndicator = true;

  /** Creates a new instance of AbstractFormElement. */
  public AbstractFormElement() {
    formElement =
        fieldset()
            .addCss(dui_form_field)
            .appendChild(
                bodyElement =
                    div()
                        .addCss(dui_field_body)
                        .appendChild(wrapperElement = div().addCss(dui_input_wrapper)));
    labelElement = LazyChild.of(label().addCss(dui_field_label), formElement);
    labelElement.whenInitialized(() -> labelElement.element().appendChild(labelText));
    messagesWrapper = LazyChild.of(div().addCss(dui_messages_wrapper), bodyElement);
    helperTextElement = LazyChild.of(span().addCss(dui_field_helper), messagesWrapper);
    errorElementSupplier =
        errorMessage -> span().addCss(dui_field_error).setTextContent(errorMessage);

    requiredValidator = new RequiredValidator<>(this);
    if (getConfig().isFixedLabelSpace()) {
      labelElement.get();
    }
    init((T) this);
    setLabelFloatLeft(getConfig().isFormFieldFloatLabelLeft());
  }

  protected LazyChild<DominoElement<HTMLElement>> initRequiredIndicator() {
    return LazyChild.of(
        elementOf(getConfig().getRequiredIndicator().get()).addCss(dui_field_required_indicator),
        labelElement);
  }

  /**
   * Returns the HTML representation of this form element.
   *
   * @return The HTML fieldset element representing the form element.
   */
  @Override
  public HTMLFieldSetElement element() {
    return formElement.element();
  }

  /**
   * Sets the "for" attribute of the label element to associate it with an HTML element by its ID.
   *
   * @param id The ID of the HTML element to associate with the label.
   * @return This form element instance.
   */
  @Override
  public T labelForId(String id) {
    labelElement.doOnce(() -> labelElement.element().setAttribute("for", id));
    return (T) this;
  }

  /**
   * Groups this form element with a FieldsGrouping instance.
   *
   * @param fieldsGrouping The FieldsGrouping instance to group this form element with.
   * @return This form element instance.
   */
  @Override
  public T groupBy(FieldsGrouping fieldsGrouping) {
    fieldsGrouping.addFormElement(this);
    return (T) this;
  }

  /**
   * Ungroups this form element from a FieldsGrouping instance.
   *
   * @param fieldsGrouping The FieldsGrouping instance to ungroup this form element from.
   * @return This form element instance.
   */
  @Override
  public T ungroup(FieldsGrouping fieldsGrouping) {
    fieldsGrouping.removeFormElement(this);
    return (T) this;
  }

  @Override
  public PrefixElement getPrefixElement() {
    return PrefixElement.of(wrapperElement);
  }

  @Override
  public PostfixElement getPostfixElement() {
    return PostfixElement.of(wrapperElement);
  }

  /**
   * Appends a prefix add-on to the form element.
   *
   * @param addon The prefix add-on to append.
   * @return This form element instance.
   */
  @Override
  public T appendChild(PrefixAddOn<?> addon) {
    getPrefixElement().appendChild(addon);
    return (T) this;
  }

  /**
   * Appends a postfix add-on to the form element.
   *
   * @param addon The postfix add-on to append.
   * @return This form element instance.
   */
  @Override
  public T appendChild(PostfixAddOn<?> addon) {
    getPostfixElement().appendChild(addon);
    return (T) this;
  }

  @Override
  public PrimaryAddOnElement getPrimaryAddonsElement() {
    return PrimaryAddOnElement.of(wrapperElement);
  }

  /**
   * Sets whether auto-validation is enabled for this form element.
   *
   * @param autoValidation True to enable auto-validation, false to disable it.
   * @return This form element instance.
   */
  @Override
  public T setAutoValidation(boolean autoValidation) {
    if (autoValidation) {
      if (autoValidator == null) {
        autoValidator = createAutoValidator(this::validate);
      }
      autoValidator.attach();
    } else {
      if (nonNull(autoValidator)) {
        autoValidator.remove();
      }
      autoValidator = null;
    }
    this.autoValidate = autoValidation;
    return (T) this;
  }

  /**
   * Checks if auto-validation is enabled for this form element.
   *
   * @return True if auto-validation is enabled, false otherwise.
   */
  @Override
  public boolean isAutoValidation() {
    return autoValidate;
  }

  /**
   * Performs auto-validation on this form element.
   *
   * @return This form element instance.
   */
  @Override
  public T autoValidate() {
    if (isAutoValidation()) {
      validate();
    }
    return (T) this;
  }

  /**
   * Pauses form element validations.
   *
   * @return This form element instance.
   */
  @Override
  public T pauseValidations() {
    this.validationsPaused = true;
    return (T) this;
  }

  /**
   * Resumes form element validations.
   *
   * @return This form element instance.
   */
  @Override
  public T resumeValidations() {
    this.validationsPaused = false;
    return (T) this;
  }

  /**
   * Checks if form element validations are paused.
   *
   * @return True if validations are paused, false otherwise.
   */
  @Override
  public boolean isValidationsPaused() {
    return validationsPaused;
  }

  /**
   * Toggles pause state for form element validations.
   *
   * @param toggle True to pause validations, false to resume them.
   * @return This form element instance.
   */
  @Override
  public T togglePauseValidations(boolean toggle) {
    this.validationsPaused = toggle;
    return (T) this;
  }

  /**
   * Pauses focus-based form element validations.
   *
   * @return This form element instance.
   */
  @Override
  public T pauseFocusValidations() {
    this.focusValidationPaused = true;
    return (T) this;
  }

  /**
   * Resumes focus-based form element validations.
   *
   * @return This form element instance.
   */
  @Override
  public T resumeFocusValidations() {
    this.focusValidationPaused = false;
    return (T) this;
  }

  /**
   * Toggles pause state for focus-based form element validations.
   *
   * @param toggle True to pause focus validations, false to resume them.
   * @return This form element instance.
   */
  @Override
  public T togglePauseFocusValidations(boolean toggle) {
    this.focusValidationPaused = toggle;
    return (T) this;
  }

  /**
   * Checks if focus-based form element validations are paused.
   *
   * @return True if focus validations are paused, false otherwise.
   */
  @Override
  public boolean isFocusValidationsPaused() {
    return this.focusValidationPaused;
  }

  /**
   * Sets the helper text for this form element.
   *
   * @param helperText The helper text to set.
   * @return This form element instance.
   */
  @Override
  public T setHelperText(String helperText) {
    helperTextElement.get().setTextContent(helperText);
    return (T) this;
  }

  /**
   * Gets the helper text of this form element.
   *
   * @return The helper text of this form element.
   */
  @Override
  public String getHelperText() {
    if (helperTextElement.isInitialized()) {
      return helperTextElement.get().getTextContent();
    }
    return "";
  }

  /**
   * Sets the label for this form element.
   *
   * @param label The label to set.
   * @return This form element instance.
   */
  @Override
  public T setLabel(String label) {
    labelElement.get();
    labelText.textContent = label;
    return (T) this;
  }

  /**
   * Gets the label of this form element.
   *
   * @return The label of this form element.
   */
  @Override
  public String getLabel() {
    if (labelElement.isInitialized()) {
      return labelElement.get().getTextContent();
    }
    return "";
  }

  /**
   * Sets whether the label should float to the left when a value is entered.
   *
   * @param floatLeft True to make the label float to the left, false otherwise.
   * @return This form element instance.
   */
  public T setLabelFloatLeft(boolean floatLeft) {
    addCss(BooleanCssClass.of(dui_form_label_float_left, floatLeft));
    return (T) this;
  }

  /**
   * Validates this form element and returns the validation result.
   *
   * @param formElement The form element to validate.
   * @return The validation result.
   */
  @Override
  public ValidationResult validate(T formElement) {
    if (!validationsPaused) {
      return doValidate();
    } else {
      return ValidationResult.valid();
    }
  }

  /**
   * Gets the set of validators associated with this form element.
   *
   * @return The set of validators.
   */
  @Override
  public Set<Validator<T>> getValidators() {
    return validators;
  }

  protected ValidationResult doValidate() {
    element.clearInvalid();
    if (!element.isEnabled()) {
      return ValidationResult.valid();
    }
    for (Validator<T> validator : getValidators()) {
      ValidationResult result = validator.isValid((T) this);
      if (!result.isValid()) {
        element.invalidate(result.getErrorMessage());
        return result;
      }
    }
    return ValidationResult.valid();
  }

  /**
   * Invalidates this form element with a custom error message.
   *
   * @param errorMessage The error message to display.
   * @return This form element instance.
   */
  @Override
  public T invalidate(String errorMessage) {
    invalidate(Collections.singletonList(errorMessage));
    return (T) this;
  }

  /**
   * Invalidates this form element with a list of custom error messages.
   *
   * @param errorMessages The list of error messages to display.
   * @return This form element instance.
   */
  @Override
  public T invalidate(List<String> errorMessages) {
    removeErrors();
    errorMessages.forEach(
        message -> {
          this.errors.add(message);
          messagesWrapper.get().appendChild(errorElementSupplier.apply(message));
        });

    if (!errorMessages.isEmpty()) {
      formElement.addCss(dui_field_invalid);
    }

    return (T) this;
  }

  private void removeErrors() {
    errors.clear();
    messagesWrapper
        .get()
        .querySelectorAll("." + dui_field_error.getCssClass())
        .forEach(BaseDominoElement::remove);
    dui_field_invalid.remove(this);
  }

  /**
   * Gets the list of error messages associated with this form element.
   *
   * @return The list of error messages.
   */
  @Override
  public List<String> getErrors() {
    return errors;
  }

  /**
   * Clears any invalid state and error messages from this form element.
   *
   * @return This form element instance.
   */
  @Override
  public T clearInvalid() {
    removeErrors();
    return (T) this;
  }

  /**
   * Sets whether this form element is required.
   *
   * @param required True to make this form element required, false otherwise.
   * @return This form element instance.
   */
  @Override
  public T setRequired(boolean required) {
    this.required = required;
    getRequiredElement().initOrRemove(isRequired() && isShowRequiredIndicator());
    addOrRemoveValidator(requiredValidator, required);
    return (T) this;
  }

  /**
   * Sets whether to show the required indicator for this form element.
   *
   * @param state True to show the required indicator, false to hide it.
   * @return This form element instance.
   */
  public T setShowRequiredIndicator(boolean state) {
    this.showRequiredIndicator = state;
    getRequiredElement().initOrRemove(isRequired() && isShowRequiredIndicator());
    return (T) this;
  }

  private LazyChild<DominoElement<HTMLElement>> getRequiredElement() {
    if (isNull(requiredElement)) {
      requiredElement = initRequiredIndicator();
    }
    return requiredElement;
  }

  /**
   * Checks if the required indicator should be shown for this form element.
   *
   * @return True if the required indicator is shown, false otherwise.
   */
  public boolean isShowRequiredIndicator() {
    return this.showRequiredIndicator;
  }

  /**
   * Sets whether this form element is required and provides a custom error message for the required
   * validation.
   *
   * @param required True to make this form element required, false otherwise.
   * @param message The custom error message to display when the field is required.
   * @return This form element instance.
   */
  @Override
  public T setRequired(boolean required, String message) {
    setRequired(required);
    setRequiredErrorMessage(message);
    return (T) this;
  }

  /**
   * Checks if this form element is required.
   *
   * @return True if this form element is required, false otherwise.
   */
  @Override
  public boolean isRequired() {
    return required;
  }

  /**
   * Sets the error message to display when this form element is required but not filled.
   *
   * @param requiredErrorMessage The required error message.
   * @return This form element instance.
   */
  @Override
  public T setRequiredErrorMessage(String requiredErrorMessage) {
    this.requiredErrorMessage = requiredErrorMessage;
    return (T) this;
  }

  /**
   * Gets the error message to display when this form element is required but not filled.
   *
   * @return The required error message.
   */
  @Override
  public String getRequiredErrorMessage() {
    return isNull(requiredErrorMessage) ? labels.requiredErrorMessage() : requiredErrorMessage;
  }

  /**
   * Displays errors associated with this form element based on a list of EditorError instances.
   *
   * @param errors The list of EditorError instances.
   */
  @Override
  public void showErrors(List<EditorError> errors) {
    List<String> editorErrors =
        errors.stream()
            .filter(e -> this.equals(e.getEditor()))
            .map(EditorError::getMessage)
            .collect(Collectors.toList());

    if (editorErrors.isEmpty()) {
      clearInvalid();
    } else {
      invalidate(editorErrors);
    }
  }

  /**
   * Sets whether error messages should be fixed in position.
   *
   * @param fixErrorsPosition True to fix error messages in position, false otherwise.
   * @return This form element instance.
   */
  @Override
  public T fixErrorsPosition(boolean fixErrorsPosition) {
    addCss(BooleanCssClass.of(dui_fixed_errors, fixErrorsPosition));
    return (T) this;
  }

  /**
   * Pauses change listeners for this form element.
   *
   * @return This form element instance.
   */
  @Override
  public T pauseChangeListeners() {
    this.changeListenersPaused = true;
    return (T) this;
  }

  /**
   * Resumes change listeners for this form element.
   *
   * @return This form element instance.
   */
  @Override
  public T resumeChangeListeners() {
    this.changeListenersPaused = false;
    return (T) this;
  }

  /**
   * Gets the set of change listeners associated with this form element.
   *
   * @return The set of change listeners.
   */
  @Override
  public Set<ChangeListener<? super V>> getChangeListeners() {
    return changeListeners;
  }

  /**
   * Checks if change listeners for this form element are paused.
   *
   * @return True if change listeners are paused, false otherwise.
   */
  @Override
  public boolean isChangeListenersPaused() {
    return changeListenersPaused;
  }

  /**
   * Toggles pause state for change listeners for this form element.
   *
   * @param toggle True to pause change listeners, false to resume them.
   * @return This form element instance.
   */
  @Override
  public T togglePauseChangeListeners(boolean toggle) {
    this.changeListenersPaused = toggle;
    return (T) this;
  }

  /**
   * Pauses clear listeners for this form element.
   *
   * @return This form element instance.
   */
  @Override
  public T pauseClearListeners() {
    this.clearListenersPaused = true;
    return (T) this;
  }

  /**
   * Resumes clear listeners for this form element.
   *
   * @return This form element instance.
   */
  @Override
  public T resumeClearListeners() {
    this.clearListenersPaused = false;
    return (T) this;
  }

  /**
   * Toggles pause state for clear listeners for this form element.
   *
   * @param toggle True to pause clear listeners, false to resume them.
   * @return This form element instance.
   */
  @Override
  public T togglePauseClearListeners(boolean toggle) {
    this.clearListenersPaused = toggle;
    return (T) this;
  }

  /**
   * Gets the set of clear listeners associated with this form element.
   *
   * @return The set of clear listeners.
   */
  @Override
  public Set<ClearListener<? super V>> getClearListeners() {
    return clearListeners;
  }

  /**
   * Checks if clear listeners for this form element are paused.
   *
   * @return True if clear listeners are paused, false otherwise.
   */
  @Override
  public boolean isClearListenersPaused() {
    return clearListenersPaused;
  }

  /**
   * Sets whether empty values should be treated as null values.
   *
   * @param emptyAsNull True to treat empty values as null, false otherwise.
   * @return This form element instance.
   */
  public T setEmptyAsNull(boolean emptyAsNull) {
    this.emptyAsNull = emptyAsNull;
    return (T) this;
  }

  /**
   * Checks if empty values are treated as null values.
   *
   * @return True if empty values are treated as null, false otherwise.
   */
  public boolean isEmptyAsNull() {
    return emptyAsNull;
  }

  /**
   * Sets the default value for this form element.
   *
   * @param defaultValue The default value to set.
   * @return This form element instance.
   */
  @Override
  public T setDefaultValue(V defaultValue) {
    this.defaultValue = defaultValue;
    return (T) this;
  }

  /**
   * Gets the default value for this form element.
   *
   * @return The default value.
   */
  @Override
  public V getDefaultValue() {
    return defaultValue;
  }

  /**
   * Gets the body element of this form element.
   *
   * @return The body element.
   */
  public DivElement getBodyElement() {
    return bodyElement;
  }

  /**
   * Gets the label element of this form element.
   *
   * @return The label element.
   */
  public LabelElement getLabelElement() {
    return labelElement.get();
  }

  /**
   * Gets the wrapper element of this form element.
   *
   * @return The wrapper element.
   */
  public DivElement getWrapperElement() {
    return wrapperElement;
  }

  /**
   * Gets the messages wrapper element of this form element.
   *
   * @return The messages wrapper element.
   */
  public DivElement getMessagesWrapperElement() {
    return messagesWrapper.get();
  }

  /**
   * Gets the helper text element of this form element.
   *
   * @return The helper text element.
   */
  public SpanElement getHelperTextElement() {
    return helperTextElement.get();
  }

  /**
   * Applies a custom child handler to the body element of this form element.
   *
   * @param handler The child handler to apply.
   * @return This form element instance.
   */
  public T withBody(ChildHandler<T, DivElement> handler) {
    handler.apply((T) this, bodyElement);
    return (T) this;
  }

  /**
   * Initializes and retrieves the label element associated with this form element. Use this method
   * when you want to customize or manipulate the label element.
   *
   * @return This form element instance.
   */
  public T withLabel() {
    labelElement.get();
    return (T) this;
  }

  /**
   * Applies a custom child handler to the label element of this form element.
   *
   * @param handler The child handler to apply.
   * @return This form element instance.
   */
  public T withLabel(ChildHandler<T, LabelElement> handler) {
    handler.apply((T) this, labelElement.get());
    return (T) this;
  }

  /**
   * Applies a custom child handler to the wrapper element of this form element.
   *
   * @param handler The child handler to apply.
   * @return This form element instance.
   */
  public T withWrapper(ChildHandler<T, DivElement> handler) {
    handler.apply((T) this, wrapperElement);
    return (T) this;
  }

  /**
   * Initializes and retrieves the messages wrapper element associated with this form element. Use
   * this method when you want to customize or manipulate the messages wrapper element.
   *
   * @return This form element instance.
   */
  public T withMessagesWrapper() {
    messagesWrapper.get();
    return (T) this;
  }

  /**
   * Applies a custom child handler to the messages wrapper element of this form element.
   *
   * @param handler The child handler to apply.
   * @return This form element instance.
   */
  public T withMessagesWrapper(ChildHandler<T, DivElement> handler) {
    handler.apply((T) this, messagesWrapper.get());
    return (T) this;
  }

  /**
   * Initializes and retrieves the helper text element associated with this form element. Use this
   * method when you want to customize or manipulate the helper text element.
   *
   * @return This form element instance.
   */
  public T withHelperText() {
    helperTextElement.get();
    return (T) this;
  }

  /**
   * Applies a custom child handler to the helper text element of this form element.
   *
   * @param handler The child handler to apply.
   * @return This form element instance.
   */
  public T withHelperText(ChildHandler<T, SpanElement> handler) {
    handler.apply((T) this, helperTextElement.get());
    return (T) this;
  }

  /**
   * Gets the required element associated with this form element.
   *
   * @return The required element.
   */
  public LazyChild<DominoElement<HTMLElement>> requiredElement() {
    return requiredElement;
  }

  /**
   * Gets the messages wrapper element associated with this form element.
   *
   * @return The messages wrapper element.
   */
  public LazyChild<DivElement> messagesWrapper() {
    return messagesWrapper;
  }

  /**
   * Gets the label element associated with this form element.
   *
   * @return The label element.
   */
  public LazyChild<LabelElement> labelElement() {
    return labelElement;
  }
}
