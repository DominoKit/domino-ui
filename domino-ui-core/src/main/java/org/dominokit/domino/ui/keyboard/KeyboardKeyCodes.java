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
package org.dominokit.domino.ui.keyboard;

import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;

/**
 * Enum mapping standard KeyboardEvent.code values (and some legacy aliases) to a Java enum, with
 * convenient lookup by the raw event.code string.
 *
 * <p>Usage: KeyboardKeyCodes key = KeyboardKeyCodes.of(event.code); if (key ==
 * KeyboardKeyCodes.ENTER) { ... }
 */
public enum KeyboardKeyCodes implements KeyboardKeyCode {

  // Special / unknown
  UNIDENTIFIED("Unidentified", ""),

  // Number row
  ESCAPE("Escape"),
  DIGIT_1("Digit1"),
  DIGIT_2("Digit2"),
  DIGIT_3("Digit3"),
  DIGIT_4("Digit4"),
  DIGIT_5("Digit5"),
  DIGIT_6("Digit6"),
  DIGIT_7("Digit7"),
  DIGIT_8("Digit8"),
  DIGIT_9("Digit9"),
  DIGIT_0("Digit0"),
  MINUS("Minus"),
  EQUAL("Equal"),
  BACKSPACE("Backspace"),
  TAB("Tab"),

  // Top letter row
  KEY_Q("KeyQ"),
  KEY_W("KeyW"),
  KEY_E("KeyE"),
  KEY_R("KeyR"),
  KEY_T("KeyT"),
  KEY_Y("KeyY"),
  KEY_U("KeyU"),
  KEY_I("KeyI"),
  KEY_O("KeyO"),
  KEY_P("KeyP"),
  BRACKET_LEFT("BracketLeft"),
  BRACKET_RIGHT("BracketRight"),
  ENTER("Enter"),
  CONTROL_LEFT("ControlLeft"),

  // Home row
  KEY_A("KeyA"),
  KEY_S("KeyS"),
  KEY_D("KeyD"),
  KEY_F("KeyF"),
  KEY_G("KeyG"),
  KEY_H("KeyH"),
  KEY_J("KeyJ"),
  KEY_K("KeyK"),
  KEY_L("KeyL"),
  SEMICOLON("Semicolon"),
  QUOTE("Quote"),
  BACKQUOTE("Backquote"),
  SHIFT_LEFT("ShiftLeft"),
  BACKSLASH("Backslash"),

  // Bottom letter row
  KEY_Z("KeyZ"),
  KEY_X("KeyX"),
  KEY_C("KeyC"),
  KEY_V("KeyV"),
  KEY_B("KeyB"),
  KEY_N("KeyN"),
  KEY_M("KeyM"),
  COMMA("Comma"),
  PERIOD("Period"),
  SLASH("Slash"),
  SHIFT_RIGHT("ShiftRight"),

  // Modifiers & space
  ALT_LEFT("AltLeft"),
  ALT_RIGHT("AltRight"),
  META_LEFT("MetaLeft", "OSLeft"), // OSLeft legacy
  META_RIGHT("MetaRight", "OSRight"),
  CONTROL_RIGHT("ControlRight"),
  CAPS_LOCK("CapsLock"),
  SPACE("Space"),
  CONTEXT_MENU("ContextMenu"),

  // Function keys
  F1("F1"),
  F2("F2"),
  F3("F3"),
  F4("F4"),
  F5("F5"),
  F6("F6"),
  F7("F7"),
  F8("F8"),
  F9("F9"),
  F10("F10"),
  F11("F11"),
  F12("F12"),
  F13("F13"),
  F14("F14"),
  F15("F15"),
  F16("F16"),
  F17("F17"),
  F18("F18"),
  F19("F19"),
  F20("F20"),
  F21("F21"),
  F22("F22"),
  F23("F23"),
  F24("F24"),

  // Numpad
  NUMPAD_0("Numpad0"),
  NUMPAD_1("Numpad1"),
  NUMPAD_2("Numpad2"),
  NUMPAD_3("Numpad3"),
  NUMPAD_4("Numpad4"),
  NUMPAD_5("Numpad5"),
  NUMPAD_6("Numpad6"),
  NUMPAD_7("Numpad7"),
  NUMPAD_8("Numpad8"),
  NUMPAD_9("Numpad9"),
  NUMPAD_DECIMAL("NumpadDecimal"),
  NUMPAD_ADD("NumpadAdd"),
  NUMPAD_SUBTRACT("NumpadSubtract"),
  NUMPAD_MULTIPLY("NumpadMultiply"),
  NUMPAD_DIVIDE("NumpadDivide"),
  NUMPAD_ENTER("NumpadEnter"),
  NUMPAD_EQUAL("NumpadEqual"),
  NUMPAD_COMMA("NumpadComma"),

  // Navigation / editing
  PRINT_SCREEN("PrintScreen"),
  PAUSE("Pause"),
  SCROLL_LOCK("ScrollLock"),
  INSERT("Insert"),
  DELETE("Delete"),
  HOME("Home"),
  END("End"),
  PAGE_UP("PageUp"),
  PAGE_DOWN("PageDown"),
  ARROW_UP("ArrowUp"),
  ARROW_DOWN("ArrowDown"),
  ARROW_LEFT("ArrowLeft"),
  ARROW_RIGHT("ArrowRight"),
  NUM_LOCK("NumLock"),

  // IME / language / international
  KANA_MODE("KanaMode"),
  LANG_1("Lang1"),
  LANG_2("Lang2"),
  LANG_3("Lang3"),
  LANG_4("Lang4"),
  INTL_RO("IntlRo"),
  INTL_BACKSLASH("IntlBackslash"),
  INTL_YEN("IntlYen"),
  CONVERT("Convert"),
  NON_CONVERT("NonConvert"),

  // Editing / system special keys
  UNDO("Undo"),
  CUT("Cut"),
  COPY("Copy"),
  PASTE("Paste"),
  HELP("Help"),

  // Media keys
  MEDIA_TRACK_PREVIOUS("MediaTrackPrevious"),
  MEDIA_TRACK_NEXT("MediaTrackNext"),
  MEDIA_PLAY_PAUSE("MediaPlayPause"),
  MEDIA_STOP("MediaStop"),
  MEDIA_SELECT("MediaSelect"),
  AUDIO_VOLUME_MUTE("AudioVolumeMute"),
  AUDIO_VOLUME_DOWN("AudioVolumeDown", "VolumeDown"),
  AUDIO_VOLUME_UP("AudioVolumeUp", "VolumeUp"),
  EJECT("Eject"),

  // System power
  POWER("Power"),
  SLEEP("Sleep"),
  WAKE_UP("WakeUp"),

  // Browser keys
  BROWSER_HOME("BrowserHome"),
  BROWSER_SEARCH("BrowserSearch"),
  BROWSER_FAVORITES("BrowserFavorites"),
  BROWSER_REFRESH("BrowserRefresh"),
  BROWSER_STOP("BrowserStop"),
  BROWSER_FORWARD("BrowserForward"),
  BROWSER_BACK("BrowserBack"),

  // App launch keys
  LAUNCH_APP1("LaunchApp1"),
  LAUNCH_APP2("LaunchApp2"),
  LAUNCH_MAIL("LaunchMail");

  private final Set<String> codes;

  private static final Map<String, KeyboardKeyCodes> LOOKUP;

  static {
    Map<String, KeyboardKeyCodes> map = new HashMap<>();
    for (KeyboardKeyCodes key : values()) {
      for (String code : key.codes) {
        map.put(code, key);
      }
    }
    LOOKUP = Collections.unmodifiableMap(map);
  }

  KeyboardKeyCodes(String... codes) {
    Set<String> set = new LinkedHashSet<>();
    if (codes != null) {
      for (String c : codes) {
        if (c != null && !c.isEmpty()) {
          set.add(c);
        }
      }
    }
    this.codes = Collections.unmodifiableSet(set);
  }

  @Override
  public Set<String> getCodes() {
    return codes;
  }

  /**
   * Finds the enum constant matching the given KeyboardEvent.code string.
   *
   * <p>Never returns null; returns UNIDENTIFIED for unknown/invalid codes.
   */
  public static KeyboardKeyCodes of(String code) {
    if (code == null) {
      return UNIDENTIFIED;
    }
    return LOOKUP.getOrDefault(code, UNIDENTIFIED);
  }

  /**
   * @return {@code true} if this is any modifier key (Ctrl/Shift/Alt/Meta, any side).
   */
  public boolean isModifier() {
    switch (this) {
      case CONTROL_LEFT:
      case CONTROL_RIGHT:
      case SHIFT_LEFT:
      case SHIFT_RIGHT:
      case ALT_LEFT:
      case ALT_RIGHT:
      case META_LEFT:
      case META_RIGHT:
        return true;
      default:
        return false;
    }
  }

  /**
   * @return {@code true} if this is a lock key (CapsLock, NumLock, ScrollLock).
   */
  public boolean isLockKey() {
    switch (this) {
      case CAPS_LOCK:
      case NUM_LOCK:
      case SCROLL_LOCK:
        return true;
      default:
        return false;
    }
  }

  /**
   * @return {@code true} if this is a navigation / cursor key.
   */
  public boolean isNavigationKey() {
    switch (this) {
      case ARROW_UP:
      case ARROW_DOWN:
      case ARROW_LEFT:
      case ARROW_RIGHT:
      case HOME:
      case END:
      case PAGE_UP:
      case PAGE_DOWN:
      case INSERT:
      case DELETE:
        return true;
      default:
        return false;
    }
  }

  /**
   * @return {@code true} if this is one of the function keys F1..F24.
   */
  public boolean isFunctionKey() {
    switch (this) {
      case F1:
      case F2:
      case F3:
      case F4:
      case F5:
      case F6:
      case F7:
      case F8:
      case F9:
      case F10:
      case F11:
      case F12:
      case F13:
      case F14:
      case F15:
      case F16:
      case F17:
      case F18:
      case F19:
      case F20:
      case F21:
      case F22:
      case F23:
      case F24:
        return true;
      default:
        return false;
    }
  }

  /**
   * @return {@code true} if this is any numpad key.
   */
  public boolean isNumpadKey() {
    switch (this) {
      case NUMPAD_0:
      case NUMPAD_1:
      case NUMPAD_2:
      case NUMPAD_3:
      case NUMPAD_4:
      case NUMPAD_5:
      case NUMPAD_6:
      case NUMPAD_7:
      case NUMPAD_8:
      case NUMPAD_9:
      case NUMPAD_DECIMAL:
      case NUMPAD_ADD:
      case NUMPAD_SUBTRACT:
      case NUMPAD_MULTIPLY:
      case NUMPAD_DIVIDE:
      case NUMPAD_ENTER:
      case NUMPAD_EQUAL:
      case NUMPAD_COMMA:
        return true;
      default:
        return false;
    }
  }
}
