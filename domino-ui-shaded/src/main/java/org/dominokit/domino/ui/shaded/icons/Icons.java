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
package org.dominokit.domino.ui.shaded.icons;

/** A factory class for all icons supported */
@Deprecated
public class Icons
    implements ActionIcons,
        AlertIcons,
        AvIcons,
        CommunicationIcons,
        ContentIcons,
        DeviceIcons,
        EditorIcons,
        HardwareIcons,
        FileIcons,
        ImageIcons,
        MapsIcons,
        NavigationIcons,
        NotificationIcons,
        PlacesIcons,
        SocialIcons,
        ToggleIcons,
        MdiIcons {

  private Icons() {}

  public static final Icons ALL = new Icons();

  public static final ActionIcons ACTION_ICONS = ALL;
  public static final AlertIcons ALERT_ICONS = ALL;
  public static final AvIcons AV_ICONS = ALL;
  public static final CommunicationIcons COMMUNICATION_ICONS = ALL;
  public static final ContentIcons CONTENT_ICONS = ALL;
  public static final DeviceIcons DEVICE_ICONS = ALL;
  public static final EditorIcons EDITOR_ICONS = ALL;
  public static final FileIcons FILE_ICONS = ALL;
  public static final HardwareIcons HARDWARE_ICONS = ALL;
  public static final ImageIcons IMAGE_ICONS = ALL;
  public static final MapsIcons MAPS_ICONS = ALL;
  public static final NavigationIcons NAVIGATION_ICONS = ALL;
  public static final NotificationIcons NOTIFICATION_ICONS = ALL;
  public static final PlacesIcons PLACES_ICONS = ALL;
  public static final SocialIcons SOCIAL_ICONS = ALL;
  public static final ToggleIcons TOGGLE_ICONS = ALL;
  public static final MdiIcons MDI_ICONS = ALL;

  /**
   * A factory method which creates icon based on the {@code name}
   *
   * @param name the name of the icon
   * @return new instance
   */
  public static BaseIcon<?> of(String name) {
    if (name.startsWith("mdi")) {
      return MdiIcon.create(name);
    }
    return Icon.create(name);
  }
}
