package ru.gleb.company.model.mapper;

import ru.gleb.company.model.OrderInfo;
import org.json.JSONObject;

public class OrderInfoMapper {
	public static OrderInfo map(JSONObject obj) {
		if (obj == null) return null;
		OrderInfo orderInfo = new OrderInfo();
		orderInfo.setName(obj.optString("name"));
		orderInfo.setPhoneNumber(obj.optString("phone_number"));
		orderInfo.setEmail(obj.optString("email"));
		orderInfo.setShippingAddress(ShippingAddressMapper.map(obj.optJSONObject("shipping_address")));
		return orderInfo;		
	}
}