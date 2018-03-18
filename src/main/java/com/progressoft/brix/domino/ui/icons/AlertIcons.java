package com.progressoft.brix.domino.ui.icons;

public interface AlertIcons {
    default Icon add_alert() {
        return Icon.create("add_alert");
    }

    default Icon error() {
        return Icon.create("error");
    }

    default Icon error_outline() {
        return Icon.create("error_outline");
    }

    default Icon warning() {
        return Icon.create("warning");
    }
}
