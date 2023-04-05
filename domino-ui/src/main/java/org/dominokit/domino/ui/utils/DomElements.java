package org.dominokit.domino.ui.utils;

import elemental2.dom.Element;
import elemental2.dom.HTMLAnchorElement;
import elemental2.dom.HTMLAreaElement;
import elemental2.dom.HTMLAudioElement;
import elemental2.dom.HTMLBRElement;
import elemental2.dom.HTMLBodyElement;
import elemental2.dom.HTMLButtonElement;
import elemental2.dom.HTMLCanvasElement;
import elemental2.dom.HTMLDListElement;
import elemental2.dom.HTMLDataListElement;
import elemental2.dom.HTMLDivElement;
import elemental2.dom.HTMLElement;
import elemental2.dom.HTMLEmbedElement;
import elemental2.dom.HTMLFieldSetElement;
import elemental2.dom.HTMLFormElement;
import elemental2.dom.HTMLHRElement;
import elemental2.dom.HTMLHeadingElement;
import elemental2.dom.HTMLIFrameElement;
import elemental2.dom.HTMLImageElement;
import elemental2.dom.HTMLInputElement;
import elemental2.dom.HTMLLIElement;
import elemental2.dom.HTMLLabelElement;
import elemental2.dom.HTMLLegendElement;
import elemental2.dom.HTMLMapElement;
import elemental2.dom.HTMLMeterElement;
import elemental2.dom.HTMLModElement;
import elemental2.dom.HTMLOListElement;
import elemental2.dom.HTMLObjectElement;
import elemental2.dom.HTMLOptGroupElement;
import elemental2.dom.HTMLOptionElement;
import elemental2.dom.HTMLOutputElement;
import elemental2.dom.HTMLParagraphElement;
import elemental2.dom.HTMLParamElement;
import elemental2.dom.HTMLPictureElement;
import elemental2.dom.HTMLPreElement;
import elemental2.dom.HTMLProgressElement;
import elemental2.dom.HTMLQuoteElement;
import elemental2.dom.HTMLScriptElement;
import elemental2.dom.HTMLSelectElement;
import elemental2.dom.HTMLSourceElement;
import elemental2.dom.HTMLTableCaptionElement;
import elemental2.dom.HTMLTableCellElement;
import elemental2.dom.HTMLTableColElement;
import elemental2.dom.HTMLTableElement;
import elemental2.dom.HTMLTableRowElement;
import elemental2.dom.HTMLTableSectionElement;
import elemental2.dom.HTMLTextAreaElement;
import elemental2.dom.HTMLTrackElement;
import elemental2.dom.HTMLUListElement;
import elemental2.dom.HTMLVideoElement;
import elemental2.svg.SVGCircleElement;
import elemental2.svg.SVGElement;
import elemental2.svg.SVGLineElement;

import static elemental2.dom.DomGlobal.document;
import static jsinterop.base.Js.cast;

public interface DomElements {

    String SVGNS = "http://www.w3.org/2000/svg";
    DomElements dom = new DomElements() {
    };

    default <E extends Element> E create(String element, Class<E> type) {
        return cast(document.createElement(element));
    }

    default <E extends Element> E createSVG(String element, Class<E> type) {
        return cast(document.createElementNS(SVGNS, element));
    }

    /**
     * @return a {@link DominoElement} wrapping the document {@link HTMLBodyElement}
     */
    default HTMLBodyElement body() {
        return document.body;
    }

    /**
     * @return a new {@link HTMLDivElement} wrapped as a {@link DominoElement}
     */
    default HTMLPictureElement picture() {
        return create("picture", HTMLPictureElement.class);
    }

    // ------------------------------------------------------ content sectioning

    default HTMLElement address() {
        return create("address", HTMLElement.class);
    }

    default HTMLElement article() {
        return create("article", HTMLElement.class);
    }

    default HTMLElement aside() {
        return create("aside", HTMLElement.class);
    }

    default HTMLElement footer() {
        return create("footer", HTMLElement.class);
    }

    default HTMLHeadingElement h(int n) {
        return create("h" + n, HTMLHeadingElement.class);
    }

    default HTMLElement header() {
        return create("header", HTMLElement.class);
    }

    default HTMLElement hgroup() {
        return create("hgroup", HTMLElement.class);
    }

    default HTMLElement nav() {
        return create("nav", HTMLElement.class);
    }

    default HTMLElement section() {
        return create("section", HTMLElement.class);
    }

    // ------------------------------------------------------ text content

    default HTMLQuoteElement blockquote() {
        return create("blockquote", HTMLQuoteElement.class);
    }

    default HTMLElement dd() {
        return create("dd", HTMLElement.class);
    }

    default HTMLDivElement div() {
        return create("div", HTMLDivElement.class);
    }

    default HTMLDListElement dl() {
        return create("dl", HTMLDListElement.class);
    }

    default HTMLElement dt() {
        return create("dt", HTMLElement.class);
    }

    default HTMLElement figcaption() {
        return create("figcaption", HTMLElement.class);
    }

    default HTMLElement figure() {
        return create("figure", HTMLElement.class);
    }

    default HTMLHRElement hr() {
        return create("hr", HTMLHRElement.class);
    }

    default HTMLLIElement li() {
        return create("li", HTMLLIElement.class);
    }

    default HTMLElement main() {
        return create("main", HTMLElement.class);
    }

    default HTMLOListElement ol() {
        return create("ol", HTMLOListElement.class);
    }

    default HTMLParagraphElement p() {
        return create("p", HTMLParagraphElement.class);
    }

    default HTMLPreElement pre() {
        return create("pre", HTMLPreElement.class);
    }

    default HTMLUListElement ul() {
        return create("ul", HTMLUListElement.class);
    }

    // ------------------------------------------------------ inline text semantics

    default HTMLAnchorElement a() {
        return create("a", HTMLAnchorElement.class);
    }

    default HTMLElement abbr() {
        return create("abbr", HTMLElement.class);
    }

    default HTMLElement b() {
        return create("b", HTMLElement.class);
    }

    default HTMLBRElement br() {
        return create("br", HTMLBRElement.class);
    }

    default HTMLElement cite() {
        return create("cite", HTMLElement.class);
    }

    default HTMLElement code() {
        return create("code", HTMLElement.class);
    }

    default HTMLElement dfn() {
        return create("dfn", HTMLElement.class);
    }

    default HTMLElement em() {
        return create("em", HTMLElement.class);
    }

    default HTMLElement i() {
        return create("i", HTMLElement.class);
    }

    default HTMLElement kbd() {
        return create("kbd", HTMLElement.class);
    }

    default HTMLElement mark() {
        return create("mark", HTMLElement.class);
    }

    default HTMLQuoteElement q() {
        return create("q", HTMLQuoteElement.class);
    }

    default HTMLElement small() {
        return create("small", HTMLElement.class);
    }

    default HTMLElement span() {
        return create("span", HTMLElement.class);
    }

    default HTMLElement strong() {
        return create("strong", HTMLElement.class);
    }

    default HTMLElement sub() {
        return create("sub", HTMLElement.class);
    }

    default HTMLElement sup() {
        return create("sup", HTMLElement.class);
    }

    default HTMLElement time() {
        return create("time", HTMLElement.class);
    }

    default HTMLElement u() {
        return create("u", HTMLElement.class);
    }

    default HTMLElement var() {
        return create("var", HTMLElement.class);
    }

    default HTMLElement wbr() {
        return create("wbr", HTMLElement.class);
    }

    // ------------------------------------------------------ image and multimedia

    default HTMLAreaElement area() {
        return create("area", HTMLAreaElement.class);
    }

    default HTMLAudioElement audio() {
        return create("audio", HTMLAudioElement.class);
    }

    default HTMLImageElement img() {
        return create("img", HTMLImageElement.class);
    }

    default HTMLImageElement img(String src) {
        HTMLImageElement img = create("img", HTMLImageElement.class);
        img.src = src;
        return img;
    }

    default HTMLMapElement map() {
        return create("map", HTMLMapElement.class);
    }

    default HTMLTrackElement track() {
        return create("track", HTMLTrackElement.class);
    }

    default HTMLVideoElement video() {
        return create("video", HTMLVideoElement.class);
    }

    // ------------------------------------------------------ embedded content

    default HTMLCanvasElement canvas() {
        return create("canvas", HTMLCanvasElement.class);
    }

    default HTMLEmbedElement embed() {
        return create("embed", HTMLEmbedElement.class);
    }

    default HTMLIFrameElement iframe() {
        return create("iframe", HTMLIFrameElement.class);
    }

    default HTMLIFrameElement iframe(String src) {
        HTMLIFrameElement iframe = iframe();
        iframe.src = src;
        return iframe;
    }

    default HTMLObjectElement object() {
        return create("object", HTMLObjectElement.class);
    }

    default HTMLParamElement param() {
        return create("param", HTMLParamElement.class);
    }

    default HTMLSourceElement source() {
        return create("source", HTMLSourceElement.class);
    }

    // ------------------------------------------------------ scripting

    default HTMLElement noscript() {
        return create("noscript", HTMLElement.class);
    }

    default HTMLScriptElement script() {
        return create("script", HTMLScriptElement.class);
    }

    // ------------------------------------------------------ demarcating edits

    default HTMLModElement del() {
        return create("del", HTMLModElement.class);
    }

    default HTMLModElement ins() {
        return create("ins", HTMLModElement.class);
    }

    // ------------------------------------------------------ table content

    default HTMLTableCaptionElement caption() {
        return create("caption", HTMLTableCaptionElement.class);
    }

    default HTMLTableColElement col() {
        return create("col", HTMLTableColElement.class);
    }

    default HTMLTableColElement colgroup() {
        return create("colgroup", HTMLTableColElement.class);
    }

    default HTMLTableElement table() {
        return create("table", HTMLTableElement.class);
    }

    default HTMLTableSectionElement tbody() {
        return create("tbody", HTMLTableSectionElement.class);
    }

    default HTMLTableCellElement td() {
        return create("td", HTMLTableCellElement.class);
    }

    default HTMLTableSectionElement tfoot() {
        return create("tfoot", HTMLTableSectionElement.class);
    }

    default HTMLTableCellElement th() {
        return create("th", HTMLTableCellElement.class);
    }

    default HTMLTableSectionElement thead() {
        return create("thead", HTMLTableSectionElement.class);
    }

    default HTMLTableRowElement tr() {
        return create("tr", HTMLTableRowElement.class);
    }

    // ------------------------------------------------------ forms

    default HTMLButtonElement button() {
        return create("button", HTMLButtonElement.class);
    }

    default HTMLDataListElement datalist() {
        return create("datalist", HTMLDataListElement.class);
    }

    default HTMLFieldSetElement fieldset() {
        return create("fieldset", HTMLFieldSetElement.class);
    }

    default HTMLFormElement form() {
        return create("form", HTMLFormElement.class);
    }

    default HTMLInputElement input(InputType type) {
        return input(type.name());
    }

    default HTMLInputElement input(String type) {
        HTMLInputElement input = create("input", HTMLInputElement.class);
        input.type = type;
        return input;
    }

    default HTMLLabelElement label() {
        return create("label", HTMLLabelElement.class);
    }

    default HTMLLegendElement legend() {
        return create("legend", HTMLLegendElement.class);
    }

    default HTMLMeterElement meter() {
        return create("meter", HTMLMeterElement.class);
    }

    default HTMLOptGroupElement optgroup() {
        return create("optgroup", HTMLOptGroupElement.class);
    }

    default HTMLOptionElement option() {
        return create("option", HTMLOptionElement.class);
    }

    default HTMLOutputElement output() {
        return create("output", HTMLOutputElement.class);
    }

    default HTMLProgressElement progress() {
        return create("progress", HTMLProgressElement.class);
    }

    default HTMLSelectElement select_() {
        return create("select", HTMLSelectElement.class);
    }

    default HTMLTextAreaElement textarea() {
        return create("textarea", HTMLTextAreaElement.class);
    }

    default SVGElement svg(){
        return createSVG("svg", SVGElement.class);
    }
    default SVGCircleElement circle(){
        return createSVG("circle", SVGCircleElement.class);
    }

    default SVGLineElement line(){
        return createSVG("line", SVGLineElement.class);
    }
}
