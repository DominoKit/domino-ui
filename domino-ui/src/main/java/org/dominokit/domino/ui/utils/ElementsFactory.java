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
import static jsinterop.base.Js.cast;
import static org.dominokit.domino.ui.utils.DomElements.dom;

import elemental2.dom.DomGlobal;
import elemental2.dom.Element;
import elemental2.dom.HTMLBodyElement;
import elemental2.dom.HTMLDivElement;
import elemental2.dom.HTMLElement;
import elemental2.dom.Text;
import org.dominokit.domino.ui.IsElement;
import org.dominokit.domino.ui.elements.ABBRElement;
import org.dominokit.domino.ui.elements.AddressElement;
import org.dominokit.domino.ui.elements.AnchorElement;
import org.dominokit.domino.ui.elements.AreaElement;
import org.dominokit.domino.ui.elements.ArticleElement;
import org.dominokit.domino.ui.elements.AsideElement;
import org.dominokit.domino.ui.elements.AudioElement;
import org.dominokit.domino.ui.elements.BElement;
import org.dominokit.domino.ui.elements.BRElement;
import org.dominokit.domino.ui.elements.BlockquoteElement;
import org.dominokit.domino.ui.elements.BodyElement;
import org.dominokit.domino.ui.elements.ButtonElement;
import org.dominokit.domino.ui.elements.CanvasElement;
import org.dominokit.domino.ui.elements.CircleElement;
import org.dominokit.domino.ui.elements.CiteElement;
import org.dominokit.domino.ui.elements.CodeElement;
import org.dominokit.domino.ui.elements.ColElement;
import org.dominokit.domino.ui.elements.ColGroupElement;
import org.dominokit.domino.ui.elements.DDElement;
import org.dominokit.domino.ui.elements.DFNElement;
import org.dominokit.domino.ui.elements.DListElement;
import org.dominokit.domino.ui.elements.DTElement;
import org.dominokit.domino.ui.elements.DataListElement;
import org.dominokit.domino.ui.elements.DelElement;
import org.dominokit.domino.ui.elements.DivElement;
import org.dominokit.domino.ui.elements.EMElement;
import org.dominokit.domino.ui.elements.EmbedElement;
import org.dominokit.domino.ui.elements.FieldSetElement;
import org.dominokit.domino.ui.elements.FigCaptionElement;
import org.dominokit.domino.ui.elements.FigureElement;
import org.dominokit.domino.ui.elements.FooterElement;
import org.dominokit.domino.ui.elements.FormElement;
import org.dominokit.domino.ui.elements.HGroupElement;
import org.dominokit.domino.ui.elements.HRElement;
import org.dominokit.domino.ui.elements.HeaderElement;
import org.dominokit.domino.ui.elements.HeadingElement;
import org.dominokit.domino.ui.elements.IElement;
import org.dominokit.domino.ui.elements.IFrameElement;
import org.dominokit.domino.ui.elements.ImageElement;
import org.dominokit.domino.ui.elements.InputElement;
import org.dominokit.domino.ui.elements.InsElement;
import org.dominokit.domino.ui.elements.KBDElement;
import org.dominokit.domino.ui.elements.LIElement;
import org.dominokit.domino.ui.elements.LabelElement;
import org.dominokit.domino.ui.elements.LegendElement;
import org.dominokit.domino.ui.elements.LineElement;
import org.dominokit.domino.ui.elements.MainElement;
import org.dominokit.domino.ui.elements.MapElement;
import org.dominokit.domino.ui.elements.MarkElement;
import org.dominokit.domino.ui.elements.MeterElement;
import org.dominokit.domino.ui.elements.NavElement;
import org.dominokit.domino.ui.elements.NoScriptElement;
import org.dominokit.domino.ui.elements.OListElement;
import org.dominokit.domino.ui.elements.ObjectElement;
import org.dominokit.domino.ui.elements.OptGroupElement;
import org.dominokit.domino.ui.elements.OptionElement;
import org.dominokit.domino.ui.elements.OutputElement;
import org.dominokit.domino.ui.elements.ParagraphElement;
import org.dominokit.domino.ui.elements.ParamElement;
import org.dominokit.domino.ui.elements.PictureElement;
import org.dominokit.domino.ui.elements.PreElement;
import org.dominokit.domino.ui.elements.ProgressElement;
import org.dominokit.domino.ui.elements.QuoteElement;
import org.dominokit.domino.ui.elements.ScriptElement;
import org.dominokit.domino.ui.elements.SectionElement;
import org.dominokit.domino.ui.elements.SelectElement;
import org.dominokit.domino.ui.elements.SmallElement;
import org.dominokit.domino.ui.elements.SourceElement;
import org.dominokit.domino.ui.elements.SpanElement;
import org.dominokit.domino.ui.elements.StrongElement;
import org.dominokit.domino.ui.elements.SubElement;
import org.dominokit.domino.ui.elements.SupElement;
import org.dominokit.domino.ui.elements.SvgElement;
import org.dominokit.domino.ui.elements.TBodyElement;
import org.dominokit.domino.ui.elements.TDElement;
import org.dominokit.domino.ui.elements.TFootElement;
import org.dominokit.domino.ui.elements.THElement;
import org.dominokit.domino.ui.elements.THeadElement;
import org.dominokit.domino.ui.elements.TableCaptionElement;
import org.dominokit.domino.ui.elements.TableElement;
import org.dominokit.domino.ui.elements.TableRowElement;
import org.dominokit.domino.ui.elements.TextAreaElement;
import org.dominokit.domino.ui.elements.TimeElement;
import org.dominokit.domino.ui.elements.TrackElement;
import org.dominokit.domino.ui.elements.UElement;
import org.dominokit.domino.ui.elements.UListElement;
import org.dominokit.domino.ui.elements.VarElement;
import org.dominokit.domino.ui.elements.VideoElement;
import org.dominokit.domino.ui.elements.WBRElement;

public interface ElementsFactory {

  ElementsFactory elements = new ElementsFactory() {};

  default <E extends Element> E create(String element, Class<E> type) {
    return cast(document.createElement(element));
  }

  /**
   * @param element the {@link HTMLElement} E to wrap as a DominoElement
   * @param <E> extends from {@link Element}
   * @return the {@link DominoElement} wrapping the provided element
   */
  default <E extends Element> DominoElement<E> elementOf(E element) {
    return new DominoElement<>(element);
  }

  /**
   * @param element the {@link IsElement} E to wrap as a DominoElement
   * @param <E> extends from {@link Element}
   * @return the {@link DominoElement} wrapping the provided element
   */
  default <T extends Element, E extends IsElement<T>> DominoElement<T> elementOf(E element) {
    return new DominoElement<>(element.element());
  }

  default String getUniqueId() {
    return DominoId.unique();
  }

  default String getUniqueId(String prefix) {
    return DominoId.unique(prefix);
  }

  /** @return a {@link DominoElement} wrapping the document {@link HTMLBodyElement} */
  default BodyElement body() {
    return new BodyElement(dom.body());
  }

  /** @return a new {@link HTMLDivElement} wrapped as a {@link DominoElement} */
  default PictureElement picture() {
    return new PictureElement(dom.picture());
  }

  // ------------------ content sectioning

  default AddressElement address() {
    return new AddressElement(dom.address());
  }

  default ArticleElement article() {
    return new ArticleElement(dom.article());
  }

  default AsideElement aside() {
    return new AsideElement(dom.aside());
  }

  default FooterElement footer() {
    return new FooterElement(dom.footer());
  }

  default HeadingElement h(int n) {
    return new HeadingElement(dom.h(n));
  }

  default HeaderElement header() {
    return new HeaderElement(dom.header());
  }

  default HGroupElement hgroup() {
    return new HGroupElement(dom.hgroup());
  }

  default NavElement nav() {
    return new NavElement(dom.nav());
  }

  default SectionElement section() {
    return new SectionElement(dom.section());
  }

  // ------------------------------------------------------ text content

  default BlockquoteElement blockquote() {
    return new BlockquoteElement(dom.blockquote());
  }

  default DDElement dd() {
    return new DDElement(dom.dd());
  }

  default DivElement div() {
    return new DivElement(dom.div());
  }

  default DListElement dl() {
    return new DListElement(dom.dl());
  }

  default DTElement dt() {
    return new DTElement(dom.dt());
  }

  default FigCaptionElement figcaption() {
    return new FigCaptionElement(dom.figcaption());
  }

  default FigureElement figure() {
    return new FigureElement(dom.figure());
  }

  default HRElement hr() {
    return new HRElement(dom.hr());
  }

  default LIElement li() {
    return new LIElement(dom.li());
  }

  @SuppressWarnings("all")
  default MainElement main() {
    return new MainElement(dom.main());
  }

  default OListElement ol() {
    return new OListElement(dom.ol());
  }

  default ParagraphElement p() {
    return new ParagraphElement(dom.p());
  }

  default ParagraphElement p(String text) {
    return new ParagraphElement(dom.p()).setTextContent(text);
  }

  default PreElement pre() {
    return new PreElement(dom.pre());
  }

  default UListElement ul() {
    return new UListElement(dom.ul());
  }

  // ------------------------------------------------------ inline text semantics

  default AnchorElement a() {
    return new AnchorElement(dom.a())
        .setAttribute("tabindex", "0")
        .setAttribute("href", "#")
        .setAttribute("aria-expanded", "true");
  }

  default AnchorElement a(String href) {
    return new AnchorElement(dom.a())
        .setAttribute("href", href)
        .setAttribute("aria-expanded", "true");
  }

  default AnchorElement a(String href, String target) {
    return new AnchorElement(dom.a())
        .setAttribute("href", href)
        .setAttribute("target", target)
        .setAttribute("aria-expanded", "true");
  }

  default ABBRElement abbr() {
    return new ABBRElement(dom.abbr());
  }

  default BElement b() {
    return new BElement(dom.b());
  }

  default BRElement br() {
    return new BRElement(dom.br());
  }

  default CiteElement cite() {
    return new CiteElement(dom.cite());
  }

  default CodeElement code() {
    return new CodeElement(dom.code());
  }

  default DFNElement dfn() {
    return new DFNElement(dom.dfn());
  }

  default EMElement em() {
    return new EMElement(dom.em());
  }

  default IElement i() {
    return new IElement(dom.i());
  }

  default KBDElement kbd() {
    return new KBDElement(dom.kbd());
  }

  default MarkElement mark() {
    return new MarkElement(dom.mark());
  }

  default QuoteElement q() {
    return new QuoteElement(dom.q());
  }

  default SmallElement small() {
    return new SmallElement(dom.small());
  }

  default SpanElement span() {
    return new SpanElement(dom.span());
  }

  default StrongElement strong() {
    return new StrongElement(dom.strong());
  }

  default SubElement sub() {
    return new SubElement(dom.sub());
  }

  default SupElement sup() {
    return new SupElement(dom.sup());
  }

  default TimeElement time() {
    return new TimeElement(dom.time());
  }

  default UElement u() {
    return new UElement(dom.u());
  }

  default VarElement var() {
    return new VarElement(dom.var());
  }

  default WBRElement wbr() {
    return new WBRElement(dom.wbr());
  }

  // ------------------------------------------------------ image and multimedia

  default AreaElement area() {
    return new AreaElement(dom.area());
  }

  default AudioElement audio() {
    return new AudioElement(dom.audio());
  }

  default ImageElement img() {
    return new ImageElement(dom.img());
  }

  default ImageElement img(String src) {
    return new ImageElement(dom.img(src));
  }

  default MapElement map() {
    return new MapElement(dom.map());
  }

  default TrackElement track() {
    return new TrackElement(dom.track());
  }

  default VideoElement video() {
    return new VideoElement(dom.video());
  }

  // ------------------------------------------------------ embedded content

  default CanvasElement canvas() {
    return new CanvasElement(dom.canvas());
  }

  default EmbedElement embed() {
    return new EmbedElement(dom.embed());
  }

  default IFrameElement iframe() {
    return new IFrameElement(dom.iframe());
  }

  default IFrameElement iframe(String src) {
    return iframe().setAttribute("src", src);
  }

  default ObjectElement object() {
    return new ObjectElement(dom.object());
  }

  default ParamElement param() {
    return new ParamElement(dom.param());
  }

  default SourceElement source() {
    return new SourceElement(dom.source());
  }

  // ------------------------------------------------------ scripting

  default NoScriptElement noscript() {
    return new NoScriptElement(dom.noscript());
  }

  default ScriptElement script() {
    return new ScriptElement(dom.script());
  }

  // ------------------------------------------------------ demarcating edits

  default DelElement del() {
    return new DelElement(dom.del());
  }

  default InsElement ins() {
    return new InsElement(dom.ins());
  }

  // ------------------------------------------------------ table content

  default TableCaptionElement caption() {
    return new TableCaptionElement(dom.caption());
  }

  default ColElement col() {
    return new ColElement(dom.col());
  }

  default ColGroupElement colgroup() {
    return new ColGroupElement(dom.colgroup());
  }

  default TableElement table() {
    return new TableElement(dom.table());
  }

  default TBodyElement tbody() {
    return new TBodyElement(dom.tbody());
  }

  default TDElement td() {
    return new TDElement(dom.td());
  }

  default TFootElement tfoot() {
    return new TFootElement(dom.tfoot());
  }

  default THElement th() {
    return new THElement(dom.th());
  }

  default THeadElement thead() {
    return new THeadElement(dom.thead());
  }

  default TableRowElement tr() {
    return new TableRowElement(dom.tr());
  }

  // ------------------------------------------------------ forms

  default ButtonElement button() {
    return new ButtonElement(dom.button());
  }

  default DataListElement datalist() {
    return new DataListElement(dom.datalist());
  }

  default FieldSetElement fieldset() {
    return new FieldSetElement(dom.fieldset());
  }

  default FormElement form() {
    return new FormElement(dom.form());
  }

  default InputElement input(InputType type) {
    return input(type.name());
  }

  default InputElement input(String type) {
    return new InputElement(dom.input(type));
  }

  default LabelElement label() {
    return new LabelElement(dom.label());
  }

  default LabelElement label(String text) {
    return label().textContent(text);
  }

  default LegendElement legend() {
    return new LegendElement(dom.legend());
  }

  default MeterElement meter() {
    return new MeterElement(dom.meter());
  }

  default OptGroupElement optgroup() {
    return new OptGroupElement(dom.optgroup());
  }

  default OptionElement option() {
    return new OptionElement(dom.option());
  }

  default OutputElement output() {
    return new OutputElement(dom.output());
  }

  default ProgressElement progress() {
    return new ProgressElement(dom.progress());
  }

  default SelectElement select_() {
    return new SelectElement(dom.select_());
  }

  default TextAreaElement textarea() {
    return new TextAreaElement(dom.textarea());
  }

  default SvgElement svg() {
    return new SvgElement(dom.svg());
  }

  default CircleElement circle(double cx, double cy, double r) {
    CircleElement circle = new CircleElement(dom.circle());
    circle.setAttribute("cx", cx);
    circle.setAttribute("cy", cy);
    circle.setAttribute("r", r);
    return circle;
  }

  default LineElement line(double x1, double y1, double x2, double y2) {
    LineElement circle = new LineElement(dom.line());
    circle.setAttribute("x1", x1);
    circle.setAttribute("y1", y1);
    circle.setAttribute("x2", x2);
    circle.setAttribute("y2", y2);
    return circle;
  }

  /** @return new empty {@link Text} node */
  default Text text() {
    return DomGlobal.document.createTextNode("");
  }

  /**
   * @param content String content of the node
   * @return new {@link Text} node with the provided text content
   */
  default Text text(String content) {
    if (isNull(content) || content.isEmpty()) {
      return text();
    }
    return DomGlobal.document.createTextNode(content);
  }
}
