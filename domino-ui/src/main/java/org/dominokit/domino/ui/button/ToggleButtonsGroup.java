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
package org.dominokit.domino.ui.button;

import static java.util.Objects.isNull;
import static java.util.Objects.nonNull;

import java.util.Collections;
import java.util.HashSet;
import java.util.Objects;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;
import org.dominokit.domino.ui.button.group.BaseButtonsGroup;
import org.dominokit.domino.ui.style.Color;
import org.dominokit.domino.ui.style.CssClass;
import org.dominokit.domino.ui.utils.HasChangeListeners;
import org.dominokit.domino.ui.utils.IsToggleGroup;

public class ToggleButtonsGroup extends BaseButtonsGroup<ToggleButtonsGroup, ToggleButton>
    implements IsToggleGroup<ToggleButton>,
        HasChangeListeners<ToggleButtonsGroup, Set<ToggleButton>> {

  private Set<ToggleButton> buttons;
  private boolean multipleToggle = false;
  private boolean pauseChangeListeners;
  private Set<ChangeListener<? super Set<ToggleButton>>> changeListeners;
  private CssClass cssToggleClass;

  /** Creates an empty ButtonsGroup */
  public ToggleButtonsGroup() {}

  /**
   * Creates a ButtonsGroup that holds the provided buttons
   *
   * @param buttons The set of {@link org.dominokit.domino.ui.button.IsButton} components to be
   *     appended to the ButtonsGroup
   */
  public ToggleButtonsGroup(ToggleButton... buttons) {
    super(buttons);
  }

  /**
   * Factory method to create an empty ButtonsGroup
   *
   * @return An empty {@link org.dominokit.domino.ui.button.group.ButtonsGroup}.
   */
  public static ToggleButtonsGroup create() {
    return new ToggleButtonsGroup();
  }

  /**
   * Factory method to create a ButtonsGroup that holds the provided buttons
   *
   * @param buttons The set of {@link org.dominokit.domino.ui.button.IsButton} components to be
   *     appended to the ButtonsGroup
   * @return A {@link ToggleButtonsGroup}
   */
  public static ToggleButtonsGroup create(ToggleButton... buttons) {
    return new ToggleButtonsGroup(buttons);
  }

  @Override
  public void onItemToggle(ToggleButton toggleItem) {
    if (getButtons().contains(toggleItem)) {
      if (isMultipleToggle()) {
        Set<ToggleButton> newValue =
            getButtons().stream().filter(ToggleButton::isToggled).collect(Collectors.toSet());
        Set<ToggleButton> oldValue = new HashSet<>(getButtons());
        if (toggleItem.isToggled()) {
          oldValue.remove(toggleItem);
        } else {
          oldValue.add(toggleItem);
        }
        triggerChangeListeners(oldValue, newValue);
      } else {
        Optional<ToggleButton> first =
            getButtons().stream()
                .filter(ToggleButton::isToggled)
                .filter(button -> !button.equals(toggleItem))
                .findFirst();
        if (first.isPresent()) {
          ToggleButton toggleButton = first.get();
          toggleButton.updateToggle(false, false);
          triggerChangeListeners(
              new HashSet<>(Collections.singleton(toggleButton)),
              new HashSet<>(Collections.singleton(toggleItem)));
        } else {
          triggerChangeListeners(new HashSet<>(), new HashSet<>(Collections.singleton(toggleItem)));
        }
      }
    }
  }

  public ToggleButtonsGroup toggleByKey(String key) {
    this.buttons.stream()
        .filter(button -> Objects.equals(button.getKey(), key))
        .findFirst()
        .ifPresent(ToggleButton::toggle);
    return this;
  }

  public boolean isMultipleToggle() {
    return multipleToggle;
  }

  public ToggleButtonsGroup setMultipleToggle(boolean multipleToggle) {
    this.multipleToggle = multipleToggle;
    return this;
  }

  @Override
  protected void onButtonAdded(ToggleButton btn) {
    getButtons().add(btn);
    if (nonNull(cssToggleClass)) {
      btn.setToggleCssClass(cssToggleClass);
    }
    btn.bindTo(this);
    //    btn.onDetached(mutationRecord -> getButtons().remove(btn));
    if (btn.isToggled()) {
      onItemToggle(btn);
    }
  }

  private Set<ToggleButton> getButtons() {
    if (isNull(this.buttons)) {
      this.buttons = new HashSet<>();
    }
    return this.buttons;
  }

  @Override
  public ToggleButtonsGroup pauseChangeListeners() {
    this.pauseChangeListeners = true;
    return this;
  }

  @Override
  public ToggleButtonsGroup resumeChangeListeners() {
    this.pauseChangeListeners = true;
    return this;
  }

  @Override
  public ToggleButtonsGroup togglePauseChangeListeners(boolean toggle) {
    this.pauseChangeListeners = toggle;
    return this;
  }

  @Override
  public Set<ChangeListener<? super Set<ToggleButton>>> getChangeListeners() {
    if (isNull(this.changeListeners)) {
      this.changeListeners = new HashSet<>();
    }
    return this.changeListeners;
  }

  @Override
  public boolean isChangeListenersPaused() {
    return this.pauseChangeListeners;
  }

  @Override
  public ToggleButtonsGroup triggerChangeListeners(
      Set<ToggleButton> oldValue, Set<ToggleButton> newValue) {
    if (!isChangeListenersPaused()) {
      getChangeListeners()
          .forEach(changeListener -> changeListener.onValueChanged(oldValue, newValue));
    }
    return this;
  }

  public ToggleButtonsGroup setToggleCssClass(CssClass toggleCssClass) {
    buttons.forEach(button -> button.setToggleCssClass(toggleCssClass));
    this.cssToggleClass = toggleCssClass;
    return this;
  }

  public ToggleButtonsGroup setToggledColors(Color background, Color forground) {
    this.setCssProperty("--dui-btn-toggled-bg", background.toVarValue());
    this.setCssProperty("--dui-btn-toggled-color", forground.toVarValue());
    return this;
  }

  @Override
  public ToggleButtonsGroup appendChild(ToggleButton... buttons) {
    return super.appendChild(buttons);
  }
}
