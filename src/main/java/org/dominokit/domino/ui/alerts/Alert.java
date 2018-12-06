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

import static java.util.Objects.nonNull;
import static org.jboss.gwt.elemento.core.Elements.*;

public class Alert extends BaseDominoElement<HTMLDivElement, Alert> implements HasBackground<Alert> {

    public enum AlertType {
        SUCCESS(AlertStyles.SUCCESS),
        INFO(AlertStyles.INFO),
        WARNING(AlertStyles.WARNING),
        ERROR(AlertStyles.ERROR);

        private final String style;

        AlertType(String style) {
            this.style = style;
        }
    }

    private Color background;
    private boolean dismissible = false;
    private DominoElement<HTMLDivElement> element = DominoElement.of(div()
            .css(AlertStyles.ALERT)
            .css(Styles.default_shadow));

    public Alert() {
        init(this);
    }

    private HTMLButtonElement closeButton = button()
            .attr("type", "button")
            .css(AlertStyles.CLOSE)
            .attr("aria-label", "Close")
            .add(span()
                    .attr("aria-hidden", "true")
                    .textContent("×")
                    .asElement())
            .asElement();

    private static Alert create(AlertType type) {
        Alert alert = create();
        alert.element.style().add(type.style);
        return alert;
    }

    public static Alert create(Color background) {
        Alert alert = create();
        alert.style().add(background.getBackground());
        alert.background = background;
        return alert;
    }

    public static Alert create() {
        Alert alert = new Alert();
        alert.closeButton.addEventListener("click", e -> alert.asElement().remove());
        return alert;
    }

    public static Alert success() {
        return create(AlertType.SUCCESS);
    }

    public static Alert info() {
        return create(AlertType.INFO);
    }

    public static Alert warning() {
        return create(AlertType.WARNING);
    }

    public static Alert error() {
        return create(AlertType.ERROR);
    }

    @Override
    public Alert setBackground(Color background) {
        if (nonNull(background))
            element.style().remove(this.background.getBackground());
        this.background = background;
        element.style().add(this.background.getBackground());
        return this;
    }

    public Alert appendChild(Strong strong) {
        element.appendChild(strong.asElement());
        return this;
    }


    public Alert appendChild(String text) {
        element.appendChild(TextNode.of(text));
        return this;
    }

    public Alert appendChild(HTMLAnchorElement anchorElement) {
        if (nonNull(anchorElement)) {
            Style.of(anchorElement).add(Styles.alert_link);
            element.appendChild(anchorElement);
        }
        return this;
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
            element.style().add(AlertStyles.ALERT_DISMISSIBLE);
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
            element.style().remove(AlertStyles.ALERT_DISMISSIBLE);
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
