package org.dominokit.domino.ui.icons;

import elemental2.dom.HTMLElement;
import org.dominokit.domino.ui.utils.DominoElement;

import static java.util.Objects.nonNull;
import static org.jboss.gwt.elemento.core.Elements.i;

public class MdiIcon extends BaseIcon<MdiIcon> {
    private MdiSize mdiSize;
    private MdiRotate mdiRotate;
    private MdiFlip mdiFlip;
    private MdiContrast mdiContrast;

    private MdiIcon(HTMLElement icon) {
        this.icon = DominoElement.of(icon);
        init(this);
        size24();
    }

    public static MdiIcon create(String icon) {
        MdiIcon iconElement = new MdiIcon(i().css("mdi").css(icon).asElement());
        iconElement.name = icon;
        return iconElement;
    }

    @Override
    public MdiIcon copy() {
        return MdiIcon.create(this.getName())
                .setColor(this.color);
    }

    @Override
    protected MdiIcon doToggle() {
        if (nonNull(toggleName)) {
            if (this.style.contains(originalName)) {
                this.style.remove(originalName);
                this.style.add(toggleName);
            } else {
                this.style.add(originalName);
                this.style.remove(toggleName);
            }
        }

        return this;
    }

    @Override
    public MdiIcon changeTo(BaseIcon icon) {
        style.remove(getName());
        style.add(icon.getName());
        return null;
    }

    public MdiIcon setSize(MdiSize mdiSize) {
        if (nonNull(this.mdiSize)) {
            style.remove(this.mdiSize.getStyle());
        }
        this.mdiSize = mdiSize;
        style.add(this.mdiSize.getStyle());
        return this;
    }

    public MdiIcon size18() {
        return setSize(MdiSize.mdi18);
    }

    public MdiIcon size24() {
        return setSize(MdiSize.mdi24);
    }

    public MdiIcon size36() {
        return setSize(MdiSize.mdi36);
    }

    public MdiIcon size48() {
        return setSize(MdiSize.mdi48);
    }

    public MdiIcon sizeNone() {
        if (nonNull(this.mdiSize)) {
            style.remove(this.mdiSize.getStyle());
        }
        return this;
    }

    public MdiIcon setRotate(MdiRotate mdiRotate) {
        if (nonNull(this.mdiRotate)) {
            style.remove(this.mdiRotate.getStyle());
        }
        this.mdiRotate = mdiRotate;
        style.add(this.mdiRotate.getStyle());
        return this;
    }

    public MdiIcon rotate45() {
        return setRotate(MdiRotate.rotate45);
    }

    public MdiIcon rotate90() {
        return setRotate(MdiRotate.rotate90);
    }

    public MdiIcon rotate135() {
        return setRotate(MdiRotate.rotate135);
    }

    public MdiIcon rotate180() {
        return setRotate(MdiRotate.rotate180);
    }

    public MdiIcon rotate225() {
        return setRotate(MdiRotate.rotate225);
    }

    public MdiIcon rotate270() {
        return setRotate(MdiRotate.rotate270);
    }

    public MdiIcon rotate315() {
        return setRotate(MdiRotate.rotate315);
    }

    public MdiIcon rotateNone() {
        if (nonNull(this.mdiRotate)) {
            style.remove(this.mdiRotate.getStyle());
        }
        return this;
    }

    public MdiIcon setFlip(MdiFlip mdiFlip) {
        if (nonNull(this.mdiFlip)) {
            style.remove(this.mdiFlip.getStyle());
        }
        this.mdiFlip = mdiFlip;
        style.add(this.mdiFlip.getStyle());
        return this;
    }

    public MdiIcon flipV() {
        return setFlip(MdiFlip.flipV);
    }

    public MdiIcon flipH() {
        return setFlip(MdiFlip.flipH);
    }

    public MdiIcon flipNone() {
        if (nonNull(this.mdiFlip)) {
            style.remove(this.mdiFlip.getStyle());
        }
        return this;
    }

    public MdiIcon setSpin(boolean spin) {
        style.remove("mdi-spin");
        if (spin) {
            style.add("mdi-spin");
        }

        return this;
    }

    public MdiIcon spin() {
        return setSpin(true);
    }

    public MdiIcon noSpin() {
        return setSpin(false);
    }

    public MdiIcon setActive(boolean active) {
        style.remove("mdi-inactive");
        if (!active) {
            style.add("mdi-inactive");
        }

        return this;
    }

    public MdiIcon active() {
        return setActive(true);
    }

    public MdiIcon inactive() {
        return setActive(false);
    }

    public MdiIcon setContrast(MdiContrast mdiContrast) {
        if (nonNull(this.mdiContrast)) {
            style.remove(this.mdiContrast.getStyle());
        }
        this.mdiContrast = mdiContrast;
        style.add(this.mdiContrast.getStyle());
        return this;
    }

    public MdiIcon light() {
        return setContrast(MdiContrast.light);
    }

    public MdiIcon dark() {
        return setContrast(MdiContrast.dark);
    }

    public MdiIcon noContrast() {
        if (nonNull(this.mdiContrast)) {
            style.remove(this.mdiContrast.getStyle());
        }
        return this;
    }

    @Override
    public HTMLElement asElement() {
        return icon.asElement();
    }

    public enum MdiSize {
        mdi18("mdi-18px"),
        mdi24("mdi-24px"),
        mdi36("mdi-36px"),
        mdi48("mdi-48px");

        private final String style;

        MdiSize(String style) {
            this.style = style;
        }

        public String getStyle() {
            return style;
        }
    }

    public enum MdiRotate {
        rotate45("mdi-rotate-45"),
        rotate90("mdi-rotate-90"),
        rotate135("mdi-rotate-135"),
        rotate180("mdi-rotate-180"),
        rotate225("mdi-rotate-225"),
        rotate270("mdi-rotate-270"),
        rotate315("mdi-rotate-315");

        private String style;

        MdiRotate(String style) {
            this.style = style;
        }

        public String getStyle() {
            return style;
        }
    }

    public enum MdiFlip {
        flipV("mdi-flip-v"),
        flipH("mdi-flip-h");

        private String style;

        MdiFlip(String style) {
            this.style = style;
        }

        public String getStyle() {
            return style;
        }
    }

    public enum MdiContrast {

        light("mdi-light"),
        dark("mdi-dark");

        private String style;

        MdiContrast(String style) {
            this.style = style;
        }

        public String getStyle() {
            return style;
        }
    }
}
