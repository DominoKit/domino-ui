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

/**
 * Represents metadata for a Material Design Icon (MDI). This class contains information about the
 * icon's name, codepoint, aliases, tags, author, and version.
 */
public class MdiMeta {

  private final String name;
  private final String codepoint;
  private final List<String> aliases;
  private final List<String> tags;
  private final String author;
  private final String version;

  /**
   * Constructs an instance of {@code MdiMeta} with the specified metadata.
   *
   * @param name The name of the MDI icon.
   * @param codepoint The codepoint representing the icon in Unicode.
   * @param aliases A list of aliases for the icon.
   * @param tags A list of tags associated with the icon.
   * @param author The author or source of the icon.
   * @param version The version of the icon.
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

  /**
   * Constructs an instance of {@code MdiMeta} with the specified name. This constructor initializes
   * the other metadata fields with empty values or empty lists.
   *
   * @param name The name of the MDI icon.
   */
  MdiMeta(String name) {
    this(name, "", new ArrayList<>(), new ArrayList<>(), "", "");
  }

  /**
   * Gets the name of the MDI icon.
   *
   * @return The name of the icon.
   */
  public String getName() {
    return name;
  }

  /**
   * Gets the Unicode codepoint representing the MDI icon.
   *
   * @return The codepoint as a string.
   */
  public String getCodepoint() {
    return codepoint;
  }

  /**
   * Gets a list of aliases for the MDI icon.
   *
   * @return A list of alias names.
   */
  public List<String> getAliases() {
    return aliases;
  }

  /**
   * Gets a list of tags associated with the MDI icon.
   *
   * @return A list of tag names.
   */
  public List<String> getTags() {
    return tags;
  }

  /**
   * Gets the author or source of the MDI icon.
   *
   * @return The author's name or source information.
   */
  public String getAuthor() {
    return author;
  }

  /**
   * Gets the version of the MDI icon.
   *
   * @return The icon's version information.
   */
  public String getVersion() {
    return version;
  }
}
