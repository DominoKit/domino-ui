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

import static org.jboss.elemento.Elements.div;
import static org.jboss.elemento.Elements.img;

import elemental2.dom.*;
import org.dominokit.domino.ui.icons.Icon;
import org.dominokit.domino.ui.icons.Icons;
import org.dominokit.domino.ui.style.Color;
import org.dominokit.domino.ui.style.Styles;
import org.dominokit.domino.ui.utils.BaseDominoElement;
import org.dominokit.domino.ui.utils.DominoElement;

/**
 * A component for file item image
 *
 * @see FileItem
 */
public class FileImage extends BaseDominoElement<HTMLDivElement, FileImage> {

  private DominoElement<HTMLDivElement> fileImageContainer;

  public FileImage() {
    initFileContainer();
    Icon icon = Icons.EDITOR_ICONS.insert_drive_file().setColor(Color.GREY);
    icon.addCss("md-inactive");
    icon.style().setCursor("default").setFontSize("100px").setWidth("100%").setTextAlign("center");
    setImage(icon.element());
    init(this);
  }

  public FileImage(File file) {
    initFileContainer();
    DominoElement<HTMLImageElement> image = DominoElement.of(img()).css(Styles.img_responsive);
    image.element().alt = file.name;
    image
        .style()
        .setMaxHeight("100%")
        .setMaxWidth("100%")
        .setMarginRight("auto")
        .setMarginLeft("auto")
        .setFlex("1 1");
    FileReader fileReader = new FileReader();
    fileReader.addEventListener("load", evt -> image.element().src = fileReader.result.asString());
    fileReader.readAsDataURL(file);
    setImage(image.element());
    init(this);
  }

  private void initFileContainer() {
    fileImageContainer = DominoElement.of(div());
    fileImageContainer.style().setHeight("200px").setAlignItems("center").setDisplay("flex");
  }

  /**
   * @param file the image file
   * @return new instance
   */
  public static FileImage createImageFile(File file) {
    return new FileImage(file);
  }

  /** @return new instance with default image for non-image files */
  public static FileImage createDefault() {
    return new FileImage();
  }

  /** {@inheritDoc} */
  @Override
  public HTMLDivElement element() {
    return fileImageContainer.element();
  }

  /**
   * Sets the image for this file
   *
   * @param image the image element
   * @return same instance
   */
  public FileImage setImage(HTMLElement image) {
    fileImageContainer.appendChild(image);
    return this;
  }
}
