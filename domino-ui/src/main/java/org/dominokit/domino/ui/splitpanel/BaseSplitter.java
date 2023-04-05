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
package org.dominokit.domino.ui.splitpanel;

import elemental2.dom.EventListener;
import elemental2.dom.HTMLDivElement;
import elemental2.dom.MouseEvent;
import elemental2.dom.TouchEvent;
import jsinterop.base.Js;
import org.dominokit.domino.ui.elements.DivElement;
import org.dominokit.domino.ui.utils.BaseDominoElement;
import org.dominokit.domino.ui.utils.ChildHandler;
import org.dominokit.domino.ui.utils.DominoElement;
import org.dominokit.domino.ui.events.EventType;

import static elemental2.dom.DomGlobal.document;

abstract class BaseSplitter<T extends BaseSplitter<?>>
        extends BaseDominoElement<HTMLDivElement, T> implements HasSize, SplitStyles {

    private static final int LEFT_BUTTON = 1;

    protected DivElement element;
    protected final DivElement handleElement;
    private double initialStartPosition = 0;

    BaseSplitter(SplitPanel first, SplitPanel second, HasSplitPanels mainPanel) {
        element = div()
                .addCss(dui_split_layout_splitter)
                .appendChild(handleElement = div()
                        .addCss(dui_splitter_handle));

        init((T) this);
        EventListener resizeListener =
                evt -> {
                    MouseEvent mouseEvent = Js.uncheckedCast(evt);

                    if (LEFT_BUTTON == mouseEvent.buttons) {
                        double currentPosition = mousePosition(mouseEvent);
                        resize(first, second, currentPosition, mainPanel);
                    }
                };

        EventListener touchResizeListener =
                evt -> {
                    evt.preventDefault();
                    evt.stopPropagation();
                    TouchEvent touchEvent = Js.uncheckedCast(evt);
                    double currentPosition = touchPosition(touchEvent);
                    resize(first, second, currentPosition, mainPanel);
                };

        addEventListener(
                EventType.mousedown.getName(),
                evt -> {
                    MouseEvent mouseEvent = Js.uncheckedCast(evt);
                    initialStartPosition = mousePosition(mouseEvent);
                    startResize(first, second, mainPanel);
                    body().addEventListener(EventType.mousemove.getName(), resizeListener);
                });

        addEventListener(
                EventType.touchstart.getName(),
                evt -> {
                    evt.preventDefault();
                    evt.stopPropagation();
                    TouchEvent touchEvent = Js.uncheckedCast(evt);
                    initialStartPosition = touchPosition(touchEvent);
                    startResize(first, second, mainPanel);
                    body().addEventListener(EventType.touchmove.getName(), touchResizeListener);
                });

        addEventListener(
                EventType.mouseup.getName(),
                evt -> body().removeEventListener(EventType.mousemove.getName(), resizeListener));
        addEventListener(
                EventType.touchend.getName(),
                evt ->
                        body().removeEventListener(EventType.touchmove.getName(), touchResizeListener));

        document.body.addEventListener(
                EventType.mouseup.getName(),
                evt -> body().removeEventListener(EventType.mousemove.getName(), resizeListener));
        document.body.addEventListener(
                EventType.touchend.getName(),
                evt ->
                        body().removeEventListener(EventType.touchmove.getName(), touchResizeListener));
    }

    private void resize(
            SplitPanel first, SplitPanel second, double currentPosition, HasSplitPanels mainPanel) {
        double diff = currentPosition - initialStartPosition;

        mainPanel.resizePanels(first, second, diff);
    }

    private void startResize(SplitPanel first, SplitPanel second, HasSplitPanels mainPanel) {
        mainPanel.onResizeStart(first, second);
    }

    protected abstract double mousePosition(MouseEvent event);

    protected abstract double touchPosition(TouchEvent event);

    public T withHandle(ChildHandler<T, DivElement> handler){
        handler.apply((T) this, handleElement);
        return (T) this;
    }

    @Override
    public HTMLDivElement element() {
        return element.element();
    }

}
