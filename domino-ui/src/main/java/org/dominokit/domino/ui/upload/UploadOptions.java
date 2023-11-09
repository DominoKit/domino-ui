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

/**
 * The {@code UploadOptions} class represents the configuration options for file uploads. It
 * provides settings such as the target URL for file uploads, the maximum file size allowed, and the
 * custom XML HTTP request object to use for uploads.
 */
public class UploadOptions {

  private String url;
  private XMLHttpRequest xmlHttpRequest;
  private double maxFileSize = Double.MAX_VALUE;
  private Supplier<List<Integer>> successCodesProvider = DEFAULT_SUCCESS_CODES;

  /** Constructs a new {@code UploadOptions} instance with default settings. */
  public UploadOptions() {}

  /**
   * Sets the custom XML HTTP request object to be used for file uploads.
   *
   * @param xmlHttpRequest The custom {@link XMLHttpRequest} object.
   * @return This {@code UploadOptions} instance for method chaining.
   */
  public UploadOptions setXMLHttpRequest(XMLHttpRequest xmlHttpRequest) {
    this.xmlHttpRequest = xmlHttpRequest;
    return this;
  }

  /**
   * Retrieves the custom XML HTTP request object configured for file uploads.
   *
   * @return An optional {@link XMLHttpRequest} object, or empty if not set.
   */
  public Optional<XMLHttpRequest> getXmlHttpRequest() {
    return Optional.ofNullable(xmlHttpRequest);
  }

  /**
   * Retrieves the maximum allowed file size for uploads.
   *
   * @return The maximum file size in bytes.
   */
  public double getMaxFileSize() {
    return maxFileSize;
  }

  /**
   * Sets the maximum allowed file size for uploads.
   *
   * @param maxFileSize The maximum file size in bytes.
   * @return This {@code UploadOptions} instance for method chaining.
   */
  public UploadOptions setMaxFileSize(double maxFileSize) {
    this.maxFileSize = maxFileSize;
    return this;
  }

  /**
   * Retrieves the target URL for file uploads.
   *
   * @return The target URL for uploads.
   */
  public String getUrl() {
    return url;
  }

  /**
   * Sets the target URL for file uploads.
   *
   * @param url The target URL for uploads.
   * @return This {@code UploadOptions} instance for method chaining.
   */
  public UploadOptions setUrl(String url) {
    this.url = url;
    return this;
  }

  /**
   * Retrieves the supplier for the list of success status codes for uploads.
   *
   * @return A {@link Supplier} providing a list of success status codes.
   */
  public Supplier<List<Integer>> getSuccessCodesProvider() {
    return successCodesProvider;
  }

  /**
   * Sets the supplier for the list of success status codes for uploads.
   *
   * @param successCodesProvider A {@link Supplier} providing a list of success status codes.
   * @return This {@code UploadOptions} instance for method chaining.
   */
  public UploadOptions setSuccessCodesProvider(Supplier<List<Integer>> successCodesProvider) {
    this.successCodesProvider = successCodesProvider;
    return this;
  }
}
