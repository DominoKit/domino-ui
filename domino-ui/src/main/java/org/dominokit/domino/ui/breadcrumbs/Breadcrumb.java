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
 * A component to represent the navigation path the user took to reach the current view or page
 *
 * <p>This component displays locations with the ability to navigate between them and highlighting
 * the current one, each location can have text and icon with a click listener.
 */
public class Breadcrumb extends BaseDominoElement<HTMLOListElement, Breadcrumb>
    implements HasChangeListeners<Breadcrumb, BreadcrumbItem> {
  private final OListElement element;
  private final List<BreadcrumbItem> items = new ArrayList<>();
  private final Set<ChangeListener<? super BreadcrumbItem>> changeListeners = new HashSet<>();
  private BreadcrumbItem activeItem;
  private boolean removeTail = false;

  private boolean changeListenersPaused = false;

  /**
   * Creates an empty breadcrumb instance
   */
  public Breadcrumb() {
    element = ol().addCss(dui_breadcrumb);
    init(this);
  }

  /**
   * Factory method to create new empty breadcrumb instance
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
   * @return same breadcrumb instance
   */
  public Breadcrumb appendChild(String text, EventListener onClick) {
    BreadcrumbItem item = BreadcrumbItem.create(text);
    addAndActivateNewItem(item);
    item.addClickListener(onClick);
    return this;
  }

  /**
   * Creates a new {@link BreadcrumbItem} with the provided <b>icon</b>, <b>text</b>, and <b>click</b> listener
   * and add it to the current breadcrumb instance
   *
   * @param icon the {@link org.dominokit.domino.ui.icons.Icon} of the location
   * @param text the label of the location
   * @param onClick {@link elemental2.dom.EventListener} that will be called when the location is
   *     clicked
   * @return same breadcrumb instance
   */
  public Breadcrumb appendChild(Icon<?> icon, String text, EventListener onClick) {
    BreadcrumbItem item = BreadcrumbItem.create(icon, text);
    addAndActivateNewItem(item);
    item.addClickListener(onClick);
    return this;
  }

  /**
   * Adds provided {@link BreadcrumbItem}s to the current Breadcrumb instance
   *
   * @param items the {@link org.dominokit.domino.ui.breadcrumbs.BreadcrumbItem}s  to be added
   * @return same breadcrumb instance
   */
  public Breadcrumb appendChild(BreadcrumbItem... items) {
    return appendChild(false, items);
  }

  /**
   * Adds the provided {@link org.dominokit.domino.ui.breadcrumbs.BreadcrumbItem}s then activate the last item
   * and checks the silent flag to decide on calling the change listeners.
   *
   * @param silent boolean, if <b>true</b> to ignore the change listeners, otherwise change listeners will be triggered.
   * @param items the {@link org.dominokit.domino.ui.breadcrumbs.BreadcrumbItem}s to be added
   * @return same breadcrumb instance
   */
  public Breadcrumb appendChild(boolean silent, BreadcrumbItem... items) {
    for (BreadcrumbItem item : items) {
      addNewItem(item);
    }
    setActiveItem(this.items.get(this.items.size() - 1), silent);
    return this;
  }

  /**
   * Adds the provided {@link org.dominokit.domino.ui.breadcrumbs.BreadcrumbItem} to the current breadcrumb instance
   *
   * @param item the {@link org.dominokit.domino.ui.breadcrumbs.BreadcrumbItem} to be added
   * @return same breadcrumb instance
   */
  public Breadcrumb appendChild(BreadcrumbItem item) {
    addAndActivateNewItem(item);
    return this;
  }

  /**
   * Remove all breadcrumb items starting from the provided index inclusive.
   *
   * @param itemFromIndex the starting index from of the breadcrumb items to be removed
   * @param silent boolean, if <b>true</b> dont trigger change listeners
   * @return same breadcrumb instance
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
   * Set a given item as the active item of the breadcrumb and trigger the change listeners.
   *
   * @param item The item be set as active one
   * @return same breadcrumb instance
   */
  public Breadcrumb setActiveItem(BreadcrumbItem item) {
    return setActiveItem(item, false);
  }

  /**
   * Set the active breadcrumb item and ignore the change listeners if the <b>silent</b> flag is <b>true</b>.
   *
   * @param item The item be set as active one
   * @param silent boolean, if true dont trigger change handlers
   * @return same breadcrumb instance
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
   * If true, then activating a breadcrumb item will remove the tailing ones.
   *
   * <p>Default to <b>false</b></p>
   *
   * <p>Example:
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
   * @param removeTail <b>true</b> to enable remove tail on item activation, <b>false</b> to disable it.
   * @return same breadcrumb instance
   */
  public Breadcrumb setRemoveActiveTailItem(boolean removeTail) {
    this.removeTail = removeTail;
    return this;
  }

  /**
   * Removes all breadcrumb items from the breadcrumb
   *
   * @return same breadcrumb instance
   */
  public Breadcrumb removeAll() {
    items.forEach(BaseDominoElement::remove);
    items.clear();
    this.activeItem = null;
    return this;
  }

  /** @hidden {@inheritDoc} */
  @Override
  public HTMLOListElement element() {
    return element.element();
  }

  /**
   *
   * @return a current active {@link org.dominokit.domino.ui.breadcrumbs.BreadcrumbItem}
   */
  public BreadcrumbItem getActiveItem() {
    return activeItem;
  }

  /**
   * @return a List of all breadcrumb items currently available in the breadcrumb instance.
   */
  public List<BreadcrumbItem> getItems() {
    return items;
  }

  /**
   * Adds a listener that will be triggered when the active breadcrumb item is changed.
   * @param changeListener {@link org.dominokit.domino.ui.utils.HasChangeListeners.ChangeListener}
   * @return same breadcrumb instance
   */
  @Override
  public Breadcrumb addChangeListener(ChangeListener<? super BreadcrumbItem> changeListener) {
    changeListeners.add(changeListener);
    return this;
  }

  /**
   * Removes an already registered change listener
   * @param changeListener {@link org.dominokit.domino.ui.utils.HasChangeListeners.ChangeListener}
   * @return same breadcrumb instance
   */
  @Override
  public Breadcrumb removeChangeListener(ChangeListener<? super BreadcrumbItem> changeListener) {
    changeListeners.remove(changeListener);
    return this;
  }

  /**
   * Checks if the breadcrumb already has the provided change listener registered.
   * @param changeListener {@link org.dominokit.domino.ui.utils.HasChangeListeners.ChangeListener}
   * @return same breadcrumb instance
   */
  @Override
  public boolean hasChangeListener(ChangeListener<? super BreadcrumbItem> changeListener) {
    return changeListeners.contains(changeListener);
  }

  /**
   * Once called change listeners will not be triggered when the active breadcrumb item is changed until <b>resumeChangeListeners</b>
   * is called.
   * @return same breadcrumb instance
   */
  @Override
  public Breadcrumb pauseChangeListeners() {
    this.changeListenersPaused = true;
    return this;
  }

  /**
   * revert the effect of <b>pauseChangeListeners</b>
   * @return same breadcrumb instance
   */
  @Override
  public Breadcrumb resumeChangeListeners() {
    this.changeListenersPaused = false;
    return this;
  }

  /**
   * Pause ore resume change listeners based on the provided flag
   * @param toggle boolean, <b>true</b> to pause the change listeners, <b>false</b> to resume the change listeners.
   * @return same breadcrumb instance
   */
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
