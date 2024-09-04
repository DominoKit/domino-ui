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

import static java.util.Objects.nonNull;

import elemental2.dom.Node;
import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;
import java.util.function.Function;
import java.util.function.Supplier;
import org.dominokit.domino.ui.animations.Transition;
import org.dominokit.domino.ui.collapsible.*;
import org.dominokit.domino.ui.dropdown.DropDownPosition;
import org.dominokit.domino.ui.forms.AbstractSelect;
import org.dominokit.domino.ui.forms.AbstractSuggestBox;
import org.dominokit.domino.ui.forms.BasicFormElement;
import org.dominokit.domino.ui.forms.BigDecimalBox;
import org.dominokit.domino.ui.forms.DoubleBox;
import org.dominokit.domino.ui.forms.FieldStyle;
import org.dominokit.domino.ui.forms.FloatBox;
import org.dominokit.domino.ui.forms.IntegerBox;
import org.dominokit.domino.ui.forms.LongBox;
import org.dominokit.domino.ui.forms.ShortBox;
import org.dominokit.domino.ui.forms.ValueBox;
import org.dominokit.domino.ui.modals.DefaultZIndexManager;
import org.dominokit.domino.ui.modals.ZIndexManager;
import org.dominokit.domino.ui.tree.TreeItem;

/**
 * This class provides global configuration for form fields
 *
 * <p>These configurations should be set before creating the form fields
 */
public class DominoUIConfig {

  /** The DominoUIConfig single INSTANCE for global access. */
  public static final DominoUIConfig INSTANCE = new DominoUIConfig();

  private FieldStyle fieldsStyle = FieldStyle.LINED;
  private FieldStyle DEFAULT = () -> fieldsStyle.getStyle();
  private Supplier<Node> requiredIndicator = () -> TextNode.of(" * ");
  private String defaultRequiredMessage = "* This field is required";
  private Optional<Boolean> fixErrorsPosition = Optional.empty();
  private Optional<Boolean> floatLabels = Optional.empty();
  private Optional<Boolean> condensed = Optional.empty();

  private int initialZIndex = 1;
  private int zIndexIncrement = 1;

  private ZIndexManager zindexManager = new DefaultZIndexManager();
  private RequiredIndicatorRenderer requiredIndicatorRenderer =
      new RequiredIndicatorRenderer() {
        @Override
        public <T extends BasicFormElement<?, ?>> void appendRequiredIndicator(
            T valueBox, Node requiredIndicator) {
          removeRequiredIndicator(valueBox, requiredIndicator);
          valueBox
              .getLabelElement()
              .ifPresent(labelElement -> labelElement.appendChild(requiredIndicator));
        }

        @Override
        public <T extends BasicFormElement<?, ?>> void removeRequiredIndicator(
            T valueBox, Node requiredIndicator) {
          if (nonNull(valueBox.getLabelElement())
              && valueBox.getLabelElement().isPresent()
              && valueBox.getLabelElement().get().hasDirectChild(requiredIndicator)) {
            valueBox
                .getLabelElement()
                .ifPresent(labelElement -> labelElement.removeChild(requiredIndicator));
          }
        }
      };

  private GlobalValidationHandler globalValidationHandler = new GlobalValidationHandler() {};

  private DropdownPositionProvider<AbstractSelect<?, ?, ?>> defaultSelectPopupPosition =
      AbstractSelect.PopupPositionTopDown::new;
  private DropdownPositionProvider<AbstractSuggestBox<?, ?>> defaultSuggestPopupPosition =
      field -> new AbstractSuggestBox.PopupPositionTopDown(field);

  private Supplier<CollapseStrategy> defaultCollapseStrategySupplier = DisplayCollapseStrategy::new;
  private Supplier<CollapseStrategy> defaultCardCollapseStrategySupplier =
      HeightCollapseStrategy::new;
  private Supplier<CollapseStrategy> defaultAccordionCollapseStrategySupplier =
      HeightCollapseStrategy::new;

  private Supplier<CollapseStrategy> defaultTooltipCollapseStrategySupplier =
      () ->
          new AnimationCollapseStrategy(
              new AnimationCollapseOptions()
                  .setShowTransition(Transition.FADE_IN)
                  .setHideTransition(Transition.FADE_OUT)
                  .setShowDuration(CollapseDuration._300ms)
                  .setHideDuration(CollapseDuration._300ms)
                  .setShowDelay(500));
  private TreeCollapseSupplier defaultTreeCollapseStrategySupplier =
      TreeHeightCollapseStrategy::new;

  private NumberParsers numberParsers = new NumberParsers() {};

  private boolean focusNextFieldOnEnter = false;
  private int defaultButtonElevation = 1;
  private int defaultModalElevation = 2;

  protected DominoUIConfig() {}

  /**
   * Globally change the form fields style
   *
   * @param fieldsStyle {@link FieldStyle}
   */
  public DominoUIConfig setDefaultFieldsStyle(FieldStyle fieldsStyle) {
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
  public DominoUIConfig setFixErrorsPosition(boolean fixErrorsPosition) {
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
  public DominoUIConfig setFloatLabels(boolean floatLabels) {
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
  public DominoUIConfig setCondensed(boolean condensed) {
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
  public DominoUIConfig setRequiredIndicator(Supplier<Node> requiredIndicator) {
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
  public DominoUIConfig setDefaultRequiredMessage(String defaultRequiredMessage) {
    if (nonNull(defaultRequiredMessage) && !defaultRequiredMessage.isEmpty()) {
      this.defaultRequiredMessage = defaultRequiredMessage;
    }
    return this;
  }

  /**
   * @param requiredIndicatorRenderer A {@link RequiredIndicatorRenderer}
   * @return same instance
   */
  public DominoUIConfig setRequiredIndicatorRenderer(
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
  public DominoUIConfig setGlobalValidationHandler(
      GlobalValidationHandler globalValidationHandler) {
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
  public DominoUIConfig setDefaultSelectPopupPosition(
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
  public DominoUIConfig setDefaultSuggestPopupPosition(
      DropdownPositionProvider<AbstractSuggestBox<?, ?>> defaultSuggestPopupPosition) {
    if (nonNull(defaultSuggestPopupPosition)) {
      this.defaultSuggestPopupPosition = defaultSuggestPopupPosition;
    }
    return this;
  }

  public Supplier<CollapseStrategy> getDefaultCollapseStrategySupplier() {
    return defaultCollapseStrategySupplier;
  }

  public DominoUIConfig setDefaultCollapseStrategySupplier(
      Supplier<CollapseStrategy> defaultCollapseStrategySupplier) {
    this.defaultCollapseStrategySupplier = defaultCollapseStrategySupplier;
    return this;
  }

  public Supplier<CollapseStrategy> getDefaultCardCollapseStrategySupplier() {
    return defaultCardCollapseStrategySupplier;
  }

  public DominoUIConfig setDefaultCardCollapseStrategySupplier(
      Supplier<CollapseStrategy> defaultCardCollapseStrategySupplier) {
    this.defaultCardCollapseStrategySupplier = defaultCardCollapseStrategySupplier;
    return this;
  }

  public TreeCollapseSupplier getDefaultTreeCollapseStrategySupplier() {
    return defaultTreeCollapseStrategySupplier;
  }

  public DominoUIConfig setDefaultTreeCollapseStrategySupplier(
      TreeCollapseSupplier defaultTreeCollapseStrategySupplier) {
    this.defaultTreeCollapseStrategySupplier = defaultTreeCollapseStrategySupplier;
    return this;
  }

  public Supplier<CollapseStrategy> getDefaultAccordionCollapseStrategySupplier() {
    return defaultAccordionCollapseStrategySupplier;
  }

  public DominoUIConfig setDefaultAccordionCollapseStrategySupplier(
      Supplier<CollapseStrategy> defaultAccordionCollapseStrategySupplier) {
    this.defaultAccordionCollapseStrategySupplier = defaultAccordionCollapseStrategySupplier;
    return this;
  }

  public Supplier<CollapseStrategy> getDefaultTooltipCollapseStrategySupplier() {
    return defaultTooltipCollapseStrategySupplier;
  }

  public DominoUIConfig setDefaultTooltipCollapseStrategySupplier(
      Supplier<CollapseStrategy> defaultTooltipCollapseStrategySupplier) {
    this.defaultTooltipCollapseStrategySupplier = defaultTooltipCollapseStrategySupplier;
    return this;
  }

  public NumberParsers getNumberParsers() {
    return numberParsers;
  }

  public DominoUIConfig setNumberParsers(NumberParsers numberParsers) {
    if (nonNull(numberParsers)) {
      this.numberParsers = numberParsers;
    }
    return this;
  }

  /** @return true if press enter key will move the focus to the next input field if exists */
  public boolean isFocusNextFieldOnEnter() {
    return focusNextFieldOnEnter;
  }

  /**
   * @param focusNextFieldOnEnter boolean, true to enable moving the focus to next field on enter
   *     key press, false to disable it.
   * @return same {@link DominoUIConfig} instance
   */
  public DominoUIConfig setFocusNextFieldOnEnter(boolean focusNextFieldOnEnter) {
    this.focusNextFieldOnEnter = focusNextFieldOnEnter;
    return this;
  }

  public int getDefaultButtonElevation() {
    return defaultButtonElevation;
  }

  public DominoUIConfig setDefaultButtonElevation(int defaultButtonElevation) {
    this.defaultButtonElevation = defaultButtonElevation;
    return this;
  }

  public int getDefaultModalElevation() {
    return defaultModalElevation;
  }

  public DominoUIConfig setDefaultModalElevation(int defaultModalElevation) {
    this.defaultModalElevation = defaultModalElevation;
    return this;
  }

  public int getInitialZIndex() {
    return initialZIndex;
  }

  public DominoUIConfig setInitialZIndex(int initialZIndex) {
    this.initialZIndex = initialZIndex;
    return this;
  }

  public int getZindexIncrement() {
    return zIndexIncrement;
  }

  public DominoUIConfig setZindexIncrement(int zIndexIncrement) {
    this.zIndexIncrement = zIndexIncrement;
    return this;
  }

  public ZIndexManager getZindexManager() {
    return zindexManager;
  }

  public void setZindexManager(ZIndexManager zindexManager) {
    this.zindexManager = zindexManager;
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

  /** A provider for creating {@link CollapseStrategy} for TreeItem(s) */
  public interface TreeCollapseSupplier {
    CollapseStrategy get(TreeItem<?> treeItem);
  }

  public interface NumberParsers {
    default Function<String, BigDecimal> bigDecimalParser(BigDecimalBox field) {
      return value -> BigDecimal.valueOf(field.parseDouble(value));
    }

    default Function<String, Double> doubleParser(DoubleBox field) {
      return field::parseDouble;
    }

    default Function<String, Integer> integerParser(IntegerBox field) {
      return value -> Double.valueOf(field.parseDouble(value)).intValue();
    }

    default Function<String, Float> floatParser(FloatBox field) {
      return value -> Double.valueOf(field.parseDouble(value)).floatValue();
    }

    default Function<String, Long> longParser(LongBox field) {
      return value -> Double.valueOf(field.parseDouble(value)).longValue();
    }

    default Function<String, Short> shortParser(ShortBox field) {
      return value -> Double.valueOf(field.parseDouble(value)).shortValue();
    }
  }
}
