package org.dominokit.domino.ui.config;

import org.dominokit.domino.ui.collapsible.CollapseStrategy;
import org.dominokit.domino.ui.collapsible.TreeHeightCollapseStrategy;
import org.dominokit.domino.ui.tree.TreeItem;

import java.util.function.Supplier;

public interface TreeConfig extends ComponentConfig {

    default Supplier<CollapseStrategy> getTreeDefaultCollapseStrategy(TreeItem<?> treeItem){
        return ()-> new TreeHeightCollapseStrategy(treeItem);
    }
}
