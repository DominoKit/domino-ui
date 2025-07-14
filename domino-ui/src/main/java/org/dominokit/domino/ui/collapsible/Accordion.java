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
import static org.dominokit.domino.ui.utils.Domino.*;

import elemental2.dom.HTMLDivElement;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.function.Supplier;
import org.dominokit.domino.ui.elements.DivElement;
import org.dominokit.domino.ui.utils.BaseDominoElement;

/**
 * A drawer like component that allow you to show and hide content.
 *
 * <p>Accordion component can work in different mode to give the user the ability to show and hide
 * content, accordions can have multiple {@link org.dominokit.domino.ui.collapsible.AccordionPanel}
 * when the user clicks on a panel to show/hide its content, there will be only one panel opened at
 * a time by default, the other panels will be closed unless the multi open flag is set which will
 * allow opening more than one panel at the same time
 *
 * @see CollapseStrategy
 * @see BaseDominoElement
 */
public class Accordion extends BaseDominoElement<HTMLDivElement, Accordion>
    implements CollapsibleStyles {

  private final DivElement element;
  private List<AccordionPanel> panels = new LinkedList<>();
  private boolean multiOpen = false;
  private Supplier<CollapseStrategy> panelsCollapseStrategy;

  /** Creates an empty accordion */
  public Accordion() {
    element = div().addCss(dui_collapse_group);
    init(this);
  }

  /**
   * Factory method to create an empty accordion
   *
   * @return new Accordion instance
   */
  public static Accordion create() {
    return new Accordion();
  }

  /**
   * Adds an accordion panel to the accordion
   *
   * @param panel The {@link org.dominokit.domino.ui.collapsible.AccordionPanel} to be added
   * @return same accordion instance
   */
  public Accordion appendChild(AccordionPanel panel) {
    insertChild(-1, panel);
    return this;
  }

  /**
   * Adds multiple accordion panels to the accordion
   *
   * @param panels The {@link org.dominokit.domino.ui.collapsible.AccordionPanel}s to be added
   * @return same accordion instance
   */
  public Accordion appendChild(AccordionPanel... panels) {
    Arrays.asList(panels).forEach(this::appendChild);
    return this;
  }
  /**
   * Inserts an accordion panel at the specified index in the accordion
   *
   * @param index The index to insert the panel at, if the index is less than 0 or greater than the
   *     number of panels it will be appended to the end of the accordion
   * @param panel The {@link org.dominokit.domino.ui.collapsible.AccordionPanel} to be inserted
   * @return same accordion instance
   */
  public Accordion insertChild(int index, AccordionPanel panel) {
    boolean isAppend = index < 0 || index >= panels.size();
    if (isAppend) {
      panels.add(panel);
    } else {
      panels.add(index, panel);
    }
    if (nonNull(panelsCollapseStrategy)) {
      panel.setCollapseStrategy(panelsCollapseStrategy.get());
    }
    if (isAppend) {
      element.appendChild(panel);
    } else {
      element.insertFirst(panel);
    }
    panel.withHeader(
        (accordionPanel, header) -> {
          header.addClickListener(evt -> togglePanel(panel));
        });
    return this;
  }

  /**
   * Only if the provided AccordionPanel is one of the panels in this accordion toggle the Accordion
   * panel open state. if it is open it will be closed and if closed it will open
   *
   * @param panel The {@link org.dominokit.domino.ui.collapsible.AccordionPanel} to be toggled
   * @return same accordion instance
   */
  public Accordion togglePanel(AccordionPanel panel) {
    if (panels.contains(panel)) {
      if (!multiOpen) {
        List<AccordionPanel> accordionPanels = otherPanels(panel);
        accordionPanels.forEach(
            accordionPanel -> {
              if (!accordionPanel.isCollapsed()) {
                accordionPanel.collapse();
              }
            });
        panel.toggleCollapse();
      } else {
        panel.toggleCollapse();
      }
    }
    return this;
  }

  private List<AccordionPanel> otherPanels(AccordionPanel exclude) {
    List<AccordionPanel> newList = new ArrayList<>(panels);
    newList.remove(exclude);
    return newList;
  }

  /**
   * Collapse all the accordion panels, this will only work if the accordion is set to allow
   * multiple open panels, otherwise it will not have any effect.
   *
   * @return same accordion instance
   */
  public Accordion collapseAll() {
    if (isMultiOpen()) {
      panels.forEach(AccordionPanel::collapse);
    }
    return this;
  }

  /**
   * Expand all the accordion panels, this will only work if the accordion is set to allow multiple
   * open panels, otherwise it will not have any effect.
   *
   * @return same accordion instance
   */
  public Accordion expandAll() {
    if (isMultiOpen()) {
      panels.forEach(AccordionPanel::expand);
    }
    return this;
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
   * Use to check if this accordion allows multiple opened accordion panels.
   *
   * @return a boolean, <b>true</b> if multiple opened panels enabled, <b>false</b> if multiple
   *     opened panel is disabled
   */
  public boolean isMultiOpen() {
    return multiOpen;
  }

  /**
   * Enable/Disable open multiple panels based on the provided flag
   *
   * @param multiOpen a boolean, <b>true</b> enables open multiple panels, <b>false</b> disable open
   *     multiple panel.
   * @return a {@link org.dominokit.domino.ui.collapsible.Accordion} object
   */
  public Accordion setMultiOpen(boolean multiOpen) {
    this.multiOpen = multiOpen;
    return this;
  }

  /**
   * Sets the collapse/expand strategy for the accordion panels.
   *
   * @param strategy The {@link org.dominokit.domino.ui.collapsible.CollapseStrategy} to use when
   *     the accordion panels are collapsed/expaned
   * @return Same accordion instance
   */
  public Accordion setPanelCollapseStrategy(Supplier<CollapseStrategy> strategy) {
    this.panelsCollapseStrategy = strategy;
    panels.forEach(
        accordionPanel -> accordionPanel.setCollapseStrategy(this.panelsCollapseStrategy.get()));
    return this;
  }

  /** @dominokit-site-ignore {@inheritDoc} */
  @Override
  public HTMLDivElement element() {
    return element.element();
  }

  /**
   * @return A {@link java.util.List} of the {@link AccordionPanel}s in this added to this accordion
   *     instance
   */
  public List<AccordionPanel> getPanels() {
    return panels;
  }
}
