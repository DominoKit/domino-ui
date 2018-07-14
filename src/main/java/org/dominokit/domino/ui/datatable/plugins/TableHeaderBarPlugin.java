package org.dominokit.domino.ui.datatable.plugins;

import elemental2.dom.*;
import org.dominokit.domino.ui.button.IconButton;
import org.dominokit.domino.ui.column.Column;
import org.dominokit.domino.ui.datatable.DataTable;
import org.dominokit.domino.ui.datatable.events.SearchEvent;
import org.dominokit.domino.ui.forms.TextBox;
import org.dominokit.domino.ui.icons.Icons;
import org.dominokit.domino.ui.popover.Tooltip;
import org.dominokit.domino.ui.row.Row;
import org.dominokit.domino.ui.style.Style;
import org.dominokit.domino.ui.style.Styles;

import java.util.ArrayList;
import java.util.List;

import static java.util.Objects.nonNull;
import static org.jboss.gwt.elemento.core.Elements.*;

public class TableHeaderBarPlugin<T> implements DataTablePlugin<T> {

    private Column column = Column.create()
            .onLarge(Column.OnLarge.six)
            .onMedium(Column.OnMedium.six)
            .onSmall(Column.OnSmall.twelve)
            .onXSmall(Column.OnXSmall.twelve);

    private Column titleColumn = column.copy();
    private Column actionsBarColumn = column.copy();

    private HTMLHeadingElement title = Style.of(h(2)).setMarginBottom("0px").asElement();
    private HTMLUListElement actionsBar = Style.of(ul().style("list-style: none;")).setMarginBottom("0px").asElement();
    private HTMLDivElement element = div()
            .add(Row.create()
                    .addColumn(titleColumn.addElement(title))
                    .addColumn(actionsBarColumn.addElement(actionsBar))
                    .asElement())
            .css("header")
            .style("padding-bottom: 5px;")
            .asElement();

    private final List<TableHeaderActionElement<T>> actionElements = new ArrayList<>();

    public TableHeaderBarPlugin(String title) {
        this(title, "");
    }

    public TableHeaderBarPlugin(String title, String description) {
        this.title.appendChild(new Text(title));
        if (nonNull(description) && !description.isEmpty()) {
            this.title.appendChild(small().textContent(description).asElement());
        }

        Style.of(titleColumn).setMarginBottom("0px");
        Style.of(actionsBarColumn).setMarginBottom("0px");
    }

    @Override
    public void onBeforeAddTable(DataTable<T> dataTable) {
        actionElements.forEach(actionElement -> actionsBar.appendChild(li().add(actionElement.asElement(dataTable)).asElement()));
        dataTable.asElement().appendChild(element);
    }

    public TableHeaderBarPlugin<T> addActionElement(TableHeaderActionElement<T> tableHeaderActionElement) {
        actionElements.add(tableHeaderActionElement);
        return this;
    }

    public static class CondenseTableAction<T> implements TableHeaderActionElement<T> {
        @Override
        public Node asElement(DataTable<T> dataTable) {
            IconButton condenseButton = IconButton.create(Icons.ALL.line_weight())
                    .linkify();

            Tooltip tooltip = Tooltip.create(condenseButton.asElement(), new Text("Condense"));
            Style.of(condenseButton)
                    .setProperty("padding", "0px")
                    .setHeight("26px")
                    .setColor("black", true)
                    .css(Styles.pull_right, Styles.m_r_15);
            condenseButton.addClickListener(evt -> {
                if (dataTable.isCondensed()) {
                    dataTable.expand();
                    condenseButton.setIcon(Icons.ALL.line_weight());
                    tooltip.setContent(new Text("Condense"));
                } else {
                    dataTable.condense();
                    condenseButton.setIcon(Icons.ALL.format_line_spacing());
                    tooltip.setContent(new Text("Expand"));
                }
            });

            return condenseButton.asElement();
        }
    }

    public static class StripesTableAction<T> implements TableHeaderActionElement<T> {
        @Override
        public Node asElement(DataTable<T> dataTable) {
            IconButton strippedButton = IconButton.create(Icons.ALL.power_input())
                    .linkify();
            Tooltip tooltip = Tooltip.create(strippedButton.asElement(), new Text("No Stripes"));
            Style.of(strippedButton)
                    .setProperty("padding", "0px")
                    .setHeight("26px")
                    .setColor("black", true)
                    .css(Styles.pull_right, Styles.m_r_15);
            strippedButton.addClickListener(evt -> {
                if (dataTable.isStriped()) {
                    dataTable.noStripes();
                    strippedButton.setIcon(Icons.ALL.drag_handle());
                    tooltip.setContent(new Text("Stripped"));
                } else {
                    dataTable.striped();
                    strippedButton.setIcon(Icons.ALL.power_input());
                    tooltip.setContent(new Text("No Stripes"));
                }
            });

            return strippedButton.asElement();
        }
    }

    public static class BordersTableAction<T> implements TableHeaderActionElement<T> {
        @Override
        public Node asElement(DataTable<T> dataTable) {
            IconButton borderedButton = IconButton.create(Icons.ALL.border_vertical())
                    .linkify();
            Tooltip tooltip = Tooltip.create(borderedButton.asElement(), new Text("Bordered"));
            Style.of(borderedButton)
                    .setProperty("padding", "0px")
                    .setHeight("26px")
                    .setColor("black", true)
                    .css(Styles.pull_right, Styles.m_r_15);
            borderedButton.addClickListener(evt -> {
                if (dataTable.isBordered()) {
                    dataTable.noBorder();
                    borderedButton.setIcon(Icons.ALL.border_vertical());
                    tooltip.setContent(new Text("Bordered"));
                } else {
                    dataTable.bordered();
                    borderedButton.setIcon(Icons.ALL.border_clear());
                    tooltip.setContent(new Text("No Borders"));
                }
            });

            return borderedButton.asElement();
        }
    }

    public static class HoverTableAction<T> implements TableHeaderActionElement<T> {
        @Override
        public Node asElement(DataTable<T> dataTable) {
            IconButton hoverButton = IconButton.create(Icons.ALL.blur_off())
                    .linkify();
            Tooltip tooltip = Tooltip.create(hoverButton.asElement(), new Text("No Hover"));
            Style.of(hoverButton)
                    .setProperty("padding", "0px")
                    .setHeight("26px")
                    .setColor("black", true)
                    .css(Styles.pull_right, Styles.m_r_15);
            hoverButton.addClickListener(evt -> {
                if (dataTable.isHoverable()) {
                    dataTable.noHover();
                    hoverButton.setIcon(Icons.ALL.blur_on());
                    tooltip.setContent(new Text("Hover"));
                } else {
                    dataTable.hovered();
                    hoverButton.setIcon(Icons.ALL.blur_off());
                    tooltip.setContent(new Text("No Hover"));
                }
            });

            return hoverButton.asElement();
        }
    }

    public static class SearchTableAction<T> implements TableHeaderActionElement<T> {

        @Override
        public Node asElement(DataTable<T> dataTable) {
            TextBox textBox = TextBox.create()
                    .setPlaceholder("Search")
                    .setLeftAddon(Icons.ALL.search().asElement());
            Style.of(textBox)
                    .setMarginBottom("0px")
                    .setMaxWidth("300px")
                    .css(Styles.pull_right);

            textBox.getInputElement().addEventListener("input", evt -> {
                dataTable.fireTableEvent(new SearchEvent(textBox.getValue()));

            });

            return textBox.asElement();
        }
    }


}
