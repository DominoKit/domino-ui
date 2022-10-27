package org.dominokit.ui.tools.processor.theming;

import org.apache.commons.io.IOUtils;

import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;

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
