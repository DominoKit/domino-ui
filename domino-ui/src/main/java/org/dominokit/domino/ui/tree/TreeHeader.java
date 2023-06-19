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
package org.dominokit.domino.ui.tree;

import static java.util.Objects.nonNull;

import elemental2.dom.HTMLDivElement;
import elemental2.dom.HTMLElement;
import org.dominokit.domino.ui.elements.DivElement;
import org.dominokit.domino.ui.elements.SpanElement;
import org.dominokit.domino.ui.icons.Icon;
import org.dominokit.domino.ui.utils.BaseDominoElement;
import org.dominokit.domino.ui.utils.ChildHandler;
import org.dominokit.domino.ui.utils.LazyChild;
import org.dominokit.domino.ui.utils.PostfixAddOn;

public class TreeHeader extends BaseDominoElement<HTMLDivElement, TreeHeader>
    implements TreeStyles {

  private final DivElement element;
  private final DivElement content;
  private LazyChild<Icon<?>> headerIcon;
  private final LazyChild<SpanElement> textElement;

  public static TreeHeader create() {
    return new TreeHeader();
  }

  public static TreeHeader create(Icon<?> icon) {
    return new TreeHeader(icon);
  }

  public static TreeHeader create(String title) {
    return new TreeHeader(title);
  }

  public static TreeHeader create(Icon<?> icon, String title) {
    return new TreeHeader(icon, title);
  }

  public TreeHeader() {
    element =
        div()
            .addCss(dui_tree_header)
            .appendChild(
                content =
                    div()
                        .addCss(dui_tree_item_content)
                        .appendChild(div().addCss(dui_tree_item_filler)));
    textElement = LazyChild.of(span().addCss(dui_tree_header_item, dui_tree_item_text), content);
    init(this);
  }

  public TreeHeader(Icon<?> icon) {
    this();
    setIcon(icon);
  }

  public TreeHeader(String title) {
    this();
    setTitle(title);
  }

  public TreeHeader(Icon<?> icon, String title) {
    this();
    setIcon(icon);
    setTitle(title);
  }

  public TreeHeader setTitle(String title) {
    textElement.get().setTextContent(title);
    return this;
  }

  public TreeHeader setIcon(Icon<?> icon) {
    if (nonNull(headerIcon) && headerIcon.isInitialized()) {
      headerIcon.remove();
    }

    headerIcon = LazyChild.of(icon.addCss(dui_tree_header_item, dui_tree_item_icon), content);
    headerIcon.get();
    return this;
  }

  public TreeHeader appendChild(PostfixAddOn<?> postfixAddOn) {
    if (nonNull(postfixAddOn)) {
      postfixAddOn.addCss(dui_tree_header_item);
      content.appendChild(postfixAddOn);
    }
    return this;
  }

  public TreeHeader withContent(ChildHandler<TreeHeader, DivElement> handler) {
    handler.apply(this, content);
    return this;
  }

  public DivElement getContent() {
    return content;
  }

  public TreeHeader withTitle(ChildHandler<TreeHeader, SpanElement> handler) {
    handler.apply(this, textElement.get());
    return this;
  }

  public TreeHeader withTitle() {
    textElement.get();
    return this;
  }

  public SpanElement getTitle() {
    return textElement.get();
  }

  @Override
  protected HTMLElement getAppendTarget() {
    return content.element();
  }

  @Override
  public HTMLDivElement element() {
    return element.element();
  }
}
