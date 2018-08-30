package org.dominokit.domino.ui.tag;

import elemental2.dom.Event;
import elemental2.dom.HTMLDivElement;
import elemental2.dom.HTMLInputElement;
import elemental2.dom.KeyboardEvent;
import jsinterop.base.Js;
import org.dominokit.domino.ui.chips.Chip;
import org.dominokit.domino.ui.dropdown.DropDownMenu;
import org.dominokit.domino.ui.dropdown.DropDownPosition;
import org.dominokit.domino.ui.dropdown.DropdownAction;
import org.dominokit.domino.ui.forms.ValueBox;
import org.dominokit.domino.ui.style.ColorScheme;
import org.dominokit.domino.ui.tag.store.DynamicLocalTagsStore;
import org.dominokit.domino.ui.tag.store.TagsStore;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import static java.util.Objects.nonNull;
import static org.dominokit.domino.ui.utils.ElementUtil.isEnterKey;
import static org.jboss.gwt.elemento.core.Elements.div;
import static org.jboss.gwt.elemento.core.Elements.input;

public class TagsInput<V> extends ValueBox<TagsInput<V>, HTMLDivElement, List<V>> {

    private HTMLInputElement tagTextInput;
    private final List<Chip> chips = new ArrayList<>();
    private final List<V> selectedItems = new ArrayList<>();
    private final TagsStore<V> store;
    private DropDownMenu dropDownMenu;
    private ColorScheme colorScheme = ColorScheme.INDIGO;

    public TagsInput(String type, String label, TagsStore<V> store) {
        super(type, label);
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
        return new TagsInput<>("text", label, store);
    }

    @Override
    protected HTMLDivElement createInputElement(String type) {
        HTMLDivElement tagsInputContainer = div().css("tags-input", "form-control").asElement();
        tagTextInput = input("text").css("tag-text-input").asElement();
        dropDownMenu = DropDownMenu.create(tagTextInput).setPosition(DropDownPosition.BOTTOM);
        tagsInputContainer.appendChild(tagTextInput);
        tagsInputContainer.addEventListener("click", evt -> {
            focus();
            evt.stopPropagation();
        });
        initListeners();
        return tagsInputContainer;
    }

    @Override
    public TagsInput<V> focus() {
        tagTextInput.focus();
        return super.focus();
    }

    private void initListeners() {
        tagTextInput.addEventListener("keypress", evt -> {
            String displayValue = tagTextInput.value;
            KeyboardEvent keyboardEvent = Js.uncheckedCast(evt);
            if (isEnterKey(keyboardEvent) && !displayValue.isEmpty()) {
                V value = store.getItemByDisplayValue(displayValue);
                if (nonNull(value)) {
                    addTag(displayValue, value);
                }
            }
        });
        tagTextInput.addEventListener("input", evt -> search());
        tagTextInput.addEventListener("change", Event::stopPropagation);
        tagTextInput.addEventListener("focusin", evt -> search());
        tagTextInput.addEventListener("click", Event::stopPropagation);
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
                    .addAction(DropdownAction.create(value, displayValue)
                            .addSelectionHandler(() -> addTag(displayValue, value)));
        }
    }

    private void openMenu() {
        if (dropDownMenu.hasActions()) {
            dropDownMenu.open();
        }
    }

    private void closeMenu() {
        dropDownMenu.close();
    }

    private void fireChangeEvent() {
        callChangeHandlers();
        tagTextInput.value = "";
        closeMenu();
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
            addTag(displayValue, value);
        }
    }

    private void addTag(String displayValue, V value) {
        Chip chip = Chip.create(displayValue)
                .setColorScheme(colorScheme)
                .setRemovable(true);
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
}
