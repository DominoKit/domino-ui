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
package org.dominokit.domino.ui.icons;

public interface ToggleIcons {

  default Icon check_box() {
    return Icon.create("check_box");
  }

  default Icon check_box_outline_blank() {
    return Icon.create("check_box_outline_blank");
  }

  default Icon indeterminate_check_box() {
    return Icon.create("indeterminate_check_box");
  }

  default Icon radio_button_checked() {
    return Icon.create("radio_button_checked");
  }

  default Icon radio_button_unchecked() {
    return Icon.create("radio_button_unchecked");
  }

  default Icon star() {
    return Icon.create("star");
  }

  default Icon star_border() {
    return Icon.create("star_border");
  }

  default Icon star_half() {
    return Icon.create("star_half");
  }
}
