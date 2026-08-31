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
package org.dominokit.domino.ui.themes;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import org.junit.Test;

public class DominoThemeCssContractTest {

  private static final String FILE_LIST =
      "/org/dominokit/domino/ui/themes/domino-theme-css-files.txt";

  @Test
  public void normalThemeResourcesUseTheDominoScope() throws IOException {
    List<String> resources = readFileList();

    String defaultTheme = readResource(resources.get(0));
    String lightTheme = readResource(resources.get(1));
    String darkTheme = readResource(resources.get(2));

    assertTrue(defaultTheme.contains(".dui.dui-theme-default"));
    assertTrue(lightTheme.contains(".dui.dui-colors-light"));
    assertTrue(darkTheme.contains(".dui.dui-colors-dark"));

    for (String resource : resources) {
      String css = readResource(resource);
      assertFalse(resource + " must not define :root", css.contains(":root"));
      assertFalse(resource + " must not contain WaitMe selectors", css.contains("waitMe_"));
      assertFalse(resource + " must not contain WaitMe selectors", css.contains(".waitMe_"));
    }
  }

  @Test
  public void waitMeIsNotPartOfTheNormalThemeResourceList() throws IOException {
    List<String> resources = readFileList();

    assertFalse(resources.stream().anyMatch(resource -> resource.contains("domino-ui-waitMe")));
    assertNotNull(
        getClass()
            .getClassLoader()
            .getResource(
                "org/dominokit/domino/ui/public/css/domino-ui/dui-components/domino-ui-waitMe.css"));
  }

  @Test
  public void buttonIconSizeIsControlledByAThemeToken() throws IOException {
    String defaultTheme =
        readResource(
            "org/dominokit/domino/ui/public/css/domino-ui/dui-components/domino-ui-theme-default.css");
    String buttons =
        readResource(
            "org/dominokit/domino/ui/public/css/domino-ui/dui-components/domino-ui-buttons.css");

    assertTrue(defaultTheme.contains("--dui-btn-icon-size:"));
    assertTrue(buttons.contains("font-size: var(--dui-btn-icon-size);"));
  }

  @Test
  public void focusIndicatorUsesAThemeAndColorModeAwareToken() throws IOException {
    String defaultTheme =
        readResource(
            "org/dominokit/domino/ui/public/css/domino-ui/dui-components/domino-ui-theme-default.css");
    String lightTheme =
        readResource(
            "org/dominokit/domino/ui/public/css/domino-ui/dui-components/domino-ui-colors-light.css");
    String darkTheme =
        readResource(
            "org/dominokit/domino/ui/public/css/domino-ui/dui-components/domino-ui-colors-dark.css");
    String buttons =
        readResource(
            "org/dominokit/domino/ui/public/css/domino-ui/dui-components/domino-ui-buttons.css");

    assertTrue(defaultTheme.contains("--dui-focus-indicator-color: var(--dui-accent-l-4);"));
    assertTrue(lightTheme.contains("--dui-focus-indicator-color: var(--dui-accent-d-2);"));
    assertTrue(darkTheme.contains("--dui-focus-indicator-color: var(--dui-accent-l-2);"));
    assertTrue(
        buttons.contains(
            "outline: var(--dui-focus-indicator-color, var(--dui-bg-l-4, var(--dui-accent-l-4)))"));
    assertTrue(
        defaultTheme.contains(
            "--dui-form-field-focused-border: 1px solid var(--dui-focus-indicator-color);"));
  }

  @Test
  public void clickableIconShadowSpreadIsControlledByAThemeToken() throws IOException {
    String defaultTheme =
        readResource(
            "org/dominokit/domino/ui/public/css/domino-ui/dui-components/domino-ui-theme-default.css");
    String lightTheme =
        readResource(
            "org/dominokit/domino/ui/public/css/domino-ui/dui-components/domino-ui-colors-light.css");
    String darkTheme =
        readResource(
            "org/dominokit/domino/ui/public/css/domino-ui/dui-components/domino-ui-colors-dark.css");

    assertTrue(defaultTheme.contains("--dui-clickable-shadow-spread: 5px;"));
    assertTrue(lightTheme.contains("var(--dui-clickable-shadow-spread)"));
    assertTrue(darkTheme.contains("var(--dui-clickable-shadow-spread)"));
  }

  @Test
  public void quickSearchUsesOneRadiusAndAContrastingLightSurface() throws IOException {
    String defaultTheme =
        readResource(
            "org/dominokit/domino/ui/public/css/domino-ui/dui-components/domino-ui-theme-default.css");
    String menu =
        readResource(
            "org/dominokit/domino/ui/public/css/domino-ui/dui-components/domino-ui-menu.css");
    String search =
        readResource(
            "org/dominokit/domino/ui/public/css/domino-ui/dui-components/domino-ui-search.css");
    String lightTheme =
        readResource(
            "org/dominokit/domino/ui/public/css/domino-ui/dui-components/domino-ui-colors-light.css");

    assertTrue(
        defaultTheme.contains("--dui-quick-search-radius: var(--dui-form-field-wrapper-radius);"));
    assertFalse(menu.contains("border-radius: var(--dui-spc-1);"));
    assertTrue(menu.contains("border-radius: var(--dui-quick-search-radius);"));
    assertTrue(search.contains(".dui-quick-search .dui-field-input-wrapper"));
    assertTrue(search.contains("border-radius: var(--dui-quick-search-radius);"));
    assertTrue(lightTheme.contains("--dui-quick-search-bg-color: var(--dui-clr-dominant-d-1);"));
  }

  @Test
  public void recordDetailsUseAVisualIdentitySurfaceAcrossRowStates() throws IOException {
    String datatable =
        readResource(
            "org/dominokit/domino/ui/public/css/domino-ui/dui-components/domino-ui-datatable.css");
    String lightTheme =
        readResource(
            "org/dominokit/domino/ui/public/css/domino-ui/dui-components/domino-ui-colors-light.css");
    String darkTheme =
        readResource(
            "org/dominokit/domino/ui/public/css/domino-ui/dui-components/domino-ui-colors-dark.css");

    assertTrue(
        datatable.contains(
            ".dui-datatable-responsive tbody .dui-datatable-row.dui-datatable-details-tr"));
    assertTrue(
        datatable.contains(
            "--dui-datatable-row-background: var(--dui-datatable-row-details-background);"));
    assertTrue(datatable.contains(".dui-datatable-details-td {"));
    assertTrue(
        datatable.contains("background-color: var(--dui-datatable-row-details-background);"));
    assertTrue(lightTheme.contains("--dui-datatable-row-details-background:"));
    assertTrue(darkTheme.contains("--dui-datatable-row-details-background:"));
  }

  @Test
  public void treeRootUsesTheSelectedIdentitySurface() throws IOException {
    String defaultTheme =
        readResource(
            "org/dominokit/domino/ui/public/css/domino-ui/dui-components/domino-ui-theme-default.css");
    String tree =
        readResource(
            "org/dominokit/domino/ui/public/css/domino-ui/dui-components/domino-ui-tree.css");

    assertTrue(defaultTheme.contains("--dui-tree-background: var(--dui-clr-dominant);"));
    assertTrue(tree.contains("background: var(--dui-tree-background);"));
  }

  @Test
  public void defaultInfoBoxUsesTheSelectedIdentitySurface() throws IOException {
    String lightTheme =
        readResource(
            "org/dominokit/domino/ui/public/css/domino-ui/dui-components/domino-ui-colors-light.css");
    String darkTheme =
        readResource(
            "org/dominokit/domino/ui/public/css/domino-ui/dui-components/domino-ui-colors-dark.css");

    assertTrue(lightTheme.contains("--dui-info-background-color: var(--dui-accent-l-5);"));
    assertTrue(lightTheme.contains("--dui-info-color: var(--dui-color);"));
    assertTrue(lightTheme.contains("--dui-info-icon-background: var(--dui-accent-l-3);"));
    assertTrue(darkTheme.contains("--dui-info-background-color: var(--dui-accent-d-4);"));
    assertTrue(darkTheme.contains("--dui-info-icon-background: var(--dui-accent-d-3);"));
  }

  @Test
  public void subtleAndMinimalAlertsUseSurfaceContrastTextColor() throws IOException {
    String alerts =
        readResource(
            "org/dominokit/domino/ui/public/css/domino-ui/dui-components/domino-ui-alert.css");

    assertTrue(alerts.contains("--dui-emphasis-text-color: var(--dui-color);"));
  }

  @Test
  public void breadcrumbArrowUsesTheDefaultThemeArrowToken() throws IOException {
    String defaultTheme =
        readResource(
            "org/dominokit/domino/ui/public/css/domino-ui/dui-components/domino-ui-theme-default.css");
    String breadcrumb =
        readResource(
            "org/dominokit/domino/ui/public/css/domino-ui/dui-components/domino-ui-breadcrumb.css");

    assertTrue(defaultTheme.contains("--dui-bc-arrow-content: '\\203A\\00a0';"));
    assertTrue(defaultTheme.contains("--dui-bc-arrow-font-size: var(--dui-spc-px-16);"));
    assertTrue(breadcrumb.contains("font-size: var(--dui-bc-arrow-font-size);"));
  }

  @Test
  public void componentCustomizationsUseSemanticThemeTokens() throws IOException {
    String defaultTheme =
        readResource(
            "org/dominokit/domino/ui/public/css/domino-ui/dui-components/domino-ui-theme-default.css");
    String chips =
        readResource(
            "org/dominokit/domino/ui/public/css/domino-ui/dui-components/domino-ui-chips.css");
    String forms =
        readResource(
            "org/dominokit/domino/ui/public/css/domino-ui/dui-components/domino-ui-forms.css");
    String menu =
        readResource(
            "org/dominokit/domino/ui/public/css/domino-ui/dui-components/domino-ui-menu.css");
    String datatable =
        readResource(
            "org/dominokit/domino/ui/public/css/domino-ui/dui-components/domino-ui-datatable.css");
    String progress =
        readResource(
            "org/dominokit/domino/ui/public/css/domino-ui/dui-components/domino-ui-progressbar.css");
    String scrollbars =
        readResource(
            "org/dominokit/domino/ui/public/css/domino-ui/dui-components/domino-ui-scrollbars.css");

    assertTrue(defaultTheme.contains("--dui-form-field-chip-height:"));
    assertTrue(forms.contains("--dui-chip-height: var(--dui-form-field-chip-height);"));
    assertTrue(defaultTheme.contains("--dui-form-field-addon-button-padding:"));
    assertTrue(forms.contains("padding: var(--dui-form-field-addon-button-padding);"));
    assertTrue(defaultTheme.contains("--dui-form-field-addon-button-height:"));
    assertTrue(forms.contains("height: var(--dui-form-field-addon-button-height);"));
    assertTrue(forms.contains(".dui-field-postfix .dui-btn .dui-btn-body"));
    assertTrue(forms.contains("height: 100%;"));
    String stepper =
        readResource(
            "org/dominokit/domino/ui/public/css/domino-ui/dui-components/domino-ui-stepper.css");
    assertTrue(defaultTheme.contains("--dui-step-tracker-node-icon-transform:"));
    assertTrue(stepper.contains("transform: var(--dui-step-tracker-node-icon-transform);"));
    assertTrue(defaultTheme.contains("--dui-chip-addon-line-height:"));
    assertTrue(chips.contains("line-height: var(--dui-chip-addon-line-height);"));
    assertTrue(defaultTheme.contains("--dui-chip-remove-icon-size:"));
    assertTrue(chips.contains("--dui-icon-size: var(--dui-chip-remove-icon-size);"));
    assertTrue(defaultTheme.contains("--dui-progress-bar-display:"));
    assertTrue(progress.contains("display: var(--dui-progress-bar-display);"));
    assertTrue(defaultTheme.contains("--dui-menu-subheader-badge-padding:"));
    assertTrue(menu.contains("padding: var(--dui-menu-subheader-badge-padding);"));
    assertTrue(defaultTheme.contains("--dui-datatable-cell-badge-padding:"));
    assertTrue(datatable.contains("padding: var(--dui-datatable-cell-badge-padding);"));
    assertTrue(defaultTheme.contains("--dui-heading-font-weight:"));
    assertTrue(defaultTheme.contains("--dui-datatable-header-font-weight:"));
    assertTrue(datatable.contains("font-weight: var(--dui-datatable-header-font-weight);"));
    assertTrue(
        defaultTheme.contains(
            "--dui-datatable-cell-form-field-wrapper-background: var(--dui-clr-dominant);"));
    assertTrue(datatable.contains(".dui-datatable-td .dui-field-input-wrapper"));
    assertTrue(
        datatable.contains(
            "background-color: var(--dui-datatable-cell-form-field-wrapper-background);"));
    assertTrue(
        datatable.contains(
            ".dui-datatable-td .dui-form-checkbox .dui-field-input-wrapper {\n"
                + "    background-color: inherit;\n"
                + "}\n\n"
                + ".dui-datatable-td .dui-form-checkbox .dui-checkbox-label:after {\n"
                + "    background-color: var(--dui-datatable-cell-form-field-wrapper-background);\n"
                + "}\n\n"
                + ".dui-datatable-td .dui-field-input-hidden:checked + .dui-field-input .dui-checkbox-label:before,\n"
                + ".dui-datatable-td .dui-field-input-hidden:indeterminate + .dui-field-input .dui-checkbox-label:before {\n"
                + "    z-index: 1;\n"
                + "}"));
    String blockHeader =
        readResource(
            "org/dominokit/domino/ui/public/css/domino-ui/dui-components/domino-ui-blockheader.css");
    assertTrue(defaultTheme.contains("--dui-block-header-title-font-weight:"));
    assertTrue(blockHeader.contains("font-weight: var(--dui-block-header-title-font-weight);"));
    String media =
        readResource(
            "org/dominokit/domino/ui/public/css/domino-ui/dui-components/domino-ui-media-objects.css");
    assertTrue(defaultTheme.contains("--dui-media-heading-font-weight:"));
    assertTrue(media.contains("font-weight: var(--dui-media-heading-font-weight);"));
    String navbar =
        readResource(
            "org/dominokit/domino/ui/public/css/domino-ui/dui-components/domino-ui-navbar.css");
    assertTrue(defaultTheme.contains("--dui-nav-bar-title-font-weight:"));
    assertTrue(navbar.contains("font-weight: var(--dui-nav-bar-title-font-weight);"));
    String thumbnails =
        readResource(
            "org/dominokit/domino/ui/public/css/domino-ui/dui-components/domino-ui-thumbnails.css");
    assertTrue(defaultTheme.contains("--dui-thumbnail-title-font-weight:"));
    assertTrue(thumbnails.contains("font-weight: var(--dui-thumbnail-title-font-weight);"));
    assertTrue(defaultTheme.contains("--dui-scrollbar-width:"));
    assertTrue(scrollbars.contains("scrollbar-width: var(--dui-scrollbar-width);"));
  }

  @Test
  public void datatableRowsUseSemanticSurfaceAndInteractionTokens() throws IOException {
    String lightTheme =
        readResource(
            "org/dominokit/domino/ui/public/css/domino-ui/dui-components/domino-ui-colors-light.css");
    String darkTheme =
        readResource(
            "org/dominokit/domino/ui/public/css/domino-ui/dui-components/domino-ui-colors-dark.css");
    String datatable =
        readResource(
            "org/dominokit/domino/ui/public/css/domino-ui/dui-components/domino-ui-datatable.css");

    for (String theme : Arrays.asList(lightTheme, darkTheme)) {
      assertTrue(theme.contains("--dui-datatable-row-background:"));
      assertTrue(theme.contains("--dui-datatable-row-striped-background:"));
      assertTrue(theme.contains("--dui-datatable-row-hover-background:"));
      assertTrue(theme.contains("--dui-datatable-row-selected-background:"));
      assertTrue(theme.contains("--dui-datatable-row-selected-hover-background:"));
      assertTrue(theme.contains("--dui-datatable-row-highlight-background:"));
      assertTrue(theme.contains("--dui-datatable-row-context-background:"));
      assertTrue(theme.contains("--dui-datatable-row-selected-indicator-color:"));
      assertTrue(theme.contains("--dui-datatable-row-selected-indicator-width:"));
      assertTrue(theme.contains("--dui-datatable-row-focus-background:"));
    }

    assertTrue(datatable.contains("background-color: var(--dui-datatable-row-background);"));
    assertTrue(
        datatable.contains("background-color: var(--dui-datatable-row-striped-background);"));
    assertTrue(datatable.contains("background-color: var(--dui-datatable-row-hover-background);"));
    assertTrue(
        datatable.contains("background-color: var(--dui-datatable-row-selected-background);"));
    assertTrue(
        datatable.contains(
            "background-color: var(--dui-datatable-row-selected-hover-background);"));
    assertTrue(
        datatable.contains("background-color: var(--dui-datatable-row-highlight-background);"));
    assertTrue(
        datatable.contains("background-color: var(--dui-datatable-row-context-background);"));
    assertTrue(
        datatable.contains(".dui-datatable-row-selected .dui-datatable-td:first-child::before"));
    assertTrue(datatable.contains("position: relative;"));
    assertTrue(datatable.contains("inset-inline-start: 0;"));
    assertTrue(datatable.contains("width: var(--dui-datatable-row-selected-indicator-width);"));
    assertTrue(
        datatable.contains("background-color: var(--dui-datatable-row-selected-indicator-color);"));
    assertFalse(
        datatable.contains("border-inline-start: var(--dui-datatable-row-selected-indicator);"));
    assertTrue(datatable.contains("background-color: var(--dui-datatable-row-focus-background);"));
    assertFalse(datatable.contains("outline: var(--dui-datatable-row-focus-outline);"));
    assertTrue(datatable.contains(":focus-within"));
    assertFalse(datatable.contains("--dui-datatable-even-bg-color: var("));
    assertFalse(datatable.contains("--dui-datatable-odd-bg-color: var("));
    assertFalse(datatable.contains("--dui-bg-clr: var(--dui-datatable-row-highlight"));
  }

  @Test
  public void datatableBordersUseSemanticThemeColors() throws IOException {
    String lightTheme =
        readResource(
            "org/dominokit/domino/ui/public/css/domino-ui/dui-components/domino-ui-colors-light.css");
    String darkTheme =
        readResource(
            "org/dominokit/domino/ui/public/css/domino-ui/dui-components/domino-ui-colors-dark.css");
    String datatable =
        readResource(
            "org/dominokit/domino/ui/public/css/domino-ui/dui-components/domino-ui-datatable.css");

    assertTrue(lightTheme.contains("--dui-datatable-border-color: var(--dui-clr-dominant-d-2);"));
    assertTrue(darkTheme.contains("--dui-datatable-border-color: var(--dui-clr-dominant-l-2);"));
    assertTrue(
        lightTheme.contains(
            "--dui-datatable-column-resizer-color: var(--dui-datatable-border-color);"));
    assertTrue(
        darkTheme.contains(
            "--dui-datatable-column-resizer-color: var(--dui-datatable-border-color);"));
    assertTrue(
        lightTheme.contains(
            "--dui-datatable-pin-column-border-color: var(--dui-datatable-border-color);"));
    assertTrue(
        darkTheme.contains(
            "--dui-datatable-pin-column-border-color: var(--dui-datatable-border-color);"));
    assertTrue(datatable.contains("border-top: 1px solid var(--dui-datatable-border-color);"));
    assertTrue(datatable.contains("border: 1px dashed var(--dui-datatable-border-color);"));
  }

  @Test
  public void semanticForegroundsAreThemeAwareAndComponentSurfacesUseThem() throws IOException {
    String defaultTheme =
        readResource(
            "org/dominokit/domino/ui/public/css/domino-ui/dui-components/domino-ui-theme-default.css");
    String lightTheme =
        readResource(
            "org/dominokit/domino/ui/public/css/domino-ui/dui-components/domino-ui-colors-light.css");
    String darkTheme =
        readResource(
            "org/dominokit/domino/ui/public/css/domino-ui/dui-components/domino-ui-colors-dark.css");
    String buttons =
        readResource(
            "org/dominokit/domino/ui/public/css/domino-ui/dui-components/domino-ui-buttons.css");
    String generic =
        readResource(
            "org/dominokit/domino/ui/public/css/domino-ui/dui-components/domino-ui-generic.css");
    String alert =
        readResource(
            "org/dominokit/domino/ui/public/css/domino-ui/dui-components/domino-ui-alert.css");
    String infobox =
        readResource(
            "org/dominokit/domino/ui/public/css/domino-ui/dui-components/domino-ui-infobox.css");
    String progress =
        readResource(
            "org/dominokit/domino/ui/public/css/domino-ui/dui-components/domino-ui-progressbar.css");
    String menu =
        readResource(
            "org/dominokit/domino/ui/public/css/domino-ui/dui-components/domino-ui-menu.css");
    String forms =
        readResource(
            "org/dominokit/domino/ui/public/css/domino-ui/dui-components/domino-ui-forms.css");
    String search =
        readResource(
            "org/dominokit/domino/ui/public/css/domino-ui/dui-components/domino-ui-search.css");
    assertTrue(defaultTheme.contains("--dui-alert-color: var(--dui-accent-fg-clr);"));
    assertTrue(defaultTheme.contains("--dui-alert-background: var(--dui-bg);"));
    assertTrue(defaultTheme.contains("--dui-info-icon-color: var(--dui-dominant-fg-clr);"));
    assertTrue(defaultTheme.contains("--dui-progress-bar-color: var(--dui-accent-fg-clr);"));
    assertTrue(
        buttons.contains(
            "color: var(--dui-btn-fg-clr, var(--dui-accent-fg-clr, var(--dui-color)));"));
    assertTrue(generic.contains("--dui-context-fg-color: var(--dui-primary-fg-clr);"));
    assertTrue(alert.contains("color: var(--dui-alert-color);"));
    assertTrue(infobox.contains("color: var(--dui-info-icon-color);"));
    assertTrue(progress.contains("color: var(--dui-progress-bar-color);"));
    assertTrue(menu.contains("color: var(--dui-menu-item-selected-color);"));
    assertTrue(forms.contains("color: var(--dui-form-field-placeholder-color);"));
    assertTrue(search.contains("color: var(--dui-form-field-placeholder-color);"));
    assertTrue(search.contains("opacity: var(--dui-quick-search-input-placeholder-opacity);"));

    assertTrue(lightTheme.contains("--dui-primary-fg-clr: var(--dui-clr-white);"));
    assertTrue(lightTheme.contains("--dui-secondary-fg-clr: var(--dui-clr-black);"));
    assertTrue(lightTheme.contains("--dui-success-fg-clr: var(--dui-clr-black);"));
    assertTrue(lightTheme.contains("--dui-warning-fg-clr: var(--dui-clr-black);"));
    assertTrue(lightTheme.contains("--dui-info-fg-clr: var(--dui-clr-black);"));
    assertTrue(lightTheme.contains("--dui-error-fg-clr: var(--dui-clr-black);"));
    assertTrue(lightTheme.contains("--dui-accent-fg-clr: var(--dui-clr-black);"));
    assertTrue(
        lightTheme.contains(
            "--dui-form-field-placeholder-color: color-mix(in srgb, var(--dui-color-1) 75%, var(--dui-color-2) 25%);"));
    assertTrue(lightTheme.contains("--dui-menu-item-selected-color: var(--dui-color);"));
    assertTrue(lightTheme.contains("--dui-nav-bar-description-color: var(--dui-color);"));

    assertTrue(darkTheme.contains("--dui-primary-fg-clr: var(--dui-clr-white);"));
    assertTrue(darkTheme.contains("--dui-secondary-fg-clr: var(--dui-clr-white);"));
    assertTrue(darkTheme.contains("--dui-success-fg-clr: var(--dui-clr-black);"));
    assertTrue(darkTheme.contains("--dui-warning-fg-clr: var(--dui-clr-black);"));
    assertTrue(darkTheme.contains("--dui-info-fg-clr: var(--dui-clr-white);"));
    assertTrue(darkTheme.contains("--dui-error-fg-clr: var(--dui-clr-white);"));
    assertTrue(darkTheme.contains("--dui-accent-fg-clr: var(--dui-clr-white);"));
    assertTrue(
        darkTheme.contains(
            "--dui-form-field-placeholder-color: color-mix(in srgb, var(--dui-color-1) 75%, var(--dui-color-2) 25%);"));
    assertTrue(darkTheme.contains("--dui-menu-item-selected-color: var(--dui-color);"));
    assertTrue(darkTheme.contains("--dui-nav-bar-description-color: var(--dui-color);"));
  }

  @Test
  public void emphasisModifiersUseContrastAwareTextAndBorderColors() throws IOException {
    String emphasis =
        readResource(
            "org/dominokit/domino/ui/public/css/domino-ui/dui-components/domino-ui-emphasis.css");
    String infobox =
        readResource(
            "org/dominokit/domino/ui/public/css/domino-ui/dui-components/domino-ui-infobox.css");

    assertTrue(emphasis.contains("--dui-emphasis-text-color: var(--dui-color);"));
    assertTrue(emphasis.contains("color: var(--dui-emphasis-text-color);"));
    assertTrue(
        emphasis.contains("color-mix(in srgb, var(--dui-emphasis-color) 82%, var(--dui-color))"));
    assertTrue(infobox.contains("--dui-emphasis-color: var(--dui-info-color);"));
  }

  @Test
  public void darkFormFieldsUseADarkerDominantSurface() throws IOException {
    String lightTheme =
        readResource(
            "org/dominokit/domino/ui/public/css/domino-ui/dui-components/domino-ui-colors-light.css");
    String darkTheme =
        readResource(
            "org/dominokit/domino/ui/public/css/domino-ui/dui-components/domino-ui-colors-dark.css");
    String forms =
        readResource(
            "org/dominokit/domino/ui/public/css/domino-ui/dui-components/domino-ui-forms.css");

    assertTrue(lightTheme.contains("--dui-form-field-background: var(--dui-clr-dominant);"));
    assertTrue(darkTheme.contains("--dui-form-field-background: var(--dui-clr-dominant-d-1);"));
    assertTrue(forms.contains(".dui-field-input-wrapper {"));
    assertTrue(forms.contains("background-color: var(--dui-form-field-background);"));
  }

  @Test
  public void formFieldAddonsUseThemeControlledSpacing() throws IOException {
    String defaultTheme =
        readResource(
            "org/dominokit/domino/ui/public/css/domino-ui/dui-components/domino-ui-theme-default.css");
    String forms =
        readResource(
            "org/dominokit/domino/ui/public/css/domino-ui/dui-components/domino-ui-forms.css");

    assertTrue(defaultTheme.contains("--dui-form-field-wrapper-gap: var(--dui-spc-px-5);"));
    assertTrue(defaultTheme.contains("--dui-form-field-addon-gap: var(--dui-spc-3);"));
    assertTrue(
        forms.contains(
            ".dui-field-prefix,\n.dui-field-postfix {\n    gap: var(--dui-form-field-addon-gap);"));
  }

  @Test
  public void switchesExposeReadOnlyVisualStateTokens() throws IOException {
    String defaultTheme =
        readResource(
            "org/dominokit/domino/ui/public/css/domino-ui/dui-components/domino-ui-theme-default.css");
    String forms =
        readResource(
            "org/dominokit/domino/ui/public/css/domino-ui/dui-components/domino-ui-forms.css");

    assertTrue(defaultTheme.contains("--dui-form-field-switch-readonly-track-background:"));
    assertTrue(defaultTheme.contains("--dui-form-field-switch-readonly-checked-track-background:"));
    assertTrue(defaultTheme.contains("--dui-form-field-switch-readonly-thumb-background:"));
    assertTrue(defaultTheme.contains("--dui-form-field-switch-readonly-checked-thumb-background:"));
    assertTrue(forms.contains(".dui-form-switch[readonly] {"));
    assertTrue(
        forms.contains(
            "--dui-form-field-switch-track-background: var(--dui-form-field-switch-readonly-track-background);"));
    assertTrue(
        forms.contains(
            "--dui-form-field-switch-checked-track-background: var(--dui-form-field-switch-readonly-checked-track-background);"));
    assertTrue(
        forms.contains(
            "--dui-form-field-switch-thumb-background: var(--dui-form-field-switch-readonly-thumb-background);"));
    assertTrue(
        forms.contains(
            "--dui-form-field-switch-checked-thumb-background: var(--dui-form-field-switch-readonly-checked-thumb-background);"));
  }

  @Test
  public void checkboxesExposeReadOnlyVisualStateTokens() throws IOException {
    String defaultTheme =
        readResource(
            "org/dominokit/domino/ui/public/css/domino-ui/dui-components/domino-ui-theme-default.css");
    String forms =
        readResource(
            "org/dominokit/domino/ui/public/css/domino-ui/dui-components/domino-ui-forms.css");

    assertTrue(defaultTheme.contains("--dui-form-field-checkbox-readonly-border-color:"));
    assertTrue(defaultTheme.contains("--dui-form-field-checkbox-readonly-filled-background:"));
    assertTrue(defaultTheme.contains("--dui-form-field-checkbox-readonly-check-color:"));
    assertTrue(forms.contains(".dui-form-checkbox[readonly] {"));
    assertTrue(
        forms.contains(
            "--dui-form-field-checkbox-square-border-color: var(--dui-form-field-checkbox-readonly-border-color);"));
    assertTrue(
        forms.contains(
            "--dui-form-field-checkbox-square-filled-background: var(--dui-form-field-checkbox-readonly-filled-background);"));
    assertTrue(
        forms.contains(
            "background-color: var(--dui-form-field-checkbox-square-filled-background, var(--dui-accent));"));
  }

  @Test
  public void nestedCardsUseAContrastingSurface() throws IOException {
    String defaultTheme =
        readResource(
            "org/dominokit/domino/ui/public/css/domino-ui/dui-components/domino-ui-theme-default.css");
    String lightTheme =
        readResource(
            "org/dominokit/domino/ui/public/css/domino-ui/dui-components/domino-ui-colors-light.css");
    String darkTheme =
        readResource(
            "org/dominokit/domino/ui/public/css/domino-ui/dui-components/domino-ui-colors-dark.css");
    String cards =
        readResource(
            "org/dominokit/domino/ui/public/css/domino-ui/dui-components/domino-ui-cards.css");

    assertTrue(defaultTheme.contains("--dui-card-nested-background:"));
    assertTrue(defaultTheme.contains("--dui-card-nested-2-background:"));
    assertTrue(defaultTheme.contains("--dui-card-nested-3-background:"));
    assertTrue(lightTheme.contains("--dui-card-nested-background: var(--dui-clr-dominant-l-3);"));
    assertTrue(lightTheme.contains("--dui-card-nested-2-background: var(--dui-clr-dominant-l-2);"));
    assertTrue(lightTheme.contains("--dui-card-nested-3-background: var(--dui-clr-dominant-d-1);"));
    assertTrue(darkTheme.contains("--dui-card-nested-background: var(--dui-clr-dominant-l-1);"));
    assertTrue(darkTheme.contains("--dui-card-nested-2-background: var(--dui-clr-dominant-l-2);"));
    assertTrue(darkTheme.contains("--dui-card-nested-3-background: var(--dui-clr-dominant-l-3);"));
    assertTrue(cards.contains(".dui-card .dui-card {"));
    assertTrue(cards.contains("background-color: var(--dui-card-nested-background);"));
    assertTrue(cards.contains(".dui-card .dui-card .dui-card {"));
    assertTrue(cards.contains("background-color: var(--dui-card-nested-2-background);"));
    assertTrue(cards.contains(".dui-card .dui-card .dui-card .dui-card {"));
    assertTrue(cards.contains("background-color: var(--dui-card-nested-3-background);"));
  }

  @Test
  public void defaultThemeExposesSharedRadiusTokens() throws IOException {
    String defaultTheme =
        readResource(
            "org/dominokit/domino/ui/public/css/domino-ui/dui-components/domino-ui-theme-default.css");

    assertTrue(defaultTheme.contains("--dui-radius-none: 0;"));
    assertTrue(defaultTheme.contains("--dui-radius-xs: 2px;"));
    assertTrue(defaultTheme.contains("--dui-radius-sm: 3px;"));
    assertTrue(defaultTheme.contains("--dui-radius-md: 4px;"));
    assertTrue(defaultTheme.contains("--dui-radius-lg: 6px;"));
    assertTrue(defaultTheme.contains("--dui-radius-xl: 8px;"));
    assertTrue(defaultTheme.contains("--dui-radius-pill: 9999px;"));

    assertTrue(defaultTheme.contains("--dui-btn-border-radius: var(--dui-radius-xs);"));
    assertTrue(defaultTheme.contains("--dui-btn-group-border-radius: var(--dui-radius-xs);"));
    assertTrue(defaultTheme.contains("--dui-card-border-radius: var(--dui-radius-xs);"));
    assertTrue(defaultTheme.contains("--dui-dialog-border-radius: var(--dui-radius-xs);"));
  }

  @Test
  public void bottomPositionedCardsOnlyRoundTheirOuterBottomCorners() throws IOException {
    String cards =
        readResource(
            "org/dominokit/domino/ui/public/css/domino-ui/dui-components/domino-ui-cards.css");

    assertTrue(
        cards.contains(
            ".dui-card.dui-card-header-bottom .dui-card-header {\n"
                + "    border-top-left-radius: 0;\n"
                + "    border-top-right-radius: 0;\n"
                + "    border-bottom-left-radius: inherit;\n"
                + "    border-bottom-right-radius: inherit;"));
    assertTrue(
        cards.contains(
            ".dui-card.dui-card-header-bottom .dui-card-body {\n"
                + "    border-top-left-radius: inherit;\n"
                + "    border-top-right-radius: inherit;\n"
                + "    border-bottom-left-radius: 0;\n"
                + "    border-bottom-right-radius: 0;"));
  }

  @Test
  public void rightDrawerStacksAboveFooter() throws IOException {
    String appLayout =
        readResource(
            "org/dominokit/domino/ui/public/css/domino-ui/dui-components/domino-ui-app-layout.css");

    assertTrue(appLayout.contains("--dui-right-drawer-z-index: var(--dui-zindex-offset-6);"));
    assertTrue(appLayout.contains("--dui-footer-z-index: var(--dui-zindex-offset-5);"));
    assertTrue(appLayout.contains("z-index: var(--dui-right-drawer-z-index);"));
  }

  @Test
  public void drawersScrollWithinTheLayoutBounds() throws IOException {
    String appLayout =
        readResource(
            "org/dominokit/domino/ui/public/css/domino-ui/dui-components/domino-ui-app-layout.css");

    assertTrue(appLayout.contains(".dui-left-drawer {\n    overflow-y: auto;"));
    assertTrue(appLayout.contains(".dui-right-drawer {\n    overflow-y: auto;"));
    assertTrue(
        appLayout.contains(
            "    position: absolute;\n    top: 0;\n    bottom: 0;\n    height: auto;\n    inset-inline-start: 0;"));
    assertTrue(appLayout.contains("    top: 0;\n    bottom: 0;\n    height: auto;"));
    assertTrue(appLayout.contains("margin: var(--dui-right-drawer-padding-top) 0 0 0;"));
  }

  @Test
  public void emphasisModifiersExposeScopedComposableTokens() throws IOException {
    String emphasis =
        readResource(
            "org/dominokit/domino/ui/public/css/domino-ui/dui-components/domino-ui-emphasis.css");
    String buttons =
        readResource(
            "org/dominokit/domino/ui/public/css/domino-ui/dui-components/domino-ui-buttons.css");
    String badges =
        readResource(
            "org/dominokit/domino/ui/public/css/domino-ui/dui-components/domino-ui-badge.css");
    String chips =
        readResource(
            "org/dominokit/domino/ui/public/css/domino-ui/dui-components/domino-ui-chips.css");
    String alerts =
        readResource(
            "org/dominokit/domino/ui/public/css/domino-ui/dui-components/domino-ui-alert.css");
    String infobox =
        readResource(
            "org/dominokit/domino/ui/public/css/domino-ui/dui-components/domino-ui-infobox.css");
    String menu =
        readResource(
            "org/dominokit/domino/ui/public/css/domino-ui/dui-components/domino-ui-menu.css");
    String cards =
        readResource(
            "org/dominokit/domino/ui/public/css/domino-ui/dui-components/domino-ui-cards.css");
    String tabs =
        readResource(
            "org/dominokit/domino/ui/public/css/domino-ui/dui-components/domino-ui-tabs.css");
    String progress =
        readResource(
            "org/dominokit/domino/ui/public/css/domino-ui/dui-components/domino-ui-progressbar.css");

    assertFalse(emphasis.contains(":root"));
    assertTrue(emphasis.contains("body.dui .dui-emphasis-subtle"));
    assertTrue(emphasis.contains("body.dui .dui-emphasis-minimal"));
    assertTrue(emphasis.contains("body.dui .dui-emphasis-filled"));
    assertTrue(emphasis.contains("--dui-emphasis-fill-strength: 14%;"));
    assertTrue(emphasis.contains("--dui-emphasis-fill-strength: 0%;"));
    assertTrue(emphasis.contains("--dui-emphasis-ring-width: 1px;"));
    assertTrue(emphasis.contains("--dui-emphasis-ring-width: 0px;"));
    assertTrue(emphasis.contains("--dui-emphasis-ring-style: inset;"));
    assertTrue(emphasis.contains("--dui-emphasis-border: 1px solid var(--dui-emphasis-color);"));
    assertTrue(emphasis.contains("--dui-emphasis-border: 0 solid transparent;"));
    assertTrue(emphasis.contains("--dui-emphasis-border-width: 1px;"));
    assertTrue(
        emphasis.contains(
            "--dui-emphasis-border-color: color-mix(in srgb, var(--dui-emphasis-color) 82%, var(--dui-color))"));
    assertTrue(emphasis.contains("body.dui :is(.dui-emphasis-subtle, .dui-emphasis-minimal)"));
    assertTrue(emphasis.contains(".dui-btn, .dui-badge, .dui-chip"));
    assertTrue(emphasis.contains(".dui-progress-bar, .dui-card).dui-emphasis-subtle"));
    assertTrue(emphasis.contains(".dui-card"));
    assertFalse(emphasis.contains(".dui-tab-item"));
    assertFalse(emphasis.contains(".dui-tab-anchor"));
    assertFalse(emphasis.contains(".dui-menu-item"));
    assertFalse(emphasis.contains(".dui-menu"));
    assertFalse(tabs.contains("--dui-emphasis-color"));
    assertTrue(emphasis.contains(".dui-badge, .dui-chip, .dui-alert"));
    assertTrue(
        emphasis.contains(
            ":is(.dui-badge, .dui-chip, .dui-alert, .dui-card):not(.dui-emphasis-filled)"));
    assertTrue(emphasis.contains("border-width: var(--dui-emphasis-border-width);"));
    assertTrue(emphasis.contains(".dui-emphasis-subtle:not(.dui-emphasis-filled)"));
    assertTrue(emphasis.contains("body.dui .dui-emphasis-filled"));

    assertTrue(buttons.contains("--dui-emphasis-color: var(--dui-btn-bg-clr"));
    assertTrue(buttons.contains("--dui-emphasis-native-box-shadow: var(--dui-btn-box-shadow);"));
    assertTrue(emphasis.contains("color-mix(in srgb, var(--dui-emphasis-color)"));
    assertTrue(emphasis.contains("var(--dui-emphasis-ring-width"));
    assertTrue(badges.contains("--dui-emphasis-color: var(--dui-badge-background);"));
    assertTrue(chips.contains("--dui-emphasis-color: var(--dui-accent"));
    assertTrue(alerts.contains("--dui-emphasis-color: var(--dui-alert-background);"));
    assertTrue(alerts.contains(".dui-alert.dui-info"));
    assertTrue(alerts.contains(".dui-alert.dui-warning"));
    assertTrue(alerts.contains("--dui-emphasis-color: var(--dui-bg);"));
    assertTrue(alerts.contains("--dui-emphasis-text-color: var(--dui-color);"));
    assertTrue(infobox.contains("--dui-emphasis-color: var(--dui-info-color);"));
    assertFalse(menu.contains("--dui-emphasis-color"));
    assertTrue(cards.contains("--dui-emphasis-color: var(--dui-accent);"));
    assertTrue(progress.contains("--dui-emphasis-color: var(--dui-accent);"));
    assertTrue(progress.contains("--dui-emphasis-text-color: var(--dui-progress-bar-color);"));
  }

  @Test
  public void accentHarmonyKeepsTheCompleteSourceAndRuntimeScale() throws IOException {
    String colors =
        readResource(
            "org/dominokit/domino/ui/public/css/domino-ui/dui-components/domino-ui-colors.css");
    String lightTheme =
        readResource(
            "org/dominokit/domino/ui/public/css/domino-ui/dui-components/domino-ui-colors-light.css");
    String darkTheme =
        readResource(
            "org/dominokit/domino/ui/public/css/domino-ui/dui-components/domino-ui-colors-dark.css");

    for (String slot : accentScaleSlots()) {
      assertTrue(
          "Missing source accent slot: " + slot, colors.contains("--dui-accent-source" + slot));
      assertTrue("Missing runtime accent slot: " + slot, colors.contains("--dui-accent" + slot));
    }

    assertTrue(lightTheme.contains("--dui-accent-source-l-5:"));
    assertTrue(lightTheme.contains("--dui-accent-source-d-4:"));
    assertTrue(darkTheme.contains("--dui-accent-source-l-5:"));
    assertTrue(darkTheme.contains("--dui-accent-source-d-4:"));
    assertTrue(colors.contains("--dui-accent-harmony-strength: 0%;"));
    assertTrue(colors.contains("--dui-accent-harmony-anchor: var(--dui-accent-source);"));
    assertTrue(colors.contains("color-mix(in oklch,"));
    assertTrue(colors.contains("calc(100% - var(--dui-accent-harmony-strength))"));
  }

  private List<String> accentScaleSlots() {
    return Arrays.asList(
        "-l-5", "-l-4", "-l-3", "-l-2", "-l-1", "", "-d-1", "-d-2", "-d-3", "-d-4");
  }

  private List<String> readFileList() throws IOException {
    try (InputStream stream = getClass().getResourceAsStream(FILE_LIST)) {
      assertNotNull(FILE_LIST, stream);
      String content = new String(stream.readAllBytes(), StandardCharsets.UTF_8);
      return Arrays.stream(content.split("\\R"))
          .map(String::trim)
          .filter(line -> !line.isEmpty())
          .collect(Collectors.toList());
    }
  }

  private String readResource(String resource) throws IOException {
    try (InputStream stream = getClass().getClassLoader().getResourceAsStream(resource)) {
      assertNotNull(resource, stream);
      return new String(stream.readAllBytes(), StandardCharsets.UTF_8);
    }
  }
}
