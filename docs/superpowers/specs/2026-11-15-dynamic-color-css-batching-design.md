# Dynamic Color CSS Batching Design

## Intent

Opening the Showcase Colors sample currently resolves color classes while constructing the entire sample in one JavaScript task. The sample renders 28 palettes with 10 shades each, and each color box requests several color utilities. This can trigger many synchronous CSSOM lookups and writes, delaying the browser's next paint.

## Goals

- Keep the existing color names, shades, selectors, and `Color` API.
- Reduce repeated CSSOM scans and duplicate property writes.
- Apply large groups of generated color rules over multiple animation frames so the browser can paint and respond between chunks.
- Keep isolated utility use synchronous where practical.

## Non-goals

- Change the palette values or generated class names.
- Replace runtime CSS injection with generated static CSS.
- Change the appearance of unrelated dynamic utility families.

## Approaches

1. **Index and group synchronous CSSOM writes.** Cache rules and properties by selector and apply declarations together. This reduces lookup work and preserves synchronous style availability, but a very large batch can still block one task.
2. **Queue and flush incrementally.** Coalesce declarations and process a bounded amount of work per animation frame. This keeps the browser responsive during large bursts, but classes in later chunks receive styles progressively.
3. **Only render the Showcase sample in chunks.** This is a narrow workaround and leaves large color batches from other consumers slow.

Use approaches 1 and 2 together. Approach 3 is unnecessary if the shared injector can spread a large batch across frames.

## Proposed behavior

- Keep an index of owned CSS rules and their property values, plus a one-time index of accessible document rules and declared properties. Refresh the document index when the stylesheet list changes.
- Coalesce pending declarations by selector and property, and apply each selector's declarations together, so one selector is inserted once and repeated color-family mappings are deduplicated.
- Apply the first 128 changed declarations synchronously. When a burst exceeds that budget, schedule the remaining declarations in slices of at most 256 per `requestAnimationFrame` and continue until the queue is empty.
- Return the existing class names immediately. During a large burst, some classes may be present in the DOM before their declarations have been applied; they become styled as their queued chunk is flushed.
- Preserve the current synchronous path for ordinary, isolated utility requests.

## Verification

- Add GWT tests for rule deduplication, property grouping, queue ordering, and multi-frame draining.
- Open the Showcase Colors route in Chrome and confirm it paints progressively without one long injection task, while every palette eventually has the same styles as before.
