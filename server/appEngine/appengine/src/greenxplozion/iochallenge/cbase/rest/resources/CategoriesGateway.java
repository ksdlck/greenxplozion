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
		List<Category> list = this.fetchAll();
		if (list.size() == 0) {
			Map<String, String> localizedNames = new HashMap<String, String>();
			localizedNames.put("de", "Grünes Zeug");
			localizedNames.put("en", "Green stuff");
			Category cat = new Category(
					"aglub19hcHBfaWRyHAsSCENhdGVnb3J5GAEMCxIIQ2F0ZWdvcnkYEAw",
					localizedNames);
			this.save(cat);
			Map<String, String> localizedNames2 = new HashMap<String, String>();
			localizedNames2.put("de", "Blaues Zeug");
			localizedNames2.put("en", "Blue stuff");
			Category cat2 = new Category(
					"aglub19hcHBfaWRyHAsSCENhdGVnb3J5GAIMCxIIQ2F0ZWdvcnkYEQw",
					localizedNames2);
			this.save(cat2);
			Map<String, String> localizedNames3 = new HashMap<String, String>();
			localizedNames3.put("de", "Alles andere");
			localizedNames3.put("en", "Everything else");
			Category cat3 = new Category(
					"aglub19hcHBfaWRyHAsSCENhdGVnb3J5GAMMCxIIQ2F0ZWdvcnkYEgw",
					localizedNames3);
			this.save(cat3);
		}
	}

	public void save(Category category) {
		Key key = null;
		if (category.getKey() == null) {
			key = KeyFactory.createKey(CATEGORY_KIND, CATEGORY_KEY_NAME);
		} else {
			key = KeyFactory.stringToKey(category.getKey());
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
			Key key = entity.getKey();
			Map<String, String> localizedNames = new HashMap<String, String>();
			for (Entry<String, Object> property : entity.getProperties()
					.entrySet()) {
				if (property.getKey().startsWith(CATEGORY_NAME_PREFIX)) {
					localizedNames.put(
							property.getKey().substring(
									CATEGORY_NAME_PREFIX.length()),
							(String) property.getValue());
				}
			}
			result.add(new Category(key.toString(), localizedNames));
		}
		return result;
	}
}
