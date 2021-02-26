package org.dominokit.domino.ui.forms;

import elemental2.dom.DomGlobal;
import elemental2.dom.HTMLElement;
import org.dominokit.domino.ui.chips.Chip;
import org.dominokit.domino.ui.grid.flex.FlexItem;
import org.dominokit.domino.ui.style.Color;
import org.dominokit.domino.ui.style.Elevation;
import org.dominokit.domino.ui.utils.ElementUtil;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import static java.util.Objects.isNull;
import static java.util.Objects.nonNull;

public class MultiSelect<T> extends AbstractSelect<List<T>, T, MultiSelect<T>> {

    private static final String DEFAULT_SEPARATOR = ",";

    private ValueRenderer valueRenderer = this::renderSelectedOptions;
    private List<SelectOption<T>> selectedOptions = new ArrayList<>();
    private String selectedOptionsSeparator;
    private Color color = Color.THEME;

    public static <T> MultiSelect<T> create() {
        return new MultiSelect<>();
    }

    public static <T> MultiSelect<T> create(String label) {
        return new MultiSelect<>(label);
    }

    public static <T> MultiSelect<T> create(String label, List<SelectOption<T>> options) {
        return new MultiSelect<>(label, options);
    }

    public static <T> MultiSelect<T> create(List<SelectOption<T>> options) {
        return new MultiSelect<>(options);
    }

    public static <T extends Enum<T>> MultiSelect<T> ofEnum(String label, T[] values) {
        MultiSelect<T> select = create(label);
        for (T value : values) {
            select.appendChild(SelectOption.create(value, value.name(), value.toString()));
        }
        return select;
    }

    public MultiSelect() {
        super();
        setup();
    }

    public MultiSelect(String label) {
        super(label);
        setup();
    }

    public MultiSelect(String label, List<SelectOption<T>> options) {
        super(label, options);
        setup();
    }

    public MultiSelect(List<SelectOption<T>> options) {
        super(options);
        setup();
    }

    private void setup() {
        setOptionRenderer(new MultiOptionRenderer());
    }

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
        if (!silent)
            onSelection(option);
        return this;
    }

    @Override
    public MultiSelect<T> setValue(List<T> value, boolean silent) {
        if (isNull(value))
            return this;
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
                .map(tSelectOption -> {
                    Chip chip = Chip.create(tSelectOption.getDisplayValue())
                            .setRemovable(true)
                            .setColor(color)
                            .setBorderColor(color)
                            .elevate(Elevation.NONE);
                    chip.addRemoveHandler(() -> {
                        tSelectOption.deselect();
                        selectedOptions.remove(tSelectOption);
                        chip.remove(true);
                        showPlaceholder();
                        if (isAutoValidation())
                            validate();
                    });

                    return chip;
                })
                .forEach(valuesContainer::appendChild);
    }

    public List<SelectOption<T>> getSelectedOptions() {
        return selectedOptions;
    }

    @Override
    public List<T> getValue() {
        return selectedOptions.stream()
                .map(SelectOption::getValue)
                .collect(Collectors.toList());
    }

    public String getSelectedOptionsSeparator() {
        return selectedOptionsSeparator;
    }

    public void setSelectedOptionsSeparator(String selectedOptionsSeparator) {
        this.selectedOptionsSeparator = selectedOptionsSeparator;
    }

    @Override
    public String getStringValue() {
        return selectedOptions.stream()
                .map(SelectOption::getDisplayValue)
                .collect(Collectors.joining(isNull(selectedOptionsSeparator) ? DEFAULT_SEPARATOR : selectedOptionsSeparator));
    }

    @Override
    public MultiSelect<T> clear() {
        selectedOptions.clear();
        return super.clear();
    }

    public List<Integer> getSelectedIndex() {
        return getSelectedOptions()
                .stream()
                .map(option -> options.indexOf(option))
                .collect(Collectors.toList());
    }

    public void setValueRenderer(ValueRenderer valueRenderer) {
        this.valueRenderer = valueRenderer;
    }

    @Override
    protected void scrollToSelectedOption() {
        List<SelectOption<T>> selectedOptions = getSelectedOptions();
        if (nonNull(selectedOptions) && !selectedOptions.isEmpty()) {
            ElementUtil.scrollIntoParent(selectedOptions.get(0).element(), getOptionsMenu().getMenuElement().element());
        }
    }

    public MultiSelect<T> setColor(Color color) {
        this.color = color;
        return this;
    }

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
            option.getOptionLayoutElement()
                    .insertFirst(checkMarkFlexItem);
            option.addSelectionHandler(selectable -> {
                DomGlobal.console.info("select handler");
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
