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

import static elemental2.dom.DomGlobal.document;
import static org.dominokit.domino.ui.utils.ElementsFactory.elements;

import elemental2.dom.Element;
import elemental2.dom.EventListener;

/**
 * FollowOnScroll class.
 *
 * @author vegegoku
 * @version $Id: $Id
 */
public class FollowOnScroll {

  private final EventListener repositionListener;

  /**
   * Constructor for FollowOnScroll.
   *
   * @param targetElement a {@link elemental2.dom.Element} object
   * @param scrollFollower a {@link org.dominokit.domino.ui.utils.FollowOnScroll.ScrollFollower}
   *     object
   */
  public FollowOnScroll(Element targetElement, ScrollFollower scrollFollower) {
    repositionListener =
        evt -> {
          if (scrollFollower.isFollowerOpen()) {
            scrollFollower.positionFollower();
          }
        };
    elements.elementOf(targetElement).onDetached(mutationRecord -> stop());
  }

  /** start. */
  public void start() {
    document.addEventListener("scroll", repositionListener, true);
  }

  /** stop. */
  public void stop() {
    document.removeEventListener("scroll", repositionListener, true);
  }

  public interface ScrollFollower {
    boolean isFollowerOpen();

    void positionFollower();
  }
}
