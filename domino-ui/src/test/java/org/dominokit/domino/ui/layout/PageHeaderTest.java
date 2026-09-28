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
package org.dominokit.domino.ui.layout;

import com.google.gwt.junit.client.GWTTestCase;

public class PageHeaderTest extends GWTTestCase {

  @Override
  public String getModuleName() {
    return "org.dominokit.domino.ui.DominoUI";
  }

  public void testPageHeaderUsesTheSharedStructureWithItsOwnRootClass() {
    PageHeader pageHeader = new PageHeader("Orders", "Recent orders");

    assertTrue(pageHeader.element().className.contains("dui-page-header"));
    assertTrue(pageHeader.element().className.contains("dui-nav-bar-base"));
    assertEquals("Orders", pageHeader.getTitleTextElement().getTextContent());
    assertEquals("Recent orders", pageHeader.getDescription());
    assertNotNull(pageHeader.getBody());
  }

  public void testPageHeaderDescriptionIsLazyAndFluentMethodsReturnPageHeader() {
    PageHeader pageHeader = PageHeader.create();

    assertEquals(2, pageHeader.element().childNodes.length);
    assertSame(pageHeader, pageHeader.setTitle("Orders"));
    assertSame(pageHeader, pageHeader.setDescription("Recent orders"));
    assertSame(pageHeader, pageHeader.withTitle((self, title) -> {}));
    assertSame(pageHeader, pageHeader.withDescription((self, description) -> {}));
    assertSame(pageHeader, pageHeader.withTitleTextElement((self, title) -> {}));
    assertSame(pageHeader, pageHeader.withBody((self, body) -> {}));
  }
}
