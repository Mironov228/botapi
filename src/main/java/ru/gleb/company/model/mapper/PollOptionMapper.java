package ru.gleb.company.model.mapper;

import ru.gleb.company.model.PollOption;
import org.json.JSONObject;

public class PollOptionMapper {
	public static PollOption map(JSONObject obj) {
		if (obj == null) return null;
		PollOption pollOption = new PollOption();
		pollOption.setText(obj.getString("text"));
		pollOption.setVoterCount(obj.getInt("voter_count"));
		return pollOption;
	}
}