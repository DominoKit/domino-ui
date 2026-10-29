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

/** Lucide notifications catalog category. */
public interface LucideNotifications {
  enum Icon implements LucideIconDefinition {
    AD(
        "ad",
        "<path d=\"M10 13H6\" />\n  <path d=\"M10 15v-4a2 2 0 0 0-4 0v4\" />\n  <path d=\"M14 14.5a.5.5 0 0 0 .5.5h1a2.5 2.5 0 0 0 2.5-2.5v-1A2.5 2.5 0 0 0 15.5 9h-1a.5.5 0 0 0-.5.5z\" />\n  <rect x=\"2\" y=\"5\" width=\"20\" height=\"14\" rx=\"2\" />"),
    ALARM_CLOCK(
        "alarm-clock",
        "<circle cx=\"12\" cy=\"13\" r=\"8\" />\n  <path d=\"M12 9v4l2 2\" />\n  <path d=\"M5 3 2 6\" />\n  <path d=\"m22 6-3-3\" />\n  <path d=\"M6.38 18.7 4 21\" />\n  <path d=\"M17.64 18.67 20 21\" />"),
    ALARM_CLOCK_CHECK(
        "alarm-clock-check",
        "<circle cx=\"12\" cy=\"13\" r=\"8\" />\n  <path d=\"M5 3 2 6\" />\n  <path d=\"m22 6-3-3\" />\n  <path d=\"M6.38 18.7 4 21\" />\n  <path d=\"M17.64 18.67 20 21\" />\n  <path d=\"m9 13 2 2 4-4\" />"),
    ALARM_CLOCK_MINUS(
        "alarm-clock-minus",
        "<circle cx=\"12\" cy=\"13\" r=\"8\" />\n  <path d=\"M5 3 2 6\" />\n  <path d=\"m22 6-3-3\" />\n  <path d=\"M6.38 18.7 4 21\" />\n  <path d=\"M17.64 18.67 20 21\" />\n  <path d=\"M9 13h6\" />"),
    ALARM_CLOCK_OFF(
        "alarm-clock-off",
        "<path d=\"M6.87 6.87a8 8 0 1 0 11.26 11.26\" />\n  <path d=\"M19.9 14.25a8 8 0 0 0-9.15-9.15\" />\n  <path d=\"m22 6-3-3\" />\n  <path d=\"M6.26 18.67 4 21\" />\n  <path d=\"m2 2 20 20\" />\n  <path d=\"M4 4 2 6\" />"),
    ALARM_CLOCK_PLUS(
        "alarm-clock-plus",
        "<circle cx=\"12\" cy=\"13\" r=\"8\" />\n  <path d=\"M5 3 2 6\" />\n  <path d=\"m22 6-3-3\" />\n  <path d=\"M6.38 18.7 4 21\" />\n  <path d=\"M17.64 18.67 20 21\" />\n  <path d=\"M12 10v6\" />\n  <path d=\"M9 13h6\" />"),
    BELL(
        "bell",
        "<path d=\"M10.268 21a2 2 0 0 0 3.464 0\" />\n  <path d=\"M3.262 15.326A1 1 0 0 0 4 17h16a1 1 0 0 0 .74-1.673C19.41 13.956 18 12.499 18 8A6 6 0 0 0 6 8c0 4.499-1.411 5.956-2.738 7.326\" />"),
    BELL_CHECK(
        "bell-check",
        "<path d=\"M10.268 21a2 2 0 0 0 3.464 0\" />\n  <path d=\"m15 8 2 2 4-4\" />\n  <path d=\"M16.8607 4.4824A6 6 0 0 0 6 8C6 12.499 4.589 13.956 3.262 15.326\" />\n  <path d=\"M3.262 15.326A1 1 0 0 0 4 17H20A1 1 0 0 0 20.74 15.327C20.209 14.779 19.665 14.218 19.203 13.454\" />"),
    BELL_DOT(
        "bell-dot",
        "<path d=\"M10.268 21a2 2 0 0 0 3.464 0\" />\n  <path d=\"M11.68 2.009A6 6 0 0 0 6 8c0 4.499-1.411 5.956-2.738 7.326A1 1 0 0 0 4 17h16a1 1 0 0 0 .74-1.673c-.824-.85-1.678-1.731-2.21-3.348\" />\n  <circle cx=\"18\" cy=\"5\" r=\"3\" />"),
    BELL_ELECTRIC(
        "bell-electric",
        "<path d=\"M18.518 17.347A7 7 0 0 1 14 19\" />\n  <path d=\"M18.8 4A11 11 0 0 1 20 9\" />\n  <path d=\"M9 9h.01\" />\n  <circle cx=\"20\" cy=\"16\" r=\"2\" />\n  <circle cx=\"9\" cy=\"9\" r=\"7\" />\n  <rect x=\"4\" y=\"16\" width=\"10\" height=\"6\" rx=\"2\" />"),
    BELL_MINUS(
        "bell-minus",
        "<path d=\"M10.268 21a2 2 0 0 0 3.464 0\" />\n  <path d=\"M15 8h6\" />\n  <path d=\"M16.243 3.757A6 6 0 0 0 6 8c0 4.499-1.411 5.956-2.738 7.326A1 1 0 0 0 4 17h16a1 1 0 0 0 .74-1.673A9.4 9.4 0 0 1 18.667 12\" />"),
    BELL_OFF(
        "bell-off",
        "<path d=\"M10.268 21a2 2 0 0 0 3.464 0\" />\n  <path d=\"M17 17H4a1 1 0 0 1-.74-1.673C4.59 13.956 6 12.499 6 8a6 6 0 0 1 .258-1.742\" />\n  <path d=\"m2 2 20 20\" />\n  <path d=\"M8.668 3.01A6 6 0 0 1 18 8c0 2.687.77 4.653 1.707 6.05\" />"),
    BELL_PLUS(
        "bell-plus",
        "<path d=\"M10.268 21a2 2 0 0 0 3.464 0\" />\n  <path d=\"M15 8h6\" />\n  <path d=\"M18 5v6\" />\n  <path d=\"M20.002 14.464a9 9 0 0 0 .738.863A1 1 0 0 1 20 17H4a1 1 0 0 1-.74-1.673C4.59 13.956 6 12.499 6 8a6 6 0 0 1 8.75-5.332\" />"),
    BELL_RING(
        "bell-ring",
        "<path d=\"M10.268 21a2 2 0 0 0 3.464 0\" />\n  <path d=\"M22 8c0-2.3-.8-4.3-2-6\" />\n  <path d=\"M3.262 15.326A1 1 0 0 0 4 17h16a1 1 0 0 0 .74-1.673C19.41 13.956 18 12.499 18 8A6 6 0 0 0 6 8c0 4.499-1.411 5.956-2.738 7.326\" />\n  <path d=\"M4 2C2.8 3.7 2 5.7 2 8\" />"),
    CHECK("check", "<path d=\"M20 6 9 17l-5-5\" />"),
    CHECK_CHECK(
        "check-check", "<path d=\"M18 6 7 17l-5-5\" />\n  <path d=\"m22 10-7.5 7.5L13 16\" />"),
    CHECK_LINE(
        "check-line",
        "<path d=\"M20 4L9 15\" />\n  <path d=\"M21 19L3 19\" />\n  <path d=\"M9 15L4 10\" />"),
    CIRCLE_ALERT(
        "circle-alert",
        "<circle cx=\"12\" cy=\"12\" r=\"10\" />\n  <line x1=\"12\" x2=\"12\" y1=\"8\" y2=\"12\" />\n  <line x1=\"12\" x2=\"12.01\" y1=\"16\" y2=\"16\" />"),
    CIRCLE_CHECK(
        "circle-check",
        "<circle cx=\"12\" cy=\"12\" r=\"10\" />\n  <path d=\"m16 9-5.5 5.5L8 12\" />"),
    CIRCLE_CHECK_BIG(
        "circle-check-big",
        "<path d=\"M21.801 10A10 10 0 1 1 17 3.335\" />\n  <path d=\"m9 11 3 3L22 4\" />"),
    CIRCLE_DASHED_CHECK(
        "circle-dashed-check",
        "<path d=\"M10.1 2.182a10 10 0 013.8 0\" />\n  <path d=\"M13.9 21.818a10 10 0 01-3.8 0\" />\n  <path d=\"m16 9-5.5 5.5L8 12\" />\n  <path d=\"M17.609 3.721a10 10 0 012.69 2.7\" />\n  <path d=\"M2.182 13.9a10 10 0 010-3.8\" />\n  <path d=\"M20.279 17.609a10 10 0 01-2.7 2.69\" />\n  <path d=\"M21.818 10.1a10 10 0 010 3.8\" />\n  <path d=\"M3.721 6.391a10 10 0 012.7-2.69\" />\n  <path d=\"M6.391 20.279a10 10 0 01-2.69-2.7\" />"),
    CIRCLE_QUESTION_MARK(
        "circle-question-mark",
        "<circle cx=\"12\" cy=\"12\" r=\"10\" />\n  <path d=\"M9.09 9a3 3 0 0 1 5.83 1c0 2-3 3-3 3\" />\n  <path d=\"M12 17h.01\" />"),
    COPY_CHECK(
        "copy-check",
        "<path d=\"m12 15 2 2 4-4\" />\n  <rect width=\"14\" height=\"14\" x=\"8\" y=\"8\" rx=\"2\" ry=\"2\" />\n  <path d=\"M4 16c-1.1 0-2-.9-2-2V4c0-1.1.9-2 2-2h10c1.1 0 2 .9 2 2\" />"),
    COPY_X(
        "copy-x",
        "<path d=\"M4 16a2 2 0 0 1-2-2V4a2 2 0 0 1 2-2h10a2 2 0 0 1 2 2\" />\n  <rect x=\"8\" y=\"8\" width=\"14\" height=\"14\" rx=\"2\" />\n  <path d=\"m12.5 12.5 5 5\" />\n  <path d=\"m12.5 17.5 5-5\" />"),
    FACE_SLIGHTLY_SMILING_PLUS(
        "face-slightly-smiling-plus",
        "<path d=\"M13.267 2.08a10 10 0 108.653 8.653\" />\n  <path d=\"M15 10V9\" />\n  <path d=\"M16 5h6\" />\n  <path d=\"M16.472 15a6 6 0 01-8.943 0\" />\n  <path d=\"M19 2v6\" />\n  <path d=\"M9 10V9\" />"),
    FILE_EXCLAMATION_POINT(
        "file-exclamation-point",
        "<path d=\"M6 22a2 2 0 0 1-2-2V4a2 2 0 0 1 2-2h8a2.4 2.4 0 0 1 1.704.706l3.588 3.588A2.4 2.4 0 0 1 20 8v12a2 2 0 0 1-2 2z\" />\n  <path d=\"M12 9v4\" />\n  <path d=\"M12 17h.01\" />"),
    INFO(
        "info",
        "<circle cx=\"12\" cy=\"12\" r=\"10\" />\n  <path d=\"M12 16v-4\" />\n  <path d=\"M12 8h.01\" />"),
    LAPTOP_MINIMAL_CHECK(
        "laptop-minimal-check",
        "<path d=\"M2 20h20\" />\n  <path d=\"m9 10 2 2 4-4\" />\n  <rect x=\"3\" y=\"4\" width=\"18\" height=\"12\" rx=\"2\" />"),
    LIST_CLOCK(
        "list-clock",
        "<path d=\"M16 13v2.2l1.6 1\" />\n  <path d=\"M3 12h3.458\" />\n  <path d=\"M3 19h3.832\" />\n  <path d=\"M3 5h18\" />\n  <circle cx=\"16\" cy=\"15\" r=\"6\" />"),
    MAIL_CLOCK(
        "mail-clock",
        "<path d=\"M16 14v2.2l1.6 1\" />\n  <path d=\"m22 7-.759.484\" />\n  <path d=\"M6.835 20H4a2 2 0 01-2-2V6a2 2 0 012-2h16a2 2 0 012 2v2\" />\n  <path d=\"M7.605 10.567 2 7\" />\n  <circle cx=\"16\" cy=\"16\" r=\"6\" />"),
    MEGAPHONE(
        "megaphone",
        "<path d=\"M11 6a13 13 0 0 0 8.4-2.8A1 1 0 0 1 21 4v12a1 1 0 0 1-1.6.8A13 13 0 0 0 11 14H5a2 2 0 0 1-2-2V8a2 2 0 0 1 2-2z\" />\n  <path d=\"M6 14a12 12 0 0 0 2.4 7.2 2 2 0 0 0 3.2-2.4A8 8 0 0 1 10 14\" />\n  <path d=\"M8 6v8\" />"),
    MEGAPHONE_OFF(
        "megaphone-off",
        "<path d=\"M11.636 6A13 13 0 0 0 19.4 3.2 1 1 0 0 1 21 4v11.344\" />\n  <path d=\"M14.378 14.357A13 13 0 0 0 11 14H5a2 2 0 0 1-2-2V8a2 2 0 0 1 2-2h1\" />\n  <path d=\"m2 2 20 20\" />\n  <path d=\"M6 14a12 12 0 0 0 2.4 7.2 2 2 0 0 0 3.2-2.4A8 8 0 0 1 10 14\" />\n  <path d=\"M8 8v6\" />"),
    MESSAGE_CIRCLE_WARNING(
        "message-circle-warning",
        "<path d=\"M2.992 16.342a2 2 0 0 1 .094 1.167l-1.065 3.29a1 1 0 0 0 1.236 1.168l3.413-.998a2 2 0 0 1 1.099.092 10 10 0 1 0-4.777-4.719\" />\n  <path d=\"M12 8v4\" />\n  <path d=\"M12 16h.01\" />"),
    MESSAGE_SQUARE_DOT(
        "message-square-dot",
        "<path d=\"M12.7 3H4a2 2 0 0 0-2 2v16.286a.71.71 0 0 0 1.212.502l2.202-2.202A2 2 0 0 1 6.828 19H20a2 2 0 0 0 2-2v-4.7\" />\n  <circle cx=\"19\" cy=\"6\" r=\"3\" />"),
    MESSAGE_SQUARE_WARNING(
        "message-square-warning",
        "<path d=\"M22 17a2 2 0 0 1-2 2H6.828a2 2 0 0 0-1.414.586l-2.202 2.202A.71.71 0 0 1 2 21.286V5a2 2 0 0 1 2-2h16a2 2 0 0 1 2 2z\" />\n  <path d=\"M12 15h.01\" />\n  <path d=\"M12 7v4\" />"),
    MESSAGES_CIRCLE(
        "messages-circle",
        "<path d=\"M19.95 10.05a7 7 0 011.412 7.872 1 1 0 00-.058.787l.675 2.089a1 1 0 01-1.236 1.168l-2.155-.631a1 1 0 00-.745.06 7 7 0 01-7.793-1.445\" />\n  <path d=\"M2.696 12.708a1 1 0 00-.058-.785 7 7 0 113.518 3.473 1 1 0 00-.744-.061l-2.155.63a1 1 0 01-1.236-1.167z\" />"),
    OCTAGON_ALERT(
        "octagon-alert",
        "<path d=\"M12 16h.01\" />\n  <path d=\"M12 8v4\" />\n  <path d=\"M15.312 2a2 2 0 0 1 1.414.586l4.688 4.688A2 2 0 0 1 22 8.688v6.624a2 2 0 0 1-.586 1.414l-4.688 4.688a2 2 0 0 1-1.414.586H8.688a2 2 0 0 1-1.414-.586l-4.688-4.688A2 2 0 0 1 2 15.312V8.688a2 2 0 0 1 .586-1.414l4.688-4.688A2 2 0 0 1 8.688 2z\" />"),
    OCTAGON_X(
        "octagon-x",
        "<path d=\"m15 9-6 6\" />\n  <path d=\"M2.586 16.726A2 2 0 0 1 2 15.312V8.688a2 2 0 0 1 .586-1.414l4.688-4.688A2 2 0 0 1 8.688 2h6.624a2 2 0 0 1 1.414.586l4.688 4.688A2 2 0 0 1 22 8.688v6.624a2 2 0 0 1-.586 1.414l-4.688 4.688a2 2 0 0 1-1.414.586H8.688a2 2 0 0 1-1.414-.586z\" />\n  <path d=\"m9 9 6 6\" />"),
    SHIELD_ALERT(
        "shield-alert",
        "<path d=\"M20 13c0 5-3.5 7.5-7.66 8.95a1 1 0 0 1-.67-.01C7.5 20.5 4 18 4 13V6a1 1 0 0 1 1-1c2 0 4.5-1.2 6.24-2.72a1.17 1.17 0 0 1 1.52 0C14.51 3.81 17 5 19 5a1 1 0 0 1 1 1z\" />\n  <path d=\"M12 8v4\" />\n  <path d=\"M12 16h.01\" />"),
    SQUARE_CHECK(
        "square-check",
        "<rect width=\"18\" height=\"18\" x=\"3\" y=\"3\" rx=\"2\" />\n  <path d=\"m16 9-5.5 5.5L8 12\" />"),
    SQUARE_CHECK_BIG(
        "square-check-big",
        "<path d=\"M21 10.656V19a2 2 0 0 1-2 2H5a2 2 0 0 1-2-2V5a2 2 0 0 1 2-2h12.344\" />\n  <path d=\"m9 11 3 3L22 4\" />"),
    SQUARE_EXCLAMATION_POINT(
        "square-exclamation-point",
        "<rect width=\"18\" height=\"18\" x=\"3\" y=\"3\" rx=\"2\" />\n  <line x1=\"12\" x2=\"12\" y1=\"8\" y2=\"12\" />\n  <line x1=\"12\" x2=\"12.01\" y1=\"16\" y2=\"16\" />"),
    SQUARE_X(
        "square-x",
        "<rect width=\"18\" height=\"18\" x=\"3\" y=\"3\" rx=\"2\" ry=\"2\" />\n  <path d=\"m15 9-6 6\" />\n  <path d=\"m9 9 6 6\" />"),
    TRIANGLE_ALERT(
        "triangle-alert",
        "<path d=\"m21.73 18-8-14a2 2 0 0 0-3.48 0l-8 14A2 2 0 0 0 4 21h16a2 2 0 0 0 1.73-3\" />\n  <path d=\"M12 9v4\" />\n  <path d=\"M12 17h.01\" />"),
    VIBRATE(
        "vibrate",
        "<path d=\"m2 8 2 2-2 2 2 2-2 2\" />\n  <path d=\"m22 8-2 2 2 2-2 2 2 2\" />\n  <rect width=\"8\" height=\"14\" x=\"8\" y=\"5\" rx=\"1\" />"),
    WHISTLE(
        "whistle",
        "<path d=\"M10 6v4\" />\n  <path d=\"M21 6a1 1 0 0 1 1 1v2a1 1 0 0 1-1 1h-5.675A7 7 0 1 1 9 6z\" />"),
    X("x", "<path d=\"M18 6 6 18\" />\n  <path d=\"m6 6 12 12\" />"),
    X_LINE_TOP(
        "x-line-top",
        "<path d=\"M18 4H6\" />\n  <path d=\"M18 8 6 20\" />\n  <path d=\"m6 8 12 12\" />");

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
  default LucideIcon ad_notifications() {
    return LucideIcon.create(Icon.AD);
  }

  default LucideIcon alarm_clock_notifications() {
    return LucideIcon.create(Icon.ALARM_CLOCK);
  }

  default LucideIcon alarm_clock_check_notifications() {
    return LucideIcon.create(Icon.ALARM_CLOCK_CHECK);
  }

  default LucideIcon alarm_clock_minus_notifications() {
    return LucideIcon.create(Icon.ALARM_CLOCK_MINUS);
  }

  default LucideIcon alarm_clock_off_notifications() {
    return LucideIcon.create(Icon.ALARM_CLOCK_OFF);
  }

  default LucideIcon alarm_clock_plus_notifications() {
    return LucideIcon.create(Icon.ALARM_CLOCK_PLUS);
  }

  default LucideIcon bell_notifications() {
    return LucideIcon.create(Icon.BELL);
  }

  default LucideIcon bell_check_notifications() {
    return LucideIcon.create(Icon.BELL_CHECK);
  }

  default LucideIcon bell_dot_notifications() {
    return LucideIcon.create(Icon.BELL_DOT);
  }

  default LucideIcon bell_electric_notifications() {
    return LucideIcon.create(Icon.BELL_ELECTRIC);
  }

  default LucideIcon bell_minus() {
    return LucideIcon.create(Icon.BELL_MINUS);
  }

  default LucideIcon bell_off() {
    return LucideIcon.create(Icon.BELL_OFF);
  }

  default LucideIcon bell_plus() {
    return LucideIcon.create(Icon.BELL_PLUS);
  }

  default LucideIcon bell_ring() {
    return LucideIcon.create(Icon.BELL_RING);
  }

  default LucideIcon check() {
    return LucideIcon.create(Icon.CHECK);
  }

  default LucideIcon check_check() {
    return LucideIcon.create(Icon.CHECK_CHECK);
  }

  default LucideIcon check_line() {
    return LucideIcon.create(Icon.CHECK_LINE);
  }

  default LucideIcon circle_alert() {
    return LucideIcon.create(Icon.CIRCLE_ALERT);
  }

  default LucideIcon circle_check() {
    return LucideIcon.create(Icon.CIRCLE_CHECK);
  }

  default LucideIcon circle_check_big() {
    return LucideIcon.create(Icon.CIRCLE_CHECK_BIG);
  }

  default LucideIcon circle_dashed_check_notifications() {
    return LucideIcon.create(Icon.CIRCLE_DASHED_CHECK);
  }

  default LucideIcon circle_question_mark_notifications() {
    return LucideIcon.create(Icon.CIRCLE_QUESTION_MARK);
  }

  default LucideIcon copy_check_notifications() {
    return LucideIcon.create(Icon.COPY_CHECK);
  }

  default LucideIcon copy_x_notifications() {
    return LucideIcon.create(Icon.COPY_X);
  }

  default LucideIcon face_slightly_smiling_plus_notifications() {
    return LucideIcon.create(Icon.FACE_SLIGHTLY_SMILING_PLUS);
  }

  default LucideIcon file_exclamation_point_notifications() {
    return LucideIcon.create(Icon.FILE_EXCLAMATION_POINT);
  }

  default LucideIcon info_notifications() {
    return LucideIcon.create(Icon.INFO);
  }

  default LucideIcon laptop_minimal_check_notifications() {
    return LucideIcon.create(Icon.LAPTOP_MINIMAL_CHECK);
  }

  default LucideIcon list_clock_notifications() {
    return LucideIcon.create(Icon.LIST_CLOCK);
  }

  default LucideIcon mail_clock_notifications() {
    return LucideIcon.create(Icon.MAIL_CLOCK);
  }

  default LucideIcon megaphone_notifications() {
    return LucideIcon.create(Icon.MEGAPHONE);
  }

  default LucideIcon megaphone_off_notifications() {
    return LucideIcon.create(Icon.MEGAPHONE_OFF);
  }

  default LucideIcon message_circle_warning_notifications() {
    return LucideIcon.create(Icon.MESSAGE_CIRCLE_WARNING);
  }

  default LucideIcon message_square_dot_notifications() {
    return LucideIcon.create(Icon.MESSAGE_SQUARE_DOT);
  }

  default LucideIcon message_square_warning_notifications() {
    return LucideIcon.create(Icon.MESSAGE_SQUARE_WARNING);
  }

  default LucideIcon messages_circle_notifications() {
    return LucideIcon.create(Icon.MESSAGES_CIRCLE);
  }

  default LucideIcon octagon_alert_notifications() {
    return LucideIcon.create(Icon.OCTAGON_ALERT);
  }

  default LucideIcon octagon_x_notifications() {
    return LucideIcon.create(Icon.OCTAGON_X);
  }

  default LucideIcon shield_alert_notifications() {
    return LucideIcon.create(Icon.SHIELD_ALERT);
  }

  default LucideIcon square_check() {
    return LucideIcon.create(Icon.SQUARE_CHECK);
  }

  default LucideIcon square_check_big() {
    return LucideIcon.create(Icon.SQUARE_CHECK_BIG);
  }

  default LucideIcon square_exclamation_point_notifications() {
    return LucideIcon.create(Icon.SQUARE_EXCLAMATION_POINT);
  }

  default LucideIcon square_x_notifications() {
    return LucideIcon.create(Icon.SQUARE_X);
  }

  default LucideIcon triangle_alert_notifications() {
    return LucideIcon.create(Icon.TRIANGLE_ALERT);
  }

  default LucideIcon vibrate_notifications() {
    return LucideIcon.create(Icon.VIBRATE);
  }

  default LucideIcon whistle_notifications() {
    return LucideIcon.create(Icon.WHISTLE);
  }

  default LucideIcon x_notifications() {
    return LucideIcon.create(Icon.X);
  }

  default LucideIcon x_line_top_notifications() {
    return LucideIcon.create(Icon.X_LINE_TOP);
  }
}
