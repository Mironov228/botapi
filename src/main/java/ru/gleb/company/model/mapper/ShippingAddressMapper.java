package ru.gleb.company.model.mapper;

import ru.gleb.company.model.ShippingAddress;
import org.json.JSONObject;

public class ShippingAddressMapper {
	public static ShippingAddress map(JSONObject obj) {
		if (obj == null) return null;
		ShippingAddress shippingAddress = new ShippingAddress();

		shippingAddress.setCountryCode(obj.getString("country_code"));
		shippingAddress.setState(obj.getString("state"));
		shippingAddress.setCity(obj.getString("city"));
		shippingAddress.setStreetLine1(obj.getString("street_line1"));
		shippingAddress.setStreetLine2(obj.getString("street_line2"));
		shippingAddress.setPostCode(obj.getString("post_code"));

		return shippingAddress;
	}
}