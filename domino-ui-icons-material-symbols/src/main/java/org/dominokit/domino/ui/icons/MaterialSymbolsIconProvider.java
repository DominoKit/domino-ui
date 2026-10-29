/*
 * Copyright © 2026 Dominokit
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
package org.dominokit.domino.ui.icons;

/** Default semantic provider backed by Google's Material Symbols. */
public final class MaterialSymbolsIconProvider implements IconProvider {
  public static final MaterialSymbolsIconProvider INSTANCE = new MaterialSymbolsIconProvider();

  private MaterialSymbolsIconProvider() {}

  @Override
  public MaterialSymbolsIcon icon(IconName name) {
    return MaterialSymbolsIcon.create(name);
  }
}
