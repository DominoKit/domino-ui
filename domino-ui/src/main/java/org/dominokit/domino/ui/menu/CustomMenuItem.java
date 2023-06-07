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
package org.dominokit.domino.ui.menu;

import static java.util.Objects.isNull;
import static java.util.Objects.nonNull;

/**
 * An implementation of {@link AbstractMenuItem} that can take custom content
 */
public class CustomMenuItem<V> extends AbstractMenuItem<V> {

    private MenuSearchFilter searchFilter = (token, caseSensitive) -> false;

    public static <V> CustomMenuItem<V> create() {
        return new CustomMenuItem<>();
    }

    /**
     * match the search token with both the text and description of the menu item
     *
     * @param token String search text
     * @param caseSensitive boolean, true if the search is case-sensitive
     * @return boolean, true if the item matches the search
     */
    @Override
    public boolean onSearch(String token, boolean caseSensitive) {
        if (isNull(token) || token.isEmpty()) {
            this.show();
            return true;
        }
        if (searchable && searchFilter.onSearch(token, caseSensitive)) {
            if (this.isHidden()) {
                this.show();
            }
            return true;
        }
        if (!this.isHidden()) {
            this.hide();
        }
        return false;
    }


    public MenuSearchFilter getSearchFilter() {
        return searchFilter;
    }

    public CustomMenuItem<V> setSearchFilter(MenuSearchFilter searchFilter) {
        if (nonNull(searchFilter)) {
            this.searchFilter = searchFilter;
        }
        return this;
    }
}
