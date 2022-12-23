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

public class CssToLowerCase {

  public static void main(String[] args) throws IOException {
    InputStream source = CssToJavaCssConverter.class.getResourceAsStream("/converter-source.css");
    String css = IOUtils.toString(source, StandardCharsets.UTF_8);

    Arrays.stream(css.split("\\r?\\n|\\r"))
        .filter(line -> !line.trim().isEmpty())
        .map(line -> line.toLowerCase().replace("cssclass", "CssClass").replace("string", "String"))
        .forEach(s -> System.out.println(s));
  }
}
