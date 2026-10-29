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

/** Tabler Logic catalog category. */
public interface TablerLogic {
  enum OutlineIcon implements TablerIconDefinition {
    LOGIC_AND(
        "logic-and",
        "<path d=\"M22 12h-5\" />\n  <path d=\"M2 9h5\" />\n  <path d=\"M2 15h5\" />\n  <path d=\"M9 5c6 0 8 3.5 8 7s-2 7 -8 7h-2v-14h2\" />"),
    LOGIC_BUFFER(
        "logic-buffer",
        "<path d=\"M22 12h-5\" />\n  <path d=\"M2 9h5\" />\n  <path d=\"M2 15h5\" />\n  <path d=\"M7 5l10 7l-10 7l0 -14\" />"),
    LOGIC_NAND(
        "logic-nand",
        "<path d=\"M22 12h-3\" />\n  <path d=\"M2 9h3\" />\n  <path d=\"M2 15h3\" />\n  <path d=\"M7 5c6 0 8 3.5 8 7s-2 7 -8 7h-2v-14h2\" />\n  <path d=\"M15 12a2 2 0 1 0 4 0a2 2 0 1 0 -4 0\" />"),
    LOGIC_NOR(
        "logic-nor",
        "<path d=\"M22 12h-4\" />\n  <path d=\"M2 9h5\" />\n  <path d=\"M2 15h5\" />\n  <path d=\"M6 5c10.667 2.1 10.667 12.6 0 14c1.806 -4.667 1.806 -9.333 0 -14\" />\n  <path d=\"M14 12a2 2 0 1 0 4 0a2 2 0 1 0 -4 0\" />"),
    LOGIC_NOT(
        "logic-not",
        "<path d=\"M22 12h-3\" />\n  <path d=\"M2 9h3\" />\n  <path d=\"M2 15h3\" />\n  <path d=\"M5 5l10 7l-10 7l0 -14\" />\n  <path d=\"M15 12a2 2 0 1 0 4 0a2 2 0 1 0 -4 0\" />"),
    LOGIC_OR(
        "logic-or",
        "<path d=\"M22 12h-6\" />\n  <path d=\"M2 9h7\" />\n  <path d=\"M2 15h7\" />\n  <path d=\"M8 5c10.667 2.1 10.667 12.6 0 14c1.806 -4.667 1.806 -9.333 0 -14\" />"),
    LOGIC_XNOR(
        "logic-xnor",
        "<path d=\"M22 12h-2\" />\n  <path d=\"M2 9h4\" />\n  <path d=\"M2 15h4\" />\n  <path d=\"M5 19c1.778 -4.667 1.778 -9.333 0 -14\" />\n  <path d=\"M8 5c10.667 2.1 10.667 12.6 0 14c1.806 -4.667 1.806 -9.333 0 -14\" />\n  <path d=\"M16 12a2 2 0 1 0 4 0a2 2 0 1 0 -4 0\" />"),
    LOGIC_XOR(
        "logic-xor",
        "<path d=\"M22 12h-4\" />\n  <path d=\"M2 9h6\" />\n  <path d=\"M2 15h6\" />\n  <path d=\"M7 19c1.778 -4.667 1.778 -9.333 0 -14\" />\n  <path d=\"M10 5c10.667 2.1 10.667 12.6 0 14c1.806 -4.667 1.806 -9.333 0 -14\" />");

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
    ;

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

  default TablerIcon logic_and() {
    return TablerIcon.create(TablerLogic.OutlineIcon.LOGIC_AND);
  }

  default TablerIcon logic_buffer() {
    return TablerIcon.create(TablerLogic.OutlineIcon.LOGIC_BUFFER);
  }

  default TablerIcon logic_nand() {
    return TablerIcon.create(TablerLogic.OutlineIcon.LOGIC_NAND);
  }

  default TablerIcon logic_nor() {
    return TablerIcon.create(TablerLogic.OutlineIcon.LOGIC_NOR);
  }

  default TablerIcon logic_not() {
    return TablerIcon.create(TablerLogic.OutlineIcon.LOGIC_NOT);
  }

  default TablerIcon logic_or() {
    return TablerIcon.create(TablerLogic.OutlineIcon.LOGIC_OR);
  }

  default TablerIcon logic_xnor() {
    return TablerIcon.create(TablerLogic.OutlineIcon.LOGIC_XNOR);
  }

  default TablerIcon logic_xor() {
    return TablerIcon.create(TablerLogic.OutlineIcon.LOGIC_XOR);
  }
}
