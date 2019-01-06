package org.dominokit.domino.ui.modals;

import elemental2.dom.Event;
import elemental2.dom.HTMLDivElement;
import jsinterop.base.Js;
import org.jboss.gwt.elemento.core.Elements;
import org.jboss.gwt.elemento.core.EventType;

import java.util.Deque;
import java.util.LinkedList;

public class ModalBackDrop {
    public static Deque<BaseModal> openedModals = new LinkedList<>();
    public static final HTMLDivElement INSTANCE = Elements.div()
            .css(ModalStyles.MODAL_BACKDROP)
            .css(ModalStyles.FADE)
            .css(ModalStyles.IN)
            .on(EventType.click, event -> {
                if (ModalBackDrop.INSTANCE.isEqualNode(Js.uncheckedCast(event.target))) {
                    closeCurrentOpen();
                }
            })
            .on(EventType.keypress, event -> {
                if (ModalBackDrop.INSTANCE.isEqualNode(Js.uncheckedCast(event.target))) {
                    closeCurrentOpen();
                }
            })
            .on(EventType.scroll, Event::stopPropagation)
            .asElement();

    private static void closeCurrentOpen() {
        if (!ModalBackDrop.openedModals.isEmpty()) {
            BaseModal modal = ModalBackDrop.openedModals.pop();
            if (modal.isAutoClose()) {
                modal.close();
            }
        }
    }
}
