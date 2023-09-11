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

import com.squareup.javapoet.JavaFile;
import com.squareup.javapoet.TypeSpec;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.apache.commons.io.IOUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/** MdiIconsProcessingStep class. */
public class MdiIconsProcessingStep {

  private static final String MDI_VERSION = "v7.2.96";
  private static final Logger LOGGER = LoggerFactory.getLogger(MdiIconsProcessingStep.class);
  /** Constant <code>ICONS_ROOT_PACKAGE="org.dominokit.domino.ui.icons"</code> */
  public static final String ICONS_ROOT_PACKAGE = "org.dominokit.domino.ui.icons";
  /** Constant <code>PUBLIC_ROOT="org.dominokit.domino.ui.public"</code> */
  public static final String PUBLIC_ROOT = "org.dominokit.domino.ui.public";

  /**
   * {@inheritDoc}
   *
   * @param args an array of {@link java.lang.String} objects
   */
  public static void main(String[] args) {
    generateIcons();
    updateFonts();
    updateCss();
  }

  private static Path getIconRootPath() {
    return Paths.get("domino-ui/src/main/java", ICONS_ROOT_PACKAGE.replace(".", "/"));
  }

  private static Path getSourceRootPath() {
    return Paths.get("domino-ui/src/main/java");
  }

  private static Path getResourceRootPath() {
    return Paths.get("domino-ui/src/main/resources");
  }

  private static Path getResourcePublicRootPath() {
    return Paths.get("domino-ui/src/main/resources/org/dominokit/domino/ui/public");
  }

  private static void updateFonts() {
    copyFont("materialdesignicons-webfont.eot");
    copyFont("materialdesignicons-webfont.ttf");
    copyFont("materialdesignicons-webfont.woff");
    copyFont("materialdesignicons-webfont.woff2");
  }

  private static void updateCss() {
    copyCss("materialdesignicons.css");
    copyCss("materialdesignicons.css.map");
    copyCss("materialdesignicons.min.css");
    copyCss("materialdesignicons.min.css.map");
  }

  private static void copyFont(String fontName) {
    try (InputStream inputStream =
        new URL(
                "https://github.com/Templarian/MaterialDesign-Webfont/blob/"
                    + MDI_VERSION
                    + "/fonts/"
                    + fontName
                    + "?raw=true")
            .openStream()) {
      copyFont(fontName, inputStream);
    } catch (IOException e) {
      try {
        copyFont(
            fontName,
            Files.newInputStream(
                Paths.get(getResourceRootPath().toString(), "cached/mdi/fonts/" + fontName)));
      } catch (IOException ex) {
        LOGGER.error("", ex);
      }
    }
  }

  private static void copyFont(String fontName, InputStream inputStream) throws IOException {
    Path path = Paths.get(getResourcePublicRootPath().toString(), "css/fonts/" + fontName);
    OutputStream outputStream = Files.newOutputStream(path);
    IOUtils.copyLarge(inputStream, outputStream);
    outputStream.close();
  }

  private static void copyCss(String cssName) {
    try (InputStream inputStream =
        new URL(
                "https://raw.githubusercontent.com/Templarian/MaterialDesign-Webfont/"
                    + MDI_VERSION
                    + "/css/"
                    + cssName
                    + "?raw=true")
            .openStream()) {
      copyCss(cssName, inputStream);
    } catch (IOException e) {
      try {
        copyFont(
            cssName,
            Files.newInputStream(
                Paths.get(getResourceRootPath().toString(), "cached/mdi/css/" + cssName)));
      } catch (IOException ex) {
        LOGGER.error("", ex);
      }
    }
  }

  private static void copyCss(String cssName, InputStream inputStream) throws IOException {
    Path path =
        Paths.get(
            getResourcePublicRootPath().toString(), "css/domino-ui/dui-components/mdi/" + cssName);
    System.out.println(path.toFile().getAbsolutePath().toString());
    OutputStream outputStream = Files.newOutputStream(path);
    IOUtils.copyLarge(inputStream, outputStream);
    outputStream.close();
  }

  private static void generateIcons() {
    writeSource(
        new MdiIconsSourceWriter(ICONS_ROOT_PACKAGE, loadIconMetaInfo()).asTypeBuilder(),
        ICONS_ROOT_PACKAGE + ".lib");
  }

  /**
   * writeSource.
   *
   * @param builders a {@link java.util.List} object
   * @param rootPackage a {@link java.lang.String} object
   */
  protected static void writeSource(List<TypeSpec.Builder> builders, String rootPackage) {
    builders.forEach(
        builder -> {
          JavaFile javaFile = JavaFile.builder(rootPackage, builder.build()).build();
          writeSource(javaFile);
        });
  }

  /**
   * Writes the source file to the {@link javax.annotation.processing.Filer}
   *
   * @param sourceFile the source file to write
   */
  protected static void writeSource(JavaFile sourceFile) {
    try {
      sourceFile.writeTo(Paths.get(getSourceRootPath().toString()));
    } catch (IOException e) {
      LOGGER.error("", e);
    }
  }

  private static List<MetaIconInfo> loadIconMetaInfo() {
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
      LOGGER.error("", e);
    }

    return new ArrayList<>();
  }
}
