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

import static org.dominokit.domino.ui.collapsible.Collapsible.DUI_COLLAPSED;
import static org.dominokit.domino.ui.style.GenericCss.dui_transition_none;
import static org.dominokit.domino.ui.utils.Domino.*;
import static org.dominokit.domino.ui.utils.ElementsFactory.elements;

import elemental2.dom.AddEventListenerOptions;
import elemental2.dom.DomGlobal;
import elemental2.dom.Element;
import elemental2.dom.EventListener;
import org.dominokit.domino.ui.tree.TreeItem;
import org.dominokit.domino.ui.utils.DominoId;
import org.dominokit.domino.ui.utils.IsCollapsible;

/**
 * An implementation of {@link org.dominokit.domino.ui.collapsible.CollapseStrategy} that is meant
 * to be used with the {@link org.dominokit.domino.ui.tree.Tree} component
 */
public class TreeHeightCollapseStrategy implements CollapseStrategy, CollapsibleStyles {

  private static final String EXPAND_COLLAPSE_HEIGHT_VAR =
      "--dui-tree-item-expand-collapse-height-";
  private static final String DUI_COLLAPSED_HEIGHT = "dui-collapsed-height";
  private static final String DUI_EXPANDED_HEIGHT = "dui-expanded-height";
  private static final String DUI_EXPAND_COLLAPSE_VAR = "dui-expand-collapse-var";

  private final CollapsibleDuration transition;
  private final String heightVar;
  private CollapsibleHandlers handlers;
  private final TreeItem<?> treeItem;
  private boolean expanding = false;
  private boolean collapsing = false;

  /**
   * Constructor for TreeHeightCollapseStrategy.
   *
   * @param treeItem a {@link org.dominokit.domino.ui.tree.TreeItem} object
   */
  public TreeHeightCollapseStrategy(TreeItem<?> treeItem) {
    this(treeItem, CollapsibleDuration._300ms);
  }

  /**
   * Constructor for TreeHeightCollapseStrategy.
   *
   * @param treeItem a {@link org.dominokit.domino.ui.tree.TreeItem} object
   * @param transition a {@link CollapsibleDuration} object
   */
  public TreeHeightCollapseStrategy(TreeItem<?> treeItem, CollapsibleDuration transition) {
    this.treeItem = treeItem;
    this.transition = transition;
    this.heightVar = DominoId.unique(EXPAND_COLLAPSE_HEIGHT_VAR);
    this.treeItem.setAttribute(DUI_EXPAND_COLLAPSE_VAR, this.heightVar);
    this.treeItem.setCssProperty("height", "var(" + this.heightVar + ", auto)");
  }

  /** @dominokit-site-ignore {@inheritDoc} */
  @Override
  public void init(Element element, CollapsibleHandlers handlers) {
    this.handlers = handlers;
    this.treeItem.addCss(dui_height_collapsed_overflow).addCss(transition.getStyle());
    this.treeItem.nowOrWhenAttached(
        () -> {
          double height = treeItem.getBoundingClientRect().height;
          treeItem.setAttribute(DUI_COLLAPSED_HEIGHT, height);
        });

    element.setAttribute(DUI_COLLAPSED, true);
  }

  /** @dominokit-site-ignore {@inheritDoc} */
  @Override
  public void cleanup(Element element) {
    elements.elementOf(element).addCss(dui_height_collapsed_overflow).addCss(transition.getStyle());
    element.removeAttribute("dom-ui-collapse-height");
  }

  /** @dominokit-site-ignore {@inheritDoc} */
  @Override
  public void expand(Element element) {
    treeItem.nowOrWhenAttached(
        () -> {
          if (!collapsing) {
            this.expanding = true;
            this.handlers.onBeforeExpand().run();
            double height = treeItem.getBoundingClientRect().height;
            treeItem.setAttribute(DUI_COLLAPSED_HEIGHT, height);
            treeItem.getSubTree().show();
            treeItem.setCssProperty(this.heightVar, height + "px");
            double expandedHeight = getActualHeight();
            treeItem.setAttribute(DUI_EXPANDED_HEIGHT, expandedHeight);
            expandElement(element);
          }
        });
  }

  private double getActualHeight() {
    double expandedHeight =
        treeItem.childElements().stream()
            .filter(IsCollapsible::isExpanded)
            .mapToDouble(e -> e.getBoundingClientRect().height)
            .sum();
    return expandedHeight;
  }

  private void expandElement(Element element) {
    if (dui_transition_none.isAppliedTo(treeItem)) {
      treeItem.setCssProperty(this.heightVar, "auto");
      treeItem.removeAttribute(DUI_COLLAPSED);
      handlers.onExpandCompleted().run();
      expanding = false;
    } else {
      EventListener stopListener =
          evt -> {
            resetParentHeight(treeItem);
            treeItem.setCssProperty(this.heightVar, "auto");
            handlers.onExpandCompleted().run();
            expanding = false;
          };

      createAnimationEndListeners(stopListener);

      String expandedHeight = treeItem.getAttribute(DUI_EXPANDED_HEIGHT);
      treeItem.setCssProperty(this.heightVar, expandedHeight + "px");
      treeItem.removeAttribute(DUI_COLLAPSED);
    }
  }

  private void createAnimationEndListeners(EventListener stopListener) {
    AddEventListenerOptions addEventListenerOptions = AddEventListenerOptions.create();
    addEventListenerOptions.setOnce(true);
    treeItem
        .element()
        .addEventListener("webkitTransitionEnd", stopListener, addEventListenerOptions);
    treeItem.element().addEventListener("MSTransitionEnd", stopListener, addEventListenerOptions);
    treeItem.element().addEventListener("mozTransitionEnd", stopListener, addEventListenerOptions);
    treeItem.element().addEventListener("oanimationend", stopListener, addEventListenerOptions);
    treeItem.element().addEventListener("animationend", stopListener, addEventListenerOptions);
  }

  /** @dominokit-site-ignore {@inheritDoc} */
  @Override
  public void collapse(Element element) {
    if (!expanding) {
      collapsing = true;
      treeItem.setCssProperty(this.heightVar, getActualHeight() + "px");
      boolean disableAnimation = dui_transition_none.isAppliedTo(treeItem);
      treeItem.apply(
          self -> {
            if (self.isAttached()) {
              this.handlers.onBeforeCollapse().run();
              EventListener stopListener =
                  evt -> {
                    handlers.onCollapseCompleted().run();
                    collapsing = false;
                  };
              createAnimationEndListeners(stopListener);
              collapseElement(element);
            } else {
              self.onAttached(
                  (e, mutationRecord) -> {
                    this.handlers.onBeforeCollapse().run();
                    treeItem.addCss(dui_transition_none);
                    EventListener stopListener =
                        evt -> {
                          if (!disableAnimation) {
                            dui_transition_none.remove(treeItem);
                          }
                          handlers.onCollapseCompleted().run();
                          collapsing = false;
                        };
                    createAnimationEndListeners(stopListener);
                    collapseElement(element);
                  });
            }
          });
    }
  }

  private void resetParentHeight(TreeItem<?> treeItem) {
    treeItem
        .getParent()
        .ifPresent(
            parent -> {
              if (parent instanceof TreeItem) {
                TreeItem<?> parentItem = (TreeItem<?>) parent;
                parentItem.removeCssProperty(parentItem.getAttribute(DUI_EXPAND_COLLAPSE_VAR));
                parent.getParent().ifPresent(treeItem1 -> resetParentHeight(parentItem));
              }
            });
  }

  private void collapseElement(Element element) {
    if (dui_transition_none.isAppliedTo(treeItem)) {
      treeItem.setAttribute(DUI_COLLAPSED, "true");
      treeItem.setCssProperty(this.heightVar, treeItem.getAttribute(DUI_COLLAPSED_HEIGHT) + "px");
    } else {
      DomGlobal.requestAnimationFrame(
          timestamp -> {
            treeItem.setAttribute(DUI_COLLAPSED, "true");
            treeItem.setCssProperty(
                this.heightVar, treeItem.getAttribute(DUI_COLLAPSED_HEIGHT) + "px");
          });
    }
  }
}
