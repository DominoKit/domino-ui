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

public interface FormsStyles {

  CssClass dui_form_field = () -> "dui-form-field";
  CssClass dui_field_label = () -> "dui-field-label";
  CssClass dui_form_label_float_left = () -> "dui-form-label-float-left";
  CssClass dui_field_body = () -> "dui-form-field-body";
  CssClass dui_input_wrapper = () -> "dui-field-input-wrapper";
  CssClass dui_add_on = () -> "dui-field-addon";
  CssClass dui_add_on_left = () -> "dui-field-addon-left";
  CssClass dui_add_on_right = () -> "dui-field-addon-right";
  CssClass dui_add_on_mandatory = () -> "dui-field-addon-mandatory";
  CssClass dui_field_prefix = () -> "dui-field-prefix";
  CssClass dui_field_postfix = () -> "dui-field-postfix";
  CssClass dui_field_input = () -> "dui-field-input";
  CssClass du_field_counter = () -> "dui-field-counter";
  CssClass dui_messages_wrapper = () -> "dui-field-messages-wrapper";
  CssClass dui_field_helper = () -> "dui-field-helper";
  CssClass dui_field_error = () -> "dui-field-error";
  CssClass dui_field_required_indicator = () -> "dui-field-required-indicator";
  CssClass dui_fixed_errors = () -> "dui-form-messages-fixed";
  CssClass dui_field_invalid = () -> "dui-field-invalid";
  CssClass dui_hidden_input = () -> "dui-field-input-hidden";

  CssClass dui_switch = () -> "dui-form-switch";
  CssClass di_switch_off_label = () -> "dui-switch-off-label";
  CssClass dui_switch_on_label = () -> "dui-switch-on-label";
  CssClass dui_switch_track = () -> "dui-switch-track";
  CssClass dui_field_placeholder = () -> "dui-field-placeholder";
  CssClass dui_form_select = () -> "dui-form-select";
  CssClass dui_form_select_clear = () -> "dui-form-select-clear";
  CssClass dui_form_select_drop_arrow = () -> "dui-form-select-drop-arrow";
  CssClass dui_select_menu = ()-> "dui-select-menu";

  CssClass dui_form_radio_group = () -> "dui-form-radio-group";
  CssClass dui_form_radio = () -> "dui-form-radio";
  CssClass dui_form_radio_label = () -> "dui-radio-label";
  CssClass dui_form_radio_note = () -> "dui-form-radio-note";
  CssClass dui_form_radio_group_vertical = () -> "dui-form-radio-group-vertical";
  CssClass dui_form_radio_group_gap = () -> "dui-form-radio-gap";

  CssClass dui_form_check_box = () -> "dui-form-checkbox";
  CssClass dui_check_box_label = () -> "dui-checkbox-label";
  CssClass dui_check_box_indeterminate = () -> "dui-form-checkbox-indeterminate";
  CssClass dui_check_box_filled = () -> "dui-form-checkbox-filled";
  CssClass dui_switch_grow = () -> "dui-switch-grow";
  CssClass dui_switch_condense = () -> "dui-switch-condense-labels";
  CssClass dui_form_tags_input = () -> "dui-form-tags-input";
  CssClass dui_form_text_area = () -> "dui-form-text-area";
  CssClass dui_form_text_area_header = () -> "dui-form-text-area-header";
  CssClass dui_form_text_area_gap = () -> "dui-text-area-gap";
}
