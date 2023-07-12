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
package org.dominokit.domino.ui.notifications;

import static java.util.Objects.nonNull;

import elemental2.dom.*;
import java.util.ArrayList;
import java.util.List;
import org.dominokit.domino.ui.animations.Animation;
import org.dominokit.domino.ui.animations.Transition;
import org.dominokit.domino.ui.button.RemoveButton;
import org.dominokit.domino.ui.elements.DivElement;
import org.dominokit.domino.ui.elements.SpanElement;
import org.dominokit.domino.ui.events.EventType;
import org.dominokit.domino.ui.style.*;
import org.dominokit.domino.ui.utils.BaseDominoElement;
import org.dominokit.domino.ui.utils.ChildHandler;
import org.dominokit.domino.ui.utils.LazyChild;

/**
 * A component for showing notifications on different position with custom content
 *
 * <p>Customize the component can be done by overwriting classes provided by {@link
 * NotificationStyles} </pre>
 *
 * @see BaseDominoElement
 * @author vegegoku
 * @version $Id: $Id
 */
public class Notification extends BaseDominoElement<HTMLDivElement, Notification>
    implements NotificationStyles {

  private final DivElement element;
  private final DivElement root;
  private final DivElement content;
  private final LazyChild<SpanElement> messageSpan;
  private final LazyChild<RemoveButton> closeButton;

  private int duration = 4000;
  private Transition inTransition = Transition.FADE_IN;
  private Transition outTransition = Transition.FADE_OUT;
  private SwapCssClass position = SwapCssClass.of(dui_ntf_top_left);
  private boolean dismissible = true;
  private boolean infinite = false;
  private boolean closed = true;
  private final List<CloseHandler> closeHandlers = new ArrayList<>();

  /** Constructor for Notification. */
  public Notification() {
    root =
        div()
            .addCss(dui_notification_wrapper, position)
            .appendChild(
                element =
                    div()
                        .appendChild(content = div().addCss(dui_order_first))
                        .addCss(dui_notification));
    messageSpan = LazyChild.of(span(), content);
    closeButton = LazyChild.of(RemoveButton.create().addCss(dui_order_last), element);
    closeButton.whenInitialized(
        () -> {
          closeButton.element().addEventListener(EventType.click.getName(), e -> close());
          element.insertBefore(span().addCss("dui-notification-filler"), closeButton.element());
        });
    init(this);
  }

  /**
   * Creates a notification for the message with no specific type and default black bacjground.
   *
   * @param message the content message
   * @return {@link org.dominokit.domino.ui.notifications.Notification}
   */
  public static Notification create(String message) {
    Notification notification = new Notification();
    notification.setMessage(message);
    return notification;
  }

  /**
   * Creates a notification for the message with no specific type and default black bacjground.
   *
   * @return {@link org.dominokit.domino.ui.notifications.Notification}
   */
  public static Notification create() {
    return new Notification();
  }

  /** {@inheritDoc} */
  @Override
  protected HTMLElement getStyleTarget() {
    return element.element();
  }

  /** {@inheritDoc} */
  @Override
  public HTMLElement getAppendTarget() {
    return content.element();
  }

  /** @return {@link DominoElement<HTMLButtonElement>} the close button of the notification. */
  /**
   * Getter for the field <code>closeButton</code>.
   *
   * @return a {@link org.dominokit.domino.ui.button.RemoveButton} object
   */
  public RemoveButton getCloseButton() {
    return closeButton.get();
  }

  /**
   * Use to show or hide the close button.
   *
   * @return {@link org.dominokit.domino.ui.notifications.Notification}
   * @param dismissible a boolean
   */
  public Notification setDismissible(boolean dismissible) {
    this.dismissible = dismissible;
    closeButton.initOrRemove(dismissible);
    return this;
  }

  /** @return boolean, true if the close button is visible, else false. */
  /**
   * isDismissible.
   *
   * @return a boolean
   */
  public boolean isDismissible() {
    return dismissible;
  }

  /**
   * for none infinite notifications, the duration defined how long the notification will remain
   * visible after the show transition is completed before it is automatically closed.
   *
   * @param duration in millisecond
   * @return {@link org.dominokit.domino.ui.notifications.Notification}
   */
  public Notification setDuration(int duration) {
    this.duration = duration;
    return this;
  }

  /**
   * Defines the animation transition to be applied to show up the notification when {@link
   * Notification#expand()} is called.
   *
   * @param inTransition {@link org.dominokit.domino.ui.animations.Transition}
   * @return {@link org.dominokit.domino.ui.notifications.Notification}
   */
  public Notification inTransition(Transition inTransition) {
    this.inTransition = inTransition;
    return this;
  }

  /**
   * Defines the animation transition to be applied to close up the notification when {@link
   * Notification#close()} is called, or the duration ends.
   *
   * @param outTransition {@link org.dominokit.domino.ui.animations.Transition}
   * @return {@link org.dominokit.domino.ui.notifications.Notification}
   */
  public Notification outTransition(Transition outTransition) {
    this.outTransition = outTransition;
    return this;
  }

  /**
   * The text content of the notification
   *
   * @param message the content message
   * @return {@link org.dominokit.domino.ui.notifications.Notification}
   */
  public Notification setMessage(String message) {
    this.messageSpan.get().setTextContent(message);
    return this;
  }

  /**
   * Defines the location in which the notification will show up when {@link
   * org.dominokit.domino.ui.notifications.Notification#expand()} is called.
   *
   * @param position {@link org.dominokit.domino.ui.notifications.Notification.Position}
   * @return {@link org.dominokit.domino.ui.notifications.Notification}
   */
  public Notification setPosition(Position position) {
    root.addCss(this.position.replaceWith(position.style));
    return this;
  }

  /**
   * When true, duration will be ignored, and the notification will only close if the {@link
   * Notification#close()} is called or close button is clicked.
   *
   * @param infinite true to close manually only, false otherwise
   * @return {@link org.dominokit.domino.ui.notifications.Notification}
   */
  public Notification setInfinite(boolean infinite) {
    this.infinite = infinite;
    return this;
  }

  /** @return boolean, true if notification is finite */
  /**
   * isInfinite.
   *
   * @return a boolean
   */
  public boolean isInfinite() {
    return infinite;
  }

  /** {@inheritDoc} */
  @Override
  public Notification show() {
    return expand();
  }

  /** {@inheritDoc} */
  @Override
  public Notification hide() {
    close();
    return this;
  }

  /**
   * Show up the notification and apply the IN transtion animation.
   *
   * @return {@link org.dominokit.domino.ui.notifications.Notification}
   */
  public Notification expand() {
    this.closed = false;
    Animation.create(element)
        .beforeStart(
            element -> {
              DomGlobal.document.body.appendChild(element());
              NotificationPosition.updatePositions(position);
            })
        .transition(inTransition)
        .callback(
            e -> {
              if (!infinite) {
                close(duration);
              }
            })
        .animate();
    return this;
  }

  /**
   * Closes the notification based on the applied notification position and apply the close
   * animation.ce trans
   */
  public final void close() {
    close(0);
  }

  /**
   * Closes the notification based on the applied notification position and apply the close
   * animation after the specified duration.
   *
   * @param after time to wait before starting the close animation in milliseconds
   */
  public final void close(int after) {
    if (!closed) {
      animateClose(
          after,
          () -> {
            closeHandlers.forEach(CloseHandler::onClose);
            this.closed = true;
          });
    }
  }

  private void animateClose(int after, Runnable onComplete) {
    Animation.create(element)
        .delay(after)
        .transition(outTransition)
        .callback(
            e2 -> {
              element().remove();
              onComplete.run();
              NotificationPosition.updatePositions(position);
            })
        .animate();
  }

  /** @return List of {@link CloseHandler} to be called when a notification is closed. */
  /**
   * Getter for the field <code>closeHandlers</code>.
   *
   * @return a {@link java.util.List} object
   */
  public List<CloseHandler> getCloseHandlers() {
    return closeHandlers;
  }

  /**
   * Add a handler to be called when a notification is closed
   *
   * @param closeHandler {@link org.dominokit.domino.ui.notifications.Notification.CloseHandler}
   * @return {@link org.dominokit.domino.ui.notifications.Notification}
   */
  public Notification addCloseHandler(CloseHandler closeHandler) {
    if (nonNull(closeHandler)) {
      closeHandlers.add(closeHandler);
    }
    return this;
  }

  /**
   * Removes a {@link org.dominokit.domino.ui.notifications.Notification.CloseHandler} from the
   * currently existing close handlers.
   *
   * @param closeHandler A {@link org.dominokit.domino.ui.notifications.Notification.CloseHandler}
   * @return {@link org.dominokit.domino.ui.notifications.Notification}
   */
  public Notification removeCloseHandler(CloseHandler closeHandler) {
    if (nonNull(closeHandler)) {
      closeHandlers.remove(closeHandler);
    }
    return this;
  }

  /**
   * withContent.
   *
   * @param handler a {@link org.dominokit.domino.ui.utils.ChildHandler} object
   * @return a {@link org.dominokit.domino.ui.notifications.Notification} object
   */
  public Notification withContent(ChildHandler<Notification, DivElement> handler) {
    handler.apply(this, content);
    return this;
  }

  /** @return {@link HTMLDivElement} the root element that represent this notification instance. */
  /** {@inheritDoc} */
  @Override
  public HTMLDivElement element() {
    return root.element();
  }

  /** functional interface to handle close event */
  @FunctionalInterface
  public interface CloseHandler {
    void onClose();
  }

  public enum Position {
    TOP_LEFT(NotificationStyles.dui_ntf_top_left),
    TOP_MIDDLE(NotificationStyles.dui_ntf_top_middle),
    TOP_RIGHT(NotificationStyles.dui_ntf_top_right),
    BOTTOM_LEFT(NotificationStyles.dui_ntf_bottom_left),
    BOTTOM_MIDDLE(NotificationStyles.dui_ntf_bottom_middle),
    BOTTOM_RIGHT(NotificationStyles.dui_ntf_bottom_right);

    private CssClass style;

    Position(CssClass style) {
      this.style = style;
    }

    public CssClass getStyle() {
      return style;
    }
  }
}
