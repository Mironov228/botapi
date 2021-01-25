package ru.gleb.company.model.mapper;

import ru.gleb.company.model.User;
import org.json.JSONObject;

public class UserMapper {
	public static User map(JSONObject obj) {
		if (obj == null)
			return null;
		User user = new User();

		user.setId(obj.getInt("id"));
		user.setBot(obj.getBoolean("is_bot"));
		user.setFirstName(obj.getString("first_name"));
		user.setLastName(obj.optString("last_name"));
		user.setUsername(obj.optString("username"));
		user.setLanguageCode(obj.optString("language_code"));
		
		return user;
	}
}