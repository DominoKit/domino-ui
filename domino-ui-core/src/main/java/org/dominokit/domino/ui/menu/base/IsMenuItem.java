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

import elemental2.dom.HTMLElement;
import org.dominokit.domino.ui.IsElement;
import org.dominokit.domino.ui.elements.DivElement;
import org.dominokit.domino.ui.menu.SingleSelectionMode;
import org.dominokit.domino.ui.utils.ChildHandler;
import org.dominokit.domino.ui.utils.HasSelectionListeners;
import org.dominokit.domino.ui.utils.PostfixElement;
import org.dominokit.domino.ui.utils.PrefixElement;
import org.dominokit.domino.ui.utils.Selectable;

/** Core-safe menu item contract shared by menu implementations. */
public interface IsMenuItem<V, I extends IsMenuItem<V, I, S>, S extends Selectable<S>>
    extends IsElement<HTMLElement>, HasSelectionListeners<S, S, S> {

  <C extends IsMenuBase<V, C, I, S>> IsMenuBase<V, C, I, S> getParent();

  <C extends IsMenuBase<V, C, I, S>> C getMenu();

  I select(boolean silent);

  I deselect(boolean silent);

  boolean isRootItem();

  boolean isSelectable();

  I setSelectable(boolean selectable);

  I setSelected(boolean selected);

  I setSelected(boolean selected, boolean silent);

  boolean isSearchable();

  I setSearchable(boolean searchable);

  boolean onSearch(String token, boolean caseSensitive);

  I select();

  I deselect();

  boolean isSelected();

  I focus();

  String getKey();

  V getValue();

  void setValue(V value);

  <T extends I> T withValue(V value);

  boolean hasMenu();

  HTMLElement getClickableElement();

  PrefixElement getPrefixElement();

  PostfixElement getPostfixElement();

  I withBodyElement(ChildHandler<I, DivElement> handler);

  boolean startsWith(String character);

  I setSelectionMode(SingleSelectionMode selectionMode);

  SingleSelectionMode getEffectiveSelectionMode();
}
