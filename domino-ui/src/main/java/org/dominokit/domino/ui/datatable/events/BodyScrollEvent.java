package org.dominokit.domino.ui.datatable.events;

import org.dominokit.domino.ui.datatable.plugins.BodyScrollPlugin;

/**
 * This event will be fired by the {@link BodyScrollPlugin} for scrollable table body whenever the scroll reaches the top or the bottom
 */
public class BodyScrollEvent implements TableEvent {

    /**
     * A constant string to define a unique type for this event
     */
    public static final String BODY_SCROLL ="data-table-body-scroll";

    private final BodyScrollPlugin.ScrollPosition scrollPosition;

    /**
     *
     * @param scrollPosition a {@link BodyScrollPlugin.ScrollPosition}
     */
    public BodyScrollEvent(BodyScrollPlugin.ScrollPosition scrollPosition) {
        this.scrollPosition = scrollPosition;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String getType() {
        return BODY_SCROLL;
    }

    /**
     *
     * @return {@link BodyScrollPlugin.ScrollPosition}
     */
    public BodyScrollPlugin.ScrollPosition getScrollPosition() {
        return scrollPosition;
    }
}
