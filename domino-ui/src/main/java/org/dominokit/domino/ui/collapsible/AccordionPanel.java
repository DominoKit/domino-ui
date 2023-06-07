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
package org.dominokit.domino.ui.collapsible;

import elemental2.dom.*;
import org.dominokit.domino.ui.config.AccordionConfig;
import org.dominokit.domino.ui.config.HasComponentConfig;
import org.dominokit.domino.ui.elements.DivElement;
import org.dominokit.domino.ui.icons.Icon;
import org.dominokit.domino.ui.layout.NavBar;
import org.dominokit.domino.ui.utils.*;

/**
 * A component to show/hide content inside an {@link Accordion}
 *
 * <p>The accordion panel can be appended to an Accordion to show/hide some content when the user
 * clicks on the panel header
 *
 * @see Accordion
 */
public class AccordionPanel extends BaseDominoElement<HTMLDivElement, AccordionPanel>
    implements IsCollapsible<AccordionPanel>, CollapsibleStyles, HasComponentConfig<AccordionConfig> {

  private DivElement element;
  private LazyChild<NavBar> headerElement;
  private LazyChild<Icon<?>> panelIcon = NullLazyChild.of();
  private DivElement contentElement;
  private DivElement bodyElement;
  private LazyChild<NavBar> contentHeader;
  private LazyChild<NavBar> contentFooter;

  public AccordionPanel() {
    element =
        div()
            .addCss(dui_collapse_panel)
            .appendChild(
                contentElement =
                    div()
                        .addCss(dui_panel_content)
                        .appendChild(bodyElement = div().addCss(dui_panel_body)));
    init(this);

    headerElement =
        LazyChild.of(
                NavBar.create().addCss(dui_panel_header).setAttribute("role", "tab"), element);

    contentHeader =
        LazyChild.of(NavBar.create().addCss(dui_panel_content_header), contentElement);
    contentFooter = LazyChild.of(NavBar.create().addCss(dui_panel_footer), contentElement);
    setCollapseStrategy(getConfig().getDefaultAccordionCollapseStrategySupplier().get());

    addExpandListener(() -> addCss(dui_active));
    addCollapseListener(() -> removeCss(dui_active));
    collapse();
  }

  /** @param title String, the accordion panel header title */
  public AccordionPanel(String title) {
    this();
    setTitle(title);
  }

  /**
   * A factory to create Accordion panel with a title
   *
   * @param title String, the accordion panel header title
   * @return new Accordion instance
   */
  public static AccordionPanel create(String title) {
    return new AccordionPanel(title);
  }

  @Override
  protected HTMLElement getAppendTarget() {
    return bodyElement.element();
  }

  public AccordionPanel appendChild(PostfixAddOn<?> element) {
    headerElement.get().appendChild(element.addCss(dui_panel_utility));
    return this;
  }

  public AccordionPanel appendChild(HeaderContent<?> element) {
    contentHeader.get().appendChild(element);
    return this;
  }

  public AccordionPanel appendChild(FooterContent<?> element) {
    contentFooter.get().appendChild(element);
    return this;
  }

  @Override
  public HTMLElement getCollapsibleElement() {
    return contentElement.element();
  }

  /**
   * Change the panel header title.
   *
   * @param title String, the accordion panel header title
   * @return same AccordionPanel instance
   */
  public AccordionPanel setTitle(String title) {
    headerElement.get().setTitle(title);
    return this;
  }

  /**
   * Change the panel header title.
   *
   * @param title String, the accordion panel header title
   * @return same AccordionPanel instance
   */
  public AccordionPanel withTitle(String title) {
    return setTitle(title);
  }

  public AccordionPanel withHeader(
      ChildHandler<AccordionPanel, NavBar> handler) {
    handler.apply(this, headerElement.get());
    return this;
  }

  public NavBar getHeader() {
    return headerElement.get();
  }

  public AccordionPanel setIcon(Icon<?> icon) {
    panelIcon.remove();
    panelIcon = LazyChild.of(icon.addCss(dui_panel_icon), headerElement);
    panelIcon.get();
    return this;
  }

  public AccordionPanel withIcon(Icon<?> icon) {
    return setIcon(icon);
  }

  /** {@inheritDoc} */
  @Override
  public HTMLDivElement element() {
    return element.element();
  }

  public DivElement getContentBody() {
    return bodyElement;
  }

  public AccordionPanel withContentBody(
      ChildHandler<AccordionPanel, DivElement> handler) {
    handler.apply(this, bodyElement);
    return this;
  }

  public DivElement getContent() {
    return contentElement;
  }

  public AccordionPanel withContent(
      ChildHandler<AccordionPanel, DivElement> handler) {
    handler.apply(this, contentElement);
    return this;
  }

  public NavBar getContentHeader() {
    return contentHeader.get();
  }

  public AccordionPanel withContentHeader(
      ChildHandler<AccordionPanel, NavBar> handler) {
    handler.apply(this, contentHeader.get());
    return this;
  }

  public AccordionPanel withContentHeader() {
    contentHeader.get();
    return this;
  }

  public NavBar getContentFooter() {
    return contentFooter.get();
  }

  public AccordionPanel withContentFooter(
      ChildHandler<AccordionPanel, NavBar> handler) {
    handler.apply(this, contentFooter.get());
    return this;
  }

  public AccordionPanel withContentFooter() {
    contentFooter.get();
    return this;
  }
}
