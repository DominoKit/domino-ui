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

import elemental2.dom.HTMLDivElement;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import org.dominokit.domino.ui.elements.DivElement;
import org.dominokit.domino.ui.utils.BaseDominoElement;

/**
 * A drawer like component that allow you to show and hide content.
 *
 * <p>Accordion component can work in different mode to give the user the ability to show and hide
 * content an accordion can multiple {@link org.dominokit.domino.ui.collapsible.AccordionPanel} and
 * the user click on a panel to show/hide its content by default only one panel will be open and the
 * other panels will be closed unless the multi open flag is set which will allow more than one
 * panel to be open at once.
 *
 * @see AccordionPanel
 * @author vegegoku
 * @version $Id: $Id
 */
public class Accordion extends BaseDominoElement<HTMLDivElement, Accordion>
    implements CollapsibleStyles {

  private final DivElement element;
  private List<AccordionPanel> panels = new LinkedList<>();
  private boolean multiOpen = false;
  private CollapseStrategy panelsCollapseStrategy;

  /** Default constructor */
  public Accordion() {
    element = div().addCss(dui_collapse_group);
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
   * Adds an accordion panel to the accordion and allow overriding the accordion panel colors with
   * the colors from the Accordion
   *
   * @param panel {@link org.dominokit.domino.ui.collapsible.AccordionPanel}
   * @return same accordion instance
   */
  public Accordion appendChild(AccordionPanel panel) {
    panels.add(panel);
    if (nonNull(panelsCollapseStrategy)) {
      panel.setCollapseStrategy(panelsCollapseStrategy);
    }
    element.appendChild(panel);
    panel.withHeader(
        (accordionPanel, header) -> {
          header.addClickListener(evt -> togglePanel(panel));
        });
    return this;
  }

  /**
   * Toggles the Accordion panel open state. if it is open it will be closed and if closed it will
   * open
   *
   * @param panel {@link org.dominokit.domino.ui.collapsible.AccordionPanel}
   */
  public void togglePanel(AccordionPanel panel) {
    if (panels.contains(panel)) {
      if (!multiOpen) {
        List<AccordionPanel> accordionPanels = otherPanels(panel);
        accordionPanels.forEach(
            accordionPanel -> {
              if (!accordionPanel.isCollapsed()) {
                accordionPanel.collapse();
              }
            });
        if (panel.isCollapsed()) {
          panel.expand();
        }
      } else {
        panel.toggleCollapse();
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
   * isMultiOpen.
   *
   * @return a boolean
   */
  public boolean isMultiOpen() {
    return multiOpen;
  }

  /**
   * Setter for the field <code>multiOpen</code>.
   *
   * @param multiOpen a boolean
   * @return a {@link org.dominokit.domino.ui.collapsible.Accordion} object
   */
  public Accordion setMultiOpen(boolean multiOpen) {
    this.multiOpen = multiOpen;
    return this;
  }

  /**
   * setPanelCollapseStrategy.
   *
   * @param strategy a {@link org.dominokit.domino.ui.collapsible.CollapseStrategy} object
   * @return a {@link org.dominokit.domino.ui.collapsible.Accordion} object
   */
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
  /**
   * Getter for the field <code>panels</code>.
   *
   * @return a {@link java.util.List} object
   */
  public List<AccordionPanel> getPanels() {
    return panels;
  }
}
