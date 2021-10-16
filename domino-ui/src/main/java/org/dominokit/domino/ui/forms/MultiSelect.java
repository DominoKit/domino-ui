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
import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;
import java.util.stream.Collectors;
import org.dominokit.domino.ui.chips.Chip;
import org.dominokit.domino.ui.dropdown.DropdownAction;
import org.dominokit.domino.ui.grid.flex.FlexItem;
import org.dominokit.domino.ui.style.Color;
import org.dominokit.domino.ui.style.Elevation;
import org.dominokit.domino.ui.utils.ElementUtil;

/**
 * A component that allow selecting multiple options from a DropDownMenu
 *
 * @param <T> The type of a single option value
 */
public class MultiSelect<T> extends AbstractSelect<List<T>, T, MultiSelect<T>> {

  private static final String DEFAULT_SEPARATOR = ",";

  private ValueRenderer valueRenderer = this::renderSelectedOptions;
  private List<SelectOption<T>> selectedOptions = new ArrayList<>();
  private String selectedOptionsSeparator;
  private Color color = Color.THEME;

  /**
   * Creates an instance without a label
   *
   * @param <T> Type the select options value
   * @return new MultiSelect instance
   */
  public static <T> MultiSelect<T> create() {
    return new MultiSelect<>();
  }

  /**
   * Creates an instance with a label
   *
   * @param label String
   * @param <T> Type the select options value
   * @return new MultiSelect instance
   */
  public static <T> MultiSelect<T> create(String label) {
    return new MultiSelect<>(label);
  }

  /**
   * Creates an instance with a label and initialized with a list of options
   *
   * @param label String
   * @param options List of {@link SelectOption}
   * @param <T> Type the select options value
   * @return new MultiSelect instance
   */
  public static <T> MultiSelect<T> create(String label, List<SelectOption<T>> options) {
    return new MultiSelect<>(label, options);
  }

  /**
   * Creates an instance without a label and initialized with a list of options
   *
   * @param options List of {@link SelectOption}
   * @param <T> Type the select options value
   * @return new MultiSelect instance
   */
  public static <T> MultiSelect<T> create(List<SelectOption<T>> options) {
    return new MultiSelect<>(options);
  }

  /**
   * Creates an instance with a label and initialized with options from an enum values
   *
   * @param label String
   * @param values T[] of enum values
   * @param <T> type of the enum
   * @return new MultiSelect instance
   */
  public static <T extends Enum<T>> MultiSelect<T> ofEnum(String label, T[] values) {
    MultiSelect<T> select = create(label);
    for (T value : values) {
      select.appendChild(SelectOption.create(value, value.name(), value.toString()));
    }
    return select;
  }

  /** Creates an instance without a label */
  public MultiSelect() {
    setup();
  }

  /**
   * Creates an instance with a label
   *
   * @param label String
   */
  public MultiSelect(String label) {
    super(label);
    setup();
  }

  /**
   * Creates an instance with a label and initialized with a list of options
   *
   * @param label String
   * @param options List of {@link SelectOption}
   */
  public MultiSelect(String label, List<SelectOption<T>> options) {
    super(label, options);
    setup();
  }

  /**
   * Creates an instance without a label and initialized with a list of options
   *
   * @param options List of {@link SelectOption}
   */
  public MultiSelect(List<SelectOption<T>> options) {
    super(options);
    setup();
  }

  private void setup() {
    fieldGroup.addCss("multi-select");
    noneOption.addCss("multi-select-option");
    setOptionRenderer(new MultiOptionRenderer());
  }

  /** {@inheritDoc} */
  @Override
  public MultiSelect<T> appendChild(
      SelectOption<T> option, Consumer<DropdownAction<SelectOption<T>>> andThen) {
    option.addCss("multi-select-option");
    return super.appendChild(option, andThen);
  }

  /** {@inheritDoc} */
  @Override
  public MultiSelect<T> select(SelectOption<T> option, boolean silent) {
    floatLabel();
    if (this.selectedOptions.contains(option)) {
      option.deselect(silent);
      selectedOptions.remove(option);
    } else {
      this.selectedOptions.add(option);
      option.select();
    }
    valueRenderer.render();
    hidePlaceholder();
    if (!silent) onSelection(option);
    return this;
  }

  /** {@inheritDoc} */
  @Override
  public MultiSelect<T> setValue(List<T> value, boolean silent) {
    if (isNull(value)) return this;
    for (SelectOption<T> option : getOptions()) {
      if (value.contains(option.getValue())) {
        select(option, silent);
      }
    }
    return this;
  }

  private void renderSelectedOptions() {
    valuesContainer.clearElement();
    selectedOptions.stream()
        .map(
            tSelectOption -> {
              Chip chip =
                  Chip.create(tSelectOption.getDisplayValue())
                      .setRemovable(!isReadOnly())
                      .setColor(color)
                      .setBorderColor(color)
                      .elevate(Elevation.NONE);
              chip.addRemoveHandler(
                  () -> {
                    tSelectOption.deselect();
                    selectedOptions.remove(tSelectOption);
                    chip.remove(true);
                    showPlaceholder();
                    if (isAutoValidation()) validate();
                  });

              return chip;
            })
        .forEach(valuesContainer::appendChild);
  }

  /** @return a List of all {@link SelectOption} selected */
  public List<SelectOption<T>> getSelectedOptions() {
    return selectedOptions;
  }

  /** {@inheritDoc} */
  @Override
  public List<T> getValue() {
    return selectedOptions.stream().map(SelectOption::getValue).collect(Collectors.toList());
  }

  /** @return String separator to display selected options */
  public String getSelectedOptionsSeparator() {
    return selectedOptionsSeparator;
  }

  /** @param selectedOptionsSeparator String separator to display selected options */
  public void setSelectedOptionsSeparator(String selectedOptionsSeparator) {
    this.selectedOptionsSeparator = selectedOptionsSeparator;
  }

  /**
   * {@inheritDoc}
   *
   * @return A comma separated string of all selected options
   */
  @Override
  public String getStringValue() {
    return selectedOptions.stream()
        .map(SelectOption::getDisplayValue)
        .collect(
            Collectors.joining(
                isNull(selectedOptionsSeparator) ? DEFAULT_SEPARATOR : selectedOptionsSeparator));
  }

  /** {@inheritDoc} */
  @Override
  protected void doClear() {
    selectedOptions.forEach(SelectOption::deselect);
    selectedOptions.clear();
  }

  /** @return List of Integer indices of all select options */
  public List<Integer> getSelectedIndex() {
    return getSelectedOptions().stream()
        .map(option -> options.indexOf(option))
        .collect(Collectors.toList());
  }

  /** @param valueRenderer {@link ValueRenderer} */
  public void setValueRenderer(ValueRenderer valueRenderer) {
    this.valueRenderer = valueRenderer;
  }

  /** {@inheritDoc} */
  @Override
  protected void scrollToSelectedOption() {
    List<SelectOption<T>> selectedOptions = getSelectedOptions();
    if (nonNull(selectedOptions) && !selectedOptions.isEmpty()) {
      ElementUtil.scrollIntoParent(
          selectedOptions.get(0).element(), getOptionsMenu().getMenuElement().element());
    }
  }

  /**
   * Sets the color of the options and the display values
   *
   * @param color A {@link Color}
   * @return same instance
   */
  public MultiSelect<T> setColor(Color color) {
    this.color = color;
    return this;
  }

  @Override
  public MultiSelect<T> setReadOnly(boolean readOnly) {
    super.setReadOnly(readOnly);
    valueRenderer.render();
    return this;
  }

  @Override
  public boolean isEmpty() {
    return isNull(getValue()) || getValue().isEmpty();
  }

  @Override
  public boolean isEmptyIgnoreSpaces() {
    return isEmpty();
  }

  /** a Function to define how we should render the select value */
  @FunctionalInterface
  public interface ValueRenderer {
    void render();
  }

  private class MultiOptionRenderer implements OptionRenderer<T> {

    @Override
    public HTMLElement element(SelectOption<T> option) {
      CheckBox checkMark = CheckBox.create().setColor(color).filledIn();
      FlexItem checkMarkFlexItem = FlexItem.create();
      checkMarkFlexItem.appendChild(checkMark);
      option.getOptionLayoutElement().insertFirst(checkMarkFlexItem);
      option.addSelectionHandler(
          selectable -> {
            if (selectable.isSelected()) {
              checkMark.check(true);
            } else {
              checkMark.uncheck(true);
            }
          });
      checkMark.addChangeHandler(value -> select(option));
      return option.element();
    }
  }
}
