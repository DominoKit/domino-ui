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

import elemental2.dom.DomGlobal;
import java.util.function.Consumer;
import jsinterop.base.Js;
import org.dominokit.domino.ui.utils.ElementHandler;

/** MDI-specific toggle icon with provider-independent child visibility switching. */
public class ToggleMdiIcon extends AbstractIcon<ToggleMdiIcon> {

  private final MdiIcon primary;
  private final MdiIcon toggle;
  private boolean toggled;
  private boolean toggleOnClick;
  private Consumer<ToggleMdiIcon> onToggle = icon -> {};

  public static ToggleMdiIcon create(MdiIcon primary, MdiIcon toggle) {
    return new ToggleMdiIcon(primary, toggle);
  }

  public ToggleMdiIcon(MdiIcon primary, MdiIcon toggle) {
    super(Js.cast(DomGlobal.document.createElement("span")), "mdi", "");
    this.primary = primary;
    this.toggle = toggle;
    root.classList.add("dui-icon-toggle");
    root.appendChild(primary.element());
    root.appendChild(toggle.element());
    toggle.element().style.display = "none";
    addClickListener(
        event -> {
          if (toggleOnClick) toggle();
        });
  }

  public boolean isToggled() {
    return toggled;
  }

  /** Shows this toggle icon, preserving the legacy {@code Icon} visibility API. */
  public ToggleMdiIcon show() {
    root.classList.remove("dui-hidden");
    return this;
  }

  /** Hides this toggle icon, preserving the legacy {@code Icon} visibility API. */
  public ToggleMdiIcon hide() {
    root.classList.add("dui-hidden");
    return this;
  }

  public ToggleMdiIcon toggleOnClick(boolean enabled) {
    toggleOnClick = enabled;
    if (enabled) root.setAttribute("aria-pressed", Boolean.toString(toggled));
    return this;
  }

  public ToggleMdiIcon onToggle(Consumer<ToggleMdiIcon> handler) {
    onToggle = handler == null ? icon -> {} : handler;
    return this;
  }

  public ToggleMdiIcon toggle() {
    return toggle(false);
  }

  public ToggleMdiIcon toggle(boolean silent) {
    toggled = !toggled;
    primary.element().style.display = toggled ? "none" : "";
    toggle.element().style.display = toggled ? "" : "none";
    root.setAttribute("aria-pressed", Boolean.toString(toggled));
    if (!silent) onToggle.accept(this);
    return this;
  }

  public ToggleMdiIcon applyToAll(ElementHandler<MdiIcon> handler) {
    handler.handleElement(primary);
    handler.handleElement(toggle);
    return this;
  }

  @Override
  public ToggleMdiIcon copy() {
    ToggleMdiIcon copy = new ToggleMdiIcon(primary.copy(), toggle.copy());
    copy.toggleOnClick = toggleOnClick;
    if (toggled) copy.toggle(true);
    return copy;
  }

  public ToggleMdiIcon setRotate(MdiIcon.MdiRotate value) {
    return applyToBoth(icon -> icon.setRotate(value));
  }

  public ToggleMdiIcon rotate45() {
    return applyToBoth(MdiIcon::rotate45);
  }

  public ToggleMdiIcon rotate90() {
    return applyToBoth(MdiIcon::rotate90);
  }

  public ToggleMdiIcon rotate135() {
    return applyToBoth(MdiIcon::rotate135);
  }

  public ToggleMdiIcon rotate180() {
    return applyToBoth(MdiIcon::rotate180);
  }

  public ToggleMdiIcon rotate225() {
    return applyToBoth(MdiIcon::rotate225);
  }

  public ToggleMdiIcon rotate270() {
    return applyToBoth(MdiIcon::rotate270);
  }

  public ToggleMdiIcon rotate315() {
    return applyToBoth(MdiIcon::rotate315);
  }

  public ToggleMdiIcon rotateNone() {
    return applyToBoth(MdiIcon::rotateNone);
  }

  public ToggleMdiIcon setFlip(MdiIcon.MdiFlip value) {
    return applyToBoth(icon -> icon.setFlip(value));
  }

  public ToggleMdiIcon flipV() {
    return applyToBoth(MdiIcon::flipV);
  }

  public ToggleMdiIcon flipH() {
    return applyToBoth(MdiIcon::flipH);
  }

  public ToggleMdiIcon flipNone() {
    return applyToBoth(MdiIcon::flipNone);
  }

  public ToggleMdiIcon setSpin(boolean value) {
    return applyToBoth(icon -> icon.setSpin(value));
  }

  public ToggleMdiIcon spin() {
    return setSpin(true);
  }

  public ToggleMdiIcon noSpin() {
    return setSpin(false);
  }

  public ToggleMdiIcon setActive(boolean value) {
    return applyToBoth(icon -> icon.setActive(value));
  }

  public ToggleMdiIcon active() {
    return setActive(true);
  }

  public ToggleMdiIcon inactive() {
    return setActive(false);
  }

  public ToggleMdiIcon setContrast(MdiIcon.MdiContrast value) {
    return applyToBoth(icon -> icon.setContrast(value));
  }

  public ToggleMdiIcon light() {
    return applyToBoth(MdiIcon::light);
  }

  public ToggleMdiIcon dark() {
    return applyToBoth(MdiIcon::dark);
  }

  public ToggleMdiIcon noContrast() {
    return applyToBoth(MdiIcon::noContrast);
  }

  private ToggleMdiIcon applyToBoth(Consumer<MdiIcon> action) {
    action.accept(primary);
    action.accept(toggle);
    return this;
  }
}
