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
package org.dominokit.domino.ui.config;

import elemental2.dom.Element;
import elemental2.dom.HTMLElement;
import elemental2.dom.Node;
import jsinterop.base.Js;
import org.dominokit.domino.ui.popover.IsPopover;
import org.dominokit.domino.ui.popover.IsTooltip;
import org.dominokit.domino.ui.popover.Popover;
import org.dominokit.domino.ui.popover.Tooltip;

/** UIConfig interface. */
public interface UIConfig
    extends FormsFieldsConfig,
        DominoCoreConfig,
        AccordionConfig,
        CardConfig,
        ProgressBarConfig,
        SearchConfig,
        SpinConfig,
        TabsConfig,
        TreeConfig,
        UploadConfig,
        StepperConfig,
        CalendarConfig,
        TimePickerConfig,
        DelayedActionConfig,
        DatatableConfig,
        CarouselConfig,
        RichTextConfig,
        SlidersConfig,
        MenuConfig,
        NotificationConfig,
        PaginationConfig {

  @Override
  default IsPopover<?, ?> createPopover(Element target) {
    return Popover.create(Js.<HTMLElement>uncheckedCast(target));
  }

  @Override
  default IsTooltip<?, ?> createTooltip(Element target, String text) {
    return Tooltip.create(target, text);
  }

  @Override
  default IsTooltip<?, ?> createTooltip(Element target, Node content) {
    return Tooltip.create(target, content);
  }
}
