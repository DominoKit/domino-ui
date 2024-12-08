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
package org.dominokit.domino.ui.loaders;

import static org.dominokit.domino.ui.utils.Domino.*;

import elemental2.dom.HTMLDivElement;
import org.dominokit.domino.ui.IsElement;
import org.dominokit.domino.ui.elements.DivElement;
import org.dominokit.domino.ui.utils.DominoElement;

/**
 * A loader component that displays an orbit animation.
 *
 * <p>The OrbitLoader displays an animation consisting of two orbiting elements. It is often used to
 * indicate loading or processing.
 *
 * <p>Example usage:
 *
 * <pre>
 * OrbitLoader loader = OrbitLoader.create();
 * loader.setLoadingText("Loading...");
 * // Add the loader to a container element
 * container.appendChild(loader.element());
 * </pre>
 */
public class OrbitLoader extends BaseLoader<OrbitLoader> implements IsElement<HTMLDivElement> {

  private final DivElement progress1 =
      div().addCss(wait_me_progress_elem_1).appendChild(div().addCss(dui_loader_darkest));
  private final DivElement progress2 =
      div().addCss(wait_me_progress_elem_2).appendChild(div().addCss(dui_loader_darkest));

  private final DivElement loader =
      div().addCss(wait_me_progress, orbit).appendChild(progress1).appendChild(progress2);

  private final DivElement content =
      div()
          .addCss(wait_me_content, dui_vertical_center)
          .appendChild(loader)
          .appendChild(loadingText);

  private final DivElement element =
      div().addCss(wait_me).style("background: var(--dui-loader-background);").appendChild(content);

  /** Initializes a new instance of the {@code OrbitLoader} class. */
  public OrbitLoader() {
    init(this);
  }

  /**
   * Creates a new instance of the {@code OrbitLoader} class.
   *
   * @return A new {@code OrbitLoader} instance.
   */
  public static OrbitLoader create() {
    return new OrbitLoader();
  }

  /**
   * Sets the loading text to be displayed by the loader.
   *
   * @param text The text to display as loading text.
   */
  @Override
  public void setLoadingText(String text) {
    loadingText.textContent = text;
  }

  /**
   * Sets the size of the loader.
   *
   * @param width The width of the loader.
   * @param height The height of the loader.
   */
  @Override
  public void setSize(String width, String height) {
    onAttached((e, mutationRecord) -> loader.setWidth(width).setHeight(height));
  }

  /** Removes the loading text from the loader. */
  @Override
  public void removeLoadingText() {
    onAttached((e, mutationRecord) -> loadingText.remove());
  }

  /**
   * Gets the content element of the loader.
   *
   * @return A {@code DominoElement} representing the content element.
   */
  @Override
  public DominoElement<HTMLDivElement> getContentElement() {
    return content.toDominoElement();
  }

  /**
   * Gets the HTMLDivElement element associated with this loader.
   *
   * @return The HTMLDivElement element of the loader.
   */
  @Override
  public HTMLDivElement element() {
    return element.element();
  }
}
