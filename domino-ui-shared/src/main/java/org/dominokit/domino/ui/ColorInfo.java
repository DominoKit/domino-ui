package org.dominokit.domino.ui;

import java.lang.annotation.*;

/**
 * An annotation to setup the information for a specific color to generate its assets and classes using the {@link ColorsSet}
 */
@Retention(RetentionPolicy.SOURCE)
@Target(ElementType.PACKAGE)
@Documented
@Repeatable(ColorsSet.class)
public @interface ColorInfo {

    /**
     * The color name, avoid using names already used by domino-ui core or other ColorSets to avoid css classes clashes.
     * @return String color name
     */
    String name();

    /**
     * The hex value for the base color, this will be used to generate different shades in case a shade is not specified in the {@link ColorShades}
     * @return String color hex value
     */
    String hex();

    /**
     * Use to manually specify a specific shade for the base color and avoid the generated shade.
     * @return the {@link ColorShades}
     */
    ColorShades shades() default @ColorShades;

}
