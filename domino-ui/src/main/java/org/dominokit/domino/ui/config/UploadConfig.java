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

/**
 * Implementations of this interface can be used to configure defaults for {@link FileUpload}
 * component
 */
public interface UploadConfig extends ComponentConfig {

  /**
   * Use this method to define the default upload icon
   *
   * <p>Defaults to : {@code upload}
   *
   * @return a {@code Supplier<Icon<?>>}
   */
  default Supplier<Icon<?>> getDefaultUploadIcon() {
    return Icons::upload;
  }

  /**
   * Use this method to define the default remove file item icon
   *
   * <p>Defaults to : {@code trash_can}
   *
   * @return a {@code Supplier<Icon<?>>}
   */
  default Supplier<Icon<?>> getDefaultRemoveIcon() {
    return Icons::trash_can;
  }

  /**
   * Use this method to define the default cancel upload icon
   *
   * <p>Defaults to : {@code cancel}
   *
   * @return a {@code Supplier<Icon<?>>}
   */
  default Supplier<Icon<?>> getDefaultCancelIcon() {
    return Icons::cancel;
  }

  /**
   * Use this method to define the default implementation for {@link FilePreviewFactory}
   *
   * <p>Defaults to : {@code DefaultFilePreview}
   *
   * @return a {@code FilePreviewFactory}
   */
  default FilePreviewFactory getFilePreviewFactory() {
    return DefaultFilePreview::new;
  }

  /**
   * Use this method to define the default container that will be used to host file previews
   * elements
   *
   * <p>Defaults to : {@code DefaultFilePreviewContainer}
   *
   * @return a {@code Supplier<FilePreviewContainer<?, ?>>}
   */
  default Supplier<FilePreviewContainer<?, ?>> getDefaultFilePreviewContainer() {
    return DefaultFilePreviewContainer::new;
  }

  /**
   * when the user uploaded a set of files that are less or equals the max uploads allowed, and they
   * are already uploaded, should we allow him to upload a new set of files that are in total with
   * the previous batch could overflow the max allowed upload limit.
   *
   * @return boolean default true
   */
  default boolean isMaxUploadsOverflowAllowed() {
    return true;
  }
}
