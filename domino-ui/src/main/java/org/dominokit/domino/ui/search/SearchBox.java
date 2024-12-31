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

import elemental2.dom.Event;
import elemental2.dom.EventListener;
import elemental2.dom.HTMLDivElement;
import java.util.HashSet;
import java.util.Set;
import jsinterop.base.Js;
import org.dominokit.domino.ui.forms.TextBox;
import org.dominokit.domino.ui.icons.BaseIcon;
import org.dominokit.domino.ui.icons.Icons;
import org.dominokit.domino.ui.keyboard.KeyboardEvents;
import org.dominokit.domino.ui.utils.BaseDominoElement;
import org.dominokit.domino.ui.utils.DominoElement;
import org.dominokit.domino.ui.utils.ElementUtil;
import org.gwtproject.timer.client.Timer;
import org.jboss.elemento.EventType;

/** A simple search box that is triggered while the user is typing */
public class SearchBox extends BaseDominoElement<HTMLDivElement, SearchBox> {

  private String searchToolTip = "Search";
  private String clearSearchToolTip = "Clear search";

  private int autoSearchDelay = 200;
  private DominoElement<HTMLDivElement> root = DominoElement.div().css("search-box");
  private final TextBox textBox;
  private boolean autoSearch = true;
  private Timer autoSearchTimer;
  private EventListener autoSearchEventListener;
  private final BaseIcon<?> searchIcon;
  private final BaseIcon<?> clearIcon;

  private Set<SearchListener> searchListeners = new HashSet<>();

  public static SearchBox create() {
    return new SearchBox();
  }

  /** creates a new instance */
  public SearchBox() {
    init(this);
    searchIcon =
        Icons.ALL
            .magnify_mdi()
            .clickable()
            .addClickListener(
                evt -> {
                  autoSearchTimer.cancel();
                  doSearch();
                })
            .setTooltip(searchToolTip);

    clearIcon =
        Icons.ALL
            .window_close_mdi()
            .setAttribute("tabindex", "0")
            .setAttribute("aria-expanded", "true")
            .setAttribute("href", "#")
            .clickable()
            .setTooltip(clearSearchToolTip)
            .addClickListener(
                evt -> {
                  clearSearch();
                  focusSearchBox();
                });

    KeyboardEvents.listenOnKeyDown(clearIcon)
        .onEnter(
            evt -> {
              clearSearch();
              focusSearchBox();
            },
            KeyboardEvents.KeyboardEventOptions.create()
                .setPreventDefault(true)
                .setStopPropagation(true));

    textBox =
        TextBox.create()
            .floating()
            .setPlaceholder(searchToolTip)
            .addLeftAddOn(searchIcon)
            .addRightAddOn(clearIcon)
            .setMarginBottom("0px");

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

  /** Clears the search box and trigger the search with an empty token */
  public void clearSearch() {
    textBox.clear();
    autoSearchTimer.cancel();
    doSearch();
  }

  /** @return boolean, true if the auto search is enabled */
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

    textBox.addEventListener(
        EventType.keydown.getName(),
        evt -> {
          if (ElementUtil.isEnterKey(Js.uncheckedCast(evt))) {
            doSearch();
          }
        });

    return this;
  }

  /** @return int search delay in milliseconds */
  public int getAutoSearchDelay() {
    return autoSearchDelay;
  }

  /** @param autoSearchDelayInMillies int auto search delay in milliseconds */
  public void setAutoSearchDelay(int autoSearchDelayInMillies) {
    this.autoSearchDelay = autoSearchDelayInMillies;
  }

  private void doSearch() {
    searchListeners.forEach(searchListener -> searchListener.onSearch(textBox.getValue()));
  }

  /**
   * Set the search icon tooltip
   *
   * @param searchToolTip String
   * @return same action instance
   */
  public SearchBox setSearchToolTip(String searchToolTip) {
    this.searchToolTip = searchToolTip;
    searchIcon.setTooltip(searchToolTip);
    textBox.setPlaceholder(searchToolTip);
    return this;
  }

  /**
   * Set the clear search icon tooltip
   *
   * @param clearSearchToolTip String
   * @return same action instance
   */
  public SearchBox setClearSearchToolTip(String clearSearchToolTip) {
    this.clearSearchToolTip = clearSearchToolTip;
    clearIcon.setTooltip(clearSearchToolTip);
    return this;
  }

  /**
   * Adds a search listener to the search box component
   *
   * @param searchListener {@link SearchListener}
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
   * @param searchListener {@link SearchListener}
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

  /** @return String tooltip of the search icon */
  public String getSearchToolTip() {
    return searchToolTip;
  }

  /** @return String tooltip of the clear search icon */
  public String getClearSearchToolTip() {
    return clearSearchToolTip;
  }

  /** @return The search {@link TextBox} */
  public TextBox getTextBox() {
    return textBox;
  }

  /** @return the search {@link BaseIcon} */
  public BaseIcon<?> getSearchIcon() {
    return searchIcon;
  }

  /** @return the clear search {@link BaseIcon} */
  public BaseIcon<?> getClearIcon() {
    return clearIcon;
  }

  /** @return a set of {@link SearchListener}s */
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
