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
package org.dominokit.domino.ui.upload;

import static java.util.Objects.nonNull;

import elemental2.dom.HTMLDivElement;
import org.dominokit.domino.ui.elements.DivElement;
import org.dominokit.domino.ui.elements.HeadingElement;
import org.dominokit.domino.ui.elements.SmallElement;
import org.dominokit.domino.ui.icons.Icon;
import org.dominokit.domino.ui.utils.BaseDominoElement;
import org.dominokit.domino.ui.utils.LazyChild;

public class DefaultFileUploadDecoration
    extends BaseDominoElement<HTMLDivElement, DefaultFileUploadDecoration>
    implements FileUploadStyles {

  private final DivElement root;
  private LazyChild<Icon<?>> iconElement;
  private LazyChild<HeadingElement> titleElement;
  private LazyChild<SmallElement> descriptionElement;

  public static DefaultFileUploadDecoration create() {
    return new DefaultFileUploadDecoration();
  }

  public DefaultFileUploadDecoration() {
    root = div().addCss(dui_flex, dui_flex_col, dui_text_center, dui_items_center);
    init(this);
  }

  public DefaultFileUploadDecoration(Icon<?> icon) {
    this();
    setIcon(icon);
  }

  public DefaultFileUploadDecoration(Icon<?> icon, String title) {
    this();
    setIcon(icon);
    setTitle(title);
  }

  public DefaultFileUploadDecoration(Icon<?> icon, String title, String description) {
    this();
    setIcon(icon);
    setTitle(title);
    setDescription(description);
  }

  public DefaultFileUploadDecoration setIcon(Icon<?> icon) {
    if (nonNull(iconElement) && iconElement.isInitialized()) {
      iconElement.remove();
    }
    if (nonNull(icon)) {
      iconElement = LazyChild.of(icon.addCss(dui_order_10), root);
      iconElement.get();
    }

    return this;
  }

  public DefaultFileUploadDecoration setTitle(String title) {
    if (nonNull(titleElement) && titleElement.isInitialized()) {
      titleElement.remove();
    }
    if (nonNull(title) && !title.isEmpty()) {
      titleElement = LazyChild.of(h(3).textContent(title).addCss(dui_order_20), root);
      titleElement.get();
    }

    return this;
  }

  public DefaultFileUploadDecoration setDescription(String description) {
    if (nonNull(descriptionElement) && descriptionElement.isInitialized()) {
      descriptionElement.remove();
    }
    if (nonNull(description) && !description.isEmpty()) {
      descriptionElement =
          LazyChild.of(small().textContent(description).addCss(dui_order_30), root);
      descriptionElement.get();
    }

    return this;
  }

  @Override
  public HTMLDivElement element() {
    return root.element();
  }
}
