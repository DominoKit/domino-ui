package org.dominokit.domino.ui.upload;

import elemental2.dom.HTMLElement;
import org.dominokit.domino.ui.IsElement;

public interface IsFilePreview<E extends HTMLElement> extends IsElement<E> {
    void onUploadFailed(String error);
    void onUploadSuccess();
    void onUploadCompleted();
    void onUploadCanceled();
    void onUploadProgress(double progress);
    void onReset();
    void onUploadStarted();

}
