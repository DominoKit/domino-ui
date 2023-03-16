package org.dominokit.domino.ui.config;

import org.dominokit.domino.ui.collapsible.CollapseStrategy;
import org.dominokit.domino.ui.collapsible.HeightCollapseStrategy;

import java.util.function.Supplier;

public interface AccordionConfig extends ComponentConfig {

    default Supplier<CollapseStrategy> getDefaultAccordionCollapseStrategySupplier() {
        return HeightCollapseStrategy::new;
    }
}
