<a title="Gitter" href="https://gitter.im/domino-gwt/domino-ui"><img src="https://badges.gitter.im/Join%20Chat.svg"></a>
[![Build Status](https://travis-ci.org/DominoKit/domino-ui.svg?branch=master)](https://travis-ci.org/DominoKit/domino-ui)
[![Maven Central](https://maven-badges.herokuapp.com/maven-central/org.dominokit/domino-ui/badge.svg)](https://maven-badges.herokuapp.com/maven-central/org.dominokit/domino-ui)
![Sonatype Nexus (Snapshots)](https://img.shields.io/nexus/s/https/oss.sonatype.org/org.dominokit/domino-ui.svg)


# Domino-ui

A type safe material design with bootstrap builder for java developer with GWT without dependencies on external JavaScript.

## Demo app

[Domino-ui Demo app](https://vegegoku.github.io/domino-ui/index.html?theme=indigo#home)

## Setup

### Maven dependency

```xml
<dependency>
  <groupId>org.dominokit</groupId>
  <artifactId>domino-ui</artifactId>
  <version>1.0-SNAPSHOT</version>
</dependency>
<dependency>
  <groupId>org.dominokit</groupId>
  <artifactId>domino-ui</artifactId>
  <version>1.0-SNAPSHOT</version>
  <classifier>sources</classifier>
</dependency>
```

> To use the snapshot version without building locally, configure the snapshot repository
```xml
<repository>
   <id>sonatype-snapshots-repo</id>
   <url>https://oss.sonatype.org/content/repositories/snapshots</url>
   <snapshots>
      <enabled>true</enabled>
      <updatePolicy>always</updatePolicy>
      <checksumPolicy>fail</checksumPolicy>
   </snapshots>
</repository>
```

### GWT module inheritance
```xml
<inherits name="org.dominokit.domino.ui.DominoUI"/>
```

### Css
Add the following css files to your index page:
> Replace [module-short-name] with the proper module name.
```html
<meta content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no" name="viewport">

<link type="text/css" rel="stylesheet" href="{module-short-name}/css/domino-ui.css">
<link type="text/css" rel="stylesheet" href="{module-short-name}/css/themes/all-themes.css">
```

----------------------
## Domino-ui Release 1.0 Road map

> Checked items are already completed

### Build All basic components :

- [x] Cards
- [x] Info box
- [x] Buttons
- [x] Alerts
- [x] Badges
- [x] Labels
- [x] Modals
- [x] Lists
- [x] Loaders
- [x] Icons
- [x] Breadcrumbs
- [x] Collapse
- [x] Notifications
- [x] Media Objects
- [x] Pagination
- [x] Preloaders
- [x] Progress bars
- [x] Tabs
- [x] Thumbnails
- [x] Dialogs
- [x] Tooltips and Popovers
- [x] Waves
- [x] Typography
- [x] Helper classes
- [x] Colors
- [x] Animations
- [x] File upload
- [x] Date picker
- [x] Time picker
- [ ] Date time picker
- [x] Inputs decorations : Labels, Helper text, validation, Icons
- [x] Advanced Select
- [ ] Multi-Select
- [x] Tag field
- [x] Spinners
- [ ] Field masking
- [x] Simple grids - Table based -
- [x] Form wizards / Steppers
- [x] Carousel
- [x] Sliders
- [x] Chips
- [x] Tree

### Third Party libs and tools integration

- [ ] make sure that domino-ui can be used with other third party tools and libs, this might indicate a standarized API and split between the builders and actual element class.

Sample of third party tools and frameworks:
- [x] Editors framework.
- [ ] UI Binder

### Restructure CSS and Theming

- [ ] Restructure the CSS allowing easy theming, writing a new theme by the users should be easy.

- [ ] Simplify the injection of the css resources.

### Java docs

- [ ] Make sure all Domino-ui classes has the proper JavaDocs.


### Documentation

- [ ] Create a full documentation describing how to use Domino-ui, setup a project and document each element/component on its own, this could be in github pages.

### Build Samples

- [ ] Implement three samples with different types of contents, the samples should try to use most of the available components.
---------------------------

## Sample

```java

DomGlobal.document.body.appendChild(Row.create()
        .addColumn(Column.span4()
                .appendChild(Card.create("CARD TITLE", "Card description")
                        .appendChild(Paragraph.create("I love Domino-ui, Domino-ui does not use jquery or js and is typesafe, I love Domino-ui, Domino-ui does not use jquery or js and is typesafe, I love Domino-ui, Domino-ui does not use jquery or js and is typesafe")
                                .asElement())
                        .setHeaderBackground(Color.BLUE)
                        .setBodyBackground(Color.LIGHT_BLUE)
                        .asElement()))
        .addColumn(Column.span4()
                .appendChild(Card.create("CARD TITLE", "Card description")
                        .appendChild(Paragraph.create("I love Domino-ui, Domino-ui does not use jquery or js and is typesafe, I love Domino-ui, Domino-ui does not use jquery or js and is typesafe, I love Domino-ui, Domino-ui does not use jquery or js and is typesafe")
                                .asElement())
                        .setHeaderBackground(Color.GREEN)
                        .setBodyBackground(Color.LIGHT_GREEN)
                        .asElement()))
        .addColumn(Column.span4()
                .appendChild(Card.create("CARD TITLE", "Card description")
                        .appendChild(Paragraph.create("I love Domino-ui, Domino-ui does not use jquery or js and is typesafe, I love Domino-ui, Domino-ui does not use jquery or js and is typesafe, I love Domino-ui, Domino-ui does not use jquery or js and is typesafe")
                                .asElement())
                        .setHeaderBackground(Color.ORANGE)
                        .setBodyBackground(Color.AMBER)
                        .asElement()))
        .asElement());
```
![Imgur](https://i.imgur.com/xaUJXi9.png)
