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
import static org.dominokit.domino.ui.forms.FormsStyles.*;

import elemental2.dom.HTMLDivElement;
import elemental2.dom.HTMLElement;
import elemental2.dom.HTMLFieldSetElement;
import elemental2.dom.HTMLLabelElement;
import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;
import org.dominokit.domino.ui.forms.validations.RequiredValidator;
import org.dominokit.domino.ui.forms.validations.ValidationResult;
import org.dominokit.domino.ui.i18n.FormsLabels;
import org.dominokit.domino.ui.style.BooleanCssClass;
import org.dominokit.domino.ui.utils.*;
import org.gwtproject.editor.client.EditorError;
import org.jboss.elemento.IsElement;

public abstract class AbstractFormElement<T extends AbstractFormElement<T, V>, V>
    extends BaseDominoElement<HTMLFieldSetElement, T> implements FormElement<T, V> {

  protected final DominoElement<HTMLFieldSetElement> formElement;
  protected final DominoElement<HTMLDivElement> bodyElement;
  protected final LazyChild<DominoElement<HTMLLabelElement>> labelElement;
  protected final LazyChild<DominoElement<HTMLElement>> requiredElement;
  protected final DominoElement<HTMLDivElement> wrapperElement;
  protected final LazyChild<DominoElement<HTMLDivElement>> messagesWrapper;
  protected final LazyChild<DominoElement<HTMLElement>> helperTextElement;
  protected Function<String, DominoElement<HTMLElement>> errorElementSupplier;

  protected Set<Validator> validators = new LinkedHashSet<>();
  protected AutoValidator autoValidator;
  protected final List<String> errors = new ArrayList<>();
  protected String requiredErrorMessage;

  protected final FormsLabels labels = DominoUIConfig.CONFIG.getDominoUILabels();
  protected final RequiredValidator requiredValidator;
  protected Set<ChangeListener<? super V>> changeListeners = new LinkedHashSet<>();
  protected Set<ClearListener<? super V>> clearListeners = new LinkedHashSet<>();
  private boolean autoValidate = false;
  private boolean required = false;
  private boolean changeListenersPaused = false;
  private boolean clearListenersPaused = false;
  private boolean validationsPaused = false;
  private boolean focusValidationPaused = false;
  private boolean emptyAsNull;

  protected V defaultValue;

  public AbstractFormElement() {
    formElement =
        DominoElement.fieldSet()
            .addCss(FORM_FIELD)
            .appendChild(
                bodyElement =
                    DominoElement.div()
                        .addCss(FIELD_BODY)
                        .appendChild(wrapperElement = DominoElement.div().addCss(INPUT_WRAPPER)));
    labelElement = LazyChild.of(DominoElement.label().addCss(FIELD_LABEL), formElement);
    messagesWrapper = LazyChild.of(DominoElement.div().addCss(MESSAGES_WRAPPER), bodyElement);
    helperTextElement = LazyChild.of(DominoElement.span().addCss(FIELD_HELPER), messagesWrapper);
    errorElementSupplier =
        errorMessage -> DominoElement.span().addCss(FIELD_ERROR).setTextContent(errorMessage);
    requiredElement =
        LazyChild.of(
            DominoElement.of(DominoUIConfig.CONFIG.getRequiredIndicator().get())
                .addCss(FIELD_REQUIRED_INDICATOR),
            labelElement);
    requiredValidator = new RequiredValidator(this);
    init((T) this);
  }

  @Override
  public HTMLFieldSetElement element() {
    return formElement.element();
  }

  @Override
  public T labelForId(String id) {
    labelElement.doOnce(() -> labelElement.element().setAttribute("for", id));
    return (T) this;
  }

  @Override
  public T groupBy(FieldsGrouping fieldsGrouping) {
    fieldsGrouping.addFormElement(this);
    return (T) this;
  }

  @Override
  public T ungroup(FieldsGrouping fieldsGrouping) {
    fieldsGrouping.removeFormElement(this);
    return (T) this;
  }

  @Override
  public <E extends HTMLElement, C extends IsElement<E>> T addLeftAddOn(C addon) {
    wrapperElement.appendChild(DominoElement.of(addon).addCss(ADD_ON, ADD_ON_LEFT));
    return (T) this;
  }

  @Override
  public <E extends HTMLElement, C extends IsElement<E>> T addRightAddOn(C addon) {
    wrapperElement.appendChild(DominoElement.of(addon).addCss(ADD_ON, ADD_ON_RIGHT));
    return (T) this;
  }

  @Override
  public <E extends HTMLElement, C extends IsElement<E>> T addPrimaryAddOn(C addon) {
    wrapperElement.appendChild(DominoElement.of(addon).addCss(ADD_ON, ADD_ON_MANDATORY));
    return (T) this;
  }

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

  @Override
  public boolean isAutoValidation() {
    return autoValidate;
  }

  @Override
  public T autoValidate() {
    if (isAutoValidation()) {
      validate();
    }
    return (T) this;
  }

  @Override
  public T pauseValidations() {
    this.validationsPaused = true;
    return (T) this;
  }

  @Override
  public T resumeValidations() {
    this.validationsPaused = false;
    return (T) this;
  }

  @Override
  public boolean isValidationsPaused() {
    return validationsPaused;
  }

  @Override
  public T togglePauseValidations(boolean toggle) {
    this.validationsPaused = toggle;
    return (T) this;
  }

  @Override
  public T pauseFocusValidations() {
    this.focusValidationPaused = true;
    return (T) this;
  }

  @Override
  public T resumeFocusValidations() {
    this.focusValidationPaused = false;
    return (T) this;
  }

  @Override
  public T togglePauseFocusValidations(boolean toggle) {
    this.focusValidationPaused = toggle;
    return (T) this;
  }

  @Override
  public boolean isFocusValidationsPaused() {
    return this.focusValidationPaused;
  }

  @Override
  public T setHelperText(String helperText) {
    helperTextElement.get().setTextContent(helperText);
    return (T) this;
  }

  @Override
  public String getHelperText() {
    if (helperTextElement.isInitialized()) {
      return helperTextElement.get().getTextContent();
    }
    return "";
  }

  @Override
  public T setLabel(String label) {
    labelElement.get().setTextContent(label);
    return (T) this;
  }

  @Override
  public String getLabel() {
    if (labelElement.isInitialized()) {
      return labelElement.get().getTextContent();
    }
    return "";
  }

  @Override
  public ValidationResult validate() {
    if (!validationsPaused) {
      return doValidate();
    } else {
      return ValidationResult.valid();
    }
  }

  @Override
  public Set<Validator> getValidators() {
    return validators;
  }

  /**
   * Runs all the validated over the FormElement if it is enabled and fail-fast
   *
   * @return the {@link ValidationResult}
   */
  protected ValidationResult doValidate() {
    element.clearInvalid();
    if (!element.isEnabled()) {
      return ValidationResult.valid();
    }
    Set<Validator> validators1 = getValidators();
    for (Validator validator : validators1) {
      ValidationResult result = validator.isValid();
      if (!result.isValid()) {
        element.invalidate(result.getErrorMessage());
        return result;
      }
    }
    return ValidationResult.valid();
  }

  @Override
  public T invalidate(String errorMessage) {
    invalidate(Collections.singletonList(errorMessage));
    return (T) this;
  }

  @Override
  public T invalidate(List<String> errorMessages) {
    removeErrors();
    errorMessages.forEach(
        message -> {
          this.errors.add(message);
          messagesWrapper.get().appendChild(errorElementSupplier.apply(message));
        });

    if (!errorMessages.isEmpty()) {
      formElement.addCss(FIELD_INVALID);
    }

    return (T) this;
  }

  private void removeErrors() {
    errors.clear();
    messagesWrapper
        .get()
        .querySelectorAll("." + FIELD_ERROR.getCssClass())
        .forEach(BaseDominoElement::remove);
    FIELD_INVALID.remove(this);
  }

  @Override
  public List<String> getErrors() {
    return errors;
  }

  @Override
  public T clearInvalid() {
    removeErrors();
    return (T) this;
  }

  @Override
  public T setRequired(boolean required) {
    this.required = required;
    requiredElement.initOrRemove(required);
    addOrRemoveValidator(requiredValidator, required);
    return (T) this;
  }

  @Override
  public T setRequired(boolean required, String message) {
    setRequired(required);
    setRequiredErrorMessage(message);
    return (T) this;
  }

  @Override
  public boolean isRequired() {
    return required;
  }

  @Override
  public T setRequiredErrorMessage(String requiredErrorMessage) {
    this.requiredErrorMessage = requiredErrorMessage;
    return (T) this;
  }

  @Override
  public String getRequiredErrorMessage() {
    return isNull(requiredErrorMessage) ? labels.requiredErrorMessage() : requiredErrorMessage;
  }

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

  @Override
  public T fixErrorsPosition(boolean fixErrorsPosition) {
    addCss(BooleanCssClass.of(FIXED_ERRORS, fixErrorsPosition));
    return (T) this;
  }

  @Override
  public T pauseChangeListeners() {
    this.changeListenersPaused = true;
    return (T) this;
  }

  @Override
  public T resumeChangeListeners() {
    this.changeListenersPaused = false;
    return (T) this;
  }

  @Override
  public Set<ChangeListener<? super V>> getChangeListeners() {
    return changeListeners;
  }

  @Override
  public boolean isChangeListenersPaused() {
    return changeListenersPaused;
  }

  @Override
  public T togglePauseChangeListeners(boolean toggle) {
    this.changeListenersPaused = toggle;
    return (T) this;
  }

  @Override
  public T pauseClearListeners() {
    this.clearListenersPaused = true;
    return (T) this;
  }

  @Override
  public T resumeClearListeners() {
    this.clearListenersPaused = false;
    return (T) this;
  }

  @Override
  public T togglePauseClearListeners(boolean toggle) {
    this.clearListenersPaused = toggle;
    return (T) this;
  }

  @Override
  public Set<ClearListener<? super V>> getClearListeners() {
    return clearListeners;
  }

  @Override
  public boolean isClearListenersPaused() {
    return clearListenersPaused;
  }

  /**
   * @param emptyAsNull boolean, if true empty value will be considered null otherwise its normal
   *     empty String
   * @return same TextBox instance
   */
  public T setEmptyAsNull(boolean emptyAsNull) {
    this.emptyAsNull = emptyAsNull;
    return (T) this;
  }

  /** @return boolean, true is {@link #setEmptyAsNull(boolean)} */
  public boolean isEmptyAsNull() {
    return emptyAsNull;
  }

  @Override
  public T setDefaultValue(V defaultValue) {
    this.defaultValue = defaultValue;
    return (T) this;
  }

  @Override
  public V getDefaultValue() {
    return defaultValue;
  }

  public DominoElement<HTMLDivElement> getBodyElement() {
    return bodyElement;
  }

  public DominoElement<HTMLLabelElement> getLabelElement() {
    return labelElement.get();
  }

  public DominoElement<HTMLDivElement> getWrapperElement() {
    return wrapperElement;
  }

  public DominoElement<HTMLDivElement> getMessagesWrapperElement() {
    return messagesWrapper.get();
  }

  public DominoElement<HTMLElement> getHelperTextElement() {
    return helperTextElement.get();
  }

  public T withBodyElement(ChildHandler<T, DominoElement<HTMLDivElement>> handler) {
    handler.apply((T) this, bodyElement);
    return (T) this;
  }

  public T withLabelElement() {
    labelElement.get();
    return (T) this;
  }

  public T withLabelElement(ChildHandler<T, DominoElement<HTMLLabelElement>> handler) {
    handler.apply((T) this, labelElement.get());
    return (T) this;
  }

  public T withWrapperElement(ChildHandler<T, DominoElement<HTMLDivElement>> handler) {
    handler.apply((T) this, wrapperElement);
    return (T) this;
  }

  public T withMessagesWrapperElement() {
    messagesWrapper.get();
    return (T) this;
  }

  public T withMessagesWrapperElement(ChildHandler<T, DominoElement<HTMLDivElement>> handler) {
    handler.apply((T) this, messagesWrapper.get());
    return (T) this;
  }

  public T withHelperTextElement() {
    helperTextElement.get();
    return (T) this;
  }

  public T withHelperTextElement(ChildHandler<T, DominoElement<HTMLElement>> handler) {
    handler.apply((T) this, helperTextElement.get());
    return (T) this;
  }
}
