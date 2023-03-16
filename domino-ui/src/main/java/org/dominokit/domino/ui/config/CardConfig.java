package org.dominokit.domino.ui.config;

import org.dominokit.domino.ui.collapsible.CollapseStrategy;
import org.dominokit.domino.ui.collapsible.HeightCollapseStrategy;
import org.dominokit.domino.ui.icons.BaseIcon;
import org.dominokit.domino.ui.icons.Icons;

import java.util.function.Supplier;

public interface CardConfig extends ComponentConfig {

    default Supplier<CollapseStrategy> getDefaultCardCollapseStrategySupplier() {
        return HeightCollapseStrategy::new;
    }


    default Supplier<BaseIcon<?>> getCardCollapseIcon() {
        return Icons.ALL::chevron_up_mdi;
    }

    default Supplier<BaseIcon<?>> getCardExpandIcon() {
        return Icons.ALL::chevron_down_mdi;
    }
}
