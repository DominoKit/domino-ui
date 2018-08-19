package org.dominokit.domino.ui.search;

import com.google.gwt.core.client.Scheduler;
import elemental2.dom.HTMLDivElement;
import elemental2.dom.HTMLElement;
import elemental2.dom.HTMLInputElement;
import jsinterop.base.Js;
import org.dominokit.domino.ui.style.Style;
import org.dominokit.domino.ui.utils.ElementUtil;
import org.gwtproject.timer.client.Timer;
import org.jboss.gwt.elemento.core.EventType;
import org.jboss.gwt.elemento.core.IsElement;

import static org.jboss.gwt.elemento.core.Elements.*;

public class Search implements IsElement<HTMLDivElement> {
    private final HTMLElement closeIcon = i().css("material-icons").textContent("close").asElement();
    private final HTMLInputElement searchInput = input("text").attr("placeholder", "START TYPING...").asElement();
    private HTMLDivElement element = div()
            .css("search-bar")
            .add(div().css("search-icon")
                    .add(i().css("material-icons").textContent("search")))
            .add(searchInput)
            .add(div().css("close-search")
                    .add(closeIcon))
            .asElement();

    private SearchHandler searchHandler = searchToken -> {
    };
    private SearchCloseHandler closeHandler = () -> {
    };
    private final boolean autoSearch;

    private Timer autoSearchTimer;

    public Search(boolean autoSearch) {
        this.autoSearch = autoSearch;
        this.closeIcon.addEventListener("click", evt -> {
            evt.stopPropagation();
            close();
        });

        autoSearchTimer= new Timer() {
            @Override
            public void run() {
                searchHandler.onSearch(searchInput.value);
            }
        };

        if (autoSearch) {
            searchInput.addEventListener("input", evt -> {
                autoSearchTimer.cancel();
                autoSearchTimer.schedule(200);
            });
        }

        searchInput.addEventListener(EventType.keypress.getName(), evt -> {
            if (ElementUtil.isEnterKey(Js.uncheckedCast(evt))) {
                searchHandler.onSearch(searchInput.value);
            }
        });

    }

    public static Search create() {
        return new Search(false);
    }

    public static Search create(boolean autoSearch) {
        return new Search(autoSearch);
    }

    public Search open() {
        Style.of(element).setDisplay("inline-block");
        Scheduler.get().scheduleFixedDelay(() -> {
            Style.of(element).css("open");
            return false;
        }, 50);

        searchInput.focus();
        return this;
    }

    public Search close() {
        Style.of(element)
                .removeCss("open");
        Scheduler.get().scheduleFixedDelay(() -> {
            Style.of(element)
                    .setDisplay("none");
            return false;
        }, 50);

        searchInput.value = "";
        closeHandler.onClose();

        return this;
    }

    public Search onSearch(SearchHandler handler) {
        this.searchHandler = handler;
        return this;
    }

    public Search onClose(SearchCloseHandler handler){
        this.closeHandler = handler;
        return this;
    }


    public boolean isAutoSearch() {
        return autoSearch;
    }

    public SearchHandler getSearchHandler() {
        return searchHandler;
    }

    public void setSearchHandler(SearchHandler searchHandler) {
        this.searchHandler = searchHandler;
    }

    public SearchCloseHandler getCloseHandler() {
        return closeHandler;
    }

    public void setCloseHandler(SearchCloseHandler closeHandler) {
        this.closeHandler = closeHandler;
    }

    @Override
    public HTMLDivElement asElement() {
        return element;
    }

    @FunctionalInterface
    public interface SearchHandler {
        void onSearch(String searchToken);
    }

    @FunctionalInterface
    public interface SearchCloseHandler {
        void onClose();
    }
}
