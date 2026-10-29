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

/** Lucide photography catalog category. */
public interface LucidePhotography {
  enum Icon implements LucideIconDefinition {
    APERTURE(
        "aperture",
        "<circle cx=\"12\" cy=\"12\" r=\"10\" />\n  <path d=\"m14.31 8 5.74 9.94\" />\n  <path d=\"M9.69 8h11.48\" />\n  <path d=\"m7.38 12 5.74-9.94\" />\n  <path d=\"M9.69 16 3.95 6.06\" />\n  <path d=\"M14.31 16H2.83\" />\n  <path d=\"m16.62 12-5.74 9.94\" />"),
    BACKPACK(
        "backpack",
        "<path d=\"M4 10a4 4 0 0 1 4-4h8a4 4 0 0 1 4 4v10a2 2 0 0 1-2 2H6a2 2 0 0 1-2-2z\" />\n  <path d=\"M8 10h8\" />\n  <path d=\"M8 18h8\" />\n  <path d=\"M8 22v-6a2 2 0 0 1 2-2h4a2 2 0 0 1 2 2v6\" />\n  <path d=\"M9 6V4a2 2 0 0 1 2-2h2a2 2 0 0 1 2 2v2\" />"),
    BINOCULARS(
        "binoculars",
        "<path d=\"M10 10h4\" />\n  <path d=\"M19 7V4a1 1 0 0 0-1-1h-2a1 1 0 0 0-1 1v3\" />\n  <path d=\"M20 21a2 2 0 0 0 2-2v-3.851c0-1.39-2-2.962-2-4.829V8a1 1 0 0 0-1-1h-4a1 1 0 0 0-1 1v11a2 2 0 0 0 2 2z\" />\n  <path d=\"M 22 16 L 2 16\" />\n  <path d=\"M4 21a2 2 0 0 1-2-2v-3.851c0-1.39 2-2.962 2-4.829V8a1 1 0 0 1 1-1h4a1 1 0 0 1 1 1v11a2 2 0 0 1-2 2z\" />\n  <path d=\"M9 7V4a1 1 0 0 0-1-1H6a1 1 0 0 0-1 1v3\" />"),
    BLEND(
        "blend", "<circle cx=\"15\" cy=\"9\" r=\"7\" />\n  <circle cx=\"9\" cy=\"15\" r=\"7\" />"),
    BOOK_IMAGE(
        "book-image",
        "<path d=\"m20 13.7-2.1-2.1a2 2 0 0 0-2.8 0L9.7 17\" />\n  <path d=\"M4 19.5v-15A2.5 2.5 0 0 1 6.5 2H19a1 1 0 0 1 1 1v18a1 1 0 0 1-1 1H6.5a1 1 0 0 1 0-5H20\" />\n  <circle cx=\"10\" cy=\"8\" r=\"2\" />"),
    CAMERA(
        "camera",
        "<path d=\"M13.997 4a2 2 0 0 1 1.76 1.05l.486.9A2 2 0 0 0 18.003 7H20a2 2 0 0 1 2 2v9a2 2 0 0 1-2 2H4a2 2 0 0 1-2-2V9a2 2 0 0 1 2-2h1.997a2 2 0 0 0 1.759-1.048l.489-.904A2 2 0 0 1 10.004 4z\" />\n  <circle cx=\"12\" cy=\"13\" r=\"3\" />"),
    CAMERA_OFF(
        "camera-off",
        "<path d=\"M14.564 14.558a3 3 0 1 1-4.122-4.121\" />\n  <path d=\"m2 2 20 20\" />\n  <path d=\"M20 20H4a2 2 0 0 1-2-2V9a2 2 0 0 1 2-2h1.997a2 2 0 0 0 .819-.175\" />\n  <path d=\"M9.695 4.024A2 2 0 0 1 10.004 4h3.993a2 2 0 0 1 1.76 1.05l.486.9A2 2 0 0 0 18.003 7H20a2 2 0 0 1 2 2v7.344\" />"),
    CCTV(
        "cctv",
        "<path d=\"M16.75 12h3.632a1 1 0 0 1 .894 1.447l-2.034 4.069a1 1 0 0 1-1.708.134l-2.124-2.97\" />\n  <path d=\"M17.106 9.053a1 1 0 0 1 .447 1.341l-3.106 6.211a1 1 0 0 1-1.342.447L3.61 12.3a2.92 2.92 0 0 1-1.3-3.91L3.69 5.6a2.92 2.92 0 0 1 3.92-1.3z\" />\n  <path d=\"M2 19h3.76a2 2 0 0 0 1.8-1.1L9 15\" />\n  <path d=\"M2 21v-4\" />\n  <path d=\"M7 9h.01\" />"),
    CCTV_OFF(
        "cctv-off",
        "<path d=\"m12.309 6.652 4.797 2.401a1 1 0 0 1 .447 1.341l-.501 1.001.605.605h2.725a1 1 0 0 1 .894 1.447l-.724 1.448\" />\n  <path d=\"m15.166 15.166-.719 1.439a1 1 0 0 1-1.342.447L3.61 12.3a2.92 2.92 0 0 1-1.3-3.91L3.69 5.6a2.9 2.9 0 0 1 .873-1.037\" />\n  <path d=\"M2 19h3.76a2 2 0 0 0 1.8-1.1l1.441-2.902\" />\n  <path d=\"m2 2 20 20\" />\n  <path d=\"M2 21v-4\" />\n  <path d=\"M7 9h.01\" />"),
    CONTRAST(
        "contrast",
        "<circle cx=\"12\" cy=\"12\" r=\"10\" />\n  <path d=\"M12 18a6 6 0 0 0 0-12v12z\" />"),
    CROP(
        "crop",
        "<path d=\"M6 2v14a2 2 0 0 0 2 2h14\" />\n  <path d=\"M18 22V8a2 2 0 0 0-2-2H2\" />"),
    CROSSHAIR(
        "crosshair",
        "<circle cx=\"12\" cy=\"12\" r=\"10\" />\n  <line x1=\"22\" x2=\"18\" y1=\"12\" y2=\"12\" />\n  <line x1=\"6\" x2=\"2\" y1=\"12\" y2=\"12\" />\n  <line x1=\"12\" x2=\"12\" y1=\"6\" y2=\"2\" />\n  <line x1=\"12\" x2=\"12\" y1=\"22\" y2=\"18\" />"),
    DATABASE_BACKUP(
        "database-backup",
        "<ellipse cx=\"12\" cy=\"5\" rx=\"9\" ry=\"3\" />\n  <path d=\"M3 12a9 3 0 0 0 5 2.69\" />\n  <path d=\"M21 9.3V5\" />\n  <path d=\"M3 5v14a9 3 0 0 0 6.47 2.88\" />\n  <path d=\"M12 12v4h4\" />\n  <path d=\"M13 20a5 5 0 0 0 9-3 4.5 4.5 0 0 0-4.5-4.5c-1.33 0-2.54.54-3.41 1.41L12 16\" />"),
    DIAMOND_MINUS(
        "diamond-minus",
        "<path d=\"M2.7 10.3a2.41 2.41 0 0 0 0 3.41l7.59 7.59a2.41 2.41 0 0 0 3.41 0l7.59-7.59a2.41 2.41 0 0 0 0-3.41L13.7 2.71a2.41 2.41 0 0 0-3.41 0z\" />\n  <path d=\"M8 12h8\" />"),
    DIAMOND_PLUS(
        "diamond-plus",
        "<path d=\"M12 8v8\" />\n  <path d=\"M2.7 10.3a2.41 2.41 0 0 0 0 3.41l7.59 7.59a2.41 2.41 0 0 0 3.41 0l7.59-7.59a2.41 2.41 0 0 0 0-3.41L13.7 2.71a2.41 2.41 0 0 0-3.41 0z\" />\n  <path d=\"M8 12h8\" />"),
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
    FILM(
        "film",
        "<rect width=\"18\" height=\"18\" x=\"3\" y=\"3\" rx=\"2\" />\n  <path d=\"M7 3v18\" />\n  <path d=\"M3 7.5h4\" />\n  <path d=\"M3 12h18\" />\n  <path d=\"M3 16.5h4\" />\n  <path d=\"M17 3v18\" />\n  <path d=\"M17 7.5h4\" />\n  <path d=\"M17 16.5h4\" />"),
    FLASHLIGHT(
        "flashlight",
        "<path d=\"M12 13v1\" />\n  <path d=\"M17 2a1 1 0 0 1 1 1v4a3 3 0 0 1-.6 1.8l-.6.8A4 4 0 0 0 16 12v8a2 2 0 0 1-2 2H10a2 2 0 0 1-2-2v-8a4 4 0 0 0-.8-2.4l-.6-.8A3 3 0 0 1 6 7V3a1 1 0 0 1 1-1z\" />\n  <path d=\"M6 6h12\" />"),
    FLASHLIGHT_OFF(
        "flashlight-off",
        "<path d=\"M11.652 6H18\" />\n  <path d=\"M12 13v1\" />\n  <path d=\"M16 16v4a2 2 0 0 1-2 2h-4a2 2 0 0 1-2-2v-8a4 4 0 0 0-.8-2.4l-.6-.8A3 3 0 0 1 6 7V6\" />\n  <path d=\"m2 2 20 20\" />\n  <path d=\"M7.649 2H17a1 1 0 0 1 1 1v4a3 3 0 0 1-.6 1.8l-.6.8a4 4 0 0 0-.55 1.007\" />"),
    FOCUS(
        "focus",
        "<circle cx=\"12\" cy=\"12\" r=\"3\" />\n  <path d=\"M3 7V5a2 2 0 0 1 2-2h2\" />\n  <path d=\"M17 3h2a2 2 0 0 1 2 2v2\" />\n  <path d=\"M21 17v2a2 2 0 0 1-2 2h-2\" />\n  <path d=\"M7 21H5a2 2 0 0 1-2-2v-2\" />"),
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
    IMAGE(
        "image",
        "<rect width=\"18\" height=\"18\" x=\"3\" y=\"3\" rx=\"2\" ry=\"2\" />\n  <circle cx=\"9\" cy=\"9\" r=\"2\" />\n  <path d=\"m21 15-3.086-3.086a2 2 0 0 0-2.828 0L6 21\" />"),
    IMAGE_DOWN(
        "image-down",
        "<path d=\"M10.3 21H5a2 2 0 0 1-2-2V5a2 2 0 0 1 2-2h14a2 2 0 0 1 2 2v10l-3.1-3.1a2 2 0 0 0-2.814.014L6 21\" />\n  <path d=\"m14 19 3 3v-5.5\" />\n  <path d=\"m17 22 3-3\" />\n  <circle cx=\"9\" cy=\"9\" r=\"2\" />"),
    IMAGE_MINUS(
        "image-minus",
        "<path d=\"M21 9v10a2 2 0 0 1-2 2H5a2 2 0 0 1-2-2V5a2 2 0 0 1 2-2h7\" />\n  <line x1=\"16\" x2=\"22\" y1=\"5\" y2=\"5\" />\n  <circle cx=\"9\" cy=\"9\" r=\"2\" />\n  <path d=\"m21 15-3.086-3.086a2 2 0 0 0-2.828 0L6 21\" />"),
    IMAGE_OFF(
        "image-off",
        "<line x1=\"2\" x2=\"22\" y1=\"2\" y2=\"22\" />\n  <path d=\"M10.41 10.41a2 2 0 1 1-2.83-2.83\" />\n  <line x1=\"13.5\" x2=\"6\" y1=\"13.5\" y2=\"21\" />\n  <line x1=\"18\" x2=\"21\" y1=\"12\" y2=\"15\" />\n  <path d=\"M3.59 3.59A1.99 1.99 0 0 0 3 5v14a2 2 0 0 0 2 2h14c.55 0 1.052-.22 1.41-.59\" />\n  <path d=\"M21 15V5a2 2 0 0 0-2-2H9\" />"),
    IMAGE_PLAY(
        "image-play",
        "<path d=\"M15 15.003a1 1 0 0 1 1.517-.859l4.997 2.997a1 1 0 0 1 0 1.718l-4.997 2.997a1 1 0 0 1-1.517-.86z\" />\n  <path d=\"M21 12.17V5a2 2 0 0 0-2-2H5a2 2 0 0 0-2 2v14a2 2 0 0 0 2 2h6\" />\n  <path d=\"m6 21 5-5\" />\n  <circle cx=\"9\" cy=\"9\" r=\"2\" />"),
    IMAGE_PLUS(
        "image-plus",
        "<path d=\"M16 5h6\" />\n  <path d=\"M19 2v6\" />\n  <path d=\"M21 11.5V19a2 2 0 0 1-2 2H5a2 2 0 0 1-2-2V5a2 2 0 0 1 2-2h7.5\" />\n  <path d=\"m21 15-3.086-3.086a2 2 0 0 0-2.828 0L6 21\" />\n  <circle cx=\"9\" cy=\"9\" r=\"2\" />"),
    IMAGE_UP(
        "image-up",
        "<path d=\"M10.3 21H5a2 2 0 0 1-2-2V5a2 2 0 0 1 2-2h14a2 2 0 0 1 2 2v10l-3.1-3.1a2 2 0 0 0-2.814.014L6 21\" />\n  <path d=\"m14 19.5 3-3 3 3\" />\n  <path d=\"M17 22v-5.5\" />\n  <circle cx=\"9\" cy=\"9\" r=\"2\" />"),
    IMAGE_UPSCALE(
        "image-upscale",
        "<path d=\"M16 3h5v5\" />\n  <path d=\"M17 21h2a2 2 0 0 0 2-2\" />\n  <path d=\"M21 12v3\" />\n  <path d=\"m21 3-5 5\" />\n  <path d=\"M3 7V5a2 2 0 0 1 2-2\" />\n  <path d=\"m5 21 4.144-4.144a1.21 1.21 0 0 1 1.712 0L13 19\" />\n  <path d=\"M9 3h3\" />\n  <rect x=\"3\" y=\"11\" width=\"10\" height=\"10\" rx=\"1\" />"),
    IMAGES(
        "images",
        "<path d=\"m22 11-1.296-1.296a2.4 2.4 0 0 0-3.408 0L11 16\" />\n  <path d=\"M4 8a2 2 0 0 0-2 2v10a2 2 0 0 0 2 2h10a2 2 0 0 0 2-2\" />\n  <circle cx=\"13\" cy=\"7\" r=\"1\" fill=\"currentColor\" />\n  <rect x=\"8\" y=\"2\" width=\"14\" height=\"14\" rx=\"2\" />"),
    LAYOUT_LIST(
        "layout-list",
        "<rect width=\"7\" height=\"7\" x=\"3\" y=\"3\" rx=\"1\" />\n  <rect width=\"7\" height=\"7\" x=\"3\" y=\"14\" rx=\"1\" />\n  <path d=\"M14 4h7\" />\n  <path d=\"M14 9h7\" />\n  <path d=\"M14 15h7\" />\n  <path d=\"M14 20h7\" />"),
    LENS(
        "lens",
        "<path d=\"M15.725 7.296h.01\" />\n  <path d=\"M6 12a6 6 0 016-6\" />\n  <circle cx=\"12\" cy=\"12\" r=\"10\" />"),
    LIBRARY(
        "library",
        "<path d=\"m16 6 4 14\" />\n  <path d=\"M12 6v14\" />\n  <path d=\"M8 8v12\" />\n  <path d=\"M4 4v16\" />"),
    LIBRARY_BIG(
        "library-big",
        "<rect width=\"8\" height=\"18\" x=\"3\" y=\"3\" rx=\"1\" />\n  <path d=\"M7 3v18\" />\n  <path d=\"M20.4 18.9c.2.5-.1 1.1-.6 1.3l-1.9.7c-.5.2-1.1-.1-1.3-.6L11.1 5.1c-.2-.5.1-1.1.6-1.3l1.9-.7c.5-.2 1.1.1 1.3.6Z\" />"),
    LIGHTBULB(
        "lightbulb",
        "<path d=\"M15 14c.2-1 .7-1.7 1.5-2.5 1-.9 1.5-2.2 1.5-3.5A6 6 0 0 0 6 8c0 1 .2 2.2 1.5 3.5.7.7 1.3 1.5 1.5 2.5\" />\n  <path d=\"M9 18h6\" />\n  <path d=\"M10 22h4\" />"),
    LIGHTBULB_OFF(
        "lightbulb-off",
        "<path d=\"M16.8 11.2c.8-.9 1.2-2 1.2-3.2a6 6 0 0 0-9.3-5\" />\n  <path d=\"m2 2 20 20\" />\n  <path d=\"M6.3 6.3a4.67 4.67 0 0 0 1.2 5.2c.7.7 1.3 1.5 1.5 2.5\" />\n  <path d=\"M9 18h6\" />\n  <path d=\"M10 22h4\" />"),
    PAINTBRUSH(
        "paintbrush",
        "<path d=\"m14.622 17.897-10.68-2.913\" />\n  <path d=\"M18.376 2.622a1 1 0 1 1 3.002 3.002L17.36 9.643a.5.5 0 0 0 0 .707l.944.944a2.41 2.41 0 0 1 0 3.408l-.944.944a.5.5 0 0 1-.707 0L8.354 7.348a.5.5 0 0 1 0-.707l.944-.944a2.41 2.41 0 0 1 3.408 0l.944.944a.5.5 0 0 0 .707 0z\" />\n  <path d=\"M9 8c-1.804 2.71-3.97 3.46-6.583 3.948a.507.507 0 0 0-.302.819l7.32 8.883a1 1 0 0 0 1.185.204C12.735 20.405 16 16.792 16 15\" />"),
    PAINTBRUSH_VERTICAL(
        "paintbrush-vertical",
        "<path d=\"M10 2v2\" />\n  <path d=\"M14 2v4\" />\n  <path d=\"M17 2a1 1 0 0 1 1 1v9H6V3a1 1 0 0 1 1-1z\" />\n  <path d=\"M6 12a1 1 0 0 0-1 1v1a2 2 0 0 0 2 2h2a1 1 0 0 1 1 1v2.9a2 2 0 1 0 4 0V17a1 1 0 0 1 1-1h2a2 2 0 0 0 2-2v-1a1 1 0 0 0-1-1\" />"),
    PALETTE(
        "palette",
        "<path d=\"M12 22a1 1 0 0 1 0-20 10 9 0 0 1 10 9 5 5 0 0 1-5 5h-2.25a1.75 1.75 0 0 0-1.4 2.8l.3.4a1.75 1.75 0 0 1-1.4 2.8z\" />\n  <circle cx=\"13.5\" cy=\"6.5\" r=\".5\" fill=\"currentColor\" />\n  <circle cx=\"17.5\" cy=\"10.5\" r=\".5\" fill=\"currentColor\" />\n  <circle cx=\"6.5\" cy=\"12.5\" r=\".5\" fill=\"currentColor\" />\n  <circle cx=\"8.5\" cy=\"7.5\" r=\".5\" fill=\"currentColor\" />"),
    PENCIL_SPARKLES(
        "pencil-sparkles",
        "<path d=\"M10 3H8\" />\n  <path d=\"m15.007 5.008 3.987 3.986\" />\n  <path d=\"M20 15v4\" />\n  <path d=\"M21.174 6.813a2.82 2.82 0 0 0-3.986-3.987L3.842 16.175a2 2 0 0 0-.5.83l-1.321 4.352a.5.5 0 0 0 .623.622l4.353-1.32a2 2 0 0 0 .83-.497z\" />\n  <path d=\"M22 17h-4\" />\n  <path d=\"M4 5v4\" />\n  <path d=\"M6 7H2\" />\n  <path d=\"M9 2v2\" />"),
    PRESENTATION(
        "presentation",
        "<path d=\"M2 3h20\" />\n  <path d=\"M21 3v11a2 2 0 0 1-2 2H5a2 2 0 0 1-2-2V3\" />\n  <path d=\"m7 21 5-5 5 5\" />"),
    PROJECTOR(
        "projector",
        "<path d=\"M5 7 3 5\" />\n  <path d=\"M9 6V3\" />\n  <path d=\"m13 7 2-2\" />\n  <circle cx=\"9\" cy=\"13\" r=\"3\" />\n  <path d=\"M11.83 12H20a2 2 0 0 1 2 2v4a2 2 0 0 1-2 2H4a2 2 0 0 1-2-2v-4a2 2 0 0 1 2-2h2.17\" />\n  <path d=\"M16 16h2\" />"),
    PROPORTIONS(
        "proportions",
        "<rect width=\"20\" height=\"16\" x=\"2\" y=\"4\" rx=\"2\" />\n  <path d=\"M12 9v11\" />\n  <path d=\"M2 9h13a2 2 0 0 1 2 2v9\" />"),
    RATIO(
        "ratio",
        "<rect width=\"12\" height=\"20\" x=\"6\" y=\"2\" rx=\"2\" />\n  <rect width=\"20\" height=\"12\" x=\"2\" y=\"6\" rx=\"2\" />"),
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
    SCAN_EYE(
        "scan-eye",
        "<path d=\"M3 7V5a2 2 0 0 1 2-2h2\" />\n  <path d=\"M17 3h2a2 2 0 0 1 2 2v2\" />\n  <path d=\"M21 17v2a2 2 0 0 1-2 2h-2\" />\n  <path d=\"M7 21H5a2 2 0 0 1-2-2v-2\" />\n  <circle cx=\"12\" cy=\"12\" r=\"1\" />\n  <path d=\"M18.944 12.33a1 1 0 0 0 0-.66 7.5 7.5 0 0 0-13.888 0 1 1 0 0 0 0 .66 7.5 7.5 0 0 0 13.888 0\" />"),
    SCAN_SEARCH(
        "scan-search",
        "<path d=\"M3 7V5a2 2 0 0 1 2-2h2\" />\n  <path d=\"M17 3h2a2 2 0 0 1 2 2v2\" />\n  <path d=\"M21 17v2a2 2 0 0 1-2 2h-2\" />\n  <path d=\"M7 21H5a2 2 0 0 1-2-2v-2\" />\n  <circle cx=\"12\" cy=\"12\" r=\"3\" />\n  <path d=\"m16 16-1.9-1.9\" />"),
    SCAN_SQUARE(
        "scan-square",
        "<path d=\"M3 7V5a2 2 0 0 1 2-2h2\" />\n  <path d=\"M17 3h2a2 2 0 0 1 2 2v2\" />\n  <path d=\"M21 17v2a2 2 0 0 1-2 2h-2\" />\n  <path d=\"M7 21H5a2 2 0 0 1-2-2v-2\" />\n  <rect width=\"8\" height=\"8\" x=\"8\" y=\"8\" rx=\"1\" />"),
    SPOTLIGHT(
        "spotlight",
        "<path d=\"M15.295 19.562 16 22\" />\n  <path d=\"m17 16 3.758 2.098\" />\n  <path d=\"m19 12.5 3.026-.598\" />\n  <path d=\"M7.61 6.3a3 3 0 0 0-3.92 1.3l-1.38 2.79a3 3 0 0 0 1.3 3.91l6.89 3.597a1 1 0 0 0 1.342-.447l3.106-6.211a1 1 0 0 0-.447-1.341z\" />\n  <path d=\"M8 9V2\" />"),
    SQUARE_BOOKMARK(
        "square-bookmark",
        "<path d=\"M11 3v7.751a.25.25 0 00.407.195l2.28-1.834a.5.5 0 01.627 0l2.28 1.834a.25.25 0 00.406-.195V3\" />\n  <rect x=\"3\" y=\"3\" width=\"18\" height=\"18\" rx=\"2\" />"),
    SQUARE_CENTERLINE_DASHED_HORIZONTAL(
        "square-centerline-dashed-horizontal",
        "<path d=\"M8 3H5a2 2 0 0 0-2 2v14c0 1.1.9 2 2 2h3\" />\n  <path d=\"M16 3h3a2 2 0 0 1 2 2v14a2 2 0 0 1-2 2h-3\" />\n  <path d=\"M12 20v2\" />\n  <path d=\"M12 14v2\" />\n  <path d=\"M12 8v2\" />\n  <path d=\"M12 2v2\" />"),
    SQUARE_CENTERLINE_DASHED_VERTICAL(
        "square-centerline-dashed-vertical",
        "<path d=\"M21 8V5a2 2 0 0 0-2-2H5a2 2 0 0 0-2 2v3\" />\n  <path d=\"M21 16v3a2 2 0 0 1-2 2H5a2 2 0 0 1-2-2v-3\" />\n  <path d=\"M4 12H2\" />\n  <path d=\"M10 12H8\" />\n  <path d=\"M16 12h-2\" />\n  <path d=\"M22 12h-2\" />"),
    SQUARE_LIBRARY(
        "square-library",
        "<rect width=\"18\" height=\"18\" x=\"3\" y=\"3\" rx=\"2\" />\n  <path d=\"M7 7v10\" />\n  <path d=\"M11 7v10\" />\n  <path d=\"m15 7 2 10\" />"),
    SQUARE_SPARKLES(
        "square-sparkles",
        "<path d=\"M11 15H7\" />\n  <path d=\"M15.41 2.49a.6.6 0 011.18 0l.63 3.334a1.2 1.2 0 00.956.955l3.334.631a.6.6 0 010 1.18l-3.334.63a1.2 1.2 0 00-.955.956l-.631 3.334a.6.6 0 01-1.18 0l-.63-3.334a1.2 1.2 0 00-.956-.955L10.49 8.59a.6.6 0 010-1.18l3.334-.63a1.2 1.2 0 00.955-.956z\" />\n  <path d=\"M21 13v6a2 2 0 01-2 2H5a2 2 0 01-2-2V5a2 2 0 012-2h6\" />\n  <path d=\"M9 13v4\" />"),
    SWATCH_BOOK(
        "swatch-book",
        "<path d=\"M11 17a4 4 0 0 1-8 0V5a2 2 0 0 1 2-2h4a2 2 0 0 1 2 2Z\" />\n  <path d=\"M16.7 13H19a2 2 0 0 1 2 2v4a2 2 0 0 1-2 2H7\" />\n  <path d=\"M 7 17h.01\" />\n  <path d=\"m11 8 2.3-2.3a2.4 2.4 0 0 1 3.404.004L18.6 7.6a2.4 2.4 0 0 1 .026 3.434L9.9 19.8\" />"),
    TRIANGLES_CENTERLINE_DASHED_HORIZONTAL(
        "triangles-centerline-dashed-horizontal",
        "<path d=\"M10 12H8\" />\n  <path d=\"M16 12h-2\" />\n  <path d=\"M22 12h-2\" />\n  <path d=\"M4 12H2\" />\n  <path d=\"M7.298 20.288A1 1 0 008 22h8a1 1 0 00.703-1.712l-3.991-3.99a1 1 0 00-1.424-.001z\" />\n  <path d=\"M7.298 3.712A1 1 0 018 2h8a1 1 0 01.703 1.712l-3.991 3.99a1 1 0 01-1.424.001z\" />"),
    TRIANGLES_CENTERLINE_DASHED_VERTICAL(
        "triangles-centerline-dashed-vertical",
        "<path d=\"M12 14v2\" />\n  <path d=\"M12 20v2\" />\n  <path d=\"M12 2v2\" />\n  <path d=\"M12 8v2\" />\n  <path d=\"M20.288 16.703A1 1 0 0022 16V8a1 1 0 00-1.712-.703l-3.99 3.991a1 1 0 00-.001 1.424z\" />\n  <path d=\"M3.712 16.703A1 1 0 012 16V8a1 1 0 011.712-.703l3.99 3.991a1 1 0 01.001 1.424z\" />"),
    VIDEO(
        "video",
        "<path d=\"m16 13 5.223 3.482a.5.5 0 0 0 .777-.416V7.87a.5.5 0 0 0-.752-.432L16 10.5\" />\n  <rect x=\"2\" y=\"6\" width=\"14\" height=\"12\" rx=\"2\" />"),
    VIDEO_OFF(
        "video-off",
        "<path d=\"M10.66 6H14a2 2 0 0 1 2 2v2.5l5.248-3.062A.5.5 0 0 1 22 7.87v8.196\" />\n  <path d=\"M16 16a2 2 0 0 1-2 2H4a2 2 0 0 1-2-2V8a2 2 0 0 1 2-2h2\" />\n  <path d=\"m2 2 20 20\" />"),
    VIDEOTAPE(
        "videotape",
        "<rect width=\"20\" height=\"16\" x=\"2\" y=\"4\" rx=\"2\" />\n  <path d=\"M2 8h20\" />\n  <circle cx=\"8\" cy=\"14\" r=\"2\" />\n  <path d=\"M8 12h8\" />\n  <circle cx=\"16\" cy=\"14\" r=\"2\" />"),
    VIEW(
        "view",
        "<path d=\"M21 17v2a2 2 0 0 1-2 2H5a2 2 0 0 1-2-2v-2\" />\n  <path d=\"M21 7V5a2 2 0 0 0-2-2H5a2 2 0 0 0-2 2v2\" />\n  <circle cx=\"12\" cy=\"12\" r=\"1\" />\n  <path d=\"M18.944 12.33a1 1 0 0 0 0-.66 7.5 7.5 0 0 0-13.888 0 1 1 0 0 0 0 .66 7.5 7.5 0 0 0 13.888 0\" />"),
    WAND(
        "wand",
        "<path d=\"M15 4V2\" />\n  <path d=\"M15 16v-2\" />\n  <path d=\"M8 9h2\" />\n  <path d=\"M20 9h2\" />\n  <path d=\"M17.8 11.8 19 13\" />\n  <path d=\"M15 9h.01\" />\n  <path d=\"M17.8 6.2 19 5\" />\n  <path d=\"m3 21 9-9\" />\n  <path d=\"M12.2 6.2 11 5\" />"),
    WAND_SPARKLES(
        "wand-sparkles",
        "<path d=\"m21.64 3.64-1.28-1.28a1.21 1.21 0 0 0-1.72 0L2.36 18.64a1.21 1.21 0 0 0 0 1.72l1.28 1.28a1.2 1.2 0 0 0 1.72 0L21.64 5.36a1.2 1.2 0 0 0 0-1.72\" />\n  <path d=\"m14 7 3 3\" />\n  <path d=\"M5 6v4\" />\n  <path d=\"M19 14v4\" />\n  <path d=\"M10 2v2\" />\n  <path d=\"M7 8H3\" />\n  <path d=\"M21 16h-4\" />\n  <path d=\"M11 3H9\" />"),
    ZAP(
        "zap",
        "<path d=\"M15.914 4a1.5 1.5 0 00-2.474-1.561l-9 9A1.5 1.5 0 005.5 14h4.002a.5.5 0 01.471.666L8.086 20a1.5 1.5 0 002.475 1.56l9-9A1.5 1.5 0 0018.5 10h-3.997a.5.5 0 01-.472-.667z\" />"),
    ZAP_OFF(
        "zap-off",
        "<path d=\"M10.768 5.111 13.44 2.44a1.5 1.5 0 012.474 1.561l-1.633 4.625\" />\n  <path d=\"m18.889 13.232.672-.672A1.5 1.5 0 0018.5 10h-2.844\" />\n  <path d=\"m2 2 20 20\" />\n  <path d=\"m7.94 7.94-3.5 3.499A1.5 1.5 0 005.5 14h4.002a.5.5 0 01.471.666L8.086 20a1.5 1.5 0 002.475 1.56l5.5-5.5\" />"),
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
  default LucideIcon aperture() {
    return LucideIcon.create(Icon.APERTURE);
  }

  default LucideIcon backpack_photography() {
    return LucideIcon.create(Icon.BACKPACK);
  }

  default LucideIcon binoculars_photography() {
    return LucideIcon.create(Icon.BINOCULARS);
  }

  default LucideIcon blend_photography() {
    return LucideIcon.create(Icon.BLEND);
  }

  default LucideIcon book_image_photography() {
    return LucideIcon.create(Icon.BOOK_IMAGE);
  }

  default LucideIcon camera_photography() {
    return LucideIcon.create(Icon.CAMERA);
  }

  default LucideIcon camera_off_photography() {
    return LucideIcon.create(Icon.CAMERA_OFF);
  }

  default LucideIcon cctv_photography() {
    return LucideIcon.create(Icon.CCTV);
  }

  default LucideIcon cctv_off_photography() {
    return LucideIcon.create(Icon.CCTV_OFF);
  }

  default LucideIcon contrast_photography() {
    return LucideIcon.create(Icon.CONTRAST);
  }

  default LucideIcon crop_photography() {
    return LucideIcon.create(Icon.CROP);
  }

  default LucideIcon crosshair() {
    return LucideIcon.create(Icon.CROSSHAIR);
  }

  default LucideIcon database_backup_photography() {
    return LucideIcon.create(Icon.DATABASE_BACKUP);
  }

  default LucideIcon diamond_minus_photography() {
    return LucideIcon.create(Icon.DIAMOND_MINUS);
  }

  default LucideIcon diamond_plus_photography() {
    return LucideIcon.create(Icon.DIAMOND_PLUS);
  }

  default LucideIcon eclipse_photography() {
    return LucideIcon.create(Icon.ECLIPSE);
  }

  default LucideIcon eye_photography() {
    return LucideIcon.create(Icon.EYE);
  }

  default LucideIcon eye_closed_photography() {
    return LucideIcon.create(Icon.EYE_CLOSED);
  }

  default LucideIcon eye_dashed_photography() {
    return LucideIcon.create(Icon.EYE_DASHED);
  }

  default LucideIcon eye_off_photography() {
    return LucideIcon.create(Icon.EYE_OFF);
  }

  default LucideIcon film_photography() {
    return LucideIcon.create(Icon.FILM);
  }

  default LucideIcon flashlight_photography() {
    return LucideIcon.create(Icon.FLASHLIGHT);
  }

  default LucideIcon flashlight_off_photography() {
    return LucideIcon.create(Icon.FLASHLIGHT_OFF);
  }

  default LucideIcon focus() {
    return LucideIcon.create(Icon.FOCUS);
  }

  default LucideIcon frame_photography() {
    return LucideIcon.create(Icon.FRAME);
  }

  default LucideIcon fullscreen_photography() {
    return LucideIcon.create(Icon.FULLSCREEN);
  }

  default LucideIcon gallery_horizontal_photography() {
    return LucideIcon.create(Icon.GALLERY_HORIZONTAL);
  }

  default LucideIcon gallery_horizontal_end_photography() {
    return LucideIcon.create(Icon.GALLERY_HORIZONTAL_END);
  }

  default LucideIcon gallery_thumbnails_photography() {
    return LucideIcon.create(Icon.GALLERY_THUMBNAILS);
  }

  default LucideIcon gallery_vertical_photography() {
    return LucideIcon.create(Icon.GALLERY_VERTICAL);
  }

  default LucideIcon gallery_vertical_end_photography() {
    return LucideIcon.create(Icon.GALLERY_VERTICAL_END);
  }

  default LucideIcon image_photography() {
    return LucideIcon.create(Icon.IMAGE);
  }

  default LucideIcon image_down_photography() {
    return LucideIcon.create(Icon.IMAGE_DOWN);
  }

  default LucideIcon image_minus_photography() {
    return LucideIcon.create(Icon.IMAGE_MINUS);
  }

  default LucideIcon image_off_photography() {
    return LucideIcon.create(Icon.IMAGE_OFF);
  }

  default LucideIcon image_play_photography() {
    return LucideIcon.create(Icon.IMAGE_PLAY);
  }

  default LucideIcon image_plus_photography() {
    return LucideIcon.create(Icon.IMAGE_PLUS);
  }

  default LucideIcon image_up_photography() {
    return LucideIcon.create(Icon.IMAGE_UP);
  }

  default LucideIcon image_upscale_photography() {
    return LucideIcon.create(Icon.IMAGE_UPSCALE);
  }

  default LucideIcon images_photography() {
    return LucideIcon.create(Icon.IMAGES);
  }

  default LucideIcon layout_list_photography() {
    return LucideIcon.create(Icon.LAYOUT_LIST);
  }

  default LucideIcon lens_photography() {
    return LucideIcon.create(Icon.LENS);
  }

  default LucideIcon library_photography() {
    return LucideIcon.create(Icon.LIBRARY);
  }

  default LucideIcon library_big_photography() {
    return LucideIcon.create(Icon.LIBRARY_BIG);
  }

  default LucideIcon lightbulb() {
    return LucideIcon.create(Icon.LIGHTBULB);
  }

  default LucideIcon lightbulb_off() {
    return LucideIcon.create(Icon.LIGHTBULB_OFF);
  }

  default LucideIcon paintbrush_photography() {
    return LucideIcon.create(Icon.PAINTBRUSH);
  }

  default LucideIcon paintbrush_vertical_photography() {
    return LucideIcon.create(Icon.PAINTBRUSH_VERTICAL);
  }

  default LucideIcon palette_photography() {
    return LucideIcon.create(Icon.PALETTE);
  }

  default LucideIcon pencil_sparkles_photography() {
    return LucideIcon.create(Icon.PENCIL_SPARKLES);
  }

  default LucideIcon presentation_photography() {
    return LucideIcon.create(Icon.PRESENTATION);
  }

  default LucideIcon projector_photography() {
    return LucideIcon.create(Icon.PROJECTOR);
  }

  default LucideIcon proportions_photography() {
    return LucideIcon.create(Icon.PROPORTIONS);
  }

  default LucideIcon ratio_photography() {
    return LucideIcon.create(Icon.RATIO);
  }

  default LucideIcon rotate_ccw_photography() {
    return LucideIcon.create(Icon.ROTATE_CCW);
  }

  default LucideIcon rotate_ccw_square_photography() {
    return LucideIcon.create(Icon.ROTATE_CCW_SQUARE);
  }

  default LucideIcon rotate_cw_photography() {
    return LucideIcon.create(Icon.ROTATE_CW);
  }

  default LucideIcon rotate_cw_square_photography() {
    return LucideIcon.create(Icon.ROTATE_CW_SQUARE);
  }

  default LucideIcon scan_eye_photography() {
    return LucideIcon.create(Icon.SCAN_EYE);
  }

  default LucideIcon scan_search_photography() {
    return LucideIcon.create(Icon.SCAN_SEARCH);
  }

  default LucideIcon scan_square_photography() {
    return LucideIcon.create(Icon.SCAN_SQUARE);
  }

  default LucideIcon spotlight_photography() {
    return LucideIcon.create(Icon.SPOTLIGHT);
  }

  default LucideIcon square_bookmark_photography() {
    return LucideIcon.create(Icon.SQUARE_BOOKMARK);
  }

  default LucideIcon square_centerline_dashed_horizontal_photography() {
    return LucideIcon.create(Icon.SQUARE_CENTERLINE_DASHED_HORIZONTAL);
  }

  default LucideIcon square_centerline_dashed_vertical_photography() {
    return LucideIcon.create(Icon.SQUARE_CENTERLINE_DASHED_VERTICAL);
  }

  default LucideIcon square_library_photography() {
    return LucideIcon.create(Icon.SQUARE_LIBRARY);
  }

  default LucideIcon square_sparkles_photography() {
    return LucideIcon.create(Icon.SQUARE_SPARKLES);
  }

  default LucideIcon swatch_book_photography() {
    return LucideIcon.create(Icon.SWATCH_BOOK);
  }

  default LucideIcon triangles_centerline_dashed_horizontal_photography() {
    return LucideIcon.create(Icon.TRIANGLES_CENTERLINE_DASHED_HORIZONTAL);
  }

  default LucideIcon triangles_centerline_dashed_vertical_photography() {
    return LucideIcon.create(Icon.TRIANGLES_CENTERLINE_DASHED_VERTICAL);
  }

  default LucideIcon video_photography() {
    return LucideIcon.create(Icon.VIDEO);
  }

  default LucideIcon video_off_photography() {
    return LucideIcon.create(Icon.VIDEO_OFF);
  }

  default LucideIcon videotape_photography() {
    return LucideIcon.create(Icon.VIDEOTAPE);
  }

  default LucideIcon view_photography() {
    return LucideIcon.create(Icon.VIEW);
  }

  default LucideIcon wand_photography() {
    return LucideIcon.create(Icon.WAND);
  }

  default LucideIcon wand_sparkles_photography() {
    return LucideIcon.create(Icon.WAND_SPARKLES);
  }

  default LucideIcon zap_photography() {
    return LucideIcon.create(Icon.ZAP);
  }

  default LucideIcon zap_off_photography() {
    return LucideIcon.create(Icon.ZAP_OFF);
  }

  default LucideIcon zoom_in_photography() {
    return LucideIcon.create(Icon.ZOOM_IN);
  }

  default LucideIcon zoom_out_photography() {
    return LucideIcon.create(Icon.ZOOM_OUT);
  }
}
