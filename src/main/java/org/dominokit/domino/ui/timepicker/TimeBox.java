package org.dominokit.domino.ui.timepicker;

import elemental2.dom.DomGlobal;
import elemental2.dom.EventListener;
import elemental2.dom.HTMLInputElement;
import elemental2.dom.KeyboardEvent;
import jsinterop.base.Js;
import org.dominokit.domino.ui.forms.ValueBox;
import org.dominokit.domino.ui.modals.ModalDialog;
import org.dominokit.domino.ui.popover.Popover;
import org.dominokit.domino.ui.popover.PopupPosition;
import org.gwtproject.i18n.shared.DateTimeFormatInfo;
import org.jboss.gwt.elemento.core.EventType;

import static java.util.Objects.isNull;
import static java.util.Objects.nonNull;
import static org.jboss.gwt.elemento.core.Elements.input;
import static org.jboss.gwt.elemento.core.Elements.onDetach;

public class TimeBox extends ValueBox<TimeBox, HTMLInputElement, Time> {

    private TimePicker timePicker;

    private Popover popover;
    private ModalDialog modal;
    private EventListener modalListener;
    private PopupPosition popupPosition = PopupPosition.BOTTOM;

    private PickerStyle pickerStyle;
    private Time value;
    private EventListener keyboardModalListener;

    public TimeBox() {
        this(new Time());
    }

    public TimeBox(Time time) {
        this("", time);
    }

    public TimeBox(String placeholder, Time time) {
        this(placeholder, time, null);
    }

    public TimeBox(String placeholder, Time time, DateTimeFormatInfo dateTimeFormatInfo) {
        super("text", placeholder);
        if (nonNull(dateTimeFormatInfo))
            this.timePicker = TimePicker.create(dateTimeFormatInfo);
        else
            this.timePicker = TimePicker.create();
        setValue(time);
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
        onDetach(asElement(), mutationRecord -> {
            if (nonNull(popover))
                popover.discard();
            if (nonNull(modal)) {
                modal.close();
                modal.asElement().remove();
            }
        });

        timePicker.addCloseHandler(() -> {
            if (nonNull(popover))
                popover.close();
            if (nonNull(modal) && modal.isOpen())
                modal.close();
        });

        timePicker.addClearHandler(() -> setValue(null));
        setPickerStyle(PickerStyle.MODAL);

    }

    public static TimeBox create() {
        return new TimeBox();
    }

    public static TimeBox create(Time time) {
        return new TimeBox(time);
    }

    public static TimeBox create(String placeHolder, Time time) {
        return new TimeBox(placeHolder, time);
    }

    public static TimeBox create(String placeholder, Time time, DateTimeFormatInfo dateTimeFormatInfo) {
        return new TimeBox(placeholder, time, dateTimeFormatInfo);
    }


    @Override
    public boolean isEmpty() {
        return isNull(getTimePicker().getTime());
    }

    @Override
    protected void clearValue() {
        setValue(null);
    }

    @Override
    protected void doSetValue(Time value) {
        if (nonNull(value))
            this.timePicker.setTime(value);

        setStringValue(value, timePicker);
        this.value = value;
    }

    private void setStringValue(Time time, TimePicker picker) {
        if (nonNull(time))
            this.getInputElement().value = picker.getFormattedTime();
        else
            this.getInputElement().value = "";
        this.value = time;
    }

    @Override
    public Time getValue() {
        return this.value;
    }

    @Override
    public String getPlaceholder() {
        return getInputElement().placeholder;
    }

    @Override
    protected HTMLInputElement createInputElement(String type) {
        return input("text").css("form-control")
                .attr("readOnly", "true")
                .asElement();
    }

    @Override
    public TimeBox setPlaceholder(String placeholder) {
        getInputElement().placeholder = placeholder;
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
                popover.getContentElement().style.setProperty("padding", "0px", "important");
                popover.getContentElement().style.setProperty("width", "270px", "important");
                popover.position(this.popupPosition)
                        .asElement().style.setProperty("max-width", "none", "important");

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
                this.modal = ModalDialog.createPickerModal(getPlaceholder(), timePicker.getColorScheme(), this.timePicker.asElement());
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
    protected void doSetReadOnly(boolean readOnly) {
        super.doSetReadOnly(readOnly);
        if (readOnly) {
            disableModal();
            disablePopover();
        } else if (isEnabled()) {
            enableModal();
            enablePopover();
        }
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
