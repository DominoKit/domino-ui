package org.dominokit.domino.ui.forms;

import elemental2.dom.DomGlobal;
import elemental2.dom.Node;
import org.dominokit.domino.ui.menu.AbstractMenuItem;
import org.dominokit.domino.ui.utils.DominoElement;
import org.dominokit.domino.ui.utils.LazyChild;
import org.dominokit.domino.ui.utils.MatchHighlighter;

import static java.util.Objects.isNull;
import static java.util.Objects.nonNull;

public abstract class SelectOption<V> extends AbstractMenuItem<V, SelectOption<V>> {
    private LazyChild<DominoElement<?>> valueElement;

    public SelectOption() {
    }

    @Override
    public SelectOption<V> select(boolean silent) {
        if (nonNull(valueElement)) {
            valueElement.get();
        }
        return super.select(silent);
    }

    @Override
    public SelectOption<V> deselect(boolean silent) {
        valueElement.remove();
        return super.deselect(silent);
    }

    void setValueElement(LazyChild<DominoElement<?>> valueElement) {
        if(isNull(this.valueElement)) {
            this.valueElement = valueElement;
        }
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

    private void cleanHighlight(Node node){
        if(node.nodeType == DomGlobal.document.ELEMENT_NODE){
            if(node.nodeName.equalsIgnoreCase("mark")) {
                node.parentElement.textContent = node.parentElement.textContent.replace("<mark>", "").replace("</mark>", "");
            }else {
                for (int i = 0; i < node.childNodes.length; i++) {
                    cleanHighlight(node.childNodes.getAt(i));
                }
            }
        }
    }

}
