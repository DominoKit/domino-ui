package org.dominokit.domino.ui.elements;

import elemental2.dom.HTMLInputElement;
import org.dominokit.domino.ui.IsElement;

public class InputElement extends BaseElement<HTMLInputElement, InputElement> {
    public static InputElement of(HTMLInputElement e) {
        return new InputElement(e);
    }
    public static InputElement of(IsElement<HTMLInputElement> e) {
        return new InputElement(e.element());
    }

    public InputElement(HTMLInputElement element) {
        super(element);
    }

    public String getName(){
        return element.element().name;
    }

    public InputElement setName(String name){
        element.element().name = name;
        return this;
    }
}