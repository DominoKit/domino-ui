package org.dominokit.domino.ui.stepper;

import org.dominokit.domino.ui.icons.Icons;
import org.dominokit.domino.ui.style.ColorsCss;
import org.dominokit.domino.ui.style.SpacingCss;

import static org.dominokit.domino.ui.style.GenericCss.dui_error;
import static org.dominokit.domino.ui.style.GenericCss.dui_warning;

public class WarningStep implements StepState{
    @Override
    public void apply(StepTracker tracker) {
        tracker
                .addCss(ColorsCss.dui_accent_warning)
                .withTrackerNode((parent1, node) -> node
                        .appendChild(Icons.exclamation().addCss(SpacingCss.dui_font_size_4, dui_tracker_node_icon))
                        .addCss(dui_warning)
                );
    }

    @Override
    public void cleanUp(StepTracker tracker) {
        tracker
                .removeCss(ColorsCss.dui_accent_warning)
                .withTrackerNode((parent1, node) -> node
                        .clearElement()
                        .removeCss(dui_warning)
                );
    }

    @Override
    public String getKey() {
        return "WARNING";
    }
}
