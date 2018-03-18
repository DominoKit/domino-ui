package com.progressoft.brix.domino.ui.layout;

import com.progressoft.brix.domino.ui.icons.Icon;
import com.progressoft.brix.domino.ui.themes.Theme;
import elemental2.dom.HTMLDivElement;
import elemental2.dom.HTMLElement;
import elemental2.dom.HTMLUListElement;

public interface IsLayout {
    Layout show();

    Layout show(Theme theme);

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

    Layout setTitle(String title);

    HTMLElement addActionItem(Icon icon);
}
