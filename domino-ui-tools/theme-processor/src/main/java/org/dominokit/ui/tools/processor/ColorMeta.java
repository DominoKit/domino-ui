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
package org.dominokit.ui.tools.processor;

import java.awt.*;
import org.dominokit.domino.ui.ColorInfo;

public class ColorMeta {

  public String name;
  public String hex;
  public String cssPostFix;
  public String fieldName;

  public String hex_lighten_1;
  public String hex_lighten_2;
  public String hex_lighten_3;
  public String hex_lighten_4;
  public String hex_lighten_5;

  public String hex_darken_1;
  public String hex_darken_2;
  public String hex_darken_3;
  public String hex_darken_4;

  public String rgba_1;
  public String rgba_2;

  public ColorMeta(ColorInfo colorInfo) {

    this.name = colorInfo.name().replace(" ", "-");
    this.hex = colorInfo.hex().startsWith("#") ? colorInfo.hex() : ("#" + colorInfo.hex());
    this.cssPostFix = "-" + colorInfo.name().toLowerCase().replace(" ", "-");
    this.fieldName = colorInfo.name().toUpperCase().replace(" ", "_").replace("-", "_");

    float luminance = getLuminance(hex);
    float lightenIncrement = (100.0F - luminance) / 7.0F;
    float darkenDecrement = luminance / 7.0F;

    float targetLuminance = luminance;

    targetLuminance += lightenIncrement;
    if (!colorInfo.shades().hex_lighten_1().isEmpty()) {
      this.hex_lighten_1 = colorInfo.shades().hex_lighten_1();
    } else {
      this.hex_lighten_1 = getShade(hex, targetLuminance);
    }

    targetLuminance += lightenIncrement;
    if (!colorInfo.shades().hex_lighten_2().isEmpty()) {
      this.hex_lighten_2 = colorInfo.shades().hex_lighten_2();
    } else {
      this.hex_lighten_2 = getShade(hex, targetLuminance);
    }

    targetLuminance += lightenIncrement;
    if (!colorInfo.shades().hex_lighten_3().isEmpty()) {
      this.hex_lighten_3 = colorInfo.shades().hex_lighten_3();
    } else {
      this.hex_lighten_3 = getShade(hex, targetLuminance);
    }

    targetLuminance += lightenIncrement;
    if (!colorInfo.shades().hex_lighten_4().isEmpty()) {
      this.hex_lighten_4 = colorInfo.shades().hex_lighten_4();
    } else {
      this.hex_lighten_4 = getShade(hex, targetLuminance);
    }

    targetLuminance += lightenIncrement;
    if (!colorInfo.shades().hex_lighten_5().isEmpty()) {
      this.hex_lighten_5 = colorInfo.shades().hex_lighten_5();
    } else {
      this.hex_lighten_5 = getShade(hex, targetLuminance);
    }

    targetLuminance = luminance;

    targetLuminance -= darkenDecrement;
    if (!colorInfo.shades().hex_darken_1().isEmpty()) {
      this.hex_darken_1 = colorInfo.shades().hex_darken_1();
    } else {
      this.hex_darken_1 = getShade(hex, targetLuminance);
    }

    targetLuminance -= darkenDecrement;
    if (!colorInfo.shades().hex_darken_2().isEmpty()) {
      this.hex_darken_2 = colorInfo.shades().hex_darken_2();
    } else {
      this.hex_darken_2 = getShade(hex, targetLuminance);
    }

    targetLuminance -= darkenDecrement;
    if (!colorInfo.shades().hex_darken_3().isEmpty()) {
      this.hex_darken_3 = colorInfo.shades().hex_darken_3();
    } else {
      this.hex_darken_3 = getShade(hex, targetLuminance);
    }

    targetLuminance -= darkenDecrement;
    if (!colorInfo.shades().hex_darken_3().isEmpty()) {
      this.hex_darken_3 = colorInfo.shades().hex_darken_3();
    } else {
      this.hex_darken_3 = getShade(hex, targetLuminance);
    }

    targetLuminance -= darkenDecrement;
    if (!colorInfo.shades().hex_darken_4().isEmpty()) {
      this.hex_darken_4 = colorInfo.shades().hex_darken_4();
    } else {
      this.hex_darken_4 = getShade(hex, targetLuminance);
    }

    if (!colorInfo.shades().rgba_1().isEmpty()) {
      this.rgba_1 = colorInfo.shades().rgba_1();
    } else {
      this.rgba_1 = getRgb(hex, 0.1F);
    }

    if (!colorInfo.shades().rgba_2().isEmpty()) {
      this.rgba_2 = colorInfo.shades().rgba_2();
    } else {
      this.rgba_2 = getRgb(hex, 0.5F);
    }
  }

  private String getRgb(String baseHex, float alpha) {
    Color baseColor = Color.decode(baseHex);
    return baseColor.getRed()
        + ", "
        + baseColor.getGreen()
        + ", "
        + baseColor.getBlue()
        + ", "
        + alpha;
  }

  private float getLuminance(String hex) {
    Color baseColor = Color.decode(hex);

    HSLColor hslBaseColor = new HSLColor(baseColor);
    return hslBaseColor.getLuminance();
  }

  private String getShade(String baseHex, float shadeLevel) {
    Color baseColor = Color.decode(baseHex);

    HSLColor hslBaseColor = new HSLColor(baseColor);
    float luminance = hslBaseColor.getLuminance();
    Color rgbColor = hslBaseColor.adjustLuminance(shadeLevel);
    return convertToHex(rgbColor);
  }

  private String convertToHex(Color color) {
    String hex = Integer.toHexString(color.getRGB() & 0xffffff);
    if (hex.length() < 6) {
      if (hex.length() == 5) hex = "0" + hex;
      if (hex.length() == 4) hex = "00" + hex;
      if (hex.length() == 3) hex = "000" + hex;
    }
    hex = "#" + hex;
    return hex;
  }

  public String getName() {
    return name;
  }

  public String getHex() {
    return hex;
  }

  public String getHex_lighten_1() {
    return hex_lighten_1;
  }

  public String getHex_lighten_2() {
    return hex_lighten_2;
  }

  public String getHex_lighten_3() {
    return hex_lighten_3;
  }

  public String getHex_lighten_4() {
    return hex_lighten_4;
  }

  public String getHex_lighten_5() {
    return hex_lighten_5;
  }

  public String getHex_darken_1() {
    return hex_darken_1;
  }

  public String getHex_darken_2() {
    return hex_darken_2;
  }

  public String getHex_darken_3() {
    return hex_darken_3;
  }

  public String getHex_darken_4() {
    return hex_darken_4;
  }

  public String getRgba_1() {
    return rgba_1;
  }

  public String getRgba_2() {
    return rgba_2;
  }

  public String getCssPostFix() {
    return cssPostFix;
  }

  public String getFieldName() {
    return fieldName;
  }
}
