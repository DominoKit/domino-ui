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
import org.dominokit.domino.ui.icons.BaseIcon;
import org.dominokit.domino.ui.style.Elevation;
import org.dominokit.domino.ui.utils.DominoElement;

/**
 * a simple button component
 *
 * <p>this class provide a set of factory methods to create simple buttons with different styles and
 * a combination of a text and icon. example
 *
 * <pre>
 *         Button.create("submit")
 *              .addClickListener(evt-&gt; //handle the event);
 *     </pre>
 *
 * <pre>
 *         Button.create(Icons.ALL.content_save_mdi(), "Save")
 *              .addClickListener(evt-&gt; //handle the event);
 *     </pre>
 *
 * <pre>
 *         Button.createPrimary("Approve")
 *              .addClickListener(evt-&gt; //handle the event);
 *     </pre>
 */
public class Button extends BaseButton<HTMLButtonElement, Button> {

  /** creates a Button without a text and with {@link Elevation#LEVEL_1} */
  public Button() {}

  /**
   * create a Button with a text and with {@link Elevation#LEVEL_1}
   *
   * @param text String, the button text
   */
  public Button(String text) {
    super(text);
  }

  /**
   * creates a Button with an icon and {@link Elevation#LEVEL_1}
   *
   * @param icon The button icon
   */
  public Button(BaseIcon<?> icon) {
    super(icon);
  }

  public Button(String text, BaseIcon<?> icon) {
    super(text, icon);
  }

  /**
   * creats a Button using {@link Button#Button()}
   *
   * @return new Button instance
   */
  public static Button create() {
    return new Button();
  }

  /**
   * create a button using {@link Button#Button(String)}
   *
   * @param text String button text
   * @return new Button instance
   */
  public static Button create(String text) {
    return new Button(text);
  }

  /**
   * creates a Button with an icon by calling {@link Button#Button(BaseIcon)}
   *
   * @param icon {@link BaseIcon}, the button icon
   * @return new Button instance
   */
  public static Button create(BaseIcon<?> icon) {
    return new Button(icon);
  }

  /**
   * creates a Button with an icon by calling {@link Button#Button(BaseIcon)}
   *
   * @param icon {@link BaseIcon}, the button icon
   * @return new Button instance
   */
  public static Button create(String text, BaseIcon<?> icon) {
    return new Button(text, icon);
  }

  /**
   * creates a Button with an icon by calling {@link Button#Button(BaseIcon)}
   *
   * @param icon {@link BaseIcon}, the button icon
   * @return new Button instance
   */
  public static Button create(BaseIcon<?> icon, String text) {
    return new Button(text, icon);
  }

  @Override
  protected DominoElement<HTMLButtonElement> createButtonElement() {
    return button();
  }
}
