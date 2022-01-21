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
package org.dominokit.domino.ui.alerts;

import static java.util.Objects.nonNull;
import static org.jboss.elemento.Elements.*;

import elemental2.dom.HTMLAnchorElement;
import elemental2.dom.HTMLButtonElement;
import elemental2.dom.HTMLDivElement;
import org.dominokit.domino.ui.Typography.Strong;
import org.dominokit.domino.ui.style.Color;
import org.dominokit.domino.ui.style.Elevation;
import org.dominokit.domino.ui.style.Style;
import org.dominokit.domino.ui.style.Styles;
import org.dominokit.domino.ui.utils.BaseDominoElement;
import org.dominokit.domino.ui.utils.DominoElement;
import org.dominokit.domino.ui.utils.HasBackground;
import org.dominokit.domino.ui.utils.TextNode;

/**
 * Displays messages on the screen.
 *
 * <p>This component provides four basic types of severity:
 *
 * <ul>
 *   <li>Success
 *   <li>Info
 *   <li>Warning
 *   <li>Error
 * </ul>
 *
 * <p>Customize the component can be done by overwriting classes provided by {@link AlertStyles}
 *
 * <p>For example:
 *
 * <pre>
 *     Alert.success()
 *          .appendChild("Well done! ")
 *          .appendChild("You successfully read this important alert message.")
 * </pre>
 *
 * @see BaseDominoElement
 * @see HasBackground
 * @see Color
 */
public class Alert extends BaseDominoElement<HTMLDivElement, Alert>
    implements HasBackground<Alert> {

  /** Alert severity levels */
  public enum AlertType {
    /** Success severity */
    SUCCESS(AlertStyles.SUCCESS),
    /** Info severity */
    INFO(AlertStyles.INFO),
    /** Warning severity */
    WARNING(AlertStyles.WARNING),
    /** Error severity */
    ERROR(AlertStyles.ERROR);

    private final String style;

    AlertType(String style) {
      this.style = style;
    }
  }

  private Color background;
  private boolean dismissible = false;
  private final DominoElement<HTMLDivElement> element =
      DominoElement.of(div()).css(AlertStyles.ALERT).elevate(Elevation.LEVEL_1);

  public Alert() {
    init(this);
  }

  private final HTMLButtonElement closeButton =
      DominoElement.of(button())
          .attr("type", "button")
          .css(AlertStyles.CLOSE)
          .attr("aria-label", "Close")
          .add(span().attr("aria-hidden", "true").textContent("×"))
          .element();

  private static Alert create(AlertType type) {
    Alert alert = create();
    alert.element.addCss(type.style);
    return alert;
  }

  /**
   * Creates alert with background color
   *
   * @param background the background color
   * @return new alert instance
   */
  public static Alert create(Color background) {
    Alert alert = create();
    alert.addCss(background.getBackground());
    alert.background = background;
    return alert;
  }

  /**
   * Creates alert with default style
   *
   * @return new alert instance
   */
  public static Alert create() {
    Alert alert = new Alert();
    alert.closeButton.addEventListener("click", e -> alert.element().remove());
    return alert;
  }

  /**
   * Creates alert with success severity
   *
   * @return new alert instance
   */
  public static Alert success() {
    return create(AlertType.SUCCESS);
  }

  /**
   * Creates alert with info severity
   *
   * @return new alert instance
   */
  public static Alert info() {
    return create(AlertType.INFO);
  }

  /**
   * Creates alert with warning severity
   *
   * @return new alert instance
   */
  public static Alert warning() {
    return create(AlertType.WARNING);
  }

  /**
   * Creates alert with error severity
   *
   * @return new alert instance
   */
  public static Alert error() {
    return create(AlertType.ERROR);
  }

  /** {@inheritDoc} */
  @Override
  public Alert setBackground(Color background) {
    if (nonNull(background)) element.removeCss(this.background.getBackground());
    this.background = background;
    element.addCss(this.background.getBackground());
    return this;
  }

  /**
   * Adds {@link Strong} as a child
   *
   * @param strong the element to add
   * @return same instance
   */
  public Alert appendChild(Strong strong) {
    element.appendChild(strong.element());
    return this;
  }

  /**
   * Adds text as a child, the {@code text} will be added in {@link TextNode}
   *
   * @param text the content
   * @return same instance
   */
  public Alert appendChild(String text) {
    element.appendChild(TextNode.of(text));
    return this;
  }

  /**
   * Adds anchor element as a child, this method adds {@link Styles#alert_link} style to anchor
   * element by default
   *
   * @param anchorElement the element
   * @return same instance
   */
  public Alert appendChild(HTMLAnchorElement anchorElement) {
    if (nonNull(anchorElement)) {
      Style.of(anchorElement).addCss(Styles.alert_link);
      element.appendChild(anchorElement);
    }
    return this;
  }

  /**
   * Adds {@link AlertLink} as a child
   *
   * @param alertLink the element
   * @return same instance
   * @see AlertLink
   */
  public Alert appendChild(AlertLink alertLink) {
    return appendChild(alertLink.element());
  }

  /** use {@link Alert#setDismissible(boolean)} instead */
  @Deprecated
  public Alert setDissmissible(boolean dismissible) {
    return setDismissible(dismissible);
  }

  /**
   * Passing true means that the alert will be closable and a close button will be added to the
   * element to hide it
   *
   * @param dismissible true to set it as closable, false otherwise
   * @return same instance
   */
  public Alert setDismissible(boolean dismissible) {
    if (dismissible) {
      return dismissible();
    } else {
      return unDismissible();
    }
  }

  /**
   * Sets the alert to closable and a close button will be added to the element to hide it
   *
   * @return same instance
   */
  public Alert dismissible() {
    if (!dismissible) {
      element.addCss(AlertStyles.ALERT_DISMISSIBLE);
      if (element.getChildElementCount() > 0) element.insertFirst(closeButton);
      else element.appendChild(closeButton);
    }
    dismissible = true;
    return this;
  }

  /**
   * Sets the alert to not closable and the close button will be removed if exist, the alert can be
   * hidden programmatically using {@link Alert#remove()}
   *
   * @return same instance
   */
  public Alert unDismissible() {
    if (dismissible) {
      element.removeCss(AlertStyles.ALERT_DISMISSIBLE);
      element.removeChild(closeButton);
    }
    dismissible = false;
    return this;
  }

  /** @return true if the alert is closable, false otherwise */
  public boolean isDismissible() {
    return dismissible;
  }

  /**
   * Returns the close button for customization
   *
   * @return the close button element
   */
  public HTMLButtonElement getCloseButton() {
    return closeButton;
  }

  /** {@inheritDoc} */
  @Override
  public HTMLDivElement element() {
    return element.element();
  }
}
