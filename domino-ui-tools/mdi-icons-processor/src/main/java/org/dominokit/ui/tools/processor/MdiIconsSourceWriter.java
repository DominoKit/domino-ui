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
package org.dominokit.ui.tools.processor;

import static java.util.Objects.isNull;

import com.squareup.javapoet.*;
import java.util.*;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import javax.lang.model.element.Modifier;

/**
 * MdiIconsSourceWriter class.
 *
 * @author vegegoku
 * @version $Id: $Id
 */
public class MdiIconsSourceWriter {
  /** Constant <code>RESERVED_KEYWORDS</code> */
  public static final Set<String> RESERVED_KEYWORDS =
      new HashSet<>(
          Arrays.asList(
              "abstract",
              "assert",
              "boolean",
              "break",
              "byte",
              "case",
              "catch",
              "char",
              "class",
              "const",
              "continue",
              "default",
              "do",
              "double",
              "else",
              "enum",
              "extends",
              "final",
              "finally",
              "float",
              "for",
              "goto",
              "if",
              "implements",
              "import",
              "instanceof",
              "int",
              "interface",
              "long",
              "native",
              "new",
              "package",
              "private",
              "protected",
              "public",
              "return",
              "short",
              "static",
              "strictfp",
              "super",
              "switch",
              "synchronized",
              "this",
              "throw",
              "throws",
              "transient",
              "try",
              "void",
              "volatile",
              "while",
              "true",
              "false",
              "null"));

  private static final String MDI_ICON_TYPE = "org.dominokit.domino.ui.icons.MdiIcon";
  private static final String MDI_ICON_FACTORY_TYPE =
      "org.dominokit.domino.ui.icons.MdiIconsByTagFactory";
  private static final String MDI_META_TYPE = "org.dominokit.domino.ui.icons.MdiMeta";

  /** Constant <code>UNTAGGED="UnTagged"</code> */
  public static final String UNTAGGED = "UnTagged";

  private final List<MetaIconInfo> metaIconInfos;
  private final String rootPackageName;

  /**
   * Constructor for MdiIconsSourceWriter.
   *
   * @param rootPackage a Element object
   * @param metaIconInfos a {@link java.util.List} object
   */
  protected MdiIconsSourceWriter(String rootPackage, List<MetaIconInfo> metaIconInfos) {
    this.metaIconInfos = metaIconInfos;
    this.rootPackageName = rootPackage + ".lib";
  }

  /**
   * {@inheritDoc}
   *
   * @return a {@link java.util.List} object
   */
  public List<TypeSpec.Builder> asTypeBuilder() {
    return new ArrayList<>(generateIconsByTag());
  }

  private List<TypeSpec.Builder> generateIconsByTag() {
    List<TypeSpec.Builder> types = new ArrayList<>();

    Set<String> tags =
        metaIconInfos.stream()
            .map(MetaIconInfo::getTags)
            .flatMap(List::stream)
            .collect(Collectors.toSet());

    tags.forEach(
        tag -> {
          types.addAll(
              generateByTagInterface(
                  tag,
                  metaIconInfos.stream()
                      .filter(metaIconInfo -> metaIconInfo.getTags().contains(tag))
                      .collect(Collectors.toList())));
        });

    types.addAll(
        generateByTagInterface(
            "",
            metaIconInfos.stream()
                .filter(metaIconInfo -> metaIconInfo.getTags().isEmpty())
                .collect(Collectors.toList())));

    types.add(generateMdiIconsByTagInterface(tags));

    types.add(generateAllMdiIconsInterface());

    types.add(generateMdiTagsConstants(tags));
    types.add(generateMdiByTagFactory(tags));
    types.add(generateAllMdiIconsWithMetaInterface());

    return types;
  }

  private TypeSpec.Builder generateMdiByTagFactory(Set<String> tags) {

    ParameterizedTypeName listType =
        ParameterizedTypeName.get(
            ClassName.get(List.class),
            ParameterizedTypeName.get(
                ClassName.get(Supplier.class), ClassName.bestGuess(MDI_ICON_TYPE)));

    return classBuilder("MdiByTagFactory")
        .addModifiers(Modifier.PUBLIC)
        .addMethod(
            MethodSpec.methodBuilder("get")
                .addModifiers(Modifier.PUBLIC, Modifier.STATIC)
                .returns(listType)
                .addParameter(ParameterSpec.builder(TypeName.get(String.class), "tag").build())
                .addCode(switchCodeBuilder(tags).build())
                .build());
  }

  /**
   * classBuilder.
   *
   * @param name a {@link java.lang.String} object
   * @return a {@link com.squareup.javapoet.TypeSpec.Builder} object
   */
  public static TypeSpec.Builder classBuilder(String name) {
    return TypeSpec.classBuilder(name)
        .addModifiers(Modifier.PUBLIC)
        .addJavadoc("This is a generated class, please don't modify\n");
  }

  /**
   * interfaceBuilder.
   *
   * @param name a {@link java.lang.String} object
   * @return a {@link com.squareup.javapoet.TypeSpec.Builder} object
   */
  public static TypeSpec.Builder interfaceBuilder(String name) {
    return TypeSpec.interfaceBuilder(name)
        .addModifiers(Modifier.PUBLIC)
        .addJavadoc("This is a generated class, please don't modify\n");
  }

  private CodeBlock.Builder switchCodeBuilder(Set<String> tags) {
    ClassName tagsConstants = ClassName.bestGuess(rootPackageName + ".MdiTags");

    CodeBlock.Builder builder = CodeBlock.builder();
    builder.beginControlFlow("switch(tag)");
    tags.forEach(
        tag ->
            builder.addStatement(
                "case $T.$L : return new $T().icons()",
                tagsConstants,
                tagToClassName(tag).toUpperCase(),
                ClassName.bestGuess(rootPackageName + "." + tagToClassName(tag) + "_Factory")));

    builder.addStatement(
        "case $T.$L : return new $T().icons()",
        tagsConstants,
        tagToClassName(UNTAGGED).toUpperCase(),
        ClassName.bestGuess(rootPackageName + "." + tagToClassName(UNTAGGED) + "_Factory"));

    builder.addStatement(
        "default : throw new $T(tag)", TypeName.get(IllegalArgumentException.class));

    builder.endControlFlow();

    return builder;
  }

  private TypeSpec.Builder generateMdiTagsConstants(Set<String> tags) {
    TypeSpec.Builder builder = interfaceBuilder("MdiTags").addModifiers(Modifier.PUBLIC);

    tags.forEach(
        tag ->
            builder.addField(
                FieldSpec.builder(
                        TypeName.get(String.class),
                        tagToClassName(tag).toUpperCase(),
                        Modifier.PUBLIC,
                        Modifier.STATIC,
                        Modifier.FINAL)
                    .initializer("$S", tag)
                    .build()));

    builder.addField(
        FieldSpec.builder(
                TypeName.get(String.class),
                UNTAGGED.toUpperCase(),
                Modifier.PUBLIC,
                Modifier.STATIC,
                Modifier.FINAL)
            .initializer("$S", "")
            .build());

    builder.addField(
        FieldSpec.builder(
                ParameterizedTypeName.get(ClassName.get(List.class), TypeName.get(String.class)),
                "TAGS",
                Modifier.PUBLIC,
                Modifier.STATIC,
                Modifier.FINAL)
            .initializer(
                "$T.asList($L)",
                TypeName.get(Arrays.class),
                tags.stream()
                    .map(tag -> tagToClassName(tag).toUpperCase())
                    .collect(Collectors.joining(",")))
            .build());

    return builder;
  }

  private TypeSpec.Builder generateAllMdiIconsInterface() {
    TypeSpec.Builder builder = classBuilder("Icons").addModifiers(Modifier.PUBLIC);

    metaIconInfos.forEach(
        metaIconInfo -> {
          MethodSpec.Builder iconMethod =
              MethodSpec.methodBuilder(
                      unreservedKeywordName(metaIconInfo.getName().replace("-", "_")))
                  .addModifiers(Modifier.PUBLIC)
                  .addModifiers(Modifier.STATIC)
                  .returns(ClassName.bestGuess(MDI_ICON_TYPE))
                  .addStatement(
                      "return $T.create($S)",
                      ClassName.bestGuess(MDI_ICON_TYPE),
                      "mdi-" + metaIconInfo.getName());

          if (metaIconInfo.isDeprecated()) {
            iconMethod.addAnnotation(Deprecated.class);
          }

          builder.addMethod(iconMethod.build());
        });

    return builder;
  }

  private TypeSpec.Builder generateAllMdiIconsWithMetaInterface() {
    TypeSpec.Builder builder = classBuilder("IconsMeta").addModifiers(Modifier.PUBLIC);

    metaIconInfos.forEach(
        metaIconInfo -> {
          MethodSpec.Builder iconMethod =
              MethodSpec.methodBuilder(
                      unreservedKeywordName(metaIconInfo.getName().replace("-", "_")))
                  .addModifiers(Modifier.PUBLIC)
                  .addModifiers(Modifier.STATIC)
                  .returns(ClassName.bestGuess(MDI_ICON_TYPE))
                  .addStatement(
                      "return $T.create($S, new $T($S, $S, $T.asList($L), $T.asList($L), $S, $S))",
                      ClassName.bestGuess(MDI_ICON_TYPE),
                      "mdi-" + metaIconInfo.getName(),
                      ClassName.bestGuess(MDI_META_TYPE),
                      metaIconInfo.getName(),
                      metaIconInfo.getCodepoint(),
                      TypeName.get(Arrays.class),
                      getStringLiteral(metaIconInfo.getTags()),
                      TypeName.get(Arrays.class),
                      getStringLiteral(metaIconInfo.getAliases()),
                      metaIconInfo.getAuthor(),
                      metaIconInfo.getVersion());

          if (metaIconInfo.isDeprecated()) {
            iconMethod.addAnnotation(Deprecated.class);
          }

          builder.addMethod(iconMethod.build());
        });

    return builder;
  }

  private TypeSpec.Builder generateMdiIconsByTagInterface(Set<String> tags) {
    TypeSpec.Builder builder = interfaceBuilder("MdiIconsByTag").addModifiers(Modifier.PUBLIC);

    tags.forEach(
        tag ->
            builder.addSuperinterface(
                ClassName.bestGuess(rootPackageName + "." + tagToClassName(tag))));

    builder.addSuperinterface(ClassName.bestGuess(rootPackageName + "." + UNTAGGED));

    return builder;
  }

  private List<TypeSpec.Builder> generateByTagInterface(String tag, List<MetaIconInfo> icons) {

    List<TypeSpec.Builder> types = new ArrayList<>();
    String typeName = tagToClassName(tag);
    if (typeName.isEmpty()) {
      typeName = UNTAGGED;
    }
    TypeSpec.Builder builder = interfaceBuilder(typeName).addModifiers(Modifier.PUBLIC);

    ParameterizedTypeName listType =
        ParameterizedTypeName.get(
            ClassName.get(List.class),
            ParameterizedTypeName.get(
                ClassName.get(Supplier.class), ClassName.bestGuess(MDI_ICON_TYPE)));

    CodeBlock.Builder staticInitializer = CodeBlock.builder();

    TypeSpec.Builder factoryBuilder =
        classBuilder(typeName + "_Factory")
            .addModifiers(Modifier.PUBLIC)
            .addSuperinterface(ClassName.bestGuess(MDI_ICON_FACTORY_TYPE))
            .addField(
                FieldSpec.builder(
                        listType, "icons", Modifier.PRIVATE, Modifier.STATIC, Modifier.FINAL)
                    .initializer("new $T()", TypeName.get(ArrayList.class))
                    .build())
            .addField(
                FieldSpec.builder(
                        ClassName.bestGuess(rootPackageName + "." + typeName),
                        "tagIcons",
                        Modifier.PRIVATE,
                        Modifier.STATIC,
                        Modifier.FINAL)
                    .initializer(
                        "new $T(){}", ClassName.bestGuess(rootPackageName + "." + typeName))
                    .build());

    icons.forEach(
        metaIconInfo -> {
          String methodName =
              unreservedKeywordName(metaIconInfo.getName().replace("-", "_") + methodPostFix(tag));
          MethodSpec.Builder iconMethod =
              MethodSpec.methodBuilder(methodName)
                  .addModifiers(Modifier.PUBLIC)
                  .addModifiers(Modifier.DEFAULT)
                  .returns(ClassName.bestGuess(MDI_ICON_TYPE))
                  .addStatement(
                      "return $T.create($S)",
                      ClassName.bestGuess(MDI_ICON_TYPE),
                      "mdi-" + metaIconInfo.getName());
          if (metaIconInfo.isDeprecated()) {
            iconMethod.addAnnotation(Deprecated.class);
          }
          builder.addMethod(iconMethod.build());
          staticInitializer.addStatement("icons.add(()-> tagIcons." + methodName + "())");
        });

    factoryBuilder
        .addStaticBlock(staticInitializer.build())
        .addMethod(
            MethodSpec.methodBuilder("icons")
                .addAnnotation(Override.class)
                .addModifiers(Modifier.PUBLIC)
                .returns(listType)
                .addStatement("return new $T<>(icons)", TypeName.get(ArrayList.class))
                .build());
    types.add(builder);
    types.add(factoryBuilder);
    return types;
  }

  private String methodPostFix(String tag) {
    if (tag.isEmpty()) {
      return "";
    } else {
      return "_" + tagToClassName(tag).toLowerCase();
    }
  }

  private String tagToClassName(String tag) {
    return tag.replace("/", "_").replace("+", "_").replace(" ", "");
  }

  private String getStringLiteral(List<String> stringList) {
    String literal = stringList.stream().map(s -> "\"" + s + "\"").collect(Collectors.joining(","));
    return (isNull(literal) || literal.isEmpty()) ? "" : literal;
  }

  private String unreservedKeywordName(String str) {
    if (RESERVED_KEYWORDS.contains(str)) {
      return str + "_";
    }
    return str;
  }
}
