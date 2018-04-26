package org.dominokit.domino.ui.upload;

public class UploadOptions {
    private String url;
    private double maxFileSize;

    public UploadOptions(String url, double maxFileSize) {
        this.url = url;
        this.maxFileSize = maxFileSize;
    }

    public String getUrl() {
        return url;
    }

    public double getMaxFileSize() {
        return maxFileSize;
    }
}
