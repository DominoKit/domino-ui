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

/** LimitOneOfCssClass class. */
public class LimitOneOfCssClass implements CssClass {

  private final CompositeCssClass allowedClasses;
  private CssClass active = CssClass.NONE;

  /**
   * of.
   *
   * @param allowedClasses a {@link org.dominokit.domino.ui.style.CssClass} object.
   * @return a {@link org.dominokit.domino.ui.style.LimitOneOfCssClass} object.
   */
  public static LimitOneOfCssClass of(CssClass... allowedClasses) {
    return new LimitOneOfCssClass(allowedClasses);
  }

  /**
   * of.
   *
   * @param allowedClasses a {@link java.lang.String} object.
   * @return a {@link org.dominokit.domino.ui.style.LimitOneOfCssClass} object.
   */
  public static LimitOneOfCssClass of(String... allowedClasses) {
    return new LimitOneOfCssClass(allowedClasses);
  }

  /**
   * Constructor for LimitOneOfCssClass.
   *
   * @param allowedClasses a {@link org.dominokit.domino.ui.style.CssClass} object.
   */
  public LimitOneOfCssClass(CssClass... allowedClasses) {
    this.allowedClasses = CompositeCssClass.of(allowedClasses);
  }

  /**
   * Constructor for LimitOneOfCssClass.
   *
   * @param allowedClasses a {@link java.lang.String} object.
   */
  public LimitOneOfCssClass(String... allowedClasses) {
    this.allowedClasses =
        CompositeCssClass.of(
            Arrays.stream(allowedClasses).map(s -> (CssClass) () -> s).collect(Collectors.toSet()));
  }

  /**
   * Constructor for LimitOneOfCssClass.
   *
   * @param allowedClasses a {@link java.util.Collection} object.
   */
  public LimitOneOfCssClass(Collection<CssClass> allowedClasses) {
    this.allowedClasses = CompositeCssClass.of(allowedClasses);
  }

  /**
   * use.
   *
   * @param activated a {@link org.dominokit.domino.ui.style.CssClass} object.
   * @return a {@link org.dominokit.domino.ui.style.LimitOneOfCssClass} object.
   */
  public LimitOneOfCssClass use(CssClass activated) {
    if (this.allowedClasses.contains(activated)) {
      this.active = activated;
    }
    return this;
  }

  /**
   * use.
   *
   * @param activated a {@link org.dominokit.domino.ui.style.HasCssClass} object.
   * @return a {@link org.dominokit.domino.ui.style.LimitOneOfCssClass} object.
   */
  public LimitOneOfCssClass use(HasCssClass activated) {
    if (this.allowedClasses.contains(activated.getCssClass())) {
      this.active = activated.getCssClass();
    }
    return this;
  }

  /** {@inheritDoc} */
  @Override
  public void remove(Element element) {
    allowedClasses.remove(element);
  }

  /** {@inheritDoc} */
  @Override
  public void apply(Element element) {
    if (allowedClasses.contains(active)) {
      allowedClasses.remove(element);
      active.apply(element);
    }
  }

  /**
   * Getter for the field <code>allowedClasses</code>.
   *
   * @return a {@link org.dominokit.domino.ui.style.CompositeCssClass} object.
   */
  public CompositeCssClass getAllowedClasses() {
    return allowedClasses;
  }

  /**
   * Getter for the field <code>active</code>.
   *
   * @param element a {@link elemental2.dom.Element} object.
   * @return a {@link java.util.Optional} object.
   */
  public Optional<CssClass> getActive(Element element) {
    return CompositeCssClass.of(element).getCssClasses().stream()
        .filter(allowedClasses::contains)
        .findFirst();
  }

  /** {@inheritDoc} */
  @Override
  public String getCssClass() {
    return active.getCssClass();
  }
}
