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

import elemental2.dom.HTMLElement;
import elemental2.dom.Node;
import org.dominokit.domino.ui.collapsible.CollapseStrategy;
import org.dominokit.domino.ui.collapsible.DisplayCollapseStrategy;
import org.dominokit.domino.ui.collapsible.HeightCollapseStrategy;
import org.dominokit.domino.ui.forms.*;
import org.dominokit.domino.ui.i18n.DefaultDominoUILabels;
import org.dominokit.domino.ui.i18n.DominoUILabels;
import org.dominokit.domino.ui.icons.BaseIcon;
import org.dominokit.domino.ui.icons.Icons;

import java.math.BigDecimal;
import java.util.Optional;
import java.util.function.Function;
import java.util.function.Supplier;

import static java.util.Objects.nonNull;
//import org.dominokit.domino.ui.tree.TreeItem;

/**
 * This class provides global configuration for form fields
 *
 * <p>These configurations should be set before creating the form fields
 */
public class DominoUIConfig {

  /** The DominoFields single INSTANCE for global access. */
  public static final DominoUIConfig CONFIG = new DominoUIConfig();

  private DominoUILabels dominoUILabels = new DefaultDominoUILabels();
  private Supplier<HTMLElement> requiredIndicator = () -> DominoElement.span().textContent("*").element();
  private String defaultRequiredMessage = "* This field is required";
  private boolean fixErrorsPosition = false;
//  private RequiredIndicatorRenderer requiredIndicatorRenderer =
//      new RequiredIndicatorRenderer() {
//        @Override
//        public <T extends BasicFormElement<?, ?>> void appendRequiredIndicator(
//            T valueBox, Node requiredIndicator) {
//          removeRequiredIndicator(valueBox, requiredIndicator);
//          valueBox.getLabelElement().appendChild(requiredIndicator);
//        }
//
//        @Override
//        public <T extends BasicFormElement<?, ?>> void removeRequiredIndicator(
//            T valueBox, Node requiredIndicator) {
//          if (valueBox.getLabelElement().hasDirectChild(requiredIndicator)) {
//            valueBox.getLabelElement().removeChild(requiredIndicator);
//          }
//        }
//      };

//  private GlobalValidationHandler globalValidationHandler = new GlobalValidationHandler() {};
//
//  private DropdownPositionProvider<AbstractSuggestBox<?, ?>> defaultSuggestPopupPosition =
//      field -> new AbstractSuggestBox.PopupPositionTopDown(field);

  private Supplier<CollapseStrategy> defaultCollapseStrategySupplier = DisplayCollapseStrategy::new;
  private Supplier<CollapseStrategy> defaultCardCollapseStrategySupplier =
      HeightCollapseStrategy::new;
  private Supplier<CollapseStrategy> defaultAccordionCollapseStrategySupplier =
      HeightCollapseStrategy::new;
//  private TreeCollapseSupplier defaultTreeCollapseStrategySupplier =
//      TreeHeightCollapseStrategy::new;

  private NumberParsers numberParsers = new NumberParsers() {};

  private boolean focusNextFieldOnEnter = false;
  private boolean spellCheck;

  private Supplier<BaseIcon<?>> cardCollapseIconSupplier = Icons.ALL::chevron_up_mdi;
  private Supplier<BaseIcon<?>> cardExpandIconSupplier = Icons.ALL::chevron_down_mdi;

  protected DominoUIConfig() {}

  /** @return {@link Optional} representing if the errors position should be fixed */
  public boolean getFixErrorsPosition() {
    return fixErrorsPosition;
  }

  /**
   * @param fixErrorsPosition true to fix errors position
   * @return same instance
   */
  public DominoUIConfig setFixErrorsPosition(boolean fixErrorsPosition) {
    this.fixErrorsPosition = fixErrorsPosition;
    return this;
  }

  /**
   * @return a supplier of {@link Node}, this should return a new Node instance everytime it is call
   *     and that will be used as a required field indicator the default will supply a text node of
   *     <b>*</b>
   */
  public Supplier<HTMLElement> getRequiredIndicator() {
    return requiredIndicator;
  }

  /**
   * Sets the Supplier for the {@link Node} that should be used as a required indicator
   *
   * @param requiredIndicator {@link Node} Supplier
   */
  public DominoUIConfig setRequiredIndicator(Supplier<HTMLElement> requiredIndicator) {
    this.requiredIndicator = requiredIndicator;
    return this;
  }
//
//  /** @return the {@link RequiredIndicatorRenderer} */
//  public RequiredIndicatorRenderer getRequiredIndicatorRenderer() {
//    return requiredIndicatorRenderer;
//  }

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

//  /**
//   * @param requiredIndicatorRenderer A {@link RequiredIndicatorRenderer}
//   * @return same instance
//   */
//  public DominoUIConfig setRequiredIndicatorRenderer(
//      RequiredIndicatorRenderer requiredIndicatorRenderer) {
//    if (nonNull(requiredIndicatorRenderer)) {
//      this.requiredIndicatorRenderer = requiredIndicatorRenderer;
//    }
//    return this;
//  }
//
//  /** @return the {@link GlobalValidationHandler} */
//  public GlobalValidationHandler getGlobalValidationHandler() {
//    return globalValidationHandler;
//  }
//
//  /**
//   * @param globalValidationHandler A {@link GlobalValidationHandler}
//   * @return same instance
//   */
//  public DominoUIConfig setGlobalValidationHandler(
//      GlobalValidationHandler globalValidationHandler) {
//    if (nonNull(globalValidationHandler)) {
//      this.globalValidationHandler = globalValidationHandler;
//    }
//    return this;
//  }
//
//  /** @return the default {@link DropdownPositionProvider} for {@link AbstractSuggestBox} */
//  public DropdownPositionProvider<AbstractSuggestBox<?, ?>> getDefaultSuggestPopupPosition() {
//    return defaultSuggestPopupPosition;
//  }

//  /**
//   * Sets the default dropdown position for suggest box
//   *
//   * @param defaultSuggestPopupPosition the {@link DropdownPositionProvider}
//   * @return same instance
//   */
//  public DominoUIConfig setDefaultSuggestPopupPosition(
//      DropdownPositionProvider<AbstractSuggestBox<?, ?>> defaultSuggestPopupPosition) {
//    if (nonNull(defaultSuggestPopupPosition)) {
//      this.defaultSuggestPopupPosition = defaultSuggestPopupPosition;
//    }
//    return this;
//  }

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
//
//  public TreeCollapseSupplier getDefaultTreeCollapseStrategySupplier() {
//    return defaultTreeCollapseStrategySupplier;
//  }
//
//  public DominoUIConfig setDefaultTreeCollapseStrategySupplier(
//      TreeCollapseSupplier defaultTreeCollapseStrategySupplier) {
//    this.defaultTreeCollapseStrategySupplier = defaultTreeCollapseStrategySupplier;
//    return this;
//  }

  public Supplier<CollapseStrategy> getDefaultAccordionCollapseStrategySupplier() {
    return defaultAccordionCollapseStrategySupplier;
  }

  public DominoUIConfig setDefaultAccordionCollapseStrategySupplier(
      Supplier<CollapseStrategy> defaultAccordionCollapseStrategySupplier) {
    this.defaultAccordionCollapseStrategySupplier = defaultAccordionCollapseStrategySupplier;
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

  public boolean getSpellCheck() {
    return this.spellCheck;
  }

  public DominoUIConfig setSpellCheck(boolean spellCheck) {
    this.spellCheck = spellCheck;
    return this;
  }

  public DominoUILabels getDominoUILabels() {
    return dominoUILabels;
  }

  public DominoUIConfig setDominoUILabels(DominoUILabels dominoUILabels) {
    if (nonNull(dominoUILabels)) {
      this.dominoUILabels = dominoUILabels;
    }
    return this;
  }
//
//  /** An interface for rendering the required indicator on fields */
//  public interface RequiredIndicatorRenderer {
//    /**
//     * @param valueBox the {@link BasicFormElement} to append required to
//     * @param requiredIndicator the node for required indicator
//     * @param <T> the type of the form field
//     */
//    <T extends BasicFormElement<?, ?>> void appendRequiredIndicator(
//        T valueBox, Node requiredIndicator);
//
//    /**
//     * @param valueBox the {@link BasicFormElement} to remove required from
//     * @param requiredIndicator the node for required indicator
//     * @param <T> the type of the form field
//     */
//    <T extends BasicFormElement<?, ?>> void removeRequiredIndicator(
//        T valueBox, Node requiredIndicator);
//  }
//
//  /** A global validation handler that will be called when a form field gets validated */
//  public interface GlobalValidationHandler {
//    default <T extends ValueBox<?, ?, ?>> void onInvalidate(T valueBox, List<String> errors) {}
//
//    default <T extends ValueBox<?, ?, ?>> void onClearValidation(T valueBox) {}
//  }

  public DominoUIConfig setCardCollapseIcons(Supplier<BaseIcon<?>> collapseIcon, Supplier<BaseIcon<?>> expandIcon){
    this.cardCollapseIconSupplier = collapseIcon;
    this.cardExpandIconSupplier = expandIcon;
    return this;
  }

  public BaseIcon<?> getCardCollapseIcon(){
    return this.cardCollapseIconSupplier.get();
  }

  public BaseIcon<?> getCardExpandIcon(){
    return this.cardExpandIconSupplier.get();
  }
//
//  /** A provider for creating {@link CollapseStrategy} for TreeItem(s) */
//  public interface TreeCollapseSupplier {
//    CollapseStrategy get(TreeItem<?> treeItem);
//  }

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
