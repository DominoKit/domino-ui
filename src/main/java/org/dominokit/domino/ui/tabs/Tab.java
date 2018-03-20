package org.dominokit.domino.ui.tabs;

import org.dominokit.domino.ui.icons.Icon;
import org.dominokit.domino.ui.utils.HasClickableElement;
import elemental2.dom.*;

import static org.jboss.gwt.elemento.core.Elements.*;

public class Tab implements HasClickableElement{

    private HTMLAnchorElement clickableElement=a().asElement();
    private HTMLLIElement tab=li().attr("role","presentation").add(clickableElement).asElement();
    private HTMLDivElement contentContainer =div().attr("role","tabpanel").css("tab-pane", "fade").asElement();
    private boolean active;

    public Tab(String text) {
        clickableElement.textContent=text;
    }

    public Tab(Icon icon) {
        clickableElement.appendChild(icon.asElement());
    }

    public Tab(Icon icon, String text) {
        clickableElement.appendChild(icon.asElement());
        clickableElement.appendChild(new Text(text));
    }

    public static Tab create(String text){
        return new Tab(text);
    }

    public static Tab create(Icon icon){
        return new Tab(icon);
    }

    public static Tab create(Icon icon, String text){
        return new Tab(icon, text);
    }

    public HTMLLIElement getTab() {
        return tab;
    }

    public HTMLDivElement getContentContainer() {
        return contentContainer;
    }

    public Tab appendContent(Node content){
        contentContainer.appendChild(content);
        return this;
    }

    public Tab activate(){
        tab.classList.add("active");
        contentContainer.classList.add("in");
        contentContainer.classList.add("active");
        this.active=true;
        return this;
    }

    public Tab deActivate(){
        tab.classList.remove("active");
        contentContainer.classList.remove("in");
        contentContainer.classList.remove("active");
        this.active=false;
        return this;
    }

    public boolean isActive() {
        return active;
    }

    @Override
    public HTMLElement getClickableElement() {
        return clickableElement;
    }
}
