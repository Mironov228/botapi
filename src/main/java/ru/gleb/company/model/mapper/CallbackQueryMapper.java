package ru.gleb.company.model.mapper;

import ru.gleb.company.model.CallbackQuery;
import org.json.JSONObject;

public class CallbackQueryMapper {
	public static CallbackQuery map(JSONObject obj) {
		if (obj == null) return null;
		CallbackQuery callbackQuery = new CallbackQuery();

		callbackQuery.setId(obj.getString("id"));
		callbackQuery.setFrom(UserMapper.map(obj.getJSONObject("from")));
		callbackQuery.setMessage(MessageMapper.map(obj.optJSONObject("message")));
		callbackQuery.setInlineMessageId(obj.optString("inline_message_id"));
		callbackQuery.setData(obj.optString("data"));
		callbackQuery.setChatInstance(obj.optString("chat_instance"));
		callbackQuery.setGameShortName(obj.optString("game_short_name"));

		return callbackQuery;
	}
}