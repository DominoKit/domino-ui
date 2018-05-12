package org.dominokit.domino.ui.layout;

import org.dominokit.domino.ui.icons.Icon;
import org.dominokit.domino.ui.style.ColorScheme;
import org.dominokit.domino.ui.themes.Theme;
import elemental2.dom.HTMLDivElement;
import elemental2.dom.HTMLElement;
import elemental2.dom.HTMLUListElement;

public interface IsLayout {
    Layout show();

    Layout show(ColorScheme theme);

    void toggleRightPanel();

    Layout showRightPanel();

    Layout hideRightPanel();

    void toggleLeftPanel();

    Layout showLeftPanel();

    Layout hideLeftPanel();

    HTMLElement getRightPanel();

    HTMLElement getLeftPanel();

    HTMLDivElement getContentPanel();

    HTMLUListElement getTopBar();

    NavigationBar getNavigationBar();

    Content getContentSection();

    Layout setTitle(String title);

    HTMLElement addActionItem(Icon icon);
}
