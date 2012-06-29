package greenxplozion.iochallenge.cbase.rest.resources;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import com.google.appengine.api.datastore.DatastoreService;
import com.google.appengine.api.datastore.DatastoreServiceFactory;
import com.google.appengine.api.datastore.Entity;
import com.google.appengine.api.datastore.FetchOptions;
import com.google.appengine.api.datastore.Key;
import com.google.appengine.api.datastore.KeyFactory;
import com.google.appengine.api.datastore.Query;

public class CategoriesGateway {

	private static final String CATEGORY_KEY_NAME = "key";
	private static final String CATEGORY_KIND = "Category";
	private static final String CATEGORY_NAME_PREFIX = "Name_";

	public CategoriesGateway() {
		Key key = KeyFactory.stringToKey("aglub19hcHBfaWRyHAsSCENhdGVnb3J5GAEMCxIIQ2F0ZWdvcnkYEAw");
		
		Map<String, String> localizedNames = new HashMap<String, String>();
		localizedNames.put("de", "Grünes Zeug");
		localizedNames.put("en", "Green stuff");
		Category cat = new Category(key, localizedNames);
		this.save(cat);
		Key key2 = KeyFactory.stringToKey("aglub19hcHBfaWRyHAsSCENhdGVnb3J5GAIMCxIIQ2F0ZWdvcnkYEQw");
		Map<String, String> localizedNames2 = new HashMap<String, String>();
		localizedNames2.put("de", "Blaues Zeug");
		localizedNames2.put("en", "Blue stuff");
		Category cat2 = new Category(key2, localizedNames2);
		this.save(cat2);
		Key key3 = KeyFactory.stringToKey("aglub19hcHBfaWRyHAsSCENhdGVnb3J5GAMMCxIIQ2F0ZWdvcnkYEgw");
		Map<String, String> localizedNames3 = new HashMap<String, String>();
		localizedNames3.put("de", "Alles andere");
		localizedNames3.put("en", "Everything else");
		Category cat3 = new Category(key3, localizedNames3);
		this.save(cat3);

	}

	public void save(Category category) {
		Key key = null;
		if (category.getKey() == null) {
			key = KeyFactory.createKey(CATEGORY_KIND, CATEGORY_KEY_NAME);
		} else {
			key = category.getKey();
		}

		Entity entity = new Entity(CATEGORY_KIND, key);
		for (Entry<String, String> entry : category.getNames().entrySet()) {
			entity.setProperty(CATEGORY_NAME_PREFIX + entry.getKey(),
					entry.getValue());
		}
		DatastoreService service = DatastoreServiceFactory
				.getDatastoreService();
		service.put(entity);
	
	}

	public List<Category> fetchAll() {
		DatastoreService service = DatastoreServiceFactory
				.getDatastoreService();
		Query query = new Query(CATEGORY_KIND);
		List<Entity> entities = service.prepare(query).asList(
				FetchOptions.Builder.withDefaults());
		List<Category> result = new LinkedList<Category>();
		for (Entity entity : entities) {
			Key key = null;
			Map<String, String> localizedNames = new HashMap<String, String>();
			for (Entry<String, Object> property : entity.getProperties()
					.entrySet()) {
				if (CATEGORY_KEY_NAME.equals(property.getKey())) {
					key = (Key) property.getValue();
				}
				if (property.getKey().startsWith(CATEGORY_NAME_PREFIX)) {
					localizedNames.put(
							property.getKey().substring(
									CATEGORY_NAME_PREFIX.length()),
							(String) property.getValue());
				}
			}
			result.add(new Category(key, localizedNames));
		}
		return result;
	}
}
