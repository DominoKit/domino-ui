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

import static java.util.Objects.nonNull;

import elemental2.dom.Node;
import java.util.List;
import java.util.Optional;
import java.util.function.Supplier;
import org.dominokit.domino.ui.dropdown.DropDownPosition;
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
  private String defaultRequiredMessage = "* This field is required";
  private Optional<Boolean> fixErrorsPosition = Optional.empty();
  private Optional<Boolean> floatLabels = Optional.empty();
  private Optional<Boolean> condensed = Optional.empty();
  private RequiredIndicatorRenderer requiredIndicatorRenderer =
      new RequiredIndicatorRenderer() {
        @Override
        public <T extends BasicFormElement<?, ?>> void appendRequiredIndicator(
            T valueBox, Node requiredIndicator) {
          removeRequiredIndicator(valueBox, requiredIndicator);
          valueBox.getLabelElement().appendChild(requiredIndicator);
        }

        @Override
        public <T extends BasicFormElement<?, ?>> void removeRequiredIndicator(
            T valueBox, Node requiredIndicator) {
          if (nonNull(valueBox.getLabelElement())
              && valueBox.getLabelElement().hasDirectChild(requiredIndicator)) {
            valueBox.getLabelElement().removeChild(requiredIndicator);
          }
        }
      };

  private GlobalValidationHandler globalValidationHandler = new GlobalValidationHandler() {};

  private DropdownPositionProvider<AbstractSelect<?, ?, ?>> defaultSelectPopupPosition =
      AbstractSelect.PopupPositionTopDown::new;
  private DropdownPositionProvider<SuggestBox<?>> defaultSuggestPopupPosition =
      field -> new SuggestBox.PopupPositionTopDown();

  private DominoFields() {}

  /**
   * Globally change the form fields style
   *
   * @param fieldsStyle {@link FieldStyle}
   */
  public DominoFields setDefaultFieldsStyle(FieldStyle fieldsStyle) {
    this.fieldsStyle = fieldsStyle;
    return this;
  }

  /** @return Default {@link FieldStyle} */
  public FieldStyle getDefaultFieldsStyle() {
    return DEFAULT;
  }

  public Optional<Boolean> getFixErrorsPosition() {
    return fixErrorsPosition;
  }

  public DominoFields setFixErrorsPosition(boolean fixErrorsPosition) {
    this.fixErrorsPosition = Optional.of(fixErrorsPosition);
    return this;
  }

  public Optional<Boolean> getFloatLabels() {
    return floatLabels;
  }

  public DominoFields setFloatLabels(boolean floatLabels) {
    this.floatLabels = Optional.of(floatLabels);
    return this;
  }

  public Optional<Boolean> getCondensed() {
    return condensed;
  }

  public DominoFields setCondensed(boolean condensed) {
    this.condensed = Optional.of(condensed);
    return this;
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
  public DominoFields setRequiredIndicator(Supplier<Node> requiredIndicator) {
    this.requiredIndicator = requiredIndicator;
    return this;
  }

  public RequiredIndicatorRenderer getRequiredIndicatorRenderer() {
    return requiredIndicatorRenderer;
  }

  public String getDefaultRequiredMessage() {
    return defaultRequiredMessage;
  }

  public DominoFields setDefaultRequiredMessage(String defaultRequiredMessage) {
    if (nonNull(defaultRequiredMessage) && !defaultRequiredMessage.isEmpty()) {
      this.defaultRequiredMessage = defaultRequiredMessage;
    }
    return this;
  }

  public DominoFields setRequiredIndicatorRenderer(
      RequiredIndicatorRenderer requiredIndicatorRenderer) {
    if (nonNull(requiredIndicatorRenderer)) {
      this.requiredIndicatorRenderer = requiredIndicatorRenderer;
    }
    return this;
  }

  public GlobalValidationHandler getGlobalValidationHandler() {
    return globalValidationHandler;
  }

  public DominoFields setGlobalValidationHandler(GlobalValidationHandler globalValidationHandler) {
    if (nonNull(globalValidationHandler)) {
      this.globalValidationHandler = globalValidationHandler;
    }
    return this;
  }

  public DropdownPositionProvider<AbstractSelect<?, ?, ?>> getDefaultSelectPopupPosition() {
    return defaultSelectPopupPosition;
  }

  public DominoFields setDefaultSelectPopupPosition(
      DropdownPositionProvider<AbstractSelect<?, ?, ?>> defaultSelectPopupPosition) {
    if (nonNull(defaultSelectPopupPosition)) {
      this.defaultSelectPopupPosition = defaultSelectPopupPosition;
    }
    return this;
  }

  public DropdownPositionProvider<SuggestBox<?>> getDefaultSuggestPopupPosition() {
    return defaultSuggestPopupPosition;
  }

  public DominoFields setDefaultSuggestPopupPosition(
      DropdownPositionProvider<SuggestBox<?>> defaultSuggestPopupPosition) {
    if (nonNull(defaultSuggestPopupPosition)) {
      this.defaultSuggestPopupPosition = defaultSuggestPopupPosition;
    }
    return this;
  }

  public interface RequiredIndicatorRenderer {
    <T extends BasicFormElement<?, ?>> void appendRequiredIndicator(
        T valueBox, Node requiredIndicator);

    <T extends BasicFormElement<?, ?>> void removeRequiredIndicator(
        T valueBox, Node requiredIndicator);
  }

  public interface GlobalValidationHandler {
    default <T extends ValueBox<?, ?, ?>> void onInvalidate(T valueBox, List<String> errors) {}

    default <T extends ValueBox<?, ?, ?>> void onClearValidation(T valueBox) {}
  }

  public interface DropdownPositionProvider<T> {
    DropDownPosition createPosition(T field);
  }
}
