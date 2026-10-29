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

/** Tabler Database catalog category. */
public interface TablerDatabase {
  enum OutlineIcon implements TablerIconDefinition {
    COLUMN_INSERT_LEFT(
        "column-insert-left",
        "<path d=\"M14 4h4a1 1 0 0 1 1 1v14a1 1 0 0 1 -1 1h-4a1 1 0 0 1 -1 -1v-14a1 1 0 0 1 1 -1\" />\n  <path d=\"M5 12l4 0\" />\n  <path d=\"M7 10l0 4\" />"),
    COLUMN_INSERT_RIGHT(
        "column-insert-right",
        "<path d=\"M6 4h4a1 1 0 0 1 1 1v14a1 1 0 0 1 -1 1h-4a1 1 0 0 1 -1 -1v-14a1 1 0 0 1 1 -1\" />\n  <path d=\"M15 12l4 0\" />\n  <path d=\"M17 10l0 4\" />"),
    COLUMN_REMOVE(
        "column-remove",
        "<path d=\"M6 4h4a1 1 0 0 1 1 1v14a1 1 0 0 1 -1 1h-4a1 1 0 0 1 -1 -1v-14a1 1 0 0 1 1 -1\" />\n  <path d=\"M16 10l4 4\" />\n  <path d=\"M16 14l4 -4\" />"),
    DATABASE(
        "database",
        "<path d=\"M4 6a8 3 0 1 0 16 0a8 3 0 1 0 -16 0\" />\n  <path d=\"M4 6v6a8 3 0 0 0 16 0v-6\" />\n  <path d=\"M4 12v6a8 3 0 0 0 16 0v-6\" />"),
    DATABASE_COG(
        "database-cog",
        "<path d=\"M4 6c0 1.657 3.582 3 8 3s8 -1.343 8 -3s-3.582 -3 -8 -3s-8 1.343 -8 3\" />\n  <path d=\"M4 6v6c0 1.657 3.582 3 8 3c.21 0 .42 -.003 .626 -.01\" />\n  <path d=\"M20 11.5v-5.5\" />\n  <path d=\"M4 12v6c0 1.657 3.582 3 8 3\" />\n  <path d=\"M17.001 19a2 2 0 1 0 4 0a2 2 0 1 0 -4 0\" />\n  <path d=\"M19.001 15.5v1.5\" />\n  <path d=\"M19.001 21v1.5\" />\n  <path d=\"M22.032 17.25l-1.299 .75\" />\n  <path d=\"M17.27 20l-1.3 .75\" />\n  <path d=\"M15.97 17.25l1.3 .75\" />\n  <path d=\"M20.733 20l1.3 .75\" />"),
    DATABASE_DOLLAR(
        "database-dollar",
        "<path d=\"M4 6c0 1.657 3.582 3 8 3s8 -1.343 8 -3s-3.582 -3 -8 -3s-8 1.343 -8 3\" />\n  <path d=\"M4 6v6c0 1.657 3.582 3 8 3c.415 0 .822 -.012 1.22 -.035\" />\n  <path d=\"M20 10v-4\" />\n  <path d=\"M4 12v6c0 1.657 3.582 3 8 3c.352 0 .698 -.009 1.037 -.025\" />\n  <path d=\"M21 15h-2.5a1.5 1.5 0 0 0 0 3h1a1.5 1.5 0 0 1 0 3h-2.5\" />\n  <path d=\"M19 21v1m0 -8v1\" />"),
    DATABASE_EDIT(
        "database-edit",
        "<path d=\"M4 6c0 1.657 3.582 3 8 3s8 -1.343 8 -3s-3.582 -3 -8 -3s-8 1.343 -8 3\" />\n  <path d=\"M4 6v6c0 1.657 3.582 3 8 3c.478 0 .947 -.016 1.402 -.046\" />\n  <path d=\"M20 12v-6\" />\n  <path d=\"M4 12v6c0 1.526 3.04 2.786 6.972 2.975\" />\n  <path d=\"M18.42 15.61a2.1 2.1 0 0 1 2.97 2.97l-3.39 3.42h-3v-3l3.42 -3.39\" />"),
    DATABASE_EXCLAMATION(
        "database-exclamation",
        "<path d=\"M4 6c0 1.657 3.582 3 8 3s8 -1.343 8 -3s-3.582 -3 -8 -3s-8 1.343 -8 3\" />\n  <path d=\"M4 6v6c0 1.657 3.582 3 8 3c1.118 0 2.182 -.086 3.148 -.241m4.852 -2.759v-6\" />\n  <path d=\"M4 12v6c0 1.657 3.582 3 8 3c1.064 0 2.079 -.078 3.007 -.22\" />\n  <path d=\"M19 16v3\" />\n  <path d=\"M19 22v.01\" />"),
    DATABASE_EXPORT(
        "database-export",
        "<path d=\"M4 6c0 1.657 3.582 3 8 3s8 -1.343 8 -3s-3.582 -3 -8 -3s-8 1.343 -8 3\" />\n  <path d=\"M4 6v6c0 1.657 3.582 3 8 3c1.118 0 2.183 -.086 3.15 -.241\" />\n  <path d=\"M20 12v-6\" />\n  <path d=\"M4 12v6c0 1.657 3.582 3 8 3c.157 0 .312 -.002 .466 -.005\" />\n  <path d=\"M16 19h6\" />\n  <path d=\"M19 16l3 3l-3 3\" />"),
    DATABASE_HEART(
        "database-heart",
        "<path d=\"M4 6c0 1.657 3.582 3 8 3s8 -1.343 8 -3s-3.582 -3 -8 -3s-8 1.343 -8 3\" />\n  <path d=\"M4 6v6c0 1.453 2.755 2.665 6.414 2.941\" />\n  <path d=\"M20 11v-5\" />\n  <path d=\"M4 12v6c0 1.579 3.253 2.873 7.383 2.991\" />\n  <path d=\"M18 22l3.35 -3.284a2.143 2.143 0 0 0 .005 -3.071a2.242 2.242 0 0 0 -3.129 -.006l-.224 .22l-.223 -.22a2.242 2.242 0 0 0 -3.128 -.006a2.143 2.143 0 0 0 -.006 3.071l3.355 3.296\" />"),
    DATABASE_IMPORT(
        "database-import",
        "<path d=\"M4 6c0 1.657 3.582 3 8 3s8 -1.343 8 -3s-3.582 -3 -8 -3s-8 1.343 -8 3\" />\n  <path d=\"M4 6v6c0 1.657 3.582 3 8 3c.856 0 1.68 -.05 2.454 -.144m5.546 -2.856v-6\" />\n  <path d=\"M4 12v6c0 1.657 3.582 3 8 3c.171 0 .341 -.002 .51 -.006\" />\n  <path d=\"M19 22v-6\" />\n  <path d=\"M22 19l-3 -3l-3 3\" />"),
    DATABASE_LEAK(
        "database-leak",
        "<path d=\"M4 6c0 1.657 3.582 3 8 3s8 -1.343 8 -3s-3.582 -3 -8 -3s-8 1.343 -8 3\" />\n  <path d=\"M4 6v12c0 1.657 3.582 3 8 3s8 -1.343 8 -3v-12\" />\n  <path d=\"M4 15a2.4 2.4 0 0 0 2 -1a2.4 2.4 0 0 1 2 -1a2.4 2.4 0 0 1 2 1a2.4 2.4 0 0 0 2 1a2.4 2.4 0 0 0 2 -1a2.4 2.4 0 0 1 2 -1a2.4 2.4 0 0 1 2 1a2.4 2.4 0 0 0 2 1\" />"),
    DATABASE_MINUS(
        "database-minus",
        "<path d=\"M4 6c0 1.657 3.582 3 8 3s8 -1.343 8 -3s-3.582 -3 -8 -3s-8 1.343 -8 3\" />\n  <path d=\"M4 6v6c0 1.657 3.582 3 8 3s8 -1.343 8 -3v-6\" />\n  <path d=\"M4 12v6c0 1.657 3.582 3 8 3c.164 0 .328 -.002 .49 -.006\" />\n  <path d=\"M20 15v-3\" />\n  <path d=\"M16 19h6\" />"),
    DATABASE_OFF(
        "database-off",
        "<path d=\"M12.983 8.978c3.955 -.182 7.017 -1.446 7.017 -2.978c0 -1.657 -3.582 -3 -8 -3c-1.661 0 -3.204 .19 -4.483 .515m-2.783 1.228c-.471 .382 -.734 .808 -.734 1.257c0 1.22 1.944 2.271 4.734 2.74\" />\n  <path d=\"M4 6v6c0 1.657 3.582 3 8 3c.986 0 1.93 -.067 2.802 -.19m3.187 -.82c1.251 -.53 2.011 -1.228 2.011 -1.99v-6\" />\n  <path d=\"M4 12v6c0 1.657 3.582 3 8 3c3.217 0 5.991 -.712 7.261 -1.74m.739 -3.26v-4\" />\n  <path d=\"M3 3l18 18\" />"),
    DATABASE_PLUS(
        "database-plus",
        "<path d=\"M4 6c0 1.657 3.582 3 8 3s8 -1.343 8 -3s-3.582 -3 -8 -3s-8 1.343 -8 3\" />\n  <path d=\"M4 6v6c0 1.657 3.582 3 8 3c1.075 0 2.1 -.08 3.037 -.224\" />\n  <path d=\"M20 12v-6\" />\n  <path d=\"M4 12v6c0 1.657 3.582 3 8 3c.166 0 .331 -.002 .495 -.006\" />\n  <path d=\"M16 19h6\" />\n  <path d=\"M19 16v6\" />"),
    DATABASE_SEARCH(
        "database-search",
        "<path d=\"M4 6c0 1.657 3.582 3 8 3s8 -1.343 8 -3s-3.582 -3 -8 -3s-8 1.343 -8 3\" />\n  <path d=\"M4 6v6c0 1.657 3.582 3 8 3m8 -3.5v-5.5\" />\n  <path d=\"M4 12v6c0 1.657 3.582 3 8 3\" />\n  <path d=\"M15 18a3 3 0 1 0 6 0a3 3 0 1 0 -6 0\" />\n  <path d=\"M20.2 20.2l1.8 1.8\" />"),
    DATABASE_SHARE(
        "database-share",
        "<path d=\"M4 6c0 1.657 3.582 3 8 3s8 -1.343 8 -3s-3.582 -3 -8 -3s-8 1.343 -8 3\" />\n  <path d=\"M4 6v6c0 1.657 3.582 3 8 3c.361 0 .716 -.009 1.065 -.026\" />\n  <path d=\"M20 13v-7\" />\n  <path d=\"M4 12v6c0 1.657 3.582 3 8 3\" />\n  <path d=\"M16 22l5 -5\" />\n  <path d=\"M21 21.5v-4.5h-4.5\" />"),
    DATABASE_STAR(
        "database-star",
        "<path d=\"M4 6c0 1.657 3.582 3 8 3s8 -1.343 8 -3s-3.582 -3 -8 -3s-8 1.343 -8 3\" />\n  <path d=\"M4 6v6c0 1.43 2.67 2.627 6.243 2.927\" />\n  <path d=\"M20 10.5v-4.5\" />\n  <path d=\"M4 12v6c0 1.546 3.12 2.82 7.128 2.982\" />\n  <path d=\"M17.8 20.817l-2.172 1.138a.392 .392 0 0 1 -.568 -.41l.415 -2.411l-1.757 -1.707a.389 .389 0 0 1 .217 -.665l2.428 -.352l1.086 -2.193a.392 .392 0 0 1 .702 0l1.086 2.193l2.428 .352a.39 .39 0 0 1 .217 .665l-1.757 1.707l.414 2.41a.39 .39 0 0 1 -.567 .411l-2.172 -1.138\" />"),
    DATABASE_X(
        "database-x",
        "<path d=\"M4 6c0 1.657 3.582 3 8 3s8 -1.343 8 -3s-3.582 -3 -8 -3s-8 1.343 -8 3\" />\n  <path d=\"M4 6v6c0 1.657 3.582 3 8 3c.537 0 1.062 -.02 1.57 -.058\" />\n  <path d=\"M20 13.5v-7.5\" />\n  <path d=\"M4 12v6c0 1.657 3.582 3 8 3c.384 0 .762 -.01 1.132 -.03\" />\n  <path d=\"M22 22l-5 -5\" />\n  <path d=\"M17 22l5 -5\" />"),
    RELATION_MANY_TO_MANY(
        "relation-many-to-many",
        "<path d=\"M3 7a2 2 0 0 1 2 -2h14a2 2 0 0 1 2 2v10a2 2 0 0 1 -2 2h-14a2 2 0 0 1 -2 -2v-10\" />\n  <path d=\"M15 14v-4l3 4v-4\" />\n  <path d=\"M6 14v-4l3 4v-4\" />\n  <path d=\"M12 10.5l0 .01\" />\n  <path d=\"M12 13.5l0 .01\" />"),
    RELATION_ONE_TO_MANY(
        "relation-one-to-many",
        "<path d=\"M3 7a2 2 0 0 1 2 -2h14a2 2 0 0 1 2 2v10a2 2 0 0 1 -2 2h-14a2 2 0 0 1 -2 -2v-10\" />\n  <path d=\"M7 10h1v4\" />\n  <path d=\"M14 14v-4l3 4v-4\" />\n  <path d=\"M11 10.5l0 .01\" />\n  <path d=\"M11 13.5l0 .01\" />"),
    RELATION_ONE_TO_ONE(
        "relation-one-to-one",
        "<path d=\"M3 7a2 2 0 0 1 2 -2h14a2 2 0 0 1 2 2v10a2 2 0 0 1 -2 2h-14a2 2 0 0 1 -2 -2v-10\" />\n  <path d=\"M8 10h1v4\" />\n  <path d=\"M15 10h1v4\" />\n  <path d=\"M12 10.5l0 .01\" />\n  <path d=\"M12 13.5l0 .01\" />"),
    ROW_INSERT_BOTTOM(
        "row-insert-bottom",
        "<path d=\"M20 6v4a1 1 0 0 1 -1 1h-14a1 1 0 0 1 -1 -1v-4a1 1 0 0 1 1 -1h14a1 1 0 0 1 1 1\" />\n  <path d=\"M12 15l0 4\" />\n  <path d=\"M14 17l-4 0\" />"),
    ROW_INSERT_TOP(
        "row-insert-top",
        "<path d=\"M4 18v-4a1 1 0 0 1 1 -1h14a1 1 0 0 1 1 1v4a1 1 0 0 1 -1 1h-14a1 1 0 0 1 -1 -1\" />\n  <path d=\"M12 9v-4\" />\n  <path d=\"M10 7l4 0\" />"),
    ROW_REMOVE(
        "row-remove",
        "<path d=\"M20 6v4a1 1 0 0 1 -1 1h-14a1 1 0 0 1 -1 -1v-4a1 1 0 0 1 1 -1h14a1 1 0 0 1 1 1\" />\n  <path d=\"M10 16l4 4\" />\n  <path d=\"M10 20l4 -4\" />"),
    SCHEMA(
        "schema",
        "<path d=\"M5 2h5v4h-5l0 -4\" />\n  <path d=\"M15 10h5v4h-5l0 -4\" />\n  <path d=\"M5 18h5v4h-5l0 -4\" />\n  <path d=\"M5 10h5v4h-5l0 -4\" />\n  <path d=\"M10 12h5\" />\n  <path d=\"M7.5 6v4\" />\n  <path d=\"M7.5 14v4\" />"),
    SCHEMA_OFF(
        "schema-off",
        "<path d=\"M6 2h4v4m-4 0h-1v-1\" />\n  <path d=\"M15 11v-1h5v4h-2\" />\n  <path d=\"M5 18h5v4h-5l0 -4\" />\n  <path d=\"M5 10h5v4h-5l0 -4\" />\n  <path d=\"M10 12h2\" />\n  <path d=\"M7.5 7.5v2.5\" />\n  <path d=\"M7.5 14v4\" />\n  <path d=\"M3 3l18 18\" />"),
    TABLE(
        "table",
        "<path d=\"M3 5a2 2 0 0 1 2 -2h14a2 2 0 0 1 2 2v14a2 2 0 0 1 -2 2h-14a2 2 0 0 1 -2 -2v-14\" />\n  <path d=\"M3 10h18\" />\n  <path d=\"M10 3v18\" />"),
    TABLE_ALIAS(
        "table-alias",
        "<path d=\"M3 12v-7a2 2 0 0 1 2 -2h14a2 2 0 0 1 2 2v14a2 2 0 0 1 -2 2h-7\" />\n  <path d=\"M3 10h18\" />\n  <path d=\"M10 3v10\" />\n  <path d=\"M2 17a1 1 0 0 1 1 -1h4a1 1 0 0 1 1 1v4a1 1 0 0 1 -1 1h-4a1 1 0 0 1 -1 -1v-4\" />"),
    TABLE_COLUMN(
        "table-column",
        "<path d=\"M3 5a2 2 0 0 1 2 -2h14a2 2 0 0 1 2 2v14a2 2 0 0 1 -2 2h-14a2 2 0 0 1 -2 -2v-14\" />\n  <path d=\"M10 10h11\" />\n  <path d=\"M10 3v18\" />\n  <path d=\"M9 3l-6 6\" />\n  <path d=\"M10 7l-7 7\" />\n  <path d=\"M10 12l-7 7\" />\n  <path d=\"M10 17l-4 4\" />"),
    TABLE_DOWN(
        "table-down",
        "<path d=\"M12.5 21h-7.5a2 2 0 0 1 -2 -2v-14a2 2 0 0 1 2 -2h14a2 2 0 0 1 2 2v7.5\" />\n  <path d=\"M3 10h18\" />\n  <path d=\"M10 3v18\" />\n  <path d=\"M19 16v6\" />\n  <path d=\"M22 19l-3 3l-3 -3\" />"),
    TABLE_EXPORT(
        "table-export",
        "<path d=\"M12.5 21h-7.5a2 2 0 0 1 -2 -2v-14a2 2 0 0 1 2 -2h14a2 2 0 0 1 2 2v7.5\" />\n  <path d=\"M3 10h18\" />\n  <path d=\"M10 3v18\" />\n  <path d=\"M16 19h6\" />\n  <path d=\"M19 16l3 3l-3 3\" />"),
    TABLE_HEART(
        "table-heart",
        "<path d=\"M11.5 21h-6.5a2 2 0 0 1 -2 -2v-14a2 2 0 0 1 2 -2h14a2 2 0 0 1 2 2v6\" />\n  <path d=\"M3 10h18\" />\n  <path d=\"M10 3v18\" />\n  <path d=\"M18 22l3.35 -3.284a2.143 2.143 0 0 0 .005 -3.071a2.242 2.242 0 0 0 -3.129 -.006l-.224 .22l-.223 -.22a2.242 2.242 0 0 0 -3.128 -.006a2.143 2.143 0 0 0 -.006 3.071l3.355 3.296\" />"),
    TABLE_IMPORT(
        "table-import",
        "<path d=\"M12 21h-7a2 2 0 0 1 -2 -2v-14a2 2 0 0 1 2 -2h14a2 2 0 0 1 2 2v8\" />\n  <path d=\"M3 10h18\" />\n  <path d=\"M10 3v18\" />\n  <path d=\"M19 22v-6\" />\n  <path d=\"M22 19l-3 -3l-3 3\" />"),
    TABLE_MINUS(
        "table-minus",
        "<path d=\"M12.5 21h-7.5a2 2 0 0 1 -2 -2v-14a2 2 0 0 1 2 -2h14a2 2 0 0 1 2 2v10\" />\n  <path d=\"M3 10h18\" />\n  <path d=\"M10 3v18\" />\n  <path d=\"M16 19h6\" />"),
    TABLE_OFF(
        "table-off",
        "<path d=\"M7 3h12a2 2 0 0 1 2 2v12m-.585 3.413a1.994 1.994 0 0 1 -1.415 .587h-14a2 2 0 0 1 -2 -2v-14c0 -.55 .223 -1.05 .583 -1.412\" />\n  <path d=\"M3 10h7m4 0h7\" />\n  <path d=\"M10 3v3m0 4v11\" />\n  <path d=\"M3 3l18 18\" />"),
    TABLE_OPTIONS(
        "table-options",
        "<path d=\"M12 21h-7a2 2 0 0 1 -2 -2v-14a2 2 0 0 1 2 -2h14a2 2 0 0 1 2 2v7\" />\n  <path d=\"M3 10h18\" />\n  <path d=\"M10 3v18\" />\n  <path d=\"M17.001 19a2 2 0 1 0 4 0a2 2 0 1 0 -4 0\" />\n  <path d=\"M19.001 15.5v1.5\" />\n  <path d=\"M19.001 21v1.5\" />\n  <path d=\"M22.032 17.25l-1.299 .75\" />\n  <path d=\"M17.27 20l-1.3 .75\" />\n  <path d=\"M15.97 17.25l1.3 .75\" />\n  <path d=\"M20.733 20l1.3 .75\" />"),
    TABLE_PLUS(
        "table-plus",
        "<path d=\"M12.5 21h-7.5a2 2 0 0 1 -2 -2v-14a2 2 0 0 1 2 -2h14a2 2 0 0 1 2 2v7.5\" />\n  <path d=\"M3 10h18\" />\n  <path d=\"M10 3v18\" />\n  <path d=\"M16 19h6\" />\n  <path d=\"M19 16v6\" />"),
    TABLE_ROW(
        "table-row",
        "<path d=\"M3 5a2 2 0 0 1 2 -2h14a2 2 0 0 1 2 2v14a2 2 0 0 1 -2 2h-14a2 2 0 0 1 -2 -2v-14\" />\n  <path d=\"M9 3l-6 6\" />\n  <path d=\"M14 3l-7 7\" />\n  <path d=\"M19 3l-7 7\" />\n  <path d=\"M21 6l-4 4\" />\n  <path d=\"M3 10h18\" />\n  <path d=\"M10 10v11\" />"),
    TABLE_SHARE(
        "table-share",
        "<path d=\"M12 21h-7a2 2 0 0 1 -2 -2v-14a2 2 0 0 1 2 -2h14a2 2 0 0 1 2 2v8\" />\n  <path d=\"M3 10h18\" />\n  <path d=\"M10 3v18\" />\n  <path d=\"M16 22l5 -5\" />\n  <path d=\"M21 21.5v-4.5h-4.5\" />"),
    TABLE_SHORTCUT(
        "table-shortcut",
        "<path d=\"M3 13v-8a2 2 0 0 1 2 -2h14a2 2 0 0 1 2 2v14a2 2 0 0 1 -2 2h-8\" />\n  <path d=\"M3 10h18\" />\n  <path d=\"M10 3v11\" />\n  <path d=\"M2 22l5 -5\" />\n  <path d=\"M7 21.5v-4.5h-4.5\" />"),
    TABLE_SPARK(
        "table-spark",
        "<path d=\"M19 22.5a4.75 4.75 0 0 1 3.5 -3.5a4.75 4.75 0 0 1 -3.5 -3.5a4.75 4.75 0 0 1 -3.5 3.5a4.75 4.75 0 0 1 3.5 3.5\" />\n  <path d=\"M12 21h-7a2 2 0 0 1 -2 -2v-14a2 2 0 0 1 2 -2h14a2 2 0 0 1 2 2v7\" />\n  <path d=\"M3 10h18\" />\n  <path d=\"M10 3v18\" />");

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
    DATABASE(
        "database",
        "<path d=\"M3 15.731c1.968 1.507 5.234 2.269 9 2.269c3.76 0 7.025 -.76 9 -2.252v2.252c0 2.425 -3.895 3.936 -8.693 3.998l-.307 .002c-4.938 0 -9 -1.523 -9 -4z\" />\n  <path d=\"M3 9.731c1.968 1.507 5.234 2.269 9 2.269c3.76 0 7.025 -.76 9 -2.252v2.252c0 2.477 -4.062 4 -9 4c-4.798 0 -8.77 -1.438 -8.979 -3.795l-.016 -.101l-.005 -.104z\" />\n  <path d=\"M12 2c1.041 0 2.044 .068 2.977 .198l.469 .071q .84 .14 1.586 .348l.44 .131l.075 .024a11 11 0 0 1 .805 .3l.199 .086q .535 .242 .967 .53q .165 .11 .313 .225a3.8 3.8 0 0 1 .669 .668l.091 .128q .07 .105 .129 .211l.07 .139q .163 .35 .2 .73l.01 .211c0 2.477 -4.062 4 -9 4c-4.798 0 -8.77 -1.438 -8.979 -3.795a1 1 0 0 1 -.021 -.205l.005 -.104l.016 -.1c.205 -2.306 4.01 -3.733 8.667 -3.794z\" />"),
    RELATION_MANY_TO_MANY(
        "relation-many-to-many",
        "<path d=\"M19 4a3 3 0 0 1 3 3v10a3 3 0 0 1 -3 3h-14a3 3 0 0 1 -3 -3v-10a3 3 0 0 1 3 -3zm-3.2 5.4c-.577 -.769 -1.8 -.361 -1.8 .6v4a1 1 0 0 0 1 1l.117 -.007a1 1 0 0 0 .883 -.993v-1l1.2 1.6c.577 .769 1.8 .361 1.8 -.6v-4a1 1 0 0 0 -1 -1l-.117 .007a1 1 0 0 0 -.883 .993v1zm-9 0c-.577 -.769 -1.8 -.361 -1.8 .6v4a1 1 0 0 0 1 1l.117 -.007a1 1 0 0 0 .883 -.993v-1l1.2 1.6c.577 .769 1.8 .361 1.8 -.6v-4a1 1 0 0 0 -1 -1l-.117 .007a1 1 0 0 0 -.883 .993v1zm5.2 3.1a1 1 0 0 0 -1 1v.01a1 1 0 0 0 2 0v-.01a1 1 0 0 0 -1 -1m0 -3a1 1 0 0 0 -1 1v.01a1 1 0 0 0 2 0v-.01a1 1 0 0 0 -1 -1\" />"),
    RELATION_ONE_TO_MANY(
        "relation-one-to-many",
        "<path d=\"M19 4a3 3 0 0 1 3 3v10a3 3 0 0 1 -3 3h-14a3 3 0 0 1 -3 -3v-10a3 3 0 0 1 3 -3zm-4.2 5.4c-.577 -.769 -1.8 -.361 -1.8 .6v4a1 1 0 0 0 1 1l.117 -.007a1 1 0 0 0 .883 -.993v-1l1.2 1.6c.577 .769 1.8 .361 1.8 -.6v-4a1 1 0 0 0 -1 -1l-.117 .007a1 1 0 0 0 -.883 .993v1zm-6.8 -.4h-1a1 1 0 1 0 0 2v3a1 1 0 0 0 2 0v-4a1 1 0 0 0 -1 -1m3 3.5a1 1 0 0 0 -1 1v.01a1 1 0 0 0 2 0v-.01a1 1 0 0 0 -1 -1m0 -3a1 1 0 0 0 -1 1v.01a1 1 0 0 0 2 0v-.01a1 1 0 0 0 -1 -1\" />"),
    RELATION_ONE_TO_ONE(
        "relation-one-to-one",
        "<path d=\"M19 4a3 3 0 0 1 3 3v10a3 3 0 0 1 -3 3h-14a3 3 0 0 1 -3 -3v-10a3 3 0 0 1 3 -3zm-10 5h-1a1 1 0 1 0 0 2v3a1 1 0 0 0 2 0v-4a1 1 0 0 0 -1 -1m7 0h-1a1 1 0 0 0 0 2v3a1 1 0 0 0 2 0v-4a1 1 0 0 0 -1 -1m-4 3.5a1 1 0 0 0 -1 1v.01a1 1 0 0 0 2 0v-.01a1 1 0 0 0 -1 -1m0 -3a1 1 0 0 0 -1 1v.01a1 1 0 0 0 2 0v-.01a1 1 0 0 0 -1 -1\" />"),
    TABLE(
        "table",
        "<path d=\"M4 11h4a1 1 0 0 1 1 1v8a1 1 0 0 1 -1 1h-2a3 3 0 0 1 -2.995 -2.824l-.005 -.176v-6a1 1 0 0 1 1 -1z\" />\n  <path d=\"M21 12v6a3 3 0 0 1 -2.824 2.995l-.176 .005h-6a1 1 0 0 1 -1 -1v-8a1 1 0 0 1 1 -1h8a1 1 0 0 1 1 1z\" />\n  <path d=\"M18 3a3 3 0 0 1 2.995 2.824l.005 .176v2a1 1 0 0 1 -1 1h-8a1 1 0 0 1 -1 -1v-4a1 1 0 0 1 1 -1h6z\" />\n  <path d=\"M9 4v4a1 1 0 0 1 -1 1h-4a1 1 0 0 1 -1 -1v-2a3 3 0 0 1 2.824 -2.995l.176 -.005h2a1 1 0 0 1 1 1z\" />");

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

  default TablerIcon column_insert_left() {
    return TablerIcon.create(TablerDatabase.OutlineIcon.COLUMN_INSERT_LEFT);
  }

  default TablerIcon column_insert_right() {
    return TablerIcon.create(TablerDatabase.OutlineIcon.COLUMN_INSERT_RIGHT);
  }

  default TablerIcon column_remove() {
    return TablerIcon.create(TablerDatabase.OutlineIcon.COLUMN_REMOVE);
  }

  default TablerIcon database() {
    return TablerIcon.create(TablerDatabase.OutlineIcon.DATABASE);
  }

  default TablerIcon database_cog() {
    return TablerIcon.create(TablerDatabase.OutlineIcon.DATABASE_COG);
  }

  default TablerIcon database_dollar() {
    return TablerIcon.create(TablerDatabase.OutlineIcon.DATABASE_DOLLAR);
  }

  default TablerIcon database_edit() {
    return TablerIcon.create(TablerDatabase.OutlineIcon.DATABASE_EDIT);
  }

  default TablerIcon database_exclamation() {
    return TablerIcon.create(TablerDatabase.OutlineIcon.DATABASE_EXCLAMATION);
  }

  default TablerIcon database_export() {
    return TablerIcon.create(TablerDatabase.OutlineIcon.DATABASE_EXPORT);
  }

  default TablerIcon database_heart() {
    return TablerIcon.create(TablerDatabase.OutlineIcon.DATABASE_HEART);
  }

  default TablerIcon database_import() {
    return TablerIcon.create(TablerDatabase.OutlineIcon.DATABASE_IMPORT);
  }

  default TablerIcon database_leak() {
    return TablerIcon.create(TablerDatabase.OutlineIcon.DATABASE_LEAK);
  }

  default TablerIcon database_minus() {
    return TablerIcon.create(TablerDatabase.OutlineIcon.DATABASE_MINUS);
  }

  default TablerIcon database_off() {
    return TablerIcon.create(TablerDatabase.OutlineIcon.DATABASE_OFF);
  }

  default TablerIcon database_plus() {
    return TablerIcon.create(TablerDatabase.OutlineIcon.DATABASE_PLUS);
  }

  default TablerIcon database_search() {
    return TablerIcon.create(TablerDatabase.OutlineIcon.DATABASE_SEARCH);
  }

  default TablerIcon database_share() {
    return TablerIcon.create(TablerDatabase.OutlineIcon.DATABASE_SHARE);
  }

  default TablerIcon database_star() {
    return TablerIcon.create(TablerDatabase.OutlineIcon.DATABASE_STAR);
  }

  default TablerIcon database_x() {
    return TablerIcon.create(TablerDatabase.OutlineIcon.DATABASE_X);
  }

  default TablerIcon relation_many_to_many() {
    return TablerIcon.create(TablerDatabase.OutlineIcon.RELATION_MANY_TO_MANY);
  }

  default TablerIcon relation_one_to_many() {
    return TablerIcon.create(TablerDatabase.OutlineIcon.RELATION_ONE_TO_MANY);
  }

  default TablerIcon relation_one_to_one() {
    return TablerIcon.create(TablerDatabase.OutlineIcon.RELATION_ONE_TO_ONE);
  }

  default TablerIcon row_insert_bottom() {
    return TablerIcon.create(TablerDatabase.OutlineIcon.ROW_INSERT_BOTTOM);
  }

  default TablerIcon row_insert_top() {
    return TablerIcon.create(TablerDatabase.OutlineIcon.ROW_INSERT_TOP);
  }

  default TablerIcon row_remove() {
    return TablerIcon.create(TablerDatabase.OutlineIcon.ROW_REMOVE);
  }

  default TablerIcon schema() {
    return TablerIcon.create(TablerDatabase.OutlineIcon.SCHEMA);
  }

  default TablerIcon schema_off() {
    return TablerIcon.create(TablerDatabase.OutlineIcon.SCHEMA_OFF);
  }

  default TablerIcon table() {
    return TablerIcon.create(TablerDatabase.OutlineIcon.TABLE);
  }

  default TablerIcon table_alias() {
    return TablerIcon.create(TablerDatabase.OutlineIcon.TABLE_ALIAS);
  }

  default TablerIcon table_column() {
    return TablerIcon.create(TablerDatabase.OutlineIcon.TABLE_COLUMN);
  }

  default TablerIcon table_down() {
    return TablerIcon.create(TablerDatabase.OutlineIcon.TABLE_DOWN);
  }

  default TablerIcon table_export() {
    return TablerIcon.create(TablerDatabase.OutlineIcon.TABLE_EXPORT);
  }

  default TablerIcon table_heart() {
    return TablerIcon.create(TablerDatabase.OutlineIcon.TABLE_HEART);
  }

  default TablerIcon table_import() {
    return TablerIcon.create(TablerDatabase.OutlineIcon.TABLE_IMPORT);
  }

  default TablerIcon table_minus() {
    return TablerIcon.create(TablerDatabase.OutlineIcon.TABLE_MINUS);
  }

  default TablerIcon table_off() {
    return TablerIcon.create(TablerDatabase.OutlineIcon.TABLE_OFF);
  }

  default TablerIcon table_options() {
    return TablerIcon.create(TablerDatabase.OutlineIcon.TABLE_OPTIONS);
  }

  default TablerIcon table_plus() {
    return TablerIcon.create(TablerDatabase.OutlineIcon.TABLE_PLUS);
  }

  default TablerIcon table_row() {
    return TablerIcon.create(TablerDatabase.OutlineIcon.TABLE_ROW);
  }

  default TablerIcon table_share() {
    return TablerIcon.create(TablerDatabase.OutlineIcon.TABLE_SHARE);
  }

  default TablerIcon table_shortcut() {
    return TablerIcon.create(TablerDatabase.OutlineIcon.TABLE_SHORTCUT);
  }

  default TablerIcon table_spark() {
    return TablerIcon.create(TablerDatabase.OutlineIcon.TABLE_SPARK);
  }

  default TablerIcon database_filled() {
    return TablerIcon.create(TablerDatabase.FilledIcon.DATABASE);
  }

  default TablerIcon relation_many_to_many_filled() {
    return TablerIcon.create(TablerDatabase.FilledIcon.RELATION_MANY_TO_MANY);
  }

  default TablerIcon relation_one_to_many_filled() {
    return TablerIcon.create(TablerDatabase.FilledIcon.RELATION_ONE_TO_MANY);
  }

  default TablerIcon relation_one_to_one_filled() {
    return TablerIcon.create(TablerDatabase.FilledIcon.RELATION_ONE_TO_ONE);
  }

  default TablerIcon table_filled() {
    return TablerIcon.create(TablerDatabase.FilledIcon.TABLE);
  }
}
