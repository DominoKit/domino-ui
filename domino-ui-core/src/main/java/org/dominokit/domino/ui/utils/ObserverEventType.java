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
package org.dominokit.domino.ui.utils;

import elemental2.dom.Element;
import org.dominokit.domino.ui.IsElement;

/** Builds the custom event names used by core element lifecycle observers. */
public final class ObserverEventType {

  private ObserverEventType() {}

  public static String attachedType(HasAttributes<?> element) {
    return "dui-attached-" + element.getAttribute(BaseDominoElement.ATTACH_UID_KEY);
  }

  public static String attachedType(IsElement<?> element) {
    return attachedType(element.element());
  }

  public static String attachedType(Element element) {
    return "dui-attached-" + element.getAttribute(BaseDominoElement.ATTACH_UID_KEY);
  }

  public static String detachedType(HasAttributes<?> element) {
    return "dui-detached-" + element.getAttribute(BaseDominoElement.DETACH_UID_KEY);
  }

  public static String detachedType(IsElement<?> element) {
    return detachedType(element.element());
  }

  public static String detachedType(Element element) {
    return "dui-detached-" + element.getAttribute(BaseDominoElement.DETACH_UID_KEY);
  }

  public static String attributeType(HasAttributes<?> element) {
    return "dui-attribute-change-"
        + element.getAttribute(BaseDominoElement.ATTRIBUTE_CHANGE_UID_KEY);
  }

  public static String attributeType(IsElement<?> element) {
    return attributeType(element.element());
  }

  public static String attributeType(Element element) {
    return "dui-attribute-change-"
        + element.getAttribute(BaseDominoElement.ATTRIBUTE_CHANGE_UID_KEY);
  }

  public static String characterDataType(HasAttributes<?> element) {
    return "dui-character-data-change-"
        + element.getAttribute(BaseDominoElement.CHARACTER_DATA_CHANGE_UID_KEY);
  }

  public static String characterDataType(IsElement<?> element) {
    return characterDataType(element.element());
  }

  public static String characterDataType(Element element) {
    return "dui-character-data-change-"
        + element.getAttribute(BaseDominoElement.CHARACTER_DATA_CHANGE_UID_KEY);
  }
}
