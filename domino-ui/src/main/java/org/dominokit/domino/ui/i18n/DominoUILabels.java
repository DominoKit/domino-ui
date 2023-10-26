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
package org.dominokit.domino.ui.i18n;

/**
 * The {@code DominoUILabels} interface defines a collection of sub-label interfaces for various UI
 * components. It consolidates all these sub-label interfaces into a single interface to provide a
 * unified way to access labels for different parts of the UI.
 *
 * <p>Developers can implement this interface to provide custom labels for various UI components by
 * implementing the sub-label interfaces.
 *
 * @see QuickSearchLabels
 * @see FormsLabels
 * @see MenuLabels
 * @see DialogLabels
 * @see LoaderLabels
 * @see PaginationLabels
 * @see SearchLabels
 * @see UploadLabels
 * @see PickersLabels
 * @see CalendarLabels
 * @see RichTextLabels
 * @see TimePickerLabels
 */
public interface DominoUILabels
    extends QuickSearchLabels,
        FormsLabels,
        MenuLabels,
        DialogLabels,
        LoaderLabels,
        PaginationLabels,
        SearchLabels,
        UploadLabels,
        PickersLabels,
        CalendarLabels,
        RichTextLabels,
        TimePickerLabels {}
