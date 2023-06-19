/*
 * Copyright © 2019 Dominokit
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
package org.dominokit.domino.ui.style;

import static java.util.Objects.nonNull;

import elemental2.dom.Element;

/**
 * A class to apply a box-shadow to any element
 *
 * <p>This enum list a set of predefined of box-shadow effects css classes, each enum values is a
 * css class name Example
 *
 * <pre>
 *     someDominoElement.elevate(Elevation.LEVEL_3)
 *     </pre>
 */
public enum Elevation {
  NONE("elevation-none"),
  LEVEL_0("elevation-0"),
  LEVEL_1("elevation-1"),
  LEVEL_2("elevation-2"),
  LEVEL_3("elevation-3"),
  LEVEL_4("elevation-4"),
  LEVEL_5("elevation-5"),
  LEVEL_6("elevation-6"),
  LEVEL_7("elevation-7"),
  LEVEL_8("elevation-8"),
  LEVEL_9("elevation-9"),
  LEVEL_10("elevation-10"),
  LEVEL_11("elevation-11"),
  LEVEL_12("elevation-12"),
  LEVEL_13("elevation-13"),
  LEVEL_14("elevation-14"),
  LEVEL_15("elevation-15"),
  LEVEL_16("elevation-16"),
  LEVEL_17("elevation-17"),
  LEVEL_18("elevation-18"),
  LEVEL_19("elevation-19"),
  LEVEL_20("elevation-20"),
  LEVEL_21("elevation-21"),
  LEVEL_22("elevation-22"),
  LEVEL_23("elevation-23"),
  LEVEL_24("elevation-24");

  private String style;

  /** @param style String, The css class name for the box-shadow effect */
  Elevation(String style) {
    this.style = style;
  }

  /** @return String, the elevation css class name */
  public String getStyle() {
    return style;
  }

  /**
   * a factory method to get an Elevation enum value from an int value.
   *
   * @param level int value the larger the value the larger the shadow
   * @return Elevation
   */
  public static Elevation of(int level) {
    switch (level) {
      case 0:
        return LEVEL_0;
      case 1:
        return LEVEL_1;
      case 2:
        return LEVEL_2;
      case 3:
        return LEVEL_3;
      case 4:
        return LEVEL_4;
      case 5:
        return LEVEL_5;
      case 6:
        return LEVEL_6;
      case 7:
        return LEVEL_7;
      case 8:
        return LEVEL_8;
      case 9:
        return LEVEL_9;
      case 10:
        return LEVEL_10;
      case 11:
        return LEVEL_11;
      case 12:
        return LEVEL_12;
      case 13:
        return LEVEL_13;
      case 14:
        return LEVEL_14;
      case 15:
        return LEVEL_15;
      case 16:
        return LEVEL_16;
      case 17:
        return LEVEL_17;
      case 18:
        return LEVEL_18;
      case 19:
        return LEVEL_19;
      case 20:
        return LEVEL_20;
      case 21:
        return LEVEL_21;
      case 22:
        return LEVEL_22;
      case 23:
        return LEVEL_23;
      case 24:
        return LEVEL_24;
      default:
        if (level < 0) {
          return LEVEL_0;
        } else {
          return LEVEL_24;
        }
    }
  }

  /**
   * Removes all elevation css classes from an element
   *
   * @param element an {@link Element} to remove the css classes from.
   */
  public static void removeFrom(Element element) {
    String elevationClass = "";
    for (int i = 0; i < element.classList.length; i++) {
      if (element.classList.item(i).startsWith("elevation-")) {
        elevationClass = element.classList.item(i);
      }
    }
    if (nonNull(elevationClass) && !elevationClass.isEmpty()) {
      element.classList.remove(elevationClass);
    }
  }
}
