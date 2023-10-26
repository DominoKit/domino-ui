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
 * The {@code MatchHighlighter} class provides utility methods for highlighting matching substrings
 * within a source string. It allows you to emphasize specific parts of the source string by
 * wrapping them with HTML mark tags.
 */
public class MatchHighlighter {

  private static final String prefix = "<mark>";
  private static final String postfix = "</mark>";

  /**
   * Highlights the matching part of a source string by wrapping it with HTML mark tags.
   *
   * @param source The source string to be highlighted.
   * @param part The substring to be highlighted within the source string.
   * @return A new string with the matching part wrapped in mark tags or the original source string
   *     if no match is found.
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

  /**
   * Checks if a source string contains a specific part, ignoring case.
   *
   * @param source The source string to check.
   * @param part The substring to search for within the source string.
   * @return {@code true} if the part is found within the source string, ignoring case; otherwise,
   *     {@code false}.
   */
  private static boolean containsPart(String source, String part) {
    return source.toLowerCase().contains(part.toLowerCase());
  }

  /**
   * Returns an empty string if the source is null; otherwise, returns the source string.
   *
   * @param source The source string to check.
   * @return An empty string if the source is null; otherwise, the source string itself.
   */
  private static String sourceOrEmpty(String source) {
    return isNull(source) ? "" : source;
  }
}
