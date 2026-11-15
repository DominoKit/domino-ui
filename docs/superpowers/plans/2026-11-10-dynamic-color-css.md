# Dynamic Color CSS Implementation Plan

> **For agentic workers:** REQUIRED SUB-SKILL: Use superpowers:executing-plans to implement this plan task-by-task. Steps use checkbox (`- [ ]`) syntax for tracking.

**Goal:** Preserve Domino UI's built-in color API while injecting only the color utility CSS rules that an application uses.

**Architecture:** Reuse `DynamicCss.lazyCssClass` and its document CSSOM registry to resolve built-in color class names into runtime declarations. Keep palette variables static and remove the generated static utility matrix.

**Tech Stack:** Java/GWT, Elemental2 CSSOM, Maven Ant resource concatenation and minification, CSS.

**Spec:** `docs/superpowers/specs/2026-11-10-dynamic-color-css.md`

## Global Constraints

- Preserve existing color names, shades, Java API constants, and class tokens.
- Keep arbitrary custom colors out of scope.
- CSS-only color utility compatibility is out of scope while the static matrix is removed.
- Do not eagerly preload the built-in color utility matrix.

## Review Focus

- Color selector families and utility declarations must retain the behavior of the existing CSS rules.
- Repeated resolution of the same color class must not duplicate runtime rules.
- The generated static color utility stylesheet should no longer be published.
- Existing light/dark palette variables must remain part of normal CSS delivery.
- Static utility class values used by runtime components must resolve without changing their names.

---

### Task 1: Lazy runtime color utility rules

**Files:**
- Modify: `domino-ui-shared/src/main/java/org/dominokit/domino/ui/utils/DynamicCss.java`
- Modify: `domino-ui-shared/src/main/java/org/dominokit/domino/ui/utils/DynamicCssRegistry.java`
- Modify: `domino-ui-shared/src/main/java/org/dominokit/domino/ui/utils/StaticDynamicCssUtility.java`
- Modify: `domino-ui-shared/src/main/java/org/dominokit/domino/ui/style/ColorsCss.java`

**Interfaces:**
- Consumes: existing `DynamicCss.lazyCssClass(String)`, `DynamicCssStyleSheet.setProperty`, and public `ColorsCss` constants.
- Produces: lazy resolution of existing built-in color class names that inject matching rules and retain their exact class tokens.

- [x] Add color-class recognition and declaration generation for the existing palette names, shades, and utility families.
- [x] Route existing `ColorsCss` constants through lazy resolution while preserving `LimitOneOfPrefixedCssClass` behavior.
- [x] Ensure repeated color-class resolution reuses injected rules and does not trigger development preloading of all color rules.

### Task 2: Default and compatibility CSS resources

**Files:**
- Modify: `domino-ui/src/main/resources/org/dominokit/domino/ui/public/css/domino-ui/dui-components/domino-ui-generic.css` to retain shared context helpers and runtime harmony rules from the full utility stylesheet
- Delete: `domino-ui/src/main/resources/org/dominokit/domino/ui/public/css/domino-ui/dui-components/domino-ui-colors.css`
- Keep light/dark palette value stylesheets.
- Modify: `domino-ui/pom.xml`

**Interfaces:**
- Consumes: runtime Java resolver from Task 1 and current static color utility stylesheet.
- Produces: aggregate CSS without the large color utility matrix; only used color rules are injected at runtime.

- [x] Remove the generated static color utility stylesheet and its aggregate/minification references.
- [x] Preserve normal light/dark palette CSS.

### Task 3: Consumer documentation

**Files:**
- Modify: `STYLING_AND_THEMING.md`

**Interfaces:**
- Consumes: runtime-injected rules from Task 1 and removal of the static matrix in Task 2.
- Produces: clear guidance for Java API runtime injection.

- [x] Document that Java `ColorsCss`/`Color` usage injects used color rules at runtime.
