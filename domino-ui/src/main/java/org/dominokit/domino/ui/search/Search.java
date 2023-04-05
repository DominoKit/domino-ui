/*
 * Copyright © 2019 Dominokit
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.dominokit.domino.ui.search;


import elemental2.dom.HTMLDivElement;
import elemental2.dom.HTMLInputElement;
import jsinterop.base.Js;
import org.dominokit.domino.ui.animations.Transition;
import org.dominokit.domino.ui.collapsible.AnimationCollapseStrategy;
import org.dominokit.domino.ui.collapsible.CollapseDuration;
import org.dominokit.domino.ui.elements.DivElement;
import org.dominokit.domino.ui.elements.InputElement;
import org.dominokit.domino.ui.i18n.HasLabels;
import org.dominokit.domino.ui.i18n.SearchLabels;
import org.dominokit.domino.ui.icons.Icon;
import org.dominokit.domino.ui.icons.Icons;
import org.dominokit.domino.ui.utils.BaseDominoElement;
import org.dominokit.domino.ui.utils.DominoElement;
import org.dominokit.domino.ui.utils.ElementUtil;
import org.gwtproject.timer.client.Timer;
import org.dominokit.domino.ui.events.EventType;

/**
 * A search component that can fit into another component with fixed height, this component will
 * be
 * hidden by default and can be revealed by a trigger.
 *
 * <p>also the component provide callback and a type ahead delay, and provides a close button to
 * hide the component
 *
 * <pre>
 * Search.create(true)
 *                 .setSearchPlaceHolder("Search")
 *                 .styler(style -&gt; style.setHeight(Unit.px.of(40)))
 *                 .onSearch(searchToken -&gt; Notification.create("Inline searching for : " +
 * searchToken).show())
 *                 .onClose(() -&gt; Notification.create("Closing inline search : ").show());
 * </pre>
 */
public class Search extends BaseDominoElement<HTMLDivElement, Search>
        implements HasLabels<SearchLabels>, SearchStyles {

    private final Icon<?> closeIcon;
    private final InputElement searchInput;
    private DivElement element;
    private SearchHandler searchHandler;
    private SearchCloseHandler closeHandler;
    private final boolean autoSearch;
    private Timer autoSearchTimer;

    /**
     * @param autoSearch boolean, true to trigger the search while the user is typing with 200ms
     *                   delay, false to trigger the search only when the user press ENTER
     */
    public Search(boolean autoSearch) {
        this.autoSearch = autoSearch;
        this.closeIcon = Icons.ALL.close_mdi()
                .clickable()
                .addClickListener(evt -> {
                    evt.stopPropagation();
                    close();
                });
        this.searchInput = input("text").setAttribute("placeholder", getLabels().getStartTyping());
        this.element = div()
                .addCss(dui_search_bar, dui_h_full)
                .collapse()
                .appendChild(div().addCss(dui_search_bar_container)
                        .appendChild(Icons.ALL.magnify_mdi())
                        .appendChild(searchInput.addCss(dui_flex_grow))
                        .appendChild(closeIcon)
                );
        this.searchHandler = searchToken -> {
        };
        this.closeHandler = () -> {
        };
        autoSearchTimer =
                new Timer() {
                    @Override
                    public void run() {
                        searchHandler.onSearch(searchInput.element().value);
                    }
                };

        if (autoSearch) {
            searchInput.addEventListener(
                    "input",
                    evt -> {
                        autoSearchTimer.cancel();
                        autoSearchTimer.schedule(200);
                    });
        }

        searchInput.addEventListener(
                EventType.keypress.getName(),
                evt -> {
                    if (ElementUtil.isEnterKey(Js.uncheckedCast(evt))) {
                        searchHandler.onSearch(searchInput.element().value);
                    }
                });

        searchInput.onKeyDown(keyEvents -> keyEvents.onEscape(evt -> {
            evt.stopPropagation();
            close();
        }));

        init(this);

        setCollapseStrategy(new AnimationCollapseStrategy(Transition.FADE_IN, Transition.FADE_OUT, CollapseDuration._300ms));
    }

    /**
     * @return new Search instance
     */
    public static Search create() {
        return new Search(false);
    }

    /**
     * @param autoSearch boolean, true to trigger the search while the user is typing with 200ms
     *                   delay
     * @return new Search instance
     */
    public static Search create(boolean autoSearch) {
        return new Search(autoSearch);
    }

    /**
     * Show the search if it is hidden
     *
     * @return same Search instance
     */
    public Search open() {
        expand();
        setZIndex(config().getUIConfig().getZindexManager().getNextZIndex());
        searchInput.element().focus();
        return this;
    }

    /**
     * Hides the search if it is open
     *
     * @return same Search instance
     */
    public Search close() {
        collapse();
        searchInput.element().value = "";
        closeHandler.onClose();
        return this;
    }

    /**
     * @param handler {@link SearchHandler}
     * @return same Search instance
     */
    public Search onSearch(SearchHandler handler) {
        this.searchHandler = handler;
        return this;
    }

    /**
     * @param handler {@link SearchCloseHandler}
     * @return same Search instance
     */
    public Search onClose(SearchCloseHandler handler) {
        this.closeHandler = handler;
        return this;
    }

    /**
     * @param placeHolder String placeholder text for the search input
     * @return same Search instance
     */
    public Search setSearchPlaceHolder(String placeHolder) {
        searchInput.setAttribute("placeholder", placeHolder);
        return this;
    }

    /**
     * @return boolean, true if auto search is enabled
     */
    public boolean isAutoSearch() {
        return autoSearch;
    }

    /**
     * @return the {@link SearchHandler}
     */
    public SearchHandler getSearchHandler() {
        return searchHandler;
    }

    /**
     * @param searchHandler {@link SearchHandler}
     */
    public void setSearchHandler(SearchHandler searchHandler) {
        this.searchHandler = searchHandler;
    }

    /**
     * @return the {@link SearchCloseHandler}
     */
    public SearchCloseHandler getCloseHandler() {
        return closeHandler;
    }

    /**
     * @param closeHandler {@link SearchCloseHandler}
     */
    public void setCloseHandler(SearchCloseHandler closeHandler) {
        this.closeHandler = closeHandler;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public HTMLDivElement element() {
        return element.element();
    }

    /**
     * @return the {@link HTMLInputElement} of this search component wrapped as {@link
     * DominoElement}
     */
    public InputElement getInputElement() {
        return searchInput;
    }

    /**
     * A functional interface to implement the search logic
     */
    @FunctionalInterface
    public interface SearchHandler {
        /**
         * @param searchToken String value of the search input
         */
        void onSearch(String searchToken);
    }

    /**
     * A functional interface to handle closing of the Search component
     */
    @FunctionalInterface
    public interface SearchCloseHandler {
        /**
         * Will be called when the search is closed
         */
        void onClose();
    }
}
