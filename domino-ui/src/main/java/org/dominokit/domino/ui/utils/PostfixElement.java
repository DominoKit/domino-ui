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

import static org.dominokit.domino.ui.style.GenericCss.dui_postfix_addon;

import elemental2.dom.Element;
import elemental2.dom.NodeList;
import java.util.Arrays;
import org.dominokit.domino.ui.IsElement;
import org.dominokit.domino.ui.elements.BaseElement;

public class PostfixElement extends BaseElement<Element, PostfixElement> {

  public static PostfixElement of(Element element) {
    return new PostfixElement(element);
  }

  public static PostfixElement of(IsElement<?> element) {
    return new PostfixElement(element.element());
  }

  /**
   * Constructs a new {@code BaseElement} with the provided DOM element.
   *
   * @param element The DOM element to wrap.
   */
  public PostfixElement(Element element) {
    super(element);
  }

  public PostfixElement appendChild(Element element) {
    return appendChild(PostfixAddOn.of(element));
  }

  public PostfixElement appendChild(PostfixAddOn<?> addon) {
    element().appendChild(addon.element());
    return this;
  }

  public PostfixElement appendChild(PostfixAddOn<?>... addons) {
    Arrays.stream(addons).forEach(this::appendChild);
    return this;
  }

  public PostfixElement appendChild(PrefixAddOn<?> addon) {
    throw new IllegalArgumentException("Cant append a prefix add-on to a Postfix element.");
  }

  public PostfixElement appendChild(PrefixAddOn<?>... addons) {
    throw new IllegalArgumentException("Cant append a prefix add-on to a Postfix element.");
  }

  public PostfixElement appendChild(PrimaryAddOn<?> addon) {
    throw new IllegalArgumentException("Cant append a primary add-on to a Postfix element.");
  }

  public PostfixElement appendChild(PrimaryAddOn<?>... addons) {
    throw new IllegalArgumentException("Cant append a primary add-on to a Postfix element.");
  }

  public PostfixElement appendChild(IsElement<?> element) {
    return super.appendChild(PostfixAddOn.of(element));
  }

  public PostfixElement appendChild(IsElement<?>... element) {
    Arrays.stream(element).forEach(this::appendChild);
    return this;
  }

  public PostfixElement appendChild(Element... element) {
    Arrays.stream(element).forEach(this::appendChild);
    return this;
  }

  @Override
  public PostfixElement clearElement() {
    NodeList<Element> prefixes =
        this.element().querySelectorAll(":scope > ." + dui_postfix_addon.getCssClass());
    prefixes.asList().forEach(Element::remove);
    return this;
  }
}
