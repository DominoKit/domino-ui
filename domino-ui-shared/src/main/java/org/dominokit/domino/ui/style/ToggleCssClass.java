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

public class ToggleCssClass implements CssClass {

  private final CssClass cssClass;
  public static ToggleCssClass of(CssClass cssClass) {
    return new ToggleCssClass(cssClass);
  }

  public static ToggleCssClass of(HasCssClass cssClass) {
    return new ToggleCssClass(cssClass.getCssClass());
  }

  public static ToggleCssClass of(String cssClass) {
    return new ToggleCssClass(()-> cssClass);
  }

  public ToggleCssClass(CssClass cssClass) {
    this.cssClass = cssClass;
  }

  @Override
  public void apply(Element element) {
    if (element.classList.contains(getCssClass())) {
      element.classList.remove(getCssClass());
    } else {
      element.classList.add(getCssClass());
    }
  }

  @Override
  public String getCssClass() {
    return cssClass.getCssClass();
  }
}
