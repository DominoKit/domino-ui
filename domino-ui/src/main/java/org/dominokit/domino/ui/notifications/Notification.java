package org.dominokit.domino.ui.notifications;

import elemental2.dom.*;
import org.dominokit.domino.ui.animations.Animation;
import org.dominokit.domino.ui.animations.Transition;
import org.dominokit.domino.ui.style.Color;
import org.dominokit.domino.ui.style.Elevation;
import org.dominokit.domino.ui.style.Styles;
import org.dominokit.domino.ui.utils.BaseDominoElement;
import org.jboss.gwt.elemento.core.Elements;
import org.jboss.gwt.elemento.core.IsElement;
import org.jboss.gwt.elemento.template.DataElement;
import org.jboss.gwt.elemento.template.Templated;

import javax.annotation.PostConstruct;

import static java.util.Objects.nonNull;
import static org.jboss.gwt.elemento.core.Elements.*;

public class Notification extends BaseDominoElement<HTMLDivElement, Notification> implements IsElement<HTMLDivElement> {

    public static final Position TOP_LEFT = new TopLeftPosition();
    public static final Position TOP_CENTER = new TopCenterPosition();
    public static final Position TOP_RIGHT = new TopRightPosition();

    public static final Position BOTTOM_LEFT = new BottomLeftPosition();
    public static final Position BOTTOM_CENTER = new BottomCenterPosition();
    public static final Position BOTTOM_RIGHT = new BottomRightPosition();

    private HTMLButtonElement closeButton = button()
            .attr("type","button")
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
            .attr("role","alert")
            .attr("data-position","20")
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

    public Notification() {
        init(this);
        elevate(Elevation.LEVEL_1);
    }

    public static Notification createDanger(String message) {
        return create(message, NotificationStyles.ALERT_DANGER);
    }

    public static Notification createSuccess(String message) {
        return create(message, NotificationStyles.ALERT_SUCCESS);
    }

    public static Notification createWarning(String message) {
        return create(message, NotificationStyles.ALERT_WARNING);
    }

    public static Notification createInfo(String message) {
        return create(message, NotificationStyles.ALERT_INFO);
    }

    public static Notification create(String message, String type) {
        Notification notification = create(message);
        notification.style().add(type);
        notification.type = type;
        notification.style().remove(notification.background.getBackground());
        return notification;
    }

    public static Notification create(String message) {
        Notification notification = new Notification();
        notification.messageSpan.textContent = message;
        notification.style().add(notification.background.getBackground());
        notification.closeButton.addEventListener("click", e -> notification.close());
        return notification;
    }

    private void close() {
        int dataPosition = Integer.parseInt(element().getAttribute("data-position"));
        int height = element().offsetHeight;
        element().remove();
        position.onRemoveElement(dataPosition, height);
    }

    public Notification duration(int duration) {
        this.duration = duration;
        return this;
    }

    public Notification inTransition(Transition inTransition) {
        this.inTransition = inTransition;
        return this;
    }

    public Notification outTransition(Transition outTransition) {
        this.outTransition = outTransition;
        return this;
    }

    public Notification setMessage(String message) {
        this.messageSpan.textContent = message;
        return this;
    }

    public Notification appendContent(Node content) {
        element().appendChild(content);
        return this;
    }

    public Notification setPosition(Position position) {
        this.position = position;
        return this;
    }

    public Notification setBackground(Color background) {
        if (nonNull(type)) {
            style().remove(type);
        }

        style().remove(this.background.getBackground());
        style().add(background.getBackground());
        this.background = background;
        return this;
    }

    public Notification show() {
        position.onBeforeAttach(element());
        DomGlobal.document.body.appendChild(element());
        position.onNewElement(element());
        Animation.create(element())
                .transition(inTransition)
                .callback(e -> Animation.create(element())
                        .delay(duration)
                        .transition(outTransition)
                        .callback(e2 -> element().remove())
                        .animate())
                .animate();

        return this;
    }

    @Override
    public HTMLDivElement element() {
        return element;
    }

    public interface Position {
        void onBeforeAttach(HTMLElement element);

        void onNewElement(HTMLElement element);

        void onRemoveElement(int dataPosition, int height);
    }
}
