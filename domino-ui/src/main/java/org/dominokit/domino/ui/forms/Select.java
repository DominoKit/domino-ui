package org.dominokit.domino.ui.forms;

import org.dominokit.domino.ui.dropdown.DropDownMenu;
import org.dominokit.domino.ui.utils.ElementUtil;

import java.util.List;
import java.util.Objects;

import static java.util.Objects.nonNull;

public class Select<T> extends AbstractSelect<T, T, Select<T>> {

    private SelectOption<T> selectedOption;

    public static <T> Select<T> create() {
        return new Select<>();
    }

    public static <T> Select<T> create(String label) {
        return new Select<>(label);
    }

    public static <T> Select<T> create(String label, List<SelectOption<T>> options) {
        return new Select<>(label, options);
    }

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

    public Select() {
    }

    public Select(String label) {
        super(label);
    }

    public Select(List<SelectOption<T>> options) {
        super(options);
    }

    public Select(String label, List<SelectOption<T>> options) {
        super(label, options);
    }

    @Override
    public DropDownMenu getOptionsMenu() {
        return super.getOptionsMenu();
    }

    @Override
    public Select<T> select(SelectOption<T> option, boolean silent) {
        if (selectedOption != null)
            if (!option.isEqualNode(selectedOption.element()))
                selectedOption.deselect();
        floatLabel();
        this.selectedOption = option;
        option.select();
        buttonValueContainer.setTextContent(option.getDisplayValue());
        if (!silent)
            onSelection(option);
        return this;
    }

    public SelectOption<T> getSelectedOption() {
        return selectedOption;
    }

    @Override
    public Select<T> setValue(T value, boolean silent) {
        for (SelectOption<T> option : getOptions()) {
            if (Objects.equals(option.getValue(), value)) {
                select(option, silent);
            }
        }
        return this;
    }

    @Override
    public T getValue() {
        return isSelected() ? getSelectedOption().getValue() : null;
    }

    @Override
    public String getStringValue() {
        SelectOption<T> selectedOption = getSelectedOption();
        if (nonNull(selectedOption)) {
            return selectedOption.getDisplayValue();
        }
        return null;
    }

    @Override
    public Select<T> clear() {
        this.selectedOption = null;
        return super.clear();
    }

    public int getSelectedIndex() {
        return options.indexOf(getSelectedOption());
    }

    @Override
    protected void scrollToSelectedOption() {
        if(nonNull(selectedOption)){
            ElementUtil.scrollIntoParent(selectedOption.element(), getOptionsMenu().getMenuElement().element());
        }
    }
}
