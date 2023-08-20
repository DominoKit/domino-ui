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

  /** Constructor for UploadOptions. */
  public UploadOptions() {}

  /**
   * setXMLHttpRequest.
   *
   * @param xmlHttpRequest a {@link elemental2.dom.XMLHttpRequest} object
   * @return a {@link org.dominokit.domino.ui.upload.UploadOptions} object
   */
  public UploadOptions setXMLHttpRequest(XMLHttpRequest xmlHttpRequest) {
    this.xmlHttpRequest = xmlHttpRequest;
    return this;
  }

  /**
   * Getter for the field <code>xmlHttpRequest</code>.
   *
   * @return a {@link java.util.Optional} object
   */
  public Optional<XMLHttpRequest> getXmlHttpRequest() {
    return Optional.ofNullable(xmlHttpRequest);
  }

  /** @return the maximum accepted file size */
  /**
   * Getter for the field <code>maxFileSize</code>.
   *
   * @return a double
   */
  public double getMaxFileSize() {
    return maxFileSize;
  }

  /**
   * Setter for the field <code>maxFileSize</code>.
   *
   * @param maxFileSize a double
   * @return a {@link org.dominokit.domino.ui.upload.UploadOptions} object
   */
  public UploadOptions setMaxFileSize(double maxFileSize) {
    this.maxFileSize = maxFileSize;
    return this;
  }

  /**
   * Getter for the field <code>url</code>.
   *
   * @return a {@link java.lang.String} object
   */
  public String getUrl() {
    return url;
  }

  /**
   * Setter for the field <code>url</code>.
   *
   * @param url a {@link java.lang.String} object
   * @return a {@link org.dominokit.domino.ui.upload.UploadOptions} object
   */
  public UploadOptions setUrl(String url) {
    this.url = url;
    return this;
  }

  /** @return the success codes provider */
  /**
   * Getter for the field <code>successCodesProvider</code>.
   *
   * @return a {@link java.util.function.Supplier} object
   */
  public Supplier<List<Integer>> getSuccessCodesProvider() {
    return successCodesProvider;
  }

  /**
   * Setter for the field <code>successCodesProvider</code>.
   *
   * @param successCodesProvider a {@link java.util.function.Supplier} object
   * @return a {@link org.dominokit.domino.ui.upload.UploadOptions} object
   */
  public UploadOptions setSuccessCodesProvider(Supplier<List<Integer>> successCodesProvider) {
    this.successCodesProvider = successCodesProvider;
    return this;
  }
}
