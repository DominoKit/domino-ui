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

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import org.junit.Test;

public class WaitMeAssetTest {

  private static final String RESOURCE_ROOT =
      "org/dominokit/domino/ui/public/css/domino-ui/dui-components/";

  @Test
  public void readableAndMinifiedAssetsRemainPackagedSeparately() throws IOException {
    assertWaitMeResource(RESOURCE_ROOT + "domino-ui-waitMe.css");
    assertWaitMeResource(RESOURCE_ROOT + "domino-ui-waitMe.min.css");
  }

  @Test
  public void theDominoUiBundleMustNotExcludeTheWaitMeStylesheet() throws IOException {
    String pom = Files.readString(Path.of("pom.xml"), StandardCharsets.UTF_8);

    assertTrue(
        "The standard domino-ui.css bundle must retain the WaitMe loader rules",
        !pom.contains("<cssExclude>domino-ui-waitMe.css</cssExclude>"));
  }

  private void assertWaitMeResource(String resource) throws IOException {
    try (InputStream stream = getClass().getClassLoader().getResourceAsStream(resource)) {
      assertNotNull(resource, stream);
      String css = new String(stream.readAllBytes(), StandardCharsets.UTF_8);
      assertTrue(
          resource + " must contain the WaitMe container selector",
          css.contains("waitMe_container"));
    }
  }
}
