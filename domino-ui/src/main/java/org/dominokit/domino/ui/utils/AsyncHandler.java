package org.dominokit.domino.ui.utils;

/**
 * a Generic function to apply some logic to any component
 * the caller must call the CompleteHandler.onComplete after finish executing the logic to finalize the process.
 *
 * @param <T> the field
 */
@FunctionalInterface
public interface AsyncHandler<T> {
    /**
     * @param field T the field we apply the logic on
     */
    void apply(T field, CompleteHandler handler);

    @FunctionalInterface
    interface CompleteHandler {
        void onComplete();
    }
}
