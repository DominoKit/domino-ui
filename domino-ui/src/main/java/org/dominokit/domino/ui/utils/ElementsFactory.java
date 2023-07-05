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

/**
 * ElementsFactory interface.
 *
 * @author vegegoku
 * @version $Id: $Id
 */
public interface ElementsFactory {

  /** Constant <code>elements</code> */
  ElementsFactory elements = new ElementsFactory() {};

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
   * @param element a {@link java.lang.String} object
   * @param type a {@link java.lang.Class} object
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
   * @param <E> extends from {@link elemental2.dom.Element}
   * @return the {@link org.dominokit.domino.ui.utils.DominoElement} wrapping the provided element
   */
  default <E extends Element> DominoElement<E> elementOf(E element) {
    return new DominoElement<>(element);
  }

  /**
   * elementOf.
   *
   * @param element the {@link org.dominokit.domino.ui.IsElement} E to wrap as a DominoElement
   * @param <E> extends from {@link elemental2.dom.Element}
   * @return the {@link org.dominokit.domino.ui.utils.DominoElement} wrapping the provided element
   * @param <T> a T class
   */
  default <T extends Element, E extends IsElement<T>> DominoElement<T> elementOf(E element) {
    return new DominoElement<>(element.element());
  }

  /**
   * getUniqueId.
   *
   * @return a {@link java.lang.String} object
   */
  default String getUniqueId() {
    return DominoId.unique();
  }

  /**
   * getUniqueId.
   *
   * @param prefix a {@link java.lang.String} object
   * @return a {@link java.lang.String} object
   */
  default String getUniqueId(String prefix) {
    return DominoId.unique(prefix);
  }

  /** @return a {@link DominoElement} wrapping the document {@link HTMLBodyElement} */
  /**
   * body.
   *
   * @return a {@link org.dominokit.domino.ui.elements.BodyElement} object
   */
  default BodyElement body() {
    return new BodyElement(dom.body());
  }

  /** @return a new {@link HTMLDivElement} wrapped as a {@link DominoElement} */
  /**
   * picture.
   *
   * @return a {@link org.dominokit.domino.ui.elements.PictureElement} object
   */
  default PictureElement picture() {
    return new PictureElement(dom.picture());
  }

  // ------------------ content sectioning

  /**
   * address.
   *
   * @return a {@link org.dominokit.domino.ui.elements.AddressElement} object
   */
  default AddressElement address() {
    return new AddressElement(dom.address());
  }

  /**
   * article.
   *
   * @return a {@link org.dominokit.domino.ui.elements.ArticleElement} object
   */
  default ArticleElement article() {
    return new ArticleElement(dom.article());
  }

  /**
   * aside.
   *
   * @return a {@link org.dominokit.domino.ui.elements.AsideElement} object
   */
  default AsideElement aside() {
    return new AsideElement(dom.aside());
  }

  /**
   * footer.
   *
   * @return a {@link org.dominokit.domino.ui.elements.FooterElement} object
   */
  default FooterElement footer() {
    return new FooterElement(dom.footer());
  }

  /**
   * h.
   *
   * @param n a int
   * @return a {@link org.dominokit.domino.ui.elements.HeadingElement} object
   */
  default HeadingElement h(int n) {
    return new HeadingElement(dom.h(n));
  }

  /**
   * header.
   *
   * @return a {@link org.dominokit.domino.ui.elements.HeaderElement} object
   */
  default HeaderElement header() {
    return new HeaderElement(dom.header());
  }

  /**
   * hgroup.
   *
   * @return a {@link org.dominokit.domino.ui.elements.HGroupElement} object
   */
  default HGroupElement hgroup() {
    return new HGroupElement(dom.hgroup());
  }

  /**
   * nav.
   *
   * @return a {@link org.dominokit.domino.ui.elements.NavElement} object
   */
  default NavElement nav() {
    return new NavElement(dom.nav());
  }

  /**
   * section.
   *
   * @return a {@link org.dominokit.domino.ui.elements.SectionElement} object
   */
  default SectionElement section() {
    return new SectionElement(dom.section());
  }

  // ------------------------------------------------------ text content

  /**
   * blockquote.
   *
   * @return a {@link org.dominokit.domino.ui.elements.BlockquoteElement} object
   */
  default BlockquoteElement blockquote() {
    return new BlockquoteElement(dom.blockquote());
  }

  /**
   * dd.
   *
   * @return a {@link org.dominokit.domino.ui.elements.DDElement} object
   */
  default DDElement dd() {
    return new DDElement(dom.dd());
  }

  /**
   * div.
   *
   * @return a {@link org.dominokit.domino.ui.elements.DivElement} object
   */
  default DivElement div() {
    return new DivElement(dom.div());
  }

  /**
   * dl.
   *
   * @return a {@link org.dominokit.domino.ui.elements.DListElement} object
   */
  default DListElement dl() {
    return new DListElement(dom.dl());
  }

  /**
   * dt.
   *
   * @return a {@link org.dominokit.domino.ui.elements.DTElement} object
   */
  default DTElement dt() {
    return new DTElement(dom.dt());
  }

  /**
   * figcaption.
   *
   * @return a {@link org.dominokit.domino.ui.elements.FigCaptionElement} object
   */
  default FigCaptionElement figcaption() {
    return new FigCaptionElement(dom.figcaption());
  }

  /**
   * figure.
   *
   * @return a {@link org.dominokit.domino.ui.elements.FigureElement} object
   */
  default FigureElement figure() {
    return new FigureElement(dom.figure());
  }

  /**
   * hr.
   *
   * @return a {@link org.dominokit.domino.ui.elements.HRElement} object
   */
  default HRElement hr() {
    return new HRElement(dom.hr());
  }

  /**
   * li.
   *
   * @return a {@link org.dominokit.domino.ui.elements.LIElement} object
   */
  default LIElement li() {
    return new LIElement(dom.li());
  }

  /**
   * main.
   *
   * @return a {@link org.dominokit.domino.ui.elements.MainElement} object
   */
  @SuppressWarnings("all")
  default MainElement main() {
    return new MainElement(dom.main());
  }

  /**
   * ol.
   *
   * @return a {@link org.dominokit.domino.ui.elements.OListElement} object
   */
  default OListElement ol() {
    return new OListElement(dom.ol());
  }

  /**
   * p.
   *
   * @return a {@link org.dominokit.domino.ui.elements.ParagraphElement} object
   */
  default ParagraphElement p() {
    return new ParagraphElement(dom.p());
  }

  /**
   * p.
   *
   * @param text a {@link java.lang.String} object
   * @return a {@link org.dominokit.domino.ui.elements.ParagraphElement} object
   */
  default ParagraphElement p(String text) {
    return new ParagraphElement(dom.p()).setTextContent(text);
  }

  /**
   * pre.
   *
   * @return a {@link org.dominokit.domino.ui.elements.PreElement} object
   */
  default PreElement pre() {
    return new PreElement(dom.pre());
  }

  /**
   * ul.
   *
   * @return a {@link org.dominokit.domino.ui.elements.UListElement} object
   */
  default UListElement ul() {
    return new UListElement(dom.ul());
  }

  // ------------------------------------------------------ inline text semantics

  /**
   * a.
   *
   * @return a {@link org.dominokit.domino.ui.elements.AnchorElement} object
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
   * @param href a {@link java.lang.String} object
   * @return a {@link org.dominokit.domino.ui.elements.AnchorElement} object
   */
  default AnchorElement a(String href) {
    return new AnchorElement(dom.a())
        .setAttribute("href", href)
        .setAttribute("aria-expanded", "true");
  }

  /**
   * a.
   *
   * @param href a {@link java.lang.String} object
   * @param target a {@link java.lang.String} object
   * @return a {@link org.dominokit.domino.ui.elements.AnchorElement} object
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
   * @return a {@link org.dominokit.domino.ui.elements.ABBRElement} object
   */
  default ABBRElement abbr() {
    return new ABBRElement(dom.abbr());
  }

  /**
   * b.
   *
   * @return a {@link org.dominokit.domino.ui.elements.BElement} object
   */
  default BElement b() {
    return new BElement(dom.b());
  }

  /**
   * br.
   *
   * @return a {@link org.dominokit.domino.ui.elements.BRElement} object
   */
  default BRElement br() {
    return new BRElement(dom.br());
  }

  /**
   * cite.
   *
   * @return a {@link org.dominokit.domino.ui.elements.CiteElement} object
   */
  default CiteElement cite() {
    return new CiteElement(dom.cite());
  }

  /**
   * code.
   *
   * @return a {@link org.dominokit.domino.ui.elements.CodeElement} object
   */
  default CodeElement code() {
    return new CodeElement(dom.code());
  }

  /**
   * dfn.
   *
   * @return a {@link org.dominokit.domino.ui.elements.DFNElement} object
   */
  default DFNElement dfn() {
    return new DFNElement(dom.dfn());
  }

  /**
   * em.
   *
   * @return a {@link org.dominokit.domino.ui.elements.EMElement} object
   */
  default EMElement em() {
    return new EMElement(dom.em());
  }

  /**
   * i.
   *
   * @return a {@link org.dominokit.domino.ui.elements.IElement} object
   */
  default IElement i() {
    return new IElement(dom.i());
  }

  /**
   * kbd.
   *
   * @return a {@link org.dominokit.domino.ui.elements.KBDElement} object
   */
  default KBDElement kbd() {
    return new KBDElement(dom.kbd());
  }

  /**
   * mark.
   *
   * @return a {@link org.dominokit.domino.ui.elements.MarkElement} object
   */
  default MarkElement mark() {
    return new MarkElement(dom.mark());
  }

  /**
   * q.
   *
   * @return a {@link org.dominokit.domino.ui.elements.QuoteElement} object
   */
  default QuoteElement q() {
    return new QuoteElement(dom.q());
  }

  /**
   * small.
   *
   * @return a {@link org.dominokit.domino.ui.elements.SmallElement} object
   */
  default SmallElement small() {
    return new SmallElement(dom.small());
  }

  /**
   * span.
   *
   * @return a {@link org.dominokit.domino.ui.elements.SpanElement} object
   */
  default SpanElement span() {
    return new SpanElement(dom.span());
  }

  /**
   * strong.
   *
   * @return a {@link org.dominokit.domino.ui.elements.StrongElement} object
   */
  default StrongElement strong() {
    return new StrongElement(dom.strong());
  }

  /**
   * sub.
   *
   * @return a {@link org.dominokit.domino.ui.elements.SubElement} object
   */
  default SubElement sub() {
    return new SubElement(dom.sub());
  }

  /**
   * sup.
   *
   * @return a {@link org.dominokit.domino.ui.elements.SupElement} object
   */
  default SupElement sup() {
    return new SupElement(dom.sup());
  }

  /**
   * time.
   *
   * @return a {@link org.dominokit.domino.ui.elements.TimeElement} object
   */
  default TimeElement time() {
    return new TimeElement(dom.time());
  }

  /**
   * u.
   *
   * @return a {@link org.dominokit.domino.ui.elements.UElement} object
   */
  default UElement u() {
    return new UElement(dom.u());
  }

  /**
   * var.
   *
   * @return a {@link org.dominokit.domino.ui.elements.VarElement} object
   */
  default VarElement var() {
    return new VarElement(dom.var());
  }

  /**
   * wbr.
   *
   * @return a {@link org.dominokit.domino.ui.elements.WBRElement} object
   */
  default WBRElement wbr() {
    return new WBRElement(dom.wbr());
  }

  // ------------------------------------------------------ image and multimedia

  /**
   * area.
   *
   * @return a {@link org.dominokit.domino.ui.elements.AreaElement} object
   */
  default AreaElement area() {
    return new AreaElement(dom.area());
  }

  /**
   * audio.
   *
   * @return a {@link org.dominokit.domino.ui.elements.AudioElement} object
   */
  default AudioElement audio() {
    return new AudioElement(dom.audio());
  }

  /**
   * img.
   *
   * @return a {@link org.dominokit.domino.ui.elements.ImageElement} object
   */
  default ImageElement img() {
    return new ImageElement(dom.img());
  }

  /**
   * img.
   *
   * @param src a {@link java.lang.String} object
   * @return a {@link org.dominokit.domino.ui.elements.ImageElement} object
   */
  default ImageElement img(String src) {
    return new ImageElement(dom.img(src));
  }

  /**
   * map.
   *
   * @return a {@link org.dominokit.domino.ui.elements.MapElement} object
   */
  default MapElement map() {
    return new MapElement(dom.map());
  }

  /**
   * track.
   *
   * @return a {@link org.dominokit.domino.ui.elements.TrackElement} object
   */
  default TrackElement track() {
    return new TrackElement(dom.track());
  }

  /**
   * video.
   *
   * @return a {@link org.dominokit.domino.ui.elements.VideoElement} object
   */
  default VideoElement video() {
    return new VideoElement(dom.video());
  }

  // ------------------------------------------------------ embedded content

  /**
   * canvas.
   *
   * @return a {@link org.dominokit.domino.ui.elements.CanvasElement} object
   */
  default CanvasElement canvas() {
    return new CanvasElement(dom.canvas());
  }

  /**
   * embed.
   *
   * @return a {@link org.dominokit.domino.ui.elements.EmbedElement} object
   */
  default EmbedElement embed() {
    return new EmbedElement(dom.embed());
  }

  /**
   * iframe.
   *
   * @return a {@link org.dominokit.domino.ui.elements.IFrameElement} object
   */
  default IFrameElement iframe() {
    return new IFrameElement(dom.iframe());
  }

  /**
   * iframe.
   *
   * @param src a {@link java.lang.String} object
   * @return a {@link org.dominokit.domino.ui.elements.IFrameElement} object
   */
  default IFrameElement iframe(String src) {
    return iframe().setAttribute("src", src);
  }

  /**
   * object.
   *
   * @return a {@link org.dominokit.domino.ui.elements.ObjectElement} object
   */
  default ObjectElement object() {
    return new ObjectElement(dom.object());
  }

  /**
   * param.
   *
   * @return a {@link org.dominokit.domino.ui.elements.ParamElement} object
   */
  default ParamElement param() {
    return new ParamElement(dom.param());
  }

  /**
   * source.
   *
   * @return a {@link org.dominokit.domino.ui.elements.SourceElement} object
   */
  default SourceElement source() {
    return new SourceElement(dom.source());
  }

  // ------------------------------------------------------ scripting

  /**
   * noscript.
   *
   * @return a {@link org.dominokit.domino.ui.elements.NoScriptElement} object
   */
  default NoScriptElement noscript() {
    return new NoScriptElement(dom.noscript());
  }

  /**
   * script.
   *
   * @return a {@link org.dominokit.domino.ui.elements.ScriptElement} object
   */
  default ScriptElement script() {
    return new ScriptElement(dom.script());
  }

  // ------------------------------------------------------ demarcating edits

  /**
   * del.
   *
   * @return a {@link org.dominokit.domino.ui.elements.DelElement} object
   */
  default DelElement del() {
    return new DelElement(dom.del());
  }

  /**
   * ins.
   *
   * @return a {@link org.dominokit.domino.ui.elements.InsElement} object
   */
  default InsElement ins() {
    return new InsElement(dom.ins());
  }

  // ------------------------------------------------------ table content

  /**
   * caption.
   *
   * @return a {@link org.dominokit.domino.ui.elements.TableCaptionElement} object
   */
  default TableCaptionElement caption() {
    return new TableCaptionElement(dom.caption());
  }

  /**
   * col.
   *
   * @return a {@link org.dominokit.domino.ui.elements.ColElement} object
   */
  default ColElement col() {
    return new ColElement(dom.col());
  }

  /**
   * colgroup.
   *
   * @return a {@link org.dominokit.domino.ui.elements.ColGroupElement} object
   */
  default ColGroupElement colgroup() {
    return new ColGroupElement(dom.colgroup());
  }

  /**
   * table.
   *
   * @return a {@link org.dominokit.domino.ui.elements.TableElement} object
   */
  default TableElement table() {
    return new TableElement(dom.table());
  }

  /**
   * tbody.
   *
   * @return a {@link org.dominokit.domino.ui.elements.TBodyElement} object
   */
  default TBodyElement tbody() {
    return new TBodyElement(dom.tbody());
  }

  /**
   * td.
   *
   * @return a {@link org.dominokit.domino.ui.elements.TDElement} object
   */
  default TDElement td() {
    return new TDElement(dom.td());
  }

  /**
   * tfoot.
   *
   * @return a {@link org.dominokit.domino.ui.elements.TFootElement} object
   */
  default TFootElement tfoot() {
    return new TFootElement(dom.tfoot());
  }

  /**
   * th.
   *
   * @return a {@link org.dominokit.domino.ui.elements.THElement} object
   */
  default THElement th() {
    return new THElement(dom.th());
  }

  /**
   * thead.
   *
   * @return a {@link org.dominokit.domino.ui.elements.THeadElement} object
   */
  default THeadElement thead() {
    return new THeadElement(dom.thead());
  }

  /**
   * tr.
   *
   * @return a {@link org.dominokit.domino.ui.elements.TableRowElement} object
   */
  default TableRowElement tr() {
    return new TableRowElement(dom.tr());
  }

  // ------------------------------------------------------ forms

  /**
   * button.
   *
   * @return a {@link org.dominokit.domino.ui.elements.ButtonElement} object
   */
  default ButtonElement button() {
    return new ButtonElement(dom.button());
  }

  /**
   * datalist.
   *
   * @return a {@link org.dominokit.domino.ui.elements.DataListElement} object
   */
  default DataListElement datalist() {
    return new DataListElement(dom.datalist());
  }

  /**
   * fieldset.
   *
   * @return a {@link org.dominokit.domino.ui.elements.FieldSetElement} object
   */
  default FieldSetElement fieldset() {
    return new FieldSetElement(dom.fieldset());
  }

  /**
   * form.
   *
   * @return a {@link org.dominokit.domino.ui.elements.FormElement} object
   */
  default FormElement form() {
    return new FormElement(dom.form());
  }

  /**
   * input.
   *
   * @param type a {@link org.dominokit.domino.ui.utils.InputType} object
   * @return a {@link org.dominokit.domino.ui.elements.InputElement} object
   */
  default InputElement input(InputType type) {
    return input(type.name());
  }

  /**
   * input.
   *
   * @param type a {@link java.lang.String} object
   * @return a {@link org.dominokit.domino.ui.elements.InputElement} object
   */
  default InputElement input(String type) {
    return new InputElement(dom.input(type));
  }

  /**
   * label.
   *
   * @return a {@link org.dominokit.domino.ui.elements.LabelElement} object
   */
  default LabelElement label() {
    return new LabelElement(dom.label());
  }

  /**
   * label.
   *
   * @param text a {@link java.lang.String} object
   * @return a {@link org.dominokit.domino.ui.elements.LabelElement} object
   */
  default LabelElement label(String text) {
    return label().textContent(text);
  }

  /**
   * legend.
   *
   * @return a {@link org.dominokit.domino.ui.elements.LegendElement} object
   */
  default LegendElement legend() {
    return new LegendElement(dom.legend());
  }

  /**
   * meter.
   *
   * @return a {@link org.dominokit.domino.ui.elements.MeterElement} object
   */
  default MeterElement meter() {
    return new MeterElement(dom.meter());
  }

  /**
   * optgroup.
   *
   * @return a {@link org.dominokit.domino.ui.elements.OptGroupElement} object
   */
  default OptGroupElement optgroup() {
    return new OptGroupElement(dom.optgroup());
  }

  /**
   * option.
   *
   * @return a {@link org.dominokit.domino.ui.elements.OptionElement} object
   */
  default OptionElement option() {
    return new OptionElement(dom.option());
  }

  /**
   * output.
   *
   * @return a {@link org.dominokit.domino.ui.elements.OutputElement} object
   */
  default OutputElement output() {
    return new OutputElement(dom.output());
  }

  /**
   * progress.
   *
   * @return a {@link org.dominokit.domino.ui.elements.ProgressElement} object
   */
  default ProgressElement progress() {
    return new ProgressElement(dom.progress());
  }

  /**
   * select_.
   *
   * @return a {@link org.dominokit.domino.ui.elements.SelectElement} object
   */
  default SelectElement select_() {
    return new SelectElement(dom.select_());
  }

  /**
   * textarea.
   *
   * @return a {@link org.dominokit.domino.ui.elements.TextAreaElement} object
   */
  default TextAreaElement textarea() {
    return new TextAreaElement(dom.textarea());
  }

  /**
   * svg.
   *
   * @return a {@link org.dominokit.domino.ui.elements.SvgElement} object
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
   * @return a {@link org.dominokit.domino.ui.elements.CircleElement} object
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
   * @return a {@link org.dominokit.domino.ui.elements.LineElement} object
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
   * @return a {@link elemental2.dom.Text} object
   */
  default Text text() {
    return DomGlobal.document.createTextNode("");
  }

  /**
   * text.
   *
   * @param content String content of the node
   * @return new {@link elemental2.dom.Text} node with the provided text content
   */
  default Text text(String content) {
    if (isNull(content) || content.isEmpty()) {
      return text();
    }
    return DomGlobal.document.createTextNode(content);
  }
}
