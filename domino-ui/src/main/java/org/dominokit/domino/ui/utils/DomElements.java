/*
 * Copyright © 2019 Dominokit
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.dominokit.domino.ui.utils;

import static elemental2.dom.DomGlobal.document;
import static jsinterop.base.Js.cast;

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

/** DomElements interface. */
public interface DomElements {

  /** Constant <code>SVGNS="http://www.w3.org/2000/svg"</code> */
  String SVGNS = "http://www.w3.org/2000/svg";
  /** Constant <code>dom</code> */
  DomElements dom = new DomElements() {};

  /**
   * create.
   *
   * @param element a {@link java.lang.String} object
   * @param type a {@link java.lang.Class} object
   * @param <E> a E class
   * @return a E object
   */
  default <E extends Element> E create(String element, Class<E> type) {
    return cast(document.createElement(element));
  }

  /**
   * createSVG.
   *
   * @param element a {@link java.lang.String} object
   * @param type a {@link java.lang.Class} object
   * @param <E> a E class
   * @return a E object
   */
  default <E extends Element> E createSVG(String element, Class<E> type) {
    return cast(document.createElementNS(SVGNS, element));
  }

  /** @return a {@link DominoElement} wrapping the document {@link HTMLBodyElement} */
  /**
   * body.
   *
   * @return a {@link elemental2.dom.HTMLBodyElement} object
   */
  default HTMLBodyElement body() {
    return document.body;
  }

  /** @return a new {@link HTMLDivElement} wrapped as a {@link DominoElement} */
  /**
   * picture.
   *
   * @return a {@link elemental2.dom.HTMLPictureElement} object
   */
  default HTMLPictureElement picture() {
    return create("picture", HTMLPictureElement.class);
  }

  // ------------------------------------------------------ content sectioning

  /**
   * address.
   *
   * @return a {@link elemental2.dom.HTMLElement} object
   */
  default HTMLElement address() {
    return create("address", HTMLElement.class);
  }

  /**
   * article.
   *
   * @return a {@link elemental2.dom.HTMLElement} object
   */
  default HTMLElement article() {
    return create("article", HTMLElement.class);
  }

  /**
   * aside.
   *
   * @return a {@link elemental2.dom.HTMLElement} object
   */
  default HTMLElement aside() {
    return create("aside", HTMLElement.class);
  }

  /**
   * footer.
   *
   * @return a {@link elemental2.dom.HTMLElement} object
   */
  default HTMLElement footer() {
    return create("footer", HTMLElement.class);
  }

  /**
   * h.
   *
   * @param n a int
   * @return a {@link elemental2.dom.HTMLHeadingElement} object
   */
  default HTMLHeadingElement h(int n) {
    return create("h" + n, HTMLHeadingElement.class);
  }

  /**
   * header.
   *
   * @return a {@link elemental2.dom.HTMLElement} object
   */
  default HTMLElement header() {
    return create("header", HTMLElement.class);
  }

  /**
   * hgroup.
   *
   * @return a {@link elemental2.dom.HTMLElement} object
   */
  default HTMLElement hgroup() {
    return create("hgroup", HTMLElement.class);
  }

  /**
   * nav.
   *
   * @return a {@link elemental2.dom.HTMLElement} object
   */
  default HTMLElement nav() {
    return create("nav", HTMLElement.class);
  }

  /**
   * section.
   *
   * @return a {@link elemental2.dom.HTMLElement} object
   */
  default HTMLElement section() {
    return create("section", HTMLElement.class);
  }

  // ------------------------------------------------------ text content

  /**
   * blockquote.
   *
   * @return a {@link elemental2.dom.HTMLQuoteElement} object
   */
  default HTMLQuoteElement blockquote() {
    return create("blockquote", HTMLQuoteElement.class);
  }

  /**
   * dd.
   *
   * @return a {@link elemental2.dom.HTMLElement} object
   */
  default HTMLElement dd() {
    return create("dd", HTMLElement.class);
  }

  /**
   * div.
   *
   * @return a {@link elemental2.dom.HTMLDivElement} object
   */
  default HTMLDivElement div() {
    return create("div", HTMLDivElement.class);
  }

  /**
   * dl.
   *
   * @return a {@link elemental2.dom.HTMLDListElement} object
   */
  default HTMLDListElement dl() {
    return create("dl", HTMLDListElement.class);
  }

  /**
   * dt.
   *
   * @return a {@link elemental2.dom.HTMLElement} object
   */
  default HTMLElement dt() {
    return create("dt", HTMLElement.class);
  }

  /**
   * figcaption.
   *
   * @return a {@link elemental2.dom.HTMLElement} object
   */
  default HTMLElement figcaption() {
    return create("figcaption", HTMLElement.class);
  }

  /**
   * figure.
   *
   * @return a {@link elemental2.dom.HTMLElement} object
   */
  default HTMLElement figure() {
    return create("figure", HTMLElement.class);
  }

  /**
   * hr.
   *
   * @return a {@link elemental2.dom.HTMLHRElement} object
   */
  default HTMLHRElement hr() {
    return create("hr", HTMLHRElement.class);
  }

  /**
   * li.
   *
   * @return a {@link elemental2.dom.HTMLLIElement} object
   */
  default HTMLLIElement li() {
    return create("li", HTMLLIElement.class);
  }

  /**
   * main.
   *
   * @return a {@link elemental2.dom.HTMLElement} object
   */
  default HTMLElement main() {
    return create("main", HTMLElement.class);
  }

  /**
   * ol.
   *
   * @return a {@link elemental2.dom.HTMLOListElement} object
   */
  default HTMLOListElement ol() {
    return create("ol", HTMLOListElement.class);
  }

  /**
   * p.
   *
   * @return a {@link elemental2.dom.HTMLParagraphElement} object
   */
  default HTMLParagraphElement p() {
    return create("p", HTMLParagraphElement.class);
  }

  /**
   * pre.
   *
   * @return a {@link elemental2.dom.HTMLPreElement} object
   */
  default HTMLPreElement pre() {
    return create("pre", HTMLPreElement.class);
  }

  /**
   * ul.
   *
   * @return a {@link elemental2.dom.HTMLUListElement} object
   */
  default HTMLUListElement ul() {
    return create("ul", HTMLUListElement.class);
  }

  // ------------------------------------------------------ inline text semantics

  /**
   * a.
   *
   * @return a {@link elemental2.dom.HTMLAnchorElement} object
   */
  default HTMLAnchorElement a() {
    return create("a", HTMLAnchorElement.class);
  }

  /**
   * abbr.
   *
   * @return a {@link elemental2.dom.HTMLElement} object
   */
  default HTMLElement abbr() {
    return create("abbr", HTMLElement.class);
  }

  /**
   * b.
   *
   * @return a {@link elemental2.dom.HTMLElement} object
   */
  default HTMLElement b() {
    return create("b", HTMLElement.class);
  }

  /**
   * br.
   *
   * @return a {@link elemental2.dom.HTMLBRElement} object
   */
  default HTMLBRElement br() {
    return create("br", HTMLBRElement.class);
  }

  /**
   * cite.
   *
   * @return a {@link elemental2.dom.HTMLElement} object
   */
  default HTMLElement cite() {
    return create("cite", HTMLElement.class);
  }

  /**
   * code.
   *
   * @return a {@link elemental2.dom.HTMLElement} object
   */
  default HTMLElement code() {
    return create("code", HTMLElement.class);
  }

  /**
   * dfn.
   *
   * @return a {@link elemental2.dom.HTMLElement} object
   */
  default HTMLElement dfn() {
    return create("dfn", HTMLElement.class);
  }

  /**
   * em.
   *
   * @return a {@link elemental2.dom.HTMLElement} object
   */
  default HTMLElement em() {
    return create("em", HTMLElement.class);
  }

  /**
   * i.
   *
   * @return a {@link elemental2.dom.HTMLElement} object
   */
  default HTMLElement i() {
    return create("i", HTMLElement.class);
  }

  /**
   * kbd.
   *
   * @return a {@link elemental2.dom.HTMLElement} object
   */
  default HTMLElement kbd() {
    return create("kbd", HTMLElement.class);
  }

  /**
   * mark.
   *
   * @return a {@link elemental2.dom.HTMLElement} object
   */
  default HTMLElement mark() {
    return create("mark", HTMLElement.class);
  }

  /**
   * q.
   *
   * @return a {@link elemental2.dom.HTMLQuoteElement} object
   */
  default HTMLQuoteElement q() {
    return create("q", HTMLQuoteElement.class);
  }

  /**
   * small.
   *
   * @return a {@link elemental2.dom.HTMLElement} object
   */
  default HTMLElement small() {
    return create("small", HTMLElement.class);
  }

  /**
   * span.
   *
   * @return a {@link elemental2.dom.HTMLElement} object
   */
  default HTMLElement span() {
    return create("span", HTMLElement.class);
  }

  /**
   * strong.
   *
   * @return a {@link elemental2.dom.HTMLElement} object
   */
  default HTMLElement strong() {
    return create("strong", HTMLElement.class);
  }

  /**
   * sub.
   *
   * @return a {@link elemental2.dom.HTMLElement} object
   */
  default HTMLElement sub() {
    return create("sub", HTMLElement.class);
  }

  /**
   * sup.
   *
   * @return a {@link elemental2.dom.HTMLElement} object
   */
  default HTMLElement sup() {
    return create("sup", HTMLElement.class);
  }

  /**
   * time.
   *
   * @return a {@link elemental2.dom.HTMLElement} object
   */
  default HTMLElement time() {
    return create("time", HTMLElement.class);
  }

  /**
   * u.
   *
   * @return a {@link elemental2.dom.HTMLElement} object
   */
  default HTMLElement u() {
    return create("u", HTMLElement.class);
  }

  /**
   * var.
   *
   * @return a {@link elemental2.dom.HTMLElement} object
   */
  default HTMLElement var() {
    return create("var", HTMLElement.class);
  }

  /**
   * wbr.
   *
   * @return a {@link elemental2.dom.HTMLElement} object
   */
  default HTMLElement wbr() {
    return create("wbr", HTMLElement.class);
  }

  // ------------------------------------------------------ image and multimedia

  /**
   * area.
   *
   * @return a {@link elemental2.dom.HTMLAreaElement} object
   */
  default HTMLAreaElement area() {
    return create("area", HTMLAreaElement.class);
  }

  /**
   * audio.
   *
   * @return a {@link elemental2.dom.HTMLAudioElement} object
   */
  default HTMLAudioElement audio() {
    return create("audio", HTMLAudioElement.class);
  }

  /**
   * img.
   *
   * @return a {@link elemental2.dom.HTMLImageElement} object
   */
  default HTMLImageElement img() {
    return create("img", HTMLImageElement.class);
  }

  /**
   * img.
   *
   * @param src a {@link java.lang.String} object
   * @return a {@link elemental2.dom.HTMLImageElement} object
   */
  default HTMLImageElement img(String src) {
    HTMLImageElement img = create("img", HTMLImageElement.class);
    img.src = src;
    return img;
  }

  /**
   * map.
   *
   * @return a {@link elemental2.dom.HTMLMapElement} object
   */
  default HTMLMapElement map() {
    return create("map", HTMLMapElement.class);
  }

  /**
   * track.
   *
   * @return a {@link elemental2.dom.HTMLTrackElement} object
   */
  default HTMLTrackElement track() {
    return create("track", HTMLTrackElement.class);
  }

  /**
   * video.
   *
   * @return a {@link elemental2.dom.HTMLVideoElement} object
   */
  default HTMLVideoElement video() {
    return create("video", HTMLVideoElement.class);
  }

  // ------------------------------------------------------ embedded content

  /**
   * canvas.
   *
   * @return a {@link elemental2.dom.HTMLCanvasElement} object
   */
  default HTMLCanvasElement canvas() {
    return create("canvas", HTMLCanvasElement.class);
  }

  /**
   * embed.
   *
   * @return a {@link elemental2.dom.HTMLEmbedElement} object
   */
  default HTMLEmbedElement embed() {
    return create("embed", HTMLEmbedElement.class);
  }

  /**
   * iframe.
   *
   * @return a {@link elemental2.dom.HTMLIFrameElement} object
   */
  default HTMLIFrameElement iframe() {
    return create("iframe", HTMLIFrameElement.class);
  }

  /**
   * iframe.
   *
   * @param src a {@link java.lang.String} object
   * @return a {@link elemental2.dom.HTMLIFrameElement} object
   */
  default HTMLIFrameElement iframe(String src) {
    HTMLIFrameElement iframe = iframe();
    iframe.src = src;
    return iframe;
  }

  /**
   * object.
   *
   * @return a {@link elemental2.dom.HTMLObjectElement} object
   */
  default HTMLObjectElement object() {
    return create("object", HTMLObjectElement.class);
  }

  /**
   * param.
   *
   * @return a {@link elemental2.dom.HTMLParamElement} object
   */
  default HTMLParamElement param() {
    return create("param", HTMLParamElement.class);
  }

  /**
   * source.
   *
   * @return a {@link elemental2.dom.HTMLSourceElement} object
   */
  default HTMLSourceElement source() {
    return create("source", HTMLSourceElement.class);
  }

  // ------------------------------------------------------ scripting

  /**
   * noscript.
   *
   * @return a {@link elemental2.dom.HTMLElement} object
   */
  default HTMLElement noscript() {
    return create("noscript", HTMLElement.class);
  }

  /**
   * script.
   *
   * @return a {@link elemental2.dom.HTMLScriptElement} object
   */
  default HTMLScriptElement script() {
    return create("script", HTMLScriptElement.class);
  }

  // ------------------------------------------------------ demarcating edits

  /**
   * del.
   *
   * @return a {@link elemental2.dom.HTMLModElement} object
   */
  default HTMLModElement del() {
    return create("del", HTMLModElement.class);
  }

  /**
   * ins.
   *
   * @return a {@link elemental2.dom.HTMLModElement} object
   */
  default HTMLModElement ins() {
    return create("ins", HTMLModElement.class);
  }

  // ------------------------------------------------------ table content

  /**
   * caption.
   *
   * @return a {@link elemental2.dom.HTMLTableCaptionElement} object
   */
  default HTMLTableCaptionElement caption() {
    return create("caption", HTMLTableCaptionElement.class);
  }

  /**
   * col.
   *
   * @return a {@link elemental2.dom.HTMLTableColElement} object
   */
  default HTMLTableColElement col() {
    return create("col", HTMLTableColElement.class);
  }

  /**
   * colgroup.
   *
   * @return a {@link elemental2.dom.HTMLTableColElement} object
   */
  default HTMLTableColElement colgroup() {
    return create("colgroup", HTMLTableColElement.class);
  }

  /**
   * table.
   *
   * @return a {@link elemental2.dom.HTMLTableElement} object
   */
  default HTMLTableElement table() {
    return create("table", HTMLTableElement.class);
  }

  /**
   * tbody.
   *
   * @return a {@link elemental2.dom.HTMLTableSectionElement} object
   */
  default HTMLTableSectionElement tbody() {
    return create("tbody", HTMLTableSectionElement.class);
  }

  /**
   * td.
   *
   * @return a {@link elemental2.dom.HTMLTableCellElement} object
   */
  default HTMLTableCellElement td() {
    return create("td", HTMLTableCellElement.class);
  }

  /**
   * tfoot.
   *
   * @return a {@link elemental2.dom.HTMLTableSectionElement} object
   */
  default HTMLTableSectionElement tfoot() {
    return create("tfoot", HTMLTableSectionElement.class);
  }

  /**
   * th.
   *
   * @return a {@link elemental2.dom.HTMLTableCellElement} object
   */
  default HTMLTableCellElement th() {
    return create("th", HTMLTableCellElement.class);
  }

  /**
   * thead.
   *
   * @return a {@link elemental2.dom.HTMLTableSectionElement} object
   */
  default HTMLTableSectionElement thead() {
    return create("thead", HTMLTableSectionElement.class);
  }

  /**
   * tr.
   *
   * @return a {@link elemental2.dom.HTMLTableRowElement} object
   */
  default HTMLTableRowElement tr() {
    return create("tr", HTMLTableRowElement.class);
  }

  // ------------------------------------------------------ forms

  /**
   * button.
   *
   * @return a {@link elemental2.dom.HTMLButtonElement} object
   */
  default HTMLButtonElement button() {
    return create("button", HTMLButtonElement.class);
  }

  /**
   * datalist.
   *
   * @return a {@link elemental2.dom.HTMLDataListElement} object
   */
  default HTMLDataListElement datalist() {
    return create("datalist", HTMLDataListElement.class);
  }

  /**
   * fieldset.
   *
   * @return a {@link elemental2.dom.HTMLFieldSetElement} object
   */
  default HTMLFieldSetElement fieldset() {
    return create("fieldset", HTMLFieldSetElement.class);
  }

  /**
   * form.
   *
   * @return a {@link elemental2.dom.HTMLFormElement} object
   */
  default HTMLFormElement form() {
    return create("form", HTMLFormElement.class);
  }

  /**
   * input.
   *
   * @param type a {@link org.dominokit.domino.ui.utils.InputType} object
   * @return a {@link elemental2.dom.HTMLInputElement} object
   */
  default HTMLInputElement input(InputType type) {
    return input(type.name());
  }

  /**
   * input.
   *
   * @param type a {@link java.lang.String} object
   * @return a {@link elemental2.dom.HTMLInputElement} object
   */
  default HTMLInputElement input(String type) {
    HTMLInputElement input = create("input", HTMLInputElement.class);
    input.type = type;
    return input;
  }

  /**
   * label.
   *
   * @return a {@link elemental2.dom.HTMLLabelElement} object
   */
  default HTMLLabelElement label() {
    return create("label", HTMLLabelElement.class);
  }

  /**
   * legend.
   *
   * @return a {@link elemental2.dom.HTMLLegendElement} object
   */
  default HTMLLegendElement legend() {
    return create("legend", HTMLLegendElement.class);
  }

  /**
   * meter.
   *
   * @return a {@link elemental2.dom.HTMLMeterElement} object
   */
  default HTMLMeterElement meter() {
    return create("meter", HTMLMeterElement.class);
  }

  /**
   * optgroup.
   *
   * @return a {@link elemental2.dom.HTMLOptGroupElement} object
   */
  default HTMLOptGroupElement optgroup() {
    return create("optgroup", HTMLOptGroupElement.class);
  }

  /**
   * option.
   *
   * @return a {@link elemental2.dom.HTMLOptionElement} object
   */
  default HTMLOptionElement option() {
    return create("option", HTMLOptionElement.class);
  }

  /**
   * output.
   *
   * @return a {@link elemental2.dom.HTMLOutputElement} object
   */
  default HTMLOutputElement output() {
    return create("output", HTMLOutputElement.class);
  }

  /**
   * progress.
   *
   * @return a {@link elemental2.dom.HTMLProgressElement} object
   */
  default HTMLProgressElement progress() {
    return create("progress", HTMLProgressElement.class);
  }

  /**
   * select_.
   *
   * @return a {@link elemental2.dom.HTMLSelectElement} object
   */
  default HTMLSelectElement select_() {
    return create("select", HTMLSelectElement.class);
  }

  /**
   * textarea.
   *
   * @return a {@link elemental2.dom.HTMLTextAreaElement} object
   */
  default HTMLTextAreaElement textarea() {
    return create("textarea", HTMLTextAreaElement.class);
  }

  /**
   * svg.
   *
   * @return a {@link elemental2.svg.SVGElement} object
   */
  default SVGElement svg() {
    return createSVG("svg", SVGElement.class);
  }

  /**
   * circle.
   *
   * @return a {@link elemental2.svg.SVGCircleElement} object
   */
  default SVGCircleElement circle() {
    return createSVG("circle", SVGCircleElement.class);
  }

  /**
   * line.
   *
   * @return a {@link elemental2.svg.SVGLineElement} object
   */
  default SVGLineElement line() {
    return createSVG("line", SVGLineElement.class);
  }
}
