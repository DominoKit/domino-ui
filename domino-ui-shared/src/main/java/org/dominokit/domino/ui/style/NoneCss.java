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
package org.dominokit.domino.ui.style;

import elemental2.dom.Element;
import org.dominokit.domino.ui.IsElement;

/**
 * NoneCss class.
 *
 * @author vegegoku
 * @version $Id: $Id
 */
public class NoneCss implements CssClass {
  /** {@inheritDoc} */
  @Override
  public String getCssClass() {
    return "";
  }

  /** {@inheritDoc} */
  @Override
  public void apply(Element element) {}

  /** {@inheritDoc} */
  @Override
  public boolean isAppliedTo(Element element) {
    return false;
  }

  /** {@inheritDoc} */
  @Override
  public boolean isAppliedTo(IsElement<?> element) {
    return false;
  }

  /** {@inheritDoc} */
  @Override
  public void remove(Element element) {}

  /** {@inheritDoc} */
  @Override
  public void remove(IsElement<?> element) {}
}
