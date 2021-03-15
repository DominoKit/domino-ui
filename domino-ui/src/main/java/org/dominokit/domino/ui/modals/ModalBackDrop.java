package org.dominokit.domino.ui.modals;

import elemental2.dom.Event;
import elemental2.dom.HTMLDivElement;
import jsinterop.base.Js;
import org.dominokit.domino.ui.popover.Popover;
import org.jboss.elemento.Elements;
import org.jboss.elemento.EventType;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * A utility class to show overlays that blocks the content behind a modal dialog.
 * <p>
 *     this class can track the overlay across the page and all opened modals and it adjust its position whenever a modal is opened or closed
 * </p>
 */
public class ModalBackDrop {
    /**
     * the z-index increment for every modal open
     */
    public static final int INCREMENT = 10;
    private static Deque<BaseModal> openedModals = new LinkedList<>();
    private static Deque<Popover> openedPopOvers = new LinkedList<>();
    private static Integer NEXT_Z_INDEX = 1040;
    /**
     * The single instance of the overlay backdrop element
     */
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
            .element();

    private static void closeCurrentOpen() {
        if (!ModalBackDrop.openedModals.isEmpty()) {
            BaseModal modal = ModalBackDrop.openedModals.peek();
            if (modal.isAutoClose()) {
                modal.close();
            }
        }
    }

    /**
     *
     * @param modal {@link BaseModal}
     * @return boolean, true if the provided modal is tracked by the ModalBackDrop
     */
    public static boolean contains(BaseModal modal) {
        return openedModals.contains(modal);
    }

    public static void push(BaseModal modal) {
        openedModals.push(modal);
        NEXT_Z_INDEX += INCREMENT;
    }

    /**
     *
     * @param modal {@link BaseModal} to be removed from the tracked modals and to increment the overlay z-index
     */
    public static void popModal(BaseModal modal) {
        openedModals.remove(modal);
        NEXT_Z_INDEX -= INCREMENT;
    }

    /**
     *
     * @param popover {@link Popover}
     * @return boolean, true if the provided Popover is tracked by the ModalBackDrop
     */
    public static boolean contains(Popover popover) {
        return openedPopOvers.contains(popover);
    }

    /**
     *
     * @param popover {@link Popover} to be tracked by this ModalBackDrop and to increment the overlay z-index
     */
    public static void push(Popover popover) {
        openedPopOvers.push(popover);
        NEXT_Z_INDEX += INCREMENT;
    }

    /**
     *
     * remove the popover on top of queue from the tracked modals and to increment the overlay z-index
     */
    public static void popPopOver() {
        if (!openedPopOvers.isEmpty()) {
            openedPopOvers.pop();
            NEXT_Z_INDEX -= INCREMENT;
        }
    }

    /**
     *
     * @return the Integer z-index for the next modal
     */
    public static Integer getNextZIndex() {
        return NEXT_Z_INDEX;
    }

    /**
     * Increment the z-index by the {@link #INCREMENT}
     */
    public static void toNextZIndex() {
        NEXT_Z_INDEX += INCREMENT;
    }

    /**
     * Close all currently open {@link Popover}s
     */
    public static void closePopovers() {
        List<Popover> opened = new ArrayList<>(openedPopOvers);
        opened.forEach(Popover::close);
    }

    /**
     * Automatically close all {@link Popover}s when the page is scrolled
     */
    public static void onScrollClosePopovers() {
        List<Popover> shouldClose = openedPopOvers.stream().filter(Popover::isCloseOnScroll).collect(Collectors.toList());
        for (Popover popover : shouldClose) {
            popover.close();
        }
    }

    /**
     *
     * @return the int count of all opened moal dialogs
     */
    public static int openedModalsCount() {
        return openedModals.size();
    }

    /**
     *
     * @return boolean true if all opened dialogs are not modals
     */
    public static boolean allOpenedNotModals() {
        return openedModals.stream().noneMatch(BaseModal::isModal);
    }
}
