/*
 * Copyright 2015-2016 Red Hat, Inc, and individual contributors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.dominokit.domino.ui.events;

/**
 * The {@code EventType} interface defines a set of common event types that can be used in event
 * handling. Each event type is represented as a lambda expression that returns the event type name.
 *
 * <p><strong>Usage Example:</strong>
 *
 * <pre>
 * // Register an event listener for the "click" event type
 * EventListener listener = event -> {
 *     // Handle the click event
 * };
 * element.addEventListener(EventType.click.getName(), listener);
 * </pre>
 */
public interface EventType {

  /** Represents the "online" event type. */
  EventType online = () -> "online";

  /** Represents the "offline" event type. */
  EventType offline = () -> "offline";

  /** Represents the "focus" event type. */
  EventType focus = () -> "focus";

  /** Represents the "blur" event type. */
  EventType blur = () -> "blur";

  /** Represents the "pagehide" event type. */
  EventType pagehide = () -> "pagehide";

  /** Represents the "pageshow" event type. */
  EventType pageshow = () -> "pageshow";

  /** Represents the "popstate" event type. */
  EventType popstate = () -> "popstate";

  /** Represents the "reset" event type. */
  EventType reset = () -> "reset";

  /** Represents the "submit" event type. */
  EventType submit = () -> "submit";

  /** Represents the "beforeprint" event type. */
  EventType beforeprint = () -> "beforeprint";

  /** Represents the "afterprint" event type. */
  EventType afterprint = () -> "afterprint";

  /** Represents the "compositionstart" event type. */
  EventType compositionstart = () -> "compositionstart";

  /** Represents the "compositionupdate" event type. */
  EventType compositionupdate = () -> "compositionupdate";

  /** Represents the "compositionend" event type. */
  EventType compositionend = () -> "compositionend";

  /** Represents the "fullscreenchange" event type. */
  EventType fullscreenchange = () -> "fullscreenchange";

  /** Represents the "fullscreenerror" event type. */
  EventType fullscreenerror = () -> "fullscreenerror";

  /** Represents the "resize" event type. */
  EventType resize = () -> "resize";

  /** Represents the "scroll" event type. */
  EventType scroll = () -> "scroll";

  /** Represents the "cut" event type. */
  EventType cut = () -> "cut";

  /** Represents the "copy" event type. */
  EventType copy = () -> "copy";

  /** Represents the "paste" event type. */
  EventType paste = () -> "paste";

  /** Represents the "keydown" event type. */
  EventType keydown = () -> "keydown";

  /** Represents the "keypress" event type. */
  EventType keypress = () -> "keypress";

  /** Represents the "keyup" event type. */
  EventType keyup = () -> "keyup";

  /** Represents the "mouseenter" event type. */
  EventType mouseenter = () -> "mouseenter";

  /** Represents the "mouseover" event type. */
  EventType mouseover = () -> "mouseover";

  /** Represents the "mousemove" event type. */
  EventType mousemove = () -> "mousemove";

  /** Represents the "mousedown" event type. */
  EventType mousedown = () -> "mousedown";

  /** Represents the "mouseup" event type. */
  EventType mouseup = () -> "mouseup";

  /** Represents the "auxclick" event type. */
  EventType auxclick = () -> "auxclick";

  /** Represents the "click" event type. */
  EventType click = () -> "click";

  /** Represents the "dblclick" event type. */
  EventType dblclick = () -> "dblclick";

  /** Represents the "contextmenu" event type. */
  EventType contextmenu = () -> "contextmenu";

  /** Represents the "wheel" event type. */
  EventType wheel = () -> "wheel";

  /** Represents the "mouseleave" event type. */
  EventType mouseleave = () -> "mouseleave";

  /** Represents the "mouseout" event type. */
  EventType mouseout = () -> "mouseout";

  /** Represents the "pointerlockchange" event type. */
  EventType pointerlockchange = () -> "pointerlockchange";

  /** Represents the "pointerlockerror" event type. */
  EventType pointerlockerror = () -> "pointerlockerror";

  /** Represents the "dragstart" event type. */
  EventType dragstart = () -> "dragstart";

  /** Represents the "drag" event type. */
  EventType drag = () -> "drag";

  /** Represents the "dragend" event type. */
  EventType dragend = () -> "dragend";

  /** Represents the "dragenter" event type. */
  EventType dragenter = () -> "dragenter";

  /** Represents the "dragover" event type. */
  EventType dragover = () -> "dragover";

  /** Represents the "dragleave" event type. */
  EventType dragleave = () -> "dragleave";

  /** Represents the "drop" event type. */
  EventType drop = () -> "drop";

  /** Represents the "touchcancel" event type. */
  EventType touchcancel = () -> "touchcancel";

  /** Represents the "touchend" event type. */
  EventType touchend = () -> "touchend";

  /** Represents the "touchmove" event type. */
  EventType touchmove = () -> "touchmove";

  /** Represents the "touchstart" event type. */
  EventType touchstart = () -> "touchstart";

  /** Represents the "hashchange" event type. */
  EventType hashchange = () -> "hashchange";

  /** Represents the "input" event type. */
  EventType input = () -> "input";

  /** Represents the "readystatechange" event type. */
  EventType readystatechange = () -> "readystatechange";

  /** Represents the "change" event type. */
  EventType change = () -> "change";

  /** Represents the "search" event type. */
  EventType search = () -> "search";

  /** Represents the "invalid" event type. */
  EventType invalid = () -> "invalid";

  /** Represents the "show" event type. */
  EventType show = () -> "show";

  /** Represents the "message" event type. */
  EventType message = () -> "message";

  /** Represents the "storage" event type. */
  EventType storage = () -> "storage";

  /** Represents the "load" event type. */
  EventType load = () -> "load";

  /** Represents the "visibilitychange" event type. */
  EventType visibilitychange = () -> "visibilitychange";

  /**
   * Retrieves the name of the event type.
   *
   * @return The name of the event type.
   */
  String getName();
}
