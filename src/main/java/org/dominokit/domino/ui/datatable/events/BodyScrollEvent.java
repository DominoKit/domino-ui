package org.dominokit.domino.ui.datatable.events;

import org.dominokit.domino.ui.datatable.plugins.BodyScrollPlugin;

public class BodyScrollEvent implements TableEvent {

    public static final String BODY_SCROLL ="data-table-body-scroll";

    private final BodyScrollPlugin.ScrollPosition scrollPosition;

    public BodyScrollEvent(BodyScrollPlugin.ScrollPosition scrollPosition) {
        this.scrollPosition = scrollPosition;
    }

    @Override
    public String getType() {
        return BODY_SCROLL;
    }

    public BodyScrollPlugin.ScrollPosition getScrollPosition() {
        return scrollPosition;
    }
}
