package org.dominokit.domino.ui.tag;

import elemental2.dom.HTMLDivElement;
import elemental2.dom.HTMLInputElement;
import org.dominokit.domino.ui.chips.Chip;
import org.dominokit.domino.ui.dropdown.DropDownMenu;
import org.dominokit.domino.ui.dropdown.DropDownPosition;
import org.dominokit.domino.ui.dropdown.DropdownAction;
import org.dominokit.domino.ui.forms.ValueBox;
import org.dominokit.domino.ui.keyboard.KeyboardEvents;
import org.dominokit.domino.ui.keyboard.KeyboardEvents.KeyboardEventOptions;
import org.dominokit.domino.ui.style.ColorScheme;
import org.dominokit.domino.ui.tag.store.DynamicLocalTagsStore;
import org.dominokit.domino.ui.tag.store.TagsStore;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import static java.util.Objects.nonNull;
import static org.jboss.gwt.elemento.core.Elements.div;
import static org.jboss.gwt.elemento.core.Elements.input;

public class TagsInput<V> extends ValueBox<TagsInput<V>, HTMLDivElement, List<V>> {

    private HTMLInputElement tagTextInput;
    private final List<Chip> chips = new ArrayList<>();
    private final List<V> selectedItems = new ArrayList<>();
    private final TagsStore<V> store;
    private DropDownMenu dropDownMenu;
    private ColorScheme colorScheme = ColorScheme.INDIGO;

    public TagsInput(String label, TagsStore<V> store) {
        super("text", label);
        this.store = store;
        floating();
    }

    public static TagsInput<String> create() {
        return create("");
    }

    public static TagsInput<String> create(String label) {
        return create(label, new DynamicLocalTagsStore());
    }

    public static <V> TagsInput<V> create(TagsStore<V> store) {
        return create("", store);
    }

    public static <V> TagsInput<V> create(String label, TagsStore<V> store) {
        return new TagsInput<>(label, store);
    }

    @Override
    protected HTMLDivElement createInputElement(String type) {
        HTMLDivElement tagsInputContainer = div().css("tags-input", "form-control").asElement();
        tagTextInput = input(type).css("tag-text-input").asElement();
        dropDownMenu = DropDownMenu.create(tagTextInput)
                .setPosition(DropDownPosition.BOTTOM)
                .addCloseHandler(() -> tagTextInput.focus());
        tagsInputContainer.appendChild(tagTextInput);
        tagsInputContainer.addEventListener("click", evt -> {
            tagTextInput.focus();
            evt.stopPropagation();
        });
        initListeners();
        return tagsInputContainer;
    }

    private void initListeners() {
        KeyboardEvents.listenOn(tagTextInput)
                .onEnter(evt -> {
                    String displayValue = tagTextInput.value;
                    if (displayValue.isEmpty()) {
                        openMenu();
                    } else {
                        V value = store.getItemByDisplayValue(displayValue);
                        if (nonNull(value)) {
                            appendChip(displayValue, value);
                        }
                    }
                })
                .onTab(evt -> {
                    dropDownMenu.close();
                    unfocus();
                })
                .onCtrlBackspace(evt -> {
                    chips.stream().reduce((first, second) -> second)
                            .ifPresent(Chip::remove);
                    search();
                })
                .onArrowUpDown(evt -> openMenu(), KeyboardEventOptions.create().setPreventDefault(true));

        tagTextInput.addEventListener("input", evt -> search());
        tagTextInput.addEventListener("focus", evt -> {
            focus();
            search();
        });
        tagTextInput.addEventListener("blur", evt -> unfocus());
    }

    private void search() {
        dropDownMenu.clearActions();
        String searchValue = tagTextInput.value;
        Map<String, V> valuesToShow = store.filter(searchValue);
        valuesToShow.forEach(this::addDropDownAction);
        openMenu();
    }

    private void addDropDownAction(String displayValue, V value) {
        if (!selectedItems.contains(value)) {
            dropDownMenu
                    .addAction(DropdownAction.create(displayValue, displayValue)
                            .addSelectionHandler(selectedValue -> {
                                appendChip(displayValue, value);
                                tagTextInput.focus();
                            }));
        }
    }

    private void openMenu() {
        if (dropDownMenu.hasActions()) {
            dropDownMenu.open();
        }
    }

    private void fireChangeEvent() {
        callChangeHandlers();
        tagTextInput.value = "";
        validate();
    }

    @Override
    protected void clearValue() {
        chips.forEach(Chip::remove);
        chips.clear();
        selectedItems.clear();
    }

    @Override
    protected void doSetValue(List<V> values) {
        for (V value : values) {
            String displayValue = store.getDisplayValue(value);
            appendChip(displayValue, value);
        }
    }

    public void appendChip(String displayValue, V value) {
        Chip chip = Chip.create(displayValue)
                .setColorScheme(colorScheme)
                .setRemovable(true);
        appendChip(chip, value);
    }

    public void appendChip(Chip chip, V value){
        chip.addRemoveHandler(() -> {
            selectedItems.remove(value);
            chips.remove(chip);
            fireChangeEvent();
        });
        chips.add(chip);
        selectedItems.add(value);
        getInputElement().insertBefore(chip.asElement(), tagTextInput);
        fireChangeEvent();
    }

    @Override
    public boolean isEmpty() {
        return selectedItems.isEmpty();
    }

    @Override
    public List<V> getValue() {
        return selectedItems;
    }

    @Override
    public TagsInput<V> setPlaceholder(String placeholder) {
        tagTextInput.setAttribute("placeholder", placeholder);
        return this;
    }

    public TagsInput<V> setDropDownPosition(DropDownPosition position) {
        dropDownMenu.setPosition(position);
        return this;
    }

    @Override
    public TagsInput<V> disable() {
        chips.forEach(Chip::disable);
        tagTextInput.disabled = true;
        return super.disable();
    }

    @Override
    public TagsInput<V> enable() {
        chips.forEach(Chip::enable);
        tagTextInput.disabled = false;
        return super.enable();
    }

    public TagsInput<V> setTagsColor(ColorScheme colorScheme) {
        this.colorScheme = colorScheme;
        chips.forEach(chip -> chip.setColorScheme(this.colorScheme));
        return this;
    }

    @Override
    public TagsInput<V> setReadOnly(boolean readOnly) {
        return super.setReadOnly(readOnly);
    }

    @Override
    public String getStringValue() {
        return getValue().stream().map(Object::toString).collect(Collectors.joining(","));
    }
}
