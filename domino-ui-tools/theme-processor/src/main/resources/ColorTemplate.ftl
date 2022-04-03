:root {
<#list colors as color>
    --dui-clr-${color.name}:${color.hex};
</#list>
}
<#list colors as color>
.dui.dui-fg-${color.name} {
    color: var(--dui-clr-${color.name});
}
.dui.dui-bg-${color.name} {
    background-color: var(--dui-clr-${color.name});
}
.dui.dui-text-decoration-color{
    text-decoration-color:  var(--dui-clr-${color.name});
}
</#list>
