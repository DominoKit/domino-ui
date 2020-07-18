package org.dominokit.domino.ui.forms;

import elemental2.dom.Node;
import org.dominokit.domino.ui.utils.TextNode;

import java.util.function.Supplier;

public class DominoFields {

    public static final DominoFields INSTANCE = new DominoFields();
    private FieldStyle fieldsStyle = FieldStyle.LINED;
    private FieldStyle DEFAULT = () -> fieldsStyle.getStyle();
    private Supplier<Node> requiredIndicator = ()-> TextNode.of(" * ");

    private DominoFields() {
    }

    public void setDefaultFieldsStyle(FieldStyle fieldsStyle) {
        this.fieldsStyle = fieldsStyle;
    }

    public FieldStyle getDefaultFieldsStyle(){
        return DEFAULT;
    }

    public Supplier<Node> getRequiredIndicator() {
        return requiredIndicator;
    }

    public void setRequiredIndicator(Supplier<Node> requiredIndicator) {
        this.requiredIndicator = requiredIndicator;
    }
}
