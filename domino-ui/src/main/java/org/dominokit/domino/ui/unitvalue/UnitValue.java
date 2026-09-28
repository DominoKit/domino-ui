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
package org.dominokit.domino.ui.unitvalue;

import static java.util.Objects.requireNonNull;
import static org.dominokit.domino.ui.utils.Domino.div;
import static org.dominokit.domino.ui.utils.Domino.small;
import static org.dominokit.domino.ui.utils.Domino.span;

import elemental2.dom.HTMLDivElement;
import elemental2.dom.Node;
import org.dominokit.domino.ui.IsElement;
import org.dominokit.domino.ui.elements.DivElement;
import org.dominokit.domino.ui.elements.SmallElement;
import org.dominokit.domino.ui.elements.SpanElement;
import org.dominokit.domino.ui.style.GenericCss;
import org.dominokit.domino.ui.utils.BaseDominoElement;
import org.dominokit.domino.ui.utils.LazyChild;
import org.dominokit.domino.ui.utils.NullLazyChild;

/**
 * Displays a pre-formatted value with an optional unit or symbol, title, and description.
 *
 * <p>{@code UnitValue} does not parse or format the supplied value. The value is rendered exactly
 * as supplied by the caller.
 *
 * <p>The component is vertical by default. Add {@link GenericCss#dui_horizontal} to the root to
 * place the title and value row on the same line, or {@link GenericCss#dui_vertical} to explicitly
 * select vertical layout.
 */
public class UnitValue extends BaseDominoElement<HTMLDivElement, UnitValue>
    implements UnitValueStyles {

  private final DivElement root;
  private final DivElement valueRow;
  private final SpanElement valueElement;
  private LazyChild<SpanElement> titleElement = NullLazyChild.of();
  private LazyChild<SpanElement> unitElement = NullLazyChild.of();
  private LazyChild<SmallElement> descriptionElement = NullLazyChild.of();

  /** Creates a UnitValue displaying only the supplied value. */
  public UnitValue(String value) {
    root =
        div()
            .addCss(
                dui_unit_value,
                GenericCss.dui_vertical,
                GenericCss.dui_ignore_bg,
                GenericCss.dui_ignore_fg);
    valueRow = div().addCss(dui_unit_value_row);
    valueElement = span().addCss(dui_unit_value_value);
    valueRow.appendChild(valueElement);
    root.appendChild(valueRow);
    init(this);
    setValue(value);
  }

  /** Creates a UnitValue displaying the supplied value and text unit. */
  public UnitValue(String value, String unit) {
    this(value);
    setUnit(unit);
  }

  /** Creates a UnitValue displaying the supplied value and DOM unit or symbol. */
  public UnitValue(String value, Node unit) {
    this(value);
    setUnit(unit);
  }

  /** Creates a UnitValue displaying the supplied value and Domino UI unit or symbol. */
  public UnitValue(String value, IsElement<?> unit) {
    this(value);
    setUnit(unit);
  }

  /** Creates a UnitValue displaying only the supplied value. */
  public static UnitValue create(String value) {
    return new UnitValue(value);
  }

  /** Creates a UnitValue displaying the supplied value and text unit. */
  public static UnitValue create(String value, String unit) {
    return new UnitValue(value, unit);
  }

  /** Creates a UnitValue displaying the supplied value and DOM unit or symbol. */
  public static UnitValue create(String value, Node unit) {
    return new UnitValue(value, unit);
  }

  /** Creates a UnitValue displaying the supplied value and Domino UI unit or symbol. */
  public static UnitValue create(String value, IsElement<?> unit) {
    return new UnitValue(value, unit);
  }

  /** Returns the root {@code HTMLDivElement}. */
  @Override
  public HTMLDivElement element() {
    return root.element();
  }

  /** Sets the pre-formatted value without parsing or changing it. */
  public UnitValue setValue(String value) {
    valueElement.setTextContent(requireNonNull(value, "value cannot be null"));
    return this;
  }

  /** Sets or clears the optional text title. */
  public UnitValue setTitle(String title) {
    if (isEmpty(title)) {
      titleElement.remove();
    } else {
      titleElement = ensureTitle();
      titleElement.get().setTextContent(title);
    }
    return this;
  }

  /** Sets or clears the optional DOM title. */
  public UnitValue setTitle(Node title) {
    if (title == null) {
      titleElement.remove();
    } else {
      titleElement = ensureTitle();
      titleElement.get().clearElement().appendChild(title);
    }
    return this;
  }

  /** Sets or clears the optional Domino UI title. */
  public UnitValue setTitle(IsElement<?> title) {
    return setTitle(title == null ? null : title.element());
  }

  /** Sets or clears the optional text description. */
  public UnitValue setDescription(String description) {
    if (isEmpty(description)) {
      descriptionElement.remove();
    } else {
      descriptionElement = ensureDescription();
      descriptionElement.get().setTextContent(description);
    }
    return this;
  }

  /** Sets or clears the optional DOM description. */
  public UnitValue setDescription(Node description) {
    if (description == null) {
      descriptionElement.remove();
    } else {
      descriptionElement = ensureDescription();
      descriptionElement.get().clearElement().appendChild(description);
    }
    return this;
  }

  /** Sets or clears the optional Domino UI description. */
  public UnitValue setDescription(IsElement<?> description) {
    return setDescription(description == null ? null : description.element());
  }

  /** Sets or clears the optional text unit or symbol. */
  public UnitValue setUnit(String unit) {
    if (isEmpty(unit)) {
      unitElement.remove();
    } else {
      unitElement = ensureUnit();
      unitElement.get().setTextContent(unit);
    }
    return this;
  }

  /** Sets or clears the optional DOM unit or symbol. */
  public UnitValue setUnit(Node unit) {
    if (unit == null) {
      unitElement.remove();
    } else {
      unitElement = ensureUnit();
      unitElement.get().clearElement().appendChild(unit);
    }
    return this;
  }

  /** Sets or clears the optional Domino UI unit or symbol. */
  public UnitValue setUnit(IsElement<?> unit) {
    return setUnit(unit == null ? null : unit.element());
  }

  /** Returns the value element for targeted styling. */
  public SpanElement getValueElement() {
    return valueElement;
  }

  /** Returns the value/unit row for targeted styling. */
  public DivElement getValueRow() {
    return valueRow;
  }

  /** Returns the title element, or {@code null} when no title has been supplied. */
  public SpanElement getTitleElement() {
    return titleElement.isInitialized() ? titleElement.get() : null;
  }

  /** Returns the unit element, or {@code null} when no unit has been supplied. */
  public SpanElement getUnitElement() {
    return unitElement.isInitialized() ? unitElement.get() : null;
  }

  /** Returns the description element, or {@code null} when no description has been supplied. */
  public SmallElement getDescriptionElement() {
    return descriptionElement.isInitialized() ? descriptionElement.get() : null;
  }

  private LazyChild<SpanElement> ensureTitle() {
    if (!titleElement.isInitialized()) {
      titleElement = LazyChild.ofInsertFirst(span().addCss(dui_unit_value_title), root);
    }
    return titleElement;
  }

  private LazyChild<SpanElement> ensureUnit() {
    if (!unitElement.isInitialized()) {
      unitElement = LazyChild.of(span().addCss(dui_unit_value_unit), valueRow);
    }
    return unitElement;
  }

  private LazyChild<SmallElement> ensureDescription() {
    if (!descriptionElement.isInitialized()) {
      descriptionElement = LazyChild.of(small().addCss(dui_unit_value_description), root);
    }
    return descriptionElement;
  }

  private boolean isEmpty(String value) {
    return value == null || value.isEmpty();
  }
}
