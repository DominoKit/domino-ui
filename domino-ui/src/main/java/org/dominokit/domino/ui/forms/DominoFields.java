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

import elemental2.dom.Node;
import java.util.function.Supplier;
import org.dominokit.domino.ui.utils.TextNode;

/**
 * This class provides global configuration for form fields
 *
 * <p>These configurations should be set before creating the form fields
 */
public class DominoFields {

  /** The DominoFields single INSTANCE for global access. */
  public static final DominoFields INSTANCE = new DominoFields();

  private FieldStyle fieldsStyle = FieldStyle.LINED;
  private FieldStyle DEFAULT = () -> fieldsStyle.getStyle();
  private Supplier<Node> requiredIndicator = () -> TextNode.of(" * ");

  private DominoFields() {}

  /**
   * Globally change the form fields style
   *
   * @param fieldsStyle {@link FieldStyle}
   */
  public void setDefaultFieldsStyle(FieldStyle fieldsStyle) {
    this.fieldsStyle = fieldsStyle;
  }

  /** @return Default {@link FieldStyle} */
  public FieldStyle getDefaultFieldsStyle() {
    return DEFAULT;
  }

  /**
   * @return a supplier of {@link Node}, this should return a new Node instance everytime it is call
   *     and that will be used as a required field indicator the default will supply a text node of
   *     <b>*</b>
   */
  public Supplier<Node> getRequiredIndicator() {
    return requiredIndicator;
  }

  /**
   * Sets the Supplier for the {@link Node} that should be used as a required indicator
   *
   * @param requiredIndicator {@link Node} Supplier
   */
  public void setRequiredIndicator(Supplier<Node> requiredIndicator) {
    this.requiredIndicator = requiredIndicator;
  }
}
