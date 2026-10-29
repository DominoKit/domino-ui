# Upstream data

The bundled variable font and complete ligature codepoint catalog (4,304 names)
are from Google's `google/material-design-icons` repository at commit
`10ecc14790612ca8fd164e3f4ffe9c16fc50d5b7`. The icon set is covered by
`LICENSE-UPSTREAM.txt` (Apache 2.0). The renderer uses exact ligature names and
exposes the FILL, wght, GRAD, and opsz font axes.

Category assignments were snapshotted on 2026-10-26 from Google's icon metadata
endpoint and checked in at
`src/main/resources/META-INF/icons/material-symbols-categories.json`. The snapshot produces 18 categories. The 372 pinned ligatures absent from that
metadata are assigned to `Other`, so all
4,304 names remain available through category factory interfaces.
