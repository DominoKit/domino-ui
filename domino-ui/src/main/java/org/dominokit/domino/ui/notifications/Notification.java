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
import static org.dominokit.domino.ui.utils.Domino.*;

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
 * Represents a UI notification component.
 *
 * <p>Usage example:
 *
 * <pre>
 * Notification.create("This is a sample message")
 *             .setPosition(Notification.Position.TOP_RIGHT)
 *             .show();
 * </pre>
 *
 * @see NotificationStyles
 * @see BaseDominoElement
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

  /** Constructs a default notification instance. */
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
   * Creates a new notification with the specified message.
   *
   * @param message the message of the notification
   * @return a new notification instance
   */
  public static Notification create(String message) {
    Notification notification = new Notification();
    notification.setMessage(message);
    return notification;
  }

  /**
   * Creates a new default notification.
   *
   * @return a new notification instance
   */
  public static Notification create() {
    return new Notification();
  }

  /**
   * {@inheritDoc}
   *
   * <p>Returns the main element of this notification to which styles can be applied.
   *
   * @return the style target element
   */
  @Override
  protected HTMLElement getStyleTarget() {
    return element.element();
  }

  /**
   * {@inheritDoc}
   *
   * <p>Returns the main content element of this notification to which additional content can be
   * appended.
   *
   * @return the append target element
   */
  @Override
  public HTMLElement getAppendTarget() {
    return content.element();
  }

  /**
   * Retrieves the close button of the notification.
   *
   * @return the close button
   */
  public RemoveButton getCloseButton() {
    return closeButton.get();
  }

  /**
   * Sets whether the notification can be dismissed by the user.
   *
   * @param dismissible true if the notification should be dismissible, false otherwise
   * @return this notification for chaining
   */
  public Notification setDismissible(boolean dismissible) {
    this.dismissible = dismissible;
    closeButton.initOrRemove(dismissible);
    return this;
  }

  /**
   * Checks if the notification is dismissible by the user.
   *
   * @return true if the notification is dismissible, false otherwise
   */
  public boolean isDismissible() {
    return dismissible;
  }

  /**
   * Sets the duration for which the notification will be displayed.
   *
   * @param duration the duration in milliseconds
   * @return this notification for chaining
   */
  public Notification setDuration(int duration) {
    this.duration = duration;
    return this;
  }

  /**
   * Sets the transition animation when the notification is displayed.
   *
   * @param inTransition the in-transition animation
   * @return this notification for chaining
   */
  public Notification inTransition(Transition inTransition) {
    this.inTransition = inTransition;
    return this;
  }

  /**
   * Sets the transition animation when the notification is hidden.
   *
   * @param outTransition the out-transition animation
   * @return this notification for chaining
   */
  public Notification outTransition(Transition outTransition) {
    this.outTransition = outTransition;
    return this;
  }

  /**
   * Sets the message content for the notification.
   *
   * @param message the message to be displayed
   * @return this notification for chaining
   */
  public Notification setMessage(String message) {
    this.messageSpan.get().setTextContent(message);
    return this;
  }

  /**
   * Sets the position for the notification on the screen.
   *
   * @param position the desired position for the notification
   * @return this notification for chaining
   */
  public Notification setPosition(Position position) {
    root.addCss(this.position.replaceWith(position.style));
    return this;
  }

  /**
   * Specifies whether the notification should be displayed indefinitely.
   *
   * @param infinite true if the notification should be displayed indefinitely, false otherwise
   * @return this notification for chaining
   */
  public Notification setInfinite(boolean infinite) {
    this.infinite = infinite;
    return this;
  }

  /**
   * Checks if the notification is set to be displayed indefinitely.
   *
   * @return true if the notification is set to be displayed indefinitely, false otherwise
   */
  public boolean isInfinite() {
    return infinite;
  }

  /**
   * {@inheritDoc}
   *
   * <p>Shows the notification on the screen.
   *
   * @return this notification for chaining
   */
  @Override
  public Notification show() {
    return expand();
  }

  /**
   * {@inheritDoc}
   *
   * <p>Hides the notification from the screen.
   *
   * @return this notification for chaining
   */
  @Override
  public Notification hide() {
    close();
    return this;
  }

  /**
   * Displays the notification on the screen using the set animation and updates its position.
   *
   * @return this notification for chaining
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

  /** Closes the notification immediately. */
  public final void close() {
    close(0);
  }

  /**
   * Closes the notification after a specified delay.
   *
   * @param after the delay in milliseconds after which the notification should be closed
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

  /**
   * Animates the closing of the notification after a specified delay.
   *
   * @param after the delay in milliseconds before initiating the close animation
   * @param onComplete a runnable that will be executed when the animation is complete
   */
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

  /**
   * Retrieves the list of close handlers associated with the notification.
   *
   * @return a list of close handlers
   */
  public List<CloseHandler> getCloseHandlers() {
    return closeHandlers;
  }

  /**
   * Adds a close handler to the notification.
   *
   * @param closeHandler the close handler to be added
   * @return this notification for chaining
   */
  public Notification addCloseHandler(CloseHandler closeHandler) {
    if (nonNull(closeHandler)) {
      closeHandlers.add(closeHandler);
    }
    return this;
  }

  /**
   * Removes a specified close handler from the notification.
   *
   * @param closeHandler the close handler to be removed
   * @return this notification for chaining
   */
  public Notification removeCloseHandler(CloseHandler closeHandler) {
    if (nonNull(closeHandler)) {
      closeHandlers.remove(closeHandler);
    }
    return this;
  }

  /**
   * Adds custom content to the notification.
   *
   * @param handler a handler that will be provided with the notification and its content element
   * @return this notification for chaining
   */
  public Notification withContent(ChildHandler<Notification, DivElement> handler) {
    handler.apply(this, content);
    return this;
  }

  /**
   * Retrieves the root HTMLDivElement of the notification.
   *
   * @return the root HTMLDivElement of the notification
   */
  @Override
  public HTMLDivElement element() {
    return root.element();
  }

  /**
   * A functional interface representing handlers that are triggered when a notification is closed.
   */
  @FunctionalInterface
  public interface CloseHandler {
    /** Triggered when the notification is closed. */
    void onClose();
  }

  /**
   * An enumeration representing the possible positions of a notification on the screen.
   *
   * <p>Example Usage:
   *
   * <pre>
   * Notification notification = Notification.create("This is a notification");
   * notification.setPosition(Position.TOP_LEFT);
   * notification.show();
   * </pre>
   */
  public enum Position {
    /** Represents the top-left position of the screen. */
    TOP_LEFT(NotificationStyles.dui_ntf_top_left),

    /** Represents the top-middle position of the screen. */
    TOP_MIDDLE(NotificationStyles.dui_ntf_top_middle),

    /** Represents the top-right position of the screen. */
    TOP_RIGHT(NotificationStyles.dui_ntf_top_right),

    /** Represents the bottom-left position of the screen. */
    BOTTOM_LEFT(NotificationStyles.dui_ntf_bottom_left),

    /** Represents the bottom-middle position of the screen. */
    BOTTOM_MIDDLE(NotificationStyles.dui_ntf_bottom_middle),

    /** Represents the bottom-right position of the screen. */
    BOTTOM_RIGHT(NotificationStyles.dui_ntf_bottom_right);

    private CssClass style;

    /**
     * Constructs a new {@link Position} enumeration value with the provided style.
     *
     * @param style the {@link CssClass} representing the style of the notification's position.
     */
    Position(CssClass style) {
      this.style = style;
    }

    /**
     * Retrieves the CSS class representing the style of the notification's position.
     *
     * @return the {@link CssClass} of the position.
     */
    public CssClass getStyle() {
      return style;
    }
  }
}
