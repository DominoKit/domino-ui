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
package org.dominokit.domino.ui.progress;

import elemental2.dom.HTMLDivElement;
import java.util.Optional;
import org.dominokit.domino.ui.config.HasComponentConfig;
import org.dominokit.domino.ui.config.ProgressBarConfig;
import org.dominokit.domino.ui.elements.DivElement;
import org.dominokit.domino.ui.utils.BaseDominoElement;
import org.dominokit.domino.ui.utils.DominoUIConfig;

/**
 * A component to show the progress for a single operation within a {@link
 * org.dominokit.domino.ui.progress.Progress}
 *
 * <p>example
 *
 * <pre>
 * Progress.create()
 *         .appendChild(ProgressBar.create(100).setValue(50));
 * </pre>
 *
 * @see Progress
 * @author vegegoku
 * @version $Id: $Id
 */
public class ProgressBar extends BaseDominoElement<HTMLDivElement, ProgressBar>
    implements ProgressStyles, HasComponentConfig<ProgressBarConfig> {

  private DivElement element;
  private double maxValue;
  private double value = 0;
  private String textExpression;
  private boolean showText = false;

  private Progress parent;

  /** @param maxValue int max value of the operation progress */
  /**
   * Constructor for ProgressBar.
   *
   * @param maxValue a int
   */
  public ProgressBar(int maxValue) {
    this(maxValue, DominoUIConfig.CONFIG.getUIConfig().getDefaultProgressExpression());
  }

  /**
   * Constructor for ProgressBar.
   *
   * @param maxValue int max value of the operation progress
   * @param textExpression String that contains the parameter one or all of the parameters
   *     <b>percent</b>,<b>value</b>,<b>maxValue</b>
   *     <p>example
   *     <pre>
   *                                                                       "Finished {percent}% of the items - {value}/{maxValue}"
   *                                                                   </pre>
   */
  public ProgressBar(int maxValue, String textExpression) {
    element = div().addCss(dui_progress_bar).setAttribute("role", "progressbar");
    this.maxValue = maxValue;
    this.textExpression = textExpression;
    this.setValue(0);
    init(this);
  }

  /**
   * create.
   *
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

  void setParent(Progress parent) {
    this.parent = parent;
  }

  /** @return double current progress value */
  /**
   * Getter for the field <code>value</code>.
   *
   * @return a double
   */
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
   * Setter for the field <code>value</code>.
   *
   * @param value double value of progress
   * @return same Progressbar instance
   */
  public ProgressBar setValue(double value) {
    if (value >= 0 && value <= maxValue) {
      this.value = value;
      updateWidth();
    }
    return this;
  }

  private void updateText() {
    if (showText) {
      int percent = new Double((value / maxValue) * 100).intValue();
      element.setTextContent(
          getConfig().evaluateProgressBarExpression(textExpression, percent, value, maxValue));
    }
  }

  /**
   * Adds an animation effect to the ProgressBar
   *
   * @return same ProgressBar instance
   */
  public ProgressBar animate() {
    striped();
    element.addCss(dui_active);
    return this;
  }

  /**
   * Apply the {@link org.dominokit.domino.ui.style.GenericCss#dui_striped}
   *
   * @return same Progressbar instance
   */
  public ProgressBar striped() {
    dui_striped.apply(this);
    return this;
  }

  /** @return double max value */
  /**
   * Getter for the field <code>maxValue</code>.
   *
   * @return a double
   */
  public double getMaxValue() {
    return maxValue;
  }

  /**
   * Setter for the field <code>maxValue</code>.
   *
   * @param maxValue double
   * @return same ProgressBar instance
   */
  public ProgressBar setMaxValue(double maxValue) {
    this.maxValue = maxValue;
    setValue(this.value);
    return this;
  }

  /**
   * textExpression.
   *
   * @param expression String that contains the parameter one or all of the parameters
   *     <b>percent</b>,<b>value</b>,<b>maxValue</b>
   *     <p>example
   *     <pre>
   *                                                               "Finished {percent}% of the items - {value}/{maxValue}"
   *                                                           </pre>
   *
   * @return same ProgressBar instance
   */
  public ProgressBar textExpression(String expression) {
    this.textExpression = expression;
    showText();
    return this;
  }

  /** {@inheritDoc} */
  @Override
  public ProgressBar remove() {
    Optional.ofNullable(parent).ifPresent(progress -> progress.removeBar(this));
    this.parent = null;
    return super.remove();
  }

  void updateWidth() {
    Optional.ofNullable(parent)
        .ifPresent(
            progress -> {
              element.style().setWidth(progress.calculateWidth(value) + "%");
              updateText();
            });
  }
}
