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

import static java.util.Objects.nonNull;

import elemental2.core.JsArray;
import elemental2.core.JsRegExp;
import elemental2.core.JsString;
import elemental2.dom.HTMLInputElement;
import elemental2.dom.KeyboardEvent;
import java.util.List;
import java.util.function.Consumer;
import java.util.stream.Collectors;
import org.dominokit.domino.ui.forms.InputFormField;

/** A utility that provides masking feature on input elements based on pattern and regex */
public class Mask {

  private final HTMLInputElement element;
  private JsRegExp regex;
  private String pattern;
  private final List<Character> slots;
  private final Consumer<String> onPatternMatched;
  private Consumer<String> onPatternNotMatched;
  private int[] prev;
  private int first;
  private boolean back;

  private Mask(
      HTMLInputElement element,
      String pattern,
      String regex,
      String slots,
      Consumer<String> onPatternMatched,
      Consumer<String> onPatternNotMatched) {
    this.element = element;
    this.regex = new JsRegExp(regex, "g");
    this.slots = slots.chars().mapToObj(e -> (char) e).collect(Collectors.toList());
    this.onPatternMatched = onPatternMatched;
    this.onPatternNotMatched = onPatternNotMatched;
    setPattern(pattern);
    element.addEventListener(
        "keydown",
        evt -> {
          KeyboardEvent ke = (KeyboardEvent) evt;
          back = ke.key.equals("Backspace");
        });
    element.addEventListener("input", evt -> update());
  }

  /**
   * Build mask for {@link org.dominokit.domino.ui.forms.InputFormField}
   *
   * @param valueBox {@link org.dominokit.domino.ui.forms.InputFormField}
   * @return {@link org.dominokit.domino.ui.utils.Mask.MaskingBuilder}
   */
  public static MaskingBuilder of(InputFormField<?, HTMLInputElement, ?> valueBox) {
    return of(valueBox.getInputElement().element());
  }

  /**
   * Build mask for HTML input element
   *
   * @param element {@link elemental2.dom.HTMLInputElement}
   * @return {@link org.dominokit.domino.ui.utils.Mask.MaskingBuilder}
   */
  public static MaskingBuilder of(HTMLInputElement element) {
    return new MaskingBuilder(element);
  }

  private void update() {
    String value = element.value.substring(0, element.selectionStart);
    char[] chars = format(value);
    boolean filled = false;
    int nextDataSlot = -1;
    for (int i1 = 0; i1 < chars.length; i1++) {
      if (slots.contains(chars[i1])) {
        nextDataSlot = i1;
        break;
      }
    }
    int next;
    if (nextDataSlot < 0) {
      next = prev[prev.length - 1];
      filled = true;
    } else {
      if (back) {
        nextDataSlot = nextDataSlot - 1;
        if (nextDataSlot >= 0 && nextDataSlot < prev.length) {
          next = prev[nextDataSlot];
        } else {
          next = first;
        }
      } else {
        next = nextDataSlot;
      }
    }
    element.value = String.valueOf(format(value));
    element.setSelectionRange(next, next);
    back = false;
    if (filled) {
      JsArray<String> match = new JsString(element.value).match(regex);
      if (nonNull(match)) {
        onPatternMatched.accept(element.value);
      } else {
        onPatternNotMatched.accept(element.value);
      }
    }
  }

  private char[] format(String input) {
    char[] chars = new char[pattern.length()];
    int inputIndex = 0;
    char[] charArray = pattern.toCharArray();
    for (int i = 0; i < charArray.length; i++) {
      char c = charArray[i];
      if ((inputIndex < input.length() && input.charAt(inputIndex) == c) || slots.contains(c)) {
        if (inputIndex < input.length()) {
          chars[i] = input.charAt(inputIndex);
          inputIndex++;
        } else {
          chars[i] = c;
        }
      } else {
        chars[i] = c;
      }
    }
    return chars;
  }

  /** @return the element value */
  /**
   * getValue.
   *
   * @return a {@link java.lang.String} object
   */
  public String getValue() {
    return element.value;
  }

  /** @return the pattern */
  /**
   * Getter for the field <code>pattern</code>.
   *
   * @return a {@link java.lang.String} object
   */
  public String getPattern() {
    return pattern;
  }

  /** @param pattern the new pattern */
  /**
   * Setter for the field <code>pattern</code>.
   *
   * @param pattern a {@link java.lang.String} object
   */
  public void setPattern(String pattern) {
    this.pattern = pattern;
    prev = new int[this.pattern.length()];
    int actualIndex = 1;
    int visibleIndex = 0;
    char[] chars = this.pattern.toCharArray();
    for (int i = 0; i < chars.length; i++) {
      if (this.slots.contains(chars[i])) {
        prev[i] = actualIndex;
        visibleIndex = actualIndex;
      } else {
        prev[i] = visibleIndex;
      }
      actualIndex++;
    }
    for (int i = 0; i < chars.length; i++) {
      if (this.slots.contains(chars[i])) {
        first = i;
        break;
      }
    }
  }

  /** @param regex the regex to check if the value matches the expected input */
  /**
   * Setter for the field <code>regex</code>.
   *
   * @param regex a {@link java.lang.String} object
   */
  public void setRegex(String regex) {
    this.regex = new JsRegExp(regex, "g");
  }

  /**
   * onPatternNotMatched.
   *
   * @param onPatternNotMatched a consumer that will be called when the value is filled but it does
   *     not match the pattern
   */
  public void onPatternNotMatched(Consumer<String> onPatternNotMatched) {
    this.onPatternNotMatched = onPatternNotMatched;
  }

  /** A builder class for {@link Mask} */
  public static class MaskingBuilder {
    private final HTMLInputElement element;
    private String regex;
    private String slots;
    private Consumer<String> onPatternMatched;
    private String pattern;
    private Consumer<String> onPatternNotMatched;

    public MaskingBuilder(HTMLInputElement element) {
      this.element = element;
    }

    public MaskingBuilder pattern(String pattern) {
      this.pattern = pattern;
      return this;
    }

    public MaskingBuilder regex(String regex) {
      this.regex = regex;
      return this;
    }

    public MaskingBuilder dataSlots(String slots) {
      this.slots = slots;
      return this;
    }

    public MaskingBuilder onPatternMatched(Consumer<String> onPatternMatched) {
      this.onPatternMatched = onPatternMatched;
      return this;
    }

    public MaskingBuilder onPatternNotMatched(Consumer<String> onPatternNotMatched) {
      this.onPatternNotMatched = onPatternNotMatched;
      return this;
    }

    public Mask build() {
      return new Mask(element, pattern, regex, slots, onPatternMatched, onPatternNotMatched);
    }
  }
}
