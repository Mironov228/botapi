package ru.gleb.company.model.mapper;

import java.lang.reflect.Array;
import org.json.JSONObject;
import org.json.JSONArray;

public interface Mapper<T> {
	T map(JSONObject obj);

	static <K> K[] mapArray(JSONArray arr, Mapper<? extends K> mapper, Class<K> clazz) {
		if (arr == null) return null;
		K[] mappedArray = (K[]) Array.newInstance(clazz, arr.length());
		for (int i = 0; i < arr.length(); i++) {
			mappedArray[i] = mapper.map(arr.getJSONObject(i));
		}
		return mappedArray;
	}
}