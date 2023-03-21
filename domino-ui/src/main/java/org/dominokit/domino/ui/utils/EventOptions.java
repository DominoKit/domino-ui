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
package org.dominokit.domino.ui.utils;

import elemental2.dom.AddEventListenerOptions;

public class EventOptions {
  private final AddEventListenerOptions options;

  public EventOptions() {
    this.options = AddEventListenerOptions.create();
  }

  public EventOptions(boolean capture, boolean once, boolean passive) {
    this.options = AddEventListenerOptions.create();
    this.options.setCapture(capture);
    this.options.setOnce(once);
    this.options.setPassive(passive);
  }

  public static EventOptions of() {
    return new EventOptions();
  }

  public static EventOptions of(boolean capture, boolean once, boolean passive) {
    return new EventOptions(capture, once, passive);
  }

  public EventOptions setPassive(boolean passive) {
    options.setPassive(passive);
    return this;
  }

  public EventOptions setOnce(boolean once) {
    options.setOnce(once);
    return this;
  }

  public EventOptions setCapture(boolean capture) {
    options.setCapture(capture);
    return this;
  }

  public AddEventListenerOptions get() {
    return options;
  }
}
