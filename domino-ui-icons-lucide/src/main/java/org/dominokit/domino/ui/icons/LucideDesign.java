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

/** Lucide design catalog category. */
public interface LucideDesign {
  enum Icon implements LucideIconDefinition {
    A_ARROW_DOWN(
        "a-arrow-down",
        "<path d=\"m14 12 4 4 4-4\" />\n  <path d=\"M18 16V7\" />\n  <path d=\"m2 16 4.039-9.69a.5.5 0 0 1 .923 0L11 16\" />\n  <path d=\"M3.304 13h6.392\" />"),
    A_ARROW_UP(
        "a-arrow-up",
        "<path d=\"m14 11 4-4 4 4\" />\n  <path d=\"M18 16V7\" />\n  <path d=\"m2 16 4.039-9.69a.5.5 0 0 1 .923 0L11 16\" />\n  <path d=\"M3.304 13h6.392\" />"),
    A_LARGE_SMALL(
        "a-large-small",
        "<path d=\"m15 16 2.536-7.328a1.02 1.02 1 0 1 1.928 0L22 16\" />\n  <path d=\"M15.697 14h5.606\" />\n  <path d=\"m2 16 4.039-9.69a.5.5 0 0 1 .923 0L11 16\" />\n  <path d=\"M3.304 13h6.392\" />"),
    ANGLE(
        "angle",
        "<path d=\"M3 3v16a2 2 0 0 0 2 2h16\" />\n  <path d=\"M3 11a10 10 0 0 1 10 10\" />"),
    APP_WINDOW(
        "app-window",
        "<rect x=\"2\" y=\"4\" width=\"20\" height=\"16\" rx=\"2\" />\n  <path d=\"M10 4v4\" />\n  <path d=\"M2 8h20\" />\n  <path d=\"M6 4v4\" />"),
    APP_WINDOW_MAC(
        "app-window-mac",
        "<rect width=\"20\" height=\"16\" x=\"2\" y=\"4\" rx=\"2\" />\n  <path d=\"M6 8h.01\" />\n  <path d=\"M10 8h.01\" />\n  <path d=\"M14 8h.01\" />"),
    AXIS_3D(
        "axis-3d",
        "<path d=\"M13.5 10.5 15 9\" />\n  <path d=\"M4 4v15a1 1 0 0 0 1 1h15\" />\n  <path d=\"M4.293 19.707 6 18\" />\n  <path d=\"m9 15 1.5-1.5\" />"),
    BETWEEN_HORIZONTAL_END(
        "between-horizontal-end",
        "<rect width=\"13\" height=\"7\" x=\"3\" y=\"3\" rx=\"1\" />\n  <path d=\"m22 15-3-3 3-3\" />\n  <rect width=\"13\" height=\"7\" x=\"3\" y=\"14\" rx=\"1\" />"),
    BETWEEN_HORIZONTAL_START(
        "between-horizontal-start",
        "<rect width=\"13\" height=\"7\" x=\"8\" y=\"3\" rx=\"1\" />\n  <path d=\"m2 9 3 3-3 3\" />\n  <rect width=\"13\" height=\"7\" x=\"8\" y=\"14\" rx=\"1\" />"),
    BETWEEN_VERTICAL_END(
        "between-vertical-end",
        "<rect width=\"7\" height=\"13\" x=\"3\" y=\"3\" rx=\"1\" />\n  <path d=\"m9 22 3-3 3 3\" />\n  <rect width=\"7\" height=\"13\" x=\"14\" y=\"3\" rx=\"1\" />"),
    BETWEEN_VERTICAL_START(
        "between-vertical-start",
        "<rect width=\"7\" height=\"13\" x=\"3\" y=\"8\" rx=\"1\" />\n  <path d=\"m15 2-3 3-3-3\" />\n  <rect width=\"7\" height=\"13\" x=\"14\" y=\"8\" rx=\"1\" />"),
    BLEND(
        "blend", "<circle cx=\"15\" cy=\"9\" r=\"7\" />\n  <circle cx=\"9\" cy=\"15\" r=\"7\" />"),
    BOOK_TYPE(
        "book-type",
        "<path d=\"M10 13h4\" />\n  <path d=\"M12 6v7\" />\n  <path d=\"M16 8V6H8v2\" />\n  <path d=\"M4 19.5v-15A2.5 2.5 0 0 1 6.5 2H19a1 1 0 0 1 1 1v18a1 1 0 0 1-1 1H6.5a1 1 0 0 1 0-5H20\" />"),
    BRING_TO_FRONT(
        "bring-to-front",
        "<rect x=\"8\" y=\"8\" width=\"8\" height=\"8\" rx=\"2\" />\n  <path d=\"M4 10a2 2 0 0 1-2-2V4a2 2 0 0 1 2-2h4a2 2 0 0 1 2 2\" />\n  <path d=\"M14 20a2 2 0 0 0 2 2h4a2 2 0 0 0 2-2v-4a2 2 0 0 0-2-2\" />"),
    BRUSH(
        "brush",
        "<path d=\"m11 10 3 3\" />\n  <path d=\"M6.5 21A3.5 3.5 0 1 0 3 17.5a2.62 2.62 0 0 1-.708 1.792A1 1 0 0 0 3 21z\" />\n  <path d=\"M9.969 17.031 21.378 5.624a1 1 0 0 0-3.002-3.002L6.967 14.031\" />"),
    BRUSH_CLEANING(
        "brush-cleaning",
        "<path d=\"m16 22-1-4\" />\n  <path d=\"M19 14a1 1 0 0 0 1-1v-1a2 2 0 0 0-2-2h-3a1 1 0 0 1-1-1V4a2 2 0 0 0-4 0v5a1 1 0 0 1-1 1H6a2 2 0 0 0-2 2v1a1 1 0 0 0 1 1\" />\n  <path d=\"M19 14H5l-1.973 6.767A1 1 0 0 0 4 22h16a1 1 0 0 0 .973-1.233z\" />\n  <path d=\"m8 22 1-4\" />"),
    CHART_NO_AXES_GANTT(
        "chart-no-axes-gantt",
        "<path d=\"M6 5h12\" />\n  <path d=\"M4 12h10\" />\n  <path d=\"M12 19h8\" />"),
    COLUMNS_2(
        "columns-2",
        "<rect width=\"18\" height=\"18\" x=\"3\" y=\"3\" rx=\"2\" />\n  <path d=\"M12 3v18\" />"),
    COLUMNS_3(
        "columns-3",
        "<rect width=\"18\" height=\"18\" x=\"3\" y=\"3\" rx=\"2\" />\n  <path d=\"M9 3v18\" />\n  <path d=\"M15 3v18\" />"),
    COLUMNS_3_COG(
        "columns-3-cog",
        "<path d=\"M10.6 21H5a2 2 0 01-2-2V5a2 2 0 012-2h14a2 2 0 012 2v5.6\" />\n  <path d=\"m14.305 19.53.923-.382\" />\n  <path d=\"M15 3v7.6\" />\n  <path d=\"m15.229 16.852-.924-.383\" />\n  <path d=\"m16.852 15.228-.383-.923\" />\n  <path d=\"m16.852 20.772-.383.924\" />\n  <path d=\"m19.148 15.228.383-.923\" />\n  <path d=\"m19.53 21.696-.382-.924\" />\n  <path d=\"m20.773 16.852.922-.383\" />\n  <path d=\"m20.773 19.148.922.383\" />\n  <path d=\"M9 3v18\" />\n  <circle cx=\"18\" cy=\"18\" r=\"3\" />"),
    COLUMNS_4(
        "columns-4",
        "<rect width=\"18\" height=\"18\" x=\"3\" y=\"3\" rx=\"2\" />\n  <path d=\"M7.5 3v18\" />\n  <path d=\"M12 3v18\" />\n  <path d=\"M16.5 3v18\" />"),
    COMPONENT(
        "component",
        "<path d=\"M15.536 11.293a1 1 0 0 0 0 1.414l2.376 2.377a1 1 0 0 0 1.414 0l2.377-2.377a1 1 0 0 0 0-1.414l-2.377-2.377a1 1 0 0 0-1.414 0z\" />\n  <path d=\"M2.297 11.293a1 1 0 0 0 0 1.414l2.377 2.377a1 1 0 0 0 1.414 0l2.377-2.377a1 1 0 0 0 0-1.414L6.088 8.916a1 1 0 0 0-1.414 0z\" />\n  <path d=\"M8.916 17.912a1 1 0 0 0 0 1.415l2.377 2.376a1 1 0 0 0 1.414 0l2.377-2.376a1 1 0 0 0 0-1.415l-2.377-2.376a1 1 0 0 0-1.414 0z\" />\n  <path d=\"M8.916 4.674a1 1 0 0 0 0 1.414l2.377 2.376a1 1 0 0 0 1.414 0l2.377-2.376a1 1 0 0 0 0-1.414l-2.377-2.377a1 1 0 0 0-1.414 0z\" />"),
    CONTRAST(
        "contrast",
        "<circle cx=\"12\" cy=\"12\" r=\"10\" />\n  <path d=\"M12 18a6 6 0 0 0 0-12v12z\" />"),
    CROP(
        "crop",
        "<path d=\"M6 2v14a2 2 0 0 0 2 2h14\" />\n  <path d=\"M18 22V8a2 2 0 0 0-2-2H2\" />"),
    CYLINDER(
        "cylinder",
        "<ellipse cx=\"12\" cy=\"5\" rx=\"9\" ry=\"3\" />\n  <path d=\"M3 5v14a9 3 0 0 0 18 0V5\" />"),
    DATABASE_BACKUP(
        "database-backup",
        "<ellipse cx=\"12\" cy=\"5\" rx=\"9\" ry=\"3\" />\n  <path d=\"M3 12a9 3 0 0 0 5 2.69\" />\n  <path d=\"M21 9.3V5\" />\n  <path d=\"M3 5v14a9 3 0 0 0 6.47 2.88\" />\n  <path d=\"M12 12v4h4\" />\n  <path d=\"M13 20a5 5 0 0 0 9-3 4.5 4.5 0 0 0-4.5-4.5c-1.33 0-2.54.54-3.41 1.41L12 16\" />"),
    DECIMALS_ARROW_LEFT(
        "decimals-arrow-left",
        "<path d=\"m13 21-3-3 3-3\" />\n  <path d=\"M20 18H10\" />\n  <path d=\"M3 11h.01\" />\n  <rect x=\"6\" y=\"3\" width=\"5\" height=\"8\" rx=\"2.5\" />"),
    DECIMALS_ARROW_RIGHT(
        "decimals-arrow-right",
        "<path d=\"M10 18h10\" />\n  <path d=\"m17 21 3-3-3-3\" />\n  <path d=\"M3 11h.01\" />\n  <rect x=\"15\" y=\"3\" width=\"5\" height=\"8\" rx=\"2.5\" />\n  <rect x=\"6\" y=\"3\" width=\"5\" height=\"8\" rx=\"2.5\" />"),
    DIAMETER(
        "diameter",
        "<circle cx=\"19\" cy=\"19\" r=\"2\" />\n  <circle cx=\"5\" cy=\"5\" r=\"2\" />\n  <path d=\"M6.48 3.66a10 10 0 0 1 13.86 13.86\" />\n  <path d=\"m6.41 6.41 11.18 11.18\" />\n  <path d=\"M3.66 6.48a10 10 0 0 0 13.86 13.86\" />"),
    DOCK(
        "dock",
        "<path d=\"M2 8h20\" />\n  <rect width=\"20\" height=\"16\" x=\"2\" y=\"4\" rx=\"2\" />\n  <path d=\"M6 16h12\" />"),
    DRAFTING_COMPASS(
        "drafting-compass",
        "<path d=\"m12.99 6.74 1.93 3.44\" />\n  <path d=\"M19.136 12a10 10 0 0 1-14.271 0\" />\n  <path d=\"m21 21-2.16-3.84\" />\n  <path d=\"m3 21 8.02-14.26\" />\n  <circle cx=\"12\" cy=\"5\" r=\"2\" />"),
    ECLIPSE(
        "eclipse",
        "<circle cx=\"12\" cy=\"12\" r=\"10\" />\n  <path d=\"M12 2a7 7 0 1 0 10 10\" />"),
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
    FILE_AXIS_3D(
        "file-axis-3d",
        "<path d=\"M6 22a2 2 0 0 1-2-2V4a2 2 0 0 1 2-2h8a2.4 2.4 0 0 1 1.704.706l3.588 3.588A2.4 2.4 0 0 1 20 8v12a2 2 0 0 1-2 2z\" />\n  <path d=\"M14 2v5a1 1 0 0 0 1 1h5\" />\n  <path d=\"m8 18 4-4\" />\n  <path d=\"M8 10v8h8\" />"),
    FILE_BOX(
        "file-box",
        "<path d=\"M14 2v5a1 1 0 001 1h5\" />\n  <path d=\"M14.692 22H18a2 2 0 002-2V8a2.4 2.4 0 00-.706-1.706l-3.588-3.588A2.4 2.4 0 0014 2H6a2 2 0 00-2 2v3.804\" />\n  <path d=\"M2.264 13.752 7 16.5l4.737-2.748\" />\n  <path d=\"M2.995 13.014A2 2 0 002 14.744v3.516a2 2 0 00.996 1.73l3 1.74a2 2 0 002.008 0l3-1.74A2 2 0 0012 18.26v-3.517a2 2 0 00-.995-1.73l-3-1.742a2 2 0 00-1.892-.064z\" />\n  <path d=\"M7 16.5V22\" />"),
    FOLDER_KANBAN(
        "folder-kanban",
        "<path d=\"M4 20h16a2 2 0 0 0 2-2V8a2 2 0 0 0-2-2h-7.93a2 2 0 0 1-1.66-.9l-.82-1.2A2 2 0 0 0 7.93 3H4a2 2 0 0 0-2 2v13c0 1.1.9 2 2 2Z\" />\n  <path d=\"M8 10v4\" />\n  <path d=\"M12 10v2\" />\n  <path d=\"M16 10v6\" />"),
    FRAME(
        "frame",
        "<line x1=\"22\" x2=\"2\" y1=\"6\" y2=\"6\" />\n  <line x1=\"22\" x2=\"2\" y1=\"18\" y2=\"18\" />\n  <line x1=\"6\" x2=\"6\" y1=\"2\" y2=\"22\" />\n  <line x1=\"18\" x2=\"18\" y1=\"2\" y2=\"22\" />"),
    FULLSCREEN(
        "fullscreen",
        "<path d=\"M3 7V5a2 2 0 0 1 2-2h2\" />\n  <path d=\"M17 3h2a2 2 0 0 1 2 2v2\" />\n  <path d=\"M21 17v2a2 2 0 0 1-2 2h-2\" />\n  <path d=\"M7 21H5a2 2 0 0 1-2-2v-2\" />\n  <rect width=\"10\" height=\"8\" x=\"7\" y=\"8\" rx=\"1\" />"),
    GALLERY_HORIZONTAL(
        "gallery-horizontal",
        "<path d=\"M2 3v18\" />\n  <rect width=\"12\" height=\"18\" x=\"6\" y=\"3\" rx=\"2\" />\n  <path d=\"M22 3v18\" />"),
    GALLERY_HORIZONTAL_END(
        "gallery-horizontal-end",
        "<path d=\"M2 7v10\" />\n  <path d=\"M6 5v14\" />\n  <rect width=\"12\" height=\"18\" x=\"10\" y=\"3\" rx=\"2\" />"),
    GALLERY_THUMBNAILS(
        "gallery-thumbnails",
        "<rect width=\"18\" height=\"14\" x=\"3\" y=\"3\" rx=\"2\" />\n  <path d=\"M4 21h1\" />\n  <path d=\"M9 21h1\" />\n  <path d=\"M14 21h1\" />\n  <path d=\"M19 21h1\" />"),
    GALLERY_VERTICAL(
        "gallery-vertical",
        "<path d=\"M3 2h18\" />\n  <rect width=\"18\" height=\"12\" x=\"3\" y=\"6\" rx=\"2\" />\n  <path d=\"M3 22h18\" />"),
    GALLERY_VERTICAL_END(
        "gallery-vertical-end",
        "<path d=\"M7 2h10\" />\n  <path d=\"M5 6h14\" />\n  <rect width=\"18\" height=\"12\" x=\"3\" y=\"10\" rx=\"2\" />"),
    GAP_HORIZONTAL(
        "gap-horizontal",
        "<path d=\"M12 2v2\" />\n  <path d=\"M12 8v2\" />\n  <path d=\"M12 14v2\" />\n  <path d=\"M12 20v2\" />\n  <path d=\"M21 3h-3a2 2 0 0 0-2 2v14a2 2 0 0 0 2 2h3\" />\n  <path d=\"M3 3h3a2 2 0 0 1 2 2v14a2 2 0 0 1-2 2H3\" />"),
    GAP_VERTICAL(
        "gap-vertical",
        "<path d=\"M2 12h2\" />\n  <path d=\"M8 12h2\" />\n  <path d=\"M14 12h2\" />\n  <path d=\"M20 12h2\" />\n  <path d=\"M3 21v-3a2 2 0 0 1 2-2h14a2 2 0 0 1 2 2v3\" />\n  <path d=\"M3 3v3a2 2 0 0 0 2 2h14a2 2 0 0 0 2-2V3\" />"),
    GRID_2X2(
        "grid-2x2",
        "<path d=\"M12 3v18\" />\n  <path d=\"M3 12h18\" />\n  <rect x=\"3\" y=\"3\" width=\"18\" height=\"18\" rx=\"2\" />"),
    GRID_3X2(
        "grid-3x2",
        "<path d=\"M15 3v18\" />\n  <path d=\"M3 12h18\" />\n  <path d=\"M9 3v18\" />\n  <rect x=\"3\" y=\"3\" width=\"18\" height=\"18\" rx=\"2\" />"),
    GRID_3X3(
        "grid-3x3",
        "<rect width=\"18\" height=\"18\" x=\"3\" y=\"3\" rx=\"2\" />\n  <path d=\"M3 9h18\" />\n  <path d=\"M3 15h18\" />\n  <path d=\"M9 3v18\" />\n  <path d=\"M15 3v18\" />"),
    HAND_GRAB(
        "hand-grab",
        "<path d=\"M18 11.5V9a2 2 0 0 0-2-2a2 2 0 0 0-2 2v1.4\" />\n  <path d=\"M14 10V8a2 2 0 0 0-2-2a2 2 0 0 0-2 2v2\" />\n  <path d=\"M10 9.9V9a2 2 0 0 0-2-2a2 2 0 0 0-2 2v5\" />\n  <path d=\"M6 14a2 2 0 0 0-2-2a2 2 0 0 0-2 2\" />\n  <path d=\"M18 11a2 2 0 1 1 4 0v3a8 8 0 0 1-8 8h-4a8 8 0 0 1-8-8 2 2 0 1 1 4 0\" />"),
    HANDLE_BOTTOM_RIGHT(
        "handle-bottom-right", "<path d=\"M21 8 8 21\" />\n  <path d=\"m21 15-6 6\" />"),
    HEART_X(
        "heart-x",
        "<path d=\"m15.5 12.5 5 5\" />\n  <path d=\"m20.5 12.5-5 5\" />\n  <path d=\"M21.955 8.774a5.5 5.5 0 0 0-9.546-2.95.6.6 0 0 1-.818 0A5.5 5.5 0 0 0 2 9.5c0 2.3 1.5 4 3 5.5l5.508 5.332a2 2 0 0 0 2.57.352\" />"),
    HIGHLIGHTER(
        "highlighter",
        "<path d=\"m9 11-6 6v3h9l3-3\" />\n  <path d=\"m22 12-4.6 4.6a2 2 0 0 1-2.8 0l-5.2-5.2a2 2 0 0 1 0-2.8L14 4\" />"),
    ITERATION_CCW(
        "iteration-ccw", "<path d=\"m16 14 4 4-4 4\" />\n  <path d=\"M20 10a8 8 0 1 0-8 8h8\" />"),
    ITERATION_CW(
        "iteration-cw", "<path d=\"M4 10a8 8 0 1 1 8 8H4\" />\n  <path d=\"m8 22-4-4 4-4\" />"),
    KANBAN("kanban", "<path d=\"M5 3v14\" />\n  <path d=\"M12 3v8\" />\n  <path d=\"M19 3v18\" />"),
    LAND_PLOT(
        "land-plot",
        "<path d=\"m12 8 6-3-6-3v10\" />\n  <path d=\"m8 11.99-5.5 3.14a1 1 0 0 0 0 1.74l8.5 4.86a2 2 0 0 0 2 0l8.5-4.86a1 1 0 0 0 0-1.74L16 12\" />\n  <path d=\"m6.49 12.85 11.02 6.3\" />\n  <path d=\"M17.51 12.85 6.5 19.15\" />"),
    LASSO(
        "lasso",
        "<path d=\"M3.704 14.467a10 8 0 1 1 3.115 2.375\" />\n  <path d=\"M7 22a5 5 0 0 1-2-3.994\" />\n  <circle cx=\"5\" cy=\"16\" r=\"2\" />"),
    LASSO_SELECT(
        "lasso-select",
        "<path d=\"M7 22a5 5 0 0 1-2-4\" />\n  <path d=\"M7 16.93c.96.43 1.96.74 2.99.91\" />\n  <path d=\"M3.34 14A6.8 6.8 0 0 1 2 10c0-4.42 4.48-8 10-8s10 3.58 10 8a7.19 7.19 0 0 1-.33 2\" />\n  <path d=\"M5 18a2 2 0 1 0 0-4 2 2 0 0 0 0 4z\" />\n  <path d=\"M14.33 22h-.09a.35.35 0 0 1-.24-.32v-10a.34.34 0 0 1 .33-.34c.08 0 .15.03.21.08l7.34 6a.33.33 0 0 1-.21.59h-4.49l-2.57 3.85a.35.35 0 0 1-.28.14z\" />"),
    LAYER_ARROW_DOWN(
        "layer-arrow-down",
        "<path d=\"M12 10v10\" />\n  <path d=\"M22 10a1 1 0 01-.59.92l-5.077 2.308\" />\n  <path d=\"M22.017 10.005a1 1 0 00-.597-.916l-8.59-3.91a2 2 0 00-1.66.001L2.6 9.08a1 1 0 00-.02 1.831l5.093 2.316\" />\n  <path d=\"m9 17 3 3 3-3\" />"),
    LAYER_ARROW_UP(
        "layer-arrow-up",
        "<path d=\"M12 14V4\" />\n  <path d=\"M7.674 10.774 2.58 13.09a1 1 0 000 1.822l8.6 3.91a2 2 0 001.65 0l8.58-3.9a1 1 0 00.59-.92 1 1 0 00-.59-.922l-5.078-2.308\" />\n  <path d=\"m9 7 3-3 3 3\" />"),
    LAYERS(
        "layers",
        "<path d=\"M12.83 2.18a2 2 0 0 0-1.66 0L2.6 6.08a1 1 0 0 0 0 1.83l8.58 3.91a2 2 0 0 0 1.66 0l8.58-3.9a1 1 0 0 0 0-1.83z\" />\n  <path d=\"M2 12a1 1 0 0 0 .58.91l8.6 3.91a2 2 0 0 0 1.65 0l8.58-3.9A1 1 0 0 0 22 12\" />\n  <path d=\"M2 17a1 1 0 0 0 .58.91l8.6 3.91a2 2 0 0 0 1.65 0l8.58-3.9A1 1 0 0 0 22 17\" />"),
    LAYERS_2(
        "layers-2",
        "<path d=\"M13 13.74a2 2 0 0 1-2 0L2.5 8.87a1 1 0 0 1 0-1.74L11 2.26a2 2 0 0 1 2 0l8.5 4.87a1 1 0 0 1 0 1.74z\" />\n  <path d=\"m20 14.285 1.5.845a1 1 0 0 1 0 1.74L13 21.74a2 2 0 0 1-2 0l-8.5-4.87a1 1 0 0 1 0-1.74l1.5-.845\" />"),
    LAYERS_ARROW_DOWN(
        "layers-arrow-down",
        "<path d=\"M12 7v15\" />\n  <path d=\"M2 12a1 1 0 00.58.91l5.093 2.316\" />\n  <path d=\"M22 12a1 1 0 01-.59.92l-5.077 2.308\" />\n  <path d=\"M8 10.37 2.6 7.91a1 1 0 010-1.831l8.57-3.9a2 2 0 011.66.001l8.59 3.91a1 1 0 010 1.831l-5.392 2.45\" />\n  <path d=\"m9 19 3 3 3-3\" />"),
    LAYERS_ARROW_UP(
        "layers-arrow-up",
        "<path d=\"M12 12V2\" />\n  <path d=\"M2 17.002a1 1 0 00.58.91l8.6 3.91a2 2 0 001.65 0l8.58-3.9a1 1 0 00.59-.92\" />\n  <path d=\"M7.674 8.774 2.58 11.09a1 1 0 000 1.822l8.6 3.91a2 2 0 001.65 0l8.58-3.9a1 1 0 00.59-.92 1 1 0 00-.59-.922l-5.078-2.308\" />\n  <path d=\"m9 5 3-3 3 3\" />"),
    LAYERS_MINUS(
        "layers-minus",
        "<path d=\"M12.83 2.18a2 2 0 0 0-1.66 0L2.6 6.08a1 1 0 0 0 0 1.83l8.58 3.91a2 2 0 0 0 .83.18 2 2 0 0 0 .83-.18l8.58-3.9a1 1 0 0 0 0-1.832z\" />\n  <path d=\"M16 17h6\" />\n  <path d=\"M2.003 11.995a1 1 0 0 0 .597.915l8.58 3.91a2 2 0 0 0 .83.18\" />\n  <path d=\"M2.003 16.995a1 1 0 0 0 .597.915l8.58 3.91a2 2 0 0 0 .83.18 2 2 0 0 0 .83-.18l2.11-.96\" />\n  <path d=\"M22.018 12.004a1 1 0 0 1-.598.916l-.177.08\" />"),
    LAYERS_PLUS(
        "layers-plus",
        "<path d=\"M12.83 2.18a2 2 0 0 0-1.66 0L2.6 6.08a1 1 0 0 0 0 1.83l8.58 3.91a2 2 0 0 0 .83.18 2 2 0 0 0 .83-.18l8.58-3.9a1 1 0 0 0 0-1.831z\" />\n  <path d=\"M16 17h6\" />\n  <path d=\"M19 14v6\" />\n  <path d=\"M2 12a1 1 0 0 0 .58.91l8.6 3.91a2 2 0 0 0 .825.178\" />\n  <path d=\"M2 17a1 1 0 0 0 .58.91l8.6 3.91a2 2 0 0 0 1.65 0l2.116-.962\" />"),
    LAYOUT_ARROW_DOWN(
        "layout-arrow-down",
        "<rect width=\"7\" height=\"7\" x=\"3\" y=\"3\" rx=\"1\" />\n  <rect width=\"7\" height=\"7\" x=\"3\" y=\"14\" rx=\"1\" />\n  <path d=\"M18 3v18\" />\n  <path d=\"m21 18-3 3-3-3\" />"),
    LAYOUT_ARROW_RIGHT(
        "layout-arrow-right",
        "<rect width=\"7\" height=\"7\" x=\"3\" y=\"3\" rx=\"1\" />\n  <rect width=\"7\" height=\"7\" x=\"14\" y=\"3\" rx=\"1\" />\n  <path d=\"M3 18h18\" />\n  <path d=\"m18 21 3-3-3-3\" />"),
    LAYOUT_DASHBOARD(
        "layout-dashboard",
        "<rect width=\"7\" height=\"9\" x=\"3\" y=\"3\" rx=\"1\" />\n  <rect width=\"7\" height=\"5\" x=\"14\" y=\"3\" rx=\"1\" />\n  <rect width=\"7\" height=\"9\" x=\"14\" y=\"12\" rx=\"1\" />\n  <rect width=\"7\" height=\"5\" x=\"3\" y=\"16\" rx=\"1\" />"),
    LAYOUT_FREEFORM(
        "layout-freeform",
        "<rect width=\"7\" height=\"7\" x=\"3\" y=\"3\" rx=\"1\" />\n  <rect width=\"7\" height=\"7\" x=\"14\" y=\"4\" rx=\"1\" />\n  <rect width=\"7\" height=\"7\" x=\"4\" y=\"14\" rx=\"1\" />"),
    LAYOUT_GRID(
        "layout-grid",
        "<rect width=\"7\" height=\"7\" x=\"3\" y=\"3\" rx=\"1\" />\n  <rect width=\"7\" height=\"7\" x=\"14\" y=\"3\" rx=\"1\" />\n  <rect width=\"7\" height=\"7\" x=\"14\" y=\"14\" rx=\"1\" />\n  <rect width=\"7\" height=\"7\" x=\"3\" y=\"14\" rx=\"1\" />"),
    LAYOUT_GRID_CIRCLES(
        "layout-grid-circles",
        "<circle cx=\"17.5\" cy=\"17.5\" r=\"3.5\" />\n  <circle cx=\"17.5\" cy=\"6.5\" r=\"3.5\" />\n  <circle cx=\"6.5\" cy=\"17.5\" r=\"3.5\" />\n  <circle cx=\"6.5\" cy=\"6.5\" r=\"3.5\" />"),
    LAYOUT_LIST(
        "layout-list",
        "<rect width=\"7\" height=\"7\" x=\"3\" y=\"3\" rx=\"1\" />\n  <rect width=\"7\" height=\"7\" x=\"3\" y=\"14\" rx=\"1\" />\n  <path d=\"M14 4h7\" />\n  <path d=\"M14 9h7\" />\n  <path d=\"M14 15h7\" />\n  <path d=\"M14 20h7\" />"),
    LAYOUT_PANEL_LEFT(
        "layout-panel-left",
        "<rect width=\"7\" height=\"18\" x=\"3\" y=\"3\" rx=\"1\" />\n  <rect width=\"7\" height=\"7\" x=\"14\" y=\"3\" rx=\"1\" />\n  <rect width=\"7\" height=\"7\" x=\"14\" y=\"14\" rx=\"1\" />"),
    LINE_SQUIGGLE(
        "line-squiggle",
        "<path d=\"M7 3.5c5-2 7 2.5 3 4C1.5 10 2 15 5 16c5 2 9-10 14-7s.5 13.5-4 12c-5-2.5.5-11 6-2\" />"),
    LINE_STYLE(
        "line-style",
        "<path d=\"M11 5h2\" />\n  <path d=\"M15 12h6\" />\n  <path d=\"M19 5h2\" />\n  <path d=\"M3 12h6\" />\n  <path d=\"M3 19h18\" />\n  <path d=\"M3 5h2\" />"),
    LOADER(
        "loader",
        "<path d=\"M12 2v4\" />\n  <path d=\"m16.2 7.8 2.9-2.9\" />\n  <path d=\"M18 12h4\" />\n  <path d=\"m16.2 16.2 2.9 2.9\" />\n  <path d=\"M12 18v4\" />\n  <path d=\"m4.9 19.1 2.9-2.9\" />\n  <path d=\"M2 12h4\" />\n  <path d=\"m4.9 4.9 2.9 2.9\" />"),
    LOADER_PINWHEEL(
        "loader-pinwheel",
        "<path d=\"M22 12a1 1 0 0 1-10 0 1 1 0 0 0-10 0\" />\n  <path d=\"M7 20.7a1 1 0 1 1 5-8.7 1 1 0 1 0 5-8.6\" />\n  <path d=\"M7 3.3a1 1 0 1 1 5 8.6 1 1 0 1 0 5 8.6\" />\n  <circle cx=\"12\" cy=\"12\" r=\"10\" />"),
    MAGNET(
        "magnet",
        "<path d=\"m12 15 4 4\" />\n  <path d=\"M2.352 10.648a1.205 1.205 0 0 0 0 1.704l2.296 2.296a1.205 1.205 0 0 0 1.704 0l6.029-6.029a1 1 0 1 1 3 3l-6.029 6.029a1.205 1.205 0 0 0 0 1.704l2.296 2.296a1.205 1.205 0 0 0 1.704 0l6.365-6.367A1 1 0 0 0 8.716 4.282z\" />\n  <path d=\"m5 8 4 4\" />"),
    MAXIMIZE(
        "maximize",
        "<path d=\"M8 3H5a2 2 0 0 0-2 2v3\" />\n  <path d=\"M21 8V5a2 2 0 0 0-2-2h-3\" />\n  <path d=\"M3 16v3a2 2 0 0 0 2 2h3\" />\n  <path d=\"M16 21h3a2 2 0 0 0 2-2v-3\" />"),
    MAXIMIZE_2(
        "maximize-2",
        "<path d=\"M15 3h6v6\" />\n  <path d=\"m21 3-7 7\" />\n  <path d=\"m3 21 7-7\" />\n  <path d=\"M9 21H3v-6\" />"),
    MINIMIZE(
        "minimize",
        "<path d=\"M8 3v3a2 2 0 0 1-2 2H3\" />\n  <path d=\"M21 8h-3a2 2 0 0 1-2-2V3\" />\n  <path d=\"M3 16h3a2 2 0 0 1 2 2v3\" />\n  <path d=\"M16 21v-3a2 2 0 0 1 2-2h3\" />"),
    MINIMIZE_2(
        "minimize-2",
        "<path d=\"m14 10 7-7\" />\n  <path d=\"M20 10h-6V4\" />\n  <path d=\"m3 21 7-7\" />\n  <path d=\"M4 14h6v6\" />"),
    MOP_SPARKLES(
        "mop-sparkles",
        "<path d=\"M10 22a3 3 0 01-3-3\" />\n  <path d=\"M10 22c2.761 0 5-1.79 5-4-4.42 0-4.08-5-8.5-5a4.501 4.501 0 000 9z\" />\n  <path d=\"M10 3H8\" />\n  <path d=\"M12.5 11.5 22 2\" />\n  <path d=\"M20 13v4\" />\n  <path d=\"M22 15h-4\" />\n  <path d=\"M4 5v4\" />\n  <path d=\"M6 7H2\" />\n  <path d=\"m6.98 13.02 2.665-2.664a1.21 1.21 0 011.71 0l2.29 2.288a1.21 1.21 0 010 1.712l-2.088 2.087\" />\n  <path d=\"M9 2v2\" />"),
    MOVE_3D(
        "move-3d",
        "<path d=\"M5 3v16h16\" />\n  <path d=\"m5 19 6-6\" />\n  <path d=\"m2 6 3-3 3 3\" />\n  <path d=\"m18 16 3 3-3 3\" />"),
    NOTEBOOK(
        "notebook",
        "<path d=\"M2 6h4\" />\n  <path d=\"M2 10h4\" />\n  <path d=\"M2 14h4\" />\n  <path d=\"M2 18h4\" />\n  <rect width=\"16\" height=\"20\" x=\"4\" y=\"2\" rx=\"2\" />\n  <path d=\"M16 2v20\" />"),
    ORIGAMI(
        "origami",
        "<path d=\"M12 12V4a1 1 0 0 1 1-1h6.297a1 1 0 0 1 .651 1.759l-4.696 4.025\" />\n  <path d=\"m12 21-7.414-7.414A2 2 0 0 1 4 12.172V6.415a1.002 1.002 0 0 1 1.707-.707L20 20.009\" />\n  <path d=\"m12.214 3.381 8.414 14.966a1 1 0 0 1-.167 1.199l-1.168 1.163a1 1 0 0 1-.706.291H6.351a1 1 0 0 1-.625-.219L3.25 18.8a1 1 0 0 1 .631-1.781l4.165.027\" />"),
    PAINT_BUCKET(
        "paint-bucket",
        "<path d=\"M11 7 6 2\" />\n  <path d=\"M18.992 12H2.041\" />\n  <path d=\"M21.145 18.38A3.34 3.34 0 0 1 20 16.5a3.3 3.3 0 0 1-1.145 1.88c-.575.46-.855 1.02-.855 1.595A2 2 0 0 0 20 22a2 2 0 0 0 2-2.025c0-.58-.285-1.13-.855-1.595\" />\n  <path d=\"m8.5 4.5 2.148-2.148a1.205 1.205 0 0 1 1.704 0l7.296 7.296a1.205 1.205 0 0 1 0 1.704l-7.592 7.592a3.615 3.615 0 0 1-5.112 0l-3.888-3.888a3.615 3.615 0 0 1 0-5.112L5.67 7.33\" />"),
    PAINT_ROLLER(
        "paint-roller",
        "<rect width=\"16\" height=\"6\" x=\"2\" y=\"2\" rx=\"2\" />\n  <path d=\"M10 16v-2a2 2 0 0 1 2-2h8a2 2 0 0 0 2-2V7a2 2 0 0 0-2-2h-2\" />\n  <rect width=\"4\" height=\"6\" x=\"8\" y=\"16\" rx=\"1\" />"),
    PAINTBRUSH(
        "paintbrush",
        "<path d=\"m14.622 17.897-10.68-2.913\" />\n  <path d=\"M18.376 2.622a1 1 0 1 1 3.002 3.002L17.36 9.643a.5.5 0 0 0 0 .707l.944.944a2.41 2.41 0 0 1 0 3.408l-.944.944a.5.5 0 0 1-.707 0L8.354 7.348a.5.5 0 0 1 0-.707l.944-.944a2.41 2.41 0 0 1 3.408 0l.944.944a.5.5 0 0 0 .707 0z\" />\n  <path d=\"M9 8c-1.804 2.71-3.97 3.46-6.583 3.948a.507.507 0 0 0-.302.819l7.32 8.883a1 1 0 0 0 1.185.204C12.735 20.405 16 16.792 16 15\" />"),
    PAINTBRUSH_VERTICAL(
        "paintbrush-vertical",
        "<path d=\"M10 2v2\" />\n  <path d=\"M14 2v4\" />\n  <path d=\"M17 2a1 1 0 0 1 1 1v9H6V3a1 1 0 0 1 1-1z\" />\n  <path d=\"M6 12a1 1 0 0 0-1 1v1a2 2 0 0 0 2 2h2a1 1 0 0 1 1 1v2.9a2 2 0 1 0 4 0V17a1 1 0 0 1 1-1h2a2 2 0 0 0 2-2v-1a1 1 0 0 0-1-1\" />"),
    PALETTE(
        "palette",
        "<path d=\"M12 22a1 1 0 0 1 0-20 10 9 0 0 1 10 9 5 5 0 0 1-5 5h-2.25a1.75 1.75 0 0 0-1.4 2.8l.3.4a1.75 1.75 0 0 1-1.4 2.8z\" />\n  <circle cx=\"13.5\" cy=\"6.5\" r=\".5\" fill=\"currentColor\" />\n  <circle cx=\"17.5\" cy=\"10.5\" r=\".5\" fill=\"currentColor\" />\n  <circle cx=\"6.5\" cy=\"12.5\" r=\".5\" fill=\"currentColor\" />\n  <circle cx=\"8.5\" cy=\"7.5\" r=\".5\" fill=\"currentColor\" />"),
    PANEL_TOP(
        "panel-top",
        "<rect width=\"18\" height=\"18\" x=\"3\" y=\"3\" rx=\"2\" />\n  <path d=\"M3 9h18\" />"),
    PANELS_TOP_LEFT(
        "panels-top-left",
        "<rect width=\"18\" height=\"18\" x=\"3\" y=\"3\" rx=\"2\" />\n  <path d=\"M3 9h18\" />\n  <path d=\"M9 21V9\" />"),
    PAPERCLIP(
        "paperclip",
        "<path d=\"m16 6-8.414 8.586a2 2 0 0 0 2.829 2.829l8.414-8.586a4 4 0 1 0-5.657-5.657l-8.379 8.551a6 6 0 1 0 8.485 8.485l8.379-8.551\" />"),
    PEN(
        "pen",
        "<path d=\"M21.174 6.812a1 1 0 0 0-3.986-3.987L3.842 16.174a2 2 0 0 0-.5.83l-1.321 4.352a.5.5 0 0 0 .623.622l4.353-1.32a2 2 0 0 0 .83-.497z\" />"),
    PEN_LINE(
        "pen-line",
        "<path d=\"M13 21h8\" />\n  <path d=\"M21.174 6.812a1 1 0 0 0-3.986-3.987L3.842 16.174a2 2 0 0 0-.5.83l-1.321 4.352a.5.5 0 0 0 .623.622l4.353-1.32a2 2 0 0 0 .83-.497z\" />"),
    PEN_OFF(
        "pen-off",
        "<path d=\"m10 10-6.157 6.162a2 2 0 0 0-.5.833l-1.322 4.36a.5.5 0 0 0 .622.624l4.358-1.323a2 2 0 0 0 .83-.5L14 13.982\" />\n  <path d=\"m12.829 7.172 4.359-4.346a1 1 0 1 1 3.986 3.986l-4.353 4.353\" />\n  <path d=\"m2 2 20 20\" />"),
    PEN_TOOL(
        "pen-tool",
        "<path d=\"m18 13-.654-4.736a4 4 0 00-2.756-3.266l-9.163-2.9a2 2 0 00-2.017.493l-.82.819a2 2 0 00-.492 2.017l2.9 9.163a4 4 0 003.266 2.756L13 18\" />\n  <path d=\"M18.648 12.352a1.205 1.205 0 011.704 0l1.296 1.296a1.205 1.205 0 010 1.704l-6.296 6.296a1.205 1.205 0 01-1.704 0l-1.296-1.296a1.205 1.205 0 010-1.704z\" />\n  <path d=\"m3 3 6.586 6.586\" />\n  <circle cx=\"11\" cy=\"11\" r=\"2\" />"),
    PENCIL(
        "pencil",
        "<path d=\"M21.174 6.812a1 1 0 0 0-3.986-3.987L3.842 16.174a2 2 0 0 0-.5.83l-1.321 4.352a.5.5 0 0 0 .623.622l4.353-1.32a2 2 0 0 0 .83-.497z\" />\n  <path d=\"m15 5 4 4\" />"),
    PENCIL_LINE(
        "pencil-line",
        "<path d=\"M13 21h8\" />\n  <path d=\"m15 5 4 4\" />\n  <path d=\"M21.174 6.812a1 1 0 0 0-3.986-3.987L3.842 16.174a2 2 0 0 0-.5.83l-1.321 4.352a.5.5 0 0 0 .623.622l4.353-1.32a2 2 0 0 0 .83-.497z\" />"),
    PENCIL_OFF(
        "pencil-off",
        "<path d=\"m10 10-6.157 6.162a2 2 0 0 0-.5.833l-1.322 4.36a.5.5 0 0 0 .622.624l4.358-1.323a2 2 0 0 0 .83-.5L14 13.982\" />\n  <path d=\"m12.829 7.172 4.359-4.346a1 1 0 1 1 3.986 3.986l-4.353 4.353\" />\n  <path d=\"m15 5 4 4\" />\n  <path d=\"m2 2 20 20\" />"),
    PENCIL_RULER(
        "pencil-ruler",
        "<path d=\"M13 7 8.7 2.7a2.41 2.41 0 0 0-3.4 0L2.7 5.3a2.41 2.41 0 0 0 0 3.4L7 13\" />\n  <path d=\"m8 6 2-2\" />\n  <path d=\"m18 16 2-2\" />\n  <path d=\"m17 11 4.3 4.3c.94.94.94 2.46 0 3.4l-2.6 2.6c-.94.94-2.46.94-3.4 0L11 17\" />\n  <path d=\"M21.174 6.812a1 1 0 0 0-3.986-3.987L3.842 16.174a2 2 0 0 0-.5.83l-1.321 4.352a.5.5 0 0 0 .623.622l4.353-1.32a2 2 0 0 0 .83-.497z\" />\n  <path d=\"m15 5 4 4\" />"),
    PENCIL_SPARKLES(
        "pencil-sparkles",
        "<path d=\"M10 3H8\" />\n  <path d=\"m15.007 5.008 3.987 3.986\" />\n  <path d=\"M20 15v4\" />\n  <path d=\"M21.174 6.813a2.82 2.82 0 0 0-3.986-3.987L3.842 16.175a2 2 0 0 0-.5.83l-1.321 4.352a.5.5 0 0 0 .623.622l4.353-1.32a2 2 0 0 0 .83-.497z\" />\n  <path d=\"M22 17h-4\" />\n  <path d=\"M4 5v4\" />\n  <path d=\"M6 7H2\" />\n  <path d=\"M9 2v2\" />"),
    PIPETTE(
        "pipette",
        "<path d=\"m12 9-8.414 8.414A2 2 0 0 0 3 18.828v1.344a2 2 0 0 1-.586 1.414A2 2 0 0 1 3.828 21h1.344a2 2 0 0 0 1.414-.586L15 12\" />\n  <path d=\"m18 9 .4.4a1 1 0 1 1-3 3l-3.8-3.8a1 1 0 1 1 3-3l.4.4 3.4-3.4a1 1 0 1 1 3 3z\" />\n  <path d=\"m2 22 .414-.414\" />"),
    PRESENTATION(
        "presentation",
        "<path d=\"M2 3h20\" />\n  <path d=\"M21 3v11a2 2 0 0 1-2 2H5a2 2 0 0 1-2-2V3\" />\n  <path d=\"m7 21 5-5 5 5\" />"),
    PROPORTIONS(
        "proportions",
        "<rect width=\"20\" height=\"16\" x=\"2\" y=\"4\" rx=\"2\" />\n  <path d=\"M12 9v11\" />\n  <path d=\"M2 9h13a2 2 0 0 1 2 2v9\" />"),
    RADIUS(
        "radius",
        "<path d=\"M20.34 17.52a10 10 0 1 0-2.82 2.82\" />\n  <circle cx=\"19\" cy=\"19\" r=\"2\" />\n  <path d=\"m13.41 13.41 4.18 4.18\" />\n  <circle cx=\"12\" cy=\"12\" r=\"2\" />"),
    RATIO(
        "ratio",
        "<rect width=\"12\" height=\"20\" x=\"6\" y=\"2\" rx=\"2\" />\n  <rect width=\"20\" height=\"12\" x=\"2\" y=\"6\" rx=\"2\" />"),
    RECTANGLE_HORIZONTAL(
        "rectangle-horizontal", "<rect width=\"20\" height=\"12\" x=\"2\" y=\"6\" rx=\"2\" />"),
    RECTANGLE_VERTICAL(
        "rectangle-vertical", "<rect width=\"12\" height=\"20\" x=\"6\" y=\"2\" rx=\"2\" />"),
    ROTATE_3D(
        "rotate-3d",
        "<path d=\"m15.194 13.707 3.814 1.86-1.86 3.814\" />\n  <path d=\"M16.47214 7.52786 A 5 10 0 1 0 13 21.79796\" />\n  <path d=\"M21.79796 11 A 10 5 0 1 0 19 15.57071\" />"),
    ROTATE_CCW(
        "rotate-ccw",
        "<path d=\"M3 12a9 9 0 1 0 9-9 9.75 9.75 0 0 0-6.74 2.74L3 8\" />\n  <path d=\"M3 3v5h5\" />"),
    ROTATE_CCW_SQUARE(
        "rotate-ccw-square",
        "<path d=\"M20 9V7a2 2 0 0 0-2-2h-6\" />\n  <path d=\"m15 2-3 3 3 3\" />\n  <path d=\"M20 13v5a2 2 0 0 1-2 2H6a2 2 0 0 1-2-2V7a2 2 0 0 1 2-2h2\" />"),
    ROTATE_CW(
        "rotate-cw",
        "<path d=\"M21 12a9 9 0 1 1-9-9c2.52 0 4.93 1 6.74 2.74L21 8\" />\n  <path d=\"M21 3v5h-5\" />"),
    ROTATE_CW_SQUARE(
        "rotate-cw-square",
        "<path d=\"M12 5H6a2 2 0 0 0-2 2v3\" />\n  <path d=\"m9 8 3-3-3-3\" />\n  <path d=\"M4 14v4a2 2 0 0 0 2 2h12a2 2 0 0 0 2-2V7a2 2 0 0 0-2-2h-2\" />"),
    ROWS_2(
        "rows-2",
        "<rect width=\"18\" height=\"18\" x=\"3\" y=\"3\" rx=\"2\" />\n  <path d=\"M3 12h18\" />"),
    ROWS_3(
        "rows-3",
        "<rect width=\"18\" height=\"18\" x=\"3\" y=\"3\" rx=\"2\" />\n  <path d=\"M21 9H3\" />\n  <path d=\"M21 15H3\" />"),
    ROWS_4(
        "rows-4",
        "<rect width=\"18\" height=\"18\" x=\"3\" y=\"3\" rx=\"2\" />\n  <path d=\"M21 7.5H3\" />\n  <path d=\"M21 12H3\" />\n  <path d=\"M21 16.5H3\" />"),
    RULER(
        "ruler",
        "<path d=\"M21.3 15.3a2.4 2.4 0 0 1 0 3.4l-2.6 2.6a2.4 2.4 0 0 1-3.4 0L2.7 8.7a2.41 2.41 0 0 1 0-3.4l2.6-2.6a2.41 2.41 0 0 1 3.4 0Z\" />\n  <path d=\"m14.5 12.5 2-2\" />\n  <path d=\"m11.5 9.5 2-2\" />\n  <path d=\"m8.5 6.5 2-2\" />\n  <path d=\"m17.5 15.5 2-2\" />"),
    RULER_DIMENSION_LINE(
        "ruler-dimension-line",
        "<path d=\"M10 15v-3\" />\n  <path d=\"M14 15v-3\" />\n  <path d=\"M18 15v-3\" />\n  <path d=\"M2 8V4\" />\n  <path d=\"M22 6H2\" />\n  <path d=\"M22 8V4\" />\n  <path d=\"M6 15v-3\" />\n  <rect x=\"2\" y=\"12\" width=\"20\" height=\"8\" rx=\"2\" />"),
    SCALE_3D(
        "scale-3d",
        "<path d=\"M5 7v11a1 1 0 0 0 1 1h11\" />\n  <path d=\"M5.293 18.707 11 13\" />\n  <circle cx=\"19\" cy=\"19\" r=\"2\" />\n  <circle cx=\"5\" cy=\"5\" r=\"2\" />"),
    SCALING(
        "scaling",
        "<path d=\"M12 3H5a2 2 0 0 0-2 2v14a2 2 0 0 0 2 2h14a2 2 0 0 0 2-2v-7\" />\n  <path d=\"M14 15H9v-5\" />\n  <path d=\"M16 3h5v5\" />\n  <path d=\"M21 3 9 15\" />"),
    SCAN_BOX(
        "scan-box",
        "<path d=\"M12 12v5.5\" />\n  <path d=\"M17 3h2a2 2 0 012 2v2\" />\n  <path d=\"M21 17v2a2 2 0 01-2 2h-2\" />\n  <path d=\"M3 7V5a2 2 0 012-2h2\" />\n  <path d=\"M7 21H5a2 2 0 01-2-2v-2\" />\n  <path d=\"M7.264 9.252 12 12l4.737-2.748\" />\n  <path d=\"M7.995 8.514A2 2 0 007 10.244v3.516a2 2 0 00.996 1.73l3 1.74a2 2 0 002.008 0l3-1.74A2 2 0 0017 13.76v-3.517a2 2 0 00-.995-1.73l-3-1.742a2 2 0 00-1.892-.064z\" />"),
    SCAN_SQUARE(
        "scan-square",
        "<path d=\"M3 7V5a2 2 0 0 1 2-2h2\" />\n  <path d=\"M17 3h2a2 2 0 0 1 2 2v2\" />\n  <path d=\"M21 17v2a2 2 0 0 1-2 2h-2\" />\n  <path d=\"M7 21H5a2 2 0 0 1-2-2v-2\" />\n  <rect width=\"8\" height=\"8\" x=\"8\" y=\"8\" rx=\"1\" />"),
    SCISSORS(
        "scissors",
        "<circle cx=\"6\" cy=\"6\" r=\"3\" />\n  <path d=\"M8.12 8.12 12 12\" />\n  <path d=\"M20 4 8.12 15.88\" />\n  <circle cx=\"6\" cy=\"18\" r=\"3\" />\n  <path d=\"M14.8 14.8 20 20\" />"),
    SCISSORS_LINE_DASHED(
        "scissors-line-dashed",
        "<path d=\"M5.42 9.42 8 12\" />\n  <circle cx=\"4\" cy=\"8\" r=\"2\" />\n  <path d=\"m14 6-8.58 8.58\" />\n  <circle cx=\"4\" cy=\"16\" r=\"2\" />\n  <path d=\"M10.8 14.8 14 18\" />\n  <path d=\"M16 12h-2\" />\n  <path d=\"M22 12h-2\" />"),
    SEND_TO_BACK(
        "send-to-back",
        "<rect x=\"14\" y=\"14\" width=\"8\" height=\"8\" rx=\"2\" />\n  <rect x=\"2\" y=\"2\" width=\"8\" height=\"8\" rx=\"2\" />\n  <path d=\"M7 14v1a2 2 0 0 0 2 2h1\" />\n  <path d=\"M14 7h1a2 2 0 0 1 2 2v1\" />"),
    SLICE(
        "slice",
        "<path d=\"M11 16.586V19a1 1 0 0 1-1 1H2L18.37 3.63a1 1 0 1 1 3 3l-9.663 9.663a1 1 0 0 1-1.414 0L8 14\" />"),
    SPLINE(
        "spline",
        "<circle cx=\"19\" cy=\"5\" r=\"2\" />\n  <circle cx=\"5\" cy=\"19\" r=\"2\" />\n  <path d=\"M5 17A12 12 0 0 1 17 5\" />"),
    SPLINE_POINTER(
        "spline-pointer",
        "<path d=\"M12.034 12.681a.498.498 0 0 1 .647-.647l9 3.5a.5.5 0 0 1-.033.943l-3.444 1.068a1 1 0 0 0-.66.66l-1.067 3.443a.5.5 0 0 1-.943.033z\" />\n  <path d=\"M5 17A12 12 0 0 1 17 5\" />\n  <circle cx=\"19\" cy=\"5\" r=\"2\" />\n  <circle cx=\"5\" cy=\"19\" r=\"2\" />"),
    SPRAY_CAN(
        "spray-can",
        "<path d=\"M3 3h.01\" />\n  <path d=\"M7 5h.01\" />\n  <path d=\"M11 7h.01\" />\n  <path d=\"M3 7h.01\" />\n  <path d=\"M7 9h.01\" />\n  <path d=\"M3 11h.01\" />\n  <rect width=\"4\" height=\"4\" x=\"15\" y=\"5\" />\n  <path d=\"m19 9 2 2v10c0 .6-.4 1-1 1h-6c-.6 0-1-.4-1-1V11l2-2\" />\n  <path d=\"m13 14 8-2\" />\n  <path d=\"m13 19 8-2\" />"),
    SQUARE_BOTTOM_DASHED_SCISSORS(
        "square-bottom-dashed-scissors",
        "<path d=\"M14 21h1\" />\n  <path d=\"m17 17-2.18-2.18\" />\n  <path d=\"M5 21a2 2 0 01-2-2V5a2 2 0 012-2h14a2 2 0 012 2v14a2 2 0 01-2 2\" />\n  <path d=\"M9 21h1\" />\n  <path d=\"M9.56 14.44 17 7\" />\n  <path d=\"M9.56 9.56 12 12\" />\n  <circle cx=\"8.5\" cy=\"15.5\" r=\"1.5\" />\n  <circle cx=\"8.5\" cy=\"8.5\" r=\"1.5\" />"),
    SQUARE_CENTERLINE_DASHED_HORIZONTAL(
        "square-centerline-dashed-horizontal",
        "<path d=\"M8 3H5a2 2 0 0 0-2 2v14c0 1.1.9 2 2 2h3\" />\n  <path d=\"M16 3h3a2 2 0 0 1 2 2v14a2 2 0 0 1-2 2h-3\" />\n  <path d=\"M12 20v2\" />\n  <path d=\"M12 14v2\" />\n  <path d=\"M12 8v2\" />\n  <path d=\"M12 2v2\" />"),
    SQUARE_CENTERLINE_DASHED_VERTICAL(
        "square-centerline-dashed-vertical",
        "<path d=\"M21 8V5a2 2 0 0 0-2-2H5a2 2 0 0 0-2 2v3\" />\n  <path d=\"M21 16v3a2 2 0 0 1-2 2H5a2 2 0 0 1-2-2v-3\" />\n  <path d=\"M4 12H2\" />\n  <path d=\"M10 12H8\" />\n  <path d=\"M16 12h-2\" />\n  <path d=\"M22 12h-2\" />"),
    SQUARE_CHART_GANTT(
        "square-chart-gantt",
        "<rect width=\"18\" height=\"18\" x=\"3\" y=\"3\" rx=\"2\" />\n  <path d=\"M9 8h7\" />\n  <path d=\"M8 12h6\" />\n  <path d=\"M11 16h5\" />"),
    SQUARE_DASHED(
        "square-dashed",
        "<path d=\"M5 3a2 2 0 0 0-2 2\" />\n  <path d=\"M19 3a2 2 0 0 1 2 2\" />\n  <path d=\"M21 19a2 2 0 0 1-2 2\" />\n  <path d=\"M5 21a2 2 0 0 1-2-2\" />\n  <path d=\"M9 3h1\" />\n  <path d=\"M9 21h1\" />\n  <path d=\"M14 3h1\" />\n  <path d=\"M14 21h1\" />\n  <path d=\"M3 9v1\" />\n  <path d=\"M21 9v1\" />\n  <path d=\"M3 14v1\" />\n  <path d=\"M21 14v1\" />"),
    SQUARE_DASHED_KANBAN(
        "square-dashed-kanban",
        "<path d=\"M8 7v7\" />\n  <path d=\"M12 7v4\" />\n  <path d=\"M16 7v9\" />\n  <path d=\"M5 3a2 2 0 0 0-2 2\" />\n  <path d=\"M9 3h1\" />\n  <path d=\"M14 3h1\" />\n  <path d=\"M19 3a2 2 0 0 1 2 2\" />\n  <path d=\"M21 9v1\" />\n  <path d=\"M21 14v1\" />\n  <path d=\"M21 19a2 2 0 0 1-2 2\" />\n  <path d=\"M14 21h1\" />\n  <path d=\"M9 21h1\" />\n  <path d=\"M5 21a2 2 0 0 1-2-2\" />\n  <path d=\"M3 14v1\" />\n  <path d=\"M3 9v1\" />"),
    SQUARE_DASHED_PLUS(
        "square-dashed-plus",
        "<path d=\"M5 3a2 2 0 0 0-2 2\" />\n  <path d=\"M19 3a2 2 0 0 1 2 2\" />\n  <path d=\"M21 19a2 2 0 0 1-2 2\" />\n  <path d=\"M5 21a2 2 0 0 1-2-2\" />\n  <path d=\"M9 3h1\" />\n  <path d=\"M9 21h1\" />\n  <path d=\"M14 3h1\" />\n  <path d=\"M14 21h1\" />\n  <path d=\"M3 9v1\" />\n  <path d=\"M21 9v1\" />\n  <path d=\"M3 14v1\" />\n  <path d=\"M21 14v1\" />\n  <path d=\"M8 12h8\" />\n  <path d=\"M12 8v8\" />"),
    SQUARE_DASHED_TOP_SOLID(
        "square-dashed-top-solid",
        "<path d=\"M14 21h1\" />\n  <path d=\"M21 14v1\" />\n  <path d=\"M21 19a2 2 0 0 1-2 2\" />\n  <path d=\"M21 9v1\" />\n  <path d=\"M3 14v1\" />\n  <path d=\"M3 5a2 2 0 0 1 2-2h14a2 2 0 0 1 2 2\" />\n  <path d=\"M3 9v1\" />\n  <path d=\"M5 21a2 2 0 0 1-2-2\" />\n  <path d=\"M9 21h1\" />"),
    SQUARE_DASHED_X(
        "square-dashed-x",
        "<path d=\"M14 21h1\" />\n  <path d=\"M14 3h1\" />\n  <path d=\"M19 3a2 2 0 012 2\" />\n  <path d=\"M21 14v1\" />\n  <path d=\"M21 19a2 2 0 01-2 2\" />\n  <path d=\"M21 9v1\" />\n  <path d=\"M3 14v1\" />\n  <path d=\"M3 9v1\" />\n  <path d=\"M5 21a2 2 0 01-2-2\" />\n  <path d=\"M5 3a2 2 0 00-2 2\" />\n  <path d=\"m9 15 6-6\" />\n  <path d=\"M9 21h1\" />\n  <path d=\"M9 3h1\" />\n  <path d=\"m9 9 6 6\" />"),
    SQUARE_DASHED_X_CORNER(
        "square-dashed-x-corner",
        "<path d=\"M14 3h1\" />\n  <path d=\"m16 16 5 5\" />\n  <path d=\"M19 3a2 2 0 012 2\" />\n  <path d=\"m21 16-5 5\" />\n  <path d=\"M21 9v1\" />\n  <path d=\"M3 14v1\" />\n  <path d=\"M3 9v1\" />\n  <path d=\"M5 21a2 2 0 01-2-2\" />\n  <path d=\"M5 3a2 2 0 00-2 2\" />\n  <path d=\"M9 21h1\" />\n  <path d=\"M9 3h1\" />"),
    SQUARE_DIMENSIONS(
        "square-dimensions",
        "<rect width=\"18\" height=\"18\" x=\"3\" y=\"3\" rx=\"2\" />\n  <path d=\"M12 7H7v5\" />\n  <path d=\"M12 17h5v-5\" />"),
    SQUARE_KANBAN(
        "square-kanban",
        "<rect width=\"18\" height=\"18\" x=\"3\" y=\"3\" rx=\"2\" />\n  <path d=\"M8 7v7\" />\n  <path d=\"M12 7v4\" />\n  <path d=\"M16 7v9\" />"),
    SQUARE_OFF(
        "square-off",
        "<path d=\"M20.4 20.4a2 2 0 01-1.4.6H5a2 2 0 01-2-2V5a2 2 0 01.59-1.41\" />\n  <path d=\"M21 15.3V5a2 2 0 00-2-2H8.7\" />\n  <path d=\"M22 22 2 2\" />"),
    SQUARE_ROUND_CORNER(
        "square-round-corner",
        "<path d=\"M21 11a8 8 0 0 0-8-8\" />\n  <path d=\"M21 15v4a2 2 0 0 1-2 2H5a2 2 0 0 1-2-2V5a2 2 0 0 1 2-2h4\" />"),
    SQUARE_SCISSORS(
        "square-scissors",
        "<path d=\"m17 17-2.18-2.18\" />\n  <path d=\"M9.56 14.44 17 7\" />\n  <path d=\"M9.56 9.56 12 12\" />\n  <circle cx=\"8.5\" cy=\"15.5\" r=\"1.5\" />\n  <circle cx=\"8.5\" cy=\"8.5\" r=\"1.5\" />\n  <rect x=\"3\" y=\"3\" width=\"18\" height=\"18\" rx=\"2\" />"),
    SQUARES_EXCLUDE(
        "squares-exclude",
        "<path d=\"M16 12v2a2 2 0 0 1-2 2H9a1 1 0 0 0-1 1v3a2 2 0 0 0 2 2h10a2 2 0 0 0 2-2V10a2 2 0 0 0-2-2h0\" />\n  <path d=\"M4 16a2 2 0 0 1-2-2V4a2 2 0 0 1 2-2h10a2 2 0 0 1 2 2v3a1 1 0 0 1-1 1h-5a2 2 0 0 0-2 2v2\" />"),
    SQUARES_INTERSECT(
        "squares-intersect",
        "<path d=\"M10 22a2 2 0 0 1-2-2\" />\n  <path d=\"M14 2a2 2 0 0 1 2 2\" />\n  <path d=\"M16 22h-2\" />\n  <path d=\"M2 10V8\" />\n  <path d=\"M2 4a2 2 0 0 1 2-2\" />\n  <path d=\"M20 8a2 2 0 0 1 2 2\" />\n  <path d=\"M22 14v2\" />\n  <path d=\"M22 20a2 2 0 0 1-2 2\" />\n  <path d=\"M4 16a2 2 0 0 1-2-2\" />\n  <path d=\"M8 10a2 2 0 0 1 2-2h5a1 1 0 0 1 1 1v5a2 2 0 0 1-2 2H9a1 1 0 0 1-1-1z\" />\n  <path d=\"M8 2h2\" />"),
    SQUARES_SUBTRACT(
        "squares-subtract",
        "<path d=\"M10 22a2 2 0 0 1-2-2\" />\n  <path d=\"M16 22h-2\" />\n  <path d=\"M16 4a2 2 0 0 0-2-2H4a2 2 0 0 0-2 2v10a2 2 0 0 0 2 2h3a1 1 0 0 0 1-1v-5a2 2 0 0 1 2-2h5a1 1 0 0 0 1-1z\" />\n  <path d=\"M20 8a2 2 0 0 1 2 2\" />\n  <path d=\"M22 14v2\" />\n  <path d=\"M22 20a2 2 0 0 1-2 2\" />"),
    SQUARES_UNITE(
        "squares-unite",
        "<path d=\"M4 16a2 2 0 0 1-2-2V4a2 2 0 0 1 2-2h10a2 2 0 0 1 2 2v3a1 1 0 0 0 1 1h3a2 2 0 0 1 2 2v10a2 2 0 0 1-2 2H10a2 2 0 0 1-2-2v-3a1 1 0 0 0-1-1z\" />"),
    SQUIRCLE_DASHED(
        "squircle-dashed",
        "<path d=\"M13.77 3.043a34 34 0 0 0-3.54 0\" />\n  <path d=\"M13.771 20.956a33 33 0 0 1-3.541.001\" />\n  <path d=\"M20.18 17.74c-.51 1.15-1.29 1.93-2.439 2.44\" />\n  <path d=\"M20.18 6.259c-.51-1.148-1.291-1.929-2.44-2.438\" />\n  <path d=\"M20.957 10.23a33 33 0 0 1 0 3.54\" />\n  <path d=\"M3.043 10.23a34 34 0 0 0 .001 3.541\" />\n  <path d=\"M6.26 20.179c-1.15-.508-1.93-1.29-2.44-2.438\" />\n  <path d=\"M6.26 3.82c-1.149.51-1.93 1.291-2.44 2.44\" />"),
    STAMP(
        "stamp",
        "<path d=\"M14 13V8.5C14 7 15 7 15 5a3 3 0 0 0-6 0c0 2 1 2 1 3.5V13\" />\n  <path d=\"M20 15.5a2.5 2.5 0 0 0-2.5-2.5h-11A2.5 2.5 0 0 0 4 15.5V17a1 1 0 0 0 1 1h14a1 1 0 0 0 1-1z\" />\n  <path d=\"M5 22h14\" />"),
    SWATCH_BOOK(
        "swatch-book",
        "<path d=\"M11 17a4 4 0 0 1-8 0V5a2 2 0 0 1 2-2h4a2 2 0 0 1 2 2Z\" />\n  <path d=\"M16.7 13H19a2 2 0 0 1 2 2v4a2 2 0 0 1-2 2H7\" />\n  <path d=\"M 7 17h.01\" />\n  <path d=\"m11 8 2.3-2.3a2.4 2.4 0 0 1 3.404.004L18.6 7.6a2.4 2.4 0 0 1 .026 3.434L9.9 19.8\" />"),
    TABLET_SMARTPHONE(
        "tablet-smartphone",
        "<rect width=\"10\" height=\"14\" x=\"3\" y=\"8\" rx=\"2\" />\n  <path d=\"M5 4a2 2 0 0 1 2-2h12a2 2 0 0 1 2 2v16a2 2 0 0 1-2 2h-2.4\" />\n  <path d=\"M8 18h.01\" />"),
    TANGENT(
        "tangent",
        "<circle cx=\"17\" cy=\"4\" r=\"2\" />\n  <path d=\"M15.59 5.41 5.41 15.59\" />\n  <circle cx=\"4\" cy=\"17\" r=\"2\" />\n  <path d=\"M12 22s-4-9-1.5-11.5S22 12 22 12\" />"),
    TORUS(
        "torus",
        "<ellipse cx=\"12\" cy=\"11\" rx=\"3\" ry=\"2\" />\n  <ellipse cx=\"12\" cy=\"12.5\" rx=\"10\" ry=\"8.5\" />"),
    TRIANGLES_CENTERLINE_DASHED_HORIZONTAL(
        "triangles-centerline-dashed-horizontal",
        "<path d=\"M10 12H8\" />\n  <path d=\"M16 12h-2\" />\n  <path d=\"M22 12h-2\" />\n  <path d=\"M4 12H2\" />\n  <path d=\"M7.298 20.288A1 1 0 008 22h8a1 1 0 00.703-1.712l-3.991-3.99a1 1 0 00-1.424-.001z\" />\n  <path d=\"M7.298 3.712A1 1 0 018 2h8a1 1 0 01.703 1.712l-3.991 3.99a1 1 0 01-1.424.001z\" />"),
    TRIANGLES_CENTERLINE_DASHED_VERTICAL(
        "triangles-centerline-dashed-vertical",
        "<path d=\"M12 14v2\" />\n  <path d=\"M12 20v2\" />\n  <path d=\"M12 2v2\" />\n  <path d=\"M12 8v2\" />\n  <path d=\"M20.288 16.703A1 1 0 0022 16V8a1 1 0 00-1.712-.703l-3.99 3.991a1 1 0 00-.001 1.424z\" />\n  <path d=\"M3.712 16.703A1 1 0 012 16V8a1 1 0 011.712-.703l3.99 3.991a1 1 0 01.001 1.424z\" />"),
    VECTOR_POLYGON(
        "vector-polygon",
        "<path d=\"m12.828 4.813 5.344 2.375\" />\n  <path d=\"m15.769 18.153 3.461-8.306\" />\n  <path d=\"m5.687 14.074 7.625 4.852\" />\n  <path d=\"M9.772 5.579 5.228 11.42\" />\n  <circle cx=\"11\" cy=\"4\" r=\"2\" />\n  <circle cx=\"15\" cy=\"20\" r=\"2\" />\n  <circle cx=\"20\" cy=\"8\" r=\"2\" />\n  <circle cx=\"4\" cy=\"13\" r=\"2\" />"),
    VECTOR_SQUARE(
        "vector-square",
        "<path d=\"M17.055 4.533a24 24 0 00-10.11 0\" />\n  <path d=\"M19.467 17.055a24 24 0 000-10.11\" />\n  <path d=\"M4.533 6.945a24 24 0 000 10.11\" />\n  <path d=\"M6.945 19.467a24 24 0 0010.11 0\" />\n  <circle cx=\"19\" cy=\"19\" r=\"2\" />\n  <circle cx=\"19\" cy=\"5\" r=\"2\" />\n  <circle cx=\"5\" cy=\"19\" r=\"2\" />\n  <circle cx=\"5\" cy=\"5\" r=\"2\" />"),
    VIEW(
        "view",
        "<path d=\"M21 17v2a2 2 0 0 1-2 2H5a2 2 0 0 1-2-2v-2\" />\n  <path d=\"M21 7V5a2 2 0 0 0-2-2H5a2 2 0 0 0-2 2v2\" />\n  <circle cx=\"12\" cy=\"12\" r=\"1\" />\n  <path d=\"M18.944 12.33a1 1 0 0 0 0-.66 7.5 7.5 0 0 0-13.888 0 1 1 0 0 0 0 .66 7.5 7.5 0 0 0 13.888 0\" />"),
    WAND(
        "wand",
        "<path d=\"M15 4V2\" />\n  <path d=\"M15 16v-2\" />\n  <path d=\"M8 9h2\" />\n  <path d=\"M20 9h2\" />\n  <path d=\"M17.8 11.8 19 13\" />\n  <path d=\"M15 9h.01\" />\n  <path d=\"M17.8 6.2 19 5\" />\n  <path d=\"m3 21 9-9\" />\n  <path d=\"M12.2 6.2 11 5\" />"),
    WAND_SPARKLES(
        "wand-sparkles",
        "<path d=\"m21.64 3.64-1.28-1.28a1.21 1.21 0 0 0-1.72 0L2.36 18.64a1.21 1.21 0 0 0 0 1.72l1.28 1.28a1.2 1.2 0 0 0 1.72 0L21.64 5.36a1.2 1.2 0 0 0 0-1.72\" />\n  <path d=\"m14 7 3 3\" />\n  <path d=\"M5 6v4\" />\n  <path d=\"M19 14v4\" />\n  <path d=\"M10 2v2\" />\n  <path d=\"M7 8H3\" />\n  <path d=\"M21 16h-4\" />\n  <path d=\"M11 3H9\" />"),
    ZOOM_IN(
        "zoom-in",
        "<circle cx=\"11\" cy=\"11\" r=\"8\" />\n  <line x1=\"21\" x2=\"16.65\" y1=\"21\" y2=\"16.65\" />\n  <line x1=\"11\" x2=\"11\" y1=\"8\" y2=\"14\" />\n  <line x1=\"8\" x2=\"14\" y1=\"11\" y2=\"11\" />"),
    ZOOM_OUT(
        "zoom-out",
        "<circle cx=\"11\" cy=\"11\" r=\"8\" />\n  <line x1=\"21\" x2=\"16.65\" y1=\"21\" y2=\"16.65\" />\n  <line x1=\"8\" x2=\"14\" y1=\"11\" y2=\"11\" />");

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
  default LucideIcon a_arrow_down_design() {
    return LucideIcon.create(Icon.A_ARROW_DOWN);
  }

  default LucideIcon a_arrow_up_design() {
    return LucideIcon.create(Icon.A_ARROW_UP);
  }

  default LucideIcon a_large_small_design() {
    return LucideIcon.create(Icon.A_LARGE_SMALL);
  }

  default LucideIcon angle_design() {
    return LucideIcon.create(Icon.ANGLE);
  }

  default LucideIcon app_window_design() {
    return LucideIcon.create(Icon.APP_WINDOW);
  }

  default LucideIcon app_window_mac_design() {
    return LucideIcon.create(Icon.APP_WINDOW_MAC);
  }

  default LucideIcon axis_3d() {
    return LucideIcon.create(Icon.AXIS_3D);
  }

  default LucideIcon between_horizontal_end_design() {
    return LucideIcon.create(Icon.BETWEEN_HORIZONTAL_END);
  }

  default LucideIcon between_horizontal_start_design() {
    return LucideIcon.create(Icon.BETWEEN_HORIZONTAL_START);
  }

  default LucideIcon between_vertical_end_design() {
    return LucideIcon.create(Icon.BETWEEN_VERTICAL_END);
  }

  default LucideIcon between_vertical_start_design() {
    return LucideIcon.create(Icon.BETWEEN_VERTICAL_START);
  }

  default LucideIcon blend_design() {
    return LucideIcon.create(Icon.BLEND);
  }

  default LucideIcon book_type_design() {
    return LucideIcon.create(Icon.BOOK_TYPE);
  }

  default LucideIcon bring_to_front_design() {
    return LucideIcon.create(Icon.BRING_TO_FRONT);
  }

  default LucideIcon brush_design() {
    return LucideIcon.create(Icon.BRUSH);
  }

  default LucideIcon brush_cleaning_design() {
    return LucideIcon.create(Icon.BRUSH_CLEANING);
  }

  default LucideIcon chart_no_axes_gantt_design() {
    return LucideIcon.create(Icon.CHART_NO_AXES_GANTT);
  }

  default LucideIcon columns_2_design() {
    return LucideIcon.create(Icon.COLUMNS_2);
  }

  default LucideIcon columns_3_design() {
    return LucideIcon.create(Icon.COLUMNS_3);
  }

  default LucideIcon columns_3_cog_design() {
    return LucideIcon.create(Icon.COLUMNS_3_COG);
  }

  default LucideIcon columns_4_design() {
    return LucideIcon.create(Icon.COLUMNS_4);
  }

  default LucideIcon component_design() {
    return LucideIcon.create(Icon.COMPONENT);
  }

  default LucideIcon contrast_design() {
    return LucideIcon.create(Icon.CONTRAST);
  }

  default LucideIcon crop_design() {
    return LucideIcon.create(Icon.CROP);
  }

  default LucideIcon cylinder_design() {
    return LucideIcon.create(Icon.CYLINDER);
  }

  default LucideIcon database_backup_design() {
    return LucideIcon.create(Icon.DATABASE_BACKUP);
  }

  default LucideIcon decimals_arrow_left_design() {
    return LucideIcon.create(Icon.DECIMALS_ARROW_LEFT);
  }

  default LucideIcon decimals_arrow_right_design() {
    return LucideIcon.create(Icon.DECIMALS_ARROW_RIGHT);
  }

  default LucideIcon diameter_design() {
    return LucideIcon.create(Icon.DIAMETER);
  }

  default LucideIcon dock_design() {
    return LucideIcon.create(Icon.DOCK);
  }

  default LucideIcon drafting_compass_design() {
    return LucideIcon.create(Icon.DRAFTING_COMPASS);
  }

  default LucideIcon eclipse_design() {
    return LucideIcon.create(Icon.ECLIPSE);
  }

  default LucideIcon eye_design() {
    return LucideIcon.create(Icon.EYE);
  }

  default LucideIcon eye_closed_design() {
    return LucideIcon.create(Icon.EYE_CLOSED);
  }

  default LucideIcon eye_dashed_design() {
    return LucideIcon.create(Icon.EYE_DASHED);
  }

  default LucideIcon eye_off_design() {
    return LucideIcon.create(Icon.EYE_OFF);
  }

  default LucideIcon file_axis_3d_design() {
    return LucideIcon.create(Icon.FILE_AXIS_3D);
  }

  default LucideIcon file_box_design() {
    return LucideIcon.create(Icon.FILE_BOX);
  }

  default LucideIcon folder_kanban_design() {
    return LucideIcon.create(Icon.FOLDER_KANBAN);
  }

  default LucideIcon frame_design() {
    return LucideIcon.create(Icon.FRAME);
  }

  default LucideIcon fullscreen_design() {
    return LucideIcon.create(Icon.FULLSCREEN);
  }

  default LucideIcon gallery_horizontal_design() {
    return LucideIcon.create(Icon.GALLERY_HORIZONTAL);
  }

  default LucideIcon gallery_horizontal_end_design() {
    return LucideIcon.create(Icon.GALLERY_HORIZONTAL_END);
  }

  default LucideIcon gallery_thumbnails_design() {
    return LucideIcon.create(Icon.GALLERY_THUMBNAILS);
  }

  default LucideIcon gallery_vertical_design() {
    return LucideIcon.create(Icon.GALLERY_VERTICAL);
  }

  default LucideIcon gallery_vertical_end_design() {
    return LucideIcon.create(Icon.GALLERY_VERTICAL_END);
  }

  default LucideIcon gap_horizontal_design() {
    return LucideIcon.create(Icon.GAP_HORIZONTAL);
  }

  default LucideIcon gap_vertical_design() {
    return LucideIcon.create(Icon.GAP_VERTICAL);
  }

  default LucideIcon grid_2x2_design() {
    return LucideIcon.create(Icon.GRID_2X2);
  }

  default LucideIcon grid_3x2_design() {
    return LucideIcon.create(Icon.GRID_3X2);
  }

  default LucideIcon grid_3x3_design() {
    return LucideIcon.create(Icon.GRID_3X3);
  }

  default LucideIcon hand_grab_design() {
    return LucideIcon.create(Icon.HAND_GRAB);
  }

  default LucideIcon handle_bottom_right() {
    return LucideIcon.create(Icon.HANDLE_BOTTOM_RIGHT);
  }

  default LucideIcon heart_x_design() {
    return LucideIcon.create(Icon.HEART_X);
  }

  default LucideIcon highlighter_design() {
    return LucideIcon.create(Icon.HIGHLIGHTER);
  }

  default LucideIcon iteration_ccw_design() {
    return LucideIcon.create(Icon.ITERATION_CCW);
  }

  default LucideIcon iteration_cw_design() {
    return LucideIcon.create(Icon.ITERATION_CW);
  }

  default LucideIcon kanban_design() {
    return LucideIcon.create(Icon.KANBAN);
  }

  default LucideIcon land_plot_design() {
    return LucideIcon.create(Icon.LAND_PLOT);
  }

  default LucideIcon lasso_design() {
    return LucideIcon.create(Icon.LASSO);
  }

  default LucideIcon lasso_select_design() {
    return LucideIcon.create(Icon.LASSO_SELECT);
  }

  default LucideIcon layer_arrow_down_design() {
    return LucideIcon.create(Icon.LAYER_ARROW_DOWN);
  }

  default LucideIcon layer_arrow_up_design() {
    return LucideIcon.create(Icon.LAYER_ARROW_UP);
  }

  default LucideIcon layers_design() {
    return LucideIcon.create(Icon.LAYERS);
  }

  default LucideIcon layers_2_design() {
    return LucideIcon.create(Icon.LAYERS_2);
  }

  default LucideIcon layers_arrow_down_design() {
    return LucideIcon.create(Icon.LAYERS_ARROW_DOWN);
  }

  default LucideIcon layers_arrow_up_design() {
    return LucideIcon.create(Icon.LAYERS_ARROW_UP);
  }

  default LucideIcon layers_minus_design() {
    return LucideIcon.create(Icon.LAYERS_MINUS);
  }

  default LucideIcon layers_plus_design() {
    return LucideIcon.create(Icon.LAYERS_PLUS);
  }

  default LucideIcon layout_arrow_down_design() {
    return LucideIcon.create(Icon.LAYOUT_ARROW_DOWN);
  }

  default LucideIcon layout_arrow_right_design() {
    return LucideIcon.create(Icon.LAYOUT_ARROW_RIGHT);
  }

  default LucideIcon layout_dashboard_design() {
    return LucideIcon.create(Icon.LAYOUT_DASHBOARD);
  }

  default LucideIcon layout_freeform_design() {
    return LucideIcon.create(Icon.LAYOUT_FREEFORM);
  }

  default LucideIcon layout_grid_design() {
    return LucideIcon.create(Icon.LAYOUT_GRID);
  }

  default LucideIcon layout_grid_circles_design() {
    return LucideIcon.create(Icon.LAYOUT_GRID_CIRCLES);
  }

  default LucideIcon layout_list_design() {
    return LucideIcon.create(Icon.LAYOUT_LIST);
  }

  default LucideIcon layout_panel_left_design() {
    return LucideIcon.create(Icon.LAYOUT_PANEL_LEFT);
  }

  default LucideIcon line_squiggle_design() {
    return LucideIcon.create(Icon.LINE_SQUIGGLE);
  }

  default LucideIcon line_style_design() {
    return LucideIcon.create(Icon.LINE_STYLE);
  }

  default LucideIcon loader_design() {
    return LucideIcon.create(Icon.LOADER);
  }

  default LucideIcon loader_pinwheel_design() {
    return LucideIcon.create(Icon.LOADER_PINWHEEL);
  }

  default LucideIcon magnet() {
    return LucideIcon.create(Icon.MAGNET);
  }

  default LucideIcon maximize_design() {
    return LucideIcon.create(Icon.MAXIMIZE);
  }

  default LucideIcon maximize_2_design() {
    return LucideIcon.create(Icon.MAXIMIZE_2);
  }

  default LucideIcon minimize_design() {
    return LucideIcon.create(Icon.MINIMIZE);
  }

  default LucideIcon minimize_2_design() {
    return LucideIcon.create(Icon.MINIMIZE_2);
  }

  default LucideIcon mop_sparkles_design() {
    return LucideIcon.create(Icon.MOP_SPARKLES);
  }

  default LucideIcon move_3d() {
    return LucideIcon.create(Icon.MOVE_3D);
  }

  default LucideIcon notebook_design() {
    return LucideIcon.create(Icon.NOTEBOOK);
  }

  default LucideIcon origami_design() {
    return LucideIcon.create(Icon.ORIGAMI);
  }

  default LucideIcon paint_bucket_design() {
    return LucideIcon.create(Icon.PAINT_BUCKET);
  }

  default LucideIcon paint_roller_design() {
    return LucideIcon.create(Icon.PAINT_ROLLER);
  }

  default LucideIcon paintbrush_design() {
    return LucideIcon.create(Icon.PAINTBRUSH);
  }

  default LucideIcon paintbrush_vertical_design() {
    return LucideIcon.create(Icon.PAINTBRUSH_VERTICAL);
  }

  default LucideIcon palette_design() {
    return LucideIcon.create(Icon.PALETTE);
  }

  default LucideIcon panel_top_design() {
    return LucideIcon.create(Icon.PANEL_TOP);
  }

  default LucideIcon panels_top_left_design() {
    return LucideIcon.create(Icon.PANELS_TOP_LEFT);
  }

  default LucideIcon paperclip_design() {
    return LucideIcon.create(Icon.PAPERCLIP);
  }

  default LucideIcon pen_design() {
    return LucideIcon.create(Icon.PEN);
  }

  default LucideIcon pen_line_design() {
    return LucideIcon.create(Icon.PEN_LINE);
  }

  default LucideIcon pen_off_design() {
    return LucideIcon.create(Icon.PEN_OFF);
  }

  default LucideIcon pen_tool_design() {
    return LucideIcon.create(Icon.PEN_TOOL);
  }

  default LucideIcon pencil_design() {
    return LucideIcon.create(Icon.PENCIL);
  }

  default LucideIcon pencil_line_design() {
    return LucideIcon.create(Icon.PENCIL_LINE);
  }

  default LucideIcon pencil_off_design() {
    return LucideIcon.create(Icon.PENCIL_OFF);
  }

  default LucideIcon pencil_ruler_design() {
    return LucideIcon.create(Icon.PENCIL_RULER);
  }

  default LucideIcon pencil_sparkles_design() {
    return LucideIcon.create(Icon.PENCIL_SPARKLES);
  }

  default LucideIcon pipette_design() {
    return LucideIcon.create(Icon.PIPETTE);
  }

  default LucideIcon presentation_design() {
    return LucideIcon.create(Icon.PRESENTATION);
  }

  default LucideIcon proportions_design() {
    return LucideIcon.create(Icon.PROPORTIONS);
  }

  default LucideIcon radius_design() {
    return LucideIcon.create(Icon.RADIUS);
  }

  default LucideIcon ratio_design() {
    return LucideIcon.create(Icon.RATIO);
  }

  default LucideIcon rectangle_horizontal_design() {
    return LucideIcon.create(Icon.RECTANGLE_HORIZONTAL);
  }

  default LucideIcon rectangle_vertical_design() {
    return LucideIcon.create(Icon.RECTANGLE_VERTICAL);
  }

  default LucideIcon rotate_3d() {
    return LucideIcon.create(Icon.ROTATE_3D);
  }

  default LucideIcon rotate_ccw_design() {
    return LucideIcon.create(Icon.ROTATE_CCW);
  }

  default LucideIcon rotate_ccw_square_design() {
    return LucideIcon.create(Icon.ROTATE_CCW_SQUARE);
  }

  default LucideIcon rotate_cw_design() {
    return LucideIcon.create(Icon.ROTATE_CW);
  }

  default LucideIcon rotate_cw_square_design() {
    return LucideIcon.create(Icon.ROTATE_CW_SQUARE);
  }

  default LucideIcon rows_2_design() {
    return LucideIcon.create(Icon.ROWS_2);
  }

  default LucideIcon rows_3_design() {
    return LucideIcon.create(Icon.ROWS_3);
  }

  default LucideIcon rows_4_design() {
    return LucideIcon.create(Icon.ROWS_4);
  }

  default LucideIcon ruler_design() {
    return LucideIcon.create(Icon.RULER);
  }

  default LucideIcon ruler_dimension_line_design() {
    return LucideIcon.create(Icon.RULER_DIMENSION_LINE);
  }

  default LucideIcon scale_3d() {
    return LucideIcon.create(Icon.SCALE_3D);
  }

  default LucideIcon scaling() {
    return LucideIcon.create(Icon.SCALING);
  }

  default LucideIcon scan_box_design() {
    return LucideIcon.create(Icon.SCAN_BOX);
  }

  default LucideIcon scan_square_design() {
    return LucideIcon.create(Icon.SCAN_SQUARE);
  }

  default LucideIcon scissors_design() {
    return LucideIcon.create(Icon.SCISSORS);
  }

  default LucideIcon scissors_line_dashed_design() {
    return LucideIcon.create(Icon.SCISSORS_LINE_DASHED);
  }

  default LucideIcon send_to_back_design() {
    return LucideIcon.create(Icon.SEND_TO_BACK);
  }

  default LucideIcon slice() {
    return LucideIcon.create(Icon.SLICE);
  }

  default LucideIcon spline() {
    return LucideIcon.create(Icon.SPLINE);
  }

  default LucideIcon spline_pointer_design() {
    return LucideIcon.create(Icon.SPLINE_POINTER);
  }

  default LucideIcon spray_can_design() {
    return LucideIcon.create(Icon.SPRAY_CAN);
  }

  default LucideIcon square_bottom_dashed_scissors_design() {
    return LucideIcon.create(Icon.SQUARE_BOTTOM_DASHED_SCISSORS);
  }

  default LucideIcon square_centerline_dashed_horizontal_design() {
    return LucideIcon.create(Icon.SQUARE_CENTERLINE_DASHED_HORIZONTAL);
  }

  default LucideIcon square_centerline_dashed_vertical_design() {
    return LucideIcon.create(Icon.SQUARE_CENTERLINE_DASHED_VERTICAL);
  }

  default LucideIcon square_chart_gantt_design() {
    return LucideIcon.create(Icon.SQUARE_CHART_GANTT);
  }

  default LucideIcon square_dashed_design() {
    return LucideIcon.create(Icon.SQUARE_DASHED);
  }

  default LucideIcon square_dashed_kanban_design() {
    return LucideIcon.create(Icon.SQUARE_DASHED_KANBAN);
  }

  default LucideIcon square_dashed_plus_design() {
    return LucideIcon.create(Icon.SQUARE_DASHED_PLUS);
  }

  default LucideIcon square_dashed_top_solid_design() {
    return LucideIcon.create(Icon.SQUARE_DASHED_TOP_SOLID);
  }

  default LucideIcon square_dashed_x_design() {
    return LucideIcon.create(Icon.SQUARE_DASHED_X);
  }

  default LucideIcon square_dashed_x_corner_design() {
    return LucideIcon.create(Icon.SQUARE_DASHED_X_CORNER);
  }

  default LucideIcon square_dimensions_design() {
    return LucideIcon.create(Icon.SQUARE_DIMENSIONS);
  }

  default LucideIcon square_kanban_design() {
    return LucideIcon.create(Icon.SQUARE_KANBAN);
  }

  default LucideIcon square_off_design() {
    return LucideIcon.create(Icon.SQUARE_OFF);
  }

  default LucideIcon square_round_corner_design() {
    return LucideIcon.create(Icon.SQUARE_ROUND_CORNER);
  }

  default LucideIcon square_scissors_design() {
    return LucideIcon.create(Icon.SQUARE_SCISSORS);
  }

  default LucideIcon squares_exclude() {
    return LucideIcon.create(Icon.SQUARES_EXCLUDE);
  }

  default LucideIcon squares_intersect() {
    return LucideIcon.create(Icon.SQUARES_INTERSECT);
  }

  default LucideIcon squares_subtract() {
    return LucideIcon.create(Icon.SQUARES_SUBTRACT);
  }

  default LucideIcon squares_unite() {
    return LucideIcon.create(Icon.SQUARES_UNITE);
  }

  default LucideIcon squircle_dashed_design() {
    return LucideIcon.create(Icon.SQUIRCLE_DASHED);
  }

  default LucideIcon stamp_design() {
    return LucideIcon.create(Icon.STAMP);
  }

  default LucideIcon swatch_book_design() {
    return LucideIcon.create(Icon.SWATCH_BOOK);
  }

  default LucideIcon tablet_smartphone_design() {
    return LucideIcon.create(Icon.TABLET_SMARTPHONE);
  }

  default LucideIcon tangent_design() {
    return LucideIcon.create(Icon.TANGENT);
  }

  default LucideIcon torus_design() {
    return LucideIcon.create(Icon.TORUS);
  }

  default LucideIcon triangles_centerline_dashed_horizontal_design() {
    return LucideIcon.create(Icon.TRIANGLES_CENTERLINE_DASHED_HORIZONTAL);
  }

  default LucideIcon triangles_centerline_dashed_vertical_design() {
    return LucideIcon.create(Icon.TRIANGLES_CENTERLINE_DASHED_VERTICAL);
  }

  default LucideIcon vector_polygon_design() {
    return LucideIcon.create(Icon.VECTOR_POLYGON);
  }

  default LucideIcon vector_square_design() {
    return LucideIcon.create(Icon.VECTOR_SQUARE);
  }

  default LucideIcon view_design() {
    return LucideIcon.create(Icon.VIEW);
  }

  default LucideIcon wand_design() {
    return LucideIcon.create(Icon.WAND);
  }

  default LucideIcon wand_sparkles_design() {
    return LucideIcon.create(Icon.WAND_SPARKLES);
  }

  default LucideIcon zoom_in_design() {
    return LucideIcon.create(Icon.ZOOM_IN);
  }

  default LucideIcon zoom_out_design() {
    return LucideIcon.create(Icon.ZOOM_OUT);
  }
}
