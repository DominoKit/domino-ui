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
package org.dominokit.domino.ui.forms;

import org.dominokit.domino.ui.style.CssClass;

/**
 * The `FormsStyles` interface provides a set of CSS classes that can be used to style form elements
 * and components within Domino UI forms.
 */
public interface FormsStyles {

  /** CSS class for a form field container. */
  CssClass dui_form_field = () -> "dui-form-field";

  /** CSS class for a field label. */
  CssClass dui_field_label = () -> "dui-field-label";

  /** CSS class for a floating left-aligned form label. */
  CssClass dui_form_label_float_left = () -> "dui-form-label-float-left";

  /** CSS class for the body of a form field. */
  CssClass dui_field_body = () -> "dui-form-field-body";

  /** CSS class for the wrapper of an input element. */
  CssClass dui_input_wrapper = () -> "dui-field-input-wrapper";

  /** CSS class for an input add-on. */
  CssClass dui_add_on = () -> "dui-field-addon";

  /** CSS class for a left-aligned input add-on. */
  CssClass dui_add_on_left = () -> "dui-field-addon-left";

  /** CSS class for a right-aligned input add-on. */
  CssClass dui_add_on_right = () -> "dui-field-addon-right";

  /** CSS class for a mandatory input add-on. */
  CssClass dui_add_on_mandatory = () -> "dui-field-addon-mandatory";

  /** CSS class for a prefix element within a form field. */
  CssClass dui_field_prefix = () -> "dui-field-prefix";

  /** CSS class for a postfix element within a form field. */
  CssClass dui_field_postfix = () -> "dui-field-postfix";

  /** CSS class for the main input element within a form field. */
  CssClass dui_field_input = () -> "dui-field-input";

  /** CSS class for a field counter. */
  CssClass du_field_counter = () -> "dui-field-counter";

  /** CSS class for the wrapper of messages within a form field. */
  CssClass dui_messages_wrapper = () -> "dui-field-messages-wrapper";

  /** CSS class for a field helper text. */
  CssClass dui_field_helper = () -> "dui-field-helper";

  /** CSS class for a field error message. */
  CssClass dui_field_error = () -> "dui-field-error";

  /** CSS class for indicating a required field. */
  CssClass dui_field_required_indicator = () -> "dui-field-required-indicator";

  /** CSS class for fixed error messages within a form field. */
  CssClass dui_fixed_errors = () -> "dui-form-messages-fixed";

  /** CSS class for marking a field as invalid. */
  CssClass dui_field_invalid = () -> "dui-field-invalid";

  /** CSS class for a hidden input element within a form field. */
  CssClass dui_hidden_input = () -> "dui-field-input-hidden";

  /** CSS class for a form switch component. */
  CssClass dui_switch = () -> "dui-form-switch";

  /** CSS class for the label of an off-state switch. */
  CssClass di_switch_off_label = () -> "dui-switch-off-label";

  /** CSS class for the label of an on-state switch. */
  CssClass dui_switch_on_label = () -> "dui-switch-on-label";

  /** CSS class for the track of a switch component. */
  CssClass dui_switch_track = () -> "dui-switch-track";

  /** CSS class for a form field placeholder. */
  CssClass dui_field_placeholder = () -> "dui-field-placeholder";

  /** CSS class for a form select component. */
  CssClass dui_form_select = () -> "dui-form-select";

  /** CSS class for the clear button of a form select component. */
  CssClass dui_form_select_clear = () -> "dui-form-select-clear";

  /** CSS class for the drop arrow of a form select component. */
  CssClass dui_form_select_drop_arrow = () -> "dui-form-select-drop-arrow";

  /** CSS class for a select menu. */
  CssClass dui_select_menu = () -> "dui-select-menu";

  /** CSS class for a radio button group within a form. */
  CssClass dui_form_radio_group = () -> "dui-form-radio-group";

  /** CSS class for a radio button within a radio group. */
  CssClass dui_form_radio = () -> "dui-form-radio";

  /** CSS class for a label of a radio button. */
  CssClass dui_form_radio_label = () -> "dui-radio-label";

  /** CSS class for a note associated with a radio button. */
  CssClass dui_form_radio_note = () -> "dui-form-radio-note";

  /** CSS class for a vertically aligned radio button group. */
  CssClass dui_form_radio_group_vertical = () -> "dui-form-radio-group-vertical";

  /** CSS class for specifying the gap between radio buttons within a group. */
  CssClass dui_form_radio_group_gap = () -> "dui-form-radio-gap";

  /** CSS class for a checkbox within a form. */
  CssClass dui_form_check_box = () -> "dui-form-checkbox";

  /** CSS class for a checkbox within a select component. */
  CssClass dui_form_select_check_box = () -> "dui-form-select-checkbox";

  /** CSS class for the label of a checkbox. */
  CssClass dui_check_box_label = () -> "dui-checkbox-label";

  /** CSS class for an indeterminate checkbox state. */
  CssClass dui_check_box_indeterminate = () -> "dui-form-checkbox-indeterminate";

  /** CSS class for a filled checkbox. */
  CssClass dui_check_box_filled = () -> "dui-form-checkbox-filled";

  /** CSS class for expanding switch labels. */
  CssClass dui_switch_grow = () -> "dui-switch-grow";

  /** CSS class for condensing switch labels. */
  CssClass dui_switch_condense = () -> "dui-switch-condense-labels";

  /** CSS class for a tags input component within a form. */
  CssClass dui_form_tags_input = () -> "dui-form-tags-input";

  /** CSS class for a text area within a form. */
  CssClass dui_form_text_area = () -> "dui-form-text-area";

  /** CSS class for the header of a text area. */
  CssClass dui_form_text_area_header = () -> "dui-form-text-area-header";

  /** CSS class for specifying the gap within a text area. */
  CssClass dui_form_text_area_gap = () -> "dui-text-area-gap";
}
