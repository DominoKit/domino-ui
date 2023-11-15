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

import static org.dominokit.domino.ui.utils.Domino.*;

import elemental2.dom.FormData;
import elemental2.dom.XMLHttpRequest;

/**
 * The {@code UploadRequestSender} interface defines a contract for sending upload requests using an
 * XML HTTP request (XHR) object with associated form data.
 */
public interface UploadRequestSender {

  /**
   * Called when the XHR request is ready to be sent with the provided form data.
   *
   * @param request The {@link XMLHttpRequest} object used to send the request.
   * @param formData The {@link FormData} object containing the data to be sent in the request.
   */
  void onReady(XMLHttpRequest request, FormData formData);
}
