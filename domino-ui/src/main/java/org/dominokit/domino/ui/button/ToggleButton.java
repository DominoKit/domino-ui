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
import static org.dominokit.domino.ui.button.ButtonStyles.dui_toggle_button;
import static org.dominokit.domino.ui.utils.Domino.button;

import elemental2.dom.HTMLButtonElement;
import java.util.HashSet;
import java.util.Set;
import org.dominokit.domino.ui.elements.ButtonElement;
import org.dominokit.domino.ui.icons.Icon;
import org.dominokit.domino.ui.style.BooleanCssClass;
import org.dominokit.domino.ui.style.Color;
import org.dominokit.domino.ui.style.CssClass;
import org.dominokit.domino.ui.utils.HasChangeListeners;
import org.dominokit.domino.ui.utils.HasValue;
import org.dominokit.domino.ui.utils.IsToggleGroup;
import org.dominokit.domino.ui.utils.IsToggleItem;
import org.gwtproject.editor.client.TakesValue;

public class ToggleButton extends BaseButton<HTMLButtonElement, ToggleButton>
    implements HasChangeListeners<ToggleButton, Boolean>,
        IsToggleItem<ToggleButton>,
        TakesValue<Boolean>,
        HasValue<ToggleButton, Boolean> {

  private CssClass toggleCssClass = () -> "dui-btn-toggled";
  private boolean changeListenersPaused;
  private Set<ChangeListener<? super Boolean>> changeListeners;
  private boolean state = false;
  private IsToggleGroup<ToggleButton> group;
  private String key;

  /** Creates an empty button */
  public ToggleButton() {}

  /**
   * create a Button with a text.
   *
   * @param text String, the button text
   */
  public ToggleButton(String text) {
    super(text);
  }

  /**
   * Creates a Button with an icon
   *
   * @param icon The button icon
   */
  public ToggleButton(Icon<?> icon) {
    super(icon);
  }

  /**
   * Creates button with text and icon
   *
   * @param text The button text
   * @param icon The button icon
   */
  public ToggleButton(String text, Icon<?> icon) {
    super(text, icon);
  }

  /**
   * Factory method to create empty button
   *
   * @return new Button instance
   */
  public static ToggleButton create() {
    return new ToggleButton();
  }

  /**
   * Factory method to create a button with a text.
   *
   * @param text The button text
   * @return new Button instance
   */
  public static ToggleButton create(String text) {
    return new ToggleButton(text);
  }

  /**
   * Factory method to create a button with an icon.
   *
   * @param icon the button icon
   * @return new Button instance
   */
  public static ToggleButton create(Icon<?> icon) {
    return new ToggleButton(icon);
  }

  /**
   * Factory method to create button with a text and icon.
   *
   * @param text a {@link java.lang.String} object
   * @param icon the button icon
   * @return new Button instance
   */
  public static ToggleButton create(String text, Icon<?> icon) {
    return new ToggleButton(text, icon);
  }

  /**
   * Factory method to create button with a text and icon.
   *
   * @param icon the button icon
   * @param text a {@link java.lang.String} object
   * @return new Button instance
   */
  public static ToggleButton create(Icon<?> icon, String text) {
    return new ToggleButton(text, icon);
  }

  @Override
  protected void prepare() {
    addCss(dui_toggle_button);
    this.addClickListener(
        evt -> {
          boolean state = isToggled();
          if (nonNull(group) && (!group.isMultipleToggle() && state)) {
            return;
          }
          setToggle(!isToggled());
        });
  }

  public ToggleButton setToggle(boolean toggle, boolean silent) {
    withPauseChangeListenersToggle(silent, toggleButton -> updateToggle(toggle, true));
    return this;
  }

  ToggleButton updateToggle(boolean toggle, boolean notifyParent) {
    boolean oldState = this.state;
    this.state = toggle;
    addCss(BooleanCssClass.of(toggleCssClass, toggle));
    if (this.state != oldState) {
      withPauseChangeListenersToggle(
          isChangeListenersPaused(), toggleButton -> triggerChangeListeners(oldState, this.state));
      if (nonNull(group) && notifyParent) {
        this.group.onItemToggle(this);
      }
    }
    return this;
  }

  public boolean isToggled() {
    return this.state;
  }

  /**
   * @dominokit-site-ignore {@inheritDoc}
   */
  @Override
  protected ButtonElement createButtonElement() {
    return button();
  }

  @Override
  public ToggleButton pauseChangeListeners() {
    this.changeListenersPaused = true;
    return this;
  }

  @Override
  public ToggleButton resumeChangeListeners() {
    this.changeListenersPaused = false;
    return this;
  }

  @Override
  public ToggleButton togglePauseChangeListeners(boolean toggle) {
    this.changeListenersPaused = toggle;
    return this;
  }

  @Override
  public Set<ChangeListener<? super Boolean>> getChangeListeners() {
    if (isNull(this.changeListeners)) {
      this.changeListeners = new HashSet<>();
    }
    return this.changeListeners;
  }

  @Override
  public boolean isChangeListenersPaused() {
    return this.changeListenersPaused;
  }

  @Override
  public ToggleButton triggerChangeListeners(Boolean oldValue, Boolean newValue) {
    if (!isChangeListenersPaused()) {
      getChangeListeners()
          .forEach(changeListener -> changeListener.onValueChanged(oldValue, newValue));
    }
    return this;
  }

  @Override
  public ToggleButton bindTo(IsToggleGroup<ToggleButton> toggleGroup) {
    this.group = toggleGroup;
    return this;
  }

  @Override
  public ToggleButton toggle() {
    return setToggle(!isToggled());
  }

  @Override
  public ToggleButton toggle(boolean silent) {
    return setToggle(!isToggled(), silent);
  }

  @Override
  public ToggleButton setToggle(boolean value) {
    return setToggle(value, isChangeListenersPaused());
  }

  @Override
  public ToggleButton setKey(String key) {
    this.key = key;
    return this;
  }

  @Override
  public String getKey() {
    return this.key;
  }

  public CssClass getToggleCssClass() {
    return toggleCssClass;
  }

  public ToggleButton setToggleCssClass(CssClass toggleCssClass) {
    if (isNull(toggleCssClass)) {
      this.toggleCssClass = CssClass.NONE;
    } else {
      this.toggleCssClass = toggleCssClass;
    }
    return this;
  }

  public ToggleButton setToggledColors(Color background, Color forground) {
    this.setCssProperty("--dui-btn-toggled-bg", background.toVarValue());
    this.setCssProperty("--dui-btn-toggled-color", forground.toVarValue());
    return this;
  }

  public Boolean getValue() {
    return state;
  }

  @Override
  public ToggleButton withValue(Boolean value) {
    return withValue(value, isChangeListenersPaused());
  }

  @Override
  public ToggleButton withValue(Boolean value, boolean silent) {
    setToggle(value, silent);
    return this;
  }

  @Override
  public void setValue(Boolean value) {
    setToggle(value);
  }
}
