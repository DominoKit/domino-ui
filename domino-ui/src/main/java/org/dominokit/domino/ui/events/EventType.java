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
 * @see <a
 *     href="https://developer.mozilla.org/en-US/docs/Web/Events">https://developer.mozilla.org/en-US/docs/Web/Events</a>
 */
public interface EventType {

  // Network Events
  EventType online = () -> "online";
  EventType offline = () -> "offline";

  // Focus Events
  EventType focus = () -> "focus";
  EventType blur = () -> "blur";

  // Session History Events
  EventType pagehide = () -> "pagehide";
  EventType pageshow = () -> "pageshow";
  EventType popstate = () -> "popstate";

  // Form Events
  EventType reset = () -> "reset";
  EventType submit = () -> "submit";

  // Printing Events
  EventType beforeprint = () -> "beforeprint";
  EventType afterprint = () -> "afterprint";

  // Text Composition Events
  EventType compositionstart = () -> "compositionstart";
  EventType compositionupdate = () -> "compositionupdate";
  EventType compositionend = () -> "compositionend";

  // View Events
  EventType fullscreenchange = () -> "fullscreenchange";
  EventType fullscreenerror = () -> "fullscreenerror";
  EventType resize = () -> "resize";
  EventType scroll = () -> "scroll";

  // Clipboard Events
  EventType cut = () -> "cut";
  EventType copy = () -> "copy";
  EventType paste = () -> "paste";

  // Keyboard Events
  EventType keydown = () -> "keydown";
  EventType keypress = () -> "keypress";
  EventType keyup = () -> "keyup";

  // Mouse Events
  EventType mouseenter = () -> "mouseenter";
  EventType mouseover = () -> "mouseover";
  EventType mousemove = () -> "mousemove";
  EventType mousedown = () -> "mousedown";
  EventType mouseup = () -> "mouseup";
  EventType auxclick = () -> "auxclick";
  EventType click = () -> "click";
  EventType dblclick = () -> "dblclick";
  EventType contextmenu = () -> "contextmenu";
  EventType wheel = () -> "wheel";
  EventType mouseleave = () -> "mouseleave";
  EventType mouseout = () -> "mouseout";
  EventType pointerlockchange = () -> "pointerlockchange";
  EventType pointerlockerror = () -> "pointerlockerror";

  // Drag & Drop Events
  EventType dragstart = () -> "dragstart";
  EventType drag = () -> "drag";
  EventType dragend = () -> "dragend";
  EventType dragenter = () -> "dragenter";
  EventType dragover = () -> "dragover";
  EventType dragleave = () -> "dragleave";
  EventType drop = () -> "drop";

  // Touch Events
  EventType touchcancel = () -> "touchcancel";
  EventType touchend = () -> "touchend";
  EventType touchmove = () -> "touchmove";
  EventType touchstart = () -> "touchstart";

  // Value Change Events
  EventType hashchange = () -> "hashchange";
  EventType input = () -> "input";
  EventType readystatechange = () -> "readystatechange";
  EventType change = () -> "change";
  EventType search = () -> "search";

  // Uncategorized Events
  EventType invalid = () -> "invalid";
  EventType show = () -> "show";
  EventType message = () -> "message";

  // Storage Events
  EventType storage = () -> "storage";

  // Window Events
  EventType load = () -> "load";

  // Page Visibility API Events
  EventType visibilitychange = () -> "visibilitychange";

  /** @return the name of the event type. */
  String getName();
}
