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
package org.dominokit.domino.ui.cards;

import com.google.gwt.junit.client.GWTTestCase;
import elemental2.dom.DomGlobal;
import elemental2.dom.HTMLDivElement;
import org.dominokit.domino.ui.elements.DivElement;

public class CardTest extends GWTTestCase {

  @Override
  public String getModuleName() {
    return "org.dominokit.domino.ui.DominoUI";
  }

  public void testExistingBodyRemainsTheAppendTarget() {
    Card card = Card.create();
    DivElement body = card.getBody();
    HTMLDivElement child = (HTMLDivElement) DomGlobal.document.createElement("div");

    card.withBody((self, currentBody) -> currentBody.appendChild(child));

    assertSame(body.element(), card.getAppendTarget());
    assertSame(child, body.element().firstElementChild);
    assertTrue(body.element().classList.contains("dui-card-body"));
    assertTrue(card.getContent().element().classList.contains("dui-card-content"));
  }

  public void testContentHeaderAndFooterAreLazyAndKeepTheirOrder() {
    Card card = Card.create();
    DivElement content = card.getContent();

    assertEquals(1, content.element().childNodes.length);
    assertSame(card.getBody().element(), content.element().firstElementChild);

    DivElement footer = card.getContentFooter();
    assertEquals(2, content.element().childNodes.length);
    assertSame(footer.element(), content.element().lastElementChild);

    DivElement header = card.getContentHeader();
    assertEquals(3, content.element().childNodes.length);
    assertSame(header.element(), content.element().firstElementChild);
    assertSame(card.getBody().element(), header.element().nextElementSibling);
    assertSame(footer.element(), card.getBody().element().nextElementSibling);
    assertTrue(header.element().classList.contains("dui-card-content-header"));
    assertTrue(footer.element().classList.contains("dui-card-content-footer"));
  }

  public void testContentBodyIsAlwaysPresentEvenWhenEmpty() {
    Card card = Card.create();

    assertFalse(card.getBody().element().hasChildNodes());
    assertFalse(card.getBody().element().classList.contains("dui-hidden"));
    assertSame(card.getBody().element(), card.getContent().element().firstElementChild);
  }

  public void testBottomHeaderPositionKeepsTheContentContainerTogether() {
    Card card = Card.create("Bottom header").setHeaderPosition(HeaderPosition.BOTTOM);

    assertTrue(card.element().classList.contains("dui-card-header-bottom"));
    assertSame(card.getContent().element(), card.element().lastElementChild);
    assertSame(card.getHeader().element(), card.element().firstElementChild);
  }

  public void testCardCollapseTargetsTheContentContainer() {
    Card card = Card.create("Collapsible card").setCollapsible(true);

    card.collapse();

    assertTrue(card.isCollapsed());
    assertTrue(card.getContent().isCollapsed());
    assertFalse(card.getBody().isCollapsed());

    card.expand();

    assertFalse(card.isCollapsed());
    assertFalse(card.getContent().isCollapsed());
  }
}
