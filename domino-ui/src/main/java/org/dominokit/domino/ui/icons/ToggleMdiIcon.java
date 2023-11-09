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

/**
 * A class that represents a toggleable Material Design Icon (MdiIcon). It allows switching between
 * two MdiIcons (a primary and a toggle) and provides various methods to customize their appearance
 * and behavior.
 */
public class ToggleMdiIcon extends ToggleIcon<MdiIcon, ToggleMdiIcon> {

  /**
   * Creates a new instance of ToggleMdiIcon with the given primary and toggle MdiIcons.
   *
   * @param primary The primary MdiIcon to display.
   * @param toggle The toggle MdiIcon to display when toggled.
   * @return A new ToggleMdiIcon instance.
   */
  public static ToggleMdiIcon create(MdiIcon primary, MdiIcon toggle) {
    return new ToggleMdiIcon(primary, toggle);
  }

  /**
   * Creates a new instance of ToggleMdiIcon with the given primary and toggle MdiIcons.
   *
   * @param primary The primary MdiIcon to display.
   * @param toggle The toggle MdiIcon to display when toggled.
   */
  public ToggleMdiIcon(MdiIcon primary, MdiIcon toggle) {
    super(primary, toggle);
  }

  /**
   * Creates a copy of the ToggleMdiIcon instance.
   *
   * @return A new ToggleMdiIcon instance with copied primary and toggle icons.
   */
  @Override
  public ToggleMdiIcon copy() {
    return new ToggleMdiIcon(primary.copy(), toggle.copy());
  }

  /**
   * Sets the rotation for both the primary and toggle MdiIcons.
   *
   * @param mdiRotate The rotation to apply to both icons.
   * @return The ToggleMdiIcon instance for method chaining.
   */
  public ToggleMdiIcon setRotate(MdiIcon.MdiRotate mdiRotate) {
    primary.setRotate(mdiRotate);
    toggle.setRotate(mdiRotate);
    return this;
  }

  /**
   * Rotates both the primary and toggle icons 45 degrees.
   *
   * @return The ToggleMdiIcon instance for method chaining.
   */
  public ToggleMdiIcon rotate45() {
    primary.rotate45();
    toggle.rotate45();
    return this;
  }

  /**
   * Rotates both the primary and toggle icons 90 degrees.
   *
   * @return The ToggleMdiIcon instance for method chaining.
   */
  public ToggleMdiIcon rotate90() {
    primary.rotate90();
    toggle.rotate90();
    return this;
  }

  /**
   * Rotates both the primary and toggle icons 135 degrees.
   *
   * @return The ToggleMdiIcon instance for method chaining.
   */
  public ToggleMdiIcon rotate135() {
    primary.rotate135();
    toggle.rotate135();
    return this;
  }

  /**
   * Rotates both the primary and toggle icons 180 degrees.
   *
   * @return The ToggleMdiIcon instance for method chaining.
   */
  public ToggleMdiIcon rotate180() {
    primary.rotate180();
    toggle.rotate180();
    return this;
  }

  /**
   * Rotates both the primary and toggle icons 225 degrees.
   *
   * @return The ToggleMdiIcon instance for method chaining.
   */
  public ToggleMdiIcon rotate225() {
    primary.rotate225();
    toggle.rotate225();
    return this;
  }

  /**
   * Rotates both the primary and toggle icons 270 degrees.
   *
   * @return The ToggleMdiIcon instance for method chaining.
   */
  public ToggleMdiIcon rotate270() {
    primary.rotate270();
    toggle.rotate270();
    return this;
  }

  /**
   * Rotates both the primary and toggle icons 315 degrees.
   *
   * @return The ToggleMdiIcon instance for method chaining.
   */
  public ToggleMdiIcon rotate315() {
    primary.rotate315();
    toggle.rotate315();
    return this;
  }

  /**
   * Resets the rotation for both the primary and toggle icons.
   *
   * @return The ToggleMdiIcon instance for method chaining.
   */
  public ToggleMdiIcon rotateNone() {
    primary.rotateNone();
    toggle.rotateNone();
    return this;
  }

  /**
   * Sets the flip mode for both the primary and toggle icons.
   *
   * @param mdiFlip The flip mode to apply to both icons.
   * @return The ToggleMdiIcon instance for method chaining.
   */
  public ToggleMdiIcon setFlip(MdiIcon.MdiFlip mdiFlip) {
    primary.setFlip(mdiFlip);
    toggle.setFlip(mdiFlip);
    return this;
  }

  /**
   * Flips both the primary and toggle icons vertically.
   *
   * @return The ToggleMdiIcon instance for method chaining.
   */
  public ToggleMdiIcon flipV() {
    primary.flipV();
    toggle.flipV();
    return this;
  }

  /**
   * Flips both the primary and toggle icons horizontally.
   *
   * @return The ToggleMdiIcon instance for method chaining.
   */
  public ToggleMdiIcon flipH() {
    primary.flipH();
    toggle.flipH();
    return this;
  }

  /**
   * Resets the flip mode for both the primary and toggle icons.
   *
   * @return The ToggleMdiIcon instance for method chaining.
   */
  public ToggleMdiIcon flipNone() {
    primary.flipNone();
    toggle.flipNone();
    return this;
  }

  /**
   * Sets the spin mode for both the primary and toggle icons.
   *
   * @param spin True to enable spinning, false to disable it.
   * @return The ToggleMdiIcon instance for method chaining.
   */
  public ToggleMdiIcon setSpin(boolean spin) {
    primary.setSpin(spin);
    toggle.setSpin(spin);
    return this;
  }

  /**
   * Enables spinning for both the primary and toggle icons.
   *
   * @return The ToggleMdiIcon instance for method chaining.
   */
  public ToggleMdiIcon spin() {
    primary.spin();
    toggle.spin();
    return this;
  }

  /**
   * Disables spinning for both the primary and toggle icons.
   *
   * @return The ToggleMdiIcon instance for method chaining.
   */
  public ToggleMdiIcon noSpin() {
    primary.noSpin();
    toggle.noSpin();
    return this;
  }

  /**
   * Sets the active state for both the primary and toggle icons.
   *
   * @param active True to set the icons as active, false to set them as inactive.
   * @return The ToggleMdiIcon instance for method chaining.
   */
  public ToggleMdiIcon setActive(boolean active) {
    primary.setActive(active);
    toggle.setActive(active);
    return this;
  }

  /**
   * Sets both the primary and toggle icons as active.
   *
   * @return The ToggleMdiIcon instance for method chaining.
   */
  public ToggleMdiIcon active() {
    primary.active();
    toggle.active();
    return this;
  }

  /**
   * Sets both the primary and toggle icons as inactive.
   *
   * @return The ToggleMdiIcon instance for method chaining.
   */
  public ToggleMdiIcon inactive() {
    primary.inactive();
    toggle.inactive();
    return this;
  }

  /**
   * Sets the contrast mode for both the primary and toggle icons.
   *
   * @param mdiContrast The contrast mode to apply to both icons.
   * @return The ToggleMdiIcon instance for method chaining.
   */
  public ToggleMdiIcon setContrast(MdiIcon.MdiContrast mdiContrast) {
    primary.setContrast(mdiContrast);
    toggle.setContrast(mdiContrast);
    return this;
  }

  /**
   * Sets both the primary and toggle icons to the light contrast mode.
   *
   * @return The ToggleMdiIcon instance for method chaining.
   */
  public ToggleMdiIcon light() {
    primary.light();
    toggle.light();
    return this;
  }

  /**
   * Sets both the primary and toggle icons to the dark contrast mode.
   *
   * @return The ToggleMdiIcon instance for method chaining.
   */
  public ToggleMdiIcon dark() {
    primary.dark();
    toggle.dark();
    return this;
  }

  /**
   * Removes the contrast mode for both the primary and toggle icons.
   *
   * @return The ToggleMdiIcon instance for method chaining.
   */
  public ToggleMdiIcon noContrast() {
    primary.noContrast();
    toggle.noContrast();
    return this;
  }
}
