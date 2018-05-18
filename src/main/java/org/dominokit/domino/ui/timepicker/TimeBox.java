package org.dominokit.domino.ui.timepicker;

import elemental2.dom.DomGlobal;
import elemental2.dom.EventListener;
import elemental2.dom.HTMLInputElement;
import org.dominokit.domino.ui.forms.ValueBox;
import org.dominokit.domino.ui.modals.ModalDialog;
import org.dominokit.domino.ui.popover.Popover;
import org.dominokit.domino.ui.popover.PopupPosition;
import org.dominokit.domino.ui.style.Styles;
import org.dominokit.domino.ui.utils.BodyObserver;
import org.gwtproject.i18n.shared.DateTimeFormatInfo;
import org.jboss.gwt.elemento.core.Elements;
import org.jboss.gwt.elemento.core.EventType;

import static java.util.Objects.isNull;
import static java.util.Objects.nonNull;

public class TimeBox extends ValueBox<TimeBox, HTMLInputElement, Time> {

    private TimePicker timePicker;

    private Popover popover;
    private ModalDialog modal;
    private EventListener modalListener;
    private PopupPosition popupPosition = PopupPosition.BOTTOM;

    private PickerStyle pickerStyle;
    private Time value;

    public TimeBox() {
        this(new Time());
    }

    public TimeBox(Time time) {
        this.timePicker = TimePicker.create();
        this.timePicker.setTime(time);
        init();
    }

    public TimeBox(String placeholder, Time time) {
        super("text", placeholder);
        this.timePicker = timePicker.create();
        this.timePicker.setTime(time);
        init();
    }

    public TimeBox(String placeholder, Time time, DateTimeFormatInfo dateTimeFormatInfo) {
        super("text", placeholder);
        this.timePicker = TimePicker.create(dateTimeFormatInfo);
        this.timePicker.setTime(time);
        init();
    }

    @Override
    protected HTMLInputElement createElement(String type, String placeholder) {
        return Elements.input("text").css("form-control")
                .attr("placeholder", placeholder)
                .attr("readOnly", "true")
                .asElement();
    }

    private void init() {
        this.timePicker.addTimeSelectionHandler(this::setStringValue);
        this.modalListener = evt -> modal.open();
        BodyObserver.observeRemoval(asElement(), mutationRecord -> {
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

        timePicker.setColorSchemeHandler((oldColorScheme, newColorScheme) -> {
            if (nonNull(modal)) {
                modal.getHeaderContainerElement().classList.remove(oldColorScheme.color().getStyle());
                modal.getHeaderContainerElement().classList.add(newColorScheme.color().getStyle());
            }

            if (nonNull(popover)) {
                popover.getHeadingElement().classList.remove(oldColorScheme.color().getStyle());
                popover.getHeadingElement().classList.add(newColorScheme.color().getStyle());
            }
        });
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
    public void setValue(Time value) {
        if (nonNull(value))
            this.timePicker.setTime(value);

        setStringValue(value, timePicker.getDateTimeFormatInfo(), timePicker);
        this.value = value;
    }

    private void setStringValue(Time time, DateTimeFormatInfo dateTimeFormatInfo, TimePicker picker) {
        if (nonNull(time))
            this.inputElement.value = picker.getFormattedTime();
        else
            this.inputElement.value = "";
        this.value= time;
    }

    @Override
    public Time getValue() {
        return this.value;
    }

    @Override
    public String getPlaceholder() {
        return inputElement.placeholder;
    }

    @Override
    public TimeBox setPlaceholder(String placeholder) {
        inputElement.placeholder = placeholder;
        if (nonNull(modal)) {
            modal.setTitle(placeholder);
            modal.getHeaderContainerElement().classList.add(timePicker.getColorScheme().color().getStyle());
        }

        if (nonNull(popover)) {
            popover.getHeaderText().textContent = placeholder;
            popover.getHeadingElement().classList.add(timePicker.getColorScheme().color().getStyle());
        }
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
                modal.close();
                modal.asElement().remove();
            }

            if (isNull(popover)) {
                popover = Popover.create(this.asElement(), getPlaceholder(), this.timePicker.asElement());
                popover.getContentElement().style.setProperty("padding", "0px", "important");
                popover.getContentElement().style.setProperty("width", "300px", "important");
                popover.position(this.popupPosition)
                        .asElement().style.setProperty("max-width", "none", "important");
                popover.getHeadingElement().classList.add(Styles.align_center, timePicker.getColorScheme().color().getStyle());
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

    public enum PickerStyle {
        MODAL,
        POPOVER
    }
}
