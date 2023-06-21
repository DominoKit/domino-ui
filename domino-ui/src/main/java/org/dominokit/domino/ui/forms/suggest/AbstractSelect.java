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

import elemental2.dom.DomGlobal;
import elemental2.dom.HTMLElement;
import elemental2.dom.HTMLInputElement;
import java.util.*;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.stream.Collectors;
import jsinterop.base.Js;
import org.dominokit.domino.ui.IsElement;
import org.dominokit.domino.ui.elements.DivElement;
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
 * Abstract AbstractSelect class.
 *
 * @author vegegoku
 * @version $Id: $Id
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
  private DominoElement<HTMLInputElement> inputElement;

  /** Constructor for AbstractSelect. */
  public AbstractSelect() {
    placeHolderElement = span();
    addCss(dui_form_select);
    wrapperElement
        .appendChild(
            fieldInput =
                div()
                    .addCss(dui_field_input)
                    .appendChild(placeHolderElement.addCss(dui_field_placeholder)))
        .appendChild(inputElement = input(getType()).addCss(dui_hidden_input).toDominoElement());
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
                        .ifPresent(meta -> onOptionSelected(meta.getOption())))
            .addDeselectionListener(
                (source, selection) ->
                    source
                        .flatMap(OptionMeta::<T, E, O>get)
                        .ifPresent(meta -> onOptionDeselected(meta.getOption())))
            .addCollapseListener((menu) -> focus());

    getInputElement()
        .onKeyDown(
            keyEvents ->
                keyEvents.onEnter(evt -> openOptionMenu()).onSpace(evt -> openOptionMenu()));

    appendChild(
        PrimaryAddOn.of(
            Icons.chevron_down()
                .addCss(dui_form_select_drop_arrow)
                .clickable()
                .addClickListener(evt -> openOptionMenu())));

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
  }

  private void openOptionMenu() {
    if (isReadOnly() || isDisabled()) {
      return;
    }
    optionsMenu.open(true);
  }

  /**
   * asValue.
   *
   * @param singleValue a T object
   * @return a V object
   */
  protected V asValue(T singleValue) {
    return (V) singleValue;
  }

  /** updateTextValue. */
  protected void updateTextValue() {
    getInputElement().element().value = getStringValue();
  }

  /**
   * clearValue.
   *
   * @param silent a boolean
   * @return a C object
   */
  protected C clearValue(boolean silent) {
    if (!optionsMenu.getSelection().isEmpty()) {
      V oldValue = getValue();
      optionsMenu.withPauseSelectionListenersToggle(
          true, field -> optionsMenu.getSelection().forEach(AbstractMenuItem::deselect));

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
   * appendChild.
   *
   * @param option a O object
   * @return a C object
   */
  public C appendChild(O option) {
    if (nonNull(option)) {
      optionsMenu.appendChild(option.getMenuItem());
    }
    return (C) this;
  }

  /**
   * appendOptions.
   *
   * @param options a {@link java.util.Collection} object
   * @return a C object
   */
  public C appendOptions(Collection<O> options) {
    if (nonNull(options)) {
      options.forEach(this::appendChild);
    }
    return (C) this;
  }

  /**
   * appendOptions.
   *
   * @param options a O object
   * @return a C object
   */
  public C appendOptions(O... options) {
    if (nonNull(options)) {
      appendOptions(Arrays.asList(options));
    }
    return (C) this;
  }

  /**
   * appendItem.
   *
   * @param mapper a {@link java.util.function.Function} object
   * @param item a I object
   * @param <I> a I class
   * @return a C object
   */
  public <I> C appendItem(Function<I, O> mapper, I item) {
    return appendChild(mapper.apply(item));
  }

  /**
   * appendItems.
   *
   * @param mapper a {@link java.util.function.Function} object
   * @param items a {@link java.util.Collection} object
   * @param <I> a I class
   * @return a C object
   */
  public <I> C appendItems(Function<I, O> mapper, Collection<I> items) {
    items.forEach(item -> appendItem(mapper, item));
    return (C) this;
  }

  /**
   * appendItems.
   *
   * @param mapper a {@link java.util.function.Function} object
   * @param items a I object
   * @param <I> a I class
   * @return a C object
   */
  public <I> C appendItems(Function<I, O> mapper, I... items) {
    appendItems(mapper, Arrays.asList(items));
    return (C) this;
  }

  /**
   * appendChild.
   *
   * @param separator a {@link org.dominokit.domino.ui.utils.Separator} object
   * @param <I> a I class
   * @return a C object
   */
  public <I> C appendChild(Separator separator) {
    optionsMenu.appendChild(separator);
    return (C) this;
  }

  /** {@inheritDoc} */
  @Override
  public String getPlaceholder() {
    return placeHolderElement.getTextContent();
  }

  /** {@inheritDoc} */
  @Override
  public C setPlaceholder(String placeholder) {
    placeHolderElement.setTextContent(placeholder);
    return (C) this;
  }

  /** {@inheritDoc} */
  @Override
  public DominoElement<HTMLInputElement> getInputElement() {
    return inputElement;
  }

  /** {@inheritDoc} */
  @Override
  public String getStringValue() {
    return optionsMenu.getSelection().stream()
        .map(option -> String.valueOf(option.getValue()))
        .collect(Collectors.joining(","));
  }

  /** {@inheritDoc} */
  @Override
  public C focus() {
    inputElement.element().focus();
    return (C) this;
  }

  /** {@inheritDoc} */
  @Override
  public C unfocus() {
    inputElement.element().blur();
    return (C) this;
  }

  /** {@inheritDoc} */
  @Override
  public boolean isFocused() {
    if (nonNull(DomGlobal.document.activeElement)) {
      String dominoId =
          elementOf(Js.<HTMLElement>uncheckedCast(DomGlobal.document.activeElement)).getDominoId();
      return nonNull(formElement.querySelector("[domino-uuid=\"" + dominoId + "\"]"));
    }
    return false;
  }

  /** {@inheritDoc} */
  @Override
  public boolean isEmpty() {
    return isNull(getValue());
  }

  /** {@inheritDoc} */
  @Override
  public boolean isEmptyIgnoreSpaces() {
    return isEmpty();
  }

  /** {@inheritDoc} */
  @Override
  public boolean isEnabled() {
    return !getInputElement().isDisabled() && super.isEnabled();
  }

  /** {@inheritDoc} */
  @Override
  public C clear() {
    return clear(false);
  }

  /** {@inheritDoc} */
  @Override
  public C clear(boolean silent) {
    return clearValue(silent);
  }

  /** {@inheritDoc} */
  @Override
  public AutoValidator createAutoValidator(ApplyFunction autoValidate) {
    return new SelectAutoValidator<>((C) this, autoValidate);
  }

  /** {@inheritDoc} */
  @Override
  public C triggerChangeListeners(V oldValue, V newValue) {
    getChangeListeners()
        .forEach(changeListener -> changeListener.onValueChanged(oldValue, newValue));
    return (C) this;
  }

  /** {@inheritDoc} */
  @Override
  public C triggerClearListeners(V oldValue) {
    getClearListeners().forEach(clearListener -> clearListener.onValueCleared(oldValue));
    return (C) this;
  }

  /** {@inheritDoc} */
  @Override
  public String getName() {
    return getInputElement().element().name;
  }

  /** {@inheritDoc} */
  @Override
  public C setName(String name) {
    getInputElement().element().name = name;
    return (C) this;
  }

  /** {@inheritDoc} */
  @Override
  public String getType() {
    return "text";
  }

  /** {@inheritDoc} */
  @Override
  public C withValue(V value) {
    return withValue(value, isChangeListenersPaused());
  }

  /**
   * addOptionsGroup.
   *
   * @param options a {@link java.util.Collection} object
   * @param groupHandler a {@link org.dominokit.domino.ui.menu.Menu.MenuItemsGroupHandler} object
   * @return a C object
   */
  public C addOptionsGroup(
      Collection<O> options, Menu.MenuItemsGroupHandler<T, AbstractMenuItem<T>> groupHandler) {
    MenuItemsGroup<T> optionsGroup = new MenuItemsGroup<>(optionsMenu);
    optionsMenu.appendGroup(optionsGroup, groupHandler);
    options.forEach(option -> addItemToGroup(optionsGroup, option));
    return (C) this;
  }

  /**
   * group.
   *
   * @param groupHandler a {@link org.dominokit.domino.ui.menu.Menu.MenuItemsGroupHandler} object
   * @param options a {@link java.util.Collection} object
   * @return a C object
   */
  public C group(
      Menu.MenuItemsGroupHandler<T, AbstractMenuItem<T>> groupHandler, Collection<O> options) {
    return addOptionsGroup(options, groupHandler);
  }

  private void addItemToGroup(MenuItemsGroup<T> optionsGroup, O option) {
    optionsGroup.appendChild(option.getMenuItem());
  }

  /** {@inheritDoc} */
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
   * withOption.
   *
   * @param option a O object
   * @return a C object
   */
  public C withOption(O option) {
    return withOption(option, isChangeListenersPaused());
  }

  /**
   * withOption.
   *
   * @param option a O object
   * @param silent a boolean
   * @return a C object
   */
  protected abstract C withOption(O option, boolean silent);

  // Should be abstract
  /**
   * doSetValue.
   *
   * @param value a V object
   */
  protected abstract void doSetValue(V value);

  /**
   * doSetOption.
   *
   * @param option a O object
   */
  protected abstract void doSetOption(O option);

  /** {@inheritDoc} */
  @Override
  public void setValue(V value) {
    withValue(value);
  }

  /**
   * selectOption.
   *
   * @param option a O object
   * @return a C object
   */
  public C selectOption(O option) {
    findOption(option)
        .ifPresent(menuItem -> menuItem.getMenuItem().select(isChangeListenersPaused()));
    return (C) this;
  }

  /**
   * getSelectedIndex.
   *
   * @return a int
   */
  public int getSelectedIndex() {
    return getOptionsMenu().getSelection().stream()
        .findFirst()
        .map(item -> getOptionsMenu().getFlatMenuItems().indexOf(item))
        .orElse(-1);
  }

  /**
   * findOption.
   *
   * @param option a O object
   * @return a {@link java.util.Optional} object
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
   * findOptionByKey.
   *
   * @param key a {@link java.lang.String} object
   * @return a {@link java.util.Optional} object
   */
  public Optional<O> findOptionByKey(String key) {
    return optionsMenu.getFlatMenuItems().stream()
        .filter(menuItem -> Objects.equals(key, menuItem.getKey()))
        .filter(menuItem -> OptionMeta.get(menuItem).isPresent())
        .map(menuItem -> OptionMeta.<T, E, O>get(menuItem).get().getOption())
        .findFirst();
  }

  /**
   * findOptionByValue.
   *
   * @param value a T object
   * @return a {@link java.util.Optional} object
   */
  public Optional<O> findOptionByValue(T value) {
    return optionsMenu.getFlatMenuItems().stream()
        .filter(menuItem -> Objects.equals(value, menuItem.getValue()))
        .filter(menuItem -> OptionMeta.get(menuItem).isPresent())
        .map(menuItem -> OptionMeta.<T, E, O>get(menuItem).get().getOption())
        .findFirst();
  }

  /**
   * findOptionByIndex.
   *
   * @param index a int
   * @return a {@link java.util.Optional} object
   */
  public Optional<O> findOptionByIndex(int index) {
    if (index < optionsMenu.getFlatMenuItems().size() && index >= 0) {
      AbstractMenuItem<T> menuItem = optionsMenu.getFlatMenuItems().get(index);
      return Optional.ofNullable(OptionMeta.<T, E, O>get(menuItem).get().getOption());
    }
    return Optional.empty();
  }

  /**
   * onOptionSelected.
   *
   * @param option a O object
   */
  protected abstract void onOptionSelected(O option);

  /**
   * onOptionDeselected.
   *
   * @param option a O object
   */
  protected abstract void onOptionDeselected(O option);

  /**
   * selectAt.
   *
   * @param index a int
   * @return a C object
   */
  public C selectAt(int index) {
    findOptionByIndex(index).ifPresent(this::onOptionSelected);
    return (C) this;
  }

  /**
   * selectByKey.
   *
   * @param key a {@link java.lang.String} object
   * @return a C object
   */
  public C selectByKey(String key) {
    findOptionByKey(key).ifPresent(this::onOptionDeselected);
    return (C) this;
  }

  /**
   * selectByValue.
   *
   * @param value a T object
   * @return a C object
   */
  public C selectByValue(T value) {
    findOptionByValue(value).ifPresent(this::onOptionSelected);
    return (C) this;
  }

  /**
   * containsKey.
   *
   * @param key a {@link java.lang.String} object
   * @return a boolean
   */
  public boolean containsKey(String key) {
    return findOptionByKey(key).isPresent();
  }

  /**
   * containsValue.
   *
   * @param value a T object
   * @return a boolean
   */
  public boolean containsValue(T value) {
    return findOptionByValue(value).isPresent();
  }

  /**
   * setClearable.
   *
   * @param clearable a boolean
   * @return a C object
   */
  public C setClearable(boolean clearable) {
    addCss(BooleanCssClass.of(dui_clearable, clearable));
    return (C) this;
  }

  /**
   * isClearable.
   *
   * @return a boolean
   */
  public boolean isClearable() {
    return containsCss(dui_clearable.getCssClass());
  }

  /**
   * setAutoCloseOnSelect.
   *
   * @param autoClose a boolean
   * @return a C object
   */
  public C setAutoCloseOnSelect(boolean autoClose) {
    optionsMenu.setAutoCloseOnSelect(autoClose);
    return (C) this;
  }

  /**
   * isAutoCloseOnSelect.
   *
   * @return a boolean
   */
  public boolean isAutoCloseOnSelect() {
    return optionsMenu.isAutoCloseOnSelect();
  }

  /**
   * setSearchable.
   *
   * @param searchable a boolean
   * @return a C object
   */
  public C setSearchable(boolean searchable) {
    optionsMenu.setSearchable(searchable);
    return (C) this;
  }

  /**
   * isSearchable.
   *
   * @return a boolean
   */
  public boolean isSearchable() {
    return optionsMenu.isSearchable();
  }

  /**
   * setSearchFilter.
   *
   * @return a C object
   */
  public C setSearchFilter() {

    return (C) this;
  }

  /**
   * isAllowCreateMissing.
   *
   * @return a boolean
   */
  public boolean isAllowCreateMissing() {
    return optionsMenu.isAllowCreateMissing();
  }

  /**
   * Getter for the field <code>optionsMenu</code>.
   *
   * @return a {@link org.dominokit.domino.ui.menu.Menu} object
   */
  public Menu<T> getOptionsMenu() {
    return optionsMenu;
  }

  /**
   * withOptionsMenu.
   *
   * @param handler a {@link org.dominokit.domino.ui.utils.ChildHandler} object
   * @return a C object
   */
  public C withOptionsMenu(ChildHandler<C, Menu<T>> handler) {
    handler.apply((C) this, optionsMenu);
    return (C) this;
  }

  /**
   * setMissingItemHandler.
   *
   * @param missingOptionHandler a {@link
   *     org.dominokit.domino.ui.forms.suggest.AbstractSelect.MissingOptionHandler} object
   * @return a C object
   */
  public C setMissingItemHandler(MissingOptionHandler<C, E, T, O> missingOptionHandler) {
    if (nonNull(missingOptionHandler)) {
      optionsMenu.setMissingItemHandler(
          (token, menu) -> missingOptionHandler.onMissingItem((C) this, token, menu::appendChild));
    } else {
      optionsMenu.setMissingItemHandler(null);
    }
    return (C) this;
  }

  /**
   * removeOption.
   *
   * @param option a O object
   * @return a C object
   */
  public C removeOption(O option) {
    findOption(option)
        .ifPresent(
            found -> {
              option.remove();
              optionsMenu.removeItem(found.getMenuItem());
            });
    return (C) this;
  }

  /**
   * removeOptions.
   *
   * @param options a {@link java.util.Collection} object
   * @return a C object
   */
  public C removeOptions(Collection<O> options) {
    options.forEach(this::removeOption);
    return (C) this;
  }

  /**
   * removeOptions.
   *
   * @param options a O object
   * @return a C object
   */
  public C removeOptions(O... options) {
    Arrays.asList(options).forEach(this::removeOption);
    return (C) this;
  }

  /**
   * removeAllOptions.
   *
   * @return a C object
   */
  public C removeAllOptions() {
    new ArrayList<>(optionsMenu.getMenuItems())
        .forEach(
            menuItem -> {
              removeOption(OptionMeta.<T, E, O>get(menuItem).get().getOption());
            });
    return (C) this;
  }

  public interface MissingOptionHandler<T, E extends IsElement<?>, V, O extends Option<V, E, O>> {
    void onMissingItem(T component, String token, Consumer<Option<V, E, O>> onComplete);
  }

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

    public SelectAutoValidator(C select, ApplyFunction autoValidate) {
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
