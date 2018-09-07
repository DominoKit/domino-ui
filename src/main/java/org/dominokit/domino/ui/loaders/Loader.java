package org.dominokit.domino.ui.loaders;

import elemental2.dom.HTMLElement;
import org.jboss.gwt.elemento.core.IsElement;

public class Loader {

    private boolean started=false;
    private HTMLElement target;
    private IsLoader loaderElement;

    public static Loader create(HTMLElement target, LoaderEffect effect){
        return new Loader(target, effect);
    }

    public static Loader create(IsElement target, LoaderEffect effect){
        return new Loader(target.asElement(), effect);
    }

    private Loader(HTMLElement target, LoaderEffect type){
        this.target=target;
        this.loaderElement =LoaderFactory.make(type);
    }

    public Loader start(){
        stop();
        target.appendChild(loaderElement.getElement());
        target.classList.add("waitMe_container");
        started=true;

        return this;
    }

    public Loader stop(){
        if(started){
            target.removeChild(loaderElement.getElement());
            target.classList.remove("waitMe_container");
            started=false;
        }

        return this;
    }

    public Loader setLoadingText(String text){
        loaderElement.setLoadingText(text);
        return this;
    }
}
