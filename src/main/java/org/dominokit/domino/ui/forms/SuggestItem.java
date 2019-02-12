package org.dominokit.domino.ui.forms;

import elemental2.core.JsRegExp;
import elemental2.core.JsString;
import elemental2.dom.HTMLDivElement;
import elemental2.dom.HTMLElement;
import org.dominokit.domino.ui.icons.BaseIcon;
import org.dominokit.domino.ui.icons.Icon;
import org.dominokit.domino.ui.icons.Icons;
import org.dominokit.domino.ui.utils.BaseDominoElement;
import org.dominokit.domino.ui.utils.DominoElement;

import static org.jboss.gwt.elemento.core.Elements.div;
import static org.jboss.gwt.elemento.core.Elements.span;

public class SuggestItem extends BaseDominoElement<HTMLDivElement, SuggestItem> {

    private static final String IGNORE_CASE_FLAG = "ig";
    private DominoElement<HTMLDivElement> element = DominoElement.of(div());
    private DominoElement<HTMLElement> valueContainer = DominoElement.of(span());
    private String value;

    public SuggestItem(String value) {
        this(value, Icons.ALL.text_fields());
    }

    public SuggestItem(String value, BaseIcon<?> icon) {
        this.value = value;
        element.appendChild(icon);
        valueContainer.setTextContent(value);
        element.appendChild(valueContainer);
        init(this);
    }

    public static SuggestItem create(String value) {
        return new SuggestItem(value);
    }

    public static SuggestItem create(String value, BaseIcon<?> icon) {
        return new SuggestItem(value, icon);
    }

    public String getValue() {
        return value;
    }

    @Override
    public HTMLDivElement asElement() {
        return element.asElement();
    }

    public void highlight(String value) {
        String innerHTML = valueContainer.getTextContent();
        JsRegExp regExp = new JsRegExp(value, IGNORE_CASE_FLAG);
        innerHTML = new JsString(innerHTML).replace(regExp, (valueToReplace, p1) -> "<b class=\"highlight\">" + valueToReplace + "</b>");
        valueContainer.asElement().innerHTML = innerHTML;
    }
}
