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

/** Lucide security catalog category. */
public interface LucideSecurity {
  enum Icon implements LucideIconDefinition {
    BOMB(
        "bomb",
        "<circle cx=\"11\" cy=\"13\" r=\"9\" />\n  <path d=\"M14.35 4.65 16.3 2.7a2.41 2.41 0 0 1 3.4 0l1.6 1.6a2.4 2.4 0 0 1 0 3.4l-1.95 1.95\" />\n  <path d=\"m22 2-1.5 1.5\" />"),
    BOOK_KEY(
        "book-key",
        "<path d=\"M13 2H6.5A2.5 2.5 0 0 0 4 4.5v15\" />\n  <path d=\"M17 2v6\" />\n  <path d=\"M17 4h2\" />\n  <path d=\"M20 15.2V21a1 1 0 0 1-1 1H6.5a1 1 0 0 1 0-5H20\" />\n  <circle cx=\"17\" cy=\"10\" r=\"2\" />"),
    BOOK_LOCK(
        "book-lock",
        "<path d=\"M18 6V4a2 2 0 1 0-4 0v2\" />\n  <path d=\"M20 15v6a1 1 0 0 1-1 1H6.5a1 1 0 0 1 0-5H20\" />\n  <path d=\"M4 19.5v-15A2.5 2.5 0 0 1 6.5 2H10\" />\n  <rect x=\"12\" y=\"6\" width=\"8\" height=\"5\" rx=\"1\" />"),
    BRICK_WALL_FIRE(
        "brick-wall-fire",
        "<path d=\"M16 3v2.107\" />\n  <path d=\"M17 9c1 3 2.5 3.5 3.5 4.5A5 5 0 0 1 22 17a5 5 0 0 1-10 0c0-.3 0-.6.1-.9a2 2 0 1 0 3.3-2C13 11.5 16 9 17 9\" />\n  <path d=\"M21 8.274V5a2 2 0 0 0-2-2H5a2 2 0 0 0-2 2v14a2 2 0 0 0 2 2h3.938\" />\n  <path d=\"M3 15h5.253\" />\n  <path d=\"M3 9h8.228\" />\n  <path d=\"M8 15v6\" />\n  <path d=\"M8 3v6\" />"),
    BRICK_WALL_SHIELD(
        "brick-wall-shield",
        "<path d=\"M12 9v1.258\" />\n  <path d=\"M16 3v5.46\" />\n  <path d=\"M21 9.118V5a2 2 0 0 0-2-2H5a2 2 0 0 0-2 2v14a2 2 0 0 0 2 2h5.75\" />\n  <path d=\"M22 17.5c0 2.499-1.75 3.749-3.83 4.474a.5.5 0 0 1-.335-.005c-2.085-.72-3.835-1.97-3.835-4.47V14a.5.5 0 0 1 .5-.499c1 0 2.25-.6 3.12-1.36a.6.6 0 0 1 .76-.001c.875.765 2.12 1.36 3.12 1.36a.5.5 0 0 1 .5.5z\" />\n  <path d=\"M3 15h7\" />\n  <path d=\"M3 9h12.142\" />\n  <path d=\"M8 15v6\" />\n  <path d=\"M8 3v6\" />"),
    CCTV(
        "cctv",
        "<path d=\"M16.75 12h3.632a1 1 0 0 1 .894 1.447l-2.034 4.069a1 1 0 0 1-1.708.134l-2.124-2.97\" />\n  <path d=\"M17.106 9.053a1 1 0 0 1 .447 1.341l-3.106 6.211a1 1 0 0 1-1.342.447L3.61 12.3a2.92 2.92 0 0 1-1.3-3.91L3.69 5.6a2.92 2.92 0 0 1 3.92-1.3z\" />\n  <path d=\"M2 19h3.76a2 2 0 0 0 1.8-1.1L9 15\" />\n  <path d=\"M2 21v-4\" />\n  <path d=\"M7 9h.01\" />"),
    CCTV_OFF(
        "cctv-off",
        "<path d=\"m12.309 6.652 4.797 2.401a1 1 0 0 1 .447 1.341l-.501 1.001.605.605h2.725a1 1 0 0 1 .894 1.447l-.724 1.448\" />\n  <path d=\"m15.166 15.166-.719 1.439a1 1 0 0 1-1.342.447L3.61 12.3a2.92 2.92 0 0 1-1.3-3.91L3.69 5.6a2.9 2.9 0 0 1 .873-1.037\" />\n  <path d=\"M2 19h3.76a2 2 0 0 0 1.8-1.1l1.441-2.902\" />\n  <path d=\"m2 2 20 20\" />\n  <path d=\"M2 21v-4\" />\n  <path d=\"M7 9h.01\" />"),
    CERTIFICATE(
        "certificate",
        "<path d=\"M12 10H6\" />\n  <path d=\"m20.69 15.479 1.29 4.88a.5.5 0 01-.698.591l-1.843-.849a1 1 0 00-.879.001l-1.846.85a.5.5 0 01-.692-.593l1.29-4.88\" />\n  <path d=\"M22 6.675V6a2 2 0 00-2-2H4a2 2 0 00-2 2v12a2 2 0 002 2h8\" />\n  <path d=\"M6 14h4\" />\n  <circle cx=\"19\" cy=\"13\" r=\"3\" />"),
    COLUMNS_4(
        "columns-4",
        "<rect width=\"18\" height=\"18\" x=\"3\" y=\"3\" rx=\"2\" />\n  <path d=\"M7.5 3v18\" />\n  <path d=\"M12 3v18\" />\n  <path d=\"M16.5 3v18\" />"),
    DOOR_CLOSED(
        "door-closed",
        "<path d=\"M19 21V5a2 2 0 00-2-2H7a2 2 0 00-2 2v16\" />\n  <path d=\"M2 21h20\" />\n  <path d=\"M9 12h.01\" />"),
    DOOR_CLOSED_COG(
        "door-closed-cog",
        "<path d=\"m14.305 19.53.923-.382\" />\n  <path d=\"m15.229 16.852-.924-.383\" />\n  <path d=\"m16.852 15.228-.383-.923\" />\n  <path d=\"m16.852 20.773-.383.924\" />\n  <path d=\"M19 10.35V5a2 2 0 00-2-2H7a2 2 0 00-2 2v16\" />\n  <path d=\"m19.148 15.228.383-.923\" />\n  <path d=\"m19.53 21.697-.382-.924\" />\n  <path d=\"M2 21h8.58\" />\n  <path d=\"m20.773 16.852.922-.383\" />\n  <path d=\"m20.773 19.148.922.383\" />\n  <path d=\"M9 12h.01\" />\n  <circle cx=\"18\" cy=\"18\" r=\"3\" />"),
    DOOR_CLOSED_LOCKED(
        "door-closed-locked",
        "<path d=\"M19 8V5a2 2 0 00-2-2H7a2 2 0 00-2 2v16\" />\n  <path d=\"M2 21h8\" />\n  <path d=\"M20 16v-2a2 2 0 00-4 0v2\" />\n  <path d=\"M9 12h.01\" />\n  <rect x=\"14\" y=\"16\" width=\"8\" height=\"5\" rx=\"1\" />"),
    DOOR_OPEN(
        "door-open",
        "<path d=\"M10 21H2\" />\n  <path d=\"M10 3H7a2 2 0 00-2 2v16\" />\n  <path d=\"M14 12h.01\" />\n  <path d=\"M19 21V5a2 2 0 00-1.675-1.974l-6.163-1.013A1 1 0 0010 3v18a1 1 0 001.124.992z\" />\n  <path d=\"M22 21h-3\" />"),
    EARTH_LOCK(
        "earth-lock",
        "<path d=\"M7 3.34V5a3 3 0 0 0 3 3\" />\n  <path d=\"M11 21.95V18a2 2 0 0 0-2-2 2 2 0 0 1-2-2v-1a2 2 0 0 0-2-2H2.05\" />\n  <path d=\"M21.54 15H17a2 2 0 0 0-2 2v4.54\" />\n  <path d=\"M12 2a10 10 0 1 0 9.54 13\" />\n  <path d=\"M20 6V4a2 2 0 1 0-4 0v2\" />\n  <rect width=\"8\" height=\"5\" x=\"14\" y=\"6\" rx=\"1\" />"),
    EYE(
        "eye",
        "<path d=\"M2.062 12.348a1 1 0 0 1 0-.696 10.75 10.75 0 0 1 19.876 0 1 1 0 0 1 0 .696 10.75 10.75 0 0 1-19.876 0\" />\n  <circle cx=\"12\" cy=\"12\" r=\"3\" />"),
    EYE_CLOSED(
        "eye-closed",
        "<path d=\"m15 18-.722-3.25\" />\n  <path d=\"M2 8a10.645 10.645 0 0 0 20 0\" />\n  <path d=\"m20 15-1.726-2.05\" />\n  <path d=\"m4 15 1.726-2.05\" />\n  <path d=\"m9 18 .722-3.25\" />"),
    EYE_DASHED(
        "eye-dashed",
        "<path d=\"M13.054 18.946a11 11 0 0 1-2.11 0\" />\n  <path d=\"M13.054 5.054a11 11 0 0 0-2.11-.001\" />\n  <path d=\"M17.072 6.274a11 11 0 0 1 1.753 1.173\" />\n  <path d=\"M18.825 16.552a11 11 0 0 1-1.753 1.174\" />\n  <path d=\"M2.514 13.303a11 11 0 0 1-.452-.954 1 1 0 0 1 0-.697 11 11 0 0 1 .45-.955\" />\n  <path d=\"M21.485 10.697a11 11 0 0 1 .453.955 1 1 0 0 1 0 .697 11 11 0 0 1-.453.954\" />\n  <path d=\"M5.173 7.448a11 11 0 0 1 1.753-1.174\" />\n  <path d=\"M6.926 17.726a11 11 0 0 1-1.753-1.174\" />\n  <circle cx=\"12\" cy=\"12\" r=\"3\" />"),
    EYE_OFF(
        "eye-off",
        "<path d=\"M10.733 5.076a10.744 10.744 0 0 1 11.205 6.575 1 1 0 0 1 0 .696 10.747 10.747 0 0 1-1.444 2.49\" />\n  <path d=\"M14.084 14.158a3 3 0 0 1-4.242-4.242\" />\n  <path d=\"M17.479 17.499a10.75 10.75 0 0 1-15.417-5.151 1 1 0 0 1 0-.696 10.75 10.75 0 0 1 4.446-5.143\" />\n  <path d=\"m2 2 20 20\" />"),
    FILE_KEY(
        "file-key",
        "<path d=\"M14 2v5a1 1 0 0 0 1 1h5\" />\n  <path d=\"M4 12v6\" />\n  <path d=\"M4 14h2\" />\n  <path d=\"M9.65 22H18a2 2 0 0 0 2-2V8a2.4 2.4 0 0 0-.706-1.706l-3.588-3.588A2.4 2.4 0 0 0 14 2H6a2 2 0 0 0-2 2v4\" />\n  <circle cx=\"4\" cy=\"20\" r=\"2\" />"),
    FILE_LOCK(
        "file-lock",
        "<path d=\"M4 9.8V4a2 2 0 0 1 2-2h8a2.4 2.4 0 0 1 1.706.706l3.588 3.588A2.4 2.4 0 0 1 20 8v12a2 2 0 0 1-2 2h-3\" />\n  <path d=\"M14 2v5a1 1 0 0 0 1 1h5\" />\n  <path d=\"M9 17v-2a2 2 0 0 0-4 0v2\" />\n  <rect width=\"8\" height=\"5\" x=\"3\" y=\"17\" rx=\"1\" />"),
    FINGERPRINT_PATTERN(
        "fingerprint-pattern",
        "<path d=\"M12 10a2 2 0 0 0-2 2c0 1.02-.1 2.51-.26 4\" />\n  <path d=\"M14 13.12c0 2.38 0 6.38-1 8.88\" />\n  <path d=\"M17.29 21.02c.12-.6.43-2.3.5-3.02\" />\n  <path d=\"M2 12a10 10 0 0 1 18-6\" />\n  <path d=\"M2 16h.01\" />\n  <path d=\"M21.8 16c.2-2 .131-5.354 0-6\" />\n  <path d=\"M5 19.5C5.5 18 6 15 6 12a6 6 0 0 1 .34-2\" />\n  <path d=\"M8.65 22c.21-.66.45-1.32.57-2\" />\n  <path d=\"M9 6.8a6 6 0 0 1 9 5.2v2\" />"),
    FOLDER_KEY(
        "folder-key",
        "<path d=\"M13 20H4a2 2 0 0 1-2-2V5a2 2 0 0 1 2-2h3.9a2 2 0 0 1 1.69.9l.81 1.2a2 2 0 0 0 1.67.9H20a2 2 0 0 1 2 2v1.36\" />\n  <path d=\"M19 12v6\" />\n  <path d=\"M19 14h2\" />\n  <circle cx=\"19\" cy=\"20\" r=\"2\" />"),
    FOLDER_LOCK(
        "folder-lock",
        "<rect width=\"8\" height=\"5\" x=\"14\" y=\"17\" rx=\"1\" />\n  <path d=\"M10 20H4a2 2 0 0 1-2-2V5a2 2 0 0 1 2-2h3.9a2 2 0 0 1 1.69.9l.81 1.2a2 2 0 0 0 1.67.9H20a2 2 0 0 1 2 2v2.5\" />\n  <path d=\"M20 17v-2a2 2 0 1 0-4 0v2\" />"),
    FOLDER_USER(
        "folder-user",
        "<path d=\"M10.254 20H4a2 2 0 0 1-2-2V5a2 2 0 0 1 2-2h3.9a2 2 0 0 1 1.69.9l.81 1.2a2 2 0 0 0 1.67.9H20a2 2 0 0 1 2 2V9.255\" />\n  <path d=\"M22 22a4 4 0 0 0-8 0\" />\n  <circle cx=\"18\" cy=\"15\" r=\"3\" />"),
    FOLDER_USERS(
        "folder-users",
        "<path d=\"M5.254 20H4a2 2 0 0 1-2-2V5a2 2 0 0 1 2-2h3.9a2 2 0 0 1 1.69.9l.81 1.2a2 2 0 0 0 1.67.9H20a2 2 0 0 1 2 2V9.255\" />\n  <circle cx=\"13\" cy=\"15\" r=\"3\" />\n  <path d=\"M17 22a4 4 0 0 0-8 0\" />\n  <path d=\"M22 22A4 4 0 0 0 20.24 18.686 1 1 0 0 1 20.1 17.143 3 3 0 0 0 19.5 12.402\" />"),
    GERM(
        "germ",
        "<path d=\"m11 2 .925 1.848\" />\n  <path d=\"M13 15h.01\" />\n  <path d=\"m16 21-1-2.472\" />\n  <path d=\"m19 2-1 1.804\" />\n  <path d=\"m2 19 2.746-1.373\" />\n  <path d=\"m22 16-2.474-2.13\" />\n  <path d=\"m22 5-1.804 1\" />\n  <path d=\"m3 10 2 2\" />\n  <path d=\"M9 16h.01\" />\n  <path d=\"M9 20v2\" />\n  <path d=\"M9.33 7.035c-.51 1.478-1.786 2.93-3.09 3.794A5 5 0 009 20a12.1 12.1 0 0011.902-9.916A6 6 0 009.33 7.035\" />\n  <circle cx=\"15\" cy=\"9\" r=\"2\" />"),
    GERM_OFF(
        "germ-off",
        "<path d=\"m11 2 .925 1.848\" />\n  <path d=\"M13 15h.01\" />\n  <path d=\"M13.424 7.768a2 2 0 112.808 2.808\" />\n  <path d=\"m16 21-1-2.472\" />\n  <path d=\"M16.988 16.988A12 12 0 019 20a5 5 0 01-2.759-9.171 8.8 8.8 0 002.307-2.28\" />\n  <path d=\"m19 2-1 1.804\" />\n  <path d=\"m2 19 2.746-1.373\" />\n  <path d=\"m2 2 20 20\" />\n  <path d=\"m22 16-2.474-2.13a12 12 0 001.376-3.786 6 6 0 00-10.313-5.151\" />\n  <path d=\"m22 5-1.804 1\" />\n  <path d=\"m3 10 2 2\" />\n  <path d=\"M9 16h.01\" />\n  <path d=\"M9 20v2\" />"),
    GLOBE_LOCK(
        "globe-lock",
        "<path d=\"M15.686 15A14.5 14.5 0 0 1 12 22a14.5 14.5 0 0 1 0-20 10 10 0 1 0 9.542 13\" />\n  <path d=\"M2 12h8.5\" />\n  <path d=\"M20 6V4a2 2 0 1 0-4 0v2\" />\n  <rect width=\"8\" height=\"5\" x=\"14\" y=\"6\" rx=\"1\" />"),
    HANDSHAKE(
        "handshake",
        "<path d=\"m11 17 2 2a1 1 0 1 0 3-3\" />\n  <path d=\"m14 14 2.5 2.5a1 1 0 1 0 3-3l-3.88-3.88a3 3 0 0 0-4.24 0l-.88.88a1 1 0 1 1-3-3l2.81-2.81a5.79 5.79 0 0 1 7.06-.87l.47.28a2 2 0 0 0 1.42.25L21 4\" />\n  <path d=\"m21 3 1 11h-2\" />\n  <path d=\"M3 3 2 14l6.5 6.5a1 1 0 1 0 3-3\" />\n  <path d=\"M3 4h8\" />"),
    HAT_GLASSES(
        "hat-glasses",
        "<path d=\"M14 18a2 2 0 0 0-4 0\" />\n  <path d=\"m19 11-2.11-6.657a2 2 0 0 0-2.752-1.148l-1.276.61A2 2 0 0 1 12 4H8.5a2 2 0 0 0-1.925 1.456L5 11\" />\n  <path d=\"M2 11h20\" />\n  <circle cx=\"17\" cy=\"18\" r=\"3\" />\n  <circle cx=\"7\" cy=\"18\" r=\"3\" />"),
    HEART_HANDSHAKE(
        "heart-handshake",
        "<path d=\"M19.414 14.414C21 12.828 22 11.5 22 9.5a5.5 5.5 0 0 0-9.591-3.676.6.6 0 0 1-.818.001A5.5 5.5 0 0 0 2 9.5c0 2.3 1.5 4 3 5.5l5.535 5.362a2 2 0 0 0 2.879.052 2.12 2.12 0 0 0-.004-3 2.124 2.124 0 1 0 3-3 2.124 2.124 0 0 0 3.004 0 2 2 0 0 0 0-2.828l-1.881-1.882a2.41 2.41 0 0 0-3.409 0l-1.71 1.71a2 2 0 0 1-2.828 0 2 2 0 0 1 0-2.828l2.823-2.762\" />"),
    ID_CARD(
        "id-card",
        "<path d=\"M13 19a4 4 0 00-8 0\" />\n  <path d=\"M16 10h2\" />\n  <path d=\"M16 14h2\" />\n  <circle cx=\"9\" cy=\"12\" r=\"3\" />\n  <rect x=\"2\" y=\"5\" width=\"20\" height=\"14\" rx=\"2\" />"),
    ID_CARD_LANYARD(
        "id-card-lanyard",
        "<path d=\"M13.5 8h-3\" />\n  <path d=\"m15 2-1 2h3a2 2 0 012 2v14a2 2 0 01-2 2H7a2 2 0 01-2-2V6a2 2 0 012-2h3\" />\n  <path d=\"M16 22a4 4 0 00-8 0\" />\n  <path d=\"m9 2 3 6\" />\n  <circle cx=\"12\" cy=\"15\" r=\"3\" />"),
    KEY(
        "key",
        "<path d=\"m2 21 9.6-9.6\" />\n  <path d=\"m7.5 15.5 2.3 2.3a1 1 0 0 1 0 1.4l-2.1 2.1a1 1 0 0 1-1.4 0L4 19\" />\n  <circle cx=\"15.5\" cy=\"7.5\" r=\"5.5\" />"),
    KEY_ROUND(
        "key-round",
        "<path d=\"M2.586 17.414A2 2 0 0 0 2 18.828V21a1 1 0 0 0 1 1h3a1 1 0 0 0 1-1v-1a1 1 0 0 1 1-1h1a1 1 0 0 0 1-1v-1a1 1 0 0 1 1-1h.172a2 2 0 0 0 1.414-.586l.814-.814a6.5 6.5 0 1 0-4-4z\" />\n  <circle cx=\"16.5\" cy=\"7.5\" r=\".5\" fill=\"currentColor\" />"),
    KEY_SQUARE(
        "key-square",
        "<path d=\"M12.4 2.7a2.5 2.5 0 0 1 3.4 0l5.5 5.5a2.5 2.5 0 0 1 0 3.4l-3.7 3.7a2.5 2.5 0 0 1-3.4 0L8.7 9.8a2.5 2.5 0 0 1 0-3.4z\" />\n  <path d=\"m14 7 3 3\" />\n  <path d=\"m9.4 10.6-6.814 6.814A2 2 0 0 0 2 18.828V21a1 1 0 0 0 1 1h3a1 1 0 0 0 1-1v-1a1 1 0 0 1 1-1h1a1 1 0 0 0 1-1v-1a1 1 0 0 1 1-1h.172a2 2 0 0 0 1.414-.586l.814-.814\" />"),
    LOCK(
        "lock",
        "<rect width=\"18\" height=\"11\" x=\"3\" y=\"11\" rx=\"2\" ry=\"2\" />\n  <path d=\"M7 11V7a5 5 0 0 1 10 0v4\" />"),
    LOCK_KEYHOLE(
        "lock-keyhole",
        "<circle cx=\"12\" cy=\"16\" r=\"1\" />\n  <rect x=\"3\" y=\"10\" width=\"18\" height=\"12\" rx=\"2\" />\n  <path d=\"M7 10V7a5 5 0 0 1 10 0v3\" />"),
    LOCK_KEYHOLE_OPEN(
        "lock-keyhole-open",
        "<circle cx=\"12\" cy=\"16\" r=\"1\" />\n  <rect width=\"18\" height=\"12\" x=\"3\" y=\"10\" rx=\"2\" />\n  <path d=\"M7 10V7a5 5 0 0 1 9.33-2.5\" />"),
    LOCK_OPEN(
        "lock-open",
        "<rect width=\"18\" height=\"11\" x=\"3\" y=\"11\" rx=\"2\" ry=\"2\" />\n  <path d=\"M7 11V7a5 5 0 0 1 9.9-1\" />"),
    MAIL_BADGE(
        "mail-badge",
        "<path d=\"M22 7.7V6a2 2 0 0 0-2-2H4a2 2 0 0 0-2 2v12a2 2 0 0 0 2 2h8.25\" />\n  <path d=\"M12 12.996a1.94 1.94 0 0 1-1.03-.296L2 7\" />\n  <path d=\"m20.69 16.479 1.29 4.88a.5.5 0 0 1-.698.591l-1.843-.849a1 1 0 0 0-.879.001l-1.846.85a.5.5 0 0 1-.692-.593l1.29-4.88\" />\n  <circle cx=\"19\" cy=\"14\" r=\"3\" />"),
    RADAR(
        "radar",
        "<path d=\"M19.07 4.93A10 10 0 0 0 6.99 3.34\" />\n  <path d=\"M4 6h.01\" />\n  <path d=\"M2.29 9.62A10 10 0 1 0 21.31 8.35\" />\n  <path d=\"M16.24 7.76A6 6 0 1 0 8.23 16.67\" />\n  <path d=\"M12 18h.01\" />\n  <path d=\"M17.99 11.66A6 6 0 0 1 15.77 16.67\" />\n  <circle cx=\"12\" cy=\"12\" r=\"2\" />\n  <path d=\"m13.41 10.59 5.66-5.66\" />"),
    ROTATE_CCW_KEY(
        "rotate-ccw-key",
        "<path d=\"M12 7v6\" />\n  <path d=\"M12 9h2\" />\n  <path d=\"M3 12a9 9 0 1 0 9-9 9.74 9.74 0 0 0-6.74 2.74L3 8\" />\n  <path d=\"M3 3v5h5\" />\n  <circle cx=\"12\" cy=\"15\" r=\"2\" />"),
    SCAN(
        "scan",
        "<path d=\"M3 7V5a2 2 0 0 1 2-2h2\" />\n  <path d=\"M17 3h2a2 2 0 0 1 2 2v2\" />\n  <path d=\"M21 17v2a2 2 0 0 1-2 2h-2\" />\n  <path d=\"M7 21H5a2 2 0 0 1-2-2v-2\" />"),
    SCAN_EYE(
        "scan-eye",
        "<path d=\"M3 7V5a2 2 0 0 1 2-2h2\" />\n  <path d=\"M17 3h2a2 2 0 0 1 2 2v2\" />\n  <path d=\"M21 17v2a2 2 0 0 1-2 2h-2\" />\n  <path d=\"M7 21H5a2 2 0 0 1-2-2v-2\" />\n  <circle cx=\"12\" cy=\"12\" r=\"1\" />\n  <path d=\"M18.944 12.33a1 1 0 0 0 0-.66 7.5 7.5 0 0 0-13.888 0 1 1 0 0 0 0 .66 7.5 7.5 0 0 0 13.888 0\" />"),
    SCAN_FACE(
        "scan-face",
        "<path d=\"M3 7V5a2 2 0 0 1 2-2h2\" />\n  <path d=\"M17 3h2a2 2 0 0 1 2 2v2\" />\n  <path d=\"M21 17v2a2 2 0 0 1-2 2h-2\" />\n  <path d=\"M7 21H5a2 2 0 0 1-2-2v-2\" />\n  <path d=\"M8 14s1.5 2 4 2 4-2 4-2\" />\n  <path d=\"M9 9h.01\" />\n  <path d=\"M15 9h.01\" />"),
    SCAN_QR_CODE(
        "scan-qr-code",
        "<path d=\"M17 12v4a1 1 0 0 1-1 1h-4\" />\n  <path d=\"M17 3h2a2 2 0 0 1 2 2v2\" />\n  <path d=\"M17 8V7\" />\n  <path d=\"M21 17v2a2 2 0 0 1-2 2h-2\" />\n  <path d=\"M3 7V5a2 2 0 0 1 2-2h2\" />\n  <path d=\"M7 17h.01\" />\n  <path d=\"M7 21H5a2 2 0 0 1-2-2v-2\" />\n  <rect x=\"7\" y=\"7\" width=\"5\" height=\"5\" rx=\"1\" />"),
    SHIELD(
        "shield",
        "<path d=\"M20 13c0 5-3.5 7.5-7.66 8.95a1 1 0 0 1-.67-.01C7.5 20.5 4 18 4 13V6a1 1 0 0 1 1-1c2 0 4.5-1.2 6.24-2.72a1.17 1.17 0 0 1 1.52 0C14.51 3.81 17 5 19 5a1 1 0 0 1 1 1z\" />"),
    SHIELD_ALERT(
        "shield-alert",
        "<path d=\"M20 13c0 5-3.5 7.5-7.66 8.95a1 1 0 0 1-.67-.01C7.5 20.5 4 18 4 13V6a1 1 0 0 1 1-1c2 0 4.5-1.2 6.24-2.72a1.17 1.17 0 0 1 1.52 0C14.51 3.81 17 5 19 5a1 1 0 0 1 1 1z\" />\n  <path d=\"M12 8v4\" />\n  <path d=\"M12 16h.01\" />"),
    SHIELD_BAN(
        "shield-ban",
        "<path d=\"M20 13c0 5-3.5 7.5-7.66 8.95a1 1 0 0 1-.67-.01C7.5 20.5 4 18 4 13V6a1 1 0 0 1 1-1c2 0 4.5-1.2 6.24-2.72a1.17 1.17 0 0 1 1.52 0C14.51 3.81 17 5 19 5a1 1 0 0 1 1 1z\" />\n  <path d=\"m4.243 5.21 14.39 12.472\" />"),
    SHIELD_CHECK(
        "shield-check",
        "<path d=\"M20 13c0 5-3.5 7.5-7.66 8.95a1 1 0 0 1-.67-.01C7.5 20.5 4 18 4 13V6a1 1 0 0 1 1-1c2 0 4.5-1.2 6.24-2.72a1.17 1.17 0 0 1 1.52 0C14.51 3.81 17 5 19 5a1 1 0 0 1 1 1z\" />\n  <path d=\"m9 12 2 2 4-4\" />"),
    SHIELD_COG(
        "shield-cog",
        "<path d=\"m10.929 14.467-.383.924\" />\n  <path d=\"M10.929 8.923 10.546 8\" />\n  <path d=\"M13.225 8.923 13.608 8\" />\n  <path d=\"m13.607 15.391-.382-.924\" />\n  <path d=\"m14.849 10.547.923-.383\" />\n  <path d=\"m14.849 12.843.923.383\" />\n  <path d=\"M20 13c0 5-3.5 7.5-7.66 8.95a1 1 0 0 1-.67-.01C7.5 20.5 4 18 4 13V6a1 1 0 0 1 1-1c2 0 4.5-1.2 6.24-2.72a1.17 1.17 0 0 1 1.52 0C14.51 3.81 17 5 19 5a1 1 0 0 1 1 1z\" />\n  <path d=\"m9.305 10.547-.923-.383\" />\n  <path d=\"m9.305 12.843-.923.383\" />\n  <circle cx=\"12.077\" cy=\"11.695\" r=\"3\" />"),
    SHIELD_COG_CORNER(
        "shield-cog-corner",
        "<path d=\"M11 22c-3.806-1.45-7-3.966-7-9V6a1 1 0 0 1 1-1c2 0 4.5-1.2 6.24-2.72a1.17 1.17 0 0 1 1.52 0C14.51 3.81 17 5 19 5a1 1 0 0 1 1 1v4\" />\n  <path d=\"M14.923 16.547 14 16.164\" />\n  <path d=\"m14.923 18.843-.923.383\" />\n  <path d=\"M16.547 14.923 16.164 14\" />\n  <path d=\"m16.547 20.467-.383.924\" />\n  <path d=\"m18.843 14.923.383-.923\" />\n  <path d=\"m19.225 21.391-.382-.924\" />\n  <path d=\"m20.467 16.547.923-.383\" />\n  <path d=\"m20.467 18.843.923.383\" />\n  <circle cx=\"17.695\" cy=\"17.695\" r=\"3\" />"),
    SHIELD_ELLIPSIS(
        "shield-ellipsis",
        "<path d=\"M20 13c0 5-3.5 7.5-7.66 8.95a1 1 0 0 1-.67-.01C7.5 20.5 4 18 4 13V6a1 1 0 0 1 1-1c2 0 4.5-1.2 6.24-2.72a1.17 1.17 0 0 1 1.52 0C14.51 3.81 17 5 19 5a1 1 0 0 1 1 1z\" />\n  <path d=\"M8 12h.01\" />\n  <path d=\"M12 12h.01\" />\n  <path d=\"M16 12h.01\" />"),
    SHIELD_HALF(
        "shield-half",
        "<path d=\"M20 13c0 5-3.5 7.5-7.66 8.95a1 1 0 0 1-.67-.01C7.5 20.5 4 18 4 13V6a1 1 0 0 1 1-1c2 0 4.5-1.2 6.24-2.72a1.17 1.17 0 0 1 1.52 0C14.51 3.81 17 5 19 5a1 1 0 0 1 1 1z\" />\n  <path d=\"M12 22V2\" />"),
    SHIELD_HOUSE(
        "shield-house",
        "<path d=\"M15 22a1 1 0 01-1-1v-4a1 1 0 01.445-.832l3-2a1 1 0 011.11 0l3 2A1 1 0 0122 17v4a1 1 0 01-1 1z\" />\n  <path d=\"M18 22v-3\" />\n  <path d=\"M20 10.418V6a1 1 0 00-1-1c-2 0-4.49-1.19-6.24-2.72a1.17 1.17 0 00-1.52 0C9.5 3.8 7 5 5 5a1 1 0 00-1 1v7c0 4.602 2.67 7.1 6.037 8.603\" />"),
    SHIELD_KEYHOLE(
        "shield-keyhole",
        "<path d=\"M12 13v3\" />\n  <path d=\"M20 13c0 5-3.5 7.5-7.66 8.95a1 1 0 01-.67-.01C7.5 20.5 4 18 4 13V6a1 1 0 011-1c2 0 4.5-1.2 6.24-2.72a1.17 1.17 0 011.52 0C14.51 3.81 17 5 19 5a1 1 0 011 1z\" />\n  <circle cx=\"12\" cy=\"11\" r=\"2\" />"),
    SHIELD_LOCK(
        "shield-lock",
        "<path d=\"M20 9.807V6a1 1 0 00-1-1c-2 0-4.49-1.19-6.24-2.72a1.17 1.17 0 00-1.52 0C9.5 3.8 7 5 5 5a1 1 0 00-1 1v7c0 3.88 2.107 6.254 5 7.796\" />\n  <path d=\"M19 17v-2a2 2 0 00-4 0v2\" />\n  <rect x=\"13\" y=\"17\" width=\"8\" height=\"5\" rx=\"1\" />"),
    SHIELD_MINUS(
        "shield-minus",
        "<path d=\"M20 13c0 5-3.5 7.5-7.66 8.95a1 1 0 0 1-.67-.01C7.5 20.5 4 18 4 13V6a1 1 0 0 1 1-1c2 0 4.5-1.2 6.24-2.72a1.17 1.17 0 0 1 1.52 0C14.51 3.81 17 5 19 5a1 1 0 0 1 1 1z\" />\n  <path d=\"M9 12h6\" />"),
    SHIELD_OFF(
        "shield-off",
        "<path d=\"m2 2 20 20\" />\n  <path d=\"M5 5a1 1 0 0 0-1 1v7c0 5 3.5 7.5 7.67 8.94a1 1 0 0 0 .67.01c2.35-.82 4.48-1.97 5.9-3.71\" />\n  <path d=\"M9.309 3.652A12.252 12.252 0 0 0 11.24 2.28a1.17 1.17 0 0 1 1.52 0C14.51 3.81 17 5 19 5a1 1 0 0 1 1 1v7a9.784 9.784 0 0 1-.08 1.264\" />"),
    SHIELD_PLUS(
        "shield-plus",
        "<path d=\"M20 13c0 5-3.5 7.5-7.66 8.95a1 1 0 0 1-.67-.01C7.5 20.5 4 18 4 13V6a1 1 0 0 1 1-1c2 0 4.5-1.2 6.24-2.72a1.17 1.17 0 0 1 1.52 0C14.51 3.81 17 5 19 5a1 1 0 0 1 1 1z\" />\n  <path d=\"M9 12h6\" />\n  <path d=\"M12 9v6\" />"),
    SHIELD_QUESTION_MARK(
        "shield-question-mark",
        "<path d=\"M20 13c0 5-3.5 7.5-7.66 8.95a1 1 0 0 1-.67-.01C7.5 20.5 4 18 4 13V6a1 1 0 0 1 1-1c2 0 4.5-1.2 6.24-2.72a1.17 1.17 0 0 1 1.52 0C14.51 3.81 17 5 19 5a1 1 0 0 1 1 1z\" />\n  <path d=\"M9.1 9a3 3 0 0 1 5.82 1c0 2-3 3-3 3\" />\n  <path d=\"M12 17h.01\" />"),
    SHIELD_USER(
        "shield-user",
        "<path d=\"M20 13c0 5-3.5 7.5-7.66 8.95a1 1 0 0 1-.67-.01C7.5 20.5 4 18 4 13V6a1 1 0 0 1 1-1c2 0 4.5-1.2 6.24-2.72a1.17 1.17 0 0 1 1.52 0C14.51 3.81 17 5 19 5a1 1 0 0 1 1 1z\" />\n  <path d=\"M6.376 18.91a6 6 0 0 1 11.249.003\" />\n  <circle cx=\"12\" cy=\"11\" r=\"4\" />"),
    SHIELD_X(
        "shield-x",
        "<path d=\"M20 13c0 5-3.5 7.5-7.66 8.95a1 1 0 0 1-.67-.01C7.5 20.5 4 18 4 13V6a1 1 0 0 1 1-1c2 0 4.5-1.2 6.24-2.72a1.17 1.17 0 0 1 1.52 0C14.51 3.81 17 5 19 5a1 1 0 0 1 1 1z\" />\n  <path d=\"m14.5 9.5-5 5\" />\n  <path d=\"m9.5 9.5 5 5\" />"),
    SQUARE_ASTERISK(
        "square-asterisk",
        "<rect width=\"18\" height=\"18\" x=\"3\" y=\"3\" rx=\"2\" />\n  <path d=\"M12 8v8\" />\n  <path d=\"m8.5 14 7-4\" />\n  <path d=\"m8.5 10 7 4\" />"),
    USER_LOCK(
        "user-lock",
        "<path d=\"M19 16v-2a2 2 0 0 0-4 0v2\" />\n  <path d=\"M9.5 15H7a4 4 0 0 0-4 4v2\" />\n  <circle cx=\"10\" cy=\"7\" r=\"4\" />\n  <rect x=\"13\" y=\"16\" width=\"8\" height=\"5\" rx=\".899\" />"),
    USER_SHIELD(
        "user-shield",
        "<path d=\"M10 15H6a4 4 0 0 0-4 4v2\" />\n  <path d=\"M22 17.5c0 2.499-1.75 3.749-3.83 4.474a.5.5 0 0 1-.335-.005c-2.085-.72-3.835-1.97-3.835-4.47V14a.5.5 0 0 1 .5-.499c1 0 2.25-.6 3.12-1.36a.6.6 0 0 1 .76-.001c.875.765 2.12 1.36 3.12 1.36a.5.5 0 0 1 .5.5z\" />\n  <circle cx=\"9\" cy=\"7\" r=\"4\" />"),
    VAULT(
        "vault",
        "<rect width=\"18\" height=\"18\" x=\"3\" y=\"3\" rx=\"2\" />\n  <circle cx=\"7.5\" cy=\"7.5\" r=\".5\" fill=\"currentColor\" />\n  <path d=\"m7.9 7.9 2.7 2.7\" />\n  <circle cx=\"16.5\" cy=\"7.5\" r=\".5\" fill=\"currentColor\" />\n  <path d=\"m13.4 10.6 2.7-2.7\" />\n  <circle cx=\"7.5\" cy=\"16.5\" r=\".5\" fill=\"currentColor\" />\n  <path d=\"m7.9 16.1 2.7-2.7\" />\n  <circle cx=\"16.5\" cy=\"16.5\" r=\".5\" fill=\"currentColor\" />\n  <path d=\"m13.4 13.4 2.7 2.7\" />\n  <circle cx=\"12\" cy=\"12\" r=\"2\" />"),
    VIRUS(
        "virus",
        "<path d=\"M12 14.991h.01\" />\n  <path d=\"M12 22v-3\" />\n  <path d=\"M12 2v3\" />\n  <path d=\"M13 22h-2\" />\n  <path d=\"M13 2h-2\" />\n  <path d=\"M13.99 10H14\" />\n  <path d=\"m16.5 19.794-1-1.733\" />\n  <path d=\"m16.5 4.205-1 1.732\" />\n  <path d=\"m19.794 16.5-1.732-1\" />\n  <path d=\"m19.794 7.5-1.732 1\" />\n  <path d=\"M2 12h3\" />\n  <path d=\"M2 13v-2\" />\n  <path d=\"M22 12h-3\" />\n  <path d=\"M22 13v-2\" />\n  <path d=\"m4.206 16.5 1.732-1\" />\n  <path d=\"m4.206 7.5 1.732 1\" />\n  <path d=\"m7.5 19.794 1-1.733\" />\n  <path d=\"m7.5 4.205 1 1.732\" />\n  <path d=\"M9 12h.01\" />\n  <circle cx=\"12\" cy=\"12\" r=\"7\" />"),
    VIRUS_OFF(
        "virus-off",
        "<path d=\"M10.01 10h.01\" />\n  <path d=\"M12 14.991h.01\" />\n  <path d=\"M12 22v-3\" />\n  <path d=\"M12 2v3\" />\n  <path d=\"M13 22h-2\" />\n  <path d=\"M13 2h-2\" />\n  <path d=\"m16.5 19.794-1-1.733\" />\n  <path d=\"m16.5 4.205-1 1.732\" />\n  <path d=\"M18.891 13.235a7 7 0 00-8.126-8.126\" />\n  <path d=\"m19.794 7.5-1.732 1\" />\n  <path d=\"M2 12h3\" />\n  <path d=\"M2 13v-2\" />\n  <path d=\"m2 2 20 20\" />\n  <path d=\"M22 12h-3\" />\n  <path d=\"M22 13v-2\" />\n  <path d=\"m4.206 16.5 1.732-1\" />\n  <path d=\"m4.206 7.5 1.732 1\" />\n  <path d=\"M7.05 7.05a7 7 0 009.9 9.9\" />\n  <path d=\"m7.5 19.794 1-1.733\" />\n  <path d=\"M9 12h.01\" />"),
    WAYPOINTS(
        "waypoints",
        "<path d=\"m10.586 5.414-5.172 5.172\" />\n  <path d=\"m18.586 13.414-5.172 5.172\" />\n  <path d=\"M6 12h12\" />\n  <circle cx=\"12\" cy=\"20\" r=\"2\" />\n  <circle cx=\"12\" cy=\"4\" r=\"2\" />\n  <circle cx=\"20\" cy=\"12\" r=\"2\" />\n  <circle cx=\"4\" cy=\"12\" r=\"2\" />"),
    WIFI_LOCK(
        "wifi-lock",
        "<path d=\"M2 8.82a15 15 0 0120 0\" />\n  <path d=\"M20 16v-2a2 2 0 00-4 0v2\" />\n  <path d=\"M5 12.859a10 10 0 018.436-2.756\" />\n  <path d=\"M8.5 16.429a5 5 0 011.794-1.13\" />\n  <rect x=\"14\" y=\"16\" width=\"8\" height=\"5\" rx=\"1\" />"),
    WORM(
        "worm",
        "<path d=\"m19 12-1.5 3\" />\n  <path d=\"M19.63 18.81 22 20\" />\n  <path d=\"M6.47 8.23a1.68 1.68 0 0 1 2.44 1.93l-.64 2.08a6.76 6.76 0 0 0 10.16 7.67l.42-.27a1 1 0 1 0-2.73-4.21l-.42.27a1.76 1.76 0 0 1-2.63-1.99l.64-2.08A6.66 6.66 0 0 0 3.94 3.9l-.7.4a1 1 0 1 0 2.55 4.34z\" />");

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
  default LucideIcon bomb_security() {
    return LucideIcon.create(Icon.BOMB);
  }

  default LucideIcon book_key_security() {
    return LucideIcon.create(Icon.BOOK_KEY);
  }

  default LucideIcon book_lock_security() {
    return LucideIcon.create(Icon.BOOK_LOCK);
  }

  default LucideIcon brick_wall_fire_security() {
    return LucideIcon.create(Icon.BRICK_WALL_FIRE);
  }

  default LucideIcon brick_wall_shield_security() {
    return LucideIcon.create(Icon.BRICK_WALL_SHIELD);
  }

  default LucideIcon cctv_security() {
    return LucideIcon.create(Icon.CCTV);
  }

  default LucideIcon cctv_off_security() {
    return LucideIcon.create(Icon.CCTV_OFF);
  }

  default LucideIcon certificate_security() {
    return LucideIcon.create(Icon.CERTIFICATE);
  }

  default LucideIcon columns_4_security() {
    return LucideIcon.create(Icon.COLUMNS_4);
  }

  default LucideIcon door_closed_security() {
    return LucideIcon.create(Icon.DOOR_CLOSED);
  }

  default LucideIcon door_closed_cog_security() {
    return LucideIcon.create(Icon.DOOR_CLOSED_COG);
  }

  default LucideIcon door_closed_locked_security() {
    return LucideIcon.create(Icon.DOOR_CLOSED_LOCKED);
  }

  default LucideIcon door_open_security() {
    return LucideIcon.create(Icon.DOOR_OPEN);
  }

  default LucideIcon earth_lock_security() {
    return LucideIcon.create(Icon.EARTH_LOCK);
  }

  default LucideIcon eye_security() {
    return LucideIcon.create(Icon.EYE);
  }

  default LucideIcon eye_closed_security() {
    return LucideIcon.create(Icon.EYE_CLOSED);
  }

  default LucideIcon eye_dashed_security() {
    return LucideIcon.create(Icon.EYE_DASHED);
  }

  default LucideIcon eye_off_security() {
    return LucideIcon.create(Icon.EYE_OFF);
  }

  default LucideIcon file_key_security() {
    return LucideIcon.create(Icon.FILE_KEY);
  }

  default LucideIcon file_lock_security() {
    return LucideIcon.create(Icon.FILE_LOCK);
  }

  default LucideIcon fingerprint_pattern_security() {
    return LucideIcon.create(Icon.FINGERPRINT_PATTERN);
  }

  default LucideIcon folder_key_security() {
    return LucideIcon.create(Icon.FOLDER_KEY);
  }

  default LucideIcon folder_lock_security() {
    return LucideIcon.create(Icon.FOLDER_LOCK);
  }

  default LucideIcon folder_user_security() {
    return LucideIcon.create(Icon.FOLDER_USER);
  }

  default LucideIcon folder_users_security() {
    return LucideIcon.create(Icon.FOLDER_USERS);
  }

  default LucideIcon germ_security() {
    return LucideIcon.create(Icon.GERM);
  }

  default LucideIcon germ_off_security() {
    return LucideIcon.create(Icon.GERM_OFF);
  }

  default LucideIcon globe_lock_security() {
    return LucideIcon.create(Icon.GLOBE_LOCK);
  }

  default LucideIcon handshake_security() {
    return LucideIcon.create(Icon.HANDSHAKE);
  }

  default LucideIcon hat_glasses_security() {
    return LucideIcon.create(Icon.HAT_GLASSES);
  }

  default LucideIcon heart_handshake_security() {
    return LucideIcon.create(Icon.HEART_HANDSHAKE);
  }

  default LucideIcon id_card_security() {
    return LucideIcon.create(Icon.ID_CARD);
  }

  default LucideIcon id_card_lanyard_security() {
    return LucideIcon.create(Icon.ID_CARD_LANYARD);
  }

  default LucideIcon key_security() {
    return LucideIcon.create(Icon.KEY);
  }

  default LucideIcon key_round_security() {
    return LucideIcon.create(Icon.KEY_ROUND);
  }

  default LucideIcon key_square_security() {
    return LucideIcon.create(Icon.KEY_SQUARE);
  }

  default LucideIcon lock() {
    return LucideIcon.create(Icon.LOCK);
  }

  default LucideIcon lock_keyhole() {
    return LucideIcon.create(Icon.LOCK_KEYHOLE);
  }

  default LucideIcon lock_keyhole_open() {
    return LucideIcon.create(Icon.LOCK_KEYHOLE_OPEN);
  }

  default LucideIcon lock_open() {
    return LucideIcon.create(Icon.LOCK_OPEN);
  }

  default LucideIcon mail_badge_security() {
    return LucideIcon.create(Icon.MAIL_BADGE);
  }

  default LucideIcon radar_security() {
    return LucideIcon.create(Icon.RADAR);
  }

  default LucideIcon rotate_ccw_key_security() {
    return LucideIcon.create(Icon.ROTATE_CCW_KEY);
  }

  default LucideIcon scan_security() {
    return LucideIcon.create(Icon.SCAN);
  }

  default LucideIcon scan_eye_security() {
    return LucideIcon.create(Icon.SCAN_EYE);
  }

  default LucideIcon scan_face_security() {
    return LucideIcon.create(Icon.SCAN_FACE);
  }

  default LucideIcon scan_qr_code_security() {
    return LucideIcon.create(Icon.SCAN_QR_CODE);
  }

  default LucideIcon shield_security() {
    return LucideIcon.create(Icon.SHIELD);
  }

  default LucideIcon shield_alert_security() {
    return LucideIcon.create(Icon.SHIELD_ALERT);
  }

  default LucideIcon shield_ban_security() {
    return LucideIcon.create(Icon.SHIELD_BAN);
  }

  default LucideIcon shield_check_security() {
    return LucideIcon.create(Icon.SHIELD_CHECK);
  }

  default LucideIcon shield_cog_security() {
    return LucideIcon.create(Icon.SHIELD_COG);
  }

  default LucideIcon shield_cog_corner_security() {
    return LucideIcon.create(Icon.SHIELD_COG_CORNER);
  }

  default LucideIcon shield_ellipsis_security() {
    return LucideIcon.create(Icon.SHIELD_ELLIPSIS);
  }

  default LucideIcon shield_half_security() {
    return LucideIcon.create(Icon.SHIELD_HALF);
  }

  default LucideIcon shield_house_security() {
    return LucideIcon.create(Icon.SHIELD_HOUSE);
  }

  default LucideIcon shield_keyhole_security() {
    return LucideIcon.create(Icon.SHIELD_KEYHOLE);
  }

  default LucideIcon shield_lock() {
    return LucideIcon.create(Icon.SHIELD_LOCK);
  }

  default LucideIcon shield_minus_security() {
    return LucideIcon.create(Icon.SHIELD_MINUS);
  }

  default LucideIcon shield_off_security() {
    return LucideIcon.create(Icon.SHIELD_OFF);
  }

  default LucideIcon shield_plus_security() {
    return LucideIcon.create(Icon.SHIELD_PLUS);
  }

  default LucideIcon shield_question_mark_security() {
    return LucideIcon.create(Icon.SHIELD_QUESTION_MARK);
  }

  default LucideIcon shield_user_security() {
    return LucideIcon.create(Icon.SHIELD_USER);
  }

  default LucideIcon shield_x_security() {
    return LucideIcon.create(Icon.SHIELD_X);
  }

  default LucideIcon square_asterisk_security() {
    return LucideIcon.create(Icon.SQUARE_ASTERISK);
  }

  default LucideIcon user_lock_security() {
    return LucideIcon.create(Icon.USER_LOCK);
  }

  default LucideIcon user_shield_security() {
    return LucideIcon.create(Icon.USER_SHIELD);
  }

  default LucideIcon vault_security() {
    return LucideIcon.create(Icon.VAULT);
  }

  default LucideIcon virus_security() {
    return LucideIcon.create(Icon.VIRUS);
  }

  default LucideIcon virus_off_security() {
    return LucideIcon.create(Icon.VIRUS_OFF);
  }

  default LucideIcon waypoints_security() {
    return LucideIcon.create(Icon.WAYPOINTS);
  }

  default LucideIcon wifi_lock_security() {
    return LucideIcon.create(Icon.WIFI_LOCK);
  }

  default LucideIcon worm_security() {
    return LucideIcon.create(Icon.WORM);
  }
}
