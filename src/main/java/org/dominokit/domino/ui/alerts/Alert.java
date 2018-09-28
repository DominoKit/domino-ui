package org.dominokit.domino.ui.alerts;


import elemental2.dom.HTMLAnchorElement;
import elemental2.dom.HTMLButtonElement;
import elemental2.dom.HTMLDivElement;
import org.dominokit.domino.ui.Typography.Strong;
import org.dominokit.domino.ui.style.Color;
import org.dominokit.domino.ui.style.Style;
import org.dominokit.domino.ui.style.Styles;
import org.dominokit.domino.ui.utils.BaseDominoElement;
import org.dominokit.domino.ui.utils.DominoElement;
import org.dominokit.domino.ui.utils.HasBackground;
import org.dominokit.domino.ui.utils.TextNode;
import org.jboss.gwt.elemento.core.IsElement;

import static java.util.Objects.nonNull;
import static org.jboss.gwt.elemento.core.Elements.*;

public class Alert extends BaseDominoElement<HTMLDivElement, Alert> implements HasBackground<Alert> {

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
    private DominoElement<HTMLDivElement> element = DominoElement.of(div().css("alert"));

    public Alert() {
        init(this);
    }

    private HTMLButtonElement closeButton = button().attr("type", "button").css("close")
            .attr("aria-label", "Close")
            .add(span().attr("aria-hidden", "true")
                    .textContent("×").asElement()).asElement();

    private static Alert create(String style) {
        Alert alert = create();
        alert.element.style().add(style);
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
            element.style().remove(style);
        this.style = background.getBackground();
        element.style().add(this.style);
        return this;
    }


    /**
     * @deprecated use {@link #appendChild(Strong)}
     */
    @Deprecated
    public Alert appendStrong(String text) {
        element.appendChild(strong().textContent(text).asElement());
        return this;
    }

    public Alert appendChild(Strong strong) {
        element.appendChild(strong.asElement());
        return this;
    }

    /**
     * @deprecated use {@link #appendChild(String)}
     */
    @Deprecated
    public Alert appendText(String text) {
        element.appendChild(TextNode.of(text));
        return this;
    }

    public Alert appendChild(String text) {
        element.appendChild(TextNode.of(text));
        return this;
    }

    /**
     * @deprecated use {@link #appendChild(HTMLAnchorElement)}
     */
    @Deprecated
    public Alert appendLink(HTMLAnchorElement anchorElement) {
        return appendChild(anchorElement);
    }

    public Alert appendChild(HTMLAnchorElement anchorElement) {
        if (nonNull(anchorElement)) {
            Style.of(anchorElement).add(Styles.alert_link);
            element.appendChild(anchorElement);
        }
        return this;
    }

    /**
     * @deprecated use {@link #appendChild(AlertLink)}
     */
    @Deprecated
    public Alert appendLink(IsElement<HTMLAnchorElement> anchorElement) {
        return appendChild(anchorElement.asElement());
    }

    public Alert appendChild(AlertLink alertLink) {
        return appendChild(alertLink.asElement());
    }

    public Alert setDissmissible(boolean dismissible) {
        if (dismissible) {
            return dismissible();
        } else {
            return unDismissible();
        }
    }

    public Alert dismissible() {
        if (!dismissible) {
            element.style().add("alert-dismissible");
            if (element.getChildElementCount() > 0)
                element.insertFirst(closeButton);
            else
                element.appendChild(closeButton);
        }
        dismissible = true;
        return this;
    }

    public Alert unDismissible() {
        if (dismissible) {
            element.style().remove("alert-dismissible");
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
        return element.asElement();
    }
}
