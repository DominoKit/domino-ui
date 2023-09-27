/*
 * Copyright © 2023 Vertispan
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

import java.io.IOException;
import java.util.Arrays;
import javax.tools.DocumentationTool;
import javax.tools.ToolProvider;
import org.dominokit.domino.ui.internal.docs.DominoUiDoclet;
import org.junit.Test;

public class DocletTest {

  @Test
  public void testDocs() throws IOException {
    DocumentationTool systemDocumentationTool = ToolProvider.getSystemDocumentationTool();
    String[] args =
        new String[] {
          "-sourcepath",
          "src/test/java",
          "-subpackages",
          "org.dominokit.domino.ui.alerts",
          DominoUiDoclet.DUI_DOCS_OUT_DIRE,
          "target/apidocs/",
          DominoUiDoclet.DUI_DOCS_ROOT_URL,
          "https://www.javadoc.io/doc/org.dominokit/domino-ui/latest/"
        };
    DocumentationTool.DocumentationTask task =
        systemDocumentationTool.getTask(
            null, null, null, DominoUiDoclet.class, Arrays.asList(args), null);
    task.call();
  }
}
