package org.dominokit.domino.ui.elements;

import elemental2.dom.HTMLScriptElement;

public class ScriptElement extends BaseElement<HTMLScriptElement, ScriptElement> {
    public static ScriptElement of(HTMLScriptElement e) {
        return new ScriptElement(e);
    }

    public ScriptElement(HTMLScriptElement element) {
        super(element);
    }
}