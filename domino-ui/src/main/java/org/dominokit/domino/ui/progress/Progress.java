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

import elemental2.dom.HTMLDivElement;
import java.util.ArrayList;
import java.util.List;
import org.dominokit.domino.ui.elements.DivElement;
import org.dominokit.domino.ui.utils.BaseDominoElement;

/**
 * Represents a visual progress component that can have multiple progress bars.
 *
 * <p>Usage example:
 *
 * <pre>
 * Progress progress = Progress.create();
 * ProgressBar bar1 = new ProgressBar(100);
 * ProgressBar bar2 = new ProgressBar(150);
 * progress.appendChild(bar1).appendChild(bar2);
 * </pre>
 *
 * @see BaseDominoElement
 */
public class Progress extends BaseDominoElement<HTMLDivElement, Progress>
    implements ProgressStyles {

  private DivElement element;
  private final List<ProgressBar> progressBars = new ArrayList<>();

  /** Creates a new Progress instance. */
  public Progress() {
    element = div().addCss(dui_progress);
    init(this);
  }

  /**
   * Static factory method to create a new instance of Progress.
   *
   * @return a new instance of {@link Progress}
   */
  public static Progress create() {
    return new Progress();
  }

  /**
   * Appends a {@link ProgressBar} to this progress component.
   *
   * @param bar the progress bar to be added
   * @return the current Progress instance
   */
  public Progress appendChild(ProgressBar bar) {
    element.appendChild(bar.element());
    this.progressBars.add(bar);
    bar.setParent(this);
    bar.updateWidth();
    return this;
  }

  /** {@inheritDoc} */
  @Override
  public HTMLDivElement element() {
    return element.element();
  }

  /**
   * Calculates the width of the progress bar based on its value.
   *
   * @param value the value of the progress
   * @return the calculated width as a string
   */
  String calculateWidth(double value) {
    return String.valueOf(
        new Double(
                (value / progressBars.stream().mapToDouble(ProgressBar::getMaxValue).sum()) * 100)
            .intValue());
  }

  /**
   * Removes the specified {@link ProgressBar} from the progress component.
   *
   * @param progressBar the progress bar to be removed
   */
  void removeBar(ProgressBar progressBar) {
    this.progressBars.remove(progressBar);
  }
}
