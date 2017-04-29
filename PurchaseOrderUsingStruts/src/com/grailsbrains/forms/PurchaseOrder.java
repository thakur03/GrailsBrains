package com.grailsbrains.forms;

import java.util.Date;


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

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getPoNumber() {
		return poNumber;
	}

	public void setPoNumber(String poNumber) {
		this.poNumber = poNumber;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getPriority() {
		return priority;
	}

	public void setPriority(String priority) {
		this.priority = priority;
	}

	public Date getIssueDate() {
		return issueDate;
	}

	public void setIssueDate(Date issueDate) {
		this.issueDate = issueDate;
	}

	public Date getDueDate() {
		return dueDate;
	}

	public void setDueDate(Date dueDate) {
		this.dueDate = dueDate;
	}

	public String getBillTo() {
		return billTo;
	}

	public void setBillTo(String billTo) {
		this.billTo = billTo;
	}

	public Byte getToShipTogether() {
		return toShipTogether;
	}

	public void setToShipTogether(Byte toShipTogether) {
		this.toShipTogether = toShipTogether;
	}

	public Address getAddressFrom() {
		return addressFrom;
	}

	public void setAddressFrom(Address addressFrom) {
		this.addressFrom = addressFrom;
	}

	public Address getAddressTo() {
		return addressTo;
	}

	public void setAddressTo(Address addressTo) {
		this.addressTo = addressTo;
	}

	public SellerVendor getSellerVendor() {
		return sellerVendor;
	}

	public void setSellerVendor(SellerVendor sellerVendor) {
		this.sellerVendor = sellerVendor;
	}

	public TransResp getTransResp() {
		return transResp;
	}

	public void setTransResp(TransResp transResp) {
		this.transResp = transResp;
	}

	public Incoterms getIncoterms() {
		return incoterms;
	}

	public void setIncoterms(Incoterms incoterms) {
		this.incoterms = incoterms;
	}

	public DesignatedMode getDesignatedMode() {
		return designatedMode;
	}

	public void setDesignatedMode(DesignatedMode designatedMode) {
		this.designatedMode = designatedMode;
	}

	public Carrier getCarrier() {
		return carrier;
	}

	public void setCarrier(Carrier carrier) {
		this.carrier = carrier;
	}

	public PurchaseOrder(Integer id, String poNumber, String status, String priority, Date issueDate, Date dueDate, String billTo, Byte toShipTogether, Address addressFrom, Address addressTo, SellerVendor sellerVendor, TransResp transResp, Incoterms incoterms, DesignatedMode designatedMode, Carrier carrier) {
		this.id = id;
		this.poNumber = poNumber;
		this.status = status;
		this.priority = priority;
		this.issueDate = issueDate;
		this.dueDate = dueDate;
		this.billTo = billTo;
		this.toShipTogether = toShipTogether;
		this.addressFrom = addressFrom;
		this.addressTo = addressTo;
		this.sellerVendor = sellerVendor;
		this.transResp = transResp;
		this.incoterms = incoterms;
		this.designatedMode = designatedMode;
		this.carrier = carrier;
	}

	public PurchaseOrder() {
	}

	@Override
	public String toString() {
		return "PurchaseOrder{" +
				"id=" + id +
				", poNumber='" + poNumber + '\'' +
				", status='" + status + '\'' +
				", priority='" + priority + '\'' +
				", issueDate=" + issueDate +
				", dueDate=" + dueDate +
				", billTo='" + billTo + '\'' +
				", toShipTogether=" + toShipTogether +
				", addressFrom=" + addressFrom +
				", addressTo=" + addressTo +
				", sellerVendor=" + sellerVendor +
				", transResp=" + transResp +
				", incoterms=" + incoterms +
				", designatedMode=" + designatedMode +
				", carrier=" + carrier +
				'}';
	}
}
