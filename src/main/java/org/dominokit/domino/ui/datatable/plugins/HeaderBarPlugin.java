package org.dominokit.domino.ui.datatable.plugins;

import elemental2.dom.*;
import org.dominokit.domino.ui.button.Button;
import org.dominokit.domino.ui.datatable.DataTable;
import org.dominokit.domino.ui.datatable.events.SearchEvent;
import org.dominokit.domino.ui.forms.Select;
import org.dominokit.domino.ui.forms.SelectOption;
import org.dominokit.domino.ui.forms.TextBox;
import org.dominokit.domino.ui.grid.Column;
import org.dominokit.domino.ui.grid.Row;
import org.dominokit.domino.ui.icons.Icons;
import org.dominokit.domino.ui.popover.Tooltip;
import org.dominokit.domino.ui.style.Style;
import org.dominokit.domino.ui.style.Styles;

import java.util.ArrayList;
import java.util.List;

import static java.util.Objects.nonNull;
import static org.jboss.gwt.elemento.core.Elements.*;

public class HeaderBarPlugin<T> implements DataTablePlugin<T> {

    private Column titleColumn = Column.span6();
    private Column actionsBarColumn = Column.span6();

    private HTMLHeadingElement title = Style.of(h(2)).setMarginBottom("0px").asElement();
    private HTMLUListElement actionsBar = Style.of(ul().style("list-style: none;")).setMarginBottom("0px").asElement();
    private HTMLDivElement element = div()
            .add(Row.create()
                    .appendChild(titleColumn.appendChild(title))
                    .appendChild(actionsBarColumn.appendChild(actionsBar))
                    .asElement())
            .css("header")
            .style("padding-bottom: 5px;")
            .asElement();

    private final List<HeaderActionElement<T>> actionElements = new ArrayList<>();

    public HeaderBarPlugin(String title) {
        this(title, "");
    }

    public HeaderBarPlugin(String title, String description) {
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

    public HeaderBarPlugin<T> addActionElement(HeaderActionElement<T> headerActionElement) {
        actionElements.add(headerActionElement);
        return this;
    }

    public static class CondenseTableAction<T> implements HeaderActionElement<T> {
        @Override
        public Node asElement(DataTable<T> dataTable) {
            Button condenseButton = Button.create(Icons.ALL.line_weight())
                    .linkify()
                    .style()
                    .setProperty("padding", "0px")
                    .setHeight("26px")
                    .setColor("black", true)
                    .add(Styles.pull_right, Styles.m_r_15)
                    .get();

            Tooltip tooltip = Tooltip.create(condenseButton, new Text("Condense"));

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

    public static class StripesTableAction<T> implements HeaderActionElement<T> {
        @Override
        public Node asElement(DataTable<T> dataTable) {
            Button strippedButton = Button.create(Icons.ALL.power_input())
                    .linkify()
                    .style()
                    .setProperty("padding", "0px")
                    .setHeight("26px")
                    .setColor("black", true)
                    .add(Styles.pull_right, Styles.m_r_15)
                    .get();
            Tooltip tooltip = Tooltip.create(strippedButton.asElement(), new Text("No Stripes"));
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

    public static class BordersTableAction<T> implements HeaderActionElement<T> {
        @Override
        public Node asElement(DataTable<T> dataTable) {
            Button borderedButton = Button.create(Icons.ALL.border_vertical())
                    .linkify()
                    .style()
                    .setProperty("padding", "0px")
                    .setHeight("26px")
                    .setColor("black", true)
                    .add(Styles.pull_right, Styles.m_r_15)
                    .get();
            Tooltip tooltip = Tooltip.create(borderedButton.asElement(), new Text("Bordered"));

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

    public static class HoverTableAction<T> implements HeaderActionElement<T> {
        @Override
        public Node asElement(DataTable<T> dataTable) {
            Button hoverButton = Button.create(Icons.ALL.blur_off())
                    .linkify()
                    .style()
                    .setProperty("padding", "0px")
                    .setHeight("26px")
                    .setColor("black", true)
                    .add(Styles.pull_right, Styles.m_r_15)
                    .get();
            Tooltip tooltip = Tooltip.create(hoverButton.asElement(), new Text("No Hover"));
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

    public static class SearchTableAction<T> implements HeaderActionElement<T> {

        private HTMLDivElement element = div().css("search-new").asElement();
        private DataTable<T> dataTable;
        private final Select<String> select;

        public SearchTableAction() {

            select = Select.<String>create()
                    .style()
                    .setMarginBottom("0px")
                    .setMaxWidth("300px")
                    .add(Styles.pull_right)
                    .get();

            TextBox textBox = TextBox.create()
                    .setPlaceholder("Search")
                    .setLeftAddon(Icons.ALL.search().asElement())
                    .style()
                    .setMarginBottom("0px")
                    .setMaxWidth("300px")
                    .add(Styles.pull_right)
                    .get();

            select.getSelectElement().style().setHeight("38px");

            element.appendChild(textBox.asElement());
            element.appendChild(select.asElement());

            textBox.getInputElement().addEventListener("input", evt -> {
                dataTable.fireTableEvent(new SearchEvent(textBox.getValue(), select.getValue()));
            });
        }

        public SearchTableAction<T> addSearchField(SelectOption<String> selectOption) {
            return addSearchField(selectOption, false);
        }

        public SearchTableAction<T> addSearchField(SelectOption<String> selectOption, boolean defaultSelection) {
            if (nonNull(selectOption)) {
                select.addOption(selectOption);
                if (defaultSelection) {
                    select.select(selectOption);
                }
            }
            return this;
        }

        @Override
        public Node asElement(DataTable<T> dataTable) {
            this.dataTable = dataTable;
            return element;
        }
    }
}
