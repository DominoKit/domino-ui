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

import elemental2.dom.HTMLAnchorElement;
import org.dominokit.domino.ui.elements.AnchorElement;
import org.dominokit.domino.ui.icons.Icon;
import org.dominokit.domino.ui.utils.ChildHandler;

/**
 * This component is a Link being rendered as a button and provide the means to set the link href
 * attribute.
 */
public class LinkButton extends BaseButton<HTMLAnchorElement, LinkButton> {

  private AnchorElement anchorElement;

  /** Creates an empty LinkButton */
  public LinkButton() {}

  /**
   * Creates a LinkButton with text
   *
   * @param text String, the button text
   */
  public LinkButton(String text) {
    super(text);
  }

  /**
   * Creates a LinkButton with icon
   *
   * @param icon The button icon
   */
  public LinkButton(Icon<?> icon) {
    super(icon);
  }

  /**
   * Creates a LinkButton with icon and text
   *
   * @param icon The button icon
   * @param text the button text
   */
  public LinkButton(Icon<?> icon, String text) {
    super(text, icon);
  }

  /**
   * Factory method to create an empty LinkButton
   *
   * @return new Button instance
   */
  public static LinkButton create() {
    return new LinkButton();
  }

  /**
   * Factory method to create a LinkButton with text
   *
   * @param text String button text
   * @return new Button instance
   */
  public static LinkButton create(String text) {
    return new LinkButton(text);
  }

  /**
   * Factory method to create a LinkButton with icon
   *
   * @param icon {@link org.dominokit.domino.ui.icons.Icon}, the button icon
   * @return new Button instance
   */
  public static LinkButton create(Icon<?> icon) {
    return new LinkButton(icon);
  }

  /**
   * Factory method to create a LinkButton with text and icon.
   *
   * @param icon {@link org.dominokit.domino.ui.icons.Icon}, the button icon
   * @param text a {@link java.lang.String} object
   * @return new Button instance
   */
  public static LinkButton create(Icon<?> icon, String text) {
    return new LinkButton(icon, text);
  }

  /** @dominokit-site-ignore {@inheritDoc} */
  @Override
  protected AnchorElement createButtonElement() {
    return anchorElement = a().removeHref();
  }

  /**
   * Use to apply customization to the AnchorElement component of this LinkButton instance without
   * breaking the fluent API chain. {@link ChildHandler}
   *
   * @param handler a {@link ChildHandler} that applies the customization.
   * @return same LinkButton instance
   */
  public LinkButton withAnchorElement(ChildHandler<LinkButton, AnchorElement> handler) {
    handler.apply(this, anchorElement);
    return this;
  }

  /**
   * Sets the href attribute for this LinkButton AnchorElement
   *
   * @param href the href attribute value
   * @return same LinkButton instance
   */
  public LinkButton setHref(String href) {
    anchorElement.setHref(href);
    return this;
  }

  /**
   * clears the href attribute for this LinkButton AnchorElement
   *
   * @return same LinkButton instance
   */
  public LinkButton removeHref() {
    anchorElement.removeHref();
    return this;
  }
}
