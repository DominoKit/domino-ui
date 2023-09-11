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
package org.dominokit.domino.ui.forms;

import static java.util.Objects.nonNull;

import elemental2.dom.File;
import elemental2.dom.HTMLInputElement;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import org.dominokit.domino.ui.elements.DivElement;
import org.dominokit.domino.ui.elements.SpanElement;
import org.dominokit.domino.ui.icons.lib.Icons;
import org.dominokit.domino.ui.utils.*;

/** Abstract TextInputFormField class. */
public class UploadBox extends InputFormField<UploadBox, HTMLInputElement, List<File>>
    implements HasPostfix<UploadBox>, HasPrefix<UploadBox> {

  protected final LazyChild<DivElement> prefixElement;
  protected final LazyChild<DivElement> postfixElement;
  private SpanElement fileNames;

  public static UploadBox create() {
    return new UploadBox();
  }

  public static UploadBox create(String label) {
    return new UploadBox(label);
  }

  /** Constructor for TextInputFormField. */
  public UploadBox() {
    prefixElement = LazyChild.of(div().addCss(dui_field_prefix), wrapperElement);
    postfixElement = LazyChild.of(div().addCss(dui_field_postfix), wrapperElement);
    appendChild(PrimaryAddOn.of(Icons.upload().clickable()));
    withWrapper(
        (parent, wrapper) ->
            wrapper
                .addCss(dui_relative)
                .appendChild(fileNames = span().addCss(dui_grow_1, dui_order_30)));
  }

  public UploadBox(String label) {
    this();
    setLabel(label);
  }

  /** {@inheritDoc} */
  @Override
  public UploadBox setPostfix(String postfix) {
    postfixElement.get().setTextContent(postfix);
    return this;
  }

  /** {@inheritDoc} */
  @Override
  public String getPostfix() {
    if (postfixElement.isInitialized()) {
      return postfixElement.get().getTextContent();
    }
    return "";
  }

  /** {@inheritDoc} */
  @Override
  public UploadBox setPrefix(String prefix) {
    prefixElement.get().setTextContent(prefix);
    return this;
  }

  /** {@inheritDoc} */
  @Override
  public String getPrefix() {
    if (prefixElement.isInitialized()) {
      return prefixElement.get().getTextContent();
    }
    return "";
  }

  /**
   * Getter for the field <code>prefixElement</code>.
   *
   * @return a {@link DivElement} object
   */
  public DivElement getPrefixElement() {
    return prefixElement.get();
  }

  /**
   * Getter for the field <code>postfixElement</code>.
   *
   * @return a {@link DivElement} object
   */
  public DivElement getPostfixElement() {
    return postfixElement.get();
  }

  /**
   * withPrefixElement.
   *
   * @return a T object
   */
  public UploadBox withPrefixElement() {
    prefixElement.get();
    return this;
  }

  /**
   * withPrefixElement.
   *
   * @param handler a {@link ChildHandler} object
   * @return a T object
   */
  public UploadBox withPrefixElement(ChildHandler<UploadBox, DivElement> handler) {
    handler.apply(this, prefixElement.get());
    return this;
  }

  /**
   * withPostfixElement.
   *
   * @return a T object
   */
  public UploadBox withPostfixElement() {
    postfixElement.get();
    return this;
  }

  /**
   * withPostfixElement.
   *
   * @param handler a {@link ChildHandler} object
   * @return a T object
   */
  public UploadBox withPostfixElement(ChildHandler<UploadBox, DivElement> handler) {
    handler.apply(this, postfixElement.get());
    return this;
  }

  /** {@inheritDoc} */
  @Override
  public String getName() {
    return getInputElement().element().name;
  }

  /** {@inheritDoc} */
  @Override
  public UploadBox setName(String name) {
    getInputElement().element().name = name;
    return this;
  }

  @Override
  public String getStringValue() {
    return getValue().stream().map(file -> file.name).collect(Collectors.joining(","));
  }

  @Override
  protected DominoElement<HTMLInputElement> createInputElement(String type) {
    return input(type)
        .addCss(
            dui_field_input,
            dui_absolute,
            dui_opacity_0,
            dui_w_full,
            dui_h_full,
            dui_top_0,
            dui_left_0)
        .addEventListener("change", evt -> fileNames.setTextContent(getStringValue()))
        .toDominoElement();
  }

  @Override
  protected void doSetValue(List<File> value) {}

  @Override
  public String getType() {
    return "file";
  }

  @Override
  public List<File> getValue() {
    if (nonNull(getInputElement().element().files)) {
      return getInputElement().element().files.asList();
    }
    return new ArrayList<>();
  }

  public UploadBox setAccepts(String... accepts) {
    getInputElement().element().accept = String.join(",", accepts);
    return this;
  }

  public String getAccepts() {
    return getInputElement().element().accept;
  }

  public UploadBox setMultiple(boolean multiple) {
    this.getInputElement().element().multiple = multiple;
    return this;
  }

  public boolean getMultiple() {
    return this.getInputElement().element().multiple;
  }
}
