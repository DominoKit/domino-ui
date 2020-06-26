package org.dominokit.domino.ui.tag;

import elemental2.dom.HTMLElement;
import elemental2.dom.HTMLInputElement;
import org.dominokit.domino.ui.chips.Chip;
import org.dominokit.domino.ui.dropdown.DropDownMenu;
import org.dominokit.domino.ui.dropdown.DropDownPosition;
import org.dominokit.domino.ui.dropdown.DropdownAction;
import org.dominokit.domino.ui.forms.AbstractValueBox;
import org.dominokit.domino.ui.forms.validations.InputAutoValidator;
import org.dominokit.domino.ui.grid.flex.FlexItem;
import org.dominokit.domino.ui.grid.flex.FlexLayout;
import org.dominokit.domino.ui.grid.flex.FlexWrap;
import org.dominokit.domino.ui.keyboard.KeyboardEvents;
import org.dominokit.domino.ui.keyboard.KeyboardEvents.KeyboardEventOptions;
import org.dominokit.domino.ui.style.ColorScheme;
import org.dominokit.domino.ui.tag.store.DynamicLocalTagsStore;
import org.dominokit.domino.ui.tag.store.TagsStore;
import org.dominokit.domino.ui.utils.BaseDominoElement;
import org.dominokit.domino.ui.utils.DominoElement;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import static java.util.Objects.nonNull;
import static org.jboss.elemento.Elements.input;

public class TagsInput<V> extends AbstractValueBox<TagsInput<V>, HTMLElement, List<V>> {

    private DominoElement<HTMLInputElement> tagTextInput;
    private final List<Chip> chips = new ArrayList<>();
    private final List<V> selectedItems = new ArrayList<>();
    private final TagsStore<V> store;
    private DropDownMenu dropDownMenu;
    private ColorScheme colorScheme = ColorScheme.INDIGO;
    private int maxSize = -1;
    private boolean userInputEnabled = true;
    private FlexItem tagInputTextContainer;
    private FlexLayout tagsContainer;
    private boolean openOnFocus = true;

    public TagsInput(String label, TagsStore<V> store) {
        super("text", label);
        init(this);
        css("tags-input");
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
    protected HTMLElement createInputElement(String type) {
        tagsContainer = FlexLayout.create()
                .setWrap(FlexWrap.WRAP_TOP_TO_BOTTOM);

        tagInputTextContainer = FlexItem.create()
                .setFlexGrow(1);
        tagTextInput = DominoElement.of(input(type))
                .addCss(TagStyles.TAG_TEXT_INPUT);
        dropDownMenu = DropDownMenu.create(tagTextInput)
                .setPosition(DropDownPosition.BOTTOM)
                .addCloseHandler(() -> {
                    openOnFocus = false;
                    tagTextInput.element().focus();
                    openOnFocus = true;
                });
        getInputContainer().addEventListener("click", evt -> {
            evt.stopPropagation();
            openOnFocus = true;
            tagTextInput.element().focus();
        });

        tagTextInput.addClickListener(evt -> {
            evt.stopPropagation();
            search();
        });

        initListeners();

        tagInputTextContainer.appendChild(tagTextInput);

        tagsContainer.appendChild(tagInputTextContainer);
        return tagsContainer.element();
    }

    private void initListeners() {
        KeyboardEvents.listenOn(tagTextInput)
                .onEnter(evt -> {
                    addTag();
                })
                .onTab(evt -> {
                    if(dropDownMenu.isOpened() && dropDownMenu.hasActions()){
                        evt.preventDefault();
                        dropDownMenu.focus();
                    }else{
                        unfocus();
                    }
                })
                .onCtrlBackspace(evt -> {
                    chips.stream().reduce((first, second) -> second)
                            .ifPresent(Chip::remove);
                    search();
                })
                .onArrowUpDown(evt -> openMenu(true), KeyboardEventOptions.create().setPreventDefault(true))
                .onEscape(evt -> dropDownMenu.close());

        tagTextInput.addEventListener("input", evt -> search());
        tagTextInput.addEventListener("focus", evt -> {
            if (openOnFocus) {
                focus();
                search();
            }
        });
        tagTextInput.addEventListener("blur", evt -> {
            addTag();
            unfocus();
        });
    }

    private void addTag() {
        String displayValue = tagTextInput.element().value;
        if (displayValue.isEmpty()) {
            openMenu();
        } else {
            V value = store.getItemByDisplayValue(displayValue);
            if (nonNull(value)) {
                appendChip(displayValue, value);
            }
        }
    }

    private void search() {
        dropDownMenu.clearActions();
        String searchValue = tagTextInput.element().value;
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
                                tagTextInput.element().focus();
                            }));
        }
    }

    private void openMenu() {
        openMenu(false);
    }

    private void openMenu(boolean focus) {
        if (dropDownMenu.hasActions()) {
            if (!dropDownMenu.isOpened()) {
                dropDownMenu.open(focus);
            } else if (focus) {
                dropDownMenu.focus();
            }
        }
    }

    private void fireChangeEvent() {
        callChangeHandlers();
        tagTextInput.element().value = "";
        validate();
        if (isExceedsMaxSize()) {
            disableAddValues();
        } else {
            enableAddValues();
        }
    }

    @Override
    protected void linkLabelToField() {
        if (!tagTextInput.hasAttribute("id")) {
            tagTextInput.setAttribute("id", tagTextInput.getAttribute(BaseDominoElement.DOMINO_UUID));
        }
        getLabelElement().setAttribute("for", tagTextInput.getAttribute("id"));
    }

    @Override
    protected void clearValue() {
        chips.forEach(chip -> chip.remove(true));
        chips.clear();
        selectedItems.clear();
        fireChangeEvent();
    }

    @Override
    protected void doSetValue(List<V> values) {
        clearValue();
        for (V value : values) {
            addValue(value);
        }
    }

    public TagsInput<V> addValue(V value) {
        String displayValue = store.getDisplayValue(value);
        appendChip(displayValue, value);
        return this;
    }

    public void appendChip(String displayValue, V value) {
        Chip chip = Chip.create(displayValue)
                .setColorScheme(colorScheme)
                .setRemovable(true)
                .addRemoveHandler(() -> dropDownMenu.close())
                .addClickListener(evt -> {
                    evt.stopPropagation();
                    if(dropDownMenu.isOpened()) {
                        dropDownMenu.close();
                    }
                });
        appendChip(chip, value);
    }

    public void appendChip(Chip chip, V value) {
        if (!isExceedsMaxSize()) {
            chip.addRemoveHandler(() -> {
                selectedItems.remove(value);
                chips.remove(chip);
                fireChangeEvent();
            });
            chips.add(chip);
            selectedItems.add(value);
            tagsContainer.insertBefore(FlexItem.from(chip.element()), tagInputTextContainer);
            fireChangeEvent();
        }
    }

    private boolean isExceedsMaxSize() {
        return maxSize >= 0 && chips.size() >= maxSize;
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
        tagTextInput.element().disabled = true;
        return super.disable();
    }

    @Override
    public TagsInput<V> enable() {
        chips.forEach(Chip::enable);
        tagTextInput.element().disabled = false;
        return super.enable();
    }

    public TagsInput<V> setTagsColor(ColorScheme colorScheme) {
        this.colorScheme = colorScheme;
        chips.forEach(chip -> chip.setColorScheme(this.colorScheme));
        return this;
    }

    private void disableAddValues() {
        if (userInputEnabled)
            tagTextInput.hide();
    }

    private void enableAddValues() {
        if (userInputEnabled)
            tagTextInput.show();
    }

    public TagsInput<V> setMaxValue(int maxSize) {
        this.maxSize = maxSize;
        return this;
    }

    @Override
    public String getStringValue() {
        return getValue().stream().map(Object::toString).collect(Collectors.joining(","));
    }

    public TagsInput<V> disableUserInput() {
        userInputEnabled = false;
        tagTextInput.hide();
        return this;
    }

    public TagsInput<V> enableUserInput() {
        userInputEnabled = true;
        tagTextInput.show();
        return this;
    }

    @Override
    protected AutoValidator createAutoValidator(AutoValidate autoValidate) {
        return new InputAutoValidator<>(getInputElement(), autoValidate);
    }
}
