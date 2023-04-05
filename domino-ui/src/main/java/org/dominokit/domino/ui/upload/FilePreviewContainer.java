package org.dominokit.domino.ui.upload;

import elemental2.dom.HTMLElement;
import org.dominokit.domino.ui.IsElement;

public interface FilePreviewContainer<E extends HTMLElement, T extends FilePreviewContainer<E,T>> extends IsElement<E> {

    T appendChild(FileItem fileItem);

}
