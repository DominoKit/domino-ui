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

import elemental2.dom.HTMLElement;
import org.dominokit.domino.ui.button.Button;
import org.dominokit.domino.ui.button.ButtonStyles;
import org.dominokit.domino.ui.events.EventType;
import org.dominokit.domino.ui.icons.Icon;
import org.dominokit.domino.ui.style.ColorsCss;
import org.dominokit.domino.ui.utils.ElementUtil;

/**
 * A component that show up in a specific position on the screen only when the user scrolls down and
 * allow the user to click it to scroll to the top of the page
 */
public class ScrollTop extends Button implements ButtonStyles {

  private int showOffset = 60;

  /** @param icon {@link Icon} to show in the component */
  /**
   * Constructor for ScrollTop.
   *
   * @param icon a {@link org.dominokit.domino.ui.icons.Icon} object
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
   * setBottom.
   *
   * @param bottom int bottom position
   * @return same ScrollTop instance
   */
  public ScrollTop setBottom(int bottom) {
    style().setBottom(bottom + "px");
    return this;
  }

  /**
   * setRight.
   *
   * @param right int right position
   * @return same ScrollTop instance
   */
  public ScrollTop setRight(int right) {
    style().setRight(right + "px");
    return this;
  }

  /**
   * Setter for the field <code>showOffset</code>.
   *
   * @param offset int minimum scroll offset that the user needs to scroll before showing this
   *     component
   * @return same ScrollTop instance
   */
  public ScrollTop setShowOffset(int offset) {
    this.showOffset = offset;
    return this;
  }

  /**
   * create.
   *
   * @param icon {@link org.dominokit.domino.ui.icons.Icon} to show in the component
   * @return same ScrollTop instance
   */
  public static ScrollTop create(Icon<?> icon) {
    return new ScrollTop(icon);
  }

  /** {@inheritDoc} */
  @Override
  public HTMLElement element() {
    return buttonElement.element();
  }
}
