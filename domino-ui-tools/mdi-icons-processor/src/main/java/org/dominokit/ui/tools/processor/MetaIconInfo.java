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
package org.dominokit.ui.tools.processor;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.util.List;
import org.dominokit.jackson.annotation.JSONMapper;

@JSONMapper
/** MetaIconInfo class. */
@JsonIgnoreProperties(ignoreUnknown = true)
public class MetaIconInfo {
  @JsonIgnore private String id;
  private String name;
  private String codepoint;
  private List<String> aliases;
  private List<String> tags;
  private String author;
  private String version;
  private boolean deprecated;

  /**
   * Getter for the field <code>name</code>.
   *
   * @return a {@link java.lang.String} object.
   */
  public String getName() {
    return name;
  }

  /**
   * Setter for the field <code>name</code>.
   *
   * @param name a {@link java.lang.String} object.
   */
  public void setName(String name) {
    this.name = name;
  }

  /**
   * Getter for the field <code>codepoint</code>.
   *
   * @return a {@link java.lang.String} object.
   */
  public String getCodepoint() {
    return codepoint;
  }

  /**
   * Setter for the field <code>codepoint</code>.
   *
   * @param codepoint a {@link java.lang.String} object.
   */
  public void setCodepoint(String codepoint) {
    this.codepoint = codepoint;
  }

  /**
   * Getter for the field <code>aliases</code>.
   *
   * @return a {@link java.util.List} object.
   */
  public List<String> getAliases() {
    return aliases;
  }

  /**
   * Setter for the field <code>aliases</code>.
   *
   * @param aliases a {@link java.util.List} object.
   */
  public void setAliases(List<String> aliases) {
    this.aliases = aliases;
  }

  /**
   * Getter for the field <code>tags</code>.
   *
   * @return a {@link java.util.List} object.
   */
  public List<String> getTags() {
    return tags;
  }

  /**
   * Setter for the field <code>tags</code>.
   *
   * @param tags a {@link java.util.List} object.
   */
  public void setTags(List<String> tags) {
    this.tags = tags;
  }

  /**
   * Getter for the field <code>author</code>.
   *
   * @return a {@link java.lang.String} object.
   */
  public String getAuthor() {
    return author;
  }

  /**
   * Setter for the field <code>author</code>.
   *
   * @param author a {@link java.lang.String} object.
   */
  public void setAuthor(String author) {
    this.author = author;
  }

  /**
   * Getter for the field <code>version</code>.
   *
   * @return a {@link java.lang.String} object.
   */
  public String getVersion() {
    return version;
  }

  /**
   * Setter for the field <code>version</code>.
   *
   * @param version a {@link java.lang.String} object.
   */
  public void setVersion(String version) {
    this.version = version;
  }

  /**
   * isDeprecated.
   *
   * @return a boolean.
   */
  public boolean isDeprecated() {
    return deprecated;
  }

  /**
   * Setter for the field <code>deprecated</code>.
   *
   * @param deprecated a boolean.
   */
  public void setDeprecated(boolean deprecated) {
    this.deprecated = deprecated;
  }
}
