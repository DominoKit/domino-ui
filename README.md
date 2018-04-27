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

### GWT module interitence
```xml
<inherits name="org.dominokit.domino.ui.DominoUI"/>
```

### Css

```html
<meta content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no" name="viewport">

<link type="text/css" rel="stylesheet" href="/static/font/material-icons.css">
<link type="text/css" rel="stylesheet" href="/static/plugins/bootstrap/css/bootstrap.css">
<link type="text/css" rel="stylesheet" href="/static/plugins/node-waves/waves.css">
<link type="text/css" rel="stylesheet" href="/static/plugins/animate-css/animate.css">
<link type="text/css" rel="stylesheet" href="/static/plugins/waitme/waitMe.css">
<link type="text/css" rel="stylesheet" href="/static/plugins/bootstrap-select/css/bootstrap-select.css">
<link type="text/css" rel="stylesheet" href="/static/css/materialize.css">
<link type="text/css" rel="stylesheet" href="/static/css/style.css">
<link type="text/css" rel="stylesheet" href="/static/css/themes/all-themes.css">
```

----------------------
## Domino-ui Release 1.0 Road map

> Checked item are already completed

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
- [ ] Time picker - **in progress**
- [ ] Date time picker
- [ ] Inputs decorations : Labels, Helper text, validation, Icons
- [ ] Input groups
- [ ] Advanced Select
- [ ] Multi-Select
- [ ] Tag field
- [ ] Spinners
- [ ] Field masking
- [ ] Simple grids - Table based -
- [ ] Form wizards / Steppers
- [ ] Carousel
- [ ] Sliders

### Third Party libs and tools integration

- [ ] make sure that domino-ui can be used with other third party tools and libs, this might indicate a standarized API and split between the builders and actual element class.

Sample of third party tools and frameworks:
- Editors framework.
- UI Binder

### Restructure CSS and Themeing

- [ ] Restructure the CSS allowing easy themeing, writing a new theme by the uusers should be easy.

- [ ] Simplify the injection of the css resources.

### Java docs

- [ ] Make sure all domino-ui classes has the proper JavaDocs.


### Documentation

- [ ] Create a full documentation describing how to use domino-ui, setup a project, and document each element/component on its own, this could be in github pages.

### Build Samples

- [ ] Implement a 3 different samples with different types of contents, the samples should try to use most of the avialable components.
---------------------------

## Sample

```java
Column column = Column.create()
        .onLarge(Column.OnLarge.four)
        .onMedium(Column.OnMedium.four)
        .onSmall(Column.OnSmall.twelve)
        .onXSmall(Column.OnXSmall.twelve);

DomGlobal.document.body.appendChild(Row.create()
        .addColumn(column.copy()
                .addElement(Card.create("CARD TITLE", "Card description")
                        .appendContent(Paragraph.create("I love domino-ui, domino-ui does not use jquery or js and is typesafe, I love domino-ui, domino-ui does not use jquery or js and is typesafe, I love domino-ui, domino-ui does not use jquery or js and is typesafe")
                                .asElement())
                        .setHeaderBackground(Background.BLUE)
                        .setBodyBackground(Background.LIGHT_BLUE)
                        .asElement()))
        .addColumn(column.copy()
                .addElement(Card.create("CARD TITLE", "Card description")
                        .appendContent(Paragraph.create("I love domino-ui, domino-ui does not use jquery or js and is typesafe, I love domino-ui, domino-ui does not use jquery or js and is typesafe, I love domino-ui, domino-ui does not use jquery or js and is typesafe")
                                .asElement())
                        .setHeaderBackground(Background.GREEN)
                        .setBodyBackground(Background.LIGHT_GREEN)
                        .asElement()))
        .addColumn(column.copy()
                .addElement(Card.create("CARD TITLE", "Card description")
                        .appendContent(Paragraph.create("I love domino-ui, domino-ui does not use jquery or js and is typesafe, I love domino-ui, domino-ui does not use jquery or js and is typesafe, I love domino-ui, domino-ui does not use jquery or js and is typesafe")
                                .asElement())
                        .setHeaderBackground(Background.ORANGE)
                        .setBodyBackground(Background.AMBER)
                        .asElement()))
        .asElement());
```
![Imgur](https://i.imgur.com/xaUJXi9.png)
