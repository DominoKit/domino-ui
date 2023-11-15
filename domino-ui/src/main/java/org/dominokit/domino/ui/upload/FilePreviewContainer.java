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

/**
 * The {@code FilePreviewContainer} interface represents a container that holds and manages file
 * previews for file upload components. It is designed to allow appending child file items to the
 * container, providing a way to display and organize uploaded files or files ready for upload
 * within a UI component.
 *
 * @param <E> The type of the HTML element representing the container.
 * @param <T> The type of the implementing class, typically used for method chaining.
 */
public interface FilePreviewContainer<E extends HTMLElement, T extends FilePreviewContainer<E, T>>
    extends IsElement<E> {

  /**
   * Appends a child {@link FileItem} to the file preview container. This method is used to add a
   * file item to the container, allowing it to be displayed within the UI component.
   *
   * @param fileItem The {@link FileItem} to append to the container.
   * @return A reference to the container instance for method chaining.
   */
  T appendChild(FileItem fileItem);
}
