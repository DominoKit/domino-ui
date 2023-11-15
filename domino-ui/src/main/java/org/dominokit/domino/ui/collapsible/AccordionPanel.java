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

import static org.dominokit.domino.ui.utils.Domino.*;

import elemental2.dom.*;
import org.dominokit.domino.ui.config.AccordionConfig;
import org.dominokit.domino.ui.config.HasComponentConfig;
import org.dominokit.domino.ui.elements.DivElement;
import org.dominokit.domino.ui.icons.Icon;
import org.dominokit.domino.ui.layout.NavBar;
import org.dominokit.domino.ui.utils.*;

/**
 * A component used with the {@link org.dominokit.domino.ui.collapsible.Accordion} component to host
 * part of the content that needs to be collapsed/expanded when the user clicks on the panel header
 *
 * @see Accordion
 * @see BaseDominoElement
 */
public class AccordionPanel extends BaseDominoElement<HTMLDivElement, AccordionPanel>
    implements IsCollapsible<AccordionPanel>,
        CollapsibleStyles,
        HasComponentConfig<AccordionConfig> {

  private DivElement element;
  private LazyChild<NavBar> headerElement;
  private LazyChild<Icon<?>> panelIcon = NullLazyChild.of();
  private DivElement contentElement;
  private DivElement bodyElement;
  private LazyChild<NavBar> contentHeader;
  private LazyChild<NavBar> contentFooter;

  /** Creates an empty AccordionPanel */
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
        LazyChild.of(NavBar.create().addCss(dui_panel_header).setAttribute("role", "tab"), element);

    contentHeader = LazyChild.of(NavBar.create().addCss(dui_panel_content_header), contentElement);
    contentFooter = LazyChild.of(NavBar.create().addCss(dui_panel_footer), contentElement);
    setCollapseStrategy(getConfig().getDefaultAccordionCollapseStrategySupplier().get());

    addExpandListener(() -> addCss(dui_active));
    addCollapseListener(() -> removeCss(dui_active));
    collapse();
  }

  /**
   * Creates an accordion panel with a title in the header
   *
   * @param title The title text
   */
  public AccordionPanel(String title) {
    this();
    setTitle(title);
  }

  /**
   * Factory method to create an accordion panel with a title
   *
   * @param title The title text
   * @return new Accordion instance
   */
  public static AccordionPanel create(String title) {
    return new AccordionPanel(title);
  }

  /** @dominokit-site-ignore {@inheritDoc} */
  @Override
  public HTMLElement getAppendTarget() {
    return bodyElement.element();
  }

  /**
   * Appends a component or element to the right side of the panel header. This will initialize and
   * append the panel header if not yet initialized.
   *
   * @param element The element or component wrapped as a postfix.
   * @return Same AccordionPanel instance
   * @see NavBar
   */
  public AccordionPanel appendChild(PostfixAddOn<?> element) {
    headerElement.get().appendChild(element.addCss(dui_panel_utility));
    return this;
  }

  /**
   * Appends a component or element to the content body header section This will initialize and
   * append the content header section if not yet initialized.
   *
   * @param element The component or element wrapped as a {@link HeaderContent}
   * @return Same AccordionPanel instance
   * @see NavBar
   */
  public AccordionPanel appendChild(HeaderContent<?> element) {
    contentHeader.get().appendChild(element);
    return this;
  }

  /**
   * Appends a component or element to the content body footer section This will initialize and
   * append the content footer section if not yet initialized.
   *
   * @param element The component or element wrapped as a {@link FooterContent}
   * @return Same AccordionPanel instance
   * @see NavBar
   */
  public AccordionPanel appendChild(FooterContent<?> element) {
    contentFooter.get().appendChild(element);
    return this;
  }

  /** @dominokit-site-ignore {@inheritDoc} */
  @Override
  public HTMLElement getCollapsibleElement() {
    return contentElement.element();
  }

  /**
   * Sets the panel header title. This will initialize and append the header element if not yet
   * initialized.
   *
   * @param title The accordion panel header title
   * @return same AccordionPanel instance
   */
  public AccordionPanel setTitle(String title) {
    headerElement.get().setTitle(title);
    return this;
  }

  /**
   * Sets the panel header title. This will initialize and append the header element if not yet
   * initialized.
   *
   * @param title The accordion panel header title
   * @return same AccordionPanel instance
   */
  public AccordionPanel withTitle(String title) {
    return setTitle(title);
  }

  /**
   * Use to customize the header element of this AccordionPanel instance without breaking the fluent
   * API chain. This will initialize and append header if not yet initialized
   *
   * @see ChildHandler
   * @see NavBar
   * @param handler The {@code ChildHandler<AccordionPanel, NavBar>} applying the customizations
   * @return same AccordionPanel instance
   */
  public AccordionPanel withHeader(ChildHandler<AccordionPanel, NavBar> handler) {
    handler.apply(this, headerElement.get());
    return this;
  }

  /**
   * This will initialize and append the header element if not yet initialized.
   *
   * @return The {@link org.dominokit.domino.ui.layout.NavBar} representing the panel header
   */
  public NavBar getHeader() {
    return headerElement.get();
  }

  /**
   * Sets the icon in the panel header. This will initialize and append the header element if not
   * yet initialized
   *
   * @param icon The {@link org.dominokit.domino.ui.icons.Icon} to be used in the panel header
   * @return Same AccordionPanel instance
   */
  public AccordionPanel setIcon(Icon<?> icon) {
    panelIcon.remove();
    panelIcon = LazyChild.of(icon.addCss(dui_panel_icon), headerElement);
    panelIcon.get();
    return this;
  }

  /**
   * Sets the icon in the panel header. This will initialize and append the header element if not
   * yet initialized
   *
   * @param icon The {@link org.dominokit.domino.ui.icons.Icon} to be used in the panel header
   * @return Same AccordionPanel instance
   */
  public AccordionPanel withIcon(Icon<?> icon) {
    return setIcon(icon);
  }

  /** @dominokit-site-ignore {@inheritDoc} */
  @Override
  public HTMLDivElement element() {
    return element.element();
  }

  /** @return The {@link org.dominokit.domino.ui.elements.DivElement} that host the panel content */
  public DivElement getContentBody() {
    return bodyElement;
  }

  /**
   * Use to customize the content body element of this AccordionPanel instance without breaking the
   * fluent API chain.
   *
   * @see ChildHandler
   * @param handler The {@code ChildHandler<AccordionPanel, DivElement>} applying the customizations
   * @return same AccordionPanel instance
   */
  public AccordionPanel withContentBody(ChildHandler<AccordionPanel, DivElement> handler) {
    handler.apply(this, bodyElement);
    return this;
  }

  /**
   * @return The {@link org.dominokit.domino.ui.elements.DivElement} representing the panel content
   *     element
   */
  public DivElement getContent() {
    return contentElement;
  }

  /**
   * Use to customize the content element of this AccordionPanel instance without breaking the
   * fluent API chain. This will initialize and append content if not yet initialized
   *
   * @see ChildHandler
   * @param handler The {@code ChildHandler<AccordionPanel, DivElement>} applying the customizations
   * @return same AccordionPanel instance
   */
  public AccordionPanel withContent(ChildHandler<AccordionPanel, DivElement> handler) {
    handler.apply(this, contentElement);
    return this;
  }

  /**
   * @return The {@link org.dominokit.domino.ui.layout.NavBar} representing the panel content
   *     header.
   */
  public NavBar getContentHeader() {
    return contentHeader.get();
  }

  /**
   * Use to customize the content header element of this AccordionPanel instance without breaking
   * the fluent API chain. This will initialize and append content header if not yet initialized
   *
   * @see ChildHandler
   * @see NavBar
   * @param handler The {@code ChildHandler<AccordionPanel, NavBar>} applying the customizations
   * @return same AccordionPanel instance
   */
  public AccordionPanel withContentHeader(ChildHandler<AccordionPanel, NavBar> handler) {
    handler.apply(this, contentHeader.get());
    return this;
  }

  /**
   * Initialize and append the content header element if not yet initialized.
   *
   * @return Same AccordionPanel instance
   */
  public AccordionPanel withContentHeader() {
    contentHeader.get();
    return this;
  }

  /**
   * @return The {@link org.dominokit.domino.ui.layout.NavBar} representing the content footer
   *     element
   */
  public NavBar getContentFooter() {
    return contentFooter.get();
  }

  /**
   * Use to customize the content footer element of this AccordionPanel instance without breaking
   * the fluent API chain. This will initialize and append content footer if not yet initialized
   *
   * @see ChildHandler
   * @see NavBar
   * @param handler The {@code ChildHandler<AccordionPanel, NavBar>} applying the customizations
   * @return same AccordionPanel instance
   */
  public AccordionPanel withContentFooter(ChildHandler<AccordionPanel, NavBar> handler) {
    handler.apply(this, contentFooter.get());
    return this;
  }

  /**
   * Initialize and append the content footer element if not yet initialized.
   *
   * @return Same AccordionPanel instance
   */
  public AccordionPanel withContentFooter() {
    contentFooter.get();
    return this;
  }
}
