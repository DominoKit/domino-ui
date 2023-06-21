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

import elemental2.dom.HTMLButtonElement;
import org.dominokit.domino.ui.elements.ButtonElement;
import org.dominokit.domino.ui.icons.Icon;

/**
 * a simple button component
 *
 * <p>this class provide a set of factory methods to create simple buttons with different styles and
 * a combination of a text and icon. example
 *
 * @author vegegoku
 * @version $Id: $Id
 */
public class Button extends BaseButton<HTMLButtonElement, Button> {

  /**
   * creates a Button without a text and with {@link
   * org.dominokit.domino.ui.style.Elevation#LEVEL_1}
   */
  public Button() {}

  /**
   * create a Button with a text and with {@link org.dominokit.domino.ui.style.Elevation#LEVEL_1}
   *
   * @param text String, the button text
   */
  public Button(String text) {
    super(text);
  }

  /**
   * creates a Button with an icon and {@link org.dominokit.domino.ui.style.Elevation#LEVEL_1}
   *
   * @param icon The button icon
   */
  public Button(Icon<?> icon) {
    super(icon);
  }

  /**
   * Constructor for Button.
   *
   * @param text a {@link java.lang.String} object
   * @param icon a {@link org.dominokit.domino.ui.icons.Icon} object
   */
  public Button(String text, Icon<?> icon) {
    super(text, icon);
  }

  /**
   * creats a Button using {@link org.dominokit.domino.ui.button.Button#Button()}
   *
   * @return new Button instance
   */
  public static Button create() {
    return new Button();
  }

  /**
   * create a button using {@link org.dominokit.domino.ui.button.Button#Button(String)}
   *
   * @param text String button text
   * @return new Button instance
   */
  public static Button create(String text) {
    return new Button(text);
  }

  /**
   * creates a Button with an icon by calling {@link
   * org.dominokit.domino.ui.button.Button#Button(Icon)}
   *
   * @param icon {@link org.dominokit.domino.ui.icons.Icon}, the button icon
   * @return new Button instance
   */
  public static Button create(Icon<?> icon) {
    return new Button(icon);
  }

  /**
   * creates a Button with an icon by calling {@link
   * org.dominokit.domino.ui.button.Button#Button(Icon)}
   *
   * @param icon {@link org.dominokit.domino.ui.icons.Icon}, the button icon
   * @return new Button instance
   * @param text a {@link java.lang.String} object
   */
  public static Button create(String text, Icon<?> icon) {
    return new Button(text, icon);
  }

  /**
   * creates a Button with an icon by calling {@link
   * org.dominokit.domino.ui.button.Button#Button(Icon)}
   *
   * @param icon {@link org.dominokit.domino.ui.icons.Icon}, the button icon
   * @return new Button instance
   * @param text a {@link java.lang.String} object
   */
  public static Button create(Icon<?> icon, String text) {
    return new Button(text, icon);
  }

  /** {@inheritDoc} */
  @Override
  protected ButtonElement createButtonElement() {
    return button();
  }
}
