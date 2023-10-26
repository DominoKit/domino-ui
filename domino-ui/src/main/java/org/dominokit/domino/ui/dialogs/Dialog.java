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
 * A concrete implementation of {@link AbstractDialog} to represent a generic dialog. This class
 * provides an easy way to create and manage a dialog window.
 *
 * <p><b>Usage:</b>
 *
 * <pre>
 * Dialog dialog = Dialog.create();
 * dialog.open();
 * </pre>
 *
 * @see AbstractDialog
 */
public class Dialog extends AbstractDialog<Dialog> {

  /** Default constructor for the {@link Dialog}. */
  public Dialog() {}

  /**
   * Creates a new instance of {@link Dialog}.
   *
   * @return a new {@link Dialog} instance
   */
  public static Dialog create() {
    return new Dialog();
  }
}
