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
package org.dominokit.domino.ui.popover;

import elemental2.dom.HTMLDivElement;
import java.util.function.Supplier;
import org.dominokit.domino.ui.IsDominoElement;
import org.dominokit.domino.ui.config.DominoCoreConfig;
import org.dominokit.domino.ui.config.PopoverConfig;
import org.dominokit.domino.ui.menu.direction.DropDirection;
import org.dominokit.domino.ui.utils.ChildHandler;
import org.dominokit.domino.ui.utils.IsPopup;
import org.dominokit.domino.ui.utils.IsScrollFollower;

/** Aggregate contract for popovers, including the common core element API. */
public interface IsPopoverBase<
        T extends IsPopoverBase<T, C>, C extends IsDominoElement<HTMLDivElement, C>>
    extends IsDominoElement<HTMLDivElement, T>, IsPopup<T>, PopoverStyles, IsScrollFollower {

  default PopoverConfig getConfig() {
    PopoverConfig ownConfig = getOwnConfig();
    return ownConfig == null ? DominoCoreConfig.Provider.get() : ownConfig;
  }

  PopoverConfig getOwnConfig();

  T setOwnConfig(PopoverConfig ownConfig);

  int getOpenDelay();

  T setOpenDelay(int openDelay);

  void discard();

  T setPosition(DropDirection position);

  DropDirection getPopupPosition();

  T setCloseOthers(boolean closeOthers);

  C getArrowElement();

  T withArrow(ChildHandler<T, C> handler);

  C getHeaderElement();

  T withHeader(ChildHandler<T, C> handler);

  C getBody();

  T withBody(ChildHandler<T, C> handler);

  T closeOnScroll(boolean closeOnScroll);

  T setOpenCondition(Supplier<Boolean> openCondition);

  boolean isCloseOnBlur();

  T setCloseOnBlur(boolean closeOnBlur);

  boolean isCloseOnScroll();
}
