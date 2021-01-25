package ru.gleb.company.model.mapper;

import ru.gleb.company.model.ChosenInlineResult;
import org.json.JSONObject;

public class ChosenInlineResultMapper {
	public static ChosenInlineResult map(JSONObject obj) {
		if (obj == null) return null;
		ChosenInlineResult chosenInlineResult = new ChosenInlineResult();

		chosenInlineResult.setResultId(obj.getString("result_id"));
		chosenInlineResult.setFrom(UserMapper.map(obj.getJSONObject("from")));
		chosenInlineResult.setLocation(LocationMapper.map(obj.getJSONObject("location")));
		chosenInlineResult.setQuery(obj.getString("query"));

		return chosenInlineResult;
	}
}