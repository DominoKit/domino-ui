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
package org.dominokit.domino.ui.config;

import java.util.function.Supplier;
import org.dominokit.domino.ui.icons.Icon;
import org.dominokit.domino.ui.icons.lib.Icons;
import org.dominokit.domino.ui.upload.*;

/** UploadConfig interface. */
public interface UploadConfig extends ComponentConfig {

  /**
   * getDefaultUploadIcon.
   *
   * @return a {@link java.util.function.Supplier} object
   */
  default Supplier<Icon<?>> getDefaultUploadIcon() {
    return Icons::upload;
  }

  /**
   * getDefaultRemoveIcon.
   *
   * @return a {@link java.util.function.Supplier} object
   */
  default Supplier<Icon<?>> getDefaultRemoveIcon() {
    return Icons::trash_can;
  }

  /**
   * getDefaultCancelIcon.
   *
   * @return a {@link java.util.function.Supplier} object
   */
  default Supplier<Icon<?>> getDefaultCancelIcon() {
    return Icons::cancel;
  }

  /**
   * getFilePreviewFactory.
   *
   * @return a {@link org.dominokit.domino.ui.upload.FilePreviewFactory} object
   */
  default FilePreviewFactory getFilePreviewFactory() {
    return new FilePreviewFactory() {
      @Override
      public IsFilePreview<?> forFile(FileItem fileItem, FileUpload fileUpload) {
        return new DefaultFilePreview(fileItem, fileUpload);
      }
    };
  }

  /**
   * getDefaultFilePreviewContainer.
   *
   * @return a {@link java.util.function.Supplier} object
   */
  default Supplier<FilePreviewContainer<?, ?>> getDefaultFilePreviewContainer() {
    return DefaultFilePreviewContainer::new;
  }
}
