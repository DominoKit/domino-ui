package org.dominokit.ui.tools.processor;

import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;
import freemarker.template.TemplateExceptionHandler;
import org.dominokit.domino.apt.commons.AbstractProcessingStep;
import org.dominokit.domino.apt.commons.ExceptionUtil;
import org.dominokit.domino.apt.commons.StepBuilder;
import org.dominokit.domino.ui.ColorInfo;
import org.dominokit.domino.ui.ColorsSet;

import javax.annotation.processing.ProcessingEnvironment;
import javax.lang.model.element.Element;
import javax.tools.FileObject;
import javax.tools.StandardLocation;
import java.io.IOException;
import java.io.StringWriter;
import java.io.Writer;
import java.util.*;

public class ThemeProcessingStep extends AbstractProcessingStep {

    public ThemeProcessingStep(ProcessingEnvironment processingEnv) {
        super(processingEnv);
    }

    public static class Builder extends StepBuilder<ThemeProcessingStep> {
        public ThemeProcessingStep build() {
            return new ThemeProcessingStep(processingEnv);
        }
    }

    @Override
    public void process(Set<? extends Element> elementsByAnnotation) {

        for (Element element : elementsByAnnotation) {
            try {
                generateColors(element);
                generateTheme(element);
//                updateCss();
            } catch (Exception e) {
                ExceptionUtil.messageStackTrace(messager, e);
            }
        }
    }

    private void generateTheme(Element element) {
        try {
            Configuration configuration = new Configuration(Configuration.VERSION_2_3_29);
            configuration.setClassForTemplateLoading(this.getClass(), "/");
            configuration.setDefaultEncoding("UTF-8");
            configuration.setTemplateExceptionHandler(TemplateExceptionHandler.RETHROW_HANDLER);
            configuration.setLogTemplateExceptions(false);
            configuration.setWrapUncheckedExceptions(true);
            configuration.setFallbackOnNullLoopVariable(false);

            List<ColorMeta> colorsMeta = new ArrayList<>();

            ColorsSet colorsSet = element.getAnnotation(ColorsSet.class);
            ColorInfo[] colors = colorsSet.value();

            StringBuffer colorsCss = new StringBuffer();

            String publicPackage = processorUtil.getElements().getPackageOf(element).getQualifiedName().toString();

            if (!colorsSet.publicPackage().isEmpty()) {
                publicPackage = colorsSet.publicPackage();
            }
            for (ColorInfo colorInfo : colors) {
                ColorMeta color = new ColorMeta(colorInfo);

                colorsMeta.add(color);
                Map<String, Object> parameters = new HashMap<>();
                parameters.put("color", color);

                Template themeTemplate = configuration.getTemplate("theme.ftl");

                FileObject resource = filer.createResource(StandardLocation.SOURCE_OUTPUT, publicPackage, "public/"+colorsSet.name()+"-theme-" + color.name.toLowerCase() + ".css");
                Writer out = resource.openWriter();
                themeTemplate.process(parameters, out);
                out.flush();
                out.close();

                Template colorCssTemplate = configuration.getTemplate("color-css.ftl");

                StringWriter colorCssWriter = new StringWriter();
                colorCssTemplate.process(parameters, colorCssWriter);
                colorCssWriter.flush();
                colorCssWriter.close();

                colorsCss.append(colorCssWriter.toString());
            }

            if (colorsSet.generateDemoPage()) {
                Map<String, Object> parameters = new HashMap<>();
                Template temp = configuration.getTemplate("colors-demo.ftl");
                parameters.put("colors", colorsMeta);
                parameters.put("colorSetName", colorsSet.name());

                FileObject themeResource = filer.createResource(StandardLocation.SOURCE_OUTPUT, publicPackage, "public/theme-" + colorsSet.name().toLowerCase() + "-colors-demo.html");
                Writer themeWriter = themeResource.openWriter();
                temp.process(parameters, themeWriter);
                themeWriter.flush();
                themeWriter.close();
            }

            FileObject colorCssResource = filer.createResource(StandardLocation.SOURCE_OUTPUT, publicPackage, "public/" + colorsSet.name().toLowerCase() + "-color.css");
            Writer colorCssResourceWriter = colorCssResource.openWriter();
            colorCssResourceWriter.write(colorsCss.toString());
            colorCssResourceWriter.flush();
            colorCssResourceWriter.close();

        } catch (IOException | TemplateException e) {
            ExceptionUtil.messageStackTrace(processorUtil.getMessager(), e);
        }
    }

    private void generateColors(Element element) {
        writeSource(new ThemeSourceWriter(element, processingEnv).asTypeBuilder(), elements.getPackageOf(element).getQualifiedName().toString());
    }

}
