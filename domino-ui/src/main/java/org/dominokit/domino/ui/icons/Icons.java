package org.dominokit.domino.ui.icons;

/**
 * A factory class for all icons supported
 */
public class Icons implements ActionIcons, AlertIcons, AvIcons, CommunicationIcons, ContentIcons, DeviceIcons, EditorIcons, HardwareIcons, FileIcons, ImageIcons, MapsIcons, NavigationIcons, NotificationIcons, PlacesIcons, SocialIcons, ToggleIcons, MdiIcons {

    private Icons() {
    }

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
