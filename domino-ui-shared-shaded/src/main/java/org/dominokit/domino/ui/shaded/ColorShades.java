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

/** Specify shades for a specific color to be used by {@link ColorInfo} */
@Retention(RetentionPolicy.SOURCE)
@Target(ElementType.PACKAGE)
@Documented
public @interface ColorShades {

  /** @return String color with 1 level lighter shade */
  String hex_lighten_1() default "";

  /** @return String color with 2 level lighter shade */
  String hex_lighten_2() default "";

  /** @return String color with 3 level lighter shade */
  String hex_lighten_3() default "";

  /** @return String color with 4 level lighter shade */
  String hex_lighten_4() default "";

  /** @return String color with lightest shade */
  String hex_lighten_5() default "";

  /** @return String color with 1 level darker shade */
  String hex_darken_1() default "";
  /** @return String color with 2 level darker shade */
  String hex_darken_2() default "";
  /** @return String color with 3 level darker shade */
  String hex_darken_3() default "";
  /** @return String color with darkest shade */
  String hex_darken_4() default "";

  /**
   * default to RGB with alpha 0.1
   *
   * @return String RBG color
   */
  String rgba_1() default "";

  /**
   * default to RGB with alpha 0.5
   *
   * @return String RBG color
   */
  String rgba_2() default "";
}
