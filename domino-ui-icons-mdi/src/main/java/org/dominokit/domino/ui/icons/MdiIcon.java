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
package org.dominokit.domino.ui.icons;

import static org.dominokit.domino.ui.icons.MdiIconsStyles.*;

import elemental2.dom.DomGlobal;
import elemental2.dom.HTMLElement;
import jsinterop.base.Js;
import org.dominokit.domino.ui.style.BooleanCssClass;
import org.dominokit.domino.ui.style.CssClass;
import org.dominokit.domino.ui.style.HasCssClass;
import org.dominokit.domino.ui.style.SwapCssClass;
import org.dominokit.domino.ui.style.ToggleCssClass;

/** Material Design Icons font renderer. */
public class MdiIcon extends AbstractIcon<MdiIcon> implements CanChangeIcon<MdiIcon> {

  private MdiMeta metaInfo;
  private String mdiName;
  private final SwapCssClass rotateClass = new SwapCssClass();
  private final SwapCssClass contrastClass = new SwapCssClass();

  private MdiIcon(HTMLElement root, String name, MdiMeta metaInfo) {
    super(root, "mdi", name);
    this.mdiName = name;
    this.metaInfo = metaInfo;
    root.classList.add("mdi");
    if (name != null && !name.isEmpty()) {
      root.classList.add(name);
    }
  }

  private MdiIcon(String name, MdiMeta metaInfo) {
    this(createRoot(), name, metaInfo);
  }

  private static HTMLElement createRoot() {
    return Js.cast(DomGlobal.document.createElement("i"));
  }

  public static MdiIcon create() {
    return new MdiIcon("", new MdiMeta(""));
  }

  public static MdiIcon create(String name) {
    String iconName = name == null ? "" : name;
    return new MdiIcon(iconName, new MdiMeta(iconName.replace("mdi-", "")));
  }

  public static MdiIcon create(CssClass icon) {
    return create(icon.getCssClass());
  }

  public static MdiIcon create(String name, MdiMeta meta) {
    return new MdiIcon(name, meta);
  }

  @Override
  public String getName() {
    return mdiName;
  }

  @Override
  public MdiIcon copy() {
    HTMLElement clone = Js.cast(root.cloneNode(false));
    return new MdiIcon(clone, mdiName, metaInfo);
  }

  @Override
  public MdiIcon changeTo(MdiIcon replacement) {
    if (mdiName != null && !mdiName.isEmpty()) {
      root.classList.remove(mdiName);
    }
    mdiName = replacement.mdiName;
    if (mdiName != null && !mdiName.isEmpty()) {
      root.classList.add(mdiName);
    }
    metaInfo = replacement.metaInfo;
    return this;
  }

  public MdiIcon setRotate(MdiRotate rotation) {
    addCss(rotateClass.replaceWith(rotation));
    return this;
  }

  public MdiIcon rotate45() {
    return setRotate(MdiRotate.rotate45);
  }

  public MdiIcon rotate90() {
    return setRotate(MdiRotate.rotate90);
  }

  public MdiIcon rotate135() {
    return setRotate(MdiRotate.rotate135);
  }

  public MdiIcon rotate180() {
    return setRotate(MdiRotate.rotate180);
  }

  public MdiIcon rotate225() {
    return setRotate(MdiRotate.rotate225);
  }

  public MdiIcon rotate270() {
    return setRotate(MdiRotate.rotate270);
  }

  public MdiIcon rotate315() {
    return setRotate(MdiRotate.rotate315);
  }

  public MdiIcon rotateNone() {
    rotateClass.remove(this);
    return this;
  }

  public MdiIcon setFlip(MdiFlip flip) {
    addCss(flip);
    return this;
  }

  public MdiIcon flipV() {
    return setFlip(MdiFlip.flipV);
  }

  public MdiIcon flipH() {
    return setFlip(MdiFlip.flipH);
  }

  public MdiIcon flipNone() {
    mdi_flip_v.remove(this);
    mdi_flip_h.remove(this);
    return this;
  }

  public MdiIcon setSpin(boolean spin) {
    addCss(BooleanCssClass.of(mdi_spin, spin));
    return this;
  }

  public MdiIcon spin() {
    return setSpin(true);
  }

  public MdiIcon noSpin() {
    return setSpin(false);
  }

  public MdiIcon setActive(boolean active) {
    addCss(BooleanCssClass.of(mdi_inactive, !active));
    return this;
  }

  public MdiIcon active() {
    return setActive(true);
  }

  public MdiIcon inactive() {
    return setActive(false);
  }

  public MdiIcon setContrast(MdiContrast contrast) {
    addCss(contrastClass.replaceWith(contrast));
    return this;
  }

  public MdiIcon light() {
    return setContrast(MdiContrast.light);
  }

  public MdiIcon dark() {
    return setContrast(MdiContrast.dark);
  }

  public MdiIcon noContrast() {
    contrastClass.remove(this);
    return this;
  }

  public MdiMeta getMetaInfo() {
    return metaInfo;
  }

  public enum MdiRotate implements HasCssClass {
    rotate45(MdiIconsStyles.mdi_rotate_45),
    rotate90(MdiIconsStyles.mdi_rotate_90),
    rotate135(MdiIconsStyles.mdi_rotate_135),
    rotate180(MdiIconsStyles.mdi_rotate_180),
    rotate225(MdiIconsStyles.mdi_rotate_225),
    rotate270(MdiIconsStyles.mdi_rotate_270),
    rotate315(MdiIconsStyles.mdi_rotate_315);

    private final CssClass style;

    MdiRotate(CssClass style) {
      this.style = style;
    }

    @Override
    public CssClass getCssClass() {
      return style;
    }
  }

  public enum MdiFlip implements HasCssClass {
    flipV(MdiIconsStyles.mdi_flip_v),
    flipH(MdiIconsStyles.mdi_flip_h);

    private final ToggleCssClass style;

    MdiFlip(ToggleCssClass style) {
      this.style = style;
    }

    @Override
    public CssClass getCssClass() {
      return style;
    }
  }

  public enum MdiContrast implements HasCssClass {
    light(MdiIconsStyles.mdi_light),
    dark(MdiIconsStyles.mdi_dark);

    private final CssClass style;

    MdiContrast(CssClass style) {
      this.style = style;
    }

    @Override
    public CssClass getCssClass() {
      return style;
    }
  }
}
