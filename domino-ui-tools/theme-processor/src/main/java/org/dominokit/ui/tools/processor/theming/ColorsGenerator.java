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

        List<Color> colors = Arrays.asList(
                Color.of("default-50", "#FAFAFA"),
                Color.of("default-100", "#FAFAFA"),
                Color.of("default-200", "#EEEEEE"),
                Color.of("default-300", "#E0E0E0"),
                Color.of("default-400", "#BDBDBD"),
                Color.of("default-500", "#9E9E9E"),
                Color.of("default-600", "#757575"),
                Color.of("default-700", "#616161"),
                Color.of("default-800", "#424242"),
                Color.of("default-900", "#212121"),

                Color.of("default-a100", "#FAFAFA"),
                Color.of("default-a200", "#EEEEEE"),
                Color.of("default-a400", "#BDBDBD"),
                Color.of("default-a700", "#616161"),


                Color.of("primary-50", "#E8EAF6"),
                Color.of("primary-100", "#C5CAE9"),
                Color.of("primary-200", "#9FA8DA"),
                Color.of("primary-300", "#7986CB"),
                Color.of("primary-400", "#5C6BC0"),
                Color.of("primary-500", "#3F51B5"),
                Color.of("primary-600", "#3949AB"),
                Color.of("primary-700", "#303F9F"),
                Color.of("primary-800", "#283593"),
                Color.of("primary-900", "#1A237E"),

                Color.of("primary-a100", "#8C9EFF"),
                Color.of("primary-a200", "#536DFE"),
                Color.of("primary-a400", "#3D5AFE"),
                Color.of("primary-a700", "#304FFE"),


                Color.of("secondary-50", "#ECEFF1"),
                Color.of("secondary-100", "#CFD8DC"),
                Color.of("secondary-200", "#B0BEC5"),
                Color.of("secondary-300", "#90A4AE"),
                Color.of("secondary-400", "#78909C"),
                Color.of("secondary-500", "#607D8B"),
                Color.of("secondary-600", "#546E7A"),
                Color.of("secondary-700", "#455A64"),
                Color.of("secondary-800", "#37474F"),
                Color.of("secondary-900", "#263238"),

                Color.of("secondary-a100", "#CFD8DC"),
                Color.of("secondary-a200", "#B0BEC5"),
                Color.of("secondary-a400", "#78909C"),
                Color.of("secondary-a700", "#455A64"),


                Color.of("success-50", "#E8F5E9"),
                Color.of("success-100", "#C8E6C9"),
                Color.of("success-200", "#A5D6A7"),
                Color.of("success-300", "#81C784"),
                Color.of("success-400", "#66BB6A"),
                Color.of("success-500", "#4CAF50"),
                Color.of("success-600", "#43A047"),
                Color.of("success-700", "#388E3C"),
                Color.of("success-800", "#2E7D32"),
                Color.of("success-900", "#1B5E20"),

                Color.of("success-a100", "#B9F6CA"),
                Color.of("success-a200", "#69F0AE"),
                Color.of("success-a400", "#00E676"),
                Color.of("success-a700", "#00C853"),


                Color.of("warning-50", "#FFF3E0"),
                Color.of("warning-100", "#FFE0B2"),
                Color.of("warning-200", "#FFCC80"),
                Color.of("warning-300", "#FFB74D"),
                Color.of("warning-400", "#FFA726"),
                Color.of("warning-500", "#FF9800"),
                Color.of("warning-600", "#FB8C00"),
                Color.of("warning-700", "#F57C00"),
                Color.of("warning-800", "#EF6C00"),
                Color.of("warning-900", "#E65100"),

                Color.of("warning-a100", "#FFD180"),
                Color.of("warning-a200", "#FFAB40"),
                Color.of("warning-a400", "#FF9100"),
                Color.of("warning-a700", "#FF6D00"),


                Color.of("info-50", "#E3F2FD"),
                Color.of("info-100", "#BBDEFB"),
                Color.of("info-200", "#90CAF9"),
                Color.of("info-300", "#64B5F6"),
                Color.of("info-400", "#42A5F5"),
                Color.of("info-500", "#2196F3"),
                Color.of("info-600", "#1E88E5"),
                Color.of("info-700", "#1976D2"),
                Color.of("info-800", "#1565C0"),
                Color.of("info-900", "#0D47A1"),

                Color.of("info-a100", "#82B1FF"),
                Color.of("info-a200", "#448AFF"),
                Color.of("info-a400", "#2979FF"),
                Color.of("info-a700", "#2962FF"),


                Color.of("error-50", "#FFEBEE"),
                Color.of("error-100", "#FFCDD2"),
                Color.of("error-200", "#EF9A9A"),
                Color.of("error-300", "#E57373"),
                Color.of("error-400", "#EF5350"),
                Color.of("error-500", "#F44336"),
                Color.of("error-600", "#E53935"),
                Color.of("error-700", "#D32F2F"),
                Color.of("error-800", "#C62828"),
                Color.of("error-900", "#B71C1C"),

                Color.of("error-a100", "#FF8A80"),
                Color.of("error-a200", "#FF5252"),
                Color.of("error-a400", "#FF1744"),
                Color.of("error-a700", "#D50000"),


                Color.of("red-50", "#FFEBEE"),
                Color.of("red-100", "#FFCDD2"),
                Color.of("red-200", "#EF9A9A"),
                Color.of("red-300", "#E57373"),
                Color.of("red-400", "#EF5350"),
                Color.of("red-500", "#F44336"),
                Color.of("red-600", "#E53935"),
                Color.of("red-700", "#D32F2F"),
                Color.of("red-800", "#C62828"),
                Color.of("red-900", "#B71C1C"),

                Color.of("red-a100", "#FF8A80"),
                Color.of("red-a200", "#FF5252"),
                Color.of("red-a400", "#FF1744"),
                Color.of("red-a700", "#D50000"),


                Color.of("pink-50", "#FCE4EC"),
                Color.of("pink-100", "#F8BBD0"),
                Color.of("pink-200", "#F48FB1"),
                Color.of("pink-300", "#F06292"),
                Color.of("pink-400", "#EC407A"),
                Color.of("pink-500", "#E91E63"),
                Color.of("pink-600", "#D81B60"),
                Color.of("pink-700", "#C2185B"),
                Color.of("pink-800", "#AD1457"),
                Color.of("pink-900", "#880E4F"),

                Color.of("pink-a100", "#FF80AB"),
                Color.of("pink-a200", "#FF4081"),
                Color.of("pink-a400", "#F50057"),
                Color.of("pink-a700", "#C51162"),


                Color.of("purple-50", "#F3E5F5"),
                Color.of("purple-100", "#E1BEE7"),
                Color.of("purple-200", "#CE93D8"),
                Color.of("purple-300", "#BA68C8"),
                Color.of("purple-400", "#AB47BC"),
                Color.of("purple-500", "#9C27B0"),
                Color.of("purple-600", "#8E24AA"),
                Color.of("purple-700", "#7B1FA2"),
                Color.of("purple-800", "#6A1B9A"),
                Color.of("purple-900", "#4A148C"),

                Color.of("purple-a100", "#EA80FC"),
                Color.of("purple-a200", "#E040FB"),
                Color.of("purple-a400", "#D500F9"),
                Color.of("purple-a700", "#AA00FF"),


                Color.of("deep-purple-50", "#EDE7F6"),
                Color.of("deep-purple-100", "#D1C4E9"),
                Color.of("deep-purple-200", "#B39DDB"),
                Color.of("deep-purple-300", "#9575CD"),
                Color.of("deep-purple-400", "#7E57C2"),
                Color.of("deep-purple-500", "#673AB7"),
                Color.of("deep-purple-600", "#5E35B1"),
                Color.of("deep-purple-700", "#512DA8"),
                Color.of("deep-purple-800", "#4527A0"),
                Color.of("deep-purple-900", "#311B92"),

                Color.of("deep-purple-a100", "#B388FF"),
                Color.of("deep-purple-a200", "#7C4DFF"),
                Color.of("deep-purple-a400", "#651FFF"),
                Color.of("deep-purple-a700", "#6200EA"),


                Color.of("indigo-50", "#E8EAF6"),
                Color.of("indigo-100", "#C5CAE9"),
                Color.of("indigo-200", "#9FA8DA"),
                Color.of("indigo-300", "#7986CB"),
                Color.of("indigo-400", "#5C6BC0"),
                Color.of("indigo-500", "#3F51B5"),
                Color.of("indigo-600", "#3949AB"),
                Color.of("indigo-700", "#303F9F"),
                Color.of("indigo-800", "#283593"),
                Color.of("indigo-900", "#1A237E"),

                Color.of("indigo-a100", "#8C9EFF"),
                Color.of("indigo-a200", "#536DFE"),
                Color.of("indigo-a400", "#3D5AFE"),
                Color.of("indigo-a700", "#304FFE"),


                Color.of("blue-50", "#E3F2FD"),
                Color.of("blue-100", "#BBDEFB"),
                Color.of("blue-200", "#90CAF9"),
                Color.of("blue-300", "#64B5F6"),
                Color.of("blue-400", "#42A5F5"),
                Color.of("blue-500", "#2196F3"),
                Color.of("blue-600", "#1E88E5"),
                Color.of("blue-700", "#1976D2"),
                Color.of("blue-800", "#1565C0"),
                Color.of("blue-900", "#0D47A1"),

                Color.of("blue-a100", "#82B1FF"),
                Color.of("blue-a200", "#448AFF"),
                Color.of("blue-a400", "#2979FF"),
                Color.of("blue-a700", "#2962FF"),


                Color.of("light-blue-50", "#E1F5FE"),
                Color.of("light-blue-100", "#B3E5FC"),
                Color.of("light-blue-200", "#81D4FA"),
                Color.of("light-blue-300", "#4FC3F7"),
                Color.of("light-blue-400", "#29B6F6"),
                Color.of("light-blue-500", "#03A9F4"),
                Color.of("light-blue-600", "#039BE5"),
                Color.of("light-blue-700", "#0288D1"),
                Color.of("light-blue-800", "#0277BD"),
                Color.of("light-blue-900", "#01579B"),

                Color.of("light-blue-a100", "#80D8FF"),
                Color.of("light-blue-a200", "#40C4FF"),
                Color.of("light-blue-a400", "#00B0FF"),
                Color.of("light-blue-a700", "#0091EA"),


                Color.of("cyan-50", "#E0F7FA"),
                Color.of("cyan-100", "#B2EBF2"),
                Color.of("cyan-200", "#80DEEA"),
                Color.of("cyan-300", "#4DD0E1"),
                Color.of("cyan-400", "#26C6DA"),
                Color.of("cyan-500", "#00BCD4"),
                Color.of("cyan-600", "#00ACC1"),
                Color.of("cyan-700", "#0097A7"),
                Color.of("cyan-800", "#00838F"),
                Color.of("cyan-900", "#006064"),

                Color.of("cyan-a100", "#84FFFF"),
                Color.of("cyan-a200", "#18FFFF"),
                Color.of("cyan-a400", "#00E5FF"),
                Color.of("cyan-a700", "#00B8D4"),


                Color.of("teal-50", "#E0F2F1"),
                Color.of("teal-100", "#B2DFDB"),
                Color.of("teal-200", "#80CBC4"),
                Color.of("teal-300", "#4DB6AC"),
                Color.of("teal-400", "#26A69A"),
                Color.of("teal-500", "#009688"),
                Color.of("teal-600", "#00897B"),
                Color.of("teal-700", "#00796B"),
                Color.of("teal-800", "#00695C"),
                Color.of("teal-900", "#004D40"),

                Color.of("teal-a100", "#A7FFEB"),
                Color.of("teal-a200", "#64FFDA"),
                Color.of("teal-a400", "#1DE9B6"),
                Color.of("teal-a700", "#00BFA5"),


                Color.of("green-50", "#E8F5E9"),
                Color.of("green-100", "#C8E6C9"),
                Color.of("green-200", "#A5D6A7"),
                Color.of("green-300", "#81C784"),
                Color.of("green-400", "#66BB6A"),
                Color.of("green-500", "#4CAF50"),
                Color.of("green-600", "#43A047"),
                Color.of("green-700", "#388E3C"),
                Color.of("green-800", "#2E7D32"),
                Color.of("green-900", "#1B5E20"),

                Color.of("green-a100", "#B9F6CA"),
                Color.of("green-a200", "#69F0AE"),
                Color.of("green-a400", "#00E676"),
                Color.of("green-a700", "#00C853"),

                Color.of("light-green-50", "#F1F8E9"),
                Color.of("light-green-100", "#DCEDC8"),
                Color.of("light-green-200", "#C5E1A5"),
                Color.of("light-green-300", "#AED581"),
                Color.of("light-green-400", "#9CCC65"),
                Color.of("light-green-500", "#8BC34A"),
                Color.of("light-green-600", "#7CB342"),
                Color.of("light-green-700", "#689F38"),
                Color.of("light-green-800", "#558B2F"),
                Color.of("light-green-900", "#33691E"),

                Color.of("light-green-a100", "#CCFF90"),
                Color.of("light-green-a200", "#B2FF59"),
                Color.of("light-green-a400", "#76FF03"),
                Color.of("light-green-a700", "#64DD17"),

                Color.of("lime-50", "#F9FBE7"),
                Color.of("lime-100", "#F0F4C3"),
                Color.of("lime-200", "#E6EE9C"),
                Color.of("lime-300", "#DCE775"),
                Color.of("lime-400", "#D4E157"),
                Color.of("lime-500", "#CDDC39"),
                Color.of("lime-600", "#C0CA33"),
                Color.of("lime-700", "#AFB42B"),
                Color.of("lime-800", "#9E9D24"),
                Color.of("lime-900", "#827717"),

                Color.of("lime-a100", "#F4FF81"),
                Color.of("lime-a200", "#EEFF41"),
                Color.of("lime-a400", "#C6FF00"),
                Color.of("lime-a700", "#AEEA00"),


                Color.of("yellow-50", "#FFFDE7"),
                Color.of("yellow-100", "#FFF9C4"),
                Color.of("yellow-200", "#FFF59D"),
                Color.of("yellow-300", "#FFF176"),
                Color.of("yellow-400", "#FFEE58"),
                Color.of("yellow-500", "#FFEB3B"),
                Color.of("yellow-600", "#FDD835"),
                Color.of("yellow-700", "#FBC02D"),
                Color.of("yellow-800", "#F9A825"),
                Color.of("yellow-900", "#F57F17"),

                Color.of("yellow-a100", "#FFFF8D"),
                Color.of("yellow-a200", "#FFFF00"),
                Color.of("yellow-a400", "#FFEA00"),
                Color.of("yellow-a700", "#FFD600"),


                Color.of("amber-50", "#FFF8E1"),
                Color.of("amber-100", "#FFECB3"),
                Color.of("amber-200", "#FFE082"),
                Color.of("amber-300", "#FFD54F"),
                Color.of("amber-400", "#FFCA28"),
                Color.of("amber-500", "#FFC107"),
                Color.of("amber-600", "#FFB300"),
                Color.of("amber-700", "#FFA000"),
                Color.of("amber-800", "#FF8F00"),
                Color.of("amber-900", "#FF6F00"),

                Color.of("amber-a100", "#FFE57F"),
                Color.of("amber-a200", "#FFD740"),
                Color.of("amber-a400", "#FFC400"),
                Color.of("amber-a700", "#FFAB00"),

                Color.of("orange-50", "#FFF3E0"),
                Color.of("orange-100", "#FFE0B2"),
                Color.of("orange-200", "#FFCC80"),
                Color.of("orange-300", "#FFB74D"),
                Color.of("orange-400", "#FFA726"),
                Color.of("orange-500", "#FF9800"),
                Color.of("orange-600", "#FB8C00"),
                Color.of("orange-700", "#F57C00"),
                Color.of("orange-800", "#EF6C00"),
                Color.of("orange-900", "#E65100"),

                Color.of("orange-a100", "#FFD180"),
                Color.of("orange-a200", "#FFAB40"),
                Color.of("orange-a400", "#FF9100"),
                Color.of("orange-a700", "#FF6D00"),


                Color.of("deep-orange-50", "#FBE9E7"),
                Color.of("deep-orange-100", "#FFCCBC"),
                Color.of("deep-orange-200", "#FFAB91"),
                Color.of("deep-orange-300", "#FF8A65"),
                Color.of("deep-orange-400", "#FF7043"),
                Color.of("deep-orange-500", "#FF5722"),
                Color.of("deep-orange-600", "#F4511E"),
                Color.of("deep-orange-700", "#E64A19"),
                Color.of("deep-orange-800", "#D84315"),
                Color.of("deep-orange-900", "#BF360C"),

                Color.of("deep-orange-a100", "#FF9E80"),
                Color.of("deep-orange-a200", "#FF6E40"),
                Color.of("deep-orange-a400", "#FF3D00"),
                Color.of("deep-orange-a700", "#DD2C00"),


                Color.of("brown-50", "#EFEBE9"),
                Color.of("brown-100", "#D7CCC8"),
                Color.of("brown-200", "#BCAAA4"),
                Color.of("brown-300", "#A1887F"),
                Color.of("brown-400", "#8D6E63"),
                Color.of("brown-500", "#795548"),
                Color.of("brown-600", "#6D4C41"),
                Color.of("brown-700", "#5D4037"),
                Color.of("brown-800", "#4E342E"),
                Color.of("brown-900", "#3E2723"),

                Color.of("brown-a100", "#D7CCC8"),
                Color.of("brown-a200", "#BCAAA4"),
                Color.of("brown-a400", "#8D6E63"),
                Color.of("brown-a700", "#5D4037"),

                Color.of("grey-50", "#FAFAFA"),
                Color.of("grey-100", "#FAFAFA"),
                Color.of("grey-200", "#EEEEEE"),
                Color.of("grey-300", "#E0E0E0"),
                Color.of("grey-400", "#BDBDBD"),
                Color.of("grey-500", "#9E9E9E"),
                Color.of("grey-600", "#757575"),
                Color.of("grey-700", "#616161"),
                Color.of("grey-800", "#424242"),
                Color.of("grey-900", "#212121"),

                Color.of("grey-a100", "#FAFAFA"),
                Color.of("grey-a200", "#EEEEEE"),
                Color.of("grey-a400", "#BDBDBD"),
                Color.of("grey-a700", "#616161"),


                Color.of("blue-grey-50", "#ECEFF1"),
                Color.of("blue-grey-100", "#CFD8DC"),
                Color.of("blue-grey-200", "#B0BEC5"),
                Color.of("blue-grey-300", "#90A4AE"),
                Color.of("blue-grey-400", "#78909C"),
                Color.of("blue-grey-500", "#607D8B"),
                Color.of("blue-grey-600", "#546E7A"),
                Color.of("blue-grey-700", "#455A64"),
                Color.of("blue-grey-800", "#37474F"),
                Color.of("blue-grey-900", "#263238"),

                Color.of("blue-grey-a100", "#CFD8DC"),
                Color.of("blue-grey-a200", "#B0BEC5"),
                Color.of("blue-grey-a400", "#78909C"),
                Color.of("blue-grey-a700", "#455A64"),

                Color.of("black", "#000"),

                Color.of("white", "#FFF")
        );

//        List<Media> mediaList = Arrays.asList(
//                Media.of("xlg", "(min-width: 1800px)"),
//                Media.of("lg", "(min-width: 1200px) and (max-width: 1800px)"),
//                Media.of("md", "(min-width: 992px) and (max-width: 1200px)"),
//                Media.of("sm", "(min-width: 768px) and (max-width: 992px)"),
//                Media.of("xsm", "(max-width: 768px)"),
//
//                Media.of("xlgup", "(min-width: 1800px)"),
//                Media.of("lgup", "(min-width: 1200px)"),
//                Media.of("mdup", "(min-width: 992px)"),
//                Media.of("smup", "(min-width: 768px)"),
//                Media.of("xsmup", "(min-width: 0x)"),
//
//                Media.of("xlgdwn", "(max-width: 1800px)"),
//                Media.of("lgdwn", "(max-width: 1800px)"),
//                Media.of("mddwn", "(max-width: 1200px)"),
//                Media.of("smdwn", "(max-width: 992px)"),
//                Media.of("xsmdwn", "(max-width: 768px)")
//        );

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


        Path source = Paths.get(ColorsGenerator.class.getResource("/").getPath());

        File file = Paths.get(source.toAbsolutePath().toString(), "colors.css").toFile();
        FileWriter fileWriter = new FileWriter(file);

        themeTemplate.process(parameters, fileWriter);

    }

}
