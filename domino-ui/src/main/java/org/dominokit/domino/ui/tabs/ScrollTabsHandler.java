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

import static org.dominokit.domino.ui.style.DisplayCss.dui_overflow_hidden;
import static org.dominokit.domino.ui.style.GenericCss.dui_vertical;

import elemental2.dom.DOMRect;
import elemental2.dom.Element;
import java.util.function.Consumer;
import org.dominokit.domino.ui.elements.UListElement;
import org.dominokit.domino.ui.icons.MdiIcon;
import org.dominokit.domino.ui.icons.lib.Icons;
import org.dominokit.domino.ui.utils.BaseDominoElement;
import org.gwtproject.timer.client.Timer;

public class ScrollTabsHandler implements TabsOverflowHandler {

  private MdiIcon scrollLeftIcon;
  private MdiIcon scrollRightIcon;
  private Timer timer;
  private Consumer<Tab> closeHandler;
  private final BaseDominoElement.HandlerRecord resizeRecord =
      new BaseDominoElement.HandlerRecord();

  public ScrollTabsHandler() {
    scrollLeftIcon = Icons.menu_left().clickable();
    scrollRightIcon = Icons.menu_right().clickable();
  }

  @Override
  public void apply(TabsPanel tabsPanel) {
    tabsPanel.withTabsNav(
        (panel, nav) -> {
          nav.addCss(dui_overflow_hidden);
          scrollLeftIcon.addClickListener(
              evt -> {
                if (dui_vertical.isAppliedTo(panel)) {
                  double shift = nav.getBoundingClientRect().height / 2;
                  nav.element().scrollTop = nav.element().scrollTop - shift;
                } else {
                  double shift = nav.getBoundingClientRect().width / 2;
                  nav.element().scrollLeft = nav.element().scrollLeft - shift;
                }
              });
          scrollRightIcon.addClickListener(
              evt -> {
                if (dui_vertical.isAppliedTo(panel)) {
                  double shift = nav.getBoundingClientRect().height / 2;
                  nav.element().scrollTop = nav.element().scrollTop + shift;
                } else {
                  double shift = nav.getBoundingClientRect().width / 2;
                  nav.element().scrollLeft = nav.element().scrollLeft + shift;
                }
              });

          tabsPanel.addCloseHandler(
              closeHandler =
                  tab -> {
                    updateTabs(tabsPanel, nav);
                  });
          nav.nowOrWhenAttached(
              () -> {
                updateTabs(tabsPanel, nav);
                timer =
                    new Timer() {
                      @Override
                      public void run() {
                        updateTabs(panel, nav);
                      }
                    };

                nav.onResize(
                    (element, observer, entries) -> {
                      timer.schedule(250);
                    },
                    resizeRecord);
              });
          if (dui_vertical.isAppliedTo(tabsPanel)) {
            scrollLeftIcon.rotate90();
            scrollRightIcon.rotate90();
          }
        });
  }

  @Override
  public void update(TabsPanel tabsPanel) {
    tabsPanel.withTabsNav(
        (panel, nav) -> {
          updateTabs(tabsPanel, nav);
        });
  }

  private void updateTabs(TabsPanel tabsPanel, UListElement nav) {
    if (isOverFlowing(nav.element())) {
      tabsPanel.getLeadingNav().appendChild(scrollLeftIcon);
      tabsPanel.getTailNav().appendChild(scrollRightIcon);

      tabsPanel.getTabs().stream()
          .filter(tab -> isPartialVisible(nav.element(), tab.element()) && tab.isActive())
          .findFirst()
          .ifPresent(
              tab -> {
                if (dui_vertical.isAppliedTo(tabsPanel)) {
                  DOMRect parentRect = nav.getBoundingClientRect();
                  DOMRect childRect = tab.getBoundingClientRect();

                  double shift = childRect.top - parentRect.top;
                  nav.element().scrollTop = nav.element().scrollTop + shift;
                } else {
                  DOMRect parentRect = nav.getBoundingClientRect();
                  DOMRect childRect = tab.getBoundingClientRect();

                  double shift = childRect.right - parentRect.right;
                  nav.element().scrollLeft = nav.element().scrollLeft + shift;
                }
              });
    } else {
      scrollLeftIcon.remove();
      scrollRightIcon.remove();
    }
  }

  @Override
  public void cleanUp(TabsPanel tabsPanel) {
    scrollLeftIcon.remove();
    scrollRightIcon.remove();
    tabsPanel.removeCloseHandler(closeHandler);
    timer.cancel();
    resizeRecord.remove();
  }

  private boolean isOverFlowing(Element element) {
    return element.scrollWidth > element.clientWidth || element.scrollHeight > element.clientHeight;
  }

  private boolean isPartialVisible(Element parent, Element child) {
    DOMRect parentRect = parent.getBoundingClientRect();
    DOMRect childRect = child.getBoundingClientRect();

    boolean fullyVisible =
        childRect.left >= parentRect.left
            && childRect.right <= parentRect.right
            && childRect.top >= parentRect.top
            && childRect.bottom <= parentRect.bottom;

    return !fullyVisible;
  }
}
