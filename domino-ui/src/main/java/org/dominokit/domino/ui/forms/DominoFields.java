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
  private DropdownPositionProvider<AbstractSuggestBox<?, ?>> defaultSuggestPopupPosition =
      field -> new AbstractSuggestBox.PopupPositionTopDown(field);

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

  /** @return {@link Optional} representing if the errors position should be fixed */
  public Optional<Boolean> getFixErrorsPosition() {
    return fixErrorsPosition;
  }

  /**
   * @param fixErrorsPosition true to fix errors position
   * @return same instance
   */
  public DominoFields setFixErrorsPosition(boolean fixErrorsPosition) {
    this.fixErrorsPosition = Optional.of(fixErrorsPosition);
    return this;
  }

  /** @return {@link Optional} representing if the labels should be floated */
  public Optional<Boolean> getFloatLabels() {
    return floatLabels;
  }

  /**
   * @param floatLabels true to float labels
   * @return same instance
   */
  public DominoFields setFloatLabels(boolean floatLabels) {
    this.floatLabels = Optional.of(floatLabels);
    return this;
  }

  /**
   * @return {@link Optional} representing if the spaces should be reduced to reduce element height
   */
  public Optional<Boolean> getCondensed() {
    return condensed;
  }

  /**
   * @param condensed true to reduce spaces
   * @return same instance
   */
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

  /** @return the {@link RequiredIndicatorRenderer} */
  public RequiredIndicatorRenderer getRequiredIndicatorRenderer() {
    return requiredIndicatorRenderer;
  }

  /** @return the default required message */
  public String getDefaultRequiredMessage() {
    return defaultRequiredMessage;
  }

  /**
   * @param defaultRequiredMessage the default required message
   * @return same instance
   */
  public DominoFields setDefaultRequiredMessage(String defaultRequiredMessage) {
    if (nonNull(defaultRequiredMessage) && !defaultRequiredMessage.isEmpty()) {
      this.defaultRequiredMessage = defaultRequiredMessage;
    }
    return this;
  }

  /**
   * @param requiredIndicatorRenderer A {@link RequiredIndicatorRenderer}
   * @return same instance
   */
  public DominoFields setRequiredIndicatorRenderer(
      RequiredIndicatorRenderer requiredIndicatorRenderer) {
    if (nonNull(requiredIndicatorRenderer)) {
      this.requiredIndicatorRenderer = requiredIndicatorRenderer;
    }
    return this;
  }

  /** @return the {@link GlobalValidationHandler} */
  public GlobalValidationHandler getGlobalValidationHandler() {
    return globalValidationHandler;
  }

  /**
   * @param globalValidationHandler A {@link GlobalValidationHandler}
   * @return same instance
   */
  public DominoFields setGlobalValidationHandler(GlobalValidationHandler globalValidationHandler) {
    if (nonNull(globalValidationHandler)) {
      this.globalValidationHandler = globalValidationHandler;
    }
    return this;
  }

  /** @return the default {@link DropdownPositionProvider} for {@link AbstractSelect} */
  public DropdownPositionProvider<AbstractSelect<?, ?, ?>> getDefaultSelectPopupPosition() {
    return defaultSelectPopupPosition;
  }

  /**
   * Sets the default dropdown position for select
   *
   * @param defaultSelectPopupPosition the {@link DropdownPositionProvider}
   * @return same instance
   */
  public DominoFields setDefaultSelectPopupPosition(
      DropdownPositionProvider<AbstractSelect<?, ?, ?>> defaultSelectPopupPosition) {
    if (nonNull(defaultSelectPopupPosition)) {
      this.defaultSelectPopupPosition = defaultSelectPopupPosition;
    }
    return this;
  }

  /** @return the default {@link DropdownPositionProvider} for {@link AbstractSuggestBox} */
  public DropdownPositionProvider<AbstractSuggestBox<?, ?>> getDefaultSuggestPopupPosition() {
    return defaultSuggestPopupPosition;
  }

  /**
   * Sets the default dropdown position for suggest box
   *
   * @param defaultSuggestPopupPosition the {@link DropdownPositionProvider}
   * @return same instance
   */
  public DominoFields setDefaultSuggestPopupPosition(
      DropdownPositionProvider<AbstractSuggestBox<?, ?>> defaultSuggestPopupPosition) {
    if (nonNull(defaultSuggestPopupPosition)) {
      this.defaultSuggestPopupPosition = defaultSuggestPopupPosition;
    }
    return this;
  }

  /** An interface for rendering the required indicator on fields */
  public interface RequiredIndicatorRenderer {
    /**
     * @param valueBox the {@link BasicFormElement} to append required to
     * @param requiredIndicator the node for required indicator
     * @param <T> the type of the form field
     */
    <T extends BasicFormElement<?, ?>> void appendRequiredIndicator(
        T valueBox, Node requiredIndicator);

    /**
     * @param valueBox the {@link BasicFormElement} to remove required from
     * @param requiredIndicator the node for required indicator
     * @param <T> the type of the form field
     */
    <T extends BasicFormElement<?, ?>> void removeRequiredIndicator(
        T valueBox, Node requiredIndicator);
  }

  /** A global validation handler that will be called when a form field gets validated */
  public interface GlobalValidationHandler {
    default <T extends ValueBox<?, ?, ?>> void onInvalidate(T valueBox, List<String> errors) {}

    default <T extends ValueBox<?, ?, ?>> void onClearValidation(T valueBox) {}
  }

  /**
   * A provider for creating {@link DropDownPosition}
   *
   * @param <T> the type of the element
   */
  public interface DropdownPositionProvider<T> {
    DropDownPosition createPosition(T field);
  }
}
