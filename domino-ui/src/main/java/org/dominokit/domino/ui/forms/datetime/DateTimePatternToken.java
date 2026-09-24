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
package org.dominokit.domino.ui.forms.datetime;

import java.util.Objects;

/** A single token extracted from a GWT date-time format pattern. */
public final class DateTimePatternToken {

  /** Identifies how a pattern token participates in direct date-time entry. */
  public enum Kind {
    NUMERIC,
    LOCALIZED_TEXT,
    DERIVED,
    LITERAL,
    DISPLAY_ONLY
  }

  private final Kind kind;
  private final String pattern;

  public DateTimePatternToken(Kind kind, String pattern) {
    this.kind = Objects.requireNonNull(kind, "kind");
    this.pattern = Objects.requireNonNull(pattern, "pattern");
  }

  public Kind getKind() {
    return kind;
  }

  public String getPattern() {
    return pattern;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (!(o instanceof DateTimePatternToken)) {
      return false;
    }
    DateTimePatternToken that = (DateTimePatternToken) o;
    return kind == that.kind && pattern.equals(that.pattern);
  }

  @Override
  public int hashCode() {
    return Objects.hash(kind, pattern);
  }

  @Override
  public String toString() {
    return "DateTimePatternToken{" + "kind=" + kind + ", pattern='" + pattern + '\'' + '}';
  }
}
