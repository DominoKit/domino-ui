package org.dominokit.domino.ui.config;

import org.dominokit.domino.ui.icons.Icon;
import org.dominokit.domino.ui.icons.Icons;
import org.dominokit.domino.ui.upload.DefaultFilePreview;
import org.dominokit.domino.ui.upload.DefaultFilePreviewContainer;
import org.dominokit.domino.ui.upload.FilePreviewContainer;
import org.dominokit.domino.ui.upload.FilePreviewFactory;

import java.util.function.Supplier;

public interface UploadConfig extends ComponentConfig {

    default Supplier<Icon<?>> getDefaultUploadIcon(){
        return Icons.ALL::upload_mdi;
    }

    default Supplier<Icon<?>> getDefaultRemoveIcon(){
        return Icons.ALL::trash_can_mdi;
    }

    default Supplier<Icon<?>> getDefaultCancelIcon(){
        return Icons.ALL::cancel_mdi;
    }

    default FilePreviewFactory getFilePreviewFactory(){
        return DefaultFilePreview::new;
    }

    default Supplier<FilePreviewContainer<?,?>> getDefaultFilePreviewContainer(){
        return DefaultFilePreviewContainer::new;
    }

}
