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

/** Lucide emoji catalog category. */
public interface LucideEmoji {
  enum Icon implements LucideIconDefinition {
    BALLOON(
        "balloon",
        "<path d=\"M12 16v1a2 2 0 0 0 2 2h1a2 2 0 0 1 2 2v1\" />\n  <path d=\"M12 6a2 2 0 0 1 2 2\" />\n  <path d=\"M18 8c0 4-3.5 8-6 8s-6-4-6-8a6 6 0 0 1 12 0\" />"),
    BICEPS_FLEXED(
        "biceps-flexed",
        "<path d=\"M12.409 13.017A5 5 0 0 1 22 15c0 3.866-4 7-9 7-4.077 0-8.153-.82-10.371-2.462-.426-.316-.631-.832-.62-1.362C2.118 12.723 2.627 2 10 2a3 3 0 0 1 3 3 2 2 0 0 1-2 2c-1.105 0-1.64-.444-2-1\" />\n  <path d=\"M15 14a5 5 0 0 0-7.584 2\" />\n  <path d=\"M9.964 6.825C8.019 7.977 9.5 13 8 15\" />"),
    CHESS_BISHOP(
        "chess-bishop",
        "<path d=\"M5 20a2 2 0 0 1 2-2h10a2 2 0 0 1 2 2v1a1 1 0 0 1-1 1H6a1 1 0 0 1-1-1z\" />\n  <path d=\"M15 18c1.5-.615 3-2.461 3-4.923C18 8.769 14.5 4.462 12 2 9.5 4.462 6 8.77 6 13.077 6 15.539 7.5 17.385 9 18\" />\n  <path d=\"m16 7-2.5 2.5\" />\n  <path d=\"M9 2h6\" />"),
    CHESS_KING(
        "chess-king",
        "<path d=\"M4 20a2 2 0 0 1 2-2h12a2 2 0 0 1 2 2v1a1 1 0 0 1-1 1H5a1 1 0 0 1-1-1z\" />\n  <path d=\"m6.7 18-1-1C4.35 15.682 3 14.09 3 12a5 5 0 0 1 4.95-5c1.584 0 2.7.455 4.05 1.818C13.35 7.455 14.466 7 16.05 7A5 5 0 0 1 21 12c0 2.082-1.359 3.673-2.7 5l-1 1\" />\n  <path d=\"M10 4h4\" />\n  <path d=\"M12 2v6.818\" />"),
    CHESS_KNIGHT(
        "chess-knight",
        "<path d=\"M5 20a2 2 0 0 1 2-2h10a2 2 0 0 1 2 2v1a1 1 0 0 1-1 1H6a1 1 0 0 1-1-1z\" />\n  <path d=\"M16.5 18c1-2 2.5-5 2.5-9a7 7 0 0 0-7-7H6.635a1 1 0 0 0-.768 1.64L7 5l-2.32 5.802a2 2 0 0 0 .95 2.526l2.87 1.456\" />\n  <path d=\"m15 5 1.425-1.425\" />\n  <path d=\"m17 8 1.53-1.53\" />\n  <path d=\"M9.713 12.185 7 18\" />"),
    CHESS_PAWN(
        "chess-pawn",
        "<path d=\"M5 20a2 2 0 0 1 2-2h10a2 2 0 0 1 2 2v1a1 1 0 0 1-1 1H6a1 1 0 0 1-1-1z\" />\n  <path d=\"m14.5 10 1.5 8\" />\n  <path d=\"M7 10h10\" />\n  <path d=\"m8 18 1.5-8\" />\n  <circle cx=\"12\" cy=\"6\" r=\"4\" />"),
    CHESS_QUEEN(
        "chess-queen",
        "<path d=\"m10.68 5.499-.996 4.982a.65.65 0 01-1.131.295L5.885 7.663\" />\n  <path d=\"m13.32 5.5.995 4.98a.65.65 0 001.131.296l2.668-3.113\" />\n  <path d=\"M20.428 8.952 17.5 18\" />\n  <path d=\"M4 20a2 2 0 012-2h12a2 2 0 012 2v1a1 1 0 01-1 1H5a1 1 0 01-1-1z\" />\n  <path d=\"M6.5 18 3.571 8.952\" />\n  <circle cx=\"12\" cy=\"4\" r=\"2\" />\n  <circle cx=\"20\" cy=\"7\" r=\"2\" />\n  <circle cx=\"4\" cy=\"7\" r=\"2\" />"),
    CHESS_ROOK(
        "chess-rook",
        "<path d=\"M5 20a2 2 0 0 1 2-2h10a2 2 0 0 1 2 2v1a1 1 0 0 1-1 1H6a1 1 0 0 1-1-1z\" />\n  <path d=\"M10 2v2\" />\n  <path d=\"M14 2v2\" />\n  <path d=\"m17 18-1-9\" />\n  <path d=\"M6 2v5a2 2 0 0 0 2 2h8a2 2 0 0 0 2-2V2\" />\n  <path d=\"M6 4h12\" />\n  <path d=\"m7 18 1-9\" />"),
    FACE_ANGRY(
        "face-angry",
        "<path d=\"M15 12v-1.584\" />\n  <path d=\"M17 10a5 5 0 00-3 1\" />\n  <path d=\"M7 10a5 5 0 013 1\" />\n  <path d=\"M9 12v-1.584\" />\n  <path d=\"M9 17a5 5 0 016.001 0\" />\n  <circle cx=\"12\" cy=\"12\" r=\"10\" />"),
    FACE_EXPRESSIONLESS(
        "face-expressionless",
        "<path d=\"M14 10h2\" />\n  <path d=\"M8 10h2\" />\n  <path d=\"M8 16h8\" />\n  <circle cx=\"12\" cy=\"12\" r=\"10\" />"),
    FACE_GRINNING(
        "face-grinning",
        "<path d=\"M15 10V9\" />\n  <path d=\"M7.084 14.302a5.12 5.12 0 009.833 0 .24.24 0 00-.235-.302H7.32a.24.24 0 00-.235.302\" />\n  <path d=\"M9 10V9\" />\n  <circle cx=\"12\" cy=\"12\" r=\"10\" />"),
    FACE_NEUTRAL(
        "face-neutral",
        "<path d=\"M15 10V9\" />\n  <path d=\"M8 16h8\" />\n  <path d=\"M9 10V9\" />\n  <circle cx=\"12\" cy=\"12\" r=\"10\" />"),
    FACE_SLIGHTLY_FROWNING(
        "face-slightly-frowning",
        "<path d=\"M15 10V9\" />\n  <path d=\"M9 10V9\" />\n  <path d=\"M9 16a5 5 0 016 0\" />\n  <circle cx=\"12\" cy=\"12\" r=\"10\" />"),
    FACE_SLIGHTLY_SMILING(
        "face-slightly-smiling",
        "<path d=\"M15 10V9\" />\n  <path d=\"M16.472 15a6 6 0 01-8.943 0\" />\n  <path d=\"M9 10V9\" />\n  <circle cx=\"12\" cy=\"12\" r=\"10\" />"),
    FACE_SLIGHTLY_SMILING_PLUS(
        "face-slightly-smiling-plus",
        "<path d=\"M13.267 2.08a10 10 0 108.653 8.653\" />\n  <path d=\"M15 10V9\" />\n  <path d=\"M16 5h6\" />\n  <path d=\"M16.472 15a6 6 0 01-8.943 0\" />\n  <path d=\"M19 2v6\" />\n  <path d=\"M9 10V9\" />"),
    HAND_FIST(
        "hand-fist",
        "<path d=\"M12.035 17.012a3 3 0 0 0-3-3l-.311-.002a.72.72 0 0 1-.505-1.229l1.195-1.195A2 2 0 0 1 10.828 11H12a2 2 0 0 0 0-4H9.243a3 3 0 0 0-2.122.879l-2.707 2.707A4.83 4.83 0 0 0 3 14a8 8 0 0 0 8 8h2a8 8 0 0 0 8-8V7a2 2 0 1 0-4 0v2a2 2 0 1 0 4 0\" />\n  <path d=\"M13.888 9.662A2 2 0 0 0 17 8V5A2 2 0 1 0 13 5\" />\n  <path d=\"M9 5A2 2 0 1 0 5 5V10\" />\n  <path d=\"M9 7V4A2 2 0 1 1 13 4V7.268\" />"),
    HAND_HELPING(
        "hand-helping",
        "<path d=\"M11 12h2a2 2 0 1 0 0-4h-3c-.6 0-1.1.2-1.4.6L3 14\" />\n  <path d=\"m7 18 1.6-1.4c.3-.4.8-.6 1.4-.6h4c1.1 0 2.1-.4 2.8-1.2l4.6-4.4a2 2 0 0 0-2.75-2.91l-4.2 3.9\" />\n  <path d=\"m2 13 6 6\" />"),
    HAND_METAL(
        "hand-metal",
        "<path d=\"M18 12.5V10a2 2 0 0 0-2-2a2 2 0 0 0-2 2v1.4\" />\n  <path d=\"M14 11V9a2 2 0 1 0-4 0v2\" />\n  <path d=\"M10 10.5V5a2 2 0 1 0-4 0v9\" />\n  <path d=\"m7 15-1.76-1.76a2 2 0 0 0-2.83 2.82l3.6 3.6C7.5 21.14 9.2 22 12 22h2a8 8 0 0 0 8-8V7a2 2 0 1 0-4 0v5\" />"),
    HEART(
        "heart",
        "<path d=\"M2 9.5a5.5 5.5 0 0 1 9.591-3.676.56.56 0 0 0 .818 0A5.49 5.49 0 0 1 22 9.5c0 2.29-1.5 4-3 5.5l-5.492 5.313a2 2 0 0 1-3 .019L5 15c-1.5-1.5-3-3.2-3-5.5\" />"),
    HEART_CRACK(
        "heart-crack",
        "<path d=\"M12.409 5.824c-.702.792-1.15 1.496-1.415 2.166l2.153 2.156a.5.5 0 0 1 0 .707l-2.293 2.293a.5.5 0 0 0 0 .707L12 15\" />\n  <path d=\"M13.508 20.313a2 2 0 0 1-3 .019L5 15c-1.5-1.5-3-3.2-3-5.5a5.5 5.5 0 0 1 9.591-3.677.6.6 0 0 0 .818.001A5.5 5.5 0 0 1 22 9.5c0 2.29-1.5 4-3 5.5z\" />"),
    HEART_HANDSHAKE(
        "heart-handshake",
        "<path d=\"M19.414 14.414C21 12.828 22 11.5 22 9.5a5.5 5.5 0 0 0-9.591-3.676.6.6 0 0 1-.818.001A5.5 5.5 0 0 0 2 9.5c0 2.3 1.5 4 3 5.5l5.535 5.362a2 2 0 0 0 2.879.052 2.12 2.12 0 0 0-.004-3 2.124 2.124 0 1 0 3-3 2.124 2.124 0 0 0 3.004 0 2 2 0 0 0 0-2.828l-1.881-1.882a2.41 2.41 0 0 0-3.409 0l-1.71 1.71a2 2 0 0 1-2.828 0 2 2 0 0 1 0-2.828l2.823-2.762\" />"),
    LEAFY_GREEN(
        "leafy-green",
        "<path d=\"M2 22c1.25-.987 2.27-1.975 3.9-2.2a5.56 5.56 0 0 1 3.8 1.5 4 4 0 0 0 6.187-2.353 3.5 3.5 0 0 0 3.69-5.116A3.5 3.5 0 0 0 20.95 8 3.5 3.5 0 1 0 16 3.05a3.5 3.5 0 0 0-5.831 1.373 3.5 3.5 0 0 0-5.116 3.69 4 4 0 0 0-2.348 6.155C3.499 15.42 4.409 16.712 4.2 18.1 3.926 19.743 3.014 20.732 2 22\" />\n  <path d=\"M2 22 17 7\" />"),
    PARTY_POPPER(
        "party-popper",
        "<path d=\"M5.8 11.3 2 22l10.7-3.79\" />\n  <path d=\"M4 3h.01\" />\n  <path d=\"M22 8h.01\" />\n  <path d=\"M15 2h.01\" />\n  <path d=\"M22 20h.01\" />\n  <path d=\"m22 2-2.24.75a2.9 2.9 0 0 0-1.96 3.12c.1.86-.57 1.63-1.45 1.63h-.38c-.86 0-1.6.6-1.76 1.44L14 10\" />\n  <path d=\"m22 13-.82-.33c-.86-.34-1.82.2-1.98 1.11c-.11.7-.72 1.22-1.43 1.22H17\" />\n  <path d=\"m11 2 .33.82c.34.86-.2 1.82-1.11 1.98C9.52 4.9 9 5.52 9 6.23V7\" />\n  <path d=\"M11 13c1.93 1.93 2.83 4.17 2 5-.83.83-3.07-.07-5-2-1.93-1.93-2.83-4.17-2-5 .83-.83 3.07.07 5 2Z\" />"),
    RIBBON(
        "ribbon",
        "<path d=\"M12 11.22C11 9.997 10 9 10 8a2 2 0 0 1 4 0c0 1-.998 2.002-2.01 3.22\" />\n  <path d=\"m12 18 2.57-3.5\" />\n  <path d=\"M6.243 9.016a7 7 0 0 1 11.507-.009\" />\n  <path d=\"M9.35 14.53 12 11.22\" />\n  <path d=\"M9.35 14.53C7.728 12.246 6 10.221 6 7a6 5 0 0 1 12 0c-.005 3.22-1.778 5.235-3.43 7.5l3.557 4.527a1 1 0 0 1-.203 1.43l-1.894 1.36a1 1 0 0 1-1.384-.215L12 18l-2.679 3.593a1 1 0 0 1-1.39.213l-1.865-1.353a1 1 0 0 1-.203-1.422z\" />"),
    SALAD(
        "salad",
        "<path d=\"M19.496 12a2.5 2.5 0 00.399-2.214A2 2 0 0020.32 6.5 2 2 0 0019 3a2 2 0 00-1.5.68 2 2 0 00-3.287.424 2.5 2.5 0 00-3.189 2.06A3 3 0 0012 12l4-4\" />\n  <path d=\"M4 12a1 1 0 00-.99 1.133A9 9 0 0012 21a9 9 0 008.99-7.867A1 1 0 0020 12z\" />\n  <path d=\"M7 21h10\" />\n  <path d=\"M9.85 6.907A3.5 3.5 0 005.05 12\" />"),
    STAR(
        "star",
        "<path d=\"M11.525 2.295a.53.53 0 0 1 .95 0l2.31 4.679a2.123 2.123 0 0 0 1.595 1.16l5.166.756a.53.53 0 0 1 .294.904l-3.736 3.638a2.123 2.123 0 0 0-.611 1.878l.882 5.14a.53.53 0 0 1-.771.56l-4.618-2.428a2.122 2.122 0 0 0-1.973 0L6.396 21.01a.53.53 0 0 1-.77-.56l.881-5.139a2.122 2.122 0 0 0-.611-1.879L2.16 9.795a.53.53 0 0 1 .294-.906l5.165-.755a2.122 2.122 0 0 0 1.597-1.16z\" />"),
    STAR_CHECK(
        "star-check",
        "<path d=\"m19.06 12.501 2.78-2.707a.53.53 0 0 0-.294-.905l-5.166-.755a2.1 2.1 0 0 1-1.595-1.16l-2.31-4.68a.53.53 0 0 0-.95.001L9.216 6.974a2.1 2.1 0 0 1-1.597 1.16l-5.165.755a.53.53 0 0 0-.294.906l3.736 3.637a2.1 2.1 0 0 1 .611 1.879l-.88 5.139a.53.53 0 0 0 .769.56l4.617-2.428.027-.014\" />\n  <path d=\"m15 18 2 2 4-4\" />"),
    STAR_MINUS(
        "star-minus",
        "<path d=\"M15 18h6\" />\n  <path d=\"M17.688 14a2.1 2.1 0 0 1 .416-.568l3.736-3.638a.53.53 0 0 0-.294-.905l-5.166-.755a2.1 2.1 0 0 1-1.595-1.16l-2.31-4.68a.53.53 0 0 0-.95.001L9.216 6.974a2.1 2.1 0 0 1-1.597 1.16l-5.165.755a.53.53 0 0 0-.294.906l3.736 3.637a2.1 2.1 0 0 1 .611 1.879l-.88 5.139a.53.53 0 0 0 .769.56l4.617-2.428.027-.014\" />"),
    STAR_PLUS(
        "star-plus",
        "<path d=\"M11.013 18.582 6.396 21.01a.53.53 0 0 1-.77-.56l.881-5.139a2.12 2.12 0 0 0-.611-1.879L2.16 9.795a.53.53 0 0 1 .294-.906l5.165-.755a2.12 2.12 0 0 0 1.597-1.16l2.309-4.679a.53.53 0 0 1 .95 0l2.31 4.679a2.12 2.12 0 0 0 1.595 1.16l5.166.756a.53.53 0 0 1 .294.904L20 11.5\" />\n  <path d=\"M15 18h6\" />\n  <path d=\"M18 15v6\" />"),
    STAR_X(
        "star-x",
        "<path d=\"m15.5 15.5 5 5\" />\n  <path d=\"m20.063 11.525 1.777-1.731a.53.53 0 0 0-.294-.905l-5.166-.755a2.1 2.1 0 0 1-1.595-1.16l-2.31-4.68a.53.53 0 0 0-.95.001L9.216 6.974a2.1 2.1 0 0 1-1.597 1.16l-5.165.755a.53.53 0 0 0-.294.906l3.736 3.637a2.1 2.1 0 0 1 .611 1.879l-.88 5.139a.53.53 0 0 0 .769.56l4.617-2.428a2.1 2.1 0 0 1 .987-.243 2 2 0 0 1 .132.004\" />\n  <path d=\"m20.5 15.5-5 5\" />"),
    THUMBS_DOWN(
        "thumbs-down",
        "<path d=\"M9 18.12 10 14H4.17a2 2 0 0 1-1.92-2.56l2.33-8A2 2 0 0 1 6.5 2H20a2 2 0 0 1 2 2v8a2 2 0 0 1-2 2h-2.76a2 2 0 0 0-1.79 1.11L12 22a3.13 3.13 0 0 1-3-3.88Z\" />\n  <path d=\"M17 14V2\" />"),
    THUMBS_UP(
        "thumbs-up",
        "<path d=\"M15 5.88 14 10h5.83a2 2 0 0 1 1.92 2.56l-2.33 8A2 2 0 0 1 17.5 22H4a2 2 0 0 1-2-2v-8a2 2 0 0 1 2-2h2.76a2 2 0 0 0 1.79-1.11L12 2a3.13 3.13 0 0 1 3 3.88Z\" />\n  <path d=\"M7 10v12\" />"),
    ZODIAC_AQUARIUS(
        "zodiac-aquarius",
        "<path d=\"m2 10 2.456-3.684a.7.7 0 0 1 1.106-.013l2.39 3.413a.7.7 0 0 0 1.096-.001l2.402-3.432a.7.7 0 0 1 1.098 0l2.402 3.432a.7.7 0 0 0 1.098 0l2.389-3.413a.7.7 0 0 1 1.106.013L22 10\" />\n  <path d=\"m2 18.002 2.456-3.684a.7.7 0 0 1 1.106-.013l2.39 3.413a.7.7 0 0 0 1.097 0l2.402-3.432a.7.7 0 0 1 1.098 0l2.402 3.432a.7.7 0 0 0 1.098 0l2.389-3.413a.7.7 0 0 1 1.106.013L22 18.002\" />"),
    ZODIAC_ARIES(
        "zodiac-aries",
        "<path d=\"M12 7.5a4.5 4.5 0 1 1 5 4.5\" />\n  <path d=\"M7 12a4.5 4.5 0 1 1 5-4.5V21\" />"),
    ZODIAC_CANCER(
        "zodiac-cancer",
        "<path d=\"M21 14.5A9 6.5 0 0 1 5.5 19\" />\n  <path d=\"M3 9.5A9 6.5 0 0 1 18.5 5\" />\n  <circle cx=\"17.5\" cy=\"14.5\" r=\"3.5\" />\n  <circle cx=\"6.5\" cy=\"9.5\" r=\"3.5\" />"),
    ZODIAC_CAPRICORN(
        "zodiac-capricorn",
        "<path d=\"M11 21a3 3 0 0 0 3-3V6.5a1 1 0 0 0-7 0\" />\n  <path d=\"M7 19V6a3 3 0 0 0-3-3h0\" />\n  <circle cx=\"17\" cy=\"17\" r=\"3\" />"),
    ZODIAC_GEMINI(
        "zodiac-gemini",
        "<path d=\"M16 4.525v14.948\" />\n  <path d=\"M20 3A17 17 0 0 1 4 3\" />\n  <path d=\"M4 21a17 17 0 0 1 16 0\" />\n  <path d=\"M8 4.525v14.948\" />"),
    ZODIAC_LEO(
        "zodiac-leo",
        "<path d=\"M10 16c0-4-3-4.5-3-8a5 5 0 0 1 10 0c0 3.466-3 6.196-3 10a3 3 0 0 0 6 0\" />\n  <circle cx=\"7\" cy=\"16\" r=\"3\" />"),
    ZODIAC_LIBRA(
        "zodiac-libra",
        "<path d=\"M3 16h6.857c.162-.012.19-.323.038-.38a6 6 0 1 1 4.212 0c-.153.057-.125.368.038.38H21\" />\n  <path d=\"M3 20h18\" />"),
    ZODIAC_OPHIUCHUS(
        "zodiac-ophiuchus",
        "<path d=\"M3 10A6.06 6.06 0 0 1 12 10 A6.06 6.06 0 0 0 21 10\" />\n  <path d=\"M6 3v12a6 6 0 0 0 12 0V3\" />"),
    ZODIAC_PISCES(
        "zodiac-pisces",
        "<path d=\"M19 21a15 15 0 0 1 0-18\" />\n  <path d=\"M20 12H4\" />\n  <path d=\"M5 3a15 15 0 0 1 0 18\" />"),
    ZODIAC_SAGITTARIUS(
        "zodiac-sagittarius",
        "<path d=\"M15 3h6v6\" />\n  <path d=\"M21 3 3 21\" />\n  <path d=\"m9 9 6 6\" />"),
    ZODIAC_SCORPIO(
        "zodiac-scorpio",
        "<path d=\"M10 19V5.5a1 1 0 0 1 5 0V17a2 2 0 0 0 2 2h5l-3-3\" />\n  <path d=\"m22 19-3 3\" />\n  <path d=\"M5 19V5.5a1 1 0 0 1 5 0\" />\n  <path d=\"M5 5.5A2.5 2.5 0 0 0 2.5 3\" />"),
    ZODIAC_TAURUS(
        "zodiac-taurus",
        "<circle cx=\"12\" cy=\"15\" r=\"6\" />\n  <path d=\"M18 3A6 6 0 0 1 6 3\" />"),
    ZODIAC_VIRGO(
        "zodiac-virgo",
        "<path d=\"M11 5.5a1 1 0 0 1 5 0V16a5 5 0 0 0 5 5\" />\n  <path d=\"M16 11.5a1 1 0 0 1 5 0V16a5 5 0 0 1-5 5\" />\n  <path d=\"M6 19V6a3 3 0 0 0-3-3h0\" />\n  <path d=\"M6 5.5a1 1 0 0 1 5 0V19\" />");

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
  default LucideIcon balloon() {
    return LucideIcon.create(Icon.BALLOON);
  }

  default LucideIcon biceps_flexed() {
    return LucideIcon.create(Icon.BICEPS_FLEXED);
  }

  default LucideIcon chess_bishop_emoji() {
    return LucideIcon.create(Icon.CHESS_BISHOP);
  }

  default LucideIcon chess_king_emoji() {
    return LucideIcon.create(Icon.CHESS_KING);
  }

  default LucideIcon chess_knight_emoji() {
    return LucideIcon.create(Icon.CHESS_KNIGHT);
  }

  default LucideIcon chess_pawn_emoji() {
    return LucideIcon.create(Icon.CHESS_PAWN);
  }

  default LucideIcon chess_queen_emoji() {
    return LucideIcon.create(Icon.CHESS_QUEEN);
  }

  default LucideIcon chess_rook_emoji() {
    return LucideIcon.create(Icon.CHESS_ROOK);
  }

  default LucideIcon face_angry() {
    return LucideIcon.create(Icon.FACE_ANGRY);
  }

  default LucideIcon face_expressionless() {
    return LucideIcon.create(Icon.FACE_EXPRESSIONLESS);
  }

  default LucideIcon face_grinning() {
    return LucideIcon.create(Icon.FACE_GRINNING);
  }

  default LucideIcon face_neutral() {
    return LucideIcon.create(Icon.FACE_NEUTRAL);
  }

  default LucideIcon face_slightly_frowning_emoji() {
    return LucideIcon.create(Icon.FACE_SLIGHTLY_FROWNING);
  }

  default LucideIcon face_slightly_smiling_emoji() {
    return LucideIcon.create(Icon.FACE_SLIGHTLY_SMILING);
  }

  default LucideIcon face_slightly_smiling_plus_emoji() {
    return LucideIcon.create(Icon.FACE_SLIGHTLY_SMILING_PLUS);
  }

  default LucideIcon hand_fist_emoji() {
    return LucideIcon.create(Icon.HAND_FIST);
  }

  default LucideIcon hand_helping() {
    return LucideIcon.create(Icon.HAND_HELPING);
  }

  default LucideIcon hand_metal_emoji() {
    return LucideIcon.create(Icon.HAND_METAL);
  }

  default LucideIcon heart_emoji() {
    return LucideIcon.create(Icon.HEART);
  }

  default LucideIcon heart_crack() {
    return LucideIcon.create(Icon.HEART_CRACK);
  }

  default LucideIcon heart_handshake_emoji() {
    return LucideIcon.create(Icon.HEART_HANDSHAKE);
  }

  default LucideIcon leafy_green_emoji() {
    return LucideIcon.create(Icon.LEAFY_GREEN);
  }

  default LucideIcon party_popper() {
    return LucideIcon.create(Icon.PARTY_POPPER);
  }

  default LucideIcon ribbon_emoji() {
    return LucideIcon.create(Icon.RIBBON);
  }

  default LucideIcon salad() {
    return LucideIcon.create(Icon.SALAD);
  }

  default LucideIcon star_emoji() {
    return LucideIcon.create(Icon.STAR);
  }

  default LucideIcon star_check_emoji() {
    return LucideIcon.create(Icon.STAR_CHECK);
  }

  default LucideIcon star_minus_emoji() {
    return LucideIcon.create(Icon.STAR_MINUS);
  }

  default LucideIcon star_plus_emoji() {
    return LucideIcon.create(Icon.STAR_PLUS);
  }

  default LucideIcon star_x_emoji() {
    return LucideIcon.create(Icon.STAR_X);
  }

  default LucideIcon thumbs_down_emoji() {
    return LucideIcon.create(Icon.THUMBS_DOWN);
  }

  default LucideIcon thumbs_up_emoji() {
    return LucideIcon.create(Icon.THUMBS_UP);
  }

  default LucideIcon zodiac_aquarius_emoji() {
    return LucideIcon.create(Icon.ZODIAC_AQUARIUS);
  }

  default LucideIcon zodiac_aries_emoji() {
    return LucideIcon.create(Icon.ZODIAC_ARIES);
  }

  default LucideIcon zodiac_cancer_emoji() {
    return LucideIcon.create(Icon.ZODIAC_CANCER);
  }

  default LucideIcon zodiac_capricorn_emoji() {
    return LucideIcon.create(Icon.ZODIAC_CAPRICORN);
  }

  default LucideIcon zodiac_gemini_emoji() {
    return LucideIcon.create(Icon.ZODIAC_GEMINI);
  }

  default LucideIcon zodiac_leo_emoji() {
    return LucideIcon.create(Icon.ZODIAC_LEO);
  }

  default LucideIcon zodiac_libra_emoji() {
    return LucideIcon.create(Icon.ZODIAC_LIBRA);
  }

  default LucideIcon zodiac_ophiuchus_emoji() {
    return LucideIcon.create(Icon.ZODIAC_OPHIUCHUS);
  }

  default LucideIcon zodiac_pisces_emoji() {
    return LucideIcon.create(Icon.ZODIAC_PISCES);
  }

  default LucideIcon zodiac_sagittarius_emoji() {
    return LucideIcon.create(Icon.ZODIAC_SAGITTARIUS);
  }

  default LucideIcon zodiac_scorpio_emoji() {
    return LucideIcon.create(Icon.ZODIAC_SCORPIO);
  }

  default LucideIcon zodiac_taurus_emoji() {
    return LucideIcon.create(Icon.ZODIAC_TAURUS);
  }

  default LucideIcon zodiac_virgo_emoji() {
    return LucideIcon.create(Icon.ZODIAC_VIRGO);
  }
}
