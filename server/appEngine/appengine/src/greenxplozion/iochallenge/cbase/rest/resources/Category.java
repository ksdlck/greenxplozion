package greenxplozion.iochallenge.cbase.rest.resources;

import java.io.Serializable;
import java.util.Map;

import com.google.appengine.api.datastore.Key;

public class Category implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 7091663694798192740L;

	private Key key;

	private Map<String, String> names;

	public String getLocalizedName(String language) {
		return names.get(language);
	}

	public Category(Map<String, String> names) {
		super();
		this.names = names;
	}

	public Category(Key key, Map<String, String> names) {
		super();
		this.key = key;
		this.names = names;
	}

	public Key getKey() {
		return key;
	}

	public Map<String, String> getNames() {
		return names;
	}
	
}
