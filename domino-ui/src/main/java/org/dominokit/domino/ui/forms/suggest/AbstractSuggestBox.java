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
package org.dominokit.domino.ui.forms.suggest;

import static java.util.Objects.isNull;
import static java.util.Objects.nonNull;
import static org.dominokit.domino.ui.utils.Domino.*;

import elemental2.dom.DomGlobal;
import elemental2.dom.HTMLElement;
import elemental2.dom.HTMLInputElement;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import jsinterop.base.Js;
import org.dominokit.domino.ui.IsElement;
import org.dominokit.domino.ui.elements.DivElement;
import org.dominokit.domino.ui.elements.InputElement;
import org.dominokit.domino.ui.forms.AbstractFormElement;
import org.dominokit.domino.ui.forms.AutoValidator;
import org.dominokit.domino.ui.forms.HasInputElement;
import org.dominokit.domino.ui.icons.lib.Icons;
import org.dominokit.domino.ui.loaders.Loader;
import org.dominokit.domino.ui.loaders.LoaderEffect;
import org.dominokit.domino.ui.menu.AbstractMenuItem;
import org.dominokit.domino.ui.menu.Menu;
import org.dominokit.domino.ui.menu.direction.DropDirection;
import org.dominokit.domino.ui.style.BooleanCssClass;
import org.dominokit.domino.ui.utils.*;

/**
 * An abstract base class for suggest box elements that provides common functionality and UI
 * components.
 *
 * <p>This class allows the creation of suggest boxes for selecting options from a list of
 * suggestions. It provides features like auto-suggest, delayed text input, and a drop-down menu for
 * selecting options.
 *
 * <p>Usage Example:
 *
 * <pre>
 * // Create a suggest box with a custom SuggestionsStore
 * SuggestionsStore<MyData, IsElement<?>> suggestionsStore = createCustomSuggestionsStore();
 * MySuggestBox suggestBox = new MySuggestBox(suggestionsStore);
 * suggestBox.setPlaceholder("Search..."); suggestBox.setAutoSelect(true);
 * suggestBox.setTypeAheadDelay(500); suggestBox.addSelectionListener(selectedOption -> { MyData
 * selectedData = selectedOption.getValue(); // Handle the selected data });
 * </pre>
 *
 * @param <T> The data type of the suggest options.
 * @param <V> The value type of the suggest box.
 * @param <E> The type of the suggest box's element, usually an {@link IsElement}.
 * @param <O> The type of options that can be selected in the suggest box.
 * @param <C> The concrete suggest box implementation type.
 */
public abstract class AbstractSuggestBox<
        T,
        V,
        E extends IsElement<?>,
        O extends Option<T, E, O>,
        C extends AbstractSuggestBox<T, V, E, O, C>>
    extends AbstractFormElement<C, V>
    implements HasInputElement<C, HTMLInputElement>, HasPlaceHolder<C>, HasSuggestOptions<T, E, O> {

  /** The drop-down menu that displays the suggestion options. */
  protected Menu<T> optionsMenu;

  /** The element that contains the input field. */
  protected DivElement fieldInput;

  /** The input element for user input. */
  protected InputElement inputElement;

  /** The store that provides suggestions for the suggest box. */
  protected final SuggestionsStore<T, E, O> store;

  /** The loader element used to display loading indicators. */
  private final PrimaryAddOn<HTMLElement> loaderElement;

  /** The loader instance for displaying loading indicators. */
  private Loader loader;

  /** The delayed text input used to provide type-ahead functionality. */
  private DelayedTextInput delayedTextInput;

  /** The action to perform when text input is delayed. */
  private final DelayedTextInput.DelayedAction delayedAction =
      () -> {
        if (isEmptyInputText()) {
          optionsMenu.close();
        } else {
          search();
        }
      };

  /** Flag indicating whether auto-select is enabled. */
  private boolean autoSelect = true;

  /** The type-ahead delay in milliseconds. */
  private int typeAheadDelay = 1000;

  /**
   * Creates an instance of {@code AbstractSuggestBox} with the specified suggestions store.
   *
   * @param store The suggestions store providing data for the suggest box.
   */
  public AbstractSuggestBox(SuggestionsStore<T, E, O> store) {
    this.store = store;
    addCss(dui_form_select);
    wrapperElement.appendChild(
        fieldInput =
            div()
                .addCss(dui_field_input)
                .appendChild(
                    inputElement = input(getType()).addCss(dui_field_input, dui_flex_basis_24)));

    delayedTextInput =
        DelayedTextInput.create(inputElement.element(), getTypeAheadDelay(), delayedAction);

    optionsMenu =
        Menu.<T>create()
            .setMenuAppendTarget(getWrapperElement().element())
            .setOpenMenuCondition(menu -> !(isReadOnly() || isDisabled()))
            .setTargetElement(getWrapperElement())
            .setAutoOpen(false)
            .setFitToTargetWidth(true)
            .setDropDirection(DropDirection.BEST_MIDDLE_UP_DOWN)
            .addCloseListener(component -> focus())
            .addSelectionListener(
                (source, selection) -> {
                  source
                      .flatMap(OptionMeta::<T, E, O>get)
                      .ifPresent(meta -> onOptionSelected(meta.getOption()));
                  onAfterOptionSelected();
                })
            .addDeselectionListener(
                (source, selection) ->
                    source
                        .flatMap(OptionMeta::<T, E, O>get)
                        .ifPresent(meta -> onOptionDeselected(meta.getOption())));

    appendChild(loaderElement = PrimaryAddOn.of(div().addCss(dui_w_12, dui_h_6).element()));
    loader =
        Loader.create(loaderElement, LoaderEffect.FACEBOOK)
            .setLoadingTextPosition(Loader.LoadingTextPosition.TOP)
            .setRemoveLoadingText(true);

    onAttached(
        mutationRecord -> {
          optionsMenu.setTargetElement(getWrapperElement());
        });

    appendChild(
        PrimaryAddOn.of(
            Icons.delete()
                .addCss(dui_form_select_clear)
                .clickable()
                .addClickListener(
                    evt -> {
                      evt.stopPropagation();
                      clearValue(false);
                    })));

    getInputElement()
        .onKeyDown(
            keyEvents -> {
              keyEvents
                  .onArrowDown(
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

  /**
   * This method is called after an option has been selected. It clears the value of the input
   * element. Use this method to perform any necessary actions after an option is selected.
   */
  protected void onAfterOptionSelected() {
    getInputElement().element().value = null;
  }

  /**
   * An abstract method that needs to be implemented by concrete subclasses. It is called when the
   * user presses the backspace key in the input field. Subclasses should define their own behavior
   * when backspace is pressed.
   */
  protected abstract void onBackspace();

  /**
   * Checks if auto-select is enabled.
   *
   * @return {@code true} if auto-select is enabled, {@code false} otherwise.
   */
  public boolean isAutoSelect() {
    return this.autoSelect;
  }

  /**
   * Sets whether auto-select is enabled or disabled.
   *
   * @param autoSelect {@code true} to enable auto-select, {@code false} to disable it.
   * @return The concrete suggest box instance.
   */
  public C setAutoSelect(boolean autoSelect) {
    this.autoSelect = autoSelect;
    return (C) this;
  }

  /**
   * Gets the type-ahead delay in milliseconds.
   *
   * @return The type-ahead delay in milliseconds.
   */
  public int getTypeAheadDelay() {
    return typeAheadDelay;
  }

  /**
   * Sets the type-ahead delay in milliseconds.
   *
   * @param typeAheadDelayInMillis The type-ahead delay in milliseconds.
   */
  public void setTypeAheadDelay(int typeAheadDelayInMillis) {
    this.typeAheadDelay = typeAheadDelayInMillis;
    this.delayedTextInput.setDelay(typeAheadDelayInMillis);
  }

  /**
   * Performs a search based on the current input value. This method is responsible for filtering
   * the suggestions from the store, highlighting the matched portions, and updating the options
   * menu.
   */
  private void search() {
    if (store != null) {
      loader.start();
      optionsMenu.removeAll();
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
                  optionsMenu.appendChild(suggestion.getMenuItem());
                });
            if (!suggestions.isEmpty()) {
              openOptionsMenu();
            }
            loader.stop();
          });
    }
  }

  /**
   * Opens the options menu. This method is called when suggestions are available and should be
   * displayed.
   */
  private void openOptionsMenu() {
    optionsMenu.open(false);
  }

  /**
   * Applies a missing entry suggestion for the given value. It checks if a suggestion is available
   * for the input value and applies it if found.
   *
   * @param value The input value for which a suggestion is needed.
   * @return {@code true} if a missing entry was applied, {@code false} otherwise.
   */
  protected boolean applyMissingEntry(String value) {
    SuggestionsStore.MissingEntryProvider<T, E, O> messingEntryProvider =
        store.getMessingEntryProvider();
    Optional<O> messingSuggestion = messingEntryProvider.getMessingSuggestion(value);
    return applyMissing(messingSuggestion);
  }

  /**
   * Applies a missing suggestion if it's present.
   *
   * @param missingOption An optional missing suggestion to apply.
   * @return {@code true} if a missing suggestion was applied, {@code false} otherwise.
   */
  private boolean applyMissing(Optional<O> missingOption) {
    if (missingOption.isPresent()) {
      O option = missingOption.get();
      onBeforeApplyMissingOption(option);
      applyOptionValue(option);
      return true;
    }
    return false;
  }

  /**
   * A hook method called before applying a missing suggestion option.
   *
   * @param option The missing suggestion option.
   */
  protected void onBeforeApplyMissingOption(O option) {}

  /**
   * Applies the selected option's value. This method is used to handle the selection of an option.
   * It triggers the option selected event and performs any necessary actions after an option is
   * selected.
   *
   * @param option The selected option.
   */
  protected void applyOptionValue(O option) {
    onOptionSelected(option);
    onAfterOptionSelected();
  }

  /**
   * Clears the value of the suggest box. Implementations of this method should provide the
   * functionality to clear the current value of the suggest box.
   *
   * @param silent {@code true} to clear the value silently, {@code false} to trigger change
   *     listeners.
   * @return The suggest box instance after clearing the value.
   */
  protected abstract C clearValue(boolean silent);

  /**
   * Gets the placeholder text of the input element.
   *
   * @return The placeholder text.
   */
  @Override
  public String getPlaceholder() {
    return getInputElement().getAttribute("placeholder");
  }

  /**
   * Sets the placeholder text of the input element.
   *
   * @param placeholder The placeholder text to set.
   * @return The suggest box instance.
   */
  @Override
  public C setPlaceholder(String placeholder) {
    getInputElement().setAttribute("placeholder", placeholder);
    return (C) this;
  }

  /**
   * Gets the input element of the suggest box as a DominoElement.
   *
   * @return The input element.
   */
  @Override
  public DominoElement<HTMLInputElement> getInputElement() {
    return inputElement.toDominoElement();
  }

  /**
   * Gets the current input string value from the input element.
   *
   * @return The input string value.
   */
  private String getInputStringValue() {
    return getInputElement().element().value;
  }

  /**
   * Focuses on the suggest box input element.
   *
   * @return The suggest box instance.
   */
  @Override
  public C focus() {
    inputElement.element().focus();
    return (C) this;
  }

  /**
   * Unfocuses (blurs) the suggest box input element.
   *
   * @return The suggest box instance.
   */
  @Override
  public C unfocus() {
    inputElement.element().blur();
    return (C) this;
  }

  /**
   * Checks if the suggest box is currently focused.
   *
   * @return {@code true} if the suggest box is focused, {@code false} otherwise.
   */
  @Override
  public boolean isFocused() {
    if (nonNull(DomGlobal.document.activeElement)) {
      String dominoId =
          elementOf(Js.<HTMLElement>uncheckedCast(DomGlobal.document.activeElement)).getDominoId();
      return nonNull(formElement.querySelector("[domino-uuid=\"" + dominoId + "\"]"));
    }
    return false;
  }

  /**
   * Checks if the suggest box is empty, meaning there are no selected options.
   *
   * @return {@code true} if the suggest box is empty, {@code false} otherwise.
   */
  @Override
  public boolean isEmpty() {
    return optionsMenu.getSelection().isEmpty();
  }

  /**
   * Checks if the input text of the suggest box is empty (ignoring spaces).
   *
   * @return {@code true} if the input text is empty or contains only spaces, {@code false}
   *     otherwise.
   */
  private boolean isEmptyInputText() {
    String value = getInputElement().element().value;
    return isNull(value) || value.trim().isEmpty();
  }

  /**
   * Checks if the suggest box is empty (ignoring spaces).
   *
   * @return {@code true} if the suggest box is empty or contains only spaces, {@code false}
   *     otherwise.
   */
  @Override
  public boolean isEmptyIgnoreSpaces() {
    return isEmpty();
  }

  /**
   * Checks if the suggest box is enabled.
   *
   * @return {@code true} if the suggest box is enabled, {@code false} if disabled.
   */
  @Override
  public boolean isEnabled() {
    return !getInputElement().isDisabled() && super.isEnabled();
  }

  /**
   * Clears the current value of the suggest box. This method is used to clear the selected options.
   *
   * @return The suggest box instance after clearing the value.
   */
  @Override
  public C clear() {
    return clear(false);
  }

  /**
   * Clears the current value of the suggest box. This method is used to clear the selected options.
   *
   * @param silent {@code true} to clear the value silently, {@code false} to trigger change
   *     listeners.
   * @return The suggest box instance after clearing the value.
   */
  @Override
  public C clear(boolean silent) {
    return clearValue(silent);
  }

  /**
   * Creates an auto-validator for the suggest box.
   *
   * @param autoValidate The auto-validation function to apply.
   * @return An {@link AutoValidator} instance.
   */
  @Override
  public AutoValidator createAutoValidator(ApplyFunction autoValidate) {
    return new SuggestAutoValidator<>((C) this, autoValidate);
  }

  /**
   * Triggers change listeners with the old and new values.
   *
   * @param oldValue The old value before the change.
   * @param newValue The new value after the change.
   * @return The suggest box instance.
   */
  @Override
  public C triggerChangeListeners(V oldValue, V newValue) {
    getChangeListeners()
        .forEach(changeListener -> changeListener.onValueChanged(oldValue, newValue));
    return (C) this;
  }

  /**
   * Triggers clear listeners with the old value before clearing.
   *
   * @param oldValue The old value before clearing.
   * @return The suggest box instance.
   */
  @Override
  public C triggerClearListeners(V oldValue) {
    getClearListeners().forEach(clearListener -> clearListener.onValueCleared(oldValue));
    return (C) this;
  }

  /**
   * Gets the name of the suggest box input element.
   *
   * @return The name of the input element.
   */
  @Override
  public String getName() {
    return getInputElement().element().name;
  }

  /**
   * Sets the name of the suggest box input element.
   *
   * @param name The name to set for the input element.
   * @return The suggest box instance after setting the name.
   */
  @Override
  public C setName(String name) {
    getInputElement().element().name = name;
    return (C) this;
  }

  /**
   * Gets the type of the suggest box input element. It always returns "text" since this is a text
   * input.
   *
   * @return The input element type ("text").
   */
  @Override
  public String getType() {
    return "text";
  }

  /**
   * Sets the value of the suggest box.
   *
   * @param value The value to set.
   * @return The suggest box instance after setting the value.
   */
  @Override
  public C withValue(V value) {
    return withValue(value, isChangeListenersPaused());
  }

  /**
   * Sets the value of the suggest box.
   *
   * @param value The value to set.
   * @param silent {@code true} to set the value silently, {@code false} to trigger change
   *     listeners.
   * @return The suggest box instance after setting the value.
   */
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

  /**
   * Sets the value of the suggest box.
   *
   * @param value The value to set.
   */
  protected abstract void doSetValue(V value);

  /**
   * Sets the value of the suggest box.
   *
   * @param value The value to set.
   */
  @Override
  public void setValue(V value) {
    withValue(value);
  }

  /**
   * Sets whether the suggest box is clearable or not.
   *
   * @param clearable {@code true} to make the suggest box clearable, {@code false} otherwise.
   * @return The suggest box instance after setting clearability.
   */
  public C setClearable(boolean clearable) {
    addCss(BooleanCssClass.of(dui_clearable, clearable));
    return (C) this;
  }

  /**
   * Checks if the suggest box is clearable.
   *
   * @return {@code true} if the suggest box is clearable, {@code false} otherwise.
   */
  public boolean isClearable() {
    return containsCss(dui_clearable.getCssClass());
  }

  /**
   * Sets whether the suggest box should auto-close the options menu when an option is selected.
   *
   * @param autoClose {@code true} to auto-close the options menu on selection, {@code false}
   *     otherwise.
   * @return The suggest box instance after configuring auto-closing behavior.
   */
  public C setAutoCloseOnSelect(boolean autoClose) {
    optionsMenu.setAutoCloseOnSelect(autoClose);
    return (C) this;
  }

  /**
   * Checks if the suggest box is configured to auto-close the options menu when an option is
   * selected.
   *
   * @return {@code true} if auto-closing is enabled, {@code false} otherwise.
   */
  public boolean isAutoCloseOnSelect() {
    return optionsMenu.isAutoCloseOnSelect();
  }

  /**
   * Gets the options menu associated with the suggest box.
   *
   * @return The options menu.
   */
  public Menu<T> getOptionsMenu() {
    return optionsMenu;
  }

  /**
   * Configures the suggest box with the provided options menu using the provided handler.
   *
   * @param handler A handler for configuring the suggest box and options menu.
   * @return The suggest box instance after configuring the options menu.
   */
  public C withOptionsMenu(ChildHandler<C, Menu<T>> handler) {
    handler.apply((C) this, optionsMenu);
    return (C) this;
  }

  /**
   * An interface for rendering the value of a suggestion option in a suggest box.
   *
   * @param <T> The type of data associated with the option.
   * @param <V> The type of the suggest box's value.
   * @param <E> The type of the suggest box's element.
   * @param <S> The type of the option within the suggest box.
   * @param <C> The type of the suggest box itself.
   */
  public interface SuggestValueRenderer<
      T,
      V,
      E extends IsElement<?>,
      S extends Option<T, E, S>,
      C extends AbstractSuggestBox<T, V, E, S, C>> {
    /**
     * Renders the element for a suggestion option.
     *
     * @param select The suggest box instance.
     * @param option The suggestion option to render.
     * @return The rendered HTML element for the suggestion option.
     */
    HTMLElement element(C select, Option<T, E, S> option);
  }

  private static class SuggestAutoValidator<
          T,
          V,
          E extends IsElement<?>,
          S extends Option<T, E, S>,
          C extends AbstractSuggestBox<T, V, E, S, C>>
      extends AutoValidator {

    private C select;
    private HasSelectionListeners.SelectionListener<AbstractMenuItem<T>, List<AbstractMenuItem<T>>>
        listener;

    public SuggestAutoValidator(C select, ApplyFunction autoValidate) {
      super(autoValidate);
      this.select = select;
    }

    @Override
    public void attach() {
      select.inputElement.addEventListener("blur", evt -> autoValidate.apply());
      listener = (source, selection) -> autoValidate.apply();
      select.getOptionsMenu().addSelectionListener(listener);
    }

    @Override
    public void remove() {
      select.getOptionsMenu().removeSelectionListener(listener);
    }
  }
}
