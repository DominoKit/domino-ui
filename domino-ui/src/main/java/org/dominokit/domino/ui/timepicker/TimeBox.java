package org.dominokit.domino.ui.timepicker;

import elemental2.dom.*;
import jsinterop.base.Js;
import org.dominokit.domino.ui.forms.ValueBox;
import org.dominokit.domino.ui.forms.validations.InputAutoValidator;
import org.dominokit.domino.ui.grid.flex.FlexItem;
import org.dominokit.domino.ui.icons.Icons;
import org.dominokit.domino.ui.icons.MdiIcon;
import org.dominokit.domino.ui.modals.ModalDialog;
import org.dominokit.domino.ui.popover.Popover;
import org.dominokit.domino.ui.popover.PopupPosition;
import org.dominokit.domino.ui.style.Style;
import org.dominokit.domino.ui.utils.ElementUtil;
import org.gwtproject.i18n.shared.DateTimeFormatInfo;
import org.jboss.gwt.elemento.core.EventType;

import java.util.Date;

import static java.util.Objects.isNull;
import static java.util.Objects.nonNull;
import static org.jboss.gwt.elemento.core.Elements.input;

public class TimeBox extends ValueBox<TimeBox, HTMLInputElement, Date> {

    private TimePicker timePicker;

    private Popover popover;
    private ModalDialog modal;
    private EventListener modalListener;
    private PopupPosition popupPosition = PopupPosition.BOTTOM;

    private PickerStyle pickerStyle;
    private Date value;
    private EventListener keyboardModalListener;
    private MdiIcon timeIcon;
    private FlexItem timeIconContainer;

    public TimeBox() {
        this(null);
    }

    public TimeBox(Date time) {
        this(null, time);
    }

    public TimeBox(String label, Date time) {
        this(label, time, null);
    }

    public TimeBox(String label, Date time, DateTimeFormatInfo dateTimeFormatInfo) {
        super("text", label);
        if (nonNull(dateTimeFormatInfo))
            this.timePicker = TimePicker.create(dateTimeFormatInfo);
        else
            this.timePicker = TimePicker.create();
        value(time);
        init();
    }

    private void init() {
        this.timePicker.addTimeSelectionHandler((time, dateTimeFormatInfo, picker) -> {
            setStringValue(time, picker);
            changeLabelFloating();
            autoValidate();
        });
        this.modalListener = evt -> modal.open();
        this.keyboardModalListener = event -> {
            event.stopPropagation();
            KeyboardEvent keyboardEvent = Js.cast(event);
            if (keyboardEvent.code.equals("Enter")) {
                modal.open();
            } else if (keyboardEvent.code.equals("Escape")) {
                modal.close();
            }
        };
        ElementUtil.onDetach(asElement(), mutationRecord -> {
            if (nonNull(popover))
                popover.discard();
            if (nonNull(modal)) {
                modal.asElement().remove();
            }
        });
        timePicker.addCloseHandler(() -> {
            if (nonNull(popover))
                popover.close();
            if (nonNull(modal) && modal.isOpen())
                modal.close();
        });
        timePicker.addClearHandler(() -> value(null));
        setPickerStyle(PickerStyle.MODAL);
    }

    public static TimeBox create() {
        return new TimeBox();
    }

    public static TimeBox create(Date time) {
        return new TimeBox(time);
    }

    public static TimeBox create(String placeHolder, Date time) {
        return new TimeBox(placeHolder, time);
    }

    public static TimeBox create(String placeholder, Date time, DateTimeFormatInfo dateTimeFormatInfo) {
        return new TimeBox(placeholder, time, dateTimeFormatInfo);
    }

    @Override
    public boolean isEmpty() {
        String stringValue = getStringValue();
        return isNull(stringValue) || stringValue.isEmpty();
    }

    @Override
    protected void clearValue() {
        value(null);
    }

    @Override
    protected void doSetValue(Date value) {
        if (nonNull(value)) {
            this.timePicker.setTime(value);
        }
        setStringValue(value, timePicker);
        this.value = value;
    }

    private void setStringValue(Date time, TimePicker picker) {
        if (nonNull(time))
            this.getInputElement().asElement().value = picker.getFormattedTime();
        else
            this.getInputElement().asElement().value = "";
        this.value = time;
    }


    @Override
    public Date getValue() {
        return this.value;
    }

    @Override
    public String getPlaceholder() {
        return getInputElement().asElement().placeholder;
    }

    @Override
    protected HTMLInputElement createInputElement(String type) {
        return input("text")
                .attr("readOnly", "true")
                .asElement();
    }

    @Override
    public TimeBox setPlaceholder(String placeholder) {
        getInputElement().asElement().placeholder = placeholder;
        return this;
    }

    public TimeBox setPickerStyle(PickerStyle pickerStyle) {
        if (PickerStyle.MODAL.equals(pickerStyle)) {
            showInModal();
        } else {
            showInPopOver();
        }
        return this;
    }

    public Style<HTMLElement, TimeBox> style() {
        return Style.of(this);
    }

    private void showInPopOver() {
        if (!PickerStyle.POPOVER.equals(this.pickerStyle)) {
            if (nonNull(modal)) {
                asElement().removeEventListener(EventType.click.getName(), modalListener);
                asElement().removeEventListener(EventType.keydown.getName(), keyboardModalListener);
                modal.close();
                modal.asElement().remove();
            }

            if (isNull(popover)) {
                popover = Popover.createPicker(this.asElement(), this.timePicker.asElement());
                popover.getContentElement().style().setPadding("0px", true);
                popover.getContentElement().style().setWidth("270px", true);
                popover.position(this.popupPosition)
                        .style().setMaxWidth("none", true);

                asElement().addEventListener(EventType.keydown.getName(), event -> {
                    KeyboardEvent keyboardEvent = Js.cast(event);
                    event.stopPropagation();
                    if (keyboardEvent.code.equals("Enter")) {
                        popover.show();
                    } else if (keyboardEvent.code.equals("Escape")) {
                        popover.close();
                    }
                });
            }
        }

        this.pickerStyle = PickerStyle.POPOVER;
    }

    private void showInModal() {
        if (!PickerStyle.MODAL.equals(this.pickerStyle)) {
            if (nonNull(popover)) {
                this.popover.discard();
            }

            if (isNull(modal)) {
                this.modal = ModalDialog.createPickerModal(getPlaceholder(), this.timePicker.asElement());
                DomGlobal.document.body.appendChild(modal.asElement());
                asElement().addEventListener(EventType.click.getName(), modalListener);

                asElement().addEventListener(EventType.keydown.getName(), keyboardModalListener);
            }
        }
        this.pickerStyle = PickerStyle.MODAL;
    }

    public TimePicker getTimePicker() {
        return timePicker;
    }

    public TimeBox setPopoverPosition(PopupPosition popoverPosition) {
        this.popupPosition = popoverPosition;
        if (nonNull(this.popover))
            this.popover.position(this.popupPosition);
        return this;
    }

    @Override
    public TimeBox disable() {
        disableModal();
        disablePopover();
        return super.disable();
    }

    @Override
    public TimeBox setReadOnly(boolean readOnly) {
        super.setReadOnly(readOnly);
        if (readOnly) {
            disableModal();
            disablePopover();
        } else if (isEnabled()) {
            enableModal();
            enablePopover();
        }
        return this;
    }

    @Override
    public String getStringValue() {
        return nonNull(value) ? timePicker.getFormattedTime() : "";
    }

    @Override
    protected AutoValidator createAutoValidator(AutoValidate autoValidate) {
        return new InputAutoValidator<>(getInputElement(), autoValidate);
    }

    @Override
    protected FlexItem createMandatoryAddOn() {
        timeIcon = Icons.ALL.clock_mdi();
        timeIcon.clickable();
        timeIconContainer = FlexItem.create();
        return timeIconContainer
                .appendChild(timeIcon);
    }

    public MdiIcon getTimeIcon() {
        return timeIcon;
    }

    public void setTimeIcon(MdiIcon timeIcon) {
        this.timeIcon = timeIcon;
    }

    public FlexItem getTimeIconContainer() {
        return timeIconContainer;
    }

    public void setTimeIconContainer(FlexItem timeIconContainer) {
        this.timeIconContainer = timeIconContainer;
    }

    @Override
    public TimeBox enable() {
        enableModal();
        enablePopover();
        return super.enable();
    }

    private void disablePopover() {
        if (nonNull(popover)) {
            popover.disable();
        }
    }

    private void disableModal() {
        if (nonNull(modal)) {
            modal.disable();
        }
    }

    private void enablePopover() {
        if (nonNull(popover)) {
            popover.enable();
        }
    }

    private void enableModal() {
        if (nonNull(modal)) {
            modal.enable();
        }
    }

    public enum PickerStyle {
        MODAL,
        POPOVER
    }
}
