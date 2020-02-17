package org.dominokit.domino.ui.steppers;

import elemental2.dom.HTMLDivElement;
import elemental2.dom.HTMLLIElement;
import elemental2.dom.Node;
import org.dominokit.domino.ui.animations.Animation;
import org.dominokit.domino.ui.animations.Transition;
import org.dominokit.domino.ui.collapsible.Collapsible;
import org.dominokit.domino.ui.style.Style;
import org.dominokit.domino.ui.utils.BaseDominoElement;
import org.dominokit.domino.ui.utils.DominoElement;
import org.dominokit.domino.ui.utils.ElementUtil;
import org.jboss.elemento.IsElement;

import static java.util.Objects.nonNull;
import static org.dominokit.domino.ui.steppers.StepperStyles.*;
import static org.jboss.elemento.Elements.div;
import static org.jboss.elemento.Elements.li;

public class Step extends BaseDominoElement<HTMLLIElement, Step> {

    private final HTMLLIElement element = li().css(step).element();
    private final HTMLDivElement contentElement = div().css(step_content).element();
    private HTMLDivElement stepHeader;
    private HTMLDivElement bodyElement = div().css(step_body).element();
    private HTMLDivElement footerElement = div().css(step_footer).element();
    private boolean expanded = false;
    private StepCompletedValidator stepCompletedValidator = () -> true;
    private Collapsible collapsible = Collapsible.create(contentElement);
    private boolean allowStepClickActivation = true;
    private Stepper stepper;
    private ActivationHandler activationHandler = step -> {
    };
    private DeActivationHandler deActivationHandler = step -> {
    };

    public Step(String title) {
        init(makeHeaderElement(title, ""));
    }

    public Step(String title, String description) {
        init(makeHeaderElement(title, description));
    }

    private HTMLDivElement makeHeaderElement(String title, String description) {
        return div().css(step_title).attr("data-step-label", description).textContent(title).element();
    }

    private void init(HTMLDivElement stepHeader) {
        this.stepHeader = stepHeader;
        element.appendChild(stepHeader);
        element.appendChild(contentElement);
        contentElement.appendChild(bodyElement);
        contentElement.appendChild(footerElement);
        collapsible.hide();
        ElementUtil.onAttach(element(), mutationRecord -> {
            if (expanded) {
                collapsible.show();
            }
        });

        init(this);
    }

    public static Step create(String title) {
        return new Step(title);
    }

    public static Step create(String title, String description) {
        return new Step(title, description);
    }

    public Step appendChild(Node content) {
        bodyElement.appendChild(content);
        return this;
    }

    public Step appendChild(IsElement content) {
        return appendChild(content.element());
    }

    public Step appendFooterChild(Node content) {
        footerElement.appendChild(content);
        return this;
    }

    public Step appendFooterChild(IsElement content) {
        return appendFooterChild(content.element());
    }

    Step activate(Transition transition) {
        clearInvalid();
        Style.of(element).add(active);
        collapsible.show();
        this.expanded = true;
        Animation.create(contentElement)
                .duration(350)
                .transition(transition)
                .callback(element -> {
                    if (nonNull(activationHandler)) {
                        activationHandler.onActivated(this);
                    }
                })
                .animate();
        return this;
    }

    Step deActivate() {
        clearInvalid();
        Style.of(element).remove(active);
        collapsible.hide();
        this.expanded = false;
        if (nonNull(deActivationHandler)) {
            deActivationHandler.onDeActivated(this);
        }
        return this;
    }

    void setStepper(Stepper stepper) {
        this.stepper = stepper;
    }

    public int getIndex() {
        if (nonNull(this.stepper)) {
            return stepper.getSteps().indexOf(this);
        }
        return -1;
    }

    public void setDone(boolean done) {
        style().remove(StepperStyles.done);
        if (done) {
            style().add(StepperStyles.done);
        }
    }

    public void invalidate() {
        if (!style().contains(wrong)) {
            style().add(wrong);
        }
    }

    public void clearInvalid() {
        style().remove(wrong);
    }

    public DominoElement<HTMLDivElement> getStepBody() {
        return DominoElement.of(bodyElement);
    }

    public boolean isValid() {
        return stepCompletedValidator.isValid();
    }

    public Step setValidator(StepCompletedValidator stepCompletedValidator) {
        if (nonNull(stepCompletedValidator)) {
            this.stepCompletedValidator = stepCompletedValidator;
        }
        return this;
    }

    public DominoElement<HTMLDivElement> getStepHeader() {
        return DominoElement.of(stepHeader);
    }

    public DominoElement<HTMLDivElement> getContentElement() {
        return DominoElement.of(contentElement);
    }

    public boolean isActive() {
        return Style.of(element).contains(active);
    }

    @Override
    public HTMLLIElement element() {
        return element;
    }

    public void setAllowStepClickActivation(boolean allow) {
        this.allowStepClickActivation = allow;
    }

    public boolean isAllowStepClickActivation() {
        return allowStepClickActivation;
    }

    public Step disableClickActivation() {
        setAllowStepClickActivation(false);
        return this;
    }

    public Step enableClickActivation() {
        setAllowStepClickActivation(true);
        return this;
    }

    public Step onActivated(ActivationHandler activationHandler) {
        this.activationHandler = activationHandler;
        return this;
    }

    public Step onDeActivated(DeActivationHandler deActivationHandler) {
        this.deActivationHandler = deActivationHandler;
        return this;
    }

    @FunctionalInterface
    public interface StepCompletedValidator {
        boolean isValid();
    }

    @FunctionalInterface
    public interface ActivationHandler {
        void onActivated(Step step);
    }

    @FunctionalInterface
    public interface DeActivationHandler {
        void onDeActivated(Step step);
    }

}
