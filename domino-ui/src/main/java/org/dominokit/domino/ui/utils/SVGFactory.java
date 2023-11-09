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

import elemental2.svg.*;
import org.dominokit.domino.ui.elements.svg.*;

public interface SVGFactory {
  SVGFactory elements = new SVGFactory() {};

  /**
   * Provides access to the delegate that implements the SVGFactory interface.
   *
   * @return An instance of SVGFactoryDelegate.
   */
  default SVGFactoryDelegate delegate() {
    return DominoUIConfig.CONFIG.getSVGFactory();
  }

  default AElement a() {
    return delegate().a();
  }

  default AltGlyphDefElement altGlyphDef() {
    return delegate().altGlyphDef();
  }

  default AltGlyphElement altGlyph() {
    return delegate().altGlyph();
  }

  default AltGlyphItemElement altGlyphItem() {
    return delegate().altGlyphItem();
  }

  default AnimateColorElement animateColor() {
    return delegate().animateColor();
  }

  default AnimateElement animate() {
    return delegate().animate();
  }

  default AnimateMotionElement animateMotion() {
    return delegate().animateMotion();
  }

  default AnimateTransformElement animateTransform() {
    return delegate().animateTransform();
  }

  default AnimationElement animation() {
    return delegate().animation();
  }

  default CircleElement circle() {
    return delegate().circle();
  }

  default ClipPathElement clipPath() {
    return delegate().clipPath();
  }

  default ComponentTransferFunctionElement componentTransferFunction() {
    return delegate().componentTransferFunction();
  }

  default CursorElement cursor() {
    return delegate().cursor();
  }

  default DefsElement defs() {
    return delegate().defs();
  }

  default DescElement desc() {
    return delegate().desc();
  }

  default EllipseElement ellipse() {
    return delegate().ellipse();
  }

  default FEBlendElement feBlend() {
    return delegate().feBlend();
  }

  default FEColorMatrixElement feColorMatrix() {
    return delegate().feColorMatrix();
  }

  default FEComponentTransferElement feComponentTransfer() {
    return delegate().feComponentTransfer();
  }

  default FECompositeElement feComposite() {
    return delegate().feComposite();
  }

  default FEConvolveMatrixElement feConvolveMatrix() {
    return delegate().feConvolveMatrix();
  }

  default FEDiffuseLightingElement feDiffuseLighting() {
    return delegate().feDiffuseLighting();
  }

  default FEDisplacementMapElement feDisplacementMap() {
    return delegate().feDisplacementMap();
  }

  default FEDistantLightElement feDistantLight() {
    return delegate().feDistantLight();
  }

  default FEDropShadowElement feDropShadow() {
    return delegate().feDropShadow();
  }

  default FEFloodElement feFlood() {
    return delegate().feFlood();
  }

  default FEFuncAElement feFuncA() {
    return delegate().feFuncA();
  }

  default FEFuncBElement feFuncB() {
    return delegate().feFuncB();
  }

  default FEFuncGElement feFuncG() {
    return delegate().feFuncG();
  }

  default FEFuncRElement feFuncR() {
    return delegate().feFuncR();
  }

  default FEGaussianBlurElement feGaussianBlur() {
    return delegate().feGaussianBlur();
  }

  default FEImageElement feImage() {
    return delegate().feImage();
  }

  default FEMergeElement feMerge() {
    return delegate().feMerge();
  }

  default FEMergeNodeElement feMergeNode() {
    return delegate().feMergeNode();
  }

  default FEMorphologyElement feMorphology() {
    return delegate().feMorphology();
  }

  default FEOffsetElement feOffset() {
    return delegate().feOffset();
  }

  default FEPointLightElement fePointLight() {
    return delegate().fePointLight();
  }

  default FESpecularLightingElement feSpecularLighting() {
    return delegate().feSpecularLighting();
  }

  default FESpotLightElement feSpotLight() {
    return delegate().feSpotLight();
  }

  default FETileElement feTile() {
    return delegate().feTile();
  }

  default FETurbulenceElement feTurbulence() {
    return delegate().feTurbulence();
  }

  default FilterElement filter() {
    return delegate().filter();
  }

  default FontElement font() {
    return delegate().font();
  }

  default FontFaceElement fontFace() {
    return delegate().fontFace();
  }

  default FontFaceFormatElement fontFaceFormat() {
    return delegate().fontFaceFormat();
  }

  default FontFaceNameElement fontFaceName() {
    return delegate().fontFaceName();
  }

  default FontFaceUriElement fontFaceUri() {
    return delegate().fontFaceUri();
  }

  default ForeignObjectElement foreignObject() {
    return delegate().foreignObject();
  }

  default GElement g() {
    return delegate().g();
  }

  default GlyphElement glyph() {
    return delegate().glyph();
  }

  default GlyphRefElement glyphRef() {
    return delegate().glyphRef();
  }

  default GradientElement gradient() {
    return delegate().gradient();
  }

  default GraphicsElement graphics() {
    return delegate().graphics();
  }

  default HKernElement hkern() {
    return delegate().hkern();
  }

  default ImageElement image() {
    return delegate().image();
  }

  default LinearGradientElement linearGradient() {
    return delegate().linearGradient();
  }

  default LineElement line() {
    return delegate().line();
  }

  default MarkerElement marker() {
    return delegate().marker();
  }

  default MaskElement mask() {
    return delegate().mask();
  }

  default MetadataElement metadata() {
    return delegate().metadata();
  }

  default MissingGlyphElement missingGlyph() {
    return delegate().missingGlyph();
  }

  default MPathElement mpath() {
    return delegate().mpath();
  }

  default PathElement path() {
    return delegate().path();
  }

  default PatternElement pattern() {
    return delegate().pattern();
  }

  default PolygonElement polygon() {
    return delegate().polygon();
  }

  default PolyLineElement polyLine() {
    return delegate().polyLine();
  }

  default RadialGradientElement radialGradient() {
    return delegate().radialGradient();
  }

  default RectElement rect() {
    return delegate().rect();
  }

  default ScriptElement script() {
    return delegate().script();
  }

  default SetElement set() {
    return delegate().set();
  }

  default StopElement stop() {
    return delegate().stop();
  }

  default StyleElement style() {
    return delegate().style();
  }

  default SwitchElement switch_() {
    return delegate().switch_();
  }

  default SymbolElement symbol() {
    return delegate().symbol();
  }

  default TextContentElement textContent() {
    return delegate().textContent();
  }

  default TextElement text() {
    return delegate().text();
  }

  default TextPathElement textPath() {
    return delegate().textPath();
  }

  default TextPositioningElement textPositioning() {
    return delegate().textPositioning();
  }

  default TitleElement title() {
    return delegate().title();
  }

  default TRefElement tref() {
    return delegate().tref();
  }

  default TSpanElement tspan() {
    return delegate().tspan();
  }

  default UseElement use() {
    return delegate().use();
  }

  default ViewElement view() {
    return delegate().view();
  }

  default VKernElement vkern() {
    return delegate().vkern();
  }
}
