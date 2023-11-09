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
 * Represents an object that has a measurable size.
 *
 * <p>Usage example:
 *
 * <pre>
 * public class Panel implements HasSize {
 *     private double width;
 *
 *     @Override
 *     public double getSize() {
 *         return width;
 *     }
 * }
 * </pre>
 *
 * <p>Any class that implements this interface should provide the logic to return its size.
 */
public interface HasSize {

  /**
   * Retrieves the size of the object.
   *
   * @return the size as a double.
   */
  double getSize();
}
