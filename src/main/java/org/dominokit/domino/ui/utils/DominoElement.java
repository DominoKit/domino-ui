package org.dominokit.domino.ui.utils;

import elemental2.dom.EventListener;
import elemental2.dom.HTMLElement;
import elemental2.dom.Node;
import org.dominokit.domino.ui.collapsible.Collapsible;
import org.dominokit.domino.ui.style.Style;
import org.jboss.gwt.elemento.core.EventType;
import org.jboss.gwt.elemento.core.IsElement;

public abstract class DominoElement<E extends HTMLElement, T extends IsElement<E>> implements IsCollapsible<T>, HasChildren<T> {

    protected T element;
    protected Collapsible collapsible;

    public static <E extends HTMLElement, T extends IsElement<E>> DominoElement<E,T> of(E node){
        DominoElement<E, T> dominoElement = new DominoElement<E, T>(){};
        dominoElement.init((T) (IsElement<E>) () -> node);
        return dominoElement;
    }

    public void init(T element) {
        this.element = element;
        this.collapsible = Collapsible.create(element.asElement());
    }

    @Override
    public T collapse() {
        collapsible.collapse();
        return element;
    }

    @Override
    public T expand() {
        collapsible.expand();
        return element;
    }

    @Override
    public T toggle() {
        collapsible.toggle();
        return element;
    }

    @Override
    public T collapse(int duration) {
        collapsible.collapse(duration);
        return element;
    }

    @Override
    public T expand(int duration) {
        collapsible.expand(duration);
        return element;
    }

    public T clearElement(){
        ElementUtil.clear(element.asElement());
        return element;
    }

    @Override
    public boolean isCollapsed() {
        return collapsible.isCollapsed();
    }

    public Style<E,T> style(){
        return Style.of((T) this);
    }

    public T setStyleProperty(String name, String value) {
        return (T) style().setProperty(name, value);
    }

    public HtmlComponentBuilder<E, T> builder(){
        return ElementUtil.componentBuilder(element);
    }

    @Override
    public T appendChild(Node node) {
        element.asElement().appendChild(node);
        return element;
    }

    @Override
    public T appendChild(IsElement isElement) {
        element.asElement().appendChild(isElement.asElement());
        return element;
    }

    public T addClickListener(EventListener listener){
        getClickableElement().asElement().addEventListener(EventType.click.getName(), listener);
        return element;
    }

    public <C extends HTMLElement, D extends IsElement<C>> DominoElement<C,D> getClickableElement(){
        return DominoElement.of((C)element.asElement());
    }

    public E asElement(){
        return element.asElement();
    }
}
