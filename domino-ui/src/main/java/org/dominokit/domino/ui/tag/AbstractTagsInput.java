///*
// * Copyright © 2019 Dominokit
// *
// * Licensed under the Apache License, Version 2.0 (the "License");
// * you may not use this file except in compliance with the License.
// * You may obtain a copy of the License at
// *
// *     http://www.apache.org/licenses/LICENSE-2.0
// *
// * Unless required by applicable law or agreed to in writing, software
// * distributed under the License is distributed on an "AS IS" BASIS,
// * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
// * See the License for the specific language governing permissions and
// * limitations under the License.
// */
//package org.dominokit.domino.ui.tag;
//
//import static java.util.Objects.nonNull;
//import static org.jboss.elemento.Elements.input;
//
//import elemental2.dom.HTMLDivElement;
//import elemental2.dom.HTMLElement;
//import elemental2.dom.HTMLInputElement;
//import java.util.ArrayList;
//import java.util.List;
//import java.util.Map;
//import java.util.stream.Collectors;
//import org.dominokit.domino.ui.chips.Chip;
//import org.dominokit.domino.ui.dropdown.DropDownMenu;
//import org.dominokit.domino.ui.dropdown.DropDownPosition;
//import org.dominokit.domino.ui.dropdown.DropdownAction;
//import org.dominokit.domino.ui.forms.AbstractValueBox;
//import org.dominokit.domino.ui.forms.AutoValidator;
//import org.dominokit.domino.ui.forms.validations.InputAutoValidator;
//import org.dominokit.domino.ui.grid.flex.FlexItem;
//import org.dominokit.domino.ui.grid.flex.FlexLayout;
//import org.dominokit.domino.ui.grid.flex.FlexWrap;
//import org.dominokit.domino.ui.keyboard.KeyboardEvents;
//import org.dominokit.domino.ui.keyboard.KeyboardEvents.KeyboardEventOptions;
//import org.dominokit.domino.ui.style.ColorScheme;
//import org.dominokit.domino.ui.tag.store.TagsStore;
//import org.dominokit.domino.ui.utils.DominoElement;
//
///**
// * A component provides an input field which represents the data in tags
// *
// * <p>This component provides an input field which takes multiple values and each value is
// * represented in a tag. It also provides a suggestion feature to list all the items in a store for
// * the user to select from it.
// *
// * <p>Customize the component can be done by overwriting classes provided by {@link TagStyles}
// *
// * <p>For example:
// *
// * <pre>
// *     TagsInput.create("Free tag")
// *              .setPlaceholder("Type anything...")
// *              .value(Collections.singletonList("Hey! how are you?"))
// *
// *     // with a store
// *     Person schroeder_coleman = new Person(1, "Schroeder Coleman");
// *     LocalTagsStore personsStore =
// *         LocalTagsStore.create()
// *             .addItem("Schroeder Coleman", schroeder_coleman)
// *             .addItem("Renee Mcintyre", new Person(2, "Renee Mcintyre"))
// *             .addItem("Casey Garza", new Person(3, "Casey Garza"));
// *     TagsInput objectTags = TagsInput.create("Friends", personsStore);
// *     objectTags.setValue(Collections.singletonList(schroeder_coleman));
// * </pre>
// *
// * @param <V> the type of the object inside the input
// * @see AbstractValueBox
// */
//public abstract class AbstractTagsInput<T extends AbstractTagsInput<T, V>, V>
//    extends AbstractValueBox<T, HTMLElement, List<V>> {
//
//  private DominoElement<HTMLInputElement> tagTextInput;
//  private final List<Chip> chips = new ArrayList<>();
//  private final List<V> selectedItems = new ArrayList<>();
//  private TagsStore<V> store;
//  private DropDownMenu dropDownMenu;
//  private ColorScheme colorScheme = ColorScheme.INDIGO;
//  private int maxSize = -1;
//  private boolean userInputEnabled = true;
//  private FlexItem<HTMLDivElement> tagInputTextContainer;
//  private FlexLayout tagsContainer;
//  private boolean openOnFocus = true;
//
//  public AbstractTagsInput(String label, TagsStore<V> store) {
//    super("text", label);
//    init((T) this);
//    css("tags-input");
//    this.store = store;
//    floating();
//  }
//
//  @Override
//  protected HTMLElement createInputElement(String type) {
//    tagsContainer = FlexLayout.create().setWrap(FlexWrap.WRAP_TOP_TO_BOTTOM);
//
//    tagInputTextContainer = FlexItem.create().setFlexGrow(1);
//    tagTextInput = DominoElement.of(input(type)).addCss(TagStyles.TAG_TEXT_INPUT);
//    dropDownMenu = DropDownMenu.create(tagTextInput).setPosition(DropDownPosition.BOTTOM);
//
//    getInputContainer()
//        .addEventListener(
//            "click",
//            evt -> {
//              evt.stopPropagation();
//              openOnFocus = true;
//              DropDownMenu.closeAllMenus();
//              tagTextInput.element().focus();
//            });
//
//    tagTextInput.addClickListener(
//        evt -> {
//          evt.stopPropagation();
//          DropDownMenu.closeAllMenus();
//          search();
//        });
//
//    initListeners();
//
//    tagInputTextContainer.appendChild(tagTextInput);
//
//    tagsContainer.appendChild(tagInputTextContainer);
//    return tagsContainer.element();
//  }
//
//  private void initListeners() {
//    KeyboardEvents.listenOnKeyDown(tagTextInput)
//        .onEnter(
//            evt -> {
//              addTag();
//            })
//        .onTab(
//            evt -> {
//              if (dropDownMenu.isOpened() && dropDownMenu.hasActions()) {
//                evt.preventDefault();
//                dropDownMenu.focus();
//              } else {
//                unfocus();
//              }
//            })
//        .onCtrlBackspace(
//            evt -> {
//              chips.stream().reduce((first, second) -> second).ifPresent(Chip::remove);
//              search();
//            })
//        .onArrowUpDown(evt -> openMenu(true), KeyboardEventOptions.create().setPreventDefault(true))
//        .onEscape(evt -> dropDownMenu.close());
//
//    tagTextInput.addEventListener("input", evt -> search());
//    tagTextInput.addEventListener(
//        "focus",
//        evt -> {
//          if (openOnFocus) {
//            doFocus();
//            search();
//          }
//        });
//    tagTextInput.addEventListener(
//        "blur",
//        evt -> {
//          addTag();
//          unfocus();
//        });
//  }
//
//  private void addTag() {
//    String displayValue = tagTextInput.element().value;
//    if (displayValue.isEmpty()) {
//      openMenu();
//    } else {
//      V value = store.getItemByDisplayValue(displayValue);
//      if (nonNull(value)) {
//        appendChip(displayValue, value);
//      }
//    }
//  }
//
//  private void search() {
//    dropDownMenu.clearActions();
//    String searchValue = tagTextInput.element().value;
//    Map<String, V> valuesToShow = store.filter(searchValue);
//    valuesToShow.forEach(this::addDropDownAction);
//    openMenu();
//  }
//
//  private void addDropDownAction(String displayValue, V value) {
//    if (!selectedItems.contains(value)) {
//      dropDownMenu.appendChild(
//          DropdownAction.create(displayValue, displayValue)
//              .addSelectionHandler(
//                  selectedValue -> {
//                    appendChip(displayValue, value);
//                    tagTextInput.element().focus();
//                  }));
//    }
//  }
//
//  private void openMenu() {
//    openMenu(false);
//  }
//
//  private void openMenu(boolean focus) {
//    if (dropDownMenu.hasActions()) {
//      if (!dropDownMenu.isOpened()) {
//        dropDownMenu.open(focus);
//      } else if (focus) {
//        dropDownMenu.focus();
//      }
//    }
//  }
//
//  private void fireChangeEvent() {
//    callChangeHandlers();
//    tagTextInput.element().value = "";
//    validate();
//    if (isExceedsMaxSize()) {
//      disableAddValues();
//    } else {
//      enableAddValues();
//    }
//  }
//
//  @Override
//  protected void clearValue(boolean silent) {
//    chips.forEach(chip -> chip.remove(true));
//    chips.clear();
//    selectedItems.clear();
//    if (!silent) {
//      fireChangeEvent();
//    }
//  }
//
//  @Override
//  protected void doSetValue(List<V> values) {
//    clearValue();
//    if (nonNull(values)) {
//      for (V value : values) {
//        addValue(value);
//      }
//    }
//  }
//
//  /**
//   * @param store {@link TagsStore}
//   * @return same AbstractTagsInput instance
//   */
//  public T setTagsStore(TagsStore<V> store) {
//    this.store = store;
//    return (T) this;
//  }
//
//  /** @return store {@link TagsStore} */
//  public TagsStore<V> getTagsStore() {
//    return store;
//  }
//
//  /**
//   * Adds a new value.
//   *
//   * <p>The {@code value} itself should be exist in the store, in case of dynamic store, the value
//   * will be string and will be added automatically
//   *
//   * @param value the new value to add
//   * @return same instance
//   */
//  public T addValue(V value) {
//    String displayValue = store.getDisplayValue(value);
//    appendChip(displayValue, value);
//    return (T) this;
//  }
//
//  /**
//   * Appends a value as a chip with a display value
//   *
//   * @param displayValue the display of the value
//   * @param value the value object
//   */
//  public void appendChip(String displayValue, V value) {
//    Chip chip =
//        Chip.create(displayValue)
//            .setColorScheme(colorScheme)
//            .setRemovable(true)
//            .addRemoveHandler(() -> dropDownMenu.close())
//            .addClickListener(
//                evt -> {
//                  evt.stopPropagation();
//                  if (dropDownMenu.isOpened()) {
//                    dropDownMenu.close();
//                  }
//                });
//    appendChip(chip, value);
//  }
//
//  /**
//   * Appends a new chip representing to the value
//   *
//   * @param chip the {@link Chip}
//   * @param value the value object
//   */
//  public void appendChip(Chip chip, V value) {
//    if (!isExceedsMaxSize()) {
//      chip.addRemoveHandler(
//          () -> {
//            selectedItems.remove(value);
//            chips.remove(chip);
//            fireChangeEvent();
//          });
//      chips.add(chip);
//      selectedItems.add(value);
//      tagsContainer.insertBefore(FlexItem.of(chip.element()), tagInputTextContainer);
//      fireChangeEvent();
//    }
//  }
//
//  private boolean isExceedsMaxSize() {
//    return maxSize >= 0 && chips.size() >= maxSize;
//  }
//
//  /** {@inheritDoc} */
//  @Override
//  public boolean isEmpty() {
//    return selectedItems.isEmpty();
//  }
//
//  /** {@inheritDoc} */
//  @Override
//  public boolean isEmptyIgnoreSpaces() {
//    return isEmpty();
//  }
//
//  /** {@inheritDoc} */
//  @Override
//  public List<V> getValue() {
//    return selectedItems;
//  }
//
//  /** {@inheritDoc} */
//  @Override
//  public T setPlaceholder(String placeholder) {
//    tagTextInput.setAttribute("placeholder", placeholder);
//    return (T) this;
//  }
//
//  /**
//   * Sets the position of the suggestion drop down
//   *
//   * @param position the {@link DropDownPosition}
//   * @return same instance
//   */
//  public T setDropDownPosition(DropDownPosition position) {
//    dropDownMenu.setPosition(position);
//    return (T) this;
//  }
//
//  /** {@inheritDoc} */
//  @Override
//  public T disable() {
//    chips.forEach(Chip::disable);
//    tagTextInput.element().disabled = true;
//    return super.disable();
//  }
//
//  /** {@inheritDoc} */
//  @Override
//  public T enable() {
//    chips.forEach(Chip::enable);
//    tagTextInput.element().disabled = false;
//    return super.enable();
//  }
//
//  /**
//   * Sets the color scheme that will be used for tags
//   *
//   * @param colorScheme the {@link ColorScheme}
//   * @return same instance
//   */
//  public T setTagsColor(ColorScheme colorScheme) {
//    this.colorScheme = colorScheme;
//    chips.forEach(chip -> chip.setColorScheme(this.colorScheme));
//    return (T) this;
//  }
//
//  private void disableAddValues() {
//    if (userInputEnabled) tagTextInput.hide();
//  }
//
//  private void enableAddValues() {
//    if (userInputEnabled) tagTextInput.show();
//  }
//
//  /**
//   * Sets the maximum number of selected values
//   *
//   * @param maxSize the maximum size
//   * @return same instance
//   */
//  public T setMaxValue(int maxSize) {
//    this.maxSize = maxSize;
//
//    if (isExceedsMaxSize()) {
//      disableAddValues();
//    } else {
//      enableAddValues();
//    }
//
//    return (T) this;
//  }
//
//  /**
//   * Gets the maximum number of selected values
//   *
//   * @return the maximum size
//   */
//  public int getMaxValue() {
//    return maxSize;
//  }
//
//  /** {@inheritDoc} */
//  @Override
//  public String getStringValue() {
//    return getValue().stream().map(Object::toString).collect(Collectors.joining(","));
//  }
//
//  /**
//   * Disables the ability for typing in the input field and all values should be selected from the
//   * suggestion drop down
//   *
//   * @return same instance
//   */
//  public T disableUserInput() {
//    userInputEnabled = false;
//    tagTextInput.hide();
//    return (T) this;
//  }
//
//  /**
//   * Enables the ability for typing in the input field
//   *
//   * @return same instance
//   */
//  public T enableUserInput() {
//    userInputEnabled = true;
//    tagTextInput.show();
//    return (T) this;
//  }
//
//  @Override
//  protected AutoValidator createAutoValidator(AutoValidate autoValidate) {
//    return new InputAutoValidator<>(autoValidate);
//  }
//}
