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
package org.dominokit.domino.ui.style;

/** Typed custom properties used by Domino UI font theming. */
public final class FontFamily {

  public static final String BODY_PROPERTY = "--dui-font-family";
  public static final String HEADING_PROPERTY = "--dui-font-family-heading";
  public static final String MONO_PROPERTY = "--dui-font-family-mono";

  private FontFamily() {}

  public static CssProperty body(String familyStack) {
    return CssProperty.of(BODY_PROPERTY, familyStack);
  }

  public static CssProperty heading(String familyStack) {
    return CssProperty.of(HEADING_PROPERTY, familyStack);
  }

  public static CssProperty mono(String familyStack) {
    return CssProperty.of(MONO_PROPERTY, familyStack);
  }
}
