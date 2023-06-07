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

import static org.dominokit.domino.ui.icons.IconsStyles.*;

import elemental2.dom.HTMLElement;
import org.dominokit.domino.ui.elements.SpanElement;
import org.dominokit.domino.ui.style.WavesElement;
import org.dominokit.domino.ui.utils.BaseDominoElement;
import org.dominokit.domino.ui.utils.DominoElement;

/**
 * Icon with a label
 *
 * <p>This component makes sure that the label and the icon fits together
 *
 * @see BaseDominoElement
 */
public class LabeledIcon extends WavesElement<HTMLElement, LabeledIcon> {

  private final SpanElement element;

  public LabeledIcon(Icon<?> icon, String text) {
    this(icon, text, IconPosition.LEFT);
  }

  public LabeledIcon(Icon<?> icon, String text, IconPosition position) {
     element = span()
             .addCss(dui_labeled_icon)
             .appendChild(icon)
             .appendChild(span().addCss(dui_icon_text, dui_text_ellipsis).textContent(text));
     init(this);
    position.apply(this);
  }

  /**
   * Creates an icon with a label text
   *
   * @param icon the {@link Icon}
   * @param text the label of the icon
   * @return new instance
   */
  public static LabeledIcon create(Icon<?> icon, String text) {
    return new LabeledIcon(icon, text);
  }

  /**
   * Creates an icon with a label text with providing the position of the icon to either left or
   * right
   *
   * @param icon the {@link Icon}
   * @param text the label of the icon
   * @param position the {@link IconPosition}
   * @return new instance
   */
  public static LabeledIcon create(Icon<?> icon, String text, IconPosition position) {
    return new LabeledIcon(icon, text, position);
  }

  /** {@inheritDoc} */
  @Override
  public HTMLElement element() {
    return element.element();
  }

  /** An enum representing the position of the icon related to the label */
  public enum IconPosition {
    /** position the icon to the left */
    LEFT(
        (labeledIcon) -> {
          labeledIcon.addCss(dui_reversed);
        }),

    /** position the icon to the right */
    RIGHT(
        (labeledIcon) -> {
          dui_reversed.remove(labeledIcon);
        });

    private final ElementsPlacement elementsPlacement;

    IconPosition(ElementsPlacement elementsPlacement) {
      this.elementsPlacement = elementsPlacement;
    }

    /**
     * Position the elements
     *
     * @param labeledIcon the ${@link LabeledIcon} to apply the position on
     */
    public void apply(LabeledIcon labeledIcon) {
      elementsPlacement.apply(labeledIcon);
    }
  }

  @FunctionalInterface
  public interface ElementsPlacement {
    void apply(LabeledIcon labeledIcon);
  }
}
