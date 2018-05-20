package org.dominokit.domino.ui.datepicker;

import elemental2.dom.DomGlobal;
import elemental2.dom.EventListener;
import elemental2.dom.HTMLInputElement;
import org.dominokit.domino.ui.forms.ValueBox;
import org.dominokit.domino.ui.modals.ModalDialog;
import org.dominokit.domino.ui.popover.Popover;
import org.dominokit.domino.ui.popover.PopupPosition;
import org.dominokit.domino.ui.style.Styles;
import org.gwtproject.i18n.shared.DateTimeFormat;
import org.gwtproject.i18n.shared.DateTimeFormatInfo;
import org.jboss.gwt.elemento.core.Elements;
import org.jboss.gwt.elemento.core.EventType;

import java.util.Date;

import static java.util.Objects.isNull;
import static java.util.Objects.nonNull;

public class DateBox extends ValueBox<DateBox, HTMLInputElement, Date> {

    private DatePicker datePicker;
    private String pattern;

    private Popover popover;
    private ModalDialog modal;
    private EventListener modalListener;
    private PopupPosition popupPosition = PopupPosition.BOTTOM;

    private PickerStyle pickerStyle;
    private Date value;

    public DateBox() {
        this(new Date());
    }

    public DateBox(Date date) {
        this("", date);
    }

    public DateBox(String placeholder, Date date) {
        super("text", placeholder);
        this.datePicker = DatePicker.create(date);
        init();
    }

    public DateBox(String placeholder, Date date, DateTimeFormatInfo dateTimeFormatInfo) {
        super("text", placeholder);
        this.datePicker = DatePicker.create(date, dateTimeFormatInfo);
        init();
    }

    private void init() {
        this.pattern = this.datePicker.getDateTimeFormatInfo().dateFormatFull();
        this.datePicker.addDateSelectionHandler(this::setStringValue);
        this.modalListener = evt -> modal.open();
        DomGlobal.document.body.addEventListener("DOMNodeRemoved", evt -> {
            if (evt.target.equals(asElement())) {
                if (nonNull(popover))
                    popover.discard();
                if (nonNull(modal)) {
                    modal.close();
                    modal.asElement().remove();
                }
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
    }

    public static DateBox create() {
        return new DateBox();
    }

    public static DateBox create(Date date) {
        return new DateBox(date);
    }

    public static DateBox create(String placeHolder, Date date) {
        return new DateBox(placeHolder, date);
    }

    public static DateBox create(String placeholder, Date date, DateTimeFormatInfo dateTimeFormatInfo) {
        return new DateBox(placeholder, date, dateTimeFormatInfo);
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
        return isNull(datePicker.getDate());
    }

    @Override
    public DateBox clear() {
        datePicker.setValue(null);
        return this;
    }

    @Override
    public void setValue(Date value) {
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
        return Elements.input("text").css("form-control")
                .attr("readOnly", "true")
                .asElement();
    }

    @Override
    public DateBox setPlaceholder(String placeholder) {
        super.setPlaceholder(placeholder);
        if (nonNull(modal)) {
            modal.setTitle(placeholder);
            modal.getHeaderContainerElement().classList.add(datePicker.getBackground().color().getStyle());
        }

        if (nonNull(popover)) {
            popover.getHeaderText().textContent = placeholder;
            popover.getHeadingElement().classList.add(datePicker.getBackground().color().getStyle());
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
                popover = Popover.create(this.asElement(), getPlaceholder(), this.datePicker.asElement());
                popover.getContentElement().style.setProperty("padding", "0px", "important");
                popover.getContentElement().style.setProperty("width", "300px", "important");
                popover.position(this.popupPosition)
                        .asElement().style.setProperty("max-width", "none", "important");
                popover.getHeadingElement().classList.add(Styles.align_center, datePicker.getBackground().color().getStyle());
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
                this.modal = ModalDialog.create(getPlaceholder())
                        .small()
                        .setAutoClose(true)
                        .appendContent(this.datePicker.asElement());
                this.modal.getHeaderContainerElement().classList.add("calendar-modal-header", datePicker.getBackground().color().getStyle());
                this.modal.getBodyElement().style.setProperty("padding", "0px", "important");
                this.modal.getFooterElement().style.setProperty("padding", "0px", "important");
                DomGlobal.document.body.appendChild(modal.asElement());
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
