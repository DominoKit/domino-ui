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
package org.dominokit.domino.ui.icons;

import java.util.ArrayList;
import java.util.List;

/** Meta data for a {@link org.dominokit.domino.ui.icons.MdiIcon} */
public class MdiMeta {

  private final String name;
  private final String codepoint;
  private final List<String> aliases;
  private final List<String> tags;
  private final String author;
  private final String version;

  /**
   * Constructor for MdiMeta.
   *
   * @param name a {@link java.lang.String} object
   * @param codepoint a {@link java.lang.String} object
   * @param aliases a {@link java.util.List} object
   * @param tags a {@link java.util.List} object
   * @param author a {@link java.lang.String} object
   * @param version a {@link java.lang.String} object
   */
  public MdiMeta(
      String name,
      String codepoint,
      List<String> aliases,
      List<String> tags,
      String author,
      String version) {
    this.name = name;
    this.codepoint = codepoint;
    this.aliases = aliases;
    this.tags = tags;
    this.author = author;
    this.version = version;
  }

  MdiMeta(String name) {
    this(name, "", new ArrayList<>(), new ArrayList<>(), "", "");
  }

  /** @return the name of the icon */
  /**
   * Getter for the field <code>name</code>.
   *
   * @return a {@link java.lang.String} object
   */
  public String getName() {
    return name;
  }

  /** @return The code point of the icon */
  /**
   * Getter for the field <code>codepoint</code>.
   *
   * @return a {@link java.lang.String} object
   */
  public String getCodepoint() {
    return codepoint;
  }

  /** @return the list of aliases of the icon */
  /**
   * Getter for the field <code>aliases</code>.
   *
   * @return a {@link java.util.List} object
   */
  public List<String> getAliases() {
    return aliases;
  }

  /** @return The list of the tags */
  /**
   * Getter for the field <code>tags</code>.
   *
   * @return a {@link java.util.List} object
   */
  public List<String> getTags() {
    return tags;
  }

  /** @return The author */
  /**
   * Getter for the field <code>author</code>.
   *
   * @return a {@link java.lang.String} object
   */
  public String getAuthor() {
    return author;
  }

  /** @return The version */
  /**
   * Getter for the field <code>version</code>.
   *
   * @return a {@link java.lang.String} object
   */
  public String getVersion() {
    return version;
  }
}
