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

public class NavBarTest extends GWTTestCase {

  @Override
  public String getModuleName() {
    return "org.dominokit.domino.ui.DominoUI";
  }

  public void testExistingNavBarStructureAndFluentApiRemainUnchanged() {
    NavBar navBar = NavBar.create("Orders").setDescription("Recent orders");

    assertTrue(
        "Expected NavBar class, got: " + navBar.element().className,
        navBar.element().className.contains("dui-nav-bar"));
    assertTrue(
        "Expected shared base class, got: " + navBar.element().className,
        navBar.element().className.contains("dui-nav-bar-base"));
    assertEquals("Orders", navBar.getTitleTextElement().getTextContent());
    assertEquals("Recent orders", navBar.getDescription());
    assertNotNull(navBar.getBody());
    assertSame(navBar, navBar.setTitle("Updated"));
    assertSame(navBar, navBar.setDescription("Updated description"));
    assertSame(navBar, navBar.withBody((self, body) -> {}));
  }
}
