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

import static org.dominokit.domino.ui.forms.datetime.DateTimePatternToken.Kind.LOCALIZED_TEXT;
import static org.dominokit.domino.ui.forms.datetime.DateTimePatternToken.Kind.NUMERIC;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/** Holds an uncommitted overwrite session for a tokenized date-time pattern. */
public final class DateTimeTypingSession {

  private final List<TokenState> states;
  private int activeStateIndex;
  private boolean editingActiveToken;
  private boolean modified;

  private DateTimeTypingSession(List<TokenState> states) {
    this.states = states;
    this.activeStateIndex = findEditableState(0, 1);
  }

  /** Creates an empty session that presents editable tokens as their pattern placeholders. */
  public static DateTimeTypingSession empty(List<DateTimePatternToken> tokens) {
    return create(tokens, new ArrayList<>());
  }

  /**
   * Creates a session prefilled with values for editable tokens in their appearance order.
   *
   * @param tokens tokenized pattern
   * @param values formatted values for editable tokens only
   * @return a session ready for overwrite input
   */
  public static DateTimeTypingSession withTokenValues(
      List<DateTimePatternToken> tokens, List<String> values) {
    return create(tokens, new ArrayList<>(Objects.requireNonNull(values, "values")));
  }

  /**
   * Creates a session prefilled with values aligned to every pattern token.
   *
   * <p>Literal token values are ignored because literals are always rendered from their pattern.
   */
  public static DateTimeTypingSession withValues(
      List<DateTimePatternToken> tokens, List<String> values) {
    Objects.requireNonNull(tokens, "tokens");
    Objects.requireNonNull(values, "values");
    if (tokens.size() != values.size()) {
      throw new IllegalArgumentException("A value is required for every date-time pattern token");
    }
    List<TokenState> states = new ArrayList<>();
    for (int index = 0; index < tokens.size(); index++) {
      states.add(new TokenState(tokens.get(index), values.get(index)));
    }
    return new DateTimeTypingSession(states);
  }

  private static DateTimeTypingSession create(
      List<DateTimePatternToken> tokens, List<String> editableValues) {
    Objects.requireNonNull(tokens, "tokens");
    List<TokenState> states = new ArrayList<>();
    int suppliedValueIndex = 0;
    for (DateTimePatternToken token : tokens) {
      String value = null;
      if (isEditable(token)) {
        if (suppliedValueIndex < editableValues.size()) {
          value = editableValues.get(suppliedValueIndex);
          suppliedValueIndex++;
        }
      }
      states.add(new TokenState(token, value));
    }
    if (suppliedValueIndex != editableValues.size()) {
      throw new IllegalArgumentException("More token values supplied than editable pattern tokens");
    }
    return new DateTimeTypingSession(states);
  }

  /** Replaces the active token's content with the supplied text using overwrite semantics. */
  public void overwrite(String value) {
    Objects.requireNonNull(value, "value");
    if (activeStateIndex < 0 || value.isEmpty()) {
      return;
    }
    TokenState state = states.get(activeStateIndex);
    if (!editingActiveToken) {
      state.value = "";
      editingActiveToken = true;
      modified = true;
    }
    int remaining = Math.max(0, maxInputLength(state.token) - state.value.length());
    if (remaining == 0) {
      moveNext();
      overwrite(value);
      return;
    }
    int consumed = Math.min(remaining, value.length());
    state.value += value.substring(0, consumed);
    if (state.value.length() >= maxInputLength(state.token) || shouldAdvancePastLiteral(state)) {
      moveNext();
      if (consumed < value.length()) {
        overwrite(value.substring(consumed));
      }
    }
  }

  /** Moves the active position to the following editable token. */
  public void moveNext() {
    if (activeStateIndex >= 0) {
      activeStateIndex = findEditableState(activeStateIndex + 1, 1);
      editingActiveToken = false;
    }
  }

  /** Moves the active position to the previous editable token. */
  public void movePrevious() {
    if (activeStateIndex >= 0) {
      activeStateIndex = findEditableState(activeStateIndex - 1, -1);
      editingActiveToken = false;
    }
  }

  /** Removes the last typed character from the active token. */
  public void backspace() {
    if (activeStateIndex < 0) {
      return;
    }
    TokenState state = states.get(activeStateIndex);
    if (state.value != null && !state.value.isEmpty()) {
      state.value = state.value.substring(0, state.value.length() - 1);
      editingActiveToken = true;
      modified = true;
    }
  }

  /**
   * Consumes a literal separator when it belongs next to the active token.
   *
   * <p>Separators rendered by automatic numeric-token advance are already present before the active
   * token, so entering the same separator is intentionally a no-op rather than skipping a token.
   *
   * @return {@code true} when the literal belongs to this pattern
   */
  public boolean acceptLiteral(String literal) {
    Objects.requireNonNull(literal, "literal");
    if (activeStateIndex < 0 || literal.isEmpty()) {
      return false;
    }
    if (matchesLiteral(activeStateIndex - 1, literal)) {
      return true;
    }
    if (matchesLiteral(activeStateIndex + 1, literal)) {
      moveNext();
      return true;
    }
    return false;
  }

  /**
   * @return the active editable token, or {@code null} when the session has no editable token.
   */
  public DateTimePatternToken getActiveToken() {
    return activeStateIndex < 0 ? null : states.get(activeStateIndex).token;
  }

  /**
   * @return the selection start for the active token in {@link #getDisplayText()}.
   */
  public int getActiveTokenStart() {
    int start = 0;
    for (int index = 0; index < activeStateIndex; index++) {
      start += displayValue(states.get(index)).length();
    }
    return start;
  }

  /**
   * @return the selection end for the active token in {@link #getDisplayText()}.
   */
  public int getActiveTokenEnd() {
    return activeStateIndex < 0
        ? getDisplayText().length()
        : getActiveTokenStart() + displayValue(states.get(activeStateIndex)).length();
  }

  /**
   * @return whether every editable token has a complete value.
   */
  public boolean isComplete() {
    for (int index = 0; index < states.size(); index++) {
      TokenState state = states.get(index);
      if (isEditable(state.token)
          && (state.value == null || state.value.length() < minInputLength(state.token))) {
        return false;
      }
    }
    return true;
  }

  /**
   * @return whether the session has changed an editable token.
   */
  public boolean isModified() {
    return modified;
  }

  /**
   * @return the rendered value with literals and unfilled pattern placeholders retained.
   */
  public String getDisplayText() {
    StringBuilder display = new StringBuilder();
    for (int index = 0; index < states.size(); index++) {
      TokenState state = states.get(index);
      display.append(displayValue(state));
    }
    return display.toString();
  }

  /**
   * Returns the parser pattern containing only editable tokens and the literals that connect them.
   *
   * <p>Derived and display-only tokens are omitted with their immediately following literal. For
   * example, {@code EEEE, MMMM d, yyyy} becomes {@code MMMM d, yyyy}.
   */
  public String getCandidatePattern() {
    return getCandidate(true);
  }

  /** Returns the candidate text corresponding to {@link #getCandidatePattern()}. */
  public String getCandidateText() {
    if (!isComplete()) {
      throw new IllegalStateException("An incomplete typing session cannot produce a candidate");
    }
    return getCandidate(false);
  }

  private int findEditableState(int start, int step) {
    for (int index = start; index >= 0 && index < states.size(); index += step) {
      if (isEditable(states.get(index).token)) {
        return index;
      }
    }
    return activeStateIndex;
  }

  private boolean matchesLiteral(int stateIndex, String literal) {
    return stateIndex >= 0
        && stateIndex < states.size()
        && states.get(stateIndex).token.getKind() == DateTimePatternToken.Kind.LITERAL
        && states.get(stateIndex).token.getPattern().contains(literal);
  }

  /**
   * Advances variable-width numeric tokens once their first digit cannot begin a valid two-digit
   * value. This lets a user replace {@code 2:38 PM} with {@code 3:05 PM} by typing {@code 3},
   * {@code 0}, {@code 5}, while retaining two-digit entry such as {@code 10:05 AM}.
   */
  private boolean shouldAdvancePastLiteral(TokenState state) {
    return state.token.getKind() == NUMERIC
        && state.value.length() == 1
        && isFollowedByLiteralAndEditableToken()
        && cannotStartValidTwoDigitValue(state.token, state.value);
  }

  private boolean isFollowedByLiteralAndEditableToken() {
    return activeStateIndex + 2 < states.size()
        && states.get(activeStateIndex + 1).token.getKind() == DateTimePatternToken.Kind.LITERAL
        && isEditable(states.get(activeStateIndex + 2).token);
  }

  private static boolean cannotStartValidTwoDigitValue(DateTimePatternToken token, String value) {
    Integer maximum = maximumNumericValue(token);
    return maximum != null && Integer.parseInt(value) * 10 > maximum;
  }

  private static Integer maximumNumericValue(DateTimePatternToken token) {
    char symbol = token.getPattern().charAt(0);
    switch (symbol) {
      case 'M':
      case 'L':
      case 'h':
        return 12;
      case 'H':
        return 23;
      case 'K':
        return 11;
      case 'k':
        return 24;
      case 'd':
        return 31;
      case 'm':
      case 's':
        return 59;
      default:
        return null;
    }
  }

  private static boolean isEditable(DateTimePatternToken token) {
    return token.getKind() == NUMERIC || token.getKind() == LOCALIZED_TEXT;
  }

  private static int minInputLength(DateTimePatternToken token) {
    if (token.getKind() != NUMERIC) {
      return 1;
    }
    return token.getPattern().length() == 1 ? 1 : token.getPattern().length();
  }

  private static int maxInputLength(DateTimePatternToken token) {
    if (token.getKind() == LOCALIZED_TEXT) {
      return Integer.MAX_VALUE;
    }
    char symbol = token.getPattern().charAt(0);
    switch (symbol) {
      case 'd':
      case 'M':
      case 'L':
      case 'H':
      case 'h':
      case 'K':
      case 'k':
      case 'm':
      case 's':
        return 2;
      case 'y':
        return Math.max(2, token.getPattern().length());
      default:
        return token.getPattern().length();
    }
  }

  private static String displayValue(TokenState state) {
    if (state.value == null) {
      return state.token.getPattern();
    }
    if (state.value.length() >= state.token.getPattern().length()) {
      return state.value;
    }
    return state.value + state.token.getPattern().substring(state.value.length());
  }

  private String getCandidate(boolean pattern) {
    StringBuilder candidate = new StringBuilder();
    boolean skipFollowingLiteral = false;
    for (int index = 0; index < states.size(); index++) {
      TokenState state = states.get(index);
      if (state.token.getKind() == DateTimePatternToken.Kind.DERIVED
          || state.token.getKind() == DateTimePatternToken.Kind.DISPLAY_ONLY) {
        skipFollowingLiteral = true;
        continue;
      }
      if (state.token.getKind() == DateTimePatternToken.Kind.LITERAL) {
        if (skipFollowingLiteral || isDisplayOnlyOrDerived(index + 1)) {
          skipFollowingLiteral = false;
        } else {
          candidate.append(state.token.getPattern());
        }
      } else {
        skipFollowingLiteral = false;
        candidate.append(pattern ? state.token.getPattern() : state.value);
      }
    }
    return candidate.toString();
  }

  private boolean isDisplayOnlyOrDerived(int stateIndex) {
    if (stateIndex < 0 || stateIndex >= states.size()) {
      return false;
    }
    DateTimePatternToken.Kind kind = states.get(stateIndex).token.getKind();
    return kind == DateTimePatternToken.Kind.DERIVED
        || kind == DateTimePatternToken.Kind.DISPLAY_ONLY;
  }

  private static final class TokenState {
    private final DateTimePatternToken token;
    private String value;

    private TokenState(DateTimePatternToken token, String value) {
      this.token = token;
      this.value = value;
    }
  }
}
