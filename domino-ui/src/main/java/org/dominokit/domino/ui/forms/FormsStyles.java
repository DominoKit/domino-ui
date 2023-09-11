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

/** FormsStyles interface. */
public interface FormsStyles {

  /** Constant <code>dui_form_field</code> */
  CssClass dui_form_field = () -> "dui-form-field";
  /** Constant <code>dui_field_label</code> */
  CssClass dui_field_label = () -> "dui-field-label";
  /** Constant <code>dui_form_label_float_left</code> */
  CssClass dui_form_label_float_left = () -> "dui-form-label-float-left";
  /** Constant <code>dui_field_body</code> */
  CssClass dui_field_body = () -> "dui-form-field-body";
  /** Constant <code>dui_input_wrapper</code> */
  CssClass dui_input_wrapper = () -> "dui-field-input-wrapper";
  /** Constant <code>dui_add_on</code> */
  CssClass dui_add_on = () -> "dui-field-addon";
  /** Constant <code>dui_add_on_left</code> */
  CssClass dui_add_on_left = () -> "dui-field-addon-left";
  /** Constant <code>dui_add_on_right</code> */
  CssClass dui_add_on_right = () -> "dui-field-addon-right";
  /** Constant <code>dui_add_on_mandatory</code> */
  CssClass dui_add_on_mandatory = () -> "dui-field-addon-mandatory";
  /** Constant <code>dui_field_prefix</code> */
  CssClass dui_field_prefix = () -> "dui-field-prefix";
  /** Constant <code>dui_field_postfix</code> */
  CssClass dui_field_postfix = () -> "dui-field-postfix";
  /** Constant <code>dui_field_input</code> */
  CssClass dui_field_input = () -> "dui-field-input";
  /** Constant <code>du_field_counter</code> */
  CssClass du_field_counter = () -> "dui-field-counter";
  /** Constant <code>dui_messages_wrapper</code> */
  CssClass dui_messages_wrapper = () -> "dui-field-messages-wrapper";
  /** Constant <code>dui_field_helper</code> */
  CssClass dui_field_helper = () -> "dui-field-helper";
  /** Constant <code>dui_field_error</code> */
  CssClass dui_field_error = () -> "dui-field-error";
  /** Constant <code>dui_field_required_indicator</code> */
  CssClass dui_field_required_indicator = () -> "dui-field-required-indicator";
  /** Constant <code>dui_fixed_errors</code> */
  CssClass dui_fixed_errors = () -> "dui-form-messages-fixed";
  /** Constant <code>dui_field_invalid</code> */
  CssClass dui_field_invalid = () -> "dui-field-invalid";
  /** Constant <code>dui_hidden_input</code> */
  CssClass dui_hidden_input = () -> "dui-field-input-hidden";

  /** Constant <code>dui_switch</code> */
  CssClass dui_switch = () -> "dui-form-switch";
  /** Constant <code>di_switch_off_label</code> */
  CssClass di_switch_off_label = () -> "dui-switch-off-label";
  /** Constant <code>dui_switch_on_label</code> */
  CssClass dui_switch_on_label = () -> "dui-switch-on-label";
  /** Constant <code>dui_switch_track</code> */
  CssClass dui_switch_track = () -> "dui-switch-track";
  /** Constant <code>dui_field_placeholder</code> */
  CssClass dui_field_placeholder = () -> "dui-field-placeholder";
  /** Constant <code>dui_form_select</code> */
  CssClass dui_form_select = () -> "dui-form-select";
  /** Constant <code>dui_form_select_clear</code> */
  CssClass dui_form_select_clear = () -> "dui-form-select-clear";
  /** Constant <code>dui_form_select_drop_arrow</code> */
  CssClass dui_form_select_drop_arrow = () -> "dui-form-select-drop-arrow";
  /** Constant <code>dui_select_menu</code> */
  CssClass dui_select_menu = () -> "dui-select-menu";

  /** Constant <code>dui_form_radio_group</code> */
  CssClass dui_form_radio_group = () -> "dui-form-radio-group";
  /** Constant <code>dui_form_radio</code> */
  CssClass dui_form_radio = () -> "dui-form-radio";
  /** Constant <code>dui_form_radio_label</code> */
  CssClass dui_form_radio_label = () -> "dui-radio-label";
  /** Constant <code>dui_form_radio_note</code> */
  CssClass dui_form_radio_note = () -> "dui-form-radio-note";
  /** Constant <code>dui_form_radio_group_vertical</code> */
  CssClass dui_form_radio_group_vertical = () -> "dui-form-radio-group-vertical";
  /** Constant <code>dui_form_radio_group_gap</code> */
  CssClass dui_form_radio_group_gap = () -> "dui-form-radio-gap";

  /** Constant <code>dui_form_check_box</code> */
  CssClass dui_form_check_box = () -> "dui-form-checkbox";
  /** Constant <code>dui_form_select_check_box</code> */
  CssClass dui_form_select_check_box = () -> "dui-form-select-checkbox";
  /** Constant <code>dui_check_box_label</code> */
  CssClass dui_check_box_label = () -> "dui-checkbox-label";
  /** Constant <code>dui_check_box_indeterminate</code> */
  CssClass dui_check_box_indeterminate = () -> "dui-form-checkbox-indeterminate";
  /** Constant <code>dui_check_box_filled</code> */
  CssClass dui_check_box_filled = () -> "dui-form-checkbox-filled";
  /** Constant <code>dui_switch_grow</code> */
  CssClass dui_switch_grow = () -> "dui-switch-grow";
  /** Constant <code>dui_switch_condense</code> */
  CssClass dui_switch_condense = () -> "dui-switch-condense-labels";
  /** Constant <code>dui_form_tags_input</code> */
  CssClass dui_form_tags_input = () -> "dui-form-tags-input";
  /** Constant <code>dui_form_text_area</code> */
  CssClass dui_form_text_area = () -> "dui-form-text-area";
  /** Constant <code>dui_form_text_area_header</code> */
  CssClass dui_form_text_area_header = () -> "dui-form-text-area-header";
  /** Constant <code>dui_form_text_area_gap</code> */
  CssClass dui_form_text_area_gap = () -> "dui-text-area-gap";
}
