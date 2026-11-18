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
import org.dominokit.domino.ui.icons.TablerIcon;
import org.dominokit.domino.ui.icons.TablerMedia;

/** Static icon factory for the Tabler Media category. */
public final class TablerMedia_Factory {
  private static final List<IconCatalogEntry<TablerIcon>> icons = new ArrayList<>();
  private static final TablerMedia tagIcons = new TablerMedia() {};

  static {
    addIcons0();
    addIcons1();
  }

  private static void addIcons0() {
    icons.add(new IconCatalogEntry<>("album", "TablerIcons.album()", tagIcons::album));
    icons.add(
        new IconCatalogEntry<>(
            "album-off", "TablerIcons.album_off()", tagIcons::album_off));
    icons.add(
        new IconCatalogEntry<>(
            "aspect-ratio", "TablerIcons.aspect_ratio()", tagIcons::aspect_ratio));
    icons.add(
        new IconCatalogEntry<>(
            "aspect-ratio-off",
            "TablerIcons.aspect_ratio_off()",
            tagIcons::aspect_ratio_off));
    icons.add(new IconCatalogEntry<>("camera", "TablerIcons.camera()", tagIcons::camera));
    icons.add(
        new IconCatalogEntry<>(
            "camera-ai", "TablerIcons.camera_ai()", tagIcons::camera_ai));
    icons.add(
        new IconCatalogEntry<>(
            "camera-bitcoin", "TablerIcons.camera_bitcoin()", tagIcons::camera_bitcoin));
    icons.add(
        new IconCatalogEntry<>(
            "camera-bolt", "TablerIcons.camera_bolt()", tagIcons::camera_bolt));
    icons.add(
        new IconCatalogEntry<>(
            "camera-cancel", "TablerIcons.camera_cancel()", tagIcons::camera_cancel));
    icons.add(
        new IconCatalogEntry<>(
            "camera-check", "TablerIcons.camera_check()", tagIcons::camera_check));
    icons.add(
        new IconCatalogEntry<>(
            "camera-code", "TablerIcons.camera_code()", tagIcons::camera_code));
    icons.add(
        new IconCatalogEntry<>(
            "camera-cog", "TablerIcons.camera_cog()", tagIcons::camera_cog));
    icons.add(
        new IconCatalogEntry<>(
            "camera-dollar", "TablerIcons.camera_dollar()", tagIcons::camera_dollar));
    icons.add(
        new IconCatalogEntry<>(
            "camera-down", "TablerIcons.camera_down()", tagIcons::camera_down));
    icons.add(
        new IconCatalogEntry<>(
            "camera-exclamation",
            "TablerIcons.camera_exclamation()",
            tagIcons::camera_exclamation));
    icons.add(
        new IconCatalogEntry<>(
            "camera-heart", "TablerIcons.camera_heart()", tagIcons::camera_heart));
    icons.add(
        new IconCatalogEntry<>(
            "camera-minus", "TablerIcons.camera_minus()", tagIcons::camera_minus));
    icons.add(
        new IconCatalogEntry<>(
            "camera-moon", "TablerIcons.camera_moon()", tagIcons::camera_moon));
    icons.add(
        new IconCatalogEntry<>(
            "camera-off", "TablerIcons.camera_off()", tagIcons::camera_off));
    icons.add(
        new IconCatalogEntry<>(
            "camera-pause", "TablerIcons.camera_pause()", tagIcons::camera_pause));
    icons.add(
        new IconCatalogEntry<>(
            "camera-pin", "TablerIcons.camera_pin()", tagIcons::camera_pin));
    icons.add(
        new IconCatalogEntry<>(
            "camera-plus", "TablerIcons.camera_plus()", tagIcons::camera_plus));
    icons.add(
        new IconCatalogEntry<>(
            "camera-question",
            "TablerIcons.camera_question()",
            tagIcons::camera_question));
    icons.add(
        new IconCatalogEntry<>(
            "camera-search", "TablerIcons.camera_search()", tagIcons::camera_search));
    icons.add(
        new IconCatalogEntry<>(
            "camera-share", "TablerIcons.camera_share()", tagIcons::camera_share));
    icons.add(
        new IconCatalogEntry<>(
            "camera-spark", "TablerIcons.camera_spark()", tagIcons::camera_spark));
    icons.add(
        new IconCatalogEntry<>(
            "camera-star", "TablerIcons.camera_star()", tagIcons::camera_star));
    icons.add(
        new IconCatalogEntry<>(
            "camera-up", "TablerIcons.camera_up()", tagIcons::camera_up));
    icons.add(
        new IconCatalogEntry<>("camera-x", "TablerIcons.camera_x()", tagIcons::camera_x));
    icons.add(
        new IconCatalogEntry<>("capture", "TablerIcons.capture()", tagIcons::capture));
    icons.add(
        new IconCatalogEntry<>(
            "capture-off", "TablerIcons.capture_off()", tagIcons::capture_off));
    icons.add(new IconCatalogEntry<>("cast", "TablerIcons.cast()", tagIcons::cast));
    icons.add(
        new IconCatalogEntry<>("cast-off", "TablerIcons.cast_off()", tagIcons::cast_off));
    icons.add(
        new IconCatalogEntry<>(
            "circle-pause", "TablerIcons.circle_pause()", tagIcons::circle_pause));
    icons.add(
        new IconCatalogEntry<>(
            "circle-play", "TablerIcons.circle_play()", tagIcons::circle_play));
    icons.add(
        new IconCatalogEntry<>(
            "circle-stop", "TablerIcons.circle_stop()", tagIcons::circle_stop));
    icons.add(new IconCatalogEntry<>("clef", "TablerIcons.clef()", tagIcons::clef));
    icons.add(
        new IconCatalogEntry<>(
            "clef-staff", "TablerIcons.clef_staff()", tagIcons::clef_staff));
    icons.add(
        new IconCatalogEntry<>(
            "headphones", "TablerIcons.headphones()", tagIcons::headphones));
    icons.add(
        new IconCatalogEntry<>(
            "headphones-off", "TablerIcons.headphones_off()", tagIcons::headphones_off));
    icons.add(
        new IconCatalogEntry<>("headset", "TablerIcons.headset()", tagIcons::headset));
    icons.add(
        new IconCatalogEntry<>(
            "headset-off", "TablerIcons.headset_off()", tagIcons::headset_off));
    icons.add(
        new IconCatalogEntry<>("keyframe", "TablerIcons.keyframe()", tagIcons::keyframe));
    icons.add(
        new IconCatalogEntry<>(
            "keyframe-align-center",
            "TablerIcons.keyframe_align_center()",
            tagIcons::keyframe_align_center));
    icons.add(
        new IconCatalogEntry<>(
            "keyframe-align-horizontal",
            "TablerIcons.keyframe_align_horizontal()",
            tagIcons::keyframe_align_horizontal));
    icons.add(
        new IconCatalogEntry<>(
            "keyframe-align-vertical",
            "TablerIcons.keyframe_align_vertical()",
            tagIcons::keyframe_align_vertical));
    icons.add(
        new IconCatalogEntry<>(
            "keyframes", "TablerIcons.keyframes()", tagIcons::keyframes));
    icons.add(
        new IconCatalogEntry<>("maximize", "TablerIcons.maximize()", tagIcons::maximize));
    icons.add(
        new IconCatalogEntry<>(
            "maximize-off", "TablerIcons.maximize_off()", tagIcons::maximize_off));
    icons.add(
        new IconCatalogEntry<>(
            "microphone", "TablerIcons.microphone()", tagIcons::microphone));
    icons.add(
        new IconCatalogEntry<>(
            "microphone-2", "TablerIcons.microphone_2()", tagIcons::microphone_2));
    icons.add(
        new IconCatalogEntry<>(
            "microphone-2-off",
            "TablerIcons.microphone_2_off()",
            tagIcons::microphone_2_off));
    icons.add(
        new IconCatalogEntry<>(
            "microphone-off", "TablerIcons.microphone_off()", tagIcons::microphone_off));
    icons.add(
        new IconCatalogEntry<>("minimize", "TablerIcons.minimize()", tagIcons::minimize));
    icons.add(new IconCatalogEntry<>("movie", "TablerIcons.movie()", tagIcons::movie));
    icons.add(
        new IconCatalogEntry<>(
            "movie-off", "TablerIcons.movie_off()", tagIcons::movie_off));
    icons.add(new IconCatalogEntry<>("music", "TablerIcons.music()", tagIcons::music));
    icons.add(
        new IconCatalogEntry<>(
            "music-bolt", "TablerIcons.music_bolt()", tagIcons::music_bolt));
    icons.add(
        new IconCatalogEntry<>(
            "music-cancel", "TablerIcons.music_cancel()", tagIcons::music_cancel));
    icons.add(
        new IconCatalogEntry<>(
            "music-check", "TablerIcons.music_check()", tagIcons::music_check));
    icons.add(
        new IconCatalogEntry<>(
            "music-code", "TablerIcons.music_code()", tagIcons::music_code));
    icons.add(
        new IconCatalogEntry<>(
            "music-cog", "TablerIcons.music_cog()", tagIcons::music_cog));
    icons.add(
        new IconCatalogEntry<>(
            "music-dollar", "TablerIcons.music_dollar()", tagIcons::music_dollar));
    icons.add(
        new IconCatalogEntry<>(
            "music-down", "TablerIcons.music_down()", tagIcons::music_down));
    icons.add(
        new IconCatalogEntry<>(
            "music-exclamation",
            "TablerIcons.music_exclamation()",
            tagIcons::music_exclamation));
    icons.add(
        new IconCatalogEntry<>(
            "music-heart", "TablerIcons.music_heart()", tagIcons::music_heart));
    icons.add(
        new IconCatalogEntry<>(
            "music-minus", "TablerIcons.music_minus()", tagIcons::music_minus));
    icons.add(
        new IconCatalogEntry<>(
            "music-off", "TablerIcons.music_off()", tagIcons::music_off));
    icons.add(
        new IconCatalogEntry<>(
            "music-pause", "TablerIcons.music_pause()", tagIcons::music_pause));
    icons.add(
        new IconCatalogEntry<>(
            "music-pin", "TablerIcons.music_pin()", tagIcons::music_pin));
    icons.add(
        new IconCatalogEntry<>(
            "music-plus", "TablerIcons.music_plus()", tagIcons::music_plus));
    icons.add(
        new IconCatalogEntry<>(
            "music-question", "TablerIcons.music_question()", tagIcons::music_question));
    icons.add(
        new IconCatalogEntry<>(
            "music-search", "TablerIcons.music_search()", tagIcons::music_search));
    icons.add(
        new IconCatalogEntry<>(
            "music-share", "TablerIcons.music_share()", tagIcons::music_share));
    icons.add(
        new IconCatalogEntry<>(
            "music-star", "TablerIcons.music_star()", tagIcons::music_star));
    icons.add(
        new IconCatalogEntry<>("music-up", "TablerIcons.music_up()", tagIcons::music_up));
    icons.add(
        new IconCatalogEntry<>("music-x", "TablerIcons.music_x()", tagIcons::music_x));
    icons.add(new IconCatalogEntry<>("photo", "TablerIcons.photo()", tagIcons::photo));
    icons.add(
        new IconCatalogEntry<>("photo-ai", "TablerIcons.photo_ai()", tagIcons::photo_ai));
    icons.add(
        new IconCatalogEntry<>(
            "photo-alt", "TablerIcons.photo_alt()", tagIcons::photo_alt));
    icons.add(
        new IconCatalogEntry<>(
            "photo-bolt", "TablerIcons.photo_bolt()", tagIcons::photo_bolt));
    icons.add(
        new IconCatalogEntry<>(
            "photo-cancel", "TablerIcons.photo_cancel()", tagIcons::photo_cancel));
    icons.add(
        new IconCatalogEntry<>(
            "photo-check", "TablerIcons.photo_check()", tagIcons::photo_check));
    icons.add(
        new IconCatalogEntry<>(
            "photo-circle-minus",
            "TablerIcons.photo_circle_minus()",
            tagIcons::photo_circle_minus));
    icons.add(
        new IconCatalogEntry<>(
            "photo-circle-plus",
            "TablerIcons.photo_circle_plus()",
            tagIcons::photo_circle_plus));
    icons.add(
        new IconCatalogEntry<>(
            "photo-code", "TablerIcons.photo_code()", tagIcons::photo_code));
    icons.add(
        new IconCatalogEntry<>(
            "photo-cog", "TablerIcons.photo_cog()", tagIcons::photo_cog));
    icons.add(
        new IconCatalogEntry<>(
            "photo-dollar", "TablerIcons.photo_dollar()", tagIcons::photo_dollar));
    icons.add(
        new IconCatalogEntry<>(
            "photo-down", "TablerIcons.photo_down()", tagIcons::photo_down));
    icons.add(
        new IconCatalogEntry<>(
            "photo-edit", "TablerIcons.photo_edit()", tagIcons::photo_edit));
    icons.add(
        new IconCatalogEntry<>(
            "photo-exclamation",
            "TablerIcons.photo_exclamation()",
            tagIcons::photo_exclamation));
    icons.add(
        new IconCatalogEntry<>(
            "photo-heart", "TablerIcons.photo_heart()", tagIcons::photo_heart));
    icons.add(
        new IconCatalogEntry<>(
            "photo-minus", "TablerIcons.photo_minus()", tagIcons::photo_minus));
    icons.add(
        new IconCatalogEntry<>(
            "photo-off", "TablerIcons.photo_off()", tagIcons::photo_off));
    icons.add(
        new IconCatalogEntry<>(
            "photo-pause", "TablerIcons.photo_pause()", tagIcons::photo_pause));
    icons.add(
        new IconCatalogEntry<>(
            "photo-pin", "TablerIcons.photo_pin()", tagIcons::photo_pin));
    icons.add(
        new IconCatalogEntry<>(
            "photo-plus", "TablerIcons.photo_plus()", tagIcons::photo_plus));
    icons.add(
        new IconCatalogEntry<>(
            "photo-question", "TablerIcons.photo_question()", tagIcons::photo_question));
    icons.add(
        new IconCatalogEntry<>(
            "photo-search", "TablerIcons.photo_search()", tagIcons::photo_search));
    icons.add(
        new IconCatalogEntry<>(
            "photo-share", "TablerIcons.photo_share()", tagIcons::photo_share));
  }

  private static void addIcons1() {
    icons.add(
        new IconCatalogEntry<>(
            "photo-shield", "TablerIcons.photo_shield()", tagIcons::photo_shield));
    icons.add(
        new IconCatalogEntry<>(
            "photo-spark", "TablerIcons.photo_spark()", tagIcons::photo_spark));
    icons.add(
        new IconCatalogEntry<>(
            "photo-star", "TablerIcons.photo_star()", tagIcons::photo_star));
    icons.add(
        new IconCatalogEntry<>("photo-up", "TablerIcons.photo_up()", tagIcons::photo_up));
    icons.add(
        new IconCatalogEntry<>("photo-x", "TablerIcons.photo_x()", tagIcons::photo_x));
    icons.add(
        new IconCatalogEntry<>(
            "picture-in-picture",
            "TablerIcons.picture_in_picture()",
            tagIcons::picture_in_picture));
    icons.add(
        new IconCatalogEntry<>(
            "picture-in-picture-off",
            "TablerIcons.picture_in_picture_off()",
            tagIcons::picture_in_picture_off));
    icons.add(
        new IconCatalogEntry<>(
            "picture-in-picture-on",
            "TablerIcons.picture_in_picture_on()",
            tagIcons::picture_in_picture_on));
    icons.add(
        new IconCatalogEntry<>(
            "picture-in-picture-top",
            "TablerIcons.picture_in_picture_top()",
            tagIcons::picture_in_picture_top));
    icons.add(
        new IconCatalogEntry<>(
            "player-eject", "TablerIcons.player_eject()", tagIcons::player_eject));
    icons.add(
        new IconCatalogEntry<>(
            "player-pause", "TablerIcons.player_pause()", tagIcons::player_pause));
    icons.add(
        new IconCatalogEntry<>(
            "player-play", "TablerIcons.player_play()", tagIcons::player_play));
    icons.add(
        new IconCatalogEntry<>(
            "player-record", "TablerIcons.player_record()", tagIcons::player_record));
    icons.add(
        new IconCatalogEntry<>(
            "player-skip-back",
            "TablerIcons.player_skip_back()",
            tagIcons::player_skip_back));
    icons.add(
        new IconCatalogEntry<>(
            "player-skip-forward",
            "TablerIcons.player_skip_forward()",
            tagIcons::player_skip_forward));
    icons.add(
        new IconCatalogEntry<>(
            "player-stop", "TablerIcons.player_stop()", tagIcons::player_stop));
    icons.add(
        new IconCatalogEntry<>(
            "player-track-next",
            "TablerIcons.player_track_next()",
            tagIcons::player_track_next));
    icons.add(
        new IconCatalogEntry<>(
            "player-track-prev",
            "TablerIcons.player_track_prev()",
            tagIcons::player_track_prev));
    icons.add(
        new IconCatalogEntry<>("playlist", "TablerIcons.playlist()", tagIcons::playlist));
    icons.add(
        new IconCatalogEntry<>(
            "playlist-off", "TablerIcons.playlist_off()", tagIcons::playlist_off));
    icons.add(
        new IconCatalogEntry<>(
            "playlist-x", "TablerIcons.playlist_x()", tagIcons::playlist_x));
    icons.add(new IconCatalogEntry<>("radio", "TablerIcons.radio()", tagIcons::radio));
    icons.add(
        new IconCatalogEntry<>(
            "radio-off", "TablerIcons.radio_off()", tagIcons::radio_off));
    icons.add(new IconCatalogEntry<>("repeat", "TablerIcons.repeat()", tagIcons::repeat));
    icons.add(
        new IconCatalogEntry<>(
            "repeat-off", "TablerIcons.repeat_off()", tagIcons::repeat_off));
    icons.add(
        new IconCatalogEntry<>(
            "repeat-once", "TablerIcons.repeat_once()", tagIcons::repeat_once));
    icons.add(
        new IconCatalogEntry<>(
            "rewind-backward-10",
            "TablerIcons.rewind_backward_10()",
            tagIcons::rewind_backward_10));
    icons.add(
        new IconCatalogEntry<>(
            "rewind-backward-15",
            "TablerIcons.rewind_backward_15()",
            tagIcons::rewind_backward_15));
    icons.add(
        new IconCatalogEntry<>(
            "rewind-backward-20",
            "TablerIcons.rewind_backward_20()",
            tagIcons::rewind_backward_20));
    icons.add(
        new IconCatalogEntry<>(
            "rewind-backward-30",
            "TablerIcons.rewind_backward_30()",
            tagIcons::rewind_backward_30));
    icons.add(
        new IconCatalogEntry<>(
            "rewind-backward-40",
            "TablerIcons.rewind_backward_40()",
            tagIcons::rewind_backward_40));
    icons.add(
        new IconCatalogEntry<>(
            "rewind-backward-5",
            "TablerIcons.rewind_backward_5()",
            tagIcons::rewind_backward_5));
    icons.add(
        new IconCatalogEntry<>(
            "rewind-backward-50",
            "TablerIcons.rewind_backward_50()",
            tagIcons::rewind_backward_50));
    icons.add(
        new IconCatalogEntry<>(
            "rewind-backward-60",
            "TablerIcons.rewind_backward_60()",
            tagIcons::rewind_backward_60));
    icons.add(
        new IconCatalogEntry<>(
            "rewind-forward-10",
            "TablerIcons.rewind_forward_10()",
            tagIcons::rewind_forward_10));
    icons.add(
        new IconCatalogEntry<>(
            "rewind-forward-15",
            "TablerIcons.rewind_forward_15()",
            tagIcons::rewind_forward_15));
    icons.add(
        new IconCatalogEntry<>(
            "rewind-forward-20",
            "TablerIcons.rewind_forward_20()",
            tagIcons::rewind_forward_20));
    icons.add(
        new IconCatalogEntry<>(
            "rewind-forward-30",
            "TablerIcons.rewind_forward_30()",
            tagIcons::rewind_forward_30));
    icons.add(
        new IconCatalogEntry<>(
            "rewind-forward-40",
            "TablerIcons.rewind_forward_40()",
            tagIcons::rewind_forward_40));
    icons.add(
        new IconCatalogEntry<>(
            "rewind-forward-5",
            "TablerIcons.rewind_forward_5()",
            tagIcons::rewind_forward_5));
    icons.add(
        new IconCatalogEntry<>(
            "rewind-forward-50",
            "TablerIcons.rewind_forward_50()",
            tagIcons::rewind_forward_50));
    icons.add(
        new IconCatalogEntry<>(
            "rewind-forward-60",
            "TablerIcons.rewind_forward_60()",
            tagIcons::rewind_forward_60));
    icons.add(
        new IconCatalogEntry<>(
            "shareplay", "TablerIcons.shareplay()", tagIcons::shareplay));
    icons.add(
        new IconCatalogEntry<>(
            "speakerphone", "TablerIcons.speakerphone()", tagIcons::speakerphone));
    icons.add(
        new IconCatalogEntry<>(
            "subtitles", "TablerIcons.subtitles()", tagIcons::subtitles));
    icons.add(
        new IconCatalogEntry<>(
            "subtitles-ai", "TablerIcons.subtitles_ai()", tagIcons::subtitles_ai));
    icons.add(
        new IconCatalogEntry<>(
            "subtitles-edit", "TablerIcons.subtitles_edit()", tagIcons::subtitles_edit));
    icons.add(
        new IconCatalogEntry<>(
            "subtitles-off", "TablerIcons.subtitles_off()", tagIcons::subtitles_off));
    icons.add(
        new IconCatalogEntry<>(
            "user-screen", "TablerIcons.user_screen()", tagIcons::user_screen));
    icons.add(new IconCatalogEntry<>("video", "TablerIcons.video()", tagIcons::video));
    icons.add(
        new IconCatalogEntry<>(
            "video-minus", "TablerIcons.video_minus()", tagIcons::video_minus));
    icons.add(
        new IconCatalogEntry<>(
            "video-off", "TablerIcons.video_off()", tagIcons::video_off));
    icons.add(
        new IconCatalogEntry<>(
            "video-plus", "TablerIcons.video_plus()", tagIcons::video_plus));
    icons.add(new IconCatalogEntry<>("voice", "TablerIcons.voice()", tagIcons::voice));
    icons.add(
        new IconCatalogEntry<>("voice-2", "TablerIcons.voice_2()", tagIcons::voice_2));
    icons.add(new IconCatalogEntry<>("volume", "TablerIcons.volume()", tagIcons::volume));
    icons.add(
        new IconCatalogEntry<>("volume-2", "TablerIcons.volume_2()", tagIcons::volume_2));
    icons.add(
        new IconCatalogEntry<>("volume-3", "TablerIcons.volume_3()", tagIcons::volume_3));
    icons.add(
        new IconCatalogEntry<>("volume-4", "TablerIcons.volume_4()", tagIcons::volume_4));
    icons.add(
        new IconCatalogEntry<>(
            "volume-off", "TablerIcons.volume_off()", tagIcons::volume_off));
    icons.add(new IconCatalogEntry<>("image", "TablerIcons.photo()", tagIcons::image));
    icons.add(
        new IconCatalogEntry<>(
            "page-first", "TablerIcons.player_skip_back()", tagIcons::page_first));
    icons.add(
        new IconCatalogEntry<>(
            "page-last", "TablerIcons.player_skip_forward()", tagIcons::page_last));
    icons.add(
        new IconCatalogEntry<>(
            "skip-next", "TablerIcons.player_skip_forward()", tagIcons::skip_next));
    icons.add(
        new IconCatalogEntry<>(
            "skip-previous", "TablerIcons.player_skip_back()", tagIcons::skip_previous));
    icons.add(
        new IconCatalogEntry<>(
            "aspect-ratio",
            "TablerIcons.aspect_ratio_filled()",
            tagIcons::aspect_ratio_filled));
    icons.add(
        new IconCatalogEntry<>(
            "camera", "TablerIcons.camera_filled()", tagIcons::camera_filled));
    icons.add(
        new IconCatalogEntry<>(
            "capture", "TablerIcons.capture_filled()", tagIcons::capture_filled));
    icons.add(
        new IconCatalogEntry<>(
            "headphones", "TablerIcons.headphones_filled()", tagIcons::headphones_filled));
    icons.add(
        new IconCatalogEntry<>(
            "headset", "TablerIcons.headset_filled()", tagIcons::headset_filled));
    icons.add(
        new IconCatalogEntry<>(
            "keyframe", "TablerIcons.keyframe_filled()", tagIcons::keyframe_filled));
    icons.add(
        new IconCatalogEntry<>(
            "keyframe-align-center",
            "TablerIcons.keyframe_align_center_filled()",
            tagIcons::keyframe_align_center_filled));
    icons.add(
        new IconCatalogEntry<>(
            "keyframe-align-horizontal",
            "TablerIcons.keyframe_align_horizontal_filled()",
            tagIcons::keyframe_align_horizontal_filled));
    icons.add(
        new IconCatalogEntry<>(
            "keyframe-align-vertical",
            "TablerIcons.keyframe_align_vertical_filled()",
            tagIcons::keyframe_align_vertical_filled));
    icons.add(
        new IconCatalogEntry<>(
            "keyframes", "TablerIcons.keyframes_filled()", tagIcons::keyframes_filled));
    icons.add(
        new IconCatalogEntry<>(
            "microphone", "TablerIcons.microphone_filled()", tagIcons::microphone_filled));
    icons.add(
        new IconCatalogEntry<>(
            "photo", "TablerIcons.photo_filled()", tagIcons::photo_filled));
    icons.add(
        new IconCatalogEntry<>(
            "picture-in-picture",
            "TablerIcons.picture_in_picture_filled()",
            tagIcons::picture_in_picture_filled));
    icons.add(
        new IconCatalogEntry<>(
            "picture-in-picture-top",
            "TablerIcons.picture_in_picture_top_filled()",
            tagIcons::picture_in_picture_top_filled));
    icons.add(
        new IconCatalogEntry<>(
            "player-eject",
            "TablerIcons.player_eject_filled()",
            tagIcons::player_eject_filled));
    icons.add(
        new IconCatalogEntry<>(
            "player-pause",
            "TablerIcons.player_pause_filled()",
            tagIcons::player_pause_filled));
    icons.add(
        new IconCatalogEntry<>(
            "player-play",
            "TablerIcons.player_play_filled()",
            tagIcons::player_play_filled));
    icons.add(
        new IconCatalogEntry<>(
            "player-record",
            "TablerIcons.player_record_filled()",
            tagIcons::player_record_filled));
    icons.add(
        new IconCatalogEntry<>(
            "player-skip-back",
            "TablerIcons.player_skip_back_filled()",
            tagIcons::player_skip_back_filled));
    icons.add(
        new IconCatalogEntry<>(
            "player-skip-forward",
            "TablerIcons.player_skip_forward_filled()",
            tagIcons::player_skip_forward_filled));
    icons.add(
        new IconCatalogEntry<>(
            "player-stop",
            "TablerIcons.player_stop_filled()",
            tagIcons::player_stop_filled));
    icons.add(
        new IconCatalogEntry<>(
            "player-track-next",
            "TablerIcons.player_track_next_filled()",
            tagIcons::player_track_next_filled));
    icons.add(
        new IconCatalogEntry<>(
            "player-track-prev",
            "TablerIcons.player_track_prev_filled()",
            tagIcons::player_track_prev_filled));
    icons.add(
        new IconCatalogEntry<>(
            "playlist", "TablerIcons.playlist_filled()", tagIcons::playlist_filled));
    icons.add(
        new IconCatalogEntry<>(
            "video", "TablerIcons.video_filled()", tagIcons::video_filled));
    icons.add(
        new IconCatalogEntry<>(
            "video-minus",
            "TablerIcons.video_minus_filled()",
            tagIcons::video_minus_filled));
    icons.add(
        new IconCatalogEntry<>(
            "video-plus", "TablerIcons.video_plus_filled()", tagIcons::video_plus_filled));
  }

  public List<IconCatalogEntry<TablerIcon>> icons() {
    return new ArrayList<>(icons);
  }
}
