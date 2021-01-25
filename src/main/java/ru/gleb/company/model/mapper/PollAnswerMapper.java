package ru.gleb.company.model.mapper;

import ru.gleb.company.model.PollAnswer;
import org.json.JSONObject;
import org.json.JSONArray;

public class PollAnswerMapper {

	private static int[] getIntArray(JSONArray array) {
		int[] outputArr = new int[array.length()];
		for (int i = 0; i < outputArr.length; i++)
			outputArr[i] = array.getInt(i);
		return outputArr;
	}

	public static PollAnswer map(JSONObject obj) {
		if (obj == null) return null;
		PollAnswer pollAnswer = new PollAnswer();
		pollAnswer.setPollId(obj.getString("poll_id"));
		pollAnswer.setUser(UserMapper.map(obj.getJSONObject("user")));
		pollAnswer.setOptionIds(getIntArray(obj.getJSONArray("option_ids")));
		return pollAnswer;
	}
}