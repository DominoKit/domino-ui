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

import elemental2.dom.DomGlobal;
import elemental2.dom.HTMLElement;
import elemental2.dom.HTMLInputElement;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;
import jsinterop.base.Js;
import org.dominokit.domino.ui.elements.DivElement;
import org.dominokit.domino.ui.elements.InputElement;
import org.dominokit.domino.ui.icons.Icons;
import org.dominokit.domino.ui.loaders.Loader;
import org.dominokit.domino.ui.loaders.LoaderEffect;
import org.dominokit.domino.ui.menu.AbstractMenuItem;
import org.dominokit.domino.ui.menu.Menu;
import org.dominokit.domino.ui.style.BooleanCssClass;
import org.dominokit.domino.ui.utils.*;

public abstract class AbstractSuggestBox<
        T, V, S extends Option<T>, C extends AbstractSuggestBox<T, V, S, C>>
    extends AbstractFormElement<AbstractSuggestBox<T, V, S, C>, V>
    implements HasInputElement<AbstractSuggestBox<T, V, S, C>, HTMLInputElement>,
        HasPlaceHolder<AbstractSuggestBox<T, V, S, C>> {

  protected Menu<T> optionsMenu;
  protected DivElement fieldInput;
  protected InputElement inputElement;

  protected final SuggestBoxStore<T, S> store;

  private final DivElement loaderElement;
  private Loader loader;

  private DelayedTextInput delayedTextInput;

  private final DelayedTextInput.DelayedAction delayedAction =
      () -> {
        if (isEmptyInputText()) {
          optionsMenu.close();
        } else {
          search();
        }
      };
  private boolean autoSelect = true;
  private int typeAheadDelay = 1000;

  public AbstractSuggestBox(SuggestBoxStore<T, S> store) {
    this.store = store;
    addCss(dui_form_select);
    wrapperElement.appendChild(
        fieldInput =
            div()
                .addCss(dui_field_input)
                .appendChild(inputElement = input(getType()).addCss(dui_field_input)));

    delayedTextInput =
        DelayedTextInput.create(inputElement.element(), getTypeAheadDelay(), delayedAction);

    optionsMenu =
        Menu.<T>create()
            .setMenuAppendTarget(getWrapperElement().element())
            .setTargetElement(getWrapperElement())
            .setAutoOpen(false)
            .setFitToTargetWidth(true)
            .addCollapseListener(component -> focus())
            .addOnAddItemHandler((menu, menuItem) -> ((S) menuItem).bindValueTarget(fieldInput))
            .addSelectionListener(
                (source, selection) -> {
                  source.ifPresent(
                      suggestion -> {
                        onOptionSelected((S) suggestion);
                        getInputElement().element().value = null;
                      });
                });

    addPrimaryAddOn(loaderElement = div().addCss(dui_w_12, dui_h_6));
    loader =
        Loader.create(loaderElement, LoaderEffect.FACEBOOK)
            .setLoadingTextPosition(Loader.LoadingTextPosition.TOP)
            .setRemoveLoadingText(true);

    addPrimaryAddOn(
        Icons.ALL
            .delete_mdi()
            .addCss(dui_form_select_clear)
            .clickable()
            .addClickListener(
                evt -> {
                  evt.stopPropagation();
                  clearValue(false);
                }));

    getInputElement().onKeyDown(keyEvents -> {
      keyEvents.onArrowDown(
              evt -> {
                optionsMenu.focus();
                evt.preventDefault();
              })
              .onArrowUp(
                      evt -> {
                        optionsMenu.focus();
                        evt.preventDefault();
                      })
              .onEscape(
                      evt -> {
                        focus();
                        evt.preventDefault();
                      })
              .onEnter(
                      evt -> {
                        if (optionsMenu.isOpened() && !optionsMenu.getMenuItems().isEmpty()) {
                          evt.stopPropagation();
                          evt.preventDefault();
                          if (isAutoSelect()) {
                            optionsMenu.getMenuItems().get(0).select();
                            optionsMenu.close();
                          } else {
                            optionsMenu.focus();
                          }
                        }
                      })
              .onTab(
                      evt -> {
                        if (optionsMenu.isOpened()) {
                          evt.stopPropagation();
                          evt.preventDefault();
                          optionsMenu.focus();
                        }
                      })
              .onBackspace(
                      evt -> {
                        if (!isReadOnly() && !isDisabled()) {
                          if (isNull(getInputStringValue()) || getInputStringValue().isEmpty()) {
                            evt.stopPropagation();
                            evt.preventDefault();
                            onBackspace();
                          }
                        }
                      });
    });
  }

  protected abstract void onBackspace();

  protected abstract void onOptionSelected(S suggestion);

  public boolean isAutoSelect() {
    return this.autoSelect;
  }

  public C setAutoSelect(boolean autoSelect) {
    this.autoSelect = autoSelect;
    return (C) this;
  }

  public int getTypeAheadDelay() {
    return typeAheadDelay;
  }

  public void setTypeAheadDelay(int typeAheadDelayInMillis) {
    this.typeAheadDelay = typeAheadDelayInMillis;
    this.delayedTextInput.setDelay(typeAheadDelayInMillis);
  }

  private void search() {
    if (store != null) {
      loader.start();
      optionsMenu.removeAll();
      optionsMenu.close();
      store.filter(
          getInputStringValue(),
          suggestions -> {
            optionsMenu.removeAll();

            if (suggestions.isEmpty()) {
              applyMissingEntry(getInputStringValue());
            }

            suggestions.forEach(
                suggestion -> {
                  optionsMenu.clearSelection(true);
                  suggestion.highlight(getInputStringValue());
                  optionsMenu.appendChild(suggestion);
                });
            if (!suggestions.isEmpty()) {
              optionsMenu.open(false);
            }
            loader.stop();
          });
    }
  }

  private boolean applyMissingEntry(String value) {
    SuggestBoxStore.MissingEntryProvider<T, S> messingEntryProvider =
        store.getMessingEntryProvider();
    Optional<S> messingSuggestion = messingEntryProvider.getMessingSuggestion(value);
    return applyMissing(messingSuggestion);
  }

  private boolean applyMissing(Optional<S> missingOption) {
    if (missingOption.isPresent()) {
      S option = missingOption.get();
      option.bindValueTarget(fieldInput);
      onBeforeApplyMissingOption(option);
      applyOptionValue(option);
      return true;
    }
    return false;
  }

  protected void onBeforeApplyMissingOption(S option) {}

  protected void applyOptionValue(S option) {
    onApplyMissingOption(option);
    option.select();
    getInputElement().element().value = null;
  }

  public abstract void onApplyMissingOption(S option);

  protected abstract C clearValue(boolean silent);

  @Override
  public String getPlaceholder() {
    return getInputElement().getAttribute("placeholder");
  }

  @Override
  public C setPlaceholder(String placeholder) {
    getInputElement().setAttribute("placeholder", placeholder);
    return (C) this;
  }

  @Override
  public DominoElement<HTMLInputElement> getInputElement() {
    return inputElement.toDominoElement();
  }

  @Override
  public String getStringValue() {
    return optionsMenu.getSelection().stream()
        .map(option -> String.valueOf(option.getValue()))
        .collect(Collectors.joining(","));
  }

  private String getInputStringValue() {
    return getInputElement().element().value;
  }

  @Override
  public C focus() {
    inputElement.element().focus();
    return (C) this;
  }

  @Override
  public C unfocus() {
    inputElement.element().blur();
    return (C) this;
  }

  @Override
  public boolean isFocused() {
    if (nonNull(DomGlobal.document.activeElement)) {
      String dominoId =
          elementOf(Js.<HTMLElement>uncheckedCast(DomGlobal.document.activeElement))
              .getDominoId();
      return nonNull(formElement.querySelector("[domino-uuid=\"" + dominoId + "\"]"));
    }
    return false;
  }

  @Override
  public boolean isEmpty() {
    return optionsMenu.getSelection().isEmpty();
  }

  private boolean isEmptyInputText() {
    String value = getInputElement().element().value;
    return isNull(value) || value.trim().isEmpty();
  }

  @Override
  public boolean isEmptyIgnoreSpaces() {
    return isEmpty();
  }

  @Override
  public boolean isEnabled() {
    return !getInputElement().isDisabled() && super.isEnabled();
  }

  @Override
  public C clear() {
    return clear(false);
  }

  @Override
  public C clear(boolean silent) {
    return clearValue(silent);
  }

  @Override
  public AutoValidator createAutoValidator(ApplyFunction autoValidate) {
    return new SuggestAutoValidator<>((C) this, autoValidate);
  }

  @Override
  public C triggerChangeListeners(V oldValue, V newValue) {
    getChangeListeners()
        .forEach(changeListener -> changeListener.onValueChanged(oldValue, newValue));
    return (C) this;
  }

  @Override
  public C triggerClearListeners(V oldValue) {
    getClearListeners().forEach(clearListener -> clearListener.onValueCleared(oldValue));
    return (C) this;
  }

  @Override
  public String getName() {
    return getInputElement().element().name;
  }

  @Override
  public C setName(String name) {
    getInputElement().element().name = name;
    return (C) this;
  }

  @Override
  public String getType() {
    return "text";
  }

  @Override
  public C withValue(V value) {
    return withValue(value, isChangeListenersPaused());
  }

  @Override
  public C withValue(V value, boolean silent) {
    V oldValue = getValue();
    if (!Objects.equals(value, oldValue)) {
      doSetValue(value);
      if (!silent) {
        triggerChangeListeners(oldValue, getValue());
      }
    }
    autoValidate();
    return (C) this;
  }

  // Should be abstract
  protected abstract void doSetValue(V value);

  @Override
  public void setValue(V value) {
    withValue(value);
  }

  public C setClearable(boolean clearable) {
    addCss(BooleanCssClass.of(dui_clearable, clearable));
    return (C) this;
  }

  public boolean isClearable() {
    return containsCss(dui_clearable.getCssClass());
  }

  public C setAutoCloseOnSelect(boolean autoClose) {
    optionsMenu.setAutoCloseOnSelect(autoClose);
    return (C) this;
  }

  public boolean isAutoCloseOnSelect() {
    return optionsMenu.isAutoCloseOnSelect();
  }

  public Menu<T> getOptionsMenu() {
    return optionsMenu;
  }

  public C withOptionsMenu(ChildHandler<C, Menu<T>> handler) {
    handler.apply((C) this, optionsMenu);
    return (C) this;
  }

  public interface SuggestValueRenderer<
      T, V, S extends Option<T>, C extends AbstractSuggestBox<T, V, S, C>> {
    HTMLElement element(C select, Option<T> option);
  }

  private static class SuggestAutoValidator<
          T, V, S extends Option<T>, C extends AbstractSuggestBox<T, V, S, C>>
      extends AutoValidator {

    private C select;
    private HasSelectionListeners.SelectionListener<
            AbstractMenuItem<T, ?>, List<AbstractMenuItem<T, ?>>>
        listener;

    public SuggestAutoValidator(C select, ApplyFunction autoValidate) {
      super(autoValidate);
      this.select = select;
    }

    /** {@inheritDoc} */
    @Override
    public void attach() {
      listener = (source, selection) -> autoValidate.apply();
      select.getOptionsMenu().addSelectionListener(listener);
    }

    /** {@inheritDoc} */
    @Override
    public void remove() {
      select.getOptionsMenu().removeSelectionListener(listener);
    }
  }
}
