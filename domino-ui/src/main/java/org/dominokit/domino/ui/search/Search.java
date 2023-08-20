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
import jsinterop.base.Js;
import org.dominokit.domino.ui.animations.Transition;
import org.dominokit.domino.ui.collapsible.AnimationCollapseStrategy;
import org.dominokit.domino.ui.collapsible.CollapseDuration;
import org.dominokit.domino.ui.elements.DivElement;
import org.dominokit.domino.ui.elements.InputElement;
import org.dominokit.domino.ui.events.EventType;
import org.dominokit.domino.ui.i18n.HasLabels;
import org.dominokit.domino.ui.i18n.SearchLabels;
import org.dominokit.domino.ui.icons.Icon;
import org.dominokit.domino.ui.icons.lib.Icons;
import org.dominokit.domino.ui.utils.BaseDominoElement;
import org.dominokit.domino.ui.utils.ElementUtil;
import org.gwtproject.timer.client.Timer;

/**
 * A search component that can fit into another component with fixed height, this component will be
 * hidden by default and can be revealed by a trigger.
 *
 * <p>also the component provide callback and a type ahead delay, and provides a close button to
 * hide the component </pre>
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
   * Constructor for Search.
   *
   * @param autoSearch boolean, true to trigger the search while the user is typing with 200ms
   *     delay, false to trigger the search only when the user press ENTER
   */
  public Search(boolean autoSearch) {
    this.autoSearch = autoSearch;
    this.closeIcon =
        Icons.close()
            .clickable()
            .addClickListener(
                evt -> {
                  evt.stopPropagation();
                  close();
                });
    this.searchInput = input("text").setAttribute("placeholder", getLabels().getStartTyping());
    this.element =
        div()
            .addCss(dui_search_bar, dui_h_full)
            .collapse()
            .appendChild(
                div()
                    .addCss(dui_search_bar_container)
                    .appendChild(Icons.magnify())
                    .appendChild(searchInput.addCss(dui_grow_1))
                    .appendChild(closeIcon));
    this.searchHandler = searchToken -> {};
    this.closeHandler = () -> {};
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

    searchInput.onKeyDown(
        keyEvents ->
            keyEvents.onEscape(
                evt -> {
                  evt.stopPropagation();
                  close();
                }));

    init(this);

    setCollapseStrategy(
        new AnimationCollapseStrategy(
            Transition.FADE_IN, Transition.FADE_OUT, CollapseDuration._300ms));
  }

  /** @return new Search instance */
  /**
   * create.
   *
   * @return a {@link org.dominokit.domino.ui.search.Search} object
   */
  public static Search create() {
    return new Search(false);
  }

  /**
   * create.
   *
   * @param autoSearch boolean, true to trigger the search while the user is typing with 200ms delay
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
   * onSearch.
   *
   * @param handler {@link org.dominokit.domino.ui.search.Search.SearchHandler}
   * @return same Search instance
   */
  public Search onSearch(SearchHandler handler) {
    this.searchHandler = handler;
    return this;
  }

  /**
   * onClose.
   *
   * @param handler {@link org.dominokit.domino.ui.search.Search.SearchCloseHandler}
   * @return same Search instance
   */
  public Search onClose(SearchCloseHandler handler) {
    this.closeHandler = handler;
    return this;
  }

  /**
   * setSearchPlaceHolder.
   *
   * @param placeHolder String placeholder text for the search input
   * @return same Search instance
   */
  public Search setSearchPlaceHolder(String placeHolder) {
    searchInput.setAttribute("placeholder", placeHolder);
    return this;
  }

  /** @return boolean, true if auto search is enabled */
  /**
   * isAutoSearch.
   *
   * @return a boolean
   */
  public boolean isAutoSearch() {
    return autoSearch;
  }

  /** @return the {@link SearchHandler} */
  /**
   * Getter for the field <code>searchHandler</code>.
   *
   * @return a {@link org.dominokit.domino.ui.search.Search.SearchHandler} object
   */
  public SearchHandler getSearchHandler() {
    return searchHandler;
  }

  /** @param searchHandler {@link SearchHandler} */
  /**
   * Setter for the field <code>searchHandler</code>.
   *
   * @param searchHandler a {@link org.dominokit.domino.ui.search.Search.SearchHandler} object
   */
  public void setSearchHandler(SearchHandler searchHandler) {
    this.searchHandler = searchHandler;
  }

  /** @return the {@link SearchCloseHandler} */
  /**
   * Getter for the field <code>closeHandler</code>.
   *
   * @return a {@link org.dominokit.domino.ui.search.Search.SearchCloseHandler} object
   */
  public SearchCloseHandler getCloseHandler() {
    return closeHandler;
  }

  /** @param closeHandler {@link SearchCloseHandler} */
  /**
   * Setter for the field <code>closeHandler</code>.
   *
   * @param closeHandler a {@link org.dominokit.domino.ui.search.Search.SearchCloseHandler} object
   */
  public void setCloseHandler(SearchCloseHandler closeHandler) {
    this.closeHandler = closeHandler;
  }

  /** {@inheritDoc} */
  @Override
  public HTMLDivElement element() {
    return element.element();
  }

  /**
   * getInputElement.
   *
   * @return the {@link elemental2.dom.HTMLInputElement} of this search component wrapped as {@link
   *     org.dominokit.domino.ui.utils.DominoElement}
   */
  public InputElement getInputElement() {
    return searchInput;
  }

  /** A functional interface to implement the search logic */
  @FunctionalInterface
  public interface SearchHandler {
    /** @param searchToken String value of the search input */
    void onSearch(String searchToken);
  }

  /** A functional interface to handle closing of the Search component */
  @FunctionalInterface
  public interface SearchCloseHandler {
    /** Will be called when the search is closed */
    void onClose();
  }
}
