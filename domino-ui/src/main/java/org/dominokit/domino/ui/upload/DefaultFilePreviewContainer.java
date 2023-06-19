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

import elemental2.dom.HTMLDivElement;
import org.dominokit.domino.ui.grid.Row;
import org.dominokit.domino.ui.utils.BaseDominoElement;

public class DefaultFilePreviewContainer
    extends BaseDominoElement<HTMLDivElement, DefaultFilePreviewContainer>
    implements FilePreviewContainer<HTMLDivElement, DefaultFilePreviewContainer>, FileUploadStyles {

  private final Row rootRow;

  public DefaultFilePreviewContainer() {
    rootRow = Row.create().addCss(dui_gap_2).addCss(dui_file_preview_container);
    init(this);
  }

  @Override
  public DefaultFilePreviewContainer appendChild(FileItem fileItem) {
    rootRow.span2(fileItem);
    return this;
  }

  @Override
  public HTMLDivElement element() {
    return rootRow.element();
  }
}
