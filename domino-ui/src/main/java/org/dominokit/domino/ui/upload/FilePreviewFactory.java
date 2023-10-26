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

/**
 * The {@code FilePreviewFactory} interface represents a factory for creating file preview
 * components associated with a file upload. Implementations of this interface provide the ability
 * to create custom file preview components based on a {@link FileItem} and a {@link FileUpload}
 * instance.
 */
public interface FilePreviewFactory {

  /** An array of units used for formatting file sizes. */
  String[] UNITS = {"KB", "MB", "GB", "TB"};

  /**
   * Creates a file preview component for the specified {@link FileItem} and {@link FileUpload}.
   *
   * @param fileItem The {@link FileItem} for which the preview is to be created.
   * @param fileUpload The {@link FileUpload} instance associated with the file item.
   * @return An implementation of {@link IsFilePreview} representing the file preview component.
   */
  IsFilePreview<?> forFile(FileItem fileItem, FileUpload fileUpload);
}
