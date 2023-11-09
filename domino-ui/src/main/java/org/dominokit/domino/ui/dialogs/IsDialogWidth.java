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
 * Represents the width styling of a dialog.
 *
 * <p>By implementing this interface, a dialog can define its width styling. This allows for
 * consistent width management across different dialog implementations.
 *
 * <p><b>Usage:</b>
 *
 * <pre>
 * class CustomDialog implements IsDialogWidth {
 *
 *     @Override
 *     public CssClass getWidthStyle() {
 *         return CssClass.of("custom-dialog-width");
 *     }
 * }
 *
 * CustomDialog dialog = new CustomDialog();
 * CssClass widthStyle = dialog.getWidthStyle();
 * </pre>
 *
 * @see CssClass
 */
public interface IsDialogWidth {

  /**
   * Retrieves the width style of the dialog.
   *
   * @return The {@link CssClass} representing the width style of the dialog.
   */
  CssClass getWidthStyle();
}
