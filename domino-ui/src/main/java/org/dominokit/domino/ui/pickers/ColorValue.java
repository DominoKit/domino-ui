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
package org.dominokit.domino.ui.pickers;

import static java.util.Objects.isNull;

public class ColorValue {

  private final String rgb;
  private final String hex;
  private final int red;
  private final int green;
  private final int blue;

  public static ColorValue of(String value) {
    return new ColorValue(value);
  }

  public static ColorValue of(int red, int green, int blue) {
    return new ColorValue(red, green, blue);
  }

  public ColorValue(int red, int green, int blue) {
    this.red = red;
    this.green = green;
    this.blue = blue;
    this.hex = rgbToHex(red, green, blue);
    this.rgb = "rgb(" + red + ", " + green + ", " + blue + ")";
  }

  public ColorValue(String value) {
    if (isNull(value) || value.trim().isEmpty()) {
      throw new IllegalArgumentException(
          "Color cannot be null or empty, use #XXXXXX hex format or rgb(red, green, blue) format string.");
    }
    if (value.startsWith("#")) {
      if (value.length() < 7) {
        throw new IllegalArgumentException("Invalid hex format, use #XXXXXX hex format.");
      }
      this.hex = value;
      String temp = hex.replace("#", "");
      String redHex = temp.substring(0, 2);
      String greenHex = temp.substring(2, 4);
      String blueHex = temp.substring(4);
      this.red = Integer.valueOf(redHex, 16);
      this.green = Integer.valueOf(greenHex, 16);
      this.blue = Integer.valueOf(blueHex, 16);

      this.rgb = "rgb(" + red + ", " + green + ", " + blue + ")";

    } else if (value.startsWith("rgb(") && value.endsWith(")")) {
      this.rgb = value;
      String[] parsed = value.replace("rgb(", "").replace(")", "").split(",");
      this.red = Integer.parseInt(parsed[0].trim());
      this.green = Integer.parseInt(parsed[1].trim());
      this.blue = Integer.parseInt(parsed[2].trim());
      this.hex = rgbToHex(this.red, this.green, this.blue);
    } else {
      throw new IllegalArgumentException(
          "Color cannot be null or empty, use #XXXXXX hex format or rgb(red, green, blue) format string.");
    }
  }

  private String rgbToHex(int r, int g, int b) {
    return "#" + toHexString(r) + toHexString(g) + toHexString(b);
  }

  private static String toHexString(int r) {
    String hexString = Integer.toHexString(r);
    return hexString.length() == 1 ? "0" + hexString : hexString;
  }

  public String getRgb() {
    return rgb;
  }

  public String getHex() {
    return hex;
  }

  public int getRed() {
    return red;
  }

  public int getGreen() {
    return green;
  }

  public int getBlue() {
    return blue;
  }
}
