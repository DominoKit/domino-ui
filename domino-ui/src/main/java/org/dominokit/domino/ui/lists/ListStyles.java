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
 * The {@code ListStyles} interface provides CSS classes that can be used to style list elements.
 * These classes define various styles for list groups and list items.
 */
public interface ListStyles {

  /** A CSS class for styling a list group. */
  CssClass dui_list_group = () -> "dui-list-group";

  /** A CSS class for styling a bordered list group. */
  CssClass dui_list_group_bordered = () -> "dui-list-group-bordered";

  /** A CSS class for styling a list group item. */
  CssClass dui_list_group_item = () -> "dui-list-group-item";
}
