package org.dominokit.domino.ui.progress;

import elemental2.dom.HTMLDivElement;
import org.dominokit.domino.ui.utils.BaseDominoElement;

import static org.jboss.elemento.Elements.div;

/**
 * A component that can show the progress for one or more operation
 * <p>example</p>
 *
 * <pre>
 * Progress.create()
 *         .appendChild(ProgressBar.create(100).setValue(50));
 * </pre>
 *
 * @see ProgressBar
 */
public class Progress extends BaseDominoElement<HTMLDivElement, Progress> {

    private HTMLDivElement element=div().css(ProgressStyles.progress).element();

    /**
     *
     */
    public Progress() {
        init(this);
    }

    /**
     *
     * @return new Progress instance
     */
    public static Progress create(){
        return new Progress();
    }

    /**
     *
     * @param bar {@link ProgressBar} to be appended to this progress instance, each progress can have multiple ProgressBars
     * @return same Progress instance
     */
    public Progress appendChild(ProgressBar bar){
        element.appendChild(bar.element());
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public HTMLDivElement element() {
        return element;
    }

}
