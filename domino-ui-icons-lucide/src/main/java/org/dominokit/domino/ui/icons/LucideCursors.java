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

/** Lucide cursors catalog category. */
public interface LucideCursors {
  enum Icon implements LucideIconDefinition {
    CIRCLE_PLUS(
        "circle-plus",
        "<circle cx=\"12\" cy=\"12\" r=\"10\" />\n  <path d=\"M8 12h8\" />\n  <path d=\"M12 8v8\" />"),
    HAND(
        "hand",
        "<path d=\"M18 11V6a2 2 0 0 0-2-2a2 2 0 0 0-2 2\" />\n  <path d=\"M14 10V4a2 2 0 0 0-2-2a2 2 0 0 0-2 2v2\" />\n  <path d=\"M10 10.5V6a2 2 0 0 0-2-2a2 2 0 0 0-2 2v8\" />\n  <path d=\"M18 8a2 2 0 1 1 4 0v6a8 8 0 0 1-8 8h-2c-2.8 0-4.5-.86-5.99-2.34l-3.6-3.6a2 2 0 0 1 2.83-2.82L7 15\" />"),
    HAND_GRAB(
        "hand-grab",
        "<path d=\"M18 11.5V9a2 2 0 0 0-2-2a2 2 0 0 0-2 2v1.4\" />\n  <path d=\"M14 10V8a2 2 0 0 0-2-2a2 2 0 0 0-2 2v2\" />\n  <path d=\"M10 9.9V9a2 2 0 0 0-2-2a2 2 0 0 0-2 2v5\" />\n  <path d=\"M6 14a2 2 0 0 0-2-2a2 2 0 0 0-2 2\" />\n  <path d=\"M18 11a2 2 0 1 1 4 0v3a8 8 0 0 1-8 8h-4a8 8 0 0 1-8-8 2 2 0 1 1 4 0\" />"),
    LASSO(
        "lasso",
        "<path d=\"M3.704 14.467a10 8 0 1 1 3.115 2.375\" />\n  <path d=\"M7 22a5 5 0 0 1-2-3.994\" />\n  <circle cx=\"5\" cy=\"16\" r=\"2\" />"),
    LASSO_SELECT(
        "lasso-select",
        "<path d=\"M7 22a5 5 0 0 1-2-4\" />\n  <path d=\"M7 16.93c.96.43 1.96.74 2.99.91\" />\n  <path d=\"M3.34 14A6.8 6.8 0 0 1 2 10c0-4.42 4.48-8 10-8s10 3.58 10 8a7.19 7.19 0 0 1-.33 2\" />\n  <path d=\"M5 18a2 2 0 1 0 0-4 2 2 0 0 0 0 4z\" />\n  <path d=\"M14.33 22h-.09a.35.35 0 0 1-.24-.32v-10a.34.34 0 0 1 .33-.34c.08 0 .15.03.21.08l7.34 6a.33.33 0 0 1-.21.59h-4.49l-2.57 3.85a.35.35 0 0 1-.28.14z\" />"),
    LOADER(
        "loader",
        "<path d=\"M12 2v4\" />\n  <path d=\"m16.2 7.8 2.9-2.9\" />\n  <path d=\"M18 12h4\" />\n  <path d=\"m16.2 16.2 2.9 2.9\" />\n  <path d=\"M12 18v4\" />\n  <path d=\"m4.9 19.1 2.9-2.9\" />\n  <path d=\"M2 12h4\" />\n  <path d=\"m4.9 4.9 2.9 2.9\" />"),
    LOADER_CIRCLE("loader-circle", "<path d=\"M21 12a9 9 0 1 1-6.219-8.56\" />"),
    LOADER_PINWHEEL(
        "loader-pinwheel",
        "<path d=\"M22 12a1 1 0 0 1-10 0 1 1 0 0 0-10 0\" />\n  <path d=\"M7 20.7a1 1 0 1 1 5-8.7 1 1 0 1 0 5-8.6\" />\n  <path d=\"M7 3.3a1 1 0 1 1 5 8.6 1 1 0 1 0 5 8.6\" />\n  <circle cx=\"12\" cy=\"12\" r=\"10\" />"),
    MOUSE_POINTER(
        "mouse-pointer",
        "<path d=\"M12.586 12.586 19 19\" />\n  <path d=\"M3.688 3.037a.497.497 0 0 0-.651.651l6.5 15.999a.501.501 0 0 0 .947-.062l1.569-6.083a2 2 0 0 1 1.448-1.479l6.124-1.579a.5.5 0 0 0 .063-.947z\" />"),
    MOUSE_POINTER_2(
        "mouse-pointer-2",
        "<path d=\"M4.037 4.688a.495.495 0 0 1 .651-.651l16 6.5a.5.5 0 0 1-.063.947l-6.124 1.58a2 2 0 0 0-1.438 1.435l-1.579 6.126a.5.5 0 0 1-.947.063z\" />"),
    MOUSE_POINTER_2_OFF(
        "mouse-pointer-2-off",
        "<path d=\"m15.55 8.45 5.138 2.087a.5.5 0 0 1-.063.947l-6.124 1.58a2 2 0 0 0-1.438 1.435l-1.579 6.126a.5.5 0 0 1-.947.063L8.45 15.551\" />\n  <path d=\"M22 2 2 22\" />\n  <path d=\"m6.816 11.528-2.779-6.84a.495.495 0 0 1 .651-.651l6.84 2.779\" />"),
    MOUSE_POINTER_BAN(
        "mouse-pointer-ban",
        "<path d=\"M2.034 2.681a.498.498 0 0 1 .647-.647l9 3.5a.5.5 0 0 1-.033.944L8.204 7.545a1 1 0 0 0-.66.66l-1.066 3.443a.5.5 0 0 1-.944.033z\" />\n  <circle cx=\"16\" cy=\"16\" r=\"6\" />\n  <path d=\"m11.8 11.8 8.4 8.4\" />"),
    MOUSE_POINTER_CLICK(
        "mouse-pointer-click",
        "<path d=\"M14 4.1 12 6\" />\n  <path d=\"m5.1 8-2.9-.8\" />\n  <path d=\"m6 12-1.9 2\" />\n  <path d=\"M7.2 2.2 8 5.1\" />\n  <path d=\"M9.037 9.69a.498.498 0 0 1 .653-.653l11 4.5a.5.5 0 0 1-.074.949l-4.349 1.041a1 1 0 0 0-.74.739l-1.04 4.35a.5.5 0 0 1-.95.074z\" />"),
    MOVE(
        "move",
        "<path d=\"M12 2v20\" />\n  <path d=\"m15 19-3 3-3-3\" />\n  <path d=\"m19 9 3 3-3 3\" />\n  <path d=\"M2 12h20\" />\n  <path d=\"m5 9-3 3 3 3\" />\n  <path d=\"m9 5 3-3 3 3\" />"),
    MOVE_DIAGONAL(
        "move-diagonal",
        "<path d=\"M11 19H5v-6\" />\n  <path d=\"M13 5h6v6\" />\n  <path d=\"M19 5 5 19\" />"),
    MOVE_DIAGONAL_2(
        "move-diagonal-2",
        "<path d=\"M19 13v6h-6\" />\n  <path d=\"M5 11V5h6\" />\n  <path d=\"m5 5 14 14\" />"),
    MOVE_HORIZONTAL(
        "move-horizontal",
        "<path d=\"m18 8 4 4-4 4\" />\n  <path d=\"M2 12h20\" />\n  <path d=\"m6 8-4 4 4 4\" />"),
    MOVE_VERTICAL(
        "move-vertical",
        "<path d=\"M12 2v20\" />\n  <path d=\"m8 18 4 4 4-4\" />\n  <path d=\"m8 6 4-4 4 4\" />"),
    PEN_TOOL(
        "pen-tool",
        "<path d=\"m18 13-.654-4.736a4 4 0 00-2.756-3.266l-9.163-2.9a2 2 0 00-2.017.493l-.82.819a2 2 0 00-.492 2.017l2.9 9.163a4 4 0 003.266 2.756L13 18\" />\n  <path d=\"M18.648 12.352a1.205 1.205 0 011.704 0l1.296 1.296a1.205 1.205 0 010 1.704l-6.296 6.296a1.205 1.205 0 01-1.704 0l-1.296-1.296a1.205 1.205 0 010-1.704z\" />\n  <path d=\"m3 3 6.586 6.586\" />\n  <circle cx=\"11\" cy=\"11\" r=\"2\" />"),
    PENCIL(
        "pencil",
        "<path d=\"M21.174 6.812a1 1 0 0 0-3.986-3.987L3.842 16.174a2 2 0 0 0-.5.83l-1.321 4.352a.5.5 0 0 0 .623.622l4.353-1.32a2 2 0 0 0 .83-.497z\" />\n  <path d=\"m15 5 4 4\" />"),
    PENCIL_OFF(
        "pencil-off",
        "<path d=\"m10 10-6.157 6.162a2 2 0 0 0-.5.833l-1.322 4.36a.5.5 0 0 0 .622.624l4.358-1.323a2 2 0 0 0 .83-.5L14 13.982\" />\n  <path d=\"m12.829 7.172 4.359-4.346a1 1 0 1 1 3.986 3.986l-4.353 4.353\" />\n  <path d=\"m15 5 4 4\" />\n  <path d=\"m2 2 20 20\" />"),
    PENCIL_SPARKLES(
        "pencil-sparkles",
        "<path d=\"M10 3H8\" />\n  <path d=\"m15.007 5.008 3.987 3.986\" />\n  <path d=\"M20 15v4\" />\n  <path d=\"M21.174 6.813a2.82 2.82 0 0 0-3.986-3.987L3.842 16.175a2 2 0 0 0-.5.83l-1.321 4.352a.5.5 0 0 0 .623.622l4.353-1.32a2 2 0 0 0 .83-.497z\" />\n  <path d=\"M22 17h-4\" />\n  <path d=\"M4 5v4\" />\n  <path d=\"M6 7H2\" />\n  <path d=\"M9 2v2\" />"),
    PLUS("plus", "<path d=\"M5 12h14\" />\n  <path d=\"M12 5v14\" />"),
    POINTER(
        "pointer",
        "<path d=\"M22 14a8 8 0 0 1-8 8\" />\n  <path d=\"M18 11v-1a2 2 0 0 0-2-2a2 2 0 0 0-2 2\" />\n  <path d=\"M14 10V9a2 2 0 0 0-2-2a2 2 0 0 0-2 2v1\" />\n  <path d=\"M10 9.5V4a2 2 0 0 0-2-2a2 2 0 0 0-2 2v10\" />\n  <path d=\"M18 11a2 2 0 1 1 4 0v3a8 8 0 0 1-8 8h-2c-2.8 0-4.5-.86-5.99-2.34l-3.6-3.6a2 2 0 0 1 2.83-2.82L7 15\" />"),
    POINTER_OFF(
        "pointer-off",
        "<path d=\"M10 4.5V4a2 2 0 0 0-2.41-1.957\" />\n  <path d=\"M13.9 8.4a2 2 0 0 0-1.26-1.295\" />\n  <path d=\"M21.7 16.2A8 8 0 0 0 22 14v-3a2 2 0 1 0-4 0v-1a2 2 0 0 0-3.63-1.158\" />\n  <path d=\"m7 15-1.8-1.8a2 2 0 0 0-2.79 2.86L6 19.7a7.74 7.74 0 0 0 6 2.3h2a8 8 0 0 0 5.657-2.343\" />\n  <path d=\"M6 6v8\" />\n  <path d=\"m2 2 20 20\" />"),
    SPARKLES(
        "sparkles",
        "<path d=\"M11.017 2.814a1 1 0 0 1 1.966 0l1.051 5.558a2 2 0 0 0 1.594 1.594l5.558 1.051a1 1 0 0 1 0 1.966l-5.558 1.051a2 2 0 0 0-1.594 1.594l-1.051 5.558a1 1 0 0 1-1.966 0l-1.051-5.558a2 2 0 0 0-1.594-1.594l-5.558-1.051a1 1 0 0 1 0-1.966l5.558-1.051a2 2 0 0 0 1.594-1.594z\" />\n  <path d=\"M20 2v4\" />\n  <path d=\"M22 4h-4\" />\n  <circle cx=\"4\" cy=\"20\" r=\"2\" />"),
    SPLINE_POINTER(
        "spline-pointer",
        "<path d=\"M12.034 12.681a.498.498 0 0 1 .647-.647l9 3.5a.5.5 0 0 1-.033.943l-3.444 1.068a1 1 0 0 0-.66.66l-1.067 3.443a.5.5 0 0 1-.943.033z\" />\n  <path d=\"M5 17A12 12 0 0 1 17 5\" />\n  <circle cx=\"19\" cy=\"5\" r=\"2\" />\n  <circle cx=\"5\" cy=\"19\" r=\"2\" />"),
    SQUARE_DASHED_MOUSE_POINTER(
        "square-dashed-mouse-pointer",
        "<path d=\"M12.034 12.681a.498.498 0 0 1 .647-.647l9 3.5a.5.5 0 0 1-.033.943l-3.444 1.068a1 1 0 0 0-.66.66l-1.067 3.443a.5.5 0 0 1-.943.033z\" />\n  <path d=\"M5 3a2 2 0 0 0-2 2\" />\n  <path d=\"M19 3a2 2 0 0 1 2 2\" />\n  <path d=\"M5 21a2 2 0 0 1-2-2\" />\n  <path d=\"M9 3h1\" />\n  <path d=\"M9 21h2\" />\n  <path d=\"M14 3h1\" />\n  <path d=\"M3 9v1\" />\n  <path d=\"M21 9v2\" />\n  <path d=\"M3 14v1\" />"),
    SQUARE_DASHED_TEXT(
        "square-dashed-text",
        "<path d=\"M14 21h1\" />\n  <path d=\"M14 3h1\" />\n  <path d=\"M19 3a2 2 0 0 1 2 2\" />\n  <path d=\"M21 14v1\" />\n  <path d=\"M21 19a2 2 0 0 1-2 2\" />\n  <path d=\"M21 9v1\" />\n  <path d=\"M3 14v1\" />\n  <path d=\"M3 9v1\" />\n  <path d=\"M5 21a2 2 0 0 1-2-2\" />\n  <path d=\"M5 3a2 2 0 0 0-2 2\" />\n  <path d=\"M7 12h10\" />\n  <path d=\"M7 16h6\" />\n  <path d=\"M7 8h8\" />\n  <path d=\"M9 21h1\" />\n  <path d=\"M9 3h1\" />"),
    SQUARE_MOUSE_POINTER(
        "square-mouse-pointer",
        "<path d=\"M12.034 12.681a.498.498 0 0 1 .647-.647l9 3.5a.5.5 0 0 1-.033.943l-3.444 1.068a1 1 0 0 0-.66.66l-1.067 3.443a.5.5 0 0 1-.943.033z\" />\n  <path d=\"M21 11V5a2 2 0 0 0-2-2H5a2 2 0 0 0-2 2v14a2 2 0 0 0 2 2h6\" />"),
    STAMP(
        "stamp",
        "<path d=\"M14 13V8.5C14 7 15 7 15 5a3 3 0 0 0-6 0c0 2 1 2 1 3.5V13\" />\n  <path d=\"M20 15.5a2.5 2.5 0 0 0-2.5-2.5h-11A2.5 2.5 0 0 0 4 15.5V17a1 1 0 0 0 1 1h14a1 1 0 0 0 1-1z\" />\n  <path d=\"M5 22h14\" />"),
    TEXT_CURSOR(
        "text-cursor",
        "<path d=\"M17 22h-1a4 4 0 0 1-4-4V6a4 4 0 0 1 4-4h1\" />\n  <path d=\"M7 22h1a4 4 0 0 0 4-4\" />\n  <path d=\"M7 2h1a4 4 0 0 1 4 4\" />"),
    WAND(
        "wand",
        "<path d=\"M15 4V2\" />\n  <path d=\"M15 16v-2\" />\n  <path d=\"M8 9h2\" />\n  <path d=\"M20 9h2\" />\n  <path d=\"M17.8 11.8 19 13\" />\n  <path d=\"M15 9h.01\" />\n  <path d=\"M17.8 6.2 19 5\" />\n  <path d=\"m3 21 9-9\" />\n  <path d=\"M12.2 6.2 11 5\" />"),
    WAND_SPARKLES(
        "wand-sparkles",
        "<path d=\"m21.64 3.64-1.28-1.28a1.21 1.21 0 0 0-1.72 0L2.36 18.64a1.21 1.21 0 0 0 0 1.72l1.28 1.28a1.2 1.2 0 0 0 1.72 0L21.64 5.36a1.2 1.2 0 0 0 0-1.72\" />\n  <path d=\"m14 7 3 3\" />\n  <path d=\"M5 6v4\" />\n  <path d=\"M19 14v4\" />\n  <path d=\"M10 2v2\" />\n  <path d=\"M7 8H3\" />\n  <path d=\"M21 16h-4\" />\n  <path d=\"M11 3H9\" />");

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
  default LucideIcon circle_plus_cursors() {
    return LucideIcon.create(Icon.CIRCLE_PLUS);
  }

  default LucideIcon hand_cursors() {
    return LucideIcon.create(Icon.HAND);
  }

  default LucideIcon hand_grab_cursors() {
    return LucideIcon.create(Icon.HAND_GRAB);
  }

  default LucideIcon lasso_cursors() {
    return LucideIcon.create(Icon.LASSO);
  }

  default LucideIcon lasso_select_cursors() {
    return LucideIcon.create(Icon.LASSO_SELECT);
  }

  default LucideIcon loader_cursors() {
    return LucideIcon.create(Icon.LOADER);
  }

  default LucideIcon loader_circle_cursors() {
    return LucideIcon.create(Icon.LOADER_CIRCLE);
  }

  default LucideIcon loader_pinwheel_cursors() {
    return LucideIcon.create(Icon.LOADER_PINWHEEL);
  }

  default LucideIcon mouse_pointer_cursors() {
    return LucideIcon.create(Icon.MOUSE_POINTER);
  }

  default LucideIcon mouse_pointer_2_cursors() {
    return LucideIcon.create(Icon.MOUSE_POINTER_2);
  }

  default LucideIcon mouse_pointer_2_off_cursors() {
    return LucideIcon.create(Icon.MOUSE_POINTER_2_OFF);
  }

  default LucideIcon mouse_pointer_ban_cursors() {
    return LucideIcon.create(Icon.MOUSE_POINTER_BAN);
  }

  default LucideIcon mouse_pointer_click_cursors() {
    return LucideIcon.create(Icon.MOUSE_POINTER_CLICK);
  }

  default LucideIcon move_cursors() {
    return LucideIcon.create(Icon.MOVE);
  }

  default LucideIcon move_diagonal_cursors() {
    return LucideIcon.create(Icon.MOVE_DIAGONAL);
  }

  default LucideIcon move_diagonal_2_cursors() {
    return LucideIcon.create(Icon.MOVE_DIAGONAL_2);
  }

  default LucideIcon move_horizontal_cursors() {
    return LucideIcon.create(Icon.MOVE_HORIZONTAL);
  }

  default LucideIcon move_vertical_cursors() {
    return LucideIcon.create(Icon.MOVE_VERTICAL);
  }

  default LucideIcon pen_tool_cursors() {
    return LucideIcon.create(Icon.PEN_TOOL);
  }

  default LucideIcon pencil_cursors() {
    return LucideIcon.create(Icon.PENCIL);
  }

  default LucideIcon pencil_off_cursors() {
    return LucideIcon.create(Icon.PENCIL_OFF);
  }

  default LucideIcon pencil_sparkles_cursors() {
    return LucideIcon.create(Icon.PENCIL_SPARKLES);
  }

  default LucideIcon plus_cursors() {
    return LucideIcon.create(Icon.PLUS);
  }

  default LucideIcon pointer() {
    return LucideIcon.create(Icon.POINTER);
  }

  default LucideIcon pointer_off() {
    return LucideIcon.create(Icon.POINTER_OFF);
  }

  default LucideIcon sparkles_cursors() {
    return LucideIcon.create(Icon.SPARKLES);
  }

  default LucideIcon spline_pointer_cursors() {
    return LucideIcon.create(Icon.SPLINE_POINTER);
  }

  default LucideIcon square_dashed_mouse_pointer_cursors() {
    return LucideIcon.create(Icon.SQUARE_DASHED_MOUSE_POINTER);
  }

  default LucideIcon square_dashed_text_cursors() {
    return LucideIcon.create(Icon.SQUARE_DASHED_TEXT);
  }

  default LucideIcon square_mouse_pointer_cursors() {
    return LucideIcon.create(Icon.SQUARE_MOUSE_POINTER);
  }

  default LucideIcon stamp_cursors() {
    return LucideIcon.create(Icon.STAMP);
  }

  default LucideIcon text_cursor_cursors() {
    return LucideIcon.create(Icon.TEXT_CURSOR);
  }

  default LucideIcon wand_cursors() {
    return LucideIcon.create(Icon.WAND);
  }

  default LucideIcon wand_sparkles_cursors() {
    return LucideIcon.create(Icon.WAND_SPARKLES);
  }
}
