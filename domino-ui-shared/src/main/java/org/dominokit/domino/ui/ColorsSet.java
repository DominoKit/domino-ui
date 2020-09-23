package org.dominokit.domino.ui;

import java.lang.annotation.*;

/**
 * Use this annotation on a package-info class to generate new colors and colors assets for use by applications using domino-ui
 * the annotation will result in generating a Color with 10 different shades for each {@link ColorInfo} , a theme-xxx.css for each {@link ColorInfo},
 * A xxx-color.css for each, and an optional html page to demo the generated styles.
 *
 */
@Retention(RetentionPolicy.SOURCE)
@Target(ElementType.PACKAGE)
@Documented
public @interface ColorsSet {
    /**
     * A prefix to be used for classes names and css files names.
     * @return
     */
    String name() default "App";

    /**
     * the target package to generate the CSS resources, this should point to the <b>public</b> root package.
     * classes will be generated to the same package as the package-info class.
     * @return
     */
    String publicPackage() default "";

    /**
     * Use this to specify the info for each color in this this color set
     * @return
     */
    ColorInfo[] value();

    /**
     * Option to specify if a demo html page should be generated or not.
     * @return
     */
    boolean generateDemoPage() default true;
}
