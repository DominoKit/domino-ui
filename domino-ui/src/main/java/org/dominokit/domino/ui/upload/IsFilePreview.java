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

import elemental2.dom.HTMLElement;
import org.dominokit.domino.ui.IsElement;
import org.dominokit.domino.ui.utils.ChildHandler;

/**
 * IsFilePreview interface.
 *
 * @author vegegoku
 * @version $Id: $Id
 */
public interface IsFilePreview<T> extends IsElement<HTMLElement> {
  /**
   * onUploadFailed.
   *
   * @param error a {@link java.lang.String} object
   */
  void onUploadFailed(String error);

  /** onUploadSuccess. */
  void onUploadSuccess();

  /** onUploadCompleted. */
  void onUploadCompleted();

  /** onUploadCanceled. */
  void onUploadCanceled();

  /**
   * onUploadProgress.
   *
   * @param progress a double
   */
  void onUploadProgress(double progress);

  /** onReset. */
  void onReset();

  /** onUploadStarted. */
  void onUploadStarted();

  IsFilePreview<T> withComponent(ChildHandler<IsFilePreview<T>, T> handler);
}
