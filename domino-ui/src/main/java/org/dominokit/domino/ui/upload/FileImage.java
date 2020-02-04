package org.dominokit.domino.ui.upload;

import elemental2.dom.*;
import org.dominokit.domino.ui.icons.Icon;
import org.dominokit.domino.ui.icons.Icons;
import org.dominokit.domino.ui.style.Color;
import org.dominokit.domino.ui.style.Styles;
import org.dominokit.domino.ui.utils.BaseDominoElement;
import org.dominokit.domino.ui.utils.DominoElement;

import static org.jboss.elemento.Elements.div;
import static org.jboss.elemento.Elements.img;

public class FileImage extends BaseDominoElement<HTMLDivElement, FileImage> {

    private DominoElement<HTMLDivElement> fileImageContainer;

    public FileImage() {
        initFileContainer();
        Icon icon = Icons.EDITOR_ICONS.insert_drive_file().setColor(Color.GREY);
        icon.style().add("md-inactive");
        icon.style().setCursor("default")
                .setFontSize("100px")
                .setWidth("100%")
                .setTextAlign("center");
        setImage(icon.element());
        init(this);
    }

    public FileImage(File file) {
        initFileContainer();
        DominoElement<HTMLImageElement> image = DominoElement.of(img().css(Styles.img_responsive));
        image.element().alt = file.name;
        image.style().setMaxHeight("100%")
                .setMaxWidth("100%")
                .setMarginRight("auto")
                .setMarginLeft("auto")
                .setFlex("1 1");
        FileReader fileReader = new FileReader();
        fileReader.addEventListener("load", evt -> image.element().src = fileReader.result.asString());
        fileReader.readAsDataURL(file);
        setImage(image.element());
        init(this);
    }

    private void initFileContainer() {
        fileImageContainer = DominoElement.of(div());
        fileImageContainer.style().setHeight("200px")
                .setAlignItems("center")
                .setDisplay("flex");
    }

    public static FileImage createImageFile(File file) {
        return new FileImage(file);
    }

    public static FileImage createDefault() {
        return new FileImage();
    }

    @Override
    public HTMLDivElement element() {
        return fileImageContainer.element();
    }

    public FileImage setImage(HTMLElement image) {
        fileImageContainer.appendChild(image);
        return this;
    }
}
