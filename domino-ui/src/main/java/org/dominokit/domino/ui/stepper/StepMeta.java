package org.dominokit.domino.ui.stepper;

import org.dominokit.domino.ui.utils.ComponentMeta;
import org.dominokit.domino.ui.utils.HasMeta;

import java.util.Optional;

public class StepMeta implements ComponentMeta {
    public static final String DUI_STEP_META = "dui-step-meta";

    private final Step step;

    public StepMeta(Step step) {
        this.step = step;
    }

    public static StepMeta of(Step step){
        return new StepMeta(step);
    }
    public static Optional<StepMeta> get(HasMeta<?> component) {
        return component.getMeta(DUI_STEP_META);
    }

    public Step getStep() {
        return step;
    }

    @Override
    public String getKey() {
        return DUI_STEP_META;
    }
}
