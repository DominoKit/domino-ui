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

import org.dominokit.domino.ui.config.DefaultUIConfig;
import org.dominokit.domino.ui.config.UIConfig;
import org.dominokit.domino.ui.i18n.DefaultDominoUILabels;
import org.dominokit.domino.ui.i18n.DominoUILabels;

// import org.dominokit.domino.ui.tree.TreeItem;

/**
 * This class provides global configuration for form fields
 *
 * <p>These configurations should be set before creating the form fields
 */
public class DominoUIConfig {

  /** The DominoFields single INSTANCE for global access. */
  public static final DominoUIConfig CONFIG = new DominoUIConfig();

  private DominoUILabels dominoUILabels = new DefaultDominoUILabels();
  private UIConfig uiConfig = new DefaultUIConfig();
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

  //  private TreeCollapseSupplier defaultTreeCollapseStrategySupplier =
  //      TreeHeightCollapseStrategy::new;

  protected DominoUIConfig() {}

  //
  //  /** @return the {@link RequiredIndicatorRenderer} */
  //  public RequiredIndicatorRenderer getRequiredIndicatorRenderer() {
  //    return requiredIndicatorRenderer;
  //  }

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

  public DominoUILabels getDominoUILabels() {
    return dominoUILabels;
  }

  public DominoUIConfig setDominoUILabels(DominoUILabels dominoUILabels) {
    if (nonNull(dominoUILabels)) {
      this.dominoUILabels = dominoUILabels;
    }
    return this;
  }

  public UIConfig getUIConfig() {
    return uiConfig;
  }

  public DominoUIConfig setUIConfig(UIConfig uiConfig) {
    if (nonNull(uiConfig)) {
      this.uiConfig = uiConfig;
    }
    return this;
  }

  /** An interface for rendering the required indicator on fields */
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

  //
  //  /** A provider for creating {@link CollapseStrategy} for TreeItem(s) */
  //  public interface TreeCollapseSupplier {
  //    CollapseStrategy get(TreeItem<?> treeItem);
  //  }

}
