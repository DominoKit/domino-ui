package org.dominokit.domino.ui.utils;

import elemental2.dom.HTMLElement;
import elemental2.dom.Node;
import org.gwtproject.safehtml.shared.SafeHtml;
import org.jboss.gwt.elemento.core.HasElements;
import org.jboss.gwt.elemento.core.IsElement;
import org.jboss.gwt.elemento.core.builder.HtmlContentBuilder;

public class HtmlComponentBuilder<E extends HTMLElement, C extends IsElement<E>> extends HtmlContentBuilder<E>{

    private C component;

    public HtmlComponentBuilder(C component) {
        super(component.asElement());
        this.component = component;
    }

    public C component(){
        return component;
    }

    @Override
    public HtmlComponentBuilder<E, C> innerHtml(SafeHtml html) {
        super.innerHtml(html);
        return this;
    }

    @Override
    public HtmlComponentBuilder<E, C> add(IsElement element) {
        super.add(element);
        return this;
    }

    @Override
    public HtmlComponentBuilder<E, C> add(String text) {
        super.add(text);
        return this;
    }

    @Override
    public HtmlComponentBuilder<E, C> add(Node element) {
        super.add(element);
        return this;
    }

    @Override
    public HtmlComponentBuilder<E, C> addAll(HasElements elements) {
        super.addAll(elements);
        return this;
    }

    @Override
    public HtmlComponentBuilder<E, C> addAll(HTMLElement... elements) {
        super.addAll(elements);
        return this;
    }

    @Override
    public HtmlComponentBuilder<E, C> addAll(Iterable<? extends Node> elements) {
        super.addAll(elements);
        return this;
    }

    @Override
    public HtmlComponentBuilder<E, C> addAll(IsElement... elements) {
        super.addAll(elements);
        return this;
    }

    @Override
    public HtmlComponentBuilder<E, C> textContent(String text) {
        super.textContent(text);
        return this;
    }

    @Override
    public HtmlComponentBuilder<E, C> css(String... classes) {
        super.css(classes);
        return this;
    }
}
