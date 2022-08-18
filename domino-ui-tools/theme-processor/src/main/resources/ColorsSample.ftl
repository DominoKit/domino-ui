<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Title</title>
    <link rel="stylesheet" href="./colors.css">

    <style>
        .color-row {
            display: grid;
            grid-template-columns: repeat(10, 1fr);
            min-height: 100px;
        }

        .color-box {
            text-align: center;
            color: var(--dui-text-color);
            line-height: 100px;
        }

    </style>
</head>
<body>
<#list colorsNames as colorName>
<div class="color-row">
    <div class="dui dui-bg-${colorName.name}-l-5 color-box">
        <span>${colorName.name}-l-5</span>
    </div>
    <div class="dui dui-bg-${colorName.name}-l-4 color-box">
        <span>${colorName.name}-l-4</span>
    </div>
    <div class="dui dui-bg-${colorName.name}-l-3 color-box">
        <span>${colorName.name}-l-3</span>
    </div>
    <div class="dui dui-bg-${colorName.name}-l-2 color-box">
        <span>${colorName.name}-l-2</span>
    </div>
    <div class="dui dui-bg-${colorName.name}-l-1 color-box">
        <span>${colorName.name}-l-1</span>
    </div>
    <div class="dui dui-bg-${colorName.name} color-box">
        <span>${colorName.name}</span>
    </div>
    <div class="dui dui-bg-${colorName.name}-d-1 color-box">
        <span>${colorName.name}-d-1</span>
    </div>
    <div class="dui dui-bg-${colorName.name}-d-2 color-box">
        <span>${colorName.name}-d-2</span>
    </div>
    <div class="dui dui-bg-${colorName.name}-d-3 color-box">
        <span>${colorName.name}-d-3</span>
    </div>
    <div class="dui dui-bg-${colorName.name}-d-4 color-box">
        <span>${colorName.name}-d-4</span>
    </div>
</div>
</#list>
</body>
</html>