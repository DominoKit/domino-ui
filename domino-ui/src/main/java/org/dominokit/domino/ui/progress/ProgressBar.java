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

import static org.dominokit.domino.ui.utils.Domino.*;

import elemental2.dom.DomGlobal;
import elemental2.dom.HTMLDivElement;
import java.util.Optional;
import org.dominokit.domino.ui.config.HasComponentConfig;
import org.dominokit.domino.ui.config.ProgressBarConfig;
import org.dominokit.domino.ui.elements.DivElement;
import org.dominokit.domino.ui.elements.SpanElement;
import org.dominokit.domino.ui.style.BooleanCssClass;
import org.dominokit.domino.ui.utils.BaseDominoElement;
import org.dominokit.domino.ui.utils.DominoUIConfig;

/**
 * Represents a visual progress bar element.
 *
 * <p>Usage example:
 *
 * <pre>
 * ProgressBar bar = ProgressBar.create(100).setValue(50).showText();
 * </pre>
 *
 * @see BaseDominoElement
 */
public class ProgressBar extends BaseDominoElement<HTMLDivElement, ProgressBar>
    implements ProgressStyles, HasComponentConfig<ProgressBarConfig> {

  private DivElement element;
  private SpanElement textElement;
  private double maxValue;
  private double value = 0;
  private String textExpression;
  private boolean showText = false;

  private Progress parent;

  /**
   * Constructs a progress bar with the specified max value.
   *
   * @param maxValue The maximum value of the progress bar.
   */
  public ProgressBar(int maxValue) {
    this(maxValue, DominoUIConfig.CONFIG.getUIConfig().getDefaultProgressExpression());
  }

  /**
   * Constructs a progress bar with the specified max value and text expression.
   *
   * @param maxValue The maximum value of the progress bar.
   * @param textExpression The text expression for the progress bar.
   */
  public ProgressBar(int maxValue, String textExpression) {
    element =
        div()
            .addCss(dui_progress_bar)
            .setAttribute("role", "progressbar")
            .appendChild(textElement = span().addCss(dui_progress_text));
    this.maxValue = maxValue;
    this.textExpression = textExpression;
    this.setValue(0);
    init(this);
  }

  /**
   * Factory method to create a progress bar with the specified max value.
   *
   * @param maxValue The maximum value of the progress bar.
   * @return A new progress bar instance.
   */
  public static ProgressBar create(int maxValue) {
    return new ProgressBar(maxValue);
  }

  /**
   * Returns the root HTMLDivElement for this progress bar.
   *
   * @return The root HTMLDivElement.
   */
  @Override
  public HTMLDivElement element() {
    return element.element();
  }

  void setParent(Progress parent) {
    this.parent = parent;
  }

  public double getValue() {
    return value;
  }

  /**
   * Display the progress bar's value as text.
   *
   * @return The current progress bar instance.
   */
  public ProgressBar showText() {
    this.showText = true;
    updateText();
    return this;
  }

  /**
   * Set the progress bar's current value.
   *
   * @param value The new value for the progress bar.
   * @return The current progress bar instance.
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
      textElement.setTextContent(
          getConfig().evaluateProgressBarExpression(textExpression, percent, value, maxValue));
    }
  }

  /**
   * Animates the progress bar by applying a striped style and activating it.
   *
   * <p>This method will make the progress bar visually animated.
   *
   * @return The current progress bar instance.
   */
  public ProgressBar animate() {
    striped();
    element.addCss(dui_active);
    return this;
  }

  /**
   * Applies a striped style to the progress bar.
   *
   * <p>The striped style adds visual stripes across the progress bar.
   *
   * @return The current progress bar instance.
   */
  public ProgressBar striped() {
    dui_striped.apply(this);
    return this;
  }

  /**
   * Retrieves the maximum value for the progress bar.
   *
   * @return The maximum value of the progress bar.
   */
  public double getMaxValue() {
    return maxValue;
  }

  /**
   * Set the progress bar's maximum value.
   *
   * @param maxValue The new maximum value for the progress bar.
   * @return The current progress bar instance.
   */
  public ProgressBar setMaxValue(double maxValue) {
    this.maxValue = maxValue;
    setValue(this.value);
    return this;
  }

  /**
   * Sets a new text expression for the progress bar and then displays the text.
   *
   * <p>The text expression is a string that can be evaluated to produce the desired text on the
   * progress bar. The updated text is shown after setting the new expression.
   *
   * @param expression The new text expression to be set.
   * @return The current progress bar instance.
   */
  public ProgressBar textExpression(String expression) {
    this.textExpression = expression;
    showText();
    return this;
  }

  /**
   * Removes the progress bar from its parent.
   *
   * @return The current progress bar instance.
   */
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
              DomGlobal.setTimeout(
                  p0 -> {
                    boolean overFlowing = element.isOverFlowing();
                    BooleanCssClass.of(dui_progress_text_blind, overFlowing).apply(textElement);
                  },
                  0);
            });
  }
}
