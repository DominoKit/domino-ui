package org.dominokit.domino.ui.tag.store;

import java.util.Collections;
import java.util.Map;

public class DynamicLocalTagsStore extends LocalTagsStore<String> {

    @Override
    public String getItemByDisplayValue(String displayValue) {
        return displayValue;
    }

    @Override
    public String getDisplayValue(String value) {
        return value;
    }

    @Override
    public Map<String, String> filter(String searchValue) {
        return Collections.emptyMap();
    }
}
