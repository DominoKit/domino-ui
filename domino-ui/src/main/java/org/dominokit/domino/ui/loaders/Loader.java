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
package org.dominokit.domino.ui.loaders;

import static java.util.Objects.nonNull;

import elemental2.dom.HTMLElement;
import org.dominokit.domino.ui.style.Styles;
import org.dominokit.domino.ui.utils.DominoElement;
import org.gwtproject.timer.client.Timer;
import org.jboss.elemento.IsElement;

/**
 * A component which provides a loader mask on a target element
 *
 * <p>Customize the component can be done by overwriting classes provided by {@link LoaderStyles}
 *
 * <p>For example:
 *
 * <pre>
 *     Loader.create(element, LoaderEffect.PULSE)
 *           .setLoadingText("Loading ...")
 *           .start();
 * </pre>
 */
@Deprecated
public class Loader {

  private final DominoElement<HTMLElement> target;
  private final IsLoader loaderElement;
  private boolean started = false;
  private String width;
  private String height;
  private boolean removeLoadingText = false;

  private LoadingTextPosition loadingTextPosition = LoadingTextPosition.MIDDLE;
  private Timer timeOutTimer;

  /**
   * Creates a loader for a target element with an effect
   *
   * @param target the target element
   * @param effect the {@link LoaderEffect}
   * @return new instance
   */
  public static Loader create(HTMLElement target, LoaderEffect effect) {
    return new Loader(target, effect);
  }

  /**
   * Creates a loader for a target element with an effect
   *
   * @param target the target element
   * @param effect the {@link LoaderEffect}
   * @return new instance
   */
  public static Loader create(IsElement<?> target, LoaderEffect effect) {
    return new Loader(target.element(), effect);
  }

  private Loader(HTMLElement target, LoaderEffect type) {
    this.target = DominoElement.of(target);
    this.loaderElement = LoaderFactory.make(type);
    this.loaderElement.getContentElement().css(loadingTextPosition.getStyle());
    DominoElement.of(this.loaderElement.getElement())
        .addClickListener(
            evt -> {
              evt.preventDefault();
              evt.stopPropagation();
            });
  }

  /**
   * Starts the loading, the loader will keep loading until {@link Loader#stop()} is called
   *
   * @return same instance
   */
  public Loader start() {
    return start(0);
  }
  /**
   * Starts the loading, the loader will keep loading until {@link Loader#stop()} is called
   *
   * @param timeout int delay in milliseconds before automatically stopping the loader.
   * @return same instance
   */
  public Loader start(int timeout) {
    stop();

    if (nonNull(width) && nonNull(height)) {
      loaderElement.setSize(width, height);
    }
    if (removeLoadingText) {
      loaderElement.removeLoadingText();
    }

    target.appendChild(loaderElement.getElement());
    target.addCss("waitMe_container");
    started = true;

    if (timeout > 0) {
      timeOutTimer =
          new Timer() {
            @Override
            public void run() {
              stop();
            }
          };
      timeOutTimer.schedule(timeout);
    }

    return this;
  }

  /**
   * Stops the loading
   *
   * @return same instance
   */
  public Loader stop() {
    if (started) {
      loaderElement.getElement().remove();
      target.removeCss("waitMe_container");
      started = false;
      if (nonNull(timeOutTimer) && timeOutTimer.isRunning()) {
        timeOutTimer.cancel();
      }
    }

    return this;
  }

  /**
   * Sets a loading text which will be shown when the loader starts loading
   *
   * @param text the loading text
   * @return same instance
   */
  public Loader setLoadingText(String text) {
    loaderElement.setLoadingText(text);
    return this;
  }

  /**
   * Sets the width and height for the loader
   *
   * @param width the width
   * @param height the height
   * @return same instance
   */
  public Loader setSize(String width, String height) {
    this.width = width;
    this.height = height;
    return this;
  }

  /**
   * Removes the loading text when loader is shown
   *
   * @param removeLoadingText true to remove the loading text, false otherwise
   * @return same instance
   */
  public Loader setRemoveLoadingText(boolean removeLoadingText) {
    this.removeLoadingText = removeLoadingText;
    return this;
  }

  /** @return True if the loader is started, false otherwise */
  public boolean isStarted() {
    return started;
  }

  /** @return The {@link LoadingTextPosition} */
  public LoadingTextPosition getLoadingTextPosition() {
    return loadingTextPosition;
  }

  /**
   * Sets the position of the loading text
   *
   * @param loadingTextPosition the {@link LoadingTextPosition}
   * @return same instance
   */
  public Loader setLoadingTextPosition(LoadingTextPosition loadingTextPosition) {
    this.loaderElement.getContentElement().removeCss(this.loadingTextPosition.getStyle());
    this.loadingTextPosition = loadingTextPosition;
    if (LoadingTextPosition.MIDDLE.equals(loadingTextPosition)) {
      this.loaderElement.getContentElement().css(Styles.vertical_center);
    } else {
      this.loaderElement.getContentElement().removeCss(Styles.vertical_center);
    }
    this.loaderElement.getContentElement().css(this.loadingTextPosition.getStyle());
    return this;
  }

  /** @return The loader element */
  public IsLoader getLoaderElement() {
    return loaderElement;
  }

  /** An enum representing the position of the loading text based on the loader effect */
  @Deprecated
  public enum LoadingTextPosition {
    TOP(LoaderStyles.LOADING_TOP),
    MIDDLE(LoaderStyles.LOADING_MIDDLE),
    BOTTOM(LoaderStyles.LOADING_BOTTOM);

    private final String style;

    LoadingTextPosition(String style) {
      this.style = style;
    }

    /** @return The css style of the position */
    public String getStyle() {
      return style;
    }
  }
}
