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

/**
 * An enumeration representing various input types for HTML input elements. These input types define
 * the behavior and presentation of the input element.
 *
 * @see <a href="https://developer.mozilla.org/en-US/docs/Web/HTML/Element/input">HTML Input
 *     Element</a>
 */
public enum InputType {
  /** A push button with no default behavior. */
  button,

  /** A checkbox allowing the user to select multiple options from a set. */
  checkbox,

  /** An input control for selecting a color. */
  color,

  /** A control for entering a date (year, month, and day). */
  date,

  /** A control for entering a date and time, including the timezone. */
  datetime,

  /** An input control for entering an email address. */
  email,

  /** An input control for selecting a file to upload. */
  file,

  /** A control that is not displayed but whose value is submitted to the server. */
  hidden,

  /** An input control for displaying an image. */
  image,

  /** A control for entering a month and year. */
  month,

  /** A control for entering a number. */
  number,

  /** A single-line password input field. */
  password,

  /** A radio button allowing the user to select a single option from a set. */
  radio,

  /**
   * A control for entering a number whose exact value is not important (e.g., a slider control).
   */
  range,

  /** A button that resets the form to its initial values. */
  reset,

  /** A single-line text input for entering search strings. */
  search,

  /** A control that allows the user to select among a set of options. */
  select,

  /** A control for entering a telephone number. */
  tel,

  /** A single-line text input. */
  text,

  /** A multi-line text input (textarea). */
  textarea,

  /** A control for entering a time value. */
  time,

  /** A control for entering a URL. */
  url,

  /** A control for entering a week and year. */
  week
}
