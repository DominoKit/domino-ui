/*
 * Copyright © 2019 Dominokit
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.dominokit.domino.ui.timepicker;

import elemental2.dom.EventListener;
import elemental2.dom.HTMLDivElement;
import elemental2.dom.HTMLInputElement;
import elemental2.dom.KeyboardEvent;
import jsinterop.base.Js;
import org.dominokit.domino.ui.dialogs.Dialog;
import org.dominokit.domino.ui.elements.InputElement;
import org.dominokit.domino.ui.events.EventType;
import org.dominokit.domino.ui.forms.InputFormField;
import org.dominokit.domino.ui.icons.Icons;
import org.dominokit.domino.ui.icons.MdiIcon;
import org.dominokit.domino.ui.menu.direction.DropDirection;
import org.dominokit.domino.ui.popover.Popover;
import org.dominokit.domino.ui.utils.DominoElement;
import org.dominokit.domino.ui.utils.ElementUtil;
import org.dominokit.domino.ui.utils.HasPlaceHolder;
import org.dominokit.domino.ui.utils.PrimaryAddOn;
import org.gwtproject.i18n.shared.cldr.DateTimeFormatInfo;

import java.util.Date;
import java.util.Optional;

import static java.util.Objects.isNull;
import static java.util.Objects.nonNull;

/**
 * A form element that takes and provide date value as time using a picker element
 */
public class TimeBox extends InputFormField<TimeBox, HTMLInputElement, Date> implements HasPlaceHolder<TimeBox> {

    private TimePicker timePicker;

    private Popover popover;
    private Dialog modal;
    private EventListener modalListener;
    private DropDirection popupPosition = DropDirection.BOTTOM_MIDDLE;

    private PickerStyle pickerStyle;
    private Date value;
    private EventListener keyboardModalListener;
    private MdiIcon timeIcon;
    private DominoElement<HTMLDivElement> timeIconContainer;
    private boolean openOnClick = true;

    public TimeBox() {
        this(null);
    }

    /**
     * @param time {@link Date} initial time
     */
    public TimeBox(Date time) {
        this(null, time);
    }

    /**
     * @param label String field label
     * @param time  {@link Date} initial time
     */
    public TimeBox(String label, Date time) {
        this(label, time, null);
    }

    /**
     * @param label              String field label
     * @param time               {@link Date} initial time
     * @param dateTimeFormatInfo {@link DateTimeFormatInfo} to be used to format the time value in
     *                           the
     *                           text input
     */
    public TimeBox(String label, Date time, DateTimeFormatInfo dateTimeFormatInfo) {
        super();
        setLabel(label);
        if (nonNull(dateTimeFormatInfo)) {
            this.timePicker = TimePicker.create(dateTimeFormatInfo);
        } else {
            this.timePicker = TimePicker.create();
        }
        withValue(time);
        init();
    }

    private void init() {
        this.timePicker.addTimeSelectionHandler(
                (time, dateTimeFormatInfo, picker) -> {
                    Date oldValue = getValue();
                    setStringValue(time, picker);
                    autoValidate();
                    Date newValue = getValue();
                    triggerChangeListeners(oldValue, newValue);
                });
        this.modalListener = evt -> modal.open();
        this.keyboardModalListener =
                event -> {
                    event.stopPropagation();
                    KeyboardEvent keyboardEvent = Js.cast(event);
                    if (keyboardEvent.code.equals("Enter")) {
                        modal.open();
                    } else if (keyboardEvent.code.equals("Escape")) {
                        modal.close();
                    }
                };
        ElementUtil.onDetach(
                element(),
                mutationRecord -> {
                    if (nonNull(popover)) popover.discard();
                    if (nonNull(modal)) {
                        modal.element().remove();
                    }
                });
        timePicker.addCloseHandler(
                () -> {
                    if (nonNull(popover)) popover.close();
                    if (nonNull(modal) && !modal.isHidden()) modal.close();
                });
        timePicker.addClearHandler(() -> withValue(null));
        setPickerStyle(PickerStyle.MODAL);
        appendChild(PrimaryAddOn.of(Icons.clock().clickable()));

    }

    public static TimeBox create() {
        return new TimeBox();
    }

    /**
     * @param time {@link Date} initial time
     * @return new instance
     */
    public static TimeBox create(Date time) {
        return new TimeBox(time);
    }

    /**
     * @param label String field label
     * @param time  {@link Date} initial time
     * @return new instance
     */
    public static TimeBox create(String label, Date time) {
        return new TimeBox(label, time);
    }

    /**
     * @param label              String field label
     * @param time               {@link Date} initial time
     * @param dateTimeFormatInfo {@link DateTimeFormatInfo} to be used to format the time value in
     *                           the
     *                           text input
     */
    public static TimeBox create(String label, Date time, DateTimeFormatInfo dateTimeFormatInfo) {
        return new TimeBox(label, time, dateTimeFormatInfo);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean isEmpty() {
        String stringValue = getStringValue();
        return isNull(stringValue) || stringValue.isEmpty();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean isEmptyIgnoreSpaces() {
        String stringValue = getStringValue();
        return isEmpty() || stringValue.trim().isEmpty();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    protected void doSetValue(Date value) {
        if (nonNull(value)) {
            this.timePicker.setTime(value);
        }
        setStringValue(value, timePicker);
        this.value = value;
    }

    private void setStringValue(Date time, TimePicker picker) {
        if (nonNull(time)) this.getInputElement().element().value = picker.getFormattedTime();
        else this.getInputElement().element().value = "";
        this.value = time;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Date getValue() {
        return this.value;
    }

    @Override
    protected DominoElement<HTMLInputElement> createInputElement(String type) {
        return input("text").setReadOnly(true).toDominoElement();
    }

    @Override
    public String getName() {
        return InputElement.of(getInputElement()).getName();
    }

    @Override
    public TimeBox setName(String name) {
        InputElement.of(getInputElement()).setName(name);
        return this;
    }

    @Override
    public String getType() {
        return "text";
    }

    /**
     * @param pickerStyle {@link PickerStyle}
     * @return same instance
     */
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
                element().removeEventListener(EventType.click.getName(), modalListener);
                element().removeEventListener(EventType.keydown.getName(), keyboardModalListener);
                modal.close();
                modal.element().remove();
            }

//            if (isNull(popover)) {
//                popover = Popover.createPicker(this.element(), this.timePicker.element());
//                popover.getContentElement().style().setPadding("0px", true);
//                popover.getContentElement().style().setWidth("270px", true);
//                popover.position(this.popupPosition).style().setMaxWidth("none", true);
//
//                element()
//                        .addEventListener(
//                                EventType.keydown.getName(),
//                                event -> {
//                                    KeyboardEvent keyboardEvent = Js.cast(event);
//                                    event.stopPropagation();
//                                    if (keyboardEvent.code.equals("Enter")) {
//                                        popover.show();
//                                    } else if (keyboardEvent.code.equals("Escape")) {
//                                        popover.close();
//                                    }
//                                });
//            }
        }

        this.pickerStyle = PickerStyle.POPOVER;
    }

    private void showInModal() {
//        if (!PickerStyle.MODAL.equals(this.pickerStyle)) {
//            if (nonNull(popover)) {
//                this.popover.discard();
//            }
//
//            if (isNull(modal)) {
//                this.modal = Dialog.createPickerModal(getPlaceholder(), this.timePicker.element());
//                DomGlobal.document.body.appendChild(modal.element());
//                element().addEventListener(EventType.click.getName(), modalListener);
//
//                element().addEventListener(EventType.keydown.getName(), keyboardModalListener);
//            }
//        }
//        this.pickerStyle = PickerStyle.MODAL;
    }

    /**
     * @return the {@link TimePicker} of this TimeBox
     */
    public TimePicker getTimePicker() {
        return timePicker;
    }

    /**
     * @param popoverPosition {@link PopupPosition} if the {@link PickerStyle#POPOVER} is used
     * @return same instance
     */
    public TimeBox setPopoverPosition(DropDirection popoverPosition) {
        this.popupPosition = popoverPosition;
        if (nonNull(this.popover)) this.popover.setPosition(this.popupPosition);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public TimeBox disable() {
        disableModal();
        disablePopover();
        return super.disable();
    }

    /**
     * {@inheritDoc}
     */
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

    /**
     * {@inheritDoc}
     */
    @Override
    public TimeBox addChangeListener(ChangeListener<? super Date> changeListener) {
        super.addChangeListener(changeListener);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String getStringValue() {
        return nonNull(value) ? timePicker.getFormattedTime() : "";
    }

    /**
     * @return the {@link MdiIcon} that opens the picker
     */
    public MdiIcon getTimeIcon() {
        return timeIcon;
    }

    /**
     * @param timeIcon the {@link MdiIcon} that opens the picker
     */
    public void setTimeIcon(MdiIcon timeIcon) {
        this.timeIcon = timeIcon;
    }

    /**
     * @return The {@link DominoElement} that contains the time icon
     */
    public DominoElement<HTMLDivElement> getTimeIconContainer() {
        return timeIconContainer;
    }

    /**
     * @param timeIconContainer The {@link DominoElement} that contains the time icon
     */
    public void setTimeIconContainer(DominoElement<HTMLDivElement> timeIconContainer) {
        this.timeIconContainer = timeIconContainer;
    }

    /**
     * @return the an Optional {@link Popover} if {@link PickerStyle#POPOVER} is used
     */
    public Optional<Popover> getPopover() {
        return Optional.of(this.popover);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public TimeBox enable() {
        enableModal();
        enablePopover();
        return super.enable();
    }

    /**
     * @return boolean, true if clicking on the box input element will open the picker
     */
    public boolean isOpenOnClick() {
        return openOnClick;
    }

    /**
     * @param openOnClick boolean, true if clicking on the box input element will open the picker
     * @return same instance
     */
    public TimeBox setOpenOnClick(boolean openOnClick) {
        this.openOnClick = openOnClick;
        element().removeEventListener(EventType.click.getName(), modalListener);
        if (this.openOnClick) {
            element().addEventListener(EventType.click.getName(), modalListener);
        }
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

    @Override
    public String getPlaceholder() {
        return getInputElement().element().placeholder;
    }

    @Override
    public TimeBox setPlaceholder(String placeholder) {
        getInputElement().element().placeholder = placeholder;
        return this;
    }

    /**
     * Enum for time picking styles
     */
    public enum PickerStyle {
        /**
         * Opens the picker in a modal
         *
         */
        MODAL,
        /**
         * Opens the picker in a popover
         *
         * @see Popover
         */
        POPOVER
    }
}
