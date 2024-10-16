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
import static org.dominokit.domino.ui.utils.Domino.*;

import elemental2.dom.File;
import elemental2.dom.HTMLInputElement;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import org.dominokit.domino.ui.elements.DivElement;
import org.dominokit.domino.ui.elements.SpanElement;
import org.dominokit.domino.ui.icons.lib.Icons;
import org.dominokit.domino.ui.utils.*;

/**
 * The <b>UploadBox</b> class represents an input field for uploading files. It extends the
 * <b>InputFormField</b> class and provides the ability to select and display uploaded files.
 *
 * <p>Usage Example:
 *
 * <pre>
 * // Create an UploadBox with a label
 * UploadBox uploadBox = UploadBox.create("Choose Files:");
 *
 * // Set the accepted file types (e.g., images)
 * uploadBox.setAccepts("image/*");
 *
 * // Enable multiple file selection
 * uploadBox.setMultiple(true);
 *
 * // Add a change listener to handle file selection changes
 * uploadBox.addChangeHandler(event -> {
 *     List<File> selectedFiles = event.getTarget().getValue();
 *     // Handle the selected files
 * });
 * </pre>
 */
public class UploadBox extends InputFormField<UploadBox, HTMLInputElement, List<File>>
    implements HasPostfix<UploadBox>, HasPrefix<UploadBox> {

  protected final LazyChild<DivElement> prefixElement;
  protected final LazyChild<DivElement> postfixElement;
  private SpanElement fileNames;

  /**
   * Creates a new <b>UploadBox</b> instance with default settings.
   *
   * @return A new <b>UploadBox</b> instance.
   */
  public static UploadBox create() {
    return new UploadBox();
  }

  /**
   * Creates a new <b>UploadBox</b> instance with a specified label.
   *
   * @param label The label for the <b>UploadBox<b>.
   * @return A new <b>UploadBox</b> instance.
   */
  public static UploadBox create(String label) {
    return new UploadBox(label);
  }

  /** Constructs a new <b>UploadBox</b> instance with default settings. */
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

  /**
   * Constructs a new <b>UploadBox</b> instance with a specified label.
   *
   * @param label The label for the <b>UploadBox<b>.
   */
  public UploadBox(String label) {
    this();
    setLabel(label);
  }

  /**
   * Sets the postfix text for the <b>UploadBox<b>.
   *
   * @param postfix The text to be displayed as a postfix.
   * @return This <b>UploadBox</b> instance.
   */
  @Override
  public UploadBox setPostfix(String postfix) {
    postfixElement.get().setTextContent(postfix);
    return this;
  }

  /**
   * Gets the postfix text of the <b>UploadBox<b>.
   *
   * @return The postfix text of the <b>UploadBox<b>.
   */
  @Override
  public String getPostfix() {
    if (postfixElement.isInitialized()) {
      return postfixElement.get().getTextContent();
    }
    return "";
  }

  /**
   * Sets the prefix text for the <b>UploadBox<b>.
   *
   * @param prefix The text to be displayed as a prefix.
   * @return This <b>UploadBox</b> instance.
   */
  @Override
  public UploadBox setPrefix(String prefix) {
    prefixElement.get().setTextContent(prefix);
    return this;
  }

  /**
   * Gets the prefix text of the <b>UploadBox<b>.
   *
   * @return The prefix text of the <b>UploadBox<b>.
   */
  @Override
  public String getPrefix() {
    if (prefixElement.isInitialized()) {
      return prefixElement.get().getTextContent();
    }
    return "";
  }

  /**
   * Gets the prefix element of the <b>UploadBox<b>.
   *
   * @return The prefix element as a <b>DivElement<b>.
   */
  public PrefixElement getPrefixElement() {
    return PrefixElement.of(prefixElement.get().element());
  }

  public PostfixElement getPostfixElement() {
    return PostfixElement.of(postfixElement.get().element());
  }

  /**
   * Initializes and retrieves the prefix element of the <b>UploadBox<b>.
   *
   * @return This <b>UploadBox</b> instance.
   */
  public UploadBox withPrefixElement() {
    prefixElement.get();
    return this;
  }

  /**
   * Initializes and retrieves the postfix element of the <b>UploadBox<b>.
   *
   * @return This <b>UploadBox</b> instance.
   */
  public UploadBox withPostfixElement() {
    postfixElement.get();
    return this;
  }

  /**
   * Gets the name attribute of the <b>UploadBox<b>.
   *
   * @return The name attribute.
   */
  @Override
  public String getName() {
    return getInputElement().element().name;
  }

  /**
   * Sets the name attribute of the <b>UploadBox<b>.
   *
   * @param name The name attribute to set.
   * @return This <b>UploadBox</b> instance.
   */
  @Override
  public UploadBox setName(String name) {
    getInputElement().element().name = name;
    return this;
  }

  /**
   * Gets the string representation of the selected files' names, separated by commas.
   *
   * @return The selected files' names as a string.
   */
  @Override
  public String getStringValue() {
    return getValue().stream().map(file -> file.name).collect(Collectors.joining(","));
  }

  /**
   * Creates and retrieves the input element for the <b>UploadBox<b>.
   *
   * @param type The input type (e.g., "file").
   * @return A <b>DominoElement</b> representing the input element.
   */
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

  /**
   * Sets the value of the <b>UploadBox</b> (not implemented).
   *
   * @param value The value to set.
   */
  @Override
  protected void doSetValue(List<File> value) {}

  /**
   * Gets the type of the input element, which is always "file" for the <b>UploadBox<b>.
   *
   * @return The input element type.
   */
  @Override
  public String getType() {
    return "file";
  }

  /**
   * Gets the list of selected files in the <b>UploadBox<b>.
   *
   * @return A list of selected <b>File</b> objects.
   */
  @Override
  public List<File> getValue() {
    if (nonNull(getInputElement().element().files)) {
      return getInputElement().element().files.asList();
    }
    return new ArrayList<>();
  }

  /**
   * Sets the accepted file types for the <b>UploadBox<b>.
   *
   * @param accepts The file types to accept (e.g., "image/*").
   * @return This <b>UploadBox</b> instance.
   */
  public UploadBox setAccepts(String... accepts) {
    getInputElement().element().accept = String.join(",", accepts);
    return this;
  }

  /**
   * Gets the accepted file types for the <b>UploadBox<b>.
   *
   * @return The accepted file types.
   */
  public String getAccepts() {
    return getInputElement().element().accept;
  }

  /**
   * Enables or disables multiple file selection for the <b>UploadBox<b>.
   *
   * @param multiple {@code true} to enable multiple file selection, {@code false} to disable it.
   * @return This <b>UploadBox</b> instance.
   */
  public UploadBox setMultiple(boolean multiple) {
    this.getInputElement().element().multiple = multiple;
    return this;
  }

  /**
   * Checks if multiple file selection is enabled for the <b>UploadBox<b>.
   *
   * @return {@code true} if multiple file selection is enabled, {@code false} otherwise.
   */
  public boolean getMultiple() {
    return this.getInputElement().element().multiple;
  }
}
