package org.dominokit.domino.ui.datepicker;

import elemental2.dom.DomGlobal;
import elemental2.dom.EventListener;
import elemental2.dom.HTMLInputElement;
import elemental2.dom.KeyboardEvent;
import jsinterop.base.Js;
import org.dominokit.domino.ui.forms.ValueBox;
import org.dominokit.domino.ui.modals.ModalDialog;
import org.dominokit.domino.ui.popover.Popover;
import org.dominokit.domino.ui.popover.PopupPosition;
import org.dominokit.domino.ui.style.Style;
import org.dominokit.domino.ui.style.Styles;
import org.dominokit.domino.ui.utils.ElementUtil;
import org.dominokit.domino.ui.utils.ValidationResult;
import org.gwtproject.i18n.shared.DateTimeFormat;
import org.gwtproject.i18n.shared.DateTimeFormatInfo;
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
        init();
    }

    public DateBox(String label, Date date, DateTimeFormatInfo dateTimeFormatInfo) {
        super("text", label);
        this.datePicker = DatePicker.create(date, dateTimeFormatInfo);
        init();
    }

    private void init() {
        this.pattern = this.datePicker.getDateTimeFormatInfo().dateFormatFull();
        this.datePicker.addDateSelectionHandler((date, dateTimeFormatInfo) -> {
            setStringValue(date, dateTimeFormatInfo);
            changeLabelFloating();
            autoValidate();
        });
        this.modalListener = evt -> modal.open();
        ElementUtil.onDetach(asElement(), mutationRecord -> {
            if (nonNull(popover))
                popover.discard();
            if (nonNull(modal)) {
                modal.close();
                modal.asElement().remove();
            }
        });

        datePicker.addCloseHandler(() -> {
            if (nonNull(popover))
                popover.close();
            if (nonNull(modal) && modal.isOpen())
                modal.close();
        });

        datePicker.addClearHandler(() -> setValue(null));
        setPickerStyle(PickerStyle.MODAL);

        datePicker.setBackgroundHandler((oldBackground, newBackground) -> {
            if (nonNull(modal)) {
                modal.getHeaderContainerElement().classList.remove(oldBackground.color().getStyle());
                modal.getHeaderContainerElement().classList.add(newBackground.color().getStyle());

            }

            if (nonNull(popover)) {
                popover.getHeadingElement().classList.remove(oldBackground.color().getStyle());
                popover.getHeadingElement().classList.add(newBackground.color().getStyle());
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
                getFormattedValue(getInputElement().value);
                return ValidationResult.valid();
            } catch (IllegalArgumentException e) {
                return ValidationResult.invalid(invalidFormatMessage);
            }
        });
        getInputElement().addEventListener("change", evt -> {
            String value = getInputElement().value;
            if (value.isEmpty()) {
                clear();
            } else {
                try {
                    setValue(getFormattedValue(value));
                } catch (IllegalArgumentException ignored) {
                    DomGlobal.console.warn("Unable to parse date value " + value);
                }
            }
        });
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
        return isNull(value) && getInputElement().value.isEmpty();
    }

    @Override
    protected void clearValue() {
        setValue(null);
    }

    @Override
    protected void doSetValue(Date value) {
        if (nonNull(value))
            this.datePicker.setDate(value);

        setStringValue(value, datePicker.getDateTimeFormatInfo());
        this.value = value;
    }

    private void setStringValue(Date date, DateTimeFormatInfo dateTimeFormatInfo) {
        if (nonNull(date))
            this.getInputElement().value = Formatter.getFormat(this.pattern, dateTimeFormatInfo).format(date);
        else
            this.getInputElement().value = "";
        this.value = date;
    }

    @Override
    public Date getValue() {
        return this.value;
    }

    @Override
    protected HTMLInputElement createInputElement(String type) {
        return input("text").css("form-control")
                .asElement();
    }

    @Override
    public DateBox setPlaceholder(String placeholder) {
        super.setPlaceholder(placeholder);
        if (nonNull(modal)) {
            modal.setTitle(placeholder);
            modal.getHeaderContainerElement().classList.add(datePicker.getColorScheme().color().getStyle());
        }

        if (nonNull(popover)) {
            popover.getHeaderText().textContent = placeholder;
            popover.getHeadingElement().classList.add(datePicker.getColorScheme().color().getStyle());
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
                modal.close();
                modal.asElement().remove();
            }

            if (isNull(popover)) {
                popover = Popover.createPicker(this.asElement(), this.datePicker.asElement());
                Style.of(popover).setMaxWidth("300px");
                Style.of(popover.getContentElement())
                        .setImportantProperty("padding", "0px")
                        .setImportantProperty("width", "300px")
                        .setImportantProperty("max-width", "300px");

                popover.position(this.popupPosition)
                        .asElement().style.setProperty("max-width", "none", "important");
                popover.getHeadingElement().classList.add(Styles.align_center, datePicker.getColorScheme().color().getStyle());
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
                this.modal = ModalDialog.createPickerModal(getPlaceholder(), datePicker.getColorScheme(), this.datePicker.asElement());
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
        EventListener focusListener = evt -> {
            open();
        };
        getInputElement().addEventListener(EventType.focus.getName(), focusListener);
        modal.onClose(() -> {
            getInputElement().removeEventListener(EventType.focus.getName(), focusListener);
            getInputElement().focus();
            getInputElement().addEventListener(EventType.focus.getName(), focusListener);
        });
        return this;
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
            getInputElement().classList.add("readonly");
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
