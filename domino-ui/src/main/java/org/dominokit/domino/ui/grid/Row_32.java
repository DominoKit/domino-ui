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
 * A derivative component of {@link Row} which supports has 32 columns
 *
 * @see Row
 */
public class Row_32 extends Row<Row_32> {

  public Row_32() {
    super(Columns._32);
    init(this);
  }

  /**
   * Creates column which has a size of 1 column of the 32 columns defined
   *
   * @param consumer a {@link Consumer} that provides the created column
   * @return same instance
   */
  public Row_32 span1(Consumer<Column> consumer) {
    consumer.accept(addAutoSpanColumn(1));
    return this;
  }

  /**
   * Creates column which has a size of 2 columns of the 32 columns defined
   *
   * @param consumer a {@link Consumer} that provides the created column
   * @return same instance
   */
  public Row_32 span2(Consumer<Column> consumer) {
    consumer.accept(addAutoSpanColumn(2));
    return this;
  }

  /**
   * Creates column which has a size of 3 columns of the 32 columns defined
   *
   * @param consumer a {@link Consumer} that provides the created column
   * @return same instance
   */
  public Row_32 span3(Consumer<Column> consumer) {
    consumer.accept(addAutoSpanColumn(3));
    return this;
  }

  /**
   * Creates column which has a size of 4 columns of the 32 columns defined
   *
   * @param consumer a {@link Consumer} that provides the created column
   * @return same instance
   */
  public Row_32 span4(Consumer<Column> consumer) {
    consumer.accept(addAutoSpanColumn(4));
    return this;
  }

  /**
   * Creates column which has a size of 5 columns of the 32 columns defined
   *
   * @param consumer a {@link Consumer} that provides the created column
   * @return same instance
   */
  public Row_32 span5(Consumer<Column> consumer) {
    consumer.accept(addAutoSpanColumn(5));
    return this;
  }

  /**
   * Creates column which has a size of 6 columns of the 32 columns defined
   *
   * @param consumer a {@link Consumer} that provides the created column
   * @return same instance
   */
  public Row_32 span6(Consumer<Column> consumer) {
    consumer.accept(addAutoSpanColumn(6));
    return this;
  }

  /**
   * Creates column which has a size of 7 columns of the 32 columns defined
   *
   * @param consumer a {@link Consumer} that provides the created column
   * @return same instance
   */
  public Row_32 span7(Consumer<Column> consumer) {
    consumer.accept(addAutoSpanColumn(7));
    return this;
  }

  /**
   * Creates column which has a size of 8 columns of the 32 columns defined
   *
   * @param consumer a {@link Consumer} that provides the created column
   * @return same instance
   */
  public Row_32 span8(Consumer<Column> consumer) {
    consumer.accept(addAutoSpanColumn(8));
    return this;
  }

  /**
   * Creates column which has a size of 9 columns of the 32 columns defined
   *
   * @param consumer a {@link Consumer} that provides the created column
   * @return same instance
   */
  public Row_32 span9(Consumer<Column> consumer) {
    consumer.accept(addAutoSpanColumn(9));
    return this;
  }

  /**
   * Creates column which has a size of 10 columns of the 32 columns defined
   *
   * @param consumer a {@link Consumer} that provides the created column
   * @return same instance
   */
  public Row_32 span10(Consumer<Column> consumer) {
    consumer.accept(addAutoSpanColumn(10));
    return this;
  }

  /**
   * Creates column which has a size of 11 columns of the 32 columns defined
   *
   * @param consumer a {@link Consumer} that provides the created column
   * @return same instance
   */
  public Row_32 span11(Consumer<Column> consumer) {
    consumer.accept(addAutoSpanColumn(11));
    return this;
  }

  /**
   * Creates column which has a size of 12 columns of the 32 columns defined
   *
   * @param consumer a {@link Consumer} that provides the created column
   * @return same instance
   */
  public Row_32 span12(Consumer<Column> consumer) {
    consumer.accept(addAutoSpanColumn(12));
    return this;
  }

  /**
   * Creates column which has a size of 13 columns of the 32 columns defined
   *
   * @param consumer a {@link Consumer} that provides the created column
   * @return same instance
   */
  public Row_32 span13(Consumer<Column> consumer) {
    consumer.accept(addAutoSpanColumn(13));
    return this;
  }

  /**
   * Creates column which has a size of 14 columns of the 32 columns defined
   *
   * @param consumer a {@link Consumer} that provides the created column
   * @return same instance
   */
  public Row_32 span14(Consumer<Column> consumer) {
    consumer.accept(addAutoSpanColumn(14));
    return this;
  }

  /**
   * Creates column which has a size of 15 columns of the 32 columns defined
   *
   * @param consumer a {@link Consumer} that provides the created column
   * @return same instance
   */
  public Row_32 span15(Consumer<Column> consumer) {
    consumer.accept(addAutoSpanColumn(15));
    return this;
  }

  /**
   * Creates column which has a size of 16 columns of the 32 columns defined
   *
   * @param consumer a {@link Consumer} that provides the created column
   * @return same instance
   */
  public Row_32 span16(Consumer<Column> consumer) {
    consumer.accept(addAutoSpanColumn(16));
    return this;
  }

  /**
   * Creates column which has a size of 17 columns of the 32 columns defined
   *
   * @param consumer a {@link Consumer} that provides the created column
   * @return same instance
   */
  public Row_32 span17(Consumer<Column> consumer) {
    consumer.accept(addAutoSpanColumn(17));
    return this;
  }

  /**
   * Creates column which has a size of 18 columns of the 32 columns defined
   *
   * @param consumer a {@link Consumer} that provides the created column
   * @return same instance
   */
  public Row_32 span18(Consumer<Column> consumer) {
    consumer.accept(addAutoSpanColumn(18));
    return this;
  }

  /**
   * Creates column which has a size of 19 columns of the 32 columns defined
   *
   * @param consumer a {@link Consumer} that provides the created column
   * @return same instance
   */
  public Row_32 span19(Consumer<Column> consumer) {
    consumer.accept(addAutoSpanColumn(19));
    return this;
  }

  /**
   * Creates column which has a size of 20 columns of the 32 columns defined
   *
   * @param consumer a {@link Consumer} that provides the created column
   * @return same instance
   */
  public Row_32 span20(Consumer<Column> consumer) {
    consumer.accept(addAutoSpanColumn(20));
    return this;
  }

  /**
   * Creates column which has a size of 21 columns of the 32 columns defined
   *
   * @param consumer a {@link Consumer} that provides the created column
   * @return same instance
   */
  public Row_32 span21(Consumer<Column> consumer) {
    consumer.accept(addAutoSpanColumn(21));
    return this;
  }

  /**
   * Creates column which has a size of 22 columns of the 32 columns defined
   *
   * @param consumer a {@link Consumer} that provides the created column
   * @return same instance
   */
  public Row_32 span22(Consumer<Column> consumer) {
    consumer.accept(addAutoSpanColumn(22));
    return this;
  }

  /**
   * Creates column which has a size of 23 columns of the 32 columns defined
   *
   * @param consumer a {@link Consumer} that provides the created column
   * @return same instance
   */
  public Row_32 span23(Consumer<Column> consumer) {
    consumer.accept(addAutoSpanColumn(23));
    return this;
  }

  /**
   * Creates column which has a size of 24 columns of the 32 columns defined
   *
   * @param consumer a {@link Consumer} that provides the created column
   * @return same instance
   */
  public Row_32 span24(Consumer<Column> consumer) {
    consumer.accept(addAutoSpanColumn(24));
    return this;
  }

  /**
   * Creates column which has a size of 25 columns of the 32 columns defined
   *
   * @param consumer a {@link Consumer} that provides the created column
   * @return same instance
   */
  public Row_32 span25(Consumer<Column> consumer) {
    consumer.accept(addAutoSpanColumn(25));
    return this;
  }

  /**
   * Creates column which has a size of 26 columns of the 32 columns defined
   *
   * @param consumer a {@link Consumer} that provides the created column
   * @return same instance
   */
  public Row_32 span26(Consumer<Column> consumer) {
    consumer.accept(addAutoSpanColumn(26));
    return this;
  }

  /**
   * Creates column which has a size of 27 columns of the 32 columns defined
   *
   * @param consumer a {@link Consumer} that provides the created column
   * @return same instance
   */
  public Row_32 span27(Consumer<Column> consumer) {
    consumer.accept(addAutoSpanColumn(27));
    return this;
  }

  /**
   * Creates column which has a size of 28 columns of the 32 columns defined
   *
   * @param consumer a {@link Consumer} that provides the created column
   * @return same instance
   */
  public Row_32 span28(Consumer<Column> consumer) {
    consumer.accept(addAutoSpanColumn(28));
    return this;
  }

  /**
   * Creates column which has a size of 29 columns of the 32 columns defined
   *
   * @param consumer a {@link Consumer} that provides the created column
   * @return same instance
   */
  public Row_32 span29(Consumer<Column> consumer) {
    consumer.accept(addAutoSpanColumn(29));
    return this;
  }

  /**
   * Creates column which has a size of 30 columns of the 32 columns defined
   *
   * @param consumer a {@link Consumer} that provides the created column
   * @return same instance
   */
  public Row_32 span30(Consumer<Column> consumer) {
    consumer.accept(addAutoSpanColumn(30));
    return this;
  }

  /**
   * Creates column which has a size of 31 columns of the 32 columns defined
   *
   * @param consumer a {@link Consumer} that provides the created column
   * @return same instance
   */
  public Row_32 span31(Consumer<Column> consumer) {
    consumer.accept(addAutoSpanColumn(31));
    return this;
  }

  /**
   * Creates column which has a size of 32 columns of the 32 columns defined
   *
   * @param consumer a {@link Consumer} that provides the created column
   * @return same instance
   */
  public Row_32 span32(Consumer<Column> consumer) {
    consumer.accept(addAutoSpanColumn(32));
    return this;
  }
}
