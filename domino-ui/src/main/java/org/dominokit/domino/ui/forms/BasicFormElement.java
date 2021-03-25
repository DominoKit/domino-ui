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
import static org.jboss.elemento.Elements.label;

import elemental2.dom.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import org.dominokit.domino.ui.forms.validations.ElementValidations;
import org.dominokit.domino.ui.forms.validations.RequiredValidator;
import org.dominokit.domino.ui.forms.validations.ValidationResult;
import org.dominokit.domino.ui.utils.BaseDominoElement;
import org.dominokit.domino.ui.utils.DominoElement;
import org.dominokit.domino.ui.utils.IsReadOnly;
import org.gwtproject.editor.client.EditorError;
import org.gwtproject.safehtml.shared.SafeHtml;
import org.jboss.elemento.IsElement;

/**
 * A base implementation for Form elements
 *
 * @param <T> the type of form field extending from this class
 * @param <V> the type of the form field value
 */
public abstract class BasicFormElement<T extends BasicFormElement<T, V>, V>
    extends BaseDominoElement<HTMLElement, T>
    implements FormElement<T, V>, IsReadOnly<T>, HasInputElement {

  private static final String NAME = "name";
  private ElementValidations elementValidations = new ElementValidations(this);
  private RequiredValidator requiredValidator = new RequiredValidator(this);
  private String helperText;
  private boolean fixErrorsPosition;
  private String requiredErrorMessage;
  private List<HTMLElement> errorLabels = new ArrayList<>();
  private List<String> errors = new ArrayList<>();
  private boolean validationDisabled = false;
  private Node requiredIndicator = DominoFields.INSTANCE.getRequiredIndicator().get();
  private boolean showRequiredIndicator = true;

  /** {@inheritDoc} */
  @Override
  public T setHelperText(String helperText) {
    this.helperText = helperText;
    getHelperContainer().setTextContent(helperText);
    return (T) this;
  }

  /** {@inheritDoc} */
  @Override
  public String getHelperText() {
    return helperText;
  }

  /** {@inheritDoc} */
  @Override
  public T setName(String name) {
    getInputElement().setAttribute(NAME, name);
    return (T) this;
  }

  /** {@inheritDoc} */
  @Override
  public String getName() {
    return getInputElement().getAttribute(NAME);
  }

  /** {@inheritDoc} */
  @Override
  public T setLabel(String label) {
    updateLabel(label);
    return (T) this;
  }

  /** @param label String new label to replace the old one */
  protected void updateLabel(String label) {
    getLabelTextElement().setTextContent(label);
  }

  /**
   * Sets the label as a custom element
   *
   * @param node {@link Node} label element
   * @return same form element class
   */
  public T setLabel(Node node) {
    getLabelTextElement().clearElement().appendChild(node);
    return (T) this;
  }

  /**
   * Sets the label from html
   *
   * @param safeHtml {@link SafeHtml}
   * @return same form element class
   */
  public T setLabel(SafeHtml safeHtml) {
    getLabelTextElement().setInnerHtml(safeHtml.asString());
    return (T) this;
  }

  /**
   * Sets the label from an element
   *
   * @param element {@link IsElement}
   * @return same form element class
   */
  public T setLabel(IsElement<?> element) {
    return setLabel(element.element());
  }

  /** {@inheritDoc} */
  @Override
  public String getLabel() {
    return getLabelTextElement().getTextContent();
  }

  /** {@inheritDoc} */
  @Override
  public T enable() {
    getInputElement().removeAttribute("disabled");
    return (T) this;
  }

  /** {@inheritDoc} */
  @Override
  public boolean isEnabled() {
    return !getInputElement().hasAttribute("disabled");
  }

  /** {@inheritDoc} */
  @Override
  public boolean isDisabled() {
    return getInputElement().hasAttribute("disabled");
  }

  /** {@inheritDoc} */
  @Override
  public T disable() {
    getInputElement().setAttribute("disabled", "disabled");
    return (T) this;
  }

  /** @return boolean, true if the validation is disabled else false */
  public boolean isValidationDisabled() {
    return validationDisabled;
  }

  /**
   * Disable/enable the validation
   *
   * @param validationDisabled boolean, true to disable validation, false to enable it
   * @return same form element class
   */
  public T setValidationDisabled(boolean validationDisabled) {
    this.validationDisabled = validationDisabled;
    return (T) this;
  }

  /** {@inheritDoc} */
  @Override
  public ValidationResult validate() {
    if (!validationDisabled) {
      return elementValidations.validate();
    } else {
      return ValidationResult.valid();
    }
  }

  /** {@inheritDoc} */
  @Override
  public T removeValidator(Validator validator) {
    elementValidations.removeValidator(validator);
    return (T) this;
  }

  /** {@inheritDoc} */
  @Override
  public boolean hasValidator(Validator validator) {
    return elementValidations.hasValidator(validator);
  }

  /** {@inheritDoc} */
  @Override
  public T addValidator(Validator validator) {
    elementValidations.addValidator(validator);
    return (T) this;
  }

  /** {@inheritDoc} */
  @Override
  public T invalidate(String errorMessage) {
    invalidate(Collections.singletonList(errorMessage));
    return (T) this;
  }

  /** {@inheritDoc} */
  @Override
  public T invalidate(List<String> errorMessages) {
    getHelperContainer().toggleDisplay(errorMessages.isEmpty());
    removeErrors();
    if (!fixErrorsPosition) {
      getErrorsContainer().toggleDisplay(!errorMessages.isEmpty());
    } else {
      getErrorsContainer().show();
    }

    if (!errorMessages.isEmpty()) {
      css("error");
    } else {
      removeCss("error");
    }

    errorMessages.forEach(
        message -> {
          HTMLLabelElement errorLabel = makeErrorLabel(message);
          errorLabels.add(errorLabel);
          getErrorsContainer().appendChild(errorLabel);
        });

    this.errors.clear();
    this.errors.addAll(errorMessages);

    return (T) this;
  }

  /**
   * Temporary disable validation then apply the {@link FieldHandler} logic then restore the
   * validationDisabled original state
   *
   * @param fieldHandler {@link FieldHandler}
   * @return same form element class
   */
  public T withValidationDisabled(FieldHandler<T> fieldHandler) {
    boolean validationState = this.validationDisabled;
    try {
      this.validationDisabled = true;
      fieldHandler.apply((T) this);
    } finally {
      this.validationDisabled = validationState;
    }
    return (T) this;
  }

  /**
   * Creates a label and apply error styles on it
   *
   * @param message String error message
   * @return same form element instance
   */
  protected HTMLLabelElement makeErrorLabel(String message) {
    return label().css("error").textContent(message).element();
  }

  /** {@inheritDoc} */
  @Override
  public T clearInvalid() {
    getHelperContainer().show();
    removeErrors();
    if (!fixErrorsPosition) {
      getErrorsContainer().hide();
    }
    return (T) this;
  }

  private void removeErrors() {
    errorLabels.clear();
    errors.clear();
    getErrorsContainer().clearElement();
    removeCss("error");
  }

  /** {@inheritDoc} */
  @Override
  public List<String> getErrors() {
    return errors;
  }

  /** */
  public List<HTMLElement> getErrorLabels() {
    return errorLabels;
  }

  /** {@inheritDoc} */
  @Override
  public T setRequired(boolean required) {
    removeRequiredIndicator();
    if (required) {
      addValidator(requiredValidator);
      if (this.showRequiredIndicator) {
        getLabelElement().appendChild(requiredIndicator);
      }
    } else {
      removeValidator(requiredValidator);
    }
    return (T) this;
  }

  private void removeRequiredIndicator() {
    if (nonNull(getLabelElement()) && getLabelElement().hasDirectChild(requiredIndicator)) {
      getLabelElement().removeChild(requiredIndicator);
    }
  }

  /** {@inheritDoc} */
  @Override
  public T setRequired(boolean required, String message) {
    setRequired(required);
    setRequiredErrorMessage(message);
    return (T) this;
  }

  /** {@inheritDoc} */
  @Override
  public boolean isRequired() {
    return hasValidator(requiredValidator);
  }

  /** {@inheritDoc} */
  @Override
  public T setRequiredErrorMessage(String requiredErrorMessage) {
    this.requiredErrorMessage = requiredErrorMessage;
    return (T) this;
  }

  /** {@inheritDoc} */
  @Override
  public String getRequiredErrorMessage() {
    return isNull(requiredErrorMessage) ? "* This field is required." : requiredErrorMessage;
  }

  /**
   * Enable/Disable required indicator
   *
   * @param showRequiredIndicator boolean, true is visible else false
   * @return same form element instance
   */
  public T setShowRequiredIndicator(boolean showRequiredIndicator) {
    this.showRequiredIndicator = showRequiredIndicator;
    removeRequiredIndicator();
    if (showRequiredIndicator && isRequired()) {
      getLabelElement().appendChild(requiredIndicator);
    }
    return (T) this;
  }

  /** @return boolean, true if required indicator is enabled */
  public boolean isShowRequiredIndicator() {
    return showRequiredIndicator;
  }

  /** {@inheritDoc} */
  @Override
  public T groupBy(FieldsGrouping fieldsGrouping) {
    fieldsGrouping.addFormElement(this);
    return (T) this;
  }

  /** {@inheritDoc} */
  @Override
  public T ungroup(FieldsGrouping fieldsGrouping) {
    fieldsGrouping.removeFormElement(this);
    return (T) this;
  }

  /** {@inheritDoc} */
  @Override
  public void setValue(V value) {
    value(value);
  }

  /** @return boolean, true if the errors message position is fixed */
  public boolean isFixErrorsPosition() {
    return fixErrorsPosition;
  }

  /**
   * @param fixErrorsPosition boolean, if true the errors message container size will be fixed and
   *     wont change the spacing between the fileds when an error message is shown.
   * @return same form element instance
   */
  public T setFixErrorsPosition(boolean fixErrorsPosition) {
    this.fixErrorsPosition = fixErrorsPosition;
    return (T) this;
  }

  /**
   * @return the {@link HTMLDivElement} that contains this field input element wrapped as {@link
   *     DominoElement}
   */
  protected abstract DominoElement<HTMLDivElement> getFieldInputContainer();

  /**
   * @return the {@link HTMLDivElement} that contains this field wrapped as {@link DominoElement}
   */
  protected abstract DominoElement<HTMLDivElement> getFieldContainer();

  /**
   * @return the {@link HTMLElement} that contains this field helper text element wrapped as {@link
   *     DominoElement}
   */
  protected abstract DominoElement<HTMLElement> getHelperContainer();

  /**
   * @return the {@link HTMLElement} that contains this field errors element wrapped as {@link
   *     DominoElement}
   */
  protected abstract DominoElement<HTMLElement> getErrorsContainer();

  /** @return the field {@link HTMLLabelElement} wrapped as {@link DominoElement} */
  protected abstract DominoElement<HTMLLabelElement> getLabelElement();

  /**
   * @return the {@link HTMLDivElement} that contains this field additional info element wrapped as
   *     {@link DominoElement}
   */
  public abstract DominoElement<HTMLDivElement> getAdditionalInfoContainer();

  /**
   * @return the {@link HTMLElement} that contains the label text wrapped as {@link DominoElement}
   */
  public DominoElement<HTMLElement> getLabelTextElement() {
    return DominoElement.of(getLabelElement().element());
  }

  /** {@inheritDoc} */
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
   * a Generic function to apply some logic on a field without triggering validation
   *
   * @param <T> the the field
   */
  @FunctionalInterface
  public interface FieldHandler<T> {
    /** @param field T the field we apply the logic on */
    void apply(T field);
  }
}
