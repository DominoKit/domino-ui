package org.dominokit.domino.ui.upload;

import java.util.List;
import java.util.function.Supplier;

/**
 * Options for controlling the upload
 */
public class UploadOptions {
    private String url;
    private final double maxFileSize;
    private final Supplier<List<Integer>> successCodesProvider;

    public UploadOptions(String url, double maxFileSize, Supplier<List<Integer>> successCodesProvider) {
        this.url = url;
        this.maxFileSize = maxFileSize;
        this.successCodesProvider = successCodesProvider;
    }

    /**
     * @param url the server url
     */
    void setUrl(String url) {
        this.url = url;
    }

    /**
     * @return the server url
     */
    public String getUrl() {
        return url;
    }

    /**
     * @return the maximum accepted file size
     */
    public double getMaxFileSize() {
        return maxFileSize;
    }

    /**
     * @return the success codes provider
     */
    public Supplier<List<Integer>> getSuccessCodesProvider() {
        return successCodesProvider;
    }


}
