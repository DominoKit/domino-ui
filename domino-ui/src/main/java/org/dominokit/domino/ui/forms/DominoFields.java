package org.dominokit.domino.ui.forms;

public class DominoFields {

    public static final DominoFields INSTANCE = new DominoFields();
    private FieldStyle fieldsStyle = FieldStyle.LINED;
    private FieldStyle DEFAULT = () -> fieldsStyle.getStyle();

    private DominoFields() {
    }

    public void setDefaultFieldsStyle(FieldStyle fieldsStyle) {
        this.fieldsStyle = fieldsStyle;
    }

    public FieldStyle getDefaultFieldsStyle(){
        return DEFAULT;
    }
}
