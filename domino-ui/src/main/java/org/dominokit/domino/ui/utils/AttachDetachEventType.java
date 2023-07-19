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

/**
 * AttachDetachEventType class.
 *
 * @author vegegoku
 * @version $Id: $Id
 */
public class AttachDetachEventType {

  /**
   * attachedType.
   *
   * @param element a {@link org.dominokit.domino.ui.utils.HasAttributes} object
   * @return a {@link java.lang.String} object
   */
  public static String attachedType(HasAttributes<?> element) {
    return "dui-attached-" + element.getAttribute(BaseDominoElement.ATTACH_UID_KEY);
  }

  /**
   * detachedType.
   *
   * @param element a {@link org.dominokit.domino.ui.utils.HasAttributes} object
   * @return a {@link java.lang.String} object
   */
  public static String detachedType(HasAttributes<?> element) {
    return "dui-detached-" + element.getAttribute(BaseDominoElement.DETACH_UID_KEY);
  }
}
