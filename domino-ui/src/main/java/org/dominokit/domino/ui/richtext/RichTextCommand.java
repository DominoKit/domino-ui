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
package org.dominokit.domino.ui.richtext;

import static java.util.Objects.nonNull;
import static org.dominokit.domino.ui.utils.Domino.*;

import elemental2.dom.DomGlobal;
import elemental2.dom.HTMLElement;
import elemental2.dom.Range;
import elemental2.dom.Selection;
import java.util.Optional;
import org.dominokit.domino.ui.elements.DivElement;
import org.dominokit.domino.ui.i18n.HasLabels;
import org.dominokit.domino.ui.i18n.RichTextLabels;
import org.dominokit.domino.ui.utils.BaseDominoElement;

/**
 * Abstract base class for rich text editor commands.
 *
 * <p>Provides common functionalities for commands to operate on the editor's content.
 *
 * <p><b>Usage Example:</b>
 *
 * <pre>
 * public class BoldCommand extends RichTextCommand&lt;BoldCommand&gt; {
 *     ...
 *     @Override
 *     protected void execute() {
 *         // command implementation
 *     }
 * }
 * </pre>
 *
 * @param <T> The type of the command extending this base class.
 * @see BaseDominoElement
 */
public abstract class RichTextCommand<T extends RichTextCommand<T>>
    extends BaseDominoElement<HTMLElement, T> implements HasLabels<RichTextLabels> {
  protected final DivElement editableElement;

  /**
   * Creates a new command for a given editable element.
   *
   * @param editableElement The editable content area on which the command operates.
   */
  public RichTextCommand(DivElement editableElement) {
    this.editableElement = editableElement;
  }

  /** Executes the specific implementation of the rich text command. */
  protected abstract void execute();

  /**
   * Retrieves the currently selected range within the editable content area.
   *
   * @return An Optional containing the selected range, or empty if no range is selected.
   */
  protected Optional<Range> getSelectedRange() {
    Selection sel = DomGlobal.window.getSelection();
    if (nonNull(sel) && withinElement(sel)) {
      if (sel.rangeCount > -1) {
        return Optional.ofNullable(sel.getRangeAt(0).cloneRange());
      }
    }
    return Optional.empty();
  }

  /**
   * Checks if the current selection is entirely within the editable content area.
   *
   * @param sel The current selection.
   * @return {@code true} if the selection is within the editable area, {@code false} otherwise.
   */
  private boolean withinElement(Selection sel) {
    if (sel.rangeCount > 0) {
      for (int i = 0; i < sel.rangeCount; ++i) {
        if (!editableElement.contains(sel.getRangeAt(i).commonAncestorContainer)) {
          return false;
        }
      }
      return true;
    }
    return false;
  }
}
