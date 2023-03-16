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

import elemental2.dom.HTMLElement;

import static java.util.Objects.nonNull;

public class ReplaceCssClass implements CssClass {

  private CssClass original = CssClass.NONE;
  private CssClass replacement = CssClass.NONE;

  public static ReplaceCssClass of() {
    return new ReplaceCssClass();
  }

  public static ReplaceCssClass of(CssClass initialStyle) {
    return new ReplaceCssClass(initialStyle);
  }

  public static ReplaceCssClass of(String cssClass) {
    return new ReplaceCssClass(cssClass);
  }

  public ReplaceCssClass() {}

  public ReplaceCssClass(CssClass initialStyle) {
    this.original = initialStyle;
    this.replacement = original;
  }

  public ReplaceCssClass(String cssClass) {
    this.original = () -> cssClass;
    this.replacement = original;
  }

  public ReplaceCssClass replaceWith(CssClass replacement) {
    this.replacement = replacement;
    return this;
  }

  public ReplaceCssClass replaceWith(HasCssClass replacement) {
    if (nonNull(replacement)) {
      this.replacement = replacement.getCssClass();
    }
    return this;
  }

  @Override
  public void remove(HTMLElement element) {
    if (nonNull(replacement)) {
      replacement.remove(element);
    }
  }

  @Override
  public void apply(HTMLElement element) {
    if(nonNull(replacement)){
      original.remove(element);
      replacement.apply(element);
    }
  }

  public CssClass getOriginal() {
    return original;
  }

  public CssClass getReplacement() {
    return replacement;
  }

  @Override
  public String getCssClass() {
    return replacement.getCssClass();
  }
}
