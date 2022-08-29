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
import static org.dominokit.domino.ui.forms.FormsStyles.FIELD_ERROR;

import elemental2.dom.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import org.dominokit.domino.ui.forms.validations.ElementValidations;
import org.dominokit.domino.ui.forms.validations.RequiredValidator;
import org.dominokit.domino.ui.forms.validations.ValidationResult;
import org.dominokit.domino.ui.utils.*;
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
    implements FormElement<T, V>, AcceptReadOnly<T>, HasInputElement {

  private static final String NAME = "name";
  private ElementValidations elementValidations = new ElementValidations(this);
  private RequiredValidator requiredValidator = new RequiredValidator(this);
  private String helperText;
  private boolean fixErrorsPosition;
  private String requiredErrorMessage;
  private List<String> errors = new ArrayList<>();
  private boolean validationDisabled = false;
  private Node requiredIndicator = DominoUIConfig.CONFIG.getRequiredIndicator().get();
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
  public abstract T setLabel(String label);

  /**
   * Sets the label as a custom element
   *
   * @param node {@link Node} label element
   * @return same form element class
   */
  public abstract T setLabel(Node node);

  /**
   * Sets the label from html
   *
   * @param safeHtml {@link SafeHtml}
   * @return same form element class
   */
  public abstract T setLabel(SafeHtml safeHtml);

  /**
   * Sets the label from an element
   *
   * @param element {@link IsElement}
   * @return same form element class
   */
  public abstract T setLabel(IsElement<?> element);

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
    removeErrors();
    errorMessages.forEach(
        message -> {
          this.errors.add(message);
          getHelperContainer()
              .appendChild(DominoElement.span().addCss(FIELD_ERROR).textContent(message).element());
        });

    return (T) this;
  }

  /**
   * Temporary disable validation then apply the {@link Handler} logic then restore the
   * validationDisabled original state
   *
   * @param handler {@link Handler}
   * @return same form element class
   */
  public T withValidationDisabled(Handler<T> handler) {
    boolean validationState = this.validationDisabled;
    try {
      this.validationDisabled = true;
      handler.apply((T) this);
    } finally {
      this.validationDisabled = validationState;
    }
    return (T) this;
  }

  /** {@inheritDoc} */
  @Override
  public T clearInvalid() {
    removeErrors();
    return (T) this;
  }

  private void removeErrors() {
    errors.clear();
    getHelperContainer().querySelectorAll("." + FIELD_ERROR).forEach(BaseDominoElement::remove);
  }

  /** {@inheritDoc} */
  @Override
  public List<String> getErrors() {
    return errors;
  }

  /** */
  public List<HTMLElement> getErrorLabels() {
    return getHelperContainer().querySelectorAll("." + FIELD_ERROR).stream()
        .map(DominoElement::element)
        .collect(Collectors.toList());
  }

  /** {@inheritDoc} */
  @Override
  public T setRequired(boolean required) {
    removeRequiredIndicator();
    if (required) {
      addValidator(requiredValidator);
      if (this.showRequiredIndicator) {
        DominoUIConfig.CONFIG
            .getRequiredIndicatorRenderer()
            .appendRequiredIndicator((T) this, requiredIndicator);
      }
    } else {
      removeValidator(requiredValidator);
    }
    return (T) this;
  }

  private void removeRequiredIndicator() {
    DominoUIConfig.CONFIG
        .getRequiredIndicatorRenderer()
        .removeRequiredIndicator(this, requiredIndicator);
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
   *     wont change the spacing between the fields when an error message is shown.
   * @return same form element instance
   */
  public T setFixErrorsPosition(boolean fixErrorsPosition) {
    this.fixErrorsPosition = fixErrorsPosition;
    return (T) this;
  }

  /**
   * @return the {@link HTMLElement} that contains this field helper text element wrapped as {@link
   *     DominoElement}
   */
  protected abstract DominoElement<HTMLElement> getHelperContainer();

  /** @return the field {@link HTMLLabelElement} wrapped as {@link DominoElement} */
  public abstract DominoElement<HTMLLabelElement> getLabelElement();

  /**
   * @return the {@link HTMLElement} that contains the label text wrapped as {@link DominoElement}
   */
  public abstract DominoElement<HTMLElement> getLabelTextElement();

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

}
