package org.dominokit.domino.ui.utils;

import elemental2.dom.*;

import java.util.ArrayList;
import java.util.List;

import static java.util.Objects.isNull;

public class BodyObserver {

    private static List<ElementObserver> removalObservers = new ArrayList<>();
    private static List<ElementObserver> appendObservers = new ArrayList<>();

    static {
        MutationObserver mutationObserver = new MutationObserver((MutationRecord[] records, MutationObserver observer) -> {
            for (int i=0;i<records.length;i++){
                onRemoval(records[i]);
                onAppend(records[i]);
            }
            return null;
        });

        MutationObserverInit mutationObserverInit = MutationObserverInit.create();
        mutationObserverInit.setChildList(true);
        mutationObserverInit.setSubtree(true);

        mutationObserver.observe(DomGlobal.document.body, mutationObserverInit);
    }

    private static void onAppend(MutationRecord record) {
        List<ElementObserver> observed=new ArrayList<>();
        for(int i=0;i<appendObservers.size(); i++){
            ElementObserver elementObserver=appendObservers.get(i);
            if (isNull(elementObserver.observedElement())) {
                observed.add(elementObserver);
            } else {
                if (record.addedNodes.asList().contains(elementObserver.observedElement())) {
                    elementObserver.callback().onObserved(record);
                    observed.add(elementObserver);
                }
            }
        }

        appendObservers.removeAll(observed);
    }

    private static void onRemoval(MutationRecord record) {
        List<ElementObserver> observed=new ArrayList<>();
        for(int i=0;i<removalObservers.size(); i++) {
            ElementObserver elementObserver=removalObservers.get(i);
            if (isNull(elementObserver.observedElement())) {
                observed.add(elementObserver);
            } else {
                if (record.removedNodes.asList().contains(elementObserver.observedElement())) {
                    elementObserver.callback().onObserved(record);
                    observed.add(elementObserver);
                }
            }
        }

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
