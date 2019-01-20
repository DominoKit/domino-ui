package org.dominokit.domino.ui.style;

public enum Unit{
    px(value -> value+"px"),
    q(value -> value+"q"),
    mm(value -> value+"mm"),
    cm(value -> value+"cm"),
    in(value -> value+"in"),
    pt(value -> value+"pt"),
    pc(value -> value+"pc"),
    em(value -> value+"em"),
    rem(value -> value+"rem"),
    ex(value -> value+"ex"),
    ch(value -> value+"ch"),
    vw(value -> value+"vw"),
    vh(value -> value+"vh"),
    percent(value -> value+"%"),
    none(value -> value+"");


    private final UnitFormatter unitFormatter;

    Unit(UnitFormatter unitFormatter) {
        this.unitFormatter = unitFormatter;
    }

    public String of(Number value) {
        return unitFormatter.format(value);
    }

    @FunctionalInterface
    public interface UnitFormatter{
        String format(Number value);
    }
}
