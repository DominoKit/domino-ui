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
package org.dominokit.domino.ui.labels;

import static org.dominokit.domino.ui.utils.Domino.*;

import elemental2.dom.HTMLElement;
import org.dominokit.domino.ui.elements.SpanElement;
import org.dominokit.domino.ui.style.CssClass;
import org.dominokit.domino.ui.utils.BaseDominoElement;

/**
 * The {@code Label} class represents a simple label element for displaying text.
 *
 * <p>It provides a way to create and customize labels in a DOM structure.
 *
 * @see BaseDominoElement
 */
public class Label extends BaseDominoElement<HTMLElement, Label> {

  /** A CSS class representing the label: {@code dui-label}. */
  public static CssClass dui_label = () -> "dui-label";

  private final SpanElement element;

  /** Constructs a new empty {@code Label}. */
  private Label() {
    element = span().addCss(dui_label);
    init(this);
  }

  /**
   * Constructs a new {@code Label} with the specified text content.
   *
   * @param text The text content of the label.
   */
  public Label(String text) {
    this();
    element.setTextContent(text);
  }

  /**
   * Creates a new {@code Label} with the specified text content.
   *
   * @param text The text content of the label.
   * @return A new {@code Label} instance.
   */
  public static Label create(String text) {
    return new Label(text);
  }

  /** @dominokit-site-ignore {@inheritDoc} */
  @Override
  public HTMLElement element() {
    return element.element();
  }

  /**
   * Sets the text content of the label.
   *
   * @param text The text content to set.
   * @return This {@code Label} instance for method chaining.
   */
  public Label setText(String text) {
    element.setTextContent(text);
    return this;
  }
}
