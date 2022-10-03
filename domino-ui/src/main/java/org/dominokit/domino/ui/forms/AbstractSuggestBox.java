///*
// * Copyright © 2019 Dominokit
// *
// * Licensed under the Apache License, Version 2.0 (the "License");
// * you may not use this file except in compliance with the License.
// * You may obtain a copy of the License at
// *
// *     http://www.apache.org/licenses/LICENSE-2.0
// *
// * Unless required by applicable law or agreed to in writing, software
// * distributed under the License is distributed on an "AS IS" BASIS,
// * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
// * See the License for the specific language governing permissions and
// * limitations under the License.
// */
//package org.dominokit.domino.ui.forms;
//
//import static elemental2.dom.DomGlobal.document;
//import static elemental2.dom.DomGlobal.window;
//import static java.util.Objects.isNull;
//import static java.util.Objects.nonNull;
//import static org.dominokit.domino.ui.style.Unit.px;
//import static org.jboss.elemento.Elements.div;
//
//import elemental2.dom.*;
//import java.util.ArrayList;
//import java.util.List;
//import java.util.Optional;
//import org.dominokit.domino.ui.dropdown.DropDownMenu;
//import org.dominokit.domino.ui.dropdown.DropDownPosition;
//import org.dominokit.domino.ui.dropdown.DropdownAction;
//import org.dominokit.domino.ui.forms.SuggestBoxStore.MissingEntryProvider;
//import org.dominokit.domino.ui.forms.SuggestBoxStore.MissingSuggestProvider;
//import org.dominokit.domino.ui.keyboard.KeyboardEvents;
//import org.dominokit.domino.ui.loaders.Loader;
//import org.dominokit.domino.ui.loaders.LoaderEffect;
//import org.dominokit.domino.ui.style.Color;
//import org.dominokit.domino.ui.utils.AppendStrategy;
//import org.dominokit.domino.ui.utils.DelayedTextInput;
//import org.dominokit.domino.ui.utils.DominoElement;
//import org.dominokit.domino.ui.utils.DominoUIConfig;
//import org.dominokit.domino.ui.utils.HasSelectionHandler;
//import org.jboss.elemento.Elements;
//
///**
// * A component that dynamically loads suggestions from a {@link SuggestBoxStore} while the user is
// * typing
// *
// * @param <T> The type of the component extending form this class
// * @param <V> the type of the AbstractSuggestBox value
// */
//public abstract class AbstractSuggestBox<T extends AbstractSuggestBox<T, V>, V>
//    extends AbstractValueBox<T, HTMLInputElement, V>
//    implements HasSelectionHandler<T, SelectOption<V>> {
//
//  private static final String TEXT = "text";
//  private DropDownMenu suggestionsMenu;
//  private List<SelectionHandler<SelectOption<V>>> selectionHandlers;
//  private SuggestBoxStore<V> store;
//  private HTMLDivElement loaderContainer =
//      DominoElement.of(div()).css("suggest-box-loader").element();
//  private Loader loader;
//  private boolean emptyAsNull;
//  private Color highlightColor;
//  private V value;
//  private int typeAheadDelay = 200;
//  private SelectOption<V> selectedItem;
//  private DelayedTextInput delayedTextInput;
//  private boolean focusOnClose = true;
//  private DelayedTextInput.DelayedAction delayedAction =
//      () -> {
//        if (isEmptyIgnoreSpaces()) {
//          suggestionsMenu.close();
//          clearValue();
//        } else {
//          search();
//        }
//      };
//  private boolean autoSelect = true;
//  private String dropdownMaxWidth = null;
//
//  /** Creates an instance without a label and a null store */
//  public AbstractSuggestBox() {
//    this("");
//  }
//
//  /**
//   * Creates an instance with a label and a null store
//   *
//   * @param label String label
//   */
//  public AbstractSuggestBox(String label) {
//    this(label, null);
//  }
//
//  /**
//   * Creates an instance without a label and initialized with a store
//   *
//   * @param store {@link SuggestBoxStore}
//   */
//  public AbstractSuggestBox(SuggestBoxStore<V> store) {
//    this("", store);
//  }
//
//  /**
//   * Creates an instance with a label and initialized with a store
//   *
//   * @param label String
//   * @param store {@link SuggestBoxStore}
//   */
//  public AbstractSuggestBox(String label, SuggestBoxStore<V> store) {
//    this(TEXT, label, store);
//  }
//
//  /**
//   * Creates an instance with a label and initialized with the input type and a store
//   *
//   * @param type String input element type
//   * @param label String
//   * @param store {@link SuggestBoxStore}
//   */
//  public AbstractSuggestBox(String type, String label, SuggestBoxStore<V> store) {
//    super(type, label);
//    this.store = store;
//    if (isNull(selectionHandlers)) {
//      selectionHandlers = new ArrayList<>();
//    }
//    suggestionsMenu = DropDownMenu.create(fieldContainer);
//    suggestionsMenu.setAppendTarget(document.body);
//    suggestionsMenu.setAppendStrategy(AppendStrategy.FIRST);
//    suggestionsMenu.setPosition(
//        DominoUIConfig.CONFIG.getDefaultSuggestPopupPosition().createPosition(this));
//    suggestionsMenu.addCloseHandler(
//        () -> {
//          if (focusOnClose) {
//            focus();
//          }
//        });
//    Element element = document.querySelector(".content");
//    if (nonNull(element)) {
//      EventListener eventListener =
//          evt -> {
//            suggestionsMenu
//                .style()
//                .setMinWidth(element().offsetWidth + "px")
//                .setMaxWidth(
//                    nonNull(dropdownMaxWidth) ? dropdownMaxWidth : element().offsetWidth + "px");
//          };
//      element.addEventListener("transitionend", eventListener);
//      onDetached(mutationRecord -> element.removeEventListener("transitionend", eventListener));
//    }
//    onAttached(
//        mutationRecord -> {
//          suggestionsMenu
//              .style()
//              .setMinWidth(element().offsetWidth + "px")
//              .setMaxWidth(
//                  nonNull(dropdownMaxWidth) ? dropdownMaxWidth : element().offsetWidth + "px");
//        });
//    getFieldInputContainer().insertFirst(loaderContainer);
//    setLoaderEffect(LoaderEffect.IOS);
//
//    delayedTextInput =
//        DelayedTextInput.create(getInputElement(), typeAheadDelay).setDelayedAction(delayedAction);
//    KeyboardEvents.listenOnKeyDown(getInputElement())
//        .onArrowDown(
//            evt -> {
//              suggestionsMenu.focus();
//              evt.preventDefault();
//            })
//        .onArrowUp(
//            evt -> {
//              suggestionsMenu.focus();
//              evt.preventDefault();
//            })
//        .onEscape(
//            evt -> {
//              focus();
//              evt.preventDefault();
//            })
//        .onEnter(
//            evt -> {
//              if (suggestionsMenu.isOpened() && !suggestionsMenu.getFilteredAction().isEmpty()) {
//                evt.stopPropagation();
//                evt.preventDefault();
//                if (isAutoSelect()) {
//                  List<DropdownAction<?>> filteredActions = suggestionsMenu.getFilteredAction();
//                  suggestionsMenu.selectAt(
//                      suggestionsMenu.getActions().indexOf(filteredActions.get(0)));
//                  filteredActions.get(0).select();
//                  suggestionsMenu.close();
//                } else {
//                  suggestionsMenu.focus();
//                }
//              }
//            })
//        .onTab(
//            evt -> {
//              if (suggestionsMenu.isOpened()) {
//                evt.stopPropagation();
//                evt.preventDefault();
//                suggestionsMenu.focus();
//              }
//            });
//  }
//
//  /** Filter the items based on the currently typed text in the AbstractSuggestBox */
//  public final void search() {
//    if (store != null) {
//      loader.start();
//      suggestionsMenu.clearActions();
//      suggestionsMenu.close();
//      store.filter(
//          getStringValue(),
//          suggestions -> {
//            selectedItem = null;
//            suggestionsMenu.clearActions();
//
//            if (suggestions.isEmpty()) {
//              applyMissingEntry(getStringValue());
//            }
//
//            suggestions.forEach(
//                suggestion -> {
//                  suggestion.highlight(AbstractSuggestBox.this.getStringValue(), highlightColor);
//                  suggestionsMenu.appendChild(dropdownAction(suggestion));
//                });
//            suggestionsMenu.open(false);
//            loader.stop();
//          });
//    }
//  }
//
//  /** {@inheritDoc} */
//  @Override
//  protected HTMLInputElement createInputElement(String type) {
//    return Elements.input(type).element();
//  }
//
//  /** @return int delay in milliseconds before triggering the search after the user stops typing */
//  public int getTypeAheadDelay() {
//    return typeAheadDelay;
//  }
//
//  /**
//   * @param delayMilliseconds int delay in milliseconds before triggering the search after the user
//   *     stops typing
//   * @return same AbstractSuggestBox instance
//   */
//  public T setTypeAheadDelay(int delayMilliseconds) {
//    this.typeAheadDelay = delayMilliseconds;
//    this.delayedTextInput.setDelay(delayMilliseconds);
//    return (T) this;
//  }
//
//  /** @return the {@link org.dominokit.domino.ui.utils.DelayedTextInput.DelayedAction} */
//  public DelayedTextInput.DelayedAction getDelayedAction() {
//    return delayedAction;
//  }
//
//  /**
//   * Set a custom action to be executed after the user stops typing that override the default search
//   * action
//   *
//   * @param delayedAction {@link org.dominokit.domino.ui.utils.DelayedTextInput.DelayedAction}
//   * @return same AbstractSuggestBox instance
//   */
//  public T setDelayedAction(DelayedTextInput.DelayedAction delayedAction) {
//    this.delayedAction = delayedAction;
//    this.delayedTextInput.setDelayedAction(delayedAction);
//    return (T) this;
//  }
//
//  /**
//   * Sets the action to be executed when the user press Enter to override the default search action
//   *
//   * @param onEnterAction {@link org.dominokit.domino.ui.utils.DelayedTextInput.DelayedAction}
//   * @return same AbstractSuggestBox instance
//   */
//  public T setOnEnterAction(DelayedTextInput.DelayedAction onEnterAction) {
//    this.delayedTextInput.setOnEnterAction(onEnterAction);
//    return (T) this;
//  }
//
//  /** {@inheritDoc} */
//  @Override
//  protected void clearValue(boolean silent) {
//    value(null, silent);
//  }
//
//  /** {@inheritDoc} */
//  @Override
//  protected void doSetValue(V value) {
//    if (nonNull(store)) {
//      store.find(
//          value,
//          suggestItem -> {
//            if (nonNull(suggestItem)) {
//              this.value = value;
//              getInputElement().element().value = suggestItem.getDisplayValue();
//            } else {
//              if (!applyMissingValue(value)) {
//                this.value = null;
//                getInputElement().element().value = "";
//              }
//            }
//          });
//    }
//  }
//
//  private boolean applyMissingValue(V value) {
//    MissingSuggestProvider<V> messingSuggestionProvider = store.getMessingSuggestionProvider();
//    Optional<SelectOption<V>> messingSuggestion =
//        messingSuggestionProvider.getMessingSuggestion(value);
//    return applyMissing(messingSuggestion);
//  }
//
//  private boolean applyMissingEntry(String value) {
//    MissingEntryProvider<V> messingEntryProvider = store.getMessingEntryProvider();
//    Optional<SelectOption<V>> messingSuggestion = messingEntryProvider.getMessingSuggestion(value);
//    return applyMissing(messingSuggestion);
//  }
//
//  private boolean applyMissing(Optional<SelectOption<V>> messingSuggestion) {
//    if (messingSuggestion.isPresent()) {
//        SelectOption<V> messingSuggestItem = messingSuggestion.get();
//      this.value = messingSuggestItem.getValue();
//      getInputElement().element().value = messingSuggestItem.getDisplayValue();
//      return true;
//    }
//    return false;
//  }
//
//  /** {@inheritDoc} */
//  @Override
//  public V getValue() {
//    if (isNull(selectedItem)) {
//      applyMissingEntry(getStringValue());
//    }
//
//    return this.value;
//  }
//
//  /**
//   * @param store {@link SuggestBoxStore}
//   * @return same AbstractSuggestBox instance
//   */
//  public T setSuggestBoxStore(SuggestBoxStore<V> store) {
//    this.store = store;
//    return (T) this;
//  }
//
//  /**
//   * @param type String type of the htmml input element
//   * @return same AbstractSuggestBox instance
//   */
//  public T setType(String type) {
//    getInputElement().element().type = type;
//    return (T) this;
//  }
//
//  /** {@inheritDoc} */
//  @Override
//  public String getStringValue() {
//    String stringValue = getInputElement().element().value;
//    if (stringValue.isEmpty() && isEmptyAsNull()) {
//      return null;
//    }
//    return stringValue;
//  }
//
//  protected final DropdownAction<V> dropdownAction(SuggestItem<V> suggestItem) {
//    DropdownAction<V> dropdownAction = suggestItem.asDropDownAction();
//    dropdownAction.addSelectionHandler(
//        value -> {
//          selectedItem = suggestItem;
//          setValue(value);
//          selectionHandlers.forEach(handler -> handler.onSelection(suggestItem));
//          suggestionsMenu.close();
//        });
//    return dropdownAction;
//  }
//
//  /** {@inheritDoc} */
//  @Override
//  public T addSelectionHandler(SelectionHandler<SuggestItem<V>> selectionHandler) {
//    if (isNull(selectionHandlers)) {
//      selectionHandlers = new ArrayList<>();
//    }
//    selectionHandlers.add(selectionHandler);
//    return (T) this;
//  }
//
//  /** {@inheritDoc} */
//  @Override
//  public T removeSelectionHandler(SelectionHandler<SuggestItem<V>> selectionHandler) {
//    selectionHandlers.remove(selectionHandler);
//    return (T) this;
//  }
//
//  /**
//   * Sets a custom loader effect to be visible while the store is retrieving the suggestions
//   *
//   * @param loaderEffect {@link LoaderEffect}
//   * @return same AbstractSuggestBox instance
//   */
//  public T setLoaderEffect(LoaderEffect loaderEffect) {
//    loader =
//        Loader.create(loaderContainer, loaderEffect)
//            .setSize("20px", "20px")
//            .setRemoveLoadingText(true);
//    return (T) this;
//  }
//
//  /** @return the {@link Loader} used by the AbstractSuggestBox */
//  public Loader getLoader() {
//    return loader;
//  }
//
//  /**
//   * @param emptyAsNull boolean, if ture empty value will be considered null otherwise it is an
//   *     empty String
//   * @return same AbstractSuggestBox instance
//   */
//  public T setEmptyAsNull(boolean emptyAsNull) {
//    this.emptyAsNull = emptyAsNull;
//    return (T) this;
//  }
//
//  /** @return boolean, true if empty value will be considered null otherwise false */
//  public boolean isEmptyAsNull() {
//    return emptyAsNull;
//  }
//
//  /** @return the {@link SuggestBoxStore} of this AbstractSuggestBox */
//  public SuggestBoxStore<V> getStore() {
//    return store;
//  }
//
//  /** @return the {@link DelayedTextInput} of this AbstractSuggestBox */
//  public DelayedTextInput getDelayedTextInput() {
//    return delayedTextInput;
//  }
//
//  /** @return the {@link DropDownMenu} of the AbstractSuggestBox */
//  public DropDownMenu getSuggestionsMenu() {
//    return suggestionsMenu;
//  }
//
//  /**
//   * @return color to be used to highlight parts of the SuggestItems that matches the typed string
//   */
//  public Color getHighlightColor() {
//    return highlightColor;
//  }
//
//  /**
//   * Set the color to be used to highlight parts of the SuggestItems that matches the typed String
//   * in the text input
//   *
//   * @param highlightColor {@link Color}
//   * @return same AbstractSuggestBox instance
//   */
//  public T setHighlightColor(Color highlightColor) {
//    this.highlightColor = highlightColor;
//    return (T) this;
//  }
//
//  /** {@inheritDoc} */
//  @Override
//  protected AutoValidator createAutoValidator(AutoValidate autoValidate) {
//    return new SuggestAutoValidator<>(this, autoValidate);
//  }
//
//  /** @return boolean, true if autoSelect is enabled */
//  public boolean isAutoSelect() {
//    return autoSelect;
//  }
//
//  /**
//   * @param autoSelect boolean, if true pressing enter will automatically select the first entry
//   *     from the Suggestions menu
//   * @return same AbstractSuggestBox instance
//   */
//  public T setAutoSelect(boolean autoSelect) {
//    this.autoSelect = autoSelect;
//    return (T) this;
//  }
//
//  /** @return maximal width of dropdown */
//  public String getDropdownMaxWidth() {
//    return dropdownMaxWidth;
//  }
//
//  /**
//   * @param dropdownMaxWidth maximal width of dropdown. if null - equals width of control
//   * @return same AbstractSuggestBox instance
//   */
//  public T setDropdownMaxWidth(String dropdownMaxWidth) {
//    this.dropdownMaxWidth = dropdownMaxWidth;
//    return (T) this;
//  }
//
//  /** @return boolean, true if the focusOnClose is enabled */
//  public boolean isFocusOnClose() {
//    return focusOnClose;
//  }
//
//  /**
//   * @param focusOnClose boolean, if true after closing the suggestions menu the focus will go back
//   *     to the suggest box input
//   * @return same AbstractSuggestBox instance
//   */
//  public T setFocusOnClose(boolean focusOnClose) {
//    this.focusOnClose = focusOnClose;
//    return (T) this;
//  }
//
//  /**
//   * A {@link DropDownPosition} that opens the suggestion dropdown menu up or down based on the
//   * largest space available, the menu will show where the is more space
//   */
//  public static class PopupPositionTopDown implements DropDownPosition {
//
//    private DropDownPositionUp up = new DropDownPositionUp();
//    private DropDownPositionDown down = new DropDownPositionDown();
//    private AbstractSuggestBox<?, ?> suggestBox;
//
//    public PopupPositionTopDown(AbstractSuggestBox<?, ?> suggestBox) {
//      this.suggestBox = suggestBox;
//    }
//
//    /** {@inheritDoc} */
//    @Override
//    public void position(HTMLElement popup, HTMLElement target) {
//      DOMRect targetRect = target.getBoundingClientRect();
//
//      double distanceToMiddle = targetRect.top + (targetRect.height / 2);
//      double windowMiddle = window.innerHeight / 2;
//      double popupHeight = popup.getBoundingClientRect().height;
//      double distanceToBottom = window.innerHeight - targetRect.bottom;
//      double distanceToTop = targetRect.top;
//
//      boolean hasSpaceBelow = distanceToBottom > popupHeight;
//      boolean hasSpaceUp = distanceToTop > popupHeight;
//
//      if ((distanceToMiddle >= windowMiddle) && hasSpaceUp) {
//        up.position(popup, target);
//        popup.setAttribute("popup-direction", "top");
//      } else {
//        down.position(popup, target);
//        popup.setAttribute("popup-direction", "down");
//      }
//
//      popup.style.setProperty("min-width", targetRect.width + "px");
//      popup.style.setProperty(
//          "max-width",
//          nonNull(suggestBox.dropdownMaxWidth)
//              ? suggestBox.dropdownMaxWidth
//              : targetRect.width + "px");
//    }
//  }
//
//  /** A {@link DropDownPosition} that opens the suggestion dropdown menu up */
//  public static class DropDownPositionUp implements DropDownPosition {
//    /** {@inheritDoc} */
//    @Override
//    public void position(HTMLElement actionsMenu, HTMLElement target) {
//
//      DOMRect targetRect = target.getBoundingClientRect();
//
//      actionsMenu.style.setProperty(
//          "bottom", px.of(window.innerHeight - targetRect.top - window.pageYOffset));
//      actionsMenu.style.setProperty("left", px.of(targetRect.left + window.pageXOffset));
//      actionsMenu.style.removeProperty("top");
//    }
//  }
//
//  /** A {@link DropDownPosition} that opens the suggestion dropdown menu down */
//  public static class DropDownPositionDown implements DropDownPosition {
//
//    /** {@inheritDoc} */
//    @Override
//    public void position(HTMLElement actionsMenu, HTMLElement target) {
//
//      DOMRect targetRect = target.getBoundingClientRect();
//
//      actionsMenu.style.setProperty("top", px.of(targetRect.bottom + window.pageYOffset));
//      actionsMenu.style.setProperty("left", px.of(targetRect.left + window.pageXOffset));
//      actionsMenu.style.removeProperty("bottom");
//    }
//  }
//
//  private static class SuggestAutoValidator<V> extends AutoValidator {
//
//    private AbstractSuggestBox<?, V> suggestBox;
//    private SelectionHandler<SelectOption<V>> selectionHandler;
//
//    public SuggestAutoValidator(AbstractSuggestBox<?, V> suggestBox, AutoValidate autoValidate) {
//      super(autoValidate);
//      this.suggestBox = suggestBox;
//    }
//
//    @Override
//    public void attach() {
//      selectionHandler = option -> autoValidate.apply();
//      suggestBox.addSelectionHandler(selectionHandler);
//    }
//
//    @Override
//    public void remove() {
//      suggestBox.removeSelectionHandler(selectionHandler);
//    }
//  }
//}
