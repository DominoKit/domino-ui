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

import elemental2.dom.HTMLElement;
import org.dominokit.domino.ui.icons.BaseIcon;
import org.dominokit.domino.ui.style.Elevation;
import org.dominokit.domino.ui.style.StyleType;

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
public class Button extends BaseButton<Button> {

  /** creates a Button without a text and with {@link Elevation#LEVEL_1} */
  public Button() {
    init(this);
    elevate(Elevation.LEVEL_1);
  }

  /**
   * create a Button with a text and with {@link Elevation#LEVEL_1}
   *
   * @param text String, the button text
   */
  public Button(String text) {
    this();
    setContent(text);
  }

  /**
   * creates a Button with a text and apply a {@link StyleType}
   *
   * @param text String, the button text
   * @param type {@link StyleType}
   */
  public Button(String text, StyleType type) {
    this(text);
    setButtonType(type);
  }

  /**
   * creates a Button with an icon and {@link Elevation#LEVEL_1}
   *
   * @param icon The button icon
   */
  public Button(BaseIcon<?> icon) {
    super(icon);
    init(this);
    elevate(Elevation.LEVEL_1);
  }

  /**
   * creates a Button with an icon and apply a {@link StyleType}
   *
   * @param icon the button icon
   * @param type {@link StyleType}
   */
  public Button(BaseIcon<?> icon, StyleType type) {
    this(icon);
    setButtonType(type);
  }

  private static Button create(String text, StyleType type) {
    return new Button(text, type);
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
   * creates a Button with a text and apply {@link StyleType#DEFAULT}
   *
   * @param text String, the button text
   * @return new Button instance
   */
  public static Button createDefault(String text) {
    return create(text, StyleType.DEFAULT);
  }

  /**
   * creates a Button with a text and apply {@link StyleType#PRIMARY}
   *
   * @param text String, the button text
   * @return new Button instance
   */
  public static Button createPrimary(String text) {
    return create(text, StyleType.PRIMARY);
  }

  /**
   * creates a Button with a text and apply {@link StyleType#SUCCESS}
   *
   * @param text String, the button text
   * @return new Button instance
   */
  public static Button createSuccess(String text) {
    return create(text, StyleType.SUCCESS);
  }

  /**
   * creates a Button with a text and apply {@link StyleType#INFO}
   *
   * @param text String, the button text
   * @return new Button instance
   */
  public static Button createInfo(String text) {
    return create(text, StyleType.INFO);
  }

  /**
   * creates a Button with a text and apply {@link StyleType#WARNING}
   *
   * @param text String, the button text
   * @return new Button instance
   */
  public static Button createWarning(String text) {
    return create(text, StyleType.WARNING);
  }

  /**
   * creates a Button with a text and apply {@link StyleType#DANGER}
   *
   * @param text String, the button text
   * @return new Button instance
   */
  public static Button createDanger(String text) {
    return create(text, StyleType.DANGER);
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

  private static Button create(BaseIcon<?> icon, StyleType type) {
    return new Button(icon, type);
  }

  /**
   * creates a Button with an icon and apply {@link StyleType#DEFAULT}
   *
   * @param icon {@link BaseIcon}, the button icon
   * @return new Button instance
   */
  public static Button createDefault(BaseIcon<?> icon) {
    return create(icon, StyleType.DEFAULT);
  }

  /**
   * creates a Button with an icon and apply {@link StyleType#PRIMARY}
   *
   * @param icon {@link BaseIcon}, the button icon
   * @return new Button instance
   */
  public static Button createPrimary(BaseIcon<?> icon) {
    return create(icon, StyleType.PRIMARY);
  }

  /**
   * creates a Button with an icon and apply {@link StyleType#SUCCESS}
   *
   * @param icon {@link BaseIcon}, the button icon
   * @return new Button instance
   */
  public static Button createSuccess(BaseIcon<?> icon) {
    return create(icon, StyleType.SUCCESS);
  }

  /**
   * creates a Button with an icon and apply {@link StyleType#INFO}
   *
   * @param icon {@link BaseIcon}, the button icon
   * @return new Button instance
   */
  public static Button createInfo(BaseIcon<?> icon) {
    return create(icon, StyleType.INFO);
  }

  /**
   * creates a Button with an icon and apply {@link StyleType#WARNING}
   *
   * @param icon {@link BaseIcon}, the button icon
   * @return new Button instance
   */
  public static Button createWarning(BaseIcon<?> icon) {
    return create(icon, StyleType.WARNING);
  }

  /**
   * creates a Button with an icon and apply {@link StyleType#DANGER}
   *
   * @param icon {@link BaseIcon}, the button icon
   * @return new Button instance
   */
  public static Button createDanger(BaseIcon<?> icon) {
    return create(icon, StyleType.DANGER);
  }

  /** {@inheritDoc} */
  @Override
  public HTMLElement element() {
    return buttonElement.element();
  }
}
