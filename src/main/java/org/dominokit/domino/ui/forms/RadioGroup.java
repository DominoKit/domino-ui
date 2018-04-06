package org.dominokit.domino.ui.forms;

import elemental2.dom.HTMLDivElement;
import org.jboss.gwt.elemento.core.Elements;
import org.jboss.gwt.elemento.core.IsElement;

import java.util.ArrayList;
import java.util.List;

public class RadioGroup implements IsElement<HTMLDivElement> {

    private HTMLDivElement container = Elements.div().asElement();
    private List<Radio> radios = new ArrayList<>();

    public static RadioGroup create() {
        return new RadioGroup();
    }

    public RadioGroup addRadio(Radio radio) {
        radio.addCheckHandler(checked -> {
            if (checked)
                uncheckOther(radio);
        });
        if (radio.isChecked())
            uncheckOther(radio);
        radios.add(radio);
        asElement().appendChild(radio.asElement());
        return this;
    }

    private void uncheckOther(Radio radio) {
        for (Radio r : radios) {
            if (!r.asElement().isEqualNode(radio.asElement()))
                r.uncheck();
        }
    }

    public RadioGroup horizontal() {
        for (Radio radio : radios)
            radio.asElement().style.display = "inline-block";
        return this;
    }

    public RadioGroup vertical() {
        for (Radio radio : radios)
            radio.asElement().style.display = "";
        return this;
    }

    @Override
    public HTMLDivElement asElement() {
        return container;
    }

    public RadioGroup checkRadioAt(int index) {
        Radio radio = radios.get(index);
        if (radio != null)
            radio.check();
        return this;
    }

    public RadioGroup uncheckRadioAt(int index) {
        Radio radio = radios.get(index);
        if (radio != null)
            radio.uncheck();
        return this;
    }
}
