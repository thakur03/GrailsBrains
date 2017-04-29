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
public class PurchaseOrder {	
	private Integer id;
	private String poNumber;
	private String status;
	private String priority;
	private Date issueDate;
	private Date dueDate;
	private String billTo;
	private Byte toShipTogether;
	private Address addressFrom;
	private Address addressTo;
	private SellerVendor sellerVendor;
	private TransResp transResp;
	private Incoterms incoterms;
	private DesignatedMode designatedMode;
	private Carrier carrier;
}
