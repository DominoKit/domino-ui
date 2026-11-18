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
import org.dominokit.domino.ui.icons.MaterialSymbolsCommunicate;
import org.dominokit.domino.ui.icons.MaterialSymbolsIcon;

/** Static icon factory for the Material Symbols Communicate category. */
public final class MaterialSymbolsCommunicate_Factory {
  private static final List<IconCatalogEntry<MaterialSymbolsIcon>> icons = new ArrayList<>();
  private static final MaterialSymbolsCommunicate tagIcons = new MaterialSymbolsCommunicate() {};

  static {
    addIcons0();
    addIcons1();
  }

  private static void addIcons0() {
    icons.add(new IconCatalogEntry<>("3p", "MaterialSymbols._3p()", tagIcons::_3p_communicate));
    icons.add(
        new IconCatalogEntry<>(
            "add_call", "MaterialSymbols.add_call()", tagIcons::add_call_communicate));
    icons.add(
        new IconCatalogEntry<>(
            "add_comment", "MaterialSymbols.add_comment()", tagIcons::add_comment_communicate));
    icons.add(
        new IconCatalogEntry<>(
            "all_inbox", "MaterialSymbols.all_inbox()", tagIcons::all_inbox_communicate));
    icons.add(
        new IconCatalogEntry<>(
            "alternate_email",
            "MaterialSymbols.alternate_email()",
            tagIcons::alternate_email_communicate));
    icons.add(
        new IconCatalogEntry<>(
            "attach_email", "MaterialSymbols.attach_email()", tagIcons::attach_email_communicate));
    icons.add(
        new IconCatalogEntry<>(
            "attribution", "MaterialSymbols.attribution()", tagIcons::attribution_communicate));
    icons.add(
        new IconCatalogEntry<>(
            "auto_read_pause",
            "MaterialSymbols.auto_read_pause()",
            tagIcons::auto_read_pause_communicate));
    icons.add(
        new IconCatalogEntry<>(
            "auto_read_play",
            "MaterialSymbols.auto_read_play()",
            tagIcons::auto_read_play_communicate));
    icons.add(
        new IconCatalogEntry<>(
            "business_messages",
            "MaterialSymbols.business_messages()",
            tagIcons::business_messages_communicate));
    icons.add(
        new IconCatalogEntry<>(
            "calendar_add_on",
            "MaterialSymbols.calendar_add_on()",
            tagIcons::calendar_add_on_communicate));
    icons.add(
        new IconCatalogEntry<>(
            "calendar_apps_script",
            "MaterialSymbols.calendar_apps_script()",
            tagIcons::calendar_apps_script_communicate));
    icons.add(new IconCatalogEntry<>("call", "MaterialSymbols.call()", tagIcons::call_communicate));
    icons.add(
        new IconCatalogEntry<>(
            "call_end", "MaterialSymbols.call_end()", tagIcons::call_end_communicate));
    icons.add(
        new IconCatalogEntry<>(
            "call_log", "MaterialSymbols.call_log()", tagIcons::call_log_communicate));
    icons.add(
        new IconCatalogEntry<>(
            "call_made", "MaterialSymbols.call_made()", tagIcons::call_made_communicate));
    icons.add(
        new IconCatalogEntry<>(
            "call_merge", "MaterialSymbols.call_merge()", tagIcons::call_merge_communicate));
    icons.add(
        new IconCatalogEntry<>(
            "call_missed", "MaterialSymbols.call_missed()", tagIcons::call_missed_communicate));
    icons.add(
        new IconCatalogEntry<>(
            "call_missed_outgoing",
            "MaterialSymbols.call_missed_outgoing()",
            tagIcons::call_missed_outgoing_communicate));
    icons.add(
        new IconCatalogEntry<>(
            "call_quality", "MaterialSymbols.call_quality()", tagIcons::call_quality_communicate));
    icons.add(
        new IconCatalogEntry<>(
            "call_received",
            "MaterialSymbols.call_received()",
            tagIcons::call_received_communicate));
    icons.add(
        new IconCatalogEntry<>(
            "call_split", "MaterialSymbols.call_split()", tagIcons::call_split_communicate));
    icons.add(
        new IconCatalogEntry<>(
            "cancel_presentation",
            "MaterialSymbols.cancel_presentation()",
            tagIcons::cancel_presentation_communicate));
    icons.add(
        new IconCatalogEntry<>(
            "cancel_schedule_send",
            "MaterialSymbols.cancel_schedule_send()",
            tagIcons::cancel_schedule_send_communicate));
    icons.add(
        new IconCatalogEntry<>(
            "cell_tower", "MaterialSymbols.cell_tower()", tagIcons::cell_tower_communicate));
    icons.add(
        new IconCatalogEntry<>(
            "cell_wifi", "MaterialSymbols.cell_wifi()", tagIcons::cell_wifi_communicate));
    icons.add(new IconCatalogEntry<>("chat", "MaterialSymbols.chat()", tagIcons::chat_communicate));
    icons.add(
        new IconCatalogEntry<>(
            "chat_add_on", "MaterialSymbols.chat_add_on()", tagIcons::chat_add_on_communicate));
    icons.add(
        new IconCatalogEntry<>(
            "chat_apps_script",
            "MaterialSymbols.chat_apps_script()",
            tagIcons::chat_apps_script_communicate));
    icons.add(
        new IconCatalogEntry<>(
            "chat_bubble", "MaterialSymbols.chat_bubble()", tagIcons::chat_bubble_communicate));
    icons.add(
        new IconCatalogEntry<>(
            "chat_bubble_off",
            "MaterialSymbols.chat_bubble_off()",
            tagIcons::chat_bubble_off_communicate));
    icons.add(
        new IconCatalogEntry<>(
            "chat_dashed", "MaterialSymbols.chat_dashed()", tagIcons::chat_dashed_communicate));
    icons.add(
        new IconCatalogEntry<>(
            "chat_error", "MaterialSymbols.chat_error()", tagIcons::chat_error_communicate));
    icons.add(
        new IconCatalogEntry<>(
            "chat_info", "MaterialSymbols.chat_info()", tagIcons::chat_info_communicate));
    icons.add(
        new IconCatalogEntry<>(
            "chat_paste_go",
            "MaterialSymbols.chat_paste_go()",
            tagIcons::chat_paste_go_communicate));
    icons.add(
        new IconCatalogEntry<>(
            "chat_paste_go_2",
            "MaterialSymbols.chat_paste_go_2()",
            tagIcons::chat_paste_go_2_communicate));
    icons.add(
        new IconCatalogEntry<>(
            "co_present", "MaterialSymbols.co_present()", tagIcons::co_present_communicate));
    icons.add(
        new IconCatalogEntry<>(
            "comment", "MaterialSymbols.comment()", tagIcons::comment_communicate));
    icons.add(
        new IconCatalogEntry<>(
            "comment_bank", "MaterialSymbols.comment_bank()", tagIcons::comment_bank_communicate));
    icons.add(
        new IconCatalogEntry<>(
            "comments_disabled",
            "MaterialSymbols.comments_disabled()",
            tagIcons::comments_disabled_communicate));
    icons.add(
        new IconCatalogEntry<>(
            "contact_emergency",
            "MaterialSymbols.contact_emergency()",
            tagIcons::contact_emergency_communicate));
    icons.add(
        new IconCatalogEntry<>(
            "contact_mail", "MaterialSymbols.contact_mail()", tagIcons::contact_mail_communicate));
    icons.add(
        new IconCatalogEntry<>(
            "contact_phone",
            "MaterialSymbols.contact_phone()",
            tagIcons::contact_phone_communicate));
    icons.add(
        new IconCatalogEntry<>(
            "contact_support",
            "MaterialSymbols.contact_support()",
            tagIcons::contact_support_communicate));
    icons.add(
        new IconCatalogEntry<>(
            "contacts", "MaterialSymbols.contacts()", tagIcons::contacts_communicate));
    icons.add(
        new IconCatalogEntry<>(
            "dialer_sip", "MaterialSymbols.dialer_sip()", tagIcons::dialer_sip_communicate));
    icons.add(
        new IconCatalogEntry<>(
            "dialpad", "MaterialSymbols.dialpad()", tagIcons::dialpad_communicate));
    icons.add(
        new IconCatalogEntry<>("drafts", "MaterialSymbols.drafts()", tagIcons::drafts_communicate));
    icons.add(new IconCatalogEntry<>("duo", "MaterialSymbols.duo()", tagIcons::duo_communicate));
    icons.add(
        new IconCatalogEntry<>(
            "e911_avatar", "MaterialSymbols.e911_avatar()", tagIcons::e911_avatar_communicate));
    icons.add(
        new IconCatalogEntry<>(
            "for_you", "MaterialSymbols.for_you()", tagIcons::for_you_communicate));
    icons.add(
        new IconCatalogEntry<>("forum", "MaterialSymbols.forum()", tagIcons::forum_communicate));
    icons.add(
        new IconCatalogEntry<>(
            "forward_to_inbox",
            "MaterialSymbols.forward_to_inbox()",
            tagIcons::forward_to_inbox_communicate));
    icons.add(
        new IconCatalogEntry<>(
            "g_translate", "MaterialSymbols.g_translate()", tagIcons::g_translate_communicate));
    icons.add(
        new IconCatalogEntry<>(
            "group_search", "MaterialSymbols.group_search()", tagIcons::group_search_communicate));
    icons.add(
        new IconCatalogEntry<>(
            "hourglass_bottom",
            "MaterialSymbols.hourglass_bottom()",
            tagIcons::hourglass_bottom_communicate));
    icons.add(
        new IconCatalogEntry<>(
            "hourglass_top",
            "MaterialSymbols.hourglass_top()",
            tagIcons::hourglass_top_communicate));
    icons.add(new IconCatalogEntry<>("hub", "MaterialSymbols.hub()", tagIcons::hub_communicate));
    icons.add(
        new IconCatalogEntry<>(
            "import_contacts",
            "MaterialSymbols.import_contacts()",
            tagIcons::import_contacts_communicate));
    icons.add(
        new IconCatalogEntry<>("inbox", "MaterialSymbols.inbox()", tagIcons::inbox_communicate));
    icons.add(
        new IconCatalogEntry<>(
            "inbox_customize",
            "MaterialSymbols.inbox_customize()",
            tagIcons::inbox_customize_communicate));
    icons.add(
        new IconCatalogEntry<>(
            "inbox_text", "MaterialSymbols.inbox_text()", tagIcons::inbox_text_communicate));
    icons.add(
        new IconCatalogEntry<>(
            "inbox_text_asterisk",
            "MaterialSymbols.inbox_text_asterisk()",
            tagIcons::inbox_text_asterisk_communicate));
    icons.add(
        new IconCatalogEntry<>(
            "inbox_text_person",
            "MaterialSymbols.inbox_text_person()",
            tagIcons::inbox_text_person_communicate));
    icons.add(
        new IconCatalogEntry<>(
            "inbox_text_share",
            "MaterialSymbols.inbox_text_share()",
            tagIcons::inbox_text_share_communicate));
    icons.add(
        new IconCatalogEntry<>(
            "inventory_2", "MaterialSymbols.inventory_2()", tagIcons::inventory_2_communicate));
    icons.add(new IconCatalogEntry<>("lan", "MaterialSymbols.lan()", tagIcons::lan_communicate));
    icons.add(new IconCatalogEntry<>("link", "MaterialSymbols.link()", tagIcons::link_communicate));
    icons.add(
        new IconCatalogEntry<>("link_2", "MaterialSymbols.link_2()", tagIcons::link_2_communicate));
    icons.add(
        new IconCatalogEntry<>(
            "link_off", "MaterialSymbols.link_off()", tagIcons::link_off_communicate));
    icons.add(
        new IconCatalogEntry<>(
            "live_help", "MaterialSymbols.live_help()", tagIcons::live_help_communicate));
    icons.add(new IconCatalogEntry<>("mail", "MaterialSymbols.mail()", tagIcons::mail_communicate));
    icons.add(
        new IconCatalogEntry<>(
            "mail_asterisk",
            "MaterialSymbols.mail_asterisk()",
            tagIcons::mail_asterisk_communicate));
    icons.add(
        new IconCatalogEntry<>(
            "mail_lock", "MaterialSymbols.mail_lock()", tagIcons::mail_lock_communicate));
    icons.add(
        new IconCatalogEntry<>(
            "mail_off", "MaterialSymbols.mail_off()", tagIcons::mail_off_communicate));
    icons.add(
        new IconCatalogEntry<>(
            "mail_shield", "MaterialSymbols.mail_shield()", tagIcons::mail_shield_communicate));
    icons.add(
        new IconCatalogEntry<>(
            "mark_as_unread",
            "MaterialSymbols.mark_as_unread()",
            tagIcons::mark_as_unread_communicate));
    icons.add(
        new IconCatalogEntry<>(
            "mark_chat_read",
            "MaterialSymbols.mark_chat_read()",
            tagIcons::mark_chat_read_communicate));
    icons.add(
        new IconCatalogEntry<>(
            "mark_chat_unread",
            "MaterialSymbols.mark_chat_unread()",
            tagIcons::mark_chat_unread_communicate));
    icons.add(
        new IconCatalogEntry<>(
            "mark_email_read",
            "MaterialSymbols.mark_email_read()",
            tagIcons::mark_email_read_communicate));
    icons.add(
        new IconCatalogEntry<>(
            "mark_email_unread",
            "MaterialSymbols.mark_email_unread()",
            tagIcons::mark_email_unread_communicate));
    icons.add(
        new IconCatalogEntry<>(
            "mark_unread_chat_alt",
            "MaterialSymbols.mark_unread_chat_alt()",
            tagIcons::mark_unread_chat_alt_communicate));
    icons.add(
        new IconCatalogEntry<>(
            "markunread_mailbox",
            "MaterialSymbols.markunread_mailbox()",
            tagIcons::markunread_mailbox_communicate));
    icons.add(new IconCatalogEntry<>("mms", "MaterialSymbols.mms()", tagIcons::mms_communicate));
    icons.add(
        new IconCatalogEntry<>(
            "mobile_cancel",
            "MaterialSymbols.mobile_cancel()",
            tagIcons::mobile_cancel_communicate));
    icons.add(
        new IconCatalogEntry<>(
            "mobile_sound", "MaterialSymbols.mobile_sound()", tagIcons::mobile_sound_communicate));
    icons.add(
        new IconCatalogEntry<>(
            "mobile_sound_off",
            "MaterialSymbols.mobile_sound_off()",
            tagIcons::mobile_sound_off_communicate));
    icons.add(
        new IconCatalogEntry<>(
            "mode_comment", "MaterialSymbols.mode_comment()", tagIcons::mode_comment_communicate));
    icons.add(
        new IconCatalogEntry<>(
            "move_to_inbox",
            "MaterialSymbols.move_to_inbox()",
            tagIcons::move_to_inbox_communicate));
    icons.add(new IconCatalogEntry<>("nat", "MaterialSymbols.nat()", tagIcons::nat_communicate));
    icons.add(
        new IconCatalogEntry<>(
            "network_intel_node",
            "MaterialSymbols.network_intel_node()",
            tagIcons::network_intel_node_communicate));
    icons.add(
        new IconCatalogEntry<>(
            "network_intelligence",
            "MaterialSymbols.network_intelligence()",
            tagIcons::network_intelligence_communicate));
    icons.add(
        new IconCatalogEntry<>(
            "network_intelligence_history",
            "MaterialSymbols.network_intelligence_history()",
            tagIcons::network_intelligence_history_communicate));
    icons.add(
        new IconCatalogEntry<>(
            "network_intelligence_update",
            "MaterialSymbols.network_intelligence_update()",
            tagIcons::network_intelligence_update_communicate));
    icons.add(
        new IconCatalogEntry<>(
            "network_manage",
            "MaterialSymbols.network_manage()",
            tagIcons::network_manage_communicate));
    icons.add(
        new IconCatalogEntry<>(
            "next_plan", "MaterialSymbols.next_plan()", tagIcons::next_plan_communicate));
    icons.add(
        new IconCatalogEntry<>(
            "notification_audio",
            "MaterialSymbols.notification_audio()",
            tagIcons::notification_audio_communicate));
    icons.add(
        new IconCatalogEntry<>(
            "notification_audio_off",
            "MaterialSymbols.notification_audio_off()",
            tagIcons::notification_audio_off_communicate));
    icons.add(
        new IconCatalogEntry<>(
            "notification_multiple",
            "MaterialSymbols.notification_multiple()",
            tagIcons::notification_multiple_communicate));
    icons.add(
        new IconCatalogEntry<>(
            "notification_settings",
            "MaterialSymbols.notification_settings()",
            tagIcons::notification_settings_communicate));
  }

  private static void addIcons1() {
    icons.add(
        new IconCatalogEntry<>(
            "notification_sound",
            "MaterialSymbols.notification_sound()",
            tagIcons::notification_sound_communicate));
    icons.add(
        new IconCatalogEntry<>(
            "notifications",
            "MaterialSymbols.notifications()",
            tagIcons::notifications_communicate));
    icons.add(
        new IconCatalogEntry<>(
            "notifications_active",
            "MaterialSymbols.notifications_active()",
            tagIcons::notifications_active_communicate));
    icons.add(
        new IconCatalogEntry<>(
            "notifications_off",
            "MaterialSymbols.notifications_off()",
            tagIcons::notifications_off_communicate));
    icons.add(
        new IconCatalogEntry<>(
            "notifications_paused",
            "MaterialSymbols.notifications_paused()",
            tagIcons::notifications_paused_communicate));
    icons.add(
        new IconCatalogEntry<>(
            "notifications_unread",
            "MaterialSymbols.notifications_unread()",
            tagIcons::notifications_unread_communicate));
    icons.add(new IconCatalogEntry<>("ods", "MaterialSymbols.ods()", tagIcons::ods_communicate));
    icons.add(new IconCatalogEntry<>("odt", "MaterialSymbols.odt()", tagIcons::odt_communicate));
    icons.add(
        new IconCatalogEntry<>("outbox", "MaterialSymbols.outbox()", tagIcons::outbox_communicate));
    icons.add(
        new IconCatalogEntry<>(
            "outbox_alt", "MaterialSymbols.outbox_alt()", tagIcons::outbox_alt_communicate));
    icons.add(
        new IconCatalogEntry<>(
            "outgoing_mail",
            "MaterialSymbols.outgoing_mail()",
            tagIcons::outgoing_mail_communicate));
    icons.add(
        new IconCatalogEntry<>(
            "pause_presentation",
            "MaterialSymbols.pause_presentation()",
            tagIcons::pause_presentation_communicate));
    icons.add(
        new IconCatalogEntry<>(
            "perm_phone_msg",
            "MaterialSymbols.perm_phone_msg()",
            tagIcons::perm_phone_msg_communicate));
    icons.add(
        new IconCatalogEntry<>(
            "person_search",
            "MaterialSymbols.person_search()",
            tagIcons::person_search_communicate));
    icons.add(
        new IconCatalogEntry<>(
            "phone_bluetooth_speaker",
            "MaterialSymbols.phone_bluetooth_speaker()",
            tagIcons::phone_bluetooth_speaker_communicate));
    icons.add(
        new IconCatalogEntry<>(
            "phone_callback",
            "MaterialSymbols.phone_callback()",
            tagIcons::phone_callback_communicate));
    icons.add(
        new IconCatalogEntry<>(
            "phone_cancel", "MaterialSymbols.phone_cancel()", tagIcons::phone_cancel_communicate));
    icons.add(
        new IconCatalogEntry<>(
            "phone_disabled",
            "MaterialSymbols.phone_disabled()",
            tagIcons::phone_disabled_communicate));
    icons.add(
        new IconCatalogEntry<>(
            "phone_enabled",
            "MaterialSymbols.phone_enabled()",
            tagIcons::phone_enabled_communicate));
    icons.add(
        new IconCatalogEntry<>(
            "phone_forwarded",
            "MaterialSymbols.phone_forwarded()",
            tagIcons::phone_forwarded_communicate));
    icons.add(
        new IconCatalogEntry<>(
            "phone_in_talk",
            "MaterialSymbols.phone_in_talk()",
            tagIcons::phone_in_talk_communicate));
    icons.add(
        new IconCatalogEntry<>(
            "phone_locked", "MaterialSymbols.phone_locked()", tagIcons::phone_locked_communicate));
    icons.add(
        new IconCatalogEntry<>(
            "phone_missed", "MaterialSymbols.phone_missed()", tagIcons::phone_missed_communicate));
    icons.add(
        new IconCatalogEntry<>(
            "phone_paused", "MaterialSymbols.phone_paused()", tagIcons::phone_paused_communicate));
    icons.add(
        new IconCatalogEntry<>(
            "picture_in_picture",
            "MaterialSymbols.picture_in_picture()",
            tagIcons::picture_in_picture_communicate));
    icons.add(
        new IconCatalogEntry<>(
            "picture_in_picture_alt",
            "MaterialSymbols.picture_in_picture_alt()",
            tagIcons::picture_in_picture_alt_communicate));
    icons.add(
        new IconCatalogEntry<>(
            "picture_in_picture_center",
            "MaterialSymbols.picture_in_picture_center()",
            tagIcons::picture_in_picture_center_communicate));
    icons.add(
        new IconCatalogEntry<>(
            "picture_in_picture_large",
            "MaterialSymbols.picture_in_picture_large()",
            tagIcons::picture_in_picture_large_communicate));
    icons.add(
        new IconCatalogEntry<>(
            "picture_in_picture_medium",
            "MaterialSymbols.picture_in_picture_medium()",
            tagIcons::picture_in_picture_medium_communicate));
    icons.add(
        new IconCatalogEntry<>(
            "picture_in_picture_mobile",
            "MaterialSymbols.picture_in_picture_mobile()",
            tagIcons::picture_in_picture_mobile_communicate));
    icons.add(
        new IconCatalogEntry<>(
            "picture_in_picture_off",
            "MaterialSymbols.picture_in_picture_off()",
            tagIcons::picture_in_picture_off_communicate));
    icons.add(
        new IconCatalogEntry<>(
            "picture_in_picture_small",
            "MaterialSymbols.picture_in_picture_small()",
            tagIcons::picture_in_picture_small_communicate));
    icons.add(
        new IconCatalogEntry<>(
            "play_for_work",
            "MaterialSymbols.play_for_work()",
            tagIcons::play_for_work_communicate));
    icons.add(
        new IconCatalogEntry<>(
            "present_to_all",
            "MaterialSymbols.present_to_all()",
            tagIcons::present_to_all_communicate));
    icons.add(
        new IconCatalogEntry<>(
            "quickreply", "MaterialSymbols.quickreply()", tagIcons::quickreply_communicate));
    icons.add(
        new IconCatalogEntry<>(
            "reviews", "MaterialSymbols.reviews()", tagIcons::reviews_communicate));
    icons.add(
        new IconCatalogEntry<>(
            "ring_volume", "MaterialSymbols.ring_volume()", tagIcons::ring_volume_communicate));
    icons.add(new IconCatalogEntry<>("rtt", "MaterialSymbols.rtt()", tagIcons::rtt_communicate));
    icons.add(
        new IconCatalogEntry<>(
            "satellite_alt",
            "MaterialSymbols.satellite_alt()",
            tagIcons::satellite_alt_communicate));
    icons.add(
        new IconCatalogEntry<>(
            "schedule_send",
            "MaterialSymbols.schedule_send()",
            tagIcons::schedule_send_communicate));
    icons.add(
        new IconCatalogEntry<>("score", "MaterialSymbols.score()", tagIcons::score_communicate));
    icons.add(new IconCatalogEntry<>("send", "MaterialSymbols.send()", tagIcons::send_communicate));
    icons.add(
        new IconCatalogEntry<>(
            "send_and_archive",
            "MaterialSymbols.send_and_archive()",
            tagIcons::send_and_archive_communicate));
    icons.add(
        new IconCatalogEntry<>(
            "settings_bluetooth",
            "MaterialSymbols.settings_bluetooth()",
            tagIcons::settings_bluetooth_communicate));
    icons.add(
        new IconCatalogEntry<>(
            "settings_phone",
            "MaterialSymbols.settings_phone()",
            tagIcons::settings_phone_communicate));
    icons.add(
        new IconCatalogEntry<>(
            "signal_cellular_add",
            "MaterialSymbols.signal_cellular_add()",
            tagIcons::signal_cellular_add_communicate));
    icons.add(new IconCatalogEntry<>("sip", "MaterialSymbols.sip()", tagIcons::sip_communicate));
    icons.add(new IconCatalogEntry<>("sms", "MaterialSymbols.sms()", tagIcons::sms_communicate));
    icons.add(
        new IconCatalogEntry<>(
            "speaker_notes",
            "MaterialSymbols.speaker_notes()",
            tagIcons::speaker_notes_communicate));
    icons.add(
        new IconCatalogEntry<>(
            "speaker_notes_off",
            "MaterialSymbols.speaker_notes_off()",
            tagIcons::speaker_notes_off_communicate));
    icons.add(
        new IconCatalogEntry<>(
            "speaker_phone",
            "MaterialSymbols.speaker_phone()",
            tagIcons::speaker_phone_communicate));
    icons.add(
        new IconCatalogEntry<>("spoke", "MaterialSymbols.spoke()", tagIcons::spoke_communicate));
    icons.add(
        new IconCatalogEntry<>(
            "stacked_email",
            "MaterialSymbols.stacked_email()",
            tagIcons::stacked_email_communicate));
    icons.add(
        new IconCatalogEntry<>(
            "stacked_inbox",
            "MaterialSymbols.stacked_inbox()",
            tagIcons::stacked_inbox_communicate));
    icons.add(
        new IconCatalogEntry<>(
            "swap_calls", "MaterialSymbols.swap_calls()", tagIcons::swap_calls_communicate));
    icons.add(
        new IconCatalogEntry<>(
            "thread_unread",
            "MaterialSymbols.thread_unread()",
            tagIcons::thread_unread_communicate));
    icons.add(
        new IconCatalogEntry<>(
            "threat_intelligence",
            "MaterialSymbols.threat_intelligence()",
            tagIcons::threat_intelligence_communicate));
    icons.add(
        new IconCatalogEntry<>(
            "tooltip", "MaterialSymbols.tooltip()", tagIcons::tooltip_communicate));
    icons.add(
        new IconCatalogEntry<>(
            "tooltip_2", "MaterialSymbols.tooltip_2()", tagIcons::tooltip_2_communicate));
    icons.add(
        new IconCatalogEntry<>("topic", "MaterialSymbols.topic()", tagIcons::topic_communicate));
    icons.add(
        new IconCatalogEntry<>(
            "unarchive", "MaterialSymbols.unarchive()", tagIcons::unarchive_communicate));
    icons.add(
        new IconCatalogEntry<>(
            "unsubscribe", "MaterialSymbols.unsubscribe()", tagIcons::unsubscribe_communicate));
    icons.add(
        new IconCatalogEntry<>(
            "upcoming", "MaterialSymbols.upcoming()", tagIcons::upcoming_communicate));
    icons.add(
        new IconCatalogEntry<>(
            "video_chat", "MaterialSymbols.video_chat()", tagIcons::video_chat_communicate));
    icons.add(
        new IconCatalogEntry<>(
            "voice_chat", "MaterialSymbols.voice_chat()", tagIcons::voice_chat_communicate));
    icons.add(
        new IconCatalogEntry<>(
            "voice_chat_off",
            "MaterialSymbols.voice_chat_off()",
            tagIcons::voice_chat_off_communicate));
    icons.add(
        new IconCatalogEntry<>(
            "voicemail", "MaterialSymbols.voicemail()", tagIcons::voicemail_communicate));
    icons.add(
        new IconCatalogEntry<>(
            "voicemail_2", "MaterialSymbols.voicemail_2()", tagIcons::voicemail_2_communicate));
    icons.add(
        new IconCatalogEntry<>(
            "wifi_add", "MaterialSymbols.wifi_add()", tagIcons::wifi_add_communicate));
    icons.add(
        new IconCatalogEntry<>(
            "wifi_calling", "MaterialSymbols.wifi_calling()", tagIcons::wifi_calling_communicate));
    icons.add(
        new IconCatalogEntry<>(
            "wifi_channel", "MaterialSymbols.wifi_channel()", tagIcons::wifi_channel_communicate));
    icons.add(
        new IconCatalogEntry<>(
            "wifi_proxy", "MaterialSymbols.wifi_proxy()", tagIcons::wifi_proxy_communicate));
  }

  public List<IconCatalogEntry<MaterialSymbolsIcon>> icons() {
    return new ArrayList<>(icons);
  }
}
