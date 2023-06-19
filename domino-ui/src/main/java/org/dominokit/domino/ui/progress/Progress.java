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
import java.util.ArrayList;
import java.util.List;
import org.dominokit.domino.ui.elements.DivElement;
import org.dominokit.domino.ui.utils.BaseDominoElement;

/**
 * A component that can show the progress for one or more operation
 *
 * <p>example
 *
 * <pre>
 * Progress.create()
 *         .appendChild(ProgressBar.create(100).setValue(50));
 * </pre>
 *
 * @see ProgressBar
 */
public class Progress extends BaseDominoElement<HTMLDivElement, Progress>
    implements ProgressStyles {

  private DivElement element;
  private final List<ProgressBar> progressBars = new ArrayList<>();

  /** */
  public Progress() {
    element = div().addCss(dui_progress);
    init(this);
  }

  /** @return new Progress instance */
  public static Progress create() {
    return new Progress();
  }

  /**
   * @param bar {@link ProgressBar} to be appended to this progress instance, each progress can have
   *     multiple ProgressBars
   * @return same Progress instance
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

  String calculateWidth(double value) {
    return String.valueOf(
        new Double(
                (value / progressBars.stream().mapToDouble(ProgressBar::getMaxValue).sum()) * 100)
            .intValue());
  }

  void removeBar(ProgressBar progressBar) {
    this.progressBars.remove(progressBar);
  }
}
