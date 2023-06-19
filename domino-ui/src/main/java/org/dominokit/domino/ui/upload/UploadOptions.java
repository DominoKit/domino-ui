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

import static org.dominokit.domino.ui.upload.FileUpload.DEFAULT_SUCCESS_CODES;

import elemental2.dom.XMLHttpRequest;
import java.util.List;
import java.util.Optional;
import java.util.function.Supplier;

/** Options for controlling the upload */
public class UploadOptions {

  private String url;
  private XMLHttpRequest xmlHttpRequest;
  private double maxFileSize = Double.MAX_VALUE;
  private Supplier<List<Integer>> successCodesProvider = DEFAULT_SUCCESS_CODES;

  public UploadOptions() {}

  public UploadOptions setXMLHttpRequest(XMLHttpRequest xmlHttpRequest) {
    this.xmlHttpRequest = xmlHttpRequest;
    return this;
  }

  public Optional<XMLHttpRequest> getXmlHttpRequest() {
    return Optional.ofNullable(xmlHttpRequest);
  }

  /** @return the maximum accepted file size */
  public double getMaxFileSize() {
    return maxFileSize;
  }

  public UploadOptions setMaxFileSize(double maxFileSize) {
    this.maxFileSize = maxFileSize;
    return this;
  }

  public String getUrl() {
    return url;
  }

  public UploadOptions setUrl(String url) {
    this.url = url;
    return this;
  }

  /** @return the success codes provider */
  public Supplier<List<Integer>> getSuccessCodesProvider() {
    return successCodesProvider;
  }

  public UploadOptions setSuccessCodesProvider(Supplier<List<Integer>> successCodesProvider) {
    this.successCodesProvider = successCodesProvider;
    return this;
  }
}
