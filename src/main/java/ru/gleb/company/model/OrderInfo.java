package ru.gleb.company.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class OrderInfo extends Model {
	private String name; // optional
	private String phoneNumber; // optional
	private String email; // optional
	private ShippingAddress shippingAddress; // optional

	public boolean hasName() {
		return name != null;
	}

	public boolean hasPhoneNumber() {
		return phoneNumber != null;
	}

	public boolean hasEmail() {
		return email != null;
	}

	public boolean hasShippingAddress() {
		return shippingAddress != null;
	}

	@Override
	public String toString(int repeat) {
	        String repStr2 = "\t".repeat(repeat-1);
	        String repStr = repStr2 + "\t";
	        return "OrderInfo@{\n" +
	                repStr + "name: " + name + ",\n" +
	                repStr + "phoneNumber: " + phoneNumber + ",\n" +
	                repStr + "email: " + email + ",\n" +
	                repStr + "shippingAddress: " + (hasShippingAddress() ? shippingAddress.toString(repeat+1) : null) + ",\n" +
	                repStr2 + "}";
	}
}