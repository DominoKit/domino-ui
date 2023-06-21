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

/**
 * TreeHeader class.
 *
 * @author vegegoku
 * @version $Id: $Id
 */
public class TreeHeader extends BaseDominoElement<HTMLDivElement, TreeHeader>
    implements TreeStyles {

  private final DivElement element;
  private final DivElement content;
  private LazyChild<Icon<?>> headerIcon;
  private final LazyChild<SpanElement> textElement;

  /**
   * create.
   *
   * @return a {@link org.dominokit.domino.ui.tree.TreeHeader} object
   */
  public static TreeHeader create() {
    return new TreeHeader();
  }

  /**
   * create.
   *
   * @param icon a {@link org.dominokit.domino.ui.icons.Icon} object
   * @return a {@link org.dominokit.domino.ui.tree.TreeHeader} object
   */
  public static TreeHeader create(Icon<?> icon) {
    return new TreeHeader(icon);
  }

  /**
   * create.
   *
   * @param title a {@link java.lang.String} object
   * @return a {@link org.dominokit.domino.ui.tree.TreeHeader} object
   */
  public static TreeHeader create(String title) {
    return new TreeHeader(title);
  }

  /**
   * create.
   *
   * @param icon a {@link org.dominokit.domino.ui.icons.Icon} object
   * @param title a {@link java.lang.String} object
   * @return a {@link org.dominokit.domino.ui.tree.TreeHeader} object
   */
  public static TreeHeader create(Icon<?> icon, String title) {
    return new TreeHeader(icon, title);
  }

  /** Constructor for TreeHeader. */
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

  /**
   * Constructor for TreeHeader.
   *
   * @param icon a {@link org.dominokit.domino.ui.icons.Icon} object
   */
  public TreeHeader(Icon<?> icon) {
    this();
    setIcon(icon);
  }

  /**
   * Constructor for TreeHeader.
   *
   * @param title a {@link java.lang.String} object
   */
  public TreeHeader(String title) {
    this();
    setTitle(title);
  }

  /**
   * Constructor for TreeHeader.
   *
   * @param icon a {@link org.dominokit.domino.ui.icons.Icon} object
   * @param title a {@link java.lang.String} object
   */
  public TreeHeader(Icon<?> icon, String title) {
    this();
    setIcon(icon);
    setTitle(title);
  }

  /**
   * setTitle.
   *
   * @param title a {@link java.lang.String} object
   * @return a {@link org.dominokit.domino.ui.tree.TreeHeader} object
   */
  public TreeHeader setTitle(String title) {
    textElement.get().setTextContent(title);
    return this;
  }

  /**
   * setIcon.
   *
   * @param icon a {@link org.dominokit.domino.ui.icons.Icon} object
   * @return a {@link org.dominokit.domino.ui.tree.TreeHeader} object
   */
  public TreeHeader setIcon(Icon<?> icon) {
    if (nonNull(headerIcon) && headerIcon.isInitialized()) {
      headerIcon.remove();
    }

    headerIcon = LazyChild.of(icon.addCss(dui_tree_header_item, dui_tree_item_icon), content);
    headerIcon.get();
    return this;
  }

  /**
   * appendChild.
   *
   * @param postfixAddOn a {@link org.dominokit.domino.ui.utils.PostfixAddOn} object
   * @return a {@link org.dominokit.domino.ui.tree.TreeHeader} object
   */
  public TreeHeader appendChild(PostfixAddOn<?> postfixAddOn) {
    if (nonNull(postfixAddOn)) {
      postfixAddOn.addCss(dui_tree_header_item);
      content.appendChild(postfixAddOn);
    }
    return this;
  }

  /**
   * withContent.
   *
   * @param handler a {@link org.dominokit.domino.ui.utils.ChildHandler} object
   * @return a {@link org.dominokit.domino.ui.tree.TreeHeader} object
   */
  public TreeHeader withContent(ChildHandler<TreeHeader, DivElement> handler) {
    handler.apply(this, content);
    return this;
  }

  /**
   * Getter for the field <code>content</code>.
   *
   * @return a {@link org.dominokit.domino.ui.elements.DivElement} object
   */
  public DivElement getContent() {
    return content;
  }

  /**
   * withTitle.
   *
   * @param handler a {@link org.dominokit.domino.ui.utils.ChildHandler} object
   * @return a {@link org.dominokit.domino.ui.tree.TreeHeader} object
   */
  public TreeHeader withTitle(ChildHandler<TreeHeader, SpanElement> handler) {
    handler.apply(this, textElement.get());
    return this;
  }

  /**
   * withTitle.
   *
   * @return a {@link org.dominokit.domino.ui.tree.TreeHeader} object
   */
  public TreeHeader withTitle() {
    textElement.get();
    return this;
  }

  /**
   * getTitle.
   *
   * @return a {@link org.dominokit.domino.ui.elements.SpanElement} object
   */
  public SpanElement getTitle() {
    return textElement.get();
  }

  /** {@inheritDoc} */
  @Override
  protected HTMLElement getAppendTarget() {
    return content.element();
  }

  /** {@inheritDoc} */
  @Override
  public HTMLDivElement element() {
    return element.element();
  }
}
