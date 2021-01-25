package ru.gleb.company.model.mapper;

import ru.gleb.company.model.InlineQuery;
import org.json.JSONObject;

public class InlineQueryMapper {
	public static InlineQuery map(JSONObject obj) {
		if (obj == null) return null;
		InlineQuery inlineQuery = new InlineQuery();

		inlineQuery.setId(obj.getString("id"));
		inlineQuery.setFrom(UserMapper.map(obj.getJSONObject("from")));
		inlineQuery.setLocation(LocationMapper.map(obj.optJSONObject("location")));
		inlineQuery.setQuery(obj.getString("query"));
		inlineQuery.setOffset(obj.getString("offset"));

		return inlineQuery;
	}
}