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
package org.dominokit.domino.ui.utils;

import elemental2.dom.MutationRecord;
import java.util.Objects;

public class NamedMutationObserverCallback implements MutationObserverCallback {

  private final String name;
  private final boolean autoRemove;
  private final MutationObserverCallback callback;

  public static MutationObserverCallback of(String name, MutationObserverCallback callback) {
    return new NamedMutationObserverCallback(name, false, callback);
  }

  public static MutationObserverCallback doOnce(String name, MutationObserverCallback callback) {
    return new NamedMutationObserverCallback(name, true, callback);
  }

  public NamedMutationObserverCallback(
      String name, boolean autoRemove, MutationObserverCallback callback) {
    this.name = name;
    this.autoRemove = autoRemove;
    this.callback = callback;
  }

  @Override
  public void onObserved(MutationRecord mutationRecord) {
    this.callback.onObserved(mutationRecord);
  }

  @Override
  public boolean isAutoRemove() {
    return autoRemove;
  }

  @Override
  public boolean equals(Object o) {
    if (!(o instanceof NamedMutationObserverCallback)) return false;
    NamedMutationObserverCallback that = (NamedMutationObserverCallback) o;
    return Objects.equals(name, that.name);
  }

  @Override
  public int hashCode() {
    return Objects.hashCode(name);
  }
}
