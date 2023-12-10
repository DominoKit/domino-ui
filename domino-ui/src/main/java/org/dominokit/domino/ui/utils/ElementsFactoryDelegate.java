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
import static java.util.Objects.isNull;
import static java.util.Objects.nonNull;
import static jsinterop.base.Js.cast;
import static org.dominokit.domino.ui.utils.DomElements.dom;
import static org.dominokit.domino.ui.utils.Domino.*;

import elemental2.dom.DomGlobal;
import elemental2.dom.Element;
import elemental2.dom.Text;
import elemental2.svg.SVGElement;
import java.util.Optional;
import org.dominokit.domino.ui.IsElement;
import org.dominokit.domino.ui.elements.*;
import org.dominokit.domino.ui.elements.svg.CircleElement;
import org.dominokit.domino.ui.elements.svg.LineElement;

/** A utility interface for creating and manipulating HTML elements in a DOM tree. */
public interface ElementsFactoryDelegate {

  /**
   * Retrieves an element by its unique identifier.
   *
   * @param id The unique identifier of the element.
   * @return An {@link Optional} containing the element if found, or an empty {@link Optional} if
   *     not found.
   */
  default Optional<DominoElement<Element>> byId(String id) {
    Element elementById = document.getElementById(id);
    if (nonNull(elementById)) {
      return Optional.of(elementOf(elementById));
    }
    return Optional.empty();
  }

  /**
   * Creates a new HTML element of the specified type.
   *
   * @param element The type of HTML element to create.
   * @param type The {@link Class} representing the element type.
   * @param <E> The type of HTML element.
   * @return The created HTML element.
   */
  default <E extends Element> E create(String element, Class<E> type) {
    return cast(document.createElement(element));
  }

  /**
   * Wraps an existing HTML element with a {@link DominoElement}.
   *
   * @param element The existing HTML element to wrap.
   * @param <E> The type of HTML element.
   * @return A {@link DominoElement} wrapping the existing HTML element.
   */
  default <E extends Element> DominoElement<E> elementOf(E element) {
    return new DominoElement<>(element);
  }

  /**
   * Wraps an existing {@link IsElement} with a {@link DominoElement}.
   *
   * @param element The {@link IsElement} to wrap.
   * @param <T> The type of the DOM element within the {@link IsElement}.
   * @param <E> The type of HTML element.
   * @return A {@link DominoElement} wrapping the DOM element within the {@link IsElement}.
   */
  default <T extends Element, E extends IsElement<T>> DominoElement<T> elementOf(E element) {
    return new DominoElement<>(element.element());
  }

  /**
   * Generates a unique identifier.
   *
   * @return A unique identifier.
   */
  default String getUniqueId() {
    return DominoId.unique();
  }

  /**
   * Generates a unique identifier with a specified prefix.
   *
   * @param prefix The prefix to use in the unique identifier.
   * @return A unique identifier with the specified prefix.
   */
  default String getUniqueId(String prefix) {
    return DominoId.unique(prefix);
  }

  /**
   * Creates a new {@link BodyElement}.
   *
   * @return A new {@link BodyElement}.
   */
  default BodyElement body() {
    return new BodyElement(dom.body());
  }

  /**
   * Creates a new {@link PictureElement}.
   *
   * @return A new {@link PictureElement}.
   */
  default PictureElement picture() {
    return new PictureElement(dom.picture());
  }

  /**
   * Creates a new {@link AddressElement}.
   *
   * @return A new {@link AddressElement}.
   */
  default AddressElement address() {
    return new AddressElement(dom.address());
  }

  /**
   * Creates a new {@link ArticleElement}.
   *
   * @return A new {@link ArticleElement}.
   */
  default ArticleElement article() {
    return new ArticleElement(dom.article());
  }

  /**
   * Creates a new {@link AsideElement}.
   *
   * @return A new {@link AsideElement}.
   */
  default AsideElement aside() {
    return new AsideElement(dom.aside());
  }

  /**
   * Creates a new {@link FooterElement}.
   *
   * @return A new {@link FooterElement}.
   */
  default FooterElement footer() {
    return new FooterElement(dom.footer());
  }

  /**
   * Creates a new {@link HeadingElement} with the specified heading level.
   *
   * @param n The heading level (e.g., 1 for &lt;h1&gt;, 2 for &lt;h2&gt;).
   * @return A new {@link HeadingElement}.
   */
  default HeadingElement h(int n) {
    return new HeadingElement(dom.h(n));
  }

  /**
   * Creates a new {@link HeaderElement}.
   *
   * @return A new {@link HeaderElement}.
   */
  default HeaderElement header() {
    return new HeaderElement(dom.header());
  }

  /**
   * Creates a new {@link HGroupElement}.
   *
   * @return A new {@link HGroupElement}.
   */
  default HGroupElement hgroup() {
    return new HGroupElement(dom.hgroup());
  }

  /**
   * Creates a new {@link NavElement}.
   *
   * @return A new {@link NavElement}.
   */
  default NavElement nav() {
    return new NavElement(dom.nav());
  }

  /**
   * Creates a new {@link SectionElement}.
   *
   * @return A new {@link SectionElement}.
   */
  default SectionElement section() {
    return new SectionElement(dom.section());
  }

  /**
   * Creates a new {@link BlockquoteElement}.
   *
   * @return A new {@link BlockquoteElement}.
   */
  default BlockquoteElement blockquote() {
    return new BlockquoteElement(dom.blockquote());
  }

  /**
   * Creates a new {@link DDElement}.
   *
   * @return A new {@link DDElement}.
   */
  default DDElement dd() {
    return new DDElement(dom.dd());
  }

  /**
   * Creates a new {@link DivElement}.
   *
   * @return A new {@link DivElement}.
   */
  default DivElement div() {
    return new DivElement(dom.div());
  }

  /**
   * Creates a new {@link DListElement}.
   *
   * @return A new {@link DListElement}.
   */
  default DListElement dl() {
    return new DListElement(dom.dl());
  }

  /**
   * Creates a new {@link DTElement}.
   *
   * @return A new {@link DTElement}.
   */
  default DTElement dt() {
    return new DTElement(dom.dt());
  }

  /**
   * Creates a new {@link FigCaptionElement}.
   *
   * @return A new {@link FigCaptionElement}.
   */
  default FigCaptionElement figcaption() {
    return new FigCaptionElement(dom.figcaption());
  }

  /**
   * Creates a new {@link FigureElement}.
   *
   * @return A new {@link FigureElement}.
   */
  default FigureElement figure() {
    return new FigureElement(dom.figure());
  }

  /**
   * Creates a new {@link HRElement}.
   *
   * @return A new {@link HRElement}.
   */
  default HRElement hr() {
    return new HRElement(dom.hr());
  }

  /**
   * Creates a new {@link LIElement}.
   *
   * @return A new {@link LIElement}.
   */
  default LIElement li() {
    return new LIElement(dom.li());
  }

  /**
   * Creates a new {@link MainElement}.
   *
   * @return A new {@link MainElement}.
   */
  @SuppressWarnings("all")
  default MainElement main() {
    return new MainElement(dom.main());
  }

  /**
   * Creates a new {@link OListElement}.
   *
   * @return A new {@link OListElement}.
   */
  default OListElement ol() {
    return new OListElement(dom.ol());
  }

  /**
   * Creates a new {@link ParagraphElement}.
   *
   * @return A new {@link ParagraphElement}.
   */
  default ParagraphElement p() {
    return new ParagraphElement(dom.p());
  }

  /**
   * Creates a new {@link ParagraphElement} with the specified text content.
   *
   * @param text The text content for the paragraph.
   * @return A new {@link ParagraphElement} with the specified text content.
   */
  default ParagraphElement p(String text) {
    return new ParagraphElement(dom.p()).setTextContent(text);
  }

  /**
   * Creates a new {@link PreElement}.
   *
   * @return A new {@link PreElement}.
   */
  default PreElement pre() {
    return new PreElement(dom.pre());
  }

  /**
   * Creates a new {@link UListElement}.
   *
   * @return A new {@link UListElement}.
   */
  default UListElement ul() {
    return new UListElement(dom.ul());
  }

  /**
   * Creates a new {@link AnchorElement} with default attributes.
   *
   * @return A new {@link AnchorElement} with default attributes.
   */
  default AnchorElement a() {
    return new AnchorElement(dom.a())
        .setAttribute("tabindex", "0")
        .setAttribute("aria-expanded", "true");
  }

  /**
   * Creates a new {@link AnchorElement} with the specified href attribute.
   *
   * @param href The value of the href attribute.
   * @return A new {@link AnchorElement} with the specified href attribute.
   */
  default AnchorElement a(String href) {
    return new AnchorElement(dom.a())
        .setAttribute("href", href)
        .setAttribute("aria-expanded", "true");
  }

  /**
   * Creates a new {@link AnchorElement} with the specified href and target attributes.
   *
   * @param href The value of the href attribute.
   * @param target The value of the target attribute.
   * @return A new {@link AnchorElement} with the specified href and target attributes.
   */
  default AnchorElement a(String href, String target) {
    return new AnchorElement(dom.a())
        .setAttribute("href", href)
        .setAttribute("target", target)
        .setAttribute("aria-expanded", "true");
  }

  /**
   * Creates a new {@link ABBRElement}.
   *
   * @return A new {@link ABBRElement}.
   */
  default ABBRElement abbr() {
    return new ABBRElement(dom.abbr());
  }

  /**
   * Creates a new {@link BElement}.
   *
   * @return A new {@link BElement}.
   */
  default BElement b() {
    return new BElement(dom.b());
  }

  /**
   * Creates a new {@link BRElement}.
   *
   * @return A new {@link BRElement}.
   */
  default BRElement br() {
    return new BRElement(dom.br());
  }

  /**
   * Creates a new {@link CiteElement}.
   *
   * @return A new {@link CiteElement}.
   */
  default CiteElement cite() {
    return new CiteElement(dom.cite());
  }

  /**
   * Creates a new {@link CodeElement}.
   *
   * @return A new {@link CodeElement}.
   */
  default CodeElement code() {
    return new CodeElement(dom.code());
  }

  /**
   * Creates a new {@link DFNElement}.
   *
   * @return A new {@link DFNElement}.
   */
  default DFNElement dfn() {
    return new DFNElement(dom.dfn());
  }

  /**
   * Creates a new {@link EMElement}.
   *
   * @return A new {@link EMElement}.
   */
  default EMElement em() {
    return new EMElement(dom.em());
  }

  /**
   * Creates a new {@link IElement}.
   *
   * @return A new {@link IElement}.
   */
  default IElement i() {
    return new IElement(dom.i());
  }

  /**
   * Creates a new {@link KBDElement}.
   *
   * @return A new {@link KBDElement}.
   */
  default KBDElement kbd() {
    return new KBDElement(dom.kbd());
  }

  /**
   * Creates a new {@link MarkElement}.
   *
   * @return A new {@link MarkElement}.
   */
  default MarkElement mark() {
    return new MarkElement(dom.mark());
  }

  /**
   * Creates a new {@link QuoteElement}.
   *
   * @return A new {@link QuoteElement}.
   */
  default QuoteElement q() {
    return new QuoteElement(dom.q());
  }

  /**
   * Creates a new {@link SmallElement}.
   *
   * @return A new {@link SmallElement}.
   */
  default SmallElement small() {
    return new SmallElement(dom.small());
  }

  /**
   * Creates a new {@link SpanElement}.
   *
   * @return A new {@link SpanElement}.
   */
  default SpanElement span() {
    return new SpanElement(dom.span());
  }

  /**
   * Creates a new {@link StrongElement}.
   *
   * @return A new {@link StrongElement}.
   */
  default StrongElement strong() {
    return new StrongElement(dom.strong());
  }

  /**
   * Creates a new {@link SubElement}.
   *
   * @return A new {@link SubElement}.
   */
  default SubElement sub() {
    return new SubElement(dom.sub());
  }

  /**
   * Creates a new {@link SupElement}.
   *
   * @return A new {@link SupElement}.
   */
  default SupElement sup() {
    return new SupElement(dom.sup());
  }

  /**
   * Creates a new {@link TimeElement}.
   *
   * @return A new {@link TimeElement}.
   */
  default TimeElement time() {
    return new TimeElement(dom.time());
  }

  /**
   * Creates a new {@link UElement}.
   *
   * @return A new {@link UElement}.
   */
  default UElement u() {
    return new UElement(dom.u());
  }

  /**
   * Creates a new {@link VarElement}.
   *
   * @return A new {@link VarElement}.
   */
  default VarElement var() {
    return new VarElement(dom.var());
  }

  /**
   * Creates a new {@link WBRElement}.
   *
   * @return A new {@link WBRElement}.
   */
  default WBRElement wbr() {
    return new WBRElement(dom.wbr());
  }

  /**
   * Creates a new {@link AreaElement}.
   *
   * @return A new {@link AreaElement}.
   */
  default AreaElement area() {
    return new AreaElement(dom.area());
  }

  /**
   * Creates a new {@link AudioElement}.
   *
   * @return A new {@link AudioElement}.
   */
  default AudioElement audio() {
    return new AudioElement(dom.audio());
  }

  /**
   * Creates a new {@link ImageElement}.
   *
   * @return A new {@link ImageElement}.
   */
  default ImageElement img() {
    return new ImageElement(dom.img());
  }

  /**
   * Creates a new {@link ImageElement} with the specified source (src) attribute.
   *
   * @param src The value of the src attribute.
   * @return A new {@link ImageElement} with the specified src attribute.
   */
  default ImageElement img(String src) {
    return new ImageElement(dom.img(src));
  }

  /**
   * Creates a new {@link MapElement}.
   *
   * @return A new {@link MapElement}.
   */
  default MapElement map() {
    return new MapElement(dom.map());
  }

  /**
   * Creates a new {@link TrackElement}.
   *
   * @return A new {@link TrackElement}.
   */
  default TrackElement track() {
    return new TrackElement(dom.track());
  }

  /**
   * Creates a new {@link VideoElement}.
   *
   * @return A new {@link VideoElement}.
   */
  default VideoElement video() {
    return new VideoElement(dom.video());
  }

  /**
   * Creates a new {@link CanvasElement}.
   *
   * @return A new {@link CanvasElement}.
   */
  default CanvasElement canvas() {
    return new CanvasElement(dom.canvas());
  }

  /**
   * Creates a new {@link EmbedElement}.
   *
   * @return A new {@link EmbedElement}.
   */
  default EmbedElement embed() {
    return new EmbedElement(dom.embed());
  }

  /**
   * Creates a new {@link IFrameElement}.
   *
   * @return A new {@link IFrameElement}.
   */
  default IFrameElement iframe() {
    return new IFrameElement(dom.iframe());
  }

  /**
   * Creates a new {@link IFrameElement} with the specified source (src) attribute.
   *
   * @param src The value of the src attribute.
   * @return A new {@link IFrameElement} with the specified src attribute.
   */
  default IFrameElement iframe(String src) {
    return iframe().setAttribute("src", src);
  }

  /**
   * Creates a new {@link ObjectElement}.
   *
   * @return A new {@link ObjectElement}.
   */
  default ObjectElement object() {
    return new ObjectElement(dom.object());
  }

  /**
   * Creates a new {@link ParamElement}.
   *
   * @return A new {@link ParamElement}.
   */
  default ParamElement param() {
    return new ParamElement(dom.param());
  }

  /**
   * Creates a new {@link SourceElement}.
   *
   * @return A new {@link SourceElement}.
   */
  default SourceElement source() {
    return new SourceElement(dom.source());
  }

  /**
   * Creates a new {@link NoScriptElement}.
   *
   * @return A new {@link NoScriptElement}.
   */
  default NoScriptElement noscript() {
    return new NoScriptElement(dom.noscript());
  }

  /**
   * Creates a new {@link ScriptElement}.
   *
   * @return A new {@link ScriptElement}.
   */
  default ScriptElement script() {
    return new ScriptElement(dom.script());
  }

  /**
   * Creates a new {@link DelElement}.
   *
   * @return A new {@link DelElement}.
   */
  default DelElement del() {
    return new DelElement(dom.del());
  }

  /**
   * Creates a new {@link InsElement}.
   *
   * @return A new {@link InsElement}.
   */
  default InsElement ins() {
    return new InsElement(dom.ins());
  }

  /**
   * Creates a new {@link TableCaptionElement}.
   *
   * @return A new {@link TableCaptionElement}.
   */
  default TableCaptionElement caption() {
    return new TableCaptionElement(dom.caption());
  }

  /**
   * Creates a new {@link ColElement}.
   *
   * @return A new {@link ColElement}.
   */
  default ColElement col() {
    return new ColElement(dom.col());
  }

  /**
   * Creates a new {@link ColGroupElement}.
   *
   * @return A new {@link ColGroupElement}.
   */
  default ColGroupElement colgroup() {
    return new ColGroupElement(dom.colgroup());
  }

  /**
   * Creates a new {@link TableElement}.
   *
   * @return A new {@link TableElement}.
   */
  default TableElement table() {
    return new TableElement(dom.table());
  }

  /**
   * Creates a new {@link TBodyElement}.
   *
   * @return A new {@link TBodyElement}.
   */
  default TBodyElement tbody() {
    return new TBodyElement(dom.tbody());
  }

  /**
   * Creates a new {@link TDElement}.
   *
   * @return A new {@link TDElement}.
   */
  default TDElement td() {
    return new TDElement(dom.td());
  }

  /**
   * Creates a new {@link TFootElement}.
   *
   * @return A new {@link TFootElement}.
   */
  default TFootElement tfoot() {
    return new TFootElement(dom.tfoot());
  }

  /**
   * Creates a new {@link THElement}.
   *
   * @return A new {@link THElement}.
   */
  default THElement th() {
    return new THElement(dom.th());
  }

  /**
   * Creates a new {@link THeadElement}.
   *
   * @return A new {@link THeadElement}.
   */
  default THeadElement thead() {
    return new THeadElement(dom.thead());
  }

  /**
   * Creates a new {@link TableRowElement}.
   *
   * @return A new {@link TableRowElement}.
   */
  default TableRowElement tr() {
    return new TableRowElement(dom.tr());
  }

  /**
   * Creates a new {@link ButtonElement}.
   *
   * @return A new {@link ButtonElement}.
   */
  default ButtonElement button() {
    return new ButtonElement(dom.button());
  }

  /**
   * Creates a new {@link DataListElement}.
   *
   * @return A new {@link DataListElement}.
   */
  default DataListElement datalist() {
    return new DataListElement(dom.datalist());
  }

  /**
   * Creates a new {@link FieldSetElement}.
   *
   * @return A new {@link FieldSetElement}.
   */
  default FieldSetElement fieldset() {
    return new FieldSetElement(dom.fieldset());
  }

  /**
   * Creates a new {@link FormElement}.
   *
   * @return A new {@link FormElement}.
   */
  default FormElement form() {
    return new FormElement(dom.form());
  }

  /**
   * Creates a new {@link InputElement} with the specified input type.
   *
   * @param type The type attribute value for the input.
   * @return A new {@link InputElement} with the specified type attribute.
   */
  default InputElement input(InputType type) {
    return input(type.name());
  }

  /**
   * Creates a new {@link InputElement} with the specified input type.
   *
   * @param type The type attribute value for the input.
   * @return A new {@link InputElement} with the specified type attribute.
   */
  default InputElement input(String type) {
    return new InputElement(dom.input(type));
  }

  /**
   * Creates a new {@link LabelElement}.
   *
   * @return A new {@link LabelElement}.
   */
  default LabelElement label() {
    return new LabelElement(dom.label());
  }

  /**
   * Creates a new {@link LabelElement} with the specified text content.
   *
   * @param text The text content of the label.
   * @return A new {@link LabelElement} with the specified text content.
   */
  default LabelElement label(String text) {
    return label().textContent(text);
  }

  /**
   * Creates a new {@link LegendElement}.
   *
   * @return A new {@link LegendElement}.
   */
  default LegendElement legend() {
    return new LegendElement(dom.legend());
  }

  /**
   * Creates a new {@link MeterElement}.
   *
   * @return A new {@link MeterElement}.
   */
  default MeterElement meter() {
    return new MeterElement(dom.meter());
  }

  /**
   * Creates a new {@link OptGroupElement}.
   *
   * @return A new {@link OptGroupElement}.
   */
  default OptGroupElement optgroup() {
    return new OptGroupElement(dom.optgroup());
  }

  /**
   * Creates a new {@link OptionElement}.
   *
   * @return A new {@link OptionElement}.
   */
  default OptionElement option() {
    return new OptionElement(dom.option());
  }

  /**
   * Creates a new {@link OutputElement}.
   *
   * @return A new {@link OutputElement}.
   */
  default OutputElement output() {
    return new OutputElement(dom.output());
  }

  /**
   * Creates a new {@link ProgressElement}.
   *
   * @return A new {@link ProgressElement}.
   */
  default ProgressElement progress() {
    return new ProgressElement(dom.progress());
  }

  /**
   * Creates a new {@link SelectElement}.
   *
   * @return A new {@link SelectElement}.
   */
  default SelectElement select_() {
    return new SelectElement(dom.select_());
  }

  /**
   * Creates a new {@link TextAreaElement}.
   *
   * @return A new {@link TextAreaElement}.
   */
  default TextAreaElement textarea() {
    return new TextAreaElement(dom.textarea());
  }

  /**
   * Creates a new {@link SvgElement}.
   *
   * @return A new {@link SvgElement}.
   */
  default SvgElement svg() {
    return new SvgElement(dom.svg());
  }
  /**
   * Creates a new {@link SvgElement}.
   *
   * @param <T> The actual type of the svg element being created
   * @param tag The string tag name for the svg element.
   * @param type The concrete type for the svg element
   * @return A new {@link SvgElement}.
   */
  default <T extends SVGElement> T svg(String tag, Class<T> type) {
    return dom.svg(tag, type);
  }

  /**
   * Creates a new {@link CircleElement} with the specified attributes.
   *
   * @param cx The value of the cx attribute.
   * @param cy The value of the cy attribute.
   * @param r The value of the r attribute.
   * @return A new {@link CircleElement} with the specified attributes.
   */
  default CircleElement circle(double cx, double cy, double r) {
    CircleElement circle = new CircleElement(dom.circle());
    circle.setAttribute("cx", cx);
    circle.setAttribute("cy", cy);
    circle.setAttribute("r", r);
    return circle;
  }

  /**
   * Creates a new {@link LineElement} with the specified attributes.
   *
   * @param x1 The value of the x1 attribute.
   * @param y1 The value of the y1 attribute.
   * @param x2 The value of the x2 attribute.
   * @param y2 The value of the y2 attribute.
   * @return A new {@link LineElement} with the specified attributes.
   */
  default LineElement line(double x1, double y1, double x2, double y2) {
    LineElement circle = new LineElement(dom.line());
    circle.setAttribute("x1", x1);
    circle.setAttribute("y1", y1);
    circle.setAttribute("x2", x2);
    circle.setAttribute("y2", y2);
    return circle;
  }

  /**
   * Creates a new empty {@link Text} node.
   *
   * @return A new empty {@link Text} node.
   */
  default Text text() {
    return DomGlobal.document.createTextNode("");
  }

  /**
   * Creates a new {@link Text} node with the specified content.
   *
   * @param content The content of the text node.
   * @return A new {@link Text} node with the specified content.
   */
  default Text text(String content) {
    if (isNull(content) || content.isEmpty()) {
      return text();
    }
    return DomGlobal.document.createTextNode(content);
  }
}
