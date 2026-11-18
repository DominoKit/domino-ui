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
package org.dominokit.domino.ui.icons.lib;

import java.util.ArrayList;
import java.util.List;
import org.dominokit.domino.ui.icons.IconCatalogEntry;
import org.dominokit.domino.ui.icons.TablerCommunication;
import org.dominokit.domino.ui.icons.TablerIcon;

/** Static icon factory for the Tabler Communication category. */
public final class TablerCommunication_Factory {
  private static final List<IconCatalogEntry<TablerIcon>> icons = new ArrayList<>();
  private static final TablerCommunication tagIcons = new TablerCommunication() {};

  static {
    addIcons0();
    addIcons1();
  }

  private static void addIcons0() {
    icons.add(
        new IconCatalogEntry<>(
            "address-book", "TablerIcons.address_book()", tagIcons::address_book));
    icons.add(
        new IconCatalogEntry<>(
            "address-book-off",
            "TablerIcons.address_book_off()",
            tagIcons::address_book_off));
    icons.add(new IconCatalogEntry<>("bubble", "TablerIcons.bubble()", tagIcons::bubble));
    icons.add(
        new IconCatalogEntry<>(
            "bubble-minus", "TablerIcons.bubble_minus()", tagIcons::bubble_minus));
    icons.add(
        new IconCatalogEntry<>(
            "bubble-plus", "TablerIcons.bubble_plus()", tagIcons::bubble_plus));
    icons.add(
        new IconCatalogEntry<>(
            "bubble-text", "TablerIcons.bubble_text()", tagIcons::bubble_text));
    icons.add(
        new IconCatalogEntry<>("bubble-x", "TablerIcons.bubble_x()", tagIcons::bubble_x));
    icons.add(
        new IconCatalogEntry<>(
            "email-stamp", "TablerIcons.email_stamp()", tagIcons::email_stamp));
    icons.add(new IconCatalogEntry<>("mail", "TablerIcons.mail()", tagIcons::mail));
    icons.add(
        new IconCatalogEntry<>("mail-ai", "TablerIcons.mail_ai()", tagIcons::mail_ai));
    icons.add(
        new IconCatalogEntry<>(
            "mail-bitcoin", "TablerIcons.mail_bitcoin()", tagIcons::mail_bitcoin));
    icons.add(
        new IconCatalogEntry<>(
            "mail-bolt", "TablerIcons.mail_bolt()", tagIcons::mail_bolt));
    icons.add(
        new IconCatalogEntry<>(
            "mail-cancel", "TablerIcons.mail_cancel()", tagIcons::mail_cancel));
    icons.add(
        new IconCatalogEntry<>(
            "mail-check", "TablerIcons.mail_check()", tagIcons::mail_check));
    icons.add(
        new IconCatalogEntry<>(
            "mail-code", "TablerIcons.mail_code()", tagIcons::mail_code));
    icons.add(
        new IconCatalogEntry<>("mail-cog", "TablerIcons.mail_cog()", tagIcons::mail_cog));
    icons.add(
        new IconCatalogEntry<>(
            "mail-dollar", "TablerIcons.mail_dollar()", tagIcons::mail_dollar));
    icons.add(
        new IconCatalogEntry<>(
            "mail-down", "TablerIcons.mail_down()", tagIcons::mail_down));
    icons.add(
        new IconCatalogEntry<>(
            "mail-exclamation",
            "TablerIcons.mail_exclamation()",
            tagIcons::mail_exclamation));
    icons.add(
        new IconCatalogEntry<>(
            "mail-fast", "TablerIcons.mail_fast()", tagIcons::mail_fast));
    icons.add(
        new IconCatalogEntry<>(
            "mail-forward", "TablerIcons.mail_forward()", tagIcons::mail_forward));
    icons.add(
        new IconCatalogEntry<>(
            "mail-heart", "TablerIcons.mail_heart()", tagIcons::mail_heart));
    icons.add(
        new IconCatalogEntry<>(
            "mail-minus", "TablerIcons.mail_minus()", tagIcons::mail_minus));
    icons.add(
        new IconCatalogEntry<>("mail-off", "TablerIcons.mail_off()", tagIcons::mail_off));
    icons.add(
        new IconCatalogEntry<>(
            "mail-opened", "TablerIcons.mail_opened()", tagIcons::mail_opened));
    icons.add(
        new IconCatalogEntry<>(
            "mail-pause", "TablerIcons.mail_pause()", tagIcons::mail_pause));
    icons.add(
        new IconCatalogEntry<>("mail-pin", "TablerIcons.mail_pin()", tagIcons::mail_pin));
    icons.add(
        new IconCatalogEntry<>(
            "mail-plus", "TablerIcons.mail_plus()", tagIcons::mail_plus));
    icons.add(
        new IconCatalogEntry<>(
            "mail-question", "TablerIcons.mail_question()", tagIcons::mail_question));
    icons.add(
        new IconCatalogEntry<>(
            "mail-search", "TablerIcons.mail_search()", tagIcons::mail_search));
    icons.add(
        new IconCatalogEntry<>(
            "mail-share", "TablerIcons.mail_share()", tagIcons::mail_share));
    icons.add(
        new IconCatalogEntry<>(
            "mail-spark", "TablerIcons.mail_spark()", tagIcons::mail_spark));
    icons.add(
        new IconCatalogEntry<>(
            "mail-star", "TablerIcons.mail_star()", tagIcons::mail_star));
    icons.add(
        new IconCatalogEntry<>("mail-up", "TablerIcons.mail_up()", tagIcons::mail_up));
    icons.add(new IconCatalogEntry<>("mail-x", "TablerIcons.mail_x()", tagIcons::mail_x));
    icons.add(
        new IconCatalogEntry<>("mailbox", "TablerIcons.mailbox()", tagIcons::mailbox));
    icons.add(
        new IconCatalogEntry<>(
            "mailbox-off", "TablerIcons.mailbox_off()", tagIcons::mailbox_off));
    icons.add(
        new IconCatalogEntry<>("message", "TablerIcons.message()", tagIcons::message));
    icons.add(
        new IconCatalogEntry<>(
            "message-2", "TablerIcons.message_2()", tagIcons::message_2));
    icons.add(
        new IconCatalogEntry<>(
            "message-2-ai", "TablerIcons.message_2_ai()", tagIcons::message_2_ai));
    icons.add(
        new IconCatalogEntry<>(
            "message-2-bolt", "TablerIcons.message_2_bolt()", tagIcons::message_2_bolt));
    icons.add(
        new IconCatalogEntry<>(
            "message-2-cancel",
            "TablerIcons.message_2_cancel()",
            tagIcons::message_2_cancel));
    icons.add(
        new IconCatalogEntry<>(
            "message-2-check",
            "TablerIcons.message_2_check()",
            tagIcons::message_2_check));
    icons.add(
        new IconCatalogEntry<>(
            "message-2-code", "TablerIcons.message_2_code()", tagIcons::message_2_code));
    icons.add(
        new IconCatalogEntry<>(
            "message-2-cog", "TablerIcons.message_2_cog()", tagIcons::message_2_cog));
    icons.add(
        new IconCatalogEntry<>(
            "message-2-dollar",
            "TablerIcons.message_2_dollar()",
            tagIcons::message_2_dollar));
    icons.add(
        new IconCatalogEntry<>(
            "message-2-down", "TablerIcons.message_2_down()", tagIcons::message_2_down));
    icons.add(
        new IconCatalogEntry<>(
            "message-2-exclamation",
            "TablerIcons.message_2_exclamation()",
            tagIcons::message_2_exclamation));
    icons.add(
        new IconCatalogEntry<>(
            "message-2-heart",
            "TablerIcons.message_2_heart()",
            tagIcons::message_2_heart));
    icons.add(
        new IconCatalogEntry<>(
            "message-2-minus",
            "TablerIcons.message_2_minus()",
            tagIcons::message_2_minus));
    icons.add(
        new IconCatalogEntry<>(
            "message-2-off", "TablerIcons.message_2_off()", tagIcons::message_2_off));
    icons.add(
        new IconCatalogEntry<>(
            "message-2-pause",
            "TablerIcons.message_2_pause()",
            tagIcons::message_2_pause));
    icons.add(
        new IconCatalogEntry<>(
            "message-2-pin", "TablerIcons.message_2_pin()", tagIcons::message_2_pin));
    icons.add(
        new IconCatalogEntry<>(
            "message-2-plus", "TablerIcons.message_2_plus()", tagIcons::message_2_plus));
    icons.add(
        new IconCatalogEntry<>(
            "message-2-question",
            "TablerIcons.message_2_question()",
            tagIcons::message_2_question));
    icons.add(
        new IconCatalogEntry<>(
            "message-2-search",
            "TablerIcons.message_2_search()",
            tagIcons::message_2_search));
    icons.add(
        new IconCatalogEntry<>(
            "message-2-share",
            "TablerIcons.message_2_share()",
            tagIcons::message_2_share));
    icons.add(
        new IconCatalogEntry<>(
            "message-2-sparkle",
            "TablerIcons.message_2_sparkle()",
            tagIcons::message_2_sparkle));
    icons.add(
        new IconCatalogEntry<>(
            "message-2-star", "TablerIcons.message_2_star()", tagIcons::message_2_star));
    icons.add(
        new IconCatalogEntry<>(
            "message-2-up", "TablerIcons.message_2_up()", tagIcons::message_2_up));
    icons.add(
        new IconCatalogEntry<>(
            "message-2-x", "TablerIcons.message_2_x()", tagIcons::message_2_x));
    icons.add(
        new IconCatalogEntry<>(
            "message-ai", "TablerIcons.message_ai()", tagIcons::message_ai));
    icons.add(
        new IconCatalogEntry<>(
            "message-bolt", "TablerIcons.message_bolt()", tagIcons::message_bolt));
    icons.add(
        new IconCatalogEntry<>(
            "message-cancel", "TablerIcons.message_cancel()", tagIcons::message_cancel));
    icons.add(
        new IconCatalogEntry<>(
            "message-chatbot",
            "TablerIcons.message_chatbot()",
            tagIcons::message_chatbot));
    icons.add(
        new IconCatalogEntry<>(
            "message-check", "TablerIcons.message_check()", tagIcons::message_check));
    icons.add(
        new IconCatalogEntry<>(
            "message-circle", "TablerIcons.message_circle()", tagIcons::message_circle));
    icons.add(
        new IconCatalogEntry<>(
            "message-circle-bolt",
            "TablerIcons.message_circle_bolt()",
            tagIcons::message_circle_bolt));
    icons.add(
        new IconCatalogEntry<>(
            "message-circle-cancel",
            "TablerIcons.message_circle_cancel()",
            tagIcons::message_circle_cancel));
    icons.add(
        new IconCatalogEntry<>(
            "message-circle-check",
            "TablerIcons.message_circle_check()",
            tagIcons::message_circle_check));
    icons.add(
        new IconCatalogEntry<>(
            "message-circle-code",
            "TablerIcons.message_circle_code()",
            tagIcons::message_circle_code));
    icons.add(
        new IconCatalogEntry<>(
            "message-circle-cog",
            "TablerIcons.message_circle_cog()",
            tagIcons::message_circle_cog));
    icons.add(
        new IconCatalogEntry<>(
            "message-circle-dollar",
            "TablerIcons.message_circle_dollar()",
            tagIcons::message_circle_dollar));
    icons.add(
        new IconCatalogEntry<>(
            "message-circle-down",
            "TablerIcons.message_circle_down()",
            tagIcons::message_circle_down));
    icons.add(
        new IconCatalogEntry<>(
            "message-circle-exclamation",
            "TablerIcons.message_circle_exclamation()",
            tagIcons::message_circle_exclamation));
    icons.add(
        new IconCatalogEntry<>(
            "message-circle-heart",
            "TablerIcons.message_circle_heart()",
            tagIcons::message_circle_heart));
    icons.add(
        new IconCatalogEntry<>(
            "message-circle-minus",
            "TablerIcons.message_circle_minus()",
            tagIcons::message_circle_minus));
    icons.add(
        new IconCatalogEntry<>(
            "message-circle-off",
            "TablerIcons.message_circle_off()",
            tagIcons::message_circle_off));
    icons.add(
        new IconCatalogEntry<>(
            "message-circle-pause",
            "TablerIcons.message_circle_pause()",
            tagIcons::message_circle_pause));
    icons.add(
        new IconCatalogEntry<>(
            "message-circle-pin",
            "TablerIcons.message_circle_pin()",
            tagIcons::message_circle_pin));
    icons.add(
        new IconCatalogEntry<>(
            "message-circle-plus",
            "TablerIcons.message_circle_plus()",
            tagIcons::message_circle_plus));
    icons.add(
        new IconCatalogEntry<>(
            "message-circle-question",
            "TablerIcons.message_circle_question()",
            tagIcons::message_circle_question));
    icons.add(
        new IconCatalogEntry<>(
            "message-circle-search",
            "TablerIcons.message_circle_search()",
            tagIcons::message_circle_search));
    icons.add(
        new IconCatalogEntry<>(
            "message-circle-share",
            "TablerIcons.message_circle_share()",
            tagIcons::message_circle_share));
    icons.add(
        new IconCatalogEntry<>(
            "message-circle-star",
            "TablerIcons.message_circle_star()",
            tagIcons::message_circle_star));
    icons.add(
        new IconCatalogEntry<>(
            "message-circle-up",
            "TablerIcons.message_circle_up()",
            tagIcons::message_circle_up));
    icons.add(
        new IconCatalogEntry<>(
            "message-circle-user",
            "TablerIcons.message_circle_user()",
            tagIcons::message_circle_user));
    icons.add(
        new IconCatalogEntry<>(
            "message-circle-x",
            "TablerIcons.message_circle_x()",
            tagIcons::message_circle_x));
    icons.add(
        new IconCatalogEntry<>(
            "message-code", "TablerIcons.message_code()", tagIcons::message_code));
    icons.add(
        new IconCatalogEntry<>(
            "message-cog", "TablerIcons.message_cog()", tagIcons::message_cog));
    icons.add(
        new IconCatalogEntry<>(
            "message-dollar", "TablerIcons.message_dollar()", tagIcons::message_dollar));
    icons.add(
        new IconCatalogEntry<>(
            "message-dots", "TablerIcons.message_dots()", tagIcons::message_dots));
    icons.add(
        new IconCatalogEntry<>(
            "message-down", "TablerIcons.message_down()", tagIcons::message_down));
    icons.add(
        new IconCatalogEntry<>(
            "message-exclamation",
            "TablerIcons.message_exclamation()",
            tagIcons::message_exclamation));
    icons.add(
        new IconCatalogEntry<>(
            "message-forward",
            "TablerIcons.message_forward()",
            tagIcons::message_forward));
    icons.add(
        new IconCatalogEntry<>(
            "message-heart", "TablerIcons.message_heart()", tagIcons::message_heart));
    icons.add(
        new IconCatalogEntry<>(
            "message-language",
            "TablerIcons.message_language()",
            tagIcons::message_language));
    icons.add(
        new IconCatalogEntry<>(
            "message-minus", "TablerIcons.message_minus()", tagIcons::message_minus));
    icons.add(
        new IconCatalogEntry<>(
            "message-off", "TablerIcons.message_off()", tagIcons::message_off));
    icons.add(
        new IconCatalogEntry<>(
            "message-pause", "TablerIcons.message_pause()", tagIcons::message_pause));
  }

  private static void addIcons1() {
    icons.add(
        new IconCatalogEntry<>(
            "message-pin", "TablerIcons.message_pin()", tagIcons::message_pin));
    icons.add(
        new IconCatalogEntry<>(
            "message-plus", "TablerIcons.message_plus()", tagIcons::message_plus));
    icons.add(
        new IconCatalogEntry<>(
            "message-question",
            "TablerIcons.message_question()",
            tagIcons::message_question));
    icons.add(
        new IconCatalogEntry<>(
            "message-reply", "TablerIcons.message_reply()", tagIcons::message_reply));
    icons.add(
        new IconCatalogEntry<>(
            "message-report", "TablerIcons.message_report()", tagIcons::message_report));
    icons.add(
        new IconCatalogEntry<>(
            "message-search", "TablerIcons.message_search()", tagIcons::message_search));
    icons.add(
        new IconCatalogEntry<>(
            "message-share", "TablerIcons.message_share()", tagIcons::message_share));
    icons.add(
        new IconCatalogEntry<>(
            "message-sparkle",
            "TablerIcons.message_sparkle()",
            tagIcons::message_sparkle));
    icons.add(
        new IconCatalogEntry<>(
            "message-star", "TablerIcons.message_star()", tagIcons::message_star));
    icons.add(
        new IconCatalogEntry<>(
            "message-up", "TablerIcons.message_up()", tagIcons::message_up));
    icons.add(
        new IconCatalogEntry<>(
            "message-user", "TablerIcons.message_user()", tagIcons::message_user));
    icons.add(
        new IconCatalogEntry<>(
            "message-x", "TablerIcons.message_x()", tagIcons::message_x));
    icons.add(
        new IconCatalogEntry<>("messages", "TablerIcons.messages()", tagIcons::messages));
    icons.add(
        new IconCatalogEntry<>(
            "messages-off", "TablerIcons.messages_off()", tagIcons::messages_off));
    icons.add(
        new IconCatalogEntry<>(
            "phone-done", "TablerIcons.phone_done()", tagIcons::phone_done));
    icons.add(
        new IconCatalogEntry<>(
            "phone-end", "TablerIcons.phone_end()", tagIcons::phone_end));
    icons.add(
        new IconCatalogEntry<>(
            "phone-ringing", "TablerIcons.phone_ringing()", tagIcons::phone_ringing));
    icons.add(new IconCatalogEntry<>("rss", "TablerIcons.rss()", tagIcons::rss));
    icons.add(new IconCatalogEntry<>("send", "TablerIcons.send()", tagIcons::send));
    icons.add(new IconCatalogEntry<>("send-2", "TablerIcons.send_2()", tagIcons::send_2));
    icons.add(
        new IconCatalogEntry<>("send-off", "TablerIcons.send_off()", tagIcons::send_off));
    icons.add(
        new IconCatalogEntry<>(
            "bubble", "TablerIcons.bubble_filled()", tagIcons::bubble_filled));
    icons.add(
        new IconCatalogEntry<>(
            "bubble-text",
            "TablerIcons.bubble_text_filled()",
            tagIcons::bubble_text_filled));
    icons.add(
        new IconCatalogEntry<>(
            "mail", "TablerIcons.mail_filled()", tagIcons::mail_filled));
    icons.add(
        new IconCatalogEntry<>(
            "mail-opened",
            "TablerIcons.mail_opened_filled()",
            tagIcons::mail_opened_filled));
    icons.add(
        new IconCatalogEntry<>(
            "message", "TablerIcons.message_filled()", tagIcons::message_filled));
    icons.add(
        new IconCatalogEntry<>(
            "message-2", "TablerIcons.message_2_filled()", tagIcons::message_2_filled));
    icons.add(
        new IconCatalogEntry<>(
            "message-chatbot",
            "TablerIcons.message_chatbot_filled()",
            tagIcons::message_chatbot_filled));
    icons.add(
        new IconCatalogEntry<>(
            "message-circle",
            "TablerIcons.message_circle_filled()",
            tagIcons::message_circle_filled));
    icons.add(
        new IconCatalogEntry<>(
            "message-report",
            "TablerIcons.message_report_filled()",
            tagIcons::message_report_filled));
    icons.add(
        new IconCatalogEntry<>(
            "messages", "TablerIcons.messages_filled()", tagIcons::messages_filled));
    icons.add(
        new IconCatalogEntry<>(
            "send", "TablerIcons.send_filled()", tagIcons::send_filled));
  }

  public List<IconCatalogEntry<TablerIcon>> icons() {
    return new ArrayList<>(icons);
  }
}
