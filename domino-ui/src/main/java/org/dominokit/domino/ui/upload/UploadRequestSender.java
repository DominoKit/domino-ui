package org.dominokit.domino.ui.upload;

import elemental2.dom.FormData;
import elemental2.dom.XMLHttpRequest;

public interface UploadRequestSender {
    void onReady(XMLHttpRequest request, FormData formData);
}