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
package org.dominokit.domino.ui.shaded;

import java.lang.annotation.*;

/**
 * An annotation to setup the information for a specific color to generate its assets and classes
 * using the {@link ColorsSet}
 */
@Retention(RetentionPolicy.SOURCE)
@Target(ElementType.PACKAGE)
@Documented
@Repeatable(ColorsSet.class)
public @interface ColorInfo {

  /**
   * The color name, avoid using names already used by domino-ui core or other ColorSets to avoid
   * css classes clashes.
   *
   * @return String color name
   */
  String name();

  /**
   * The hex value for the base color, this will be used to generate different shades in case a
   * shade is not specified in the {@link ColorShades}
   *
   * @return String color hex value
   */
  String hex();

  /**
   * Use to manually specify a specific shade for the base color and avoid the generated shade.
   *
   * @return the {@link ColorShades}
   */
  ColorShades shades() default @ColorShades;
}
