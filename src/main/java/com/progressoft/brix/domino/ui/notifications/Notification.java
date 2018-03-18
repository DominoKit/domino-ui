package com.progressoft.brix.domino.ui.notifications;

import com.progressoft.brix.domino.ui.animations.Animation;
import com.progressoft.brix.domino.ui.animations.Transition;
import com.progressoft.brix.domino.ui.style.Background;
import elemental2.dom.*;
import org.jboss.gwt.elemento.core.IsElement;
import org.jboss.gwt.elemento.template.DataElement;
import org.jboss.gwt.elemento.template.Templated;

import static java.util.Objects.nonNull;

@Templated
public abstract class Notification implements IsElement<HTMLDivElement> {

    public static final Position TOP_LEFT = new TopLeftPosition();
    public static final Position TOP_CENTER = new TopCenterPosition();
    public static final Position TOP_RIGHT = new TopRightPosition();

    public static final Position BOTTOM_LEFT = new BottomLeftPosition();
    public static final Position BOTTOM_CENTER = new BottomCenterPosition();
    public static final Position BOTTOM_RIGHT = new BottomRightPosition();

    @DataElement
    HTMLButtonElement closeButton;

    @DataElement
    HTMLElement messageSpan;

    private int duration = 4000;
    private Transition inTransition = Transition.FADE_IN;
    private Transition outTransition = Transition.FADE_OUT;
    private Position position = TOP_RIGHT;
    private Background background=Background.BLACK;
    private String type;

    public static Notification createDanger(String message){
        return create(message, "alert-danger");
    }

    public static Notification createSuccess(String message){
        return create(message, "alert-success");
    }

    public static Notification createWarning(String message){
        return create(message, "alert-warning");
    }

    public static Notification createInfo(String message){
        return create(message, "alert-info");
    }

    public static Notification create(String message, String type){
        Notification notification = create(message);
        notification.asElement().classList.add(type);
        notification.type=type;
        notification.asElement().classList.remove(notification.background.getStyle());
        return notification;
    }

    public static Notification create(String message) {
        Notification notification = new Templated_Notification();
        notification.messageSpan.textContent = message;
        notification.asElement().classList.add(notification.background.getStyle());
        notification.closeButton.addEventListener("click", e-> notification.close());
        return notification;
    }

    private  void close() {
        int dataPosition = Integer.parseInt(asElement().getAttribute("data-position"));
        int height=asElement().offsetHeight;
        asElement().remove();
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

    public Notification appendContent(Node content){
        asElement().appendChild(content);
        return this;
    }

    public Notification setPosition(Position position) {
        this.position = position;
        return this;
    }

    public Notification setBackground(Background background){
        if(nonNull(type))
            asElement().classList.remove(type);

        asElement().classList.remove(this.background.getStyle());
        asElement().classList.add(background.getStyle());
        this.background=background;
        return this;
    }

    public Notification show() {
        position.onBeforeAttach(asElement());
        DomGlobal.document.body.appendChild(asElement());
        position.onNewElement(asElement());
        Animation.create(asElement())
                .transition(inTransition)
                .callback(e -> Animation.create(asElement())
                        .delay(duration)
                        .transition(outTransition)
                        .callback(e2 -> asElement().remove())
                        .animate())
                .animate();

        return this;
    }

    public interface Position {
        void onBeforeAttach(HTMLElement element);

        void onNewElement(HTMLElement element);

        void onRemoveElement(int dataPosition, int height);
    }
}
