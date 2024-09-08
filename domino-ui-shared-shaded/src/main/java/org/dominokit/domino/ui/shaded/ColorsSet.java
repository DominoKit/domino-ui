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
 * Use this annotation on a package-info class to generate new colors and colors assets for use by
 * applications using domino-ui the annotation will result in generating a Color with 10 different
 * shades for each {@link ColorInfo} , a theme-xxx.css for each {@link ColorInfo}, A xxx-color.css
 * for each, and an optional html page to demo the generated styles.
 */
@Retention(RetentionPolicy.SOURCE)
@Target(ElementType.PACKAGE)
@Documented
public @interface ColorsSet {
  /**
   * A prefix to be used for classes names and css files names.
   *
   * @return String theme name prefix
   */
  String name() default "App";

  /**
   * the target package to generate the CSS resources, this should point to the <b>public</b> root
   * package. classes will be generated to the same package as the package-info class.
   *
   * @return String package name
   */
  String publicPackage() default "";

  /**
   * Use this to specify the info for each color in this this color set
   *
   * @return the {@link ColorInfo} array
   */
  ColorInfo[] value();

  /**
   * Option to specify if a demo html page should be generated or not.
   *
   * @return boolean, true to generate demo page
   */
  boolean generateDemoPage() default true;
}
