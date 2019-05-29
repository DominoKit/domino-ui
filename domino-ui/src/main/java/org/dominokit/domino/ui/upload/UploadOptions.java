package org.dominokit.domino.ui.upload;

import java.util.List;
import java.util.function.Supplier;

public class UploadOptions {
    private String url;
    private double maxFileSize;
    private Supplier<List<Integer>> successCodesProvider;

    public UploadOptions(String url, double maxFileSize, Supplier<List<Integer>> successCodesProvider) {
        this.url = url;
        this.maxFileSize = maxFileSize;
        this.successCodesProvider = successCodesProvider;
    }

    void setUrl(String url) {
        this.url = url;
    }

    public String getUrl() {
        return url;
    }

    public double getMaxFileSize() {
        return maxFileSize;
    }

    public Supplier<List<Integer>> getSuccessCodesProvider() {
        return successCodesProvider;
    }
}
