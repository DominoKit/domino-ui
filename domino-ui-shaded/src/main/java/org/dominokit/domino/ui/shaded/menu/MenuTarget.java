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
package org.dominokit.domino.ui.shaded.menu;

import elemental2.dom.HTMLElement;
import java.util.HashMap;
import java.util.Map;
import org.dominokit.domino.ui.shaded.utils.ComponentMeta;
import org.dominokit.domino.ui.shaded.utils.DominoElement;
import org.dominokit.domino.ui.shaded.utils.HasMeta;
import org.jboss.elemento.ObserverCallback;

@Deprecated
public class MenuTarget implements HasMeta<MenuTarget> {

  private final DominoElement<HTMLElement> targetElement;
  private ObserverCallback targetDetachObserver;
  private final Map<String, ComponentMeta> metaObjects = new HashMap<>();

  public static MenuTarget of(HTMLElement element) {
    return new MenuTarget(element);
  }

  public MenuTarget(HTMLElement targetElement) {
    this.targetElement = DominoElement.of(targetElement);
  }

  public DominoElement<HTMLElement> getTargetElement() {
    return targetElement;
  }

  void setTargetDetachObserver(ObserverCallback targetDetachObserver) {
    this.targetDetachObserver = targetDetachObserver;
  }

  ObserverCallback getTargetDetachObserver() {
    return targetDetachObserver;
  }

  @Override
  public Map<String, ComponentMeta> getMetaObjects() {
    return metaObjects;
  }
}
