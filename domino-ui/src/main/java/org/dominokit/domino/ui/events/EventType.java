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
 * EventType interface.
 *
 * @see <a
 *     href="https://developer.mozilla.org/en-US/docs/Web/Events">https://developer.mozilla.org/en-US/docs/Web/Events</a>
 */
public interface EventType {

  // Network Events
  /** Constant <code>online</code> */
  EventType online = () -> "online";
  /** Constant <code>offline</code> */
  EventType offline = () -> "offline";

  // Focus Events
  /** Constant <code>focus</code> */
  EventType focus = () -> "focus";
  /** Constant <code>blur</code> */
  EventType blur = () -> "blur";

  // Session History Events
  /** Constant <code>pagehide</code> */
  EventType pagehide = () -> "pagehide";
  /** Constant <code>pageshow</code> */
  EventType pageshow = () -> "pageshow";
  /** Constant <code>popstate</code> */
  EventType popstate = () -> "popstate";

  // Form Events
  /** Constant <code>reset</code> */
  EventType reset = () -> "reset";
  /** Constant <code>submit</code> */
  EventType submit = () -> "submit";

  // Printing Events
  /** Constant <code>beforeprint</code> */
  EventType beforeprint = () -> "beforeprint";
  /** Constant <code>afterprint</code> */
  EventType afterprint = () -> "afterprint";

  // Text Composition Events
  /** Constant <code>compositionstart</code> */
  EventType compositionstart = () -> "compositionstart";
  /** Constant <code>compositionupdate</code> */
  EventType compositionupdate = () -> "compositionupdate";
  /** Constant <code>compositionend</code> */
  EventType compositionend = () -> "compositionend";

  // View Events
  /** Constant <code>fullscreenchange</code> */
  EventType fullscreenchange = () -> "fullscreenchange";
  /** Constant <code>fullscreenerror</code> */
  EventType fullscreenerror = () -> "fullscreenerror";
  /** Constant <code>resize</code> */
  EventType resize = () -> "resize";
  /** Constant <code>scroll</code> */
  EventType scroll = () -> "scroll";

  // Clipboard Events
  /** Constant <code>cut</code> */
  EventType cut = () -> "cut";
  /** Constant <code>copy</code> */
  EventType copy = () -> "copy";
  /** Constant <code>paste</code> */
  EventType paste = () -> "paste";

  // Keyboard Events
  /** Constant <code>keydown</code> */
  EventType keydown = () -> "keydown";
  /** Constant <code>keypress</code> */
  EventType keypress = () -> "keypress";
  /** Constant <code>keyup</code> */
  EventType keyup = () -> "keyup";

  // Mouse Events
  /** Constant <code>mouseenter</code> */
  EventType mouseenter = () -> "mouseenter";
  /** Constant <code>mouseover</code> */
  EventType mouseover = () -> "mouseover";
  /** Constant <code>mousemove</code> */
  EventType mousemove = () -> "mousemove";
  /** Constant <code>mousedown</code> */
  EventType mousedown = () -> "mousedown";
  /** Constant <code>mouseup</code> */
  EventType mouseup = () -> "mouseup";
  /** Constant <code>auxclick</code> */
  EventType auxclick = () -> "auxclick";
  /** Constant <code>click</code> */
  EventType click = () -> "click";
  /** Constant <code>dblclick</code> */
  EventType dblclick = () -> "dblclick";
  /** Constant <code>contextmenu</code> */
  EventType contextmenu = () -> "contextmenu";
  /** Constant <code>wheel</code> */
  EventType wheel = () -> "wheel";
  /** Constant <code>mouseleave</code> */
  EventType mouseleave = () -> "mouseleave";
  /** Constant <code>mouseout</code> */
  EventType mouseout = () -> "mouseout";
  /** Constant <code>pointerlockchange</code> */
  EventType pointerlockchange = () -> "pointerlockchange";
  /** Constant <code>pointerlockerror</code> */
  EventType pointerlockerror = () -> "pointerlockerror";

  // Drag & Drop Events
  /** Constant <code>dragstart</code> */
  EventType dragstart = () -> "dragstart";
  /** Constant <code>drag</code> */
  EventType drag = () -> "drag";
  /** Constant <code>dragend</code> */
  EventType dragend = () -> "dragend";
  /** Constant <code>dragenter</code> */
  EventType dragenter = () -> "dragenter";
  /** Constant <code>dragover</code> */
  EventType dragover = () -> "dragover";
  /** Constant <code>dragleave</code> */
  EventType dragleave = () -> "dragleave";
  /** Constant <code>drop</code> */
  EventType drop = () -> "drop";

  // Touch Events
  /** Constant <code>touchcancel</code> */
  EventType touchcancel = () -> "touchcancel";
  /** Constant <code>touchend</code> */
  EventType touchend = () -> "touchend";
  /** Constant <code>touchmove</code> */
  EventType touchmove = () -> "touchmove";
  /** Constant <code>touchstart</code> */
  EventType touchstart = () -> "touchstart";

  // Value Change Events
  /** Constant <code>hashchange</code> */
  EventType hashchange = () -> "hashchange";
  /** Constant <code>input</code> */
  EventType input = () -> "input";
  /** Constant <code>readystatechange</code> */
  EventType readystatechange = () -> "readystatechange";
  /** Constant <code>change</code> */
  EventType change = () -> "change";
  /** Constant <code>search</code> */
  EventType search = () -> "search";

  // Uncategorized Events
  /** Constant <code>invalid</code> */
  EventType invalid = () -> "invalid";
  /** Constant <code>show</code> */
  EventType show = () -> "show";
  /** Constant <code>message</code> */
  EventType message = () -> "message";

  // Storage Events
  /** Constant <code>storage</code> */
  EventType storage = () -> "storage";

  // Window Events
  /** Constant <code>load</code> */
  EventType load = () -> "load";

  // Page Visibility API Events
  /** Constant <code>visibilitychange</code> */
  EventType visibilitychange = () -> "visibilitychange";

  /** @return the name of the event type. */
  /**
   * getName.
   *
   * @return a {@link java.lang.String} object
   */
  String getName();
}
