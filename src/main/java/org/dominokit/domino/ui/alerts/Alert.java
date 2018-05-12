package org.dominokit.domino.ui.alerts;


import elemental2.dom.HTMLAnchorElement;
import elemental2.dom.HTMLButtonElement;
import elemental2.dom.HTMLDivElement;
import elemental2.dom.Text;
import org.dominokit.domino.ui.style.Color;
import org.dominokit.domino.ui.utils.HasBackground;
import org.jboss.gwt.elemento.core.IsElement;

import static java.util.Objects.nonNull;
import static org.jboss.gwt.elemento.core.Elements.*;

public class Alert implements IsElement<HTMLDivElement>, HasBackground<Alert> {

    public enum AlertType {
        SUCCESS("alert-success"),
        INFO("alert-info"),
        WARNING("alert-warning"),
        ERROR("alert-danger");

        private final String typeStyle;

        AlertType(String typeStyle) {
            this.typeStyle = typeStyle;
        }
    }

    private String style;
    private boolean dismissible = false;
    private HTMLDivElement element = div().css("alert").asElement();

    private HTMLButtonElement closeButton = button().attr("type", "button").css("close")
            .attr("aria-label", "Close")
            .add(span().attr("aria-hidden", "true")
                    .textContent("×").asElement()).asElement();

    private static Alert create(String style) {
        Alert alert = create();
        alert.element.classList.add(style);
        alert.style = style;
        return alert;
    }

    public static Alert create(Color background) {
        return create(background.getBackground());
    }

    public static Alert create() {
        Alert alert = new Alert();
        alert.closeButton.addEventListener("click", e -> alert.asElement().remove());
        return alert;
    }

    public static Alert success() {
        return create(AlertType.SUCCESS.typeStyle);
    }

    public static Alert info() {
        return create(AlertType.INFO.typeStyle);
    }

    public static Alert warning() {
        return create(AlertType.WARNING.typeStyle);
    }

    public static Alert error() {
        return create(AlertType.ERROR.typeStyle);
    }

    @Override
    public Alert setBackground(Color background) {
        if (nonNull(style))
            element.classList.remove(style);
        this.style = background.getBackground();
        element.classList.add(this.style);
        return this;
    }

    public Alert appendStrong(String text) {
        element.appendChild(strong().textContent(text).asElement());
        return this;
    }

    public Alert appendText(String text) {
        element.appendChild(new Text(text));
        return this;
    }

    public Alert appendLink(HTMLAnchorElement anchorElement) {
        if (nonNull(anchorElement)) {
            anchorElement.classList.add("alert-link");
            element.appendChild(anchorElement);
        }
        return this;
    }

    public Alert dismissible() {
        if (!dismissible) {
            element.classList.add("alert-dismissible");
            if (element.childElementCount > 0)
                element.insertBefore(closeButton, element.firstChild);
            else
                element.appendChild(closeButton);
        }
        dismissible = true;
        return this;
    }

    public Alert unDismissible() {
        if (dismissible) {
            element.classList.remove("alert-dismissible");
            element.removeChild(closeButton);
        }
        dismissible = false;
        return this;
    }

    public boolean isDismissible() {
        return dismissible;
    }

    @Override
    public HTMLDivElement asElement() {
        return element;
    }
}
