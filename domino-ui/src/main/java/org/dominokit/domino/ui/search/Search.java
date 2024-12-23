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

import static org.dominokit.domino.ui.utils.Domino.*;

import elemental2.dom.HTMLDivElement;
import jsinterop.base.Js;
import org.dominokit.domino.ui.animations.Transition;
import org.dominokit.domino.ui.collapsible.AnimationCollapseStrategy;
import org.dominokit.domino.ui.collapsible.CollapsibleDuration;
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
 * The `Search` class provides a search bar component with various functionality options.
 *
 * <p>Usage Example:
 *
 * <pre>
 * // Create a search bar without auto search
 * Search searchBar = Search.create();
 *
 * // Create a search bar with auto search
 * Search autoSearchBar = Search.create(true);
 *
 * // Open the search bar
 * searchBar.open();
 *
 * // Close the search bar
 * searchBar.close();
 *
 * // Set a search handler to be executed on search action
 * searchBar.onSearch(searchToken -> {
 *     // Perform search operation with the provided search token
 * });
 *
 * // Set a close handler to be executed on closing the search bar
 * searchBar.onClose(() -> {
 *     // Handle the search bar closing event
 * });
 * </pre>
 *
 * @see BaseDominoElement
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
   * Constructs a new `Search` instance with the given autoSearch setting.
   *
   * @param autoSearch `true` to enable auto search, `false` to disable it.
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
            Transition.FADE_IN, Transition.FADE_OUT, CollapsibleDuration._300ms));
  }

  /**
   * Creates a new `Search` instance with auto search disabled.
   *
   * @return A new `Search` instance.
   */
  public static Search create() {
    return new Search(false);
  }

  /**
   * Creates a new `Search` instance with the specified auto search setting.
   *
   * @param autoSearch `true` to enable auto search, `false` to disable it.
   * @return A new `Search` instance.
   */
  public static Search create(boolean autoSearch) {
    return new Search(autoSearch);
  }

  /**
   * Opens the search bar, making it visible and focused.
   *
   * @return The current `Search` instance.
   */
  public Search open() {
    expand();
    setZIndex(config().getUIConfig().getZindexManager().getNextZIndex(this));
    searchInput.element().focus();
    return this;
  }

  /**
   * Closes the search bar, making it hidden.
   *
   * @return The current `Search` instance.
   */
  public Search close() {
    collapse();
    searchInput.element().value = "";
    closeHandler.onClose();
    return this;
  }

  /**
   * Sets the search handler to be executed when a search is performed.
   *
   * @param handler The search handler.
   * @return The current `Search` instance.
   */
  public Search onSearch(SearchHandler handler) {
    this.searchHandler = handler;
    return this;
  }

  /**
   * Sets the close handler to be executed when the search bar is closed.
   *
   * @param handler The close handler.
   * @return The current `Search` instance.
   */
  public Search onClose(SearchCloseHandler handler) {
    this.closeHandler = handler;
    return this;
  }

  /**
   * Sets the placeholder text for the search input field.
   *
   * @param placeHolder The placeholder text.
   * @return The current `Search` instance.
   */
  public Search setSearchPlaceHolder(String placeHolder) {
    searchInput.setAttribute("placeholder", placeHolder);
    return this;
  }

  /**
   * Checks if auto search is enabled.
   *
   * @return `true` if auto search is enabled, `false` otherwise.
   */
  public boolean isAutoSearch() {
    return autoSearch;
  }

  /**
   * Gets the search handler associated with this search bar.
   *
   * @return The search handler.
   */
  public SearchHandler getSearchHandler() {
    return searchHandler;
  }

  /**
   * Sets the search handler for this search bar.
   *
   * @param searchHandler The search handler.
   */
  public void setSearchHandler(SearchHandler searchHandler) {
    this.searchHandler = searchHandler;
  }

  /**
   * Gets the close handler associated with this search bar.
   *
   * @return The close handler.
   */
  public SearchCloseHandler getCloseHandler() {
    return closeHandler;
  }

  /**
   * Sets the close handler for this search bar.
   *
   * @param closeHandler The close handler.
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
   * Gets the input element of the search bar.
   *
   * @return The input element.
   */
  public InputElement getInputElement() {
    return searchInput;
  }

  /** A functional interface for handling search actions. */
  @FunctionalInterface
  public interface SearchHandler {

    /**
     * Handles a search action.
     *
     * @param searchToken The search token or query.
     */
    void onSearch(String searchToken);
  }

  /** A functional interface for handling search bar close actions. */
  @FunctionalInterface
  public interface SearchCloseHandler {

    /** Handles the search bar close action. */
    void onClose();
  }
}
