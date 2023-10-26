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
 * A factory interface for creating various HTML elements in a fluent manner.
 *
 * <p>Example usage: ```java BodyElement body = ElementsFactory.elements.body(); DivElement div =
 * ElementsFactory.elements.div(); AnchorElement anchor = ElementsFactory.elements.a(); ```
 */
public interface ElementsFactory {

  /** A default instance of the ElementsFactory interface. */
  ElementsFactory elements = new ElementsFactory() {};

  /**
   * Provides access to the delegate that implements the ElementsFactory interface.
   *
   * @return An instance of ElementsFactoryDelegate.
   */
  default ElementsFactoryDelegate delegate() {
    return DominoUIConfig.CONFIG.getElementsFactory();
  }

  /**
   * Retrieves an element by its unique identifier.
   *
   * @param id The unique identifier of the element to retrieve.
   * @return An optional containing the element, or empty if not found.
   */
  default Optional<DominoElement<Element>> byId(String id) {
    return delegate().byId(id);
  }

  /**
   * Creates a new HTML element of the specified type.
   *
   * @param element The HTML element name (e.g., "div", "span").
   * @param type The Java class representing the element type.
   * @param <E> The element type.
   * @return A new instance of the specified element type.
   */
  default <E extends Element> E create(String element, Class<E> type) {
    return delegate().create(element, type);
  }

  /**
   * Wraps an existing element in a DominoElement.
   *
   * @param element The existing HTML element to wrap.
   * @param <E> The element type.
   * @return A DominoElement wrapping the existing element.
   */
  default <E extends Element> DominoElement<E> elementOf(E element) {
    return delegate().elementOf(element);
  }

  /**
   * Creates a DominoElement of the specified IsElement type.
   *
   * @param element The IsElement to wrap.
   * @param <T> The element type.
   * @param <E> The IsElement type.
   * @return A DominoElement wrapping the IsElement.
   */
  default <T extends Element, E extends IsElement<T>> DominoElement<T> elementOf(E element) {
    return delegate().elementOf(element);
  }

  /**
   * Generates a unique identifier.
   *
   * @return A unique identifier.
   */
  default String getUniqueId() {
    return delegate().getUniqueId();
  }

  /**
   * Generates a unique identifier with the specified prefix.
   *
   * @param prefix The prefix to use in the generated identifier.
   * @return A unique identifier with the specified prefix.
   */
  default String getUniqueId(String prefix) {
    return delegate().getUniqueId(prefix);
  }

  /**
   * Creates a &lt;body&gt; element.
   *
   * @return A new BodyElement.
   */
  default BodyElement body() {
    return delegate().body();
  }

  /**
   * Creates a &lt;picture&gt; element.
   *
   * @return A new PictureElement.
   */
  default PictureElement picture() {
    return delegate().picture();
  }

  /**
   * Creates an &lt;address&gt; element.
   *
   * @return A new AddressElement.
   */
  default AddressElement address() {
    return delegate().address();
  }

  /**
   * Creates an &lt;article&gt; element.
   *
   * @return A new ArticleElement.
   */
  default ArticleElement article() {
    return delegate().article();
  }

  /**
   * Creates an &lt;aside&gt; element.
   *
   * @return A new AsideElement.
   */
  default AsideElement aside() {
    return delegate().aside();
  }

  /**
   * Creates a &lt;footer&gt; element.
   *
   * @return A new FooterElement.
   */
  default FooterElement footer() {
    return delegate().footer();
  }

  /**
   * Creates a &lt;h&gt; (heading) element with the specified level.
   *
   * @param n The heading level (e.g., 1 for &lt;h1&gt;, 2 for &lt;h2&gt;, etc.).
   * @return A new HeadingElement with the specified level.
   */
  default HeadingElement h(int n) {
    return delegate().h(n);
  }

  /**
   * Creates a &lt;header&gt; element.
   *
   * @return A new HeaderElement.
   */
  default HeaderElement header() {
    return delegate().header();
  }

  /**
   * Creates an &lt;hgroup&gt; element.
   *
   * @return A new HGroupElement.
   */
  default HGroupElement hgroup() {
    return delegate().hgroup();
  }

  /**
   * Creates a &lt;nav&gt; element.
   *
   * @return A new NavElement.
   */
  default NavElement nav() {
    return delegate().nav();
  }

  /**
   * Creates a &lt;section&gt; element.
   *
   * @return A new SectionElement.
   */
  default SectionElement section() {
    return delegate().section();
  }

  /**
   * Creates a &lt;blockquote&gt; element.
   *
   * @return A new BlockquoteElement.
   */
  default BlockquoteElement blockquote() {
    return delegate().blockquote();
  }

  /**
   * Creates a &lt;dd&gt; element.
   *
   * @return A new DDElement.
   */
  default DDElement dd() {
    return delegate().dd();
  }

  /**
   * Creates a &lt;div&gt; element.
   *
   * @return A new DivElement.
   */
  default DivElement div() {
    return delegate().div();
  }

  /**
   * Creates a &lt;dl&gt; (definition list) element.
   *
   * @return A new DListElement.
   */
  default DListElement dl() {
    return delegate().dl();
  }

  /**
   * Creates a &lt;dt&gt; (definition term) element.
   *
   * @return A new DTElement.
   */
  default DTElement dt() {
    return delegate().dt();
  }

  /**
   * Creates a &lt;figcaption&gt; element.
   *
   * @return A new FigCaptionElement.
   */
  default FigCaptionElement figcaption() {
    return delegate().figcaption();
  }

  /**
   * Creates a &lt;figure&gt; element.
   *
   * @return A new FigureElement.
   */
  default FigureElement figure() {
    return delegate().figure();
  }

  /**
   * Creates a &lt;hr&gt; (horizontal rule) element.
   *
   * @return A new HRElement.
   */
  default HRElement hr() {
    return delegate().hr();
  }

  /**
   * Creates a &lt;li&gt; (list item) element.
   *
   * @return A new LIElement.
   */
  default LIElement li() {
    return delegate().li();
  }

  /**
   * Creates a &lt;main&gt; element.
   *
   * @return A new MainElement.
   */
  @SuppressWarnings("all")
  default MainElement main() {
    return delegate().main();
  }

  /**
   * Creates an &lt;ol&gt; (ordered list) element.
   *
   * @return A new OListElement.
   */
  default OListElement ol() {
    return delegate().ol();
  }

  /**
   * Creates a &lt;p&gt; (paragraph) element.
   *
   * @return A new ParagraphElement.
   */
  default ParagraphElement p() {
    return delegate().p();
  }

  /**
   * Creates a &lt;p&gt; (paragraph) element with the specified text content.
   *
   * @param text The text content to set in the paragraph.
   * @return A new ParagraphElement with the specified text content.
   */
  default ParagraphElement p(String text) {
    return delegate().p(text);
  }

  /**
   * Creates a &lt;pre&gt; (preformatted text) element.
   *
   * @return A new PreElement.
   */
  default PreElement pre() {
    return delegate().pre();
  }

  /**
   * Creates a &lt;ul&gt; (unordered list) element.
   *
   * @return A new UListElement.
   */
  default UListElement ul() {
    return delegate().ul();
  }

  /**
   * Creates an &lt;a&gt; (anchor) element.
   *
   * @return A new AnchorElement.
   */
  default AnchorElement a() {
    return delegate().a();
  }

  /**
   * Creates an &lt;a&gt; (anchor) element with the specified href.
   *
   * @param href The URL to set in the anchor's href attribute.
   * @return A new AnchorElement with the specified href.
   */
  default AnchorElement a(String href) {
    return delegate().a(href);
  }

  /**
   * Creates an &lt;a&gt; (anchor) element with the specified href and target.
   *
   * @param href The URL to set in the anchor's href attribute.
   * @param target The target attribute value to set.
   * @return A new AnchorElement with the specified href and target.
   */
  default AnchorElement a(String href, String target) {
    return delegate().a(href, target);
  }

  /**
   * Creates an &lt;abbr&gt; element.
   *
   * @return A new ABBRElement.
   */
  default ABBRElement abbr() {
    return delegate().abbr();
  }

  /**
   * Creates a &lt;b&gt; (bold) element.
   *
   * @return A new BElement.
   */
  default BElement b() {
    return delegate().b();
  }

  /**
   * Creates a &lt;br&gt; (line break) element.
   *
   * @return A new BRElement.
   */
  default BRElement br() {
    return delegate().br();
  }

  /**
   * Creates a &lt;cite&gt; element.
   *
   * @return A new CiteElement.
   */
  default CiteElement cite() {
    return delegate().cite();
  }

  /**
   * Creates a &lt;code&gt; element.
   *
   * @return A new CodeElement.
   */
  default CodeElement code() {
    return delegate().code();
  }

  /**
   * Creates a &lt;dfn&gt; element.
   *
   * @return A new DFNElement.
   */
  default DFNElement dfn() {
    return delegate().dfn();
  }

  /**
   * Creates an &lt;em&gt; (emphasis) element.
   *
   * @return A new EMElement.
   */
  default EMElement em() {
    return delegate().em();
  }

  /**
   * Creates an &lt;i&gt; (italic) element.
   *
   * @return A new IElement.
   */
  default IElement i() {
    return delegate().i();
  }

  /**
   * Creates a &lt;kbd&gt; (keyboard input) element.
   *
   * @return A new KBDElement.
   */
  default KBDElement kbd() {
    return delegate().kbd();
  }

  /**
   * Creates a &lt;mark&gt; element.
   *
   * @return A new MarkElement.
   */
  default MarkElement mark() {
    return delegate().mark();
  }

  /**
   * Creates a &lt;q&gt; (quotation) element.
   *
   * @return A new QuoteElement.
   */
  default QuoteElement q() {
    return delegate().q();
  }

  /**
   * Creates a &lt;small&gt; element.
   *
   * @return A new SmallElement.
   */
  default SmallElement small() {
    return delegate().small();
  }

  /**
   * Creates a &lt;span&gt; element.
   *
   * @return A new SpanElement.
   */
  default SpanElement span() {
    return delegate().span();
  }

  /**
   * Creates a &lt;strong&gt; (strong emphasis) element.
   *
   * @return A new StrongElement.
   */
  default StrongElement strong() {
    return delegate().strong();
  }

  /**
   * Creates a &lt;sub&gt; (subscript) element.
   *
   * @return A new SubElement.
   */
  default SubElement sub() {
    return delegate().sub();
  }

  /**
   * Creates a &lt;sup&gt; (superscript) element.
   *
   * @return A new SupElement.
   */
  default SupElement sup() {
    return delegate().sup();
  }

  /**
   * Creates a &lt;time&gt; element.
   *
   * @return A new TimeElement.
   */
  default TimeElement time() {
    return delegate().time();
  }

  /**
   * Creates a &lt;u&gt; (underline) element.
   *
   * @return A new UElement.
   */
  default UElement u() {
    return delegate().u();
  }

  /**
   * Creates a &lt;var&gt; (variable) element.
   *
   * @return A new VarElement.
   */
  default VarElement var() {
    return delegate().var();
  }

  /**
   * Creates a &lt;wbr&gt; (word break opportunity) element.
   *
   * @return A new WBRElement.
   */
  default WBRElement wbr() {
    return delegate().wbr();
  }

  /**
   * Creates an &lt;area&gt; element.
   *
   * @return A new AreaElement.
   */
  default AreaElement area() {
    return delegate().area();
  }

  /**
   * Creates an &lt;audio&gt; element.
   *
   * @return A new AudioElement.
   */
  default AudioElement audio() {
    return delegate().audio();
  }

  /**
   * Creates an &lt;img&gt; (image) element.
   *
   * @return A new ImageElement.
   */
  default ImageElement img() {
    return delegate().img();
  }

  /**
   * Creates an &lt;img&gt; (image) element with the specified source URL.
   *
   * @param src The URL of the image source.
   * @return A new ImageElement with the specified source URL.
   */
  default ImageElement img(String src) {
    return delegate().img(src);
  }

  /**
   * Creates a &lt;map&gt; element.
   *
   * @return A new MapElement.
   */
  default MapElement map() {
    return delegate().map();
  }

  /**
   * Creates a &lt;track&gt; element.
   *
   * @return A new TrackElement.
   */
  default TrackElement track() {
    return delegate().track();
  }

  /**
   * Creates a &lt;video&gt; element.
   *
   * @return A new VideoElement.
   */
  default VideoElement video() {
    return delegate().video();
  }

  /**
   * Creates a &lt;canvas&gt; element.
   *
   * @return A new CanvasElement.
   */
  default CanvasElement canvas() {
    return delegate().canvas();
  }

  /**
   * Creates an &lt;embed&gt; element.
   *
   * @return A new EmbedElement.
   */
  default EmbedElement embed() {
    return delegate().embed();
  }

  /**
   * Creates an &lt;iframe&gt; element.
   *
   * @return A new IFrameElement.
   */
  default IFrameElement iframe() {
    return delegate().iframe();
  }

  /**
   * Creates an &lt;iframe&gt; element with the specified source URL.
   *
   * @param src The URL of the iframe source.
   * @return A new IFrameElement with the specified source URL.
   */
  default IFrameElement iframe(String src) {
    return delegate().iframe(src);
  }

  /**
   * Creates an &lt;object&gt; element.
   *
   * @return A new ObjectElement.
   */
  default ObjectElement object() {
    return delegate().object();
  }

  /**
   * Creates a &lt;param&gt; element.
   *
   * @return A new ParamElement.
   */
  default ParamElement param() {
    return delegate().param();
  }

  /**
   * Creates a &lt;source&gt; element.
   *
   * @return A new SourceElement.
   */
  default SourceElement source() {
    return delegate().source();
  }

  /**
   * Creates a &lt;noscript&gt; element.
   *
   * @return A new NoScriptElement.
   */
  default NoScriptElement noscript() {
    return delegate().noscript();
  }

  /**
   * Creates a &lt;script&gt; element.
   *
   * @return A new ScriptElement.
   */
  default ScriptElement script() {
    return delegate().script();
  }

  /**
   * Creates a &lt;del&gt; (deleted text) element.
   *
   * @return A new DelElement.
   */
  default DelElement del() {
    return delegate().del();
  }

  /**
   * Creates an &lt;ins&gt; (inserted text) element.
   *
   * @return A new InsElement.
   */
  default InsElement ins() {
    return delegate().ins();
  }

  /**
   * Creates a &lt;caption&gt; (table caption) element.
   *
   * @return A new TableCaptionElement.
   */
  default TableCaptionElement caption() {
    return delegate().caption();
  }

  /**
   * Creates a &lt;col&gt; element.
   *
   * @return A new ColElement.
   */
  default ColElement col() {
    return delegate().col();
  }

  /**
   * Creates a &lt;colgroup&gt; element.
   *
   * @return A new ColGroupElement.
   */
  default ColGroupElement colgroup() {
    return delegate().colgroup();
  }

  /**
   * Creates a &lt;table&gt; element.
   *
   * @return A new TableElement.
   */
  default TableElement table() {
    return delegate().table();
  }

  /**
   * Creates a &lt;tbody&gt; element.
   *
   * @return A new TBodyElement.
   */
  default TBodyElement tbody() {
    return delegate().tbody();
  }

  /**
   * Creates a &lt;td&gt; (table cell) element.
   *
   * @return A new TDElement.
   */
  default TDElement td() {
    return delegate().td();
  }

  /**
   * Creates a &lt;tfoot&gt; element.
   *
   * @return A new TFootElement.
   */
  default TFootElement tfoot() {
    return delegate().tfoot();
  }

  /**
   * Creates a &lt;th&gt; (table header cell) element.
   *
   * @return A new THElement.
   */
  default THElement th() {
    return delegate().th();
  }

  /**
   * Creates a &lt;thead&gt; element.
   *
   * @return A new THeadElement.
   */
  default THeadElement thead() {
    return delegate().thead();
  }

  /**
   * Creates a &lt;tr&gt; (table row) element.
   *
   * @return A new TableRowElement.
   */
  default TableRowElement tr() {
    return delegate().tr();
  }

  /**
   * Creates a &lt;button&gt; element.
   *
   * @return A new ButtonElement.
   */
  default ButtonElement button() {
    return delegate().button();
  }

  /**
   * Creates a &lt;datalist&gt; element.
   *
   * @return A new DataListElement.
   */
  default DataListElement datalist() {
    return delegate().datalist();
  }

  /**
   * Creates a &lt;fieldset&gt; element.
   *
   * @return A new FieldSetElement.
   */
  default FieldSetElement fieldset() {
    return delegate().fieldset();
  }

  /**
   * Creates a &lt;form&gt; element.
   *
   * @return A new FormElement.
   */
  default FormElement form() {
    return delegate().form();
  }

  /**
   * Creates an &lt;input&gt; element with the specified input type.
   *
   * @param type The input type (e.g., "text", "checkbox", "radio", etc.).
   * @return A new InputElement with the specified input type.
   */
  default InputElement input(InputType type) {
    return delegate().input(type);
  }

  /**
   * Creates an &lt;input&gt; element with the specified input type.
   *
   * @param type The input type (e.g., "text", "checkbox", "radio", etc.).
   * @return A new InputElement with the specified input type.
   */
  default InputElement input(String type) {
    return delegate().input(type);
  }

  /**
   * Creates a &lt;label&gt; element.
   *
   * @return A new LabelElement.
   */
  default LabelElement label() {
    return delegate().label();
  }

  /**
   * Creates a &lt;label&gt; element with the specified text.
   *
   * @param text The text content to set in the label.
   * @return A new LabelElement with the specified text content.
   */
  default LabelElement label(String text) {
    return delegate().label(text);
  }

  /**
   * Creates a &lt;legend&gt; element.
   *
   * @return A new LegendElement.
   */
  default LegendElement legend() {
    return delegate().legend();
  }

  /**
   * Creates a &lt;meter&gt; element.
   *
   * @return A new MeterElement.
   */
  default MeterElement meter() {
    return delegate().meter();
  }

  /**
   * Creates an &lt;optgroup&gt; element.
   *
   * @return A new OptGroupElement.
   */
  default OptGroupElement optgroup() {
    return delegate().optgroup();
  }

  /**
   * Creates an &lt;option&gt; element.
   *
   * @return A new OptionElement.
   */
  default OptionElement option() {
    return delegate().option();
  }

  /**
   * Creates an &lt;output&gt; element.
   *
   * @return A new OutputElement.
   */
  default OutputElement output() {
    return delegate().output();
  }

  /**
   * Creates a &lt;progress&gt; element.
   *
   * @return A new ProgressElement.
   */
  default ProgressElement progress() {
    return delegate().progress();
  }

  /**
   * Creates a &lt;select&gt; element.
   *
   * @return A new SelectElement.
   */
  default SelectElement select_() {
    return delegate().select_();
  }

  /**
   * Creates a &lt;textarea&gt; element.
   *
   * @return A new TextAreaElement.
   */
  default TextAreaElement textarea() {
    return delegate().textarea();
  }

  /**
   * Creates an &lt;svg&gt; element.
   *
   * @return A new SvgElement.
   */
  default SvgElement svg() {
    return delegate().svg();
  }

  /**
   * Creates a &lt;circle&gt; element with the specified attributes.
   *
   * @param cx The x-coordinate of the center of the circle.
   * @param cy The y-coordinate of the center of the circle.
   * @param r The radius of the circle.
   * @return A new CircleElement with the specified attributes.
   */
  default CircleElement circle(double cx, double cy, double r) {
    return delegate().circle(cx, cy, r);
  }

  /**
   * Creates a &lt;line&gt; element with the specified attributes.
   *
   * @param x1 The x-coordinate of the start point of the line.
   * @param y1 The y-coordinate of the start point of the line.
   * @param x2 The x-coordinate of the end point of the line.
   * @param y2 The y-coordinate of the end point of the line.
   * @return A new LineElement with the specified attributes.
   */
  default LineElement line(double x1, double y1, double x2, double y2) {
    return delegate().line(x1, y1, x2, y2);
  }

  /**
   * Creates a &lt;text&gt; element.
   *
   * @return A new Text element.
   */
  default Text text() {
    return delegate().text();
  }

  /**
   * Creates a &lt;text&gt; element with the specified content.
   *
   * @param content The text content to set in the text element.
   * @return A new Text element with the specified content.
   */
  default Text text(String content) {
    return delegate().text(content);
  }
}
