package org.dominokit.domino.ui.config;

import org.dominokit.domino.ui.collapsible.CollapseStrategy;
import org.dominokit.domino.ui.collapsible.DisplayCollapseStrategy;

import java.util.function.Supplier;

public interface CollapseConfig extends ComponentConfig{
    default Supplier<CollapseStrategy> getDefaultCollapseStrategySupplier() {
        return DisplayCollapseStrategy::new;
    }
}
