package org.dominokit.domino.ui;

import java.lang.annotation.*;

/**
 * Specify shades for a specific color to be used by {@link ColorInfo}
 */
@Retention(RetentionPolicy.SOURCE)
@Target(ElementType.PACKAGE)
@Documented
public @interface ColorShades {

    /**
     *
     * @return String color with 1 level lighter shade
     */
    String hex_lighten_1() default "";

    /**
     *
     * @return String color with 2 level lighter shade
     */
    String hex_lighten_2() default "";

    /**
     *
     * @return String color with 3 level lighter shade
     */
    String hex_lighten_3() default "";

    /**
     *
     * @return String color with 4 level lighter shade
     */
    String hex_lighten_4() default "";

    /**
     *
     * @return String color with lightest shade
     */
    String hex_lighten_5() default "";

    /**
     *
     * @return String color with 1 level darker shade
     */
    String hex_darken_1() default "";
    /**
     *
     * @return String color with 2 level darker shade
     */
    String hex_darken_2() default "";
    /**
     *
     * @return String color with 3 level darker shade
     */
    String hex_darken_3() default "";
    /**
     *
     * @return String color with darkest shade
     */
    String hex_darken_4() default "";

    /**
     * default to RGB with alpha 0.1
     * @return String RBG color
     */
    String rgba_1() default "";

    /**
     * default to RGB with alpha 0.5
     * @return String RBG color
     */
    String rgba_2() default "";

}
