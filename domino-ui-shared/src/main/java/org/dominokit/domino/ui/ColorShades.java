package org.dominokit.domino.ui;

import java.lang.annotation.*;

/**
 * Specify shades for a specific color to be used by {@link ColorInfo}
 */
@Retention(RetentionPolicy.SOURCE)
@Target(ElementType.PACKAGE)
@Documented
public @interface ColorShades {

    String hex_lighten_1() default "";
    String hex_lighten_2() default "";
    String hex_lighten_3() default "";
    String hex_lighten_4() default "";
    String hex_lighten_5() default "";

    String hex_darken_1() default "";
    String hex_darken_2() default "";
    String hex_darken_3() default "";
    String hex_darken_4() default "";

    /**
     * default to RGB with alpha 0.1
     * @return
     */
    String rgba_1() default "";

    /**
     * default to RGB with alpha 0.5
     * @return
     */
    String rgba_2() default "";

}
