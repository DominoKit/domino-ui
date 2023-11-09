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

/**
 * Represents a dialog's dimension by combining its width and height attributes.
 *
 * <p>Implementing this interface allows a dialog to have both width and height styles, enabling
 * consistent sizing across different dialogs.
 *
 * <p><b>Usage:</b>
 *
 * <pre>
 * class CustomDialog implements IsDialogSize {
 *     // Implement methods...
 * }
 *
 * CustomDialog dialog = new CustomDialog();
 * </pre>
 *
 * @see IsDialogWidth
 * @see IsDialogHeight
 */
public interface IsDialogSize extends IsDialogWidth, IsDialogHeight {}
