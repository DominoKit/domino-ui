package org.dominokit.domino.ui;

import java.lang.annotation.*;

@Retention(RetentionPolicy.SOURCE)
@Target(ElementType.PACKAGE)
@Documented
public @interface ColorsSet {
    String name() default "App";
    String publicPackage() default "";
    ColorInfo[] value();
    boolean generateDemoPage() default true;
}
