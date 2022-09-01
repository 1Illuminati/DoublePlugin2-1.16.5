package doublePlugin.util.map;

import java.util.HashMap;
import java.util.Map;

public class NotNullStrMap<T> extends HashMap<String, T> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private T normalValue = null;
	
	public static <T> NotNullStrMap<T> getMap(Map<String, T> map) {
		NotNullStrMap<T> notNullStrMap = new NotNullStrMap<T>();
		for(String key : map.keySet()) {
			notNullStrMap.put(key, (T) map.get(key));
		}
		
		return notNullStrMap;
	}

	public void setNormalValue(T normalValue) {
		this.normalValue = normalValue;
	}
	
	@SuppressWarnings("rawtypes")
	public Class getValueClass() {
		return normalValue.getClass();
	}

	public T getNormalValue() {
		return normalValue;
	}

	public T put(String key, T value) {
		return super.put(key, value);
	}

	public T get(String key) {
		if (!super.containsKey(key))
			this.newValue(key);
		return super.get(key);
	}

	private void newValue(String key) {
		if (normalValue == null) {
			throw new NullPointerException("normalValue is null");
		}

		super.put(key, normalValue);
	}
}
