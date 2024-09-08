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
package org.dominokit.domino.ui.shaded.progress;

import static org.jboss.elemento.Elements.div;

import elemental2.dom.HTMLDivElement;
import org.dominokit.domino.ui.shaded.style.Color;
import org.dominokit.domino.ui.shaded.utils.BaseDominoElement;
import org.dominokit.domino.ui.shaded.utils.DominoElement;

/**
 * A component to show the progress for a single operation within a {@link Progress}
 *
 * <p>example
 *
 * <pre>
 * Progress.create()
 *         .appendChild(ProgressBar.create(100).setValue(50));
 * </pre>
 *
 * @see Progress
 */
@Deprecated
public class ProgressBar extends BaseDominoElement<HTMLDivElement, ProgressBar> {

  private DominoElement<HTMLDivElement> element =
      DominoElement.of(div()).css(ProgressStyles.progress_bar).attr("role", "progressbar");
  private double maxValue;
  private double value = 0;
  private String textExpression;
  private boolean showText = false;
  private String style = ProgressStyles.progress_bar_success;

  /** @param maxValue int max value of the operation progress */
  public ProgressBar(int maxValue) {
    this(maxValue, "{percent}%");
  }

  /**
   * @param maxValue int max value of the operation progress
   * @param textExpression String that contains the parameter one or all of the parameters
   *     <b>percent</b>,<b>value</b>,<b>maxValue</b>
   *     <p>example
   *     <pre>
   *                           "Finished {percent}% of the items - {value}/{maxValue}"
   *                       </pre>
   */
  public ProgressBar(int maxValue, String textExpression) {
    this.maxValue = maxValue;
    this.textExpression = textExpression;
    this.setValue(0);
    init(this);
  }

  /**
   * @param maxValue int max value of the operation progress
   * @return new ProgressBar instance
   */
  public static ProgressBar create(int maxValue) {
    return new ProgressBar(maxValue);
  }

  /** {@inheritDoc} */
  @Override
  public HTMLDivElement element() {
    return element.element();
  }

  /** @return double current progress value */
  public double getValue() {
    return value;
  }

  /**
   * Make progress text visible on the ProgressBar
   *
   * @return same Progressbar instance
   */
  public ProgressBar showText() {
    this.showText = true;
    updateText();
    return this;
  }

  /**
   * @param value double value of progress
   * @return same Progressbar instance
   */
  public ProgressBar setValue(double value) {
    if (value >= 0 && value <= maxValue) {
      this.value = value;
      int percent = new Double((value / maxValue) * 100).intValue();
      element.style().setWidth(percent + "%");
      updateText();
    }
    return this;
  }

  private void updateText() {
    if (showText) {
      int percent = new Double((value / maxValue) * 100).intValue();
      element.setTextContent(
          textExpression
              .replace("{percent}", percent + "")
              .replace("{value}", value + "")
              .replace("{maxValue}", maxValue + ""));
    }
  }

  /**
   * Adds an animation effect to the ProgressBar
   *
   * @return same ProgressBar instance
   */
  public ProgressBar animate() {
    striped();
    element.addCss(ProgressStyles.active);
    return this;
  }

  /**
   * Apply the {@link ProgressStyles#progress_bar_success}
   *
   * @return same Progressbar instance
   */
  public ProgressBar striped() {
    element.removeCss(ProgressStyles.progress_bar_striped);
    element.addCss(ProgressStyles.progress_bar_striped);
    return this;
  }

  /**
   * Apply the {@link ProgressStyles#progress_bar_success}
   *
   * @return same Progressbar instance
   */
  public ProgressBar success() {
    return setStyle(ProgressStyles.progress_bar_success);
  }

  /**
   * Apply the {@link ProgressStyles#progress_bar_warning}
   *
   * @return same Progressbar instance
   */
  public ProgressBar warning() {
    return setStyle(ProgressStyles.progress_bar_warning);
  }

  /**
   * Apply the {@link ProgressStyles#progress_bar_info}
   *
   * @return same Progressbar instance
   */
  public ProgressBar info() {
    return setStyle(ProgressStyles.progress_bar_info);
  }

  /**
   * Apply the {@link ProgressStyles#progress_bar_danger}
   *
   * @return same Progressbar instance
   */
  public ProgressBar danger() {
    return setStyle(ProgressStyles.progress_bar_danger);
  }

  private ProgressBar setStyle(String style) {
    element.removeCss(this.style);
    element.addCss(style);
    this.style = style;
    return this;
  }

  /**
   * @param background {@link Color} of the Progressbar
   * @return same ProgressBar instance
   */
  public ProgressBar setBackground(Color background) {
    setStyle(background.getBackground());
    return this;
  }

  /** @return double max value */
  public double getMaxValue() {
    return maxValue;
  }

  /**
   * @param maxValue double
   * @return same ProgressBar instance
   */
  public ProgressBar setMaxValue(double maxValue) {
    this.maxValue = maxValue;
    setValue(this.value);
    return this;
  }

  /**
   * @param expression String that contains the parameter one or all of the parameters
   *     <b>percent</b>,<b>value</b>,<b>maxValue</b>
   *     <p>example
   *     <pre>
   *                           "Finished {percent}% of the items - {value}/{maxValue}"
   *                       </pre>
   *
   * @return same ProgressBar instance
   */
  public ProgressBar textExpression(String expression) {
    this.textExpression = expression;
    updateText();
    return this;
  }
}
