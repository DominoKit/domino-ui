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
package org.dominokit.domino.ui.modals;

import elemental2.dom.HTMLDivElement;
import elemental2.dom.HTMLHeadingElement;
import elemental2.dom.Node;
import org.dominokit.domino.ui.style.Color;
import org.dominokit.domino.ui.utils.DominoElement;
import org.jboss.elemento.IsElement;

/**
 * Base interface to implement modal dialog
 *
 * @param <T> the type of the component implementing this interface
 */
public interface IsModalDialog<T> {

  /**
   * @param content {@link Node} to be appended to the modal body
   * @return same implementing component
   */
  T appendChild(Node content);

  /**
   * @param content {@link IsElement} to be appended to the modal body
   * @return same implementing component
   */
  T appendChild(IsElement<?> content);

  /**
   * @param content {@link Node} to be appended to the modal footer
   * @return same implementing component
   */
  T appendFooterChild(Node content);

  /**
   * @param content {@link IsElement} to be appended to the modal footer
   * @return same implementing component
   */
  T appendFooterChild(IsElement<?> content);

  /**
   * set the dialog size to {@link ModalSize#LARGE}
   *
   * @return same implementing interface
   */
  T large();

  /**
   * set the dialog size to {@link ModalSize#SMALL}
   *
   * @return same implementing interface
   */
  T small();

  /**
   * @param color {@link Color} of the modal header and body
   * @return same implementing interface
   */
  T setModalColor(Color color);

  /**
   * @param autoClose boolean, true to close the dialog by pressing escape key
   * @return same implementing interface
   */
  T setAutoClose(boolean autoClose);

  /**
   * Show the dialog
   *
   * @return same implementing component
   */
  T open();

  /**
   * Close and hide the dialog
   *
   * @return same implementing component
   */
  T close();

  /**
   * Hides the footer of the dialog
   *
   * @return same implementing component
   */
  T hideFooter();

  /**
   * Show the footer of the dialog
   *
   * @return same implementing component
   */
  T showFooter();

  /**
   * hide the header of the dialog
   *
   * @return same implementing component
   */
  T hideHeader();

  /**
   * Show the header of the dialog
   *
   * @return same implementing component
   */
  T showHeader();

  /**
   * Hide the title of the dialog
   *
   * @return same implementing component
   */
  T hideTitle();

  /**
   * Show the title of the dialog
   *
   * @return same implementing component
   */
  T showTitle();

  /**
   * @param title String
   * @return same implementing component
   */
  T setTitle(String title);

  /** @return same implementing component */
  DominoElement<HTMLDivElement> getDialogElement();

  /** @return same implementing component */
  DominoElement<HTMLDivElement> getContentElement();

  /** @return same implementing component */
  DominoElement<HTMLHeadingElement> getHeaderElement();

  /** @return same implementing component */
  DominoElement<HTMLDivElement> getHeaderContainerElement();

  /** @return same implementing component */
  DominoElement<HTMLDivElement> getBodyElement();

  /** @return same implementing component */
  DominoElement<HTMLDivElement> getFooterElement();

  /**
   * @param openHandler {@link OpenHandler}
   * @return same implementing component
   */
  T addOpenListener(OpenHandler openHandler);

  /**
   * @param closeHandler {@link CloseHandler}
   * @return same implementing component
   */
  T addCloseListener(CloseHandler closeHandler);

  /**
   * @param openHandler {@link OpenHandler}
   * @return same implementing component
   */
  T removeOpenHandler(OpenHandler openHandler);

  /**
   * @param closeHandler {@link CloseHandler}
   * @return same implementing component
   */
  T removeCloseHandler(CloseHandler closeHandler);

  /**
   * @param autoAppendAndRemove boolean, true to automatically remove and append the modal every
   *     time we open it
   * @return same implementing component
   */
  T setAutoAppendAndRemove(boolean autoAppendAndRemove);

  /** @return boolean, true to automatically remove and append the modal every time we open it */
  boolean getAutoAppendAndRemove();

  /**
   * make the dialog show up in the center of the screen
   *
   * @return same implementing component
   */
  T centerVertically();

  /**
   * make the dialog show up on the top of the screen
   *
   * @return
   */
  T deCenterVertically();

  /** An enum to list modal possible zises */
  enum ModalSize {
    /** Large modal with wider width */
    LARGE(ModalStyles.MODAL_LG),
    /** Medium modal with medium width */
    ALERT(ModalStyles.MODAL_ALERT),
    /** small modal with small width */
    SMALL(ModalStyles.MODAL_SM);

    String style;

    /** @param style String css style name */
    ModalSize(String style) {
      this.style = style;
    }
  }

  /** An enum to list modal types */
  enum ModalType {
    /** A modal that show up from the bottom of screen and spread to match the screen width */
    BOTTOM_SHEET(ModalStyles.BOTTOM_SHEET),
    /** A modal that show up from the top of screen and spread to match the screen width */
    TOP_SHEET(ModalStyles.TOP_SHEET),
    /** A modal that show up from the left of screen and spread to match the screen height */
    LEFT_SHEET(ModalStyles.LEFT_SHEET),
    /** A modal that show up from the right of screen and spread to match the screen height */
    RIGHT_SHEET(ModalStyles.RIGHT_SHEET);

    String style;

    /** @param style String css style name */
    ModalType(String style) {
      this.style = style;
    }
  }

  /** A function to implement a listener to be called when open the dialog */
  @FunctionalInterface
  interface OpenHandler {
    void onOpen();
  }

  /** An interface to implement handlers for closing a dialog */
  @FunctionalInterface
  interface CloseHandler {
    /** Will be called when the dialog is closed */
    void onClose();
  }
}
