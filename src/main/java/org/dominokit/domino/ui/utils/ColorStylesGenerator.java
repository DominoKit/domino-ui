package org.dominokit.domino.ui.utils;

import org.dominokit.domino.ui.style.ColorScheme;
import org.gwtproject.safehtml.shared.annotations.GwtIncompatible;
import sun.misc.IOUtils;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

import static java.nio.charset.StandardCharsets.UTF_8;

@GwtIncompatible
public class ColorStylesGenerator {
    public static void main(String[] args) {
        try {
            InputStream resourceAsStream = ColorStylesGenerator.class.getClassLoader().getResourceAsStream("color-template.css");
            InputStream whiteColorResourceAsStream = ColorStylesGenerator.class.getClassLoader().getResourceAsStream("all-colors-section.css");
            byte[] bytes = IOUtils.readFully(resourceAsStream, Integer.MAX_VALUE, false);
            byte[] whiteBytes = IOUtils.readFully(whiteColorResourceAsStream, Integer.MAX_VALUE, false);

            String templateContent = new String(bytes, UTF_8);
            String allOtherColorsTemplate = new String(whiteBytes, UTF_8);

            StringBuilder sb = new StringBuilder();

            sb
                    .append(generateColorStyles(templateContent, ColorScheme.RED))
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

            File file=new File("colors.css");
            FileOutputStream fos=new FileOutputStream(file);
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
                .replace("${color_base_name}", "-" + color.color().getName().toLowerCase().replace(" ","-"))
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
