package org.dominokit.domino.ui.config;


import elemental2.dom.HTMLElement;
import elemental2.dom.Node;
import org.dominokit.domino.ui.forms.BigDecimalBox;
import org.dominokit.domino.ui.forms.DoubleBox;
import org.dominokit.domino.ui.forms.FloatBox;
import org.dominokit.domino.ui.forms.IntegerBox;
import org.dominokit.domino.ui.forms.LongBox;
import org.dominokit.domino.ui.forms.ShortBox;
import org.dominokit.domino.ui.utils.DominoUIConfig;

import java.math.BigDecimal;
import java.util.Optional;
import java.util.function.Function;
import java.util.function.Supplier;

import static org.dominokit.domino.ui.utils.ElementsFactory.elements;

public interface FormsFieldsConfig extends ComponentConfig {

    /**
     * @return a supplier of {@link Node}, this should return a new Node instance everytime it is call
     *     and that will be used as a required field indicator the default will supply a text node of
     *     <b>*</b>
     */
    default Supplier<HTMLElement> getRequiredIndicator(){
        return ()->elements.span().textContent("*").element();
    }

    /** @return a boolean representing if the errors position should be fixed */
    default boolean isFixErrorsPosition(){
        return false;
    }

    /** @return true if press enter key will move the focus to the next input field if exists */
    default boolean isFocusNextFieldOnEnter(){
        return false;
    }

    default boolean isSpellCheckEnabled(){
        return false;
    }

    default NumberParsers getNumberParsers(){
        return new NumberParsers() {};
    }

    interface NumberParsers {
        default Function<String, BigDecimal> bigDecimalParser(BigDecimalBox field) {
            return value -> BigDecimal.valueOf(field.parseDouble(value));
        }

        default Function<String, Double> doubleParser(DoubleBox field) {
            return field::parseDouble;
        }

        default Function<String, Integer> integerParser(IntegerBox field) {
            return value -> Double.valueOf(field.parseDouble(value)).intValue();
        }

        default Function<String, Float> floatParser(FloatBox field) {
            return value -> Double.valueOf(field.parseDouble(value)).floatValue();
        }

        default Function<String, Long> longParser(LongBox field) {
            return value -> Double.valueOf(field.parseDouble(value)).longValue();
        }

        default Function<String, Short> shortParser(ShortBox field) {
            return value -> Double.valueOf(field.parseDouble(value)).shortValue();
        }
    }
}
