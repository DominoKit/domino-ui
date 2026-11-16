# Dynamic Color CSS Batching Implementation Plan

> **For agentic workers:** REQUIRED SUB-SKILL: Use superpowers:subagent-driven-development (recommended) or superpowers:executing-plans to implement this plan task-by-task. Steps use checkbox (`- [ ]`) syntax for tracking.

**Goal:** Keep existing color utilities and API while reducing CSSOM work and applying large generated-color bursts incrementally.

**Architecture:** Index owned CSS rules and accessible external stylesheet rules once, and cache owned declaration values. Group writes by selector and property; keep the first 128 changed declarations synchronous, then flush at most 256 queued declarations per animation frame. A package-private scheduler seam makes frame draining testable without changing public APIs.

**Tech Stack:** Java, GWT, elemental2 DOM/CSSOM, existing GWTTestCase tests.

**Spec:** `docs/superpowers/specs/2026-11-15-dynamic-color-css-batching-design.md`

## Global Constraints

- Keep current color names, shades, selectors, and `Color` API.
- Preserve synchronous styling for ordinary isolated utility requests.
- During a large burst, return class names immediately and allow later queued styles to apply over successive frames.
- Do not change palette values or unrelated dynamic utility families.

## Review Focus

- Repeated selector/property requests must not duplicate declarations or overwrite newer queued values; test coalescing and last-value behavior.
- Existing document stylesheets and preexisting dynamic rules must still be detected and reused; test existing compatible rules and externally defined variables.
- A burst at the sync threshold must have deterministic sync/queued behavior; test immediately below, at, and above the threshold.
- Frame scheduling must not lose or reorder remaining declarations; test multiple slices and requests enqueued while a flush is pending.
- Browsers without animation-frame availability must still drain pending declarations; test scheduler fallback behavior.

---

### Task 1: Index CSSOM rules and declarations

**Files:**
- Modify: `domino-ui-shared/src/main/java/org/dominokit/domino/ui/utils/CssomDynamicCssStyleSheet.java`
- Test: `domino-ui/src/test/java/org/dominokit/domino/ui/utils/DynamicCssCssomTest.java`

**Interfaces:**
- Consumes: existing `DynamicCssStyleSheet` API.
- Produces: cached owned selector-to-rule lookup and cached property values while preserving the existing adapter API.

- [x] **Step 1: Add regression tests** for repeated owned-rule lookup and declaration updates; existing registry tests continue to cover compatible pre-existing rules.
- [x] **Step 2: Run** the focused `DynamicCssCssomTest`; verify stylesheet and declaration semantics before changing the cache implementation.
- [x] **Step 3: Cache owned `CSSStyleRule` references and property values** in `CssomDynamicCssStyleSheet`, plus index accessible document rules and properties once per stylesheet list.
- [x] **Step 4: Run** `DynamicCssCssomTest` and `DynamicCssRegistryTest`; confirm both pass independently.

### Task 2: Coalesce and incrementally flush generated declarations

**Files:**
- Modify: `domino-ui-shared/src/main/java/org/dominokit/domino/ui/utils/DynamicCssRegistry.java`
- Create: package-private frame scheduler abstraction under `domino-ui-shared/src/main/java/org/dominokit/domino/ui/utils/`
- Test: `domino-ui/src/test/java/org/dominokit/domino/ui/utils/DynamicCssRegistryTest.java`

**Interfaces:**
- Consumes: indexed `DynamicCssStyleSheet` adapter from Task 1.
- Produces: registry declaration queue that groups writes by selector and property; default scheduler uses `requestAnimationFrame` and a timer fallback; tests use a deterministic fake scheduler.

- [x] **Step 1: Add failing tests** asserting immediate sync writes below the limit, deferred writes above it, same-key coalescing with last-value wins, ordered frame draining, and color utility names returned before flush.
- [x] **Step 2: Run** focused `DynamicCssRegistryTest` and confirm the new queue API is missing before implementation.
- [x] **Step 3: Implement** a 128-declaration synchronous budget and frame-sliced queue of at most 256 declarations; return generated class names without waiting for queued styles.
- [x] **Step 4: Add fallback test** confirming queued work drains through the timer fallback.
- [x] **Step 5: Run** `DynamicCssRegistryTest` and related dynamic CSS tests; confirm all pass.

### Task 3: Verify the color burst and integrated behavior

**Files:**
- Test: existing dynamic CSS tests and the Showcase Colors route (no showcase source change expected).

**Interfaces:**
- Consumes: completed indexed and scheduled registry behavior.
- Produces: verification evidence that isolated utilities remain synchronous and a large color workload drains progressively with equivalent final rules.

- [x] **Step 1: Run** the focused GWT dynamic CSS classes; confirm rule contents and selectors remain compatible.
- [x] **Step 2: Run** the project GWT test suite (218 tests, 0 failures/errors).
- [x] **Step 3: Open** the Showcase Colors route in headless Chrome. The current route rendered with 724 runtime rules, but its already-running code server uses the separate development checkout, so this was a smoke check rather than verification of this worktree's progressive flush.
- [x] **Step 4: Compare** `domino-ui-css-all.css` and source CSS; confirm no generated color utility selectors were restored.
