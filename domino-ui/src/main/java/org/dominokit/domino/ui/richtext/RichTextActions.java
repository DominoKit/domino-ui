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

import java.util.function.Function;
import org.dominokit.domino.ui.IsElement;
import org.dominokit.domino.ui.button.group.ButtonsGroup;
import org.dominokit.domino.ui.richtext.commands.BackColorCommand;
import org.dominokit.domino.ui.richtext.commands.BoldCommand;
import org.dominokit.domino.ui.richtext.commands.CopyCommand;
import org.dominokit.domino.ui.richtext.commands.CutCommand;
import org.dominokit.domino.ui.richtext.commands.DecreaseFontCommand;
import org.dominokit.domino.ui.richtext.commands.FontNameCommand;
import org.dominokit.domino.ui.richtext.commands.ForeColorCommand;
import org.dominokit.domino.ui.richtext.commands.HeadingCommand;
import org.dominokit.domino.ui.richtext.commands.HiliteColorCommand;
import org.dominokit.domino.ui.richtext.commands.HorizontalRuleCommand;
import org.dominokit.domino.ui.richtext.commands.IncreaseFontCommand;
import org.dominokit.domino.ui.richtext.commands.IndentCommand;
import org.dominokit.domino.ui.richtext.commands.InsertHtmlCommand;
import org.dominokit.domino.ui.richtext.commands.InsertImageCommand;
import org.dominokit.domino.ui.richtext.commands.InsertImageLinkCommand;
import org.dominokit.domino.ui.richtext.commands.InsertLinkCommand;
import org.dominokit.domino.ui.richtext.commands.InsertOrderedListCommand;
import org.dominokit.domino.ui.richtext.commands.InsertParagraphCommand;
import org.dominokit.domino.ui.richtext.commands.InsertUnorderedListCommand;
import org.dominokit.domino.ui.richtext.commands.ItalicCommand;
import org.dominokit.domino.ui.richtext.commands.JustifyCenterCommand;
import org.dominokit.domino.ui.richtext.commands.JustifyFullCommand;
import org.dominokit.domino.ui.richtext.commands.JustifyLeftCommand;
import org.dominokit.domino.ui.richtext.commands.JustifyRightCommand;
import org.dominokit.domino.ui.richtext.commands.OutdentCommand;
import org.dominokit.domino.ui.richtext.commands.PasteCommand;
import org.dominokit.domino.ui.richtext.commands.RedoCommand;
import org.dominokit.domino.ui.richtext.commands.RemoveFormatCommand;
import org.dominokit.domino.ui.richtext.commands.RemoveLinkCommand;
import org.dominokit.domino.ui.richtext.commands.StrikeThroughCommand;
import org.dominokit.domino.ui.richtext.commands.SubscriptCommand;
import org.dominokit.domino.ui.richtext.commands.SuperscriptCommand;
import org.dominokit.domino.ui.richtext.commands.UnderLineCommand;
import org.dominokit.domino.ui.richtext.commands.UndoCommand;

public enum RichTextActions {
  COPY_PASTE(
      editor ->
          ButtonsGroup.create()
              .appendChild(CopyCommand.create(editor))
              .appendChild(CutCommand.create(editor))
              .appendChild(PasteCommand.create(editor))),

  TEXT_STYLE(
      editor ->
          ButtonsGroup.create()
              .appendChild(BoldCommand.create(editor))
              .appendChild(ItalicCommand.create(editor))
              .appendChild(StrikeThroughCommand.create(editor))
              .appendChild(UnderLineCommand.create(editor))),

  TEXT_JUSTIFY(
      editor ->
          ButtonsGroup.create()
              .appendChild(JustifyFullCommand.create(editor))
              .appendChild(JustifyCenterCommand.create(editor))
              .appendChild(JustifyLeftCommand.create(editor))
              .appendChild(JustifyRightCommand.create(editor))),

  TEXT_INDENT(
      editor ->
          ButtonsGroup.create()
              .appendChild(IndentCommand.create(editor))
              .appendChild(OutdentCommand.create(editor))),

  TEXT_SIZE(
      editor ->
          ButtonsGroup.create()
              .appendChild(IncreaseFontCommand.create(editor))
              .appendChild(DecreaseFontCommand.create(editor))
              .appendChild(SubscriptCommand.create(editor))
              .appendChild(SuperscriptCommand.create(editor))),

  TEXT_FONT(editor -> ButtonsGroup.create().appendChild(FontNameCommand.create(editor))),

  HEADING(editor -> ButtonsGroup.create().appendChild(HeadingCommand.create(editor))),

  INSERT_ELEMENTS(
      editor ->
          ButtonsGroup.create()
              .appendChild(HorizontalRuleCommand.create(editor))
              .appendChild(InsertLinkCommand.create(editor))
              .appendChild(RemoveLinkCommand.create(editor))
              .appendChild(InsertHtmlCommand.create(editor))
              .appendChild(InsertOrderedListCommand.create(editor))
              .appendChild(InsertUnorderedListCommand.create(editor))
              .appendChild(InsertParagraphCommand.create(editor))
              .appendChild(InsertImageCommand.create(editor))
              .appendChild(InsertImageLinkCommand.create(editor))),

  INSERT_IMAGE(
      editor ->
          ButtonsGroup.create()
              .appendChild(InsertImageCommand.create(editor))
              .appendChild(InsertImageLinkCommand.create(editor))),

  CLEAR_FORMAT(editor -> ButtonsGroup.create().appendChild(RemoveFormatCommand.create(editor))),

  BACK_COLOR(BackColorCommand::create),
  FORE_COLOR(ForeColorCommand::create),
  HILITE_COLOR(HiliteColorCommand::create),

  UNDO_REDO(
      editor ->
          ButtonsGroup.create()
              .appendChild(UndoCommand.create(editor))
              .appendChild(RedoCommand.create(editor))),
  ;

  private final Function<RichTextEditor, IsElement<?>> handler;

  RichTextActions(Function<RichTextEditor, IsElement<?>> handler) {
    this.handler = handler;
  }

  public IsElement<?> apply(RichTextEditor editor) {
    return this.handler.apply(editor);
  }
}
