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
package org.dominokit.domino.ui.tabs;

import static java.util.Objects.nonNull;
import static org.dominokit.domino.ui.style.Unit.px;
import static org.dominokit.domino.ui.style.Unit.vh;
import static org.jboss.elemento.Elements.div;

import elemental2.dom.HTMLDivElement;
import java.util.ArrayList;
import java.util.List;
import org.dominokit.domino.ui.grid.flex.FlexDirection;
import org.dominokit.domino.ui.grid.flex.FlexLayout;
import org.dominokit.domino.ui.style.Calc;
import org.dominokit.domino.ui.utils.BaseDominoElement;
import org.dominokit.domino.ui.utils.DominoElement;
import org.jboss.elemento.IsElement;

/** The component that contains the tabs headers from the {@link VerticalTabsPanel} */
@Deprecated
public class VTabsContainer extends BaseDominoElement<HTMLDivElement, VTabsContainer>
    implements HasActiveItem<VerticalTab>, IsElement<HTMLDivElement> {

  private FlexLayout listContainer =
      FlexLayout.create().setDirection(FlexDirection.TOP_TO_BOTTOM).css(TabStyles.LIST);

  private HTMLDivElement element =
      DominoElement.of(div()).add(listContainer).css(TabStyles.VTABS).element();

  private VerticalTab activeItem;

  private List<VerticalTab> tabItems = new ArrayList<>();

  public VTabsContainer() {
    init(this);
  }

  /** @return new instance */
  public static VTabsContainer create() {
    return new VTabsContainer();
  }

  /**
   * @param tabItem {@link VerticalTab}
   * @return same VTabsContainer instance
   */
  public VTabsContainer appendChild(VerticalTab tabItem) {
    listContainer.appendChild(tabItem.element());
    this.tabItems.add(tabItem);
    return this;
  }

  /**
   * adds space between tabs
   *
   * @param fillItem {@link FillItem}
   * @return same VTabsContainer instance
   */
  public VTabsContainer appendChild(FillItem fillItem) {
    listContainer.appendChild(fillItem.element());
    return this;
  }

  /** @return the current active {@link VerticalTab} */
  @Override
  public VerticalTab getActiveItem() {
    return activeItem;
  }

  /** @param activeItem {@link VerticalTab} to be activated */
  @Override
  public void setActiveItem(VerticalTab activeItem) {
    if (nonNull(this.activeItem) && !this.activeItem.equals(activeItem)) {
      this.activeItem.deactivate();
    }

    this.activeItem = activeItem;
    this.activeItem.activate();
  }

  /** @return the {@link FlexLayout} that contains the FlexItems from each tab */
  public FlexLayout getListContainer() {
    return listContainer;
  }

  /**
   * Make the container height match the visible window height
   *
   * @return same VTabsContainer instance
   */
  public VTabsContainer autoHeight() {
    listContainer.styler(style -> style.setHeight(Calc.sub(vh.of(100), px.of(83))));
    DominoElement.of(element).styler(style -> style.setHeight(Calc.sub(vh.of(100), px.of(70))));
    return this;
  }

  /**
   * Make the container height match the visible window height, with an offset
   *
   * @return same VTabsContainer instance
   */
  public VTabsContainer autoHeight(int offset) {
    listContainer.styler(style -> style.setHeight(Calc.sum(vh.of(100), px.of(offset + 13))));
    DominoElement.of(element).styler(style -> style.setHeight(Calc.sum(vh.of(100), px.of(offset))));
    return this;
  }

  /** @return List of all {@link VerticalTab}s */
  public List<VerticalTab> getTabItems() {
    return tabItems;
  }

  /** {@inheritDoc} */
  @Override
  public HTMLDivElement element() {
    return element;
  }
}
