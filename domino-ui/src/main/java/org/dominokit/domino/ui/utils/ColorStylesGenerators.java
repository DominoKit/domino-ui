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
package org.dominokit.domino.ui.utils;

import static java.nio.charset.StandardCharsets.UTF_8;

import java.io.*;
import org.dominokit.domino.ui.style.ColorScheme;
import org.gwtproject.safehtml.shared.annotations.GwtIncompatible;

@GwtIncompatible
@Deprecated
public class ColorStylesGenerators {
  public static void main(String[] args) {
    try {

      File file =
          new File(
              "/mnt/CODE/GIT/domino-kit/domino-ui/domino-ui/src/main/resources/color-template.css");
      FileInputStream fis = new FileInputStream(file);
      byte[] bytes = new byte[(int) file.length()];
      fis.read(bytes);
      fis.close();

      file =
          new File(
              "/mnt/CODE/GIT/domino-kit/domino-ui/domino-ui/src/main/resources/all-colors-section.css");
      fis = new FileInputStream(file);
      byte[] whiteBytes = new byte[(int) file.length()];
      fis.read(whiteBytes);
      fis.close();

      String templateContent = new String(bytes, UTF_8);
      String allOtherColorsTemplate = new String(whiteBytes, UTF_8);

      StringBuilder sb = new StringBuilder();

      sb.append(generateColorStyles(templateContent, ColorScheme.RED))
          .append("\n")
          .append(generateColorStyles(templateContent, ColorScheme.PINK))
          .append("\n")
          .append(generateColorStyles(templateContent, ColorScheme.PURPLE))
          .append("\n")
          .append(generateColorStyles(templateContent, ColorScheme.DEEP_PURPLE))
          .append("\n")
          .append(generateColorStyles(templateContent, ColorScheme.INDIGO))
          .append("\n")
          .append(generateColorStyles(templateContent, ColorScheme.BLUE))
          .append("\n")
          .append(generateColorStyles(templateContent, ColorScheme.LIGHT_BLUE))
          .append("\n")
          .append(generateColorStyles(templateContent, ColorScheme.CYAN))
          .append("\n")
          .append(generateColorStyles(templateContent, ColorScheme.TEAL))
          .append("\n")
          .append(generateColorStyles(templateContent, ColorScheme.GREEN))
          .append("\n")
          .append(generateColorStyles(templateContent, ColorScheme.LIGHT_GREEN))
          .append("\n")
          .append(generateColorStyles(templateContent, ColorScheme.LIME))
          .append("\n")
          .append(generateColorStyles(templateContent, ColorScheme.YELLOW))
          .append("\n")
          .append(generateColorStyles(templateContent, ColorScheme.AMBER))
          .append("\n")
          .append(generateColorStyles(templateContent, ColorScheme.ORANGE))
          .append("\n")
          .append(generateColorStyles(templateContent, ColorScheme.DEEP_ORANGE))
          .append("\n")
          .append(generateColorStyles(templateContent, ColorScheme.BROWN))
          .append("\n")
          .append(generateColorStyles(templateContent, ColorScheme.GREY))
          .append("\n")
          .append(generateColorStyles(templateContent, ColorScheme.BLUE_GREY))
          .append("\n")
          .append(allOtherColorsTemplate)
          .append("\n");

      file = new File("domino-ui-colors.css");
      FileOutputStream fos = new FileOutputStream(file);
      fos.write(sb.toString().getBytes());
      System.out.println(file.getAbsoluteFile());
      fos.flush();
      fos.close();

    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  private static String generateColorStyles(String templateContent, ColorScheme color) {
    return templateContent
        .replace("${COLOR}", color.color().getName())
        .replace(
            "${color_base_name}", "-" + color.color().getName().toLowerCase().replace(" ", "-"))
        .replace("${main_color}", color.color().getHex())
        .replace("${color_l_1}", color.lighten_1().getHex())
        .replace("${color_l_2}", color.lighten_2().getHex())
        .replace("${color_l_3}", color.lighten_3().getHex())
        .replace("${color_l_4}", color.lighten_4().getHex())
        .replace("${color_l_5}", color.lighten_5().getHex())
        .replace("${color_d_1}", color.darker_1().getHex())
        .replace("${color_d_2}", color.darker_2().getHex())
        .replace("${color_d_3}", color.darker_3().getHex())
        .replace("${color_d_4}", color.darker_4().getHex())
        .replace("${rgba_1}", color.rgba_1())
        .replace("${rgba_2}", color.rgba_2());
  }
}
