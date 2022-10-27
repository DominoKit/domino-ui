package org.dominokit.domino.ui.forms;

import org.dominokit.domino.ui.menu.AbstractMenuItem;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.function.Function;
import java.util.stream.Collectors;

public class TagBox<V> extends AbstractSuggestBox<V, List<V>, TagOption<V>, TagBox<V>> {

    private List<TagOption<V>> selectedOptions = new ArrayList<>();
    private boolean removable;

    public static <V> TagBox<V> create(SuggestBoxStore<V, TagOption<V>> store) {
        return new TagBox<>(store);
    }

    public static <V> TagBox<V> create(Function<String, V> inputMapper) {
        return new TagBox<V>(new LocalSuggestBoxStore<V, TagOption<V>>()
                .setMissingHandlers(
                        missingValue -> Optional.of(TagOption.create(missingValue)),
                        inputValue -> Optional.of(TagOption.create(inputMapper.apply(inputValue)))
                ));
    }

    public static <V> TagBox<V> create(String label, Function<String, V> inputMapper) {
        return new TagBox<V>(label, new LocalSuggestBoxStore<V, TagOption<V>>()
                .setMissingHandlers(
                        missingValue -> Optional.of(TagOption.create(missingValue)),
                        inputValue -> Optional.of(TagOption.create(inputMapper.apply(inputValue)))
                ));
    }

    public static <V> TagBox<V> create(String label, SuggestBoxStore<V, TagOption<V>> store) {
        return new TagBox<>(label, store);
    }

    public TagBox(SuggestBoxStore<V, TagOption<V>> store) {
        super(store);
        optionsMenu.addOnAddItemHandler((menu, menuItem) -> {
            ((TagOption<V>) menuItem)
                    .setRemovable(this.isRemovable())
                    .withChip((option, chip) -> chip.setSelectable(false));
        });
        fieldInput.addCss(FormsStyles.FORM_TAGS_INPUT);
    }

    public TagBox(String label, SuggestBoxStore<V, TagOption<V>> store) {
        this(store);
        setLabel(label);
    }

    @Override
    protected void doSetValue(List<V> values) {
        clearValue(false);
        values.forEach(v -> {
            store.find(v, this::applyOptionValue);
        });
    }

    public TagBox<V> setRemovable(boolean removable) {
        this.selectedOptions.forEach(option -> option.setRemovable(removable));
        this.removable = removable;
        return this;
    }

    public boolean isRemovable() {
        return removable;
    }

    @Override
    public List<V> getValue() {
        return selectedOptions
                .stream()
                .map(AbstractMenuItem::getValue)
                .collect(Collectors.toList());
    }

    @Override
    protected void onOptionSelected(TagOption<V> suggestion) {
        selectedOptions.add(suggestion);
    }

    @Override
    protected void onBackspace() {
        if (!selectedOptions.isEmpty()) {
            TagOption<V> option = selectedOptions.get(selectedOptions.size() - 1);
            option.deselect();
            selectedOptions.remove(option);
        }
    }

    @Override
    public void onApplyMissingOption(TagOption<V> option) {
        selectedOptions.add(option);
    }

    @Override
    protected void onBeforeApplyMissingOption(TagOption<V> option) {
        option.setRemovable(isRemovable());
    }

    @Override
    protected TagBox<V> clearValue(boolean silent) {
        if (!selectedOptions.isEmpty()) {
            List<V> oldValue = getValue();
            optionsMenu.withPauseSelectionListenersToggle(true, field -> {
                new ArrayList<>(selectedOptions)
                        .forEach(AbstractMenuItem::deselect);
            });

            if (!silent) {
                triggerClearListeners(oldValue);
            }

            if (isAutoValidation()) {
                autoValidate();
            }
        }

        return this;
    }
}
