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
package org.dominokit.domino.ui.i18n;

/**
 * The {@code RichTextLabels} interface provides labels and messages related to rich text editing
 * functionality.
 */
public interface RichTextLabels extends Labels {

  /**
   * Gets the label for the "Background color" option in rich text editing.
   *
   * @return A {@code String} representing the label for the "Background color" option.
   */
  default String backgroundColor() {
    return "Background color";
  }

  /**
   * Gets the label for the "Bold" option in rich text editing.
   *
   * @return A {@code String} representing the label for the "Bold" option.
   */
  default String bold() {
    return "Bold";
  }

  /**
   * Gets the label for the "Copy" option in rich text editing.
   *
   * @return A {@code String} representing the label for the "Copy" option.
   */
  default String copy() {
    return "Copy";
  }

  /**
   * Gets the label for the "Cut" option in rich text editing.
   *
   * @return A {@code String} representing the label for the "Cut" option.
   */
  default String cut() {
    return "Cut";
  }

  /**
   * Gets the label for the "Decrease font size" option in rich text editing.
   *
   * @return A {@code String} representing the label for the "Decrease font size" option.
   */
  default String decreaseFontSize() {
    return "Decrease font size";
  }

  /**
   * Gets the label for the "Font family" option in rich text editing.
   *
   * @return A {@code String} representing the label for the "Font family" option.
   */
  default String fontFamily() {
    return "Font family";
  }

  /**
   * Gets the label for the "Fore color" option in rich text editing.
   *
   * @return A {@code String} representing the label for the "Fore color" option.
   */
  default String foreColor() {
    return "Fore color";
  }

  /**
   * Gets the label for the "Heading" option in rich text editing.
   *
   * @return A {@code String} representing the label for the "Heading" option.
   */
  default String heading() {
    return "Heading";
  }

  /**
   * Gets the label for the "Heading 1" option in rich text editing.
   *
   * @return A {@code String} representing the label for the "Heading 1" option.
   */
  default String heading1() {
    return "Heading 1";
  }

  /**
   * Gets the label for the "Heading 2" option in rich text editing.
   *
   * @return A {@code String} representing the label for the "Heading 2" option.
   */
  default String heading2() {
    return "Heading 2";
  }

  /**
   * Gets the label for the "Heading 3" option in rich text editing.
   *
   * @return A {@code String} representing the label for the "Heading 3" option.
   */
  default String heading3() {
    return "Heading 3";
  }

  /**
   * Gets the label for the "Heading 4" option in rich text editing.
   *
   * @return A {@code String} representing the label for the "Heading 4" option.
   */
  default String heading4() {
    return "Heading 4";
  }

  /**
   * Gets the label for the "Heading 5" option in rich text editing.
   *
   * @return A {@code String} representing the label for the "Heading 5" option.
   */
  default String heading5() {
    return "Heading 5";
  }

  /**
   * Gets the label for the "Heading 6" option in rich text editing.
   *
   * @return A {@code String} representing the label for the "Heading 6" option.
   */
  default String heading6() {
    return "Heading 6";
  }

  /**
   * Gets the label for the "Highlight color" option in rich text editing.
   *
   * @return A {@code String} representing the label for the "Highlight color" option.
   */
  default String highlightColor() {
    return "Highlight color";
  }

  /**
   * Gets the label for the "Insert horizontal rule" option in rich text editing.
   *
   * @return A {@code String} representing the label for the "Insert horizontal rule" option.
   */
  default String insertHorizontalRule() {
    return "Insert horizontal rule";
  }

  /**
   * Gets the label for the "Increase font size" option in rich text editing.
   *
   * @return A {@code String} representing the label for the "Increase font size" option.
   */
  default String increaseFontSize() {
    return "Increase font size";
  }

  /**
   * Gets the label for the "Increase indent" option in rich text editing.
   *
   * @return A {@code String} representing the label for the "Increase indent" option.
   */
  default String increaseIndent() {
    return "Increase indent";
  }

  /**
   * Gets the label for the "Insert" option in rich text editing.
   *
   * @return A {@code String} representing the label for the "Insert" option.
   */
  default String insert() {
    return "Insert";
  }

  /**
   * Gets the label for the "Insert HTML" option in rich text editing.
   *
   * @return A {@code String} representing the label for the "Insert HTML" option.
   */
  default String insertHtml() {
    return "Insert HTML";
  }

  /**
   * Gets the label for the "Choose an image" option in rich text editing.
   *
   * @return A {@code String} representing the label for the "Choose an image" option.
   */
  default String chooseImage() {
    return "Choose an image";
  }

  /**
   * Gets the label for the "Insert image" option in rich text editing.
   *
   * @return A {@code String} representing the label for the "Insert image" option.
   */
  default String insertImage() {
    return "Insert image";
  }

  /**
   * Gets the label for the "Image link" option in rich text editing.
   *
   * @return A {@code String} representing the label for the "Image link" option.
   */
  default String imageLink() {
    return "Image link";
  }

  /**
   * Gets the label for the "Link image" option in rich text editing.
   *
   * @return A {@code String} representing the label for the "Link image" option.
   */
  default String linkImage() {
    return "Link image";
  }

  /**
   * Gets the label for the "URL" option in rich text editing.
   *
   * @return A {@code String} representing the label for the "URL" option.
   */
  default String url() {
    return "URL";
  }

  /**
   * Gets the label for the "Insert link" option in rich text editing.
   *
   * @return A {@code String} representing the label for the "Insert link" option.
   */
  default String insertLink() {
    return "Insert link";
  }

  /**
   * Gets the label for the "Insert ordered list" option in rich text editing.
   *
   * @return A {@code String} representing the label for the "Insert ordered list" option.
   */
  default String insertOrderedList() {
    return "Insert ordered list";
  }

  /**
   * Gets the label for the "Insert paragraph" option in rich text editing.
   *
   * @return A {@code String} representing the label for the "Insert paragraph" option.
   */
  default String insertParagraph() {
    return "Insert paragraph";
  }

  /**
   * Gets the label for the "Insert unordered list" option in rich text editing.
   *
   * @return A {@code String} representing the label for the "Insert unordered list" option.
   */
  default String insertUnorderedList() {
    return "Insert unordered list";
  }

  /**
   * Gets the label for the "Italic" option in rich text editing.
   *
   * @return A {@code String} representing the label for the "Italic" option.
   */
  default String italic() {
    return "Italic";
  }

  /**
   * Gets the label for the "Justify center" option in rich text editing.
   *
   * @return A {@code String} representing the label for the "Justify center" option.
   */
  default String justifyCenter() {
    return "Justify center";
  }

  /**
   * Gets the label for the "Justify" option in rich text editing.
   *
   * @return A {@code String} representing the label for the "Justify" option.
   */
  default String justify() {
    return "Justify";
  }

  /**
   * Gets the label for the "Justify left" option in rich text editing.
   *
   * @return A {@code String} representing the label for the "Justify left" option.
   */
  default String justifyLeft() {
    return "Justify left";
  }

  /**
   * Gets the label for the "Justify right" option in rich text editing.
   *
   * @return A {@code String} representing the label for the "Justify right" option.
   */
  default String justifyRight() {
    return "Justify right";
  }

  /**
   * Gets the label for the "Reduce indent" option in rich text editing.
   *
   * @return A {@code String} representing the label for the "Reduce indent" option.
   */
  default String reduceIndent() {
    return "Reduce indent";
  }

  /**
   * Gets the label for the "Paste" option in rich text editing.
   *
   * @return A {@code String} representing the label for the "Paste" option.
   */
  default String paste() {
    return "Paste";
  }

  /**
   * Gets the label for the "Redo" option in rich text editing.
   *
   * @return A {@code String} representing the label for the "Redo" option.
   */
  default String redo() {
    return "Redo";
  }

  /**
   * Gets the label for the "Remove format" option in rich text editing.
   *
   * @return A {@code String} representing the label for the "Remove format" option.
   */
  default String removeFormat() {
    return "Remove format";
  }

  /**
   * Gets the label for the "Remove links" option in rich text editing.
   *
   * @return A {@code String} representing the label for the "Remove links" option.
   */
  default String removeLinks() {
    return "Remove links";
  }

  /**
   * Gets the label for the "Strike through" option in rich text editing.
   *
   * @return A {@code String} representing the label for the "Strike through" option.
   */
  default String strikeThrough() {
    return "Strike through";
  }

  /**
   * Gets the label for the "Subscript" option in rich text editing.
   *
   * @return A {@code String} representing the label for the "Subscript" option.
   */
  default String subscript() {
    return "Subscript";
  }

  /**
   * Gets the label for the "Superscript" option in rich text editing.
   *
   * @return A {@code String} representing the label for the "Superscript" option.
   */
  default String superscript() {
    return "Superscript";
  }

  /**
   * Gets the label for the "Underline" option in rich text editing.
   *
   * @return A {@code String} representing the label for the "Underline" option.
   */
  default String underline() {
    return "Underline";
  }

  /**
   * Gets the label for the "Undo" option in rich text editing.
   *
   * @return A {@code String} representing the label for the "Undo" option.
   */
  default String undo() {
    return "Undo";
  }
}
