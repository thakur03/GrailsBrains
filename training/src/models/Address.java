package models;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Address {
	private Integer id;
	private String refererName;
	private String address;
	private String city;
	private Date startDate;
	private Date endDate;
	private State state;
	private Country country;
}
