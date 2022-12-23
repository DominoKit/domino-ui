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
package org.dominokit.ui.tools.processor.theming;

import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import org.apache.commons.io.IOUtils;

public class CssToJavaCssConverter {
  public static void main(String[] args) throws IOException {
    InputStream source = CssToJavaCssConverter.class.getResourceAsStream("/converter-source.css");
    String css = IOUtils.toString(source, StandardCharsets.UTF_8);

    StringBuffer sb = new StringBuffer();

    Arrays.stream(css.split("\\r?\\n|\\r"))
        .filter(line -> line.startsWith(".dui."))
        .forEach(line -> sb.append(toJavaCss(line) + "\n"));

    System.out.println(sb);
  }

  private static String toJavaCss(String line) {
    return "public static final CssClass "
        + asName(line)
        + " = () -> \""
        + asStyleName(line)
        + "\";";
  }

  private static String asName(String line) {
    return line.replace(".dui", "")
        .replace("\\\\", "_")
        .replace("-", "_")
        .replace(" > * + *", "")
        .replace(" {", "")
        .substring(1)
        .toUpperCase();
  }

  private static String asStyleName(String line) {
    return line.substring(5).replace(" > * + *", "").replace(" {", "");
  }
}
