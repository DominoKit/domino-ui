package org.dominokit.domino.ui.icons;

import java.util.ArrayList;
import java.util.List;

public class MdiMeta {

    private final String name;
    private final String codepoint;
    private final List<String> aliases;
    private final List<String> tags;
    private final String author;
    private final String version;



    public MdiMeta(String name, String codepoint, List<String> aliases, List<String> tags, String author, String version) {
        this.name = name;
        this.codepoint = codepoint;
        this.aliases = aliases;
        this.tags = tags;
        this.author = author;
        this.version = version;
    }

    MdiMeta(String name){
        this( name, "", new ArrayList<>(), new ArrayList<>(), "", "");
    }

    public String getName() {
        return name;
    }

    public String getCodepoint() {
        return codepoint;
    }

    public List<String> getAliases() {
        return aliases;
    }

    public List<String> getTags() {
        return tags;
    }

    public String getAuthor() {
        return author;
    }

    public String getVersion() {
        return version;
    }
}
