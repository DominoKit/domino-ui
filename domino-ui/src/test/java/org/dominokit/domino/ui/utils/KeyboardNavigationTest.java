package org.dominokit.domino.ui.utils;

import static org.dominokit.domino.ui.utils.Domino.div;

import com.google.gwt.junit.client.GWTTestCase;
import elemental2.dom.KeyboardEvent;
import elemental2.dom.KeyboardEventInit;
import java.util.Collections;
import org.dominokit.domino.ui.elements.DivElement;

public class KeyboardNavigationTest extends GWTTestCase {

  @Override
  public String getModuleName() {
    return "org.dominokit.domino.ui.DominoUI";
  }

  public void testEscapeWithoutHandlerIsSafeAndConfiguredHandlerRuns() {
    DivElement item = div();
    int[] escapeCalls = {0};
    KeyboardNavigation<DivElement> navigation =
        KeyboardNavigation.create(Collections.singletonList(item));
    item.element().addEventListener("keydown", navigation);

    dispatchEscape(item);
    assertEquals(0, escapeCalls[0]);

    navigation.onEscape(() -> escapeCalls[0]++);
    dispatchEscape(item);
    assertEquals(1, escapeCalls[0]);
  }

  public void testDefaultNavigationSkipsHiddenItems() {
    DivElement first = div();
    DivElement hidden = div().hide();
    DivElement last = div();
    KeyboardNavigation<DivElement> navigation =
        KeyboardNavigation.create(java.util.Arrays.asList(first, hidden, last));
    DivElement[] focused = {null};
    navigation.onFocus(item -> focused[0] = item);

    navigation.focusNext(first);

    assertSame(last, focused[0]);
  }

  private void dispatchEscape(DivElement item) {
    KeyboardEventInit init = KeyboardEventInit.create();
    init.setKey("Escape");
    item.element().dispatchEvent(new KeyboardEvent("keydown", init));
  }
}
