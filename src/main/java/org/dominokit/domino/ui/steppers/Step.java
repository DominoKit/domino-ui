package org.dominokit.domino.ui.steppers;

import elemental2.dom.HTMLDivElement;
import elemental2.dom.HTMLLIElement;
import elemental2.dom.Node;
import org.dominokit.domino.ui.animations.Animation;
import org.dominokit.domino.ui.animations.Transition;
import org.dominokit.domino.ui.collapsible.Collapsible;
import org.dominokit.domino.ui.style.Style;
import org.dominokit.domino.ui.utils.ElementUtil;
import org.jboss.gwt.elemento.core.IsElement;

import static java.util.Objects.nonNull;
import static org.jboss.gwt.elemento.core.Elements.div;
import static org.jboss.gwt.elemento.core.Elements.li;

public class Step implements IsElement<HTMLLIElement> {

    private final HTMLLIElement element = li().css("step").asElement();
    private final HTMLDivElement contentElement = div().css("step-content").asElement();
    private HTMLDivElement stepHeader;
    private HTMLDivElement bodyElement = div().css("step-body").asElement();
    private HTMLDivElement footerElement = div().css("step-footer").asElement();
    private boolean expanded = false;
    private StepCompletedValidator stepCompletedValidator = () -> true;
    private Collapsible collapsible = Collapsible.create(contentElement);
    private boolean allowStepClickActivation = true;
    private Stepper stepper;

    public Step(String title) {
        init(makeHeaderElement(title, ""));
    }

    public Step(String title, String description) {
        init(makeHeaderElement(title, description));
    }

    private HTMLDivElement makeHeaderElement(String title, String description) {
        return div().css("step-title").attr("data-step-label", description).textContent(title).asElement();
    }

    private void init(HTMLDivElement stepHeader) {
        this.stepHeader = stepHeader;
        element.appendChild(stepHeader);
        element.appendChild(contentElement);
        contentElement.appendChild(bodyElement);
        contentElement.appendChild(footerElement);
        collapsible.collapse();
        ElementUtil.onAttach(asElement(), mutationRecord -> {
            if (expanded) {
                collapsible.expand();
            }
        });
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
        return appendChild(content.asElement());
    }

    public Step appendFooterChild(Node content) {
        footerElement.appendChild(content);
        return this;
    }

    public Step appendFooterChild(IsElement content) {
        return appendFooterChild(content.asElement());
    }

    Step activate(Transition transition) {
        clearInvalid();
        Style.of(element).css("active");
        collapsible.expand();
        this.expanded = true;
        Animation.create(contentElement)
                .duration(350)
                .transition(transition)
               .animate();
        return this;
    }

    Step deActivate() {
        clearInvalid();
        Style.of(element).removeCss("active");
        collapsible.collapse();
        this.expanded = false;
        return this;
    }

    void setStepper(Stepper stepper){
        this.stepper = stepper;
    }

    public int getIndex(){
        if(nonNull(this.stepper)){
            return stepper.getSteps().indexOf(this);
        }
        return -1;
    }

    public void setDone(boolean done) {
        Style.of(element).removeCss("done");
        if (done) {
            Style.of(element).css("done");
        }
    }

    public void invalidate() {
        if (!Style.of(element).hasClass("wrong")) {
            Style.of(element).css("wrong");
        }
    }

    public void clearInvalid() {
        Style.of(element).removeClass("wrong");
    }

    public HTMLDivElement getStepBody() {
        return bodyElement;
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

    public HTMLDivElement getStepHeader() {
        return stepHeader;
    }

    public boolean isActive(){
        return Style.of(element).hasClass("active");
    }

    @Override
    public HTMLLIElement asElement() {
        return element;
    }

    public void setAllowStepClickActivation(boolean allow){
        this.allowStepClickActivation = allow;
    }

    public boolean isAllowStepClickActivation() {
        return allowStepClickActivation;
    }

    public Step disableClickActivation(){
        setAllowStepClickActivation(false);
        return this;
    }

    public Step enableClickActivation(){
        setAllowStepClickActivation(true);
        return this;
    }

    @FunctionalInterface
    public interface StepCompletedValidator {
        boolean isValid();
    }
}
