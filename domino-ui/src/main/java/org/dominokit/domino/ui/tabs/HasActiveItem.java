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
package org.dominokit.domino.ui.tabs;

/**
 * Represents an entity that can have an active item.
 *
 * <p>This interface ensures that the implementing classes have the capability to maintain and
 * manipulate an active item of a specific type.
 *
 * <p><b>Usage Example:</b>
 *
 * <pre>
 * public class MyTabsPanel implements HasActiveItem<Tab> {
 *
 *     private Tab activeTab;
 *
 *     @Override
 *     public Tab getActiveItem() {
 *         return activeTab;
 *     }
 *
 *     @Override
 *     public void setActiveItem(Tab activeTab) {
 *         this.activeTab = activeTab;
 *     }
 * }
 * </pre>
 *
 * @param <T> the type of the active item
 * @see Tab
 * @see TabsPanel
 */
public interface HasActiveItem<T> {

  /**
   * Returns the currently active item.
   *
   * @return the active item
   */
  T getActiveItem();

  /**
   * Sets the provided item as the active item.
   *
   * @param activeItem the item to be set as active
   */
  void setActiveItem(T activeItem);
}
