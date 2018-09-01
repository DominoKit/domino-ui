package org.dominokit.domino.ui.utils;

import elemental2.dom.EventListener;
import elemental2.dom.HTMLElement;
import elemental2.dom.Node;
import elemental2.dom.NodeList;
import org.dominokit.domino.ui.collapsible.Collapsible;
import org.dominokit.domino.ui.style.Style;
import org.jboss.gwt.elemento.core.EventType;
import org.jboss.gwt.elemento.core.IsElement;

public abstract class DominoElement<E extends HTMLElement, T extends IsElement<E>> implements IsCollapsible<T>, HasChildren<T>, IsElement<E> {

    protected T element;
    protected Collapsible collapsible;
    private boolean expanded = true;

    public static <E extends HTMLElement, T extends IsElement<E>> DominoElement<E,T> of(E node){
        DominoElement<E, T> dominoElement = new DominoElement<E, T>(){};
        dominoElement.init((T) (IsElement<E>) () -> node);
        return dominoElement;
    }

    public void init(T element) {
        this.element = element;
        this.collapsible = Collapsible.create(getCollapsibleElement().asElement());
        ElementUtil.onAttach(asElement(), mutationRecord -> {
            if (!expanded) {
                collapsible.collapse();
            }
        });
    }

    @Override
    public T collapse() {
        collapsible.collapse();
        this.expanded= false;
        return element;
    }

    @Override
    public T expand() {
        collapsible.expand();
        this.expanded= true;
        return element;
    }

    @Override
    public T toggleDisplay() {
        collapsible.toggleDisplay();
        expanded = !expanded;
        return element;
    }

    @Override
    public T collapse(int duration) {
        collapsible.collapse(duration);
        this.expanded= false;
        return element;
    }

    @Override
    public T expand(int duration) {
        collapsible.expand(duration);
        this.expanded= true;
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

    public T addEventListener(String type, EventListener listener){
        getClickableElement().asElement().addEventListener(type, listener);
        return element;
    }

    public T addEventListener(EventType type, EventListener listener){
        getClickableElement().asElement().addEventListener(type.getName(), listener);
        return element;
    }

    public T removeEventListener(EventType type, EventListener listener){
        getClickableElement().asElement().removeEventListener(type.getName(), listener);
        return element;
    }

    public T removeEventListener(String type, EventListener listener){
        getClickableElement().asElement().removeEventListener(type, listener);
        return element;
    }

    public T insertBefore(Node newNode, Node oldNode){
        asElement().insertBefore(newNode, oldNode);
        return (T) this;
    }

    public T insertBefore(Node newNode, DominoElement oldNode){
        asElement().insertBefore(newNode, oldNode.asElement());
        return (T) this;
    }

    public T insertBefore(DominoElement newNode, DominoElement oldNode){
        asElement().insertBefore(newNode.asElement(), oldNode.asElement());
        return (T) this;
    }
    public T insertBefore(DominoElement newNode, Node oldNode){
        asElement().insertBefore(newNode.asElement(), oldNode);
        return (T) this;
    }

    public DominoElement<E,T> setAttribute(String name, String value){
        asElement().setAttribute(name, value);
        return this;
    }

    public DominoElement<E,T> setAttribute(String name, boolean value){
        asElement().setAttribute(name, value);
        return this;
    }

    public DominoElement<E,T> setAttribute(String name, double value){
        asElement().setAttribute(name, value);
        return this;
    }

    public String getAttribute(String name){
        return asElement().getAttribute(name);
    }

    public DominoElement<E,T> removeAttribute(String name){
        asElement().removeAttribute(name);
        return this;
    }

    public boolean hasAttribute(String name){
        return asElement().hasAttribute(name);
    }

    public boolean contains(Node node){
        return asElement().contains(node);
    }

    public DominoElement<E,T> setTextContent(String text){
        asElement().textContent = text;
        return this;
    }

    public DominoElement<E,T> remove(){
        asElement().remove();
        return this;
    }

    public DominoElement<E,T> removeChild(Node node){
        asElement().removeChild(node);
        return this;
    }

    public NodeList<Node> childNodes(Node node){
        return asElement().childNodes;
    }

    public Node firstChild(){
        return asElement().firstChild;
    }

    public Node lastChild(){
        return asElement().lastChild;
    }

    public String getTextContent(){
        return asElement().textContent;
    }

    public DominoElement<E,T> blur(){
        asElement().blur();
        return this;
    }

    public <C extends HTMLElement, D extends IsElement<C>> DominoElement<C,D> getClickableElement(){
        return DominoElement.of((C)element.asElement());
    }

    public <C extends HTMLElement, D extends IsElement<C>> DominoElement<C,D> getCollapsibleElement(){
        return DominoElement.of((C)element.asElement());
    }

    public E asElement(){
        return element.asElement();
    }
}
