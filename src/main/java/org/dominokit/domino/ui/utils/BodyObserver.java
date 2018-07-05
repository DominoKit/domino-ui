package org.dominokit.domino.ui.utils;

import elemental2.dom.*;
import jsinterop.base.Js;
import org.jboss.gwt.elemento.core.Elements;

import java.util.ArrayList;
import java.util.List;

import static elemental2.dom.DomGlobal.*;
import static java.util.Objects.isNull;
import static java.util.Objects.nonNull;

public class BodyObserver {

    private static String ATTACH_UID_KEY = "on-attach-uid";
    private static String DETACH_UID_KEY = "on-detach-uid";

    private static List<ElementObserver> removalObservers = new ArrayList<>();
    private static List<ElementObserver> appendObservers = new ArrayList<>();

    static {
        MutationObserver mutationObserver = new MutationObserver((MutationRecord[] records, MutationObserver observer) -> {
            for (int i = 0; i < records.length; i++) {
                onRemoval(records[i]);
                onAppend(records[i]);
            }
            return null;
        });

        MutationObserverInit mutationObserverInit = MutationObserverInit.create();
        mutationObserverInit.setChildList(true);
        mutationObserverInit.setSubtree(true);

        mutationObserver.observe(document.body, mutationObserverInit);
    }

    private BodyObserver() {

    }

    private static void onAppend(MutationRecord record) {
        List<ElementObserver> observed = new ArrayList<>();
        for (int i = 0; i < appendObservers.size(); i++) {
            ElementObserver elementObserver = appendObservers.get(i);
            if (isNull(elementObserver.observedElement())) {
                observed.add(elementObserver);
            } else {
                if (isAppended(elementObserver.attachId())) {
                    elementObserver.callback().onObserved(record);
                    elementObserver.observedElement().removeAttribute(ATTACH_UID_KEY);
                    observed.add(elementObserver);
                }
            }
        }

        appendObservers.removeAll(observed);
    }

    public static boolean isAppended(String attachId) {
        return nonNull(DomGlobal.document.body.querySelector("[" + ATTACH_UID_KEY + "='" + attachId + "']"));
    }

    private static void onRemoval(MutationRecord record) {
        List<ElementObserver> observed = new ArrayList<>();
        for (int i = 0; i < removalObservers.size(); i++) {
            ElementObserver elementObserver = removalObservers.get(i);
            if (isNull(elementObserver.observedElement())) {
                observed.add(elementObserver);
            } else {
                if (record.removedNodes.asList().contains(elementObserver.observedElement()) || isChildOfRemovedNode(record, elementObserver.attachId())) {
                    elementObserver.callback().onObserved(record);
                    elementObserver.observedElement().removeAttribute(DETACH_UID_KEY);
                    observed.add(elementObserver);
                }
            }
        }

        removalObservers.removeAll(observed);
    }

    public static boolean isChildOfRemovedNode(MutationRecord record, final String detachId) {
        List<Node> nodes = record.removedNodes.asList();

        for (int i = 0; i < nodes.size(); i++) {
            Node node = Js.uncheckedCast(nodes.get(i));
            if(Node.ELEMENT_NODE== node.nodeType) {
                if (nonNull(node.querySelector("[" + DETACH_UID_KEY + "='" + detachId + "']"))) {
                    return true;
                }
            }
        }
        return false;
    }

    public static void onDetach(HTMLElement element, ObserverCallback callback) {
        removalObservers.add(createObserver(element, callback, DETACH_UID_KEY));
    }

    public static void onAttach(HTMLElement element, ObserverCallback callback) {
        appendObservers.add(createObserver(element, callback, ATTACH_UID_KEY));
    }

    private static ElementObserver createObserver(HTMLElement element, ObserverCallback callback, String idAttributeName) {
        String elementId=element.getAttribute(idAttributeName);
        if(isNull(elementId)) {
            element.setAttribute(idAttributeName, Elements.createDocumentUniqueId());
        }
        return new ElementObserver() {
            @Override
            public String attachId() {
                return element.getAttribute(idAttributeName);
            }

            @Override
            public HTMLElement observedElement() {
                return element;
            }

            @Override
            public ObserverCallback callback() {
                return callback;
            }
        };
    }

    private interface ElementObserver {

        String attachId();

        HTMLElement observedElement();

        ObserverCallback callback();
    }

    @FunctionalInterface
    public interface ObserverCallback {
        void onObserved(MutationRecord mutationRecord);
    }
}
