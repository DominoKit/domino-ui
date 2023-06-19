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
package org.dominokit.domino.ui.datatable.events;

import org.dominokit.domino.ui.datatable.plugins.pagination.BodyScrollPlugin;

/**
 * This event will be fired by the {@link BodyScrollPlugin} for scrollable table body whenever the
 * scroll reaches the top or the bottom
 */
public class BodyScrollEvent implements TableEvent {

  /** A constant string to define a unique type for this event */
  public static final String BODY_SCROLL = "data-table-body-scroll";

  private final BodyScrollPlugin.ScrollPosition scrollPosition;

  /** @param scrollPosition a {@link BodyScrollPlugin.ScrollPosition} */
  public BodyScrollEvent(BodyScrollPlugin.ScrollPosition scrollPosition) {
    this.scrollPosition = scrollPosition;
  }

  /** {@inheritDoc} */
  @Override
  public String getType() {
    return BODY_SCROLL;
  }

  /** @return {@link BodyScrollPlugin.ScrollPosition} */
  public BodyScrollPlugin.ScrollPosition getScrollPosition() {
    return scrollPosition;
  }
}
