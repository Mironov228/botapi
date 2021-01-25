package ru.gleb.company.model.mapper;

import ru.gleb.company.model.Poll;
import ru.gleb.company.model.PollOption;
import ru.gleb.company.model.MessageEntity;
import org.json.JSONObject;

public class PollMapper {
	public static Poll map(JSONObject obj) {
		if (obj == null) return null;

		Poll poll = new Poll();
		poll.setId(obj.getString("id"));
		poll.setQuestion(obj.getString("question"));
		poll.setOptions(Mapper.mapArray(obj.getJSONArray("options"), PollOptionMapper::map, PollOption.class));
		poll.setTotalVoterCount(obj.getInt("total_voter_count"));
		poll.setClosed(obj.getBoolean("is_closed"));
		poll.setAnonymous(obj.getBoolean("is_anonymous"));
		poll.setType(obj.getString("type"));
		poll.setAllowsMultipleAnswers(obj.getBoolean("allows_multiple_answers"));
		poll.setCorrectOptionId(obj.optInt("correct_option_id"));
		poll.setExplanation(obj.optString("explanation"));
		poll.setExplanationEntities(Mapper.mapArray(obj.optJSONArray("explanation_entities"), MessageEntityMapper::map, MessageEntity.class));
		poll.setOpenPeriod(obj.optInt("open_period"));
		poll.setCloseDate(obj.optInt("close_date"));

		return poll;
	}
}