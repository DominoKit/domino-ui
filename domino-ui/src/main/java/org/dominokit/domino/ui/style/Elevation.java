package org.dominokit.domino.ui.style;

import elemental2.dom.HTMLElement;

import static java.util.Objects.nonNull;

public enum Elevation {

    NONE("elevation-none"),
    LEVEL_0("elevation-0"),
    LEVEL_1("elevation-1"),
    LEVEL_2("elevation-2"),
    LEVEL_3("elevation-3"),
    LEVEL_4("elevation-4"),
    LEVEL_5("elevation-5"),
    LEVEL_6("elevation-6"),
    LEVEL_7("elevation-7"),
    LEVEL_8("elevation-8"),
    LEVEL_9("elevation-9"),
    LEVEL_10("elevation-10"),
    LEVEL_11("elevation-11"),
    LEVEL_12("elevation-12"),
    LEVEL_13("elevation-13"),
    LEVEL_14("elevation-14"),
    LEVEL_15("elevation-15"),
    LEVEL_16("elevation-16"),
    LEVEL_17("elevation-17"),
    LEVEL_18("elevation-18"),
    LEVEL_19("elevation-19"),
    LEVEL_20("elevation-20"),
    LEVEL_21("elevation-21"),
    LEVEL_22("elevation-22"),
    LEVEL_23("elevation-23"),
    LEVEL_24("elevation-24");

    private String style;

    Elevation(String style) {
        this.style = style;
    }

    public String getStyle() {
        return style;
    }

    public static Elevation of(int level) {
        switch (level) {
            case 0:
                return LEVEL_0;
            case 1:
                return LEVEL_1;
            case 2:
                return LEVEL_2;
            case 3:
                return LEVEL_3;
            case 4:
                return LEVEL_4;
            case 5:
                return LEVEL_5;
            case 6:
                return LEVEL_6;
            case 7:
                return LEVEL_7;
            case 8:
                return LEVEL_8;
            case 9:
                return LEVEL_9;
            case 10:
                return LEVEL_10;
            case 11:
                return LEVEL_11;
            case 12:
                return LEVEL_12;
            case 13:
                return LEVEL_13;
            case 14:
                return LEVEL_14;
            case 15:
                return LEVEL_15;
            case 16:
                return LEVEL_16;
            case 17:
                return LEVEL_17;
            case 18:
                return LEVEL_18;
            case 19:
                return LEVEL_19;
            case 20:
                return LEVEL_20;
            case 21:
                return LEVEL_21;
            case 22:
                return LEVEL_22;
            case 23:
                return LEVEL_23;
            case 24:
                return LEVEL_24;
            default:
                if (level < 0) {
                    return LEVEL_0;
                } else {
                    return LEVEL_24;
                }
        }
    }

    public static void removeFrom(HTMLElement element){
        String elevationClass = "";
        for (int i = 0; i < element.classList.length; i++) {
            if(element.classList.item(i).startsWith("elevation-")){
                elevationClass = element.classList.item(i);
            }
        }
        if(nonNull(elevationClass) && !elevationClass.isEmpty()){
            element.classList.remove(elevationClass);
        }
    }
}
