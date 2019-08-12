/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.dominokit.domino.ui.icons;

import com.google.gwt.resources.client.ImageResource;
import static java.util.Objects.nonNull;
import org.dominokit.domino.ui.utils.DominoElement;
import static org.jboss.gwt.elemento.core.Elements.img;

public class ImageResourceIcon extends BaseIcon<ImageResourceIcon> {

    private final ImageResource imageResource;

    private ImageResourceIcon(ImageResource imageResource) {
        this.imageResource = imageResource;
        this.name = imageResource.getName();
        this.icon = DominoElement.of(img(imageResource.getSafeUri().asString()).asElement());
        init(this);
    }

    public static ImageResourceIcon create(ImageResource imageResource) {
        return new ImageResourceIcon(imageResource);
    }

    @Override
    public ImageResourceIcon copy() {
        return new ImageResourceIcon(imageResource);
    }

    @Override
    protected ImageResourceIcon doToggle() {
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
    public ImageResourceIcon changeTo(BaseIcon icon) {
        style.remove(getName());
        style.add(icon.getName());
        return null;
    }

}
