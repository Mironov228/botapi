package ru.gleb.company.model.mapper;

import ru.gleb.company.model.Update;
import org.json.JSONObject;

public class UpdateMapper {
	public static Update map(JSONObject obj) {
		if (obj == null)
			return null;
		Update update = new Update();

		System.out.println(obj);

		update.setUpdateId(obj.getInt("update_id"));
		update.setMessage(MessageMapper.map(obj.optJSONObject("message")));
		update.setEditedMessage(MessageMapper.map(obj.optJSONObject("edited_message")));
		update.setChannelPost(MessageMapper.map(obj.optJSONObject("channel_post")));
		update.setEditedChannelPost(MessageMapper.map(obj.optJSONObject("edited_channel_post")));
		update.setInlineQuery(InlineQueryMapper.map(obj.optJSONObject("inline_query")));
		update.setChosenInlineResult(ChosenInlineResultMapper.map(obj.optJSONObject("chosen_inline_result")));
		update.setCallbackQuery(CallbackQueryMapper.map(obj.optJSONObject("callback_query")));
		update.setShippingQuery(ShippingQueryMapper.map(obj.optJSONObject("shipping_query")));
		update.setPreCheckoutQuery(PreCheckoutQueryMapper.map(obj.optJSONObject("pre_checkout_query")));
		update.setPollAnswer(PollAnswerMapper.map(obj.optJSONObject("poll_answer")));
		
		return update;
	}
}