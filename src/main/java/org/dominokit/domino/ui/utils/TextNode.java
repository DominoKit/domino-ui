package org.dominokit.domino.ui.utils;

import elemental2.dom.DomGlobal;
import elemental2.dom.Text;

public class TextNode {

    public static Text empty(){
        return DomGlobal.document.createTextNode("");
    }

    public static Text of(String content){
        return DomGlobal.document.createTextNode(content);
    }
}
