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

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.List;
import java.util.stream.Collectors;
import org.junit.Test;

public class OptionalThemeResourceTest {

  private static final String FILE_LIST =
      "/org/dominokit/domino/ui/themes/domino-optional-theme-css-files.txt";

  @Test
  public void allOptionalThemeResourcesExistAndAreScoped() throws IOException {
    List<String> resources = readFileList();

    assertTrue("The optional theme manifest must not be empty", resources.size() > 0);

    for (String resource : resources) {
      String css = readResource(resource);
      assertTrue(resource + " must define a Domino theme scope", css.contains(".dui.dui-theme-"));
      assertFalse(resource + " must not expose demo-only -lab classes", css.contains("-lab"));
      assertFalse(resource + " must not define :root", css.contains(":root"));
      assertFalse(resource + " must not depend on body.dui", css.contains("body.dui"));
      assertFalse(resource + " must not contain WaitMe selectors", css.contains("waitMe_"));
      assertFalse(resource + " must not contain WaitMe selectors", css.contains(".waitMe_"));
    }
  }

  private List<String> readFileList() throws IOException {
    InputStream stream = getClass().getResourceAsStream(FILE_LIST);
    assertNotNull("Optional theme resource manifest is missing", stream);
    try (BufferedReader reader =
        new BufferedReader(new InputStreamReader(stream, StandardCharsets.UTF_8))) {
      return reader
          .lines()
          .map(String::trim)
          .filter(line -> !line.isEmpty() && !line.startsWith("#"))
          .collect(Collectors.toList());
    }
  }

  private String readResource(String resource) throws IOException {
    InputStream stream = getClass().getClassLoader().getResourceAsStream(resource);
    assertNotNull("Missing optional theme resource: " + resource, stream);
    try (InputStream input = stream) {
      return new String(input.readAllBytes(), StandardCharsets.UTF_8);
    }
  }
}
