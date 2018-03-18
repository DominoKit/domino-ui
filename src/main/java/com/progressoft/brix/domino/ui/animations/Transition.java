package com.progressoft.brix.domino.ui.animations;

public enum Transition {

    BOUNCE("bounce", "BOUNCE"),
    FLASH("flash", "FLASH"),
    PULSE("pulse", "PULSE"),
    RUBBER_BAND("rubberBand", "RUBBER BAND"),
    SHAKE("shake", "SHAKE"),
    SWING("swing", "SWING"),
    TADA("tada", "TADA"),
    WOBBLE("wobble", "WOBBLE"),
    JELLO("jello", "JELLO"),
    BOUNCE_IN("bounceIn", "BOUNCE IN"),
    BOUNCE_IN_DOWN("bounceInDown", "BOUNCE IN DOWN"),
    BOUNCE_IN_LEFT("bounceInLeft", "BOUNCE IN LEFT"),
    BOUNCE_IN_RIGHT("bounceInRight", "BOUNCE IN RIGHT"),
    BOUNCE_IN_UP("bounceInUp", "BOUNCE IN UP"),
    BOUNCE_OUT("bounceOut", "BOUNCE OUT"),
    BOUNCE_OUT_DOWN("bounceOutDown", "BOUNCE OUT DOWN"),
    BOUNCE_OUT_LEFT("bounceOutLeft", "BOUNCE OUT LEFT"),
    BOUNCE_OUT_RIGHT("bounceOutRight", "BOUNCE OUT RIGHT"),
    BOUNCE_OUT_UP("bounceOutUp", "BOUNCE OUT UP"),
    FADE_IN("fadeIn", "FADE IN"),
    FADE_IN_DOWN("fadeInDown", "FADE IN DOWN"),
    FADE_IN_DOWN_BIG("fadeInDownBig", "FADE IN DOWN BIG"),
    FADE_IN_LEFT("fadeInLeft", "FADE IN LEFT"),
    FADE_IN_LEFT_BIG("fadeInLeftBig", "FADE IN LEFT BIG"),
    FADE_IN_RIGHT("fadeInRight", "FADE IN RIGHT"),
    FADE_IN_RIGHT_BIG("fadeInRightBig", "FADE IN RIGHT BIG"),
    FADE_IN_UP("fadeInUp", "FADE IN UP"),
    FADE_IN_UP_BIG("fadeInUpBig", "FADE IN UP BIG"),
    FADE_OUT("fadeOut", "FADE OUT"),
    FADE_OUT_DOWN("fadeOutDown", "FADE OUT DOWN"),
    FADE_OUT_DOWN_BIG("fadeOutDownBig", "FADE OUT DOWN BIG"),
    FADE_OUT_LEFT("fadeOutLeft", "FADE OUT LEFT"),
    FADE_OUT_LEFT_BIG("fadeOutLeftBig", "FADE OUT LEFT BIG"),
    FADE_OUT_RIGHT("fadeOutRight", "FADE OUT RIGHT"),
    FADE_OUT_RIGHT_BIG("fadeOutRightBig", "FADE OUT RIGHT BIG"),
    FADE_OUT_UP("fadeOutUp", "FADE OUT UP"),
    FADE_OUT_UP_BIG("fadeOutUpBig", "FADE OUT UP BIG"),
    FLIP("flip", "FLIP"),
    FLIP_IN_X("flipInX", "FLIP IN X"),
    FLIP_IN_Y("flipInY", "FLIP IN Y"),
    FLIP_OUT_X("flipOutX", "FLIP OUT X"),
    FLIP_OUT_Y("flipOutY", "FLIP OUT Y"),
    LIGHT_SPEED_IN("lightSpeedIn", "LIGHT SPEED IN"),
    LIGHT_SPEED_OUT("lightSpeedOut", "LIGHT SPEED OUT"),
    ROTATE_IN("rotateIn", "ROTATE IN"),
    ROTATE_IN_DOWN_LEFT("rotateInDownLeft", "ROTATE IN DOWN LEFT"),
    ROTATE_IN_DOWN_RIGHT("rotateInDownRight", "ROTATE IN DOWN RIGHT"),
    ROTATE_IN_UP_LEFT("rotateInUpLeft", "ROTATE IN UP LEFT"),
    ROTATE_IN_UP_RIGHT("rotateInUpRight", "ROTATE IN UP RIGHT"),
    ROTATE_OUT("rotateOut", "ROTATE OUT"),
    ROTATE_OUT_DOWN_LEFT("rotateOutDownLeft", "ROTATE OUT DOWN LEFT"),
    ROTATE_OUT_DOWN_RIGHT("rotateOutDownRight", "ROTATE OUT DOWN RIGHT"),
    ROTATE_OUT_UP_LEFT("rotateOutUpLeft", "ROTATE OUT UP LEFT"),
    ROTATE_OUT_UP_RIGHT("rotateOutUpRight", "ROTATE OUT UP RIGHT"),
    SLIDE_IN_UP("slideInUp", "SLIDE IN UP"),
    SLIDE_IN_DOWN("slideInDown", "SLIDE IN DOWN"),
    SLIDE_IN_LEFT("slideInLeft", "SLIDE IN LEFT"),
    SLIDE_IN_RIGHT("slideInRight", "SLIDE IN RIGHT"),
    SLIDE_OUT_UP("slideOutUp", "SLIDE OUT UP"),
    SLIDE_OUT_DOWN("slideOutDown", "SLIDE OUT DOWN"),
    SLIDE_OUT_LEFT("slideOutLeft", "SLIDE OUT LEFT"),
    SLIDE_OUT_RIGHT("slideOutRight", "SLIDE OUT RIGHT"),
    ZOOM_IN("zoomIn", "ZOOM IN"),
    ZOOM_IN_DOWN("zoomInDown", "ZOOM IN DOWN"),
    ZOOM_IN_LEFT("zoomInLeft", "ZOOM IN LEFT"),
    ZOOM_IN_RIGHT("zoomInRight", "ZOOM IN RIGHT"),
    ZOOM_IN_UP("zoomInUp", "ZOOM IN UP"),
    ZOOM_OUT("zoomOut", "ZOOM OUT"),
    ZOOM_OUT_DOWN("zoomOutDown", "ZOOM OUT DOWN"),
    ZOOM_OUT_LEFT("zoomOutLeft", "ZOOM OUT LEFT"),
    ZOOM_OUT_RIGHT("zoomOutRight", "ZOOM OUT RIGHT"),
    ZOOM_OUT_UP("zoomOutUp", "ZOOM OUT UP"),
    HINGE("hinge", "HINGE"),
    ROLL_IN("rollIn", "ROLL IN"),
    ROLL_OUT("rollOut", "ROLL OUT");

    private final String style;
    private final String name;


    Transition(String style, String name) {
        this.style = style;
        this.name = name;
    }

    public String getStyle() {
        return style;
    }

    public String getName() {
        return name;
    }
}
