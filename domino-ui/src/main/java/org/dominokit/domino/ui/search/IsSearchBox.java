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
package org.dominokit.domino.ui.search;

import elemental2.dom.HTMLDivElement;
import java.util.Set;
import org.dominokit.domino.ui.IsDominoElement;
import org.dominokit.domino.ui.config.HasComponentConfig;
import org.dominokit.domino.ui.config.SearchConfig;
import org.dominokit.domino.ui.forms.TextBox;
import org.dominokit.domino.ui.i18n.HasLabels;
import org.dominokit.domino.ui.i18n.QuickSearchLabels;
import org.dominokit.domino.ui.icons.Icon;
import org.dominokit.domino.ui.utils.ChildHandler;

/** Public contract for the quick search component. */
public interface IsSearchBox<T extends IsDominoElement<HTMLDivElement, T>>
    extends IsDominoElement<HTMLDivElement, T>,
        HasLabels<QuickSearchLabels>,
        HasComponentConfig<SearchConfig> {

  T clearSearch();

  T clearSearch(boolean silent);

  boolean isAutoSearch();

  T setAutoSearch(boolean autoSearch);

  int getAutoSearchDelay();

  T setAutoSearchDelay(int autoSearchDelayInMillies);

  T addSearchListener(SearchBox.SearchListener searchListener);

  T removeSearchListener(SearchBox.SearchListener searchListener);

  T clearSearchListeners();

  TextBox getTextBox();

  T withTextBox(ChildHandler<T, TextBox> handler);

  Icon<?> getSearchIcon();

  Icon<?> getClearIcon();

  Set<SearchBox.SearchListener> getSearchListeners();
}
