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

import elemental2.dom.HTMLAnchorElement;
import org.dominokit.domino.ui.elements.AnchorElement;
import org.dominokit.domino.ui.icons.Icon;
import org.dominokit.domino.ui.style.Elevation;

public class LinkButton extends BaseButton<HTMLAnchorElement, LinkButton> {

  /** creates a Button without a text and with {@link Elevation#LEVEL_1} */
  public LinkButton() {}

  /** @param text String, the button text */
  public LinkButton(String text) {
    super(text);
  }

  /** @param icon The button icon */
  public LinkButton(Icon<?> icon) {
    super(icon);
  }

  public LinkButton(String text, Icon<?> icon) {
    super(text, icon);
  }

  /**
   * creats a Button using {@link Button#Button()}
   *
   * @return new Button instance
   */
  public static LinkButton create() {
    return new LinkButton();
  }

  /**
   * create a button using {@link Button#Button(String)}
   *
   * @param text String button text
   * @return new Button instance
   */
  public static LinkButton create(String text) {
    return new LinkButton(text);
  }

  /**
   * creates a Button with an icon by calling {@link Button#Button(Icon)}
   *
   * @param icon {@link Icon}, the button icon
   * @return new Button instance
   */
  public static LinkButton create(Icon<?> icon) {
    return new LinkButton(icon);
  }

  /**
   * creates a Button with an icon by calling {@link LinkButton#LinkButton(Icon)}
   *
   * @param icon {@link Icon}, the button icon
   * @return new Button instance
   */
  public static LinkButton create(String text, Icon<?> icon) {
    return new LinkButton(text, icon);
  }

  @Override
  protected AnchorElement createButtonElement() {
    return a();
  }
}
