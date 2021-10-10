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
import static org.jboss.elemento.Elements.div;

import elemental2.dom.HTMLDivElement;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import org.dominokit.domino.ui.style.Color;
import org.dominokit.domino.ui.utils.BaseDominoElement;
import org.dominokit.domino.ui.utils.DominoElement;

/**
 * A drawer like component that allow you to show and hide content.
 *
 * <p>Accordion component can work in different mode to give the user the ability to show and hide
 * content an accordion can multiple {@link AccordionPanel} and the user click on a panel to
 * show/hide its content by default only one panel will be open and the other panels will be closed
 * unless the multi open flag is set which will allow more than one panel to be open at once.
 *
 * <p>Multi open false
 *
 * <pre>
 *         Accordion.create()
 *                 .appendChild(
 *                         AccordionPanel.create(
 *                                 "Collapsible item 1", TextNode.of("Panel 1"))
 *                                 .show())
 *                 .appendChild(
 *                         AccordionPanel.create(
 *                                 "Collapsible item 2", TextNode.of("Panel 1")))
 *                 .appendChild(
 *                         AccordionPanel.create(
 *                                 "Collapsible item 3", TextNode.of("panel 1")));
 *     </pre>
 *
 * <p>Multi open true
 *
 * <pre>
 *         Accordion.create()
 *                 .multiOpen()
 *                 .appendChild(
 *                         AccordionPanel.create(
 *                                 "Collapsible item 1", TextNode.of("Panel 1"))
 *                                 .show()
 *                                 .setIcon(Icons.ALL.perm_contact_calendar())
 *                                 .setHeaderBackground(Color.PINK)
 *                                 .setBodyBackground(Color.PINK)
 *                                 .show())
 *                 .appendChild(
 *                         AccordionPanel.create(
 *                                 "Collapsible item 2", TextNode.of("Panel 2"))
 *                                 .setIcon(Icons.ALL.cloud_download())
 *                                 .setHeaderBackground(Color.CYAN)
 *                                 .setBodyBackground(Color.CYAN))
 *                 .appendChild(
 *                         AccordionPanel.create(
 *                                 "Collapsible item 3", TextNode.of("Panel 3"))
 *                                 .show()
 *                                 .setIcon(Icons.ALL.contact_phone())
 *                                 .setHeaderBackground(Color.TEAL)
 *                                 .setBodyBackground(Color.TEAL)
 *                                 .show())
 *                 .appendChild(
 *                         AccordionPanel.create(
 *                                 "Collapsible item 4", TextNode.of("Panel 4"))
 *                                 .setIcon(Icons.ALL.folder_shared())
 *                                 .setHeaderBackground(Color.ORANGE)
 *                                 .setBodyBackground(Color.ORANGE))
 *     </pre>
 *
 * @see AccordionPanel
 */
public class Accordion extends BaseDominoElement<HTMLDivElement, Accordion> {

  private final DominoElement<HTMLDivElement> element =
      DominoElement.of(div().css(CollapsibleStyles.PANEL_GROUP));
  private List<AccordionPanel> panels = new LinkedList<>();
  private boolean multiOpen = false;
  private Color headerColor;
  private Color bodyColor;
  private CollapseStrategy panelsCollapseStrategy;

  /** Default constructor */
  public Accordion() {
    init(this);
  }

  /**
   * A facttory to create a new Accordion instance
   *
   * @return new Accordion instance
   */
  public static Accordion create() {
    return new Accordion();
  }

  /**
   * Adds an Accordion panel to the Accordion
   *
   * @param panel {@link AccordionPanel}
   * @return same instance
   */
  public Accordion appendChild(AccordionPanel panel) {
    return appendChild(panel, true);
  }

  /**
   * Adds an accordion panel to the accordion and allow overriding the accordion panel colors with
   * the colors from the Accordion
   *
   * @param panel {@link AccordionPanel}
   * @param overrideColors boolean, true to override the colors.
   * @return same accordion instance
   */
  public Accordion appendChild(AccordionPanel panel, boolean overrideColors) {
    panels.add(panel);
    if (nonNull(panelsCollapseStrategy)) {
      panel.setCollapseStrategy(panelsCollapseStrategy);
    }
    if (overrideColors) {
      if (nonNull(headerColor)) {
        panel.setHeaderBackground(headerColor);
      }

      if (nonNull(bodyColor)) {
        panel.setBodyBackground(bodyColor);
      }
    }
    element.appendChild(panel);
    DominoElement.of(panel.getClickableElement()).addClickListener(evt -> togglePanel(panel));
    return this;
  }

  /**
   * Toggles the Accordion panel open state. if it is open it will be closed and if closed it will
   * open
   *
   * @param panel {@link AccordionPanel}
   */
  public void togglePanel(AccordionPanel panel) {
    if (panels.contains(panel)) {
      if (!multiOpen) {
        List<AccordionPanel> accordionPanels = otherPanels(panel);
        accordionPanels.forEach(
            accordionPanel -> {
              if (!accordionPanel.isCollapsed()) {
                accordionPanel.hide();
              }
            });
        if (panel.isCollapsed()) {
          panel.show();
        }
      } else {
        panel.toggleDisplay();
      }
    }
  }

  private List<AccordionPanel> otherPanels(AccordionPanel exclude) {
    List<AccordionPanel> newList = new ArrayList<>(panels);
    newList.remove(exclude);
    return newList;
  }

  /**
   * Set the Accordion to allow multiple open AccordionPanels
   *
   * @return same accordion instance
   */
  public Accordion multiOpen() {
    this.multiOpen = true;
    return this;
  }

  /**
   * Set the header background to {@link Color#BLUE}
   *
   * @return same accordion instance
   */
  public Accordion primary() {
    return setHeaderBackground(Color.BLUE);
  }

  /**
   * Set the header background to {@link Color#GREEN}
   *
   * @return same accordion instance
   */
  public Accordion success() {
    return setHeaderBackground(Color.GREEN);
  }

  /**
   * Set the header background to {@link Color#ORANGE}
   *
   * @return same accordion instance
   */
  public Accordion warning() {
    return setHeaderBackground(Color.ORANGE);
  }

  /**
   * Set the header background to {@link Color#RED}
   *
   * @return same accordion instance
   */
  public Accordion danger() {
    return setHeaderBackground(Color.RED);
  }

  /**
   * Set the header and body background to {@link Color#BLUE}
   *
   * @return same accordion instance
   */
  public Accordion primaryFull() {
    setHeaderBackground(Color.BLUE);
    setBodyBackground(Color.BLUE);

    return this;
  }

  /**
   * Set the header and body background to {@link Color#GREEN}
   *
   * @return same accordion instance
   */
  public Accordion successFull() {
    setHeaderBackground(Color.GREEN);
    setBodyBackground(Color.GREEN);

    return this;
  }

  /**
   * Set the header and body background to {@link Color#ORANGE}
   *
   * @return same accordion instance
   */
  public Accordion warningFull() {
    setHeaderBackground(Color.ORANGE);
    setBodyBackground(Color.ORANGE);

    return this;
  }

  /**
   * Set the header and body background to {@link Color#RED}
   *
   * @return same accordion instance
   */
  public Accordion dangerFull() {
    setHeaderBackground(Color.RED);
    setBodyBackground(Color.RED);

    return this;
  }

  /**
   * Set the header background to a custom color
   *
   * @param color {@link Color}
   * @return same accordion instance
   */
  public Accordion setHeaderBackground(Color color) {
    panels.forEach(p -> p.setHeaderBackground(color));
    this.headerColor = color;
    return this;
  }

  /**
   * Set the body background to a custom color
   *
   * @param color {@link Color}
   * @return same accordion instance
   */
  public Accordion setBodyBackground(Color color) {
    panels.forEach(p -> p.setBodyBackground(color));
    this.bodyColor = color;
    return this;
  }

  public Accordion setPanelCollapseStrategy(CollapseStrategy strategy) {
    this.panelsCollapseStrategy = strategy;
    panels.forEach(
        accordionPanel -> accordionPanel.setCollapseStrategy(this.panelsCollapseStrategy));
    return this;
  }

  /** {@inheritDoc} */
  @Override
  public HTMLDivElement element() {
    return element.element();
  }

  /** @return {@link List} of {@link AccordionPanel} that are added to this accordion */
  public List<AccordionPanel> getPanels() {
    return panels;
  }
}
