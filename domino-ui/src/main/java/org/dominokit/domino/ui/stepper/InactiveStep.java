package org.dominokit.domino.ui.stepper;

import org.dominokit.domino.ui.style.ColorsCss;

import static org.dominokit.domino.ui.style.GenericCss.dui_accent;
import static org.dominokit.domino.ui.style.GenericCss.dui_primary;

public class InactiveStep implements StepState{
    @Override
    public void apply(StepTracker tracker) {
        tracker.addCss(ColorsCss.dui_accent_accent_l_2);
    }

    @Override
    public void cleanUp(StepTracker tracker) {
        tracker.removeCss(ColorsCss.dui_accent_accent_l_2);
    }

    @Override
    public String getKey() {
        return "INACTIVE";
    }
}
