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

import elemental2.dom.HTMLElement;
import elemental2.dom.HTMLFieldSetElement;

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

public abstract class AbstractFormElement<T extends AbstractFormElement<T, V>, V>
    extends BaseDominoElement<HTMLFieldSetElement, T> implements FormElement<T, V> , HasComponentConfig<FormsFieldsConfig>, FormsStyles {

  protected final FieldSetElement formElement;
  protected final  DivElement bodyElement;
  protected final LazyChild<LabelElement> labelElement;
  protected LazyChild<DominoElement<HTMLElement>> requiredElement;
  protected final DivElement wrapperElement;
  protected final LazyChild< DivElement> messagesWrapper;
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

  protected V defaultValue;
  private boolean showRequiredIndicator = true;

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
    messagesWrapper = LazyChild.of(div().addCss(dui_messages_wrapper), bodyElement);
    helperTextElement = LazyChild.of(span().addCss(dui_field_helper), messagesWrapper);
    errorElementSupplier =
        errorMessage -> span().addCss(dui_field_error).setTextContent(errorMessage);

    requiredValidator = new RequiredValidator<>(this);
    if(getConfig().isFixedLabelSpace()){
      labelElement.get();
    }
    init((T) this);
    setLabelFloatLeft(getConfig().isFormFieldFloatLabelLeft());
  }

  protected LazyChild<DominoElement<HTMLElement>> initRequiredIndicator() {
    return
        LazyChild.of(
            elementOf(getConfig().getRequiredIndicator().get())
                .addCss(dui_field_required_indicator),
                labelElement);
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
  public T appendChild(PrefixAddOn<?> addon) {
    wrapperElement.appendChild(elementOf(addon));
    return (T) this;
  }

  @Override
  public T appendChild(PostfixAddOn<?> addon) {
    wrapperElement.appendChild(elementOf(addon));
    return (T) this;
  }

  @Override
  public T appendChild(PrimaryAddOn<?> addon) {
    wrapperElement.appendChild(elementOf(addon).addCss(dui_add_on, dui_add_on_mandatory));
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

  public T setLabelFloatLeft(boolean floatLeft){
    addCss(BooleanCssClass.of(dui_form_label_float_left, floatLeft));
    return (T) this;
  }

  @Override
  public ValidationResult validate(T formElement) {
    if (!validationsPaused) {
      return doValidate();
    } else {
      return ValidationResult.valid();
    }
  }

  @Override
  public Set<Validator<T>> getValidators() {
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
    for (Validator<T> validator : getValidators()) {
      ValidationResult result = validator.isValid((T) this);
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
    getRequiredElement().initOrRemove(isRequired() && isShowRequiredIndicator());
    addOrRemoveValidator(requiredValidator, required);
    return (T) this;
  }

  public T setShowRequiredIndicator(boolean state){
    this.showRequiredIndicator = state;
    getRequiredElement().initOrRemove(isRequired() && isShowRequiredIndicator());
    return (T) this;
  }

  private LazyChild<DominoElement<HTMLElement>> getRequiredElement(){
    if(isNull(requiredElement)){
      requiredElement = initRequiredIndicator();
    }
    return requiredElement;
  }

  public boolean isShowRequiredIndicator(){
    return this.showRequiredIndicator;
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
    addCss(BooleanCssClass.of(dui_fixed_errors, fixErrorsPosition));
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

  public  DivElement getBodyElement() {
    return bodyElement;
  }

  public LabelElement getLabelElement() {
    return labelElement.get();
  }

  public  DivElement getWrapperElement() {
    return wrapperElement;
  }

  public  DivElement getMessagesWrapperElement() {
    return messagesWrapper.get();
  }

  public SpanElement getHelperTextElement() {
    return helperTextElement.get();
  }

  public T withBody(ChildHandler<T,  DivElement> handler) {
    handler.apply((T) this, bodyElement);
    return (T) this;
  }

  public T withLabel() {
    labelElement.get();
    return (T) this;
  }

  public T withLabel(ChildHandler<T, LabelElement> handler) {
    handler.apply((T) this, labelElement.get());
    return (T) this;
  }

  public T withWrapper(ChildHandler<T,  DivElement> handler) {
    handler.apply((T) this, wrapperElement);
    return (T) this;
  }

  public T withMessagesWrapper() {
    messagesWrapper.get();
    return (T) this;
  }

  public T withMessagesWrapper(ChildHandler<T, DivElement> handler) {
    handler.apply((T) this, messagesWrapper.get());
    return (T) this;
  }

  public T withHelperText() {
    helperTextElement.get();
    return (T) this;
  }

  public T withHelperText(ChildHandler<T, SpanElement> handler) {
    handler.apply((T) this, helperTextElement.get());
    return (T) this;
  }

  public LazyChild<DominoElement<HTMLElement>> requiredElement() {
    return requiredElement;
  }

  public LazyChild<DivElement> messagesWrapper() {
    return messagesWrapper;
  }

  public LazyChild<LabelElement> labelElement(){
    return labelElement;
  }

}
