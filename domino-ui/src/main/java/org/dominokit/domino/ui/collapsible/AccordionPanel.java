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
import org.dominokit.domino.ui.icons.BaseIcon;
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
        implements IsCollapsible<AccordionPanel>, CollapsibleStyles {

    private DominoElement<HTMLDivElement> element;
    private LazyChild<DominoElement<HTMLDivElement>> headerElement;
    private LazyChild<DominoElement<HTMLElement>> titleElement;
    private LazyChild<BaseIcon<?>> panelIcon = NullLazyChild.of();
    private DominoElement<HTMLDivElement> contentElement;
    private DominoElement<HTMLDivElement> bodyElement;
    private LazyChild<DominoElement<HTMLDivElement>> contentHeader;
    private LazyChild<DominoElement<HTMLDivElement>> contentFooter;

    public AccordionPanel() {
        element = DominoElement.div()
                .addCss(dui_collapse_panel)
                .appendChild(contentElement = DominoElement.div()
                        .addCss(dui_panel_content)
                        .appendChild(bodyElement = DominoElement.div().addCss(dui_panel_body))
                );
        init(this);

        headerElement = LazyChild.of(DominoElement.div()
                .addCss(dui_panel_header)
                .setAttribute("role", "tab"), element);

        titleElement = LazyChild.of(DominoElement.span().addCss(dui_panel_title), headerElement);
        contentHeader = LazyChild.of(DominoElement.div().addCss(dui_panel_content_header), contentElement);
        contentFooter = LazyChild.of(DominoElement.div().addCss(dui_panel_footer), contentElement);
        setCollapseStrategy(DominoUIConfig.CONFIG.getDefaultAccordionCollapseStrategySupplier().get());

        addShowListener(() -> addCss(dui_active_element));
        addHideListener(() -> removeCss(dui_active_element));
        hide();
    }

    /**
     * @param title String, the accordion panel header title
     */
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

    public AccordionPanel appendChild(UtilityElement<?> element) {
        headerElement.get().appendChild(element.addCss(dui_panel_utility));
        return this;
    }

    public AccordionPanel appendChild(HeaderElement<?> element) {
        contentHeader.get().appendChild(element);
        return this;
    }

    public AccordionPanel appendChild(FooterElement<?> element) {
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
        titleElement.get().setTextContent(title);
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

    public AccordionPanel withTitleElement(ChildHandler<AccordionPanel, DominoElement<HTMLElement>> handler) {
        handler.apply(this, titleElement.get());
        return this;
    }

    public DominoElement<HTMLElement> getTitleElement() {
        return titleElement.get();
    }
    public AccordionPanel withHeaderElement(ChildHandler<AccordionPanel, DominoElement<HTMLDivElement>> handler) {
        handler.apply(this, headerElement.get());
        return this;
    }

    public DominoElement<HTMLDivElement> getHeaderElement() {
        return headerElement.get();
    }

    public AccordionPanel setIcon(BaseIcon<?> icon) {
        panelIcon.remove();
        panelIcon = LazyChild.of(icon.addCss(dui_panel_icon), headerElement);
        panelIcon.get();
        return this;
    }

    public AccordionPanel withIcon(BaseIcon<?> icon) {
        return setIcon(icon);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public HTMLDivElement element() {
        return element.element();
    }

    public DominoElement<HTMLDivElement> getContentBody() {
        return bodyElement;
    }

    public AccordionPanel withContentBody(ChildHandler<AccordionPanel, DominoElement<HTMLDivElement>> handler){
        handler.apply(this, bodyElement);
        return this;
    }

    public DominoElement<HTMLDivElement> getContentElement() {
        return contentElement;
    }

    public AccordionPanel withContentElement(ChildHandler<AccordionPanel, DominoElement<HTMLDivElement>> handler){
        handler.apply(this, contentElement);
        return this;
    }

    public DominoElement<HTMLDivElement> getContentHeader(){
        return contentHeader.get();
    }

    public AccordionPanel withContentHeader(ChildHandler<AccordionPanel, DominoElement<HTMLDivElement>> handler){
        handler.apply(this, contentHeader.get());
        return this;
    }

    public AccordionPanel withContentHeader(){
        contentHeader.get();
        return this;
    }

    public DominoElement<HTMLDivElement> getContentFooter(){
        return contentFooter.get();
    }

    public AccordionPanel withContentFooter(ChildHandler<AccordionPanel, DominoElement<HTMLDivElement>> handler){
        handler.apply(this, contentFooter.get());
        return this;
    }

    public AccordionPanel withContentFooter(){
        contentFooter.get();
        return this;
    }

}
