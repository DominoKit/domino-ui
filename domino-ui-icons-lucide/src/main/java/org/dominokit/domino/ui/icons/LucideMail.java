/*
 * Copyright © 2026 Dominokit
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
package org.dominokit.domino.ui.icons;

/** Lucide mail catalog category. */
public interface LucideMail {
  enum Icon implements LucideIconDefinition {
    ARCHIVE(
        "archive",
        "<rect width=\"20\" height=\"5\" x=\"2\" y=\"3\" rx=\"1\" />\n  <path d=\"M4 8v11a2 2 0 0 0 2 2h12a2 2 0 0 0 2-2V8\" />\n  <path d=\"M10 12h4\" />"),
    ARCHIVE_RESTORE(
        "archive-restore",
        "<rect width=\"20\" height=\"5\" x=\"2\" y=\"3\" rx=\"1\" />\n  <path d=\"M4 8v11a2 2 0 0 0 2 2h2\" />\n  <path d=\"M20 8v11a2 2 0 0 1-2 2h-2\" />\n  <path d=\"m9 15 3-3 3 3\" />\n  <path d=\"M12 12v9\" />"),
    ARCHIVE_X(
        "archive-x",
        "<rect width=\"20\" height=\"5\" x=\"2\" y=\"3\" rx=\"1\" />\n  <path d=\"M4 8v11a2 2 0 0 0 2 2h12a2 2 0 0 0 2-2V8\" />\n  <path d=\"m9.5 17 5-5\" />\n  <path d=\"m9.5 12 5 5\" />"),
    ARROWS_UP_FROM_LINE(
        "arrows-up-from-line",
        "<path d=\"m4 6 3-3 3 3\" />\n  <path d=\"M7 17V3\" />\n  <path d=\"m14 6 3-3 3 3\" />\n  <path d=\"M17 17V3\" />\n  <path d=\"M4 21h16\" />"),
    CONTAINER(
        "container",
        "<path d=\"M22 7.7c0-.6-.4-1.2-.8-1.5l-6.3-3.9a1.72 1.72 0 0 0-1.7 0l-10.3 6c-.5.2-.9.8-.9 1.4v6.6c0 .5.4 1.2.8 1.5l6.3 3.9a1.72 1.72 0 0 0 1.7 0l10.3-6c.5-.3.9-1 .9-1.5Z\" />\n  <path d=\"M10 21.9V14L2.1 9.1\" />\n  <path d=\"m10 14 11.9-6.9\" />\n  <path d=\"M14 19.8v-8.1\" />\n  <path d=\"M18 17.5V9.4\" />"),
    FORWARD("forward", "<path d=\"m15 17 5-5-5-5\" />\n  <path d=\"M4 18v-2a4 4 0 0 1 4-4h12\" />"),
    INBOX(
        "inbox",
        "<polyline points=\"22 12 16 12 14 15 10 15 8 12 2 12\" />\n  <path d=\"M5.45 5.11 2 12v6a2 2 0 0 0 2 2h16a2 2 0 0 0 2-2v-6l-3.45-6.89A2 2 0 0 0 16.76 4H7.24a2 2 0 0 0-1.79 1.11z\" />"),
    MAIL(
        "mail",
        "<path d=\"m22 7-8.991 5.727a2 2 0 0 1-2.009 0L2 7\" />\n  <rect x=\"2\" y=\"4\" width=\"20\" height=\"16\" rx=\"2\" />"),
    MAIL_BADGE(
        "mail-badge",
        "<path d=\"M22 7.7V6a2 2 0 0 0-2-2H4a2 2 0 0 0-2 2v12a2 2 0 0 0 2 2h8.25\" />\n  <path d=\"M12 12.996a1.94 1.94 0 0 1-1.03-.296L2 7\" />\n  <path d=\"m20.69 16.479 1.29 4.88a.5.5 0 0 1-.698.591l-1.843-.849a1 1 0 0 0-.879.001l-1.846.85a.5.5 0 0 1-.692-.593l1.29-4.88\" />\n  <circle cx=\"19\" cy=\"14\" r=\"3\" />"),
    MAIL_CHECK(
        "mail-check",
        "<path d=\"M22 13V6a2 2 0 0 0-2-2H4a2 2 0 0 0-2 2v12c0 1.1.9 2 2 2h8\" />\n  <path d=\"m22 7-8.97 5.7a1.94 1.94 0 0 1-2.06 0L2 7\" />\n  <path d=\"m16 19 2 2 4-4\" />"),
    MAIL_CLOCK(
        "mail-clock",
        "<path d=\"M16 14v2.2l1.6 1\" />\n  <path d=\"m22 7-.759.484\" />\n  <path d=\"M6.835 20H4a2 2 0 01-2-2V6a2 2 0 012-2h16a2 2 0 012 2v2\" />\n  <path d=\"M7.605 10.567 2 7\" />\n  <circle cx=\"16\" cy=\"16\" r=\"6\" />"),
    MAIL_DOT(
        "mail-dot",
        "<path d=\"M12.674 4H4a2 2 0 0 0-2 2v12a2 2 0 0 0 2 2h16a2 2 0 0 0 2-2v-4.675\" />\n  <path d=\"m2 7 9 5.701a2 2 0 0 0 2 0l1.084-.686\" />\n  <circle cx=\"19\" cy=\"7\" r=\"3\" />"),
    MAIL_MINUS(
        "mail-minus",
        "<path d=\"M22 15V6a2 2 0 0 0-2-2H4a2 2 0 0 0-2 2v12c0 1.1.9 2 2 2h8\" />\n  <path d=\"m22 7-8.97 5.7a1.94 1.94 0 0 1-2.06 0L2 7\" />\n  <path d=\"M16 19h6\" />"),
    MAIL_OPEN(
        "mail-open",
        "<path d=\"M21.2 8.4c.5.38.8.97.8 1.6v10a2 2 0 0 1-2 2H4a2 2 0 0 1-2-2V10a2 2 0 0 1 .8-1.6l8-6a2 2 0 0 1 2.4 0l8 6Z\" />\n  <path d=\"m22 10-8.97 5.7a1.94 1.94 0 0 1-2.06 0L2 10\" />"),
    MAIL_PEN(
        "mail-pen",
        "<path d=\"M15.363 17.634a2 2 0 00-.506.854l-.837 2.87a.5.5 0 00.62.62l2.87-.837a2 2 0 00.854-.506l3.013-3.009a1 1 0 10-3.004-3.004z\" />\n  <path d=\"M22 10.38V6a2 2 0 00-2-2H4a2 2 0 00-2 2v12a2 2 0 002 2h6.25\" />\n  <path d=\"m22 7-8.991 5.727a2 2 0 01-2.009 0L2 7\" />"),
    MAIL_PLUS(
        "mail-plus",
        "<path d=\"M22 13V6a2 2 0 0 0-2-2H4a2 2 0 0 0-2 2v12c0 1.1.9 2 2 2h8\" />\n  <path d=\"m22 7-8.97 5.7a1.94 1.94 0 0 1-2.06 0L2 7\" />\n  <path d=\"M19 16v6\" />\n  <path d=\"M16 19h6\" />"),
    MAIL_QUESTION_MARK(
        "mail-question-mark",
        "<path d=\"M22 10.5V6a2 2 0 0 0-2-2H4a2 2 0 0 0-2 2v12c0 1.1.9 2 2 2h12.5\" />\n  <path d=\"m22 7-8.97 5.7a1.94 1.94 0 0 1-2.06 0L2 7\" />\n  <path d=\"M18 15.28c.2-.4.5-.8.9-1a2.1 2.1 0 0 1 2.6.4c.3.4.5.8.5 1.3 0 1.3-2 2-2 2\" />\n  <path d=\"M20 22v.01\" />"),
    MAIL_SEARCH(
        "mail-search",
        "<path d=\"M22 12.5V6a2 2 0 0 0-2-2H4a2 2 0 0 0-2 2v12c0 1.1.9 2 2 2h7.5\" />\n  <path d=\"m22 7-8.97 5.7a1.94 1.94 0 0 1-2.06 0L2 7\" />\n  <path d=\"M18 21a3 3 0 1 0 0-6 3 3 0 0 0 0 6Z\" />\n  <circle cx=\"18\" cy=\"18\" r=\"3\" />\n  <path d=\"m22 22-1.5-1.5\" />"),
    MAIL_WARNING(
        "mail-warning",
        "<path d=\"M22 10.5V6a2 2 0 0 0-2-2H4a2 2 0 0 0-2 2v12c0 1.1.9 2 2 2h12.5\" />\n  <path d=\"m22 7-8.97 5.7a1.94 1.94 0 0 1-2.06 0L2 7\" />\n  <path d=\"M20 14v4\" />\n  <path d=\"M20 22v.01\" />"),
    MAIL_X(
        "mail-x",
        "<path d=\"M22 12.532V6a2 2 0 0 0-2-2H4a2 2 0 0 0-2 2v12a2 2 0 0 0 2 2h8.792\" />\n  <path d=\"m22 7-8.991 5.727a2 2 0 0 1-2.009 0L2 7\" />\n  <path d=\"m16.5 16.5 5 5\" />\n  <path d=\"m21.5 16.5-5 5\" />"),
    MAILBOX(
        "mailbox",
        "<path d=\"M22 17a2 2 0 0 1-2 2H4a2 2 0 0 1-2-2V9.5C2 7 4 5 6.5 5H18c2.2 0 4 1.8 4 4v8Z\" />\n  <polyline points=\"15,9 18,9 18,11\" />\n  <path d=\"M6.5 5C9 5 11 7 11 9.5V17a2 2 0 0 1-2 2\" />\n  <line x1=\"6\" x2=\"7\" y1=\"10\" y2=\"10\" />"),
    MAILS(
        "mails",
        "<path d=\"M17 19a2 2 0 0 1-2 2H4a2 2 0 0 1-2-2v-8a2 2 0 0 1 1-1.732\" />\n  <path d=\"m22 5.5-6.419 4.179a2 2 0 0 1-2.162 0L7 5.5\" />\n  <rect x=\"7\" y=\"3\" width=\"15\" height=\"12\" rx=\"2\" />"),
    PAPERCLIP(
        "paperclip",
        "<path d=\"m16 6-8.414 8.586a2 2 0 0 0 2.829 2.829l8.414-8.586a4 4 0 1 0-5.657-5.657l-8.379 8.551a6 6 0 1 0 8.485 8.485l8.379-8.551\" />"),
    REPLY("reply", "<path d=\"M20 18v-2a4 4 0 0 0-4-4H4\" />\n  <path d=\"m9 17-5-5 5-5\" />"),
    REPLY_ALL(
        "reply-all",
        "<path d=\"m12 17-5-5 5-5\" />\n  <path d=\"M22 18v-2a4 4 0 0 0-4-4H7\" />\n  <path d=\"m7 17-5-5 5-5\" />"),
    SEND(
        "send",
        "<path d=\"M14.536 21.686a.5.5 0 0 0 .937-.024l6.5-19a.496.496 0 0 0-.635-.635l-19 6.5a.5.5 0 0 0-.024.937l7.93 3.18a2 2 0 0 1 1.112 1.11z\" />\n  <path d=\"m21.854 2.147-10.94 10.939\" />"),
    SEND_HORIZONTAL(
        "send-horizontal",
        "<path d=\"M3.714 3.048a.498.498 0 0 0-.683.627l2.843 7.627a2 2 0 0 1 0 1.396l-2.842 7.627a.498.498 0 0 0 .682.627l18-8.5a.5.5 0 0 0 0-.904z\" />\n  <path d=\"M6 12h16\" />"),
    SHREDDER(
        "shredder",
        "<path d=\"M4 13V4a2 2 0 0 1 2-2h8a2.4 2.4 0 0 1 1.706.706l3.588 3.588A2.4 2.4 0 0 1 20 8v5\" />\n  <path d=\"M14 2v5a1 1 0 0 0 1 1h5\" />\n  <path d=\"M10 22v-5\" />\n  <path d=\"M14 19v-2\" />\n  <path d=\"M18 20v-3\" />\n  <path d=\"M2 13h20\" />\n  <path d=\"M6 20v-3\" />"),
    TRASH(
        "trash",
        "<path d=\"M10 11v6\" />\n  <path d=\"M14 11v6\" />\n  <path d=\"M19 6v14a2 2 0 0 1-2 2H7a2 2 0 0 1-2-2V6\" />\n  <path d=\"M3 6h18\" />\n  <path d=\"M8 6V4a2 2 0 0 1 2-2h4a2 2 0 0 1 2 2v2\" />"),
    TRASH_OFF(
        "trash-off",
        "<path d=\"M10 11v6\" />\n  <path d=\"M14 17v-3\" />\n  <path d=\"M16 6V4a2 2 0 00-2-2h-4a2 2 0 00-1.576.768\" />\n  <path d=\"M19 6v7.344\" />\n  <path d=\"m2 2 20 20\" />\n  <path d=\"M21 6h-9.344\" />\n  <path d=\"M3 6h3\" />\n  <path d=\"M5 6v14a2 2 0 002 2h10a2 2 0 002-2v-1\" />");

    private final String catalogName;
    private final String svg;

    Icon(String catalogName, String svg) {
      this.catalogName = catalogName;
      this.svg = svg;
    }

    @Override
    public String catalogName() {
      return catalogName;
    }

    @Override
    public String svg() {
      return svg;
    }

    @Override
    public String variant() {
      return "outline";
    }
  }

  // Icon factories for this category.
  default LucideIcon archive_mail() {
    return LucideIcon.create(Icon.ARCHIVE);
  }

  default LucideIcon archive_restore_mail() {
    return LucideIcon.create(Icon.ARCHIVE_RESTORE);
  }

  default LucideIcon archive_x_mail() {
    return LucideIcon.create(Icon.ARCHIVE_X);
  }

  default LucideIcon arrows_up_from_line_mail() {
    return LucideIcon.create(Icon.ARROWS_UP_FROM_LINE);
  }

  default LucideIcon container_mail() {
    return LucideIcon.create(Icon.CONTAINER);
  }

  default LucideIcon forward() {
    return LucideIcon.create(Icon.FORWARD);
  }

  default LucideIcon inbox_mail() {
    return LucideIcon.create(Icon.INBOX);
  }

  default LucideIcon mail_mail() {
    return LucideIcon.create(Icon.MAIL);
  }

  default LucideIcon mail_badge_mail() {
    return LucideIcon.create(Icon.MAIL_BADGE);
  }

  default LucideIcon mail_check() {
    return LucideIcon.create(Icon.MAIL_CHECK);
  }

  default LucideIcon mail_clock_mail() {
    return LucideIcon.create(Icon.MAIL_CLOCK);
  }

  default LucideIcon mail_dot_mail() {
    return LucideIcon.create(Icon.MAIL_DOT);
  }

  default LucideIcon mail_minus() {
    return LucideIcon.create(Icon.MAIL_MINUS);
  }

  default LucideIcon mail_open() {
    return LucideIcon.create(Icon.MAIL_OPEN);
  }

  default LucideIcon mail_pen() {
    return LucideIcon.create(Icon.MAIL_PEN);
  }

  default LucideIcon mail_plus() {
    return LucideIcon.create(Icon.MAIL_PLUS);
  }

  default LucideIcon mail_question_mark() {
    return LucideIcon.create(Icon.MAIL_QUESTION_MARK);
  }

  default LucideIcon mail_search() {
    return LucideIcon.create(Icon.MAIL_SEARCH);
  }

  default LucideIcon mail_warning() {
    return LucideIcon.create(Icon.MAIL_WARNING);
  }

  default LucideIcon mail_x() {
    return LucideIcon.create(Icon.MAIL_X);
  }

  default LucideIcon mailbox() {
    return LucideIcon.create(Icon.MAILBOX);
  }

  default LucideIcon mails() {
    return LucideIcon.create(Icon.MAILS);
  }

  default LucideIcon paperclip_mail() {
    return LucideIcon.create(Icon.PAPERCLIP);
  }

  default LucideIcon reply() {
    return LucideIcon.create(Icon.REPLY);
  }

  default LucideIcon reply_all() {
    return LucideIcon.create(Icon.REPLY_ALL);
  }

  default LucideIcon send_mail() {
    return LucideIcon.create(Icon.SEND);
  }

  default LucideIcon send_horizontal_mail() {
    return LucideIcon.create(Icon.SEND_HORIZONTAL);
  }

  default LucideIcon shredder_mail() {
    return LucideIcon.create(Icon.SHREDDER);
  }

  default LucideIcon trash_mail() {
    return LucideIcon.create(Icon.TRASH);
  }

  default LucideIcon trash_off_mail() {
    return LucideIcon.create(Icon.TRASH_OFF);
  }
}
