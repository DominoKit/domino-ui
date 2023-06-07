package org.dominokit.domino.ui.config;

import org.dominokit.domino.ui.collapsible.CollapseStrategy;
import org.dominokit.domino.ui.collapsible.HeightCollapseStrategy;
import org.dominokit.domino.ui.icons.Icons;
import org.dominokit.domino.ui.icons.ToggleIcon;
import org.dominokit.domino.ui.icons.ToggleMdiIcon;

import java.util.function.Supplier;

public interface CardConfig extends ComponentConfig {

    default Supplier<CollapseStrategy> getDefaultCardCollapseStrategySupplier() {
        return HeightCollapseStrategy::new;
    }

    default Supplier<ToggleIcon<?, ?>> getCardCollapseExpandIcon() {
        return ()->ToggleMdiIcon.create(Icons.chevron_up(), Icons.chevron_down());
    }
}
