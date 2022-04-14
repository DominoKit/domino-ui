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
.dui.dui-accent-${color.name} {
    accent-color: var(--dui-clr-${color.name});
}
.dui.dui-shadow-${color.name} {
    --dui-shadow-clr: var(--dui-clr-${color.name});
}
.dui.dui-text-decoration-${color.name}{
    text-decoration-color: var(--dui-clr-${color.name});
}
.dui.dui-border-${color.name}{
    border-color: var(--dui-clr-${color.name});
}
.dui.dui-border-x-${color.name}{
    border-left-color: var(--dui-clr-${color.name});
    border-right-color: var(--dui-clr-${color.name});
}
.dui.dui-border-y-${color.name}{
    border-top-color: var(--dui-clr-${color.name});
    border-bottom-color: var(--dui-clr-${color.name});
}
.dui.dui-border-t-${color.name}{
    border-top-color: var(--dui-clr-${color.name});
}
.dui.dui-border-r-${color.name}{
    border-right-color: var(--dui-clr-${color.name});
}
.dui.dui-border-b-${color.name}{
    border-bottom-color: var(--dui-clr-${color.name});
}
.dui.dui-border-l-${color.name}{
    border-left-color: var(--dui-clr-${color.name});
}
.dui.dui-divide-${color.name} > * + *{
    border-color: var(--dui-clr-${color.name});
}
.dui.dui-outline-${color.name}{
    outline-color: var(--dui-clr-${color.name});
}
</#list>
