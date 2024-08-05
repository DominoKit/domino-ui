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
package org.dominokit.domino.ui.utils;

import static org.dominokit.domino.ui.style.GenericCss.dui_prefix_addon;

import elemental2.dom.Element;
import elemental2.dom.NodeList;
import java.util.Arrays;
import org.dominokit.domino.ui.IsElement;
import org.dominokit.domino.ui.elements.BaseElement;

public class PrefixElement extends BaseElement<Element, PrefixElement> {

  public static PrefixElement of(Element element) {
    return new PrefixElement(element);
  }

  public static PrefixElement of(IsElement<?> element) {
    return new PrefixElement(element.element());
  }

  /**
   * Constructs a new {@code BaseElement} with the provided DOM element.
   *
   * @param element The DOM element to wrap.
   */
  public PrefixElement(Element element) {
    super(element);
  }

  public PrefixElement appendChild(Element element) {
    return appendChild(PrefixAddOn.of(element));
  }

  public PrefixElement appendChild(PostfixAddOn<?> addon) {
    throw new IllegalArgumentException("Cant append a postfix add-on to a Prefix element.");
  }

  public PrefixElement appendChild(PostfixAddOn<?>... addons) {
    throw new IllegalArgumentException("Cant append a postfix add-on to a Prefix element.");
  }

  public PrefixElement appendChild(PrimaryAddOn<?> addon) {
    throw new IllegalArgumentException("Cant append a primary add-on to a Prefix element.");
  }

  public PrefixElement appendChild(PrimaryAddOn<?>... addons) {
    throw new IllegalArgumentException("Cant append a primary add-on to a Prefix element.");
  }

  public PrefixElement appendChild(PrefixAddOn<?> addon) {
    element().appendChild(addon.element());
    return this;
  }

  public PrefixElement appendChild(PrefixAddOn<?>... addons) {
    Arrays.stream(addons).forEach(this::appendChild);
    return this;
  }

  public PrefixElement appendChild(IsElement<?> element) {
    return appendChild(PrefixAddOn.of(element));
  }

  public PrefixElement appendChild(IsElement<?>... element) {
    Arrays.stream(element).forEach(this::appendChild);
    return this;
  }

  public PrefixElement appendChild(Element... element) {
    Arrays.stream(element).forEach(this::appendChild);
    return this;
  }

  @Override
  public PrefixElement clearElement() {
    NodeList<Element> prefixes =
        this.element().querySelectorAll(":scope > ." + dui_prefix_addon.getCssClass());
    prefixes.asList().forEach(Element::remove);
    return this;
  }
}
