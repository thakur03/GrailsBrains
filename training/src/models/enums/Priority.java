package models.enums;

import lombok.AllArgsConstructor;
import lombok.ToString;

@AllArgsConstructor
@ToString
public enum Priority {
	HIGH("HIGH"), MEDIUM("MEDIUM"), LOW("LOW");
	private String proiority;
	
	public static Priority fromValue(String passedValue) {
		for (Priority obj : Priority.values()) {
			if (String.valueOf(obj.proiority).equals(passedValue.toUpperCase())) {
				return obj;
			}
		}
		return null;
	}
}
