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

import elemental2.dom.DomGlobal;
import elemental2.dom.Element;
import elemental2.dom.Node;
import java.util.Objects;
import org.dominokit.domino.ui.IsElement;
import org.dominokit.domino.ui.menu.AbstractMenuItem;
import org.dominokit.domino.ui.utils.BaseDominoElement;
import org.dominokit.domino.ui.utils.ChildHandler;
import org.dominokit.domino.ui.utils.MatchHighlighter;

/**
 * Abstract Option class.
 *
 * @author vegegoku
 * @version $Id: $Id
 */
public abstract class Option<V, C extends IsElement<?>, O extends Option<V, C, O>>
    extends BaseDominoElement<Element, Option<V, C, O>> {

  private final C component;
  private final AbstractMenuItem<V> menuItem;

  private final String key;
  private final V value;
  protected HasSuggestOptions<V, C, O> target;

  /**
   * Constructor for Option.
   *
   * @param key a {@link java.lang.String} object
   * @param value a V object
   * @param component a C object
   * @param menuItem a {@link org.dominokit.domino.ui.menu.AbstractMenuItem} object
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
   * Constructor for Option.
   *
   * @param key a {@link java.lang.String} object
   * @param value a V object
   * @param componentSupplier a {@link org.dominokit.domino.ui.forms.suggest.Option.OptionSupplier}
   *     object
   * @param menuItemSupplier a {@link org.dominokit.domino.ui.forms.suggest.Option.OptionSupplier}
   *     object
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
   * Getter for the field <code>component</code>.
   *
   * @return a C object
   */
  public C getComponent() {
    return component;
  }

  /**
   * Getter for the field <code>menuItem</code>.
   *
   * @return a {@link org.dominokit.domino.ui.menu.AbstractMenuItem} object
   */
  public AbstractMenuItem<V> getMenuItem() {
    return menuItem;
  }

  /**
   * Getter for the field <code>key</code>.
   *
   * @return a {@link java.lang.String} object
   */
  public String getKey() {
    return key;
  }

  /**
   * Getter for the field <code>value</code>.
   *
   * @return a V object
   */
  public V getValue() {
    return value;
  }

  /**
   * withMenuItem.
   *
   * @param handler a {@link org.dominokit.domino.ui.utils.ChildHandler} object
   * @return a O object
   */
  public O withMenuItem(ChildHandler<O, AbstractMenuItem<V>> handler) {
    handler.apply((O) this, menuItem);
    return (O) this;
  }

  /**
   * withComponent.
   *
   * @param handler a {@link org.dominokit.domino.ui.utils.ChildHandler} object
   * @return a O object
   */
  public O withComponent(ChildHandler<O, C> handler) {
    handler.apply((O) this, component);
    return (O) this;
  }

  /** {@inheritDoc} */
  @Override
  public Element element() {
    return component.element();
  }

  /**
   * setSearchable.
   *
   * @param searchable a boolean
   * @return a O object
   */
  public O setSearchable(boolean searchable) {
    this.menuItem.setSearchable(searchable);
    return (O) this;
  }

  /**
   * highlight.
   *
   * @param displayValue a {@link java.lang.String} object
   */
  public void highlight(String displayValue) {
    if (nonNull(displayValue) && displayValue.length() > 0) {
      highlightNode(menuItem.getClickableElement(), displayValue);
    }
  }

  /**
   * bindTo.
   *
   * @param target a {@link org.dominokit.domino.ui.forms.suggest.HasSuggestOptions} object
   * @return a O object
   */
  public O bindTo(HasSuggestOptions<V, C, O> target) {
    this.target = target;
    return (O) this;
  }

  /**
   * unbindTarget.
   *
   * @return a O object
   */
  public O unbindTarget() {
    this.target = null;
    return (O) this;
  }

  /**
   * Getter for the field <code>target</code>.
   *
   * @return a {@link org.dominokit.domino.ui.forms.suggest.HasSuggestOptions} object
   */
  public HasSuggestOptions<V, C, O> getTarget() {
    return target;
  }

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

  private void cleanHighlight(Node node) {
    if (node.nodeType == DomGlobal.document.ELEMENT_NODE) {
      if (node.nodeName.equalsIgnoreCase("mark")) {
        node.parentElement.textContent =
            node.parentElement.textContent.replace("<mark>", "").replace("</mark>", "");
      } else {
        for (int i = 0; i < node.childNodes.length; i++) {
          cleanHighlight(node.childNodes.getAt(i));
        }
      }
    }
  }

  public interface OptionSupplier<T, V> {
    T get(String key, V value);
  }

  /** {@inheritDoc} */
  @Override
  public String toString() {
    return "Option{" + "key='" + key + '\'' + '}';
  }

  /** {@inheritDoc} */
  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    Option<?, ?, ?> option = (Option<?, ?, ?>) o;
    return Objects.equals(key, option.key);
  }

  /** {@inheritDoc} */
  @Override
  public int hashCode() {
    return Objects.hash(key);
  }
}
