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
package org.dominokit.domino.ui.icons;

import static org.dominokit.domino.ui.icons.IconsStyles.dui_icon_text;
import static org.dominokit.domino.ui.icons.IconsStyles.dui_labeled_icon;
import static org.dominokit.domino.ui.utils.Domino.*;

import elemental2.dom.HTMLElement;
import org.dominokit.domino.ui.elements.SpanElement;
import org.dominokit.domino.ui.style.WavesElement;
import org.dominokit.domino.ui.utils.ChildHandler;

/**
 * A component that combines an icon and a text label, allowing you to create labeled icons with
 * different positions.
 */
public class LabeledIcon extends WavesElement<HTMLElement, LabeledIcon> {

  private final SpanElement element;
  private final SpanElement textElement;
  private final Icon<?> icon;

  /**
   * Creates a labeled icon with the provided icon and text, positioned to the left.
   *
   * @param icon The icon to display.
   * @param text The text label to display.
   */
  public LabeledIcon(Icon<?> icon, String text) {
    this(icon, text, IconPosition.LEFT);
  }

  /**
   * Creates a labeled icon with the provided icon, text, and specified position.
   *
   * @param icon The icon to display.
   * @param text The text label to display.
   * @param position The position of the icon relative to the text label.
   */
  public LabeledIcon(Icon<?> icon, String text, IconPosition position) {
    element =
        span()
            .addCss(dui_labeled_icon)
            .appendChild(this.icon = icon)
            .appendChild(
                textElement = span().addCss(dui_icon_text, dui_text_ellipsis).textContent(text));
    init(this);
    position.apply(this);
  }

  /**
   * Creates a new instance of a labeled icon with the provided icon and text, positioned to the
   * left.
   *
   * @param icon The icon to display.
   * @param text The text label to display.
   * @return A new instance of LabeledIcon.
   */
  public static LabeledIcon create(Icon<?> icon, String text) {
    return new LabeledIcon(icon, text);
  }

  /**
   * Creates a new instance of a labeled icon with the provided icon, text, and specified position.
   *
   * @param icon The icon to display.
   * @param text The text label to display.
   * @param position The position of the icon relative to the text label.
   * @return A new instance of LabeledIcon.
   */
  public static LabeledIcon create(Icon<?> icon, String text, IconPosition position) {
    return new LabeledIcon(icon, text, position);
  }

  /**
   * Changes the text of the labeled icon
   *
   * @param text the new text.
   * @return same component
   */
  public LabeledIcon setText(String text) {
    this.textElement.setTextContent(text);
    return this;
  }

  /**
   * Apply a handler to the labeledIcon text element.
   *
   * @param handler the handler to be applied
   * @return same component
   */
  public LabeledIcon withTextElement(ChildHandler<LabeledIcon, SpanElement> handler) {
    handler.apply(this, textElement);
    return this;
  }

  /**
   * Apply a handler to the labeledIcon icon element.
   *
   * @param handler the handler to be applied
   * @return same component
   */
  public LabeledIcon withIcon(ChildHandler<LabeledIcon, Icon<?>> handler) {
    handler.apply(this, icon);
    return this;
  }

  /**
   * Applies a new position for the labeledIcon text.
   *
   * @param position The new position to be applied
   * @return same component.
   */
  public LabeledIcon setIconPosition(IconPosition position) {
    position.apply(this);
    return this;
  }

  /** @dominokit-site-ignore {@inheritDoc} */
  @Override
  public HTMLElement element() {
    return element.element();
  }

  /**
   * Enumeration of icon positions, allowing you to specify whether the icon should be on the left
   * or right of the text label.
   */
  public enum IconPosition {
    /** The icon is positioned to the left of the text label. */
    LEFT(
        (labeledIcon) -> {
          labeledIcon.addCss(dui_reversed);
        }),

    /** The icon is positioned to the right of the text label. */
    RIGHT(
        (labeledIcon) -> {
          dui_reversed.remove(labeledIcon);
        });

    private final ElementsPlacement elementsPlacement;

    IconPosition(ElementsPlacement elementsPlacement) {
      this.elementsPlacement = elementsPlacement;
    }

    /**
     * Applies the specified position to the labeled icon.
     *
     * @param labeledIcon The labeled icon to apply the position to.
     */
    public void apply(LabeledIcon labeledIcon) {
      elementsPlacement.apply(labeledIcon);
    }
  }

  /** A functional interface for specifying the placement of elements within the labeled icon. */
  @FunctionalInterface
  public interface ElementsPlacement {
    /**
     * Applies the placement of elements within the labeled icon.
     *
     * @param labeledIcon The labeled icon to apply the placement to.
     */
    void apply(LabeledIcon labeledIcon);
  }
}
