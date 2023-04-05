package org.dominokit.domino.ui.i18n;

public interface UploadLabels extends Labels {

    default String getDefaultUploadSuccessMessage(){
        return "Upload completed.";
    }
    default String getDefaultUploadCanceledMessage(){
        return "Upload canceled.";
    }

    default String getMaxFileErrorMessage(int maxFiles, int current){
        return "The maximum allowed uploads is : "+maxFiles+", You have "+current;
    }
}
