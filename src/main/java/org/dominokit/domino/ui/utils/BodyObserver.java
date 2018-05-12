package org.dominokit.domino.ui.utils;

import elemental2.dom.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static java.util.Objects.isNull;

public class BodyObserver {

    private static List<ElementObserver> removalObservers = new ArrayList<>();
    private static List<ElementObserver> appendObservers = new ArrayList<>();

    static {
        MutationObserver mutationObserver = new MutationObserver((records, observer) -> {
            Arrays.stream(records).forEach(record -> {
                onRemoval(record);
                onAppend(record);

            });
            return null;
        });

        MutationObserverInit mutationObserverInit = MutationObserverInit.create();
        mutationObserverInit.setChildList(true);
        mutationObserverInit.setSubtree(true);

        mutationObserver.observe(DomGlobal.document.body, mutationObserverInit);
    }

    private static void onAppend(MutationRecord record) {
        List<ElementObserver> observed=new ArrayList<>();
        appendObservers.forEach(elementObserver -> {
            if (isNull(elementObserver.observedElement())) {
                observed.add(elementObserver);
            } else {
                if (record.addedNodes.asList().contains(elementObserver.observedElement())) {
                    elementObserver.callback().onObserved(record);
                    observed.add(elementObserver);
                }
            }
        });

        appendObservers.removeAll(observed);
    }

    private static void onRemoval(MutationRecord record) {
        List<ElementObserver> observed=new ArrayList<>();
        removalObservers.forEach(elementObserver -> {
            if (isNull(elementObserver.observedElement())) {
                observed.add(elementObserver);
            } else {
                if (record.removedNodes.asList().contains(elementObserver.observedElement())) {
                    elementObserver.callback().onObserved(record);
                    observed.add(elementObserver);
                }
            }
        });

        removalObservers.removeAll(observed);
    }

    public static void observeRemoval(Node element, ObserveCallback callback) {
        removalObservers.add(new ElementObserver() {
            @Override
            public Node observedElement() {
                return element;
            }

            @Override
            public ObserveCallback callback() {
                return callback;
            }
        });
    }

    public static void observeAppend(Node element, ObserveCallback callback) {
        appendObservers.add(new ElementObserver() {
            @Override
            public Node observedElement() {
                return element;
            }

            @Override
            public ObserveCallback callback() {
                return callback;
            }
        });
    }

    private interface ElementObserver {
        Node observedElement();

        ObserveCallback callback();
    }

    @FunctionalInterface
    public interface ObserveCallback {
        void onObserved(MutationRecord mutationRecord);
    }
}
