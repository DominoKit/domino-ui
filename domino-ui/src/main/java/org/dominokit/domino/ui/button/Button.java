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

import static org.dominokit.domino.ui.utils.Domino.*;

import elemental2.dom.HTMLButtonElement;
import org.dominokit.domino.ui.elements.ButtonElement;
import org.dominokit.domino.ui.icons.Icon;

/**
 * a simple button component
 *
 * <p>this class provide a set of factory methods to create simple buttons with different styles and
 * a combination of a text and icon.
 */
public class Button extends BaseButton<HTMLButtonElement, Button> {

  /** Creates an empty button */
  public Button() {}

  /**
   * create a Button with a text.
   *
   * @param text String, the button text
   */
  public Button(String text) {
    super(text);
  }

  /**
   * Creates a Button with an icon
   *
   * @param icon The button icon
   */
  public Button(Icon<?> icon) {
    super(icon);
  }

  /**
   * Creates button with text and icon
   *
   * @param text The button text
   * @param icon The button icon
   */
  public Button(String text, Icon<?> icon) {
    super(text, icon);
  }

  /**
   * Factory method to create empty button
   *
   * @return new Button instance
   */
  public static Button create() {
    return new Button();
  }

  /**
   * Factory method to create a button with a text.
   *
   * @param text The button text
   * @return new Button instance
   */
  public static Button create(String text) {
    return new Button(text);
  }

  /**
   * Factory method to create a button with an icon.
   *
   * @param icon the button icon
   * @return new Button instance
   */
  public static Button create(Icon<?> icon) {
    return new Button(icon);
  }

  /**
   * Factory method to create button with a text and icon.
   *
   * @param text a {@link java.lang.String} object
   * @param icon the button icon
   * @return new Button instance
   */
  public static Button create(String text, Icon<?> icon) {
    return new Button(text, icon);
  }

  /**
   * Factory method to create button with a text and icon.
   *
   * @param icon the button icon
   * @param text a {@link java.lang.String} object
   * @return new Button instance
   */
  public static Button create(Icon<?> icon, String text) {
    return new Button(text, icon);
  }

  /** @dominokit-site-ignore {@inheritDoc} */
  @Override
  protected ButtonElement createButtonElement() {
    return button();
  }
}
