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

import static java.util.Objects.isNull;
import static java.util.Objects.nonNull;
import static org.jboss.elemento.Elements.input;

import elemental2.dom.*;
import java.util.Date;
import java.util.Optional;
import jsinterop.base.Js;
import org.dominokit.domino.ui.forms.ValueBox;
import org.dominokit.domino.ui.forms.validations.InputAutoValidator;
import org.dominokit.domino.ui.grid.flex.FlexItem;
import org.dominokit.domino.ui.icons.Icons;
import org.dominokit.domino.ui.icons.MdiIcon;
import org.dominokit.domino.ui.modals.ModalDialog;
import org.dominokit.domino.ui.popover.Popover;
import org.dominokit.domino.ui.popover.PopupPosition;
import org.dominokit.domino.ui.utils.ElementUtil;
import org.gwtproject.i18n.shared.cldr.DateTimeFormatInfo;
import org.jboss.elemento.EventType;

/** A form element that takes and provide date value as time */
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
  private boolean openOnClick = true;

  public TimeBox() {
    this(null);
  }

  /** @param time {@link Date} initial time */
  public TimeBox(Date time) {
    this(null, time);
  }

  /**
   * @param label String field label
   * @param time {@link Date} initial time
   */
  public TimeBox(String label, Date time) {
    this(label, time, null);
  }

  /**
   * @param label String field label
   * @param time {@link Date} initial time
   * @param dateTimeFormatInfo {@link DateTimeFormatInfo} to be used to format the time value in the
   *     text input
   */
  public TimeBox(String label, Date time, DateTimeFormatInfo dateTimeFormatInfo) {
    super("text", label);
    if (nonNull(dateTimeFormatInfo)) this.timePicker = TimePicker.create(dateTimeFormatInfo);
    else this.timePicker = TimePicker.create();
    value(time);
    init();
  }

  private void init() {
    this.timePicker.addTimeSelectionHandler(
        (time, dateTimeFormatInfo, picker) -> {
          setStringValue(time, picker);
          changeLabelFloating();
          autoValidate();
          callChangeHandlers();
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
          if (nonNull(modal) && modal.isOpen()) modal.close();
        });
    timePicker.addClearHandler(() -> value(null));
    setPickerStyle(PickerStyle.MODAL);
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
   * @param time {@link Date} initial time
   * @return new instance
   */
  public static TimeBox create(String label, Date time) {
    return new TimeBox(label, time);
  }

  /**
   * @param label String field label
   * @param time {@link Date} initial time
   * @param dateTimeFormatInfo {@link DateTimeFormatInfo} to be used to format the time value in the
   *     text input
   */
  public static TimeBox create(String label, Date time, DateTimeFormatInfo dateTimeFormatInfo) {
    return new TimeBox(label, time, dateTimeFormatInfo);
  }

  /** {@inheritDoc} */
  @Override
  public boolean isEmpty() {
    String stringValue = getStringValue();
    return isNull(stringValue) || stringValue.isEmpty();
  }

  /** {@inheritDoc} */
  @Override
  protected void clearValue() {
    value(null);
  }

  /** {@inheritDoc} */
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

  /** {@inheritDoc} */
  @Override
  public Date getValue() {
    return this.value;
  }

  /** {@inheritDoc} */
  @Override
  public String getPlaceholder() {
    return getInputElement().element().placeholder;
  }

  /** {@inheritDoc} */
  @Override
  protected HTMLInputElement createInputElement(String type) {
    return input("text").attr("readOnly", "true").element();
  }

  /** {@inheritDoc} */
  @Override
  public TimeBox setPlaceholder(String placeholder) {
    getInputElement().element().placeholder = placeholder;
    return this;
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

      if (isNull(popover)) {
        popover = Popover.createPicker(this.element(), this.timePicker.element());
        popover.getContentElement().style().setPadding("0px", true);
        popover.getContentElement().style().setWidth("270px", true);
        popover.position(this.popupPosition).style().setMaxWidth("none", true);

        element()
            .addEventListener(
                EventType.keydown.getName(),
                event -> {
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
        this.modal = ModalDialog.createPickerModal(getPlaceholder(), this.timePicker.element());
        DomGlobal.document.body.appendChild(modal.element());
        element().addEventListener(EventType.click.getName(), modalListener);

        element().addEventListener(EventType.keydown.getName(), keyboardModalListener);
      }
    }
    this.pickerStyle = PickerStyle.MODAL;
  }

  /** @return the {@link TimePicker} of this TimeBox */
  public TimePicker getTimePicker() {
    return timePicker;
  }

  /**
   * @param popoverPosition {@link PopupPosition} if the {@link PickerStyle#POPOVER} is used
   * @return same instance
   */
  public TimeBox setPopoverPosition(PopupPosition popoverPosition) {
    this.popupPosition = popoverPosition;
    if (nonNull(this.popover)) this.popover.position(this.popupPosition);
    return this;
  }

  /** {@inheritDoc} */
  @Override
  public TimeBox disable() {
    disableModal();
    disablePopover();
    return super.disable();
  }

  /** {@inheritDoc} */
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

  /** {@inheritDoc} */
  @Override
  public TimeBox addChangeHandler(ChangeHandler<? super Date> changeHandler) {
    super.addChangeHandler(changeHandler);
    return this;
  }

  /** {@inheritDoc} */
  @Override
  public String getStringValue() {
    return nonNull(value) ? timePicker.getFormattedTime() : "";
  }

  /** {@inheritDoc} */
  @Override
  protected AutoValidator createAutoValidator(AutoValidate autoValidate) {
    return new InputAutoValidator<>(getInputElement(), autoValidate);
  }

  /** {@inheritDoc} */
  @Override
  protected FlexItem createMandatoryAddOn() {
    timeIcon = Icons.ALL.clock_mdi();
    timeIcon.clickable();
    timeIconContainer = FlexItem.create();
    return timeIconContainer.appendChild(timeIcon);
  }

  /** @return the {@link MdiIcon} that opens the picker */
  public MdiIcon getTimeIcon() {
    return timeIcon;
  }

  /** @param timeIcon the {@link MdiIcon} that opens the picker */
  public void setTimeIcon(MdiIcon timeIcon) {
    this.timeIcon = timeIcon;
  }

  /** @return The {@link FlexItem} that contains the time icon */
  public FlexItem getTimeIconContainer() {
    return timeIconContainer;
  }

  /** @param timeIconContainer The {@link FlexItem} that contains the time icon */
  public void setTimeIconContainer(FlexItem timeIconContainer) {
    this.timeIconContainer = timeIconContainer;
  }

  /** @return the an Optional {@link ModalDialog} if {@link PickerStyle#MODAL} is used */
  public Optional<ModalDialog> getModal() {
    return Optional.of(this.modal);
  }

  /** @return the an Optional {@link Popover} if {@link PickerStyle#POPOVER} is used */
  public Optional<Popover> getPopover() {
    return Optional.of(this.popover);
  }

  /** {@inheritDoc} */
  @Override
  public TimeBox enable() {
    enableModal();
    enablePopover();
    return super.enable();
  }

  /** @return boolean, true if clicking on the box input element will open the picker */
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

  /** Enum for time picking styles */
  public enum PickerStyle {
    /**
     * Opens the picker in a modal
     *
     * @see org.dominokit.domino.ui.modals.BaseModal.Modal
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
