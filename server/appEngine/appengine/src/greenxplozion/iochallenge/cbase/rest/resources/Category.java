package greenxplozion.iochallenge.cbase.rest.resources;

import java.util.Map;

public class Category {

	private String key;

	private Map<String, String> names;

	public String getLocalizedName(String language) {
		return names.get(language);
	}

	public Category(Map<String, String> names) {
		super();
		this.names = names;
	}

	public Category(String key, Map<String, String> names) {
		super();
		this.key = key;
		this.names = names;
	}

	public String getKey() {
		return key;
	}

	public Map<String, String> getNames() {
		return names;
	}
	
}
