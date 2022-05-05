:root {
<#list colors as color>
    --dui-clr-${color.name}:${color.hex};
</#list>
}
<#list colorsNames as colorName>
.dui[class*="dui-fg-${colorName.name}-"]{
    --dui-fg-50:var(--dui-clr-${colorName.name}-50);
    --dui-fg-100:var(--dui-clr-${colorName.name}-100);
    --dui-fg-200:var(--dui-clr-${colorName.name}-200);
    --dui-fg-300:var(--dui-clr-${colorName.name}-300);
    --dui-fg-400:var(--dui-clr-${colorName.name}-400);
    --dui-fg-500:var(--dui-clr-${colorName.name}-500);
    --dui-fg-600:var(--dui-clr-${colorName.name}-600);
    --dui-fg-700:var(--dui-clr-${colorName.name}-700);
    --dui-fg-800:var(--dui-clr-${colorName.name}-800);
    --dui-fg-900:var(--dui-clr-${colorName.name}-900);
    --dui-fg-a100:var(--dui-clr-${colorName.name}-a100);
    --dui-fg-a200:var(--dui-clr-${colorName.name}-a200);
    --dui-fg-a400:var(--dui-clr-${colorName.name}-a400);
    --dui-fg-a700:var(--dui-clr-${colorName.name}-a700);
}
.dui[class*="dui-bg-${colorName.name}-"]{
    --dui-bg-50:var(--dui-clr-${colorName.name}-50);
    --dui-bg-100:var(--dui-clr-${colorName.name}-100);
    --dui-bg-200:var(--dui-clr-${colorName.name}-200);
    --dui-bg-300:var(--dui-clr-${colorName.name}-300);
    --dui-bg-400:var(--dui-clr-${colorName.name}-400);
    --dui-bg-500:var(--dui-clr-${colorName.name}-500);
    --dui-bg-600:var(--dui-clr-${colorName.name}-600);
    --dui-bg-700:var(--dui-clr-${colorName.name}-700);
    --dui-bg-800:var(--dui-clr-${colorName.name}-800);
    --dui-bg-900:var(--dui-clr-${colorName.name}-900);
    --dui-bg-a100:var(--dui-clr-${colorName.name}-a100);
    --dui-bg-a200:var(--dui-clr-${colorName.name}-a200);
    --dui-bg-a400:var(--dui-clr-${colorName.name}-a400);
    --dui-bg-a700:var(--dui-clr-${colorName.name}-a700);
}
.dui[class*="dui-accent-${colorName.name}-"]{
    --dui-accent-50:var(--dui-clr-${colorName.name}-50);
    --dui-accent-100:var(--dui-clr-${colorName.name}-100);
    --dui-accent-200:var(--dui-clr-${colorName.name}-200);
    --dui-accent-300:var(--dui-clr-${colorName.name}-300);
    --dui-accent-400:var(--dui-clr-${colorName.name}-400);
    --dui-accent-500:var(--dui-clr-${colorName.name}-500);
    --dui-accent-600:var(--dui-clr-${colorName.name}-600);
    --dui-accent-700:var(--dui-clr-${colorName.name}-700);
    --dui-accent-800:var(--dui-clr-${colorName.name}-800);
    --dui-accent-900:var(--dui-clr-${colorName.name}-900);
    --dui-accent-a100:var(--dui-clr-${colorName.name}-a100);
    --dui-accent-a200:var(--dui-clr-${colorName.name}-a200);
    --dui-accent-a400:var(--dui-clr-${colorName.name}-a400);
    --dui-accent-a700:var(--dui-clr-${colorName.name}-a700);
}

</#list>
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
