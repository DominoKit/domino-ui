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

import java.util.List;
import java.util.function.Supplier;

/** Options for controlling the upload */
@Deprecated
public class UploadOptions {
  private String url;
  private final double maxFileSize;
  private final Supplier<List<Integer>> successCodesProvider;

  public UploadOptions(
      String url, double maxFileSize, Supplier<List<Integer>> successCodesProvider) {
    this.url = url;
    this.maxFileSize = maxFileSize;
    this.successCodesProvider = successCodesProvider;
  }

  /** @param url the server url */
  void setUrl(String url) {
    this.url = url;
  }

  /** @return the server url */
  public String getUrl() {
    return url;
  }

  /** @return the maximum accepted file size */
  public double getMaxFileSize() {
    return maxFileSize;
  }

  /** @return the success codes provider */
  public Supplier<List<Integer>> getSuccessCodesProvider() {
    return successCodesProvider;
  }
}
