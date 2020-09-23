package org.dominokit.domino.ui;

import java.lang.annotation.*;

@Retention(RetentionPolicy.SOURCE)
@Target(ElementType.PACKAGE)
@Documented
@Repeatable(ColorsSet.class)
public @interface ColorInfo {

    String name();
    String hex();

    ColorShades shades() default @ColorShades;

}
