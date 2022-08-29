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
import org.jboss.elemento.IsElement;

public class BooleanCssClass implements CssClass {

  private CssClass cssClass;
  private boolean addRemove;

  public static BooleanCssClass of(CssClass cssClass, boolean addRemove) {
    return new BooleanCssClass(cssClass, addRemove);
  }

  public BooleanCssClass(CssClass cssClass, boolean addRemove) {
    this.cssClass = cssClass;
    this.addRemove = addRemove;
  }

  @Override
  public void apply(HTMLElement element) {
    if (addRemove) {
      cssClass.apply(element);
    } else {
      remove(element);
    }
  }

  @Override
  public boolean isAppliedTo(HTMLElement element) {
    return cssClass.isAppliedTo(element);
  }

  @Override
  public boolean isAppliedTo(IsElement<?> element) {
    return cssClass.isAppliedTo(element);
  }

  @Override
  public void remove(HTMLElement element) {
    cssClass.remove(element);
  }

  @Override
  public void remove(IsElement<?> element) {
    cssClass.remove(element);
  }

  @Override
  public String getCssClass() {
    return cssClass.getCssClass();
  }
}
