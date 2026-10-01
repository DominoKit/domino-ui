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
package org.dominokit.domino.ui.menu.base;

import static elemental2.dom.DomGlobal.document;
import static elemental2.dom.DomGlobal.window;
import static java.util.Objects.isNull;
import static java.util.Objects.nonNull;
import static org.dominokit.domino.ui.menu.direction.DropDirection.DUI_POSITION_FALLBACK;
import static org.dominokit.domino.ui.utils.Domino.elementOf;
import static org.dominokit.domino.ui.utils.PopupsCloser.DOMINO_UI_AUTO_CLOSABLE;

import elemental2.dom.DomGlobal;
import elemental2.dom.Element;
import elemental2.dom.Event;
import elemental2.dom.EventListener;
import elemental2.dom.HTMLDivElement;
import elemental2.dom.HTMLElement;
import elemental2.dom.HTMLLIElement;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;
import java.util.Set;
import jsinterop.base.Js;
import org.dominokit.domino.ui.IsElement;
import org.dominokit.domino.ui.config.HasComponentConfig;
import org.dominokit.domino.ui.config.MenuConfig;
import org.dominokit.domino.ui.elements.AnchorElement;
import org.dominokit.domino.ui.elements.DivElement;
import org.dominokit.domino.ui.events.EventType;
import org.dominokit.domino.ui.icons.Icon;
import org.dominokit.domino.ui.layout.NavBar;
import org.dominokit.domino.ui.mediaquery.MediaQuery;
import org.dominokit.domino.ui.menu.DropTarget;
import org.dominokit.domino.ui.menu.HasSelectionMode;
import org.dominokit.domino.ui.menu.Menu;
import org.dominokit.domino.ui.menu.MenuStyles;
import org.dominokit.domino.ui.menu.MissingItemHandler;
import org.dominokit.domino.ui.menu.OpenMenuCondition;
import org.dominokit.domino.ui.menu.SingleSelectionMode;
import org.dominokit.domino.ui.menu.direction.BestSideUpDownDropDirection;
import org.dominokit.domino.ui.menu.direction.DropDirection;
import org.dominokit.domino.ui.menu.direction.DropDirectionContext;
import org.dominokit.domino.ui.menu.direction.MiddleOfScreenDropDirection;
import org.dominokit.domino.ui.menu.direction.MouseBestFitDirection;
import org.dominokit.domino.ui.menu.direction.SpaceChecker;
import org.dominokit.domino.ui.search.SearchBox;
import org.dominokit.domino.ui.style.BooleanCssClass;
import org.dominokit.domino.ui.utils.AnyElement;
import org.dominokit.domino.ui.utils.AppendStrategy;
import org.dominokit.domino.ui.utils.BaseDominoElement;
import org.dominokit.domino.ui.utils.ChildHandler;
import org.dominokit.domino.ui.utils.DominoElement;
import org.dominokit.domino.ui.utils.DominoUIConfig;
import org.dominokit.domino.ui.utils.HasSelectionListeners;
import org.dominokit.domino.ui.utils.IsPopup;
import org.dominokit.domino.ui.utils.KeyboardNavigation;
import org.dominokit.domino.ui.utils.LazyChild;
import org.dominokit.domino.ui.utils.MutationObserverCallback;
import org.dominokit.domino.ui.utils.PopupsCloser;
import org.dominokit.domino.ui.utils.PrefixAddOn;
import org.dominokit.domino.ui.utils.Selectable;
import org.dominokit.domino.ui.utils.SubheaderAddon;

public abstract class BaseMenu<
        V, C extends BaseMenu<V, C, I, S>, I extends IsMenuItem<V, I, S>, S extends Selectable<S>>
    extends BaseDominoElement<HTMLDivElement, C>
    implements HasSelectionListeners<C, S, List<S>>,
        IsPopup<C>,
        HasSelectionMode<C>,
        HasComponentConfig<MenuConfig>,
        MenuStyles,
        IsMenu<V, C, I, S> {

  public static final String ANY = "*";
  public static final String DUI_AUTO_CLEAR_SELECTION = "dui-auto-clear-selection";

  protected LazyChild<NavBar> menuHeader;
  protected LazyChild<DivElement> menuSearchContainer;

  protected LazyChild<DivElement> menuSubHeader;

  protected boolean caseSensitive = false;
  protected String createMissingLabel =
      DominoUIConfig.CONFIG.getUIConfig().getMissingItemCreateLabel();
  protected MissingItemHandler<V, C> missingItemHandler;

  protected KeyboardNavigation<I> keyboardNavigation;
  protected boolean autoCloseOnSelect = true;
  protected final Set<SelectionListener<? super S, ? super List<S>>> selectionListeners =
      new LinkedHashSet<>();
  protected final Set<SelectionListener<? super S, ? super List<S>>> deselectionListeners =
      new LinkedHashSet<>();
  protected LazyChild<SearchBox> searchBox;
  protected LazyChild<AnchorElement> createMissingElement;

  protected EventListener closeOnScrollListener;
  protected LazyChild<AnyElement> noResultElement;
  protected final List<S> selectedValues = new ArrayList<>();
  protected boolean headerVisible = false;
  protected boolean smallScreen;
  protected DropDirection dropDirection = new BestSideUpDownDropDirection();
  protected final DropDirection contextMenuDropDirection = new MouseBestFitDirection();
  protected final DropDirection smallScreenDropDirection = new MiddleOfScreenDropDirection();
  protected DropDirection effectiveDropDirection = dropDirection;
  protected Map<String, DropTarget> targets;
  protected DropTarget lastTarget;
  protected DominoElement<Element> menuAppendTarget;

  protected boolean selectionListenersPaused = false;
  protected boolean multiSelect = false;
  protected boolean autoOpen = true;
  protected boolean preserveSelectionStyles = true;
  protected boolean startScrollFollow = false;

  protected EventListener repositionListener =
      evt -> {
        if (isOpened() && startScrollFollow && evt.target != getMenuListElement()) {
          startScrollFollow = false;
          position();
        }
      };

  protected Set<OnBeforeOpenListener<? super C>> onBeforeOpenListeners;

  protected final EventListener openListener =
      evt -> {
        evt.stopPropagation();
        evt.preventDefault();

        onAppendTargetDetach = MutationObserverCallback.doOnce(mutationRecord -> close());
        DropTarget newTarget =
            targets.get(elementOf(Js.<HTMLElement>uncheckedCast(evt.currentTarget)).getDominoId());
        if (isNull(newTarget)) {
          newTarget =
              targets.get(elementOf(Js.<HTMLElement>uncheckedCast(evt.target)).getDominoId());
        }
        if (!Objects.equals(newTarget, lastTarget)) {
          if (nonNull(lastTarget)) {
            lastTarget.getTargetElement().removeCss(dui_context_menu_target_open);
            getSelection().forEach(item -> item.deselect(true));
          }
          newTarget.getTargetElement().addCss(dui_context_menu_target_open);
        } else {
          if (nonNull(lastTarget)
              && lastTarget.getTargetElement().hasAttribute(DUI_AUTO_CLEAR_SELECTION)) {
            if ("true"
                .equals(lastTarget.getTargetElement().getAttribute(DUI_AUTO_CLEAR_SELECTION))) {
              getSelection().forEach(item -> item.deselect(true));
            }
          }
        }

        lastTarget = newTarget;
        if (isAutoOpen()) {
          if (isOpened() && !isContextMenu()) {
            close();
          } else {
            open(evt);
          }
        }
      };

  protected boolean contextMenu = false;
  protected boolean useSmallScreensDirection = true;
  protected boolean dropDown = false;
  protected Set<OnAddItemHandler<V, C, I, S>> onAddItemHandlers = new HashSet<>();
  protected boolean fitToTargetWidth = false;
  protected boolean centerOnSmallScreens = false;

  protected EventListener lostFocusListener;
  protected boolean closeOnBlur = DominoUIConfig.CONFIG.isClosePopupOnBlur();
  protected OpenMenuCondition<V, C, I, S> openMenuCondition = (menu) -> true;
  protected List<MediaQuery.MediaQueryListenerRecord> mediaQueryRecords = new ArrayList<>();
  protected EventListener windowResizeListener;
  protected MutationObserverCallback onAttachHandler;
  protected boolean shouldFocus;
  protected MutationObserverCallback onDetachHandler;
  protected SingleSelectionMode selectionMode = SingleSelectionMode.RESELECT;
  protected MutationObserverCallback onAppendTargetDetach;
  protected boolean autoFocus = true;

  protected HTMLElement focusElement;
  private AppendStrategy appendStrategy = AppendStrategy.LAST;

  protected final EventListener autoCloseListener =
      evt -> {
        if (isAutoClose()) {
          remove();
        }
      };

  public abstract void focusFirstMatch(String token);

  public abstract Optional<I> findOptionStarsWith(String token);

  /**
   * Determines if the menu is set to be centered on small screen devices.
   *
   * @return true if the menu should be centered on small screens, false otherwise.
   */
  public boolean isCenterOnSmallScreens() {
    return centerOnSmallScreens;
  }

  /**
   * Sets the behavior for the menu to be centered or not on small screen devices.
   *
   * @param centerOnSmallScreens true to center the menu on small screens, false otherwise.
   * @return The current {@link Menu} instance.
   */
  public C setCenterOnSmallScreens(boolean centerOnSmallScreens) {
    this.centerOnSmallScreens = centerOnSmallScreens;
    return (C) this;
  }

  /**
   * Allows adding an icon to the menu header.
   *
   * @param icon The icon to be set.
   * @return The current Menu instance.
   */
  public C setIcon(Icon<?> icon) {
    menuHeader.get().appendChild(PrefixAddOn.of(icon));
    return (C) this;
  }

  /**
   * Sets the title for the menu header.
   *
   * @param title The title to be set.
   * @return The current Menu instance.
   */
  public C setTitle(String title) {
    menuHeader.get().setTitle(title);
    return (C) this;
  }

  /**
   * Appends a subheader addon to the menu.
   *
   * @param addon The subheader addon to be added.
   * @return The current Menu instance.
   */
  public C appendChild(SubheaderAddon<?> addon) {
    menuSubHeader.get().appendChild(addon);
    return (C) this;
  }

  public C appendChild(SubheaderAddon<?>... addons) {
    Arrays.stream(addons).forEach(this::appendChild);
    return (C) this;
  }

  /**
   * Handles the behavior when an expected menu item is missing.
   *
   * <p>If a missing item handler is set, this method triggers the handler's onMissingItem method,
   * performs a search with the current value of the search box, and then removes the create missing
   * element and focuses on the top focusable item in the menu.
   */
  protected void onAddMissingElement() {
    if (nonNull(missingItemHandler)) {
      missingItemHandler.onMissingItem(searchBox.get().getTextBox().getValue(), (C) this);
      onSearch(searchBox.get().getTextBox().getValue());
      createMissingElement.remove();
      keyboardNavigation.focusTopFocusableItem();
    }
  }

  public abstract boolean onSearch(String token);

  protected abstract void afterAddItem(I item);

  public void onItemAdded(I item) {
    onAddItemHandlers.forEach(handler -> handler.onAdded((C) this, item));
  }

  /** Clears the contents of the search box within the menu. */
  private void clearSearch() {
    searchBox.get().clearSearch();
  }

  /**
   * Clears the current selection of menu items.
   *
   * @param silent if true, does not trigger the deselection listeners; otherwise, does.
   */
  public void clearSelection(boolean silent) {
    selectedValues.clear();
    if (!silent) {
      triggerDeselectionListeners(null, selectedValues);
    }
  }

  /**
   * Gets the label used when an item is not found during a search.
   *
   * @return the label string.
   */
  public String getCreateMissingLabel() {
    return createMissingLabel;
  }

  /**
   * Sets the label to be displayed when an item is not found during a search.
   *
   * @param createMissingLabel the label string.
   * @return The current {@link Menu} instance.
   */
  public C setCreateMissingLabel(String createMissingLabel) {
    if (isNull(createMissingLabel) || createMissingLabel.isEmpty()) {
      this.createMissingLabel = getConfig().getMissingItemCreateLabel();
    } else {
      this.createMissingLabel = createMissingLabel;
    }
    return (C) this;
  }

  /**
   * Determines if the provided search token is empty or null.
   *
   * @param token the search string.
   * @return true if the token is null or empty, false otherwise.
   */
  protected boolean emptyToken(String token) {
    return isNull(token) || token.isEmpty();
  }

  /**
   * Retrieves the element used to display a "no results" message when a search yields no results.
   *
   * @return the "no results" element wrapped in a {@link LazyChild} container.
   */
  public LazyChild<AnyElement> getNoResultElement() {
    return noResultElement;
  }

  /**
   * Sets the element used to display a "no results" message when a search yields no results.
   *
   * @param noResultElement the HTMLLIElement to be used for displaying "no results".
   * @return The current {@link Menu} instance.
   */
  public C setNoResultElement(Element noResultElement) {
    if (nonNull(noResultElement)) {
      this.noResultElement.remove();
      this.noResultElement =
          LazyChild.of(
              AnyElement.of(noResultElement).addCss(dui_menu_no_results),
              getNoResultParentElement());
    }
    return (C) this;
  }

  protected abstract IsElement<? extends Element> getNoResultParentElement();

  /**
   * Sets the element used to display a "no results" message when a search yields no results.
   *
   * @param noResultElement the IsElement wrapping an HTMLLIElement to be used for displaying "no
   *     results".
   * @return The current {@link Menu} instance.
   */
  public C setNoResultElement(IsElement<HTMLLIElement> noResultElement) {
    if (nonNull(noResultElement)) {
      setNoResultElement(noResultElement.element());
    }
    return (C) this;
  }

  /**
   * Checks if the menu's search functionality is case-sensitive.
   *
   * @return true if the search is case-sensitive, false otherwise.
   */
  public boolean isCaseSensitive() {
    return caseSensitive;
  }

  /**
   * Sets the menu's search functionality to be case-sensitive or not.
   *
   * @param caseSensitive a boolean indicating whether to enable or disable case-sensitivity.
   * @return The current {@link Menu} instance.
   */
  public C setCaseSensitive(boolean caseSensitive) {
    this.caseSensitive = caseSensitive;
    return (C) this;
  }

  /**
   * Retrieves the current focus element of the menu.
   *
   * <p>The focus element is determined based on the following criteria: - If a custom focus element
   * has been set, it will be returned. - If the menu is searchable, the search box input will be
   * the focus element. - If the menu contains menu items, the first item will be the focus element.
   * - Otherwise, the root element of the menu items list will be the focus element.
   *
   * @return the current focus element of the menu.
   */
  public HTMLElement getFocusElement() {
    if (isNull(this.focusElement)) {
      if (isSearchable()) {
        return this.searchBox.get().getTextBox().getInputElement().element();
      } else {
        return getListFocusElement();
      }
    }
    return focusElement;
  }

  protected abstract HTMLElement getListFocusElement();

  /**
   * Sets the focus element for the menu.
   *
   * @param focusElement the HTMLElement to set as the focus element.
   * @return The current {@link Menu} instance.
   */
  public C setFocusElement(HTMLElement focusElement) {
    this.focusElement = focusElement;
    return (C) this;
  }

  /**
   * Retrieves the search box component used within the menu.
   *
   * @return the {@link SearchBox} instance.
   */
  public SearchBox getSearchBox() {
    return searchBox.get();
  }

  /**
   * Retrieves the keyboard navigation handler for the menu items.
   *
   * @return the keyboard navigation instance.
   */
  public KeyboardNavigation<I> getKeyboardNavigation() {
    return keyboardNavigation;
  }

  /**
   * Retrieves the header component of the menu.
   *
   * @return the {@link NavBar} instance representing the menu's header.
   */
  public NavBar getMenuHeader() {
    return menuHeader.get();
  }

  /**
   * Toggles the visibility of the menu's header.
   *
   * @param visible true to make the header visible, false to hide it.
   * @return The current {@link Menu} instance.
   */
  public C setHeaderVisible(boolean visible) {
    menuHeader.get().toggleDisplay(visible);
    this.headerVisible = visible;
    return (C) this;
  }

  /**
   * Checks if the menu has a search functionality enabled.
   *
   * @return true if the menu is searchable, false otherwise.
   */
  public abstract boolean isSearchable();

  /**
   * Checks if the menu allows for the creation of missing items.
   *
   * @return true if missing items can be created, false otherwise.
   */
  public boolean isAllowCreateMissing() {
    return nonNull(missingItemHandler);
  }

  /**
   * Sets the handler for missing items in the menu. When set, it allows the creation of missing
   * items.
   *
   * @param missingItemHandler the handler to manage missing items.
   * @return The current {@link Menu} instance.
   */
  public C setMissingItemHandler(MissingItemHandler<V, C> missingItemHandler) {
    this.missingItemHandler = missingItemHandler;
    return (C) this;
  }

  /**
   * Selects a given menu item.
   *
   * @param item The menu item to select.
   * @return The current {@link Menu} instance.
   */
  public C select(I item) {
    return select(item, isSelectionListenersPaused());
  }

  /**
   * Selects a given menu item with the option to silence selection events.
   *
   * @param menuItem The menu item to select.
   * @param silent If true, selection listeners will be paused; otherwise, they will be active.
   * @return The current {@link Menu} instance.
   */
  public C select(I menuItem, boolean silent) {
    menuItem.select(silent);
    return (C) this;
  }

  /**
   * Selects a menu item at a specified index.
   *
   * @param index The index of the menu item to select.
   * @return The current {@link Menu} instance.
   */
  public C selectAt(int index) {
    return selectAt(index, isSelectionListenersPaused());
  }

  /**
   * Selects a menu item at a specified index with the option to silence selection events.
   *
   * @param index The index of the menu item to select.
   * @param silent If true, selection listeners will be paused; otherwise, they will be active.
   * @return The current {@link Menu} instance.
   */
  public abstract C selectAt(int index, boolean silent);

  /**
   * Selects a menu item by its key identifier.
   *
   * @param key The key identifier of the menu item to select.
   * @return The current {@link Menu} instance.
   */
  public C selectByKey(String key) {
    return selectByKey(key, false);
  }

  /**
   * Selects a menu item by its key identifier with the option to silence selection events.
   *
   * @param key The key identifier of the menu item to select.
   * @param silent If true, selection listeners will be paused; otherwise, they will be active.
   * @return The current {@link Menu} instance.
   */
  public abstract C selectByKey(String key, boolean silent);

  /**
   * Checks if the menu is set to automatically close upon selection of an item.
   *
   * @return true if the menu will auto-close on selection, false otherwise.
   */
  public boolean isAutoCloseOnSelect() {
    return autoCloseOnSelect;
  }

  /**
   * Sets whether the menu should automatically close upon selecting an item.
   *
   * @param autoCloseOnSelect If true, the menu will auto-close on selection.
   * @return The current {@link Menu} instance.
   */
  public C setAutoCloseOnSelect(boolean autoCloseOnSelect) {
    this.autoCloseOnSelect = autoCloseOnSelect;
    return (C) this;
  }

  /**
   * Checks if the menu supports selecting multiple items simultaneously.
   *
   * @return true if the menu supports multi-selection, false otherwise.
   */
  public boolean isMultiSelect() {
    return multiSelect;
  }

  /**
   * Enables or disables the ability to select multiple items in the menu.
   *
   * @param multiSelect If true, multi-selection will be enabled.
   * @return The current {@link Menu} instance.
   */
  public C setMultiSelect(boolean multiSelect) {
    this.multiSelect = multiSelect;
    return (C) this;
  }

  /**
   * Checks if the menu is set to automatically open.
   *
   * @return true if the menu will auto-open, false otherwise.
   */
  public boolean isAutoOpen() {
    return autoOpen;
  }

  /**
   * Sets whether the menu should automatically open.
   *
   * @param autoOpen If true, the menu will auto-open.
   * @return The current {@link Menu} instance.
   */
  public C setAutoOpen(boolean autoOpen) {
    this.autoOpen = autoOpen;
    return (C) this;
  }

  /**
   * Checks if the menu is set to fit the width of its target.
   *
   * @return true if the menu fits the target width, false otherwise.
   */
  public boolean isFitToTargetWidth() {
    return fitToTargetWidth;
  }

  /**
   * Sets whether the menu should fit the width of its target.
   *
   * @param fitToTargetWidth If true, the menu will fit the target width.
   * @return The current {@link Menu} instance.
   */
  public C setFitToTargetWidth(boolean fitToTargetWidth) {
    this.fitToTargetWidth = fitToTargetWidth;
    return (C) this;
  }

  /**
   * Pauses the selection listeners of the menu.
   *
   * @return The current {@link Menu} instance.
   */
  @Override
  public C pauseSelectionListeners() {
    this.togglePauseSelectionListeners(true);
    return (C) this;
  }

  /**
   * Resumes the paused selection listeners of the menu.
   *
   * @return The current {@link Menu} instance.
   */
  @Override
  public C resumeSelectionListeners() {
    this.togglePauseSelectionListeners(false);
    return (C) this;
  }

  /**
   * Toggles the pause state of the selection listeners.
   *
   * @param toggle If true, pauses the selection listeners; if false, resumes them.
   * @return The current {@link Menu} instance.
   */
  @Override
  public C togglePauseSelectionListeners(boolean toggle) {
    this.selectionListenersPaused = toggle;
    return (C) this;
  }

  /**
   * Retrieves the set of selection listeners associated with the menu.
   *
   * @return A set of selection listeners.
   */
  @Override
  public Set<SelectionListener<? super S, ? super List<S>>> getSelectionListeners() {
    return selectionListeners;
  }

  /**
   * Retrieves the set of deselection listeners associated with the menu.
   *
   * @return A set of deselection listeners.
   */
  @Override
  public Set<SelectionListener<? super S, ? super List<S>>> getDeselectionListeners() {
    return deselectionListeners;
  }

  /**
   * Checks if the selection listeners of the menu are currently paused.
   *
   * @return true if the selection listeners are paused, false otherwise.
   */
  @Override
  public boolean isSelectionListenersPaused() {
    return this.selectionListenersPaused;
  }

  /**
   * Triggers the selection listeners of the menu.
   *
   * @param source The source menu item that caused the selection.
   * @param selection A list of selected menu items.
   * @return The current {@link Menu} instance.
   */
  @Override
  public C triggerSelectionListeners(S source, List<S> selection) {
    new ArrayList<>(selectionListeners).forEach(
        listener -> listener.onSelectionChanged(Optional.ofNullable(source), selection));
    return (C) this;
  }

  /**
   * Triggers the deselection listeners of the menu.
   *
   * @param source The source menu item that caused the deselection.
   * @param selection A list of deselected menu items.
   * @return The current {@link Menu} instance.
   */
  @Override
  public C triggerDeselectionListeners(S source, List<S> selection) {
    new ArrayList<>(deselectionListeners).forEach(
        listener -> listener.onSelectionChanged(Optional.ofNullable(source), selection));
    return (C) this;
  }

  /**
   * Returns the current selection of menu items.
   *
   * @return A list of currently selected menu items.
   */
  @Override
  public List<S> getSelection() {
    return selectedValues;
  }

  /**
   * Sets the menu to have a bordered appearance.
   *
   * @param bordered If true, the menu will have a border; if false, it will not.
   * @return The current {@link Menu} instance.
   */
  public C setBordered(boolean bordered) {
    removeCss("menu-bordered");
    if (bordered) {
      css("menu-bordered");
    }
    return (C) this;
  }

  protected abstract boolean hasVisibleItems();

  /**
   * Checks if the menu is currently open.
   *
   * @return true if the menu is open, false otherwise.
   */
  public boolean isOpened() {
    return isDropDown() && isAttached();
  }

  /**
   * Opens the menu based on a triggering event.
   *
   * @param evt The event that triggered the open action.
   */
  private void open(Event evt) {
    getEffectiveDropDirection().init(evt);
    open();
  }

  /**
   * Opens the menu and optionally sets focus on it.
   *
   * @param focus If true, the menu will be focused upon opening.
   */
  public void open(boolean focus) {
    triggerOnBeforeOpenListeners();
    if (isDropDown() && openMenuCondition.check((C) this)) {
      if (getTarget().isPresent()) {
        DominoElement<Element> targetElement = getTarget().get().getTargetElement();
        targetElement.addCss(dui_context_menu_target_open);
        if (!(targetElement.isReadOnly() || targetElement.isDisabled())) {
          doOpen(focus);
        }
      } else {
        doOpen(focus);
      }
    }
  }

  /**
   * Opens the menu and manages the necessary UI changes and events.
   *
   * @param focus If true, the menu will be focused upon opening.
   */
  private void doOpen(boolean focus) {
    getConfig().getZindexManager().onPopupOpen(this);
    if (isOpened()) {
      position();
    } else {
      closeOthers();
      if (isSearchable()) {
        searchBox.get().clearSearch();
      }
      triggerOpenListeners((C) this);
      shouldFocus = focus;
      removeAttachObserver(onAttachHandler);
      onAttached(onAttachHandler);
      appendStrategy.onAppend(getMenuAppendTarget().element(), element.element());
      removeDetachObserver(onDetachHandler);
      onDetached(onDetachHandler);
      if (smallScreen) {
        onOpenForSmallScreen();
      }
      show();
    }
  }

  protected abstract void onOpenForSmallScreen();

  public C triggerOnBeforeOpenListeners() {
    if (isDropDown()) {
      getOnBeforeOpenListeners().forEach(listener -> listener.onBeforeOpen((C) this));
      DominoElement<Element> menuAppendTarget1 = getMenuAppendTarget();
      menuAppendTarget1.onDetached(onAppendTargetDetach);
    }
    return (C) this;
  }

  /** Adjusts the position of the menu relative to its target element. */
  protected void position() {
    if (isDropDown() && isOpened()) {
      Optional<DropTarget> menuTarget = getTarget();
      menuTarget.ifPresent(
          target -> {
            getEffectiveDropDirection()
                .position(
                    DropDirectionContext.of(
                        element.element(), target.getTargetElement().element(), fitToTargetWidth));
            DomGlobal.setTimeout(p -> startScrollFollow = true);
          });
    }
  }

  /**
   * Determines the effective drop direction of the menu based on various conditions.
   *
   * @return The drop direction for the menu.
   */
  protected DropDirection getEffectiveDropDirection() {
    if (isUseSmallScreensDirection() && smallScreen) {
      return smallScreenDropDirection;
    } else {
      if (isContextMenu()) {
        return contextMenuDropDirection;
      } else {
        return dropDirection;
      }
    }
  }

  /** Closes other menus if they are opened. */
  private void closeOthers() {
    if (this.hasAttribute("domino-sub-menu")
        && Boolean.parseBoolean(this.getAttribute("domino-sub-menu"))) {
      return;
    }
    PopupsCloser.close();
  }

  /** Sets the focus on the menu. */
  public void focus() {
    getFocusElement().focus();
  }

  /**
   * Gets the current target element for the menu.
   *
   * @return An optional containing the menu target, or empty if no target is set.
   */
  public Optional<DropTarget> getTarget() {
    if (isNull(lastTarget) && targets().size() == 1) {
      return targets().values().stream().findFirst();
    }
    return Optional.ofNullable(lastTarget);
  }

  /**
   * Sets the target element for the menu.
   *
   * @param targetElement The element to be set as the menu's target.
   * @return The current {@link Menu} instance.
   */
  public C setTargetElement(IsElement<?> targetElement) {
    return setTargetElement(targetElement.element());
  }

  /**
   * Sets the target element for the menu.
   *
   * @param targetElement The element to be set as the menu's target.
   * @return The current {@link Menu} instance.
   */
  public C setTargetElement(Element targetElement) {
    if (nonNull(targetElement)) {
      setTarget(DropTarget.of(targetElement));
    } else {
      clearTargets();
    }
    return (C) this;
  }

  /**
   * Sets the target element for the menu.
   *
   * @param targetElement The element to be set as the menu's target.
   * @return The current {@link Menu} instance.
   */
  public C addTargetElement(Element targetElement) {
    if (nonNull(targetElement)) {
      addTarget(DropTarget.of(targetElement));
    } else {
      clearTargets();
    }
    return (C) this;
  }

  /**
   * Sets the menu target.
   *
   * @param menuTarget The {@link DropTarget} instance representing the menu's target.
   * @return The current {@link Menu} instance.
   */
  public C setTarget(DropTarget menuTarget) {
    clearTargets();
    return addTarget(menuTarget);
  }

  public C clearTargets() {
    new ArrayList<>(this.targets().values()).forEach(this::removeTarget);
    return (C) this;
  }

  /**
   * Adds a new target for the menu.
   *
   * @param menuTarget The new target to add.
   * @return The current {@link Menu} instance.
   */
  public C addTarget(DropTarget menuTarget) {
    if (nonNull(menuTarget)) {
      this.targets().put(menuTarget.getTargetElement().getDominoId(), menuTarget);
      MutationObserverCallback detachCallback =
          MutationObserverCallback.doOnce(
              mutationRecord -> {
                if (Objects.equals(menuTarget, lastTarget)) {
                  close();
                }
                removeTarget(menuTarget);
              });
      menuTarget.setTargetDetachObserver(detachCallback);

      MutationObserverCallback attachCallback =
          MutationObserverCallback.doOnce(
              mutationRecord -> {
                BaseMenu.this
                    .targets()
                    .put(menuTarget.getTargetElement().getDominoId(), menuTarget);
              });

      menuTarget.setTargetAttachObserver(attachCallback);

      menuTarget.setObservers();
    }
    if (!this.targets().isEmpty()) {
      applyTargetListeners(menuTarget);
      setDropDown(true);
    } else {
      setDropDown(false);
    }
    return (C) this;
  }

  /**
   * Removes a single menu target.
   *
   * @param target the target to be removed
   * @return same menu instance
   */
  public C removeTarget(DropTarget target) {
    if (nonNull(target) && targets().containsKey(target.getTargetElement().getDominoId())) {
      DropTarget menuTarget = targets().get(target.getTargetElement().getDominoId());
      menuTarget
          .getTargetElement()
          .removeEventListener(
              isContextMenu() ? EventType.contextmenu.getName() : EventType.click.getName(),
              openListener);
      targets.remove(menuTarget.getTargetElement().getDominoId());
      DominoElement<Element> targetElement = menuTarget.getTargetElement();

      targetElement.onAttached(
          MutationObserverCallback.doOnce(
              mutationRecord -> {
                if (!targets().containsKey(targetElement.getDominoId())) {
                  addTargetElement(targetElement.element());
                }
              }));

      menuTarget.cleanUp();
      if (Objects.equals(lastTarget, menuTarget)) {
        this.lastTarget = null;
      }
    }
    return (C) this;
  }

  /**
   * Gets the element to which the menu is appended in the DOM.
   *
   * @return The append target element.
   */
  public DominoElement<Element> getMenuAppendTarget() {
    return menuAppendTarget;
  }

  /**
   * Sets the element to which the menu will be appended in the DOM.
   *
   * @param appendTarget The new append target element.
   * @return The current {@link Menu} instance.
   */
  public C setMenuAppendTarget(Element appendTarget) {
    if (isNull(appendTarget)) {
      this.menuAppendTarget = elementOf(document.body);
    } else {
      this.menuAppendTarget = elementOf(appendTarget);
    }
    return (C) this;
  }

  /**
   * Opens the menu if it is a dropdown type.
   *
   * @return The current {@link Menu} instance.
   */
  public C open() {
    if (isDropDown()) {
      open(isAutoFocus());
    }
    return (C) this;
  }

  /**
   * Closes the menu if it is a dropdown type and if it is currently open.
   *
   * @return The current {@link Menu} instance.
   */
  public C close() {
    if (isDropDown()) {
      if (isOpened()) {
        this.remove();
        removeAttribute(DUI_POSITION_FALLBACK);
        getTarget()
            .ifPresent(
                menuTarget -> {
                  menuTarget.getTargetElement().element().focus();
                  menuTarget.getTargetElement().removeCss(dui_context_menu_target_open);
                });
        if (isSearchable()) {
          searchBox.get().clearSearch();
        }
        onClosed();
      }
      removeCssProperty(SpaceChecker.MAX_HEIGHT);
      removeCssProperty(SpaceChecker.MAX_WIDTH);
      getMenuAppendTarget().removeDetachObserver(onAppendTargetDetach);
    }
    return (C) this;
  }

  protected abstract void onClosed();

  /**
   * Retrieves the direction in which the menu will drop when opened.
   *
   * @return The current drop direction for the menu.
   */
  public DropDirection getDropDirection() {
    return dropDirection;
  }

  /**
   * Sets the direction in which the menu will drop when opened.
   *
   * @param dropDirection The desired drop direction.
   * @return The current {@link Menu} instance.
   */
  public C setDropDirection(DropDirection dropDirection) {
    if (nonNull(this.dropDirection)) {
      this.dropDirection.cleanup(this.element());
    }

    if (nonNull(this.effectiveDropDirection)) {
      this.effectiveDropDirection.cleanup(this.element());
    }

    if (effectiveDropDirection.equals(this.dropDirection)) {
      this.dropDirection = dropDirection;
      this.effectiveDropDirection = this.dropDirection;
    } else {
      this.dropDirection = dropDirection;
    }
    return (C) this;
  }

  /**
   * Checks if the menu is set as a context menu.
   *
   * @return {@code true} if the menu is a context menu, {@code false} otherwise.
   */
  public boolean isContextMenu() {
    return contextMenu;
  }

  /**
   * Sets the menu as a context menu or not.
   *
   * @param contextMenu {@code true} to set the menu as a context menu, {@code false} otherwise.
   * @return The current {@link Menu} instance.
   */
  public C setContextMenu(boolean contextMenu) {
    this.contextMenu = contextMenu;
    addCss(BooleanCssClass.of(dui_context_menu, contextMenu));
    targets().values().forEach(this::applyTargetListeners);
    return (C) this;
  }

  /**
   * Applies the appropriate event listeners to the target element based on whether the menu is a
   * context menu or not.
   *
   * @param menuTarget The target menu to which the listeners should bce applied.
   */
  private void applyTargetListeners(DropTarget menuTarget) {
    if (nonNull(menuTarget)) {
      if (isContextMenu()) {
        menuTarget.getTargetElement().removeEventListener(EventType.click.getName(), openListener);
        menuTarget
            .getTargetElement()
            .addEventListener(EventType.contextmenu.getName(), openListener);
      } else {
        menuTarget
            .getTargetElement()
            .removeEventListener(EventType.contextmenu.getName(), openListener);
        menuTarget.getTargetElement().addEventListener(EventType.click.getName(), openListener);
      }
    }
  }

  /**
   * Handles the event when an item is selected in the menu.
   *
   * @param item The item that was selected.
   * @param silent Indicates whether the selection was silent or should trigger events.
   */
  protected abstract void onItemSelected(S item, boolean silent, boolean shouldClose);

  /**
   * Handles the event when an item is deselected in the menu.
   *
   * @param item The item that was deselected.
   * @param silent Indicates whether the deselection was silent or should trigger events.
   */
  protected abstract void onItemDeselected(S item, boolean silent, boolean shouldClose);

  /**
   * Checks if the menu is configured to use the small screens direction for dropping.
   *
   * @return {@code true} if the menu uses the small screens direction, {@code false} otherwise.
   */
  public boolean isUseSmallScreensDirection() {
    return useSmallScreensDirection;
  }

  /**
   * Sets whether the menu should use the small screens drop direction.
   *
   * @param useSmallScreensDropDirection {@code true} to enable small screens drop direction, {@code
   *     false} otherwise.
   * @return The current {@link Menu} instance.
   */
  public C setUseSmallScreensDirection(boolean useSmallScreensDropDirection) {
    this.useSmallScreensDirection = useSmallScreensDropDirection;
    if (!useSmallScreensDropDirection && getEffectiveDropDirection() == smallScreenDropDirection) {
      this.effectiveDropDirection = dropDirection;
    }
    return (C) this;
  }

  /**
   * Determines if the menu acts as a drop-down or a context menu.
   *
   * @return {@code true} if the menu acts as a drop-down or a context menu, {@code false}
   *     otherwise.
   */
  public boolean isDropDown() {
    return dropDown || isContextMenu();
  }

  /**
   * Sets the menu's behavior to be a dropdown or not. It also adjusts attributes and listeners
   * accordingly.
   *
   * @param dropdown {@code true} to set the menu as a dropdown, {@code false} otherwise.
   */
  private void setDropDown(boolean dropdown) {
    if (dropdown) {
      this.setAttribute("domino-ui-root-menu", true).setAttribute(DOMINO_UI_AUTO_CLOSABLE, true);
      getMenuElement().addCss(dui_menu_elevation);
    } else {
      this.removeAttribute("domino-ui-root-menu").removeAttribute(DOMINO_UI_AUTO_CLOSABLE);
      dui_menu_elevation.remove(getMenuElement());
      document.removeEventListener("scroll", repositionListener);
    }
    addCss(BooleanCssClass.of(dui_menu_drop, dropdown));
    this.dropDown = dropdown;
    setAutoClose(this.dropDown);
  }

  protected abstract DivElement getMenuElement();

  /**
   * Adds a handler that is triggered when a new item is added to the menu.
   *
   * @param onAddItemHandler The handler to add.
   * @return The current {@link Menu} instance.
   */
  public C addOnAddItemHandler(OnAddItemHandler<V, C, I, S> onAddItemHandler) {
    if (nonNull(onAddItemHandler)) {
      this.onAddItemHandlers.add(onAddItemHandler);
    }
    return (C) this;
  }

  /**
   * Configures the menu to include a header.
   *
   * @return The current {@link Menu} instance.
   */
  public C withHeader() {
    menuHeader.get();
    return (C) this;
  }

  /**
   * Configures the menu to include a customized header.
   *
   * @param handler A handler to customize the header.
   * @return The current {@link Menu} instance.
   */
  public C withHeader(ChildHandler<C, NavBar> handler) {
    handler.apply((C) this, menuHeader.get());
    return (C) this;
  }

  /**
   * Checks if the menu is modal.
   *
   * @return {@code false} since the menu isn't a modal.
   */
  @Override
  public boolean isModal() {
    return false;
  }

  /**
   * Checks if the menu is set to auto-close.
   *
   * @return {@code true} if the menu is set to auto-close, {@code false} otherwise.
   */
  @Override
  public boolean isAutoClose() {
    return Boolean.parseBoolean(getAttribute(DOMINO_UI_AUTO_CLOSABLE, "false"));
  }

  /**
   * Sets the auto-close behavior for the menu.
   *
   * @param autoClose {@code true} to set the menu to auto-close, {@code false} otherwise.
   * @return The current {@link Menu} instance.
   */
  public C setAutoClose(boolean autoClose) {
    if (autoClose) {
      setAttribute(DOMINO_UI_AUTO_CLOSABLE, "true");
    } else {
      removeAttribute(DOMINO_UI_AUTO_CLOSABLE);
    }
    return (C) this;
  }

  /**
   * Sets the condition for opening the menu.
   *
   * @param openMenuCondition A condition that needs to be met for the menu to open. If null,
   *     defaults to always allow the menu to open.
   * @return The current {@link Menu} instance.
   */
  public C setOpenMenuCondition(OpenMenuCondition<V, C, I, S> openMenuCondition) {
    if (isNull(openMenuCondition)) {
      this.openMenuCondition = menu -> true;
      return (C) this;
    }
    this.openMenuCondition = openMenuCondition;
    return (C) this;
  }

  /**
   * Checks if the menu is set to close when it loses focus.
   *
   * @return {@code true} if the menu is set to close on blur, {@code false} otherwise.
   */
  public boolean isCloseOnBlur() {
    return closeOnBlur;
  }

  /**
   * Sets the close-on-blur behavior for the menu.
   *
   * @param closeOnBlur {@code true} to set the menu to close when it loses focus, {@code false}
   *     otherwise.
   * @return The current {@link Menu} instance.
   */
  public C setCloseOnBlur(boolean closeOnBlur) {
    this.closeOnBlur = closeOnBlur;
    return (C) this;
  }

  public C setCloseOnScroll(boolean closeOnScroll) {
    if (!closeOnScroll) {
      window.removeEventListener("scroll", closeOnScrollListener);
    }
    setAttribute("d-close-on-scroll", closeOnScroll);
    return (C) this;
  }

  protected boolean isCloseOnScroll() {
    return hasAttribute("d-close-on-scroll")
        && "true".equalsIgnoreCase(getAttribute("d-close-on-scroll"));
  }

  private Map<String, DropTarget> targets() {
    if (isNull(this.targets)) {
      this.targets = new HashMap<>();
    }
    return this.targets;
  }

  /**
   * @return boolean true if the selection style should be preserved after the menu item loses the
   *     selection focus, otherwise false.
   */
  public boolean isPreserveSelectionStyles() {
    return preserveSelectionStyles;
  }

  /**
   * if true selecting an Item in the menu will preserve the selection style when the menu loses the
   * focus.
   *
   * @param preserveSelectionStyles boolean, true to preserve the style, false to remove the style.
   * @return same Menu instance.
   */
  public C setPreserveSelectionStyles(boolean preserveSelectionStyles) {
    this.preserveSelectionStyles = preserveSelectionStyles;
    return (C) this;
  }

  @Override
  public ZIndexLayer getZIndexLayer() {
    if (isDropDown()) {
      return getTarget()
          .map(t -> t.getTargetElement().getZIndexLayer())
          .orElse(ZIndexLayer.Z_LAYER_1);
    }
    return super.getZIndexLayer();
  }

  /**
   * Retrieves the set of {@link OpenListener}s registered for this element.
   *
   * @return A set of {@link OpenListener} instances.
   */
  public Set<OnBeforeOpenListener<? super C>> getOnBeforeOpenListeners() {
    return onBeforeOpenListeners();
  }

  private Set<OnBeforeOpenListener<? super C>> onBeforeOpenListeners() {
    if (isNull(this.onBeforeOpenListeners)) {
      this.onBeforeOpenListeners = new HashSet<>();
    }
    return onBeforeOpenListeners;
  }

  /**
   * Adds an open event listener to the element.
   *
   * @param onBeforeOpenListener The open event listener to be added.
   * @return The element with the open event listener added.
   */
  public C addOnBeforeOpenListener(OnBeforeOpenListener<? super C> onBeforeOpenListener) {
    getOnBeforeOpenListeners().add(onBeforeOpenListener);
    return (C) this;
  }

  /**
   * Removes a close event listener from the element.
   *
   * @param onBeforeOpenListener The close event listener to be removed.
   * @return The element with the close event listener removed.
   */
  public C removeOnBeforeOpenListener(OnBeforeOpenListener<? super C> onBeforeOpenListener) {
    getOnBeforeOpenListeners().remove(onBeforeOpenListener);
    return (C) this;
  }

  public C setSelectionMode(SingleSelectionMode selectionMode) {
    this.selectionMode = selectionMode;
    return (C) this;
  }

  public C setAutoFocus(boolean autoFocus) {
    this.autoFocus = autoFocus;
    return (C) this;
  }

  public boolean isAutoFocus() {
    return autoFocus;
  }

  public abstract SingleSelectionMode getEffectiveSelectionMode();

  protected abstract Element getMenuListElement();

  /** Represents a handler called when a new item is added to the menu. */
  public interface OnAddItemHandler<
      V, C extends IsMenu<V, C, I, S>, I extends IsMenuItem<V, I, S>, S extends Selectable<S>> {

    /**
     * Called when a new menu item is added.
     *
     * @param menu The menu to which the item was added.
     * @param menuItem The added menu item.
     */
    void onAdded(C menu, I menuItem);
  }

  public interface OnBeforeOpenListener<T> {
    void onBeforeOpen(T target);
  }
}
