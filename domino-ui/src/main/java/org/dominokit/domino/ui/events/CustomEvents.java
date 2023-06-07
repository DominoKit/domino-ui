package org.dominokit.domino.ui.events;

import elemental2.dom.CustomEvent;
import elemental2.dom.CustomEventInit;
import jsinterop.base.Js;

public class CustomEvents {

    public static <T> CustomEvent<T> create(String name){
        return new CustomEvent<>(name);
    }

    public static <T> CustomEvent<T> create(String name, T details){
        CustomEventInit<T> initOptions = Js.uncheckedCast(CustomEventInit.create());
        initOptions.setDetail(details);
        return new CustomEvent<>(name, initOptions);
    }
}
