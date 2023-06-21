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
package org.dominokit.domino.ui.lists;

import org.dominokit.domino.ui.style.CssClass;

/**
 * Default CSS classes for {@link org.dominokit.domino.ui.lists.ListGroup} and {@link
 * org.dominokit.domino.ui.lists.ListItem}
 *
 * @author vegegoku
 * @version $Id: $Id
 */
public interface ListStyles {
  /** Constant <code>dui_list_group</code> */
  CssClass dui_list_group = () -> "dui-list-group";
  /** Constant <code>dui_list_group_bordered</code> */
  CssClass dui_list_group_bordered = () -> "dui-list-group-bordered";
  /** Constant <code>dui_list_group_item</code> */
  CssClass dui_list_group_item = () -> "dui-list-group-item";
}
