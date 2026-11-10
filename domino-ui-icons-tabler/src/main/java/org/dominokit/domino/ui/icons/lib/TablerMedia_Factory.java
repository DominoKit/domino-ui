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
    icons.add(
        new IconCatalogEntry<>(
            "album (outline)",
            "TablerIcon.create(TablerMedia.OutlineIcon.ALBUM)",
            tagIcons::album));
    icons.add(
        new IconCatalogEntry<>(
            "album-off (outline)",
            "TablerIcon.create(TablerMedia.OutlineIcon.ALBUM_OFF)",
            tagIcons::album_off));
    icons.add(
        new IconCatalogEntry<>(
            "aspect-ratio (outline)",
            "TablerIcon.create(TablerMedia.OutlineIcon.ASPECT_RATIO)",
            tagIcons::aspect_ratio));
    icons.add(
        new IconCatalogEntry<>(
            "aspect-ratio-off (outline)",
            "TablerIcon.create(TablerMedia.OutlineIcon.ASPECT_RATIO_OFF)",
            tagIcons::aspect_ratio_off));
    icons.add(
        new IconCatalogEntry<>(
            "camera (outline)",
            "TablerIcon.create(TablerMedia.OutlineIcon.CAMERA)",
            tagIcons::camera));
    icons.add(
        new IconCatalogEntry<>(
            "camera-ai (outline)",
            "TablerIcon.create(TablerMedia.OutlineIcon.CAMERA_AI)",
            tagIcons::camera_ai));
    icons.add(
        new IconCatalogEntry<>(
            "camera-bitcoin (outline)",
            "TablerIcon.create(TablerMedia.OutlineIcon.CAMERA_BITCOIN)",
            tagIcons::camera_bitcoin));
    icons.add(
        new IconCatalogEntry<>(
            "camera-bolt (outline)",
            "TablerIcon.create(TablerMedia.OutlineIcon.CAMERA_BOLT)",
            tagIcons::camera_bolt));
    icons.add(
        new IconCatalogEntry<>(
            "camera-cancel (outline)",
            "TablerIcon.create(TablerMedia.OutlineIcon.CAMERA_CANCEL)",
            tagIcons::camera_cancel));
    icons.add(
        new IconCatalogEntry<>(
            "camera-check (outline)",
            "TablerIcon.create(TablerMedia.OutlineIcon.CAMERA_CHECK)",
            tagIcons::camera_check));
    icons.add(
        new IconCatalogEntry<>(
            "camera-code (outline)",
            "TablerIcon.create(TablerMedia.OutlineIcon.CAMERA_CODE)",
            tagIcons::camera_code));
    icons.add(
        new IconCatalogEntry<>(
            "camera-cog (outline)",
            "TablerIcon.create(TablerMedia.OutlineIcon.CAMERA_COG)",
            tagIcons::camera_cog));
    icons.add(
        new IconCatalogEntry<>(
            "camera-dollar (outline)",
            "TablerIcon.create(TablerMedia.OutlineIcon.CAMERA_DOLLAR)",
            tagIcons::camera_dollar));
    icons.add(
        new IconCatalogEntry<>(
            "camera-down (outline)",
            "TablerIcon.create(TablerMedia.OutlineIcon.CAMERA_DOWN)",
            tagIcons::camera_down));
    icons.add(
        new IconCatalogEntry<>(
            "camera-exclamation (outline)",
            "TablerIcon.create(TablerMedia.OutlineIcon.CAMERA_EXCLAMATION)",
            tagIcons::camera_exclamation));
    icons.add(
        new IconCatalogEntry<>(
            "camera-heart (outline)",
            "TablerIcon.create(TablerMedia.OutlineIcon.CAMERA_HEART)",
            tagIcons::camera_heart));
    icons.add(
        new IconCatalogEntry<>(
            "camera-minus (outline)",
            "TablerIcon.create(TablerMedia.OutlineIcon.CAMERA_MINUS)",
            tagIcons::camera_minus));
    icons.add(
        new IconCatalogEntry<>(
            "camera-moon (outline)",
            "TablerIcon.create(TablerMedia.OutlineIcon.CAMERA_MOON)",
            tagIcons::camera_moon));
    icons.add(
        new IconCatalogEntry<>(
            "camera-off (outline)",
            "TablerIcon.create(TablerMedia.OutlineIcon.CAMERA_OFF)",
            tagIcons::camera_off));
    icons.add(
        new IconCatalogEntry<>(
            "camera-pause (outline)",
            "TablerIcon.create(TablerMedia.OutlineIcon.CAMERA_PAUSE)",
            tagIcons::camera_pause));
    icons.add(
        new IconCatalogEntry<>(
            "camera-pin (outline)",
            "TablerIcon.create(TablerMedia.OutlineIcon.CAMERA_PIN)",
            tagIcons::camera_pin));
    icons.add(
        new IconCatalogEntry<>(
            "camera-plus (outline)",
            "TablerIcon.create(TablerMedia.OutlineIcon.CAMERA_PLUS)",
            tagIcons::camera_plus));
    icons.add(
        new IconCatalogEntry<>(
            "camera-question (outline)",
            "TablerIcon.create(TablerMedia.OutlineIcon.CAMERA_QUESTION)",
            tagIcons::camera_question));
    icons.add(
        new IconCatalogEntry<>(
            "camera-search (outline)",
            "TablerIcon.create(TablerMedia.OutlineIcon.CAMERA_SEARCH)",
            tagIcons::camera_search));
    icons.add(
        new IconCatalogEntry<>(
            "camera-share (outline)",
            "TablerIcon.create(TablerMedia.OutlineIcon.CAMERA_SHARE)",
            tagIcons::camera_share));
    icons.add(
        new IconCatalogEntry<>(
            "camera-spark (outline)",
            "TablerIcon.create(TablerMedia.OutlineIcon.CAMERA_SPARK)",
            tagIcons::camera_spark));
    icons.add(
        new IconCatalogEntry<>(
            "camera-star (outline)",
            "TablerIcon.create(TablerMedia.OutlineIcon.CAMERA_STAR)",
            tagIcons::camera_star));
    icons.add(
        new IconCatalogEntry<>(
            "camera-up (outline)",
            "TablerIcon.create(TablerMedia.OutlineIcon.CAMERA_UP)",
            tagIcons::camera_up));
    icons.add(
        new IconCatalogEntry<>(
            "camera-x (outline)",
            "TablerIcon.create(TablerMedia.OutlineIcon.CAMERA_X)",
            tagIcons::camera_x));
    icons.add(
        new IconCatalogEntry<>(
            "capture (outline)",
            "TablerIcon.create(TablerMedia.OutlineIcon.CAPTURE)",
            tagIcons::capture));
    icons.add(
        new IconCatalogEntry<>(
            "capture-off (outline)",
            "TablerIcon.create(TablerMedia.OutlineIcon.CAPTURE_OFF)",
            tagIcons::capture_off));
    icons.add(
        new IconCatalogEntry<>(
            "cast (outline)", "TablerIcon.create(TablerMedia.OutlineIcon.CAST)", tagIcons::cast));
    icons.add(
        new IconCatalogEntry<>(
            "cast-off (outline)",
            "TablerIcon.create(TablerMedia.OutlineIcon.CAST_OFF)",
            tagIcons::cast_off));
    icons.add(
        new IconCatalogEntry<>(
            "circle-pause (outline)",
            "TablerIcon.create(TablerMedia.OutlineIcon.CIRCLE_PAUSE)",
            tagIcons::circle_pause));
    icons.add(
        new IconCatalogEntry<>(
            "circle-play (outline)",
            "TablerIcon.create(TablerMedia.OutlineIcon.CIRCLE_PLAY)",
            tagIcons::circle_play));
    icons.add(
        new IconCatalogEntry<>(
            "circle-stop (outline)",
            "TablerIcon.create(TablerMedia.OutlineIcon.CIRCLE_STOP)",
            tagIcons::circle_stop));
    icons.add(
        new IconCatalogEntry<>(
            "clef (outline)", "TablerIcon.create(TablerMedia.OutlineIcon.CLEF)", tagIcons::clef));
    icons.add(
        new IconCatalogEntry<>(
            "clef-staff (outline)",
            "TablerIcon.create(TablerMedia.OutlineIcon.CLEF_STAFF)",
            tagIcons::clef_staff));
    icons.add(
        new IconCatalogEntry<>(
            "headphones (outline)",
            "TablerIcon.create(TablerMedia.OutlineIcon.HEADPHONES)",
            tagIcons::headphones));
    icons.add(
        new IconCatalogEntry<>(
            "headphones-off (outline)",
            "TablerIcon.create(TablerMedia.OutlineIcon.HEADPHONES_OFF)",
            tagIcons::headphones_off));
    icons.add(
        new IconCatalogEntry<>(
            "headset (outline)",
            "TablerIcon.create(TablerMedia.OutlineIcon.HEADSET)",
            tagIcons::headset));
    icons.add(
        new IconCatalogEntry<>(
            "headset-off (outline)",
            "TablerIcon.create(TablerMedia.OutlineIcon.HEADSET_OFF)",
            tagIcons::headset_off));
    icons.add(
        new IconCatalogEntry<>(
            "keyframe (outline)",
            "TablerIcon.create(TablerMedia.OutlineIcon.KEYFRAME)",
            tagIcons::keyframe));
    icons.add(
        new IconCatalogEntry<>(
            "keyframe-align-center (outline)",
            "TablerIcon.create(TablerMedia.OutlineIcon.KEYFRAME_ALIGN_CENTER)",
            tagIcons::keyframe_align_center));
    icons.add(
        new IconCatalogEntry<>(
            "keyframe-align-horizontal (outline)",
            "TablerIcon.create(TablerMedia.OutlineIcon.KEYFRAME_ALIGN_HORIZONTAL)",
            tagIcons::keyframe_align_horizontal));
    icons.add(
        new IconCatalogEntry<>(
            "keyframe-align-vertical (outline)",
            "TablerIcon.create(TablerMedia.OutlineIcon.KEYFRAME_ALIGN_VERTICAL)",
            tagIcons::keyframe_align_vertical));
    icons.add(
        new IconCatalogEntry<>(
            "keyframes (outline)",
            "TablerIcon.create(TablerMedia.OutlineIcon.KEYFRAMES)",
            tagIcons::keyframes));
    icons.add(
        new IconCatalogEntry<>(
            "maximize (outline)",
            "TablerIcon.create(TablerMedia.OutlineIcon.MAXIMIZE)",
            tagIcons::maximize));
    icons.add(
        new IconCatalogEntry<>(
            "maximize-off (outline)",
            "TablerIcon.create(TablerMedia.OutlineIcon.MAXIMIZE_OFF)",
            tagIcons::maximize_off));
    icons.add(
        new IconCatalogEntry<>(
            "microphone (outline)",
            "TablerIcon.create(TablerMedia.OutlineIcon.MICROPHONE)",
            tagIcons::microphone));
    icons.add(
        new IconCatalogEntry<>(
            "microphone-2 (outline)",
            "TablerIcon.create(TablerMedia.OutlineIcon.MICROPHONE_2)",
            tagIcons::microphone_2));
    icons.add(
        new IconCatalogEntry<>(
            "microphone-2-off (outline)",
            "TablerIcon.create(TablerMedia.OutlineIcon.MICROPHONE_2_OFF)",
            tagIcons::microphone_2_off));
    icons.add(
        new IconCatalogEntry<>(
            "microphone-off (outline)",
            "TablerIcon.create(TablerMedia.OutlineIcon.MICROPHONE_OFF)",
            tagIcons::microphone_off));
    icons.add(
        new IconCatalogEntry<>(
            "minimize (outline)",
            "TablerIcon.create(TablerMedia.OutlineIcon.MINIMIZE)",
            tagIcons::minimize));
    icons.add(
        new IconCatalogEntry<>(
            "movie (outline)",
            "TablerIcon.create(TablerMedia.OutlineIcon.MOVIE)",
            tagIcons::movie));
    icons.add(
        new IconCatalogEntry<>(
            "movie-off (outline)",
            "TablerIcon.create(TablerMedia.OutlineIcon.MOVIE_OFF)",
            tagIcons::movie_off));
    icons.add(
        new IconCatalogEntry<>(
            "music (outline)",
            "TablerIcon.create(TablerMedia.OutlineIcon.MUSIC)",
            tagIcons::music));
    icons.add(
        new IconCatalogEntry<>(
            "music-bolt (outline)",
            "TablerIcon.create(TablerMedia.OutlineIcon.MUSIC_BOLT)",
            tagIcons::music_bolt));
    icons.add(
        new IconCatalogEntry<>(
            "music-cancel (outline)",
            "TablerIcon.create(TablerMedia.OutlineIcon.MUSIC_CANCEL)",
            tagIcons::music_cancel));
    icons.add(
        new IconCatalogEntry<>(
            "music-check (outline)",
            "TablerIcon.create(TablerMedia.OutlineIcon.MUSIC_CHECK)",
            tagIcons::music_check));
    icons.add(
        new IconCatalogEntry<>(
            "music-code (outline)",
            "TablerIcon.create(TablerMedia.OutlineIcon.MUSIC_CODE)",
            tagIcons::music_code));
    icons.add(
        new IconCatalogEntry<>(
            "music-cog (outline)",
            "TablerIcon.create(TablerMedia.OutlineIcon.MUSIC_COG)",
            tagIcons::music_cog));
    icons.add(
        new IconCatalogEntry<>(
            "music-dollar (outline)",
            "TablerIcon.create(TablerMedia.OutlineIcon.MUSIC_DOLLAR)",
            tagIcons::music_dollar));
    icons.add(
        new IconCatalogEntry<>(
            "music-down (outline)",
            "TablerIcon.create(TablerMedia.OutlineIcon.MUSIC_DOWN)",
            tagIcons::music_down));
    icons.add(
        new IconCatalogEntry<>(
            "music-exclamation (outline)",
            "TablerIcon.create(TablerMedia.OutlineIcon.MUSIC_EXCLAMATION)",
            tagIcons::music_exclamation));
    icons.add(
        new IconCatalogEntry<>(
            "music-heart (outline)",
            "TablerIcon.create(TablerMedia.OutlineIcon.MUSIC_HEART)",
            tagIcons::music_heart));
    icons.add(
        new IconCatalogEntry<>(
            "music-minus (outline)",
            "TablerIcon.create(TablerMedia.OutlineIcon.MUSIC_MINUS)",
            tagIcons::music_minus));
    icons.add(
        new IconCatalogEntry<>(
            "music-off (outline)",
            "TablerIcon.create(TablerMedia.OutlineIcon.MUSIC_OFF)",
            tagIcons::music_off));
    icons.add(
        new IconCatalogEntry<>(
            "music-pause (outline)",
            "TablerIcon.create(TablerMedia.OutlineIcon.MUSIC_PAUSE)",
            tagIcons::music_pause));
    icons.add(
        new IconCatalogEntry<>(
            "music-pin (outline)",
            "TablerIcon.create(TablerMedia.OutlineIcon.MUSIC_PIN)",
            tagIcons::music_pin));
    icons.add(
        new IconCatalogEntry<>(
            "music-plus (outline)",
            "TablerIcon.create(TablerMedia.OutlineIcon.MUSIC_PLUS)",
            tagIcons::music_plus));
    icons.add(
        new IconCatalogEntry<>(
            "music-question (outline)",
            "TablerIcon.create(TablerMedia.OutlineIcon.MUSIC_QUESTION)",
            tagIcons::music_question));
    icons.add(
        new IconCatalogEntry<>(
            "music-search (outline)",
            "TablerIcon.create(TablerMedia.OutlineIcon.MUSIC_SEARCH)",
            tagIcons::music_search));
    icons.add(
        new IconCatalogEntry<>(
            "music-share (outline)",
            "TablerIcon.create(TablerMedia.OutlineIcon.MUSIC_SHARE)",
            tagIcons::music_share));
    icons.add(
        new IconCatalogEntry<>(
            "music-star (outline)",
            "TablerIcon.create(TablerMedia.OutlineIcon.MUSIC_STAR)",
            tagIcons::music_star));
    icons.add(
        new IconCatalogEntry<>(
            "music-up (outline)",
            "TablerIcon.create(TablerMedia.OutlineIcon.MUSIC_UP)",
            tagIcons::music_up));
    icons.add(
        new IconCatalogEntry<>(
            "music-x (outline)",
            "TablerIcon.create(TablerMedia.OutlineIcon.MUSIC_X)",
            tagIcons::music_x));
    icons.add(
        new IconCatalogEntry<>(
            "photo (outline)",
            "TablerIcon.create(TablerMedia.OutlineIcon.PHOTO)",
            tagIcons::photo));
    icons.add(
        new IconCatalogEntry<>(
            "photo-ai (outline)",
            "TablerIcon.create(TablerMedia.OutlineIcon.PHOTO_AI)",
            tagIcons::photo_ai));
    icons.add(
        new IconCatalogEntry<>(
            "photo-alt (outline)",
            "TablerIcon.create(TablerMedia.OutlineIcon.PHOTO_ALT)",
            tagIcons::photo_alt));
    icons.add(
        new IconCatalogEntry<>(
            "photo-bolt (outline)",
            "TablerIcon.create(TablerMedia.OutlineIcon.PHOTO_BOLT)",
            tagIcons::photo_bolt));
    icons.add(
        new IconCatalogEntry<>(
            "photo-cancel (outline)",
            "TablerIcon.create(TablerMedia.OutlineIcon.PHOTO_CANCEL)",
            tagIcons::photo_cancel));
    icons.add(
        new IconCatalogEntry<>(
            "photo-check (outline)",
            "TablerIcon.create(TablerMedia.OutlineIcon.PHOTO_CHECK)",
            tagIcons::photo_check));
    icons.add(
        new IconCatalogEntry<>(
            "photo-circle-minus (outline)",
            "TablerIcon.create(TablerMedia.OutlineIcon.PHOTO_CIRCLE_MINUS)",
            tagIcons::photo_circle_minus));
    icons.add(
        new IconCatalogEntry<>(
            "photo-circle-plus (outline)",
            "TablerIcon.create(TablerMedia.OutlineIcon.PHOTO_CIRCLE_PLUS)",
            tagIcons::photo_circle_plus));
    icons.add(
        new IconCatalogEntry<>(
            "photo-code (outline)",
            "TablerIcon.create(TablerMedia.OutlineIcon.PHOTO_CODE)",
            tagIcons::photo_code));
    icons.add(
        new IconCatalogEntry<>(
            "photo-cog (outline)",
            "TablerIcon.create(TablerMedia.OutlineIcon.PHOTO_COG)",
            tagIcons::photo_cog));
    icons.add(
        new IconCatalogEntry<>(
            "photo-dollar (outline)",
            "TablerIcon.create(TablerMedia.OutlineIcon.PHOTO_DOLLAR)",
            tagIcons::photo_dollar));
    icons.add(
        new IconCatalogEntry<>(
            "photo-down (outline)",
            "TablerIcon.create(TablerMedia.OutlineIcon.PHOTO_DOWN)",
            tagIcons::photo_down));
    icons.add(
        new IconCatalogEntry<>(
            "photo-edit (outline)",
            "TablerIcon.create(TablerMedia.OutlineIcon.PHOTO_EDIT)",
            tagIcons::photo_edit));
    icons.add(
        new IconCatalogEntry<>(
            "photo-exclamation (outline)",
            "TablerIcon.create(TablerMedia.OutlineIcon.PHOTO_EXCLAMATION)",
            tagIcons::photo_exclamation));
    icons.add(
        new IconCatalogEntry<>(
            "photo-heart (outline)",
            "TablerIcon.create(TablerMedia.OutlineIcon.PHOTO_HEART)",
            tagIcons::photo_heart));
    icons.add(
        new IconCatalogEntry<>(
            "photo-minus (outline)",
            "TablerIcon.create(TablerMedia.OutlineIcon.PHOTO_MINUS)",
            tagIcons::photo_minus));
    icons.add(
        new IconCatalogEntry<>(
            "photo-off (outline)",
            "TablerIcon.create(TablerMedia.OutlineIcon.PHOTO_OFF)",
            tagIcons::photo_off));
    icons.add(
        new IconCatalogEntry<>(
            "photo-pause (outline)",
            "TablerIcon.create(TablerMedia.OutlineIcon.PHOTO_PAUSE)",
            tagIcons::photo_pause));
    icons.add(
        new IconCatalogEntry<>(
            "photo-pin (outline)",
            "TablerIcon.create(TablerMedia.OutlineIcon.PHOTO_PIN)",
            tagIcons::photo_pin));
    icons.add(
        new IconCatalogEntry<>(
            "photo-plus (outline)",
            "TablerIcon.create(TablerMedia.OutlineIcon.PHOTO_PLUS)",
            tagIcons::photo_plus));
    icons.add(
        new IconCatalogEntry<>(
            "photo-question (outline)",
            "TablerIcon.create(TablerMedia.OutlineIcon.PHOTO_QUESTION)",
            tagIcons::photo_question));
    icons.add(
        new IconCatalogEntry<>(
            "photo-search (outline)",
            "TablerIcon.create(TablerMedia.OutlineIcon.PHOTO_SEARCH)",
            tagIcons::photo_search));
    icons.add(
        new IconCatalogEntry<>(
            "photo-share (outline)",
            "TablerIcon.create(TablerMedia.OutlineIcon.PHOTO_SHARE)",
            tagIcons::photo_share));
  }

  private static void addIcons1() {
    icons.add(
        new IconCatalogEntry<>(
            "photo-shield (outline)",
            "TablerIcon.create(TablerMedia.OutlineIcon.PHOTO_SHIELD)",
            tagIcons::photo_shield));
    icons.add(
        new IconCatalogEntry<>(
            "photo-spark (outline)",
            "TablerIcon.create(TablerMedia.OutlineIcon.PHOTO_SPARK)",
            tagIcons::photo_spark));
    icons.add(
        new IconCatalogEntry<>(
            "photo-star (outline)",
            "TablerIcon.create(TablerMedia.OutlineIcon.PHOTO_STAR)",
            tagIcons::photo_star));
    icons.add(
        new IconCatalogEntry<>(
            "photo-up (outline)",
            "TablerIcon.create(TablerMedia.OutlineIcon.PHOTO_UP)",
            tagIcons::photo_up));
    icons.add(
        new IconCatalogEntry<>(
            "photo-x (outline)",
            "TablerIcon.create(TablerMedia.OutlineIcon.PHOTO_X)",
            tagIcons::photo_x));
    icons.add(
        new IconCatalogEntry<>(
            "picture-in-picture (outline)",
            "TablerIcon.create(TablerMedia.OutlineIcon.PICTURE_IN_PICTURE)",
            tagIcons::picture_in_picture));
    icons.add(
        new IconCatalogEntry<>(
            "picture-in-picture-off (outline)",
            "TablerIcon.create(TablerMedia.OutlineIcon.PICTURE_IN_PICTURE_OFF)",
            tagIcons::picture_in_picture_off));
    icons.add(
        new IconCatalogEntry<>(
            "picture-in-picture-on (outline)",
            "TablerIcon.create(TablerMedia.OutlineIcon.PICTURE_IN_PICTURE_ON)",
            tagIcons::picture_in_picture_on));
    icons.add(
        new IconCatalogEntry<>(
            "picture-in-picture-top (outline)",
            "TablerIcon.create(TablerMedia.OutlineIcon.PICTURE_IN_PICTURE_TOP)",
            tagIcons::picture_in_picture_top));
    icons.add(
        new IconCatalogEntry<>(
            "player-eject (outline)",
            "TablerIcon.create(TablerMedia.OutlineIcon.PLAYER_EJECT)",
            tagIcons::player_eject));
    icons.add(
        new IconCatalogEntry<>(
            "player-pause (outline)",
            "TablerIcon.create(TablerMedia.OutlineIcon.PLAYER_PAUSE)",
            tagIcons::player_pause));
    icons.add(
        new IconCatalogEntry<>(
            "player-play (outline)",
            "TablerIcon.create(TablerMedia.OutlineIcon.PLAYER_PLAY)",
            tagIcons::player_play));
    icons.add(
        new IconCatalogEntry<>(
            "player-record (outline)",
            "TablerIcon.create(TablerMedia.OutlineIcon.PLAYER_RECORD)",
            tagIcons::player_record));
    icons.add(
        new IconCatalogEntry<>(
            "player-skip-back (outline)",
            "TablerIcon.create(TablerMedia.OutlineIcon.PLAYER_SKIP_BACK)",
            tagIcons::player_skip_back));
    icons.add(
        new IconCatalogEntry<>(
            "player-skip-forward (outline)",
            "TablerIcon.create(TablerMedia.OutlineIcon.PLAYER_SKIP_FORWARD)",
            tagIcons::player_skip_forward));
    icons.add(
        new IconCatalogEntry<>(
            "player-stop (outline)",
            "TablerIcon.create(TablerMedia.OutlineIcon.PLAYER_STOP)",
            tagIcons::player_stop));
    icons.add(
        new IconCatalogEntry<>(
            "player-track-next (outline)",
            "TablerIcon.create(TablerMedia.OutlineIcon.PLAYER_TRACK_NEXT)",
            tagIcons::player_track_next));
    icons.add(
        new IconCatalogEntry<>(
            "player-track-prev (outline)",
            "TablerIcon.create(TablerMedia.OutlineIcon.PLAYER_TRACK_PREV)",
            tagIcons::player_track_prev));
    icons.add(
        new IconCatalogEntry<>(
            "playlist (outline)",
            "TablerIcon.create(TablerMedia.OutlineIcon.PLAYLIST)",
            tagIcons::playlist));
    icons.add(
        new IconCatalogEntry<>(
            "playlist-off (outline)",
            "TablerIcon.create(TablerMedia.OutlineIcon.PLAYLIST_OFF)",
            tagIcons::playlist_off));
    icons.add(
        new IconCatalogEntry<>(
            "playlist-x (outline)",
            "TablerIcon.create(TablerMedia.OutlineIcon.PLAYLIST_X)",
            tagIcons::playlist_x));
    icons.add(
        new IconCatalogEntry<>(
            "radio (outline)",
            "TablerIcon.create(TablerMedia.OutlineIcon.RADIO)",
            tagIcons::radio));
    icons.add(
        new IconCatalogEntry<>(
            "radio-off (outline)",
            "TablerIcon.create(TablerMedia.OutlineIcon.RADIO_OFF)",
            tagIcons::radio_off));
    icons.add(
        new IconCatalogEntry<>(
            "repeat (outline)",
            "TablerIcon.create(TablerMedia.OutlineIcon.REPEAT)",
            tagIcons::repeat));
    icons.add(
        new IconCatalogEntry<>(
            "repeat-off (outline)",
            "TablerIcon.create(TablerMedia.OutlineIcon.REPEAT_OFF)",
            tagIcons::repeat_off));
    icons.add(
        new IconCatalogEntry<>(
            "repeat-once (outline)",
            "TablerIcon.create(TablerMedia.OutlineIcon.REPEAT_ONCE)",
            tagIcons::repeat_once));
    icons.add(
        new IconCatalogEntry<>(
            "rewind-backward-10 (outline)",
            "TablerIcon.create(TablerMedia.OutlineIcon.REWIND_BACKWARD_10)",
            tagIcons::rewind_backward_10));
    icons.add(
        new IconCatalogEntry<>(
            "rewind-backward-15 (outline)",
            "TablerIcon.create(TablerMedia.OutlineIcon.REWIND_BACKWARD_15)",
            tagIcons::rewind_backward_15));
    icons.add(
        new IconCatalogEntry<>(
            "rewind-backward-20 (outline)",
            "TablerIcon.create(TablerMedia.OutlineIcon.REWIND_BACKWARD_20)",
            tagIcons::rewind_backward_20));
    icons.add(
        new IconCatalogEntry<>(
            "rewind-backward-30 (outline)",
            "TablerIcon.create(TablerMedia.OutlineIcon.REWIND_BACKWARD_30)",
            tagIcons::rewind_backward_30));
    icons.add(
        new IconCatalogEntry<>(
            "rewind-backward-40 (outline)",
            "TablerIcon.create(TablerMedia.OutlineIcon.REWIND_BACKWARD_40)",
            tagIcons::rewind_backward_40));
    icons.add(
        new IconCatalogEntry<>(
            "rewind-backward-5 (outline)",
            "TablerIcon.create(TablerMedia.OutlineIcon.REWIND_BACKWARD_5)",
            tagIcons::rewind_backward_5));
    icons.add(
        new IconCatalogEntry<>(
            "rewind-backward-50 (outline)",
            "TablerIcon.create(TablerMedia.OutlineIcon.REWIND_BACKWARD_50)",
            tagIcons::rewind_backward_50));
    icons.add(
        new IconCatalogEntry<>(
            "rewind-backward-60 (outline)",
            "TablerIcon.create(TablerMedia.OutlineIcon.REWIND_BACKWARD_60)",
            tagIcons::rewind_backward_60));
    icons.add(
        new IconCatalogEntry<>(
            "rewind-forward-10 (outline)",
            "TablerIcon.create(TablerMedia.OutlineIcon.REWIND_FORWARD_10)",
            tagIcons::rewind_forward_10));
    icons.add(
        new IconCatalogEntry<>(
            "rewind-forward-15 (outline)",
            "TablerIcon.create(TablerMedia.OutlineIcon.REWIND_FORWARD_15)",
            tagIcons::rewind_forward_15));
    icons.add(
        new IconCatalogEntry<>(
            "rewind-forward-20 (outline)",
            "TablerIcon.create(TablerMedia.OutlineIcon.REWIND_FORWARD_20)",
            tagIcons::rewind_forward_20));
    icons.add(
        new IconCatalogEntry<>(
            "rewind-forward-30 (outline)",
            "TablerIcon.create(TablerMedia.OutlineIcon.REWIND_FORWARD_30)",
            tagIcons::rewind_forward_30));
    icons.add(
        new IconCatalogEntry<>(
            "rewind-forward-40 (outline)",
            "TablerIcon.create(TablerMedia.OutlineIcon.REWIND_FORWARD_40)",
            tagIcons::rewind_forward_40));
    icons.add(
        new IconCatalogEntry<>(
            "rewind-forward-5 (outline)",
            "TablerIcon.create(TablerMedia.OutlineIcon.REWIND_FORWARD_5)",
            tagIcons::rewind_forward_5));
    icons.add(
        new IconCatalogEntry<>(
            "rewind-forward-50 (outline)",
            "TablerIcon.create(TablerMedia.OutlineIcon.REWIND_FORWARD_50)",
            tagIcons::rewind_forward_50));
    icons.add(
        new IconCatalogEntry<>(
            "rewind-forward-60 (outline)",
            "TablerIcon.create(TablerMedia.OutlineIcon.REWIND_FORWARD_60)",
            tagIcons::rewind_forward_60));
    icons.add(
        new IconCatalogEntry<>(
            "shareplay (outline)",
            "TablerIcon.create(TablerMedia.OutlineIcon.SHAREPLAY)",
            tagIcons::shareplay));
    icons.add(
        new IconCatalogEntry<>(
            "speakerphone (outline)",
            "TablerIcon.create(TablerMedia.OutlineIcon.SPEAKERPHONE)",
            tagIcons::speakerphone));
    icons.add(
        new IconCatalogEntry<>(
            "subtitles (outline)",
            "TablerIcon.create(TablerMedia.OutlineIcon.SUBTITLES)",
            tagIcons::subtitles));
    icons.add(
        new IconCatalogEntry<>(
            "subtitles-ai (outline)",
            "TablerIcon.create(TablerMedia.OutlineIcon.SUBTITLES_AI)",
            tagIcons::subtitles_ai));
    icons.add(
        new IconCatalogEntry<>(
            "subtitles-edit (outline)",
            "TablerIcon.create(TablerMedia.OutlineIcon.SUBTITLES_EDIT)",
            tagIcons::subtitles_edit));
    icons.add(
        new IconCatalogEntry<>(
            "subtitles-off (outline)",
            "TablerIcon.create(TablerMedia.OutlineIcon.SUBTITLES_OFF)",
            tagIcons::subtitles_off));
    icons.add(
        new IconCatalogEntry<>(
            "user-screen (outline)",
            "TablerIcon.create(TablerMedia.OutlineIcon.USER_SCREEN)",
            tagIcons::user_screen));
    icons.add(
        new IconCatalogEntry<>(
            "video (outline)",
            "TablerIcon.create(TablerMedia.OutlineIcon.VIDEO)",
            tagIcons::video));
    icons.add(
        new IconCatalogEntry<>(
            "video-minus (outline)",
            "TablerIcon.create(TablerMedia.OutlineIcon.VIDEO_MINUS)",
            tagIcons::video_minus));
    icons.add(
        new IconCatalogEntry<>(
            "video-off (outline)",
            "TablerIcon.create(TablerMedia.OutlineIcon.VIDEO_OFF)",
            tagIcons::video_off));
    icons.add(
        new IconCatalogEntry<>(
            "video-plus (outline)",
            "TablerIcon.create(TablerMedia.OutlineIcon.VIDEO_PLUS)",
            tagIcons::video_plus));
    icons.add(
        new IconCatalogEntry<>(
            "voice (outline)",
            "TablerIcon.create(TablerMedia.OutlineIcon.VOICE)",
            tagIcons::voice));
    icons.add(
        new IconCatalogEntry<>(
            "voice-2 (outline)",
            "TablerIcon.create(TablerMedia.OutlineIcon.VOICE_2)",
            tagIcons::voice_2));
    icons.add(
        new IconCatalogEntry<>(
            "volume (outline)",
            "TablerIcon.create(TablerMedia.OutlineIcon.VOLUME)",
            tagIcons::volume));
    icons.add(
        new IconCatalogEntry<>(
            "volume-2 (outline)",
            "TablerIcon.create(TablerMedia.OutlineIcon.VOLUME_2)",
            tagIcons::volume_2));
    icons.add(
        new IconCatalogEntry<>(
            "volume-3 (outline)",
            "TablerIcon.create(TablerMedia.OutlineIcon.VOLUME_3)",
            tagIcons::volume_3));
    icons.add(
        new IconCatalogEntry<>(
            "volume-4 (outline)",
            "TablerIcon.create(TablerMedia.OutlineIcon.VOLUME_4)",
            tagIcons::volume_4));
    icons.add(
        new IconCatalogEntry<>(
            "volume-off (outline)",
            "TablerIcon.create(TablerMedia.OutlineIcon.VOLUME_OFF)",
            tagIcons::volume_off));
    icons.add(
        new IconCatalogEntry<>(
            "image (outline)",
            "TablerIcon.create(TablerMedia.OutlineIcon.PHOTO)",
            tagIcons::image));
    icons.add(
        new IconCatalogEntry<>(
            "page-first (outline)",
            "TablerIcon.create(TablerMedia.OutlineIcon.PLAYER_SKIP_BACK)",
            tagIcons::page_first));
    icons.add(
        new IconCatalogEntry<>(
            "page-last (outline)",
            "TablerIcon.create(TablerMedia.OutlineIcon.PLAYER_SKIP_FORWARD)",
            tagIcons::page_last));
    icons.add(
        new IconCatalogEntry<>(
            "skip-next (outline)",
            "TablerIcon.create(TablerMedia.OutlineIcon.PLAYER_SKIP_FORWARD)",
            tagIcons::skip_next));
    icons.add(
        new IconCatalogEntry<>(
            "skip-previous (outline)",
            "TablerIcon.create(TablerMedia.OutlineIcon.PLAYER_SKIP_BACK)",
            tagIcons::skip_previous));
    icons.add(
        new IconCatalogEntry<>(
            "aspect-ratio (filled)",
            "TablerIcon.create(TablerMedia.FilledIcon.ASPECT_RATIO)",
            tagIcons::aspect_ratio_filled));
    icons.add(
        new IconCatalogEntry<>(
            "camera (filled)",
            "TablerIcon.create(TablerMedia.FilledIcon.CAMERA)",
            tagIcons::camera_filled));
    icons.add(
        new IconCatalogEntry<>(
            "capture (filled)",
            "TablerIcon.create(TablerMedia.FilledIcon.CAPTURE)",
            tagIcons::capture_filled));
    icons.add(
        new IconCatalogEntry<>(
            "headphones (filled)",
            "TablerIcon.create(TablerMedia.FilledIcon.HEADPHONES)",
            tagIcons::headphones_filled));
    icons.add(
        new IconCatalogEntry<>(
            "headset (filled)",
            "TablerIcon.create(TablerMedia.FilledIcon.HEADSET)",
            tagIcons::headset_filled));
    icons.add(
        new IconCatalogEntry<>(
            "keyframe (filled)",
            "TablerIcon.create(TablerMedia.FilledIcon.KEYFRAME)",
            tagIcons::keyframe_filled));
    icons.add(
        new IconCatalogEntry<>(
            "keyframe-align-center (filled)",
            "TablerIcon.create(TablerMedia.FilledIcon.KEYFRAME_ALIGN_CENTER)",
            tagIcons::keyframe_align_center_filled));
    icons.add(
        new IconCatalogEntry<>(
            "keyframe-align-horizontal (filled)",
            "TablerIcon.create(TablerMedia.FilledIcon.KEYFRAME_ALIGN_HORIZONTAL)",
            tagIcons::keyframe_align_horizontal_filled));
    icons.add(
        new IconCatalogEntry<>(
            "keyframe-align-vertical (filled)",
            "TablerIcon.create(TablerMedia.FilledIcon.KEYFRAME_ALIGN_VERTICAL)",
            tagIcons::keyframe_align_vertical_filled));
    icons.add(
        new IconCatalogEntry<>(
            "keyframes (filled)",
            "TablerIcon.create(TablerMedia.FilledIcon.KEYFRAMES)",
            tagIcons::keyframes_filled));
    icons.add(
        new IconCatalogEntry<>(
            "microphone (filled)",
            "TablerIcon.create(TablerMedia.FilledIcon.MICROPHONE)",
            tagIcons::microphone_filled));
    icons.add(
        new IconCatalogEntry<>(
            "photo (filled)",
            "TablerIcon.create(TablerMedia.FilledIcon.PHOTO)",
            tagIcons::photo_filled));
    icons.add(
        new IconCatalogEntry<>(
            "picture-in-picture (filled)",
            "TablerIcon.create(TablerMedia.FilledIcon.PICTURE_IN_PICTURE)",
            tagIcons::picture_in_picture_filled));
    icons.add(
        new IconCatalogEntry<>(
            "picture-in-picture-top (filled)",
            "TablerIcon.create(TablerMedia.FilledIcon.PICTURE_IN_PICTURE_TOP)",
            tagIcons::picture_in_picture_top_filled));
    icons.add(
        new IconCatalogEntry<>(
            "player-eject (filled)",
            "TablerIcon.create(TablerMedia.FilledIcon.PLAYER_EJECT)",
            tagIcons::player_eject_filled));
    icons.add(
        new IconCatalogEntry<>(
            "player-pause (filled)",
            "TablerIcon.create(TablerMedia.FilledIcon.PLAYER_PAUSE)",
            tagIcons::player_pause_filled));
    icons.add(
        new IconCatalogEntry<>(
            "player-play (filled)",
            "TablerIcon.create(TablerMedia.FilledIcon.PLAYER_PLAY)",
            tagIcons::player_play_filled));
    icons.add(
        new IconCatalogEntry<>(
            "player-record (filled)",
            "TablerIcon.create(TablerMedia.FilledIcon.PLAYER_RECORD)",
            tagIcons::player_record_filled));
    icons.add(
        new IconCatalogEntry<>(
            "player-skip-back (filled)",
            "TablerIcon.create(TablerMedia.FilledIcon.PLAYER_SKIP_BACK)",
            tagIcons::player_skip_back_filled));
    icons.add(
        new IconCatalogEntry<>(
            "player-skip-forward (filled)",
            "TablerIcon.create(TablerMedia.FilledIcon.PLAYER_SKIP_FORWARD)",
            tagIcons::player_skip_forward_filled));
    icons.add(
        new IconCatalogEntry<>(
            "player-stop (filled)",
            "TablerIcon.create(TablerMedia.FilledIcon.PLAYER_STOP)",
            tagIcons::player_stop_filled));
    icons.add(
        new IconCatalogEntry<>(
            "player-track-next (filled)",
            "TablerIcon.create(TablerMedia.FilledIcon.PLAYER_TRACK_NEXT)",
            tagIcons::player_track_next_filled));
    icons.add(
        new IconCatalogEntry<>(
            "player-track-prev (filled)",
            "TablerIcon.create(TablerMedia.FilledIcon.PLAYER_TRACK_PREV)",
            tagIcons::player_track_prev_filled));
    icons.add(
        new IconCatalogEntry<>(
            "playlist (filled)",
            "TablerIcon.create(TablerMedia.FilledIcon.PLAYLIST)",
            tagIcons::playlist_filled));
    icons.add(
        new IconCatalogEntry<>(
            "video (filled)",
            "TablerIcon.create(TablerMedia.FilledIcon.VIDEO)",
            tagIcons::video_filled));
    icons.add(
        new IconCatalogEntry<>(
            "video-minus (filled)",
            "TablerIcon.create(TablerMedia.FilledIcon.VIDEO_MINUS)",
            tagIcons::video_minus_filled));
    icons.add(
        new IconCatalogEntry<>(
            "video-plus (filled)",
            "TablerIcon.create(TablerMedia.FilledIcon.VIDEO_PLUS)",
            tagIcons::video_plus_filled));
  }

  public List<IconCatalogEntry<TablerIcon>> icons() {
    return new ArrayList<>(icons);
  }
}
