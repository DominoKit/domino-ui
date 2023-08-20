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

/** A simple search box that is triggered while the user is typing */
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
   * create.
   *
   * @return a {@link org.dominokit.domino.ui.search.SearchBox} object
   */
  public static SearchBox create() {
    return new SearchBox();
  }

  /** creates a new instance */
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
            .addCss(dui_m_0);

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
   * Clears the search box and trigger the search with an empty token
   *
   * @return a {@link org.dominokit.domino.ui.search.SearchBox} object
   */
  public SearchBox clearSearch() {
    return clearSearch(false);
  }
  /**
   * Clears the search box and trigger the search with an empty token
   *
   * @param silent a boolean
   * @return a {@link org.dominokit.domino.ui.search.SearchBox} object
   */
  public SearchBox clearSearch(boolean silent) {
    textBox.clear();
    autoSearchTimer.cancel();
    if (!silent) {
      doSearch();
    }
    return this;
  }

  /** @return boolean, true if the auto search is enabled */
  /**
   * isAutoSearch.
   *
   * @return a boolean
   */
  public boolean isAutoSearch() {
    return autoSearch;
  }

  /**
   * Enable/Disable auto search when enabled the search will be triggered while the user is typing
   * with a delay otherwise the search will only be triggered when the user click on search or press
   * Enter
   *
   * @param autoSearch boolean
   * @return same action instance
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

  /** @return int search delay in milliseconds */
  /**
   * Getter for the field <code>autoSearchDelay</code>.
   *
   * @return a int
   */
  public int getAutoSearchDelay() {
    return autoSearchDelay;
  }

  /** @param autoSearchDelayInMillies int auto search delay in milliseconds */
  /**
   * Setter for the field <code>autoSearchDelay</code>.
   *
   * @param autoSearchDelayInMillies a int
   * @return a {@link org.dominokit.domino.ui.search.SearchBox} object
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
   * Adds a search listener to the search box component
   *
   * @param searchListener {@link org.dominokit.domino.ui.search.SearchBox.SearchListener}
   * @return same instance
   */
  public SearchBox addSearchListener(SearchListener searchListener) {
    if (nonNull(searchListener)) {
      this.searchListeners.add(searchListener);
    }
    return this;
  }

  /**
   * Removes a search listener from the search box component
   *
   * @param searchListener {@link org.dominokit.domino.ui.search.SearchBox.SearchListener}
   * @return same instance
   */
  public SearchBox removeSearchListener(SearchListener searchListener) {
    if (nonNull(searchListener)) {
      this.searchListeners.remove(searchListener);
    }
    return this;
  }

  /**
   * Remove all search listeners
   *
   * @return same instance
   */
  public SearchBox clearSearchListeners() {
    this.searchListeners.clear();
    return this;
  }

  /** @return The search {@link TextBox} */
  /**
   * Getter for the field <code>textBox</code>.
   *
   * @return a {@link org.dominokit.domino.ui.forms.TextBox} object
   */
  public TextBox getTextBox() {
    return textBox;
  }

  /** @return The search {@link TextBox} */
  /**
   * withTextBox.
   *
   * @param handler a {@link org.dominokit.domino.ui.utils.ChildHandler} object
   * @return a {@link org.dominokit.domino.ui.search.SearchBox} object
   */
  public SearchBox withTextBox(ChildHandler<SearchBox, TextBox> handler) {
    handler.apply(this, textBox);
    return this;
  }

  /** @return the search {@link Icon} */
  /**
   * Getter for the field <code>searchIcon</code>.
   *
   * @return a {@link org.dominokit.domino.ui.icons.Icon} object
   */
  public Icon<?> getSearchIcon() {
    return searchIcon;
  }

  /** @return the clear search {@link Icon} */
  /**
   * Getter for the field <code>clearIcon</code>.
   *
   * @return a {@link org.dominokit.domino.ui.icons.Icon} object
   */
  public Icon<?> getClearIcon() {
    return clearIcon;
  }

  /** @return a set of {@link SearchListener}s */
  /**
   * Getter for the field <code>searchListeners</code>.
   *
   * @return a {@link java.util.Set} object
   */
  public Set<SearchListener> getSearchListeners() {
    return searchListeners;
  }

  /** {@inheritDoc} */
  @Override
  public HTMLDivElement element() {
    return root.element();
  }

  /** A functional interface to implement the search logic in as a search listener */
  @FunctionalInterface
  public interface SearchListener {
    /** @param token String user input */
    void onSearch(String token);
  }
}
