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
package org.dominokit.domino.ui.shaded.tag;

import org.dominokit.domino.ui.shaded.forms.AbstractValueBox;
import org.dominokit.domino.ui.shaded.tag.store.DynamicLocalTagsStore;
import org.dominokit.domino.ui.shaded.tag.store.TagsStore;

/**
 * A component provides an input field which represents the data in tags
 *
 * <p>This component provides an input field which takes multiple values and each value is
 * represented in a tag. It also provides a suggestion feature to list all the items in a store for
 * the user to select from it.
 *
 * <p>Customize the component can be done by overwriting classes provided by {@link TagStyles}
 *
 * <p>For example:
 *
 * <pre>
 *     TagsInput.create("Free tag")
 *              .setPlaceholder("Type anything...")
 *              .value(Collections.singletonList("Hey! how are you?"))
 *
 *     // with a store
 *     Person schroeder_coleman = new Person(1, "Schroeder Coleman");
 *     LocalTagsStore personsStore =
 *         LocalTagsStore.create()
 *             .addItem("Schroeder Coleman", schroeder_coleman)
 *             .addItem("Renee Mcintyre", new Person(2, "Renee Mcintyre"))
 *             .addItem("Casey Garza", new Person(3, "Casey Garza"));
 *     TagsInput objectTags = TagsInput.create("Friends", personsStore);
 *     objectTags.setValue(Collections.singletonList(schroeder_coleman));
 * </pre>
 *
 * @param <V> the type of the object inside the input
 * @see AbstractValueBox
 */
@Deprecated
public class TagsInput<V> extends AbstractTagsInput<TagsInput<V>, V> {

  public static TagsInput<String> create() {
    return create("");
  }

  /**
   * @return new instance of {@link String} type with a label and a dynamic store that accepts any
   *     value
   */
  public static TagsInput<String> create(final String label) {
    return create(label, new DynamicLocalTagsStore());
  }

  /** @return new instance with empty label and a {@link TagsStore} */
  public static <V> TagsInput<V> create(final TagsStore<V> store) {
    return create("", store);
  }

  /** @return new instance with a label and a {@link TagsStore} */
  public static <V> TagsInput<V> create(final String label, final TagsStore<V> store) {
    return new TagsInput<>(label, store);
  }

  protected TagsInput(final String label, final TagsStore<V> store) {
    super(label, store);
  }
}
