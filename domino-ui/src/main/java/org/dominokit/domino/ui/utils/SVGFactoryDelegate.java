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

import static org.dominokit.domino.ui.utils.DomElements.dom;

import elemental2.svg.*;
import org.dominokit.domino.ui.elements.svg.*;

public interface SVGFactoryDelegate {

  default AElement a() {
    return AElement.of(dom.createSVG("a", SVGAElement.class));
  }

  default AltGlyphDefElement altGlyphDef() {
    return AltGlyphDefElement.of(dom.createSVG("altGlyphDef", SVGAltGlyphDefElement.class));
  }

  default AltGlyphElement altGlyph() {
    return AltGlyphElement.of(dom.createSVG("altGlyph", SVGAltGlyphElement.class));
  }

  default AltGlyphItemElement altGlyphItem() {
    return AltGlyphItemElement.of(dom.createSVG("altGlyphItem", SVGAltGlyphItemElement.class));
  }

  default AnimateColorElement animateColor() {
    return AnimateColorElement.of(dom.createSVG("animateColor", SVGAnimateColorElement.class));
  }

  default AnimateElement animate() {
    return AnimateElement.of(dom.createSVG("animate", SVGAnimateElement.class));
  }

  default AnimateMotionElement animateMotion() {
    return AnimateMotionElement.of(dom.createSVG("animateMotion", SVGAnimateMotionElement.class));
  }

  default AnimateTransformElement animateTransform() {
    return AnimateTransformElement.of(
        dom.createSVG("animateTransform", SVGAnimateTransformElement.class));
  }

  default AnimationElement animation() {
    return AnimationElement.of(dom.createSVG("animation", SVGAnimationElement.class));
  }

  default CircleElement circle() {
    return CircleElement.of(dom.createSVG("circle", SVGCircleElement.class));
  }

  default ClipPathElement clipPath() {
    return ClipPathElement.of(dom.createSVG("clipPath", SVGClipPathElement.class));
  }

  default ComponentTransferFunctionElement componentTransferFunction() {
    return ComponentTransferFunctionElement.of(
        dom.createSVG("componentTransferFunction", SVGComponentTransferFunctionElement.class));
  }

  default CursorElement cursor() {
    return CursorElement.of(dom.createSVG("cursor", SVGCursorElement.class));
  }

  default DefsElement defs() {
    return DefsElement.of(dom.createSVG("defs", SVGDefsElement.class));
  }

  default DescElement desc() {
    return DescElement.of(dom.createSVG("desc", SVGDescElement.class));
  }

  default EllipseElement ellipse() {
    return EllipseElement.of(dom.createSVG("ellipse", SVGEllipseElement.class));
  }

  default FEBlendElement feBlend() {
    return FEBlendElement.of(dom.createSVG("feBlend", SVGFEBlendElement.class));
  }

  default FEColorMatrixElement feColorMatrix() {
    return FEColorMatrixElement.of(dom.createSVG("feColorMatrix", SVGFEColorMatrixElement.class));
  }

  default FEComponentTransferElement feComponentTransfer() {
    return FEComponentTransferElement.of(
        dom.createSVG("feComponentTransfer", SVGFEComponentTransferElement.class));
  }

  default FECompositeElement feComposite() {
    return FECompositeElement.of(dom.createSVG("feComposite", SVGFECompositeElement.class));
  }

  default FEConvolveMatrixElement feConvolveMatrix() {
    return FEConvolveMatrixElement.of(
        dom.createSVG("feConvolveMatrix", SVGFEConvolveMatrixElement.class));
  }

  default FEDiffuseLightingElement feDiffuseLighting() {
    return FEDiffuseLightingElement.of(
        dom.createSVG("feDiffuseLighting", SVGFEDiffuseLightingElement.class));
  }

  default FEDisplacementMapElement feDisplacementMap() {
    return FEDisplacementMapElement.of(
        dom.createSVG("feDisplacementMap", SVGFEDisplacementMapElement.class));
  }

  default FEDistantLightElement feDistantLight() {
    return FEDistantLightElement.of(
        dom.createSVG("feDistantLight", SVGFEDistantLightElement.class));
  }

  default FEDropShadowElement feDropShadow() {
    return FEDropShadowElement.of(dom.createSVG("feDropShadow", SVGFEDropShadowElement.class));
  }

  default FEFloodElement feFlood() {
    return FEFloodElement.of(dom.createSVG("feFlood", SVGFEFloodElement.class));
  }

  default FEFuncAElement feFuncA() {
    return FEFuncAElement.of(dom.createSVG("feFuncA", SVGFEFuncAElement.class));
  }

  default FEFuncBElement feFuncB() {
    return FEFuncBElement.of(dom.createSVG("feFuncB", SVGFEFuncBElement.class));
  }

  default FEFuncGElement feFuncG() {
    return FEFuncGElement.of(dom.createSVG("feFuncG", SVGFEFuncGElement.class));
  }

  default FEFuncRElement feFuncR() {
    return FEFuncRElement.of(dom.createSVG("feFuncR", SVGFEFuncRElement.class));
  }

  default FEGaussianBlurElement feGaussianBlur() {
    return FEGaussianBlurElement.of(
        dom.createSVG("feGaussianBlur", SVGFEGaussianBlurElement.class));
  }

  default FEImageElement feImage() {
    return FEImageElement.of(dom.createSVG("feImage", SVGFEImageElement.class));
  }

  default FEMergeElement feMerge() {
    return FEMergeElement.of(dom.createSVG("feMerge", SVGFEMergeElement.class));
  }

  default FEMergeNodeElement feMergeNode() {
    return FEMergeNodeElement.of(dom.createSVG("feMergeNode", SVGFEMergeNodeElement.class));
  }

  default FEMorphologyElement feMorphology() {
    return FEMorphologyElement.of(dom.createSVG("feMorphology", SVGFEMorphologyElement.class));
  }

  default FEOffsetElement feOffset() {
    return FEOffsetElement.of(dom.createSVG("feOffset", SVGFEOffsetElement.class));
  }

  default FEPointLightElement fePointLight() {
    return FEPointLightElement.of(dom.createSVG("fePointLight", SVGFEPointLightElement.class));
  }

  default FESpecularLightingElement feSpecularLighting() {
    return FESpecularLightingElement.of(
        dom.createSVG("feSpecularLighting", SVGFESpecularLightingElement.class));
  }

  default FESpotLightElement feSpotLight() {
    return FESpotLightElement.of(dom.createSVG("feSpotLight", SVGFESpotLightElement.class));
  }

  default FETileElement feTile() {
    return FETileElement.of(dom.createSVG("feTile", SVGFETileElement.class));
  }

  default FETurbulenceElement feTurbulence() {
    return FETurbulenceElement.of(dom.createSVG("feTurbulence", SVGFETurbulenceElement.class));
  }

  default FilterElement filter() {
    return FilterElement.of(dom.createSVG("filter", SVGFilterElement.class));
  }

  default FontElement font() {
    return FontElement.of(dom.createSVG("font", SVGFontElement.class));
  }

  default FontFaceElement fontFace() {
    return FontFaceElement.of(dom.createSVG("fontFace", SVGFontFaceElement.class));
  }

  default FontFaceFormatElement fontFaceFormat() {
    return FontFaceFormatElement.of(
        dom.createSVG("fontFaceFormat", SVGFontFaceFormatElement.class));
  }

  default FontFaceNameElement fontFaceName() {
    return FontFaceNameElement.of(dom.createSVG("fontFaceName", SVGFontFaceNameElement.class));
  }

  default FontFaceUriElement fontFaceUri() {
    return FontFaceUriElement.of(dom.createSVG("fontFaceUri", SVGFontFaceUriElement.class));
  }

  default ForeignObjectElement foreignObject() {
    return ForeignObjectElement.of(dom.createSVG("foreignObject", SVGForeignObjectElement.class));
  }

  default GElement g() {
    return GElement.of(dom.createSVG("g", SVGGElement.class));
  }

  default GlyphElement glyph() {
    return GlyphElement.of(dom.createSVG("glyph", SVGGlyphElement.class));
  }

  default GlyphRefElement glyphRef() {
    return GlyphRefElement.of(dom.createSVG("glyphRef", SVGGlyphRefElement.class));
  }

  default GradientElement gradient() {
    return GradientElement.of(dom.createSVG("gradient", SVGGradientElement.class));
  }

  default GraphicsElement graphics() {
    return GraphicsElement.of(dom.createSVG("graphics", SVGGraphicsElement.class));
  }

  default HKernElement hkern() {
    return HKernElement.of(dom.createSVG("hkern", SVGHKernElement.class));
  }

  default ImageElement image() {
    return ImageElement.of(dom.createSVG("image", SVGImageElement.class));
  }

  default LinearGradientElement linearGradient() {
    return LinearGradientElement.of(
        dom.createSVG("linearGradient", SVGLinearGradientElement.class));
  }

  default LineElement line() {
    return LineElement.of(dom.createSVG("line", SVGLineElement.class));
  }

  default MarkerElement marker() {
    return MarkerElement.of(dom.createSVG("marker", SVGMarkerElement.class));
  }

  default MaskElement mask() {
    return MaskElement.of(dom.createSVG("mask", SVGMaskElement.class));
  }

  default MetadataElement metadata() {
    return MetadataElement.of(dom.createSVG("metadata", SVGMetadataElement.class));
  }

  default MissingGlyphElement missingGlyph() {
    return MissingGlyphElement.of(dom.createSVG("missingGlyph", SVGMissingGlyphElement.class));
  }

  default MPathElement mpath() {
    return MPathElement.of(dom.createSVG("MPath", SVGMPathElement.class));
  }

  default PathElement path() {
    return PathElement.of(dom.createSVG("path", SVGPathElement.class));
  }

  default PatternElement pattern() {
    return PatternElement.of(dom.createSVG("pattern", SVGPatternElement.class));
  }

  default PolygonElement polygon() {
    return PolygonElement.of(dom.createSVG("polygon", SVGPolygonElement.class));
  }

  default PolyLineElement polyLine() {
    return PolyLineElement.of(dom.createSVG("polyline", SVGPolylineElement.class));
  }

  default RadialGradientElement radialGradient() {
    return RadialGradientElement.of(
        dom.createSVG("radialGradient", SVGRadialGradientElement.class));
  }

  default RectElement rect() {
    return RectElement.of(dom.createSVG("rect", SVGRectElement.class));
  }

  default ScriptElement script() {
    return ScriptElement.of(dom.createSVG("script", SVGScriptElement.class));
  }

  default SetElement set() {
    return SetElement.of(dom.createSVG("set", SVGSetElement.class));
  }

  default StopElement stop() {
    return StopElement.of(dom.createSVG("stop", SVGStopElement.class));
  }

  default StyleElement style() {
    return StyleElement.of(dom.createSVG("style", SVGStyleElement.class));
  }

  default SwitchElement switch_() {
    return SwitchElement.of(dom.createSVG("switch", SVGSwitchElement.class));
  }

  default SymbolElement symbol() {
    return SymbolElement.of(dom.createSVG("symbol", SVGSymbolElement.class));
  }

  default TextContentElement textContent() {
    return TextContentElement.of(dom.createSVG("textContent", SVGTextContentElement.class));
  }

  default TextElement text() {
    return TextElement.of(dom.createSVG("text", SVGTextElement.class));
  }

  default TextPathElement textPath() {
    return TextPathElement.of(dom.createSVG("textPath", SVGTextPathElement.class));
  }

  default TextPositioningElement textPositioning() {
    return TextPositioningElement.of(
        dom.createSVG("textPositioning", SVGTextPositioningElement.class));
  }

  default TitleElement title() {
    return TitleElement.of(dom.createSVG("title", SVGTitleElement.class));
  }

  default TRefElement tref() {
    return TRefElement.of(dom.createSVG("tref", SVGTRefElement.class));
  }

  default TSpanElement tspan() {
    return TSpanElement.of(dom.createSVG("tspan", SVGTSpanElement.class));
  }

  default UseElement use() {
    return UseElement.of(dom.createSVG("use", SVGUseElement.class));
  }

  default ViewElement view() {
    return ViewElement.of(dom.createSVG("view", SVGViewElement.class));
  }

  default VKernElement vkern() {
    return VKernElement.of(dom.createSVG("vkern", SVGVKernElement.class));
  }
}
