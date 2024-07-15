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

import elemental2.dom.DomGlobal;
import elemental2.dom.HTMLDivElement;
import org.dominokit.domino.ui.grid.Column;
import org.dominokit.domino.ui.grid.Row;
import org.dominokit.domino.ui.utils.BaseDominoElement;
import org.dominokit.domino.ui.utils.ChildHandler;

/**
 * Represents a container for file previews in the default file upload component.
 *
 * <p>This container is used to organize and display file previews for uploaded files.
 *
 * @see BaseDominoElement
 */
public class DefaultFilePreviewContainer
    extends BaseDominoElement<HTMLDivElement, DefaultFilePreviewContainer>
    implements FilePreviewContainer<HTMLDivElement, DefaultFilePreviewContainer>, FileUploadStyles {

  /** The root row element that holds the file previews. */
  private final Row rootRow;

  /** Constructs a new {@code DefaultFilePreviewContainer}. */
  public DefaultFilePreviewContainer() {
    rootRow = Row.create().addCss(dui_gap_2).addCss(dui_file_preview_container);
    init(this);
  }

  /**
   * Appends a file preview to the container.
   *
   * @param fileItem The file item representing the file to be previewed.
   * @return This {@code DefaultFilePreviewContainer} instance for method chaining.
   */
  @Override
  public DefaultFilePreviewContainer appendChild(FileItem fileItem) {
    rootRow.appendChild(
        Column.span2()
            .apply(
                self -> {
                  self.appendChild(fileItem);
                  fileItem.onDetached(
                      mutationRecord -> {
                        DomGlobal.console.info("delete columns too ------------------");
                        self.remove();
                      });
                }));
    return this;
  }

  /**
   * Configures the container with a row.
   *
   * @param handler The child handler to configure the container with a row.
   * @return This {@code DefaultFilePreviewContainer} instance for method chaining.
   */
  public DefaultFilePreviewContainer withRow(
      ChildHandler<DefaultFilePreviewContainer, Row> handler) {
    handler.apply(this, rootRow);
    return this;
  }

  /**
   * Retrieves the HTML element of this container.
   *
   * @return The {@link HTMLDivElement} representing this container.
   */
  @Override
  public HTMLDivElement element() {
    return rootRow.element();
  }
}
