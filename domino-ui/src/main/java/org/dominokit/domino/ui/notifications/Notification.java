package org.dominokit.domino.ui.notifications;

import elemental2.dom.DomGlobal;
import elemental2.dom.HTMLButtonElement;
import elemental2.dom.HTMLDivElement;
import elemental2.dom.HTMLElement;
import elemental2.dom.Node;
import org.dominokit.domino.ui.animations.Animation;
import org.dominokit.domino.ui.animations.Transition;
import org.dominokit.domino.ui.style.Color;
import org.dominokit.domino.ui.style.Elevation;
import org.dominokit.domino.ui.style.Styles;
import org.dominokit.domino.ui.utils.BaseDominoElement;
import org.dominokit.domino.ui.utils.DominoElement;
import org.jboss.elemento.EventType;
import org.jboss.elemento.IsElement;

import java.util.ArrayList;
import java.util.List;

import static java.util.Objects.nonNull;
import static org.jboss.elemento.Elements.button;
import static org.jboss.elemento.Elements.div;
import static org.jboss.elemento.Elements.span;

public class Notification extends BaseDominoElement<HTMLDivElement, Notification> implements IsElement<HTMLDivElement> {

    public static final Position TOP_LEFT = new TopLeftPosition();
    public static final Position TOP_CENTER = new TopCenterPosition();
    public static final Position TOP_RIGHT = new TopRightPosition();

    public static final Position BOTTOM_LEFT = new BottomLeftPosition();
    public static final Position BOTTOM_CENTER = new BottomCenterPosition();
    public static final Position BOTTOM_RIGHT = new BottomRightPosition();

    private HTMLButtonElement closeButton = button()
            .attr("type", "button")
            .attr("aria-hidden", "true")
            .css(NotificationStyles.CLOSE)
            .style("position: absolute; right: 10px; top: 5px; z-index: 1033;")
            .textContent("×")
            .element();

    private HTMLElement messageSpan = span().element();

    private HTMLDivElement element = div()
            .css(NotificationStyles.BOOTSTRAP_NOTIFY_CONTAINER)
            .css(NotificationStyles.ALERT)
            .css(NotificationStyles.ALERT_DISMISSIBLE)
            .css(Styles.p_r_35)
            .attr("role", "alert")
            .attr("data-position", "20")
            .style("display: inline-block; position: fixed; transition: all 800ms ease-in-out; z-index: 99999999;")
            .add(closeButton)
            .add(messageSpan)
            .element();

    private int duration = 4000;
    private Transition inTransition = Transition.FADE_IN;
    private Transition outTransition = Transition.FADE_OUT;
    private Position position = TOP_RIGHT;
    private Color background = Color.BLACK;
    private String type;
    private boolean closable = true;
    private boolean infinite = false;
    private boolean closed = true;
    private final List<CloseHandler> closeHandlers = new ArrayList<>();

    public Notification() {
        init(this);
        elevate(Elevation.LEVEL_1);
        style().add(background.getBackground());
        closeButton.addEventListener(EventType.click.getName(), e -> close());
    }

    /**
     * Creates a notification with danger style (red background) indicating a failed operation.
     *
     * @param message
     * @return {@link Notification}
     */
    public static Notification createDanger(String message) {
        return create(message, NotificationStyles.ALERT_DANGER);
    }

    /**
     * Creates a notification with success style (green background) indicating a success operation.
     *
     * @param message
     * @return {@link Notification}
     */
    public static Notification createSuccess(String message) {
        return create(message, NotificationStyles.ALERT_SUCCESS);
    }

    /**
     * Creates a notification with success style (green background) to show warnings.
     *
     * @param message
     * @return {@link Notification}
     */
    public static Notification createWarning(String message) {
        return create(message, NotificationStyles.ALERT_WARNING);
    }

    /**
     * Creates a notification with success style (green background) to informative message.
     *
     * @param message
     * @return {@link Notification}
     */
    public static Notification createInfo(String message) {
        return create(message, NotificationStyles.ALERT_INFO);
    }

    /**
     * Creates a notification for the message with the specified type/style
     *
     * @param message
     * @param type    the style to be applied on the notification, predefined types {@value NotificationStyles#ALERT_INFO},{@value NotificationStyles#ALERT_DANGER},{@value NotificationStyles#ALERT_SUCCESS},{@value NotificationStyles#ALERT_WARNING}
     * @return {@link Notification}
     */
    public static Notification create(String message, String type) {
        Notification notification = create(message);
        notification.setType(type);
        return notification;
    }

    /**
     * Creates a notification for the message with no specific type and default black bacjground.
     *
     * @param message
     * @return {@link Notification}
     */
    public static Notification create(String message) {
        Notification notification = new Notification();
        notification.setMessage(message);
        return notification;
    }

    /**
     * @return {@link DominoElement<HTMLButtonElement>} the close button of the notification.
     */
    public DominoElement<HTMLButtonElement> getCloseButton() {
        return DominoElement.of(closeButton);
    }

    /**
     * Use to show or hide the close button.
     *
     * @return {@link Notification}
     */
    public Notification setClosable(boolean closable) {
        this.closable = closable;
        getCloseButton().toggleDisplay(closable);
        return this;
    }

    /**
     * @return boolean, true if the close button is visible, else false.
     */
    public boolean isClosable() {
        return closable;
    }

    /**
     * for none infinite notifications, the duration defined how long the notification will remain visible after the show transition is completed before it is automatically closed.
     *
     * @param duration in millisecond
     * @return {@link Notification}
     */
    public Notification duration(int duration) {
        this.duration = duration;
        return this;
    }

    /**
     * Defines the animation transition to be applied to show up the notification when {@link Notification#show()} is called.
     *
     * @param inTransition {@link Transition}
     * @return {@link Notification}
     */
    public Notification inTransition(Transition inTransition) {
        this.inTransition = inTransition;
        return this;
    }

    /**
     * Defines the animation transition to be applied to close up the notification when {@link Notification#close()} is called, or the duration ends.
     *
     * @param outTransition {@link Transition}
     * @return {@link Notification}
     */
    public Notification outTransition(Transition outTransition) {
        this.outTransition = outTransition;
        return this;
    }

    /**
     * The text content of the notification
     *
     * @param message
     * @return {@link Notification}
     */
    public Notification setMessage(String message) {
        this.messageSpan.textContent = message;
        return this;
    }

    /**
     * Sets specified type/style
     *
     * @param type    the style to be applied on the notification, predefined types {@value NotificationStyles#ALERT_INFO},{@value NotificationStyles#ALERT_DANGER},{@value NotificationStyles#ALERT_SUCCESS},{@value NotificationStyles#ALERT_WARNING}
     * @return {@link Notification}
     */
    public Notification setType(String type) {
        this.type = type;
        style().add(type);
        style().remove(background.getBackground());
        return this;
    }

    /**
     * Appends any kind of content to the notification body.
     *
     * @param content {@link Node}
     * @return {@link Notification}
     */
    public Notification appendContent(Node content) {
        element().appendChild(content);
        return this;
    }

    /**
     * Defines the location in which the notification will show up when {@link Notification#show()} is called.
     *
     * @param position {@link Position}
     * @return {@link Notification}
     */
    public Notification setPosition(Position position) {
        this.position = position;
        return this;
    }

    /**
     * Apply a custom background color to the notification.
     * this will override styles applied from the notification types.
     *
     * @param background {@link Color}
     * @return {@link Notification}
     */
    public Notification setBackground(Color background) {
        if (nonNull(type)) {
            style().remove(type);
        }

        style().remove(this.background.getBackground());
        style().add(background.getBackground());
        this.background = background;
        return this;
    }

    /**
     * When true, duration will be ignored, and the notification will only close if the {@link Notification#close()} is called or close button is clicked.
     *
     * @param infinite
     * @return {@link Notification}
     */
    public Notification setInfinite(boolean infinite) {
        this.infinite = infinite;
        return this;
    }

    /**
     * @return boolean, true if notification is finite
     */
    public boolean isInfinite() {
        return infinite;
    }

    /**
     * Show up the notification and apply the IN transtion animation.
     *
     * @return {@link Notification}
     */
    public Notification show() {
        this.closed = false;
        position.onBeforeAttach(element());
        DomGlobal.document.body.appendChild(element());
        position.onNewElement(element());
        Animation.create(element())
                .transition(inTransition)
                .callback(e -> {
                    if (!infinite) {
                        close(duration);
                    }
                })
                .animate();
        return this;
    }

    /**
     * Closes the notification based on the applied notification position and apply the close animation.
     */
    public final void close() {
        close(0);
    }

    /**
     * Closes the notification based on the applied notification position and apply the close animation after the specified duration.
     * @param after time to wait before starting the close animation in milliseconds
     */
    public final void close(int after) {
        if(!closed) {
            int dataPosition = Integer.parseInt(element().getAttribute("data-position"));
            int height = element().offsetHeight;
            animateClose(after, () -> {
                position.onRemoveElement(dataPosition, height);
                closeHandlers.forEach(CloseHandler::onClose);
                this.closed = true;
            });
        }
    }

    private void animateClose(int after, Runnable onComplete) {
       Animation.create(element())
                .delay(after)
                .transition(outTransition)
                .callback(e2 -> {
                    element().remove();
                    onComplete.run();
                }).animate();
    }

    /**
     *
     * @return List of {@link CloseHandler} to be called when a notification is closed.
     */
    public List<CloseHandler> getCloseHandlers() {
        return closeHandlers;
    }

    /**
     * Add a handler to be called when a notification is closed
     * @param closeHandler {@link CloseHandler}
     * @return {@link Notification}
     */
    public Notification addCloseHandler(CloseHandler closeHandler){
        if(nonNull(closeHandler)){
            closeHandlers.add(closeHandler);
        }
        return this;
    }

    /**
     * Removes a {@link CloseHandler} from the currently existing close handlers.
     * @param closeHandler
     * @return {@link Notification}
     */
    public Notification removeCloseHandler(CloseHandler closeHandler){
        if(nonNull(closeHandler)){
            closeHandlers.remove(closeHandler);
        }
        return this;
    }

    /**
     * @return {@link HTMLDivElement} the root element that represent this notification instance.
     */
    @Override
    public HTMLDivElement element() {
        return element;
    }

    /**
     * An interface for the required API to implement new position classes for notifications
     */
    public interface Position {
        /**
         * this method will be called before attaching the notification element to the dom.
         *
         * @param element the notification element
         */
        void onBeforeAttach(HTMLElement element);

        /**
         * this method will be called everytime we try to show a new notification.
         *
         * @param element the notification element
         */
        void onNewElement(HTMLElement element);

        /**
         * this method will be called once the notification is completed and the notification element is removed from the dom
         *
         * @param dataPosition
         * @param height
         */
        void onRemoveElement(int dataPosition, int height);
    }

    /**
     * functionl interface to handle close event
     */
    @FunctionalInterface
    public interface CloseHandler {
        void onClose();
    }
}
