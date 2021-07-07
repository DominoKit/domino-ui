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

import static java.util.Objects.nonNull;

import elemental2.dom.HTMLDivElement;
import elemental2.dom.HTMLElement;
import java.util.List;
import java.util.Objects;
import org.dominokit.domino.ui.dropdown.DropDownMenu;
import org.dominokit.domino.ui.grid.flex.FlexItem;
import org.dominokit.domino.ui.icons.Icon;
import org.dominokit.domino.ui.icons.Icons;
import org.dominokit.domino.ui.style.Styles;
import org.dominokit.domino.ui.utils.ElementUtil;

/**
 * A component that allow selecting a single option from a DropDownMenu
 *
 * @param <T> The type of a single option value
 */
public class Select<T> extends AbstractSelect<T, T, Select<T>> {

  private SelectOption<T> selectedOption;

  /**
   * Creates an instance without a label
   *
   * @param <T> Type the select options value
   * @return new Select instance
   */
  public static <T> Select<T> create() {
    return new Select<>();
  }

  /**
   * Creates an instance with a label
   *
   * @param label String
   * @param <T> Type the select options value
   * @return new Select instance
   */
  public static <T> Select<T> create(String label) {
    return new Select<>(label);
  }

  /**
   * Creates an instance with a label and initialized with a list of options
   *
   * @param label String
   * @param options List of {@link SelectOption}
   * @param <T> Type the select options value
   * @return new Select instance
   */
  public static <T> Select<T> create(String label, List<SelectOption<T>> options) {
    return new Select<>(label, options);
  }

  /**
   * Creates an instance without a label and initialized with a list of options
   *
   * @param options List of {@link SelectOption}
   * @param <T> Type the select options value
   * @return new Select instance
   */
  public static <T> Select<T> create(List<SelectOption<T>> options) {
    return new Select<>(options);
  }

  public static <T extends Enum<T>> Select<T> ofEnum(String label, T[] values) {
    Select<T> select = create(label);
    for (T value : values) {
      select.appendChild(SelectOption.create(value, value.name(), value.toString()));
    }
    return select;
  }

  /** Creates an instance without a label */
  public Select() {
    setOptionRenderer(new SingleOptionRenderer());
  }

  /**
   * Creates an instance with a label
   *
   * @param label String
   */
  public Select(String label) {
    super(label);
    setOptionRenderer(new SingleOptionRenderer());
  }

  /**
   * Creates an instance without a label and initialized with a list of options
   *
   * @param options List of {@link SelectOption}
   */
  public Select(List<SelectOption<T>> options) {
    super(options);
    setOptionRenderer(new SingleOptionRenderer());
  }

  /**
   * Creates an instance with a label and initialized with a list of options
   *
   * @param label String
   * @param options List of {@link SelectOption}
   */
  public Select(String label, List<SelectOption<T>> options) {
    super(label, options);
    setOptionRenderer(new SingleOptionRenderer());
  }

  /** {@inheritDoc} */
  @Override
  public DropDownMenu getOptionsMenu() {
    return super.getOptionsMenu();
  }

  /** {@inheritDoc} */
  @Override
  public Select<T> select(SelectOption<T> option, boolean silent) {
    if (nonNull(selectedOption) && !option.isEqualNode(selectedOption.element())) {
      selectedOption.deselect();
    }
    floatLabel();
    this.selectedOption = option;
    option.select();
    valuesContainer.setTextContent(option.getDisplayValue());
    hidePlaceholder();
    if (!silent) onSelection(option);
    return this;
  }

  /** @return The currently Select {@link SelectOption} */
  public SelectOption<T> getSelectedOption() {
    return selectedOption;
  }

  /** {@inheritDoc} */
  @Override
  public Select<T> setValue(T value, boolean silent) {
    if (isNull(value)) {
      // same as clear & doClear but pass silent to deselect
      if (nonNull(selectedOption)) {
        unfloatLabel();
        selectedOption.deselect(silent);
        selectedOption = null;
        valuesContainer.setTextContent("");
        showPlaceholder();
      }
    } else {
      for (SelectOption<T> option : getOptions()) {
        if (Objects.equals(option.getValue(), value)) {
          select(option, silent);
        }
      }
    }
    return this;
  }

  /** {@inheritDoc} */
  @Override
  public T getValue() {
    return isSelected() ? getSelectedOption().getValue() : null;
  }

  /** {@inheritDoc} */
  @Override
  public String getStringValue() {
    SelectOption<T> selectedOption = getSelectedOption();
    if (nonNull(selectedOption)) {
      return selectedOption.getDisplayValue();
    }
    return null;
  }

  /** {@inheritDoc} */
  @Override
  protected void doClear() {
    if (nonNull(selectedOption)) {
      selectedOption.deselect();
      selectedOption = null;
    }
  }

  /** @return int index of selected {@link SelectOption} */
  public int getSelectedIndex() {
    return options.indexOf(getSelectedOption());
  }

  /** {@inheritDoc} */
  @Override
  protected void scrollToSelectedOption() {
    if (nonNull(selectedOption)) {
      ElementUtil.scrollIntoParent(
          selectedOption.element(), getOptionsMenu().getMenuElement().element());
    }
  }

  private class SingleOptionRenderer implements OptionRenderer<T> {

    @Override
    public HTMLElement element(SelectOption<T> option) {
      Icon checkMark =
          Icons.ALL
              .check()
              .styler(style1 -> style1.add(Styles.pull_right).add("select-option-check-mark"));
      FlexItem<HTMLDivElement> checkMarkFlexItem = FlexItem.create();
      checkMarkFlexItem.appendChild(checkMark);
      option.getOptionLayoutElement().appendChild(checkMarkFlexItem);

      checkMark.toggleDisplay(option.isSelected());
      option.addSelectionHandler(selectable -> checkMark.toggleDisplay(selectable.isSelected()));
      return option.element();
    }
  }
}
