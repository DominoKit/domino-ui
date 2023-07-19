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
 * PickersLabels interface.
 *
 * @author vegegoku
 * @version $Id: $Id
 */
public interface RichTextLabels extends Labels {

  default String backgroundColor() {
    return "Background color";
  };

  default String bold() {
    return "Bold";
  }

  default String copy() {
    return "Copy";
  }

  default String cut() {
    return "Cut";
  }

  default String decreaseFontSize() {
    return "Decrease font size";
  }

  default String fontFamily() {
    return "Font family";
  }

  default String foreColor() {
    return "Fore color";
  }

  default String heading() {
    return "Heading";
  }

  default String heading1() {
    return "Heading 1";
  }

  default String heading2() {
    return "Heading 2";
  }

  default String heading3() {
    return "Heading 3";
  }

  default String heading4() {
    return "Heading 4";
  }

  default String heading5() {
    return "Heading 5";
  }

  default String heading6() {
    return "Heading 6";
  }

  default String highlightColor() {
    return "Highlight color";
  }

  default String insertHorizontalRule() {
    return "Insert horizontal rule";
  }

  default String increaseFontSize() {
    return "Increase font size";
  }

  default String increaseIndent() {
    return "Increase indent";
  }

  default String insert() {
    return "Insert";
  }

  default String insertHtml() {
    return "Insert HTML";
  }

  default String chooseImage() {
    return "Choose an image";
  }

  default String insertImage() {
    return "Insert image";
  }

  default String imageLink() {
    return "Image link";
  }

  default String linkImage() {
    return "Link image";
  }

  default String url() {
    return "URL";
  }

  default String insertLink() {
    return "Insert link";
  }

  default String insertOrderedList() {
    return "Insert ordered list";
  }

  default String insertParagraph() {
    return "Insert paragraph";
  }

  default String insertUnorderedList() {
    return "Insert unordered list";
  }

  default String italic() {
    return "Italic";
  }

  default String justifyCenter() {
    return "Justify center";
  }

  default String justify() {
    return "Justify";
  }

  default String justifyLeft() {
    return "Justify left";
  }

  default String justifyRight() {
    return "Justify right";
  }

  default String reduceIndent() {
    return "Reduce indent";
  }

  default String paste() {
    return "Paste";
  }

  default String redo() {
    return "Redo";
  }

  default String removeFormat() {
    return "Remove format";
  }

  default String removeLinks() {
    return "Remove links";
  }

  default String strikeThrough() {
    return "Strike through";
  }

  default String subscript() {
    return "Subscript";
  }

  default String superscript() {
    return "Superscript";
  }

  default String underline() {
    return "Underline";
  }

  default String undo() {
    return "Undo";
  }
}
