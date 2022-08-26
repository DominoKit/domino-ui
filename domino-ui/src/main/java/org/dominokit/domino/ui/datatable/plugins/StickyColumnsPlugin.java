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

import elemental2.dom.HTMLElement;
import org.dominokit.domino.ui.datatable.ColumnConfig;
import org.dominokit.domino.ui.datatable.DataTable;
import org.dominokit.domino.ui.datatable.TableRow;
import org.dominokit.domino.ui.datatable.events.StickyColumnsEvent;
import org.dominokit.domino.ui.datatable.events.TableEvent;
import org.dominokit.domino.ui.menu.Menu;
import org.dominokit.domino.ui.menu.MenuItem;
import org.dominokit.domino.ui.menu.direction.TopMiddleDropDirection;
import org.dominokit.domino.ui.utils.DominoElement;

import java.util.*;
import java.util.function.BiConsumer;
import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import static java.util.Objects.nonNull;
import static org.dominokit.domino.ui.datatable.events.ColumnResizedEvent.COLUMN_RESIZED;
import static org.dominokit.domino.ui.datatable.events.TableDataUpdatedEvent.DATA_UPDATED;
import static org.dominokit.domino.ui.datatable.plugins.StickyColumnsPlugin.Direction.LEFT;
import static org.dominokit.domino.ui.datatable.plugins.StickyColumnsPlugin.Direction.RIGHT;

/**
 * this plugin allows marking columns as sticky ones
 *
 * @param <T> the type of data table records
 */
public class StickyColumnsPlugin<T> implements DataTablePlugin<T> {

  private static final String STICKY_COL = "sticky-col";
  private static final String PX = "px";
  private static final String UNSET = "unset";
  private final Map<ColumnConfig<T>, ColumnMenu> columnMenus = new HashMap<>();
  private String leftPinText = "Pin left";
  private String rightPinText = "Pin right";
  private String noPinText = "No pin";
  private ColumnMenu currentSticked;
  private Direction currentDirection;

  /** {@inheritDoc} */
  @Override
  public void init(DataTable<T> dataTable) {
    dataTable.bodyElement().setOverFlow(UNSET, true);
  }

  @Override
  public void onHeaderAdded(DataTable<T> dataTable, ColumnConfig<T> column) {
    columnMenus.put(column, new ColumnMenu(dataTable, column));
  }

  /** @param leftPinText the text for left pin text */
  public void setLeftPinText(String leftPinText) {
    this.leftPinText = leftPinText;
  }

  /** @param rightPinText the text for right pin text */
  public void setRightPinText(String rightPinText) {
    this.rightPinText = rightPinText;
  }

  /** @param noPinText the text for no pin text */
  public void setNoPinText(String noPinText) {
    this.noPinText = noPinText;
  }

  @Override
  public void handleEvent(TableEvent event) {
    if (DATA_UPDATED.equals(event.getType())) {
      for (ColumnMenu columnMenu : columnMenus.values()) {
        columnMenu.unstickColumn();
      }
    }
    if(COLUMN_RESIZED.equals(event.getType()) && nonNull(currentSticked)){
      currentSticked.stickColumn(currentDirection);
    }
  }

  /**
   * This enum identify the direction of marking columns as sticky.
   *
   * <p>{@link Direction#LEFT} starts marking columns from left to right. {@link Direction#RIGHT}
   * starts marking columns from right to left.
   */
  public enum Direction {
    LEFT((intStream, size) -> intStream, (element, distance) -> element.setLeft(distance)),
    RIGHT(
        (intStream, size) -> intStream.map(i -> size - i - 1),
        (element, distance) -> element.setRight(distance));

    private final OrderFunction orderFunction;
    private final DistanceFunction distanceHandler;

    Direction(OrderFunction orderFunction, DistanceFunction distanceHandler) {
      this.orderFunction = orderFunction;
      this.distanceHandler = distanceHandler;
    }

    private <T> void forEach(List<T> list, Predicate<T> stopPredicate, Consumer<T> valueConsumer) {
      Stream<T> stream =
          orderFunction.apply(IntStream.range(0, list.size()), list.size()).mapToObj(list::get);
      forEach(
          stream,
          (value, breaker) -> {
            valueConsumer.accept(value);
            if (stopPredicate.test(value)) {
              breaker.stop();
            }
          });
    }

    private void stick(HTMLElement element, String distance) {
      DominoElement<HTMLElement> dominoElement = DominoElement.of(element);
      dominoElement.addCss(STICKY_COL);
      distanceHandler.apply(dominoElement, distance);
    }

    public void unstick(HTMLElement element) {
      DominoElement<HTMLElement> dominoElement = DominoElement.of(element);
      dominoElement.removeCss(STICKY_COL);
      distanceHandler.apply(dominoElement, UNSET);
    }

    private static class Breaker {
      private boolean shouldBreak = false;
      public void stop() {
        shouldBreak = true;
      }
      boolean get() {
        return shouldBreak;
      }
    }

    private <T> void forEach(Stream<T> stream, BiConsumer<T, Breaker> consumer) {
      Spliterator<T> spliterator = stream.spliterator();
      boolean hadNext = true;
      Breaker breaker = new Breaker();

      while (hadNext && !breaker.get()) {
        hadNext = spliterator.tryAdvance(elem -> consumer.accept(elem, breaker));
      }
    }

    @FunctionalInterface
    private interface OrderFunction {
      IntStream apply(IntStream intStream, int size);
    }

    @FunctionalInterface
    private interface DistanceFunction {
      void apply(DominoElement<? extends HTMLElement> element, String distance);
    }
  }

  private class ColumnMenu {

    private final DataTable<T> dataTable;
    private final ColumnConfig<T> column;

    private ColumnMenu(DataTable<T> dataTable, ColumnConfig<T> column) {
      this.dataTable = dataTable;
      this.column = column;
      column
          .getHeaderLayout()
          .setDropMenu(
              Menu.create()
                  .setContextMenu(true)
                  .setDropDirection(new TopMiddleDropDirection())
                  .appendChild(
                      MenuItem.create(leftPinText).addClickListener(evt -> stickColumn(LEFT)))
                  .appendChild(
                      MenuItem.create(rightPinText).addClickListener(evt -> stickColumn(RIGHT)))
                  .appendChild(
                      MenuItem.create(noPinText).addClickListener(evt -> unstickColumn())));
    }

    private void stickColumn(Direction direction) {
      unstickColumn();
      final double[] summedLeft = {0};
      List<ColumnConfig<T>> columns = dataTable.getTableConfig().getColumns();
      Map<String, ColumnConfig<T>> effectedColumns = new LinkedHashMap<>();
      direction.forEach(
          columns,
          c -> c.getName().equals(column.getName()),
          column -> {
            effectedColumns.put(column.getName(), column);
            direction.stick(column.getHeadElement().element(), summedLeft[0] + PX);
            summedLeft[0] += columnWidth(column);
          });
      dataTable.fireTableEvent(new StickyColumnsEvent<>(new ArrayList<>(effectedColumns.values())));
      for (TableRow<T> row : dataTable.getRows()) {
        final double[] summedLeftCell = {0};
        direction.forEach(new ArrayList<>(row.getRowCells().values()),
            rowCell -> rowCell.getColumnConfig().getName().equals(column.getName()),
            cell -> {
              direction.stick(cell.getCellInfo().getElement(), summedLeftCell[0] + PX);
              summedLeftCell[0] += columnWidth(cell.getColumnConfig());
            });
      }
      currentSticked = this;
      currentDirection = direction;
    }

    private double columnWidth(ColumnConfig<T> column){
      return column.getHeadElement().getBoundingClientRect().width;
    }

    private void unstickColumn() {
      if(currentDirection != null) {
        List<ColumnConfig<T>> columns = dataTable.getTableConfig().getColumns();
        currentDirection.forEach(columns, c -> false, column -> currentDirection.unstick(column.getHeadElement().element()));
        for (TableRow<T> row : dataTable.getRows()) {
          currentDirection.forEach(new ArrayList<>(row.getRowCells().values()), rowCell -> false, cell -> currentDirection.unstick(cell
                  .getCellInfo()
                  .getElement()));
        }
        currentSticked = null;
      }
    }
  }
}
