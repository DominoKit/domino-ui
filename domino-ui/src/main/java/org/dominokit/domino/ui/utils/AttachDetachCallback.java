package org.dominokit.domino.ui.utils;

import elemental2.dom.MutationRecord;

@FunctionalInterface
public interface AttachDetachCallback {
    void onObserved(MutationRecord mutationRecord);
}