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
package org.dominokit.domino.ui.breadcrumbs;

import static java.util.Objects.nonNull;
import static org.dominokit.domino.ui.breadcrumbs.BreadcrumbStyles.dui_breadcrumb;

import elemental2.dom.EventListener;
import elemental2.dom.HTMLOListElement;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import org.dominokit.domino.ui.elements.OListElement;
import org.dominokit.domino.ui.icons.Icon;
import org.dominokit.domino.ui.utils.BaseDominoElement;
import org.dominokit.domino.ui.utils.HasBackground;
import org.dominokit.domino.ui.utils.HasChangeListeners;

/**
 * Provides current location in a navigational hierarchy.
 *
 * <p>This component displays locations with the ability to navigate between them and highlighting
 * the current one, each location can have text and icon with a click listener that will be called
 * when user clicks on it.
 *
 * <p>Customize the component can be done by overwriting classes provided by {@link
 * BreadcrumbStyles}
 *
 * @see BaseDominoElement
 * @see HasBackground
 * @see BreadcrumbItem
 */
public class Breadcrumb extends BaseDominoElement<HTMLOListElement, Breadcrumb>
    implements HasChangeListeners<Breadcrumb, BreadcrumbItem> {
  private final OListElement element;
  private final List<BreadcrumbItem> items = new ArrayList<>();
  private final Set<ChangeListener<? super BreadcrumbItem>> changeListeners = new HashSet<>();
  private BreadcrumbItem activeItem;
  private boolean removeTail = false;

  private boolean changeListenersPaused = false;

  /** Constructor for Breadcrumb. */
  public Breadcrumb() {
    element = ol().addCss(dui_breadcrumb);
    init(this);
  }

  /**
   * Creates new empty breadcrumb
   *
   * @return new breadcrumb instance
   */
  public static Breadcrumb create() {
    return new Breadcrumb();
  }

  /**
   * Adds new location with {@code text} and {@code onClick} listener
   *
   * @param text the label of the location
   * @param onClick {@link elemental2.dom.EventListener} that will be called when the location is
   *     clicked
   * @return same instance
   */
  public Breadcrumb appendChild(String text, EventListener onClick) {
    BreadcrumbItem item = BreadcrumbItem.create(text);
    addAndActivateNewItem(item);
    item.addClickListener(onClick);
    return this;
  }

  /**
   * Adds new location with {@code text}, {@code icon} and {@code onClick} listener
   *
   * @param icon the {@link org.dominokit.domino.ui.icons.Icon} of the location
   * @param text the label of the location
   * @param onClick {@link elemental2.dom.EventListener} that will be called when the location is
   *     clicked
   * @return same instance
   */
  public Breadcrumb appendChild(Icon<?> icon, String text, EventListener onClick) {
    BreadcrumbItem item = BreadcrumbItem.create(icon, text);
    addAndActivateNewItem(item);
    item.addClickListener(onClick);
    return this;
  }

  /**
   * Adds new location by providing {@link org.dominokit.domino.ui.breadcrumbs.BreadcrumbItem},
   * change handler can be triggered
   *
   * @param items the {@link org.dominokit.domino.ui.breadcrumbs.BreadcrumbItem} location to be
   *     added
   * @return same instance
   */
  public Breadcrumb appendChild(BreadcrumbItem... items) {
    return appendChild(false, items);
  }

  /**
   * Adds new location by providing {@link org.dominokit.domino.ui.breadcrumbs.BreadcrumbItem}
   *
   * @param silent boolean, if true dont trigger change handlers
   * @param items the {@link org.dominokit.domino.ui.breadcrumbs.BreadcrumbItem} location to be
   *     added
   * @return same instance
   */
  public Breadcrumb appendChild(boolean silent, BreadcrumbItem... items) {
    for (BreadcrumbItem item : items) {
      addNewItem(item);
    }
    setActiveItem(this.items.get(this.items.size() - 1), silent);
    return this;
  }

  /**
   * Adds new location by providing {@link org.dominokit.domino.ui.breadcrumbs.BreadcrumbItem}
   *
   * @param item the {@link org.dominokit.domino.ui.breadcrumbs.BreadcrumbItem} location to be added
   * @return same instance
   */
  public Breadcrumb appendChild(BreadcrumbItem item) {
    addAndActivateNewItem(item);
    return this;
  }

  /**
   * Remove child BreadcrumbItems from a given index, inclusive.
   *
   * @param itemFromIndex the {@link org.dominokit.domino.ui.breadcrumbs.BreadcrumbItem} index from
   *     which and all its siblings are removed.
   * @param silent boolean, if true dont trigger change handlers
   * @return same instance
   */
  public Breadcrumb removeChildFrom(int itemFromIndex, boolean silent) {
    List<BreadcrumbItem> removedItems = items.subList(itemFromIndex, items.size());
    removedItems.forEach(BaseDominoElement::remove);

    items.removeAll(removedItems);

    if (activeItem != null && !items.contains(activeItem)) {
      if (items.isEmpty()) activeItem = null;
      else setActiveItem(items.get(items.size() - 1), silent);
    }

    return this;
  }

  private void addAndActivateNewItem(BreadcrumbItem item) {
    addNewItem(item);
    setActiveItem(item);
  }

  private void addNewItem(BreadcrumbItem item) {
    items.add(item);
    element.appendChild(item);
    elementOf(item.getClickableElement())
        .addClickListener(
            e -> {
              if (!isDisabled()) {
                setActiveItem(item);
              }
            });
  }

  /**
   * Set a given item as the active item of the breadcrumb, change handler can be triggered
   *
   * @param item The item be set as active one
   * @return same instance
   */
  public Breadcrumb setActiveItem(BreadcrumbItem item) {
    return setActiveItem(item, false);
  }

  /**
   * Set a given item as the active item of the breadcrumb
   *
   * @param item The item be set as active one
   * @param silent boolean, if true dont trigger change handlers
   * @return same instance
   */
  public Breadcrumb setActiveItem(BreadcrumbItem item, boolean silent) {
    // If item is already active, do nothing here.
    if (item.isActive()) {
      return this;
    }

    BreadcrumbItem oldValue;
    if (nonNull(activeItem)) {
      oldValue = activeItem;
      activeItem.deActivate();
    } else {
      oldValue = null;
    }
    item.activate();
    activeItem = item;
    if (removeTail) {
      int index = items.indexOf(item) + 1;
      while (items.size() > index) {
        items.get(items.size() - 1).element().remove();
        items.remove(items.size() - 1);
      }
    }

    if (!silent && !changeListenersPaused) {
      triggerChangeListeners(oldValue, activeItem);
    }

    return this;
  }

  /**
   * If true, then selecting location will remove the tailing ones.
   *
   * <p>For example:
   *
   * <ul>
   *   <li>Given {@code removeTail} is true and having 4 locations as follows:
   *       <p><strong>A</strong> -> <strong>B</strong> -> <strong>C</strong> -> <strong>D</strong>
   *       <p>when selecting location <strong>B</strong>, then the new locations will be as follows:
   *       <p><strong>A</strong> -> <strong><u>B</u></strong>
   *   <li>Given {@code removeTail} is false and having 4 locations as follows:
   *       <p><strong>A</strong> -> <strong>B</strong> -> <strong>C</strong> -> <strong>D</strong>
   *       <p>when selecting location <strong>B</strong>, then the new locations will be as follows:
   *       <p><strong>A</strong> -> <strong><u>B</u></strong> -> <strong>C</strong> ->
   *       <strong>D</strong>
   * </ul>
   *
   * @param removeTail true for activating remove tail, false otherwise
   * @return same instance
   */
  public Breadcrumb setRemoveActiveTailItem(boolean removeTail) {
    this.removeTail = removeTail;
    return this;
  }

  /**
   * Removes all locations from the breadcrumb
   *
   * @return same instance
   */
  public Breadcrumb removeAll() {
    items.forEach(BaseDominoElement::remove);
    items.clear();
    this.activeItem = null;
    return this;
  }

  /** {@inheritDoc} */
  @Override
  public HTMLOListElement element() {
    return element.element();
  }

  /** @return The active {@link BreadcrumbItem} location */
  /**
   * Getter for the field <code>activeItem</code>.
   *
   * @return a {@link org.dominokit.domino.ui.breadcrumbs.BreadcrumbItem} object
   */
  public BreadcrumbItem getActiveItem() {
    return activeItem;
  }

  /** @return All {@link BreadcrumbItem} locations */
  /**
   * Getter for the field <code>items</code>.
   *
   * @return a {@link java.util.List} object
   */
  public List<BreadcrumbItem> getItems() {
    return items;
  }

  /** {@inheritDoc} */
  @Override
  public Breadcrumb addChangeListener(ChangeListener<? super BreadcrumbItem> changeListener) {
    changeListeners.add(changeListener);
    return this;
  }

  /** {@inheritDoc} */
  @Override
  public Breadcrumb removeChangeListener(ChangeListener<? super BreadcrumbItem> changeListener) {
    changeListeners.remove(changeListener);
    return this;
  }

  /** {@inheritDoc} */
  @Override
  public boolean hasChangeListener(ChangeListener<? super BreadcrumbItem> changeListener) {
    return changeListeners.contains(changeListener);
  }

  /** {@inheritDoc} */
  @Override
  public Breadcrumb pauseChangeListeners() {
    this.changeListenersPaused = true;
    return this;
  }

  /** {@inheritDoc} */
  @Override
  public Breadcrumb resumeChangeListeners() {
    this.changeListenersPaused = false;
    return this;
  }

  /** {@inheritDoc} */
  @Override
  public Breadcrumb togglePauseChangeListeners(boolean toggle) {
    this.changeListenersPaused = toggle;
    return this;
  }

  /** {@inheritDoc} */
  @Override
  public Set<ChangeListener<? super BreadcrumbItem>> getChangeListeners() {
    return changeListeners;
  }

  /** {@inheritDoc} */
  @Override
  public boolean isChangeListenersPaused() {
    return this.changeListenersPaused;
  }

  /** {@inheritDoc} */
  @Override
  public Breadcrumb triggerChangeListeners(BreadcrumbItem oldValue, BreadcrumbItem newValue) {
    changeListeners.forEach(changeListener -> changeListener.onValueChanged(oldValue, newValue));
    return this;
  }
}
