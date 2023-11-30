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

import static java.util.Objects.nonNull;
import static org.dominokit.domino.ui.search.SearchStyles.dui_quick_search;
import static org.dominokit.domino.ui.utils.Domino.*;

import elemental2.dom.Event;
import elemental2.dom.EventListener;
import elemental2.dom.HTMLDivElement;
import java.util.HashSet;
import java.util.Set;
import org.dominokit.domino.ui.config.HasComponentConfig;
import org.dominokit.domino.ui.config.SearchConfig;
import org.dominokit.domino.ui.elements.DivElement;
import org.dominokit.domino.ui.forms.TextBox;
import org.dominokit.domino.ui.i18n.HasLabels;
import org.dominokit.domino.ui.i18n.QuickSearchLabels;
import org.dominokit.domino.ui.icons.Icon;
import org.dominokit.domino.ui.icons.lib.Icons;
import org.dominokit.domino.ui.keyboard.KeyboardEventOptions;
import org.dominokit.domino.ui.utils.BaseDominoElement;
import org.dominokit.domino.ui.utils.ChildHandler;
import org.dominokit.domino.ui.utils.PostfixAddOn;
import org.dominokit.domino.ui.utils.PrefixAddOn;
import org.gwtproject.timer.client.Timer;

/**
 * The `SearchBox` class provides a quick search input box with various customization options.
 *
 * <p>Usage Example:
 *
 * <pre>
 * // Create a search box with default settings
 * SearchBox searchBox = SearchBox.create();
 *
 * // Add a search listener to handle search actions
 * searchBox.addSearchListener(searchToken -> {
 *     // Perform search operation with the provided search token
 * });
 *
 * // Clear the search input box
 * searchBox.clearSearch();
 *
 * // Configure and customize the search box
 * searchBox.setAutoSearch(true)
 *         .setAutoSearchDelay(300)
 *         .withTextBox((searchBoxInstance, textBox) -> {
 *             // Customize the TextBox component
 *             textBox.setPlaceholder("Enter search query");
 *         });
 * </pre>
 *
 * @see BaseDominoElement
 */
public class SearchBox extends BaseDominoElement<HTMLDivElement, SearchBox>
    implements HasLabels<QuickSearchLabels>, HasComponentConfig<SearchConfig> {

  private int autoSearchDelay;
  private DivElement root;
  private final TextBox textBox;
  private boolean autoSearch = true;
  private Timer autoSearchTimer;
  private EventListener autoSearchEventListener;
  private final Icon<?> searchIcon;
  private final Icon<?> clearIcon;

  private Set<SearchListener> searchListeners = new HashSet<>();

  /**
   * Creates a new `SearchBox` instance with default settings.
   *
   * @return A new `SearchBox` instance.
   */
  public static SearchBox create() {
    return new SearchBox();
  }

  /** Constructs a new `SearchBox` instance with default settings. */
  public SearchBox() {
    init(this);
    this.autoSearchDelay = getConfig().getAutoSearchDelay();
    root = div().addCss(dui_quick_search);
    searchIcon =
        Icons.magnify()
            .clickable()
            .addClickListener(
                evt -> {
                  autoSearchTimer.cancel();
                  doSearch();
                })
            .setTooltip(getLabels().defaultQuickSearchPlaceHolder());

    clearIcon =
        Icons.close()
            .clickable()
            .setTooltip(getLabels().defaultQuickSearchClearToolTip())
            .addClickListener(
                evt -> {
                  clearSearch();
                  focusSearchBox();
                });

    clearIcon.onKeyDown(
        keyEvents ->
            keyEvents.onEnter(
                KeyboardEventOptions.create().setPreventDefault(true).setStopPropagation(true),
                evt -> {
                  clearSearch();
                  focusSearchBox();
                }));

    textBox =
        TextBox.create()
            .setPlaceholder(getLabels().defaultQuickSearchPlaceHolder())
            .appendChild(PrefixAddOn.of(searchIcon))
            .appendChild(PostfixAddOn.of(clearIcon))
            .addCss(dui_m_0)
            .withInputElement(
                (parent, input) -> {
                  input.onKeyDown(
                      keyEvents ->
                          keyEvents.any(
                              KeyboardEventOptions.create().setStopPropagation(true), evt -> {}));
                });

    root.appendChild(textBox.element());

    autoSearchTimer =
        new Timer() {
          @Override
          public void run() {
            doSearch();
          }
        };

    autoSearchEventListener =
        evt -> {
          autoSearchTimer.cancel();
          autoSearchTimer.schedule(autoSearchDelay);
        };

    setAutoSearch(true);
    root.addClickListener(Event::stopPropagation);
  }

  private void focusSearchBox() {
    getTextBox().getInputElement().element().focus();
  }

  /**
   * Clears the search input box and triggers a search action.
   *
   * @return The current `SearchBox` instance.
   */
  public SearchBox clearSearch() {
    return clearSearch(false);
  }

  /**
   * Clears the search input box and optionally triggers a search action.
   *
   * @param silent `true` to clear the search box silently (without triggering search), `false` to
   *     trigger search.
   * @return The current `SearchBox` instance.
   */
  public SearchBox clearSearch(boolean silent) {
    textBox.clear();
    autoSearchTimer.cancel();
    if (!silent) {
      doSearch();
    }
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
   * Enables or disables auto search.
   *
   * @param autoSearch `true` to enable auto search, `false` to disable it.
   * @return The current `SearchBox` instance.
   */
  public SearchBox setAutoSearch(boolean autoSearch) {
    this.autoSearch = autoSearch;

    if (autoSearch) {
      textBox.addEventListener("input", autoSearchEventListener);
    } else {
      textBox.removeEventListener("input", autoSearchEventListener);
      autoSearchTimer.cancel();
    }

    textBox.onKeyPress(keyEvents -> keyEvents.onEnter(evt -> doSearch()));

    return this;
  }

  /**
   * Gets the auto search delay in milliseconds.
   *
   * @return The auto search delay.
   */
  public int getAutoSearchDelay() {
    return autoSearchDelay;
  }

  /**
   * Sets the auto search delay in milliseconds.
   *
   * @param autoSearchDelayInMillies The auto search delay in milliseconds.
   * @return The current `SearchBox` instance.
   */
  public SearchBox setAutoSearchDelay(int autoSearchDelayInMillies) {
    this.autoSearchDelay = autoSearchDelayInMillies;
    return this;
  }

  private SearchBox doSearch() {
    searchListeners.forEach(searchListener -> searchListener.onSearch(textBox.getValue()));
    return this;
  }

  /**
   * Adds a search listener to the search box to handle search actions.
   *
   * @param searchListener The search listener to add.
   * @return The current `SearchBox` instance.
   */
  public SearchBox addSearchListener(SearchListener searchListener) {
    if (nonNull(searchListener)) {
      this.searchListeners.add(searchListener);
    }
    return this;
  }

  /**
   * Removes a search listener from the search box.
   *
   * @param searchListener The search listener to remove.
   * @return The current `SearchBox` instance.
   */
  public SearchBox removeSearchListener(SearchListener searchListener) {
    if (nonNull(searchListener)) {
      this.searchListeners.remove(searchListener);
    }
    return this;
  }

  /**
   * Clears all search listeners from the search box.
   *
   * @return The current `SearchBox` instance.
   */
  public SearchBox clearSearchListeners() {
    this.searchListeners.clear();
    return this;
  }

  /**
   * Gets the TextBox component associated with this search box.
   *
   * @return The TextBox component.
   */
  public TextBox getTextBox() {
    return textBox;
  }

  /**
   * Applies customization to the TextBox component within the search box.
   *
   * @param handler A `ChildHandler` that can be used to customize the TextBox.
   * @return The current `SearchBox` instance.
   */
  public SearchBox withTextBox(ChildHandler<SearchBox, TextBox> handler) {
    handler.apply(this, textBox);
    return this;
  }

  /**
   * Gets the search icon associated with this search box.
   *
   * @return The search icon.
   */
  public Icon<?> getSearchIcon() {
    return searchIcon;
  }

  /**
   * Gets the clear icon associated with this search box.
   *
   * @return The clear icon.
   */
  public Icon<?> getClearIcon() {
    return clearIcon;
  }

  /**
   * Gets the set of search listeners associated with this search box.
   *
   * @return A set of search listeners.
   */
  public Set<SearchListener> getSearchListeners() {
    return searchListeners;
  }

  /** {@inheritDoc} */
  @Override
  public HTMLDivElement element() {
    return root.element();
  }

  /** A functional interface for handling search actions. */
  @FunctionalInterface
  public interface SearchListener {

    /**
     * Handles a search action.
     *
     * @param token The search token or query.
     */
    void onSearch(String token);
  }
}
