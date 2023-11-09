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
package org.dominokit.domino.ui.dialogs;

import org.dominokit.domino.ui.style.CssClass;

/**
 * Represents an object that can provide a height style for dialogs. Implementing classes can use
 * this interface to define specific height styles.
 *
 * <p><b>Usage:</b>
 *
 * <pre>
 * public class MyDialogHeight implements IsDialogHeight {
 *     @Override
 *     public CssClass getHeightStyle() {
 *         return CssClass.of("my-dialog-height-class");
 *     }
 * }
 *
 * IsDialogHeight myHeight = new MyDialogHeight();
 * CssClass css = myHeight.getHeightStyle();
 * </pre>
 *
 * @see CssClass
 */
public interface IsDialogHeight {

  /**
   * Retrieves the height style as a {@link CssClass}.
   *
   * @return the {@link CssClass} representing the height style
   */
  CssClass getHeightStyle();
}
