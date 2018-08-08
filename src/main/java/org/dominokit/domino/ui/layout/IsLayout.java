package org.dominokit.domino.ui.layout;

import elemental2.dom.HTMLDivElement;
import elemental2.dom.HTMLElement;
import elemental2.dom.HTMLUListElement;
import org.dominokit.domino.ui.icons.Icon;
import org.dominokit.domino.ui.style.ColorScheme;

public interface IsLayout {
    IsLayout show();

    IsLayout show(ColorScheme theme);

    void toggleRightPanel();

    IsLayout showRightPanel();

    IsLayout hideRightPanel();

    void toggleLeftPanel();

    IsLayout showLeftPanel();

    IsLayout hideLeftPanel();

    HTMLElement getRightPanel();

    HTMLElement getLeftPanel();

    HTMLDivElement getContentPanel();

    HTMLUListElement getTopBar();

    NavigationBar getNavigationBar();

    Content getContentSection();

    Footer getFooter();

    IsLayout hideFooter();

    IsLayout showFooter();

    IsLayout setTitle(String title);

    HTMLElement addActionItem(Icon icon);
}
