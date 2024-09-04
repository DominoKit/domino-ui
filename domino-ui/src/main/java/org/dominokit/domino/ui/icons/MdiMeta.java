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

/** Meta data for a {@link MdiIcon} */
@Deprecated
public class MdiMeta {

  private final String name;
  private final String codepoint;
  private final List<String> aliases;
  private final List<String> tags;
  private final String author;
  private final String version;

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
  public String getName() {
    return name;
  }

  /** @return The code point of the icon */
  public String getCodepoint() {
    return codepoint;
  }

  /** @return the list of aliases of the icon */
  public List<String> getAliases() {
    return aliases;
  }

  /** @return The list of the tags */
  public List<String> getTags() {
    return tags;
  }

  /** @return The author */
  public String getAuthor() {
    return author;
  }

  /** @return The version */
  public String getVersion() {
    return version;
  }
}
