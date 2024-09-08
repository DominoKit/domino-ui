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
package org.dominokit.domino.ui.shaded.utils;

import static java.util.Objects.isNull;

import elemental2.dom.DomGlobal;
import elemental2.dom.Text;

/** A static factory class to create DOM text nodes */
@Deprecated
public class TextNode {

  /** @return new empty {@link Text} node */
  public static Text empty() {
    return DomGlobal.document.createTextNode("");
  }

  /**
   * @param content String content of the node
   * @return new {@link Text} node with the provided text content
   */
  public static Text of(String content) {
    if (isNull(content) || content.isEmpty()) {
      return empty();
    }
    return DomGlobal.document.createTextNode(content);
  }
}
