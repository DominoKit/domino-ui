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
package org.dominokit.domino.ui.menu.base;

import elemental2.dom.Element;
import elemental2.dom.HTMLDivElement;
import elemental2.dom.HTMLElement;
import elemental2.dom.HTMLLIElement;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import org.dominokit.domino.ui.IsElement;
import org.dominokit.domino.ui.icons.Icon;
import org.dominokit.domino.ui.layout.IsNavBar;
import org.dominokit.domino.ui.menu.DropTarget;
import org.dominokit.domino.ui.menu.MissingItemHandler;
import org.dominokit.domino.ui.menu.OpenMenuCondition;
import org.dominokit.domino.ui.menu.SingleSelectionMode;
import org.dominokit.domino.ui.menu.direction.DropDirection;
import org.dominokit.domino.ui.utils.AnyElement;
import org.dominokit.domino.ui.utils.ChildHandler;
import org.dominokit.domino.ui.utils.DominoElement;
import org.dominokit.domino.ui.utils.HasOpenCloseListeners;
import org.dominokit.domino.ui.utils.HasZIndexLayer;
import org.dominokit.domino.ui.utils.KeyboardNavigation;
import org.dominokit.domino.ui.utils.LazyChild;
import org.dominokit.domino.ui.utils.Selectable;
import org.dominokit.domino.ui.utils.SubheaderAddon;

/** Core-safe menu contract shared by menu implementations and core element APIs. */
public interface IsMenuBase<
        V, C extends IsMenuBase<V, C, I, S>, I extends IsMenuItem<V, I, S>, S extends Selectable<S>>
    extends HasOpenCloseListeners<C>, IsElement<HTMLDivElement> {

  void focusFirstMatch(String token);

  Optional<I> findOptionStarsWith(String token);

  boolean isCenterOnSmallScreens();

  C setCenterOnSmallScreens(boolean centerOnSmallScreens);

  boolean isRootMenu();

  C setTitle(String title);

  C setIcon(Icon<?> icon);

  IsNavBar<?> getMenuHeader();

  C withHeader(ChildHandler<C, IsNavBar<?>> handler);

  C appendChild(SubheaderAddon<?> addon);

  C appendChild(SubheaderAddon<?>... addons);

  void clearSelection(boolean silent);

  String getCreateMissingLabel();

  C setCreateMissingLabel(String createMissingLabel);

  LazyChild<AnyElement> getNoResultElement();

  C setNoResultElement(Element noResultElement);

  C setNoResultElement(IsElement<HTMLLIElement> noResultElement);

  boolean isCaseSensitive();

  C setCaseSensitive(boolean caseSensitive);

  HTMLElement getFocusElement();

  C setFocusElement(HTMLElement focusElement);

  KeyboardNavigation<I> getKeyboardNavigation();

  C setHeaderVisible(boolean visible);

  boolean isSearchable();

  boolean isAllowCreateMissing();

  C setMissingItemHandler(MissingItemHandler<V, C> missingItemHandler);

  C select(I item);

  C select(I menuItem, boolean silent);

  C selectAt(int index);

  C selectAt(int index, boolean silent);

  C selectByKey(String key);

  C selectByKey(String key, boolean silent);

  boolean isAutoCloseOnSelect();

  C setAutoCloseOnSelect(boolean autoCloseOnSelect);

  boolean isMultiSelect();

  C setMultiSelect(boolean multiSelect);

  boolean isAutoOpen();

  C setAutoOpen(boolean autoOpen);

  boolean isFitToTargetWidth();

  C setFitToTargetWidth(boolean fitToTargetWidth);

  C pauseSelectionListeners();

  C resumeSelectionListeners();

  C togglePauseSelectionListeners(boolean toggle);

  boolean isSelectionListenersPaused();

  List<S> getSelection();

  C setBordered(boolean bordered);

  boolean isOpened();

  void open(boolean focus);

  C triggerOnBeforeOpenListeners();

  Set<OnBeforeOpenListener<? super C>> getOnBeforeOpenListeners();

  C addOnBeforeOpenListener(OnBeforeOpenListener<? super C> onBeforeOpenListener);

  C removeOnBeforeOpenListener(OnBeforeOpenListener<? super C> onBeforeOpenListener);

  void focus();

  Optional<DropTarget> getTarget();

  C setTargetElement(IsElement<?> targetElement);

  C setTargetElement(Element targetElement);

  C addTargetElement(Element targetElement);

  C setTarget(DropTarget menuTarget);

  C clearTargets();

  C addTarget(DropTarget menuTarget);

  C removeTarget(DropTarget target);

  DominoElement<Element> getMenuAppendTarget();

  C setMenuAppendTarget(Element appendTarget);

  C open();

  C close();

  DropDirection getDropDirection();

  C setDropDirection(DropDirection dropDirection);

  boolean isContextMenu();

  C setContextMenu(boolean contextMenu);

  boolean isUseSmallScreensDirection();

  C setUseSmallScreensDirection(boolean useSmallScreensDropDirection);

  boolean isDropDown();

  C addOnAddItemHandler(OnAddItemHandler<V, C, I, S> onAddItemHandler);

  C withHeader();

  boolean isModal();

  boolean isAutoClose();

  C setAutoClose(boolean autoClose);

  C setOpenMenuCondition(OpenMenuCondition<V, C, I, S> openMenuCondition);

  boolean isCloseOnBlur();

  C setCloseOnBlur(boolean closeOnBlur);

  C setCloseOnScroll(boolean closeOnScroll);

  boolean isPreserveSelectionStyles();

  C setPreserveSelectionStyles(boolean preserveSelectionStyles);

  HasZIndexLayer.ZIndexLayer getZIndexLayer();

  C setSelectionMode(SingleSelectionMode selectionMode);

  C setAutoFocus(boolean autoFocus);

  boolean isAutoFocus();

  SingleSelectionMode getEffectiveSelectionMode();
}
