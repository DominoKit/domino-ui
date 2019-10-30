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

    private MdiMeta metaInfo;

    private MdiIcon(HTMLElement icon) {
        this.icon = DominoElement.of(icon);
        init(this);
        size24();
    }

    private MdiIcon(String icon) {
        this(icon, new MdiMeta(icon.replace("mdi-", "")));
    }

    private MdiIcon(String icon, MdiMeta mdiMeta) {
        this.icon = DominoElement.of(i().css("mdi").css(icon).asElement());
        this.name = icon;
        this.metaInfo = mdiMeta;
        init(this);
        size24();
    }

    public static MdiIcon create(String icon) {
        return new MdiIcon(icon);
    }

    public static MdiIcon create(String icon, MdiMeta meta) {
        return new MdiIcon(icon, meta);
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
        return this;
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
        mdi18(IconsStyles.MDI_18_PX),
        mdi24(IconsStyles.MDI_24_PX),
        mdi36(IconsStyles.MDI_36_PX),
        mdi48(IconsStyles.MDI_48_PX);

        private final String style;

        MdiSize(String style) {
            this.style = style;
        }

        public String getStyle() {
            return style;
        }
    }

    public enum MdiRotate {
        rotate45(IconsStyles.MDI_ROTATE_45),
        rotate90(IconsStyles.MDI_ROTATE_90),
        rotate135(IconsStyles.MDI_ROTATE_135),
        rotate180(IconsStyles.MDI_ROTATE_180),
        rotate225(IconsStyles.MDI_ROTATE_225),
        rotate270(IconsStyles.MDI_ROTATE_270),
        rotate315(IconsStyles.MDI_ROTATE_315);

        private String style;

        MdiRotate(String style) {
            this.style = style;
        }

        public String getStyle() {
            return style;
        }
    }

    public enum MdiFlip {
        flipV(IconsStyles.MDI_FLIP_V),
        flipH(IconsStyles.MDI_FLIP_H);

        private String style;

        MdiFlip(String style) {
            this.style = style;
        }

        public String getStyle() {
            return style;
        }
    }

    public MdiMeta getMetaInfo() {
        return metaInfo;
    }

    public enum MdiContrast {

        light(IconsStyles.MDI_LIGHT),
        dark(IconsStyles.MDI_DARK);

        private String style;

        MdiContrast(String style) {
            this.style = style;
        }

        public String getStyle() {
            return style;
        }
    }
}
