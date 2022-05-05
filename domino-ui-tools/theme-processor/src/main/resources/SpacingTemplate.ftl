:root {

--dui-font-sans: ui-sans-serif, system-ui, -apple-system, BlinkMacSystemFont, "Segoe UI", Roboto, "Helvetica Neue", Arial, "Noto Sans", sans-serif, "Apple Color Emoji", "Segoe UI Emoji", "Segoe UI Symbol", "Noto Color Emoji";
--dui-font-serif: ui-serif, Georgia, Cambria, "Times New Roman", Times, serif;
--dui-font-mono: ui-monospace, SFMono-Regular, Menlo, Monaco, Consolas, "Liberation Mono", "Courier New", monospace;

<#list spacings as spacig>
    --dui-spc-${spacig.name}:${spacig.value};
</#list>
}
<#list spacings as spacig>
.dui.dui-p-${spacig.name} {
    padding: var(--dui-spc-${spacig.name});
}
.dui.dui-p-x-${spacig.name} {
    padding-left: var(--dui-spc-${spacig.name});
    padding-right: var(--dui-spc-${spacig.name});
}
.dui.dui-p-y-${spacig.name} {
    padding-top: var(--dui-spc-${spacig.name});
    padding-bottom: var(--dui-spc-${spacig.name});
}
.dui.dui-p-t-${spacig.name} {
    padding-top: var(--dui-spc-${spacig.name});
}
.dui.dui-p-r-${spacig.name} {
    padding-right: var(--dui-spc-${spacig.name});
}
.dui.dui-p-b-${spacig.name} {
    padding-bottom: var(--dui-spc-${spacig.name});
}
.dui.dui-p-l-${spacig.name} {
    padding-left: var(--dui-spc-${spacig.name});
}

.dui.dui-m-${spacig.name} {
    margin: var(--dui-spc-${spacig.name});
}
.dui.dui-m-x-${spacig.name} {
    margin-left: var(--dui-spc-${spacig.name});
    margin-right: var(--dui-spc-${spacig.name});
}
.dui.dui-m-y-${spacig.name} {
    margin-top: var(--dui-spc-${spacig.name});
    margin-bottom: var(--dui-spc-${spacig.name});
}
.dui.dui-m-t-${spacig.name} {
    margin-top: var(--dui-spc-${spacig.name});
}
.dui.dui-m-r-${spacig.name} {
    margin-right: var(--dui-spc-${spacig.name});
}
.dui.dui-m-b-${spacig.name} {
    margin-bottom: var(--dui-spc-${spacig.name});
}
.dui.dui-m-l-${spacig.name} {
    margin-left: var(--dui-spc-${spacig.name});
}

.dui.dui-space-x-${spacig.name} > * + * {
    margin-left: var(--dui-spc-${spacig.name});
}
.dui.dui-space-y-${spacig.name} > * + * {
    margin-top: var(--dui-spc-${spacig.name});
}

.dui.dui-w-${spacig.name} {
    width: var(--dui-spc-${spacig.name});
}
.dui.dui-max-w-${spacig.name} {
    max-width: var(--dui-spc-${spacig.name});
}
.dui.dui-min-w-${spacig.name} {
    min-width: var(--dui-spc-${spacig.name});
}

.dui.dui-h-${spacig.name} {
    height: var(--dui-spc-${spacig.name});
}
.dui.dui-max-h-${spacig.name} {
    max-height: var(--dui-spc-${spacig.name});
}
.dui.dui-min-h-${spacig.name} {
    min-height: var(--dui-spc-${spacig.name});
}

.dui.dui-gap-${spacig.name} {
    gap: var(--dui-spc-${spacig.name});
}
.dui.dui-gap-x-${spacig.name} {
    column-gap: var(--dui-spc-${spacig.name});
}
.dui.dui-gap-y-${spacig.name} {
    row-gap: var(--dui-spc-${spacig.name});
}

.dui.dui-inset-${spacig.name} {
    inset: var(--dui-spc-${spacig.name});
}
.dui.dui-inset-x-${spacig.name} {
    left: var(--dui-spc-${spacig.name});
    right: var(--dui-spc-${spacig.name});
}
.dui.dui-inset-y-${spacig.name} {
    top: var(--dui-spc-${spacig.name});
    bottom: var(--dui-spc-${spacig.name});
}
.dui.dui-top-${spacig.name} {
    top: var(--dui-spc-${spacig.name});
}
.dui.dui-right-${spacig.name} {
    right: var(--dui-spc-${spacig.name});
}
.dui.dui-bottom-${spacig.name} {
    bottom: var(--dui-spc-${spacig.name});
}
.dui.dui-left-${spacig.name} {
    left: var(--dui-spc-${spacig.name});
}
.dui.dui-txt-indnt-${spacig.name} {
    text-indent: var(--dui-spc-${spacig.name});
}
.dui.dui-basis-${spacig.name} {
    flex-basis: var(--dui-spc-${spacig.name});
}
</#list>
