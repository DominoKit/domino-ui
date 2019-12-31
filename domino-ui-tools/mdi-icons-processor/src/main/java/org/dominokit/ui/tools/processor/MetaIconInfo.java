package org.dominokit.ui.tools.processor;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.dominokit.jacksonapt.annotation.JSONMapper;

import java.util.List;

@JSONMapper
public class MetaIconInfo {
	@JsonIgnore
	private String id;
	private String name;
	private String codepoint;
	private List<String> aliases;
	private List<String> tags;
	private String author;
	private String version;
	private boolean deprecated;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCodepoint() {
		return codepoint;
	}

	public void setCodepoint(String codepoint) {
		this.codepoint = codepoint;
	}

	public List<String> getAliases() {
		return aliases;
	}

	public void setAliases(List<String> aliases) {
		this.aliases = aliases;
	}

	public List<String> getTags() {
		return tags;
	}

	public void setTags(List<String> tags) {
		this.tags = tags;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getVersion() {
		return version;
	}

	public void setVersion(String version) {
		this.version = version;
	}

	public boolean isDeprecated() {
		return deprecated;
	}

	public void setDeprecated(boolean deprecated) {
		this.deprecated = deprecated;
	}
}
