package models.enums;

import lombok.AllArgsConstructor;
import lombok.ToString;

@AllArgsConstructor
@ToString
public enum Status {
	NEW("NEW"), USED("USED");
	private String status;
	
	public static Status fromValue(String passedValue) {
		for (Status obj : Status.values()) {
			if (String.valueOf(obj.status).equals(passedValue.toUpperCase())) {
				return obj;
			}
		}
		return null;
	}
}
