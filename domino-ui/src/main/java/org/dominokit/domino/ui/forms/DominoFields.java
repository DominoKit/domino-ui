package org.dominokit.domino.ui.forms;

import elemental2.dom.Node;
import org.dominokit.domino.ui.utils.TextNode;

import java.util.function.Supplier;

/**
 * This class provides global configuration for form fields
 * <p>These configurations should be set before creating the form fields</p>
 *
 */
public class DominoFields {

    /**
     * The DominoFields single INSTANCE for global access.
     */
    public static final DominoFields INSTANCE = new DominoFields();
    private FieldStyle fieldsStyle = FieldStyle.LINED;
    private FieldStyle DEFAULT = () -> fieldsStyle.getStyle();
    private Supplier<Node> requiredIndicator = ()-> TextNode.of(" * ");

    private DominoFields() {
    }

    /**
     * Globally change the form fields style
     * @param fieldsStyle {@link FieldStyle}
     */
    public void setDefaultFieldsStyle(FieldStyle fieldsStyle) {
        this.fieldsStyle = fieldsStyle;
    }

    /**
     *
     * @return Default {@link FieldStyle}
     */
    public FieldStyle getDefaultFieldsStyle(){
        return DEFAULT;
    }

    /**
     *
     * @return a supplier of {@link Node}, this should return a new Node instance everytime it is call and that will be used as a required field indicator
     * the default will supply a text node of <b>*</b>
     */
    public Supplier<Node> getRequiredIndicator() {
        return requiredIndicator;
    }

    /**
     * Sets the Supplier for the {@link Node} that should be used as a required indicator
     * @param requiredIndicator {@link Node} Supplier
     */
    public void setRequiredIndicator(Supplier<Node> requiredIndicator) {
        this.requiredIndicator = requiredIndicator;
    }
}
