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

import org.dominokit.domino.ui.elements.svg.*;

/**
 * The SVGFactory interface provides methods for creating various SVG elements. This interface
 * serves as a centralized factory for creating all types of SVG elements used within the Domino UI
 * framework.
 */
public interface SVGFactory {
  SVGFactory svgElements = new SVGFactory() {};

  /**
   * Provides access to the delegate that implements the SVGFactory interface.
   *
   * @return An instance of SVGFactoryDelegate.
   */
  default SVGFactoryDelegate delegate() {
    return DominoUIConfig.CONFIG.getSVGFactory();
  }

  /**
   * Creates an AElement, representing an anchor element in SVG. This element can define a hyperlink
   * to a specified location.
   *
   * @return An instance of AElement.
   */
  default AElement svgA() {
    return delegate().a();
  }

  /**
   * Creates an AltGlyphDefElement, used in SVG to define alternative glyph definitions.
   *
   * @return An instance of AltGlyphDefElement.
   */
  default AltGlyphDefElement svgAltGlyphDef() {
    return delegate().altGlyphDef();
  }

  /**
   * Creates an AltGlyphElement, which allows for advanced glyph substitution in SVG text.
   *
   * @return An instance of AltGlyphElement.
   */
  default AltGlyphElement svgAltGlyph() {
    return delegate().altGlyph();
  }

  /**
   * Creates an AltGlyphItemElement, part of SVG's advanced text layout features.
   *
   * @return An instance of AltGlyphItemElement.
   */
  default AltGlyphItemElement svgAltGlyphItem() {
    return delegate().altGlyphItem();
  }

  /**
   * Creates an AnimateColorElement for animating color properties in SVG graphics.
   *
   * @return An instance of AnimateColorElement.
   */
  default AnimateColorElement svgAnimateColor() {
    return delegate().animateColor();
  }

  /**
   * Creates an AnimateElement, used in SVG for general-purpose animation of attributes.
   *
   * @return An instance of AnimateElement.
   */
  default AnimateElement svgAnimate() {
    return delegate().animate();
  }

  /**
   * Creates an AnimateMotionElement for animating motion of elements in SVG.
   *
   * @return An instance of AnimateMotionElement.
   */
  default AnimateMotionElement svgAnimateMotion() {
    return delegate().animateMotion();
  }

  /**
   * Creates an AnimateTransformElement for animating transformations in SVG elements.
   *
   * @return An instance of AnimateTransformElement.
   */
  default AnimateTransformElement svgAnimateTransform() {
    return delegate().animateTransform();
  }

  /**
   * Creates an AnimationElement, used for defining animations in SVG.
   *
   * @return An instance of AnimationElement.
   */
  default AnimationElement svgAnimation() {
    return delegate().animation();
  }

  /**
   * Creates a CircleElement, representing a circle in SVG.
   *
   * @return An instance of CircleElement.
   */
  default CircleElement svgCircle() {
    return delegate().circle();
  }

  /**
   * Creates a ClipPathElement, used in SVG to define a clipping path.
   *
   * @return An instance of ClipPathElement.
   */
  default ClipPathElement svgClipPath() {
    return delegate().clipPath();
  }

  /**
   * Creates a ComponentTransferFunctionElement for component-wise remapping of colors in SVG.
   *
   * @return An instance of ComponentTransferFunctionElement.
   */
  default ComponentTransferFunctionElement svgComponentTransferFunction() {
    return delegate().componentTransferFunction();
  }

  /**
   * Creates a CursorElement, used in SVG to define a custom cursor.
   *
   * @return An instance of CursorElement.
   */
  default CursorElement svgCursor() {
    return delegate().cursor();
  }

  /**
   * Creates a DefsElement, used in SVG to define objects for reuse.
   *
   * @return An instance of DefsElement.
   */
  default DefsElement svgDefs() {
    return delegate().defs();
  }

  /**
   * Creates a DescElement, providing a description for an SVG container or element.
   *
   * @return An instance of DescElement.
   */
  default DescElement svgDesc() {
    return delegate().desc();
  }

  /**
   * Creates an EllipseElement, representing an ellipse in SVG.
   *
   * @return An instance of EllipseElement.
   */
  default EllipseElement svgEllipse() {
    return delegate().ellipse();
  }

  /**
   * Creates an FEBlendElement for defining blend effects in SVG filters.
   *
   * @return An instance of FEBlendElement.
   */
  default FEBlendElement svgFeBlend() {
    return delegate().feBlend();
  }

  /**
   * Creates an FEColorMatrixElement for applying color matrix effects in SVG filters.
   *
   * @return An instance of FEColorMatrixElement.
   */
  default FEColorMatrixElement svgFeColorMatrix() {
    return delegate().feColorMatrix();
  }

  /**
   * Creates an FEComponentTransferElement for component-wise reassignment of colors in SVG filters.
   *
   * @return An instance of FEComponentTransferElement.
   */
  default FEComponentTransferElement svgFeComponentTransfer() {
    return delegate().feComponentTransfer();
  }

  /**
   * Creates an FECompositeElement, used for compositing operations in SVG filters.
   *
   * @return An instance of FECompositeElement.
   */
  default FECompositeElement svgFeComposite() {
    return delegate().feComposite();
  }

  /**
   * Creates an FEConvolveMatrixElement for applying convolution matrix effects in SVG filters.
   *
   * @return An instance of FEConvolveMatrixElement.
   */
  default FEConvolveMatrixElement svgFeConvolveMatrix() {
    return delegate().feConvolveMatrix();
  }

  /**
   * Creates an FEDiffuseLightingElement for diffuse lighting effects in SVG filters.
   *
   * @return An instance of FEDiffuseLightingElement.
   */
  default FEDiffuseLightingElement svgFeDiffuseLighting() {
    return delegate().feDiffuseLighting();
  }

  /**
   * Creates an FEDisplacementMapElement for displacement mapping in SVG filters.
   *
   * @return An instance of FEDisplacementMapElement.
   */
  default FEDisplacementMapElement svgFeDisplacementMap() {
    return delegate().feDisplacementMap();
  }

  /**
   * Creates an FEDistantLightElement for defining distant light sources in SVG filters.
   *
   * @return An instance of FEDistantLightElement.
   */
  default FEDistantLightElement svgFeDistantLight() {
    return delegate().feDistantLight();
  }

  /**
   * Creates an FEDropShadowElement for drop shadow effects in SVG.
   *
   * @return An instance of FEDropShadowElement.
   */
  default FEDropShadowElement svgFeDropShadow() {
    return delegate().feDropShadow();
  }

  /**
   * Creates an FEFloodElement for flood fill effects in SVG filters.
   *
   * @return An instance of FEFloodElement.
   */
  default FEFloodElement svgFeFlood() {
    return delegate().feFlood();
  }

  /**
   * Creates an FEFuncAElement for manipulating the alpha component of a color in SVG filters.
   *
   * @return An instance of FEFuncAElement.
   */
  default FEFuncAElement svgFeFuncA() {
    return delegate().feFuncA();
  }

  /**
   * Creates an FEFuncBElement for manipulating the blue component of a color in SVG filters.
   *
   * @return An instance of FEFuncBElement.
   */
  default FEFuncBElement svgFeFuncB() {
    return delegate().feFuncB();
  }

  /**
   * Creates an FEFuncGElement for manipulating the green component of a color in SVG filters.
   *
   * @return An instance of FEFuncGElement.
   */
  default FEFuncGElement svgFeFuncG() {
    return delegate().feFuncG();
  }

  /**
   * Creates an FEFuncRElement for manipulating the red component of a color in SVG filters.
   *
   * @return An instance of FEFuncRElement.
   */
  default FEFuncRElement svgFeFuncR() {
    return delegate().feFuncR();
  }

  /**
   * Creates an FEGaussianBlurElement for Gaussian blur effects in SVG filters.
   *
   * @return An instance of FEGaussianBlurElement.
   */
  default FEGaussianBlurElement svgFeGaussianBlur() {
    return delegate().feGaussianBlur();
  }

  /**
   * Creates an FEImageElement for embedding images in SVG filters.
   *
   * @return An instance of FEImageElement.
   */
  default FEImageElement svgFeImage() {
    return delegate().feImage();
  }

  /**
   * Creates an FEMergeElement for merging multiple input filters in SVG.
   *
   * @return An instance of FEMergeElement.
   */
  default FEMergeElement svgFeMerge() {
    return delegate().feMerge();
  }

  /**
   * Creates an FEMergeNodeElement, representing a single input in an FEMergeElement in SVG filters.
   *
   * @return An instance of FEMergeNodeElement.
   */
  default FEMergeNodeElement svgFeMergeNode() {
    return delegate().feMergeNode();
  }

  /**
   * Creates an FEMorphologyElement for applying morphological operations in SVG filters.
   *
   * @return An instance of FEMorphologyElement.
   */
  default FEMorphologyElement svgFeMorphology() {
    return delegate().feMorphology();
  }

  /**
   * Creates an FEOffsetElement for applying offset effects in SVG filters.
   *
   * @return An instance of FEOffsetElement.
   */
  default FEOffsetElement svgFeOffset() {
    return delegate().feOffset();
  }

  /**
   * Creates an FEPointLightElement for defining a point light source in SVG filters.
   *
   * @return An instance of FEPointLightElement.
   */
  default FEPointLightElement svgFePointLight() {
    return delegate().fePointLight();
  }

  /**
   * Creates an FESpecularLightingElement for applying specular lighting effects in SVG filters.
   *
   * @return An instance of FESpecularLightingElement.
   */
  default FESpecularLightingElement svgFeSpecularLighting() {
    return delegate().feSpecularLighting();
  }

  /**
   * Creates an FESpotLightElement for defining a spot light source in SVG filters.
   *
   * @return An instance of FESpotLightElement.
   */
  default FESpotLightElement svgFeSpotLight() {
    return delegate().feSpotLight();
  }

  /**
   * Creates an FETileElement for filling a target rectangle with a tiled pattern in SVG filters.
   *
   * @return An instance of FETileElement.
   */
  default FETileElement svgFeTile() {
    return delegate().feTile();
  }

  /**
   * Creates an FETurbulenceElement for creating turbulence effects in SVG filters.
   *
   * @return An instance of FETurbulenceElement.
   */
  default FETurbulenceElement svgFeTurbulence() {
    return delegate().feTurbulence();
  }

  /**
   * Creates a FilterElement, a container for SVG filter primitives.
   *
   * @return An instance of FilterElement.
   */
  default FilterElement svgFilter() {
    return delegate().filter();
  }

  /**
   * Creates a FontElement for defining a font in SVG.
   *
   * @return An instance of FontElement.
   */
  default FontElement svgFont() {
    return delegate().font();
  }

  /**
   * Creates a FontFaceElement for defining font face properties in SVG.
   *
   * @return An instance of FontFaceElement.
   */
  default FontFaceElement svgFontFace() {
    return delegate().fontFace();
  }

  /**
   * Creates a FontFaceFormatElement for defining font formats in SVG.
   *
   * @return An instance of FontFaceFormatElement.
   */
  default FontFaceFormatElement svgFontFaceFormat() {
    return delegate().fontFaceFormat();
  }

  /**
   * Creates a FontFaceNameElement for defining font names in SVG.
   *
   * @return An instance of FontFaceNameElement.
   */
  default FontFaceNameElement svgFontFaceName() {
    return delegate().fontFaceName();
  }

  /**
   * Creates a FontFaceUriElement for defining font URIs in SVG.
   *
   * @return An instance of FontFaceUriElement.
   */
  default FontFaceUriElement svgFontFaceUri() {
    return delegate().fontFaceUri();
  }

  /**
   * Creates a ForeignObjectElement for embedding external content in SVG.
   *
   * @return An instance of ForeignObjectElement.
   */
  default ForeignObjectElement svgForeignObject() {
    return delegate().foreignObject();
  }

  /**
   * Creates a GElement, a container used to group SVG elements.
   *
   * @return An instance of GElement.
   */
  default GElement svgG() {
    return delegate().g();
  }

  /**
   * Creates a GlyphElement for defining glyphs in SVG fonts.
   *
   * @return An instance of GlyphElement.
   */
  default GlyphElement svgGlyph() {
    return delegate().glyph();
  }

  /**
   * Creates a GlyphRefElement for referencing a glyph defined elsewhere in SVG fonts.
   *
   * @return An instance of GlyphRefElement.
   */
  default GlyphRefElement svgGlyphRef() {
    return delegate().glyphRef();
  }

  /**
   * Creates a GradientElement for defining gradients in SVG.
   *
   * @return An instance of GradientElement.
   */
  default GradientElement svgGradient() {
    return delegate().gradient();
  }

  /**
   * Creates a GraphicsElement, a base class for SVG graphical elements.
   *
   * @return An instance of GraphicsElement.
   */
  default GraphicsElement svgGraphics() {
    return delegate().graphics();
  }

  /**
   * Creates an HKernElement for defining horizontal kerning in SVG fonts.
   *
   * @return An instance of HKernElement.
   */
  default HKernElement svgHkern() {
    return delegate().hkern();
  }

  /**
   * Creates an ImageElement for embedding images in SVG.
   *
   * @return An instance of ImageElement.
   */
  default ImageElement svgImage() {
    return delegate().image();
  }

  /**
   * Creates a LinearGradientElement for defining linear gradients in SVG.
   *
   * @return An instance of LinearGradientElement.
   */
  default LinearGradientElement svgLinearGradient() {
    return delegate().linearGradient();
  }

  /**
   * Creates a LineElement, representing a line in SVG.
   *
   * @return An instance of LineElement.
   */
  default LineElement svgLine() {
    return delegate().line();
  }

  /**
   * Creates a MarkerElement for defining marker graphics in SVG.
   *
   * @return An instance of MarkerElement.
   */
  default MarkerElement svgMarker() {
    return delegate().marker();
  }

  /**
   * Creates a MaskElement, used for defining an alpha mask in SVG.
   *
   * @return An instance of MaskElement.
   */
  default MaskElement svgMask() {
    return delegate().mask();
  }

  /**
   * Creates a MetadataElement for embedding metadata within an SVG document.
   *
   * @return An instance of MetadataElement.
   */
  default MetadataElement svgMetadata() {
    return delegate().metadata();
  }

  /**
   * Creates a MissingGlyphElement for specifying fallback glyphs in SVG fonts.
   *
   * @return An instance of MissingGlyphElement.
   */
  default MissingGlyphElement svgMissingGlyph() {
    return delegate().missingGlyph();
  }

  /**
   * Creates an MPathElement for defining motion paths in SVG animations.
   *
   * @return An instance of MPathElement.
   */
  default MPathElement svgMpath() {
    return delegate().mpath();
  }

  /**
   * Creates a PathElement, representing a path in SVG.
   *
   * @return An instance of PathElement.
   */
  default PathElement svgPath() {
    return delegate().path();
  }

  /**
   * Creates a PatternElement for defining patterns used in fill and stroke operations in SVG.
   *
   * @return An instance of PatternElement.
   */
  default PatternElement svgPattern() {
    return delegate().pattern();
  }

  /**
   * Creates a PolygonElement, representing a polygon in SVG.
   *
   * @return An instance of PolygonElement.
   */
  default PolygonElement svgPolygon() {
    return delegate().polygon();
  }

  /**
   * Creates a PolyLineElement, representing a polyline in SVG.
   *
   * @return An instance of PolyLineElement.
   */
  default PolyLineElement svgPolyLine() {
    return delegate().polyLine();
  }

  /**
   * Creates a RadialGradientElement for defining radial gradients in SVG.
   *
   * @return An instance of RadialGradientElement.
   */
  default RadialGradientElement svgRadialGradient() {
    return delegate().radialGradient();
  }

  /**
   * Creates a RectElement, representing a rectangle in SVG.
   *
   * @return An instance of RectElement.
   */
  default RectElement svgRect() {
    return delegate().rect();
  }

  /**
   * Creates a ScriptElement for embedding scripts in SVG documents.
   *
   * @return An instance of ScriptElement.
   */
  default ScriptElement svgScript() {
    return delegate().script();
  }

  /**
   * Creates a SetElement for defining discrete animations in SVG.
   *
   * @return An instance of SetElement.
   */
  default SetElement svgSet() {
    return delegate().set();
  }

  /**
   * Creates a StopElement for defining color stops in SVG gradient elements.
   *
   * @return An instance of StopElement.
   */
  default StopElement svgStop() {
    return delegate().stop();
  }

  /**
   * Creates a StyleElement for embedding style information in SVG documents.
   *
   * @return An instance of StyleElement.
   */
  default StyleElement svgStyle() {
    return delegate().style();
  }

  /**
   * Creates a SwitchElement for conditional processing in SVG documents.
   *
   * @return An instance of SwitchElement.
   */
  default SwitchElement svgSwitch_() {
    return delegate().switch_();
  }

  /**
   * Creates a SymbolElement, used for defining graphical template objects in SVG.
   *
   * @return An instance of SymbolElement.
   */
  default SymbolElement svgSymbol() {
    return delegate().symbol();
  }

  /**
   * Creates a TextContentElement, a base class for elements containing text in SVG.
   *
   * @return An instance of TextContentElement.
   */
  default TextContentElement svgTextContent() {
    return delegate().textContent();
  }

  /**
   * Creates a TextElement, representing text in SVG.
   *
   * @return An instance of TextElement.
   */
  default TextElement svgText() {
    return delegate().text();
  }

  /**
   * Creates a TextPathElement for aligning text along a path in SVG.
   *
   * @return An instance of TextPathElement.
   */
  default TextPathElement svgTextPath() {
    return delegate().textPath();
  }

  /**
   * Creates a TextPositioningElement for advanced text positioning in SVG.
   *
   * @return An instance of TextPositioningElement.
   */
  default TextPositioningElement svgTextPositioning() {
    return delegate().textPositioning();
  }

  /**
   * Creates a TitleElement for adding descriptive titles to SVG elements.
   *
   * @return An instance of TitleElement.
   */
  default TitleElement svgTitle() {
    return delegate().title();
  }

  /**
   * Creates a TRefElement for referencing other text in SVG documents.
   *
   * @return An instance of TRefElement.
   */
  default TRefElement svgTref() {
    return delegate().tref();
  }

  /**
   * Creates a TSpanElement for defining text spans in SVG text.
   *
   * @return An instance of TSpanElement.
   */
  default TSpanElement svgTspan() {
    return delegate().tspan();
  }

  /**
   * Creates a UseElement for reusing existing SVG elements.
   *
   * @return An instance of UseElement.
   */
  default UseElement svgUse() {
    return delegate().use();
  }

  /**
   * Creates a ViewElement for defining views in SVG.
   *
   * @return An instance of ViewElement.
   */
  default ViewElement svgView() {
    return delegate().view();
  }

  /**
   * Creates a VKernElement for defining vertical kerning in SVG fonts.
   *
   * @return An instance of VKernElement.
   */
  default VKernElement svgVkern() {
    return delegate().vkern();
  }
}
