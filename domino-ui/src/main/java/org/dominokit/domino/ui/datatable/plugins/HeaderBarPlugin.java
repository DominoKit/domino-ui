/*
 * Copyright © 2019 Dominokit
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.dominokit.domino.ui.datatable.plugins;

import static java.util.Objects.nonNull;
import static org.jboss.elemento.Elements.*;

import elemental2.dom.*;
import java.util.ArrayList;
import java.util.List;
import jsinterop.base.Js;
import org.dominokit.domino.ui.datatable.ColumnConfig;
import org.dominokit.domino.ui.datatable.DataTable;
import org.dominokit.domino.ui.datatable.DataTableStyles;
import org.dominokit.domino.ui.datatable.DefaultColumnShowHideListener;
import org.dominokit.domino.ui.datatable.events.SearchClearedEvent;
import org.dominokit.domino.ui.datatable.events.TableEvent;
import org.dominokit.domino.ui.datatable.model.Category;
import org.dominokit.domino.ui.datatable.model.Filter;
import org.dominokit.domino.ui.datatable.model.SearchContext;
import org.dominokit.domino.ui.dropdown.DropDownMenu;
import org.dominokit.domino.ui.dropdown.DropDownPosition;
import org.dominokit.domino.ui.dropdown.DropdownAction;
import org.dominokit.domino.ui.forms.TextBox;
import org.dominokit.domino.ui.grid.Column;
import org.dominokit.domino.ui.grid.Row;
import org.dominokit.domino.ui.grid.flex.FlexItem;
import org.dominokit.domino.ui.grid.flex.FlexJustifyContent;
import org.dominokit.domino.ui.grid.flex.FlexLayout;
import org.dominokit.domino.ui.icons.Icon;
import org.dominokit.domino.ui.icons.Icons;
import org.dominokit.domino.ui.icons.MdiIcon;
import org.dominokit.domino.ui.style.Style;
import org.dominokit.domino.ui.style.Styles;
import org.dominokit.domino.ui.style.Unit;
import org.dominokit.domino.ui.utils.DominoElement;
import org.dominokit.domino.ui.utils.ElementUtil;
import org.dominokit.domino.ui.utils.TextNode;
import org.gwtproject.timer.client.Timer;
import org.jboss.elemento.EventType;

/**
 * This plugin attach an action bar to the table and adds {@link HeaderActionElement}(s) to it
 *
 * @param <T> the type of the data table records
 */
public class HeaderBarPlugin<T> implements DataTablePlugin<T> {

  private Column titleColumn = Column.span6();
  private Column actionsBarColumn = Column.span6();

  private HTMLHeadingElement title = Style.of(h(2)).setMarginBottom("0px").element();
  private FlexLayout actionsBar = FlexLayout.create().setJustifyContent(FlexJustifyContent.END);

  private HTMLDivElement element =
      DominoElement.of(div())
          .add(
              Row.create()
                  .appendChild(titleColumn.appendChild(title))
                  .appendChild(actionsBarColumn.appendChild(actionsBar))
                  .element())
          .css(DataTableStyles.HEADER)
          .style("padding-bottom: 5px;")
          .element();

  private final List<HeaderActionElement<T>> actionElements = new ArrayList<>();

  /**
   * creates an instance with a custom title
   *
   * @param title String title of the header bar
   */
  public HeaderBarPlugin(String title) {
    this(title, "");
  }

  /**
   * creates an instance with a custom and description
   *
   * @param title String title of the header bar
   * @param description String description of the header bar
   */
  public HeaderBarPlugin(String title, String description) {
    this.title.appendChild(DomGlobal.document.createTextNode(title));
    if (nonNull(description) && !description.isEmpty()) {
      this.title.appendChild(small().textContent(description).element());
    }

    Style.of(titleColumn).setMarginBottom("0px");
    Style.of(actionsBarColumn).setMarginBottom("0px");
  }

  /** {@inheritDoc} */
  @Override
  public void onBeforeAddTable(DataTable<T> dataTable) {
    actionElements.forEach(
        actionElement ->
            actionsBar.appendChild(
                FlexItem.create()
                    .addCss(Styles.m_r_5)
                    .addCss(Styles.m_l_5)
                    .appendChild(actionElement.asElement(dataTable))
                    .element()));
    dataTable.element().appendChild(element);
  }

  /**
   * Adds a new header action to this header bar
   *
   * @param headerActionElement the {@link HeaderActionElement}
   * @return same plugin instance
   */
  public HeaderBarPlugin<T> addActionElement(HeaderActionElement<T> headerActionElement) {
    actionElements.add(headerActionElement);
    return this;
  }

  /**
   * a Predefined {@link HeaderActionElement} that condense/expand the data table rows
   *
   * @param <T> the type of the data table records
   */
  public static class CondenseTableAction<T> implements HeaderActionElement<T> {
    private String condenseToolTip = "Condense";
    private String expandToolTip = "Expand";

    /** {@inheritDoc} */
    @Override
    public Node asElement(DataTable<T> dataTable) {
      Icon condenseIcon =
          Icons.ALL
              .line_weight()
              .clickable()
              .setTooltip(condenseToolTip)
              .setToggleIcon(Icons.ALL.format_line_spacing())
              .toggleOnClick(true)
              .apply(
                  icon ->
                      icon.addClickListener(
                          evt -> {
                            if (dataTable.isCondensed()) {
                              dataTable.show();
                              icon.setTooltip(condenseToolTip);
                            } else {
                              dataTable.condense();
                              icon.setTooltip(expandToolTip);
                            }
                          }));

      return a().add(condenseIcon).element();
    }

    /**
     * Changes the condense icon tooltip
     *
     * @param condenseToolTip String
     * @return same acton instance
     */
    public CondenseTableAction<T> setCondenseToolTip(String condenseToolTip) {
      this.condenseToolTip = condenseToolTip;
      return this;
    }

    /**
     * Changes the expand icon tooltip
     *
     * @param expandToolTip String
     * @return same acton instance
     */
    public CondenseTableAction<T> setExpandToolTip(String expandToolTip) {
      this.expandToolTip = expandToolTip;
      return this;
    }
  }

  /**
   * A predefined action to toggle stripes on data table rows
   *
   * @param <T> the type of the data table records
   */
  public static class StripesTableAction<T> implements HeaderActionElement<T> {

    private String noStripsToolTip = "No stripes";
    private String stripsToolTip = "Stripes";

    /** {@inheritDoc} */
    @Override
    public Node asElement(DataTable<T> dataTable) {
      Icon stripesIcon =
          Icons.ALL
              .format_line_spacing()
              .clickable()
              .setToggleIcon(Icons.ALL.power_input())
              .setTooltip(noStripsToolTip)
              .toggleOnClick(true)
              .apply(
                  icon ->
                      icon.addClickListener(
                          evt -> {
                            if (dataTable.isStriped()) {
                              dataTable.noStripes();
                              icon.setTooltip(stripsToolTip);
                            } else {
                              dataTable.striped();
                              icon.setTooltip(noStripsToolTip);
                            }
                          }));

      return a().add(stripesIcon).element();
    }

    /**
     * Changes the no strips icon tooltip
     *
     * @param noStripsToolTip String
     * @return same acton instance
     */
    public StripesTableAction<T> setNoStripsToolTip(String noStripsToolTip) {
      this.noStripsToolTip = noStripsToolTip;
      return this;
    }

    /**
     * Changes the strips icon tooltip
     *
     * @param stripsToolTip String
     * @return same acton instance
     */
    public StripesTableAction<T> setStripsToolTip(String stripsToolTip) {
      this.stripsToolTip = stripsToolTip;
      return this;
    }
  }

  /**
   * A predefined action to toggle borders on data table rows
   *
   * @param <T> the type of the data table records
   */
  public static class BordersTableAction<T> implements HeaderActionElement<T> {

    private String borderedToolTip = "Bordered";
    private String noBprdersToolTip = "No borders";

    /** {@inheritDoc} */
    @Override
    public Node asElement(DataTable<T> dataTable) {

      Icon bordersIcon =
          Icons.ALL
              .border_vertical()
              .clickable()
              .setToggleIcon(Icons.ALL.border_clear())
              .toggleOnClick(true)
              .setTooltip(borderedToolTip)
              .apply(
                  icon ->
                      icon.addClickListener(
                          evt -> {
                            if (dataTable.isBordered()) {
                              dataTable.noBorder();
                              icon.setTooltip(borderedToolTip);
                            } else {
                              dataTable.bordered();
                              icon.setTooltip(noBprdersToolTip);
                            }
                          }));

      return a().add(bordersIcon).element();
    }

    /**
     * Changes the borders icon tooltip
     *
     * @param borderedToolTip String
     * @return same acton instance
     */
    public BordersTableAction<T> setBorderedToolTip(String borderedToolTip) {
      this.borderedToolTip = borderedToolTip;
      return this;
    }

    /**
     * Changes the no borders icon tooltip
     *
     * @param noBordersToolTip String
     * @return same acton instance
     */
    public BordersTableAction<T> setNoBordersToolTip(String noBordersToolTip) {
      this.noBprdersToolTip = noBordersToolTip;
      return this;
    }
  }

  /**
   * A predefined action to toggle hover on data table rows
   *
   * @param <T> the type of the data table records
   */
  public static class HoverTableAction<T> implements HeaderActionElement<T> {

    private String hoverToolTip = "Hover";
    private String noHoverToolTip = "No Hover";

    /** {@inheritDoc} */
    @Override
    public Node asElement(DataTable<T> dataTable) {

      Icon hoverIcon =
          Icons.ALL
              .blur_off()
              .clickable()
              .setToggleIcon(Icons.ALL.blur_on())
              .toggleOnClick(true)
              .setTooltip(noHoverToolTip)
              .apply(
                  icon ->
                      icon.addClickListener(
                          evt -> {
                            if (dataTable.isHoverable()) {
                              dataTable.noHover();
                              icon.setTooltip(hoverToolTip);
                            } else {
                              dataTable.hovered();
                              icon.setTooltip(noHoverToolTip);
                            }
                          }));

      return a().add(hoverIcon).element();
    }

    /**
     * Changes the hover icon tooltip
     *
     * @param hoverToolTip String
     * @return same acton instance
     */
    public HoverTableAction<T> setHoverToolTip(String hoverToolTip) {
      this.hoverToolTip = hoverToolTip;
      return this;
    }

    /**
     * Changes the no hover icon tooltip
     *
     * @param noHoverToolTip String
     * @return same acton instance
     */
    public HoverTableAction<T> setNoHoverToolTip(String noHoverToolTip) {
      this.noHoverToolTip = noHoverToolTip;
      return this;
    }
  }

  /**
   * A predefined action to clear data table search
   *
   * @param <T> the type of the data table records
   */
  public static class ClearSearch<T> implements HeaderActionElement<T> {

    private String clearFiltersToolTip = "Clear filters";

    /** {@inheritDoc} */
    @Override
    public Node asElement(DataTable<T> dataTable) {

      MdiIcon clearFiltersIcon =
          Icons.MDI_ICONS
              .filter_remove_mdi()
              .setTooltip(clearFiltersToolTip)
              .size18()
              .clickable()
              .addClickListener(evt -> dataTable.getSearchContext().clear().fireSearchEvent());

      return a().add(clearFiltersIcon).element();
    }

    /**
     * Changes the clear filters icon tooltip
     *
     * @param clearFiltersToolTip String
     * @return same acton instance
     */
    public ClearSearch<T> setClearFiltersToolTip(String clearFiltersToolTip) {
      this.clearFiltersToolTip = clearFiltersToolTip;
      return this;
    }
  }

  /**
   * A predefined action to add a search box the data table
   *
   * @param <T> the type of the data table records
   */
  public static class SearchTableAction<T> implements HeaderActionElement<T> {

    private String searchToolTip = "Search";
    private String clearSearchToolTip = "Clear search";

    private int autoSearchDelay = 200;
    private HTMLDivElement element = DominoElement.of(div()).css("search-new").element();
    private DataTable<T> dataTable;
    private final TextBox textBox;
    private boolean autoSearch = true;
    private Timer autoSearchTimer;
    private EventListener autoSearchEventListener;
    private final Icon searchIcon;
    private final Icon clearIcon;

    /** creates a new instance */
    public SearchTableAction() {

      searchIcon =
          Icons.ALL
              .search()
              .addClickListener(
                  evt -> {
                    autoSearchTimer.cancel();
                    search();
                  })
              .setTooltip(searchToolTip)
              .style()
              .setCursor("pointer")
              .get();

      clearIcon =
          Icons.ALL.clear().setTooltip(clearSearchToolTip).style().setCursor("pointer").get();

      textBox =
          TextBox.create()
              .setPlaceholder(searchToolTip)
              .addLeftAddOn(searchIcon)
              .addRightAddOn(clearIcon)
              .addCss("table-search-box")
              .setMarginBottom("0px")
              .setMaxWidth("300px")
              .addCss(Styles.pull_right);

      clearIcon.addClickListener(evt -> clear());

      element.appendChild(textBox.element());

      autoSearchTimer =
          new Timer() {
            @Override
            public void run() {
              search();
            }
          };

      autoSearchEventListener =
          evt -> {
            autoSearchTimer.cancel();
            autoSearchTimer.schedule(autoSearchDelay);
          };

      setAutoSearch(true);
    }

    /** @return boolean, true if the auto search is enabled */
    public boolean isAutoSearch() {
      return autoSearch;
    }

    /**
     * Enable/Disable auto search when enabled the search will triggered while the user is typing
     * with a delay otherwise the search will only be triggered when the user click on search or
     * press Enter
     *
     * @param autoSearch boolean
     * @return same action instance
     */
    public SearchTableAction<T> setAutoSearch(boolean autoSearch) {
      this.autoSearch = autoSearch;

      if (autoSearch) {
        textBox.addEventListener("input", autoSearchEventListener);
      } else {
        textBox.removeEventListener("input", autoSearchEventListener);
        autoSearchTimer.cancel();
      }

      textBox.addEventListener(
          EventType.keypress.getName(),
          evt -> {
            if (ElementUtil.isEnterKey(Js.uncheckedCast(evt))) {
              search();
            }
          });

      return this;
    }

    /** @return int search delay in milliseconds */
    public int getAutoSearchDelay() {
      return autoSearchDelay;
    }

    /** @param autoSearchDelayInMillies int auto search delay in milliseconds */
    public void setAutoSearchDelay(int autoSearchDelayInMillies) {
      this.autoSearchDelay = autoSearchDelayInMillies;
    }

    private void search() {
      SearchContext<T> searchContext = dataTable.getSearchContext();
      Category search = Category.SEARCH;
      searchContext.removeByCategory(search);
      searchContext.add(Filter.create("*", textBox.getValue(), Category.SEARCH)).fireSearchEvent();
    }

    /** Clears the search */
    public void clear() {
      textBox.clear();
      autoSearchTimer.cancel();
      search();
      textBox.focus();
    }

    /** {@inheritDoc} */
    @Override
    public void handleEvent(TableEvent event) {
      if (SearchClearedEvent.SEARCH_EVENT_CLEARED.equals(event.getType())) {
        textBox.pauseChangeHandlers();
        textBox.clear();
        textBox.resumeChangeHandlers();
      }
    }

    /** {@inheritDoc} */
    @Override
    public Node asElement(DataTable<T> dataTable) {
      this.dataTable = dataTable;
      dataTable.addTableEventListener(SearchClearedEvent.SEARCH_EVENT_CLEARED, this);
      return element;
    }

    /**
     * Set the search icon tooltip
     *
     * @param searchToolTip String
     * @return same action instance
     */
    public SearchTableAction<T> setSearchToolTip(String searchToolTip) {
      this.searchToolTip = searchToolTip;
      searchIcon.setTooltip(searchToolTip);
      textBox.setPlaceholder(searchToolTip);
      return this;
    }

    /**
     * Set the clear search icon tooltip
     *
     * @param clearSearchToolTip String
     * @return same action instance
     */
    public SearchTableAction<T> setClearSearchToolTip(String clearSearchToolTip) {
      this.clearSearchToolTip = clearSearchToolTip;
      clearIcon.setTooltip(clearSearchToolTip);
      return this;
    }

    /** @return the search box */
    public TextBox getTextBox() {
      return textBox;
    }

    /** @return the search icon */
    public Icon getSearchIcon() {
      return searchIcon;
    }

    /** @return the clear icon */
    public Icon getClearIcon() {
      return clearIcon;
    }
  }

  /**
   * A predefined action to add a drop down to the data table that allow selecting which columns be
   * shown/hidden
   *
   * @param <T> the type of the data table records
   */
  public static class ShowHideColumnsAction<T> implements HeaderActionElement<T> {
    /** {@inheritDoc} */
    @Override
    public Node asElement(DataTable<T> dataTable) {
      Icon columnsIcon = Icons.ALL.view_column().clickable();

      DropDownMenu dropDownMenu = DropDownMenu.create(columnsIcon);
      dropDownMenu
          .setPosition(DropDownPosition.BOTTOM_LEFT)
          .apply(
              columnsMenu ->
                  dataTable.getTableConfig().getColumns().stream()
                      .filter(this::notUtility)
                      .forEach(
                          columnConfig -> {
                            Icon checkIcon =
                                Icons.ALL.check().toggleDisplay(!columnConfig.isHidden());
                            columnConfig.addShowHideListener(
                                DefaultColumnShowHideListener.of(checkIcon.element(), true));
                            FlexLayout itemElement =
                                FlexLayout.create()
                                    .appendChild(
                                        FlexItem.create()
                                            .styler(style -> style.setWidth(Unit.px.of(24)))
                                            .appendChild(checkIcon))
                                    .appendChild(
                                        FlexItem.create()
                                            .appendChild(TextNode.of(columnConfig.getTitle())));

                            columnsMenu.appendChild(
                                DropdownAction.create(columnConfig.getName(), itemElement.element())
                                    .setAutoClose(false)
                                    .addSelectionHandler(
                                        value ->
                                            columnConfig.toggleDisplay(columnConfig.isHidden())));
                          }));

      columnsIcon.addClickListener(
          evt -> {
            dropDownMenu.open();
            evt.stopPropagation();
          });
      return columnsIcon.element();
    }

    private boolean notUtility(ColumnConfig<T> column) {
      return !column.isUtilityColumn();
    }

    /** {@inheritDoc} */
    @Override
    public void handleEvent(TableEvent event) {}
  }
}
