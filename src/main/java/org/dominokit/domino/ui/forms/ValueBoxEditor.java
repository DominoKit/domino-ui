/*
 * Copyright 2010 Google Inc.
 * 
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not
 * use this file except in compliance with the License. You may obtain a copy of
 * the License at
 * 
 * http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
 * WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the
 * License for the specific language governing permissions and limitations under
 * the License.
 */
package org.dominokit.domino.ui.forms;

import com.google.gwt.editor.client.EditorDelegate;
import com.google.gwt.editor.client.HasEditorDelegate;
import com.google.gwt.editor.client.adapters.TakesValueEditor;
import com.google.gwt.user.client.ui.ValueBoxBase;

import java.text.ParseException;

/**
 * Adapts the {@link ValueBoxBase} interface to the Editor framework. This
 * adapter uses {@link ValueBoxBase#getValueOrThrow()} to report parse errors to
 * the Editor framework.
 * 
 */
public class ValueBoxEditor<T, V> extends TakesValueEditor<V> implements
    HasEditorDelegate<V> {

  /**
   * Returns a new TakesValueEditor that adapts a {@link ValueBoxBase}
   * instance.
   *
   * @param valueBox a {@link ValueBoxBase} instance to adapt
   * @return a ValueBoxEditor instance of the same type as the
   *   adapted {@link ValueBoxBase} instance
   */
  public static <T,V> ValueBoxEditor of(FormElement<T,V> valueBox) {
    return new ValueBoxEditor(valueBox);
  }

  private EditorDelegate<V> delegate;
  private final FormElement<T,V> peer;
  private V value;

  /**
   * Constructs a new ValueBoxEditor that adapts a {@link ValueBoxBase} peer
   * instance.
   *
   * @param peer a {@link ValueBoxBase} instance of type T
   */
  protected ValueBoxEditor(FormElement<T,V> peer) {
    super(peer);
    this.peer = peer;
  }

  /**
   * Returns the {@link EditorDelegate} for this instance.
   *
   * @return an {@link EditorDelegate}, or {@code null}
   * @see #setDelegate(EditorDelegate)
   */
  public EditorDelegate<V> getDelegate() {
    return delegate;
  }

  /**
   * Calls {@link ValueBoxBase#getValueOrThrow()}. If a {@link ParseException}
   * is thrown, it will be available through
   * {@link com.google.gwt.editor.client.EditorError#getUserData()
   * EditorError.getUserData()}.
   *
   * @return a value of type T
   * @see #setValue(Object)
   */
  @Override
  public V getValue() {
      value = peer.getValue();
      // TODO i18n
//      getDelegate().recordError("Bad value (" + peer.getValue() + ")",
//          peer.getValue(), e);
    return value;
  }

  /**
   * Sets the {@link EditorDelegate} for this instance. This method is only
   * called by the driver.
   * 
   * @param delegate an {@link EditorDelegate}, or {@code null}
   * @see #getDelegate()
   */
  public void setDelegate(EditorDelegate<V> delegate) {
    this.delegate = delegate;
  }

  @Override
  public void setValue(V value) {
    this.value = value;
    peer.setValue(value);
  }
}
