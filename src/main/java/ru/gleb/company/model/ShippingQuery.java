package ru.gleb.company.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ShippingQuery extends Model {
	private String id;
	private User from;
	private String invoicePayload;
	private ShippingAddress shippingAddress;

	@Override
	public String toString(int repeat) {
	        String repStr2 = "\t".repeat(repeat-1);
	        String repStr = repStr2 + "\t";
	        return "ShippingQuery@{\n" +
	                repStr + "id: " + id + ",\n" +
	                repStr + "from: " + from + ",\n" +
	                repStr + "invoicePayload: " + invoicePayload + ",\n" +
	                repStr + "shippingAddress: " + shippingAddress.toString(repeat+1) + ",\n" +
	                repStr2 + "}";
	}
}