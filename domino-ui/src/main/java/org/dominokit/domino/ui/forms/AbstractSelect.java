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

import static elemental2.dom.DomGlobal.window;
import static java.util.Objects.isNull;
import static java.util.Objects.nonNull;
import static org.dominokit.domino.ui.style.Unit.px;
import static org.jboss.elemento.Elements.button;
import static org.jboss.elemento.Elements.span;

import elemental2.dom.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedList;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import org.dominokit.domino.ui.dropdown.DropDownMenu;
import org.dominokit.domino.ui.dropdown.DropDownPosition;
import org.dominokit.domino.ui.dropdown.DropdownAction;
import org.dominokit.domino.ui.dropdown.DropdownActionsGroup;
import org.dominokit.domino.ui.grid.flex.FlexItem;
import org.dominokit.domino.ui.icons.BaseIcon;
import org.dominokit.domino.ui.icons.Icons;
import org.dominokit.domino.ui.icons.MdiIcon;
import org.dominokit.domino.ui.modals.ModalBackDrop;
import org.dominokit.domino.ui.style.Styles;
import org.dominokit.domino.ui.utils.DominoElement;

/**
 * The base implementation for dropdown select form fields components
 *
 * @param <T> The type of the field value
 * @param <V> The type of the single option value
 * @param <S> The type of the field extending from this class
 */
public abstract class AbstractSelect<T, V, S extends AbstractSelect<T, V, S>>
    extends AbstractValueBox<S, HTMLElement, T> {
  private static final String CLICK_EVENT = "click";

  protected SelectOption<V> noneOption = SelectOption.create(null, "none", "None");

  private DominoElement<HTMLButtonElement> buttonElement;
  protected DominoElement<HTMLElement> buttonValueContainer =
      DominoElement.of(span().css("select-value", Styles.ellipsis_text));
  private final DominoElement<HTMLElement> placeholderNode =
      DominoElement.of(span()).css("select-placeholder");
  protected final DominoElement<HTMLElement> valuesContainer = DominoElement.of(span());
  protected LinkedList<SelectOption<V>> options = new LinkedList<>();
  private DropDownMenu optionsMenu;
  private List<SelectionHandler<V>> selectionHandlers = new ArrayList<>();
  private Supplier<BaseIcon<?>> arrowIconSupplier = Icons.ALL::menu_down_mdi;
  private BaseIcon<?> arrowIcon;
  private OptionRenderer<V> optionRenderer = SelectOption::element;
  private boolean searchable;
  private boolean creatable;
  private boolean clearable;
  private FlexItem arrowIconContainer;
  private int popupWidth = 0;
  private String dropDirection = "auto";
  private boolean closePopOverOnOpen = false;
  private boolean autoCloseOnSelect = true;

  /** Creates an empty select */
  public AbstractSelect() {
    super("button", "");
    optionsMenu =
        DropDownMenu.create(fieldContainer).styler(style1 -> style1.add("select-option-menu"));
    optionsMenu.setAppendTarget(DomGlobal.document.body);
    optionsMenu.setAppendStrategy(DropDownMenu.AppendStrategy.FIRST);
    optionsMenu.setPosition(
        DominoFields.INSTANCE.getDefaultSelectPopupPosition().createPosition(this));
    optionsMenu.addOpenHandler(this::resumeFocusValidation);
    optionsMenu.addOpenHandler(this::scrollToSelectedOption);
    buttonElement.appendChild(buttonValueContainer);
    buttonValueContainer.appendChild(placeholderNode);
    buttonValueContainer.appendChild(valuesContainer);
    initListeners();
    dropdown();
    setSearchable(true);
    setCreatable(false);
    addChangeHandler(
        value -> {
          if (isNull(value)) {
            clear();
          }
        });
    css("d-select");
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
   * Ceate a select with empty label and a list of initial options
   *
   * @param options List of {@link SelectOption}
   */
  public AbstractSelect(List<SelectOption<V>> options) {
    this("", options);
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
    if (nonNull(arrowIcon)) {
      arrowIcon.addClickListener(clickListener);
    }

    buttonElement.addEventListener(CLICK_EVENT, clickListener);
    getLabelElement().addEventListener(CLICK_EVENT, clickListener);
    buttonElement.addEventListener("focus", evt -> focus());
    buttonElement.addEventListener("blur", evt -> unfocus());
    optionsMenu.addCloseHandler(
        () -> {
          this.focus();
          validate();
        });
  }

  /**
   * Sets a supplier for an icon to use as the dropdown arrow
   *
   * @param arrowIconSupplier Supplier for {@link BaseIcon}
   */
  public void setArrowIconSupplier(Supplier<BaseIcon<?>> arrowIconSupplier) {
    if (nonNull(arrowIconSupplier)) {
      this.arrowIconSupplier = arrowIconSupplier;
    }
  }

  /** {@inheritDoc} */
  @Override
  public S clear() {
    unfloatLabel();
    doClear();
    valuesContainer.setTextContent("");
    showPlaceholder();
    if (isAutoValidation()) validate();
    return (S) this;
  }

  /** Clear the current selection based on the implementation */
  protected abstract void doClear();

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
    optionsMenu.styler(
        style -> style.setWidth(getFieldInputContainer().getBoundingClientRect().width + "px"));
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
    optionsMenu.separator();
    return (S) this;
  }

  /**
   * Adds a select options group to the dropdown menu
   *
   * @param group {@link SelectOptionGroup}
   * @return same select instance
   */
  public S addGroup(SelectOptionGroup<V> group) {
    DropdownActionsGroup<SelectOption<V>> dropdownActionsGroup =
        DropdownActionsGroup.create(group.getTitleElement());
    for (SelectOption<V> option : group.getOptions()) {
      addOptionToGroup(dropdownActionsGroup, option);
    }
    group.setAddOptionConsumer(
        selectOption -> {
          addOptionToGroup(dropdownActionsGroup, selectOption);
        });

    optionsMenu.addGroup(dropdownActionsGroup);
    return (S) this;
  }

  private void addOptionToGroup(
      DropdownActionsGroup<SelectOption<V>> dropdownActionsGroup, SelectOption<V> option) {
    dropdownActionsGroup.appendChild(asDropDownAction(option));
    options.add(option);
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
   * Sets the dropdown menu width
   *
   * @param width int
   * @return same select instance
   */
  public S setPopupWidth(int width) {
    this.popupWidth = width;
    return (S) this;
  }

  /**
   * Adds an option to the select dropdown menu
   *
   * @param option {@link SelectOption}
   * @return same select instance
   */
  public S appendChild(SelectOption<V> option) {
    return appendChild(option, selectOptionDropdownAction -> {});
  }

  public S appendChild(SelectOption<V> option, Consumer<DropdownAction<SelectOption<V>>> andThen) {
    options.add(option);
    appendOptionValue(option, andThen);
    return (S) this;
  }

  /**
   * Insert an option as the first option in the dropdown menu
   *
   * @param option {@link SelectOption}
   * @return same select instance
   */
  public S insertFirst(SelectOption<V> option) {
    options.add(0, option);
    insertFirstOptionValue(option);
    return (S) this;
  }

  private void doSelectOption(SelectOption<V> option) {
    if (isEnabled()) {
      select(option);
      if (this.autoCloseOnSelect) {
        close();
      }
    }
  }

  private void appendOptionValue(
      SelectOption<V> option, Consumer<DropdownAction<SelectOption<V>>> andThen) {
    DropdownAction<SelectOption<V>> action = asDropDownAction(option);
    optionsMenu.appendChild(action);
    andThen.accept(action);
  }

  private void insertFirstOptionValue(SelectOption<V> option) {
    optionsMenu.insertFirst(asDropDownAction(option));
  }

  private DropdownAction<SelectOption<V>> asDropDownAction(SelectOption<V> option) {
    return DropdownAction.create(option, optionRenderer.element(option))
        .setAutoClose(this.autoCloseOnSelect)
        .setExcludeFromSearchResults(option.isExcludeFromSearchResults())
        .addSelectionHandler(value -> doSelectOption(option));
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
    if (index < options.size() && index >= 0) select(options.get(index), silent);
    return (S) this;
  }

  /**
   * @param index int
   * @return the {@link SelectOption} at the specified index if exists or else null
   */
  public SelectOption<V> getOptionAt(int index) {
    if (index < options.size() && index >= 0) return options.get(index);
    return null;
  }

  /** @return a List of all {@link SelectOption}s of this select component */
  public List<SelectOption<V>> getOptions() {
    return options;
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
  public boolean isSelected() {
    return !isEmpty();
  }

  /**
   * By default this will call the Selection Handlers and the Change handlers
   *
   * @param option the new selected {@link SelectOption}
   */
  protected void onSelection(SelectOption<V> option) {
    for (SelectionHandler<V> handler : selectionHandlers) {
      handler.onSelection(option);
    }
    for (ChangeHandler<? super T> c : changeHandlers) {
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
    buttonElement.enable();
    getLabelElement().enable();
    return (S) this;
  }

  /** {@inheritDoc} */
  @Override
  public S disable() {
    super.disable();
    buttonElement.disable();
    getLabelElement().disable();
    return (S) this;
  }

  /** {@inheritDoc} */
  @Override
  public boolean isEnabled() {
    return !buttonElement.hasAttribute("disabled");
  }

  /**
   * force open the select dropdown menu to open up by default
   *
   * @return same select instance
   */
  public S dropup() {
    this.dropDirection = "up";
    return (S) this;
  }

  private void onDropup() {
    if (searchable) {
      optionsMenu.appendChild(optionsMenu.getSearchContainer());
      optionsMenu.getSearchContainer().style().remove("pos-top").add("pos-bottom");
      optionsMenu.style().remove("pos-top").add("pos-bottom");
    }
  }

  /**
   * force open the select dropdown menu to open down by default
   *
   * @return same select instance
   */
  public S dropdown() {
    this.dropDirection = "down";
    return (S) this;
  }

  private void onDropdown() {
    if (searchable) {
      optionsMenu.insertFirst(optionsMenu.getSearchContainer());
      optionsMenu.getSearchContainer().style().remove("pos-bottom").add("pos-top");
      optionsMenu.style().remove("pos-bottom").add("pos-top");
    }
  }

  private MdiIcon getDropdownIcon() {
    return Icons.ALL.menu_down_mdi();
  }

  private MdiIcon getDropupIcon() {
    return Icons.ALL.menu_up_mdi();
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
      option.element().remove();
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
    if (nonNull(options) && !options.isEmpty() && !this.options.isEmpty()) {
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
    options.clear();
    optionsMenu.clearActions();
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
      arrowIconContainer.hide();
      floatLabel();
    } else {
      arrowIconContainer.show();
      if (isEmpty()) {
        unfloatLabel();
      }
    }
    buttonElement.setReadOnly(readOnly);
    return (S) this;
  }

  /**
   * Sets the option renderer
   *
   * @param optionRenderer the {@link OptionRenderer}
   * @return same instance
   */
  public S setOptionRenderer(OptionRenderer<V> optionRenderer) {
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
   * the select box is actually rendered with a button
   *
   * @return the {@link HTMLButtonElement} that is actually displaying the selected option
   */
  public DominoElement<HTMLButtonElement> getSelectButton() {
    return buttonElement;
  }

  /** @return the {@link HTMLLabelElement} of the select wrapped as {@link DominoElement} */
  public DominoElement<HTMLLabelElement> getSelectLabel() {
    return getLabelElement();
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
    return options.stream().map(SelectOption::getValue).collect(Collectors.toList());
  }

  /** @return a List of all String keys of all the options of this select */
  public List<String> getKeys() {
    return options.stream().map(SelectOption::getKey).collect(Collectors.toList());
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
    this.searchable = searchable;
    return (S) this;
  }

  /**
   * Enable/Disable on the fly option creation
   *
   * @param creatable boolean, if true a button will show up to allow the user to create a new
   *     select option and add it to the dropdown list
   * @return same select instance
   */
  public S setCreatable(boolean creatable) {
    optionsMenu.setCreatable(creatable);
    this.creatable = creatable;
    return (S) this;
  }

  /**
   * Adds a handler that will be called whenever we add a new option to the select using the {@link
   * #setCreatable(boolean)} feature
   *
   * @param onAddOptionHandler {@link OnAddOptionHandler}
   * @return same select instance
   */
  public S setOnAddOptionHandler(OnAddOptionHandler<V> onAddOptionHandler) {
    if (!isNull(onAddOptionHandler)) {
      optionsMenu.setOnAddListener(
          (String input) -> {
            onAddOptionHandler.onAddOption(
                input,
                createdOption -> {
                  if (!isNull(createdOption)) {
                    appendChild(createdOption);
                    select(createdOption);
                  }
                });
          });
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
    return searchable;
  }

  /** @return boolean, true is creatable feature is enabled on this select */
  public boolean isCreatable() {
    return creatable;
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
    if (clearable && !options.contains(noneOption)) {
      insertFirst(noneOption);
    } else {
      removeOption(noneOption);
    }
    return (S) this;
  }

  /** @return boolean, true if this select value can be cleared */
  public boolean isClearable() {
    return clearable;
  }

  /**
   * sets the text display for the none option from the {@link #setClearable(boolean)}
   *
   * @param clearableText String
   * @return same select instance
   */
  public S setClearableText(String clearableText) {
    noneOption.setDisplayValue(clearableText);
    return (S) this;
  }

  /**
   * @return String display value of the none option when {@link #setClearable(boolean)} is enabled
   */
  public String getClearableText() {
    return noneOption.getDisplayValue();
  }

  /** @return String dropdown direction <b>up</b> or <b>down</b> */
  public String getDropDirection() {
    return dropDirection;
  }

  /** @return the {@link HTMLElement} that contains the button of this select */
  public DominoElement<HTMLElement> getButtonValueContainer() {
    return buttonValueContainer;
  }

  /**
   * Sets a custom dropdown position for this select
   *
   * @param dropPosition {@link DropDownPosition}
   * @return same select instance
   */
  public S setDropPosition(DropDownPosition dropPosition) {
    optionsMenu.setPosition(dropPosition);
    return (S) this;
  }

  /** {@inheritDoc} for the select this will create a button element */
  @Override
  protected HTMLElement createInputElement(String type) {
    buttonElement = DominoElement.of(button().attr("type", "button").css("select-button"));
    return buttonElement.element();
  }

  /** {@inheritDoc} */
  @Override
  protected void showPlaceholder() {
    if (getPlaceholder() != null && shouldShowPlaceholder()) {
      placeholderNode.setTextContent(getPlaceholder());
    }
  }

  /** {@inheritDoc} */
  @Override
  protected void hidePlaceholder() {
    if (getPlaceholder() != null && !shouldShowPlaceholder()) {
      placeholderNode.clearElement();
    }
  }

  /** {@inheritDoc} for thes select this creates the dropdown menu arrow */
  @Override
  protected FlexItem createMandatoryAddOn() {
    if (isNull(arrowIconSupplier)) {
      arrowIcon = Icons.ALL.menu_down_mdi().clickable();
    } else {
      arrowIcon = arrowIconSupplier.get().clickable();
    }
    arrowIconContainer = FlexItem.create().appendChild(arrowIcon);
    return arrowIconContainer;
  }

  /** {@inheritDoc} */
  @Override
  protected void clearValue() {}

  /** {@inheritDoc} */
  @Override
  protected void doSetValue(T value) {}

  /**
   * Sets a custom search filter to be used when {@link #setSearchable(boolean)} is enabled
   *
   * @param searchFilter {@link org.dominokit.domino.ui.dropdown.DropDownMenu.SearchFilter}
   * @return same select instance
   */
  public S setSearchFilter(DropDownMenu.SearchFilter searchFilter) {
    this.optionsMenu.setSearchFilter(searchFilter);
    return (S) this;
  }

  /** @return the {@link DropDownMenu} of this select */
  public DropDownMenu getOptionsMenu() {
    return optionsMenu;
  }

  /** @return boolean, true if closePopOverOnOpen is enabled */
  public boolean isClosePopOverOnOpen() {
    return closePopOverOnOpen;
  }

  /**
   * Enable/Disable closing other popups in the screen when opens the select dropdown menu
   *
   * @param closePopOverOnOpen boolean, true to close other popups
   * @return same select instance
   */
  public S setClosePopOverOnOpen(boolean closePopOverOnOpen) {
    this.closePopOverOnOpen = closePopOverOnOpen;
    return (S) this;
  }

  /** @return boolean, true if the dropdown menu should close after selecting an option */
  public boolean isAutoCloseOnSelect() {
    return autoCloseOnSelect;
  }

  /**
   * @param autoCloseOnSelect boolean, if true the dropdown menu will close after selecting an
   *     option otherwise it remains open
   * @return same select instance
   */
  public S setAutoCloseOnSelect(boolean autoCloseOnSelect) {
    this.autoCloseOnSelect = autoCloseOnSelect;
    optionsMenu
        .getActions()
        .forEach(dropdownAction -> dropdownAction.setAutoClose(autoCloseOnSelect));
    return (S) this;
  }

  /**
   * implementation of this method will determine how the select will scroll to the selected option
   * when opens the dropdown menu
   */
  protected abstract void scrollToSelectedOption();

  /**
   * A {@link DropDownPosition} that opens the select dropdown menu up or down based on the largest
   * space available, the menu will show where the is more space
   *
   * @param <T> The type of the field value
   * @param <V> The type of the single option value
   * @param <S> The type of the field extending from this class
   */
  public static class PopupPositionTopDown<T, V, S extends AbstractSelect<T, V, S>>
      implements DropDownPosition {

    private DropDownPositionUp up = new DropDownPositionUp();
    private DropDownPositionDown down = new DropDownPositionDown();

    private final AbstractSelect<T, V, S> select;

    public PopupPositionTopDown(AbstractSelect<T, V, S> select) {
      this.select = select;
    }

    @Override
    public void position(HTMLElement popup, HTMLElement target) {
      DOMRect targetRect = target.getBoundingClientRect();

      double distanceToMiddle = ((targetRect.top) - (targetRect.height / 2));
      double windowMiddle = DomGlobal.window.innerHeight / 2;
      double popupHeight = popup.getElementsByClassName("dropdown-menu").getAt(0).getBoundingClientRect().height;
      double distanceToBottom = window.innerHeight - targetRect.bottom;
      double distanceToTop = (targetRect.top + targetRect.height);

      boolean hasSpaceBelow = distanceToBottom > popupHeight;
      boolean hasSpaceUp = distanceToTop > popupHeight;

      if (("up".equalsIgnoreCase(select.dropDirection) && hasSpaceUp)
          || ((distanceToMiddle >= windowMiddle) && !hasSpaceBelow)
          || (hasSpaceUp && !hasSpaceBelow)) {
        up.position(popup, target);
        select.onDropup();
        popup.setAttribute("popup-direction", "top");
      } else {
        down.position(popup, target);
        select.onDropdown();
        popup.setAttribute("popup-direction", "down");
      }

      popup.style.setProperty(
          "width", select.popupWidth > 0 ? (select.popupWidth + "px") : (targetRect.width + "px"));
    }
  }

  /** A {@link DropDownPosition} that opens the select dropdown menu always up */
  public static class DropDownPositionUp implements DropDownPosition {
    @Override
    public void position(HTMLElement actionsMenu, HTMLElement target) {

      DOMRect targetRect = target.getBoundingClientRect();

      actionsMenu.style.setProperty(
          "bottom", px.of(((window.innerHeight - targetRect.bottom) - window.pageYOffset)));
      actionsMenu.style.setProperty("left", px.of((targetRect.left + window.pageXOffset)));
      actionsMenu.style.removeProperty("top");
    }
  }

  /** A {@link DropDownPosition} that opens the select dropdown menu always down */
  public static class DropDownPositionDown implements DropDownPosition {
    @Override
    public void position(HTMLElement actionsMenu, HTMLElement target) {

      DOMRect targetRect = target.getBoundingClientRect();

      actionsMenu.style.setProperty("top", px.of((targetRect.top + window.pageYOffset)));
      actionsMenu.style.setProperty("left", px.of((targetRect.left + window.pageXOffset)));
      actionsMenu.style.removeProperty("bottom");
    }
  }

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
   * the {@link #setCreatable(boolean)} feature
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

  /**
   * An interface for rendering the {@link SelectOption}
   *
   * @param <T> the type of the object inside the option
   */
  @FunctionalInterface
  public interface OptionRenderer<T> {
    /**
     * @param option the option to render
     * @return the {@link HTMLElement} representing the option
     */
    HTMLElement element(SelectOption<T> option);
  }
}
