package org.dominokit.domino.ui.tag.store;

import java.util.Collections;
import java.util.Map;

/**
 * A dynamic store implementation that accepts any string value and add it to the store dynamically
 */
public class DynamicLocalTagsStore extends LocalTagsStore<String> {

    /**
     * {@inheritDoc}
     */
    @Override
    public String getItemByDisplayValue(String displayValue) {
        return displayValue;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String getDisplayValue(String value) {
        return value;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Map<String, String> filter(String searchValue) {
        return Collections.emptyMap();
    }
}
