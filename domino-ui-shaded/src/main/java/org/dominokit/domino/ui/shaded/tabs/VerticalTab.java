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
package org.dominokit.domino.ui.shaded.tabs;

import static java.util.Objects.nonNull;
import static org.dominokit.domino.ui.shaded.tabs.TabStyles.*;
import static org.jboss.elemento.Elements.*;

import elemental2.dom.HTMLAnchorElement;
import elemental2.dom.HTMLDivElement;
import elemental2.dom.HTMLElement;
import elemental2.dom.Node;
import java.util.ArrayList;
import java.util.List;
import org.dominokit.domino.ui.shaded.grid.flex.FlexItem;
import org.dominokit.domino.ui.shaded.icons.BaseIcon;
import org.dominokit.domino.ui.shaded.style.*;
import org.dominokit.domino.ui.shaded.utils.DominoElement;
import org.dominokit.domino.ui.shaded.utils.HasClickableElement;
import org.jboss.elemento.IsElement;

/** A component for a single Tab in the {@link VerticalTabsPanel} */
@Deprecated
public class VerticalTab extends WavesElement<HTMLDivElement, VerticalTab>
    implements HasClickableElement {

  private String title;
  private FlexItem<HTMLDivElement> element;
  private HTMLAnchorElement anchorElement;

  private BaseIcon<?> icon;
  private DominoElement<HTMLElement> titleElement;
  private DominoElement<HTMLDivElement> contentContainer =
      DominoElement.of(div()).attr("role", "tabpanel").css(TAB_PANE, FADE);
  private boolean active;
  private DominoElement<HTMLDivElement> iconContainer = DominoElement.div();
  private DominoElement<HTMLDivElement> textContainer =
      DominoElement.div().styler(style -> style.setMarginTop(Unit.px.of(2)));

  private Color textColor;
  private Color iconColor;

  private final List<VerticalTab.ActivationHandler> activationHandlers = new ArrayList<>();

  private boolean textColorOverridden = false;
  private boolean iconColorOverridden = false;

  private Color color = Color.GREY_DARKEN_3;

  /**
   * @param title String tab header title
   * @param icon icon {@link BaseIcon} for the tab header
   */
  public VerticalTab(String title, BaseIcon<?> icon) {
    this.title = title;
    setIcon(icon);
    this.titleElement = DominoElement.of(span()).css(TITLE).textContent(title);
    this.anchorElement =
        DominoElement.of(a())
            .add(iconContainer.appendChild(this.icon))
            .add(textContainer.appendChild(titleElement))
            .element();
    init();
  }

  /** @param title String title for the tab */
  public VerticalTab(String title) {
    this.title = title;
    this.titleElement = DominoElement.of(span()).css(TITLE).textContent(title);
    this.anchorElement =
        DominoElement.of(a())
            .add(iconContainer)
            .add(textContainer.appendChild(titleElement))
            .element();
    init();
  }

  /** @param icon {@link BaseIcon} for the tab header */
  public VerticalTab(BaseIcon<?> icon) {
    setIcon(icon);
    this.anchorElement = a().add(iconContainer.appendChild(this.icon)).add(textContainer).element();
    init();
  }

  /**
   * @param title String tab header title
   * @return new instance
   */
  public static VerticalTab create(String title) {
    return new VerticalTab(title);
  }

  /**
   * @param title String title for the tab header
   * @param icon icon {@link BaseIcon} for the tab header
   * @return new instance
   */
  public static VerticalTab create(String title, BaseIcon<?> icon) {
    return new VerticalTab(title, icon);
  }

  /**
   * @param icon icon {@link BaseIcon} for the tab header
   * @return new instance
   */
  public static VerticalTab create(BaseIcon<?> icon) {
    return new VerticalTab(icon);
  }

  private void init() {
    this.element = FlexItem.create().css(Color.GREY_DARKEN_3.getStyle());
    this.element.appendChild(anchorElement);
    init(this);
    setWaveColor(WaveColor.THEME);
    applyWaveStyle(WaveStyle.BLOCK);
  }

  /** @return the {@link HTMLDivElement} that contains the VerticalTab content */
  public DominoElement<HTMLDivElement> getContentContainer() {
    return DominoElement.of(contentContainer);
  }

  /**
   * make the tab active and show its content in the TabsPanel
   *
   * @return same instance
   */
  public VerticalTab activate() {
    Style.of(element()).addCss(ACTIVE);
    contentContainer.addCss(IN, ACTIVE);
    this.active = true;
    activationHandlers.forEach(handler -> handler.onActiveStateChanged(this, true));
    return this;
  }

  /**
   * make the tab inactive and hide its content in the TabsPanel
   *
   * @return same instance
   */
  public VerticalTab deactivate() {
    Style.of(element()).removeCss(ACTIVE);
    contentContainer.removeCss(IN, ACTIVE);
    this.active = false;
    activationHandlers.forEach(handler -> handler.onActiveStateChanged(this, false));
    return this;
  }

  /**
   * @param content {@link Node} to be appended to the tab contentContainer
   * @return same instance
   */
  public VerticalTab appendChild(Node content) {
    contentContainer.appendChild(content);
    return this;
  }

  /**
   * @param title String new tab header title
   * @return same instance
   */
  public VerticalTab setTitle(String title) {
    titleElement.setTextContent(title);
    return this;
  }

  /**
   * @param content {@link IsElement} to be appended to the tab contentContainer
   * @return same instance
   */
  public VerticalTab appendChild(IsElement<?> content) {
    return appendChild(content.element());
  }

  /** {@inheritDoc} */
  @Override
  public HTMLAnchorElement getClickableElement() {
    return anchorElement;
  }

  /**
   * @param icon the new {@link BaseIcon} for the tab header
   * @return same instance
   */
  public VerticalTab setIcon(BaseIcon<?> icon) {
    this.icon = icon;
    iconContainer.clearElement();
    iconContainer.appendChild(icon);
    return this;
  }

  /** @return String tab header title */
  public String getTitle() {
    return title;
  }

  /** @return boolean, true if the tab is currently active */
  public boolean isActive() {
    return active;
  }

  /** @return the {@link HTMLElement} that contains the tab header title */
  public DominoElement<HTMLElement> getTitleElement() {
    return DominoElement.of(titleElement);
  }

  /** @return the {@link HTMLElement} that has the waves effect */
  @Override
  public HTMLElement getWavesElement() {
    return anchorElement;
  }

  /** {@inheritDoc} */
  @Override
  public HTMLDivElement element() {
    return element.element();
  }

  /**
   * @param textColor {@link org.dominokit.domino.ui.icons.Color} of the tab title text
   * @return same instance
   */
  public VerticalTab setTextColor(Color textColor) {
    if (!textColorOverridden && nonNull(title)) {
      if (nonNull(this.textColor)) {
        this.titleElement.removeCss(this.textColor.getStyle());
      }
      this.titleElement.addCss(textColor.getStyle());
      this.textColor = textColor;
    }
    return this;
  }

  /**
   * @param iconColor {@link org.dominokit.domino.ui.icons.Color} of the tab header icon
   * @return same instance
   */
  public VerticalTab setIconColor(Color iconColor) {
    if (!iconColorOverridden && nonNull(icon)) {
      if (nonNull(this.iconColor)) {
        this.icon.removeCss(this.iconColor.getStyle());
      }
      this.icon.addCss(iconColor.getStyle());
      this.iconColor = iconColor;
    }
    return this;
  }

  /**
   * Override the tab title text color and prevent it from changing with {@link
   * #setTextColor(Color)}
   *
   * @param textColor {@link org.dominokit.domino.ui.icons.Color}
   * @return same instance
   */
  public VerticalTab setTextColorOverride(Color textColor) {
    setTextColor(textColor);
    this.textColorOverridden = true;
    return this;
  }

  /**
   * Override the tab icon color and prevent it from changing with {@link #setIconColor(Color)}
   *
   * @param iconColor {@link org.dominokit.domino.ui.icons.Color}
   * @return same instance
   */
  public VerticalTab setIconColorOverride(Color iconColor) {
    setIconColor(iconColor);
    this.iconColorOverridden = true;
    return this;
  }

  /**
   * @param activationHandler {@link ActivationHandler}
   * @return same instance
   */
  public VerticalTab addActivationHandler(VerticalTab.ActivationHandler activationHandler) {
    if (nonNull(activationHandler)) {
      this.activationHandlers.add(activationHandler);
    }
    return this;
  }

  /**
   * @param activationHandler {@link ActivationHandler}
   * @return same instance
   */
  public VerticalTab removeActivationHandler(VerticalTab.ActivationHandler activationHandler) {
    if (nonNull(activationHandler)) {
      this.activationHandlers.remove(activationHandler);
    }
    return this;
  }

  /**
   * @param color {@link org.dominokit.domino.ui.icons.Color} of the tab header
   * @return same instance
   */
  public VerticalTab setColor(Color color) {
    element.removeCss(this.color.getStyle());
    element.css(color.getStyle());
    this.color = color;
    return this;
  }

  /**
   * Restores the tab color to the default
   *
   * @return same instance
   */
  public VerticalTab resetColor() {
    element.removeCss(this.color.getStyle());
    element.css(Color.GREY_DARKEN_3.getStyle());
    this.color = Color.GREY_DARKEN_3;
    return this;
  }

  /** A function to handle tab activation/deactivation */
  @FunctionalInterface
  @Deprecated
  public interface ActivationHandler {
    /**
     * @param tab the {@link VerticalTab} that has its activation state changed
     * @param active boolean, true if new state is active, false if inactive
     */
    void onActiveStateChanged(VerticalTab tab, boolean active);
  }
}
