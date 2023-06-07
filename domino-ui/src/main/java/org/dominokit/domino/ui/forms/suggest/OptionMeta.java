package org.dominokit.domino.ui.forms.suggest;

import org.dominokit.domino.ui.IsElement;
import org.dominokit.domino.ui.utils.ComponentMeta;
import org.dominokit.domino.ui.utils.HasMeta;

import java.util.Optional;

public class OptionMeta<V, C extends IsElement<?>, O extends Option<V, C, O>> implements ComponentMeta {

    public static final String OPTION_META = "dui-suggest-option-meta";
    private final C component;
    private final O option;


    public static <V, C extends IsElement<?>, O extends Option<V, C, O>> OptionMeta<V, C, O> of(C component, O option){
        return new OptionMeta<>(component, option);
    }

    public OptionMeta(C component, O option) {
        this.component = component;
        this.option = option;
    }

    public static <V, C extends IsElement<?>, O extends Option<V, C, O>> Optional<OptionMeta<V, C, O>> get(HasMeta<?> component) {
        return component.getMeta(OPTION_META);
    }

    public C getComponent() {
        return component;
    }

    public O getOption() {
        return option;
    }

    @Override
    public String getKey() {
        return OPTION_META;
    }
}
