package com.progressoft.brix.domino.ui.utils;

import elemental2.dom.Element;

import static java.util.Objects.nonNull;

public class ElementUtil {

    public static void clear(Element element){
        if(nonNull(element))
            while(nonNull(element.firstChild))
                element.removeChild(element.firstChild);
    }
}
