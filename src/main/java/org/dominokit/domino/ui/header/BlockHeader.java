package org.dominokit.domino.ui.header;

import elemental2.dom.*;
import org.jboss.gwt.elemento.core.IsElement;
import org.jboss.gwt.elemento.core.builder.HtmlContentBuilder;

import static java.util.Objects.isNull;
import static java.util.Objects.nonNull;
import static org.jboss.gwt.elemento.core.Elements.*;

public class BlockHeader implements IsElement<HTMLDivElement>{

    private final HTMLDivElement element;
    private HTMLHeadingElement headerElement;
    private HTMLElement descriptionElement;

    private BlockHeader(HTMLDivElement element, HTMLHeadingElement headerElement) {
        this.element = element;
        this.headerElement = headerElement;
    }

    private BlockHeader(HTMLDivElement element, HTMLHeadingElement headerElement, String description) {
        this.element = element;
        this.headerElement = headerElement;
        createDescriptionElement(description);
    }

    private void createDescriptionElement(String description) {
        this.descriptionElement=small().textContent(description).asElement();
        headerElement.appendChild(descriptionElement);
    }

    public static BlockHeader create(String header, String description){
        HtmlContentBuilder<HTMLHeadingElement> headerElement = h(2).textContent(header);
        HTMLDivElement element = div().css("block-header")
                .add(headerElement).asElement();
        return new BlockHeader(element, headerElement.asElement(), description);
    }

    public static BlockHeader create(String header){
        HtmlContentBuilder<HTMLHeadingElement> headerElement = h(2).textContent(header);
        HTMLDivElement element = div().css("block-header")
                .add(headerElement).asElement();
        return new BlockHeader(element, headerElement.asElement());
    }

    public BlockHeader appendContent(Node content){
        if(isNull(descriptionElement))
            createDescriptionElement("");
        descriptionElement.appendChild(content);
        return this;
    }

    public BlockHeader invert(){
        if(nonNull(descriptionElement)){
            descriptionElement.remove();
            element.insertBefore(descriptionElement, headerElement);
        }

        return this;
    }

    public BlockHeader appendText(String text){
        return appendContent(new Text(text));
    }

    @Override
    public HTMLDivElement asElement() {
        return element;
    }
}
