package org.dominokit.domino.ui.scroll;

import elemental2.dom.HTMLElement;
import org.dominokit.domino.ui.button.BaseButton;
import org.dominokit.domino.ui.button.ButtonSize;
import org.dominokit.domino.ui.icons.BaseIcon;
import org.dominokit.domino.ui.style.Color;
import org.dominokit.domino.ui.style.Elevation;
import org.dominokit.domino.ui.utils.ElementUtil;
import org.jboss.gwt.elemento.core.EventType;

import static elemental2.dom.DomGlobal.document;

public class ScrollTop extends BaseButton<ScrollTop> {

    private int showOffset = 60;

    public ScrollTop(BaseIcon<?> icon) {
        super(icon);
        init(this);
        elevate(Elevation.LEVEL_1);
        circle();
        setSize(ButtonSize.LARGE);
        setBackground(Color.THEME);
        style.add("top-scroller");
        hide();
        addClickListener(evt -> ElementUtil.scrollTop());

        document.addEventListener(EventType.scroll.getName(), evt -> {
            if (document.scrollingElement.scrollTop > showOffset) {
                ScrollTop.this.show();
            } else {
                ScrollTop.this.hide();
            }
        });
    }

    public ScrollTop setBottom(int bottom) {
        style.setBottom(bottom + "px");
        return this;
    }

    public ScrollTop setRight(int right) {
        style.setRight(right + "px");
        return this;
    }

    public ScrollTop setShowOffset(int offset) {
        this.showOffset = offset;
        return this;
    }

    public static ScrollTop create(BaseIcon<?> icon) {
        return new ScrollTop(icon);
    }

    @Override
    public HTMLElement asElement() {
        return buttonElement.asElement();
    }
}
