![logoimage](https://raw.githubusercontent.com/DominoKit/DominoKit.github.io/master/logo/128.png)

<a title="Element" href="https://matrix.to/#/!togTvnNghqSNrVUADf:gitter.im/$7O8oKWAuTu2r0KolsY73ee6SrV-fu8uxzudbz_aG95w?via=gitter.im&via=matrix.org&via=t2bot.io"><img src="https://badges.gitter.im/Join%20Chat.svg"></a>
[![Development Build Status](https://github.com/DominoKit/domino-ui/actions/workflows/deploy.yaml/badge.svg?branch=development)](https://github.com/DominoKit/domino-ui/actions/workflows/deploy.yaml?branch=development)
![Maven Central](https://maven-badges.herokuapp.com/maven-central/org.dominokit/domino-ui/badge.svg)
![Sonatype Nexus (Snapshots)](https://img.shields.io/badge/Snapshot-HEAD--SNAPSHOT-orange)
![GWT3/J2CL compatible](https://img.shields.io/badge/GWT3/J2CL-compatible-brightgreen.svg)

# Domino-UI

Domino-UI is a type-safe, fluent Java UI component library that compiles to JavaScript GWT. It lets Java teams build modern UIs without external JavaScript dependencies, while keeping IDE refactoring, static typing, and a consistent API across components.

## Why Domino-UI
- Fluent, structured composition that mirrors HTML hierarchies.
- Rich component set (datatable, forms, layouts, menus, dialogs, etc.).
- Strong typing and refactoring safety for large Java codebases.
- Works with GWT/Java without runtime JavaScript dependencies.
- Configurable themes, CSS utilities, and MDI icon integration.

## Quick glance:
Domino-UI code should read like the HTML structure while staying debuggable. The preferred style initializes complex children first, then composes the tree fluently.

```java
TextBox userName = TextBox.create("User name")
    .setRequired(true)
    .setAutoValidation(true);

TextBox password = TextBox.password("Password")
    .setRequired(true)
    .setAutoValidation(true);

Button login = Button.create(Icons.lock_open())
    .setBackground(Color.THEME)
    .setContent("Login")
    .block();

Card.create("LOGIN")
    .appendChild(userName)
    .appendChild(password)
    .appendChild(login);
```

## Theming

Domino UI supports composable color modes, accents, visual identities, character styles, density,
surface treatments, and component-level emphasis modifiers. Optional themes can be loaded as one
bundle or as individual CSS files, while all theme selectors remain scoped to a `.dui` root.

See the complete guide in [theming.md](THEMING.md), including the available theme catalog, Java
descriptors, subset-loading examples, composition rules, CSS isolation guidance, contrast
recommendations, emphasis modifiers, and the separate role of the WaitMe animation stylesheet.

## Links
- Introduction: https://dominokit.com/solutions/domino-ui/v2
- Getting started: https://dominokit.com/solutions/domino-ui/v2/docs/getting-started
- Demo app: https://dominokit.com/domino-ui/demo/v2/home

## License
[Apache License 2.0](https://github.com/DominoKit/domino-ui/blob/master/LICENSE)
