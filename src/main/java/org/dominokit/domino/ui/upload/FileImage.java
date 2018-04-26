package org.dominokit.domino.ui.upload;

import elemental2.dom.*;
import org.dominokit.domino.ui.icons.Icons;
import org.dominokit.domino.ui.style.Color;
import org.dominokit.domino.ui.style.Styles;
import org.jboss.gwt.elemento.core.Elements;
import org.jboss.gwt.elemento.core.IsElement;

public class FileImage implements IsElement<HTMLDivElement> {

    private HTMLDivElement fileImageContainer;

    public FileImage() {
        initFileContainer();
        HTMLElement icon = Icons.EDITOR_ICONS.insert_drive_file().setColor(Color.GREY).asElement();
        icon.classList.add("md-inactive");
        icon.style.cursor = "default";
        icon.style.fontSize = CSSProperties.FontSizeUnionType.of("100px");
        icon.style.width = CSSProperties.WidthUnionType.of("100%");
        icon.style.textAlign = "center";
        setImage(icon);
    }

    public FileImage(File file) {
        initFileContainer();
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

    private void initFileContainer() {
        fileImageContainer = Elements.div().asElement();
        fileImageContainer.style.height = CSSProperties.HeightUnionType.of("200px");
        fileImageContainer.style.alignItems = "center";
        fileImageContainer.style.display = "flex";
    }

    public static FileImage createImageFile(File file) {
        return new FileImage(file);
    }

    public static FileImage createDefault() {
        return new FileImage();
    }

    @Override
    public HTMLDivElement asElement() {
        return fileImageContainer;
    }

    public FileImage setImage(HTMLElement image) {
        fileImageContainer.appendChild(image);
        return this;
    }
}
