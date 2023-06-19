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

import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;
import freemarker.template.TemplateExceptionHandler;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DuiColorDefine {

  public static void main(String[] args) throws IOException, TemplateException {

    List<ColorName> colors =
        Arrays.asList(
            ColorName.of("dominant"),
            ColorName.of("accent"),
            ColorName.of("primary"),
            ColorName.of("secondary"),
            ColorName.of("success"),
            ColorName.of("warning"),
            ColorName.of("info"),
            ColorName.of("error"),
            ColorName.of("red"),
            ColorName.of("pink"),
            ColorName.of("purple"),
            ColorName.of("deep-purple"),
            ColorName.of("indigo"),
            ColorName.of("blue"),
            ColorName.of("light-blue"),
            ColorName.of("cyan"),
            ColorName.of("teal"),
            ColorName.of("green"),
            ColorName.of("light-green"),
            ColorName.of("lime"),
            ColorName.of("yellow"),
            ColorName.of("amber"),
            ColorName.of("orange"),
            ColorName.of("deep-orange"),
            ColorName.of("brown"),
            ColorName.of("grey"),
            ColorName.of("blue-grey"),
            ColorName.of("white"),
            ColorName.of("black"),
            ColorName.of("transparent"));

    Configuration configuration = new Configuration(Configuration.VERSION_2_3_29);
    configuration.setClassForTemplateLoading(ColorsGenerator.class, "/");
    configuration.setDefaultEncoding("UTF-8");
    configuration.setTemplateExceptionHandler(TemplateExceptionHandler.RETHROW_HANDLER);
    configuration.setLogTemplateExceptions(false);
    configuration.setWrapUncheckedExceptions(true);
    configuration.setFallbackOnNullLoopVariable(false);

    Template colorsTemplate = configuration.getTemplate("JavaColor.ftl");
    Map<String, Object> parameters = new HashMap<>();
    parameters.put("colors", colors);

    Path sampleSource = Paths.get(ColorsGenerator.class.getResource("/").getPath());

    File sampleFile =
        Paths.get(sampleSource.toAbsolutePath().toString(), "ColorsJava.java").toFile();
    FileWriter sampleFileWriter = new FileWriter(sampleFile);

    colorsTemplate.process(parameters, sampleFileWriter);

    /*
    Color RED =
        new Color() {
            @Override
            public CssClass getCssClass() {
                return dui_red;
            }

            @Override
            public String getName() {
                return "RED";
            }

            @Override
            public CssClass getBackground() {
                return dui_bg_red;
            }

            @Override
            public CssClass getForeground() {
                return dui_fg_red;
            }
        };
     */
  }
}
