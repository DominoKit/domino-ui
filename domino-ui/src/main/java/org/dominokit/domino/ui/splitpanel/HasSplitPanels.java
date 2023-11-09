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
package org.dominokit.domino.ui.splitpanel;

/**
 * Represents an object that manages multiple split panels and their resizing behavior.
 *
 * <p>Usage example:
 *
 * <pre>{@code
 * public class ResizableLayout implements HasSplitPanels {
 *
 *     @Override
 *     public void onResizeStart(SplitPanel first, SplitPanel second) {
 *         // Initialization logic when resizing starts
 *     }
 *
 *     @Override
 *     public void resizePanels(SplitPanel first, SplitPanel second, double sizeDiff) {
 *         // Logic to adjust panel sizes
 *     }
 * }
 * }</pre>
 *
 * <p>Any class that implements this interface should manage the behavior of split panels during
 * resizing operations.
 */
public interface HasSplitPanels {

  /**
   * Called when the resizing of panels begins. This method can be used to perform any necessary
   * initialization or setup before the actual resizing takes place.
   *
   * @param first the first split panel involved in the resizing
   * @param second the second split panel involved in the resizing
   */
  void onResizeStart(SplitPanel first, SplitPanel second);

  /**
   * Adjusts the sizes of the provided split panels based on the difference in size specified by
   * {@code sizeDiff}.
   *
   * @param first the first split panel to be resized
   * @param second the second split panel to be resized
   * @param sizeDiff the difference in size to be applied during resizing
   */
  void resizePanels(SplitPanel first, SplitPanel second, double sizeDiff);
}
