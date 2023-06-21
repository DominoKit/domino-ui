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
package org.dominokit.domino.ui.upload;

import org.dominokit.domino.ui.style.CssClass;

/**
 * FileUploadStyles interface.
 *
 * @author vegegoku
 * @version $Id: $Id
 */
public interface FileUploadStyles {
  /** Constant <code>dui_file_upload</code> */
  CssClass dui_file_upload = () -> "dui-file-upload";
  /** Constant <code>dui_file_upload_input</code> */
  CssClass dui_file_upload_input = () -> "dui-file-upload-input";
  /** Constant <code>dui_file_upload_messages</code> */
  CssClass dui_file_upload_messages = () -> "dui-file-upload-messages";
  /** Constant <code>dui_file_preview</code> */
  CssClass dui_file_preview = () -> "dui-file-preview";
  /** Constant <code>dui_file_preview_container</code> */
  CssClass dui_file_preview_container = () -> "dui-file-preview-container";
  /** Constant <code>dui_file_upload_decoration</code> */
  CssClass dui_file_upload_decoration = () -> "dui-file-upload-decoration";
}
