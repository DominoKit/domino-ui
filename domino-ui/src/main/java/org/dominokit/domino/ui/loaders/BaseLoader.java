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
import org.dominokit.domino.ui.i18n.LoaderLabels;
import org.dominokit.domino.ui.utils.BaseDominoElement;
import org.dominokit.domino.ui.utils.DominoUIConfig;

/**
 * An abstract base class for implementing loader components. Loaders are visual elements that
 * indicate the progress of an operation or task.
 *
 * <p>Subclasses of this class should provide custom loader implementations.
 *
 * @param <T> The concrete loader type extending {@code BaseLoader}.
 * @see BaseDominoElement
 */
public abstract class BaseLoader<T extends BaseLoader<T>>
    extends BaseDominoElement<HTMLDivElement, T>
    implements IsLoader, IsElement<HTMLDivElement>, LoaderStyles {

  /** The labels used for loader text, retrieved from the DominoUIConfig. */
  protected final LoaderLabels labels = DominoUIConfig.CONFIG.getDominoUILabels();

  /** The HTMLDivElement used for displaying loading text. */
  protected HTMLDivElement loadingText =
      div().addCss(dui_loader, wait_me_text).textContent(labels.loading()).element();

  /**
   * Gets the HTMLDivElement element associated with this loader.
   *
   * @return The HTMLDivElement element of the loader.
   */
  @Override
  public HTMLDivElement getElement() {
    return element();
  }
}
