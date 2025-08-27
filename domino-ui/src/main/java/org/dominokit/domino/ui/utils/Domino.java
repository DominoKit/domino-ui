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

import static org.dominokit.domino.ui.utils.SVGFactory.svgElements;

import elemental2.dom.Element;
import elemental2.dom.Text;
import elemental2.svg.SVGElement;
import java.util.Optional;
import org.dominokit.domino.ui.IsElement;
import org.dominokit.domino.ui.elements.*;
import org.dominokit.domino.ui.elements.ImageElement;
import org.dominokit.domino.ui.elements.ScriptElement;
import org.dominokit.domino.ui.elements.svg.*;
import org.dominokit.domino.ui.style.DominoCss;

public class Domino implements DominoCss {

  public static ElementsFactory factory = ElementsFactory.elements;

  private Domino() {}

  public static void withFactory(ElementsFactory replacement, Runnable runnable) {
    factory = replacement;
    try {
      runnable.run();
    } finally {
      factory = ElementsFactory.elements;
    }
  }

  public static void withFactory(ElementsFactory replacement, AsyncRunnable runnable) {
    factory = replacement;
    try {
      runnable.run(
          () -> {
            factory = ElementsFactory.elements;
          });
    } finally {
      factory = ElementsFactory.elements;
    }
  }

  /**
   * Retrieves an element by its unique identifier.
   *
   * @param id The unique identifier of the element to retrieve.
   * @return An optional containing the element, or empty if not found.
   */
  public static Optional<DominoElement<Element>> byId(String id) {
    return factory.byId(id);
  }

  /**
   * Creates a new HTML element of the specified type.
   *
   * @param element The HTML element name (e.g., "div", "span").
   * @param type The Java class representing the element type.
   * @param <E> The element type.
   * @return A new instance of the specified element type.
   */
  public static <E extends Element> E create(String element, Class<E> type) {
    return factory.create(element, type);
  }

  /**
   * Wraps an existing element in a DominoElement.
   *
   * @param element The existing HTML element to wrap.
   * @param <E> The element type.
   * @return A DominoElement wrapping the existing element.
   */
  public static <E extends Element> DominoElement<E> elementOf(E element) {
    return factory.elementOf(element);
  }

  /**
   * Wraps an existing element in a DominoElement. This method does not add the "dui" CSS class to
   * the element.
   *
   * @param element The existing HTML element to wrap.
   * @param <E> The element type.
   * @return A DominoElement wrapping the existing element.
   */
  public static <E extends Element> DominoElement<E> wrap(E element) {
    return factory.wrap(element);
  }

  /**
   * Creates a DominoElement of the specified IsElement type.
   *
   * @param element The IsElement to wrap.
   * @param <T> The element type.
   * @param <E> The IsElement type.
   * @return A DominoElement wrapping the IsElement.
   */
  public static <T extends Element, E extends IsElement<T>> DominoElement<T> elementOf(E element) {
    return factory.elementOf(element);
  }

  /**
   * Creates a DominoElement of the specified IsElement type. This method does not add the "dui" CSS
   * class to the element.
   *
   * @param element The IsElement to wrap.
   * @param <T> The element type.
   * @param <E> The IsElement type.
   * @return A DominoElement wrapping the IsElement.
   */
  public static <T extends Element, E extends IsElement<T>> DominoElement<T> wrap(E element) {
    return factory.wrap(element);
  }

  /**
   * Generates a unique identifier.
   *
   * @return A unique identifier.
   */
  public static String getUniqueId() {
    return factory.getUniqueId();
  }

  /**
   * Generates a unique identifier with the specified prefix.
   *
   * @param prefix The prefix to use in the generated identifier.
   * @return A unique identifier with the specified prefix.
   */
  public static String getUniqueId(String prefix) {
    return factory.getUniqueId(prefix);
  }

  /**
   * Creates a &lt;body&gt; element.
   *
   * @return A new BodyElement.
   */
  public static BodyElement body() {
    return factory.body();
  }

  /**
   * Creates a &lt;picture&gt; element.
   *
   * @return A new PictureElement.
   */
  public static PictureElement picture() {
    return factory.picture();
  }

  /**
   * Creates an &lt;address&gt; element.
   *
   * @return A new AddressElement.
   */
  public static AddressElement address() {
    return factory.address();
  }

  /**
   * Creates an &lt;article&gt; element.
   *
   * @return A new ArticleElement.
   */
  public static ArticleElement article() {
    return factory.article();
  }

  /**
   * Creates an &lt;aside&gt; element.
   *
   * @return A new AsideElement.
   */
  public static AsideElement aside() {
    return factory.aside();
  }

  /**
   * Creates a &lt;footer&gt; element.
   *
   * @return A new FooterElement.
   */
  public static FooterElement footer() {
    return factory.footer();
  }

  /**
   * Creates a &lt;h&gt; (heading) element with the specified level.
   *
   * @param n The heading level (e.g., 1 for &lt;h1&gt;, 2 for &lt;h2&gt;, etc.).
   * @return A new HeadingElement with the specified level.
   */
  public static HeadingElement h(int n) {
    return factory.h(n);
  }

  /**
   * Creates a &lt;header&gt; element.
   *
   * @return A new HeaderElement.
   */
  public static HeaderElement header() {
    return factory.header();
  }

  /**
   * Creates an &lt;hgroup&gt; element.
   *
   * @return A new HGroupElement.
   */
  public static HGroupElement hgroup() {
    return factory.hgroup();
  }

  /**
   * Creates a &lt;nav&gt; element.
   *
   * @return A new NavElement.
   */
  public static NavElement nav() {
    return factory.nav();
  }

  /**
   * Creates a &lt;section&gt; element.
   *
   * @return A new SectionElement.
   */
  public static SectionElement section() {
    return factory.section();
  }

  /**
   * Creates a &lt;blockquote&gt; element.
   *
   * @return A new BlockquoteElement.
   */
  public static BlockquoteElement blockquote() {
    return factory.blockquote();
  }

  /**
   * Creates a &lt;dd&gt; element.
   *
   * @return A new DDElement.
   */
  public static DDElement dd() {
    return factory.dd();
  }

  /**
   * Creates a &lt;div&gt; element.
   *
   * @return A new DivElement.
   */
  public static DivElement div() {
    return factory.div();
  }

  /**
   * Creates a &lt;dl&gt; (definition list) element.
   *
   * @return A new DListElement.
   */
  public static DListElement dl() {
    return factory.dl();
  }

  /**
   * Creates a &lt;dt&gt; (definition term) element.
   *
   * @return A new DTElement.
   */
  public static DTElement dt() {
    return factory.dt();
  }

  /**
   * Creates a &lt;figcaption&gt; element.
   *
   * @return A new FigCaptionElement.
   */
  public static FigCaptionElement figcaption() {
    return factory.figcaption();
  }

  /**
   * Creates a &lt;figure&gt; element.
   *
   * @return A new FigureElement.
   */
  public static FigureElement figure() {
    return factory.figure();
  }

  /**
   * Creates a &lt;hr&gt; (horizontal rule) element.
   *
   * @return A new HRElement.
   */
  public static HRElement hr() {
    return factory.hr();
  }

  /**
   * Creates a &lt;li&gt; (list item) element.
   *
   * @return A new LIElement.
   */
  public static LIElement li() {
    return factory.li();
  }

  /**
   * Creates a &lt;main&gt; element.
   *
   * @return A new MainElement.
   */
  @SuppressWarnings("all")
  public static MainElement main() {
    return factory.main();
  }

  /**
   * Creates an &lt;ol&gt; (ordered list) element.
   *
   * @return A new OListElement.
   */
  public static OListElement ol() {
    return factory.ol();
  }

  /**
   * Creates a &lt;p&gt; (paragraph) element.
   *
   * @return A new ParagraphElement.
   */
  public static ParagraphElement p() {
    return factory.p();
  }

  /**
   * Creates a &lt;p&gt; (paragraph) element with the specified text content.
   *
   * @param text The text content to set in the paragraph.
   * @return A new ParagraphElement with the specified text content.
   */
  public static ParagraphElement p(String text) {
    return factory.p(text);
  }

  /**
   * Creates a &lt;pre&gt; (preformatted text) element.
   *
   * @return A new PreElement.
   */
  public static PreElement pre() {
    return factory.pre();
  }

  /**
   * Creates a &lt;ul&gt; (unordered list) element.
   *
   * @return A new UListElement.
   */
  public static UListElement ul() {
    return factory.ul();
  }

  /**
   * Creates an &lt;a&gt; (anchor) element.
   *
   * @return A new AnchorElement.
   */
  public static AnchorElement a() {
    return factory.a();
  }

  /**
   * Creates an &lt;a&gt; (anchor) element with the specified href.
   *
   * @param href The URL to set in the anchor's href attribute.
   * @return A new AnchorElement with the specified href.
   */
  public static AnchorElement a(String href) {
    return factory.a(href);
  }

  /**
   * Creates an &lt;a&gt; (anchor) element with the specified href and target.
   *
   * @param href The URL to set in the anchor's href attribute.
   * @param target The target attribute value to set.
   * @return A new AnchorElement with the specified href and target.
   */
  public static AnchorElement a(String href, String target) {
    return factory.a(href, target);
  }

  /**
   * Creates an &lt;abbr&gt; element.
   *
   * @return A new ABBRElement.
   */
  public static ABBRElement abbr() {
    return factory.abbr();
  }

  /**
   * Creates a &lt;b&gt; (bold) element.
   *
   * @return A new BElement.
   */
  public static BElement b() {
    return factory.b();
  }

  /**
   * Creates a &lt;br&gt; (line break) element.
   *
   * @return A new BRElement.
   */
  public static BRElement br() {
    return factory.br();
  }

  /**
   * Creates a &lt;cite&gt; element.
   *
   * @return A new CiteElement.
   */
  public static CiteElement cite() {
    return factory.cite();
  }

  /**
   * Creates a &lt;code&gt; element.
   *
   * @return A new CodeElement.
   */
  public static CodeElement code() {
    return factory.code();
  }

  /**
   * Creates a &lt;dfn&gt; element.
   *
   * @return A new DFNElement.
   */
  public static DFNElement dfn() {
    return factory.dfn();
  }

  /**
   * Creates an &lt;em&gt; (emphasis) element.
   *
   * @return A new EMElement.
   */
  public static EMElement em() {
    return factory.em();
  }

  /**
   * Creates an &lt;i&gt; (italic) element.
   *
   * @return A new IElement.
   */
  public static IElement i() {
    return factory.i();
  }

  /**
   * Creates a &lt;kbd&gt; (keyboard input) element.
   *
   * @return A new KBDElement.
   */
  public static KBDElement kbd() {
    return factory.kbd();
  }

  /**
   * Creates a &lt;mark&gt; element.
   *
   * @return A new MarkElement.
   */
  public static MarkElement mark() {
    return factory.mark();
  }

  /**
   * Creates a &lt;q&gt; (quotation) element.
   *
   * @return A new QuoteElement.
   */
  public static QuoteElement q() {
    return factory.q();
  }

  /**
   * Creates a &lt;small&gt; element.
   *
   * @return A new SmallElement.
   */
  public static SmallElement small() {
    return factory.small();
  }

  /**
   * Creates a &lt;span&gt; element.
   *
   * @return A new SpanElement.
   */
  public static SpanElement span() {
    return factory.span();
  }

  /**
   * Creates a &lt;strong&gt; (strong emphasis) element.
   *
   * @return A new StrongElement.
   */
  public static StrongElement strong() {
    return factory.strong();
  }

  /**
   * Creates a &lt;sub&gt; (subscript) element.
   *
   * @return A new SubElement.
   */
  public static SubElement sub() {
    return factory.sub();
  }

  /**
   * Creates a &lt;sup&gt; (superscript) element.
   *
   * @return A new SupElement.
   */
  public static SupElement sup() {
    return factory.sup();
  }

  /**
   * Creates a &lt;time&gt; element.
   *
   * @return A new TimeElement.
   */
  public static TimeElement time() {
    return factory.time();
  }

  /**
   * Creates a &lt;u&gt; (underline) element.
   *
   * @return A new UElement.
   */
  public static UElement u() {
    return factory.u();
  }

  /**
   * Creates a &lt;var&gt; (variable) element.
   *
   * @return A new VarElement.
   */
  public static VarElement var() {
    return factory.var();
  }

  /**
   * Creates a &lt;wbr&gt; (word break opportunity) element.
   *
   * @return A new WBRElement.
   */
  public static WBRElement wbr() {
    return factory.wbr();
  }

  /**
   * Creates an &lt;area&gt; element.
   *
   * @return A new AreaElement.
   */
  public static AreaElement area() {
    return factory.area();
  }

  /**
   * Creates an &lt;audio&gt; element.
   *
   * @return A new AudioElement.
   */
  public static AudioElement audio() {
    return factory.audio();
  }

  /**
   * Creates an &lt;img&gt; (image) element.
   *
   * @return A new ImageElement.
   */
  public static ImageElement img() {
    return factory.img();
  }

  /**
   * Creates an &lt;img&gt; (image) element with the specified source URL.
   *
   * @param src The URL of the image source.
   * @return A new ImageElement with the specified source URL.
   */
  public static ImageElement img(String src) {
    return factory.img(src);
  }

  /**
   * Creates a &lt;map&gt; element.
   *
   * @return A new MapElement.
   */
  public static MapElement map() {
    return factory.map();
  }

  /**
   * Creates a &lt;track&gt; element.
   *
   * @return A new TrackElement.
   */
  public static TrackElement track() {
    return factory.track();
  }

  /**
   * Creates a &lt;video&gt; element.
   *
   * @return A new VideoElement.
   */
  public static VideoElement video() {
    return factory.video();
  }

  /**
   * Creates a &lt;canvas&gt; element.
   *
   * @return A new CanvasElement.
   */
  public static CanvasElement canvas() {
    return factory.canvas();
  }

  /**
   * Creates an &lt;embed&gt; element.
   *
   * @return A new EmbedElement.
   */
  public static EmbedElement embed() {
    return factory.embed();
  }

  /**
   * Creates an &lt;iframe&gt; element.
   *
   * @return A new IFrameElement.
   */
  public static IFrameElement iframe() {
    return factory.iframe();
  }

  /**
   * Creates an &lt;iframe&gt; element with the specified source URL.
   *
   * @param src The URL of the iframe source.
   * @return A new IFrameElement with the specified source URL.
   */
  public static IFrameElement iframe(String src) {
    return factory.iframe(src);
  }

  /**
   * Creates an &lt;object&gt; element.
   *
   * @return A new ObjectElement.
   */
  public static ObjectElement object() {
    return factory.object();
  }

  /**
   * Creates a &lt;param&gt; element.
   *
   * @return A new ParamElement.
   */
  public static ParamElement param() {
    return factory.param();
  }

  /**
   * Creates a &lt;source&gt; element.
   *
   * @return A new SourceElement.
   */
  public static SourceElement source() {
    return factory.source();
  }

  /**
   * Creates a &lt;noscript&gt; element.
   *
   * @return A new NoScriptElement.
   */
  public static NoScriptElement noscript() {
    return factory.noscript();
  }

  /**
   * Creates a &lt;script&gt; element.
   *
   * @return A new ScriptElement.
   */
  public static ScriptElement script() {
    return factory.script();
  }

  /**
   * Creates a &lt;del&gt; (deleted text) element.
   *
   * @return A new DelElement.
   */
  public static DelElement del() {
    return factory.del();
  }

  /**
   * Creates an &lt;ins&gt; (inserted text) element.
   *
   * @return A new InsElement.
   */
  public static InsElement ins() {
    return factory.ins();
  }

  /**
   * Creates a &lt;caption&gt; (table caption) element.
   *
   * @return A new TableCaptionElement.
   */
  public static TableCaptionElement caption() {
    return factory.caption();
  }

  /**
   * Creates a &lt;col&gt; element.
   *
   * @return A new ColElement.
   */
  public static ColElement col() {
    return factory.col();
  }

  /**
   * Creates a &lt;colgroup&gt; element.
   *
   * @return A new ColGroupElement.
   */
  public static ColGroupElement colgroup() {
    return factory.colgroup();
  }

  /**
   * Creates a &lt;table&gt; element.
   *
   * @return A new TableElement.
   */
  public static TableElement table() {
    return factory.table();
  }

  /**
   * Creates a &lt;tbody&gt; element.
   *
   * @return A new TBodyElement.
   */
  public static TBodyElement tbody() {
    return factory.tbody();
  }

  /**
   * Creates a &lt;td&gt; (table cell) element.
   *
   * @return A new TDElement.
   */
  public static TDElement td() {
    return factory.td();
  }

  /**
   * Creates a &lt;tfoot&gt; element.
   *
   * @return A new TFootElement.
   */
  public static TFootElement tfoot() {
    return factory.tfoot();
  }

  /**
   * Creates a &lt;th&gt; (table header cell) element.
   *
   * @return A new THElement.
   */
  public static THElement th() {
    return factory.th();
  }

  /**
   * Creates a &lt;thead&gt; element.
   *
   * @return A new THeadElement.
   */
  public static THeadElement thead() {
    return factory.thead();
  }

  /**
   * Creates a &lt;tr&gt; (table row) element.
   *
   * @return A new TableRowElement.
   */
  public static TableRowElement tr() {
    return factory.tr();
  }

  /**
   * Creates a &lt;button&gt; element.
   *
   * @return A new ButtonElement.
   */
  public static ButtonElement button() {
    return factory.button();
  }

  /**
   * Creates a &lt;datalist&gt; element.
   *
   * @return A new DataListElement.
   */
  public static DataListElement datalist() {
    return factory.datalist();
  }

  /**
   * Creates a &lt;fieldset&gt; element.
   *
   * @return A new FieldSetElement.
   */
  public static FieldSetElement fieldset() {
    return factory.fieldset();
  }

  /**
   * Creates a &lt;form&gt; element.
   *
   * @return A new FormElement.
   */
  public static FormElement form() {
    return factory.form();
  }

  /**
   * Creates an &lt;input&gt; element with the specified input type.
   *
   * @param type The input type (e.g., "text", "checkbox", "radio", etc.).
   * @return A new InputElement with the specified input type.
   */
  public static InputElement input(InputType type) {
    return factory.input(type);
  }

  /**
   * Creates an &lt;input&gt; element with the specified input type.
   *
   * @param type The input type (e.g., "text", "checkbox", "radio", etc.).
   * @return A new InputElement with the specified input type.
   */
  public static InputElement input(String type) {
    return factory.input(type);
  }

  /**
   * Creates a &lt;label&gt; element.
   *
   * @return A new LabelElement.
   */
  public static LabelElement label() {
    return factory.label();
  }

  /**
   * Creates a &lt;label&gt; element with the specified text.
   *
   * @param text The text content to set in the label.
   * @return A new LabelElement with the specified text content.
   */
  public static LabelElement label(String text) {
    return factory.label(text);
  }

  /**
   * Creates a &lt;legend&gt; element.
   *
   * @return A new LegendElement.
   */
  public static LegendElement legend() {
    return factory.legend();
  }

  /**
   * Creates a &lt;meter&gt; element.
   *
   * @return A new MeterElement.
   */
  public static MeterElement meter() {
    return factory.meter();
  }

  /**
   * Creates an &lt;optgroup&gt; element.
   *
   * @return A new OptGroupElement.
   */
  public static OptGroupElement optgroup() {
    return factory.optgroup();
  }

  /**
   * Creates an &lt;option&gt; element.
   *
   * @return A new OptionElement.
   */
  public static OptionElement option() {
    return factory.option();
  }

  /**
   * Creates an &lt;output&gt; element.
   *
   * @return A new OutputElement.
   */
  public static OutputElement output() {
    return factory.output();
  }

  /**
   * Creates a &lt;progress&gt; element.
   *
   * @return A new ProgressElement.
   */
  public static ProgressElement progress() {
    return factory.progress();
  }

  /**
   * Creates a &lt;select&gt; element.
   *
   * @return A new SelectElement.
   */
  public static SelectElement select_() {
    return factory.select_();
  }

  /**
   * Creates a &lt;textarea&gt; element.
   *
   * @return A new TextAreaElement.
   */
  public static TextAreaElement textarea() {
    return factory.textarea();
  }

  /**
   * Creates an &lt;svg&gt; element.
   *
   * @return A new SvgElement.
   */
  public static SvgElement svg() {
    return factory.svg();
  }

  /**
   * Creates an &lt;svg&gt; element.
   *
   * @param <T> The actual type of the svg element being created
   * @param tag The string tag name for the svg element.
   * @param type The concrete type for the svg element
   * @return A new SvgElement of the specified type.
   */
  public static <T extends SVGElement> T svg(String tag, Class<T> type) {
    return factory.svg(tag, type);
  }

  /**
   * Creates a &lt;circle&gt; element with the specified attributes.
   *
   * @param cx The x-coordinate of the center of the circle.
   * @param cy The y-coordinate of the center of the circle.
   * @param r The radius of the circle.
   * @return A new CircleElement with the specified attributes.
   */
  public static CircleElement circle(double cx, double cy, double r) {
    return factory.circle(cx, cy, r);
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
  public static LineElement line(double x1, double y1, double x2, double y2) {
    return factory.line(x1, y1, x2, y2);
  }

  /**
   * Creates a &lt;text&gt; element.
   *
   * @return A new Text element.
   */
  public static Text text() {
    return factory.text();
  }

  /**
   * Creates a &lt;text&gt; element with the specified content.
   *
   * @param content The text content to set in the text element.
   * @return A new Text element with the specified content.
   */
  public static Text text(String content) {
    return factory.text(content);
  }

  /**
   * Creates an AElement, representing an anchor element in SVG. This element can define a hyperlink
   * to a specified location.
   *
   * @return An instance of AElement.
   */
  public static AElement svgA() {
    return svgElements.svgA();
  }

  /**
   * Creates an AltGlyphDefElement, used in SVG to define alternative glyph definitions.
   *
   * @return An instance of AltGlyphDefElement.
   */
  public static AltGlyphDefElement svgAltGlyphDef() {
    return svgElements.svgAltGlyphDef();
  }

  /**
   * Creates an AltGlyphElement, which allows for advanced glyph substitution in SVG text.
   *
   * @return An instance of AltGlyphElement.
   */
  public static AltGlyphElement svgAltGlyph() {
    return svgElements.svgAltGlyph();
  }

  /**
   * Creates an AltGlyphItemElement, part of SVG's advanced text layout features.
   *
   * @return An instance of AltGlyphItemElement.
   */
  public static AltGlyphItemElement svgAltGlyphItem() {
    return svgElements.svgAltGlyphItem();
  }

  /**
   * Creates an AnimateColorElement for animating color properties in SVG graphics.
   *
   * @return An instance of AnimateColorElement.
   */
  public static AnimateColorElement svgAnimateColor() {
    return svgElements.svgAnimateColor();
  }

  /**
   * Creates an AnimateElement, used in SVG for general-purpose animation of attributes.
   *
   * @return An instance of AnimateElement.
   */
  public static AnimateElement svgAnimate() {
    return svgElements.svgAnimate();
  }

  /**
   * Creates an AnimateMotionElement for animating motion of elements in SVG.
   *
   * @return An instance of AnimateMotionElement.
   */
  public static AnimateMotionElement svgAnimateMotion() {
    return svgElements.svgAnimateMotion();
  }

  /**
   * Creates an AnimateTransformElement for animating transformations in SVG elements.
   *
   * @return An instance of AnimateTransformElement.
   */
  public static AnimateTransformElement svgAnimateTransform() {
    return svgElements.svgAnimateTransform();
  }

  /**
   * Creates an AnimationElement, used for defining animations in SVG.
   *
   * @return An instance of AnimationElement.
   */
  public static AnimationElement svgAnimation() {
    return svgElements.svgAnimation();
  }

  /**
   * Creates a CircleElement, representing a circle in SVG.
   *
   * @return An instance of CircleElement.
   */
  public static CircleElement svgCircle() {
    return svgElements.svgCircle();
  }

  /**
   * Creates a ClipPathElement, used in SVG to define a clipping path.
   *
   * @return An instance of ClipPathElement.
   */
  public static ClipPathElement svgClipPath() {
    return svgElements.svgClipPath();
  }

  /**
   * Creates a ComponentTransferFunctionElement for component-wise remapping of colors in SVG.
   *
   * @return An instance of ComponentTransferFunctionElement.
   */
  public static ComponentTransferFunctionElement svgComponentTransferFunction() {
    return svgElements.svgComponentTransferFunction();
  }

  /**
   * Creates a CursorElement, used in SVG to define a custom cursor.
   *
   * @return An instance of CursorElement.
   */
  public static CursorElement svgCursor() {
    return svgElements.svgCursor();
  }

  /**
   * Creates a DefsElement, used in SVG to define objects for reuse.
   *
   * @return An instance of DefsElement.
   */
  public static DefsElement svgDefs() {
    return svgElements.svgDefs();
  }

  /**
   * Creates a DescElement, providing a description for an SVG container or element.
   *
   * @return An instance of DescElement.
   */
  public static DescElement svgDesc() {
    return svgElements.svgDesc();
  }

  /**
   * Creates an EllipseElement, representing an ellipse in SVG.
   *
   * @return An instance of EllipseElement.
   */
  public static EllipseElement svgEllipse() {
    return svgElements.svgEllipse();
  }

  /**
   * Creates an FEBlendElement for defining blend effects in SVG filters.
   *
   * @return An instance of FEBlendElement.
   */
  public static FEBlendElement svgFeBlend() {
    return svgElements.svgFeBlend();
  }

  /**
   * Creates an FEColorMatrixElement for applying color matrix effects in SVG filters.
   *
   * @return An instance of FEColorMatrixElement.
   */
  public static FEColorMatrixElement svgFeColorMatrix() {
    return svgElements.svgFeColorMatrix();
  }

  /**
   * Creates an FEComponentTransferElement for component-wise reassignment of colors in SVG filters.
   *
   * @return An instance of FEComponentTransferElement.
   */
  public static FEComponentTransferElement svgFeComponentTransfer() {
    return svgElements.svgFeComponentTransfer();
  }

  /**
   * Creates an FECompositeElement, used for compositing operations in SVG filters.
   *
   * @return An instance of FECompositeElement.
   */
  public static FECompositeElement svgFeComposite() {
    return svgElements.svgFeComposite();
  }

  /**
   * Creates an FEConvolveMatrixElement for applying convolution matrix effects in SVG filters.
   *
   * @return An instance of FEConvolveMatrixElement.
   */
  public static FEConvolveMatrixElement svgFeConvolveMatrix() {
    return svgElements.svgFeConvolveMatrix();
  }

  /**
   * Creates an FEDiffuseLightingElement for diffuse lighting effects in SVG filters.
   *
   * @return An instance of FEDiffuseLightingElement.
   */
  public static FEDiffuseLightingElement svgFeDiffuseLighting() {
    return svgElements.svgFeDiffuseLighting();
  }

  /**
   * Creates an FEDisplacementMapElement for displacement mapping in SVG filters.
   *
   * @return An instance of FEDisplacementMapElement.
   */
  public static FEDisplacementMapElement svgFeDisplacementMap() {
    return svgElements.svgFeDisplacementMap();
  }

  /**
   * Creates an FEDistantLightElement for defining distant light sources in SVG filters.
   *
   * @return An instance of FEDistantLightElement.
   */
  public static FEDistantLightElement svgFeDistantLight() {
    return svgElements.svgFeDistantLight();
  }

  /**
   * Creates an FEDropShadowElement for drop shadow effects in SVG.
   *
   * @return An instance of FEDropShadowElement.
   */
  public static FEDropShadowElement svgFeDropShadow() {
    return svgElements.svgFeDropShadow();
  }

  /**
   * Creates an FEFloodElement for flood fill effects in SVG filters.
   *
   * @return An instance of FEFloodElement.
   */
  public static FEFloodElement svgFeFlood() {
    return svgElements.svgFeFlood();
  }

  /**
   * Creates an FEFuncAElement for manipulating the alpha component of a color in SVG filters.
   *
   * @return An instance of FEFuncAElement.
   */
  public static FEFuncAElement svgFeFuncA() {
    return svgElements.svgFeFuncA();
  }

  /**
   * Creates an FEFuncBElement for manipulating the blue component of a color in SVG filters.
   *
   * @return An instance of FEFuncBElement.
   */
  public static FEFuncBElement svgFeFuncB() {
    return svgElements.svgFeFuncB();
  }

  /**
   * Creates an FEFuncGElement for manipulating the green component of a color in SVG filters.
   *
   * @return An instance of FEFuncGElement.
   */
  public static FEFuncGElement svgFeFuncG() {
    return svgElements.svgFeFuncG();
  }

  /**
   * Creates an FEFuncRElement for manipulating the red component of a color in SVG filters.
   *
   * @return An instance of FEFuncRElement.
   */
  public static FEFuncRElement svgFeFuncR() {
    return svgElements.svgFeFuncR();
  }

  /**
   * Creates an FEGaussianBlurElement for Gaussian blur effects in SVG filters.
   *
   * @return An instance of FEGaussianBlurElement.
   */
  public static FEGaussianBlurElement svgFeGaussianBlur() {
    return svgElements.svgFeGaussianBlur();
  }

  /**
   * Creates an FEImageElement for embedding images in SVG filters.
   *
   * @return An instance of FEImageElement.
   */
  public static FEImageElement svgFeImage() {
    return svgElements.svgFeImage();
  }

  /**
   * Creates an FEMergeElement for merging multiple input filters in SVG.
   *
   * @return An instance of FEMergeElement.
   */
  public static FEMergeElement svgFeMerge() {
    return svgElements.svgFeMerge();
  }

  /**
   * Creates an FEMergeNodeElement, representing a single input in an FEMergeElement in SVG filters.
   *
   * @return An instance of FEMergeNodeElement.
   */
  public static FEMergeNodeElement svgFeMergeNode() {
    return svgElements.svgFeMergeNode();
  }

  /**
   * Creates an FEMorphologyElement for applying morphological operations in SVG filters.
   *
   * @return An instance of FEMorphologyElement.
   */
  public static FEMorphologyElement svgFeMorphology() {
    return svgElements.svgFeMorphology();
  }

  /**
   * Creates an FEOffsetElement for applying offset effects in SVG filters.
   *
   * @return An instance of FEOffsetElement.
   */
  public static FEOffsetElement svgFeOffset() {
    return svgElements.svgFeOffset();
  }

  /**
   * Creates an FEPointLightElement for defining a point light source in SVG filters.
   *
   * @return An instance of FEPointLightElement.
   */
  public static FEPointLightElement svgFePointLight() {
    return svgElements.svgFePointLight();
  }

  /**
   * Creates an FESpecularLightingElement for applying specular lighting effects in SVG filters.
   *
   * @return An instance of FESpecularLightingElement.
   */
  public static FESpecularLightingElement svgFeSpecularLighting() {
    return svgElements.svgFeSpecularLighting();
  }

  /**
   * Creates an FESpotLightElement for defining a spot light source in SVG filters.
   *
   * @return An instance of FESpotLightElement.
   */
  public static FESpotLightElement svgFeSpotLight() {
    return svgElements.svgFeSpotLight();
  }

  /**
   * Creates an FETileElement for filling a target rectangle with a tiled pattern in SVG filters.
   *
   * @return An instance of FETileElement.
   */
  public static FETileElement svgFeTile() {
    return svgElements.svgFeTile();
  }

  /**
   * Creates an FETurbulenceElement for creating turbulence effects in SVG filters.
   *
   * @return An instance of FETurbulenceElement.
   */
  public static FETurbulenceElement svgFeTurbulence() {
    return svgElements.svgFeTurbulence();
  }

  /**
   * Creates a FilterElement, a container for SVG filter primitives.
   *
   * @return An instance of FilterElement.
   */
  public static FilterElement svgFilter() {
    return svgElements.svgFilter();
  }

  /**
   * Creates a FontElement for defining a font in SVG.
   *
   * @return An instance of FontElement.
   */
  public static FontElement svgFont() {
    return svgElements.svgFont();
  }

  /**
   * Creates a FontFaceElement for defining font face properties in SVG.
   *
   * @return An instance of FontFaceElement.
   */
  public static FontFaceElement svgFontFace() {
    return svgElements.svgFontFace();
  }

  /**
   * Creates a FontFaceFormatElement for defining font formats in SVG.
   *
   * @return An instance of FontFaceFormatElement.
   */
  public static FontFaceFormatElement svgFontFaceFormat() {
    return svgElements.svgFontFaceFormat();
  }

  /**
   * Creates a FontFaceNameElement for defining font names in SVG.
   *
   * @return An instance of FontFaceNameElement.
   */
  public static FontFaceNameElement svgFontFaceName() {
    return svgElements.svgFontFaceName();
  }

  /**
   * Creates a FontFaceUriElement for defining font URIs in SVG.
   *
   * @return An instance of FontFaceUriElement.
   */
  public static FontFaceUriElement svgFontFaceUri() {
    return svgElements.svgFontFaceUri();
  }

  /**
   * Creates a ForeignObjectElement for embedding external content in SVG.
   *
   * @return An instance of ForeignObjectElement.
   */
  public static ForeignObjectElement svgForeignObject() {
    return svgElements.svgForeignObject();
  }

  /**
   * Creates a GElement, a container used to group SVG elements.
   *
   * @return An instance of GElement.
   */
  public static GElement svgG() {
    return svgElements.svgG();
  }

  /**
   * Creates a GlyphElement for defining glyphs in SVG fonts.
   *
   * @return An instance of GlyphElement.
   */
  public static GlyphElement svgGlyph() {
    return svgElements.svgGlyph();
  }

  /**
   * Creates a GlyphRefElement for referencing a glyph defined elsewhere in SVG fonts.
   *
   * @return An instance of GlyphRefElement.
   */
  public static GlyphRefElement svgGlyphRef() {
    return svgElements.svgGlyphRef();
  }

  /**
   * Creates a GradientElement for defining gradients in SVG.
   *
   * @return An instance of GradientElement.
   */
  public static GradientElement svgGradient() {
    return svgElements.svgGradient();
  }

  /**
   * Creates a GraphicsElement, a base class for SVG graphical elements.
   *
   * @return An instance of GraphicsElement.
   */
  public static GraphicsElement svgGraphics() {
    return svgElements.svgGraphics();
  }

  /**
   * Creates an HKernElement for defining horizontal kerning in SVG fonts.
   *
   * @return An instance of HKernElement.
   */
  public static HKernElement svgHkern() {
    return svgElements.svgHkern();
  }

  /**
   * Creates an ImageElement for embedding images in SVG.
   *
   * @return An instance of ImageElement.
   */
  public static org.dominokit.domino.ui.elements.svg.ImageElement svgImage() {
    return svgElements.svgImage();
  }

  /**
   * Creates a LinearGradientElement for defining linear gradients in SVG.
   *
   * @return An instance of LinearGradientElement.
   */
  public static LinearGradientElement svgLinearGradient() {
    return svgElements.svgLinearGradient();
  }

  /**
   * Creates a LineElement, representing a line in SVG.
   *
   * @return An instance of LineElement.
   */
  public static LineElement svgLine() {
    return svgElements.svgLine();
  }

  /**
   * Creates a MarkerElement for defining marker graphics in SVG.
   *
   * @return An instance of MarkerElement.
   */
  public static MarkerElement svgMarker() {
    return svgElements.svgMarker();
  }

  /**
   * Creates a MaskElement, used for defining an alpha mask in SVG.
   *
   * @return An instance of MaskElement.
   */
  public static MaskElement svgMask() {
    return svgElements.svgMask();
  }

  /**
   * Creates a MetadataElement for embedding metadata within an SVG document.
   *
   * @return An instance of MetadataElement.
   */
  public static MetadataElement svgMetadata() {
    return svgElements.svgMetadata();
  }

  /**
   * Creates a MissingGlyphElement for specifying fallback glyphs in SVG fonts.
   *
   * @return An instance of MissingGlyphElement.
   */
  public static MissingGlyphElement svgMissingGlyph() {
    return svgElements.svgMissingGlyph();
  }

  /**
   * Creates an MPathElement for defining motion paths in SVG animations.
   *
   * @return An instance of MPathElement.
   */
  public static MPathElement svgMpath() {
    return svgElements.svgMpath();
  }

  /**
   * Creates a PathElement, representing a path in SVG.
   *
   * @return An instance of PathElement.
   */
  public static PathElement svgPath() {
    return svgElements.svgPath();
  }

  /**
   * Creates a PatternElement for defining patterns used in fill and stroke operations in SVG.
   *
   * @return An instance of PatternElement.
   */
  public static PatternElement svgPattern() {
    return svgElements.svgPattern();
  }

  /**
   * Creates a PolygonElement, representing a polygon in SVG.
   *
   * @return An instance of PolygonElement.
   */
  public static PolygonElement svgPolygon() {
    return svgElements.svgPolygon();
  }

  /**
   * Creates a PolyLineElement, representing a polyline in SVG.
   *
   * @return An instance of PolyLineElement.
   */
  public static PolyLineElement svgPolyLine() {
    return svgElements.svgPolyLine();
  }

  /**
   * Creates a RadialGradientElement for defining radial gradients in SVG.
   *
   * @return An instance of RadialGradientElement.
   */
  public static RadialGradientElement svgRadialGradient() {
    return svgElements.svgRadialGradient();
  }

  /**
   * Creates a RectElement, representing a rectangle in SVG.
   *
   * @return An instance of RectElement.
   */
  public static RectElement svgRect() {
    return svgElements.svgRect();
  }

  /**
   * Creates a ScriptElement for embedding scripts in SVG documents.
   *
   * @return An instance of ScriptElement.
   */
  public static org.dominokit.domino.ui.elements.svg.ScriptElement svgScript() {
    return svgElements.svgScript();
  }

  /**
   * Creates a SetElement for defining discrete animations in SVG.
   *
   * @return An instance of SetElement.
   */
  public static SetElement svgSet() {
    return svgElements.svgSet();
  }

  /**
   * Creates a StopElement for defining color stops in SVG gradient elements.
   *
   * @return An instance of StopElement.
   */
  public static StopElement svgStop() {
    return svgElements.svgStop();
  }

  /**
   * Creates a StyleElement for embedding style information in SVG documents.
   *
   * @return An instance of StyleElement.
   */
  public static StyleElement svgStyle() {
    return svgElements.svgStyle();
  }

  /**
   * Creates a SwitchElement for conditional processing in SVG documents.
   *
   * @return An instance of SwitchElement.
   */
  public static SwitchElement svgSwitch_() {
    return svgElements.svgSwitch_();
  }

  /**
   * Creates a SymbolElement, used for defining graphical template objects in SVG.
   *
   * @return An instance of SymbolElement.
   */
  public static SymbolElement svgSymbol() {
    return svgElements.svgSymbol();
  }

  /**
   * Creates a TextContentElement, a base class for elements containing text in SVG.
   *
   * @return An instance of TextContentElement.
   */
  public static TextContentElement svgTextContent() {
    return svgElements.svgTextContent();
  }

  /**
   * Creates a TextElement, representing text in SVG.
   *
   * @return An instance of TextElement.
   */
  public static TextElement svgText() {
    return svgElements.svgText();
  }

  /**
   * Creates a TextPathElement for aligning text along a path in SVG.
   *
   * @return An instance of TextPathElement.
   */
  public static TextPathElement svgTextPath() {
    return svgElements.svgTextPath();
  }

  /**
   * Creates a TextPositioningElement for advanced text positioning in SVG.
   *
   * @return An instance of TextPositioningElement.
   */
  public static TextPositioningElement svgTextPositioning() {
    return svgElements.svgTextPositioning();
  }

  /**
   * Creates a TitleElement for adding descriptive titles to SVG elements.
   *
   * @return An instance of TitleElement.
   */
  public static TitleElement svgTitle() {
    return svgElements.svgTitle();
  }

  /**
   * Creates a TRefElement for referencing other text in SVG documents.
   *
   * @return An instance of TRefElement.
   */
  public static TRefElement svgTref() {
    return svgElements.svgTref();
  }

  /**
   * Creates a TSpanElement for defining text spans in SVG text.
   *
   * @return An instance of TSpanElement.
   */
  public static TSpanElement svgTspan() {
    return svgElements.svgTspan();
  }

  /**
   * Creates a UseElement for reusing existing SVG elements.
   *
   * @return An instance of UseElement.
   */
  public static UseElement svgUse() {
    return svgElements.svgUse();
  }

  /**
   * Creates a ViewElement for defining views in SVG.
   *
   * @return An instance of ViewElement.
   */
  public static ViewElement svgView() {
    return svgElements.svgView();
  }

  /**
   * Creates a VKernElement for defining vertical kerning in SVG fonts.
   *
   * @return An instance of VKernElement.
   */
  public static VKernElement svgVkern() {
    return svgElements.svgVkern();
  }
}
