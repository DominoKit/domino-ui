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
package org.dominokit.domino.ui.style;

import elemental2.dom.Element;

/**
 * CssProperty class.
 *
 * @author vegegoku
 * @version $Id: $Id
 */
public class CssProperty implements IsCssProperty {
  private final String name;
  private final String value;

  /**
   * of.
   *
   * @param name a {@link java.lang.String} object.
   * @param value a {@link java.lang.String} object.
   * @return a {@link org.dominokit.domino.ui.style.CssProperty} object.
   */
  public static CssProperty of(String name, String value) {
    return new CssProperty(name, value);
  }

  private CssProperty(String name, String value) {
    this.name = name;
    this.value = value;
  }

  /**
   * Getter for the field <code>name</code>.
   *
   * @return a {@link java.lang.String} object.
   */
  public String getName() {
    return name;
  }

  /**
   * Getter for the field <code>value</code>.
   *
   * @return a {@link java.lang.String} object.
   */
  public String getValue() {
    return value;
  }

  /**
   * apply.
   *
   * @param element a {@link elemental2.dom.Element} object.
   */
  public void apply(Element element) {
    Style.of(element).setCssProperty(name, value);
  }

  /** {@inheritDoc} */
  @Override
  public void remove(Element element) {
    Style.of(element).removeCssProperty(name);
  }
}
