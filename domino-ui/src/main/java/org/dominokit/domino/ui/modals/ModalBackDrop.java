package org.dominokit.domino.ui.modals;

import elemental2.dom.Event;
import elemental2.dom.HTMLDivElement;
import jsinterop.base.Js;
import org.dominokit.domino.ui.popover.Popover;
import org.jboss.gwt.elemento.core.Elements;
import org.jboss.gwt.elemento.core.EventType;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

public class ModalBackDrop {
    public static final int INCREMENT = 10;
    private static Deque<BaseModal> openedModals = new LinkedList<>();
    private static Deque<Popover> openedPopOvers = new LinkedList<>();
    private static Integer NEXT_Z_INDEX = 1040;
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
            BaseModal modal = ModalBackDrop.openedModals.peek();
            if (modal.isAutoClose()) {
                modal.close();
            }
        }
    }

    public static boolean contains(BaseModal modal) {
        return openedModals.contains(modal);
    }

    public static void push(BaseModal modal) {
        openedModals.push(modal);
        NEXT_Z_INDEX += INCREMENT;
    }

    public static void popModal(BaseModal modal) {
        openedModals.remove(modal);
        NEXT_Z_INDEX -= INCREMENT;
    }

    public static boolean contains(Popover popover) {
        return openedPopOvers.contains(popover);
    }

    public static void push(Popover popover) {
        openedPopOvers.push(popover);
        NEXT_Z_INDEX += INCREMENT;
    }

    public static void popPopOver() {
        if (!openedPopOvers.isEmpty()) {
            openedPopOvers.pop();
            NEXT_Z_INDEX -= INCREMENT;
        }
    }

    public static Integer getNextZIndex() {
        return NEXT_Z_INDEX;
    }

    public static void toNextZIndex() {
        NEXT_Z_INDEX += INCREMENT;
    }

    public static void closePopovers() {
        List<Popover> opened = new ArrayList<>(openedPopOvers);
        opened.forEach(Popover::close);
    }

    public static void onScrollClosePopovers() {
        List<Popover> shouldClose = openedPopOvers.stream().filter(Popover::isCloseOnScroll).collect(Collectors.toList());
        for (Popover popover : shouldClose) {
            popover.close();
        }
    }

    public static int openedModalsCount() {
        return openedModals.size();
    }

}
