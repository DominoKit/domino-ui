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
package org.dominokit.domino.ui.animations;

import static org.dominokit.domino.ui.utils.Domino.div;

import com.google.gwt.junit.client.GWTTestCase;
import elemental2.dom.HTMLElement;

public class AnimationTest extends GWTTestCase {

  @Override
  public String getModuleName() {
    return "org.dominokit.domino.ui.DominoUI";
  }

  public void testRepeatCountIsClearedWhenAnimationStopsAndRestarts() {
    HTMLElement element = div().element();
    Animation animation = Animation.create(element).repeat(3);

    animation.animate();
    assertEquals("3", element.style.getPropertyValue("animation-iteration-count"));

    animation.stop(true);
    assertEquals("", element.style.getPropertyValue("animation-iteration-count"));

    animation.repeat(1).animate();
    assertEquals("", element.style.getPropertyValue("animation-iteration-count"));
    animation.stop(true);
  }
}
