package org.dominokit.domino.ui.config;

import org.dominokit.domino.ui.stepper.StepState;

public interface StepperConfig extends ComponentConfig {

    default StepState getDefaultStepState(){
        return StepState.INACTIVE;
    }
}
