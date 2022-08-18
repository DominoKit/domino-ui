:root {
--dui-color:var(--dui-clr-black);
--dui-alternate-color:var(--dui-clr-white);
--dui-text-color: var(--dui-color);
color: var(--dui-color);

<#list colors as color>
    --dui-clr-${color.name}:${color.hex};
</#list>
}
<#list colorsNames as colorName>
.dui[class*="dui-fg-${colorName.name}"]{
    --dui-fg-l-5:var(--dui-clr-${colorName.name}-l-5);
    --dui-fg-l-4:var(--dui-clr-${colorName.name}-l-4);
    --dui-fg-l-3:var(--dui-clr-${colorName.name}-l-3);
    --dui-fg-l-2:var(--dui-clr-${colorName.name}-l-2);
    --dui-fg-l-1:var(--dui-clr-${colorName.name}-l-1);
    --dui-fg:var(--dui-clr-${colorName.name});
    --dui-fg-d-1:var(--dui-clr-${colorName.name}-d-1);
    --dui-fg-d-2:var(--dui-clr-${colorName.name}-d-2);
    --dui-fg-d-3:var(--dui-clr-${colorName.name}-d-3);
    --dui-fg-d-4:var(--dui-clr-${colorName.name}-d-4);
}
.dui[class*="dui-bg-${colorName.name}"]{
    --dui-bg-l-5:var(--dui-clr-${colorName.name}-l-5);
    --dui-bg-l-4:var(--dui-clr-${colorName.name}-l-4);
    --dui-bg-l-3:var(--dui-clr-${colorName.name}-l-3);
    --dui-bg-l-2:var(--dui-clr-${colorName.name}-l-2);
    --dui-bg-l-1:var(--dui-clr-${colorName.name}-l-1);
    --dui-bg:var(--dui-clr-${colorName.name});
    --dui-bg-d-1:var(--dui-clr-${colorName.name}-d-1);
    --dui-bg-d-2:var(--dui-clr-${colorName.name}-d-2);
    --dui-bg-d-3:var(--dui-clr-${colorName.name}-d-3);
    --dui-bg-d-4:var(--dui-clr-${colorName.name}-d-4);

}
.dui[class*="dui-accent-${colorName.name}"]{
    --dui-accent-l-5:var(--dui-clr-${colorName.name}-l-5);
    --dui-accent-l-4:var(--dui-clr-${colorName.name}-l-4);
    --dui-accent-l-3:var(--dui-clr-${colorName.name}-l-3);
    --dui-accent-l-2:var(--dui-clr-${colorName.name}-l-2);
    --dui-accent-l-1:var(--dui-clr-${colorName.name}-l-1);
    --dui-accent:var(--dui-clr-${colorName.name});
    --dui-accent-d-1:var(--dui-clr-${colorName.name}-d-1);
    --dui-accent-d-2:var(--dui-clr-${colorName.name}-d-2);
    --dui-accent-d-3:var(--dui-clr-${colorName.name}-d-3);
    --dui-accent-d-4:var(--dui-clr-${colorName.name}-d-4);
}

</#list>
<#list colors as color>
.dui.dui-fg-${color.name} {
    --dui-fg-clr: var(--dui-clr-${color.name});
    color: var(--dui-clr-${color.name});
}
.dui.dui-bg-${color.name} {
    --dui-bg-clr: var(--dui-clr-${color.name});
    <#if (color.name?ends_with("-l-5") ||  color.name?ends_with("-l-4") || color.name?ends_with("-l-3") || color.name?ends_with("-l-2") || color.name?contains("white")) && color.name?contains("black") == false>
    --dui-text-color: var(--dui-color);
    <#else>
    --dui-text-color: var(--dui-alternate-color);
    </#if>
    background-color: var(--dui-clr-${color.name});
}
.dui.dui-accent-${color.name} {
    --dui-accent-clr: var(--dui-clr-${color.name});
    accent-color: var(--dui-clr-${color.name});
}
.dui.dui-shadow-${color.name} {
    --dui-shadow-clr: var(--dui-clr-${color.name});
}
.dui.dui-text-decoration-${color.name}{
    --dui-text-decoration-clr: var(--dui-clr-${color.name});
    text-decoration-color: var(--dui-clr-${color.name});
}
.dui.dui-border-${color.name}{
    --dui-border-clr: var(--dui-clr-${color.name});
    border-color: var(--dui-clr-${color.name});
}
.dui.dui-border-x-${color.name}{
    --dui-border-x-clr: var(--dui-clr-${color.name});
    border-left-color: var(--dui-clr-${color.name});
    border-right-color: var(--dui-clr-${color.name});
}
.dui.dui-border-y-${color.name}{
    --dui-border-y-clr: var(--dui-clr-${color.name});
    border-top-color: var(--dui-clr-${color.name});
    border-bottom-color: var(--dui-clr-${color.name});
}
.dui.dui-border-t-${color.name}{
    --dui-border-t-clr: var(--dui-clr-${color.name});
    border-top-color: var(--dui-clr-${color.name});
}
.dui.dui-border-r-${color.name}{
    --dui-border-r-clr: var(--dui-clr-${color.name});
    border-right-color: var(--dui-clr-${color.name});
}
.dui.dui-border-b-${color.name}{
    --dui-border-b-clr: var(--dui-clr-${color.name});
    border-bottom-color: var(--dui-clr-${color.name});
}
.dui.dui-border-l-${color.name}{
    --dui-border-l-clr: var(--dui-clr-${color.name});
    border-left-color: var(--dui-clr-${color.name});
}
.dui.dui-divide-${color.name} > * + *{
    --dui-border-clr: var(--dui-clr-${color.name});
    border-color: var(--dui-clr-${color.name});
}
.dui.dui-outline-${color.name}{
    --dui-outline-clr: var(--dui-clr-${color.name});
    outline-color: var(--dui-clr-${color.name});
}
</#list>
