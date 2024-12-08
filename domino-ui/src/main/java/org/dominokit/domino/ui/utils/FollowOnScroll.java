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
import static org.dominokit.domino.ui.utils.Domino.*;
import static org.dominokit.domino.ui.utils.ElementsFactory.elements;

import elemental2.dom.Element;
import elemental2.dom.EventListener;

/** A utility class for handling follow-on-scroll behavior. */
public class FollowOnScroll {

  private final EventListener repositionListener;

  /**
   * Constructs a new FollowOnScroll instance.
   *
   * @param targetElement The target element that the follower will follow as it scrolls.
   * @param scrollFollower The ScrollFollower instance responsible for tracking the follower.
   */
  public FollowOnScroll(Element targetElement, ScrollFollower scrollFollower) {
    repositionListener =
        evt -> {
          if (scrollFollower.isFollowerOpen()) {
            scrollFollower.positionFollower();
          }
        };
    elements.elementOf(targetElement).onDetached((e, mutationRecord) -> stop());
  }

  /** Starts listening to scroll events to reposition the follower. */
  public void start() {
    document.addEventListener("scroll", repositionListener, true);
  }

  /** Stops listening to scroll events, halting the follow-on-scroll behavior. */
  public void stop() {
    document.removeEventListener("scroll", repositionListener, true);
  }

  /** An interface for defining a ScrollFollower that tracks the follower's state and position. */
  public interface ScrollFollower {

    /**
     * Checks if the follower is currently open.
     *
     * @return {@code true} if the follower is open, {@code false} otherwise.
     */
    boolean isFollowerOpen();

    /** Positions the follower based on the scrolling behavior. */
    void positionFollower();
  }
}
