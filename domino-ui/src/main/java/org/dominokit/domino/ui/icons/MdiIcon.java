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

import static org.dominokit.domino.ui.icons.IconsStyles.*;
import static org.dominokit.domino.ui.utils.Domino.*;

import elemental2.dom.HTMLElement;
import org.dominokit.domino.ui.style.*;

/**
 * An icon component for Material Design Icons (MDI) that allows you to customize its appearance and
 * behavior.
 */
public class MdiIcon extends Icon<MdiIcon> implements CanChangeIcon<MdiIcon> {

  private MdiMeta metaInfo;
  private SwapCssClass rotateClass = new SwapCssClass();
  private SwapCssClass contrastClass = new SwapCssClass();

  /**
   * Creates an MdiIcon with the provided HTML element as its icon representation.
   *
   * @param icon The HTML element to use as the icon.
   */
  private MdiIcon(HTMLElement icon) {
    this.icon = elementOf(icon);
    init(this);
  }

  /**
   * Creates an MdiIcon with the specified MDI icon name.
   *
   * @param icon The name of the MDI icon to display (e.g., "mdi-home").
   */
  private MdiIcon(String icon) {
    this(icon, new MdiMeta(icon.replace("mdi-", "")));
  }

  /**
   * Creates an MdiIcon with the specified MDI icon represented as a CSS class.
   *
   * @param icon The CSS class representing the MDI icon (e.g., IconsStyles.mdi_home).
   */
  private MdiIcon(CssClass icon) {
    this(icon, new MdiMeta(icon.getCssClass().replace("mdi-", "")));
  }

  /**
   * Creates an MdiIcon with the specified MDI icon name and metadata.
   *
   * @param icon The name of the MDI icon to display (e.g., "mdi-home").
   * @param mdiMeta The metadata associated with the MDI icon.
   */
  private MdiIcon(String icon, MdiMeta mdiMeta) {
    this(() -> icon, mdiMeta);
  }

  /**
   * Creates an MdiIcon with the specified MDI icon represented as a CSS class and metadata.
   *
   * @param icon The CSS class representing the MDI icon (e.g., IconsStyles.mdi_home).
   * @param mdiMeta The metadata associated with the MDI icon.
   */
  private MdiIcon(CssClass icon, MdiMeta mdiMeta) {
    this();
    this.addCss(icon);
    this.name = SwapCssClass.of(icon);
    this.metaInfo = mdiMeta;
  }

  /** Creates a blank MdiIcon with no initial icon representation. */
  private MdiIcon() {
    this.icon = i().addCss(dui, dui_mdi).toDominoElement();
    init(this);
  }

  /**
   * Creates a new instance of an MdiIcon with a blank icon representation.
   *
   * @return A new instance of MdiIcon.
   */
  public static MdiIcon create() {
    return new MdiIcon();
  }

  /**
   * Creates a new instance of an MdiIcon with the specified MDI icon name.
   *
   * @param icon The name of the MDI icon to display (e.g., "mdi-home").
   * @return A new instance of MdiIcon.
   */
  public static MdiIcon create(String icon) {
    return new MdiIcon(icon);
  }

  /**
   * Creates a new instance of an MdiIcon with the specified MDI icon represented as a CSS class.
   *
   * @param icon The CSS class representing the MDI icon (e.g., IconsStyles.mdi_home).
   * @return A new instance of MdiIcon.
   */
  public static MdiIcon create(CssClass icon) {
    return new MdiIcon(icon);
  }

  /**
   * Creates a new instance of an MdiIcon with the specified MDI icon name and metadata.
   *
   * @param icon The name of the MDI icon to display (e.g., "mdi-home").
   * @param meta The metadata associated with the MDI icon.
   * @return A new instance of MdiIcon.
   */
  public static MdiIcon create(String icon, MdiMeta meta) {
    return new MdiIcon(icon, meta);
  }

  /**
   * Creates a copy of the current MdiIcon instance. The copy will have the same icon name and
   * styles as the original icon.
   *
   * @return A new MdiIcon instance that is a copy of the current icon.
   */
  @Override
  public MdiIcon copy() {
    MdiIcon mdiIcon = MdiIcon.create(this.getName());
    return mdiIcon.addCss(
        SwapCssClass.of(CompositeCssClass.of(mdiIcon)).replaceWith(CompositeCssClass.of(this)));
  }

  /**
   * Changes the appearance of the current MdiIcon to match another MdiIcon. This method replaces
   * the CSS classes and styles of the current icon with those of the specified icon, making the
   * current icon visually identical to the new one.
   *
   * @param icon The MdiIcon to change to.
   * @return The current MdiIcon instance with its appearance updated to match the specified icon.
   */
  @Override
  public MdiIcon changeTo(MdiIcon icon) {
    this.name.replaceWith(icon.name.getCurrent()).apply(this);
    this.name = icon.name;
    return this;
  }

  /**
   * Sets the rotation of the MdiIcon to the specified rotation type.
   *
   * @param mdiRotate The rotation type to apply.
   * @return The MdiIcon instance.
   */
  public MdiIcon setRotate(MdiRotate mdiRotate) {
    addCss(rotateClass.replaceWith(mdiRotate));
    return this;
  }

  /**
   * Rotates the MdiIcon by 45 degrees.
   *
   * @return The MdiIcon instance.
   */
  public MdiIcon rotate45() {
    return setRotate(MdiRotate.rotate45);
  }

  /**
   * Rotates the MdiIcon by 90 degrees.
   *
   * @return The MdiIcon instance.
   */
  public MdiIcon rotate90() {
    return setRotate(MdiRotate.rotate90);
  }

  /**
   * Rotates the MdiIcon by 135 degrees.
   *
   * @return The MdiIcon instance.
   */
  public MdiIcon rotate135() {
    return setRotate(MdiRotate.rotate135);
  }

  /**
   * Rotates the MdiIcon by 180 degrees.
   *
   * @return The MdiIcon instance.
   */
  public MdiIcon rotate180() {
    return setRotate(MdiRotate.rotate180);
  }

  /**
   * Rotates the MdiIcon by 225 degrees.
   *
   * @return The MdiIcon instance.
   */
  public MdiIcon rotate225() {
    return setRotate(MdiRotate.rotate225);
  }

  /**
   * Rotates the MdiIcon by 270 degrees.
   *
   * @return The MdiIcon instance.
   */
  public MdiIcon rotate270() {
    return setRotate(MdiRotate.rotate270);
  }

  /**
   * Rotates the MdiIcon by 315 degrees.
   *
   * @return The MdiIcon instance.
   */
  public MdiIcon rotate315() {
    return setRotate(MdiRotate.rotate315);
  }

  /**
   * Resets the rotation of the MdiIcon to its default state.
   *
   * @return The MdiIcon instance.
   */
  public MdiIcon rotateNone() {
    rotateClass.remove(this);
    return this;
  }

  /**
   * Sets the flip style of the MdiIcon to the specified flip type.
   *
   * @param mdiFlip The flip type to apply.
   * @return The MdiIcon instance.
   */
  public MdiIcon setFlip(MdiFlip mdiFlip) {
    addCss(mdiFlip);
    return this;
  }

  /**
   * Flips the MdiIcon vertically.
   *
   * @return The MdiIcon instance.
   */
  public MdiIcon flipV() {
    return setFlip(MdiFlip.flipV);
  }

  /**
   * Flips the MdiIcon horizontally.
   *
   * @return The MdiIcon instance.
   */
  public MdiIcon flipH() {
    return setFlip(MdiFlip.flipH);
  }

  /**
   * Resets the flip style of the MdiIcon to its default state.
   *
   * @return The MdiIcon instance.
   */
  public MdiIcon flipNone() {
    mdi_flip_v.remove(this);
    mdi_flip_h.remove(this);
    return this;
  }

  /**
   * Sets the spinning behavior of the MdiIcon.
   *
   * @param spin {@code true} to enable spinning, {@code false} to disable it.
   * @return The MdiIcon instance.
   */
  public MdiIcon setSpin(boolean spin) {
    addCss(BooleanCssClass.of(mdi_spin, spin));
    return this;
  }

  /**
   * Enables spinning for the MdiIcon.
   *
   * @return The MdiIcon instance.
   */
  public MdiIcon spin() {
    return setSpin(true);
  }

  /**
   * Disables spinning for the MdiIcon.
   *
   * @return The MdiIcon instance.
   */
  public MdiIcon noSpin() {
    return setSpin(false);
  }

  /**
   * Sets the active state of the MdiIcon.
   *
   * @param active {@code true} to set the icon as active, {@code false} to set it as inactive.
   * @return The MdiIcon instance.
   */
  public MdiIcon setActive(boolean active) {
    addCss(BooleanCssClass.of(mdi_inactive, !active));
    return this;
  }

  /**
   * Sets the MdiIcon as active.
   *
   * @return The MdiIcon instance.
   */
  public MdiIcon active() {
    return setActive(true);
  }

  /**
   * Sets the MdiIcon as inactive.
   *
   * @return The MdiIcon instance.
   */
  public MdiIcon inactive() {
    return setActive(false);
  }

  /**
   * Sets the contrast style of the MdiIcon to the specified contrast type.
   *
   * @param mdiContrast The contrast type to apply.
   * @return The MdiIcon instance.
   */
  public MdiIcon setContrast(MdiContrast mdiContrast) {
    addCss(contrastClass.replaceWith(mdiContrast));
    return this;
  }

  /**
   * Sets the MdiIcon as light contrast.
   *
   * @return The MdiIcon instance.
   */
  public MdiIcon light() {
    return setContrast(MdiContrast.light);
  }

  /**
   * Sets the MdiIcon as dark contrast.
   *
   * @return The MdiIcon instance.
   */
  public MdiIcon dark() {
    return setContrast(MdiContrast.dark);
  }

  /**
   * Resets the contrast style of the MdiIcon to its default state.
   *
   * @return The MdiIcon instance.
   */
  public MdiIcon noContrast() {
    contrastClass.remove(this);
    return this;
  }

  /** @dominokit-site-ignore {@inheritDoc} */
  @Override
  public HTMLElement element() {
    return icon.element();
  }

  /** Enumeration of MDI icon rotation types. */
  public enum MdiRotate implements HasCssClass {
    rotate45(IconsStyles.mdi_rotate_45),
    rotate90(IconsStyles.mdi_rotate_90),
    rotate135(IconsStyles.mdi_rotate_135),
    rotate180(IconsStyles.mdi_rotate_180),
    rotate225(IconsStyles.mdi_rotate_225),
    rotate270(IconsStyles.mdi_rotate_270),
    rotate315(IconsStyles.mdi_rotate_315);

    private final CssClass style;

    MdiRotate(CssClass style) {
      this.style = style;
    }

    /** {@inheritDoc} */
    public CssClass getCssClass() {
      return style;
    }
  }

  /** Enumeration of MDI icon flip types. */
  public enum MdiFlip implements HasCssClass {
    flipV(mdi_flip_v),
    flipH(IconsStyles.mdi_flip_h);

    private final CssClass style;

    MdiFlip(CssClass style) {
      this.style = style;
    }

    /** {@inheritDoc} */
    public CssClass getCssClass() {
      return style;
    }
  }

  public MdiMeta getMetaInfo() {
    return metaInfo;
  }

  /** Enumeration of MDI icon contrast types. */
  public enum MdiContrast implements HasCssClass {
    light(IconsStyles.mdi_light),
    dark(IconsStyles.mdi_dark);

    private final CssClass style;

    MdiContrast(CssClass style) {
      this.style = style;
    }

    /** {@inheritDoc} */
    public CssClass getCssClass() {
      return style;
    }
  }
}
