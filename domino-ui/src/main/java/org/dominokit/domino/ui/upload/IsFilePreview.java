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

import elemental2.dom.HTMLElement;
import org.dominokit.domino.ui.IsElement;
import org.dominokit.domino.ui.utils.ChildHandler;

/**
 * The {@code IsFilePreview} interface represents a file preview component for use in file uploads.
 * Implementations of this interface define the behavior and appearance of file previews associated
 * with individual files in a file upload component.
 *
 * @param <T> The type of the underlying component used to render the file preview.
 */
public interface IsFilePreview<T> extends IsElement<HTMLElement> {

  /**
   * Handles the event when a file upload fails.
   *
   * @param error The error message associated with the failed upload.
   */
  void onUploadFailed(String error);

  /** Handles the event when a file upload is successfully completed. */
  void onUploadSuccess();

  /** Handles the event when a file upload is completed (whether successful or not). */
  void onUploadCompleted();

  /** Handles the event when a file upload is canceled. */
  void onUploadCanceled();

  /**
   * Handles the event when a file upload progress is updated.
   *
   * @param progress The progress value (usually a percentage) of the file upload.
   */
  void onUploadProgress(double progress);

  /** Handles the event when the file preview component is reset to its initial state. */
  void onReset();

  /** Handles the event when a file upload is started. */
  void onUploadStarted();

  /**
   * Configures the file preview with a child component using the provided handler.
   *
   * @param handler The handler to configure the file preview with a child component.
   * @return The file preview instance with the configured child component.
   */
  IsFilePreview<T> withComponent(ChildHandler<IsFilePreview<T>, T> handler);
}
