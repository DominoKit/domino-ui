package org.dominokit.domino.ui.datepicker;

import elemental2.dom.DomGlobal;
import elemental2.dom.EventListener;
import elemental2.dom.HTMLInputElement;
import elemental2.dom.KeyboardEvent;
import jsinterop.base.Js;
import org.dominokit.domino.ui.forms.FormFieldsStyles;
import org.dominokit.domino.ui.forms.ValueBox;
import org.dominokit.domino.ui.forms.validations.ValidationResult;
import org.dominokit.domino.ui.modals.ModalBackDrop;
import org.dominokit.domino.ui.modals.ModalDialog;
import org.dominokit.domino.ui.popover.Popover;
import org.dominokit.domino.ui.popover.PopupPosition;
import org.dominokit.domino.ui.style.Styles;
import org.dominokit.domino.ui.timepicker.Time;
import org.dominokit.domino.ui.utils.ElementUtil;
import org.gwtproject.i18n.shared.DateTimeFormat;
import org.gwtproject.i18n.shared.DateTimeFormatInfo;
import org.gwtproject.timer.client.Timer;
import org.jboss.gwt.elemento.core.EventType;

import java.util.Date;

import static java.util.Objects.isNull;
import static java.util.Objects.nonNull;
import static org.dominokit.domino.ui.utils.ElementUtil.isEnterKey;
import static org.dominokit.domino.ui.utils.ElementUtil.isSpaceKey;
import static org.jboss.gwt.elemento.core.Elements.input;

public class DateBox extends ValueBox<DateBox, HTMLInputElement, Date> {

    private DatePicker datePicker;
    private String pattern;

    private Popover popover;
    private ModalDialog modal;
    private EventListener modalListener;
    private PopupPosition popupPosition = PopupPosition.BOTTOM;

    private PickerStyle pickerStyle;
    private Date value;
    private String invalidFormatMessage = "Invalid date format";
    private EventListener focusListener;
    private boolean openOnFocus = false;
    private boolean focused = false;
    private boolean handlerPaused = false;

    public DateBox() {
        this(new Date());
    }

    public DateBox(String label) {
        this(label, new Date());
    }

    public DateBox(Date date) {
        this("", date);
    }

    public DateBox(String label, Date date) {
        super("text", label);
        this.datePicker = DatePicker.create(date);
        initDateBox();
    }

    public DateBox(String label, Date date, Date minDate, Date maxDate) {
        super("text", label);
        this.datePicker = DatePicker.create(date, minDate, maxDate);
        initDateBox();
    }

    public DateBox(String label, Date date, DateTimeFormatInfo dateTimeFormatInfo) {
        super("text", label);
        this.datePicker = DatePicker.create(date, dateTimeFormatInfo);
        initDateBox();
    }

    public DateBox(String label, Date date, DateTimeFormatInfo dateTimeFormatInfo, Date minDate, Date maxDate) {
        super("text", label);
        this.datePicker = DatePicker.create(date, dateTimeFormatInfo, minDate, maxDate);
        initDateBox();
    }

    private void initDateBox() {
        this.pattern = this.datePicker.getDateTimeFormatInfo().dateFormatFull();
        this.datePicker.addDateSelectionHandler((date, dateTimeFormatInfo) -> {
            if (!handlerPaused) {
                value(date);
            }
        });

        getInputElement().addEventListener(EventType.focus.getName(), evt -> focused = true);
        getInputElement().addEventListener("focusin", evt -> focused = true);
        getInputElement().addEventListener(EventType.blur.getName(), evt -> focused = false);
        getInputElement().addEventListener("focusout", evt -> focused = false);

        this.modalListener = evt -> {
            if (!openOnFocus || focused) {
                modal.open();
            }
        };
        ElementUtil.onDetach(asElement(), mutationRecord -> removeBox());

        datePicker.addCloseHandler(this::close);

        datePicker.addClearHandler(() -> value(null));
        setPickerStyle(PickerStyle.MODAL);

        datePicker.setBackgroundHandler((oldBackground, newBackground) -> {
            if (nonNull(modal)) {
                modal.getHeaderContainerElement().style().remove(oldBackground.color().getStyle());
                modal.getHeaderContainerElement().style().add(newBackground.color().getStyle());

            }

            if (nonNull(popover)) {
                popover.getHeadingElement().style().remove(oldBackground.color().getStyle());
                popover.getHeadingElement().style().add(newBackground.color().getStyle());
            }
        });

        getInputElement().addEventListener(EventType.keypress.getName(), evt -> {
            KeyboardEvent keyboardEvent = Js.cast(evt);
            if (isEnterKey(keyboardEvent) || isSpaceKey(keyboardEvent)) {
                open();
            }
        });
        addValidator(() -> {
            try {
                if (isEmpty()) {
                    return ValidationResult.valid();
                }
                getFormattedValue(getInputElement().asElement().value);
                return ValidationResult.valid();
            } catch (IllegalArgumentException e) {
                return ValidationResult.invalid(invalidFormatMessage);
            }
        });
        getInputElement().addEventListener("change", evt -> {
            String value = getInputElement().asElement().value;
            if (value.isEmpty()) {
                clear();
            } else {
                try {
                    value(getFormattedValue(value));
                } catch (IllegalArgumentException ignored) {
                    DomGlobal.console.warn("Unable to parse date value " + value);
                }
            }
        });
    }

    private void removeBox() {
        if (nonNull(popover))
            popover.close();
        if (nonNull(modal)) {
            modal.asElement().remove();
        }
    }

    public void close() {
        if (nonNull(popover))
            popover.close();
        if (nonNull(modal) && modal.isOpen())
            modal.close();
    }

    private Date getFormattedValue(String value) throws IllegalArgumentException {
        DateTimeFormatInfo dateTimeFormatInfo = datePicker.getDateTimeFormatInfo();
        return Formatter.getFormat(this.pattern, dateTimeFormatInfo).parse(value);
    }

    public static DateBox create() {
        return new DateBox();
    }

    public static DateBox create(String label) {
        return new DateBox(label);
    }

    public static DateBox create(Date date) {
        return new DateBox(date);
    }

    public static DateBox create(String label, Date date) {
        return new DateBox(label, date);
    }

    public static DateBox create(String label, Date date, DateTimeFormatInfo dateTimeFormatInfo) {
        return new DateBox(label, date, dateTimeFormatInfo);
    }

    public DateBox setPattern(Pattern pattern) {
        switch (pattern) {
            case FULL:
                this.pattern = datePicker.getDateTimeFormatInfo().dateFormatFull();
                return this;
            case LONG:
                this.pattern = datePicker.getDateTimeFormatInfo().dateFormatLong();
                return this;
            case MEDIUM:
                this.pattern = datePicker.getDateTimeFormatInfo().dateFormatMedium();
                return this;
            case SHORT:
                this.pattern = datePicker.getDateTimeFormatInfo().dateFormatShort();
                return this;
            default:
                return this;
        }
    }

    public DateBox setPattern(String pattern) {
        this.pattern = pattern;
        return this;
    }

    @Override
    public boolean isEmpty() {
        return isNull(value) && getInputElement().asElement().value.isEmpty();
    }

    @Override
    protected void clearValue() {
        value(null);
    }

    @Override
    protected void doSetValue(Date value) {
        if (nonNull(value)) {
            handlerPaused = true;
            this.datePicker.setDate(value);
            this.handlerPaused = false;
            setStringValue(this.datePicker.getDate(), datePicker.getDateTimeFormatInfo());
            this.value = this.datePicker.getDate();
        }else{
            setStringValue(value, datePicker.getDateTimeFormatInfo());
            this.value = value;
        }
    }

    private void setStringValue(Date date, DateTimeFormatInfo dateTimeFormatInfo) {
        if (nonNull(date))
            this.getInputElement().asElement().value = getFormatted(date, dateTimeFormatInfo);
        else
            this.getInputElement().asElement().value = "";
        this.value = date;
    }

    private String getFormatted(Date date, DateTimeFormatInfo dateTimeFormatInfo) {
        return Formatter.getFormat(this.pattern, dateTimeFormatInfo).format(date);
    }

    @Override
    public Date getValue() {
        return this.value;
    }

    @Override
    protected HTMLInputElement createInputElement(String type) {
        return input("text")
                .css(FormFieldsStyles.FORM_CONTROL)
                .asElement();
    }

    @Override
    public DateBox setPlaceholder(String placeholder) {
        super.setPlaceholder(placeholder);
        if (nonNull(modal)) {
            modal.setTitle(placeholder);
            modal.getHeaderContainerElement().style().add(datePicker.getColorScheme().color().getStyle());
        }

        if (nonNull(popover)) {
            popover.getHeaderText().textContent = placeholder;
            popover.getHeadingElement().style().add(datePicker.getColorScheme().color().getStyle());
        }
        return this;
    }

    public DateBox setPickerStyle(PickerStyle pickerStyle) {
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
                if (modal.isOpen()) {
                    modal.close();
                }
                modal.asElement().remove();
            }

            if (isNull(popover)) {
                popover = Popover.createPicker(this, this.datePicker)
                        .position(this.popupPosition)
                        .styler(style -> style.add(DatePickerStyles.PICKER_POPOVER));

                popover.getHeadingElement()
                        .style()
                        .add(Styles.align_center, datePicker.getColorScheme().color().getStyle());
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
                this.modal = ModalDialog.createPickerModal(getPlaceholder(), this.datePicker.asElement());
                asElement().addEventListener(EventType.click.getName(), modalListener);
            }
        }
        this.pickerStyle = PickerStyle.MODAL;
    }

    public DatePicker getDatePicker() {
        return datePicker;
    }

    public DateBox setPopoverPosition(PopupPosition popoverPosition) {
        this.popupPosition = popoverPosition;
        if (nonNull(this.popover))
            this.popover.position(this.popupPosition);
        return this;
    }

    public DateBox openOnFocus() {
        this.openOnFocus = true;
        if (nonNull(getFocusEventListener())) {
            getInputElement().removeEventListener(EventType.focus.getName(), getFocusEventListener());
        }
        focusListener = evt -> {
            getInputElement().removeEventListener(EventType.focus.getName(), getFocusEventListener());
            open();
        };
        getInputElement().addEventListener(EventType.focus.getName(), getFocusEventListener());
        modal.addCloseListener(() -> {
            getInputElement().asElement().focus();
            getInputElement().addEventListener(EventType.focus.getName(), getFocusEventListener());
        });

        modal.addOpenListener(() -> {
            getInputElement().removeEventListener(EventType.focus.getName(), getFocusEventListener());
        });
        return this;
    }

    private EventListener getFocusEventListener() {
        return focusListener;
    }

    public void open() {
        if (PickerStyle.MODAL.equals(this.pickerStyle)) {
            modal.open();
        } else {
            popover.show();
        }
    }

    @Override
    public DateBox disable() {
        disableModal();
        disablePopover();
        return super.disable();
    }

    @Override
    public DateBox setReadOnly(boolean readOnly) {
        super.setReadOnly(readOnly);
        if (readOnly) {
            getInputElement().style().add(FormFieldsStyles.READONLY);
            disableModal();
            disablePopover();
        } else if (isEnabled()) {
            enableModal();
            enablePopover();
        }
        return this;
    }

    @Override
    public DateBox enable() {
        enableModal();
        enablePopover();
        return super.enable();
    }

    @Override
    public String getStringValue() {
        if (nonNull(value)) {
            return Formatter.getFormat(this.pattern, datePicker.getDateTimeFormatInfo()).format(value);
        }
        return null;
    }

    public DateBox setInvalidFormatMessage(String invalidFormatMessage) {
        this.invalidFormatMessage = invalidFormatMessage;
        return this;
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

    private static class Formatter extends DateTimeFormat {

        protected Formatter(String pattern) {
            super(pattern);
        }

        protected Formatter(String pattern, DateTimeFormatInfo dtfi) {
            super(pattern, dtfi);
        }

        public static DateTimeFormat getFormat(String pattern, DateTimeFormatInfo dateTimeFormatInfo) {
            return DateTimeFormat.getFormat(pattern, dateTimeFormatInfo);
        }
    }

    public enum Pattern {
        FULL,
        LONG,
        MEDIUM,
        SHORT
    }

    public enum PickerStyle {
        MODAL,
        POPOVER
    }

}
