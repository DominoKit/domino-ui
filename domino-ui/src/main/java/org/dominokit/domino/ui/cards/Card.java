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
package org.dominokit.domino.ui.cards;

import org.dominokit.domino.ui.utils.BaseDominoElement;

/**
 * A container component to host other components and elements that provide some extended features
 * like, collapsible body, feature rich header that comes with logo area, title, description and
 * actions toolbar and more.
 *
 * @see BaseDominoElement
 */
public class Card extends BaseCard<Card> {

  /**
   * factory method to create an empty card without a header
   *
   * @return a {@link org.dominokit.domino.ui.cards.Card} object
   */
  public static Card create() {
    return new Card();
  }

  /**
   * Factory method to create a card with a title in the header
   *
   * @param title The card title text.
   * @return new Card instance
   */
  public static Card create(String title) {
    return new Card(title);
  }

  /**
   * Factory method to create a card with a title in the header and a description below the title
   *
   * @param title The card title text
   * @param description The card description text
   * @return new Card instance
   */
  public static Card create(String title, String description) {
    return new Card(title, description);
  }

  /** Creates an empty Card without a header. */
  public Card() {}

  /**
   * Creates a card with title in the header
   *
   * @param title The card title text
   */
  public Card(String title) {
    super(title);
  }

  /**
   * Creates a card with the title in the header and a description below the title
   *
   * @param title The card title text
   * @param description The card description text
   */
  public Card(String title, String description) {
    super(title, description);
  }
}
