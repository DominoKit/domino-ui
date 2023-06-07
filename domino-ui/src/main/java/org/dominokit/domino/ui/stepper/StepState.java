package org.dominokit.domino.ui.stepper;

public interface StepState extends StepperStyles {
    StepState ACTIVE = new ActiveStep();
    StepState INACTIVE = new InactiveStep();
    StepState COMPLETED = new CompletedStep();
    StepState DISABLED = new DisabledStep();
    StepState ERROR = new ErrorStep();
    StepState WARNING = new WarningStep();
    StepState SKIPPED = new SkippedStep();

    void apply(StepTracker tracker);

    void cleanUp(StepTracker tracker);

    String getKey();

}
