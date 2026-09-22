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

import java.util.Date;
import org.dominokit.domino.ui.forms.validations.ValidationResult;

/** Adapter between the shared typing editor and a date or time form field. */
public interface DateTimeTypingEditorHost {

  String getPattern();

  Date getCommittedValue();

  String format(DateTimePatternToken token, Date value);

  Date parse(String candidatePattern, String candidateText);

  ValidationResult validateCandidate(Date candidate);

  void commit(Date value);

  void restore(Date value);

  void display(String value, int selectionStart, int selectionEnd);

  void invalidate(String message);

  void clearInvalid();

  String invalidFormatMessage(String value);
}
