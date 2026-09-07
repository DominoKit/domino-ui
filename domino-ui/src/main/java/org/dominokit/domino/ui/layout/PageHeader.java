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
package org.dominokit.domino.ui.layout;

import static org.dominokit.domino.ui.layout.NavBarStyles.dui_page_header;
import static org.dominokit.domino.ui.utils.Domino.text;

import elemental2.dom.Node;

/** A page-level heading with an optional description and body content. */
public class PageHeader extends BaseNavBar<PageHeader> {

  /** Creates an empty page header. */
  public static PageHeader create() {
    return new PageHeader();
  }

  /** Creates a page header with a text title. */
  public static PageHeader create(String title) {
    return new PageHeader(title);
  }

  /** Creates a page header with a title node. */
  public static PageHeader create(Node title) {
    return new PageHeader(title);
  }

  /** Creates an empty page header. */
  public PageHeader() {
    super();
    addCss(dui_page_header);
  }

  /** Creates a page header with a title node. */
  public PageHeader(Node title) {
    this();
    setTitle(title);
  }

  /** Creates a page header with a title and description. */
  public PageHeader(String title, String description) {
    this(text(title));
    setDescription(description);
  }

  /** Creates a page header with a text title. */
  public PageHeader(String title) {
    this(text(title));
  }
}
