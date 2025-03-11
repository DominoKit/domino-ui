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
package org.dominokit.domino.ui.menu.direction;

import static java.util.Objects.isNull;

import elemental2.dom.Element;

public class DropDirectionContext {
  private final Element source;
  private final Element target;
  private final boolean fitToTargetWidth;
  private SpaceChecker spaceChecker;

  public static DropDirectionContext of(Element source, Element target, boolean fitToTargetWidth) {
    return new DropDirectionContext(source, target, fitToTargetWidth);
  }

  public static DropDirectionContext of(Element source, Element target) {
    return new DropDirectionContext(source, target, false);
  }

  /**
   * @param source a {@link elemental2.dom.Element} object
   * @param target a {@link elemental2.dom.Element} object
   * @param fitToTargetWidth boolean
   */
  public DropDirectionContext(Element source, Element target, boolean fitToTargetWidth) {
    this.source = source;
    this.target = target;
    this.fitToTargetWidth = fitToTargetWidth;
  }

  public Element getSource() {
    return source;
  }

  public Element getTarget() {
    return target;
  }

  public boolean isFitToTargetWidth() {
    return fitToTargetWidth;
  }

  public SpaceChecker getSpaceChecker() {
    if (isNull(this.spaceChecker)) {
      this.spaceChecker = new SpaceChecker(this);
    }
    return this.spaceChecker;
  }

  public SpaceChecker newSpaceChecker() {
    this.spaceChecker = new SpaceChecker(this);
    return this.spaceChecker;
  }
}
