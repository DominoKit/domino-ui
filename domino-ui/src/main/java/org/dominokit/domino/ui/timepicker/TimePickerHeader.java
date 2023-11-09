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
package org.dominokit.domino.ui.timepicker;

import elemental2.dom.HTMLDivElement;
import java.util.Date;
import org.dominokit.domino.ui.elements.DivElement;
import org.dominokit.domino.ui.utils.BaseDominoElement;
import org.dominokit.domino.ui.utils.ChildHandler;

/**
 * The header component for a time picker.
 *
 * <p>This component displays the selected time and updates it when the time selection changes.
 *
 * @see BaseDominoElement
 */
public class TimePickerHeader extends BaseDominoElement<HTMLDivElement, TimePickerHeader>
    implements TimePickerStyles, TimePickerViewListener {

  private final DivElement root;
  private final IsTimePicker timePicker;
  private final DivElement formattedTimeElement;

  /**
   * Constructs a new TimePickerHeader for the given time picker.
   *
   * @param timePicker The time picker associated with this header.
   */
  public TimePickerHeader(IsTimePicker timePicker) {
    this.timePicker = timePicker;
    this.timePicker.bindTimePickerViewListener(this);
    this.root =
        div()
            .addCss(dui_time_header)
            .appendChild(
                formattedTimeElement =
                    div().addCss(dui_time_header_text).textContent(timePicker.formattedTime()));
    init(this);
  }

  /**
   * Creates a new TimePickerHeader for the given time picker.
   *
   * @param timePicker The time picker associated with this header.
   * @return A new TimePickerHeader instance.
   */
  public static TimePickerHeader create(IsTimePicker timePicker) {
    return new TimePickerHeader(timePicker);
  }

  /**
   * Updates the displayed time when the time selection view is updated.
   *
   * @param date The new date and time selected.
   */
  @Override
  public void onUpdatePickerView(Date date) {
    this.formattedTimeElement.textContent(this.timePicker.formattedTime());
  }

  /**
   * Provides a handler to customize the time text element in the header.
   *
   * @param handler The handler for customizing the time text element.
   * @return This TimePickerHeader instance.
   */
  public TimePickerHeader withTimeTextElement(ChildHandler<TimePickerHeader, DivElement> handler) {
    handler.apply(this, formattedTimeElement);
    return this;
  }

  /**
   * Gets the HTMLDivElement element representing the TimePickerHeader.
   *
   * @return The root HTMLDivElement element.
   */
  @Override
  public HTMLDivElement element() {
    return root.element();
  }
}
