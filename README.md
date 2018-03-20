<a title="Gitter" href="https://gitter.im/domino-gwt/domino-ui"><img src="https://badges.gitter.im/Join%20Chat.svg"></a>

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

<link type="text/css" rel="stylesheet" href="/{module-short-name}/font/material-icons.css">
<link type="text/css" rel="stylesheet" href="/{module-short-name}/plugins/bootstrap/css/bootstrap.css">
<link type="text/css" rel="stylesheet" href="/{module-short-name}/plugins/node-waves/waves.css">
<link type="text/css" rel="stylesheet" href="/{module-short-name}/plugins/animate-css/animate.css">
<link type="text/css" rel="stylesheet" href="/{module-short-name}/plugins/waitme/waitMe.css">
<link type="text/css" rel="stylesheet" href="/{module-short-name}/css/style.css">
<link type="text/css" rel="stylesheet" href="/{module-short-name}/css/themes/all-themes.css">
<script src="/{module-short-name}/plugins/node-waves/waves.js" type="text/javascript"></script>
```
> The dependency on the waves.js will be removed very soon.

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
