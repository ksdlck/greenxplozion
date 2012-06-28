package greenxplozion.iochallenge.cbase.rest.resources;

import java.util.List;
import java.util.Map.Entry;

import com.google.appengine.api.datastore.DatastoreService;
import com.google.appengine.api.datastore.DatastoreServiceFactory;
import com.google.appengine.api.datastore.Entity;
import com.google.appengine.api.datastore.Key;
import com.google.appengine.api.datastore.KeyFactory;

public class CategoriesGateway {

	private static final String CATEGORY_KEY_NAME = "key";
	private static final String CATEGORY_KIND = "Category";
	private static final String CATEGORY_NAME_PREFIX = "Name_";

	public void save(Category category) {

		Key key = KeyFactory.createKey(CATEGORY_KIND, CATEGORY_KEY_NAME);
		Entity entity = new Entity(CATEGORY_KIND, key);
		for (Entry<String, String> entry : category.getNames().entrySet()) {
			entity.setProperty(CATEGORY_NAME_PREFIX + entry.getKey(),
					entry.getValue());
		}
		DatastoreService service = DatastoreServiceFactory.getDatastoreService();
		service.put(entity);
	}

	public List<Category> fetchAll() {
		return null;
	}
}
