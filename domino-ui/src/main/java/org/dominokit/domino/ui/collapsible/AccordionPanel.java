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
package org.dominokit.domino.ui.collapsible;

import static java.util.Objects.nonNull;
import static org.jboss.elemento.Elements.*;

import elemental2.dom.*;
import org.dominokit.domino.ui.icons.BaseIcon;
import org.dominokit.domino.ui.style.Color;
import org.dominokit.domino.ui.style.Elevation;
import org.dominokit.domino.ui.utils.BaseDominoElement;
import org.dominokit.domino.ui.utils.DominoElement;
import org.dominokit.domino.ui.utils.DominoUIConfig;
import org.dominokit.domino.ui.utils.IsCollapsible;
import org.jboss.elemento.IsElement;

/**
 * A component to show/hide content inside an {@link Accordion}
 *
 * <p>The accordion panel can be appended to an Accordion to show/hide some content when the user
 * clicks on the panel header
 *
 * @see Accordion
 */
public class AccordionPanel extends BaseDominoElement<HTMLDivElement, AccordionPanel>
    implements IsCollapsible<AccordionPanel> {

  private DominoElement<HTMLDivElement> element =
      DominoElement.of(div().css(CollapsibleStyles.PANEL)).elevate(Elevation.LEVEL_1);
  private DominoElement<HTMLDivElement> headerElement =
      DominoElement.of(div().css(CollapsibleStyles.PANEL_HEADING).attr("role", "tab"));
  private DominoElement<HTMLHeadingElement> headingElement =
      DominoElement.of(h(4).css(CollapsibleStyles.PANEL_TITLE));
  private DominoElement<HTMLAnchorElement> clickableElement =
      DominoElement.of(a().attr("role", "button"));
  private DominoElement<HTMLDivElement> collapsibleElement =
      DominoElement.of(div().css(CollapsibleStyles.PANEL_COLLAPSE));
  private DominoElement<HTMLDivElement> bodyElement =
      DominoElement.of(div().css(CollapsibleStyles.PANEL_BODY));
  private Color headerColor;
  private Color bodyColor;
  private BaseIcon<?> panelIcon;

  /** @param title String, the accordion panel header title */
  public AccordionPanel(String title) {
    clickableElement.setTextContent(title);
    init();
  }

  /**
   * @param title String, the accordion panel header title
   * @param content {@link Node} the content of the panel body
   */
  public AccordionPanel(String title, Node content) {
    clickableElement.setTextContent(title);
    bodyElement.appendChild(content);
    init();
  }

  /**
   * A factory to create Accordion panel with a title
   *
   * @param title String, the accordion panel header title
   * @return new Accordion instance
   */
  public static AccordionPanel create(String title) {
    return new AccordionPanel(title);
  }

  /**
   * A factory to create Accordion panel with a title and content
   *
   * @param title String, the accordion panel header title
   * @param content {@link Node} the content of the panel body
   * @return new Accordion instance
   */
  public static AccordionPanel create(String title, Node content) {
    return new AccordionPanel(title, content);
  }

  /**
   * A factory to create Accordion panel with a title and content
   *
   * @param title String, the accordion panel header title
   * @param content {@link IsElement} the content of the panel body
   * @return new Accordion instance
   */
  public static AccordionPanel create(String title, IsElement<?> content) {
    return new AccordionPanel(title, content.element());
  }

  private void init() {
    element.appendChild(headerElement);
    headerElement.appendChild(headingElement);
    headingElement.appendChild(clickableElement);
    collapsibleElement.appendChild(bodyElement);
    element.appendChild(collapsibleElement);
    init(this);
    setCollapseStrategy(
        DominoUIConfig.INSTANCE.getDefaultAccordionCollapseStrategySupplier().get());
    hide();
  }

  /**
   * Change the panel header title.
   *
   * @param title String, the accordion panel header title
   * @return same AccordionPanel instance
   */
  public AccordionPanel setTitle(String title) {
    clickableElement.setTextContent(title);
    return this;
  }

  /**
   * Change the panel body content. replacing existing content with the one.
   *
   * @param content {@link Node}, the accordion panel body content
   * @return same AccordionPanel instance
   */
  public AccordionPanel setContent(Node content) {
    bodyElement.setTextContent("");
    return appendChild(content);
  }

  /**
   * add content to the panel body without removing existing content
   *
   * @param content {@link Node}, the accordion panel body content
   * @return same AccordionPanel instance
   */
  public AccordionPanel appendChild(Node content) {
    bodyElement.appendChild(content);
    return this;
  }

  /**
   * add content to the panel body without removing existing content
   *
   * @param content {@link IsElement}, the accordion panel body content
   * @return same AccordionPanel instance
   */
  public AccordionPanel appendChild(IsElement<?> content) {
    return appendChild(content.element());
  }

  /** {@inheritDoc} */
  @Override
  public HTMLDivElement element() {
    return element.element();
  }

  /**
   * Set the header background to {@link Color#BLUE}
   *
   * @return same AccordionPanel instance
   */
  public AccordionPanel primary() {
    return setHeaderBackground(Color.BLUE);
  }

  /**
   * Set the header background to {@link Color#GREEN}
   *
   * @return same AccordionPanel instance
   */
  public AccordionPanel success() {
    return setHeaderBackground(Color.GREEN);
  }

  /**
   * Set the header background to {@link Color#ORANGE}
   *
   * @return same AccordionPanel instance
   */
  public AccordionPanel warning() {
    return setHeaderBackground(Color.ORANGE);
  }

  /**
   * Set the header background to {@link Color#RED}
   *
   * @return same AccordionPanel instance
   */
  public AccordionPanel danger() {
    return setHeaderBackground(Color.RED);
  }

  /**
   * Set the header and body background to {@link Color#BLUE}
   *
   * @return same AccordionPanel instance
   */
  public AccordionPanel primaryFull() {
    setHeaderBackground(Color.BLUE);
    setBodyBackground(Color.BLUE);
    return this;
  }

  /**
   * Set the header and body background to {@link Color#GREEN}
   *
   * @return same AccordionPanel instance
   */
  public AccordionPanel successFull() {
    setHeaderBackground(Color.GREEN);
    setBodyBackground(Color.GREEN);
    return this;
  }

  /**
   * Set the header and body background to {@link Color#ORANGE}
   *
   * @return same AccordionPanel instance
   */
  public AccordionPanel warningFull() {
    setHeaderBackground(Color.ORANGE);
    setBodyBackground(Color.ORANGE);
    return this;
  }

  /**
   * Set the header and body background to {@link Color#RED}
   *
   * @return same AccordionPanel instance
   */
  public AccordionPanel dangerFull() {
    setHeaderBackground(Color.RED);
    setBodyBackground(Color.RED);
    return this;
  }

  /**
   * Set the header background to a custom color
   *
   * @param color {@link Color} the new background color
   * @return same AccordionPanel instance
   */
  public AccordionPanel setHeaderBackground(Color color) {
    if (nonNull(this.headerColor)) {
      getHeaderElement().removeCss(this.headerColor.getBackground());
    }
    getHeaderElement().addCss(color.getBackground());

    this.headerColor = color;

    return this;
  }

  /**
   * Set the body background to a custom color
   *
   * @param color {@link Color} the new background color
   * @return same AccordionPanel instance
   */
  public AccordionPanel setBodyBackground(Color color) {
    if (nonNull(this.bodyColor)) {
      getBodyElement().removeCss(this.bodyColor.getBackground());
    }
    getBodyElement().addCss(color.getBackground());

    this.bodyColor = color;

    return this;
  }

  /**
   * Set the Accordion panel header icon
   *
   * @param icon {@link BaseIcon}
   * @return same AccordionPanel instance
   */
  public AccordionPanel setIcon(BaseIcon<?> icon) {
    if (nonNull(this.panelIcon)) {
      panelIcon.remove();
    }

    panelIcon = icon;
    clickableElement.insertFirst(icon);

    return this;
  }

  /**
   * @deprecated
   * @return the {@link DominoElement} represent the body element.
   */
  @Deprecated
  public DominoElement<HTMLDivElement> getBody() {
    return DominoElement.of(bodyElement);
  }

  /** {@inheritDoc} */
  @Override
  public HTMLAnchorElement getClickableElement() {
    return clickableElement.element();
  }

  /** {@inheritDoc} */
  @Override
  public HTMLDivElement getCollapsibleElement() {
    return collapsibleElement.element();
  }

  /** @return the {@link DominoElement} represent the header element. */
  public DominoElement<HTMLDivElement> getHeaderElement() {
    return headerElement;
  }

  /** @return the {@link DominoElement} represent the element that contains the header text. */
  public DominoElement<HTMLHeadingElement> getHeadingElement() {
    return headingElement;
  }

  /** @return the {@link DominoElement} represent the body element. */
  public DominoElement<HTMLDivElement> getBodyElement() {
    return bodyElement;
  }

  /** @return the panel icon */
  public BaseIcon<?> getPanelIcon() {
    return panelIcon;
  }

  /** @return the panel header background color */
  public Color getHeaderColor() {
    return headerColor;
  }

  /** @return the panel body background color */
  public Color getBodyColor() {
    return bodyColor;
  }
}
