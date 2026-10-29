# Upstream data

The complete embedded SVG catalog (1,903 icons) is derived from the Lucide
repository at commit `05232756c05e9ca7d5ad267e8694e9afa5d572fa`. It is generated
from upstream `icons/`; the upstream license is recorded in
`LICENSE-UPSTREAM.txt` (ISC). The generated category interfaces use the
`categories` field in each pinned icon metadata file, resulting in 42 generated
categories. Each category enum stores the SVG inline with the named icon
constant. An icon that belongs to multiple categories has its SVG repeated in
each category. Static factories and Domino UI semantic roles resolve through
those enums.
