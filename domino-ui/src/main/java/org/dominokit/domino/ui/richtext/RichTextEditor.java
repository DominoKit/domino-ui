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

import static org.dominokit.domino.ui.utils.Domino.*;

import elemental2.dom.HTMLDivElement;
import java.util.Arrays;
import java.util.Collection;
import org.dominokit.domino.ui.elements.DivElement;
import org.dominokit.domino.ui.i18n.HasLabels;
import org.dominokit.domino.ui.i18n.RichTextLabels;
import org.dominokit.domino.ui.richtext.commands.*;
import org.dominokit.domino.ui.utils.BaseDominoElement;
import org.dominokit.domino.ui.utils.ChildHandler;
import org.dominokit.domino.ui.utils.Counter;
import org.dominokit.domino.ui.utils.DominoUIConfig;
import org.dominokit.domino.ui.utils.HasValue;
import org.gwtproject.editor.client.LeafValueEditor;
import org.gwtproject.editor.client.TakesValue;
import org.gwtproject.safehtml.shared.SafeHtmlBuilder;

/**
 * A Rich Text Editor component that provides a user-friendly interface for editing and formatting
 * text content, including commands for text manipulation and styling.
 *
 * <p><b>Usage Example:</b>
 *
 * <pre>{@code
 * RichTextEditor editor = RichTextEditor.create();
 * editor.setValue("Sample text");
 * }</pre>
 *
 * @see RichTextStyles
 * @see HasLabels
 * @see TakesValue
 * @see LeafValueEditor
 * @see HasValue
 * @see RichTextCommand
 * @see BaseDominoElement
 */
public class RichTextEditor extends BaseDominoElement<HTMLDivElement, RichTextEditor>
    implements HasLabels<RichTextLabels>,
        RichTextStyles,
        TakesValue<String>,
        LeafValueEditor<String>,
        HasValue<RichTextEditor, String>,
        IsRichTextEditor {

  private final DivElement root;
  private final DivElement editableElement = div().addCss(dui_rich_text_editable);
  private final DivElement toolbars;
  private Counter fontSize = new Counter(3, 1, 7);

  /**
   * Factory method to create a new instance of {@link RichTextEditor}.
   *
   * @return a new instance of {@link RichTextEditor}
   */
  public static RichTextEditor create() {
    return new RichTextEditor();
  }

  /**
   * Factory method to create a new instance of {@link RichTextEditor}.
   *
   * @param actions A list of actions to be added to the editor toolbars.
   * @return a new instance of {@link RichTextEditor}
   */
  public static RichTextEditor create(RichTextActions... actions) {
    return new RichTextEditor(actions);
  }

  /**
   * Factory method to create a new instance of {@link RichTextEditor}.
   *
   * @param actions A list of actions to be added to the editor toolbars.
   * @return a new instance of {@link RichTextEditor}
   */
  public static RichTextEditor create(Collection<RichTextActions> actions) {
    return new RichTextEditor(actions);
  }

  /**
   * Constructs a new {@link RichTextEditor} with default configuration and commands.
   *
   * @param actions A list of actions to be added to the editor toolbars.
   */
  public RichTextEditor(RichTextActions... actions) {
    this(Arrays.asList(actions));
  }

  /** Constructs a new {@link RichTextEditor} with default configuration and commands. */
  public RichTextEditor() {
    this(DominoUIConfig.CONFIG.getUIConfig().getDefaultRichTextActions());
  }

  /**
   * Constructs a new {@link RichTextEditor} with default configuration and commands.
   *
   * @param actions A list of actions to be added to the editor toolbars.
   */
  public RichTextEditor(Collection<RichTextActions> actions) {
    this.root =
        div()
            .addCss(dui_rich_text)
            .appendChild(
                toolbars =
                    div()
                        .addCss(dui_rich_text_toolbars)
                        .apply(
                            self ->
                                actions.forEach(action -> self.appendChild(action.apply(this)))))
            .appendChild(editableElement.setAttribute("contenteditable", "true"));
    init(this);
  }

  /**
   * Sets the value of the rich text editor and returns the editor instance for chaining.
   *
   * <p>This is a convenient method that internally calls {@link #setValue(String)}
   *
   * @param value The text value to be set in the editor.
   * @return The current RichTextEditor instance for chaining.
   */
  @Override
  public RichTextEditor withValue(String value) {
    setValue(value);
    return this;
  }

  public DivElement getEditableElement() {
    return editableElement;
  }

  @Override
  public Counter getDefaultFontSizeCounter() {
    return fontSize;
  }

  /**
   * Sets the value of the rich text editor with an option to remain silent and returns the editor
   * instance for chaining.
   *
   * <p>This method internally calls {@link #setValue(String)}. The {@code silent} parameter is
   * currently not being used, and its functionality might be implemented in future versions.
   *
   * @param value The text value to be set in the editor.
   * @param silent A flag to indicate if the operation should remain silent (currently not being
   *     used).
   * @return The current RichTextEditor instance for chaining.
   */
  @Override
  public RichTextEditor withValue(String value, boolean silent) {
    setValue(value);
    return this;
  }

  /**
   * Sets the content inside the rich text editor.
   *
   * <p>The provided string is treated as HTML, and it's safely injected into the editor's content
   * area.
   *
   * @param s The HTML content to be set in the editor.
   */
  @Override
  public void setValue(String s) {
    editableElement.setInnerHtml(
        new SafeHtmlBuilder().appendHtmlConstant(s).toSafeHtml().asString());
  }

  /**
   * Retrieves the current content of the rich text editor treated as HTML.
   *
   * @return The editor's current content as an HTML string.
   */
  @Override
  public String getValue() {
    return editableElement.element().innerHTML;
  }

  /**
   * Customizes the editable element of the RichTextEditor.
   *
   * @param handler The handler to apply customizations.
   * @return The current instance for chaining.
   */
  public RichTextEditor withEditableElement(ChildHandler<RichTextEditor, DivElement> handler) {
    handler.apply(this, editableElement);
    return this;
  }

  /**
   * Customizes the toolbars of the RichTextEditor.
   *
   * @param handler The handler to apply customizations.
   * @return The current instance for chaining.
   */
  public RichTextEditor withToolbars(ChildHandler<RichTextEditor, DivElement> handler) {
    handler.apply(this, toolbars);
    return this;
  }

  @Override
  public HTMLDivElement element() {
    return root.element();
  }
}
