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

import elemental2.dom.DomGlobal;
import elemental2.dom.Element;
import elemental2.dom.Text;
import java.util.Optional;
import org.dominokit.domino.ui.IsElement;
import org.dominokit.domino.ui.elements.*;

/** ElementsFactory interface. */
public interface ElementsFactoryDelegate {

  default Optional<DominoElement<Element>> byId(String id) {
    Element elementById = document.getElementById(id);
    if (nonNull(elementById)) {
      return Optional.of(elementOf(elementById));
    }
    return Optional.empty();
  }

  /**
   * create.
   *
   * @param element a {@link String} object
   * @param type a {@link Class} object
   * @param <E> a E class
   * @return a E object
   */
  default <E extends Element> E create(String element, Class<E> type) {
    return cast(document.createElement(element));
  }

  /**
   * elementOf.
   *
   * @param element the {@link elemental2.dom.HTMLElement} E to wrap as a DominoElement
   * @param <E> extends from {@link Element}
   * @return the {@link DominoElement} wrapping the provided element
   */
  default <E extends Element> DominoElement<E> elementOf(E element) {
    return new DominoElement<>(element);
  }

  /**
   * elementOf.
   *
   * @param element the {@link IsElement} E to wrap as a DominoElement
   * @param <E> extends from {@link Element}
   * @return the {@link DominoElement} wrapping the provided element
   * @param <T> a T class
   */
  default <T extends Element, E extends IsElement<T>> DominoElement<T> elementOf(E element) {
    return new DominoElement<>(element.element());
  }

  /**
   * getUniqueId.
   *
   * @return a {@link String} object
   */
  default String getUniqueId() {
    return DominoId.unique();
  }

  /**
   * getUniqueId.
   *
   * @param prefix a {@link String} object
   * @return a {@link String} object
   */
  default String getUniqueId(String prefix) {
    return DominoId.unique(prefix);
  }

  /** @return a {@link DominoElement} wrapping the document {@link HTMLBodyElement} */
  /**
   * body.
   *
   * @return a {@link BodyElement} object
   */
  default BodyElement body() {
    return new BodyElement(dom.body());
  }

  /** @return a new {@link HTMLDivElement} wrapped as a {@link DominoElement} */
  /**
   * picture.
   *
   * @return a {@link PictureElement} object
   */
  default PictureElement picture() {
    return new PictureElement(dom.picture());
  }

  /**
   * address.
   *
   * @return a {@link AddressElement} object
   */
  default AddressElement address() {
    return new AddressElement(dom.address());
  }

  /**
   * article.
   *
   * @return a {@link ArticleElement} object
   */
  default ArticleElement article() {
    return new ArticleElement(dom.article());
  }

  /**
   * aside.
   *
   * @return a {@link AsideElement} object
   */
  default AsideElement aside() {
    return new AsideElement(dom.aside());
  }

  /**
   * footer.
   *
   * @return a {@link FooterElement} object
   */
  default FooterElement footer() {
    return new FooterElement(dom.footer());
  }

  /**
   * h.
   *
   * @param n a int
   * @return a {@link HeadingElement} object
   */
  default HeadingElement h(int n) {
    return new HeadingElement(dom.h(n));
  }

  /**
   * header.
   *
   * @return a {@link HeaderElement} object
   */
  default HeaderElement header() {
    return new HeaderElement(dom.header());
  }

  /**
   * hgroup.
   *
   * @return a {@link HGroupElement} object
   */
  default HGroupElement hgroup() {
    return new HGroupElement(dom.hgroup());
  }

  /**
   * nav.
   *
   * @return a {@link NavElement} object
   */
  default NavElement nav() {
    return new NavElement(dom.nav());
  }

  /**
   * section.
   *
   * @return a {@link SectionElement} object
   */
  default SectionElement section() {
    return new SectionElement(dom.section());
  }

  /**
   * blockquote.
   *
   * @return a {@link BlockquoteElement} object
   */
  default BlockquoteElement blockquote() {
    return new BlockquoteElement(dom.blockquote());
  }

  /**
   * dd.
   *
   * @return a {@link DDElement} object
   */
  default DDElement dd() {
    return new DDElement(dom.dd());
  }

  /**
   * div.
   *
   * @return a {@link DivElement} object
   */
  default DivElement div() {
    return new DivElement(dom.div());
  }

  /**
   * dl.
   *
   * @return a {@link DListElement} object
   */
  default DListElement dl() {
    return new DListElement(dom.dl());
  }

  /**
   * dt.
   *
   * @return a {@link DTElement} object
   */
  default DTElement dt() {
    return new DTElement(dom.dt());
  }

  /**
   * figcaption.
   *
   * @return a {@link FigCaptionElement} object
   */
  default FigCaptionElement figcaption() {
    return new FigCaptionElement(dom.figcaption());
  }

  /**
   * figure.
   *
   * @return a {@link FigureElement} object
   */
  default FigureElement figure() {
    return new FigureElement(dom.figure());
  }

  /**
   * hr.
   *
   * @return a {@link HRElement} object
   */
  default HRElement hr() {
    return new HRElement(dom.hr());
  }

  /**
   * li.
   *
   * @return a {@link LIElement} object
   */
  default LIElement li() {
    return new LIElement(dom.li());
  }

  /**
   * main.
   *
   * @return a {@link MainElement} object
   */
  @SuppressWarnings("all")
  default MainElement main() {
    return new MainElement(dom.main());
  }

  /**
   * ol.
   *
   * @return a {@link OListElement} object
   */
  default OListElement ol() {
    return new OListElement(dom.ol());
  }

  /**
   * p.
   *
   * @return a {@link ParagraphElement} object
   */
  default ParagraphElement p() {
    return new ParagraphElement(dom.p());
  }

  /**
   * p.
   *
   * @param text a {@link String} object
   * @return a {@link ParagraphElement} object
   */
  default ParagraphElement p(String text) {
    return new ParagraphElement(dom.p()).setTextContent(text);
  }

  /**
   * pre.
   *
   * @return a {@link PreElement} object
   */
  default PreElement pre() {
    return new PreElement(dom.pre());
  }

  /**
   * ul.
   *
   * @return a {@link UListElement} object
   */
  default UListElement ul() {
    return new UListElement(dom.ul());
  }

  /**
   * a.
   *
   * @return a {@link AnchorElement} object
   */
  default AnchorElement a() {
    return new AnchorElement(dom.a())
        .setAttribute("tabindex", "0")
        .setAttribute("href", "#")
        .setAttribute("aria-expanded", "true");
  }

  /**
   * a.
   *
   * @param href a {@link String} object
   * @return a {@link AnchorElement} object
   */
  default AnchorElement a(String href) {
    return new AnchorElement(dom.a())
        .setAttribute("href", href)
        .setAttribute("aria-expanded", "true");
  }

  /**
   * a.
   *
   * @param href a {@link String} object
   * @param target a {@link String} object
   * @return a {@link AnchorElement} object
   */
  default AnchorElement a(String href, String target) {
    return new AnchorElement(dom.a())
        .setAttribute("href", href)
        .setAttribute("target", target)
        .setAttribute("aria-expanded", "true");
  }

  /**
   * abbr.
   *
   * @return a {@link ABBRElement} object
   */
  default ABBRElement abbr() {
    return new ABBRElement(dom.abbr());
  }

  /**
   * b.
   *
   * @return a {@link BElement} object
   */
  default BElement b() {
    return new BElement(dom.b());
  }

  /**
   * br.
   *
   * @return a {@link BRElement} object
   */
  default BRElement br() {
    return new BRElement(dom.br());
  }

  /**
   * cite.
   *
   * @return a {@link CiteElement} object
   */
  default CiteElement cite() {
    return new CiteElement(dom.cite());
  }

  /**
   * code.
   *
   * @return a {@link CodeElement} object
   */
  default CodeElement code() {
    return new CodeElement(dom.code());
  }

  /**
   * dfn.
   *
   * @return a {@link DFNElement} object
   */
  default DFNElement dfn() {
    return new DFNElement(dom.dfn());
  }

  /**
   * em.
   *
   * @return a {@link EMElement} object
   */
  default EMElement em() {
    return new EMElement(dom.em());
  }

  /**
   * i.
   *
   * @return a {@link IElement} object
   */
  default IElement i() {
    return new IElement(dom.i());
  }

  /**
   * kbd.
   *
   * @return a {@link KBDElement} object
   */
  default KBDElement kbd() {
    return new KBDElement(dom.kbd());
  }

  /**
   * mark.
   *
   * @return a {@link MarkElement} object
   */
  default MarkElement mark() {
    return new MarkElement(dom.mark());
  }

  /**
   * q.
   *
   * @return a {@link QuoteElement} object
   */
  default QuoteElement q() {
    return new QuoteElement(dom.q());
  }

  /**
   * small.
   *
   * @return a {@link SmallElement} object
   */
  default SmallElement small() {
    return new SmallElement(dom.small());
  }

  /**
   * span.
   *
   * @return a {@link SpanElement} object
   */
  default SpanElement span() {
    return new SpanElement(dom.span());
  }

  /**
   * strong.
   *
   * @return a {@link StrongElement} object
   */
  default StrongElement strong() {
    return new StrongElement(dom.strong());
  }

  /**
   * sub.
   *
   * @return a {@link SubElement} object
   */
  default SubElement sub() {
    return new SubElement(dom.sub());
  }

  /**
   * sup.
   *
   * @return a {@link SupElement} object
   */
  default SupElement sup() {
    return new SupElement(dom.sup());
  }

  /**
   * time.
   *
   * @return a {@link TimeElement} object
   */
  default TimeElement time() {
    return new TimeElement(dom.time());
  }

  /**
   * u.
   *
   * @return a {@link UElement} object
   */
  default UElement u() {
    return new UElement(dom.u());
  }

  /**
   * var.
   *
   * @return a {@link VarElement} object
   */
  default VarElement var() {
    return new VarElement(dom.var());
  }

  /**
   * wbr.
   *
   * @return a {@link WBRElement} object
   */
  default WBRElement wbr() {
    return new WBRElement(dom.wbr());
  }

  /**
   * area.
   *
   * @return a {@link AreaElement} object
   */
  default AreaElement area() {
    return new AreaElement(dom.area());
  }

  /**
   * audio.
   *
   * @return a {@link AudioElement} object
   */
  default AudioElement audio() {
    return new AudioElement(dom.audio());
  }

  /**
   * img.
   *
   * @return a {@link ImageElement} object
   */
  default ImageElement img() {
    return new ImageElement(dom.img());
  }

  /**
   * img.
   *
   * @param src a {@link String} object
   * @return a {@link ImageElement} object
   */
  default ImageElement img(String src) {
    return new ImageElement(dom.img(src));
  }

  /**
   * map.
   *
   * @return a {@link MapElement} object
   */
  default MapElement map() {
    return new MapElement(dom.map());
  }

  /**
   * track.
   *
   * @return a {@link TrackElement} object
   */
  default TrackElement track() {
    return new TrackElement(dom.track());
  }

  /**
   * video.
   *
   * @return a {@link VideoElement} object
   */
  default VideoElement video() {
    return new VideoElement(dom.video());
  }

  /**
   * canvas.
   *
   * @return a {@link CanvasElement} object
   */
  default CanvasElement canvas() {
    return new CanvasElement(dom.canvas());
  }

  /**
   * embed.
   *
   * @return a {@link EmbedElement} object
   */
  default EmbedElement embed() {
    return new EmbedElement(dom.embed());
  }

  /**
   * iframe.
   *
   * @return a {@link IFrameElement} object
   */
  default IFrameElement iframe() {
    return new IFrameElement(dom.iframe());
  }

  /**
   * iframe.
   *
   * @param src a {@link String} object
   * @return a {@link IFrameElement} object
   */
  default IFrameElement iframe(String src) {
    return iframe().setAttribute("src", src);
  }

  /**
   * object.
   *
   * @return a {@link ObjectElement} object
   */
  default ObjectElement object() {
    return new ObjectElement(dom.object());
  }

  /**
   * param.
   *
   * @return a {@link ParamElement} object
   */
  default ParamElement param() {
    return new ParamElement(dom.param());
  }

  /**
   * source.
   *
   * @return a {@link SourceElement} object
   */
  default SourceElement source() {
    return new SourceElement(dom.source());
  }

  /**
   * noscript.
   *
   * @return a {@link NoScriptElement} object
   */
  default NoScriptElement noscript() {
    return new NoScriptElement(dom.noscript());
  }

  /**
   * script.
   *
   * @return a {@link ScriptElement} object
   */
  default ScriptElement script() {
    return new ScriptElement(dom.script());
  }

  /**
   * del.
   *
   * @return a {@link DelElement} object
   */
  default DelElement del() {
    return new DelElement(dom.del());
  }

  /**
   * ins.
   *
   * @return a {@link InsElement} object
   */
  default InsElement ins() {
    return new InsElement(dom.ins());
  }

  /**
   * caption.
   *
   * @return a {@link TableCaptionElement} object
   */
  default TableCaptionElement caption() {
    return new TableCaptionElement(dom.caption());
  }

  /**
   * col.
   *
   * @return a {@link ColElement} object
   */
  default ColElement col() {
    return new ColElement(dom.col());
  }

  /**
   * colgroup.
   *
   * @return a {@link ColGroupElement} object
   */
  default ColGroupElement colgroup() {
    return new ColGroupElement(dom.colgroup());
  }

  /**
   * table.
   *
   * @return a {@link TableElement} object
   */
  default TableElement table() {
    return new TableElement(dom.table());
  }

  /**
   * tbody.
   *
   * @return a {@link TBodyElement} object
   */
  default TBodyElement tbody() {
    return new TBodyElement(dom.tbody());
  }

  /**
   * td.
   *
   * @return a {@link TDElement} object
   */
  default TDElement td() {
    return new TDElement(dom.td());
  }

  /**
   * tfoot.
   *
   * @return a {@link TFootElement} object
   */
  default TFootElement tfoot() {
    return new TFootElement(dom.tfoot());
  }

  /**
   * th.
   *
   * @return a {@link THElement} object
   */
  default THElement th() {
    return new THElement(dom.th());
  }

  /**
   * thead.
   *
   * @return a {@link THeadElement} object
   */
  default THeadElement thead() {
    return new THeadElement(dom.thead());
  }

  /**
   * tr.
   *
   * @return a {@link TableRowElement} object
   */
  default TableRowElement tr() {
    return new TableRowElement(dom.tr());
  }

  /**
   * button.
   *
   * @return a {@link ButtonElement} object
   */
  default ButtonElement button() {
    return new ButtonElement(dom.button());
  }

  /**
   * datalist.
   *
   * @return a {@link DataListElement} object
   */
  default DataListElement datalist() {
    return new DataListElement(dom.datalist());
  }

  /**
   * fieldset.
   *
   * @return a {@link FieldSetElement} object
   */
  default FieldSetElement fieldset() {
    return new FieldSetElement(dom.fieldset());
  }

  /**
   * form.
   *
   * @return a {@link FormElement} object
   */
  default FormElement form() {
    return new FormElement(dom.form());
  }

  /**
   * input.
   *
   * @param type a {@link InputType} object
   * @return a {@link InputElement} object
   */
  default InputElement input(InputType type) {
    return input(type.name());
  }

  /**
   * input.
   *
   * @param type a {@link String} object
   * @return a {@link InputElement} object
   */
  default InputElement input(String type) {
    return new InputElement(dom.input(type));
  }

  /**
   * label.
   *
   * @return a {@link LabelElement} object
   */
  default LabelElement label() {
    return new LabelElement(dom.label());
  }

  /**
   * label.
   *
   * @param text a {@link String} object
   * @return a {@link LabelElement} object
   */
  default LabelElement label(String text) {
    return label().textContent(text);
  }

  /**
   * legend.
   *
   * @return a {@link LegendElement} object
   */
  default LegendElement legend() {
    return new LegendElement(dom.legend());
  }

  /**
   * meter.
   *
   * @return a {@link MeterElement} object
   */
  default MeterElement meter() {
    return new MeterElement(dom.meter());
  }

  /**
   * optgroup.
   *
   * @return a {@link OptGroupElement} object
   */
  default OptGroupElement optgroup() {
    return new OptGroupElement(dom.optgroup());
  }

  /**
   * option.
   *
   * @return a {@link OptionElement} object
   */
  default OptionElement option() {
    return new OptionElement(dom.option());
  }

  /**
   * output.
   *
   * @return a {@link OutputElement} object
   */
  default OutputElement output() {
    return new OutputElement(dom.output());
  }

  /**
   * progress.
   *
   * @return a {@link ProgressElement} object
   */
  default ProgressElement progress() {
    return new ProgressElement(dom.progress());
  }

  /**
   * select_.
   *
   * @return a {@link SelectElement} object
   */
  default SelectElement select_() {
    return new SelectElement(dom.select_());
  }

  /**
   * textarea.
   *
   * @return a {@link TextAreaElement} object
   */
  default TextAreaElement textarea() {
    return new TextAreaElement(dom.textarea());
  }

  /**
   * svg.
   *
   * @return a {@link SvgElement} object
   */
  default SvgElement svg() {
    return new SvgElement(dom.svg());
  }

  /**
   * circle.
   *
   * @param cx a double
   * @param cy a double
   * @param r a double
   * @return a {@link CircleElement} object
   */
  default CircleElement circle(double cx, double cy, double r) {
    CircleElement circle = new CircleElement(dom.circle());
    circle.setAttribute("cx", cx);
    circle.setAttribute("cy", cy);
    circle.setAttribute("r", r);
    return circle;
  }

  /**
   * line.
   *
   * @param x1 a double
   * @param y1 a double
   * @param x2 a double
   * @param y2 a double
   * @return a {@link LineElement} object
   */
  default LineElement line(double x1, double y1, double x2, double y2) {
    LineElement circle = new LineElement(dom.line());
    circle.setAttribute("x1", x1);
    circle.setAttribute("y1", y1);
    circle.setAttribute("x2", x2);
    circle.setAttribute("y2", y2);
    return circle;
  }

  /** @return new empty {@link Text} node */
  /**
   * text.
   *
   * @return a {@link Text} object
   */
  default Text text() {
    return DomGlobal.document.createTextNode("");
  }

  /**
   * text.
   *
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
