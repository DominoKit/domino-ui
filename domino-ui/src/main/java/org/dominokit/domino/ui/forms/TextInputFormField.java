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
package org.dominokit.domino.ui.forms;

import static org.dominokit.domino.ui.forms.FormsStyles.*;

import elemental2.dom.HTMLDivElement;
import elemental2.dom.HTMLInputElement;
import org.dominokit.domino.ui.utils.*;

public abstract class TextInputFormField<
        T extends InputFormField<T, E, V>, E extends HTMLInputElement, V>
    extends CountableInputFormField<T, E, V> implements HasPostfix<T>, HasPrefix<T> {

  protected final LazyChild<DominoElement<HTMLDivElement>> prefixElement;
  protected final LazyChild<DominoElement<HTMLDivElement>> postfixElement;

  public TextInputFormField() {
    prefixElement = LazyChild.of(DominoElement.div().addCss(FIELD_PREFIX), wrapperElement);
    postfixElement = LazyChild.of(DominoElement.div().addCss(FIELD_POSTFIX), wrapperElement);
  }

  @Override
  public T setPostfix(String postfix) {
    postfixElement.get().setTextContent(postfix);
    return (T) this;
  }

  @Override
  public String getPostfix() {
    if (postfixElement.isInitialized()) {
      return postfixElement.get().getTextContent();
    }
    return "";
  }

  @Override
  public T setPrefix(String prefix) {
    prefixElement.get().setTextContent(prefix);
    return (T) this;
  }

  @Override
  public String getPrefix() {
    if (prefixElement.isInitialized()) {
      return prefixElement.get().getTextContent();
    }
    return "";
  }

  public DominoElement<HTMLDivElement> getPrefixElement() {
    return prefixElement.get();
  }

  public DominoElement<HTMLDivElement> getPostfixElement() {
    return postfixElement.get();
  }

  public T withPrefixElement() {
    prefixElement.get();
    return (T) this;
  }

  public T withPrefixElement(ChildHandler<T, DominoElement<HTMLDivElement>> handler) {
    handler.apply((T) this, prefixElement.get());
    return (T) this;
  }

  public T withPostfixElement() {
    postfixElement.get();
    return (T) this;
  }

  public T withPostfixElement(ChildHandler<T, DominoElement<HTMLDivElement>> handler) {
    handler.apply((T) this, postfixElement.get());
    return (T) this;
  }

  @Override
  public String getName() {
    return getInputElement().element().name;
  }

  @Override
  public T setName(String name) {
    getInputElement().element().name = name;
    return (T) this;
  }
}
