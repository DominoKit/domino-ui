package org.dominokit.domino.ui.style;

public enum Unit{
    px(new UnitFormatter() {
        @Override
        public String format(Number value) {
            return value + "px";
        }
    }),
    q(new UnitFormatter() {
        @Override
        public String format(Number value) {
            return value + "q";
        }
    }),
    mm(new UnitFormatter() {
        @Override
        public String format(Number value) {
            return value + "mm";
        }
    }),
    cm(new UnitFormatter() {
        @Override
        public String format(Number value) {
            return value + "cm";
        }
    }),
    in(new UnitFormatter() {
        @Override
        public String format(Number value) {
            return value + "in";
        }
    }),
    pt(new UnitFormatter() {
        @Override
        public String format(Number value) {
            return value + "pt";
        }
    }),
    pc(new UnitFormatter() {
        @Override
        public String format(Number value) {
            return value + "pc";
        }
    }),
    em(new UnitFormatter() {
        @Override
        public String format(Number value) {
            return value + "em";
        }
    }),
    rem(new UnitFormatter() {
        @Override
        public String format(Number value) {
            return value + "rem";
        }
    }),
    ex(new UnitFormatter() {
        @Override
        public String format(Number value) {
            return value + "ex";
        }
    }),
    ch(new UnitFormatter() {
        @Override
        public String format(Number value) {
            return value + "ch";
        }
    }),
    vw(new UnitFormatter() {
        @Override
        public String format(Number value) {
            return value + "vw";
        }
    }),
    vh(new UnitFormatter() {
        @Override
        public String format(Number value) {
            return value + "vh";
        }
    }),
    none(new UnitFormatter() {
        @Override
        public String format(Number value) {
            return value + "";
        }
    });


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
