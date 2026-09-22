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

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.Arrays;
import java.util.List;
import org.junit.Test;

public class DateTimeTypingSessionTest {

  @Test
  public void emptyDateSessionRetainsPatternWhileNumericTokensAreOverwritten() {
    DateTimeTypingSession session = DateTimeTypingSession.empty(tokens("dd/MM/yyyy"));

    assertEquals("dd/MM/yyyy", session.getDisplayText());
    assertFalse(session.isComplete());

    session.overwrite("2");
    session.overwrite("5");

    assertEquals("25/MM/yyyy", session.getDisplayText());
    assertEquals("MM", session.getActiveToken().getPattern());
    assertFalse(session.isComplete());
  }

  @Test
  public void populatedSessionOverwritesActiveTokenInsteadOfAppending() {
    DateTimeTypingSession session =
        DateTimeTypingSession.withTokenValues(tokens("HH:mm"), Arrays.asList("10", "30"));

    session.overwrite("1");
    session.overwrite("4");

    assertEquals("14:30", session.getDisplayText());
    assertTrue(session.isComplete());
  }

  @Test
  public void populatedSingleDigitHourAdvancesPastItsSeparatorAfterReplacement() {
    DateTimeTypingSession session =
        DateTimeTypingSession.withValues(
            tokens("h:mm a"), Arrays.asList("2", null, "38", null, "PM"));

    session.overwrite("3");
    session.overwrite("0");
    session.overwrite("5");

    assertEquals("3:05 PM", session.getDisplayText());
    assertTrue(session.isComplete());
  }

  @Test
  public void singleDigitHourRetainsTheTokenWhenItCanBeginATwoDigitHour() {
    DateTimeTypingSession session = DateTimeTypingSession.empty(tokens("h:mm a"));

    session.overwrite("1");

    assertEquals("h", session.getActiveToken().getPattern());
    session.overwrite("0");
    assertEquals("mm", session.getActiveToken().getPattern());
  }

  @Test
  public void navigationSkipsLiteralAndDerivedTokens() {
    DateTimeTypingSession session = DateTimeTypingSession.empty(tokens("EEEE, MMMM d, yyyy"));

    assertEquals("MMMM", session.getActiveToken().getPattern());
    session.moveNext();
    assertEquals("d", session.getActiveToken().getPattern());
    session.movePrevious();
    assertEquals("MMMM", session.getActiveToken().getPattern());
  }

  @Test
  public void typingAnAlreadyRenderedLiteralDoesNotSkipTheNextToken() {
    DateTimeTypingSession session = DateTimeTypingSession.empty(tokens("yyyy-MM-dd"));

    session.overwrite("2026");

    assertEquals("MM", session.getActiveToken().getPattern());
    assertTrue(session.acceptLiteral("-"));
    assertEquals("MM", session.getActiveToken().getPattern());
  }

  @Test
  public void localizedTextTokenAcceptsAFullMonthNameLongerThanItsPatternWidth() {
    DateTimeTypingSession session = DateTimeTypingSession.empty(tokens("MMMM d, yyyy"));

    session.overwrite("September");

    assertEquals("September d, yyyy", session.getDisplayText());
    assertEquals("MMMM", session.getActiveToken().getPattern());
  }

  @Test
  public void candidateExcludesDerivedWeekdayAndItsFollowingLiteral() {
    DateTimeTypingSession session =
        DateTimeTypingSession.withValues(
            tokens("EEEE, MMMM d, yyyy"),
            Arrays.asList("Friday", null, "September", null, "18", null, "2026"));

    assertTrue(session.isComplete());
    assertEquals("MMMM d, yyyy", session.getCandidatePattern());
    assertEquals("September 18, 2026", session.getCandidateText());
  }

  @Test
  public void candidateExcludesDisplayOnlySuffixesAndTheirSeparatingLiteral() {
    DateTimeTypingSession session =
        DateTimeTypingSession.withValues(
            tokens("HH:mm 'UTC' z"), Arrays.asList("12", null, "34", null, "GMT"));

    assertTrue(session.isComplete());
    assertEquals("HH:mm", session.getCandidatePattern());
    assertEquals("12:34", session.getCandidateText());
  }

  private static List<DateTimePatternToken> tokens(String pattern) {
    return DateTimePatternTokenizer.tokenize(pattern);
  }
}
