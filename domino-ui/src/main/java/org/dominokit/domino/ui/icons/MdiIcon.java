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

import static java.util.Objects.nonNull;
import static org.jboss.elemento.Elements.i;

import elemental2.dom.HTMLElement;
import org.dominokit.domino.ui.utils.DominoElement;

/** <a href="https://materialdesignicons.com/">MDI</a> icons implementation */
public class MdiIcon extends BaseIcon<MdiIcon> {
  private MdiSize mdiSize;
  private MdiRotate mdiRotate;
  private MdiFlip mdiFlip;
  private MdiContrast mdiContrast;

  private MdiMeta metaInfo;

  private MdiIcon(HTMLElement icon) {
    this.icon = DominoElement.of(icon);
    init(this);
    size24();
  }

  private MdiIcon(String icon) {
    this(icon, new MdiMeta(icon.replace("mdi-", "")));
  }

  private MdiIcon(String icon, MdiMeta mdiMeta) {
    this.icon = DominoElement.of(i().css("mdi").css(icon).element());
    this.name = icon;
    this.metaInfo = mdiMeta;
    init(this);
    size24();
  }

  /**
   * Creates a new icon
   *
   * @param icon the name of the icon
   * @return new instance
   */
  public static MdiIcon create(String icon) {
    return new MdiIcon(icon);
  }

  /**
   * Creates a new icon with meta
   *
   * @param icon the icon name
   * @param meta the {@link MdiMeta}
   * @return new instance
   */
  public static MdiIcon create(String icon, MdiMeta meta) {
    return new MdiIcon(icon, meta);
  }

  /** {@inheritDoc} */
  @Override
  public MdiIcon copy() {
    return MdiIcon.create(this.getName()).setColor(this.color);
  }

  /** {@inheritDoc} */
  @Override
  protected MdiIcon doToggle() {
    if (nonNull(toggleName)) {
      if (this.style().containsCss(originalName)) {
        this.style().removeCss(originalName);
        this.style().addCss(toggleName);
      } else {
        this.style().addCss(originalName);
        this.style().removeCss(toggleName);
      }
    }
    return this;
  }

  /** {@inheritDoc} */
  @Override
  public MdiIcon changeTo(BaseIcon<MdiIcon> icon) {
    removeCss(getName());
    addCss(icon.getName());
    return this;
  }

  /**
   * Sets the size of the icon
   *
   * @param mdiSize the {@link MdiSize}
   * @return same instance
   */
  public MdiIcon setSize(MdiSize mdiSize) {
    if (nonNull(this.mdiSize)) {
      removeCss(this.mdiSize.getStyle());
    }
    this.mdiSize = mdiSize;
    addCss(this.mdiSize.getStyle());
    return this;
  }

  /**
   * Sets the size to 18 px
   *
   * @return same instance
   */
  public MdiIcon size18() {
    return setSize(MdiSize.mdi18);
  }

  /**
   * Sets the size to 24 px
   *
   * @return same instance
   */
  public MdiIcon size24() {
    return setSize(MdiSize.mdi24);
  }

  /**
   * Sets the size to 36 px
   *
   * @return same instance
   */
  public MdiIcon size36() {
    return setSize(MdiSize.mdi36);
  }

  /**
   * Sets the size to 48 px
   *
   * @return same instance
   */
  public MdiIcon size48() {
    return setSize(MdiSize.mdi48);
  }

  /**
   * Sets the size to the default
   *
   * @return same instance
   */
  public MdiIcon sizeNone() {
    if (nonNull(this.mdiSize)) {
      removeCss(this.mdiSize.getStyle());
    }
    return this;
  }

  /**
   * Sets the type of rotate applied to the icon
   *
   * @param mdiRotate the {@link MdiRotate}
   * @return same instance
   */
  public MdiIcon setRotate(MdiRotate mdiRotate) {
    if (nonNull(this.mdiRotate)) {
      removeCss(this.mdiRotate.getStyle());
    }
    this.mdiRotate = mdiRotate;
    addCss(this.mdiRotate.getStyle());
    return this;
  }

  /**
   * Rotates the icon with 45 degrees
   *
   * @return same instance
   */
  public MdiIcon rotate45() {
    return setRotate(MdiRotate.rotate45);
  }

  /**
   * Rotates the icon with 90 degrees
   *
   * @return same instance
   */
  public MdiIcon rotate90() {
    return setRotate(MdiRotate.rotate90);
  }

  /**
   * Rotates the icon with 135 degrees
   *
   * @return same instance
   */
  public MdiIcon rotate135() {
    return setRotate(MdiRotate.rotate135);
  }

  /**
   * Rotates the icon with 180 degrees
   *
   * @return same instance
   */
  public MdiIcon rotate180() {
    return setRotate(MdiRotate.rotate180);
  }

  /**
   * Rotates the icon with 225 degrees
   *
   * @return same instance
   */
  public MdiIcon rotate225() {
    return setRotate(MdiRotate.rotate225);
  }

  /**
   * Rotates the icon with 270 degrees
   *
   * @return same instance
   */
  public MdiIcon rotate270() {
    return setRotate(MdiRotate.rotate270);
  }

  /**
   * Rotates the icon with 315 degrees
   *
   * @return same instance
   */
  public MdiIcon rotate315() {
    return setRotate(MdiRotate.rotate315);
  }

  /**
   * Sets the rotate to the default value
   *
   * @return same instance
   */
  public MdiIcon rotateNone() {
    if (nonNull(this.mdiRotate)) {
      removeCss(this.mdiRotate.getStyle());
    }
    return this;
  }

  /**
   * Flips the icon either horizontally or vertically
   *
   * @param mdiFlip the {@link MdiFlip}
   * @return same instance
   */
  public MdiIcon setFlip(MdiFlip mdiFlip) {
    if (nonNull(this.mdiFlip)) {
      removeCss(this.mdiFlip.getStyle());
    }
    this.mdiFlip = mdiFlip;
    addCss(this.mdiFlip.getStyle());
    return this;
  }

  /**
   * Flips the icon vertically
   *
   * @return same instance
   */
  public MdiIcon flipV() {
    return setFlip(MdiFlip.flipV);
  }

  /**
   * Flips the icon horizontally
   *
   * @return same instance
   */
  public MdiIcon flipH() {
    return setFlip(MdiFlip.flipH);
  }

  /**
   * Removes the flip
   *
   * @return same instance
   */
  public MdiIcon flipNone() {
    if (nonNull(this.mdiFlip)) {
      removeCss(this.mdiFlip.getStyle());
    }
    return this;
  }

  /**
   * Sets if the icon should spin
   *
   * @param spin true to spin the icon, false otherwise
   * @return same instance
   */
  public MdiIcon setSpin(boolean spin) {
    removeCss("mdi-spin");
    if (spin) {
      addCss("mdi-spin");
    }

    return this;
  }

  /**
   * Spins the icon
   *
   * @return same instance
   */
  public MdiIcon spin() {
    return setSpin(true);
  }

  /**
   * Removes the spinning of the icon
   *
   * @return same instance
   */
  public MdiIcon noSpin() {
    return setSpin(false);
  }

  /**
   * Sets if the icon is active or not
   *
   * @param active true to activate the icon, false otherwise
   * @return same instance
   */
  public MdiIcon setActive(boolean active) {
    removeCss("mdi-inactive");
    if (!active) {
      addCss("mdi-inactive");
    }

    return this;
  }

  /**
   * Activate the icon
   *
   * @return same instance
   */
  public MdiIcon active() {
    return setActive(true);
  }

  /**
   * Marks the icon as inactive
   *
   * @return same instance
   */
  public MdiIcon inactive() {
    return setActive(false);
  }

  /**
   * Sets the contrast of the icon
   *
   * @param mdiContrast the {@link MdiContrast}
   * @return same instance
   */
  public MdiIcon setContrast(MdiContrast mdiContrast) {
    if (nonNull(this.mdiContrast)) {
      removeCss(this.mdiContrast.getStyle());
    }
    this.mdiContrast = mdiContrast;
    addCss(this.mdiContrast.getStyle());
    return this;
  }

  /**
   * Sets the contrast as light
   *
   * @return same instance
   */
  public MdiIcon light() {
    return setContrast(MdiContrast.light);
  }

  /**
   * Sets the contrast as dark
   *
   * @return same instance
   */
  public MdiIcon dark() {
    return setContrast(MdiContrast.dark);
  }

  /**
   * Removes the contrast
   *
   * @return same instance
   */
  public MdiIcon noContrast() {
    if (nonNull(this.mdiContrast)) {
      removeCss(this.mdiContrast.getStyle());
    }
    return this;
  }

  /** {@inheritDoc} */
  @Override
  public HTMLElement element() {
    return icon.element();
  }

  /** An enum representing the sizes of the icon */
  public enum MdiSize {
    mdi18(IconsStyles.MDI_18_PX),
    mdi24(IconsStyles.MDI_24_PX),
    mdi36(IconsStyles.MDI_36_PX),
    mdi48(IconsStyles.MDI_48_PX);

    private final String style;

    MdiSize(String style) {
      this.style = style;
    }

    /** @return The style of the size */
    public String getStyle() {
      return style;
    }
  }

  /** An enum representing the rotation degree of the icon */
  public enum MdiRotate {
    rotate45(IconsStyles.MDI_ROTATE_45),
    rotate90(IconsStyles.MDI_ROTATE_90),
    rotate135(IconsStyles.MDI_ROTATE_135),
    rotate180(IconsStyles.MDI_ROTATE_180),
    rotate225(IconsStyles.MDI_ROTATE_225),
    rotate270(IconsStyles.MDI_ROTATE_270),
    rotate315(IconsStyles.MDI_ROTATE_315);

    private final String style;

    MdiRotate(String style) {
      this.style = style;
    }

    /** @return The style of the rotation */
    public String getStyle() {
      return style;
    }
  }

  /** An enum representing the flip of the icon */
  public enum MdiFlip {
    flipV(IconsStyles.MDI_FLIP_V),
    flipH(IconsStyles.MDI_FLIP_H);

    private final String style;

    MdiFlip(String style) {
      this.style = style;
    }

    /** @return The style of the flip */
    public String getStyle() {
      return style;
    }
  }

  /** @return The {@link MdiMeta} of the icon */
  public MdiMeta getMetaInfo() {
    return metaInfo;
  }

  /** An enum representing the contrast of the icon */
  public enum MdiContrast {
    light(IconsStyles.MDI_LIGHT),
    dark(IconsStyles.MDI_DARK);

    private final String style;

    MdiContrast(String style) {
      this.style = style;
    }

    /** @return The style of the contrast */
    public String getStyle() {
      return style;
    }
  }
}
