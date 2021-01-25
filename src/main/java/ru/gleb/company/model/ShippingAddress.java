package ru.gleb.company.model;

import lombok.Getter;
import lombok.Setter;

import java.util.Optional;

@Getter
@Setter
public class ShippingAddress extends Model {
	private String countryCode;
	private String state;
	private String city;
	private String streetLine1;
	private String streetLine2;
	private String postCode;

	@Override
	public String toString(int repeat) {
	        String repStr2 = "\t".repeat(repeat-1);
	        String repStr = repStr2 + "\t";
	        return "ShippingAddress@{\n" +
	                repStr + "countryCode: " + countryCode + ",\n" +
	                repStr + "state: " + state + ",\n" +
	                repStr + "city: " + city + ",\n" +
	                repStr + "streetLine1: " + streetLine1 + ",\n" +
	                repStr + "streetLine2: " + streetLine2 + ",\n" +
	                repStr + "postCode: " + postCode + ",\n" +
	                repStr2 + "}";
	}
}