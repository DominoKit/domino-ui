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
