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
package org.dominokit.domino.ui.menu;

import static org.dominokit.domino.ui.utils.ElementsFactory.elements;

import elemental2.dom.Element;
import java.util.HashMap;
import java.util.Map;
import org.dominokit.domino.ui.utils.AttachDetachCallback;
import org.dominokit.domino.ui.utils.ComponentMeta;
import org.dominokit.domino.ui.utils.DominoElement;
import org.dominokit.domino.ui.utils.HasMeta;

/** MenuTarget class. */
public class MenuTarget implements HasMeta<MenuTarget> {

  private final Element targetElement;
  private AttachDetachCallback targetDetachObserver;
  private final Map<String, ComponentMeta> metaObjects = new HashMap<>();

  /**
   * of.
   *
   * @param element a {@link elemental2.dom.Element} object
   * @return a {@link org.dominokit.domino.ui.menu.MenuTarget} object
   */
  public static MenuTarget of(Element element) {
    return new MenuTarget(element);
  }

  /**
   * Constructor for MenuTarget.
   *
   * @param targetElement a {@link elemental2.dom.Element} object
   */
  public MenuTarget(Element targetElement) {
    this.targetElement = targetElement;
  }

  /**
   * Getter for the field <code>targetElement</code>.
   *
   * @return a {@link org.dominokit.domino.ui.utils.DominoElement} object
   */
  public DominoElement<Element> getTargetElement() {
    return elements.elementOf(targetElement);
  }

  void setTargetDetachObserver(AttachDetachCallback targetDetachObserver) {
    this.targetDetachObserver = targetDetachObserver;
  }

  AttachDetachCallback getTargetDetachObserver() {
    return targetDetachObserver;
  }

  /** {@inheritDoc} */
  @Override
  public Map<String, ComponentMeta> getMetaObjects() {
    return metaObjects;
  }
}
