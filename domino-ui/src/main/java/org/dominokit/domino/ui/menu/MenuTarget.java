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

import static org.dominokit.domino.ui.utils.Domino.*;
import static org.dominokit.domino.ui.utils.ElementsFactory.elements;

import elemental2.dom.Element;
import java.util.HashMap;
import java.util.Map;
import org.dominokit.domino.ui.utils.AttachDetachCallback;
import org.dominokit.domino.ui.utils.ComponentMeta;
import org.dominokit.domino.ui.utils.DominoElement;
import org.dominokit.domino.ui.utils.HasMeta;

/**
 * Represents a target for the menu in the UI. This class wraps a target DOM {@link Element} to be
 * used as a menu target in a Domino UI application.
 *
 * <p><b>Usage example:</b>
 *
 * <pre>
 * Element myElement = ... // some DOM element
 * MenuTarget menuTarget = MenuTarget.of(myElement);
 * </pre>
 */
public class MenuTarget implements HasMeta<MenuTarget> {

  private final Element targetElement;
  private AttachDetachCallback targetDetachObserver;
  private AttachDetachCallback targetAttachObserver;
  private final Map<String, ComponentMeta> metaObjects = new HashMap<>();

  /**
   * Factory method to create an instance of {@link MenuTarget} using the given DOM {@link Element}.
   *
   * @param element the target DOM element
   * @return a new instance of {@link MenuTarget}
   */
  public static MenuTarget of(Element element) {
    return new MenuTarget(element);
  }

  /**
   * Constructs a new {@link MenuTarget} for the provided target DOM {@link Element}.
   *
   * @param targetElement the target DOM element
   */
  public MenuTarget(Element targetElement) {
    this.targetElement = targetElement;
  }

  /**
   * Retrieves the wrapped target DOM {@link Element} as a {@link DominoElement}.
   *
   * @return the target {@link DominoElement}
   */
  public DominoElement<Element> getTargetElement() {
    return elements.elementOf(targetElement);
  }

  /**
   * Sets an observer for the target's attach/detach events.
   *
   * @param targetDetachObserver the observer callback
   */
  void setTargetDetachObserver(AttachDetachCallback targetDetachObserver) {
    this.targetDetachObserver = targetDetachObserver;
  }

  /**
   * Retrieves the observer set for the target's attach/detach events.
   *
   * @return the observer callback
   */
  AttachDetachCallback getTargetDetachObserver() {
    return targetDetachObserver;
  }

  /**
   * Sets an observer for the target's attach/detach events.
   *
   * @param targetDetachObserver the observer callback
   */
  void setTargetAttachObserver(AttachDetachCallback targetAttachObserver) {
    this.targetAttachObserver = targetAttachObserver;
  }

  /**
   * Retrieves the observer set for the target's attach/detach events.
   *
   * @return the observer callback
   */
  AttachDetachCallback getTargetAttachObserver() {
    return targetAttachObserver;
  }

  /**
   * {@inheritDoc}
   *
   * <p>Returns a map of meta objects associated with this menu target.
   *
   * @return a map where the key is a string identifier and the value is the associated {@link
   *     ComponentMeta} object.
   */
  @Override
  public Map<String, ComponentMeta> getMetaObjects() {
    return metaObjects;
  }
}
