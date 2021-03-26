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
package org.dominokit.domino.ui.grid;

import java.util.function.Consumer;

/**
 * A derivative component of {@link Row} which supports has 12 columns
 *
 * @see Row
 */
public class Row_12 extends Row<Row_12> {

  public Row_12() {
    super(Columns._12);
    init(this);
  }

  /**
   * Creates column which has a size of 1 column of the 12 columns defined
   *
   * @param consumer a {@link Consumer} that provides the created column
   * @return same instance
   */
  public Row_12 span1(Consumer<Column> consumer) {
    consumer.accept(addAutoSpanColumn(1));
    return this;
  }

  /**
   * Creates column which has a size of 2 columns of the 12 columns defined
   *
   * @param consumer a {@link Consumer} that provides the created column
   * @return same instance
   */
  public Row_12 span2(Consumer<Column> consumer) {
    consumer.accept(addAutoSpanColumn(2));
    return this;
  }

  /**
   * Creates column which has a size of 3 columns of the 12 columns defined
   *
   * @param consumer a {@link Consumer} that provides the created column
   * @return same instance
   */
  public Row_12 span3(Consumer<Column> consumer) {
    consumer.accept(addAutoSpanColumn(3));
    return this;
  }

  /**
   * Creates column which has a size of 4 columns of the 12 columns defined
   *
   * @param consumer a {@link Consumer} that provides the created column
   * @return same instance
   */
  public Row_12 span4(Consumer<Column> consumer) {
    consumer.accept(addAutoSpanColumn(4));
    return this;
  }

  /**
   * Creates column which has a size of 5 columns of the 12 columns defined
   *
   * @param consumer a {@link Consumer} that provides the created column
   * @return same instance
   */
  public Row_12 span5(Consumer<Column> consumer) {
    consumer.accept(addAutoSpanColumn(5));
    return this;
  }

  /**
   * Creates column which has a size of 6 columns of the 12 columns defined
   *
   * @param consumer a {@link Consumer} that provides the created column
   * @return same instance
   */
  public Row_12 span6(Consumer<Column> consumer) {
    consumer.accept(addAutoSpanColumn(6));
    return this;
  }

  /**
   * Creates column which has a size of 7 columns of the 12 columns defined
   *
   * @param consumer a {@link Consumer} that provides the created column
   * @return same instance
   */
  public Row_12 span7(Consumer<Column> consumer) {
    consumer.accept(addAutoSpanColumn(7));
    return this;
  }

  /**
   * Creates column which has a size of 8 columns of the 12 columns defined
   *
   * @param consumer a {@link Consumer} that provides the created column
   * @return same instance
   */
  public Row_12 span8(Consumer<Column> consumer) {
    consumer.accept(addAutoSpanColumn(8));
    return this;
  }

  /**
   * Creates column which has a size of 9 columns of the 12 columns defined
   *
   * @param consumer a {@link Consumer} that provides the created column
   * @return same instance
   */
  public Row_12 span9(Consumer<Column> consumer) {
    consumer.accept(addAutoSpanColumn(9));
    return this;
  }

  /**
   * Creates column which has a size of 10 columns of the 12 columns defined
   *
   * @param consumer a {@link Consumer} that provides the created column
   * @return same instance
   */
  public Row_12 span10(Consumer<Column> consumer) {
    consumer.accept(addAutoSpanColumn(10));
    return this;
  }

  /**
   * Creates column which has a size of 11 columns of the 12 columns defined
   *
   * @param consumer a {@link Consumer} that provides the created column
   * @return same instance
   */
  public Row_12 span11(Consumer<Column> consumer) {
    consumer.accept(addAutoSpanColumn(11));
    return this;
  }

  /**
   * Creates column which has a size of 12 columns of the 12 columns defined
   *
   * @param consumer a {@link Consumer} that provides the created column
   * @return same instance
   */
  public Row_12 span12(Consumer<Column> consumer) {
    consumer.accept(addAutoSpanColumn(12));
    return this;
  }
}
