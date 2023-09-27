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
package org.dominokit.domino.ui.internal.docs;

import static java.util.Objects.nonNull;

import com.sun.source.doctree.DocCommentTree;
import com.sun.source.util.TreePath;
import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;
import java.util.stream.Collectors;
import javax.lang.model.SourceVersion;
import javax.lang.model.element.*;
import javax.lang.model.type.DeclaredType;
import javax.lang.model.type.TypeKind;
import javax.lang.model.type.TypeMirror;
import javax.lang.model.type.WildcardType;
import javax.tools.Diagnostic;
import jdk.javadoc.doclet.Doclet;
import jdk.javadoc.doclet.DocletEnvironment;
import jdk.javadoc.doclet.Reporter;

public class DominoUiDoclet implements Doclet {
  private Locale locale;
  private Reporter reporter;
  private DocletEnvironment env;

  public static final String DUI_DOCS_ROOT_URL = "-duidocsurl";
  public static final String DUI_DOCS_OUT_DIRE = "-duidocsdir";

  private String docsUrl;
  private String outputDir;

  @Override
  public void init(Locale locale, Reporter reporter) {
    this.locale = locale;
    this.reporter = reporter;
  }

  @Override
  public String getName() {
    return "domino-ui-site-docs";
  }

  @Override
  public SourceVersion getSupportedSourceVersion() {
    return SourceVersion.RELEASE_11;
  }

  @Override
  public Set<? extends Option> getSupportedOptions() {
    Option[] options = {
      new Option() {

        @Override
        public int getArgumentCount() {
          return 1;
        }

        @Override
        public String getDescription() {
          return "Docs root URL";
        }

        @Override
        public Kind getKind() {
          return Kind.STANDARD;
        }

        @Override
        public List<String> getNames() {
          return List.of(DUI_DOCS_ROOT_URL);
        }

        @Override
        public String getParameters() {
          return "url";
        }

        @Override
        public boolean process(String opt, List<String> arguments) {
          if (arguments.isEmpty()) {
            reporter.print(
                Diagnostic.Kind.ERROR,
                "You must specify the domino-ui root-docs url " + DUI_DOCS_ROOT_URL);
            return false;
          }
          docsUrl = arguments.get(0);
          return true;
        }
      },
      new Option() {

        @Override
        public int getArgumentCount() {
          return 1;
        }

        @Override
        public String getDescription() {
          return "Docs output dire";
        }

        @Override
        public Kind getKind() {
          return Kind.STANDARD;
        }

        @Override
        public List<String> getNames() {
          return List.of(DUI_DOCS_OUT_DIRE);
        }

        @Override
        public String getParameters() {
          return "dir";
        }

        @Override
        public boolean process(String opt, List<String> arguments) {
          if (arguments.isEmpty()) {
            reporter.print(
                Diagnostic.Kind.ERROR,
                "You must specify the domino-ui docs out dire " + DUI_DOCS_OUT_DIRE);
            return false;
          }
          outputDir = arguments.get(0);
          return true;
        }
      }
    };
    return new HashSet<>(Arrays.asList(options));
  }

  @Override
  public boolean run(DocletEnvironment environment) {
    this.env = environment;
    reporter.print(Diagnostic.Kind.NOTE, "Running doclet.");
    try {

      Set<Element> documentedTypes =
          environment.getIncludedElements().stream()
              .filter(
                  element ->
                      ElementKind.CLASS == element.getKind()
                          || ElementKind.INTERFACE == element.getKind())
              .collect(Collectors.toSet());

      documentedTypes.stream()
          .forEach(
              rootElement -> {
                try {
                  String elementDocs = getDocs(rootElement);
                  PackageElement pkg = env.getElementUtils().getPackageOf(rootElement);

                  String constructors =
                      rootElement.getEnclosedElements().stream()
                          .filter(element -> ElementKind.CONSTRUCTOR == element.getKind())
                          .filter(element -> element.getModifiers().contains(Modifier.PUBLIC))
                          .map(this::asMemberSummary)
                          .map(Object::toString)
                          .collect(Collectors.joining("\n"));

                  String staticMethods =
                      rootElement.getEnclosedElements().stream()
                          .filter(element -> ElementKind.METHOD == element.getKind())
                          .filter(
                              element ->
                                  element.getModifiers().contains(Modifier.PUBLIC)
                                      && element.getModifiers().contains(Modifier.STATIC))
                          .map(this::asMemberSummary)
                          .map(Object::toString)
                          .collect(Collectors.joining("\n"));

                  String noneStaticMethods =
                      rootElement.getEnclosedElements().stream()
                          .filter(element -> ElementKind.METHOD == element.getKind())
                          .filter(
                              element ->
                                  element.getModifiers().contains(Modifier.PUBLIC)
                                      && !element.getModifiers().contains(Modifier.STATIC))
                          .map(this::asMemberSummary)
                          .map(Object::toString)
                          .collect(Collectors.joining("\n"));

                  StringBuffer members = new StringBuffer();
                  members.append("<div class=\"dui dui-members-summary\">");

                  if (!constructors.isEmpty()) {
                    members.append("<h4>Constructors</h4>");
                    members.append("<div class=\"dui dui-site-component-members\">");
                    members.append(constructors);
                    members.append("</div>\n");
                  }

                  if (!staticMethods.isEmpty()) {
                    members.append("<h4>Static methods</h4>");
                    members.append("<div class=\"dui dui-site-component-members\">");
                    members.append(staticMethods);
                    members.append("</div>\n");
                  }

                  if (!noneStaticMethods.isEmpty()) {
                    members.append("<h4>Public methods</h4>");
                    members.append("<div class=\"dui dui-site-component-members\">");
                    members.append(noneStaticMethods);
                    members.append("</div>\n");
                    members.append("</div>\n");
                  }

                  writeFile(rootElement, "-dui-site-class-docs.html", pkg, elementDocs);
                  writeFile(rootElement, "-dui-site-members-docs.html", pkg, members.toString());
                } catch (Exception exception) {
                  reporter.print(Diagnostic.Kind.ERROR, rootElement, formatException(exception));
                  throw new RuntimeException(exception);
                }
              });

    } catch (Exception e) {
      reporter.print(Diagnostic.Kind.ERROR, formatException(e));
      throw new RuntimeException(e);
    }

    return true;
  }

  private MemberSummary asMemberSummary(Element element) {
    String modifiers =
        element.getModifiers().stream().map(Modifier::toString).collect(Collectors.joining(" "));

    String type = getTypeName(((ExecutableElement) element).getReturnType());
    String parameters =
        ((ExecutableElement) element)
            .getParameters().stream()
                .map(
                    variableElement ->
                        getTypeName(variableElement.asType())
                            + " "
                            + variableElement.getSimpleName().toString())
                .collect(Collectors.joining(", "));
    String docs = getDocs(element);

    String name =
        ElementKind.CONSTRUCTOR == element.getKind()
            ? element.getEnclosingElement().getSimpleName().toString()
            : element.getSimpleName().toString();
    return new MemberSummary(modifiers, type, name + "(" + parameters + ")", docs);
  }

  private String getTypeName(TypeMirror typeMirror) {
    if (TypeKind.WILDCARD.equals(typeMirror.getKind())) {
      WildcardType dt = (WildcardType) typeMirror;

      TypeMirror superBound = dt.getSuperBound();
      TypeMirror extendsBound = dt.getExtendsBound();
      if (nonNull(superBound)) {
        return dt.toString().substring(0, dt.toString().indexOf("super") + 6)
            + getTypeName(superBound);
      }
      if (nonNull(extendsBound)) {
        return dt.toString().substring(0, dt.toString().indexOf("extends") + 8)
            + getTypeName(extendsBound);
      }
      return dt.toString();
    }
    Element typeElement = env.getTypeUtils().asElement(typeMirror);
    String name =
        nonNull(typeElement) ? typeElement.getSimpleName().toString() : typeMirror.toString();

    ElementType et = ElementType.of(typeMirror, env);
    String pkg = "";
    if (et.isPrimitiveArray() || et.isArray() || et.is2dArray()) {
      TypeMirror ct = et.deepArrayComponentType();
      Element te = env.getTypeUtils().asElement(ct);
      if (nonNull(te)) {
        pkg = env.getElementUtils().getPackageOf(te).getQualifiedName().toString();
      }

    } else {
      if (nonNull(typeElement)) {
        pkg = env.getElementUtils().getPackageOf(typeElement).getQualifiedName().toString();
      }
    }
    String typeArgs = "";
    if (nonNull(typeElement)) {
      if (typeMirror.getKind() == TypeKind.DECLARED) {
        DeclaredType dt = (DeclaredType) typeMirror;
        typeArgs =
            dt.getTypeArguments().stream()
                .map(this::getTypeName)
                .collect(Collectors.joining(", ", "&lt;", "&gt;"));
      }
    }

    return name.replace(pkg + ".", "") + ("&lt;&gt;".equals(typeArgs) ? "" : typeArgs);
  }

  private void writeFile(Element e, String filePostfix, PackageElement pkg, String elementDocs)
      throws FileNotFoundException {
    File outFile =
        Paths.get(
                outputDir,
                pkg.getQualifiedName().toString().replace(".", "/"),
                e.getSimpleName().toString() + filePostfix)
            .toFile();
    try {
      Files.createDirectories(outFile.getParentFile().toPath());
    } catch (IOException ex) {
      reporter.print(Diagnostic.Kind.ERROR, formatException(ex));
      throw new RuntimeException(ex);
    }
    try (PrintWriter writer = new PrintWriter(outFile)) {
      writer.print(elementDocs);
    }
  }

  public String getDocs(Element element) {

    TreePath path = env.getDocTrees().getPath(element);
    if (nonNull(path)) {
      DocCommentTree tree = env.getDocTrees().getDocCommentTree(path);
      if (nonNull(tree)) {
        Optional<DocCommentTree> docCommentTree =
            Optional.ofNullable(path).map(treePath -> env.getDocTrees().getDocCommentTree(path));
        return docCommentTree
            .map(doctree -> doctree.accept(new DuiSiteDocsTreeVisitor(this.env, docsUrl), element))
            .orElse("");
      }
    }
    return "";
  }

  public String formatException(Exception e) {
    StringWriter out = new StringWriter();
    e.printStackTrace(new PrintWriter(out));
    return out.getBuffer().toString();
  }

  private static class MemberSummary {
    private final String modifiers;
    private final String type;
    private final String signature;
    private final String docs;

    public MemberSummary(String modifiers, String type, String signature, String docs) {
      this.modifiers = modifiers;
      this.type = type;
      this.signature = signature;
      this.docs = docs;
    }

    @Override
    public String toString() {
      StringBuffer sb = new StringBuffer();
      sb.append("<div class=\"dui dui-component-member\">");
      sb.append("<div class=\"dui dui-component-member-signature\">\n<code>");
      sb.append(modifiers);
      sb.append(" ");
      sb.append(type);
      sb.append(" ");
      sb.append(signature);
      sb.append("</code></div>\n");

      sb.append("<div class=\"dui dui-summary-docs\">");
      sb.append(docs);
      sb.append("</div>\n");
      sb.append("</div>\n");

      return sb.toString();
    }
  }
}
