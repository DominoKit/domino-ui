package org.dominokit.domino.ui.stepper;

import static org.dominokit.domino.ui.style.ColorsCss.dui_accent_accent_d_2;
import static org.dominokit.domino.ui.style.ColorsCss.dui_accent_accent_d_4;

public class ActiveStep implements StepState{
    @Override
    public void apply(StepTracker tracker) {
        tracker.addCss(dui_accent_accent_d_2);
    }

    @Override
    public void cleanUp(StepTracker tracker) {
       tracker
                .removeCss(dui_accent_accent_d_2)
                .withTrackerNode((parent1, node) -> node
                        .removeCss(dui_accent_accent_d_2)
                );
    }

    @Override
    public String getKey() {
        return "ACTIVE";
    }
}
