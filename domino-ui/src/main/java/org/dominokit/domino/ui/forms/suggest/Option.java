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
package org.dominokit.domino.ui.forms.suggest;

import static java.util.Objects.nonNull;
import static org.dominokit.domino.ui.utils.Domino.*;
import static org.dominokit.domino.ui.utils.Domino.span;

import elemental2.dom.DomGlobal;
import elemental2.dom.Element;
import elemental2.dom.Node;
import java.util.Objects;
import jsinterop.base.Js;
import org.dominokit.domino.ui.IsElement;
import org.dominokit.domino.ui.menu.AbstractMenuItem;
import org.dominokit.domino.ui.utils.BaseDominoElement;
import org.dominokit.domino.ui.utils.ChildHandler;
import org.dominokit.domino.ui.utils.MatchHighlighter;

/**
 * The base class for suggestion options used in suggestion components. It provides functionality
 * for creating and managing suggestion options, such as components and menu items.
 *
 * @param <V> The type of value associated with the suggestion option.
 * @param <C> The type of component used in the suggestion option.
 * @param <O> The type of the suggestion option itself.
 * @see BaseDominoElement
 */
public abstract class Option<V, C extends IsElement<?>, O extends Option<V, C, O>>
    extends BaseDominoElement<Element, Option<V, C, O>> {

  private final C component;
  private final AbstractMenuItem<V> menuItem;

  private final String key;
  private final V value;
  protected HasSuggestOptions<V, C, O> target;

  /**
   * Constructs an Option with the provided key, value, component, and menu item.
   *
   * @param key The unique key of the option.
   * @param value The value associated with the option.
   * @param component The component representing the option.
   * @param menuItem The menu item corresponding to the option.
   */
  public Option(String key, V value, C component, AbstractMenuItem<V> menuItem) {
    this.key = key;
    this.value = value;
    this.component = component;
    this.menuItem = menuItem;
    this.menuItem.setKey(key);
    this.menuItem.setValue(value);
    this.menuItem.applyMeta(OptionMeta.of(component, (O) this));
    init(this);
  }

  /**
   * Constructs an Option with the provided key, value, and component using supplier functions.
   *
   * @param key The unique key of the option.
   * @param value The value associated with the option.
   * @param componentSupplier A supplier function for creating the component.
   * @param menuItemSupplier A supplier function for creating the menu item.
   */
  public Option(
      String key,
      V value,
      OptionSupplier<C, V> componentSupplier,
      OptionSupplier<AbstractMenuItem<V>, V> menuItemSupplier) {
    this.key = key;
    this.value = value;
    this.component = componentSupplier.get(key, value);
    this.menuItem = menuItemSupplier.get(key, value);
    this.menuItem.setKey(key);
    this.menuItem.setValue(value);
    this.menuItem.applyMeta(OptionMeta.of(component, (O) this));
    init(this);
  }

  /**
   * Gets the component associated with this option.
   *
   * @return The component representing this option.
   */
  public C getComponent() {
    return component;
  }

  /**
   * Gets the menu item associated with this option.
   *
   * @return The menu item corresponding to this option.
   */
  public AbstractMenuItem<V> getMenuItem() {
    return menuItem;
  }

  /**
   * Gets the unique key of this option.
   *
   * @return The unique key of this option.
   */
  public String getKey() {
    return key;
  }

  /**
   * Gets the value associated with this option.
   *
   * @return The value associated with this option.
   */
  public V getValue() {
    return value;
  }
  /**
   * Attaches a menu item to this option using a handler function. The handler function allows
   * customizing the menu item associated with this option.
   *
   * @param handler A handler function that takes this option and the menu item and applies
   *     customizations.
   * @return This option instance for method chaining.
   */
  public O withMenuItem(ChildHandler<O, AbstractMenuItem<V>> handler) {
    handler.apply((O) this, menuItem);
    return (O) this;
  }

  /**
   * Attaches a component to this option using a handler function. The handler function allows
   * customizing the component associated with this option.
   *
   * @param handler A handler function that takes this option and the component and applies
   *     customizations.
   * @return This option instance for method chaining.
   */
  public O withComponent(ChildHandler<O, C> handler) {
    handler.apply((O) this, component);
    return (O) this;
  }

  /**
   * Returns the DOM element of the component associated with this option.
   *
   * @return The DOM element of the component.
   */
  @Override
  public Element element() {
    return component.element();
  }

  /**
   * Sets whether the menu item of this option is searchable.
   *
   * @param searchable {@code true} to make the menu item searchable, {@code false} otherwise.
   * @return This option instance for method chaining.
   */
  public O setSearchable(boolean searchable) {
    this.menuItem.setSearchable(searchable);
    return (O) this;
  }

  /**
   * Highlights the menu item of this option based on a search term.
   *
   * @param displayValue The search term to highlight within the menu item.
   */
  public void highlight(String displayValue) {
    if (nonNull(displayValue) && displayValue.length() > 0) {
      highlightNode(menuItem.getClickableElement(), displayValue);
    }
  }

  /**
   * Binds this option to a target that implements {@link HasSuggestOptions}.
   *
   * @param target The target to bind this option to.
   * @return This option instance for method chaining.
   */
  public O bindTo(HasSuggestOptions<V, C, O> target) {
    this.target = target;
    return (O) this;
  }

  /**
   * Unbinds this option from its target.
   *
   * @return This option instance for method chaining.
   */
  public O unbindTarget() {
    this.target = null;
    return (O) this;
  }

  /**
   * Gets the target to which this option is bound.
   *
   * @return The target to which this option is bound.
   */
  public HasSuggestOptions<V, C, O> getTarget() {
    return target;
  }

  /**
   * Highlights text within a DOM node based on a search term. This method recursively traverses
   * child nodes of the given node to apply highlighting to text nodes.
   *
   * @param node The DOM node to apply highlighting to.
   * @param searchTerm The search term used for highlighting.
   */
  private void highlightNode(Node node, String searchTerm) {
    cleanHighlight(node);
    if (node.nodeType == DomGlobal.document.TEXT_NODE) {
      String text = node.nodeValue;
      String highlighted = MatchHighlighter.highlight(text, searchTerm);
      node.parentElement.appendChild(span().setInnerHtml(highlighted).element());
      node.parentElement.removeChild(node);
    } else if (node.nodeType == DomGlobal.document.ELEMENT_NODE) {
      for (int i = 0; i < node.childNodes.length; i++) {
        highlightNode(node.childNodes.getAt(i), searchTerm);
      }
    }
  }

  /**
   * Cleans up any existing highlighting within a DOM node. This method is used to remove previously
   * applied highlighting before re-highlighting.
   *
   * @param node The DOM node to clean up highlighting from.
   */
  private void cleanHighlight(Node node) {
    if (node.nodeType == DomGlobal.document.ELEMENT_NODE) {
      if (node.nodeName.equalsIgnoreCase("mark")) {
        node.parentElement.textContent =
            node.parentElement.textContent.replace("<mark>", "").replace("</mark>", "");
      } else {
        for (int i = 0; i < node.childNodes.length; i++) {

          if (node.childNodes.getAt(i) instanceof Node) {
            cleanHighlight(Js.uncheckedCast(node.childNodes.getAt(i)));
          }
        }
      }
    }
  }

  public O onSelected() {
    return (O) this;
  }

  public O onDeselected() {
    return (O) this;
  }

  /**
   * Functional interface for supplying an instance of a type {@code T} based on a key and a value.
   *
   * @param <T> The type of object to be created.
   * @param <V> The type of the value used for creating the object.
   */
  public interface OptionSupplier<T, V> {

    /**
     * Creates and returns an instance of type {@code T} based on the provided key and value.
     *
     * @param key The key used for creating the object.
     * @param value The value used for creating the object.
     * @return An instance of type {@code T}.
     */
    T get(String key, V value);
  }

  @Override
  public String toString() {
    return "Option{" + "key='" + key + '\'' + '}';
  }

  /**
   * Compares this Option to another object for equality. Two Options are considered equal if they
   * have the same key.
   *
   * @param o The object to compare to this Option.
   * @return {@code true} if the objects are equal, {@code false} otherwise.
   */
  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    Option<?, ?, ?> option = (Option<?, ?, ?>) o;
    return Objects.equals(key, option.key);
  }

  /**
   * Computes a hash code for this Option based on its key.
   *
   * @return The hash code for this Option.
   */
  @Override
  public int hashCode() {
    return Objects.hash(key);
  }
}
