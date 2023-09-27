/*
 * Copyright © 2023 Vertispan
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

import com.sun.source.doctree.*;
import com.sun.source.util.DocTreePath;
import com.sun.source.util.DocTrees;
import com.sun.source.util.SimpleDocTreeVisitor;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import javax.lang.model.element.Element;
import javax.lang.model.element.ElementKind;
import jdk.javadoc.doclet.DocletEnvironment;

public class DuiSiteDocsTreeVisitor extends SimpleDocTreeVisitor<String, Element> {

  private final DocletEnvironment docletEnv;
  private final String docsRootUrl;

  public DuiSiteDocsTreeVisitor(DocletEnvironment docletEnv, String docsRootUrl) {
    this.docletEnv = docletEnv;
    this.docsRootUrl = docsRootUrl;
  }

  @Override
  protected String defaultAction(DocTree node, Element element) {
    return node.toString();
  }

  @Override
  public String visitReference(ReferenceTree node, Element element) {
    return getElementFromReference(node, element)
        .map(
            referencedElement -> {
              if (ElementKind.METHOD == referencedElement.getKind()) {
                return "";
              } else {
                String pkgPath =
                    docletEnv
                        .getElementUtils()
                        .getPackageOf(referencedElement)
                        .getQualifiedName()
                        .toString()
                        .replace(".", "/");

                return docsRootUrl
                    + pkgPath
                    + "/"
                    + referencedElement.getSimpleName().toString()
                    + ".html";
              }
            })
        .orElse(node.getSignature());
  }

  @Override
  public String visitLink(LinkTree node, Element element) {
    return "<a class=\"dui\" tabindex=\"0\" aria-expanded=\"true\" target=\"_blank\" href=\""
        + visit(node.getReference(), element)
        + "\">"
        + getRefLabel(node, element)
        + "</a>";
  }

  private String getRefLabel(LinkTree node, Element element) {
    if (node.getLabel().isEmpty()) {
      return getElementFromReference(node.getReference(), element)
          .map(e -> e.getSimpleName().toString())
          .orElse(node.getReference() + "");
    }
    return node.getLabel().get(0).toString();
  }

  private Optional<Element> getElementFromReference(DocTree node, Element element) {
    DocTrees trees = docletEnv.getDocTrees();
    final Element referencedElement =
        trees.getElement(
            new DocTreePath(
                new DocTreePath(trees.getPath(element), trees.getDocCommentTree(element)), node));
    return Optional.ofNullable(referencedElement);
  }

  @Override
  public String visitDocComment(DocCommentTree node, Element element) {
    StringBuffer result = new StringBuffer();
    String body =
        node.getFullBody().stream()
            .map(docTree -> visit(docTree, element))
            .collect(Collectors.joining());
    result.append(body);
    result.append("\n");

    String tags =
        node.getBlockTags().stream()
            .filter(docTree -> !(docTree.getKind() == DocTree.Kind.SEE))
            .map(tag -> tag.accept(this, element))
            .collect(Collectors.joining("\n"));

    result.append(tags);
    result.append("\n");

    List<? extends DocTree> seeTags =
        node.getBlockTags().stream()
            .filter(docTree -> (docTree.getKind() == DocTree.Kind.SEE))
            .collect(Collectors.toList());

    if (!seeTags.isEmpty()) {
      result.append("<p>See also : </p>");
      result.append("\n");
      result.append("<ul>");
      result.append("\n");
    }

    result.append(
        seeTags.stream().map(tag -> tag.accept(this, element)).collect(Collectors.joining("\n")));

    if (!seeTags.isEmpty()) {
      result.append("\n");
      result.append("</ul>");
      result.append("\n");
    }
    return result.toString();
  }

  @Override
  public String visitSee(SeeTree node, Element element) {

    return node.getReference().stream()
        .map(
            docTree ->
                getElementFromReference(docTree, element)
                    .map(
                        refElement ->
                            "<li><a class=\"dui\" tabindex=\"0\" aria-expanded=\"true\" target=\"_blank\" href=\""
                                + visit(docTree, element)
                                + "\">"
                                + refElement.getSimpleName().toString()
                                + "</a></li>")
                    .orElse(docTree.accept(this, element)))
        .collect(Collectors.joining("\n"));
  }

  @Override
  public String visitParam(ParamTree node, Element element) {
    return "<div class=\"dui dui-site-member-param\"><p><b>"
        + node.getName()
        + "</b><p>"
        + node.getDescription().stream()
            .map(docTree -> docTree.accept(this, element))
            .collect(Collectors.joining())
        + "</p></div>";
  }

  @Override
  public String visitReturn(ReturnTree node, Element element) {
    return "";
  }

  @Override
  public String visitInheritDoc(InheritDocTree node, Element element) {
    return "Check super implementation documentation.";
  }

  @Override
  public String visitText(TextTree node, Element element) {
    return " " + node.getBody();
  }

  @Override
  public String visitLiteral(LiteralTree node, Element element) {
    if (DocTree.Kind.CODE == node.getKind()) {
      return "<code>" + node.getBody() + "</code>";
    }
    return super.visitLiteral(node, element);
  }
}
