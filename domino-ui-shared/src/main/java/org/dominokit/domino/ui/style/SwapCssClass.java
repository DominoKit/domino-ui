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

import static java.util.Objects.nonNull;

import elemental2.dom.HTMLElement;

public class SwapCssClass implements CssClass {

  private CssClass current = CssClass.NONE;
  private CssClass replacement = CssClass.NONE;

  public static SwapCssClass of() {
    return new SwapCssClass();
  }

  public static SwapCssClass of(CssClass initialStyle) {
    return new SwapCssClass(initialStyle);
  }

  public static SwapCssClass of(String cssClass) {
    return new SwapCssClass(cssClass);
  }

  public SwapCssClass() {
  }

  public SwapCssClass(CssClass initialStyle) {
    this.current = initialStyle;
    this.replacement = current;
  }

  public SwapCssClass(String cssClass) {
    this.current = () -> cssClass;
    this.replacement = current;
  }

  public SwapCssClass replaceWith(CssClass replacement) {
    this.replacement = replacement;
    return this;
  }

  public SwapCssClass replaceWith(HasCssClass replacement) {
    if (nonNull(replacement)) {
      this.replacement = replacement.getCssClass();
    }
    return this;
  }

  @Override
  public void remove(HTMLElement element) {
    if (nonNull(current)) {
      current.remove(element);
    }
  }

  @Override
  public void apply(HTMLElement element) {
      remove(element);
      current = replacement;
      replacement.apply(element);
  }

  public CssClass getCurrent() {
    return current;
  }

  public CssClass getReplacement() {
    return replacement;
  }

  @Override
  public String getCssClass() {
    return replacement.getCssClass();
  }
}
