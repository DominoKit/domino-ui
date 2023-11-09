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
package org.dominokit.domino.ui.i18n;

/**
 * The {@code DialogLabels} interface defines methods for labels used in dialogs and confirmation
 * dialogs. It extends the {@link Labels} interface, providing default implementations for common
 * dialog labels.
 *
 * <p>Developers can implement this interface to provide custom labels for dialogs and confirmation
 * dialogs.
 *
 * @see Labels
 */
public interface DialogLabels extends Labels {

  /**
   * Gets the label for rejecting a confirmation dialog.
   *
   * @return The label for rejecting a confirmation dialog.
   */
  default String dialogConfirmationReject() {
    return "No";
  }

  /**
   * Gets the label for accepting a confirmation dialog.
   *
   * @return The label for accepting a confirmation dialog.
   */
  default String dialogConfirmationAccept() {
    return "Yes";
  }

  /**
   * Gets the label for confirming an action in a dialog.
   *
   * @return The label for confirming an action in a dialog.
   */
  default String dialogOk() {
    return "Ok";
  }
}
