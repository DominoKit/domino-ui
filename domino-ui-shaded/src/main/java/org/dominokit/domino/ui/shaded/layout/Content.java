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
package org.dominokit.domino.ui.shaded.layout;

import static org.jboss.elemento.Elements.div;
import static org.jboss.elemento.Elements.section;

import elemental2.dom.HTMLDivElement;
import elemental2.dom.HTMLElement;
import org.dominokit.domino.ui.shaded.utils.BaseDominoElement;
import org.dominokit.domino.ui.shaded.utils.DominoElement;

/** a component that represent the Content part of the {@link Layout} */
@Deprecated
public class Content extends BaseDominoElement<HTMLElement, Content> {

  HTMLDivElement contentContainer;
  HTMLElement section;

  /** */
  public Content() {
    contentContainer = DominoElement.of(div()).css(LayoutStyles.CONTENT_PANEL).element();
    section = DominoElement.of(section()).css(LayoutStyles.CONTENT).add(contentContainer).element();

    init(this);
  }

  /** @return new Content instance */
  public static Content create() {
    return new Content();
  }

  /** {@inheritDoc} */
  @Override
  public HTMLElement element() {
    return section;
  }
}
