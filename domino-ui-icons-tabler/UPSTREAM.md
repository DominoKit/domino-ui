# Upstream data

The complete embedded SVG catalogs are derived from the Tabler Icons repository
at commit `a4ce1404bc6d24d3c365afe7b258d6bf6f48d62d`: 5,184 outline icons and
1,054 filled icons. They are generated from upstream `icons/outline/` and
`icons/filled/`; the upstream license is recorded in `LICENSE-UPSTREAM.txt`
(MIT). Category interfaces use each SVG's pinned `category` metadata, producing
41 generated categories. Filled icons inherit their matching outline icon's
category. Category enums store each SVG inline with the named icon constant. An
icon that belongs to multiple categories has its SVG repeated in each category.
Static factories and Domino UI semantic roles resolve through those enums.
