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

public class ToggleMdiIcon extends ToggleIcon<MdiIcon, ToggleMdiIcon> {

  public static ToggleMdiIcon create(MdiIcon primary, MdiIcon toggle) {
    return new ToggleMdiIcon(primary, toggle);
  }

  public ToggleMdiIcon(MdiIcon primary, MdiIcon toggle) {
    super(primary, toggle);
  }

  @Override
  public ToggleMdiIcon copy() {
    return new ToggleMdiIcon(primary.copy(), toggle.copy());
  }

  /**
   * Sets the type of rotate applied to the icon
   *
   * @param mdiRotate the {@link MdiIcon.MdiRotate}
   * @return same instance
   */
  public ToggleMdiIcon setRotate(MdiIcon.MdiRotate mdiRotate) {
    primary.setRotate(mdiRotate);
    toggle.setRotate(mdiRotate);
    return this;
  }

  /**
   * Rotates the icon with 45 degrees
   *
   * @return same instance
   */
  public ToggleMdiIcon rotate45() {
    primary.rotate45();
    toggle.rotate45();
    return this;
  }

  /**
   * Rotates the icon with 90 degrees
   *
   * @return same instance
   */
  public ToggleMdiIcon rotate90() {
    primary.rotate90();
    toggle.rotate90();
    return this;
  }

  /**
   * Rotates the icon with 135 degrees
   *
   * @return same instance
   */
  public ToggleMdiIcon rotate135() {
    primary.rotate135();
    toggle.rotate135();
    return this;
  }

  /**
   * Rotates the icon with 180 degrees
   *
   * @return same instance
   */
  public ToggleMdiIcon rotate180() {
    primary.rotate180();
    toggle.rotate180();
    return this;
  }

  /**
   * Rotates the icon with 225 degrees
   *
   * @return same instance
   */
  public ToggleMdiIcon rotate225() {
    primary.rotate225();
    toggle.rotate225();
    return this;
  }

  /**
   * Rotates the icon with 270 degrees
   *
   * @return same instance
   */
  public ToggleMdiIcon rotate270() {
    primary.rotate270();
    toggle.rotate270();
    return this;
  }

  /**
   * Rotates the icon with 315 degrees
   *
   * @return same instance
   */
  public ToggleMdiIcon rotate315() {
    primary.rotate315();
    toggle.rotate315();
    return this;
  }

  /**
   * Sets rotate to the default value
   *
   * @return same instance
   */
  public ToggleMdiIcon rotateNone() {
    primary.rotateNone();
    toggle.rotateNone();
    return this;
  }

  /**
   * Flips the icon either horizontally or vertically
   *
   * @param mdiFlip the {@link MdiIcon.MdiFlip}
   * @return same instance
   */
  public ToggleMdiIcon setFlip(MdiIcon.MdiFlip mdiFlip) {
    primary.setFlip(mdiFlip);
    toggle.setFlip(mdiFlip);
    return this;
  }

  /**
   * Flips the icon vertically
   *
   * @return same instance
   */
  public ToggleMdiIcon flipV() {
    primary.flipV();
    toggle.flipV();
    return this;
  }

  /**
   * Flips the icon horizontally
   *
   * @return same instance
   */
  public ToggleMdiIcon flipH() {
    primary.flipH();
    toggle.flipH();
    return this;
  }

  /**
   * Removes the flip
   *
   * @return same instance
   */
  public ToggleMdiIcon flipNone() {
    primary.flipNone();
    toggle.flipNone();
    return this;
  }

  /**
   * Sets if the icon should spin
   *
   * @param spin true to spin the icon, false otherwise
   * @return same instance
   */
  public ToggleMdiIcon setSpin(boolean spin) {
    primary.setSpin(spin);
    toggle.setSpin(spin);
    return this;
  }

  /**
   * Spins the icon
   *
   * @return same instance
   */
  public ToggleMdiIcon spin() {
    primary.spin();
    toggle.spin();
    return this;
  }

  /**
   * Removes the spinning of the icon
   *
   * @return same instance
   */
  public ToggleMdiIcon noSpin() {
    primary.noSpin();
    toggle.noSpin();
    return this;
  }

  /**
   * Sets if the icon is active or not
   *
   * @param active true to activate the icon, false otherwise
   * @return same instance
   */
  public ToggleMdiIcon setActive(boolean active) {
    primary.setActive(active);
    toggle.setActive(active);
    return this;
  }

  /**
   * Activate the icon
   *
   * @return same instance
   */
  public ToggleMdiIcon active() {
    primary.active();
    toggle.active();
    return this;
  }

  /**
   * Marks the icon as inactive
   *
   * @return same instance
   */
  public ToggleMdiIcon inactive() {
    primary.inactive();
    toggle.inactive();
    return this;
  }

  /**
   * Sets the contrast of the icon
   *
   * @param mdiContrast the {@link MdiIcon.MdiContrast}
   * @return same instance
   */
  public ToggleMdiIcon setContrast(MdiIcon.MdiContrast mdiContrast) {
    primary.setContrast(mdiContrast);
    toggle.setContrast(mdiContrast);
    return this;
  }

  /**
   * Sets the contrast as light
   *
   * @return same instance
   */
  public ToggleMdiIcon light() {
    primary.light();
    toggle.light();
    return this;
  }

  /**
   * Sets the contrast as dark
   *
   * @return same instance
   */
  public ToggleMdiIcon dark() {
    primary.dark();
    toggle.dark();
    return this;
  }

  /**
   * Removes the contrast
   *
   * @return same instance
   */
  public ToggleMdiIcon noContrast() {
    primary.noContrast();
    toggle.noContrast();
    return this;
  }
}
