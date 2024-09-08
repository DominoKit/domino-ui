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
package org.dominokit.domino.ui.shaded.modals;

import elemental2.dom.Node;

/** a component to show a pop-up with the ability to block the content behind it. */
@Deprecated
public class ModalDialog extends BaseModal<ModalDialog> {

  public ModalDialog(String title) {
    super(title);
    init(this);
  }

  public ModalDialog() {
    init(this);
  }

  public static ModalDialog create(String title) {
    return new ModalDialog(title);
  }

  public static ModalDialog create() {
    return new ModalDialog();
  }

  public static ModalDialog createPickerModal(String title, Node content) {
    return ModalDialog.create(title)
        .addCss(ModalStyles.PICKER_MODAL)
        .small()
        .setAutoClose(true)
        .appendChild(content);
  }
}
