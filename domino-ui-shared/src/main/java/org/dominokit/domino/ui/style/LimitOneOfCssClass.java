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
import java.util.Arrays;
import java.util.Collection;
import java.util.Optional;
import java.util.stream.Collectors;

public class LimitOneOfCssClass implements CssClass {

  private final CompositeCssClass allowedClasses;
  private CssClass active = CssClass.NONE;

  public static LimitOneOfCssClass of(CssClass... allowedClasses) {
    return new LimitOneOfCssClass(allowedClasses);
  }

  public static LimitOneOfCssClass of(String... allowedClasses) {
    return new LimitOneOfCssClass(allowedClasses);
  }

  public LimitOneOfCssClass(CssClass... allowedClasses) {
    this.allowedClasses = CompositeCssClass.of(allowedClasses);
  }

  public LimitOneOfCssClass(String... allowedClasses) {
    this.allowedClasses =
        CompositeCssClass.of(
            Arrays.stream(allowedClasses).map(s -> (CssClass) () -> s).collect(Collectors.toSet()));
  }

  public LimitOneOfCssClass(Collection<CssClass> allowedClasses) {
    this.allowedClasses = CompositeCssClass.of(allowedClasses);
  }

  public LimitOneOfCssClass use(CssClass activated) {
    if (this.allowedClasses.contains(activated)) {
      this.active = activated;
    }
    return this;
  }

  public LimitOneOfCssClass use(HasCssClass activated) {
    if (this.allowedClasses.contains(activated.getCssClass())) {
      this.active = activated.getCssClass();
    }
    return this;
  }

  @Override
  public void remove(Element element) {
    allowedClasses.remove(element);
  }

  @Override
  public void apply(Element element) {
    if (allowedClasses.contains(active)) {
      allowedClasses.remove(element);
      active.apply(element);
    }
  }

  public CompositeCssClass getAllowedClasses() {
    return allowedClasses;
  }

  public Optional<CssClass> getActive(Element element) {
    return CompositeCssClass.of(element).getCssClasses().stream()
        .filter(allowedClasses::contains)
        .findFirst();
  }

  @Override
  public String getCssClass() {
    return active.getCssClass();
  }
}
