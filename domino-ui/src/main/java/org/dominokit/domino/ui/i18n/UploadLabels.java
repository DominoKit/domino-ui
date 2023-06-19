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

public interface UploadLabels extends Labels {

  default String getDefaultUploadSuccessMessage() {
    return "Upload completed.";
  }

  default String getDefaultUploadCanceledMessage() {
    return "Upload canceled.";
  }

  default String getMaxFileErrorMessage(int maxFiles, int current) {
    return "The maximum allowed uploads is : " + maxFiles + ", You have " + current;
  }
}
