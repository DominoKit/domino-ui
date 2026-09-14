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

import static org.junit.Assert.assertTrue;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import org.junit.Test;

public class CssMinificationPackageContract {

  private static final Path CSS_ROOT =
      Path.of("target/classes/org/dominokit/domino/ui/public/css/domino-ui");

  @Test
  public void publishesMinifiedSiblingsForEveryEligibleDominoStylesheet() throws IOException {
    for (Path source : eligibleSources()) {
      Path minified = minifiedSibling(source);
      assertTrue(minified + " must exist", Files.isRegularFile(minified));
      assertTrue(minified + " must not be empty", Files.size(minified) > 0);
      assertTrue(
          minified + " must be smaller than " + source, Files.size(minified) < Files.size(source));
    }
  }

  @Test
  public void keepsTheLegacyAggregateBundlesAvailable() {
    assertTrue(Files.isRegularFile(CSS_ROOT.resolve("domino-ui.css")));
    assertTrue(Files.isRegularFile(CSS_ROOT.resolve("themes/domino-ui-themes.css")));
  }

  @Test
  public void preservesRepresentativeModernCssSyntaxInMinifiedResources() throws IOException {
    assertContains("dui-components/domino-ui-colors.min.css", "var(--dui-");
    assertContains("dui-components/domino-ui-colors.min.css", "color-mix(");
    assertContains("dui-components/domino-ui-colors.min.css", "@supports");
    assertContains("themes/character/domino-ui-theme-glass.min.css", ":where(");
    assertContains("dui-components/domino-ui-animation.min.css", "@keyframes");
    assertContains("dui-components/screens/domino-ui-screen-small.min.css", "@media");
  }

  private List<Path> eligibleSources() throws IOException {
    try (Stream<Path> paths = Files.walk(CSS_ROOT)) {
      return paths
          .filter(Files::isRegularFile)
          .filter(this::isEligibleSource)
          .collect(Collectors.toList());
    }
  }

  private boolean isEligibleSource(Path source) {
    Path relativePath = CSS_ROOT.relativize(source);
    String path = relativePath.toString().replace('\\', '/');

    return !path.endsWith(".min.css")
        && (path.equals("domino-ui-fonts-modern.css")
            || (path.startsWith("dui-components/")
                && path.contains("/domino-ui-")
                && !path.equals("dui-components/domino-ui-waitMe.css"))
            || (path.startsWith("themes/") && path.contains("/domino-ui-theme-")));
  }

  private Path minifiedSibling(Path source) {
    String filename = source.getFileName().toString();
    return source.resolveSibling(filename.substring(0, filename.length() - 4) + ".min.css");
  }

  private void assertContains(String relativePath, String expectedContent) throws IOException {
    String css = Files.readString(CSS_ROOT.resolve(relativePath), StandardCharsets.UTF_8);
    assertTrue(relativePath + " must contain " + expectedContent, css.contains(expectedContent));
  }
}
