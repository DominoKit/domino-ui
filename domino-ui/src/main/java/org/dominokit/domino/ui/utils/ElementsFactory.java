package org.dominokit.domino.ui.utils;

import elemental2.dom.HTMLAnchorElement;
import elemental2.dom.HTMLBodyElement;
import elemental2.dom.HTMLButtonElement;
import elemental2.dom.HTMLDivElement;
import elemental2.dom.HTMLElement;
import elemental2.dom.HTMLFieldSetElement;
import elemental2.dom.HTMLHeadingElement;
import elemental2.dom.HTMLImageElement;
import elemental2.dom.HTMLInputElement;
import elemental2.dom.HTMLLIElement;
import elemental2.dom.HTMLLabelElement;
import elemental2.dom.HTMLOListElement;
import elemental2.dom.HTMLParagraphElement;
import elemental2.dom.HTMLPictureElement;
import elemental2.dom.HTMLPreElement;
import elemental2.dom.HTMLQuoteElement;
import elemental2.dom.HTMLTableCellElement;
import elemental2.dom.HTMLTableElement;
import elemental2.dom.HTMLTableRowElement;
import elemental2.dom.HTMLTableSectionElement;
import elemental2.dom.HTMLTextAreaElement;
import elemental2.dom.HTMLUListElement;
import jsinterop.base.Js;
import org.dominokit.domino.ui.style.GenericCss;
import org.jboss.elemento.Elements;
import org.jboss.elemento.Id;
import org.jboss.elemento.IsElement;

import static elemental2.dom.DomGlobal.document;

public interface ElementsFactory {

    ElementsFactory elements= new ElementsFactory() {
    };

    /**
     * @param element the {@link HTMLElement} E to wrap as a DominoElement
     * @param <E> extends from {@link HTMLElement}
     * @return the {@link DominoElement} wrapping the provided element
     */
    default <E extends HTMLElement> DominoElement<E> elementOf(E element) {
        return new DominoElement<>(element).addCss(GenericCss.dui);
    }

    /**
     * @param element the {@link IsElement} E to wrap as a DominoElement
     * @param <E> extends from {@link HTMLElement}
     * @return the {@link DominoElement} wrapping the provided element
     */
    default <T extends HTMLElement, E extends IsElement<T>> DominoElement<T> elementOf(E element) {
        return new DominoElement<>(element.element()).addCss(GenericCss.dui);
    }

    /** @return a {@link DominoElement} wrapping the document {@link HTMLBodyElement} */
    default DominoElement<HTMLBodyElement> body() {
        return new DominoElement<>(document.body);
    }

    /** @return a new {@link HTMLDivElement} wrapped as a {@link DominoElement} */
    default DominoElement<HTMLDivElement> div() {
        return elementOf(Elements.div());
    }

    default DominoElement<HTMLElement> nav() {
        return elementOf(Elements.nav());
    }

    default DominoElement<HTMLHeadingElement> h4() {
        return elementOf(Elements.h(4));
    }

    default DominoElement<HTMLLabelElement> label() {
        return elementOf(Elements.label());
    }

    default DominoElement<HTMLElement> span() {
        return elementOf(Elements.span());
    }

    default DominoElement<HTMLElement> section() {
        return elementOf(Elements.section());
    }

    default DominoElement<HTMLElement> aside() {
        return elementOf(Elements.aside());
    }

    default DominoElement<HTMLElement> header() {
        return elementOf(Elements.header());
    }

    /** @return a new {@link HTMLDivElement} wrapped as a {@link DominoElement} */
    default DominoElement<HTMLPictureElement> picture() {
        return elementOf(Js.<HTMLPictureElement>uncheckedCast(document.createElement("picture")))
                .addCss(GenericCss.dui);
    }

    default DominoElement<HTMLInputElement> input(String type) {
        return elementOf(Elements.input(type));
    }

    default DominoElement<HTMLUListElement> ul() {
        return elementOf(Elements.ul());
    }

    default DominoElement<HTMLAnchorElement> a() {
        return elementOf(Elements.a());
    }

    default DominoElement<HTMLAnchorElement> a(String href) {
        return elementOf(Elements.a(href));
    }

    default DominoElement<HTMLLIElement> li() {
        return elementOf(Elements.li());
    }

    default DominoElement<HTMLElement> i() {
        return elementOf(Elements.i());
    }

    default DominoElement<HTMLElement> small() {
        return elementOf(Elements.small());
    }

    default DominoElement<HTMLFieldSetElement> fieldSet() {
        return elementOf(Elements.fieldset());
    }

    default String getUniqueId() {
        return Id.unique();
    }

    default DominoElement<HTMLButtonElement> button() {
        return elementOf(Elements.button());
    }

    default DominoElement<HTMLTextAreaElement> textarea() {
        return elementOf(Elements.textarea());
    }

    default DominoElement<HTMLOListElement> ol() {
        return elementOf(Elements.ol());
    }

    default DominoElement<HTMLHeadingElement> h(int type) {
        return elementOf(Elements.h(type));
    }

    default DominoElement<HTMLParagraphElement> p() {
        return elementOf(Elements.p());
    }

    default DominoElement<HTMLImageElement> image(String src) {
        return elementOf(Elements.img(src));
    }

    default DominoElement<HTMLElement> code() {
        return elementOf(Elements.code());
    }

    default DominoElement<HTMLPreElement> pre() {
        return elementOf(Elements.pre());
    }

    default DominoElement<HTMLQuoteElement> blockquote() {
        return elementOf(Elements.blockquote());
    }
    default DominoElement<HTMLElement> footer() {
        return elementOf(Elements.footer());
    }
    default DominoElement<HTMLTableRowElement> tr() {
        return elementOf(Elements.tr());
    }
    default DominoElement<HTMLTableCellElement> th() {
        return elementOf(Elements.th());
    }
    default DominoElement<HTMLTableElement> table() {
        return elementOf(Elements.table());
    }
    default DominoElement<HTMLTableSectionElement> tbody() {
        return elementOf(Elements.tbody());
    }
    default DominoElement<HTMLTableSectionElement> thead() {
        return elementOf(Elements.thead());
    }
}
