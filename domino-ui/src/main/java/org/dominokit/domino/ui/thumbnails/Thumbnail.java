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
package org.dominokit.domino.ui.thumbnails;

import elemental2.dom.HTMLDivElement;
import elemental2.dom.HTMLElement;
import elemental2.dom.HTMLImageElement;
import elemental2.dom.HTMLPictureElement;
import elemental2.dom.Node;
import jsinterop.base.Js;
import org.dominokit.domino.ui.IsElement;
import org.dominokit.domino.ui.elements.DivElement;
import org.dominokit.domino.ui.style.SwapCssClass;
import org.dominokit.domino.ui.utils.BaseDominoElement;
import org.dominokit.domino.ui.utils.ChildHandler;
import org.dominokit.domino.ui.utils.FooterContent;
import org.dominokit.domino.ui.utils.HeaderContent;
import org.dominokit.domino.ui.utils.LazyChild;

/**
 * A component which provides a showcase for images and any other elements with extra caption
 *
 * <p>Customize the component can be done by overwriting classes provided by {@link ThumbnailStyles}
 *
 * <p>For example:
 *
 * <pre>
 *     Thumbnail.create()
 *         .setContent(a().add(img(GWT.getModuleBaseURL() + "/images/image-gallery/1.jpg").css(Styles.img_responsive)))
 *         .appendCaptionChild(h(3).textContent("Thumbnail label"))
 *         .appendCaptionChild(Paragraph.create(SAMPLE_TEXT))
 *         .appendCaptionChild(Button.createPrimary("BUTTON"))
 * </pre>
 *
 * @see BaseDominoElement
 */
public class Thumbnail extends BaseDominoElement<HTMLDivElement, Thumbnail> implements ThumbnailStyles {

    private final DivElement element;
    private final DivElement head;
    private final LazyChild<DivElement> title;
    private final DivElement body;

    private final LazyChild<DivElement> tail;
    private final LazyChild<DivElement> footer;

    private SwapCssClass directionCss = SwapCssClass.of();

    public Thumbnail() {
        this.element = div()
                .addCss(dui_thumbnail)
                .appendChild(head = div().addCss(dui_thumbnail_head)
                        .appendChild(body = div().addCss(dui_thumbnail_body))
                );
        title = LazyChild.of(div().addCss(dui_thumbnail_title), head);
        tail = LazyChild.of(div().addCss(dui_thumbnail_tail), element);
        footer = LazyChild.of(div().addCss(dui_thumbnail_footer), tail);

        init(this);
    }

    /**
     * @return new instnace
     */
    public static Thumbnail create() {
        return new Thumbnail();
    }

    @Override
    protected HTMLElement getAppendTarget() {
        return body.element();
    }

    public Thumbnail setDirection(ThumbnailDirection direction) {
        addCss(directionCss.replaceWith(direction));
        return this;
    }

    public Thumbnail appendChild(HTMLImageElement img) {
        elements.elementOf(img).addCss(dui_thumbnail_img);
        return super.appendChild(img);
    }

    public Thumbnail appendChild(IsElement<?> element) {
        if (element.element() instanceof HTMLImageElement || element.element() instanceof HTMLPictureElement) {
            elements.elementOf(element).addCss(dui_thumbnail_img);
        }
        return super.appendChild(element);
    }

    public Thumbnail appendChild(Node node) {
        if (node instanceof HTMLImageElement || node instanceof HTMLPictureElement) {
            elements.elementOf(Js.<HTMLElement>uncheckedCast(node)).addCss(dui_thumbnail_img);
        }
        return super.appendChild(node);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public HTMLDivElement element() {
        return element.element();
    }

    public Thumbnail withHeader(ChildHandler<Thumbnail, DivElement> handler) {
        handler.apply(this, head);
        return this;
    }

    public Thumbnail withTitle(ChildHandler<Thumbnail, DivElement> handler) {
        handler.apply(this, title.get());
        return this;
    }

    public Thumbnail withTitle() {
        title.get();
        return this;
    }

    public Thumbnail withTail(ChildHandler<Thumbnail, DivElement> handler) {
        handler.apply(this, tail.get());
        return this;
    }

    public Thumbnail withTail() {
        tail.get();
        return this;
    }

    public Thumbnail appendChild(FooterContent<?> footerContent){
        footer.get().appendChild(footerContent);
        return this;
    }

    public Thumbnail appendChild(HeaderContent<?> headerContent){
        title.get().appendChild(headerContent);
        return this;
    }

    public Thumbnail withFooter(ChildHandler<Thumbnail, DivElement> handler) {
        handler.apply(this, footer.get());
        return this;
    }

    public Thumbnail withFooter() {
        footer.get();
        return this;
    }

    public Thumbnail withBody(ChildHandler<Thumbnail, DivElement> handler) {
        handler.apply(this, body);
        return this;
    }

    public DivElement getHeader() {
        return head;
    }

    public DivElement getTitle() {
        return title.get();
    }

    public DivElement getBody() {
        return body;
    }

    public DivElement getTail() {
        return tail.get();
    }

    public DivElement getFooter() {
        return footer.get();
    }
}
