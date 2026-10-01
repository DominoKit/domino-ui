package org.dominokit.domino.ui.dnd;

import static org.dominokit.domino.ui.utils.Domino.div;

import com.google.gwt.junit.client.GWTTestCase;
import org.dominokit.domino.ui.elements.DivElement;

public class DragSourceTest extends GWTTestCase {

  @Override
  public String getModuleName() {
    return "org.dominokit.domino.ui.DominoUI";
  }

  public void testReplacingIdDetachesPreviousDraggable() {
    DivElement firstElement = div();
    DivElement secondElement = div();
    Draggable<DivElement> first = Draggable.of("item", firstElement);
    Draggable<DivElement> second = Draggable.of("item", secondElement);
    DragSource source = new DragSource();

    source.addDraggable(first);
    source.addDraggable(second);

    assertFalse(firstElement.element().draggable);
    assertTrue(secondElement.element().draggable);
    source.removeDraggable("item");
    assertFalse(secondElement.element().draggable);
  }

  public void testAddingSameInstanceAgainKeepsItAttached() {
    DivElement element = div();
    Draggable<DivElement> draggable = Draggable.of("item", element);
    DragSource source = new DragSource();

    source.addDraggable(draggable);
    source.addDraggable(draggable);

    assertTrue(element.element().draggable);
  }
}
