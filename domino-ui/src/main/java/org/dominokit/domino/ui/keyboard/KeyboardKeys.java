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
import java.util.Locale;
import java.util.Map;
import java.util.Set;

/**
 * Enumeration of keyboard key values with common aliases mapped to a single constant.
 *
 * <p>The enum provides helpers to normalize key strings coming from {@code KeyboardEvent.key} and
 * to classify keys into functional groups such as modifiers, navigation keys, function keys, or
 * numpad keys.
 *
 * <p>Aliases are stored in a lookup map in both original and lower-case forms, enabling
 * case-insensitive matching through {@link #of(String)} while preserving canonical names through
 * {@link #getPrimaryKey()} on the {@link KeyboardKey} interface.
 */
public enum KeyboardKeys implements KeyboardKey {

  // Special / unknown
  UNIDENTIFIED("Unidentified"),

  // Modifier keys
  SHIFT("Shift"),
  CONTROL("Control"),
  ALT("Alt"),
  META("Meta", "OS"),

  // Lock keys
  CAPS_LOCK("CapsLock"),
  NUM_LOCK("NumLock"),
  SCROLL_LOCK("ScrollLock"),

  // Whitespace / editing
  ENTER("Enter"),
  TAB("Tab"),
  SPACE(" ", "Spacebar"),
  BACKSPACE("Backspace"),
  DELETE("Delete", "Del"),
  INSERT("Insert"),
  ESCAPE("Escape", "Esc"),

  // Navigation
  ARROW_UP("ArrowUp", "Up"),
  ARROW_DOWN("ArrowDown", "Down"),
  ARROW_LEFT("ArrowLeft", "Left"),
  ARROW_RIGHT("ArrowRight", "Right"),
  HOME("Home"),
  END("End"),
  PAGE_UP("PageUp"),
  PAGE_DOWN("PageDown"),

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

  // Digits (top row)
  DIGIT_0("0"),
  DIGIT_1("1"),
  DIGIT_2("2"),
  DIGIT_3("3"),
  DIGIT_4("4"),
  DIGIT_5("5"),
  DIGIT_6("6"),
  DIGIT_7("7"),
  DIGIT_8("8"),
  DIGIT_9("9"),

  // Letters (case-insensitive via normalization)
  KEY_A("a", "A"),
  KEY_B("b", "B"),
  KEY_C("c", "C"),
  KEY_D("d", "D"),
  KEY_E("e", "E"),
  KEY_F("f", "F"),
  KEY_G("g", "G"),
  KEY_H("h", "H"),
  KEY_I("i", "I"),
  KEY_J("j", "J"),
  KEY_K("k", "K"),
  KEY_L("l", "L"),
  KEY_M("m", "M"),
  KEY_N("n", "N"),
  KEY_O("o", "O"),
  KEY_P("p", "P"),
  KEY_Q("q", "Q"),
  KEY_R("r", "R"),
  KEY_S("s", "S"),
  KEY_T("t", "T"),
  KEY_U("u", "U"),
  KEY_V("v", "V"),
  KEY_W("w", "W"),
  KEY_X("x", "X"),
  KEY_Y("y", "Y"),
  KEY_Z("z", "Z"),

  // Punctuation / symbols (US layout-ish)
  SEMICOLON(";", ":"),
  EQUAL("=", "+"),
  COMMA(",", "<"),
  MINUS("-", "_"),
  PERIOD(".", ">"),
  SLASH("/", "?"),
  BACKQUOTE("`", "~"),
  BRACKET_LEFT("[", "{"),
  BRACKET_RIGHT("]", "}"),
  BACKSLASH("\\", "|"),
  QUOTE("'", "\""),

  // Numpad keys (key values, not physical codes)
  NUMPAD_0("0"),
  NUMPAD_1("1"),
  NUMPAD_2("2"),
  NUMPAD_3("3"),
  NUMPAD_4("4"),
  NUMPAD_5("5"),
  NUMPAD_6("6"),
  NUMPAD_7("7"),
  NUMPAD_8("8"),
  NUMPAD_9("9"),
  NUMPAD_DECIMAL(".", "Decimal"),
  NUMPAD_ADD("+"),
  NUMPAD_SUBTRACT("-"),
  NUMPAD_MULTIPLY("*"),
  NUMPAD_DIVIDE("/", "Divide"),

  // Media keys
  AUDIO_VOLUME_MUTE("AudioVolumeMute"),
  AUDIO_VOLUME_DOWN("AudioVolumeDown"),
  AUDIO_VOLUME_UP("AudioVolumeUp"),
  MEDIA_PLAY_PAUSE("MediaPlayPause"),
  MEDIA_STOP("MediaStop"),
  MEDIA_TRACK_NEXT("MediaTrackNext"),
  MEDIA_TRACK_PREVIOUS("MediaTrackPrevious"),

  // Browser keys
  BROWSER_BACK("BrowserBack"),
  BROWSER_FORWARD("BrowserForward"),
  BROWSER_REFRESH("BrowserRefresh"),
  BROWSER_STOP("BrowserStop"),
  BROWSER_SEARCH("BrowserSearch"),
  BROWSER_FAVORITES("BrowserFavorites"),
  BROWSER_HOME("BrowserHome"),

  // Application launch keys
  LAUNCH_MAIL("LaunchMail"),
  LAUNCH_APP1("LaunchApp1"),
  LAUNCH_APP2("LaunchApp2"),

  // IME / international
  HANGUL_MODE("HangulMode", "KanaMode"),
  HANJA_MODE("HanjaMode"),
  HANKAKU("Hankaku"),
  ZENKAKU("Zenkaku"),
  ZENKAKU_HANKAKU("ZenkakuHankaku"),
  CONVERT("Convert"),
  NON_CONVERT("NonConvert"),

  // System power
  POWER("Power"),
  SLEEP("Sleep"),
  WAKE_UP("WakeUp");

  // ----------------------------------------------------------------------
  // Implementation
  // ----------------------------------------------------------------------

  private final Set<String> keys;
  private static final Map<String, KeyboardKeys> LOOKUP;

  static {
    Map<String, KeyboardKeys> map = new HashMap<>();
    for (KeyboardKeys kk : values()) {
      for (String k : kk.keys) {
        if (k == null || k.isEmpty()) {
          continue;
        }
        // Store original
        map.put(k, kk);
        // Store lowercase variant for case-insensitive lookup
        String lower = k.toLowerCase(Locale.ROOT);
        map.putIfAbsent(lower, kk);
      }
    }
    LOOKUP = Collections.unmodifiableMap(map);
  }

  KeyboardKeys(String... keys) {
    Set<String> set = new LinkedHashSet<>();
    if (keys != null) {
      for (String k : keys) {
        if (k != null && !k.isEmpty()) {
          set.add(k);
        }
      }
    }
    this.keys = Collections.unmodifiableSet(set);
  }

  @Override
  public Set<String> getKeys() {
    return keys;
  }

  /**
   * Map a KeyboardEvent.key string to a specific enum constant.
   *
   * <ul>
   *   <li>Preserves the single-space value used by {@code KeyboardEvent.key} for Space, then trims
   *       surrounding whitespace for other values
   *   <li>Matches aliases in a case-insensitive manner
   *   <li>Returns {@link #UNIDENTIFIED} for unknown or empty values
   * </ul>
   */
  public static KeyboardKeys of(String key) {
    if (key == null) {
      return UNIDENTIFIED;
    }
    // KeyboardEvent.key reports Space as a single space, which would be lost by trim().
    if (" ".equals(key)) {
      return SPACE;
    }
    String normalized = key.trim();
    if (normalized.isEmpty()) {
      return UNIDENTIFIED;
    }

    KeyboardKeys mapped = LOOKUP.get(normalized);
    if (mapped != null) {
      return mapped;
    }

    String lower = normalized.toLowerCase(Locale.ROOT);
    return LOOKUP.getOrDefault(lower, UNIDENTIFIED);
  }

  /**
   * For key values we usually don't have generic vs specific variants, so this is identity by
   * default.
   *
   * @param other another key to compare against
   * @return {@code true} when the keys are identical, otherwise {@code false}
   */
  public boolean matches(KeyboardKeys other) {
    return other != null && this == other;
  }

  /**
   * Indicates if the key is a modifier key such as Shift, Control, Alt, or Meta.
   *
   * @return {@code true} when the key is a modifier
   */
  public boolean isModifier() {
    switch (this) {
      case SHIFT:
      case CONTROL:
      case ALT:
      case META:
        return true;
      default:
        return false;
    }
  }

  /**
   * Indicates if the key is one of the lock keys (CapsLock, NumLock, ScrollLock).
   *
   * @return {@code true} when the key is a lock key
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
   * Indicates if the key is used for navigation (arrow keys, Home/End, PageUp/PageDown, Insert,
   * Delete).
   *
   * @return {@code true} when the key is a navigation key
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
   * Indicates if the key is a function key (F1–F24).
   *
   * @return {@code true} when the key is a function key
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
   * Indicates if the key belongs to the numpad group.
   *
   * @return {@code true} when the key is a numpad key
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
        return true;
      default:
        return false;
    }
  }
}
