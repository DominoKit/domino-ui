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
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;
import org.dominokit.domino.ui.IsElement;
import org.dominokit.domino.ui.mediaquery.MediaQuery;

/** XSmallCss class. */
public class XSmallCss implements CssClass {

  private Set<CssClass> cssClasses = new HashSet<>();

  /**
   * of.
   *
   * @param cssClasses a {@link java.util.Collection} object.
   * @return a {@link org.dominokit.domino.ui.style.XSmallCss} object.
   */
  public static XSmallCss of(Collection<CssClass> cssClasses) {
    return new XSmallCss(cssClasses);
  }

  /**
   * of.
   *
   * @param cssClasses a {@link org.dominokit.domino.ui.style.CssClass} object.
   * @return a {@link org.dominokit.domino.ui.style.XSmallCss} object.
   */
  public static XSmallCss of(CssClass... cssClasses) {
    return new XSmallCss(cssClasses);
  }

  /**
   * of.
   *
   * @param element a {@link elemental2.dom.Element} object.
   * @return a {@link org.dominokit.domino.ui.style.XSmallCss} object.
   */
  public static XSmallCss of(Element element) {
    return of(
        element.classList.asList().stream()
            .map(s -> (CssClass) () -> s)
            .collect(Collectors.toList()));
  }

  /**
   * of.
   *
   * @param element a {@link org.dominokit.domino.ui.IsElement} object.
   * @return a {@link org.dominokit.domino.ui.style.XSmallCss} object.
   */
  public static XSmallCss of(IsElement<?> element) {
    return of(element.element());
  }

  /**
   * Constructor for XSmallCss.
   *
   * @param cssClasses a {@link java.util.Collection} object.
   */
  public XSmallCss(Collection<CssClass> cssClasses) {
    this.cssClasses.addAll(cssClasses);
  }

  /**
   * Constructor for XSmallCss.
   *
   * @param cssClasses a {@link org.dominokit.domino.ui.style.CssClass} object.
   */
  public XSmallCss(CssClass... cssClasses) {
    this(Arrays.asList(cssClasses));
  }

  /** {@inheritDoc} */
  @Override
  public String getCssClass() {
    return cssClasses.stream().map(CssClass::getCssClass).collect(Collectors.joining(" "));
  }

  /** {@inheritDoc} */
  @Override
  public void apply(Element element) {
    MediaQuery.addOnXSmallAndDownListener(() -> {});

    cssClasses.forEach(cssClass -> cssClass.apply(element));
  }

  /** {@inheritDoc} */
  @Override
  public boolean isAppliedTo(Element element) {
    return cssClasses.stream().allMatch(cssClass -> cssClass.isAppliedTo(element));
  }

  /** {@inheritDoc} */
  @Override
  public boolean isAppliedTo(IsElement<?> element) {
    return isAppliedTo(element.element());
  }

  /** {@inheritDoc} */
  @Override
  public void remove(Element element) {
    cssClasses.forEach(cssClass -> cssClass.remove(element));
  }

  /** {@inheritDoc} */
  @Override
  public void remove(IsElement<?> element) {
    remove(element.element());
  }
}
