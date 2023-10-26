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
import static org.dominokit.domino.ui.loaders.LoaderStyles.*;
import static org.dominokit.domino.ui.style.GenericCss.dui_vertical_center;
import static org.dominokit.domino.ui.utils.ElementsFactory.elements;

import elemental2.dom.Element;
import elemental2.dom.HTMLElement;
import org.dominokit.domino.ui.IsElement;
import org.dominokit.domino.ui.style.*;
import org.dominokit.domino.ui.utils.DominoElement;
import org.gwtproject.timer.client.Timer;

/**
 * The Loader class is responsible for displaying loading animations on a target DOM element.
 *
 * <p><b>Usage:</b>
 *
 * <pre>
 * Loader loader = Loader.create(someElement, LoaderEffect.SOME_EFFECT);
 * loader.start();
 * // ... do some work
 * loader.stop();
 * </pre>
 */
public class Loader {

  private final DominoElement<Element> target;
  private final IsLoader loaderElement;
  private boolean started = false;
  private String width;
  private String height;
  private boolean removeLoadingText = false;

  private Timer timeOutTimer;

  private SwapCssClass loadingPosition = SwapCssClass.of(LoadingTextPosition.MIDDLE.style);

  /**
   * Static factory method to create a Loader instance.
   *
   * @param target The target HTMLElement where the loader will be shown.
   * @param effect The loading effect to be applied.
   * @return A new Loader instance.
   */
  public static Loader create(HTMLElement target, LoaderEffect effect) {
    return new Loader(target, effect);
  }

  /**
   * Static factory method to create a Loader instance.
   *
   * @param target The target IsElement where the loader will be shown.
   * @param effect The loading effect to be applied.
   * @return A new Loader instance.
   */
  public static Loader create(IsElement<?> target, LoaderEffect effect) {
    return new Loader(target.element(), effect);
  }

  /**
   * Private constructor for the Loader class.
   *
   * @param target The target Element where the loader will be shown.
   * @param type The type of loader effect to be applied.
   */
  private Loader(Element target, LoaderEffect type) {
    this.target = elements.elementOf(target);
    this.loaderElement = LoaderFactory.make(type);
    this.loaderElement.getContentElement().addCss(loadingPosition);
  }

  /**
   * Start the loader without any timeout.
   *
   * @return The current Loader instance.
   */
  public Loader start() {
    return start(0);
  }

  /**
   * Start the loader with a specified timeout.
   *
   * @param timeout The time in milliseconds after which the loader should stop automatically.
   * @return The current Loader instance.
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
    target.addCss(waitme_container);
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
   * Stops the loader.
   *
   * @return The current Loader instance.
   */
  public Loader stop() {
    if (started) {
      loaderElement.getElement().remove();
      target.removeCss(waitme_container);
      started = false;
      if (nonNull(timeOutTimer) && timeOutTimer.isRunning()) {
        timeOutTimer.cancel();
      }
    }

    return this;
  }

  /**
   * Set the text to be displayed during loading.
   *
   * @param text The loading text.
   * @return The current Loader instance.
   */
  public Loader setLoadingText(String text) {
    loaderElement.setLoadingText(text);
    return this;
  }

  /**
   * Set the size for the loader.
   *
   * @param width Width of the loader.
   * @param height Height of the loader.
   * @return The current Loader instance.
   */
  public Loader setSize(String width, String height) {
    this.width = width;
    this.height = height;
    return this;
  }

  /**
   * Configure the loader to remove the loading text.
   *
   * @param removeLoadingText Whether to remove the loading text or not.
   * @return The current Loader instance.
   */
  public Loader setRemoveLoadingText(boolean removeLoadingText) {
    this.removeLoadingText = removeLoadingText;
    return this;
  }

  /**
   * Check if the loader has started.
   *
   * @return {@code true} if the loader is running, otherwise {@code false}.
   */
  public boolean isStarted() {
    return started;
  }

  /**
   * Set the position for the loading text.
   *
   * @param loadingTextPosition The desired position for the loading text.
   * @return The current Loader instance.
   */
  public Loader setLoadingTextPosition(LoadingTextPosition loadingTextPosition) {
    this.loaderElement
        .getContentElement()
        .addCss(loadingPosition.replaceWith(loadingTextPosition.style));
    return this;
  }

  /**
   * Get the current loader element being used.
   *
   * @return The loader element.
   */
  public IsLoader getLoaderElement() {
    return loaderElement;
  }

  /** Enum to represent the possible positions for the loading text. */
  public enum LoadingTextPosition {
    TOP(LoaderStyles.loading_top),
    MIDDLE(CompositeCssClass.of(loading_middle, dui_vertical_center)),
    BOTTOM(loading_bottom);

    private final CssClass style;

    /**
     * Constructor for LoadingTextPosition.
     *
     * @param style The style to apply for the position.
     */
    LoadingTextPosition(CssClass style) {
      this.style = style;
    }

    /**
     * Get the CSS style associated with the position.
     *
     * @return The style.
     */
    public CssClass getStyle() {
      return style;
    }
  }
}
