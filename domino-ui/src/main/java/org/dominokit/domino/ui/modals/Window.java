package org.dominokit.domino.ui.modals;

import elemental2.dom.ClientRect;
import elemental2.dom.DomGlobal;
import elemental2.dom.EventListener;
import elemental2.dom.MouseEvent;
import jsinterop.base.Js;
import org.dominokit.domino.ui.grid.flex.FlexItem;
import org.dominokit.domino.ui.grid.flex.FlexLayout;
import org.dominokit.domino.ui.icons.Icons;
import org.dominokit.domino.ui.icons.MdiIcon;
import org.dominokit.domino.ui.style.Color;
import org.jboss.gwt.elemento.core.EventType;

import static org.dominokit.domino.ui.style.Unit.px;

public class Window extends BaseModal<Window> {

    private final MdiIcon restore;
    private final MdiIcon maximize;
    private boolean maximized = false;

    private double mouseX;
    private double mouseY;

    private boolean startMoving = false;
    private double deltaX;
    private double deltaY;
    private final EventListener moveListener;
    private final EventListener stopMoveListener;

    private double windowLeft = -1;
    private double windowTop = -1;

    private String headerBackGround = Color.THEME.getBackground();

    private boolean draggable = true;
    private boolean fixed;

    public static Window create(String title){
        return new Window(title);
    }

    public Window(String title) {
        super(title);
        init(this);
        elevate(10);
        setModal(false);
        css("window");
        modalElement.getModalHeader().css(headerBackGround);
        modalElement.getModalTitle().styler(style -> style
                .setFloat("left")
                .setPadding(px.of(8)));

        restore = Icons.ALL.window_restore_mdi();
        maximize = Icons.ALL.window_maximize_mdi();
        modalElement.getModalHeader().appendChild(FlexLayout.create()
                .styler(style -> style.setFloat("right"))
                .appendChild(FlexItem.create()
                        .appendChild(restore
                                .hide()
                                .size18()
                                .clickable()
                                .addClickListener(evt -> restore())
                        )
                        .appendChild(maximize
                                .size18()
                                .clickable()
                                .addClickListener(evt -> maximize())
                        )
                        .appendChild(Icons.ALL.close_mdi()
                                .size18()
                                .clickable()
                                .addClickListener(evt -> close()))
                )
        );

        moveListener = evt -> {

            if (draggable) {
                MouseEvent mouseEvent = Js.uncheckedCast(evt);

                if (startMoving && mouseEvent.button == 0 && !maximized) {
                    evt.preventDefault();
                    deltaX = mouseX - mouseEvent.clientX;
                    deltaY = mouseY - mouseEvent.clientY;
                    mouseX = mouseEvent.clientX;
                    mouseY = mouseEvent.clientY;

                    double left = modalElement.asElement().offsetLeft - deltaX;
                    double top = modalElement.asElement().offsetTop - deltaY;

                    ClientRect windowRect = modalElement.getModalDialog().asElement().getBoundingClientRect();
                    double initialWidth = windowRect.width;
                    double initialHeight = windowRect.height;

                    double windowWidth = DomGlobal.window.innerWidth;
                    double windowHeight = DomGlobal.window.innerHeight;

                    if (left > 0 && left < (windowWidth - initialWidth)) {
                        modalElement.asElement().style.left = left + "px";
                        this.windowLeft = left;
                    }

                    if (top > 0 && top < (windowHeight - initialHeight)) {
                        modalElement.asElement().style.top = top + "px";
                        this.windowTop = top;
                    }
                }
            }
        };
        stopMoveListener = evt -> {
            if (draggable) {
                startMoving = false;
            }
        };

        onOpen(this::addMoveListeners);
        onClose(this::removeMoveListeners);

        initPosition();
    }

    public boolean isDraggable() {
        return draggable;
    }

    public Window setDraggable(boolean draggable) {
        this.draggable = draggable;
        return this;
    }

    public Window maximize() {
        maximize.hide();
        restore.show();
        maximized = true;
        updatePosition();
        Window.this.css("maximized");

        return this;
    }

    public Window restore() {
        restore.hide();
        maximize.show();
        maximized = false;
        Window.this.removeCss("maximized");
        updatePosition();

        return this;
    }

    public Window setHeaderBackground(Color color) {
        modalElement.getModalHeader().removeCss(headerBackGround);
        modalElement.getModalHeader().css(color.getBackground());
        this.headerBackGround = color.getBackground();

        return this;
    }

    public Window setFixed() {
        css("fixed");
        this.fixed = true;
        updatePosition();
        return this;
    }

    public boolean isMaximized() {
        return maximized;
    }

    public double getWindowLeft() {
        return windowLeft;
    }

    public Window setWindowLeft(double windowLeft) {
        this.windowLeft = windowLeft;
        return this;
    }

    public double getWindowTop() {
        return windowTop;
    }

    public Window setWindowTop(double windowTop) {
        this.windowTop = windowTop;
        return this;
    }

    private void initPosition() {
        onOpen(() -> updatePosition());
    }

    private void updatePosition() {
        if (maximized) {
            modalElement.asElement().style.left = "0px";
            modalElement.asElement().style.top = "0px";
        } else {
            ClientRect windowRect = modalElement.getModalDialog().asElement().getBoundingClientRect();
            double initialWidth = windowRect.width;
            double windowWidth = DomGlobal.window.innerWidth;

            if (windowLeft < 0) {
                modalElement.asElement().style.left = ((windowWidth - initialWidth) / 2)+((fixed ? 0 : DomGlobal.window.pageXOffset)) + "px";
            } else {
                modalElement.asElement().style.left = windowLeft + "px";
            }

            if (windowTop < 0) {
                modalElement.asElement().style.top = 100 + (fixed ? 0 : DomGlobal.window.pageYOffset) + "px";
            } else {
                modalElement.asElement().style.top = windowTop + "px";
            }
        }
    }

    private void removeMoveListeners() {
        DomGlobal.document.body.removeEventListener(EventType.mouseup.getName(), stopMoveListener);
        DomGlobal.document.body.removeEventListener(EventType.mousemove.getName(), moveListener);
        modalElement.getModalHeader().removeEventListener(EventType.mousemove.getName(), moveListener);
        modalElement.getModalHeader().removeEventListener(EventType.mouseup.getName(), stopMoveListener);
    }

    private void addMoveListeners() {
        modalElement.getModalHeader()
                .addEventListener(EventType.mousedown, evt -> {
                    if (draggable) {
                        MouseEvent mouseEvent = Js.uncheckedCast(evt);
                        if (!startMoving && mouseEvent.button == 0) {
                            mouseEvent.stopPropagation();
                            mouseEvent.preventDefault();

                            mouseX = mouseEvent.clientX;
                            mouseY = mouseEvent.clientY;

                            startMoving = true;
                        }
                    }
                });

        modalElement.getModalHeader()
                .addEventListener(EventType.mouseup, stopMoveListener);
        DomGlobal.document.body
                .addEventListener(EventType.mousemove.getName(), moveListener);
        DomGlobal.document.body
                .addEventListener(EventType.mouseup.getName(), stopMoveListener);
    }
}
