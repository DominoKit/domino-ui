package org.dominokit.domino.ui.style;

public interface WavesStyles {
    CssClass dui_waves_float = ()->"dui-waves-float";
    CssClass dui_waves_circle = ()->"dui-waves-circle";
    CssClass dui_waves_ripple = ()->"dui-waves-ripple";
    CssClass dui_waves_block = ()->"dui-waves-block";


    CssClass dui_waves_primary = new ReplaceCssClass(CompositeCssClass.of(
            ()->"dui-waves-info",
            ()->"dui-waves-warning",
            ()->"dui-waves-error",
            ()->"dui-waves-accent",
            ()->"dui-waves-dominant",
            ()->"dui-waves-secondary",
            ()->"dui-waves-success"
    )).replaceWith(()->"dui-waves-primary");
    CssClass dui_waves_secondary = new ReplaceCssClass(CompositeCssClass.of(
            ()->"dui-waves-info",
            ()->"dui-waves-warning",
            ()->"dui-waves-error",
            ()->"dui-waves-accent",
            ()->"dui-waves-dominant",
            ()->"dui-waves-primary",
            ()->"dui-waves-success"
    )).replaceWith(()->"dui-waves-secondary");
    CssClass dui_waves_dominant = new ReplaceCssClass(CompositeCssClass.of(
            ()->"dui-waves-info",
            ()->"dui-waves-warning",
            ()->"dui-waves-error",
            ()->"dui-waves-accent",
            ()->"dui-waves-secondary",
            ()->"dui-waves-primary",
            ()->"dui-waves-success"
    )).replaceWith(()->"dui-waves-dominant");
    CssClass dui_waves_accent = new ReplaceCssClass(CompositeCssClass.of(
            ()->"dui-waves-info",
            ()->"dui-waves-warning",
            ()->"dui-waves-error",
            ()->"dui-waves-dominant",
            ()->"dui-waves-secondary",
            ()->"dui-waves-primary",
            ()->"dui-waves-success"
    )).replaceWith(()->"dui-waves-accent");
    CssClass dui_waves_success = new ReplaceCssClass(CompositeCssClass.of(
            ()->"dui-waves-info",
            ()->"dui-waves-warning",
            ()->"dui-waves-error",
            ()->"dui-waves-accent",
            ()->"dui-waves-dominant",
            ()->"dui-waves-secondary",
            ()->"dui-waves-primary"
    )).replaceWith(()->"dui-waves-success");
    CssClass dui_waves_info = new ReplaceCssClass(CompositeCssClass.of(
            ()->"dui-waves-success",
            ()->"dui-waves-warning",
            ()->"dui-waves-error",
            ()->"dui-waves-accent",
            ()->"dui-waves-dominant",
            ()->"dui-waves-secondary",
            ()->"dui-waves-primary"
    )).replaceWith(()->"dui-waves-info");
    CssClass dui_waves_warning = new ReplaceCssClass(CompositeCssClass.of(
            ()->"dui-waves-success",
            ()->"dui-waves-info",
            ()->"dui-waves-error",
            ()->"dui-waves-accent",
            ()->"dui-waves-dominant",
            ()->"dui-waves-secondary",
            ()->"dui-waves-primary"
    )).replaceWith(()->"dui-waves-warning");
    CssClass dui_waves_error = new ReplaceCssClass(CompositeCssClass.of(
            ()->"dui-waves-success",
            ()->"dui-waves-info",
            ()->"dui-waves-warning",
            ()->"dui-waves-accent",
            ()->"dui-waves-dominant",
            ()->"dui-waves-secondary",
            ()->"dui-waves-primary"
    )).replaceWith(()->"dui-waves-error");

    CssClass dui_waves_red = ()->"dui-waves-red";
    CssClass dui_waves_pink = ()->"dui-waves-pink";
    CssClass dui_waves_purple = ()->"dui-waves-purple";
    CssClass dui_waves_deep_purple = ()->"dui-waves-deep-purple";
    CssClass dui_waves_indigo = ()->"dui-waves-indigo";
    CssClass dui_waves_blue = ()->"dui-waves-blue";
    CssClass dui_waves_light_blue = ()->"dui-waves-light-blue";
    CssClass dui_waves_cyan = ()->"dui-waves-cyan";
    CssClass dui_waves_teal = ()->"dui-waves-teal";
    CssClass dui_waves_green = ()->"dui-waves-green";
    CssClass dui_waves_light_green = ()->"dui-waves-light-green";
    CssClass dui_waves_lime = ()->"dui-waves-lime";
    CssClass dui_waves_yellow = ()->"dui-waves-yellow";
    CssClass dui_waves_amber = ()->"dui-waves-amber";
    CssClass dui_waves_orange = ()->"dui-waves-orange";
    CssClass dui_waves_deep_orange = ()->"dui-waves-deep-orange";
    CssClass dui_waves_brown = ()->"dui-waves-brown";
    CssClass dui_waves_grey = ()->"dui-waves-grey";
    CssClass dui_waves_blue_grey = ()->"dui-waves-blue-grey";
    CssClass dui_waves_white = ()->"dui-waves-white";
    CssClass dui_waves_black = ()->"dui-waves-black";
}
