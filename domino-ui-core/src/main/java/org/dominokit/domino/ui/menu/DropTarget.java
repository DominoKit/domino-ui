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

import static java.util.Objects.isNull;
import static org.dominokit.domino.ui.utils.ElementsFactory.elements;

import elemental2.dom.Element;
import java.util.HashMap;
import java.util.Map;
import org.dominokit.domino.ui.utils.ComponentMeta;
import org.dominokit.domino.ui.utils.DominoElement;
import org.dominokit.domino.ui.utils.HasMeta;
import org.dominokit.domino.ui.utils.MutationObserverCallback;

/**
 * Represents a target for the menu in the UI. This class wraps a target DOM {@link Element} to be
 * used as a drop target in a Domino UI application.
 *
 * <p><b>Usage example:</b>
 *
 * <pre>
 * Element myElement = ... // some DOM element
 * DropTarget menuTarget = DropTarget.of(myElement);
 * </pre>
 */
public class DropTarget implements HasMeta<DropTarget> {

  private DominoElement<Element> targetElement;
  private MutationObserverCallback targetDetachObserver;
  private MutationObserverCallback targetAttachObserver;
  private Map<String, ComponentMeta> metaObjects;

  /**
   * Factory method to create an instance of {@link DropTarget} using the given DOM {@link Element}.
   *
   * @param element the target DOM element
   * @return a new instance of {@link DropTarget}
   */
  public static DropTarget of(Element element) {
    return new DropTarget(element);
  }

  /**
   * Constructs a new {@link DropTarget} for the provided target DOM {@link Element}.
   *
   * @param targetElement the target DOM element
   */
  public DropTarget(Element targetElement) {
    this.targetElement = elements.elementOf(targetElement);
  }

  /**
   * Retrieves the wrapped target DOM {@link Element} as a {@link DominoElement}.
   *
   * @return the target {@link DominoElement}
   */
  public DominoElement<Element> getTargetElement() {
    return targetElement;
  }

  /**
   * Sets an observer for the target's attach/detach events.
   *
   * @param targetDetachObserver the observer callback
   */
  public void setTargetDetachObserver(MutationObserverCallback targetDetachObserver) {
    this.targetDetachObserver = targetDetachObserver;
  }

  /**
   * Retrieves the observer set for the target's attach/detach events.
   *
   * @return the observer callback
   */
  public MutationObserverCallback getTargetDetachObserver() {
    return targetDetachObserver;
  }

  /**
   * Sets an observer for the target's attach/detach events.
   *
   * @param targetAttachObserver the observer callback
   */
  public void setTargetAttachObserver(MutationObserverCallback targetAttachObserver) {
    this.targetAttachObserver = targetAttachObserver;
  }

  /**
   * Retrieves the observer set for the target's attach/detach events.
   *
   * @return the observer callback
   */
  public MutationObserverCallback getTargetAttachObserver() {
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
    if (isNull(this.metaObjects)) {
      this.metaObjects = new HashMap<>();
    }
    return metaObjects;
  }

  public final void setObservers() {
    getTargetElement().registerOnDetached(getTargetDetachObserver());
    getTargetElement().registerOnAttached(getTargetAttachObserver());
  }

  public final void cleanUp() {
    getTargetElement().removeDetachObserver(getTargetDetachObserver());
    getTargetElement().removeAttachObserver(getTargetAttachObserver());
    this.targetDetachObserver = null;
    this.targetAttachObserver = null;
    this.targetElement = null;
  }
}
