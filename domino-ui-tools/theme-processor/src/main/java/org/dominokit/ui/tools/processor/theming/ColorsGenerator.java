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

public class ColorsGenerator {
  public static void main(String[] args) throws IOException, TemplateException {
    // accent, background
    List<Color> colors =
        Arrays.asList(
            Color.of("dominant-l-5", "#FAFAFA"),
            Color.of("dominant-l-4", "#FAFAFA"),
            Color.of("dominant-l-3", "#EEEEEE"),
            Color.of("dominant-l-2", "#E0E0E0"),
            Color.of("dominant-l-1", "#BDBDBD"),
            Color.of("dominant", "#9E9E9E"),
            Color.of("dominant-d-1", "#757575"),
            Color.of("dominant-d-2", "#616161"),
            Color.of("dominant-d-3", "#424242"),
            Color.of("dominant-d-4", "#212121"),

            Color.of("accent-l-5", "#FAFAFA"),
            Color.of("accent-l-4", "#FAFAFA"),
            Color.of("accent-l-3", "#EEEEEE"),
            Color.of("accent-l-2", "#E0E0E0"),
            Color.of("accent-l-1", "#BDBDBD"),
            Color.of("accent", "#9E9E9E"),
            Color.of("accent-d-1", "#757575"),
            Color.of("accent-d-2", "#616161"),
            Color.of("accent-d-3", "#424242"),
            Color.of("accent-d-4", "#212121"),

            Color.of("primary-l-5", "#E8EAF6"),
            Color.of("primary-l-4", "#C5CAE9"),
            Color.of("primary-l-3", "#9FA8DA"),
            Color.of("primary-l-2", "#7986CB"),
            Color.of("primary-l-1", "#5C6BC0"),
            Color.of("primary", "#3F51B5"),
            Color.of("primary-d-1", "#3949AB"),
            Color.of("primary-d-2", "#303F9F"),
            Color.of("primary-d-3", "#283593"),
            Color.of("primary-d-4", "#1A237E"),

            Color.of("secondary-l-5", "#ECEFF1"),
            Color.of("secondary-l-4", "#CFD8DC"),
            Color.of("secondary-l-3", "#B0BEC5"),
            Color.of("secondary-l-2", "#90A4AE"),
            Color.of("secondary-l-1", "#78909C"),
            Color.of("secondary", "#607D8B"),
            Color.of("secondary-d-1", "#546E7A"),
            Color.of("secondary-d-2", "#455A64"),
            Color.of("secondary-d-3", "#37474F"),
            Color.of("secondary-d-4", "#263238"),
            
            Color.of("success-l-5", "#E8F5E9"),
            Color.of("success-l-4", "#C8E6C9"),
            Color.of("success-l-3", "#A5D6A7"),
            Color.of("success-l-2", "#81C784"),
            Color.of("success-l-1", "#66BB6A"),
            Color.of("success", "#4CAF50"),
            Color.of("success-d-1", "#43A047"),
            Color.of("success-d-2", "#388E3C"),
            Color.of("success-d-3", "#2E7D32"),
            Color.of("success-d-4", "#1B5E20"),

            Color.of("warning-l-5", "#FFF3E0"),
            Color.of("warning-l-4", "#FFE0B2"),
            Color.of("warning-l-3", "#FFCC80"),
            Color.of("warning-l-2", "#FFB74D"),
            Color.of("warning-l-1", "#FFA726"),
            Color.of("warning", "#FF9800"),
            Color.of("warning-d-1", "#FB8C00"),
            Color.of("warning-d-2", "#F57C00"),
            Color.of("warning-d-3", "#EF6C00"),
            Color.of("warning-d-4", "#E65100"),

            Color.of("info-l-5", "#E3F2FD"),
            Color.of("info-l-4", "#BBDEFB"),
            Color.of("info-l-3", "#90CAF9"),
            Color.of("info-l-2", "#64B5F6"),
            Color.of("info-l-1", "#42A5F5"),
            Color.of("info", "#2196F3"),
            Color.of("info-d-1", "#1E88E5"),
            Color.of("info-d-2", "#1976D2"),
            Color.of("info-d-3", "#1565C0"),
            Color.of("info-d-4", "#0D47A1"),

            Color.of("error-l-5", "#FFEBEE"),
            Color.of("error-l-4", "#FFCDD2"),
            Color.of("error-l-3", "#EF9A9A"),
            Color.of("error-l-2", "#E57373"),
            Color.of("error-l-1", "#EF5350"),
            Color.of("error", "#F44336"),
            Color.of("error-d-1", "#E53935"),
            Color.of("error-d-2", "#D32F2F"),
            Color.of("error-d-3", "#C62828"),
            Color.of("error-d-4", "#B71C1C"),

            Color.of("red-l-5", "#FFEBEE"),
            Color.of("red-l-4", "#FFCDD2"),
            Color.of("red-l-3", "#EF9A9A"),
            Color.of("red-l-2", "#E57373"),
            Color.of("red-l-1", "#EF5350"),
            Color.of("red", "#F44336"),
            Color.of("red-d-1", "#E53935"),
            Color.of("red-d-2", "#D32F2F"),
            Color.of("red-d-3", "#C62828"),
            Color.of("red-d-4", "#B71C1C"),

            Color.of("pink-l-5", "#FCE4EC"),
            Color.of("pink-l-4", "#F8BBD0"),
            Color.of("pink-l-3", "#F48FB1"),
            Color.of("pink-l-2", "#F06292"),
            Color.of("pink-l-1", "#EC407A"),
            Color.of("pink", "#E91E63"),
            Color.of("pink-d-1", "#D81B60"),
            Color.of("pink-d-2", "#C2185B"),
            Color.of("pink-d-3", "#AD1457"),
            Color.of("pink-d-4", "#880E4F"),

            Color.of("purple-l-5", "#F3E5F5"),
            Color.of("purple-l-4", "#E1BEE7"),
            Color.of("purple-l-3", "#CE93D8"),
            Color.of("purple-l-2", "#BA68C8"),
            Color.of("purple-l-1", "#AB47BC"),
            Color.of("purple", "#9C27B0"),
            Color.of("purple-d-1", "#8E24AA"),
            Color.of("purple-d-2", "#7B1FA2"),
            Color.of("purple-d-3", "#6A1B9A"),
            Color.of("purple-d-4", "#4A148C"),

            Color.of("deep-purple-l-5", "#EDE7F6"),
            Color.of("deep-purple-l-4", "#D1C4E9"),
            Color.of("deep-purple-l-3", "#B39DDB"),
            Color.of("deep-purple-l-2", "#9575CD"),
            Color.of("deep-purple-l-1", "#7E57C2"),
            Color.of("deep-purple", "#673AB7"),
            Color.of("deep-purple-d-1", "#5E35B1"),
            Color.of("deep-purple-d-2", "#512DA8"),
            Color.of("deep-purple-d-3", "#4527A0"),
            Color.of("deep-purple-d-4", "#311B92"),

            Color.of("indigo-l-5", "#E8EAF6"),
            Color.of("indigo-l-4", "#C5CAE9"),
            Color.of("indigo-l-3", "#9FA8DA"),
            Color.of("indigo-l-2", "#7986CB"),
            Color.of("indigo-l-1", "#5C6BC0"),
            Color.of("indigo", "#3F51B5"),
            Color.of("indigo-d-1", "#3949AB"),
            Color.of("indigo-d-2", "#303F9F"),
            Color.of("indigo-d-3", "#283593"),
            Color.of("indigo-d-4", "#1A237E"),

            Color.of("blue-l-5", "#E3F2FD"),
            Color.of("blue-l-4", "#BBDEFB"),
            Color.of("blue-l-3", "#90CAF9"),
            Color.of("blue-l-2", "#64B5F6"),
            Color.of("blue-l-1", "#42A5F5"),
            Color.of("blue", "#2196F3"),
            Color.of("blue-d-1", "#1E88E5"),
            Color.of("blue-d-2", "#1976D2"),
            Color.of("blue-d-3", "#1565C0"),
            Color.of("blue-d-4", "#0D47A1"),

            Color.of("light-blue-l-5", "#E1F5FE"),
            Color.of("light-blue-l-4", "#B3E5FC"),
            Color.of("light-blue-l-3", "#81D4FA"),
            Color.of("light-blue-l-2", "#4FC3F7"),
            Color.of("light-blue-l-1", "#29B6F6"),
            Color.of("light-blue", "#03A9F4"),
            Color.of("light-blue-d-1", "#039BE5"),
            Color.of("light-blue-d-2", "#0288D1"),
            Color.of("light-blue-d-3", "#0277BD"),
            Color.of("light-blue-d-4", "#01579B"),

            Color.of("cyan-l-5", "#E0F7FA"),
            Color.of("cyan-l-4", "#B2EBF2"),
            Color.of("cyan-l-3", "#80DEEA"),
            Color.of("cyan-l-2", "#4DD0E1"),
            Color.of("cyan-l-1", "#26C6DA"),
            Color.of("cyan", "#00BCD4"),
            Color.of("cyan-d-1", "#00ACC1"),
            Color.of("cyan-d-2", "#0097A7"),
            Color.of("cyan-d-3", "#00838F"),
            Color.of("cyan-d-4", "#006064"),

            Color.of("teal-l-5", "#E0F2F1"),
            Color.of("teal-l-4", "#B2DFDB"),
            Color.of("teal-l-3", "#80CBC4"),
            Color.of("teal-l-2", "#4DB6AC"),
            Color.of("teal-l-1", "#26A69A"),
            Color.of("teal", "#009688"),
            Color.of("teal-d-1", "#00897B"),
            Color.of("teal-d-2", "#00796B"),
            Color.of("teal-d-3", "#00695C"),
            Color.of("teal-d-4", "#004D40"),

            Color.of("green-l-5", "#E8F5E9"),
            Color.of("green-l-4", "#C8E6C9"),
            Color.of("green-l-3", "#A5D6A7"),
            Color.of("green-l-2", "#81C784"),
            Color.of("green-l-1", "#66BB6A"),
            Color.of("green", "#4CAF50"),
            Color.of("green-d-1", "#43A047"),
            Color.of("green-d-2", "#388E3C"),
            Color.of("green-d-3", "#2E7D32"),
            Color.of("green-d-4", "#1B5E20"),

            Color.of("light-green-l-5", "#F1F8E9"),
            Color.of("light-green-l-4", "#DCEDC8"),
            Color.of("light-green-l-3", "#C5E1A5"),
            Color.of("light-green-l-2", "#AED581"),
            Color.of("light-green-l-1", "#9CCC65"),
            Color.of("light-green", "#8BC34A"),
            Color.of("light-green-d-1", "#7CB342"),
            Color.of("light-green-d-2", "#689F38"),
            Color.of("light-green-d-3", "#558B2F"),
            Color.of("light-green-d-4", "#33691E"),

            Color.of("lime-l-4", "#F0F4C3"),
            Color.of("lime-l-3", "#E6EE9C"),
            Color.of("lime-l-2", "#DCE775"),
            Color.of("lime-l-1", "#D4E157"),
            Color.of("lime", "#CDDC39"),
            Color.of("lime-d-1", "#C0CA33"),
            Color.of("lime-d-2", "#AFB42B"),
            Color.of("lime-d-3", "#9E9D24"),
            Color.of("lime-d-4", "#827717"),

            Color.of("yellow-l-5", "#FFFDE7"),
            Color.of("yellow-l-4", "#FFF9C4"),
            Color.of("yellow-l-3", "#FFF59D"),
            Color.of("yellow-l-2", "#FFF176"),
            Color.of("yellow-l-1", "#FFEE58"),
            Color.of("yellow", "#FFEB3B"),
            Color.of("yellow-d-1", "#FDD835"),
            Color.of("yellow-d-2", "#FBC02D"),
            Color.of("yellow-d-3", "#F9A825"),
            Color.of("yellow-d-4", "#F57F17"),

            Color.of("amber-l-5", "#FFF8E1"),
            Color.of("amber-l-4", "#FFECB3"),
            Color.of("amber-l-3", "#FFE082"),
            Color.of("amber-l-2", "#FFD54F"),
            Color.of("amber-l-1", "#FFCA28"),
            Color.of("amber", "#FFC107"),
            Color.of("amber-d-1", "#FFB300"),
            Color.of("amber-d-2", "#FFA000"),
            Color.of("amber-d-3", "#FF8F00"),
            Color.of("amber-d-4", "#FF6F00"),

            Color.of("orange-l-5", "#FFF3E0"),
            Color.of("orange-l-4", "#FFE0B2"),
            Color.of("orange-l-3", "#FFCC80"),
            Color.of("orange-l-2", "#FFB74D"),
            Color.of("orange-l-1", "#FFA726"),
            Color.of("orange", "#FF9800"),
            Color.of("orange-d-1", "#FB8C00"),
            Color.of("orange-d-2", "#F57C00"),
            Color.of("orange-d-3", "#EF6C00"),
            Color.of("orange-d-4", "#E65100"),

            Color.of("deep-orange-l-5", "#FBE9E7"),
            Color.of("deep-orange-l-4", "#FFCCBC"),
            Color.of("deep-orange-l-3", "#FFAB91"),
            Color.of("deep-orange-l-2", "#FF8A65"),
            Color.of("deep-orange-l-1", "#FF7043"),
            Color.of("deep-orange", "#FF5722"),
            Color.of("deep-orange-d-1", "#F4511E"),
            Color.of("deep-orange-d-2", "#E64A19"),
            Color.of("deep-orange-d-3", "#D84315"),
            Color.of("deep-orange-d-4", "#BF360C"),

            Color.of("brown-l-5", "#EFEBE9"),
            Color.of("brown-l-4", "#D7CCC8"),
            Color.of("brown-l-3", "#BCAAA4"),
            Color.of("brown-l-2", "#A1887F"),
            Color.of("brown-l-1", "#8D6E63"),
            Color.of("brown", "#795548"),
            Color.of("brown-d-1", "#6D4C41"),
            Color.of("brown-d-2", "#5D4037"),
            Color.of("brown-d-3", "#4E342E"),
            Color.of("brown-d-4", "#3E2723"),

            Color.of("grey-l-5", "#FAFAFA"),
            Color.of("grey-l-4", "#FAFAFA"),
            Color.of("grey-l-3", "#EEEEEE"),
            Color.of("grey-l-2", "#E0E0E0"),
            Color.of("grey-l-1", "#BDBDBD"),
            Color.of("grey", "#9E9E9E"),
            Color.of("grey-d-1", "#757575"),
            Color.of("grey-d-2", "#616161"),
            Color.of("grey-d-3", "#424242"),
            Color.of("grey-d-4", "#212121"),

            Color.of("blue-grey-l-5", "#ECEFF1"),
            Color.of("blue-grey-l-4", "#CFD8DC"),
            Color.of("blue-grey-l-3", "#B0BEC5"),
            Color.of("blue-grey-l-2", "#90A4AE"),
            Color.of("blue-grey-l-1", "#78909C"),
            Color.of("blue-grey", "#607D8B"),
            Color.of("blue-grey-d-1", "#546E7A"),
            Color.of("blue-grey-d-2", "#455A64"),
            Color.of("blue-grey-d-3", "#37474F"),
            Color.of("blue-grey-d-4", "#263238"),

            Color.of("white-l-5", "#FAFAFA"),
            Color.of("white-l-4", "#FAFAFA"),
            Color.of("white-l-3", "#EEEEEE"),
            Color.of("white-l-2", "#E0E0E0"),
            Color.of("white-l-1", "#BDBDBD"),
            Color.of("white", "#FFFFFF"),
            Color.of("white-d-1", "#FAFAFA"),
            Color.of("white-d-2", "#EEEEEE"),
            Color.of("white-d-3", "#E0E0E0"),
            Color.of("white-d-4", "#BDBDBD"),

            Color.of("black-l-5", "#BDBDBD"),
            Color.of("black-l-4", "#757575"),
            Color.of("black-l-3", "#616161"),
            Color.of("black-l-2", "#424242"),
            Color.of("black-l-1", "#212121"),
            Color.of("black", "#000000"),
            Color.of("black-d-1", "#757575"),
            Color.of("black-d-2", "#616161"),
            Color.of("black-d-3", "#424242"),
            Color.of("black-d-4", "#212121"),

            Color.of("black", "#000"),
            Color.of("white", "#FFF"),
            Color.of("inherit", "inherit"),
            Color.of("current", "currentColor"),
            Color.of("transparent", "transparent"));

    List<ColorName> colorNames =
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
            ColorName.of("black"));
    

    Configuration configuration = new Configuration(Configuration.VERSION_2_3_29);
    configuration.setClassForTemplateLoading(ColorsGenerator.class, "/");
    configuration.setDefaultEncoding("UTF-8");
    configuration.setTemplateExceptionHandler(TemplateExceptionHandler.RETHROW_HANDLER);
    configuration.setLogTemplateExceptions(false);
    configuration.setWrapUncheckedExceptions(true);
    configuration.setFallbackOnNullLoopVariable(false);

    Template themeTemplate = configuration.getTemplate("ColorTemplate.ftl");
    Map<String, Object> parameters = new HashMap<>();
    parameters.put("colors", colors);
    parameters.put("colorsNames", colorNames);

    Path source = Paths.get(ColorsGenerator.class.getResource("/").getPath());

    File file = Paths.get(source.toAbsolutePath().toString(), "colors.css").toFile();
    FileWriter fileWriter = new FileWriter(file);

    themeTemplate.process(parameters, fileWriter);


    Template sampleTemplate = configuration.getTemplate("ColorsSample.ftl");
    Map<String, Object> sampleParameters = new HashMap<>();
    sampleParameters.put("colors", colors);
    sampleParameters.put("colorsNames", colorNames);

    Path sampleSource = Paths.get(ColorsGenerator.class.getResource("/").getPath());

    File sampleFile = Paths.get(sampleSource.toAbsolutePath().toString(), "ColorsSample.html").toFile();
    FileWriter sampleFileWriter = new FileWriter(sampleFile);

    sampleTemplate.process(sampleParameters, sampleFileWriter);
  }
}
