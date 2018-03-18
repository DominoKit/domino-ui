package com.progressoft.brix.domino.ui.alerts;

import com.progressoft.brix.domino.ui.style.Background;
import com.progressoft.brix.domino.ui.utils.HasBackground;
import elemental2.dom.HTMLAnchorElement;
import elemental2.dom.HTMLButtonElement;
import elemental2.dom.HTMLDivElement;
import elemental2.dom.Text;
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
    private HTMLDivElement alertElement = div().css("alert").asElement();

    private HTMLButtonElement closeButton = button().attr("type", "button").css("close")
            .attr("aria-label", "Close")
            .add(span().attr("aria-hidden", "true")
                    .textContent("×").asElement()).asElement();

    private static Alert create(String style) {
        Alert alert = create();
        alert.alertElement.classList.add(style);
        alert.style = style;
        return alert;
    }

    public static Alert create(Background background) {
        return create(background.getStyle());
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
    public Alert setBackground(Background background) {
        if (nonNull(style))
            alertElement.classList.remove(style);
        this.style = background.getStyle();
        alertElement.classList.add(this.style);
        return this;
    }

    public Alert appendStrong(String text) {
        alertElement.appendChild(strong().textContent(text).asElement());
        return this;
    }

    public Alert appendText(String text) {
        alertElement.appendChild(new Text(text));
        return this;
    }

    public Alert appendLink(HTMLAnchorElement anchorElement) {
        if (nonNull(anchorElement)) {
            anchorElement.classList.add("alert-link");
            alertElement.appendChild(anchorElement);
        }
        return this;
    }

    public Alert dismissible() {
        if (!dismissible) {
            alertElement.classList.add("alert-dismissible");
            if (alertElement.childElementCount > 0)
                alertElement.insertBefore(closeButton, alertElement.firstChild);
            else
                alertElement.appendChild(closeButton);
        }
        dismissible = true;
        return this;
    }

    public Alert unDismissible() {
        if (dismissible) {
            alertElement.classList.remove("alert-dismissible");
            alertElement.removeChild(closeButton);
        }
        dismissible = false;
        return this;
    }

    public boolean isDismissible() {
        return dismissible;
    }

    @Override
    public HTMLDivElement asElement() {
        return alertElement;
    }
}
