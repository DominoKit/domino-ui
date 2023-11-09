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

/**
 * The {@code DomElements} interface provides factory methods for creating various HTML and SVG
 * elements as well as accessing commonly used HTML elements from the DOM.
 *
 * <p>Example Usage:
 *
 * <pre>
 * // Create an anchor element
 * HTMLAnchorElement anchorElement = DomElements.dom.a();
 *
 * // Create an input element with a specific type
 * HTMLInputElement inputElement = DomElements.dom.input(InputType.TEXT);
 *
 * // Access the document body element
 * HTMLBodyElement bodyElement = DomElements.dom.body();
 * </pre>
 */
public interface DomElements {

  /** The XML namespace for SVG elements. */
  String SVGNS = "http://www.w3.org/2000/svg";

  /** An instance of the {@code DomElements} interface for convenience. */
  DomElements dom = new DomElements() {};

  /**
   * Creates an HTML element of the specified type.
   *
   * @param element The name of the HTML element.
   * @param type The class representing the HTML element.
   * @return An instance of the created HTML element.
   */
  default <E extends Element> E create(String element, Class<E> type) {
    return cast(document.createElement(element));
  }

  /**
   * Creates an SVG element of the specified type.
   *
   * @param element The name of the SVG element.
   * @param type The class representing the SVG element.
   * @return An instance of the created SVG element.
   */
  default <E extends Element> E createSVG(String element, Class<E> type) {
    return cast(document.createElementNS(SVGNS, element));
  }

  /**
   * Accesses the document's body element.
   *
   * @return The HTML body element.
   */
  default HTMLBodyElement body() {
    return document.body;
  }

  /**
   * Creates a {@code <picture>} element.
   *
   * @return The created picture element.
   */
  default HTMLPictureElement picture() {
    return create("picture", HTMLPictureElement.class);
  }

  /**
   * Creates an {@code <address>} element.
   *
   * @return The created address element.
   */
  default HTMLElement address() {
    return create("address", HTMLElement.class);
  }

  /**
   * Creates an {@code <article>} element.
   *
   * @return The created article element.
   */
  default HTMLElement article() {
    return create("article", HTMLElement.class);
  }

  /**
   * Creates an {@code <aside>} element.
   *
   * @return The created aside element.
   */
  default HTMLElement aside() {
    return create("aside", HTMLElement.class);
  }

  /**
   * Creates a {@code <footer>} element.
   *
   * @return The created footer element.
   */
  default HTMLElement footer() {
    return create("footer", HTMLElement.class);
  }

  /**
   * Creates an {@code <h>} element with the specified level.
   *
   * @param n The heading level (e.g., 1 for {@code <h1>}, 2 for {@code <h2>}).
   * @return The created heading element.
   */
  default HTMLHeadingElement h(int n) {
    return create("h" + n, HTMLHeadingElement.class);
  }

  /**
   * Creates a {@code <header>} element.
   *
   * @return The created header element.
   */
  default HTMLElement header() {
    return create("header", HTMLElement.class);
  }

  /**
   * Creates an {@code <hgroup>} element.
   *
   * @return The created hgroup element.
   */
  default HTMLElement hgroup() {
    return create("hgroup", HTMLElement.class);
  }

  /**
   * Creates a {@code <nav>} element.
   *
   * @return The created nav element.
   */
  default HTMLElement nav() {
    return create("nav", HTMLElement.class);
  }

  /**
   * Creates a {@code <section>} element.
   *
   * @return The created section element.
   */
  default HTMLElement section() {
    return create("section", HTMLElement.class);
  }

  /**
   * Creates a {@code <blockquote>} element.
   *
   * @return The created blockquote element.
   */
  default HTMLQuoteElement blockquote() {
    return create("blockquote", HTMLQuoteElement.class);
  }

  /**
   * Creates a {@code <dd>} element.
   *
   * @return The created dd element.
   */
  default HTMLElement dd() {
    return create("dd", HTMLElement.class);
  }

  /**
   * Creates a {@code <div>} element.
   *
   * @return The created div element.
   */
  default HTMLDivElement div() {
    return create("div", HTMLDivElement.class);
  }

  /**
   * Creates a {@code <dl>} element (definition list).
   *
   * @return The created dl element.
   */
  default HTMLDListElement dl() {
    return create("dl", HTMLDListElement.class);
  }

  /**
   * Creates a {@code <dt>} element (definition term).
   *
   * @return The created dt element.
   */
  default HTMLElement dt() {
    return create("dt", HTMLElement.class);
  }

  /**
   * Creates a {@code <figcaption>} element.
   *
   * @return The created figcaption element.
   */
  default HTMLElement figcaption() {
    return create("figcaption", HTMLElement.class);
  }

  /**
   * Creates a {@code <figure>} element.
   *
   * @return The created figure element.
   */
  default HTMLElement figure() {
    return create("figure", HTMLElement.class);
  }

  /**
   * Creates a {@code <hr>} element (horizontal rule).
   *
   * @return The created hr element.
   */
  default HTMLHRElement hr() {
    return create("hr", HTMLHRElement.class);
  }

  /**
   * Creates a {@code <li>} element (list item).
   *
   * @return The created li element.
   */
  default HTMLLIElement li() {
    return create("li", HTMLLIElement.class);
  }

  /**
   * Creates a {@code <main>} element.
   *
   * @return The created main element.
   */
  default HTMLElement main() {
    return create("main", HTMLElement.class);
  }

  /**
   * Creates an {@code <ol>} element (ordered list).
   *
   * @return The created ol element.
   */
  default HTMLOListElement ol() {
    return create("ol", HTMLOListElement.class);
  }

  /**
   * Creates a {@code <p>} element (paragraph).
   *
   * @return The created p element.
   */
  default HTMLParagraphElement p() {
    return create("p", HTMLParagraphElement.class);
  }

  /**
   * Creates a {@code <pre>} element (preformatted text).
   *
   * @return The created pre element.
   */
  default HTMLPreElement pre() {
    return create("pre", HTMLPreElement.class);
  }

  /**
   * Creates a {@code <ul>} element (unordered list).
   *
   * @return The created ul element.
   */
  default HTMLUListElement ul() {
    return create("ul", HTMLUListElement.class);
  }

  /**
   * Creates an {@code <a>} element (anchor).
   *
   * @return The created a element.
   */
  default HTMLAnchorElement a() {
    return create("a", HTMLAnchorElement.class);
  }

  /**
   * Creates an {@code <abbr>} element (abbreviation).
   *
   * @return The created abbr element.
   */
  default HTMLElement abbr() {
    return create("abbr", HTMLElement.class);
  }

  /**
   * Creates a {@code <b>} element (bold text).
   *
   * @return The created b element.
   */
  default HTMLElement b() {
    return create("b", HTMLElement.class);
  }

  /**
   * Creates a {@code <br>} element (line break).
   *
   * @return The created br element.
   */
  default HTMLBRElement br() {
    return create("br", HTMLBRElement.class);
  }

  /**
   * Creates a {@code <cite>} element (citation).
   *
   * @return The created cite element.
   */
  default HTMLElement cite() {
    return create("cite", HTMLElement.class);
  }

  /**
   * Creates a {@code <code>} element (code).
   *
   * @return The created code element.
   */
  default HTMLElement code() {
    return create("code", HTMLElement.class);
  }

  /**
   * Creates a {@code <dfn>} element (definition).
   *
   * @return The created dfn element.
   */
  default HTMLElement dfn() {
    return create("dfn", HTMLElement.class);
  }

  /**
   * Creates an {@code <em>} element (emphasized text).
   *
   * @return The created em element.
   */
  default HTMLElement em() {
    return create("em", HTMLElement.class);
  }

  /**
   * Creates an {@code <i>} element (italicized text).
   *
   * @return The created i element.
   */
  default HTMLElement i() {
    return create("i", HTMLElement.class);
  }

  /**
   * Creates a {@code <kbd>} element (keyboard input).
   *
   * @return The created kbd element.
   */
  default HTMLElement kbd() {
    return create("kbd", HTMLElement.class);
  }

  /**
   * Creates a {@code <mark>} element (highlighted text).
   *
   * @return The created mark element.
   */
  default HTMLElement mark() {
    return create("mark", HTMLElement.class);
  }

  /**
   * Creates a {@code <q>} element (short inline quotation).
   *
   * @return The created q element.
   */
  default HTMLQuoteElement q() {
    return create("q", HTMLQuoteElement.class);
  }

  /**
   * Creates a {@code <small>} element (small text).
   *
   * @return The created small element.
   */
  default HTMLElement small() {
    return create("small", HTMLElement.class);
  }

  /**
   * Creates a {@code <span>} element (generic inline container).
   *
   * @return The created span element.
   */
  default HTMLElement span() {
    return create("span", HTMLElement.class);
  }

  /**
   * Creates a {@code <strong>} element (strong importance).
   *
   * @return The created strong element.
   */
  default HTMLElement strong() {
    return create("strong", HTMLElement.class);
  }

  /**
   * Creates a {@code <sub>} element (subscript).
   *
   * @return The created sub element.
   */
  default HTMLElement sub() {
    return create("sub", HTMLElement.class);
  }

  /**
   * Creates a {@code <sup>} element (superscript).
   *
   * @return The created sup element.
   */
  default HTMLElement sup() {
    return create("sup", HTMLElement.class);
  }

  /**
   * Creates a {@code <time>} element (time or date).
   *
   * @return The created time element.
   */
  default HTMLElement time() {
    return create("time", HTMLElement.class);
  }

  /**
   * Creates a {@code <u>} element (underlined text).
   *
   * @return The created u element.
   */
  default HTMLElement u() {
    return create("u", HTMLElement.class);
  }

  /**
   * Creates a {@code <var>} element (variable).
   *
   * @return The created var element.
   */
  default HTMLElement var() {
    return create("var", HTMLElement.class);
  }

  /**
   * Creates a {@code <wbr>} element (word break opportunity).
   *
   * @return The created wbr element.
   */
  default HTMLElement wbr() {
    return create("wbr", HTMLElement.class);
  }

  /**
   * Creates an {@code <area>} element (image map area).
   *
   * @return The created area element.
   */
  default HTMLAreaElement area() {
    return create("area", HTMLAreaElement.class);
  }

  /**
   * Creates an {@code <audio>} element (audio playback).
   *
   * @return The created audio element.
   */
  default HTMLAudioElement audio() {
    return create("audio", HTMLAudioElement.class);
  }

  /**
   * Creates an {@code <img>} element (image).
   *
   * @return The created img element.
   */
  default HTMLImageElement img() {
    return create("img", HTMLImageElement.class);
  }

  /**
   * Creates an {@code <img>} element (image) with the specified source (src).
   *
   * @param src The source URL for the image.
   * @return The created img element with the specified source.
   */
  default HTMLImageElement img(String src) {
    HTMLImageElement img = create("img", HTMLImageElement.class);
    img.src = src;
    return img;
  }

  /**
   * Creates a {@code <map>} element (image map).
   *
   * @return The created map element.
   */
  default HTMLMapElement map() {
    return create("map", HTMLMapElement.class);
  }

  /**
   * Creates a {@code <track>} element (text tracks for media elements).
   *
   * @return The created track element.
   */
  default HTMLTrackElement track() {
    return create("track", HTMLTrackElement.class);
  }

  /**
   * Creates a {@code <video>} element (video playback).
   *
   * @return The created video element.
   */
  default HTMLVideoElement video() {
    return create("video", HTMLVideoElement.class);
  }

  /**
   * Creates a {@code <canvas>} element (drawing surface).
   *
   * @return The created canvas element.
   */
  default HTMLCanvasElement canvas() {
    return create("canvas", HTMLCanvasElement.class);
  }

  /**
   * Creates an {@code <embed>} element (external content).
   *
   * @return The created embed element.
   */
  default HTMLEmbedElement embed() {
    return create("embed", HTMLEmbedElement.class);
  }

  /**
   * Creates an {@code <iframe>} element (inline frame).
   *
   * @return The created iframe element.
   */
  default HTMLIFrameElement iframe() {
    return create("iframe", HTMLIFrameElement.class);
  }

  /**
   * Creates an {@code <iframe>} element (inline frame) with the specified source (src).
   *
   * @param src The source URL for the iframe.
   * @return The created iframe element with the specified source.
   */
  default HTMLIFrameElement iframe(String src) {
    HTMLIFrameElement iframe = iframe();
    iframe.src = src;
    return iframe;
  }

  /**
   * Creates an {@code <object>} element (embedded object).
   *
   * @return The created object element.
   */
  default HTMLObjectElement object() {
    return create("object", HTMLObjectElement.class);
  }

  /**
   * Creates a {@code <param>} element (parameter for object elements).
   *
   * @return The created param element.
   */
  default HTMLParamElement param() {
    return create("param", HTMLParamElement.class);
  }

  /**
   * Creates a {@code <source>} element (media resource for media elements).
   *
   * @return The created source element.
   */
  default HTMLSourceElement source() {
    return create("source", HTMLSourceElement.class);
  }

  /**
   * Creates a {@code <noscript>} element (fallback content for script-disabled browsers).
   *
   * @return The created noscript element.
   */
  default HTMLElement noscript() {
    return create("noscript", HTMLElement.class);
  }

  /**
   * Creates a {@code <script>} element (JavaScript code).
   *
   * @return The created script element.
   */
  default HTMLScriptElement script() {
    return create("script", HTMLScriptElement.class);
  }

  /**
   * Creates a {@code <del>} element (deleted text).
   *
   * @return The created del element.
   */
  default HTMLModElement del() {
    return create("del", HTMLModElement.class);
  }

  /**
   * Creates an {@code <ins>} element (inserted text).
   *
   * @return The created ins element.
   */
  default HTMLModElement ins() {
    return create("ins", HTMLModElement.class);
  }

  /**
   * Creates a {@code <caption>} element (table caption).
   *
   * @return The created caption element.
   */
  default HTMLTableCaptionElement caption() {
    return create("caption", HTMLTableCaptionElement.class);
  }

  /**
   * Creates a {@code <col>} element (table column).
   *
   * @return The created col element.
   */
  default HTMLTableColElement col() {
    return create("col", HTMLTableColElement.class);
  }

  /**
   * Creates a {@code <colgroup>} element (group of table columns).
   *
   * @return The created colgroup element.
   */
  default HTMLTableColElement colgroup() {
    return create("colgroup", HTMLTableColElement.class);
  }

  /**
   * Creates a {@code <table>} element (table).
   *
   * @return The created table element.
   */
  default HTMLTableElement table() {
    return create("table", HTMLTableElement.class);
  }

  /**
   * Creates a {@code <tbody>} element (table body section).
   *
   * @return The created tbody element.
   */
  default HTMLTableSectionElement tbody() {
    return create("tbody", HTMLTableSectionElement.class);
  }

  /**
   * Creates a {@code <td>} element (table cell).
   *
   * @return The created td element.
   */
  default HTMLTableCellElement td() {
    return create("td", HTMLTableCellElement.class);
  }

  /**
   * Creates a {@code <tfoot>} element (table footer section).
   *
   * @return The created tfoot element.
   */
  default HTMLTableSectionElement tfoot() {
    return create("tfoot", HTMLTableSectionElement.class);
  }

  /**
   * Creates a {@code <th>} element (table header cell).
   *
   * @return The created th element.
   */
  default HTMLTableCellElement th() {
    return create("th", HTMLTableCellElement.class);
  }

  /**
   * Creates a {@code <thead>} element (table header section).
   *
   * @return The created thead element.
   */
  default HTMLTableSectionElement thead() {
    return create("thead", HTMLTableSectionElement.class);
  }

  /**
   * Creates a {@code <tr>} element (table row).
   *
   * @return The created tr element.
   */
  default HTMLTableRowElement tr() {
    return create("tr", HTMLTableRowElement.class);
  }

  /**
   * Creates a {@code <button>} element (button).
   *
   * @return The created button element.
   */
  default HTMLButtonElement button() {
    return create("button", HTMLButtonElement.class);
  }

  /**
   * Creates a {@code <datalist>} element (datalist for input elements).
   *
   * @return The created datalist element.
   */
  default HTMLDataListElement datalist() {
    return create("datalist", HTMLDataListElement.class);
  }

  /**
   * Creates a {@code <fieldset>} element (fieldset).
   *
   * @return The created fieldset element.
   */
  default HTMLFieldSetElement fieldset() {
    return create("fieldset", HTMLFieldSetElement.class);
  }

  /**
   * Creates a {@code <form>} element (form).
   *
   * @return The created form element.
   */
  default HTMLFormElement form() {
    return create("form", HTMLFormElement.class);
  }

  /**
   * Creates an {@code <input>} element (input field) with the specified type.
   *
   * @param type The input type (e.g., "text", "checkbox").
   * @return The created input element with the specified type.
   */
  default HTMLInputElement input(InputType type) {
    return input(type.name());
  }

  /**
   * Creates an {@code <input>} element (input field) with the specified type.
   *
   * @param type The input type as a string (e.g., "text", "checkbox").
   * @return The created input element with the specified type.
   */
  default HTMLInputElement input(String type) {
    HTMLInputElement input = create("input", HTMLInputElement.class);
    input.type = type;
    return input;
  }

  /**
   * Creates a {@code <label>} element (label for form elements).
   *
   * @return The created label element.
   */
  default HTMLLabelElement label() {
    return create("label", HTMLLabelElement.class);
  }

  /**
   * Creates a {@code <legend>} element (legend for fieldset).
   *
   * @return The created legend element.
   */
  default HTMLLegendElement legend() {
    return create("legend", HTMLLegendElement.class);
  }

  /**
   * Creates a {@code <meter>} element (meter for gauge).
   *
   * @return The created meter element.
   */
  default HTMLMeterElement meter() {
    return create("meter", HTMLMeterElement.class);
  }

  /**
   * Creates a {@code <optgroup>} element (group of options within a select element).
   *
   * @return The created optgroup element.
   */
  default HTMLOptGroupElement optgroup() {
    return create("optgroup", HTMLOptGroupElement.class);
  }

  /**
   * Creates a {@code <option>} element (selectable option within a select element).
   *
   * @return The created option element.
   */
  default HTMLOptionElement option() {
    return create("option", HTMLOptionElement.class);
  }

  /**
   * Creates an {@code <output>} element (output for form calculation results).
   *
   * @return The created output element.
   */
  default HTMLOutputElement output() {
    return create("output", HTMLOutputElement.class);
  }

  /**
   * Creates a {@code <progress>} element (progress bar).
   *
   * @return The created progress element.
   */
  default HTMLProgressElement progress() {
    return create("progress", HTMLProgressElement.class);
  }

  /**
   * Creates a {@code <select>} element (dropdown select list).
   *
   * @return The created select element.
   */
  default HTMLSelectElement select_() {
    return create("select", HTMLSelectElement.class);
  }

  /**
   * Creates a {@code <textarea>} element (multiline text input).
   *
   * @return The created textarea element.
   */
  default HTMLTextAreaElement textarea() {
    return create("textarea", HTMLTextAreaElement.class);
  }

  /**
   * Creates an {@code <svg>} element (Scalable Vector Graphics container).
   *
   * @return The created svg element.
   */
  default SVGElement svg() {
    return createSVG("svg", SVGElement.class);
  }

  /**
   * Creates an {@code <svg>} element (Scalable Vector Graphics container).
   *
   * @param <T> The actual type of the svg element being created
   * @param tag The string tag name for the svg element.
   * @param type The concrete type for the svg element
   * @return The created svg element.
   */
  default <T extends SVGElement> T svg(String tag, Class<T> type) {
    return createSVG(tag, type);
  }

  /**
   * Creates a {@code <circle>} element (SVG circle).
   *
   * @return The created circle element.
   */
  default SVGCircleElement circle() {
    return createSVG("circle", SVGCircleElement.class);
  }

  /**
   * Creates a {@code <line>} element (SVG line).
   *
   * @return The created line element.
   */
  default SVGLineElement line() {
    return createSVG("line", SVGLineElement.class);
  }
}
