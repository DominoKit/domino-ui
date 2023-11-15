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
package org.dominokit.domino.ui.scroll;

import static elemental2.dom.DomGlobal.document;
import static org.dominokit.domino.ui.utils.Domino.*;

import elemental2.dom.HTMLElement;
import org.dominokit.domino.ui.button.Button;
import org.dominokit.domino.ui.button.ButtonStyles;
import org.dominokit.domino.ui.events.EventType;
import org.dominokit.domino.ui.icons.Icon;
import org.dominokit.domino.ui.style.ColorsCss;
import org.dominokit.domino.ui.utils.ElementUtil;

/**
 * Represents a button for scrolling to the top of a web page.
 *
 * <p>The {@code ScrollTop} class provides a button component that allows users to quickly scroll to
 * the top of a web page when clicked. It shows or hides based on the scroll position and provides a
 * customizable offset for showing the button.
 *
 * <p><b>Usage Example:</b>
 *
 * <pre>
 * // Create a scroll to top button with an icon
 * Icon icon = Icons.arrow_upward();
 * ScrollTop scrollTopButton = new ScrollTop(icon);
 *
 * // Customize the button's position and show offset
 * scrollTopButton.setBottom(20);
 * scrollTopButton.setRight(20);
 * scrollTopButton.setShowOffset(100);
 *
 * // Add the button to the document
 * document.body.appendChild(scrollTopButton.element());
 * </pre>
 */
public class ScrollTop extends Button implements ButtonStyles {

  /** The offset at which the button should be shown (default is 60). */
  private int showOffset = 60;

  /**
   * Constructs a new ScrollTop button with the specified icon.
   *
   * @param icon The icon to be displayed on the button.
   */
  public ScrollTop(Icon<?> icon) {
    super(icon);
    init(this);
    circle();
    addCss(ColorsCss.dui_bg_accent);
    addCss(dui_top_scroller);
    collapse();
    addClickListener(evt -> ElementUtil.scrollTop());

    document.addEventListener(
        EventType.scroll.getName(),
        evt -> {
          if (document.scrollingElement.scrollTop > showOffset) {
            ScrollTop.this.expand();
          } else {
            ScrollTop.this.collapse();
          }
        });
  }

  /**
   * Sets the bottom position of the ScrollTop button.
   *
   * @param bottom The bottom position in pixels.
   * @return This ScrollTop instance for method chaining.
   */
  public ScrollTop setBottom(int bottom) {
    style().setBottom(bottom + "px");
    return this;
  }

  /**
   * Sets the right position of the ScrollTop button.
   *
   * @param right The right position in pixels.
   * @return This ScrollTop instance for method chaining.
   */
  public ScrollTop setRight(int right) {
    style().setRight(right + "px");
    return this;
  }

  /**
   * Sets the show offset for the ScrollTop button.
   *
   * @param offset The offset at which the button should be shown.
   * @return This ScrollTop instance for method chaining.
   */
  public ScrollTop setShowOffset(int offset) {
    this.showOffset = offset;
    return this;
  }

  /**
   * Factory method to create a new instance of ScrollTop with the specified icon.
   *
   * @param icon The icon to be displayed on the button.
   * @return A new instance of ScrollTop with the specified icon.
   */
  public static ScrollTop create(Icon<?> icon) {
    return new ScrollTop(icon);
  }

  /**
   * @dominokit-site-ignore {@inheritDoc}
   *     <p>Returns the main HTMLElement of this ScrollTop button.
   * @return The HTMLElement of the ScrollTop button.
   */
  @Override
  public HTMLElement element() {
    return buttonElement.element();
  }
}
