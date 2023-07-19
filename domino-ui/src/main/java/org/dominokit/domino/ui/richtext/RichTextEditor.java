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

import elemental2.dom.HTMLDivElement;
import org.dominokit.domino.ui.button.group.ButtonsGroup;
import org.dominokit.domino.ui.elements.DivElement;
import org.dominokit.domino.ui.i18n.HasLabels;
import org.dominokit.domino.ui.i18n.RichTextLabels;
import org.dominokit.domino.ui.richtext.commands.*;
import org.dominokit.domino.ui.utils.BaseDominoElement;
import org.dominokit.domino.ui.utils.ChildHandler;
import org.dominokit.domino.ui.utils.Counter;
import org.dominokit.domino.ui.utils.HasValue;
import org.gwtproject.editor.client.LeafValueEditor;
import org.gwtproject.editor.client.TakesValue;
import org.gwtproject.safehtml.shared.SafeHtmlBuilder;

public class RichTextEditor extends BaseDominoElement<HTMLDivElement, RichTextEditor>
    implements HasLabels<RichTextLabels>,
        RichTextStyles,
        TakesValue<String>,
        LeafValueEditor<String>,
        HasValue<RichTextEditor, String> {

  private final DivElement root;
  private final DivElement editableElement;
  private final DivElement toolbars;
  private Counter fontSize = new Counter(3, 1, 7);

  public static RichTextEditor create() {
    return new RichTextEditor();
  }

  public RichTextEditor() {
    editableElement = div().addCss(dui_rich_text_editable);
    this.root =
        div()
            .addCss(dui_rich_text)
            .appendChild(
                toolbars =
                    div()
                        .addCss(dui_rich_text_toolbars)
                        .appendChild(
                            ButtonsGroup.create()
                                .appendChild(CopyCommand.create(editableElement))
                                .appendChild(CutCommand.create(editableElement))
                                .appendChild(PasteCommand.create(editableElement)))
                        .appendChild(
                            ButtonsGroup.create()
                                .appendChild(BoldCommand.create(editableElement))
                                .appendChild(ItalicCommand.create(editableElement))
                                .appendChild(StrikeThroughCommand.create(editableElement))
                                .appendChild(UnderLineCommand.create(editableElement)))
                        .appendChild(
                            ButtonsGroup.create()
                                .appendChild(JustifyFullCommand.create(editableElement))
                                .appendChild(JustifyCenterCommand.create(editableElement))
                                .appendChild(JustifyLeftCommand.create(editableElement))
                                .appendChild(JustifyRightCommand.create(editableElement)))
                        .appendChild(
                            ButtonsGroup.create()
                                .appendChild(IndentCommand.create(editableElement))
                                .appendChild(OutdentCommand.create(editableElement)))
                        .appendChild(
                            ButtonsGroup.create()
                                .appendChild(IncreaseFontCommand.create(editableElement, fontSize))
                                .appendChild(DecreaseFontCommand.create(editableElement, fontSize))
                                .appendChild(SubscriptCommand.create(editableElement))
                                .appendChild(SuperscriptCommand.create(editableElement)))
                        .appendChild(
                            ButtonsGroup.create()
                                .appendChild(FontNameCommand.create(editableElement)))
                        .appendChild(
                            ButtonsGroup.create()
                                .appendChild(HeadingCommand.create(editableElement)))
                        .appendChild(
                            ButtonsGroup.create()
                                .appendChild(HorizontalRuleCommand.create(editableElement))
                                .appendChild(InsertLinkCommand.create(editableElement))
                                .appendChild(RemoveLinkCommand.create(editableElement))
                                .appendChild(InsertHtmlCommand.create(editableElement))
                                .appendChild(InsertOrderedListCommand.create(editableElement))
                                .appendChild(InsertUnorderedListCommand.create(editableElement))
                                .appendChild(InsertParagraphCommand.create(editableElement))
                                .appendChild(InsertImageCommand.create(editableElement))
                                .appendChild(InsertImageLinkCommand.create(editableElement)))
                        .appendChild(
                            ButtonsGroup.create()
                                .appendChild(RemoveFormatCommand.create(editableElement)))
                        .appendChild(BackColorCommand.create(editableElement))
                        .appendChild(ForeColorCommand.create(editableElement))
                        .appendChild(HiliteColorCommand.create(editableElement))
                        .appendChild(
                            ButtonsGroup.create()
                                .appendChild(UndoCommand.create(editableElement))
                                .appendChild(RedoCommand.create(editableElement))))
            .appendChild(editableElement.setAttribute("contenteditable", "true"));
    init(this);
  }

  @Override
  public RichTextEditor withValue(String value) {
    setValue(value);
    return this;
  }

  @Override
  public RichTextEditor withValue(String value, boolean silent) {
    setValue(value);
    return this;
  }

  @Override
  public void setValue(String s) {
    editableElement.setInnerHtml(
        new SafeHtmlBuilder().appendHtmlConstant(s).toSafeHtml().asString());
  }

  @Override
  public String getValue() {
    return editableElement.element().innerHTML;
  }

  public RichTextEditor withEditableElement(ChildHandler<RichTextEditor, DivElement> handler) {
    handler.apply(this, editableElement);
    return this;
  }

  public RichTextEditor withToolbars(ChildHandler<RichTextEditor, DivElement> handler) {
    handler.apply(this, toolbars);
    return this;
  }

  @Override
  public HTMLDivElement element() {
    return root.element();
  }
}
