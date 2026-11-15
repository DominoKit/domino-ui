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

import com.google.gwt.junit.client.GWTTestCase;
import elemental2.dom.MutationRecord;
import elemental2.dom.Node;
import jsinterop.annotations.JsFunction;
import jsinterop.base.Js;
import jsinterop.base.JsPropertyMap;

public class BodyObserverTest extends GWTTestCase {

  @Override
  public String getModuleName() {
    return "org.dominokit.domino.ui.DominoUI";
  }

  public void testOnElementsRemovedSkipsTextNodeWithoutNativeCastFailure() {
    JsPropertyMap<Object> textNodeShape = JsPropertyMap.of();
    textNodeShape.set("nodeType", Node.TEXT_NODE);

    JsPropertyMap<Object> removedNodes = JsPropertyMap.of();
    removedNodes.set("length", 1);
    removedNodes.set("item", (NodeListItem) index -> textNodeShape);

    JsPropertyMap<Object> recordShape = JsPropertyMap.of();
    recordShape.set("removedNodes", removedNodes);
    MutationRecord record = Js.uncheckedCast(recordShape);

    BodyObserver.onElementsRemoved(record);
  }

  @JsFunction
  private interface NodeListItem {
    Object item(double index);
  }
}
