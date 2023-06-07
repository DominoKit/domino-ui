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
package org.dominokit.domino.ui.notifications;

import org.dominokit.domino.ui.style.CssClass;

/** Default CSS classes for {@link Notification} */
public interface NotificationStyles {

  CssClass dui_notification = () -> "dui-notification";
  CssClass dui_notification_wrapper = () -> "dui-notification-wrapper";
  CssClass dui_ntf_top_left = () -> "dui-ntf-top-left";
  CssClass dui_ntf_top_middle = () -> "dui-ntf-top-middle";
  CssClass dui_ntf_top_right = () -> "dui-ntf-top-right";
  CssClass dui_ntf_bottom_left = () -> "dui-ntf-bottom-left";
  CssClass dui_ntf_bottom_middle = () -> "dui-ntf-bottom-middle";
  CssClass dui_ntf_bottom_right = () -> "dui-ntf-bottom-right";
  CssClass dui_notification_filler = () -> "dui-notification-filler";
}
