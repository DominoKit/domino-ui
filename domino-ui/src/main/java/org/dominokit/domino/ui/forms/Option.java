package org.dominokit.domino.ui.forms;

import elemental2.dom.DomGlobal;
import elemental2.dom.Node;
import org.dominokit.domino.ui.menu.AbstractMenuItem;
import org.dominokit.domino.ui.utils.DominoElement;
import org.dominokit.domino.ui.utils.MatchHighlighter;
import org.jboss.elemento.IsElement;

import static java.util.Objects.nonNull;

public abstract class Option<V> extends AbstractMenuItem<V, Option<V>> {

    protected IsElement<?> valueTarget;

    public Option() {
    }

    @Override
    public Option<V> select(boolean silent) {
        onSelected();
        return super.select(silent);
    }

    protected abstract void onSelected();

    @Override
    public Option<V> deselect(boolean silent) {
        onDeselected();
        return super.deselect(silent);
    }

    protected abstract void onDeselected();

    void bindValueTarget(IsElement<?> valueTarget){
        this.valueTarget = valueTarget;
    }

    public IsElement<?> getValueTarget() {
        return valueTarget;
    }

    public void highlight(String displayValue) {
        if (nonNull(displayValue) && displayValue.length() > 0) {
            highlightNode(this.linkElement.element(), displayValue);
        }
    }

    private void highlightNode(Node node, String searchTerm) {
        cleanHighlight(node);
        if (node.nodeType == DomGlobal.document.TEXT_NODE) {
            String text = node.nodeValue;
            String highlighted = MatchHighlighter.highlight(text, searchTerm);
            node.parentElement.appendChild(DominoElement.span().setInnerHtml(highlighted).element());
            node.parentElement.removeChild(node);
        } else if (node.nodeType == DomGlobal.document.ELEMENT_NODE) {
            for (int i = 0; i < node.childNodes.length; i++) {
                highlightNode(node.childNodes.getAt(i), searchTerm);
            }
        }
    }

    private void cleanHighlight(Node node) {
        if (node.nodeType == DomGlobal.document.ELEMENT_NODE) {
            if (node.nodeName.equalsIgnoreCase("mark")) {
                node.parentElement.textContent = node.parentElement.textContent.replace("<mark>", "").replace("</mark>", "");
            } else {
                for (int i = 0; i < node.childNodes.length; i++) {
                    cleanHighlight(node.childNodes.getAt(i));
                }
            }
        }
    }

}
