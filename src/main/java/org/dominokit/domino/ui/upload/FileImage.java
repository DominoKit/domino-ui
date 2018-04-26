package org.dominokit.domino.ui.upload;

import elemental2.dom.*;
import org.dominokit.domino.ui.style.Styles;
import org.jboss.gwt.elemento.core.Elements;
import org.jboss.gwt.elemento.core.IsElement;

public class FileImage implements IsElement<HTMLDivElement> {

    private HTMLDivElement fileImageContainer;

    public FileImage() {
        fileImageContainer = Elements.div().asElement();
        fileImageContainer.style.height = CSSProperties.HeightUnionType.of("200px");
        fileImageContainer.style.alignItems = "center";
        fileImageContainer.style.display = "flex";
    }

    public FileImage(File file) {
        this();
        HTMLImageElement image = Elements.img().css(Styles.img_responsive).asElement();
        image.alt = file.name;
        image.style.maxHeight = CSSProperties.MaxHeightUnionType.of("100%");
        image.style.maxWidth = CSSProperties.MaxWidthUnionType.of("100%");
        image.style.marginRight = CSSProperties.MarginRightUnionType.of("auto");
        image.style.marginLeft = CSSProperties.MarginLeftUnionType.of("auto");
        FileReader fileReader = new FileReader();
        fileReader.addEventListener("load", evt -> image.src = fileReader.result.asString());
        fileReader.readAsDataURL(file);
        setImage(image);
    }

    public static FileImage createImageFile(File file) {
        return new FileImage(file);
    }

    public static FileImage create() {
        return new FileImage();
    }

    @Override
    public HTMLDivElement asElement() {
        return fileImageContainer;
    }

    public FileImage setImage(HTMLImageElement image) {
        fileImageContainer.appendChild(image);
        return this;
    }
}
