/*
 * Copyright © 2018 The GWT Authors
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
package org.dominokit.ui.tools.processor;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Set;
import javax.annotation.processing.ProcessingEnvironment;
import javax.lang.model.element.Element;
import javax.tools.FileObject;
import javax.tools.StandardLocation;
import org.apache.commons.io.IOUtils;
import org.dominokit.domino.apt.commons.AbstractProcessingStep;
import org.dominokit.domino.apt.commons.ExceptionUtil;
import org.dominokit.domino.apt.commons.StepBuilder;

public class MdiIconsProcessingStep extends AbstractProcessingStep {

  private static final String MDI_VERSION = "v4.6.95";

  public MdiIconsProcessingStep(ProcessingEnvironment processingEnv) {
    super(processingEnv);
  }

  public static class Builder extends StepBuilder<MdiIconsProcessingStep> {
    public MdiIconsProcessingStep build() {
      return new MdiIconsProcessingStep(processingEnv);
    }
  }

  @Override
  public void process(Set<? extends Element> elementsByAnnotation) {

    for (Element element : elementsByAnnotation) {
      try {
        generateIcons(element);
        updateFonts();
        updateCss();
      } catch (Exception e) {
        ExceptionUtil.messageStackTrace(messager, e);
      }
    }
  }

  private void updateFonts() {
    copyFont("materialdesignicons-webfont.eot");
    copyFont("materialdesignicons-webfont.ttf");
    copyFont("materialdesignicons-webfont.woff");
    copyFont("materialdesignicons-webfont.woff2");
  }

  private void updateCss() {
    copyCss("materialdesignicons.css");
    copyCss("materialdesignicons.css.map");
    copyCss("materialdesignicons.min.css");
    copyCss("materialdesignicons.min.css.map");
  }

  private void copyFont(String fontName) {
    try (InputStream inputStream =
        new URL(
                "https://github.com/Templarian/MaterialDesign-Webfont/blob/"
                    + MDI_VERSION
                    + "/fonts/"
                    + fontName
                    + "?raw=true")
            .openStream()) {
      FileObject resource =
          filer.createResource(
              StandardLocation.SOURCE_OUTPUT,
              "org.dominokit.domino.ui",
              "public/css/mdi/fonts/" + fontName);
      OutputStream outputStream = resource.openOutputStream();
      IOUtils.copyLarge(inputStream, outputStream);
      outputStream.close();
    } catch (IOException e) {
      ExceptionUtil.messageStackTrace(messager, e);
    }
  }

  private void copyCss(String cssName) {
    try (InputStream inputStream =
        new URL(
                "https://raw.githubusercontent.com/Templarian/MaterialDesign-Webfont/"
                    + MDI_VERSION
                    + "/css/"
                    + cssName
                    + "?raw=true")
            .openStream()) {
      FileObject resource =
          filer.createResource(
              StandardLocation.SOURCE_OUTPUT,
              "org.dominokit.domino.ui",
              "public/css/mdi/css/" + cssName);
      OutputStream outputStream = resource.openOutputStream();
      IOUtils.copyLarge(inputStream, outputStream);
      outputStream.close();
    } catch (IOException e) {
      ExceptionUtil.messageStackTrace(messager, e);
    }
  }

  private void generateIcons(Element presenterElement) {
    writeSource(
        new MdiIconsSourceWriter(presenterElement, loadIconMetaInfo(), processingEnv)
            .asTypeBuilder(),
        elements.getPackageOf(presenterElement).getQualifiedName().toString());
  }

  private List<MetaIconInfo> loadIconMetaInfo() {
    try {
      try (InputStream meta =
          new URL(
                  "https://raw.githubusercontent.com/Templarian/MaterialDesign-SVG/"
                      + MDI_VERSION
                      + "/meta.json")
              .openStream()) {
        String metaJson = IOUtils.toString(meta, "UTF-8");
        return Arrays.asList(
            MetaIconInfo_MapperImpl.INSTANCE.readArray(metaJson, MetaIconInfo[]::new));
      }
    } catch (IOException e) {
      ExceptionUtil.messageStackTrace(messager, e);
    }

    return new ArrayList<>();
  }
}
