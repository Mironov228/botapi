package ru.gleb.company.model.mapper;

import ru.gleb.company.model.PreCheckoutQuery;
import org.json.JSONObject;

public class PreCheckoutQueryMapper {
	public static PreCheckoutQuery map(JSONObject obj) {
		if (obj == null) return null;
		PreCheckoutQuery preCheckoutQuery = new PreCheckoutQuery();
		preCheckoutQuery.setId(obj.getString("id"));
		preCheckoutQuery.setFrom(UserMapper.map(obj.getJSONObject("from")));
		preCheckoutQuery.setCurrency(obj.getString("currency"));
		preCheckoutQuery.setTotalAmount(obj.getInt("total_amount"));
		preCheckoutQuery.setInvoicePayload(obj.getString("invoice_payload"));
		preCheckoutQuery.setOrderInfo(OrderInfoMapper.map(obj.getJSONObject("order_info")));
		return preCheckoutQuery;
	}
}