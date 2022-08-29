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
import static org.jboss.elemento.Elements.span;

import elemental2.dom.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.function.Consumer;
import java.util.stream.Collectors;
import org.dominokit.domino.ui.dropdown.DropDownMenu;
import org.dominokit.domino.ui.icons.Icons;
import org.dominokit.domino.ui.icons.MdiIcon;
import org.dominokit.domino.ui.menu.AbstractMenu;
import org.dominokit.domino.ui.menu.Menu;
import org.dominokit.domino.ui.menu.direction.BestMiddleUpDownDropDirection;
import org.dominokit.domino.ui.modals.ModalBackDrop;
import org.dominokit.domino.ui.utils.*;
import org.jboss.elemento.IsElement;

/**
 * The base implementation for dropdown select form fields components
 *
 * @param <T> The type of the field value
 * @param <V> The type of the single option value
 * @param <S> The type of the field extending from this class
 */
public abstract class AbstractSelect<T, V, S extends AbstractSelect<T, V, S>>
    extends AbstractValueBox<S, HTMLElement, T>
    implements SelectOptionRenderer<V>, SelectSearchFilter<V>, CanInitSelectOption<V> {
  protected final DominoElement<HTMLElement> valuesContainer = DominoElement.of(span());
  private Menu<V> optionsMenu;
  private List<SelectionHandler<V>> selectionHandlers = new ArrayList<>();
  private boolean clearable;
  private boolean closePopOverOnOpen = false;
  private DominoElement<HTMLElement> placeHolderElement;
  private DominoElement<HTMLDivElement> fieldInput;
  private MdiIcon clearIcon;
  private MdiIcon dropIcon;
  private SelectOptionRenderer<V> optionRenderer;
  private SelectSearchFilter searchFilter =
      (token, caseSensitive, selectOption) -> {
        if (selectOption.isExcludeFromSearchResults()) {
          return false;
        }
        if (isNull(token) || token.isEmpty()) {
          return true;
        }
        if (caseSensitive) {
          return selectOption.getDisplayValue().contains(token);
        } else {
          return selectOption.getDisplayValue().toLowerCase().contains(token.toLowerCase());
        }
      };;

  /** Creates an empty select */
  public AbstractSelect() {
    super("text");
    addCss(FORM_SELECT);
    optionsMenu =
        Menu.<V>create()
            .setTargetElement(this)
            .setAppendTarget(DomGlobal.document.body)
            .setDropDirection(new BestMiddleUpDownDropDirection());

    optionsMenu.addOpenHandler(this::resumeFocusValidation);
    optionsMenu.addOpenHandler(this::scrollToSelectedOption);

    initListeners();
    setSearchable(true);
    addChangeListener(
        value -> {
          if (isNull(value)) {
            clear();
          }
        });
  }

  /** Creates an empty select */
  public AbstractSelect(SelectOptionRenderer<V> optionRenderer) {
    this();
    setOptionRenderer(optionRenderer);
  }

  /**
   * Create an empty select with a lable
   *
   * @param label String
   */
  public AbstractSelect(String label) {
    this();
    setLabel(label);
  }

  /**
   * Create an empty select with a lable
   *
   * @param label String
   */
  public AbstractSelect(String label, SelectOptionRenderer<V> optionRenderer) {
    this();
    setLabel(label);
    setOptionRenderer(optionRenderer);
  }

  /**
   * Create a select field with a label and an initial options list
   *
   * @param label String
   * @param options List of {@link SelectOption}
   */
  public AbstractSelect(String label, List<SelectOption<V>> options) {
    this(label);
    options.forEach(this::appendChild);
  }

  /**
   * Create a select field with a label and an initial options list
   *
   * @param label String
   * @param options List of {@link SelectOption}
   */
  public AbstractSelect(
      String label, List<SelectOption<V>> options, SelectOptionRenderer<V> optionRenderer) {
    this(label);
    setOptionRenderer(optionRenderer);
    options.forEach(this::appendChild);
  }

  /**
   * Ceate a select with empty label and a list of initial options
   *
   * @param options List of {@link SelectOption}
   */
  public AbstractSelect(List<SelectOption<V>> options) {
    this();
    options.forEach(this::appendChild);
  }

  /**
   * Ceate a select with empty label and a list of initial options
   *
   * @param options List of {@link SelectOption}
   */
  public AbstractSelect(List<SelectOption<V>> options, SelectOptionRenderer<V> optionRenderer) {
    this();
    setOptionRenderer(optionRenderer);
    options.forEach(this::appendChild);
  }

  private void initListeners() {
    EventListener clickListener =
        evt -> {
          pauseFocusValidation();
          if (closePopOverOnOpen) {
            ModalBackDrop.closePopovers();
          }
          open();
          evt.stopPropagation();
        };

    withMandatoryAddOn(
        dropIcon = Icons.ALL.chevron_down_mdi().clickable().addClickListener(clickListener));

    withMandatoryAddOn(
        clearIcon = Icons.ALL.eraser_mdi().clickable().hide().addClickListener(evt -> clear()));

    fieldInput.addEventListener("click", clickListener);
    inputElement.get().addEventListener("focus", evt -> focus());
    inputElement.get().addEventListener("blur", evt -> unfocus());
    optionsMenu.addCloseHandler(
        () -> {
          this.focus();
          validate();
        });
  }

  @Override
  public S clear(boolean silent) {
    clearValue(silent);
    valuesContainer.setTextContent("");
    if (isAutoValidation()) validate();
    return (S) this;
  }

  /**
   * Opens the select dropdown menu
   *
   * @return same component instance
   */
  public S open() {
    if (isEnabled() && !isReadOnly()) {
      DropDownMenu.closeAllMenus();
      doOpen();
    }
    return (S) this;
  }

  private void doOpen() {
    optionsMenu.open();
    optionsMenu.styler(style -> style.setWidth(inputWrapper.getBoundingClientRect().width + "px"));
  }

  /** Closes the select dropdown menu */
  public S close() {
    optionsMenu.close();
    return (S) this;
  }

  /**
   * Adds a separator item between the select option in the dropdown menu
   *
   * @return same select instance
   */
  public S divider() {
    optionsMenu.appendSeparator();
    return (S) this;
  }

  /**
   * Adds a select options group to the dropdown menu
   *
   * @param group {@link SelectOptionGroup}
   * @return same select instance
   */
  public S addGroup(
      SelectOptionGroup<V> group,
      AbstractMenu.MenuItemsGroupHandler<V, SelectOption<V>, SelectOptionGroup<V>> handler) {
    optionsMenu.appendGroup(group, handler);
    return (S) this;
  }

  /**
   * Adds a List of options to the select dropdown menu
   *
   * @param options List of {@link SelectOption}
   * @return same select instance
   */
  public S addOptions(List<SelectOption<V>> options) {
    options.forEach(this::appendChild);
    return (S) this;
  }

  /**
   * Adds an option to the select dropdown menu
   *
   * @param option {@link SelectOption}
   * @return same select instance
   */
  public S appendChild(SelectOption<V> option) {
    initOption(option);
    optionsMenu.appendChild(option);
    return (S) this;
  }

  @Override
  public void initOption(SelectOption<V> option) {
    option.setSearchFilter(this);
    option.render(this);
  }

  private void doSelectOption(SelectOption<V> option) {
    if (isEnabled()) {
      select(option);
    }
  }

  /**
   * Selects the option at the specified index if exists and set its value as the select value
   *
   * @param index int
   * @return same select instance
   */
  public S selectAt(int index) {
    return selectAt(index, false);
  }

  /**
   * Selects the option at the specified index if exists and set its value as the select value
   *
   * @param index int
   * @param silent boolean, true to avoid triggering change handlers
   * @return same select instance
   */
  public S selectAt(int index, boolean silent) {
    if (index < optionsMenu.getMenuItems().size() && index >= 0) {
      optionsMenu.getMenuItems().get(index).select(silent);
    }
    return (S) this;
  }

  /**
   * @param index int
   * @return the {@link SelectOption} at the specified index if exists or else null
   */
  public SelectOption<V> getOptionAt(int index) {
    if (index < optionsMenu.getMenuItems().size() && index >= 0) {
      return (SelectOption<V>) optionsMenu.getMenuItems().get(index);
    }
    return null;
  }

  /** @return a List of all {@link SelectOption}s of this select component */
  public List<SelectOption<V>> getOptions() {
    return optionsMenu.getMenuItems().stream()
        .filter(menuItem -> !menuItem.isItemsGroup())
        .map(menuItem -> (SelectOption<V>) menuItem)
        .collect(Collectors.toList());
  }

  /**
   * Selects the specified option if it is one of this select options
   *
   * @param option {@link SelectOption}
   * @return same select instance
   */
  public S select(SelectOption<V> option) {
    return select(option, false);
  }

  /**
   * Selects the option at the specified index if exists and set its value as the select value
   *
   * @param option {@link SelectOption}
   * @param silent boolean, true to avoid triggering change handlers
   * @return same select instance
   */
  public abstract S select(SelectOption<V> option, boolean silent);

  /** @return boolean, true if the select has a selected option */
  public abstract boolean isSelected();

  /**
   * By default this will call the Selection Handlers and the Change handlers
   *
   * @param option the new selected {@link SelectOption}
   */
  protected void onSelection(SelectOption<V> option) {
    for (SelectionHandler<V> handler : selectionHandlers) {
      handler.onSelection(option);
    }
    for (ChangeListener<? super T> c : changeListeners) {
      c.onValueChanged(getValue());
    }
  }

  /**
   * @param selectionHandler {@link SelectionHandler}
   * @return same select instance
   */
  public S addSelectionHandler(SelectionHandler<V> selectionHandler) {
    selectionHandlers.add(selectionHandler);
    return (S) this;
  }

  /** {@inheritDoc} */
  @Override
  public S enable() {
    super.enable();
    inputElement.get().enable();
    return (S) this;
  }

  /** {@inheritDoc} */
  @Override
  public S disable() {
    super.disable();
    inputElement.get().disable();
    return (S) this;
  }

  /** {@inheritDoc} */
  @Override
  public boolean isEnabled() {
    return !inputElement.get().isDisabled();
  }

  /** {@inheritDoc} */
  @Override
  public S value(T value) {
    return setValue(value, false);
  }

  /**
   * Set the value with the ability to do so without triggering change handlers
   *
   * @param value T
   * @param silent boolean, true to avoid triggering change handlers
   * @return same select instance
   */
  public abstract S setValue(T value, boolean silent);

  /**
   * @param selectionHandler {@link SelectionHandler}
   * @return same select instance
   */
  public S removeSelectionHandler(SelectionHandler selectionHandler) {
    if (nonNull(selectionHandler)) selectionHandlers.remove(selectionHandler);
    return (S) this;
  }

  /**
   * Removes an option from the select dropdown menu
   *
   * @param option {@link SelectOption}
   * @return same select instance
   */
  public S removeOption(SelectOption<V> option) {
    if (nonNull(option) && getOptions().remove(option)) {
      option.deselect(true);
      option.remove();
    }
    return (S) this;
  }

  /**
   * Removes a list of options from the select dropdown menu
   *
   * @param options collection of {@link SelectOption}
   * @return same select instance
   */
  public S removeOptions(Collection<SelectOption<V>> options) {
    if (nonNull(options) && !options.isEmpty() && !getOptions().isEmpty()) {
      options.forEach(this::removeOption);
    }
    return (S) this;
  }

  /**
   * Removes all options from the select dropdown menu
   *
   * @return same select instance
   */
  public S removeAllOptions() {
    optionsMenu.removeAll();
    clear();
    if (isClearable()) {
      setClearable(true);
    }
    return (S) this;
  }

  /** {@inheritDoc} */
  @Override
  public S setReadOnly(boolean readOnly) {
    super.setReadOnly(readOnly);
    if (readOnly) {
      dropIcon.hide();
      clearIcon.hide();
    } else {
      dropIcon.show();
      clearIcon.toggleDisplay(clearable);
    }
    inputElement.get().setReadOnly(readOnly);
    return (S) this;
  }

  /**
   * Sets the option renderer
   *
   * @param optionRenderer the {@link SelectOptionRenderer}
   * @return same instance
   */
  public S setOptionRenderer(SelectOptionRenderer<V> optionRenderer) {
    this.optionRenderer = optionRenderer;
    return (S) this;
  }

  /**
   * A function to implement logic that will be called when the user change the selection in the
   * select
   *
   * @param <V> The type of the select value
   */
  @FunctionalInterface
  public interface SelectionHandler<V> {
    /** @param option the selected {@link SelectOption} */
    void onSelection(SelectOption<V> option);
  }

  /**
   * {@inheritDoc}
   *
   * @param autoValidate {@link AutoValidate}
   * @return the {@link AutoValidator} implementation for the select which is {@link
   *     SelectAutoValidator}
   */
  @Override
  protected AutoValidator createAutoValidator(AutoValidate autoValidate) {
    return new SelectAutoValidator<>(this, autoValidate);
  }

  private void setAddon(
      DominoElement<HTMLDivElement> container, DominoElement oldAddon, Element addon) {
    if (nonNull(oldAddon)) {
      oldAddon.remove();
    }
    if (nonNull(addon)) {
      List<String> oldClasses = new ArrayList<>(addon.classList.asList());
      for (String oldClass : oldClasses) {
        addon.classList.remove(oldClass);
      }
      oldClasses.add(0, "input-addon");
      for (String oldClass : oldClasses) {
        addon.classList.add(oldClass);
      }
      container.appendChild(addon);
    }
  }

  /** @return a List of all V values from all the options of this select */
  public List<V> getValues() {
    return getOptions().stream().map(SelectOption::getValue).collect(Collectors.toList());
  }

  /** @return a List of all String keys of all the options of this select */
  public List<String> getKeys() {
    return getOptions().stream().map(SelectOption::getKey).collect(Collectors.toList());
  }

  /**
   * Check if the select has an option with the specified key
   *
   * @param key String
   * @return boolean, true of option with that key exists
   */
  public boolean containsKey(String key) {
    return getKeys().contains(key);
  }

  /**
   * Check if the select has an option with the specified value
   *
   * @param value V
   * @return boolean, true of option with that value exists
   */
  public boolean containsValue(V value) {
    return getValues().contains(value);
  }

  /**
   * Disable/Enable search for the select.
   *
   * @param searchable boolean, if true a text box will show up in the dropdown menu to search for
   *     options
   * @return same select instance
   */
  public S setSearchable(boolean searchable) {
    optionsMenu.setSearchable(searchable);
    return (S) this;
  }

  /**
   * Adds a handler that will be called whenever we add a new option to the select using the {@link
   *
   * @param onAddOptionHandler {@link OnAddOptionHandler}
   * @return same select instance
   */
  public S setOnAddOptionHandler(OnAddOptionHandler<V> onAddOptionHandler) {
    if (!isNull(onAddOptionHandler)) {
      optionsMenu.setMissingItemHandler(
          (token, menu) -> onAddOptionHandler.onAddOption(token, menu::appendChild));
    }
    return (S) this;
  }

  /**
   * Closes the dropdown menu and call the handler
   *
   * @param closeMenuHandler {@link CloseMenuHandler}
   * @return same select instance
   */
  public S closeMenu(CloseMenuHandler closeMenuHandler) {
    optionsMenu.close();
    closeMenuHandler.onMenuClosed();
    return (S) this;
  }

  /** @return boolean, true if search is enabled on this select */
  public boolean isSearchable() {
    return optionsMenu.isSearchable();
  }

  /** @return boolean, true is creatable feature is enabled on this select */
  public boolean isCreatable() {
    return optionsMenu.isAllowCreateMissing();
  }

  /** closes all currently opened selects dropdown menus */
  public static void closeAllSelects() {
    DropDownMenu.closeAllMenus();
  }

  /**
   * Selects an option by its key if exists
   *
   * @param key String
   * @return same select instance
   */
  public S selectByKey(String key) {
    return selectByKey(key, false);
  }

  /**
   * Selects an option by its key if exists with ability to avoid triggering change handlers
   *
   * @param key String
   * @param silent boolean, true to avoid triggering change handlers
   * @return same select instance
   */
  public S selectByKey(String key, boolean silent) {
    for (SelectOption<V> option : getOptions()) {
      if (option.getKey().equals(key)) {
        select(option, silent);
      }
    }
    return (S) this;
  }

  /**
   * Enable/Disable the none option in the field
   *
   * @param clearable boolean, if true a none option will added to the select as the first option,
   *     when selected it actually nulls the select value
   * @return same select instance
   */
  public S setClearable(boolean clearable) {
    this.clearable = clearable;
    this.clearIcon.toggleDisplay(clearable);
    return (S) this;
  }

  /** @return boolean, true if this select value can be cleared */
  public boolean isClearable() {
    return clearable;
  }

  /** {@inheritDoc} for the select this will create a button element */
  @Override
  protected LazyChild<DominoElement<HTMLInputElement>> createInputElement(String type) {
    LazyChild<DominoElement<HTMLInputElement>> inputElement =
        LazyChild.of(DominoElement.input(type).addCss(HIDDEN_INPUT), inputWrapper);
    placeHolderElement = DominoElement.span().addCss(FIELD_PLACEHOLDER);
    fieldInput = DominoElement.div().addCss(FIELD_INPUT);
    inputWrapper.appendChild(fieldInput.appendChild(placeHolderElement));
    return inputElement;
  }

  @Override
  public S setPlaceholder(String placeholder) {
    placeHolderElement.setTextContent(placeholder);
    return (S) this;
  }

  /** {@inheritDoc} */
  @Override
  protected void doSetValue(T value) {}

  /**
   * Sets a custom search filter to be used when {@link #setSearchable(boolean)} is enabled
   *
   * @param searchFilter {@link org.dominokit.domino.ui.dropdown.DropDownMenu.SearchFilter}
   * @return same select instance
   */
  public S setSearchFilter(SelectSearchFilter<V> searchFilter) {
    if (nonNull(searchFilter)) {
      this.searchFilter = searchFilter;
    }
    return (S) this;
  }

  @Override
  public boolean onSearch(String token, boolean caseSensitive, SelectOption<V> selectOption) {
    return searchFilter.onSearch(token, caseSensitive, selectOption);
  }

  /** @return the {@link DropDownMenu} of this select */
  public Menu<V> getOptionsMenu() {
    return optionsMenu;
  }

  /** @return boolean, true if the dropdown menu should close after selecting an option */
  public boolean isAutoCloseOnSelect() {
    return optionsMenu.isAutoCloseOnSelect();
  }

  /**
   * @param autoCloseOnSelect boolean, if true the dropdown menu will close after selecting an
   *     option otherwise it remains open
   * @return same select instance
   */
  public S setAutoCloseOnSelect(boolean autoCloseOnSelect) {
    optionsMenu.setAutoCloseOnSelect(true);
    return (S) this;
  }

  @Override
  public IsElement<?> render(V value, String key, String displayValue) {
    return DominoElement.span().setTextContent(displayValue);
  }

  /**
   * implementation of this method will determine how the select will scroll to the selected option
   * when opens the dropdown menu
   */
  protected abstract void scrollToSelectedOption();

  private static class SelectAutoValidator<T, V, S extends AbstractSelect<T, V, S>>
      extends AutoValidator {

    private AbstractSelect<T, V, S> select;
    private SelectionHandler<V> selectionHandler;

    public SelectAutoValidator(AbstractSelect<T, V, S> select, AutoValidate autoValidate) {
      super(autoValidate);
      this.select = select;
    }

    /** {@inheritDoc} */
    @Override
    public void attach() {
      selectionHandler = option -> autoValidate.apply();
      select.addSelectionHandler(selectionHandler);
    }

    /** {@inheritDoc} */
    @Override
    public void remove() {
      select.removeSelectionHandler(selectionHandler);
    }
  }

  /**
   * A function for implementing logic to be executed when a new option is added on the fly using
   * the {@link #setClearable(boolean)} (boolean)} feature
   *
   * @param <V> the type of the select value
   */
  @FunctionalInterface
  public interface OnAddOptionHandler<V> {
    /**
     * Takes the user input and convert it into a SelectOption
     *
     * @param input String user input
     * @param completeHandler a callback Consumer of a {@link SelectOption} that should be called
     *     after creating the option
     */
    void onAddOption(String input, Consumer<SelectOption<V>> completeHandler);
  }

  /**
   * A function for implementing logic that will be executed whenever the select dropdown is closed
   *
   * @param <V> the type of the select value
   */
  @FunctionalInterface
  public interface CloseMenuHandler<V> {
    /** */
    void onMenuClosed();
  }
}
