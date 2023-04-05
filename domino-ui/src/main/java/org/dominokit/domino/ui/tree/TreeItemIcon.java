package org.dominokit.domino.ui.tree;

import org.dominokit.domino.ui.icons.MdiIcon;
import org.dominokit.domino.ui.icons.StateChangeMdiIcon;

public class TreeItemIcon {

    public static final String STATE_COLLAPSED = "dui-tree-collapsed";
    public static final String STATE_EXPANDED = "dui-tree-expanded";
    public static final String STATE_LEAF = "dui-tree-leaf";

    public static StateChangeMdiIcon of(MdiIcon collapsed, MdiIcon expanded, MdiIcon leaf){
        StateChangeMdiIcon stateChangeMdiIcon= new StateChangeMdiIcon(MdiIcon.create(leaf.getName()));
        stateChangeMdiIcon
                .withState(STATE_COLLAPSED, collapsed)
                .withState(STATE_EXPANDED, expanded)
                .withState(STATE_LEAF, leaf);
        return stateChangeMdiIcon;
    }
}
