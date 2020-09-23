package org.dominokit.domino.ui;

import java.lang.annotation.*;

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

    String rgba_1() default "";
    String rgba_2() default "";

}
