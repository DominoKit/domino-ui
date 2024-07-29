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
 * The {@code UploadLabels} interface provides labels and messages for file upload components.
 *
 * <p>Usage Example:
 *
 * <pre><code>
 * UploadButton uploadButton = UploadButton.create();
 * uploadButton.setSuccessMessage(uploadLabels.getDefaultUploadSuccessMessage());
 * uploadButton.setCanceledMessage(uploadLabels.getDefaultUploadCanceledMessage());
 * </code></pre>
 *
 * @see Labels
 */
public interface UploadLabels extends Labels {

  /**
   * Gets the default success message for a file upload completion.
   *
   * @return The default success message.
   */
  default String getDefaultUploadSuccessMessage() {
    return "Upload completed.";
  }

  /**
   * Gets the default message for a canceled file upload.
   *
   * @return The default canceled message.
   */
  default String getDefaultUploadCanceledMessage() {
    return "Upload canceled.";
  }

  /**
   * Gets an error message for exceeding the maximum allowed uploads.
   *
   * @param maxFiles The maximum allowed uploads.
   * @param current The current number of uploads.
   * @return The error message for exceeding the maximum allowed uploads.
   */
  default String getMaxFileErrorMessage(int maxFiles, int current, int added, int ignored) {
    return "The maximum allowed uploads is : "
        + maxFiles
        + ", You have : "
        + current
        + ", added : "
        + added
        + ", ignored : "
        + ignored;
  }
}
