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
package org.dominokit.domino.ui.layout;

import elemental2.dom.HTMLElement;
import elemental2.dom.Node;
import org.dominokit.domino.ui.IsDominoElement;
import org.dominokit.domino.ui.elements.DivElement;
import org.dominokit.domino.ui.elements.HeadingElement;
import org.dominokit.domino.ui.elements.SmallElement;
import org.dominokit.domino.ui.elements.SpanElement;
import org.dominokit.domino.ui.utils.ChildHandler;

/** Public contract for nav-like components with a title, description, and body. */
public interface IsNavBar<T extends IsDominoElement<HTMLElement, T>>
    extends IsDominoElement<HTMLElement, T> {

  T setTitle(String title);

  T setTitle(Node title);

  T setResponsiveLayout(boolean responsive);

  T setDescription(String description);

  T withTitle(ChildHandler<T, HeadingElement> handler);

  T withDescription(ChildHandler<T, SmallElement> handler);

  T withTitleTextElement(ChildHandler<T, SpanElement> handler);

  HeadingElement getTitleElement();

  SmallElement getDescriptionElement();

  String getTitle();

  SpanElement getTitleTextElement();

  String getDescription();

  T withBody(ChildHandler<T, DivElement> handler);

  DivElement getBody();
}
