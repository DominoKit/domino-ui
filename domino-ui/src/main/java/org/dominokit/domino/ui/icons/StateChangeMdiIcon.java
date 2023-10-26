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
 * A StateChangeIcon implementation for Material Design Icons (MDI) icons. This icon can change its
 * state to display different MDI icons.
 */
public class StateChangeMdiIcon extends StateChangeIcon<MdiIcon, StateChangeMdiIcon> {

  /**
   * Creates a new StateChangeMdiIcon with the specified default MDI icon.
   *
   * @param defaultIcon The default MDI icon to be displayed initially.
   */
  public static StateChangeMdiIcon create(MdiIcon defaultIcon) {
    return new StateChangeMdiIcon(defaultIcon);
  }

  /**
   * Constructs a new StateChangeMdiIcon with the default MDI icon.
   *
   * @param defaultIcon The default MDI icon to be displayed initially.
   */
  public StateChangeMdiIcon(MdiIcon defaultIcon) {
    super(defaultIcon);
  }

  /**
   * {@inheritDoc} Creates a copy of the StateChangeMdiIcon along with its states.
   *
   * @return A new StateChangeMdiIcon instance that is a copy of the original.
   */
  @Override
  public StateChangeMdiIcon copy() {
    StateChangeMdiIcon copy = new StateChangeMdiIcon(defaultIcon.copy());
    statesMap.forEach(copy::withState);
    return copy;
  }

  /**
   * Sets the rotation state for the default icon and all state icons.
   *
   * @param mdiRotate The rotation state to set.
   * @return The StateChangeMdiIcon instance for method chaining.
   */
  public StateChangeMdiIcon setRotate(MdiIcon.MdiRotate mdiRotate) {
    defaultIcon.setRotate(mdiRotate);
    statesMap.values().forEach(mdiIcon -> mdiIcon.setRotate(mdiRotate));
    return this;
  }

  /**
   * Rotates the default icon and all state icons by 45 degrees.
   *
   * @return The StateChangeMdiIcon instance for method chaining.
   */
  public StateChangeMdiIcon rotate45() {
    defaultIcon.rotate45();
    statesMap.values().forEach(MdiIcon::rotate45);
    return this;
  }

  /**
   * Rotates the default icon and all state icons by 90 degrees.
   *
   * @return The StateChangeMdiIcon instance for method chaining.
   */
  public StateChangeMdiIcon rotate90() {
    defaultIcon.rotate90();
    statesMap.values().forEach(MdiIcon::rotate90);
    return this;
  }

  /**
   * Rotates the default icon and all state icons by 135 degrees.
   *
   * @return The StateChangeMdiIcon instance for method chaining.
   */
  public StateChangeMdiIcon rotate135() {
    defaultIcon.rotate135();
    statesMap.values().forEach(MdiIcon::rotate135);
    return this;
  }

  /**
   * Rotates the default icon and all state icons by 180 degrees.
   *
   * @return The StateChangeMdiIcon instance for method chaining.
   */
  public StateChangeMdiIcon rotate180() {
    defaultIcon.rotate180();
    statesMap.values().forEach(MdiIcon::rotate180);
    return this;
  }

  /**
   * Rotates the default icon and all state icons by 225 degrees.
   *
   * @return The StateChangeMdiIcon instance for method chaining.
   */
  public StateChangeMdiIcon rotate225() {
    defaultIcon.rotate225();
    statesMap.values().forEach(MdiIcon::rotate225);
    return this;
  }

  /**
   * Rotates the default icon and all state icons by 270 degrees.
   *
   * @return The StateChangeMdiIcon instance for method chaining.
   */
  public StateChangeMdiIcon rotate270() {
    defaultIcon.rotate270();
    statesMap.values().forEach(MdiIcon::rotate270);
    return this;
  }

  /**
   * Rotates the default icon and all state icons by 315 degrees.
   *
   * @return The StateChangeMdiIcon instance for method chaining.
   */
  public StateChangeMdiIcon rotate315() {
    defaultIcon.rotate315();
    statesMap.values().forEach(MdiIcon::rotate315);
    return this;
  }

  /**
   * Resets the rotation state for the default icon and all state icons.
   *
   * @return The StateChangeMdiIcon instance for method chaining.
   */
  public StateChangeMdiIcon rotateNone() {
    defaultIcon.rotateNone();
    statesMap.values().forEach(MdiIcon::rotateNone);
    return this;
  }

  /**
   * Sets the flip state for the default icon and all state icons.
   *
   * @param mdiFlip The flip state to set.
   * @return The StateChangeMdiIcon instance for method chaining.
   */
  public StateChangeMdiIcon setFlip(MdiIcon.MdiFlip mdiFlip) {
    defaultIcon.setFlip(mdiFlip);
    statesMap.values().forEach(mdiIcon -> mdiIcon.setFlip(mdiFlip));
    return this;
  }

  /**
   * Flips the default icon and all state icons vertically.
   *
   * @return The StateChangeMdiIcon instance for method chaining.
   */
  public StateChangeMdiIcon flipV() {
    defaultIcon.flipV();
    statesMap.values().forEach(MdiIcon::flipV);
    return this;
  }

  /**
   * Flips the default icon and all state icons horizontally.
   *
   * @return The StateChangeMdiIcon instance for method chaining.
   */
  public StateChangeMdiIcon flipH() {
    defaultIcon.flipH();
    statesMap.values().forEach(MdiIcon::flipH);
    return this;
  }

  /**
   * Resets the flip state for the default icon and all state icons.
   *
   * @return The StateChangeMdiIcon instance for method chaining.
   */
  public StateChangeMdiIcon flipNone() {
    defaultIcon.flipNone();
    statesMap.values().forEach(MdiIcon::flipNone);
    return this;
  }

  /**
   * Sets the spin state for the default icon and all state icons.
   *
   * @param spin True to enable spinning, false to disable it.
   * @return The StateChangeMdiIcon instance for method chaining.
   */
  public StateChangeMdiIcon setSpin(boolean spin) {
    defaultIcon.setSpin(spin);
    statesMap.values().forEach(mdiIcon -> mdiIcon.setSpin(spin));
    return this;
  }

  /**
   * Enables spinning for the default icon and all state icons.
   *
   * @return The StateChangeMdiIcon instance for method chaining.
   */
  public StateChangeMdiIcon spin() {
    defaultIcon.spin();
    statesMap.values().forEach(MdiIcon::spin);
    return this;
  }

  /**
   * Disables spinning for the default icon and all state icons.
   *
   * @return The StateChangeMdiIcon instance for method chaining.
   */
  public StateChangeMdiIcon noSpin() {
    defaultIcon.noSpin();
    statesMap.values().forEach(MdiIcon::noSpin);
    return this;
  }

  /**
   * Sets the active state for the default icon and all state icons.
   *
   * @param active True to set the icons as active, false to set them as inactive.
   * @return The StateChangeMdiIcon instance for method chaining.
   */
  public StateChangeMdiIcon setActive(boolean active) {
    defaultIcon.setActive(active);
    statesMap.values().forEach(mdiIcon -> mdiIcon.setActive(active));
    return this;
  }

  /**
   * Sets the default icon and all state icons as active.
   *
   * @return The StateChangeMdiIcon instance for method chaining.
   */
  public StateChangeMdiIcon active() {
    defaultIcon.active();
    statesMap.values().forEach(MdiIcon::active);
    return this;
  }

  /**
   * Sets the default icon and all state icons as inactive.
   *
   * @return The StateChangeMdiIcon instance for method chaining.
   */
  public StateChangeMdiIcon inactive() {
    defaultIcon.inactive();
    statesMap.values().forEach(MdiIcon::inactive);
    return this;
  }

  /**
   * Sets the contrast state for the default icon and all state icons.
   *
   * @param mdiContrast The contrast state to set.
   * @return The StateChangeMdiIcon instance for method chaining.
   */
  public StateChangeMdiIcon setContrast(MdiIcon.MdiContrast mdiContrast) {
    defaultIcon.setContrast(mdiContrast);
    statesMap.values().forEach(mdiIcon -> mdiIcon.setContrast(mdiContrast));
    return this;
  }

  /**
   * Sets the default icon and all state icons to have a light contrast.
   *
   * @return The StateChangeMdiIcon instance for method chaining.
   */
  public StateChangeMdiIcon light() {
    defaultIcon.light();
    statesMap.values().forEach(MdiIcon::light);
    return this;
  }

  /**
   * Sets the default icon and all state icons to have a dark contrast.
   *
   * @return The StateChangeMdiIcon instance for method chaining.
   */
  public StateChangeMdiIcon dark() {
    defaultIcon.dark();
    statesMap.values().forEach(MdiIcon::dark);
    return this;
  }

  /**
   * Resets the contrast state for the default icon and all state icons.
   *
   * @return The StateChangeMdiIcon instance for method chaining.
   */
  public StateChangeMdiIcon noContrast() {
    defaultIcon.noContrast();
    statesMap.values().forEach(MdiIcon::noContrast);
    return this;
  }
}
