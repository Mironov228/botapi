package ru.gleb.company.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PreCheckoutQuery extends Model {
	private String id;
	private User from;
	private String currency;
	private int totalAmount;
	private String invoicePayload;
	private String shippingOptionId; // optional
	private OrderInfo orderInfo; // optional

	public boolean hasOrderInfo() {
		return orderInfo != null;
	}

	public boolean hasShippingOptionId() {
		return shippingOptionId != null;
	}

	@Override
	public String toString(int repeat) {
	        String repStr2 = "\t".repeat(repeat-1);
	        String repStr = repStr2 + "\t";
	        return "Type@{\n" +
	                repStr + "id: " + id + ",\n" +
	                repStr + "from: " + from + ",\n" +
	                repStr + "currency: " + currency + ",\n" +
	                repStr + "totalAmount: " + totalAmount + ",\n" +
	                repStr + "invoicePayload: " + invoicePayload + ",\n" +
	                repStr + "shippingOptionId: " + shippingOptionId + ",\n" +
	                repStr + "orderInfo: " + (hasOrderInfo() ? orderInfo.toString(repeat+1) : null) + ",\n" +
	                repStr2 + "}";
	}
}