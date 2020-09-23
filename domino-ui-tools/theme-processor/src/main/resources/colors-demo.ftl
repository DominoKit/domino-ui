<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Title</title>

    <style>
        .container {
            width: 500px;
            display: flex;
            flex-direction: column;
        }

        .item {
            flex-grow: 1;
            height: 100px;
            width: 500px;
            text-align: center;
            line-height: 100px;
            color: white;
        }
    </style>
    <link rel="stylesheet" href="${colorSetName?lower_case}-color.css">
</head>
<body>

<#list colors as color>
<div class="container">
    <div class="item bg-l-5-${color.name?lower_case}">${color.name?lower_case}-ligthen-5 : ${color.hex_lighten_5}</div>
    <div class="item bg-l-4-${color.name?lower_case}">${color.name}-ligthen-4 : ${color.hex_lighten_4}</div>
    <div class="item bg-l-3-${color.name?lower_case}">${color.name}-ligthen-3 : ${color.hex_lighten_3}</div>
    <div class="item bg-l-2-${color.name?lower_case}">${color.name}-ligthen-2 : ${color.hex_lighten_2}</div>
    <div class="item bg-l-1-${color.name?lower_case}">${color.name}-ligthen-1 : ${color.hex_lighten_1}</div>
    <div class="item bg-${color.name?lower_case}">${color.name} : ${color.hex}</div>
    <div class="item bg-d-1-${color.name?lower_case}">${color.name}-darken-1 : ${color.hex_darken_1}</div>
    <div class="item bg-d-2-${color.name?lower_case}">${color.name}-darken-2 : ${color.hex_darken_2}</div>
    <div class="item bg-d-3-${color.name?lower_case}">${color.name}-darken-3 : ${color.hex_darken_3}</div>
    <div class="item bg-d-4-${color.name?lower_case}">${color.name}-darken-4 : ${color.hex_darken_4}</div>
</div>
</#list>

</body>
</html>