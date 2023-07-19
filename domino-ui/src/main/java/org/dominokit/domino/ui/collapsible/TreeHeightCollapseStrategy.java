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
import static org.dominokit.domino.ui.utils.ElementsFactory.elements;

import elemental2.dom.AddEventListenerOptions;
import elemental2.dom.DomGlobal;
import elemental2.dom.Element;
import elemental2.dom.EventListener;
import org.dominokit.domino.ui.tree.TreeItem;
import org.dominokit.domino.ui.utils.DominoId;
import org.dominokit.domino.ui.utils.IsCollapsible;

/**
 * An implementation of {@link org.dominokit.domino.ui.collapsible.CollapseStrategy} that uses the
 * css display property to hide/show the collapsible element
 *
 * @author vegegoku
 * @version $Id: $Id
 */
public class TreeHeightCollapseStrategy implements CollapseStrategy, CollapsibleStyles {

  /** Constant <code>EXPAND_COLLAPSE_HEIGHT_VAR="--dui-tree-item-expand-collapse-height-"</code> */
  public static final String EXPAND_COLLAPSE_HEIGHT_VAR = "--dui-tree-item-expand-collapse-height-";
  /** Constant <code>DUI_COLLAPSED_HEIGHT="dui-collapsed-height"</code> */
  public static final String DUI_COLLAPSED_HEIGHT = "dui-collapsed-height";
  /** Constant <code>DUI_EXPANDED_HEIGHT="dui-expanded-height"</code> */
  public static final String DUI_EXPANDED_HEIGHT = "dui-expanded-height";
  /** Constant <code>DUI_EXPAND_COLLAPSE_VAR="dui-expand-collapse-var"</code> */
  public static final String DUI_EXPAND_COLLAPSE_VAR = "dui-expand-collapse-var";

  private final CollapseDuration transition;
  private final String heightVar;
  private CollapsibleHandlers handlers;
  private final TreeItem<?> treeItem;

  /**
   * Constructor for TreeHeightCollapseStrategy.
   *
   * @param treeItem a {@link org.dominokit.domino.ui.tree.TreeItem} object
   */
  public TreeHeightCollapseStrategy(TreeItem<?> treeItem) {
    this(treeItem, CollapseDuration._300ms);
  }

  /**
   * Constructor for TreeHeightCollapseStrategy.
   *
   * @param treeItem a {@link org.dominokit.domino.ui.tree.TreeItem} object
   * @param transition a {@link org.dominokit.domino.ui.collapsible.CollapseDuration} object
   */
  public TreeHeightCollapseStrategy(TreeItem<?> treeItem, CollapseDuration transition) {
    this.treeItem = treeItem;
    this.transition = transition;
    this.heightVar = DominoId.unique(EXPAND_COLLAPSE_HEIGHT_VAR);
    this.treeItem.setAttribute(DUI_EXPAND_COLLAPSE_VAR, this.heightVar);
    this.treeItem.setCssProperty("height", "var(" + this.heightVar + ", auto)");
  }

  /** {@inheritDoc} */
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

  /** {@inheritDoc} */
  @Override
  public void cleanup(Element element) {
    elements.elementOf(element).addCss(dui_height_collapsed_overflow).addCss(transition.getStyle());
    element.removeAttribute("dom-ui-collapse-height");
  }

  /** {@inheritDoc} */
  @Override
  public void expand(Element element) {
    treeItem.nowOrWhenAttached(
        () -> {
          this.handlers.onBeforeExpand().run();
          double height = treeItem.getBoundingClientRect().height;
          treeItem.setAttribute(DUI_COLLAPSED_HEIGHT, height);
          treeItem.getSubTree().show();
          treeItem.setCssProperty(this.heightVar, height + "px");
          double expandedHeight = getActualHeight();
          treeItem.setAttribute(DUI_EXPANDED_HEIGHT, expandedHeight);
          expandElement(element);
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
    } else {
      EventListener stopListener =
          evt -> {
            resetParentHeight(treeItem);
            treeItem.setCssProperty(this.heightVar, "auto");
            handlers.onExpandCompleted().run();
          };

      AddEventListenerOptions addEventListenerOptions = AddEventListenerOptions.create();
      addEventListenerOptions.setOnce(true);
      treeItem
          .element()
          .addEventListener("webkitTransitionEnd", stopListener, addEventListenerOptions);
      treeItem.element().addEventListener("MSTransitionEnd", stopListener, addEventListenerOptions);
      treeItem
          .element()
          .addEventListener("mozTransitionEnd", stopListener, addEventListenerOptions);
      treeItem.element().addEventListener("oanimationend", stopListener, addEventListenerOptions);
      treeItem.element().addEventListener("animationend", stopListener, addEventListenerOptions);

      String expandedHeight = treeItem.getAttribute(DUI_EXPANDED_HEIGHT);
      treeItem.setCssProperty(this.heightVar, expandedHeight + "px");
      treeItem.removeAttribute(DUI_COLLAPSED);
    }
  }

  /** {@inheritDoc} */
  @Override
  public void collapse(Element element) {
    treeItem.setCssProperty(this.heightVar, getActualHeight() + "px");
    boolean disableAnimation = dui_transition_none.isAppliedTo(treeItem);
    treeItem.apply(
        self -> {
          if (self.isAttached()) {
            this.handlers.onBeforeCollapse().run();
            collapseElement(element);
            handlers.onCollapseCompleted().run();
          } else {
            self.onAttached(
                mutationRecord -> {
                  this.handlers.onBeforeCollapse().run();
                  treeItem.addCss(dui_transition_none);
                  collapseElement(element);
                  if (!disableAnimation) {
                    dui_transition_none.remove(treeItem);
                  }
                  handlers.onCollapseCompleted().run();
                });
          }
        });
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
