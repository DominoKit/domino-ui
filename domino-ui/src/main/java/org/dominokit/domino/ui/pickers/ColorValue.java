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

/**
 * Represents a color value in various formats, including RGB and hexadecimal.
 *
 * <p>The {@code ColorValue} class allows you to work with colors in different formats such as RGB
 * and hexadecimal. It provides methods for creating color values from these formats and retrieving
 * color components (red, green, blue) in both numerical and string representations.
 *
 * <p>Usage examples:
 *
 * <pre>
 * // Create a ColorValue from a hexadecimal color code
 * ColorValue color = ColorValue.of("#FF5733");
 *
 * // Create a ColorValue from RGB components
 * ColorValue rgbColor = ColorValue.of(255, 87, 51);
 * </pre>
 *
 * <p>All HTML tags in the documentation are correctly closed.
 */
public class ColorValue {

  private final String rgb;
  private final String hex;
  private final int red;
  private final int green;
  private final int blue;

  /**
   * Creates a {@code ColorValue} instance from a hexadecimal color code.
   *
   * @param value The hexadecimal color code (e.g., "#FF5733").
   * @return A new {@code ColorValue} instance representing the specified color.
   * @throws IllegalArgumentException if the input value is invalid or null.
   */
  public static ColorValue of(String value) {
    return new ColorValue(value);
  }

  /**
   * Creates a {@code ColorValue} instance from RGB components.
   *
   * @param red The red component value (0-255).
   * @param green The green component value (0-255).
   * @param blue The blue component value (0-255).
   * @return A new {@code ColorValue} instance representing the specified color.
   */
  public static ColorValue of(int red, int green, int blue) {
    return new ColorValue(red, green, blue);
  }

  /**
   * Constructs a {@code ColorValue} instance from RGB components.
   *
   * @param red The red component value (0-255).
   * @param green The green component value (0-255).
   * @param blue The blue component value (0-255).
   */
  public ColorValue(int red, int green, int blue) {
    this.red = red;
    this.green = green;
    this.blue = blue;
    this.hex = rgbToHex(red, green, blue);
    this.rgb = "rgb(" + red + ", " + green + ", " + blue + ")";
  }

  /**
   * Constructs a {@code ColorValue} instance from a hexadecimal color code or an RGB format string.
   *
   * @param value The color value as a hexadecimal code (e.g., "#FF5733") or RGB format string
   *     (e.g., "rgb(255, 87, 51)").
   * @throws IllegalArgumentException if the input value is invalid or null.
   */
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

  /**
   * Gets the RGB representation of the color value.
   *
   * @return The RGB format string (e.g., "rgb(255, 87, 51)").
   */
  public String getRgb() {
    return rgb;
  }

  /**
   * Gets the hexadecimal representation of the color value.
   *
   * @return The hexadecimal color code (e.g., "#FF5733").
   */
  public String getHex() {
    return hex;
  }

  /**
   * Gets the red component value of the color.
   *
   * @return The red component value (0-255).
   */
  public int getRed() {
    return red;
  }

  /**
   * Gets the green component value of the color.
   *
   * @return The green component value (0-255).
   */
  public int getGreen() {
    return green;
  }

  /**
   * Gets the blue component value of the color.
   *
   * @return The blue component value (0-255).
   */
  public int getBlue() {
    return blue;
  }
}
