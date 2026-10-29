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
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.function.Consumer;
import jsinterop.base.Js;

/** MDI-specific icon that displays one of several icons selected by a state key. */
public class StateChangeMdiIcon extends AbstractIcon<StateChangeMdiIcon> {

  private final MdiIcon defaultIcon;
  private final Map<String, MdiIcon> states = new LinkedHashMap<>();
  private String state = "default";
  private Consumer<StateChangeMdiIcon> onStateChanged = icon -> {};

  public static StateChangeMdiIcon create(MdiIcon defaultIcon) {
    return new StateChangeMdiIcon(defaultIcon);
  }

  public StateChangeMdiIcon(MdiIcon defaultIcon) {
    super(Js.cast(DomGlobal.document.createElement("span")), "mdi", "");
    this.defaultIcon = defaultIcon;
    root.classList.add("dui-icon-state");
    root.appendChild(defaultIcon.element());
  }

  public StateChangeMdiIcon withState(String state, MdiIcon icon) {
    if (state != null && !state.isEmpty() && icon != null) {
      MdiIcon previous = states.put(state, icon);
      if (previous != null) root.removeChild(previous.element());
      icon.element().style.display = "none";
      root.appendChild(icon.element());
    }
    return this;
  }

  public StateChangeMdiIcon removeState(String state) {
    MdiIcon removed = states.remove(state);
    if (removed != null) root.removeChild(removed.element());
    if (state.equals(this.state)) setState("default");
    return this;
  }

  public StateChangeMdiIcon onStateChanged(Consumer<StateChangeMdiIcon> handler) {
    onStateChanged = handler == null ? icon -> {} : handler;
    return this;
  }

  public StateChangeMdiIcon setState(String state) {
    if ("default".equals(state) || states.containsKey(state)) {
      this.state = state;
      defaultIcon.element().style.display = "default".equals(state) ? "" : "none";
      states.forEach((key, icon) -> icon.element().style.display = key.equals(state) ? "" : "none");
      root.setAttribute("dui-icon-state", state);
      onStateChanged.accept(this);
    }
    return this;
  }

  public String getState() {
    return state;
  }

  @Override
  public StateChangeMdiIcon copy() {
    StateChangeMdiIcon copy = new StateChangeMdiIcon(defaultIcon.copy());
    states.forEach((key, icon) -> copy.withState(key, icon.copy()));
    if (!"default".equals(state)) copy.setState(state);
    return copy;
  }

  private StateChangeMdiIcon applyToIcons(Consumer<MdiIcon> action) {
    action.accept(defaultIcon);
    states.values().forEach(action);
    return this;
  }

  public StateChangeMdiIcon setRotate(MdiIcon.MdiRotate value) {
    return applyToIcons(icon -> icon.setRotate(value));
  }

  public StateChangeMdiIcon rotate45() {
    return applyToIcons(MdiIcon::rotate45);
  }

  public StateChangeMdiIcon rotate90() {
    return applyToIcons(MdiIcon::rotate90);
  }

  public StateChangeMdiIcon rotate135() {
    return applyToIcons(MdiIcon::rotate135);
  }

  public StateChangeMdiIcon rotate180() {
    return applyToIcons(MdiIcon::rotate180);
  }

  public StateChangeMdiIcon rotate225() {
    return applyToIcons(MdiIcon::rotate225);
  }

  public StateChangeMdiIcon rotate270() {
    return applyToIcons(MdiIcon::rotate270);
  }

  public StateChangeMdiIcon rotate315() {
    return applyToIcons(MdiIcon::rotate315);
  }

  public StateChangeMdiIcon rotateNone() {
    return applyToIcons(MdiIcon::rotateNone);
  }

  public StateChangeMdiIcon setFlip(MdiIcon.MdiFlip value) {
    return applyToIcons(icon -> icon.setFlip(value));
  }

  public StateChangeMdiIcon flipV() {
    return applyToIcons(MdiIcon::flipV);
  }

  public StateChangeMdiIcon flipH() {
    return applyToIcons(MdiIcon::flipH);
  }

  public StateChangeMdiIcon flipNone() {
    return applyToIcons(MdiIcon::flipNone);
  }

  public StateChangeMdiIcon setSpin(boolean value) {
    return applyToIcons(icon -> icon.setSpin(value));
  }

  public StateChangeMdiIcon spin() {
    return setSpin(true);
  }

  public StateChangeMdiIcon noSpin() {
    return setSpin(false);
  }

  public StateChangeMdiIcon setActive(boolean value) {
    return applyToIcons(icon -> icon.setActive(value));
  }

  public StateChangeMdiIcon active() {
    return setActive(true);
  }

  public StateChangeMdiIcon inactive() {
    return setActive(false);
  }

  public StateChangeMdiIcon setContrast(MdiIcon.MdiContrast value) {
    return applyToIcons(icon -> icon.setContrast(value));
  }

  public StateChangeMdiIcon light() {
    return applyToIcons(MdiIcon::light);
  }

  public StateChangeMdiIcon dark() {
    return applyToIcons(MdiIcon::dark);
  }

  public StateChangeMdiIcon noContrast() {
    return applyToIcons(MdiIcon::noContrast);
  }
}
