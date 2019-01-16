package org.dominokit.domino.ui.header;

import elemental2.dom.*;
import org.dominokit.domino.ui.utils.BaseDominoElement;
import org.dominokit.domino.ui.utils.DominoElement;
import org.jboss.gwt.elemento.core.IsElement;

import static java.util.Objects.isNull;
import static java.util.Objects.nonNull;
import static org.jboss.gwt.elemento.core.Elements.*;

public class FieldSet extends BaseDominoElement<HTMLFieldSetElement, FieldSet> {

    private HTMLFieldSetElement element = fieldset()/*.css("block-legend")*/.asElement();
    private HTMLLegendElement legendElement = legend().asElement();
    private HTMLElement descriptionElement;
    private Text legendText = DomGlobal.document.createTextNode("");
    private Text descriptionText = DomGlobal.document.createTextNode("");

    private FieldSet(String legend) {
        this(legend, null);
    }

    private FieldSet(String legend, String description) {
        legendText.textContent = legend;
        legendElement.appendChild(legendText);
        element.appendChild(legendElement);

        if (nonNull(description)) {
            createDescriptionElement(description);
        }
        init(this);
    }

    private void createDescriptionElement(String description) {
        descriptionText.textContent = description;
        descriptionElement = small().add(descriptionText).asElement();
        legendElement.appendChild(descriptionElement);
    }

    public static FieldSet create(String legend, String description) {
        return new FieldSet(legend, description);
    }

    public static FieldSet create(String legend) {
        return new FieldSet(legend);
    }

    public FieldSet appendChild(Node content) {
        element.appendChild(content);
        return this;
    }

    public FieldSet appendChild(IsElement content) {
        return appendChild(content.asElement());
    }

    public FieldSet invertLegend() {
        if (nonNull(descriptionElement)) {
            descriptionElement.remove();
            legendElement.insertBefore(descriptionElement, legendText);
        }

        return this;
    }

    public FieldSet setLegend(String legend) {
        legendText.textContent = legend;
        return this;
    }

    public FieldSet setDescription(String description) {
        if (isNull(descriptionElement) && nonNull(description))
            createDescriptionElement(description);
        if (nonNull(descriptionElement) && isNull(description)) {
            descriptionElement.remove();
            descriptionElement = null;
        }
        if (nonNull(descriptionElement) && isNull(description)) {
            descriptionElement.remove();
        }
        if (isNull(descriptionElement) && nonNull(description))
            descriptionText.textContent = description;
        return this;
    }

    public DominoElement<HTMLLegendElement> getLegendElement() {
        return DominoElement.of(legendElement);
    }

    public DominoElement<HTMLElement> getDescriptionElement() {
        return DominoElement.of(descriptionElement);
    }

    @Override
    public HTMLFieldSetElement asElement() {
        return element;
    }
}
