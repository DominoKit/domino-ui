package org.dominokit.domino.ui.forms;

import elemental2.dom.Node;
import org.checkerframework.checker.nullness.Opt;
import org.dominokit.domino.ui.utils.DominoElement;
import org.dominokit.domino.ui.utils.TextNode;

import java.util.List;
import java.util.Optional;
import java.util.function.Supplier;

import static java.util.Objects.nonNull;

public class DominoFields {

    public static final DominoFields INSTANCE = new DominoFields();
    private FieldStyle fieldsStyle = FieldStyle.LINED;
    private FieldStyle DEFAULT = () -> fieldsStyle.getStyle();
    private Supplier<Node> requiredIndicator = () -> TextNode.of(" * ");
    private String defaultRequiredMessage = "* This field is required";
    private Optional<Boolean> fixErrorsPosition = Optional.empty();
    private Optional<Boolean> floatLabels = Optional.empty();
    private RequiredIndicatorRenderer requiredIndicatorRenderer = new RequiredIndicatorRenderer() {
        @Override
        public <T extends BasicFormElement<?, ?>> void appendRequiredIndicator(T valueBox, Node requiredIndicator) {
            removeRequiredIndicator(valueBox, requiredIndicator);
            valueBox.getLabelElement().appendChild(requiredIndicator);
        }

        @Override
        public <T extends BasicFormElement<?, ?>> void removeRequiredIndicator(T valueBox, Node requiredIndicator) {
            if (nonNull(valueBox.getLabelElement()) && valueBox.getLabelElement().hasDirectChild(requiredIndicator)) {
                valueBox.getLabelElement().removeChild(requiredIndicator);
            }
        }
    };

    private GlobalValidationHandler globalValidationHandler = new GlobalValidationHandler() {
    };

    private DominoFields() {
    }

    public DominoFields setDefaultFieldsStyle(FieldStyle fieldsStyle) {
        this.fieldsStyle = fieldsStyle;
        return this;
    }

    public FieldStyle getDefaultFieldsStyle() {
        return DEFAULT;
    }

    public Optional<Boolean> getFixErrorsPosition() {
        return fixErrorsPosition;
    }

    public DominoFields setFixErrorsPosition(boolean fixErrorsPosition) {
        this.fixErrorsPosition = Optional.of(fixErrorsPosition);
        return this;
    }

    public Optional<Boolean> getFloatLabels() {
        return floatLabels;
    }

    public DominoFields setFloatLabels(boolean floatLabels) {
        this.floatLabels = Optional.of(floatLabels);
        return this;
    }

    public Supplier<Node> getRequiredIndicator() {
        return requiredIndicator;
    }

    public DominoFields setRequiredIndicator(Supplier<Node> requiredIndicator) {
        this.requiredIndicator = requiredIndicator;
        return this;
    }

    public RequiredIndicatorRenderer getRequiredIndicatorRenderer() {
        return requiredIndicatorRenderer;
    }

    public String getDefaultRequiredMessage() {
        return defaultRequiredMessage;
    }

    public DominoFields setDefaultRequiredMessage(String defaultRequiredMessage) {
        if(nonNull(defaultRequiredMessage) && !defaultRequiredMessage.isEmpty()){
            this.defaultRequiredMessage = defaultRequiredMessage;
        }
        return this;
    }

    public DominoFields setRequiredIndicatorRenderer(RequiredIndicatorRenderer requiredIndicatorRenderer) {
        if(nonNull(requiredIndicatorRenderer)) {
            this.requiredIndicatorRenderer = requiredIndicatorRenderer;
        }
        return this;
    }

    public GlobalValidationHandler getGlobalValidationHandler() {
        return globalValidationHandler;
    }

    public DominoFields setGlobalValidationHandler(GlobalValidationHandler globalValidationHandler) {
        if(nonNull(globalValidationHandler)) {
            this.globalValidationHandler = globalValidationHandler;
        }
        return this;
    }

    public interface RequiredIndicatorRenderer {
        <T extends BasicFormElement<?,?>> void appendRequiredIndicator(T valueBox, Node requiredIndicator);
        <T extends BasicFormElement<?,?>> void removeRequiredIndicator(T valueBox, Node requiredIndicator);
    }

    public interface GlobalValidationHandler {
        default <T extends ValueBox<?,?,?>> void onInvalidate(T valueBox, List<String> errors){};
        default <T extends ValueBox<?,?,?>> void onClearValidation(T valueBox) {};
    }
}
