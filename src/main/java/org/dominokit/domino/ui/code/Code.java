package org.dominokit.domino.ui.code;

import elemental2.dom.HTMLElement;
import elemental2.dom.HTMLPreElement;
import org.jboss.gwt.elemento.core.IsElement;

import static java.util.Objects.nonNull;
import static org.jboss.gwt.elemento.core.Elements.code;
import static org.jboss.gwt.elemento.core.Elements.pre;

public class Code{

    public static class Block implements IsElement<HTMLPreElement>{
        private final HTMLPreElement element;

        private Block(HTMLPreElement element) {
            this.element = element;
        }

        public Block setCode(String code){
            if(nonNull(element.firstChild))
                element.removeChild(element.firstChild);
            element.appendChild(code().style("overflow-x: scroll; white-space: pre;").textContent(code).asElement());
            return this;
        }

        @Override
        public HTMLPreElement asElement() {
            return element;
        }
    }

    public static class Statement implements IsElement<HTMLElement>{
        private final HTMLElement element;

        private Statement(HTMLElement element) {
            this.element = element;
        }

        @Override
        public HTMLElement asElement() {
            return element;
        }
    }

    public static Block block(String code){
        return new Block(pre().add(code().textContent(code)).asElement());
    }

    public static Block block(){
        return new Block(pre().asElement());
    }

    public static Statement statement(String code){
        return new Statement(code().textContent(code).asElement());
    }

}
