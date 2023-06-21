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
package org.dominokit.domino.ui.utils;

import static java.util.Objects.isNull;

/**
 * MatchHighlighter class.
 *
 * @author vegegoku
 * @version $Id: $Id
 */
public class MatchHighlighter {

  private static final String prefix = "<mark>";
  private static final String postfix = "</mark>";

  /**
   * highlight.
   *
   * @param source a {@link java.lang.String} object
   * @param part a {@link java.lang.String} object
   * @return a {@link java.lang.String} object
   */
  public static String highlight(String source, String part) {
    if (isNull(part)
        || isNull(source)
        || part.isEmpty()
        || source.isEmpty()
        || !containsPart(source, part)) {
      return sourceOrEmpty(source);
    }
    int startIndex = source.toLowerCase().indexOf(part.toLowerCase());
    String partInSource = source.substring(startIndex, startIndex + part.length());
    String result = source.replace(partInSource, prefix + partInSource + postfix);
    return result;
  }

  private static boolean containsPart(String source, String part) {
    return source.toLowerCase().contains(part.toLowerCase());
  }

  private static String sourceOrEmpty(String source) {
    return isNull(source) ? "" : source;
  }
}
