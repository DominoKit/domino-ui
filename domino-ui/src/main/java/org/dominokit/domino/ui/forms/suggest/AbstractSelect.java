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
import elemental2.dom.Event;
import elemental2.dom.HTMLElement;
import elemental2.dom.HTMLInputElement;
import elemental2.dom.KeyboardEvent;
import java.util.*;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.stream.Collectors;
import jsinterop.base.Js;
import org.dominokit.domino.ui.IsElement;
import org.dominokit.domino.ui.elements.DivElement;
import org.dominokit.domino.ui.elements.InputElement;
import org.dominokit.domino.ui.elements.SpanElement;
import org.dominokit.domino.ui.forms.AbstractFormElement;
import org.dominokit.domino.ui.forms.AutoValidator;
import org.dominokit.domino.ui.forms.HasInputElement;
import org.dominokit.domino.ui.icons.lib.Icons;
import org.dominokit.domino.ui.menu.AbstractMenuItem;
import org.dominokit.domino.ui.menu.Menu;
import org.dominokit.domino.ui.menu.MenuItemsGroup;
import org.dominokit.domino.ui.menu.direction.DropDirection;
import org.dominokit.domino.ui.style.BooleanCssClass;
import org.dominokit.domino.ui.utils.*;

/**
 * Represents an abstract select form element which can be used as a base for building dropdown
 * selectors. This abstract class encapsulates common behavior and rendering logic shared by various
 * select components.
 *
 * <p><b>Usage:</b>
 *
 * <pre>
 * // Create a concrete class extending AbstractSelect
 * public class MySelect extends AbstractSelect<MyType, String, MyElement, MyOption, MySelect> {
 *      // implementation details...
 * }
 * MySelect select = new MySelect();
 *
 * </pre>
 *
 * @param <T> The type of the model.
 * @param <V> The type of the value to be selected.
 * @param <E> The type of the element.
 * @param <O> The type of the option.
 * @param <C> The type of the concrete class extending this abstract class.
 */
public abstract class AbstractSelect<
        T,
        V,
        E extends IsElement<?>,
        O extends Option<T, E, O>,
        C extends AbstractSelect<T, V, E, O, C>>
    extends AbstractFormElement<C, V>
    implements HasInputElement<C, HTMLInputElement>, HasPlaceHolder<C> {

  protected Menu<T> optionsMenu;
  protected DivElement fieldInput;
  private SpanElement placeHolderElement;
  private InputElement inputElement;
  private InputElement typingElement;
  private int typeAheadDelay = -1;

  /**
   * Default constructor which initializes the underlying structures, sets up event listeners, and
   * styles the select form.
   */
  public AbstractSelect() {
    placeHolderElement = span();
    addCss(dui_form_select);
    wrapperElement
        .addCss(dui_relative)
        .appendChild(
            fieldInput =
                div()
                    .addCss(dui_field_input, dui_flex_nowrap)
                    .appendChild(placeHolderElement.addCss(dui_field_placeholder)))
        .appendChild(inputElement = input(getType()).addCss(dui_hidden_input))
        .appendChild(
            typingElement =
                input("text")
                    .addEventListener("input", evt -> onTypingStart())
                    .addCss(dui_auto_type_input, dui_hidden)
                    .setTabIndex(-1)
                    .onKeyDown(keyEvents -> keyEvents.alphanumeric(Event::stopPropagation)));

    DelayedTextInput.create(typingElement, getTypeAheadDelay())
        .setDelayedAction(
            () -> {
              optionsMenu
                  .findOptionStarsWith(typingElement.getValue())
                  .flatMap(OptionMeta::get)
                  .ifPresent(
                      meta -> onOptionSelected((O) meta.getOption(), isChangeListenersPaused()));
              optionsMenu.focusFirstMatch(typingElement.getValue());
              typingElement.setValue(null).addCss(dui_hidden);
              focus();
              onTypingEnd();
            })
        .setOnEnterAction(
            () -> {
              openOptionMenu(false);
              String token = typingElement.getValue();
              typingElement.setValue(null).addCss(dui_hidden);
              DomGlobal.setTimeout(p0 -> optionsMenu.focusFirstMatch(token), 0);
            });

    onKeyDown(
        keyEvents -> {
          keyEvents.alphanumeric(
              evt -> {
                KeyboardEvent keyboardEvent = Js.uncheckedCast(evt);
                keyboardEvent.stopPropagation();
                keyboardEvent.preventDefault();
                String key = keyboardEvent.key;
                if (nonNull(key)
                    && !optionsMenu.isOpened()
                    && (isNull(typingElement.getValue()) || typingElement.getValue().isEmpty())) {
                  typingElement.removeCss(dui_hidden);
                  typingElement.element().value = key;
                  typingElement.element().focus();
                }
              });
        });

    labelForId(inputElement.getDominoId());

    optionsMenu =
        Menu.<T>create()
            .addCss(dui_select_menu)
            .setOpenMenuCondition(menu -> !(isReadOnly() || isDisabled()))
            .setDropDirection(DropDirection.BEST_MIDDLE_DOWN_UP)
            .setMenuAppendTarget(body().element())
            .setTargetElement(getWrapperElement())
            .setFitToTargetWidth(true)
            .addSelectionListener(
                (source, selection) ->
                    source
                        .flatMap(OptionMeta::<T, E, O>get)
                        .ifPresent(
                            meta -> onOptionSelected(meta.getOption(), isChangeListenersPaused())))
            .addDeselectionListener(
                (source, selection) ->
                    source
                        .flatMap(OptionMeta::<T, E, O>get)
                        .ifPresent(
                            meta ->
                                onOptionDeselected(meta.getOption(), isChangeListenersPaused())))
            .addOpenListener((menu) -> focus());

    onAttached(
        (e, mutationRecord) -> {
          optionsMenu.setTargetElement(getWrapperElement());
        });
    getInputElement()
        .onKeyDown(
            keyEvents ->
                keyEvents.onEnter(evt -> openOptionMenu()).onSpace(evt -> openOptionMenu()))
        .onKeyUp(keyEvents -> keyEvents.onArrowDown(evt -> openOptionMenu()));

    appendChild(
        PrimaryAddOn.of(
            Icons.chevron_down()
                .addCss(dui_form_select_drop_arrow)
                .clickable()
                .setAttribute("tabindex", getConfig().isTabFocusSelectArrowEnabled() ? "0" : "-1")
                .setAttribute(
                    "aria-expanded", getConfig().isTabFocusSelectArrowEnabled() ? "true" : "false")
                .addClickListener(
                    evt -> {
                      evt.stopPropagation();
                      openOptionMenu();
                    })
                .onKeyDown(
                    keyEvents ->
                        keyEvents.onEnter(
                            evt -> {
                              evt.stopPropagation();
                              openOptionMenu();
                            }))));

    appendChild(
        PrimaryAddOn.of(
            config()
                .getUIConfig()
                .clearableInputDefaultIcon()
                .addCss(dui_form_select_clear)
                .clickable()
                .addClickListener(
                    evt -> {
                      evt.stopPropagation();
                      clearValue(false);
                    })));
  }

  protected abstract void onTypingStart();

  protected abstract void onTypingEnd();

  private int getTypeAheadDelay() {
    return typeAheadDelay > 0
        ? typeAheadDelay
        : config().getUIConfig().getSelectBoxTypeAheadDelay();
  }

  public C setTypeAheadDelay(int delay) {
    this.typeAheadDelay = delay;
    return (C) this;
  }

  /**
   * Opens the options menu allowing user to select an option, unless the select is read-only or
   * disabled.
   */
  private void openOptionMenu() {
    openOptionMenu(true);
  }

  /**
   * Opens the options menu allowing user to select an option, unless the select is read-only or
   * disabled.
   *
   * @param focus a flag to decide if the menu should be focused on first element or not.
   */
  private void openOptionMenu(boolean focus) {
    if (isReadOnly() || isDisabled()) {
      return;
    }
    if (optionsMenu.isOpened() && !optionsMenu.isContextMenu()) {
      optionsMenu.close();
    } else {
      optionsMenu.open(focus);
    }
  }

  /**
   * Convert the provided single value into the expected return value of type {@code V}.
   *
   * @param singleValue the value to be converted.
   * @return the converted value of type {@code V}.
   */
  protected V asValue(T singleValue) {
    return (V) singleValue;
  }

  /** Updates the text representation of the current value to the input element. */
  protected void updateTextValue() {
    getInputElement().element().value = getStringValue();
  }

  /**
   * Clears the current value from the select.
   *
   * @param silent if {@code true}, change listeners will not be triggered.
   * @return an instance of the concrete class.
   */
  protected C clearValue(boolean silent) {
    if (!optionsMenu.getSelection().isEmpty()) {
      V oldValue = getValue();
      optionsMenu.withPauseSelectionListenersToggle(
          true,
          field -> {
            List<AbstractMenuItem<T>> selection = optionsMenu.getSelection();
            new ArrayList<>(selection)
                .forEach(
                    item -> {
                      withPausedChangeListeners(
                          select -> {
                            item.deselect(silent);
                            if (silent) {
                              OptionMeta.get(item)
                                  .ifPresent(
                                      meta -> onOptionDeselected((O) meta.getOption(), silent));
                            }
                          });
                    });
          });

      if (!silent) {
        optionsMenu.triggerDeselectionListeners(null, new ArrayList<>());
        triggerClearListeners(oldValue);
        triggerChangeListeners(oldValue, getValue());
      }

      if (isAutoValidation()) {
        autoValidate();
      }
    }

    return (C) this;
  }

  /**
   * Appends the specified option to the select.
   *
   * @param option The option to be added to the select.
   * @return an instance of the concrete class.
   */
  public C appendChild(O option) {
    if (nonNull(option)) {
      optionsMenu.appendChild(option.getMenuItem());
    }
    return (C) this;
  }

  /**
   * Insert the specified option in the specified index.
   *
   * @param index The desired location index.
   * @param option The option to be added to the select.
   * @return an instance of the concrete class.
   */
  public C insertChild(int index, O option) {
    if (nonNull(option)) {
      optionsMenu.insertChild(index, option.getMenuItem());
    }
    return (C) this;
  }

  /**
   * Appends a collection of options to the select.
   *
   * @param options The collection of options to be added to the select.
   * @return an instance of the concrete class.
   */
  public C appendOptions(Collection<O> options) {
    if (nonNull(options)) {
      options.forEach(this::appendChild);
    }
    return (C) this;
  }

  /**
   * Insert a collection of options starting from the provided index.
   *
   * @param index The insert starting index
   * @param options The collection of options to be added to the select.
   * @return an instance of the concrete class.
   */
  public C insertOptions(int index, Collection<O> options) {
    if (nonNull(options)) {
      int[] i = new int[] {index};
      options.forEach(
          o -> {
            insertChild(i[0], o);
            i[0] = i[0]++;
          });
    }
    return (C) this;
  }

  /**
   * Appends a series of options to the select.
   *
   * @param options The options to be added to the select.
   * @return an instance of the concrete class.
   */
  public C appendOptions(O... options) {
    if (nonNull(options)) {
      appendOptions(Arrays.asList(options));
    }
    return (C) this;
  }

  /**
   * Insert a series of options to the select at the provided index.
   *
   * @param index The starting insert index.
   * @param options The options to be added to the select.
   * @return an instance of the concrete class.
   */
  public C insertOptions(int index, O... options) {
    if (nonNull(options)) {
      insertOptions(index, Arrays.asList(options));
    }
    return (C) this;
  }

  /**
   * Maps the specified item using the provided mapper function and appends it as an option to the
   * select.
   *
   * @param mapper The function to map the item to an option.
   * @param item The item to be mapped and added as an option to the select.
   * @return an instance of the concrete class.
   */
  public <I> C appendItem(Function<I, O> mapper, I item) {
    return appendChild(mapper.apply(item));
  }

  /**
   * Maps the specified item using the provided mapper function and insert it at the provided index
   *
   * @param index The index
   * @param mapper The function to map the item to an option.
   * @param item The item to be mapped and added as an option to the select.
   * @return an instance of the concrete class.
   */
  public <I> C insertItem(int index, Function<I, O> mapper, I item) {
    return insertChild(index, mapper.apply(item));
  }

  /**
   * Maps each item in the provided collection using the given mapper function and appends them as
   * options to the select.
   *
   * @param mapper The function to map each item to an option.
   * @param items The collection of items to be mapped and added as options to the select.
   * @return an instance of the concrete class.
   */
  public <I> C appendItems(Function<I, O> mapper, Collection<I> items) {
    items.forEach(item -> appendItem(mapper, item));
    return (C) this;
  }

  /**
   * Maps each item in the provided collection using the given mapper function and insert them
   * starting from the provided index.
   *
   * @param index The starting insert index.
   * @param mapper The function to map each item to an option.
   * @param items The collection of items to be mapped and added as options to the select.
   * @return an instance of the concrete class.
   */
  public <I> C insertItems(int index, Function<I, O> mapper, Collection<I> items) {
    int[] i = new int[] {index};
    items.forEach(
        item -> {
          insertItem(i[0], mapper, item);
          i[0] = i[0]++;
        });
    return (C) this;
  }

  /**
   * Maps each item in the provided series using the given mapper function and appends them as
   * options to the select.
   *
   * @param mapper The function to map each item to an option.
   * @param items The items to be mapped and added as options to the select.
   * @return an instance of the concrete class.
   */
  public <I> C appendItems(Function<I, O> mapper, I... items) {
    appendItems(mapper, Arrays.asList(items));
    return (C) this;
  }

  /**
   * Maps each item in the provided series using the given mapper function and insert them starting
   * from the provided index.
   *
   * @param index insert starting index.
   * @param mapper The function to map each item to an option.
   * @param items The items to be mapped and added as options to the select.
   * @return an instance of the concrete class.
   */
  public <I> C insertItems(int index, Function<I, O> mapper, I... items) {
    insertItems(index, mapper, Arrays.asList(items));
    return (C) this;
  }

  /**
   * Appends the specified separator to the select.
   *
   * @param separator The separator to be added between options in the select.
   * @return an instance of the concrete class.
   */
  public <I> C appendChild(Separator separator) {
    optionsMenu.appendChild(separator);
    return (C) this;
  }

  /**
   * insert the specified separator to the select at the provided index.
   *
   * @param index the insert index.
   * @param separator The separator to be added between options in the select.
   * @return an instance of the concrete class.
   */
  public <I> C insertChild(int index, Separator separator) {
    optionsMenu.insertChild(index, separator);
    return (C) this;
  }

  /**
   * Retrieves the current placeholder text from the select.
   *
   * @return The placeholder text.
   */
  @Override
  public String getPlaceholder() {
    return placeHolderElement.getTextContent();
  }

  /**
   * Sets the placeholder text for the select.
   *
   * @param placeholder The text to be used as a placeholder.
   * @return an instance of the concrete class.
   */
  @Override
  public C setPlaceholder(String placeholder) {
    placeHolderElement.setTextContent(placeholder);
    return (C) this;
  }

  /**
   * Retrieves the input element associated with the select.
   *
   * @return The input element.
   */
  @Override
  public DominoElement<HTMLInputElement> getInputElement() {
    return inputElement.toDominoElement();
  }

  /**
   * Returns the string representation of the currently selected value(s) in the select.
   *
   * @return The string representation of the selected value(s).
   */
  @Override
  public String getStringValue() {
    return optionsMenu.getSelection().stream()
        .map(option -> String.valueOf(option.getValue()))
        .collect(Collectors.joining(","));
  }

  /**
   * Focuses on the input element associated with the select.
   *
   * @return an instance of the concrete class.
   */
  @Override
  public C focus() {
    inputElement.element().focus();
    return (C) this;
  }

  /**
   * Removes focus from the input element associated with the select.
   *
   * @return an instance of the concrete class.
   */
  @Override
  public C unfocus() {
    inputElement.element().blur();
    return (C) this;
  }

  /**
   * Checks if the input element associated with the select currently has focus.
   *
   * @return {@code true} if the element is focused, {@code false} otherwise.
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
   * Determines if the select currently has a value.
   *
   * @return {@code true} if the select is empty, {@code false} otherwise.
   */
  @Override
  public boolean isEmpty() {
    return isNull(getValue());
  }

  /**
   * Determines if the select currently has a value while ignoring spaces.
   *
   * <p>Note: This method currently has the same implementation as {@link #isEmpty()}.
   *
   * @return {@code true} if the select is empty, {@code false} otherwise.
   */
  @Override
  public boolean isEmptyIgnoreSpaces() {
    return isEmpty();
  }

  /**
   * Checks if the select is enabled.
   *
   * @return {@code true} if the select is enabled, {@code false} otherwise.
   */
  @Override
  public boolean isEnabled() {
    return !getInputElement().isDisabled() && super.isEnabled();
  }

  /**
   * Clears the current value of the select.
   *
   * @return an instance of the concrete class.
   */
  @Override
  public C clear() {
    return clear(isChangeListenersPaused());
  }

  /**
   * Clears the current value of the select with the option to notify listeners of the change.
   *
   * @param silent if {@code true}, listeners will not be notified of the change.
   * @return an instance of the concrete class.
   */
  @Override
  public C clear(boolean silent) {
    return clearValue(silent);
  }

  /**
   * Creates an {@link AutoValidator} for the select element.
   *
   * @param autoValidate The function to be applied for auto-validation.
   * @return an instance of {@link AutoValidator}.
   */
  @Override
  public AutoValidator createAutoValidator(ApplyFunction autoValidate) {
    return new SelectAutoValidator<>((C) this, autoValidate);
  }

  /**
   * Triggers all registered change listeners with the specified old and new values.
   *
   * @param oldValue The old value.
   * @param newValue The new value.
   * @return an instance of the concrete class.
   */
  @Override
  public C triggerChangeListeners(V oldValue, V newValue) {
    getChangeListeners()
        .forEach(changeListener -> changeListener.onValueChanged(oldValue, newValue));
    return (C) this;
  }

  /**
   * Triggers all registered clear listeners with the specified old value.
   *
   * @param oldValue The old value.
   * @return an instance of the concrete class.
   */
  @Override
  public C triggerClearListeners(V oldValue) {
    getClearListeners().forEach(clearListener -> clearListener.onValueCleared(oldValue));
    return (C) this;
  }

  /**
   * Retrieves the name attribute of the input element associated with the select.
   *
   * @return The name attribute of the input element.
   */
  @Override
  public String getName() {
    return getInputElement().element().name;
  }

  /**
   * Sets the name attribute for the input element associated with the select.
   *
   * @param name The name to set.
   * @return an instance of the concrete class.
   */
  @Override
  public C setName(String name) {
    getInputElement().element().name = name;
    return (C) this;
  }

  /**
   * Retrieves the type attribute of the input element. For this implementation, it always returns
   * "text".
   *
   * @return The string "text".
   */
  @Override
  public String getType() {
    return "text";
  }

  /**
   * Sets the value for the select. Whether to notify listeners is determined by the current state
   * of change listeners.
   *
   * @param value The new value to set.
   * @return an instance of the concrete class.
   */
  @Override
  public C withValue(V value) {
    return withValue(value, isChangeListenersPaused());
  }

  /**
   * Adds a group of options to the select menu with a provided group handler.
   *
   * @param options The collection of options to add to the group.
   * @param groupHandler The handler for the options group.
   * @return an instance of the concrete class.
   */
  public C addOptionsGroup(
      Collection<O> options, Menu.MenuItemsGroupHandler<T, AbstractMenuItem<T>> groupHandler) {
    MenuItemsGroup<T> optionsGroup = new MenuItemsGroup<>(optionsMenu);
    optionsMenu.appendGroup(optionsGroup, groupHandler);
    options.forEach(option -> addItemToGroup(optionsGroup, option));
    return (C) this;
  }

  /**
   * Convenience method to group a set of options using a provided group handler. Internally uses
   * {@link #addOptionsGroup(Collection, Menu.MenuItemsGroupHandler)}.
   *
   * @param groupHandler The handler for the options group.
   * @param options The collection of options to group.
   * @return an instance of the concrete class.
   */
  public C group(
      Menu.MenuItemsGroupHandler<T, AbstractMenuItem<T>> groupHandler, Collection<O> options) {
    return addOptionsGroup(options, groupHandler);
  }

  /**
   * Helper method to append an item to a specific options group.
   *
   * @param optionsGroup The options group to which the item is added.
   * @param option The option to add to the group.
   */
  private void addItemToGroup(MenuItemsGroup<T> optionsGroup, O option) {
    optionsGroup.appendChild(option.getMenuItem());
  }

  /**
   * Sets the value for the select. Optionally, it can notify listeners based on the provided silent
   * flag.
   *
   * @param value The new value to set.
   * @param silent If true, change listeners will not be notified.
   * @return an instance of the concrete class.
   */
  @Override
  public C withValue(V value, boolean silent) {
    V oldValue = getValue();
    if (!Objects.equals(value, oldValue)) {
      doSetValue(value, silent);
      if (!silent) {
        triggerChangeListeners(oldValue, getValue());
      }
    }
    autoValidate();
    return (C) this;
  }

  /**
   * Appends an option to the select. Whether to notify listeners is determined by the current state
   * of change listeners.
   *
   * @param option The option to add.
   * @return an instance of the concrete class.
   */
  public C withOption(O option) {
    return withOption(option, isChangeListenersPaused());
  }

  /**
   * Abstract method to set the specified option for the select with an option to notify listeners.
   * Concrete implementations will define its behavior.
   *
   * @param option The option to set.
   * @param silent If true, change listeners will not be notified.
   * @return an instance of the concrete class.
   */
  protected abstract C withOption(O option, boolean silent);

  /**
   * Abstract method to set a specified value for the select. Concrete implementations will define
   * its behavior.
   *
   * @param value The value to set.
   * @param silent boolean to pause triggering change handlers
   */
  protected abstract void doSetValue(V value, boolean silent);

  /**
   * Abstract method to set a specified option for the select. Concrete implementations will define
   * its behavior.
   *
   * @param option The option to set.
   */
  protected abstract void doSetOption(O option);

  /**
   * Sets the value of the select component.
   *
   * @param value The new value to set.
   */
  @Override
  public void setValue(V value) {
    withValue(value);
  }

  /**
   * Selects a given option within the select component.
   *
   * @param option The option to select.
   * @return an instance of the concrete class.
   */
  public C selectOption(O option) {
    findOption(option)
        .ifPresent(menuItem -> menuItem.getMenuItem().select(isChangeListenersPaused()));
    return (C) this;
  }

  /**
   * Retrieves the index of the currently selected option within the select component. If no option
   * is selected, it returns -1.
   *
   * @return The index of the selected option, or -1 if no option is selected.
   */
  public int getSelectedIndex() {
    return getOptionsMenu().getSelection().stream()
        .findFirst()
        .map(item -> getOptionsMenu().getFlatMenuItems().indexOf(item))
        .orElse(-1);
  }

  /**
   * Searches for a specific option within the select component.
   *
   * @param option The option to search for.
   * @return An Optional containing the matched option or empty if not found.
   */
  public Optional<O> findOption(O option) {
    return Optional.ofNullable(option)
        .flatMap(
            vSelectionOption -> {
              return optionsMenu.getFlatMenuItems().stream()
                  .filter(menuItem -> Objects.equals(option.getKey(), menuItem.getKey()))
                  .filter(menuItem -> OptionMeta.get(menuItem).isPresent())
                  .map(menuItem -> OptionMeta.<T, E, O>get(menuItem).get().getOption())
                  .findFirst();
            });
  }

  /**
   * Searches for an option by its key within the select component.
   *
   * @param key The key of the option to search for.
   * @return An Optional containing the matched option or empty if not found.
   */
  public Optional<O> findOptionByKey(String key) {
    return optionsMenu.getFlatMenuItems().stream()
        .filter(menuItem -> Objects.equals(key, menuItem.getKey()))
        .filter(menuItem -> OptionMeta.get(menuItem).isPresent())
        .map(menuItem -> OptionMeta.<T, E, O>get(menuItem).get().getOption())
        .findFirst();
  }

  private Optional<AbstractMenuItem<T>> findMenuItemByKey(String key) {
    return optionsMenu.getFlatMenuItems().stream()
        .filter(menuItem -> Objects.equals(key, menuItem.getKey()))
        .findFirst();
  }

  /**
   * Searches for an option by its value within the select component.
   *
   * @param value The value of the option to search for.
   * @return An Optional containing the matched option or empty if not found.
   */
  public Optional<O> findOptionByValue(T value) {
    return optionsMenu.getFlatMenuItems().stream()
        .filter(menuItem -> Objects.equals(value, menuItem.getValue()))
        .filter(menuItem -> OptionMeta.get(menuItem).isPresent())
        .map(menuItem -> OptionMeta.<T, E, O>get(menuItem).get().getOption())
        .findFirst();
  }

  private Optional<AbstractMenuItem<T>> findMenuItemByValue(T value) {
    return optionsMenu.getFlatMenuItems().stream()
        .filter(menuItem -> Objects.equals(value, menuItem.getValue()))
        .findFirst();
  }

  /**
   * Searches for an option by its index within the select component.
   *
   * @param index The index of the option to search for.
   * @return An Optional containing the matched option or empty if the index is out of bounds or not
   *     found.
   */
  public Optional<O> findOptionByIndex(int index) {
    return findMenuItemByIndex(index).map(item -> OptionMeta.<T, E, O>get(item).get().getOption());
  }

  private Optional<AbstractMenuItem<T>> findMenuItemByIndex(int index) {
    if (index < optionsMenu.getFlatMenuItems().size() && index >= 0) {
      return Optional.ofNullable(optionsMenu.getFlatMenuItems().get(index));
    }
    return Optional.empty();
  }

  /**
   * Called when a specific option is selected. Implementations should handle any custom behavior
   * associated with the selection of the option. Optionally, it can notify listeners based on the
   * provided silent flag.
   *
   * @param option The option that was selected.
   * @param silent If true, change listeners will not be notified.
   */
  protected abstract void onOptionSelected(O option, boolean silent);

  /**
   * Called when a specific option is deselected. Implementations should handle any custom behavior
   * associated with the deselection of the option. Optionally, it can notify listeners based on the
   * provided silent flag.
   *
   * @param option The option that was deselected.
   * @param silent If true, change listeners will not be notified.
   */
  protected abstract void onOptionDeselected(O option, boolean silent);

  /**
   * Selects the option at the specified index within the select component.
   *
   * @param index The index of the option to select.
   * @return an instance of the concrete class.
   */
  public C selectAt(int index) {
    selectAt(index, isChangeListenersPaused());
    return (C) this;
  }

  /**
   * Selects the option at the specified Indices within the select component.
   *
   * @param indices The Indices of the options to select.
   * @return an instance of the concrete class.
   */
  public C selectAt(int... indices) {
    selectAt(isChangeListenersPaused(), indices);
    return (C) this;
  }

  /**
   * Selects the option at the specified index within the select component. Optionally, it can
   * notify listeners based on the provided silent flag.
   *
   * @param index The index of the option to select.
   * @param silent If true, change listeners will not be notified.
   * @return an instance of the concrete class.
   */
  public C selectAt(int index, boolean silent) {
    findOptionByIndex(index).ifPresent(o -> onOptionSelected(o, silent));
    return (C) this;
  }

  /**
   * Selects the option at the specified Indices within the select component. Optionally, it can
   * notify listeners based on the provided silent flag.
   *
   * @param indices The Indices of the option to select.
   * @param silent If true, change listeners will not be notified.
   * @return an instance of the concrete class.
   */
  public C selectAt(boolean silent, int... indices) {
    Arrays.stream(indices)
        .forEach(
            index -> {
              selectAt(index, silent);
            });
    return (C) this;
  }

  /**
   * Selects the option associated with the specified key within the select component. Note: This
   * method erroneously calls onOptionDeselected instead of onOptionSelected.
   *
   * @param key The key of the option to select.
   * @return an instance of the concrete class.
   */
  public C selectByKey(String key) {
    selectByKey(key, isChangeListenersPaused());
    return (C) this;
  }

  /**
   * Selects the option associated with the specified key within the select component. Note: This
   * method erroneously calls onOptionDeselected instead of onOptionSelected. Optionally, it can
   * notify listeners based on the provided silent flag.
   *
   * @param key The key of the option to select.
   * @param silent If true, change listeners will not be notified.
   * @return an instance of the concrete class.
   */
  public C selectByKey(String key, boolean silent) {
    findOptionByKey(key).ifPresent(o -> onOptionSelected(o, silent));
    return (C) this;
  }

  /**
   * Selects the option with the specified value within the select component.
   *
   * @param value The value of the option to select.
   * @return an instance of the concrete class.
   */
  public C selectByValue(T value) {
    selectByValue(value, isChangeListenersPaused());
    return (C) this;
  }

  /**
   * Selects the option with the specified value within the select component. Optionally, it can
   * notify listeners based on the provided silent flag.
   *
   * @param value The value of the option to select.
   * @param silent If true, change listeners will not be notified.
   * @return an instance of the concrete class.
   */
  public C selectByValue(T value, boolean silent) {
    findOptionByValue(value).ifPresent(o -> onOptionSelected(o, silent));
    return (C) this;
  }

  /**
   * Deselects the option at the specified index within the select component.
   *
   * @param index The index of the option to deselect.
   * @return an instance of the concrete class.
   */
  public C deselectAt(int index) {
    deselectAt(index, isChangeListenersPaused());
    return (C) this;
  }

  /**
   * Deselects the option at the specified index within the select component. Optionally, it can
   * notify listeners based on the provided silent flag.
   *
   * @param index The index of the option to deselect.
   * @param silent If true, change listeners will not be notified.
   * @return an instance of the concrete class.
   */
  public C deselectAt(int index, boolean silent) {
    findMenuItemByIndex(index).ifPresent(item -> item.deselect(silent));
    return (C) this;
  }

  /**
   * Deselects the option associated with the specified key within the select component. Optionally,
   * it can notify listeners based on the provided silent flag.
   *
   * @param key The key of the option to deselect.
   * @return an instance of the concrete class.
   */
  public C deselectByKey(String key) {
    deselectByKey(key, isChangeListenersPaused());
    return (C) this;
  }

  /**
   * Deselects the option associated with the specified key within the select component. Optionally,
   * it can notify listeners based on the provided silent flag.
   *
   * @param key The key of the option to deselect.
   * @param silent If true, change listeners will not be notified.
   * @return an instance of the concrete class.
   */
  public C deselectByKey(String key, boolean silent) {
    findMenuItemByKey(key).ifPresent(item -> item.deselect(silent));
    return (C) this;
  }

  /**
   * Deselects the option with the specified value within the select component.
   *
   * @param value The value of the option to deselect.
   * @return an instance of the concrete class.
   */
  public C deselectByValue(T value) {
    deselectByValue(value, isChangeListenersPaused());
    return (C) this;
  }

  /**
   * Deselects the option with the specified value within the select component. Optionally, it can
   * notify listeners based on the provided silent flag.
   *
   * @param value The value of the option to deselect.
   * @param silent If true, change listeners will not be notified.
   * @return an instance of the concrete class.
   */
  public C deselectByValue(T value, boolean silent) {
    findMenuItemByValue(value).ifPresent(item -> item.deselect(silent));
    return (C) this;
  }

  /**
   * Checks if the select component contains an option with the specified key.
   *
   * @param key The key to search for.
   * @return {@code true} if the option is found, otherwise {@code false}.
   */
  public boolean containsKey(String key) {
    return findOptionByKey(key).isPresent();
  }

  /**
   * Checks if the select component contains an option with the specified value.
   *
   * @param value The value to search for.
   * @return {@code true} if the option is found, otherwise {@code false}.
   */
  public boolean containsValue(T value) {
    return findOptionByValue(value).isPresent();
  }

  /**
   * Sets whether the select component can be cleared.
   *
   * @param clearable {@code true} if the select should be clearable, otherwise {@code false}.
   * @return an instance of the concrete class.
   */
  public C setClearable(boolean clearable) {
    addCss(BooleanCssClass.of(dui_clearable, clearable));
    return (C) this;
  }

  /**
   * Checks if the select component can be cleared.
   *
   * @return {@code true} if the select is clearable, otherwise {@code false}.
   */
  public boolean isClearable() {
    return containsCss(dui_clearable.getCssClass());
  }

  /**
   * Configures whether the select component should automatically close upon selecting an option.
   *
   * @param autoClose {@code true} if the select should automatically close after selection,
   *     otherwise {@code false}.
   * @return an instance of the concrete class.
   */
  public C setAutoCloseOnSelect(boolean autoClose) {
    optionsMenu.setAutoCloseOnSelect(autoClose);
    return (C) this;
  }

  /**
   * Checks if the select component is set to automatically close upon selecting an option.
   *
   * @return {@code true} if the select auto-closes on select, otherwise {@code false}.
   */
  public boolean isAutoCloseOnSelect() {
    return optionsMenu.isAutoCloseOnSelect();
  }

  /**
   * Configures whether the select component should provide a search functionality for its options.
   *
   * @param searchable {@code true} if the select should provide search functionality, otherwise
   *     {@code false}.
   * @return an instance of the concrete class.
   */
  public C setSearchable(boolean searchable) {
    optionsMenu.setSearchable(searchable);
    return (C) this;
  }

  /**
   * Checks if the select component provides a search functionality.
   *
   * @return {@code true} if the select is searchable, otherwise {@code false}.
   */
  public boolean isSearchable() {
    return optionsMenu.isSearchable();
  }

  /**
   * Checks if the select component allows creation of missing options.
   *
   * @return {@code true} if the select allows creating missing options, otherwise {@code false}.
   */
  public boolean isAllowCreateMissing() {
    return optionsMenu.isAllowCreateMissing();
  }

  /**
   * Retrieves the options menu associated with the select component.
   *
   * @return The options menu.
   */
  public Menu<T> getOptionsMenu() {
    return optionsMenu;
  }

  /**
   * Applies a handler to the options menu of the select component.
   *
   * @param handler The handler to apply.
   * @return an instance of the concrete class.
   */
  public C withOptionsMenu(ChildHandler<C, Menu<T>> handler) {
    handler.apply((C) this, optionsMenu);
    return (C) this;
  }

  /**
   * Sets the handler for missing options in the select component.
   *
   * @param missingOptionHandler The handler for missing options.
   * @return an instance of the concrete class.
   */
  public C setMissingItemHandler(MissingOptionHandler<C, E, T, O> missingOptionHandler) {
    if (nonNull(missingOptionHandler)) {
      optionsMenu.setMissingItemHandler(
          (token, menu) ->
              missingOptionHandler.onMissingItem(
                  (C) this, token, option -> appendChild((O) option)));
    } else {
      optionsMenu.setMissingItemHandler(null);
    }
    return (C) this;
  }

  /**
   * Removes a specified option from the select component.
   *
   * @param option The option to remove.
   * @return an instance of the concrete class.
   */
  public C removeOption(O option) {
    findOption(option)
        .ifPresent(
            found -> {
              V value = getValue();
              T optionValue = option.getValue();
              if (Objects.equals(value, optionValue)) {
                clear();
              }
              option.remove();
              optionsMenu.removeItem(found.getMenuItem());
              onOptionRemoved(option);
            });
    return (C) this;
  }

  protected void onOptionRemoved(O option) {}

  /**
   * Removes a specified option from the select component.
   *
   * @param index the index of the option to be removed.
   * @return an instance of the concrete class.
   */
  public C removeOptionAt(int index) {
    AbstractMenuItem<T> menuItem = optionsMenu.getMenuItems().get(index);
    return removeOption(OptionMeta.<T, E, O>get(menuItem).get().getOption());
  }

  /**
   * Removes a collection of options from the select component.
   *
   * @param options The collection of options to remove.
   * @return an instance of the concrete class.
   */
  public C removeOptions(Collection<O> options) {
    options.forEach(this::removeOption);
    return (C) this;
  }

  /**
   * Removes an array of options from the select component.
   *
   * @param options The array of options to remove.
   * @return an instance of the concrete class.
   */
  public C removeOptions(O... options) {
    Arrays.asList(options).forEach(this::removeOption);
    return (C) this;
  }

  /**
   * Removes all options from the select component.
   *
   * @return an instance of the concrete class.
   */
  public C removeAllOptions() {
    new ArrayList<>(optionsMenu.getMenuItems())
        .forEach(
            menuItem -> {
              removeOption(OptionMeta.<T, E, O>get(menuItem).get().getOption());
            });
    return (C) this;
  }

  /**
   * Hides the select component. If the options menu is open, it will be closed before hiding.
   *
   * @return an instance of the concrete class.
   */
  @Override
  public C hide() {
    if (optionsMenu.isOpened()) {
      optionsMenu.close();
    }
    return super.hide();
  }

  /**
   * This interface defines a handler to manage missing options for a component. When a requested
   * option is missing, this handler can provide the logic to handle that scenario.
   *
   * @param <T> The type of the component where the option is missing.
   * @param <E> The type of the element that is associated with the option.
   * @param <V> The type of value the option represents.
   * @param <O> The type of option.
   */
  public interface MissingOptionHandler<T, E extends IsElement<?>, V, O extends Option<V, E, O>> {

    /**
     * Called when an item is missing from the component.
     *
     * @param component The component where the item is missing.
     * @param token The token or identifier of the missing item.
     * @param onComplete A callback to be invoked once the missing item processing is complete.
     */
    void onMissingItem(T component, String token, Consumer<Option<V, E, O>> onComplete);
  }

  /**
   * This class represents an automatic validator for select components. It listens for selection
   * changes in the associated select component's options menu, and triggers validation accordingly.
   *
   * @param <T> The type of value the select represents.
   * @param <V> The actual value type.
   * @param <E> The type of the element associated with the select's option.
   * @param <S> The type of select option.
   * @param <C> The type of select component.
   */
  private static class SelectAutoValidator<
          T,
          V,
          E extends IsElement<?>,
          S extends Option<T, E, S>,
          C extends AbstractSelect<T, V, E, S, C>>
      extends AutoValidator {

    private C select;
    private HasSelectionListeners.SelectionListener<AbstractMenuItem<T>, List<AbstractMenuItem<T>>>
        listener;

    /**
     * Constructor for creating an instance of the auto validator for a given select component.
     *
     * @param select The select component to validate.
     * @param autoValidate The validation logic.
     */
    public SelectAutoValidator(C select, ApplyFunction autoValidate) {
      super(autoValidate);
      this.select = select;
    }

    /** Attaches the validator by setting up a listener to the select's options menu. */
    @Override
    public void attach() {
      listener = (source, selection) -> autoValidate.apply();
      select.getOptionsMenu().addSelectionListener(listener);
    }

    /** Removes the attached listener and cleans up any resources. */
    @Override
    public void remove() {
      select.getOptionsMenu().removeSelectionListener(listener);
    }
  }
}
