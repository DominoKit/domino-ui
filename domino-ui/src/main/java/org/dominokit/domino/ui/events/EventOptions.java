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
package org.dominokit.domino.ui.events;

import elemental2.dom.AddEventListenerOptions;

/** EventOptions class. */
public class EventOptions {
  private final AddEventListenerOptions options;

  /** Constructor for EventOptions. */
  public EventOptions() {
    this.options = AddEventListenerOptions.create();
  }

  /**
   * Constructor for EventOptions.
   *
   * @param capture a boolean
   * @param once a boolean
   * @param passive a boolean
   */
  public EventOptions(boolean capture, boolean once, boolean passive) {
    this.options = AddEventListenerOptions.create();
    this.options.setCapture(capture);
    this.options.setOnce(once);
    this.options.setPassive(passive);
  }

  /**
   * of.
   *
   * @return a {@link org.dominokit.domino.ui.events.EventOptions} object
   */
  public static EventOptions of() {
    return new EventOptions();
  }

  /**
   * of.
   *
   * @param capture a boolean
   * @param once a boolean
   * @param passive a boolean
   * @return a {@link org.dominokit.domino.ui.events.EventOptions} object
   */
  public static EventOptions of(boolean capture, boolean once, boolean passive) {
    return new EventOptions(capture, once, passive);
  }

  /**
   * setPassive.
   *
   * @param passive a boolean
   * @return a {@link org.dominokit.domino.ui.events.EventOptions} object
   */
  public EventOptions setPassive(boolean passive) {
    options.setPassive(passive);
    return this;
  }

  /**
   * setOnce.
   *
   * @param once a boolean
   * @return a {@link org.dominokit.domino.ui.events.EventOptions} object
   */
  public EventOptions setOnce(boolean once) {
    options.setOnce(once);
    return this;
  }

  /**
   * setCapture.
   *
   * @param capture a boolean
   * @return a {@link org.dominokit.domino.ui.events.EventOptions} object
   */
  public EventOptions setCapture(boolean capture) {
    options.setCapture(capture);
    return this;
  }

  /**
   * get.
   *
   * @return a {@link elemental2.dom.AddEventListenerOptions} object
   */
  public AddEventListenerOptions get() {
    return options;
  }
}
