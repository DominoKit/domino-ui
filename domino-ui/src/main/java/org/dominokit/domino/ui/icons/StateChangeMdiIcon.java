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

/** StateChangeMdiIcon class. */
public class StateChangeMdiIcon extends StateChangeIcon<MdiIcon, StateChangeMdiIcon> {

  /**
   * create.
   *
   * @param defaultIcon a {@link org.dominokit.domino.ui.icons.MdiIcon} object
   * @return a {@link org.dominokit.domino.ui.icons.StateChangeMdiIcon} object
   */
  public static StateChangeMdiIcon create(MdiIcon defaultIcon) {
    return new StateChangeMdiIcon(defaultIcon);
  }

  /**
   * Constructor for StateChangeMdiIcon.
   *
   * @param defaultIcon a {@link org.dominokit.domino.ui.icons.MdiIcon} object
   */
  public StateChangeMdiIcon(MdiIcon defaultIcon) {
    super(defaultIcon);
  }

  /** {@inheritDoc} */
  @Override
  public StateChangeMdiIcon copy() {
    StateChangeMdiIcon copy = new StateChangeMdiIcon(defaultIcon.copy());
    statesMap.forEach(copy::withState);
    return copy;
  }

  /**
   * Sets the type of rotate applied to the icon
   *
   * @param mdiRotate the {@link org.dominokit.domino.ui.icons.MdiIcon.MdiRotate}
   * @return same instance
   */
  public StateChangeMdiIcon setRotate(MdiIcon.MdiRotate mdiRotate) {
    defaultIcon.setRotate(mdiRotate);
    statesMap.values().forEach(mdiIcon -> mdiIcon.setRotate(mdiRotate));
    return this;
  }

  /**
   * Rotates the icon with 45 degrees
   *
   * @return same instance
   */
  public StateChangeMdiIcon rotate45() {
    defaultIcon.rotate45();
    statesMap.values().forEach(MdiIcon::rotate45);
    return this;
  }

  /**
   * Rotates the icon with 90 degrees
   *
   * @return same instance
   */
  public StateChangeMdiIcon rotate90() {
    defaultIcon.rotate90();
    statesMap.values().forEach(MdiIcon::rotate90);
    return this;
  }

  /**
   * Rotates the icon with 135 degrees
   *
   * @return same instance
   */
  public StateChangeMdiIcon rotate135() {
    defaultIcon.rotate135();
    statesMap.values().forEach(MdiIcon::rotate135);
    return this;
  }

  /**
   * Rotates the icon with 180 degrees
   *
   * @return same instance
   */
  public StateChangeMdiIcon rotate180() {
    defaultIcon.rotate180();
    statesMap.values().forEach(MdiIcon::rotate180);
    return this;
  }

  /**
   * Rotates the icon with 225 degrees
   *
   * @return same instance
   */
  public StateChangeMdiIcon rotate225() {
    defaultIcon.rotate225();
    statesMap.values().forEach(MdiIcon::rotate225);
    return this;
  }

  /**
   * Rotates the icon with 270 degrees
   *
   * @return same instance
   */
  public StateChangeMdiIcon rotate270() {
    defaultIcon.rotate270();
    statesMap.values().forEach(MdiIcon::rotate270);
    return this;
  }

  /**
   * Rotates the icon with 315 degrees
   *
   * @return same instance
   */
  public StateChangeMdiIcon rotate315() {
    defaultIcon.rotate315();
    statesMap.values().forEach(MdiIcon::rotate315);
    return this;
  }

  /**
   * Sets rotate to the default value
   *
   * @return same instance
   */
  public StateChangeMdiIcon rotateNone() {
    defaultIcon.rotateNone();
    statesMap.values().forEach(MdiIcon::rotateNone);
    return this;
  }

  /**
   * Flips the icon either horizontally or vertically
   *
   * @param mdiFlip the {@link org.dominokit.domino.ui.icons.MdiIcon.MdiFlip}
   * @return same instance
   */
  public StateChangeMdiIcon setFlip(MdiIcon.MdiFlip mdiFlip) {
    defaultIcon.setFlip(mdiFlip);
    statesMap.values().forEach(mdiIcon -> mdiIcon.setFlip(mdiFlip));
    return this;
  }

  /**
   * Flips the icon vertically
   *
   * @return same instance
   */
  public StateChangeMdiIcon flipV() {
    defaultIcon.flipV();
    statesMap.values().forEach(MdiIcon::flipV);
    return this;
  }

  /**
   * Flips the icon horizontally
   *
   * @return same instance
   */
  public StateChangeMdiIcon flipH() {
    defaultIcon.flipH();
    statesMap.values().forEach(MdiIcon::flipH);
    return this;
  }

  /**
   * Removes the flip
   *
   * @return same instance
   */
  public StateChangeMdiIcon flipNone() {
    defaultIcon.flipNone();
    statesMap.values().forEach(MdiIcon::flipNone);
    return this;
  }

  /**
   * Sets if the icon should spin
   *
   * @param spin true to spin the icon, false otherwise
   * @return same instance
   */
  public StateChangeMdiIcon setSpin(boolean spin) {
    defaultIcon.setSpin(spin);
    statesMap.values().forEach(mdiIcon -> mdiIcon.setSpin(spin));
    return this;
  }

  /**
   * Spins the icon
   *
   * @return same instance
   */
  public StateChangeMdiIcon spin() {
    defaultIcon.spin();
    statesMap.values().forEach(MdiIcon::spin);
    return this;
  }

  /**
   * Removes the spinning of the icon
   *
   * @return same instance
   */
  public StateChangeMdiIcon noSpin() {
    defaultIcon.noSpin();
    statesMap.values().forEach(MdiIcon::noSpin);
    return this;
  }

  /**
   * Sets if the icon is active or not
   *
   * @param active true to activate the icon, false otherwise
   * @return same instance
   */
  public StateChangeMdiIcon setActive(boolean active) {
    defaultIcon.setActive(active);
    statesMap.values().forEach(mdiIcon -> mdiIcon.setActive(active));
    return this;
  }

  /**
   * Activate the icon
   *
   * @return same instance
   */
  public StateChangeMdiIcon active() {
    defaultIcon.active();
    statesMap.values().forEach(MdiIcon::active);
    return this;
  }

  /**
   * Marks the icon as inactive
   *
   * @return same instance
   */
  public StateChangeMdiIcon inactive() {
    defaultIcon.inactive();
    statesMap.values().forEach(MdiIcon::inactive);
    return this;
  }

  /**
   * Sets the contrast of the icon
   *
   * @param mdiContrast the {@link org.dominokit.domino.ui.icons.MdiIcon.MdiContrast}
   * @return same instance
   */
  public StateChangeMdiIcon setContrast(MdiIcon.MdiContrast mdiContrast) {
    defaultIcon.setContrast(mdiContrast);
    statesMap.values().forEach(mdiIcon -> mdiIcon.setContrast(mdiContrast));
    return this;
  }

  /**
   * Sets the contrast as light
   *
   * @return same instance
   */
  public StateChangeMdiIcon light() {
    defaultIcon.light();
    statesMap.values().forEach(MdiIcon::light);
    return this;
  }

  /**
   * Sets the contrast as dark
   *
   * @return same instance
   */
  public StateChangeMdiIcon dark() {
    defaultIcon.dark();
    statesMap.values().forEach(MdiIcon::dark);
    return this;
  }

  /**
   * Removes the contrast
   *
   * @return same instance
   */
  public StateChangeMdiIcon noContrast() {
    defaultIcon.noContrast();
    statesMap.values().forEach(MdiIcon::noContrast);
    return this;
  }
}
