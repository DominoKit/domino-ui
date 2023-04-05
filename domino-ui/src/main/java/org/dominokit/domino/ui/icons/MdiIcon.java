/*
 * Copyright © 2019 Dominokit
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.dominokit.domino.ui.icons;

import static org.dominokit.domino.ui.icons.IconsStyles.*;

import elemental2.dom.HTMLElement;
import org.dominokit.domino.ui.style.BooleanCssClass;
import org.dominokit.domino.ui.style.CompositeCssClass;
import org.dominokit.domino.ui.style.CssClass;
import org.dominokit.domino.ui.style.HasCssClass;
import org.dominokit.domino.ui.style.SwapCssClass;

/**
 * <a href="https://materialdesignicons.com/">MDI</a> icons implementation
 */
public class MdiIcon extends Icon<MdiIcon> implements CanChangeIcon<MdiIcon>{

    private MdiMeta metaInfo;
    private SwapCssClass rotateClass = new SwapCssClass();
    private SwapCssClass contrastClass = new SwapCssClass();

    private MdiIcon(HTMLElement icon) {
        this.icon = elementOf(icon);
        init(this);
    }

    private MdiIcon(String icon) {
        this(icon, new MdiMeta(icon.replace("mdi-", "")));
    }

    private MdiIcon(CssClass icon) {
        this(icon, new MdiMeta(icon.getCssClass().replace("mdi-", "")));
    }

    private MdiIcon(String icon, MdiMeta mdiMeta) {
        this(() -> icon, mdiMeta);
    }

    private MdiIcon(CssClass icon, MdiMeta mdiMeta) {
        this();
        this.addCss(icon);
        this.name = SwapCssClass.of(icon);
        this.metaInfo = mdiMeta;
    }

    private MdiIcon() {
        this.icon = i().addCss(dui, dui_mdi).toDominoElement();
        init(this);
    }

    /**
     * Creates a new empty mdi icon
     *
     * @return new instance
     */
    public static MdiIcon create() {
        return new MdiIcon();
    }

    /**
     * Creates a new icon
     *
     * @param icon the name of the icon
     * @return new instance
     */
    public static MdiIcon create(String icon) {
        return new MdiIcon(icon);
    }

    /**
     * Creates a new icon
     *
     * @param icon the name of the icon
     * @return new instance
     */
    public static MdiIcon create(CssClass icon) {
        return new MdiIcon(icon);
    }

    /**
     * Creates a new icon with meta
     *
     * @param icon the icon name
     * @param meta the {@link MdiMeta}
     * @return new instance
     */
    public static MdiIcon create(String icon, MdiMeta meta) {
        return new MdiIcon(icon, meta);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public MdiIcon copy() {
        MdiIcon mdiIcon = MdiIcon.create(this.getName());
        return mdiIcon
                .addCss(SwapCssClass.of(CompositeCssClass.of(mdiIcon)).replaceWith(CompositeCssClass.of(this)));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public MdiIcon changeTo(MdiIcon icon) {
        this.name.replaceWith(icon.name.getCurrent()).apply(this);
        this.name = icon.name;
        return this;
    }

    /**
     * Sets the type of rotate applied to the icon
     *
     * @param mdiRotate the {@link MdiRotate}
     * @return same instance
     */
    public MdiIcon setRotate(MdiRotate mdiRotate) {
        addCss(rotateClass.replaceWith(mdiRotate));
        return this;
    }

    /**
     * Rotates the icon with 45 degrees
     *
     * @return same instance
     */
    public MdiIcon rotate45() {
        return setRotate(MdiRotate.rotate45);
    }

    /**
     * Rotates the icon with 90 degrees
     *
     * @return same instance
     */
    public MdiIcon rotate90() {
        return setRotate(MdiRotate.rotate90);
    }

    /**
     * Rotates the icon with 135 degrees
     *
     * @return same instance
     */
    public MdiIcon rotate135() {
        return setRotate(MdiRotate.rotate135);
    }

    /**
     * Rotates the icon with 180 degrees
     *
     * @return same instance
     */
    public MdiIcon rotate180() {
        return setRotate(MdiRotate.rotate180);
    }

    /**
     * Rotates the icon with 225 degrees
     *
     * @return same instance
     */
    public MdiIcon rotate225() {
        return setRotate(MdiRotate.rotate225);
    }

    /**
     * Rotates the icon with 270 degrees
     *
     * @return same instance
     */
    public MdiIcon rotate270() {
        return setRotate(MdiRotate.rotate270);
    }

    /**
     * Rotates the icon with 315 degrees
     *
     * @return same instance
     */
    public MdiIcon rotate315() {
        return setRotate(MdiRotate.rotate315);
    }

    /**
     * Sets the rotate to the default value
     *
     * @return same instance
     */
    public MdiIcon rotateNone() {
        rotateClass.remove(this);
        return this;
    }

    /**
     * Flips the icon either horizontally or vertically
     *
     * @param mdiFlip the {@link MdiFlip}
     * @return same instance
     */
    public MdiIcon setFlip(MdiFlip mdiFlip) {
        addCss(mdiFlip);
        return this;
    }

    /**
     * Flips the icon vertically
     *
     * @return same instance
     */
    public MdiIcon flipV() {
        return setFlip(MdiFlip.flipV);
    }

    /**
     * Flips the icon horizontally
     *
     * @return same instance
     */
    public MdiIcon flipH() {
        return setFlip(MdiFlip.flipH);
    }

    /**
     * Removes the flip
     *
     * @return same instance
     */
    public MdiIcon flipNone() {
        mdi_flip_v.remove(this);
        mdi_flip_h.remove(this);
        return this;
    }

    /**
     * Sets if the icon should spin
     *
     * @param spin true to spin the icon, false otherwise
     * @return same instance
     */
    public MdiIcon setSpin(boolean spin) {
        addCss(BooleanCssClass.of(mdi_spin, spin));
        return this;
    }

    /**
     * Spins the icon
     *
     * @return same instance
     */
    public MdiIcon spin() {
        return setSpin(true);
    }

    /**
     * Removes the spinning of the icon
     *
     * @return same instance
     */
    public MdiIcon noSpin() {
        return setSpin(false);
    }

    /**
     * Sets if the icon is active or not
     *
     * @param active true to activate the icon, false otherwise
     * @return same instance
     */
    public MdiIcon setActive(boolean active) {
        addCss(BooleanCssClass.of(mdi_inactive, !active));
        return this;
    }

    /**
     * Activate the icon
     *
     * @return same instance
     */
    public MdiIcon active() {
        return setActive(true);
    }

    /**
     * Marks the icon as inactive
     *
     * @return same instance
     */
    public MdiIcon inactive() {
        return setActive(false);
    }

    /**
     * Sets the contrast of the icon
     *
     * @param mdiContrast the {@link MdiContrast}
     * @return same instance
     */
    public MdiIcon setContrast(MdiContrast mdiContrast) {
        addCss(contrastClass.replaceWith(mdiContrast));
        return this;
    }

    /**
     * Sets the contrast as light
     *
     * @return same instance
     */
    public MdiIcon light() {
        return setContrast(MdiContrast.light);
    }

    /**
     * Sets the contrast as dark
     *
     * @return same instance
     */
    public MdiIcon dark() {
        return setContrast(MdiContrast.dark);
    }

    /**
     * Removes the contrast
     *
     * @return same instance
     */
    public MdiIcon noContrast() {
        contrastClass.remove(this);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public HTMLElement element() {
        return icon.element();
    }

    /**
     * An enum representing the rotation degree of the icon
     */
    public enum MdiRotate implements HasCssClass {
        rotate45(IconsStyles.mdi_rotate_45),
        rotate90(IconsStyles.mdi_rotate_90),
        rotate135(IconsStyles.mdi_rotate_135),
        rotate180(IconsStyles.mdi_rotate_180),
        rotate225(IconsStyles.mdi_rotate_225),
        rotate270(IconsStyles.mdi_rotate_270),
        rotate315(IconsStyles.mdi_rotate_315);

        private final CssClass style;

        MdiRotate(CssClass style) {
            this.style = style;
        }

        /**
         * @return The style of the rotation
         */
        public CssClass getCssClass() {
            return style;
        }
    }

    /**
     * An enum representing the flip of the icon
     */
    public enum MdiFlip implements HasCssClass {
        flipV(mdi_flip_v),
        flipH(IconsStyles.mdi_flip_h);

        private final CssClass style;

        MdiFlip(CssClass style) {
            this.style = style;
        }

        /**
         * @return The style of the flip
         */
        public CssClass getCssClass() {
            return style;
        }
    }

    /**
     * @return The {@link MdiMeta} of the icon
     */
    public MdiMeta getMetaInfo() {
        return metaInfo;
    }

    /**
     * An enum representing the contrast of the icon
     */
    public enum MdiContrast implements HasCssClass {
        light(IconsStyles.mdi_light),
        dark(IconsStyles.mdi_dark);

        private final CssClass style;

        MdiContrast(CssClass style) {
            this.style = style;
        }

        /**
         * @return The style of the contrast
         */
        public CssClass getCssClass() {
            return style;
        }
    }
}
