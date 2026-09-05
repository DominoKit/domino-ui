/*
 * Copyright © 2019 Dominokit
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 */
package org.dominokit.domino.ui.accessibility;

import com.google.gwt.junit.client.GWTTestCase;
import elemental2.dom.Element;
import org.dominokit.domino.ui.carousel.Carousel;
import org.dominokit.domino.ui.carousel.Slide;
import org.dominokit.domino.ui.forms.SwitchButton;
import org.dominokit.domino.ui.pagination.SimplePagination;
import org.dominokit.domino.ui.tree.Tree;
import org.dominokit.domino.ui.tree.TreeItem;

public class NavigationAccessibilityTest extends GWTTestCase {

  @Override
  public String getModuleName() {
    return "org.dominokit.domino.ui.DominoUI";
  }

  public void testTreeExposesTreeItemState() {
    Tree<String> tree = Tree.create("Files");
    TreeItem<String> parent = TreeItem.create("Documents", "documents");
    parent.appendChild(TreeItem.create("Readme", "readme"));
    tree.appendChild(parent);

    assertEquals("tree", tree.getAttribute("role"));
    assertEquals("group", tree.getSubTree().getAttribute("role"));
    assertEquals("treeitem", parent.getClickableElement().getAttribute("role"));
    assertEquals("false", parent.getClickableElement().getAttribute("aria-expanded"));
    assertEquals("false", parent.getClickableElement().getAttribute("aria-selected"));
  }

  public void testSwitchExposesCheckedState() {
    SwitchButton switchButton = SwitchButton.create("Enabled", "Off");

    assertEquals("switch", switchButton.getInputElement().getAttribute("role"));
    assertEquals("false", switchButton.getInputElement().getAttribute("aria-checked"));
    switchButton.withValue(true);
    assertEquals("true", switchButton.getInputElement().getAttribute("aria-checked"));
  }

  public void testCarouselControlsAreNamedButtons() {
    Carousel carousel = Carousel.create().appendChild(Slide.create("image.png"));
    Element previous = carousel.element().querySelector(".dui-slide-left");
    Element next = carousel.element().querySelector(".dui-slide-right");

    assertEquals("button", previous.getAttribute("role"));
    assertEquals("Previous slide", previous.getAttribute("aria-label"));
    assertEquals("button", next.getAttribute("role"));
    assertEquals("Next slide", next.getAttribute("aria-label"));
  }

  public void testPaginationUsesNavigationAndCurrentPageSemantics() {
    SimplePagination pagination = new SimplePagination(2);

    assertEquals("navigation", pagination.getAttribute("role"));
    Element current = pagination.element().querySelector(".dui-page-link.dui-active");
    assertEquals("page", current.getAttribute("aria-current"));
  }
}
