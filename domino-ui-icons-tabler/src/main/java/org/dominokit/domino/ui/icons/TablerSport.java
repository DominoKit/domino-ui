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

/** Tabler Sport catalog category. */
public interface TablerSport {
  enum OutlineIcon implements TablerIconDefinition {
    ACROBATIC(
        "acrobatic",
        "<path d=\"M13.207 3l-6.735 2.462a1 1 0 0 0 -.364 1.646l1.892 1.892\" />\n  <path d=\"M10.5 8.25l1.5 -.25h3.174a2 2 0 0 1 1.411 .583l1.422 1.417\" />\n  <path d=\"M8 9c0 4.5 1.781 5.14 3 5.5\" />\n  <path d=\"M13.007 21h-1a1 1 0 0 1 -1 -1l-.007 -5.5\" />\n  <path d=\"M12.007 14a2 2 0 1 0 4 0a2 2 0 1 0 -4 0\" />"),
    BALL_AMERICAN_FOOTBALL(
        "ball-american-football",
        "<path d=\"M15 9l-6 6\" />\n  <path d=\"M10 12l2 2\" />\n  <path d=\"M12 10l2 2\" />\n  <path d=\"M8 21a5 5 0 0 0 -5 -5\" />\n  <path d=\"M16 3c-7.18 0 -13 5.82 -13 13a5 5 0 0 0 5 5c7.18 0 13 -5.82 13 -13a5 5 0 0 0 -5 -5\" />\n  <path d=\"M16 3a5 5 0 0 0 5 5\" />"),
    BALL_AMERICAN_FOOTBALL_OFF(
        "ball-american-football-off",
        "<path d=\"M15 9l-1 1m-2 2l-3 3\" />\n  <path d=\"M10 12l2 2\" />\n  <path d=\"M8 21a5 5 0 0 0 -5 -5\" />\n  <path d=\"M6.813 6.802a12.96 12.96 0 0 0 -3.813 9.198a5 5 0 0 0 5 5a12.96 12.96 0 0 0 9.186 -3.801m1.789 -2.227a12.94 12.94 0 0 0 2.025 -6.972a5 5 0 0 0 -5 -5a12.94 12.94 0 0 0 -6.967 2.022\" />\n  <path d=\"M16 3a5 5 0 0 0 5 5\" />\n  <path d=\"M3 3l18 18\" />"),
    BALL_BASEBALL(
        "ball-baseball",
        "<path d=\"M5.636 18.364a9 9 0 1 0 12.728 -12.728a9 9 0 0 0 -12.728 12.728\" />\n  <path d=\"M12.495 3.02a9 9 0 0 1 -9.475 9.475\" />\n  <path d=\"M20.98 11.505a9 9 0 0 0 -9.475 9.475\" />\n  <path d=\"M9 9l2 2\" />\n  <path d=\"M13 13l2 2\" />\n  <path d=\"M11 7l2 1\" />\n  <path d=\"M7 11l1 2\" />\n  <path d=\"M16 11l1 2\" />\n  <path d=\"M11 16l2 1\" />"),
    BALL_BASKETBALL(
        "ball-basketball",
        "<path d=\"M3 12a9 9 0 1 0 18 0a9 9 0 1 0 -18 0\" />\n  <path d=\"M5.65 5.65l12.7 12.7\" />\n  <path d=\"M5.65 18.35l12.7 -12.7\" />\n  <path d=\"M12 3a9 9 0 0 0 9 9\" />\n  <path d=\"M3 12a9 9 0 0 1 9 9\" />"),
    BALL_BOWLING(
        "ball-bowling",
        "<path d=\"M3 12a9 9 0 1 0 18 0a9 9 0 1 0 -18 0\" />\n  <path d=\"M11 9l0 .01\" />\n  <path d=\"M15 8l0 .01\" />\n  <path d=\"M14 12l0 .01\" />"),
    BALL_FOOTBALL(
        "ball-football",
        "<path d=\"M3 12a9 9 0 1 0 18 0a9 9 0 1 0 -18 0\" />\n  <path d=\"M12 7l4.76 3.45l-1.76 5.55h-6l-1.76 -5.55l4.76 -3.45\" />\n  <path d=\"M12 7v-4m3 13l2.5 3m-.74 -8.55l3.74 -1.45m-11.44 7.05l-2.56 2.95m.74 -8.55l-3.74 -1.45\" />"),
    BALL_FOOTBALL_OFF(
        "ball-football-off",
        "<path d=\"M20.041 16.046a9 9 0 0 0 -12.084 -12.09m-2.323 1.683a9 9 0 0 0 12.726 12.73\" />\n  <path d=\"M12 7l4.755 3.455l-.566 1.743l-.98 3.014l-.209 .788h-6l-1.755 -5.545l1.86 -1.351l2.313 -1.681l.582 -.423\" />\n  <path d=\"M12 7v-4\" />\n  <path d=\"M15 16l2.5 3\" />\n  <path d=\"M16.755 10.455l3.745 -1.455\" />\n  <path d=\"M9.061 16.045l-2.561 2.955\" />\n  <path d=\"M7.245 10.455l-3.745 -1.455\" />\n  <path d=\"M3 3l18 18\" />"),
    BALL_TENNIS(
        "ball-tennis",
        "<path d=\"M3 12a9 9 0 1 0 18 0a9 9 0 1 0 -18 0\" />\n  <path d=\"M6 5.3a9 9 0 0 1 0 13.4\" />\n  <path d=\"M18 5.3a9 9 0 0 0 0 13.4\" />"),
    BALL_VOLLEYBALL(
        "ball-volleyball",
        "<path d=\"M3 12a9 9 0 1 0 18 0a9 9 0 1 0 -18 0\" />\n  <path d=\"M12 12a8 8 0 0 0 8 4\" />\n  <path d=\"M7.5 13.5a12 12 0 0 0 8.5 6.5\" />\n  <path d=\"M12 12a8 8 0 0 0 -7.464 4.928\" />\n  <path d=\"M12.951 7.353a12 12 0 0 0 -9.88 4.111\" />\n  <path d=\"M12 12a8 8 0 0 0 -.536 -8.928\" />\n  <path d=\"M15.549 15.147a12 12 0 0 0 1.38 -10.611\" />"),
    BARBELL(
        "barbell",
        "<path d=\"M2 12h1\" />\n  <path d=\"M6 8h-2a1 1 0 0 0 -1 1v6a1 1 0 0 0 1 1h2\" />\n  <path d=\"M6 7v10a1 1 0 0 0 1 1h1a1 1 0 0 0 1 -1v-10a1 1 0 0 0 -1 -1h-1a1 1 0 0 0 -1 1\" />\n  <path d=\"M9 12h6\" />\n  <path d=\"M15 7v10a1 1 0 0 0 1 1h1a1 1 0 0 0 1 -1v-10a1 1 0 0 0 -1 -1h-1a1 1 0 0 0 -1 1\" />\n  <path d=\"M18 8h2a1 1 0 0 1 1 1v6a1 1 0 0 1 -1 1h-2\" />\n  <path d=\"M22 12h-1\" />"),
    BARBELL_OFF(
        "barbell-off",
        "<path d=\"M2 12h1\" />\n  <path d=\"M6 8h-2a1 1 0 0 0 -1 1v6a1 1 0 0 0 1 1h2\" />\n  <path d=\"M6.298 6.288a1 1 0 0 0 -.298 .712v10a1 1 0 0 0 1 1h1a1 1 0 0 0 1 -1v-8\" />\n  <path d=\"M9 12h3\" />\n  <path d=\"M15 15v2a1 1 0 0 0 1 1h1c.275 0 .523 -.11 .704 -.29m.296 -3.71v-7a1 1 0 0 0 -1 -1h-1a1 1 0 0 0 -1 1v4\" />\n  <path d=\"M18 8h2a1 1 0 0 1 1 1v6a1 1 0 0 1 -1 1\" />\n  <path d=\"M22 12h-1\" />\n  <path d=\"M3 3l18 18\" />"),
    BOW(
        "bow",
        "<path d=\"M17 3h4v4\" />\n  <path d=\"M21 3l-15 15\" />\n  <path d=\"M3 18h3v3\" />\n  <path d=\"M16.5 20c1.576 -1.576 2.5 -4.095 2.5 -6.5c0 -4.81 -3.69 -8.5 -8.5 -8.5c-2.415 0 -4.922 .913 -6.5 2.5l12.5 12.5\" />"),
    BOWLING(
        "bowling",
        "<path d=\"M7 11v.01\" />\n  <path d=\"M11 10v.01\" />\n  <path d=\"M10 14v.01\" />\n  <path d=\"M11.059 6.07a8 8 0 1 0 .32 15.81\" />\n  <path d=\"M15.969 9h4\" />\n  <path d=\"M14.969 5c0 1.5 1 2 1 4c0 2.5 -2 4.5 -2 7c0 2.6 1.9 6 1.9 6h4.1s2 -3.4 2 -6c0 -2.5 -2 -4.5 -2 -7c0 -2 1 -2.5 1 -4a3 3 0 1 0 -6 0\" />"),
    CHESS(
        "chess",
        "<path d=\"M12 3a3 3 0 0 1 3 3c0 1.113 -.6 2.482 -1.5 3l1.5 7h-6l1.5 -7c-.9 -.518 -1.5 -1.887 -1.5 -3a3 3 0 0 1 3 -3\" />\n  <path d=\"M8 9h8\" />\n  <path d=\"M6.684 16.772a1 1 0 0 0 -.684 .949v1.279a1 1 0 0 0 1 1h10a1 1 0 0 0 1 -1v-1.28a1 1 0 0 0 -.684 -.948l-2.316 -.772h-6l-2.316 .772\" />"),
    CHESS_BISHOP(
        "chess-bishop",
        "<path d=\"M8 16l-1.447 .724a1 1 0 0 0 -.553 .894v2.382h12v-2.382a1 1 0 0 0 -.553 -.894l-1.447 -.724h-8\" />\n  <path d=\"M11 4a1 1 0 1 0 2 0a1 1 0 1 0 -2 0\" />\n  <path d=\"M9.5 16c-1.667 0 -2.5 -1.669 -2.5 -3c0 -3.667 1.667 -6 5 -7c3.333 1 5 3.427 5 7c0 1.284 -.775 2.881 -2.325 3l-.175 0h-5\" />\n  <path d=\"M15 8l-3 3\" />\n  <path d=\"M12 5v1\" />"),
    CHESS_KING(
        "chess-king",
        "<path d=\"M8 16l-1.447 .724a1 1 0 0 0 -.553 .894v2.382h12v-2.382a1 1 0 0 0 -.553 -.894l-1.447 -.724h-8\" />\n  <path d=\"M8.5 16a3.5 3.5 0 1 1 3.163 -5h.674a3.5 3.5 0 1 1 3.163 5l-7 0\" />\n  <path d=\"M9 6h6\" />\n  <path d=\"M12 3v8\" />"),
    CHESS_KNIGHT(
        "chess-knight",
        "<path d=\"M8 16l-1.447 .724a1 1 0 0 0 -.553 .894v2.382h12v-2.382a1 1 0 0 0 -.553 -.894l-1.447 -.724h-8\" />\n  <path d=\"M9 3l1 3l-3.491 2.148a1 1 0 0 0 .524 1.852h2.967l-2.073 6h7.961l.112 -5c0 -3 -1.09 -5.983 -4 -7c-1.94 -.678 -2.94 -1.011 -3 -1\" />"),
    CHESS_QUEEN(
        "chess-queen",
        "<path d=\"M16 16l2 -11l-4 4l-2 -5l-2 5l-4 -4l2 11\" />\n  <path d=\"M8 16l-1.447 .724a1 1 0 0 0 -.553 .894v2.382h12v-2.382a1 1 0 0 0 -.553 -.894l-1.447 -.724h-8\" />\n  <path d=\"M11 4a1 1 0 1 0 2 0a1 1 0 1 0 -2 0\" />\n  <path d=\"M5 5a1 1 0 1 0 2 0a1 1 0 1 0 -2 0\" />\n  <path d=\"M17 5a1 1 0 1 0 2 0a1 1 0 1 0 -2 0\" />"),
    CHESS_ROOK(
        "chess-rook",
        "<path d=\"M8 16l-1.447 .724a1 1 0 0 0 -.553 .894v2.382h12v-2.382a1 1 0 0 0 -.553 -.894l-1.447 -.724h-8\" />\n  <path d=\"M8 16l1 -9h6l1 9\" />\n  <path d=\"M6 4l.5 3h11l.5 -3\" />\n  <path d=\"M10 4v3\" />\n  <path d=\"M14 4v3\" />"),
    CLIFF_JUMPING(
        "cliff-jumping",
        "<path d=\"M10.5 18l2.5 2l2 -2\" />\n  <path d=\"M18 21l3 -3l-4 -2l-2 -5\" />\n  <path d=\"M9 8l3 3l3 1l4 -2l3 -2\" />\n  <path d=\"M3 21v-1l2 -3l.5 -2.5l1.5 -2.5l-1 -5l1 -3l-1 -1l-2 .5l-2 -.5\" />\n  <path d=\"M13.007 8a2 2 0 1 0 4 0a2 2 0 1 0 -4 0\" />"),
    CRICKET(
        "cricket",
        "<path d=\"M11.105 18.79l-1 .992a4.159 4.159 0 0 1 -6.038 -5.715l.157 -.166l8.282 -8.401l1.5 1.5l3.45 -3.391a2.08 2.08 0 0 1 3.057 2.815l-.116 .126l-3.391 3.45l1.5 1.5l-3.668 3.617\" />\n  <path d=\"M10.5 7.5l6 6\" />\n  <path d=\"M11 18a3 3 0 1 0 6 0a3 3 0 1 0 -6 0\" />"),
    CURLING(
        "curling",
        "<path d=\"M4 13a4 4 0 0 1 4 -4h8a4 4 0 0 1 4 4v2a4 4 0 0 1 -4 4h-8a4 4 0 0 1 -4 -4l0 -2\" />\n  <path d=\"M4 14h16\" />\n  <path d=\"M8 5h6a2 2 0 0 1 2 2v2\" />"),
    DISC_GOLF(
        "disc-golf",
        "<path d=\"M5 5h14\" />\n  <path d=\"M6 5c.32 6.744 2.74 9.246 6 10\" />\n  <path d=\"M18 5c-.32 6.744 -2.74 9.246 -6 10\" />\n  <path d=\"M10 5c0 4.915 .552 7.082 2 10\" />\n  <path d=\"M14 5c0 4.915 -.552 7.082 -2 10\" />\n  <path d=\"M12 15v6\" />\n  <path d=\"M12 3v2\" />\n  <path d=\"M7 16c.64 .64 1.509 1 2.414 1h5.172c.905 0 1.774 -.36 2.414 -1\" />\n  <path d=\"M11 21h2\" />"),
    DUMBBELL(
        "dumbbell",
        "<path d=\"M7.026 9.61l-.95 -4.18a2 2 0 0 1 1.95 -2.43h8a2 2 0 0 1 2 2.43l-1 4.2\" />\n  <path d=\"M9.026 17.001h6\" />\n  <path d=\"M18.906 20.06a7.92 7.92 0 0 0 1 -5.33a8 8 0 1 0 -14.77 5.33a2 2 0 0 0 1.71 .94h10.36a2 2 0 0 0 1.7 -.94\" />"),
    EXERCISE_BALL(
        "exercise-ball",
        "<path d=\"M5.59 18.31a15.57 15.57 0 0 1 4.51 -9.21a15.9 15.9 0 0 1 7.43 -4.19\" />\n  <path d=\"M11.55 21a9.34 9.34 0 0 1 2.79 -7.65a9.5 9.5 0 0 1 6.54 -2.85\" />\n  <path d=\"M3 12a9 9 0 1 0 18 0a9 9 0 1 0 -18 0\" />"),
    GOLF(
        "golf",
        "<path d=\"M12 18v-15l7 4l-7 4\" />\n  <path d=\"M9 17.67c-.62 .36 -1 .82 -1 1.33c0 1.1 1.8 2 4 2s4 -.9 4 -2c0 -.5 -.38 -.97 -1 -1.33\" />"),
    GOLF_OFF(
        "golf-off",
        "<path d=\"M12 18v-6m0 -4v-5l7 4l-5.07 2.897\" />\n  <path d=\"M9 17.67c-.62 .36 -1 .82 -1 1.33c0 1.1 1.8 2 4 2s4 -.9 4 -2c0 -.5 -.38 -.97 -1 -1.33\" />\n  <path d=\"M3 3l18 18\" />"),
    HELMET(
        "helmet",
        "<path d=\"M12 4a9 9 0 0 1 5.656 16h-11.312a9 9 0 0 1 5.656 -16\" />\n  <path d=\"M20 9h-8.8a1 1 0 0 0 -.968 1.246c.507 2 1.596 3.418 3.268 4.254c2 1 4.333 1.5 7 1.5\" />"),
    HELMET_OFF(
        "helmet-off",
        "<path d=\"M8.633 4.654a9 9 0 0 1 11.718 11.7m-1.503 2.486a9.008 9.008 0 0 1 -1.192 1.16h-11.312a9 9 0 0 1 -.185 -13.847\" />\n  <path d=\"M20 9h-7m-2.768 1.246c.507 2 1.596 3.418 3.268 4.254c.524 .262 1.07 .49 1.64 .683\" />\n  <path d=\"M3 3l18 18\" />"),
    HULA_HOOP(
        "hula-hoop",
        "<path d=\"M10 5a2 2 0 1 0 4 0a2 2 0 1 0 -4 0\" />\n  <path d=\"M4 6l2 1.5l6 .5l6 -.5l2 -1.5\" />\n  <path d=\"M16 21l-4 -8v-5\" />\n  <path d=\"M8 21l4 -8\" />\n  <path d=\"M9.007 10.999c-2.37 .32 -4.007 1.201 -4.007 2.001c0 1.105 3.134 2 7 2s7 -.895 7 -2c0 -.798 -1.636 -1.679 -4 -2\" />"),
    ICE_SKATING(
        "ice-skating",
        "<path d=\"M5.905 5h3.418a1 1 0 0 1 .928 .629l1.143 2.856a3 3 0 0 0 2.207 1.83l4.717 .926a2.084 2.084 0 0 1 1.682 2.045v.714a1 1 0 0 1 -1 1h-13.895a1 1 0 0 1 -1 -1.1l.8 -8a1 1 0 0 1 1 -.9\" />\n  <path d=\"M3 19h17a1 1 0 0 0 1 -1\" />\n  <path d=\"M9 15v4\" />\n  <path d=\"M15 15v4\" />"),
    JUMP_ROPE(
        "jump-rope",
        "<path d=\"M6 14v-6a3 3 0 1 1 6 0v8a3 3 0 0 0 6 0v-6\" />\n  <path d=\"M16 5a2 2 0 0 1 2 -2a2 2 0 0 1 2 2v3a2 2 0 0 1 -2 2a2 2 0 0 1 -2 -2l0 -3\" />\n  <path d=\"M4 16a2 2 0 0 1 2 -2a2 2 0 0 1 2 2v3a2 2 0 0 1 -2 2a2 2 0 0 1 -2 -2l0 -3\" />"),
    KARATE(
        "karate",
        "<path d=\"M3 9l4.5 1l3 2.5\" />\n  <path d=\"M13 21v-8l3 -5.5\" />\n  <path d=\"M8 4.5l4 2l4 1l4 3.5l-2 3.5\" />\n  <path d=\"M15.007 5a2 2 0 1 0 4 0a2 2 0 1 0 -4 0\" />"),
    KAYAK(
        "kayak",
        "<path d=\"M6.414 6.414a2 2 0 0 0 0 -2.828l-1.414 -1.414l-2.828 2.828l1.414 1.414a2 2 0 0 0 2.828 0\" />\n  <path d=\"M17.586 17.586a2 2 0 0 0 0 2.828l1.414 1.414l2.828 -2.828l-1.414 -1.414a2 2 0 0 0 -2.828 0\" />\n  <path d=\"M6.5 6.5l11 11\" />\n  <path d=\"M22 2.5c-9.983 2.601 -17.627 7.952 -20 19.5c9.983 -2.601 17.627 -7.952 20 -19.5\" />\n  <path d=\"M6.5 12.5l5 5\" />\n  <path d=\"M12.5 6.5l5 5\" />"),
    MEDAL(
        "medal",
        "<path d=\"M12 4v3m-4 -3v6m8 -6v6\" />\n  <path d=\"M12 18.5l-3 1.5l.5 -3.5l-2 -2l3 -.5l1.5 -3l1.5 3l3 .5l-2 2l.5 3.5l-3 -1.5\" />"),
    MEDAL_2(
        "medal-2",
        "<path d=\"M9 3h6l3 7l-6 2l-6 -2l3 -7\" />\n  <path d=\"M12 12l-3 -9\" />\n  <path d=\"M15 11l-3 -8\" />\n  <path d=\"M12 19.5l-3 1.5l.5 -3.5l-2 -2l3 -.5l1.5 -3l1.5 3l3 .5l-2 2l.5 3.5l-3 -1.5\" />"),
    MEEPLE(
        "meeple",
        "<path d=\"M9 20h-5a1 1 0 0 1 -1 -1c0 -2 3.378 -4.907 4 -6c-1 0 -4 -.5 -4 -2c0 -2 4 -3.5 6 -4c0 -1.5 .5 -4 3 -4s3 2.5 3 4c2 .5 6 2 6 4c0 1.5 -3 2 -4 2c.622 1.093 4 4 4 6a1 1 0 0 1 -1 1h-5c-1 0 -2 -4 -3 -4s-2 4 -3 4\" />"),
    OLYMPIC_TORCH(
        "olympic-torch",
        "<path d=\"M14 21h-4c0 -4.364 -1 -7 -2 -11q 4 2 8 0c-1 4 -2 6.636 -2 11\" />\n  <path d=\"M11 2c0 2.5 -1 2.66 -1 4a1.9 1.9 0 0 0 2 2a1.87 1.87 0 0 0 2 -2c0 -1.41 -1 -3 -3 -4\" />"),
    OLYMPICS(
        "olympics",
        "<path d=\"M3 9a3 3 0 1 0 6 0a3 3 0 1 0 -6 0\" />\n  <path d=\"M15 9a3 3 0 1 0 6 0a3 3 0 1 0 -6 0\" />\n  <path d=\"M9 9a3 3 0 1 0 6 0a3 3 0 1 0 -6 0\" />\n  <path d=\"M6 15a3 3 0 1 0 6 0a3 3 0 1 0 -6 0\" />\n  <path d=\"M12 15a3 3 0 1 0 6 0a3 3 0 1 0 -6 0\" />"),
    OLYMPICS_OFF(
        "olympics-off",
        "<path d=\"M6 6a3 3 0 1 0 3 3\" />\n  <path d=\"M15 9a3 3 0 1 0 6 0a3 3 0 1 0 -6 0\" />\n  <path d=\"M9 9a3 3 0 0 0 3 3m2.566 -1.445a3 3 0 0 0 -4.135 -4.113\" />\n  <path d=\"M6 15a3 3 0 1 0 6 0a3 3 0 1 0 -6 0\" />\n  <path d=\"M12.878 12.88a3 3 0 0 0 4.239 4.247m.586 -3.431a3.012 3.012 0 0 0 -1.43 -1.414\" />\n  <path d=\"M3 3l18 18\" />"),
    PING_PONG(
        "ping-pong",
        "<path d=\"M12.718 20.713a7.64 7.64 0 0 1 -7.48 -12.755l.72 -.72a7.643 7.643 0 0 1 9.105 -1.283l2.387 -2.345a2.08 2.08 0 0 1 3.057 2.815l-.116 .126l-2.346 2.387a7.644 7.644 0 0 1 -1.052 8.864\" />\n  <path d=\"M11 18a3 3 0 1 0 6 0a3 3 0 1 0 -6 0\" />\n  <path d=\"M9.3 5.3l9.4 9.4\" />"),
    PLAY_BASKETBALL(
        "play-basketball",
        "<path d=\"M9.007 5a2 2 0 1 0 4 0a2 2 0 1 0 -4 0\" />\n  <path d=\"M5 21l3 -3l.75 -1.5\" />\n  <path d=\"M14 21v-4l-4 -3l.5 -6\" />\n  <path d=\"M5 12l1 -3l4.5 -1l3.5 3l4 -.5\" />\n  <path d=\"M18.007 15.5a1.5 1.5 0 1 0 3 0a1.5 1.5 0 1 0 -3 0\" />"),
    PLAY_FOOTBALL(
        "play-football",
        "<path d=\"M3 17l5 1l.75 -1.5\" />\n  <path d=\"M14 21v-4l-4 -3l1 -6\" />\n  <path d=\"M6 12v-3l5 -1l3 3l3 1\" />\n  <path d=\"M18.007 19.5a1.5 1.5 0 1 0 3 0a1.5 1.5 0 1 0 -3 0\" />\n  <path d=\"M10.007 5a2 2 0 1 0 4 0a2 2 0 1 0 -4 0\" />"),
    PLAY_HANDBALL(
        "play-handball",
        "<path d=\"M13 21l3.5 -2l-4.5 -4l2 -4.5\" />\n  <path d=\"M5 7l4 3l5 .5l4 2.5l2.5 3\" />\n  <path d=\"M4 20l5 -1l1.5 -2\" />\n  <path d=\"M13.007 8a2 2 0 1 0 4 0a2 2 0 1 0 -4 0\" />\n  <path d=\"M6.007 3.5a1.5 1.5 0 1 0 3 0a1.5 1.5 0 1 0 -3 0\" />"),
    PLAY_VOLLEYBALL(
        "play-volleyball",
        "<path d=\"M11.007 5a2 2 0 1 0 4 0a2 2 0 1 0 -4 0\" />\n  <path d=\"M19.007 9.5a1.5 1.5 0 1 0 3 0a1.5 1.5 0 1 0 -3 0\" />\n  <path d=\"M2 16l5 1l.5 -2.5\" />\n  <path d=\"M11.5 21l2.5 -5.5l-5.5 -3.5l3.5 -4l3 4l4 2\" />"),
    POOL(
        "pool",
        "<path d=\"M2 20a2.4 2.4 0 0 0 2 1a2.4 2.4 0 0 0 2 -1a2.4 2.4 0 0 1 2 -1a2.4 2.4 0 0 1 2 1a2.4 2.4 0 0 0 2 1a2.4 2.4 0 0 0 2 -1a2.4 2.4 0 0 1 2 -1a2.4 2.4 0 0 1 2 1a2.4 2.4 0 0 0 2 1a2.4 2.4 0 0 0 2 -1\" />\n  <path d=\"M2 16a2.4 2.4 0 0 0 2 1a2.4 2.4 0 0 0 2 -1a2.4 2.4 0 0 1 2 -1a2.4 2.4 0 0 1 2 1a2.4 2.4 0 0 0 2 1a2.4 2.4 0 0 0 2 -1a2.4 2.4 0 0 1 2 -1a2.4 2.4 0 0 1 2 1a2.4 2.4 0 0 0 2 1a2.4 2.4 0 0 0 2 -1\" />\n  <path d=\"M15 12v-7.5a1.5 1.5 0 0 1 3 0\" />\n  <path d=\"M9 12v-7.5a1.5 1.5 0 0 0 -3 0\" />\n  <path d=\"M15 5l-6 0\" />\n  <path d=\"M9 10l6 0\" />"),
    POOL_OFF(
        "pool-off",
        "<path d=\"M2 20a2.4 2.4 0 0 0 2 1a2.4 2.4 0 0 0 2 -1a2.4 2.4 0 0 1 2 -1a2.4 2.4 0 0 1 2 1a2.4 2.4 0 0 0 2 1a2.4 2.4 0 0 0 2 -1a2.4 2.4 0 0 1 2 -1a2.4 2.4 0 0 1 2 1a2.4 2.4 0 0 0 2 1c.303 0 .6 -.045 .876 -.146\" />\n  <path d=\"M2 16a2.4 2.4 0 0 0 2 1a2.4 2.4 0 0 0 2 -1a2.4 2.4 0 0 1 2 -1a2.4 2.4 0 0 1 2 1a2.4 2.4 0 0 0 2 1a2.4 2.4 0 0 0 2 -1a2.4 2.4 0 0 1 1.13 -.856m5.727 1.717a2.4 2.4 0 0 0 1.143 -.861\" />\n  <path d=\"M15 11v-6.5a1.5 1.5 0 0 1 3 0\" />\n  <path d=\"M9 12v-3m0 -4v-.5a1.5 1.5 0 0 0 -1.936 -1.436\" />\n  <path d=\"M15 5h-6\" />\n  <path d=\"M9 10h1m4 0h1\" />\n  <path d=\"M3 3l18 18\" />"),
    RINGS(
        "rings",
        "<path d=\"M4 17a3 3 0 1 0 6 0a3 3 0 1 0 -6 0\" />\n  <path d=\"M14 17a3 3 0 1 0 6 0a3 3 0 1 0 -6 0\" />\n  <path d=\"M7 15v-11\" />\n  <path d=\"M17 15v-11\" />\n  <path d=\"M3 4h18\" />"),
    ROLLER_SKATING(
        "roller-skating",
        "<path d=\"M5.905 5h3.418a1 1 0 0 1 .928 .629l1.143 2.856a3 3 0 0 0 2.207 1.83l4.717 .926a2.084 2.084 0 0 1 1.682 2.045v.714a1 1 0 0 1 -1 1h-13.895a1 1 0 0 1 -1 -1.1l.8 -8a1 1 0 0 1 1 -.9\" />\n  <path d=\"M6 17a2 2 0 1 0 4 0a2 2 0 1 0 -4 0\" />\n  <path d=\"M14 17a2 2 0 1 0 4 0a2 2 0 1 0 -4 0\" />"),
    RUGBY(
        "rugby",
        "<path d=\"M14 15h-4v6h4v-6\" />\n  <path d=\"M12 15v-4\" />\n  <path d=\"M8 21h8\" />\n  <path d=\"M19 3v8h-14v-8\" />"),
    RUN(
        "run",
        "<path d=\"M11.007 5a2 2 0 1 0 4 0a2 2 0 1 0 -4 0\" />\n  <path d=\"M4 17l5 1l.75 -1.5\" />\n  <path d=\"M15 21v-4l-4 -3l1 -6\" />\n  <path d=\"M7 12v-3l5 -1l3 3l3 1\" />"),
    RUN_SPRINT(
        "run-sprint",
        "<path d=\"M14.007 5a2 2 0 1 0 4 0a2 2 0 0 0 -4 0\" />\n  <path d=\"M7 17l5 1l.75 -1.5\" />\n  <path d=\"M18 21v-4l-4 -3l1 -6\" />\n  <path d=\"M10 12v-3l5 -1l3 3l3 1\" />\n  <path d=\"M10 5h-4\" />\n  <path d=\"M6 10h-4\" />"),
    SCOREBOARD(
        "scoreboard",
        "<path d=\"M3 7a2 2 0 0 1 2 -2h14a2 2 0 0 1 2 2v10a2 2 0 0 1 -2 2h-14a2 2 0 0 1 -2 -2v-10\" />\n  <path d=\"M12 5v2\" />\n  <path d=\"M12 10v1\" />\n  <path d=\"M12 14v1\" />\n  <path d=\"M12 18v1\" />\n  <path d=\"M7 3v2\" />\n  <path d=\"M17 3v2\" />\n  <path d=\"M15 10.5v3a1.5 1.5 0 0 0 3 0v-3a1.5 1.5 0 0 0 -3 0\" />\n  <path d=\"M6 9h1.5a1.5 1.5 0 0 1 0 3h-.5h.5a1.5 1.5 0 0 1 0 3h-1.5\" />"),
    SCUBA_DIVING(
        "scuba-diving",
        "<path d=\"M19 12a1 1 0 1 0 2 0a1 1 0 0 0 -2 0\" />\n  <path d=\"M2 2l3 3l1.5 4l3.5 2l6 2l1 4l2.5 3\" />\n  <path d=\"M11 8l4.5 1.5\" />"),
    SCUBA_DIVING_TANK(
        "scuba-diving-tank",
        "<path d=\"M8 11a4 4 0 1 1 8 0v5h-8l0 -5\" />\n  <path d=\"M8 16v3a2 2 0 0 0 2 2h4a2 2 0 0 0 2 -2v-3\" />\n  <path d=\"M9 4h6\" />\n  <path d=\"M12 7v-3\" />\n  <path d=\"M7 4a1 1 0 1 0 2 0a1 1 0 1 0 -2 0\" />\n  <path d=\"M11.5 4a.5 .5 0 1 0 1 0a.5 .5 0 1 0 -1 0\" fill=\"currentColor\" />"),
    SCUBA_MASK(
        "scuba-mask",
        "<path d=\"M4 7h12a1 1 0 0 1 1 1v4.5a2.5 2.5 0 0 1 -2.5 2.5h-.5a2 2 0 0 1 -2 -2a2 2 0 1 0 -4 0a2 2 0 0 1 -2 2h-.5a2.5 2.5 0 0 1 -2.5 -2.5v-4.5a1 1 0 0 1 1 -1\" />\n  <path d=\"M10 17a2 2 0 0 0 2 2h3.5a5.5 5.5 0 0 0 5.5 -5.5v-9.5\" />"),
    SCUBA_MASK_OFF(
        "scuba-mask-off",
        "<path d=\"M11 7h5a1 1 0 0 1 1 1v4.5c0 .154 -.014 .304 -.04 .45m-2 2.007c-.15 .028 -.305 .043 -.463 .043h-.5a2 2 0 0 1 -2 -2a2 2 0 1 0 -4 0a2 2 0 0 1 -2 2h-.5a2.5 2.5 0 0 1 -2.5 -2.5v-4.5a1 1 0 0 1 1 -1h3\" />\n  <path d=\"M10 17a2 2 0 0 0 2 2h3.5a5.475 5.475 0 0 0 2.765 -.744m2 -2c.47 -.81 .739 -1.752 .739 -2.756v-9.5\" />\n  <path d=\"M3 3l18 18\" />"),
    SKATEBOARDING(
        "skateboarding",
        "<path d=\"M5.5 15h3.5l.75 -1.5\" />\n  <path d=\"M14 19v-5l-2.5 -3l2.5 -4\" />\n  <path d=\"M8 8l3 -1h4l1 3h3\" />\n  <path d=\"M17.5 21a.5 .5 0 1 0 0 -1a.5 .5 0 0 0 0 1\" />\n  <path d=\"M3 18c0 .552 .895 1 2 1h14c1.105 0 2 -.448 2 -1\" />\n  <path d=\"M6.5 21a.5 .5 0 1 0 0 -1a.5 .5 0 0 0 0 1\" />\n  <path d=\"M14.007 4a2 2 0 1 0 4 0a2 2 0 1 0 -4 0\" />"),
    SKI_JUMPING(
        "ski-jumping",
        "<path d=\"M17 17.5l-5 -4.5v-6l5 4\" />\n  <path d=\"M7 17.5l5 -4.5\" />\n  <path d=\"M15.103 21.58l6.762 -14.502a2 2 0 0 0 -.968 -2.657\" />\n  <path d=\"M8.897 21.58l-6.762 -14.503a2 2 0 0 1 .968 -2.657\" />\n  <path d=\"M7 11l5 -4\" />\n  <path d=\"M10.007 4a2 2 0 1 0 4 0a2 2 0 1 0 -4 0\" />"),
    SOCCER_FIELD(
        "soccer-field",
        "<path d=\"M9 12a3 3 0 1 0 6 0a3 3 0 1 0 -6 0\" />\n  <path d=\"M3 9h3v6h-3l0 -6\" />\n  <path d=\"M18 9h3v6h-3l0 -6\" />\n  <path d=\"M3 7a2 2 0 0 1 2 -2h14a2 2 0 0 1 2 2v10a2 2 0 0 1 -2 2h-14a2 2 0 0 1 -2 -2v-10\" />\n  <path d=\"M12 5l0 14\" />"),
    SPORT_BILLIARD(
        "sport-billiard",
        "<path d=\"M10 10a2 2 0 1 0 4 0a2 2 0 1 0 -4 0\" />\n  <path d=\"M10 14a2 2 0 1 0 4 0a2 2 0 1 0 -4 0\" />\n  <path d=\"M4 12a8 8 0 1 0 16 0a8 8 0 1 0 -16 0\" />"),
    STRETCHING(
        "stretching",
        "<path d=\"M15 5a1 1 0 1 0 2 0a1 1 0 1 0 -2 0\" />\n  <path d=\"M5 20l5 -.5l1 -2\" />\n  <path d=\"M18 20v-5h-5.5l2.5 -6.5l-5.5 1l1.5 2\" />"),
    STRETCHING_2(
        "stretching-2",
        "<path d=\"M6.5 21l3.5 -5\" />\n  <path d=\"M5 11l7 -2\" />\n  <path d=\"M16 21l-4 -7v-5l7 -4\" />\n  <path d=\"M9.007 6a2 2 0 1 0 4 0a2 2 0 1 0 -4 0\" />"),
    SWIMMING(
        "swimming",
        "<path d=\"M15 9a1 1 0 1 0 2 0a1 1 0 1 0 -2 0\" />\n  <path d=\"M6 11l4 -2l3.5 3l-1.5 2\" />\n  <path d=\"M3 16.75a2.4 2.4 0 0 0 1 .25a2.4 2.4 0 0 0 2 -1a2.4 2.4 0 0 1 2 -1a2.4 2.4 0 0 1 2 1a2.4 2.4 0 0 0 2 1a2.4 2.4 0 0 0 2 -1a2.4 2.4 0 0 1 2 -1a2.4 2.4 0 0 1 2 1a2.4 2.4 0 0 0 2 1a2.4 2.4 0 0 0 1 -.25\" />"),
    TARGET_2(
        "target-2",
        "<path d=\"M17 21l-1.74 -6\" />\n  <path d=\"M7 21l1.74 -6\" />\n  <path d=\"M12 4v-1\" />\n  <path d=\"M14 10a2 2 0 1 0 -4 0a2 2 0 0 0 4 0\" />\n  <path d=\"M18 10a6 6 0 1 0 -12 0a6 6 0 0 0 12 0\" />"),
    TARGET_ARROW(
        "target-arrow",
        "<path d=\"M11 12a1 1 0 1 0 2 0a1 1 0 1 0 -2 0\" />\n  <path d=\"M12 7a5 5 0 1 0 5 5\" />\n  <path d=\"M13 3.055a9 9 0 1 0 7.941 7.945\" />\n  <path d=\"M15 6v3h3l3 -3h-3v-3l-3 3\" />\n  <path d=\"M15 9l-3 3\" />"),
    TIC_TAC(
        "tic-tac",
        "<path d=\"M4 6a2 2 0 1 0 4 0a2 2 0 1 0 -4 0\" />\n  <path d=\"M3 12h18\" />\n  <path d=\"M12 3v18\" />\n  <path d=\"M4 16l4 4\" />\n  <path d=\"M4 20l4 -4\" />\n  <path d=\"M16 4l4 4\" />\n  <path d=\"M16 8l4 -4\" />\n  <path d=\"M16 18a2 2 0 1 0 4 0a2 2 0 1 0 -4 0\" />"),
    TOURNAMENT(
        "tournament",
        "<path d=\"M2 4a2 2 0 1 0 4 0a2 2 0 1 0 -4 0\" />\n  <path d=\"M18 10a2 2 0 1 0 4 0a2 2 0 1 0 -4 0\" />\n  <path d=\"M2 12a2 2 0 1 0 4 0a2 2 0 1 0 -4 0\" />\n  <path d=\"M2 20a2 2 0 1 0 4 0a2 2 0 1 0 -4 0\" />\n  <path d=\"M6 12h3a1 1 0 0 1 1 1v6a1 1 0 0 1 -1 1h-3\" />\n  <path d=\"M6 4h7a1 1 0 0 1 1 1v10a1 1 0 0 1 -1 1h-2\" />\n  <path d=\"M14 10h4\" />"),
    TREADMILL(
        "treadmill",
        "<path d=\"M10 3a1 1 0 1 0 2 0a1 1 0 0 0 -2 0\" />\n  <path d=\"M3 14l4 1l.5 -.5\" />\n  <path d=\"M12 18v-3l-3 -2.923l.75 -5.077\" />\n  <path d=\"M6 10v-2l4 -1l2.5 2.5l2.5 .5\" />\n  <path d=\"M21 22a1 1 0 0 0 -1 -1h-16a1 1 0 0 0 -1 1\" />\n  <path d=\"M18 21l1 -11l2 -1\" />"),
    TREKKING(
        "trekking",
        "<path d=\"M11 4a1 1 0 1 0 2 0a1 1 0 1 0 -2 0\" />\n  <path d=\"M7 21l2 -4\" />\n  <path d=\"M13 21v-4l-3 -3l1 -6l3 4l3 2\" />\n  <path d=\"M10 14l-1.827 -1.218a2 2 0 0 1 -.831 -2.15l.28 -1.117a2 2 0 0 1 1.939 -1.515h1.439l4 1l3 -2\" />\n  <path d=\"M17 12v9\" />\n  <path d=\"M16 20h2\" />"),
    TROPHY(
        "trophy",
        "<path d=\"M8 21l8 0\" />\n  <path d=\"M12 17l0 4\" />\n  <path d=\"M7 4l10 0\" />\n  <path d=\"M17 4v8a5 5 0 0 1 -10 0v-8\" />\n  <path d=\"M3 9a2 2 0 1 0 4 0a2 2 0 1 0 -4 0\" />\n  <path d=\"M17 9a2 2 0 1 0 4 0a2 2 0 1 0 -4 0\" />"),
    TROPHY_OFF(
        "trophy-off",
        "<path d=\"M8 21h8\" />\n  <path d=\"M12 17v4\" />\n  <path d=\"M8 4h9\" />\n  <path d=\"M17 4v8c0 .31 -.028 .612 -.082 .905m-1.384 2.632a5 5 0 0 1 -8.534 -3.537v-5\" />\n  <path d=\"M3 9a2 2 0 1 0 4 0a2 2 0 1 0 -4 0\" />\n  <path d=\"M17 9a2 2 0 1 0 4 0a2 2 0 1 0 -4 0\" />\n  <path d=\"M3 3l18 18\" />"),
    WALK(
        "walk",
        "<path d=\"M12 4a1 1 0 1 0 2 0a1 1 0 1 0 -2 0\" />\n  <path d=\"M7 21l3 -4\" />\n  <path d=\"M16 21l-2 -4l-3 -3l1 -6\" />\n  <path d=\"M6 12l2 -3l4 -1l3 3l3 1\" />"),
    WATERPOLO(
        "waterpolo",
        "<path d=\"M5 8l3 4l5 1l7 -1\" />\n  <path d=\"M3 18.75a2.4 2.4 0 0 0 1 .25a2.4 2.4 0 0 0 2 -1a2.4 2.4 0 0 1 2 -1a2.4 2.4 0 0 1 2 1a2.4 2.4 0 0 0 2 1a2.4 2.4 0 0 0 2 -1a2.4 2.4 0 0 1 2 -1a2.4 2.4 0 0 1 2 1a2.4 2.4 0 0 0 2 1a2.4 2.4 0 0 0 1 -.25\" />\n  <path d=\"M12 16l1 -3\" />\n  <path d=\"M11.007 9a2 2 0 1 0 4 0a2 2 0 1 0 -4 0\" />\n  <path d=\"M5.007 3.5a1.5 1.5 0 1 0 3 0a1.5 1.5 0 1 0 -3 0\" />"),
    YOGA(
        "yoga",
        "<path d=\"M4 20h4l1.5 -3\" />\n  <path d=\"M17 20l-1 -5h-5l1 -7\" />\n  <path d=\"M4 10l4 -1l4 -1l4 1.5l4 1.5\" />\n  <path d=\"M10.007 5a2 2 0 1 0 4 0a2 2 0 1 0 -4 0\" />");

    private final String catalogName;
    private final String svg;

    OutlineIcon(String catalogName, String svg) {
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

  enum FilledIcon implements TablerIconDefinition {
    BALL_BOWLING(
        "ball-bowling",
        "<path d=\"M17 3.34a10 10 0 1 1 -10 17.32a10 10 0 0 1 10 -17.32m-3 7.66a1 1 0 0 0 -1 1v.01a1 1 0 0 0 2 0v-.01a1 1 0 0 0 -1 -1m-3 -3a1 1 0 0 0 -1 1v.01a1 1 0 0 0 2 0v-.01a1 1 0 0 0 -1 -1m4 -1a1 1 0 0 0 -1 1v.01a1 1 0 0 0 2 0v-.01a1 1 0 0 0 -1 -1\" />"),
    BARBELL(
        "barbell",
        "<path d=\"M4 7a1 1 0 0 1 1 1v8a1 1 0 0 1 -2 0v-3h-1a1 1 0 0 1 0 -2h1v-3a1 1 0 0 1 1 -1\" />\n  <path d=\"M20 7a1 1 0 0 1 1 1v3h1a1 1 0 0 1 0 2h-1v3a1 1 0 0 1 -2 0v-8a1 1 0 0 1 1 -1\" />\n  <path d=\"M16 5a2 2 0 0 1 2 2v10a2 2 0 1 1 -4 0v-4h-4v4a2 2 0 1 1 -4 0v-10a2 2 0 1 1 4 0v4h4v-4a2 2 0 0 1 2 -2\" />"),
    BOW(
        "bow",
        "<path d=\"M21 2l.081 .003l.12 .017l.111 .03l.111 .044l.098 .052l.096 .067l.09 .08q .054 .053 .097 .112l.071 .11l.031 .062l.034 .081l.024 .076l.03 .148l.006 .118v4a1 1 0 0 1 -2 0v-1.586l-2.07 2.07c1.301 1.624 2.07 3.706 2.07 6.016c0 2.703 -1.047 5.462 -2.793 7.207a1 1 0 0 1 -1.414 0l-5.543 -5.542l-3.25 3.249v2.586a1 1 0 0 1 -2 0v-2h-2a1 1 0 0 1 -.993 -.883l-.007 -.117a1 1 0 0 1 1 -1h2.584l3.251 -3.25l-5.542 -5.543a1 1 0 0 1 -.002 -1.412c1.745 -1.755 4.489 -2.795 7.209 -2.795c2.31 0 4.393 .768 6.015 2.07l2.069 -2.07h-1.584a1 1 0 0 1 -.993 -.883l-.007 -.117a1 1 0 0 1 1 -1zm-4.495 6.91l-4.09 4.09l4.595 4.594a9.1 9.1 0 0 0 .985 -3.795l.005 -.299c0 -1.754 -.55 -3.336 -1.495 -4.59m-6.005 -2.91c-1.44 0 -2.89 .36 -4.098 .987l4.598 4.598l4.09 -4.09c-1.254 -.945 -2.836 -1.495 -4.59 -1.495\" />"),
    CHESS(
        "chess",
        "<path d=\"M12 2a4 4 0 0 1 4 4a5.03 5.03 0 0 1 -.438 2.001l.438 -.001a1 1 0 0 1 .117 1.993l-.117 .007h-1.263l1.24 5.79a1 1 0 0 1 -.747 1.184l-.113 .02l-.117 .006h-6a1 1 0 0 1 -.996 -1.093l.018 -.117l1.24 -5.79h-1.262a1 1 0 0 1 -.117 -1.993l.117 -.007h.438a5.154 5.154 0 0 1 -.412 -1.525l-.02 -.259l-.006 -.216a4 4 0 0 1 4 -4z\" />\n  <path d=\"M18 18h-12a1 1 0 0 0 -1 1a2 2 0 0 0 2 2h10a2 2 0 0 0 1.987 -1.768l.011 -.174a1 1 0 0 0 -.998 -1.058z\" />"),
    CHESS_BISHOP(
        "chess-bishop",
        "<path d=\"M12 2a2 2 0 0 1 1.386 3.442c.646 .28 1.226 .62 1.74 1.017l-3.833 3.834l-.083 .094a1 1 0 0 0 1.403 1.403l.094 -.083l3.814 -3.813c.977 1.35 1.479 3.07 1.479 5.106c0 1.913 -1.178 3.722 -3.089 3.973l-.2 .02l-.211 .007h-5c-2.126 0 -3.5 -1.924 -3.5 -4c0 -3.68 1.57 -6.255 4.613 -7.56a2 2 0 0 1 1.387 -3.44z\" />\n  <path d=\"M12 5v1\" />\n  <path d=\"M18 18h-12a1 1 0 0 0 -1 1a2 2 0 0 0 2 2h10a2 2 0 0 0 1.987 -1.768l.011 -.174a1 1 0 0 0 -.998 -1.058z\" />"),
    CHESS_KING(
        "chess-king",
        "<path d=\"M12 2a1 1 0 0 1 .993 .883l.007 .117v2h2a1 1 0 0 1 .117 1.993l-.117 .007h-2v1.758a4.49 4.49 0 0 1 2.033 -.734l.24 -.018l.227 -.006a4.5 4.5 0 0 1 4.5 4.5a4.504 4.504 0 0 1 -4.064 4.478l-.217 .016l-.219 .006h-7a4.5 4.5 0 1 1 2.501 -8.241l-.001 -1.759h-2a1 1 0 0 1 -.117 -1.993l.117 -.007h2v-2a1 1 0 0 1 1 -1z\" />\n  <path d=\"M18 18h-12a1 1 0 0 0 -1 1a2 2 0 0 0 2 2h10a2 2 0 0 0 1.987 -1.768l.011 -.174a1 1 0 0 0 -.998 -1.058z\" />"),
    CHESS_KNIGHT(
        "chess-knight",
        "<path d=\"M8.959 1.99l-.147 .028l-.115 .029a1 1 0 0 0 -.646 1.27l.749 2.245l-2.815 1.735a2 2 0 0 0 -.655 2.751l.089 .133a2 2 0 0 0 1.614 .819l1.563 -.001l-1.614 4.674a1 1 0 0 0 .945 1.327h7.961a1 1 0 0 0 1 -.978l.112 -5c0 -3.827 -1.555 -6.878 -4.67 -7.966l-2.399 -.83l-.375 -.121l-.258 -.074l-.135 -.031l-.101 -.013l-.055 -.001l-.048 .003z\" />\n  <path d=\"M18 18h-12a1 1 0 0 0 -1 1a2 2 0 0 0 2 2h10a2 2 0 0 0 1.987 -1.768l.011 -.174a1 1 0 0 0 -.998 -1.058z\" />"),
    CHESS_QUEEN(
        "chess-queen",
        "<path d=\"M12 2a2 2 0 0 1 1.572 3.236l.793 1.983l1.702 -1.702a2.003 2.003 0 0 1 1.933 -2.517a2 2 0 0 1 .674 3.884l-1.69 9.295a1 1 0 0 1 -.865 .814l-.119 .007h-8a1 1 0 0 1 -.956 -.705l-.028 -.116l-1.69 -9.295a2 2 0 1 1 2.607 -1.367l1.701 1.702l.794 -1.983a2 2 0 0 1 1.572 -3.236z\" />\n  <path d=\"M18 18h-12a1 1 0 0 0 -1 1a2 2 0 0 0 2 2h10a2 2 0 0 0 1.987 -1.768l.011 -.174a1 1 0 0 0 -.998 -1.058z\" />"),
    CHESS_ROOK(
        "chess-rook",
        "<path d=\"M14 3a1 1 0 0 1 .993 .883l.007 .117v2h1.652l.362 -2.164a1 1 0 0 1 1.034 -.836l.116 .013a1 1 0 0 1 .836 1.035l-.013 .116l-.5 3a1 1 0 0 1 -.865 .829l-.122 .007h-1.383l.877 7.89a1 1 0 0 1 -.877 1.103l-.117 .007h-8a1 1 0 0 1 -1 -.993l.006 -.117l.877 -7.89h-1.383a1 1 0 0 1 -.96 -.718l-.026 -.118l-.5 -3a1 1 0 0 1 1.947 -.442l.025 .114l.361 2.164h1.653v-2a1 1 0 0 1 1.993 -.117l.007 .117v2h2v-2a1 1 0 0 1 1 -1z\" />\n  <path d=\"M18 18h-12a1 1 0 0 0 -1 1a2 2 0 0 0 2 2h10a2 2 0 0 0 1.987 -1.768l.011 -.174a1 1 0 0 0 -.998 -1.058z\" />"),
    GOLF(
        "golf",
        "<path d=\"M11 3a1 1 0 0 1 1.496 -.868l7 4a1 1 0 0 1 0 1.736l-6.496 3.712v6.42a1 1 0 0 1 -.883 .993l-.117 .007a1 1 0 0 1 -1 -1z\" />\n  <path d=\"M14.135 17.168a1 1 0 0 1 1.367 -.363c.916 .532 1.498 1.291 1.498 2.195c0 1.84 -2.319 3 -5 3s-5 -1.16 -5 -3c0 -.911 .577 -1.66 1.498 -2.195a1 1 0 1 1 1.004 1.73c-.365 .212 -.502 .39 -.502 .465c0 .086 .179 .296 .622 .518c.6 .3 1.456 .482 2.378 .482s1.777 -.182 2.378 -.482c.443 -.222 .622 -.432 .622 -.518c0 -.07 -.142 -.256 -.502 -.465a1 1 0 0 1 -.363 -1.367\" />"),
    MEEPLE(
        "meeple",
        "<path d=\"M12 2c2.486 0 3.713 1.766 3.955 4.1l.01 .124l.129 .036c3.17 .928 5.754 2.487 5.9 4.556l.006 .184c0 1.427 -1.297 2.322 -2.871 2.733l-.201 .049l.026 .03c.244 .276 .532 .603 .7 .797l.057 .066c.49 .573 .884 1.073 1.216 1.56c.69 1.01 1.073 1.904 1.073 2.765a2 2 0 0 1 -2 2h-5c-1.043 0 -1.344 -.453 -2.394 -2.553c-.29 -.58 -.448 -.882 -.593 -1.118l-.013 -.022l-.013 .022c-.129 .21 -.268 .472 -.5 .935l-.093 .183c-1.05 2.1 -1.351 2.553 -2.394 2.553h-5a2 2 0 0 1 -2 -2c0 -.86 .384 -1.755 1.073 -2.765a18 18 0 0 1 1.216 -1.56c.152 -.178 .482 -.553 .757 -.863l.025 -.03l-.2 -.049c-1.506 -.393 -2.758 -1.23 -2.864 -2.55l-.007 -.183c0 -2.16 2.643 -3.785 5.906 -4.74l.128 -.036l.011 -.124c.235 -2.26 1.394 -3.99 3.726 -4.095z\" />"),
    SCUBA_DIVING_TANK(
        "scuba-diving-tank",
        "<path d=\"M17 17v2a3 3 0 0 1 -3 3h-4a3 3 0 0 1 -3 -3v-2z\" />\n  <path d=\"M8 2a2 2 0 0 1 1.732 1h1.15a1.496 1.496 0 0 1 2.236 0h1.882a1 1 0 0 1 0 2l-1.883 .001a2 2 0 0 1 -.115 .116v.983a5 5 0 0 1 3.998 4.9v4h-10v-4a5 5 0 0 1 4 -4.9v-.983a2 2 0 0 1 -.117 -.116h-1.151a2 2 0 1 1 -1.732 -3.001\" />"),
    TROPHY(
        "trophy",
        "<path d=\"M17 3a1 1 0 0 1 .993 .883l.007 .117v2.17a3 3 0 1 1 0 5.659v.171a6.002 6.002 0 0 1 -5 5.917v2.083h3a1 1 0 0 1 .117 1.993l-.117 .007h-8a1 1 0 0 1 -.117 -1.993l.117 -.007h3v-2.083a6.002 6.002 0 0 1 -4.996 -5.692l-.004 -.225v-.171a3 3 0 0 1 -3.996 -2.653l-.003 -.176l.005 -.176a3 3 0 0 1 3.995 -2.654l-.001 -2.17a1 1 0 0 1 1 -1h10zm-12 5a1 1 0 1 0 0 2a1 1 0 0 0 0 -2m14 0a1 1 0 1 0 0 2a1 1 0 0 0 0 -2\" />");

    private final String catalogName;
    private final String svg;

    FilledIcon(String catalogName, String svg) {
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
      return "filled";
    }
  }

  default TablerIcon acrobatic() {
    return TablerIcon.create(TablerSport.OutlineIcon.ACROBATIC);
  }

  default TablerIcon ball_american_football() {
    return TablerIcon.create(TablerSport.OutlineIcon.BALL_AMERICAN_FOOTBALL);
  }

  default TablerIcon ball_american_football_off() {
    return TablerIcon.create(TablerSport.OutlineIcon.BALL_AMERICAN_FOOTBALL_OFF);
  }

  default TablerIcon ball_baseball() {
    return TablerIcon.create(TablerSport.OutlineIcon.BALL_BASEBALL);
  }

  default TablerIcon ball_basketball() {
    return TablerIcon.create(TablerSport.OutlineIcon.BALL_BASKETBALL);
  }

  default TablerIcon ball_bowling() {
    return TablerIcon.create(TablerSport.OutlineIcon.BALL_BOWLING);
  }

  default TablerIcon ball_football() {
    return TablerIcon.create(TablerSport.OutlineIcon.BALL_FOOTBALL);
  }

  default TablerIcon ball_football_off() {
    return TablerIcon.create(TablerSport.OutlineIcon.BALL_FOOTBALL_OFF);
  }

  default TablerIcon ball_tennis() {
    return TablerIcon.create(TablerSport.OutlineIcon.BALL_TENNIS);
  }

  default TablerIcon ball_volleyball() {
    return TablerIcon.create(TablerSport.OutlineIcon.BALL_VOLLEYBALL);
  }

  default TablerIcon barbell() {
    return TablerIcon.create(TablerSport.OutlineIcon.BARBELL);
  }

  default TablerIcon barbell_off() {
    return TablerIcon.create(TablerSport.OutlineIcon.BARBELL_OFF);
  }

  default TablerIcon bow() {
    return TablerIcon.create(TablerSport.OutlineIcon.BOW);
  }

  default TablerIcon bowling() {
    return TablerIcon.create(TablerSport.OutlineIcon.BOWLING);
  }

  default TablerIcon chess() {
    return TablerIcon.create(TablerSport.OutlineIcon.CHESS);
  }

  default TablerIcon chess_bishop() {
    return TablerIcon.create(TablerSport.OutlineIcon.CHESS_BISHOP);
  }

  default TablerIcon chess_king() {
    return TablerIcon.create(TablerSport.OutlineIcon.CHESS_KING);
  }

  default TablerIcon chess_knight() {
    return TablerIcon.create(TablerSport.OutlineIcon.CHESS_KNIGHT);
  }

  default TablerIcon chess_queen() {
    return TablerIcon.create(TablerSport.OutlineIcon.CHESS_QUEEN);
  }

  default TablerIcon chess_rook() {
    return TablerIcon.create(TablerSport.OutlineIcon.CHESS_ROOK);
  }

  default TablerIcon cliff_jumping() {
    return TablerIcon.create(TablerSport.OutlineIcon.CLIFF_JUMPING);
  }

  default TablerIcon cricket() {
    return TablerIcon.create(TablerSport.OutlineIcon.CRICKET);
  }

  default TablerIcon curling() {
    return TablerIcon.create(TablerSport.OutlineIcon.CURLING);
  }

  default TablerIcon disc_golf() {
    return TablerIcon.create(TablerSport.OutlineIcon.DISC_GOLF);
  }

  default TablerIcon dumbbell() {
    return TablerIcon.create(TablerSport.OutlineIcon.DUMBBELL);
  }

  default TablerIcon exercise_ball() {
    return TablerIcon.create(TablerSport.OutlineIcon.EXERCISE_BALL);
  }

  default TablerIcon golf() {
    return TablerIcon.create(TablerSport.OutlineIcon.GOLF);
  }

  default TablerIcon golf_off() {
    return TablerIcon.create(TablerSport.OutlineIcon.GOLF_OFF);
  }

  default TablerIcon helmet() {
    return TablerIcon.create(TablerSport.OutlineIcon.HELMET);
  }

  default TablerIcon helmet_off() {
    return TablerIcon.create(TablerSport.OutlineIcon.HELMET_OFF);
  }

  default TablerIcon hula_hoop() {
    return TablerIcon.create(TablerSport.OutlineIcon.HULA_HOOP);
  }

  default TablerIcon ice_skating() {
    return TablerIcon.create(TablerSport.OutlineIcon.ICE_SKATING);
  }

  default TablerIcon jump_rope() {
    return TablerIcon.create(TablerSport.OutlineIcon.JUMP_ROPE);
  }

  default TablerIcon karate() {
    return TablerIcon.create(TablerSport.OutlineIcon.KARATE);
  }

  default TablerIcon kayak() {
    return TablerIcon.create(TablerSport.OutlineIcon.KAYAK);
  }

  default TablerIcon medal() {
    return TablerIcon.create(TablerSport.OutlineIcon.MEDAL);
  }

  default TablerIcon medal_2() {
    return TablerIcon.create(TablerSport.OutlineIcon.MEDAL_2);
  }

  default TablerIcon meeple() {
    return TablerIcon.create(TablerSport.OutlineIcon.MEEPLE);
  }

  default TablerIcon olympic_torch() {
    return TablerIcon.create(TablerSport.OutlineIcon.OLYMPIC_TORCH);
  }

  default TablerIcon olympics() {
    return TablerIcon.create(TablerSport.OutlineIcon.OLYMPICS);
  }

  default TablerIcon olympics_off() {
    return TablerIcon.create(TablerSport.OutlineIcon.OLYMPICS_OFF);
  }

  default TablerIcon ping_pong() {
    return TablerIcon.create(TablerSport.OutlineIcon.PING_PONG);
  }

  default TablerIcon play_basketball() {
    return TablerIcon.create(TablerSport.OutlineIcon.PLAY_BASKETBALL);
  }

  default TablerIcon play_football() {
    return TablerIcon.create(TablerSport.OutlineIcon.PLAY_FOOTBALL);
  }

  default TablerIcon play_handball() {
    return TablerIcon.create(TablerSport.OutlineIcon.PLAY_HANDBALL);
  }

  default TablerIcon play_volleyball() {
    return TablerIcon.create(TablerSport.OutlineIcon.PLAY_VOLLEYBALL);
  }

  default TablerIcon pool() {
    return TablerIcon.create(TablerSport.OutlineIcon.POOL);
  }

  default TablerIcon pool_off() {
    return TablerIcon.create(TablerSport.OutlineIcon.POOL_OFF);
  }

  default TablerIcon rings() {
    return TablerIcon.create(TablerSport.OutlineIcon.RINGS);
  }

  default TablerIcon roller_skating() {
    return TablerIcon.create(TablerSport.OutlineIcon.ROLLER_SKATING);
  }

  default TablerIcon rugby() {
    return TablerIcon.create(TablerSport.OutlineIcon.RUGBY);
  }

  default TablerIcon run() {
    return TablerIcon.create(TablerSport.OutlineIcon.RUN);
  }

  default TablerIcon run_sprint() {
    return TablerIcon.create(TablerSport.OutlineIcon.RUN_SPRINT);
  }

  default TablerIcon scoreboard() {
    return TablerIcon.create(TablerSport.OutlineIcon.SCOREBOARD);
  }

  default TablerIcon scuba_diving() {
    return TablerIcon.create(TablerSport.OutlineIcon.SCUBA_DIVING);
  }

  default TablerIcon scuba_diving_tank() {
    return TablerIcon.create(TablerSport.OutlineIcon.SCUBA_DIVING_TANK);
  }

  default TablerIcon scuba_mask() {
    return TablerIcon.create(TablerSport.OutlineIcon.SCUBA_MASK);
  }

  default TablerIcon scuba_mask_off() {
    return TablerIcon.create(TablerSport.OutlineIcon.SCUBA_MASK_OFF);
  }

  default TablerIcon skateboarding() {
    return TablerIcon.create(TablerSport.OutlineIcon.SKATEBOARDING);
  }

  default TablerIcon ski_jumping() {
    return TablerIcon.create(TablerSport.OutlineIcon.SKI_JUMPING);
  }

  default TablerIcon soccer_field() {
    return TablerIcon.create(TablerSport.OutlineIcon.SOCCER_FIELD);
  }

  default TablerIcon sport_billiard() {
    return TablerIcon.create(TablerSport.OutlineIcon.SPORT_BILLIARD);
  }

  default TablerIcon stretching() {
    return TablerIcon.create(TablerSport.OutlineIcon.STRETCHING);
  }

  default TablerIcon stretching_2() {
    return TablerIcon.create(TablerSport.OutlineIcon.STRETCHING_2);
  }

  default TablerIcon swimming() {
    return TablerIcon.create(TablerSport.OutlineIcon.SWIMMING);
  }

  default TablerIcon target_2() {
    return TablerIcon.create(TablerSport.OutlineIcon.TARGET_2);
  }

  default TablerIcon target_arrow() {
    return TablerIcon.create(TablerSport.OutlineIcon.TARGET_ARROW);
  }

  default TablerIcon tic_tac() {
    return TablerIcon.create(TablerSport.OutlineIcon.TIC_TAC);
  }

  default TablerIcon tournament() {
    return TablerIcon.create(TablerSport.OutlineIcon.TOURNAMENT);
  }

  default TablerIcon treadmill() {
    return TablerIcon.create(TablerSport.OutlineIcon.TREADMILL);
  }

  default TablerIcon trekking() {
    return TablerIcon.create(TablerSport.OutlineIcon.TREKKING);
  }

  default TablerIcon trophy() {
    return TablerIcon.create(TablerSport.OutlineIcon.TROPHY);
  }

  default TablerIcon trophy_off() {
    return TablerIcon.create(TablerSport.OutlineIcon.TROPHY_OFF);
  }

  default TablerIcon walk() {
    return TablerIcon.create(TablerSport.OutlineIcon.WALK);
  }

  default TablerIcon waterpolo() {
    return TablerIcon.create(TablerSport.OutlineIcon.WATERPOLO);
  }

  default TablerIcon yoga() {
    return TablerIcon.create(TablerSport.OutlineIcon.YOGA);
  }

  default TablerIcon ball_bowling_filled() {
    return TablerIcon.create(TablerSport.FilledIcon.BALL_BOWLING);
  }

  default TablerIcon barbell_filled() {
    return TablerIcon.create(TablerSport.FilledIcon.BARBELL);
  }

  default TablerIcon bow_filled() {
    return TablerIcon.create(TablerSport.FilledIcon.BOW);
  }

  default TablerIcon chess_filled() {
    return TablerIcon.create(TablerSport.FilledIcon.CHESS);
  }

  default TablerIcon chess_bishop_filled() {
    return TablerIcon.create(TablerSport.FilledIcon.CHESS_BISHOP);
  }

  default TablerIcon chess_king_filled() {
    return TablerIcon.create(TablerSport.FilledIcon.CHESS_KING);
  }

  default TablerIcon chess_knight_filled() {
    return TablerIcon.create(TablerSport.FilledIcon.CHESS_KNIGHT);
  }

  default TablerIcon chess_queen_filled() {
    return TablerIcon.create(TablerSport.FilledIcon.CHESS_QUEEN);
  }

  default TablerIcon chess_rook_filled() {
    return TablerIcon.create(TablerSport.FilledIcon.CHESS_ROOK);
  }

  default TablerIcon golf_filled() {
    return TablerIcon.create(TablerSport.FilledIcon.GOLF);
  }

  default TablerIcon meeple_filled() {
    return TablerIcon.create(TablerSport.FilledIcon.MEEPLE);
  }

  default TablerIcon scuba_diving_tank_filled() {
    return TablerIcon.create(TablerSport.FilledIcon.SCUBA_DIVING_TANK);
  }

  default TablerIcon trophy_filled() {
    return TablerIcon.create(TablerSport.FilledIcon.TROPHY);
  }
}
