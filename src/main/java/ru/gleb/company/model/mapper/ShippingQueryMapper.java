package ru.gleb.company.model.mapper;

import ru.gleb.company.model.ShippingQuery;
import org.json.JSONObject;

public class ShippingQueryMapper {
	public static ShippingQuery map(JSONObject obj) {
		if (obj == null) return null;
		ShippingQuery shippingQuery = new ShippingQuery();

		shippingQuery.setId(obj.getString("id"));
		shippingQuery.setFrom(UserMapper.map(obj.getJSONObject("from")));
		shippingQuery.setInvoicePayload(obj.getString("invoice_payload"));
		shippingQuery.setShippingAddress(ShippingAddressMapper.map(obj.getJSONObject("shipping_address")));

		return shippingQuery;
	}
}