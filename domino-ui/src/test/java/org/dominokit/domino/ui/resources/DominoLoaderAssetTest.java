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
package org.dominokit.domino.ui.resources;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import org.junit.Test;

public class DominoLoaderAssetTest {

  private static final String RESOURCE_ROOT =
      "org/dominokit/domino/ui/public/css/domino-ui/dui-components/";

  @Test
  public void publishesAnOwnedScopedLoaderStylesheet() throws IOException {
    try (InputStream stream =
        getClass().getClassLoader().getResourceAsStream(RESOURCE_ROOT + "domino-ui-waitme.css")) {
      assertNotNull("The Domino UI-owned loader stylesheet must be packaged", stream);

      String css = new String(stream.readAllBytes(), StandardCharsets.UTF_8);
      assertTrue(css.contains(".dui-waitme-container"));
      assertTrue(css.contains("@keyframes dui-waitme-animation-bounce"));
      assertFalse(css.contains("waitMe_"));
      assertFalse(css.contains("@keyframes bounce"));
    }
  }

  @Test
  public void genericComponentStylesDoNotReferenceTheLegacyLoaderContainer() throws IOException {
    try (InputStream stream =
        getClass().getClassLoader().getResourceAsStream(RESOURCE_ROOT + "domino-ui-generic.css")) {
      assertNotNull("The generic component stylesheet must be packaged", stream);

      String css = new String(stream.readAllBytes(), StandardCharsets.UTF_8);
      assertFalse(css.contains("waitMe_container"));
      assertTrue(css.contains(".dui.dui-dialog.dui-waitme-container"));
    }
  }
}
