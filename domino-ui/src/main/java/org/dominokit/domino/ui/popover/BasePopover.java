package org.dominokit.domino.ui.popover;

import elemental2.dom.CustomEvent;
import elemental2.dom.EventListener;
import elemental2.dom.HTMLDivElement;
import elemental2.dom.HTMLElement;
import jsinterop.base.Js;
import org.dominokit.domino.ui.config.HasComponentConfig;
import org.dominokit.domino.ui.config.ZIndexConfig;
import org.dominokit.domino.ui.dialogs.ModalBackDrop;
import org.dominokit.domino.ui.style.SwapCssClass;
import org.dominokit.domino.ui.utils.BaseDominoElement;
import org.dominokit.domino.ui.utils.ChildHandler;
import org.dominokit.domino.ui.utils.DominoElement;
import org.dominokit.domino.ui.utils.FollowOnScroll;
import org.dominokit.domino.ui.utils.IsPopup;
import org.jboss.elemento.EventType;

import java.util.Objects;

import static elemental2.dom.DomGlobal.document;
import static org.dominokit.domino.ui.dialogs.ModalBackDrop.DUI_REMOVE_POPOVERS;
import static org.dominokit.domino.ui.popover.PopupPosition.TOP;

public class BasePopover<T extends BasePopover<T>> extends BaseDominoElement<HTMLDivElement, T>
        implements IsPopup<T>, PopoverStyles, FollowOnScroll.ScrollFollower, HasComponentConfig<ZIndexConfig> {

    protected final HTMLElement targetElement;
    private final EventListener closeAllListener;
    private DominoElement<HTMLDivElement> root;
    private DominoElement<HTMLDivElement> wrapper;
    private DominoElement<HTMLDivElement> arrow;
    private DominoElement<HTMLDivElement> header;
    private DominoElement<HTMLDivElement> body;

    private PopupPosition popupPosition = TOP;

    private boolean closeOthers = true;
    protected final EventListener closeListener;
    private SwapCssClass positionClass = SwapCssClass.of(dui_pop_top);


    private final FollowOnScroll followOnScroll;

    static {
        document.body.addEventListener(EventType.click.getName(), element -> {
            closeAll("");
        });
    }

    private static void closeAll(String sourceId) {
        ModalBackDrop.INSTANCE.closePopovers(sourceId);
    }

    public BasePopover(HTMLElement target) {
        this.targetElement = target;
        root = div()
                .addCss(dui_popover, positionClass)
                .appendChild(wrapper= div()
                        .addCss(dui_popover_wrapper)
                        .appendChild(arrow = div().addCss(dui_popover_arrow))
                        .appendChild(header = div().addCss(dui_popover_header))
                        .appendChild(body = div().addCss(dui_popover_body))
                );

        init((T) this);
        followOnScroll = new FollowOnScroll(targetElement, this);

        closeListener = evt -> closeAll("");
        root.addEventListener(EventType.click.getName(), evt-> {
            evt.preventDefault();
            evt.stopPropagation();
        });
        elementOf(targetElement)
                .onDetached(
                        mutationRecord -> close());

        onDetached(
                mutationRecord ->{
                    body().removeEventListener(EventType.keydown.getName(), closeListener);
                }
        );
        addHideListener(this::doClose);
        closeAllListener = evt -> {
            CustomEvent<String> event= Js.uncheckedCast(evt);
            if(!Objects.equals(event.detail, getDominoId())) {
                close();
            }
        };
        addHideListener(() -> removeEventListener(DUI_REMOVE_POPOVERS, closeAllListener));
    }

    /** {@inheritDoc} */
    @Override
    public T show() {
        if (isEnabled()) {
            if (closeOthers) {
                closeAll(getDominoId());
            }
            doOpen();
            getConfig().getZindexManager().onPopupOpen(this);
            triggerExpandListeners((T) this);
        }
        return (T) this;
    }

    public T open() {
        return show();
    }

    protected void doOpen() {
        body().appendChild(root.element());
        super.show();
        doPosition();
        if(!isCloseOnScroll()) {
            followOnScroll.start();
        }

        addEventListener(DUI_REMOVE_POPOVERS, closeAllListener);
    }

    private void doPosition() {
        popupPosition.position(root.element(), targetElement);
        position(popupPosition);
    }

    /** Closes the popover */
    public T close() {
        hide();
        return (T) this;
    }

    protected void doClose() {
        followOnScroll.stop();
        element().remove();
        body().removeEventListener(EventType.keydown.getName(), closeListener);
        getConfig().getZindexManager().onPopupClose(this);
        triggerCollapseListeners((T) this);
    }

    @Override
    public boolean isModal() {
        return false;
    }

    @Override
    public boolean isAutoClose() {
        return true;
    }

    /**
     * Closes the popover and remove it completely from the target element so it will not be shown
     * again
     */
    public void discard() {
        close();
    }

    /**
     * Sets the position of the popover related to the target element
     *
     * @param position the {@link PopupPosition}
     * @return same instance
     */
    public T position(PopupPosition position) {
        addCss(positionClass.replaceWith(position.getDirectionClass()));
        this.popupPosition = position;
        return (T) this;
    }

    /**
     * Sets if other popovers should be closed when open this one
     *
     * @param closeOthers true to close all popovers when this on is opened, false otherwise
     * @return same instance
     */
    public T setCloseOthers(boolean closeOthers) {
        this.closeOthers = closeOthers;
        return (T) this;
    }

    public DominoElement<HTMLDivElement> getArrowElement() {
        return arrow;
    }

    public T withArrow(ChildHandler<T, DominoElement<HTMLDivElement>> handler){
        handler.apply((T) this, arrow);
        return (T) this;
    }

    public DominoElement<HTMLDivElement> getHeaderElement() {
        return header;
    }

    public T withHeader(ChildHandler<T, DominoElement<HTMLDivElement>> handler){
        handler.apply((T) this, header);
        return (T) this;
    }

    public DominoElement<HTMLDivElement> getBody() {
        return body;
    }

    public T withBody(ChildHandler<T, DominoElement<HTMLDivElement>> handler){
        handler.apply((T) this, body);
        return (T) this;
    }

    @Override
    protected HTMLElement getAppendTarget() {
        return body.element();
    }


    /**
     * Sets if the popover should be closed if scrolling
     *
     * @param closeOnScroll true to close on scroll, false otherwise
     * @return same instance
     */
    public T closeOnScroll(boolean closeOnScroll) {
        setAttribute("d-close-on-scroll", closeOnScroll);
        return (T) this;
    }

    /** {@inheritDoc} */
    @Override
    public HTMLDivElement element() {
        return root.element();
    }


    /** @return true if close on scrolling, false otherwise */
    public boolean isCloseOnScroll() {
        return hasAttribute("d-close-on-scroll")
                && getAttribute("d-close-on-scroll").equalsIgnoreCase("true");
    }

    @Override
    public boolean isFollowerOpen() {
        return isAttached();
    }

    @Override
    public void positionFollower() {
        doPosition();
    }
}
