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

import static org.dominokit.domino.ui.style.GenericCss.dui_primary_addon;

import elemental2.dom.Element;
import elemental2.dom.NodeList;
import java.util.Arrays;
import org.dominokit.domino.ui.IsElement;
import org.dominokit.domino.ui.elements.BaseElement;

public class PrimaryAddOnElement extends BaseElement<Element, PrimaryAddOnElement> {

  public static PrimaryAddOnElement of(Element element) {
    return new PrimaryAddOnElement(element);
  }

  public static PrimaryAddOnElement of(IsElement<?> element) {
    return new PrimaryAddOnElement(element.element());
  }

  /**
   * Constructs a new {@code BaseElement} with the provided DOM element.
   *
   * @param element The DOM element to wrap.
   */
  public PrimaryAddOnElement(Element element) {
    super(element);
  }

  public PrimaryAddOnElement appendChild(Element element) {
    return super.appendChild(PrimaryAddOn.of(element));
  }

  public PrimaryAddOnElement appendChild(PrimaryAddOn<?> addon) {
    element().appendChild(addon.element());
    return this;
  }

  public PrimaryAddOnElement appendChild(PrimaryAddOn<?>... addons) {
    Arrays.stream(addons).forEach(this::appendChild);
    return this;
  }

  public PrimaryAddOnElement appendChild(PrefixAddOn<?> addon) {
    throw new IllegalArgumentException(
        "Cant append a prefix add-on to a Primary add-on element element.");
  }

  public PrimaryAddOnElement appendChild(PrefixAddOn<?>... addons) {
    throw new IllegalArgumentException("Cant append a prefix add-on to a Primary add-on element.");
  }

  public PrimaryAddOnElement appendChild(PostfixAddOn<?> addon) {
    throw new IllegalArgumentException("Cant append a prefix add-on to a Primary add-on element.");
  }

  public PrimaryAddOnElement appendChild(PostfixAddOn<?>... addons) {
    throw new IllegalArgumentException("Cant append a prefix add-on to a Primary add-on element.");
  }

  public PrimaryAddOnElement appendChild(IsElement<?> element) {
    return appendChild(PrimaryAddOn.of(element));
  }

  public PrimaryAddOnElement appendChild(IsElement<?>... element) {
    Arrays.stream(element).forEach(this::appendChild);
    return this;
  }

  public PrimaryAddOnElement appendChild(Element... element) {
    Arrays.stream(element).forEach(this::appendChild);
    return this;
  }

  @Override
  public PrimaryAddOnElement clearElement() {
    NodeList<Element> prefixes =
        this.element().querySelectorAll(":scope > ." + dui_primary_addon.getCssClass());
    prefixes.asList().forEach(Element::remove);
    return this;
  }
}
