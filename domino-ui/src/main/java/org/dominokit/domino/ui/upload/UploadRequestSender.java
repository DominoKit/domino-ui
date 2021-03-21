package org.dominokit.domino.ui.upload;

import elemental2.dom.FormData;
import elemental2.dom.XMLHttpRequest;

/**
 * An interface for sending the upload request
 */
public interface UploadRequestSender {
    /**
     * @param request  the request to be sent
     * @param formData the {@link FormData} to be sent in the request
     */
    void onReady(XMLHttpRequest request, FormData formData);
}
