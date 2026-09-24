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
package org.dominokit.domino.ui.themes;

import elemental2.dom.Element;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/** A theme-manager operation and the complete theme selections before and after it. */
public final class ThemeChange {

  /** Whether the change affects the application body or one element. */
  public enum Scope {
    GLOBAL,
    ELEMENT
  }

  /** The manager operation that caused the change. */
  public enum Operation {
    APPLY,
    REMOVE
  }

  private final Scope scope;
  private final Operation operation;
  private final Element target;
  private final String category;
  private final IsDominoTheme previousTheme;
  private final IsDominoTheme currentTheme;
  private final Map<String, IsDominoTheme> previousThemes;
  private final Map<String, IsDominoTheme> currentThemes;

  ThemeChange(
      Scope scope,
      Operation operation,
      Element target,
      String category,
      IsDominoTheme previousTheme,
      IsDominoTheme currentTheme,
      Map<String, IsDominoTheme> previousThemes,
      Map<String, IsDominoTheme> currentThemes) {
    this.scope = Objects.requireNonNull(scope);
    this.operation = Objects.requireNonNull(operation);
    this.target = Objects.requireNonNull(target);
    this.category = Objects.requireNonNull(category);
    this.previousTheme = previousTheme;
    this.currentTheme = currentTheme;
    this.previousThemes = Collections.unmodifiableMap(new HashMap<>(previousThemes));
    this.currentThemes = Collections.unmodifiableMap(new HashMap<>(currentThemes));
  }

  public Scope getScope() {
    return scope;
  }

  public Operation getOperation() {
    return operation;
  }

  /** The themed element, or {@code document.body} for a global change. */
  public Element getTarget() {
    return target;
  }

  public String getCategory() {
    return category;
  }

  /** The previously selected theme in the affected category, or {@code null}. */
  public IsDominoTheme getPreviousTheme() {
    return previousTheme;
  }

  /** The newly selected theme in the affected category, or {@code null} after removal. */
  public IsDominoTheme getCurrentTheme() {
    return currentTheme;
  }

  /**
   * An unmodifiable snapshot of all selections before the operation, keyed by category. This
   * includes no-class clear descriptors because the manager persists them as selections.
   */
  public Map<String, IsDominoTheme> getPreviousThemes() {
    return previousThemes;
  }

  /** An unmodifiable snapshot of all selections after the operation, keyed by category. */
  public Map<String, IsDominoTheme> getCurrentThemes() {
    return currentThemes;
  }
}
