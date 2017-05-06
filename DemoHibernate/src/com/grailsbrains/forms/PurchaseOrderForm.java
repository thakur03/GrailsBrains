package com.grailsbrains.forms;

/**
 * Created by Ajeet on 5/5/2017.
 */
public class PurchaseOrderForm extends org.apache.struts.action.ActionForm {
    private Integer id;
    private String ponumber;
    private String status;
    private String priority;
    private String poissuedate;
    private String duedate;
    private String seller;
    private String transresp;
    private String incoterms;
    private String billto;
    private String designatedmode;
    private String carrier;
    private String shiptogether;

    private String shipfrom;
    private String originstreet;
    private String origincity;
    private String originstate;
    private String origincountry;
    private String pickupstart;
    private String pickupend;

    private String shipto;
    private String destinationstreat;
    private String destinationcity;
    private String destinationstate;
    private String destinationcountry;
    private String deliverystart;
    private String deliveryend;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getPonumber() {
        return ponumber;
    }

    public void setPonumber(String ponumber) {
        this.ponumber = ponumber;
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

    public String getPoissuedate() {
        return poissuedate;
    }

    public void setPoissuedate(String poissuedate) {
        this.poissuedate = poissuedate;
    }

    public String getDuedate() {
        return duedate;
    }

    public void setDuedate(String duedate) {
        this.duedate = duedate;
    }

    public String getSeller() {
        return seller;
    }

    public void setSeller(String seller) {
        this.seller = seller;
    }

    public String getTransresp() {
        return transresp;
    }

    public void setTransresp(String transresp) {
        this.transresp = transresp;
    }

    public String getIncoterms() {
        return incoterms;
    }

    public void setIncoterms(String incoterms) {
        this.incoterms = incoterms;
    }

    public String getBillto() {
        return billto;
    }

    public void setBillto(String billto) {
        this.billto = billto;
    }

    public String getDesignatedmode() {
        return designatedmode;
    }

    public void setDesignatedmode(String designatedmode) {
        this.designatedmode = designatedmode;
    }

    public String getCarrier() {
        return carrier;
    }

    public void setCarrier(String carrier) {
        this.carrier = carrier;
    }

    public String getShiptogether() {
        return shiptogether;
    }

    public void setShiptogether(String shiptogether) {
        this.shiptogether = shiptogether;
    }

    public String getShipfrom() {
        return shipfrom;
    }

    public void setShipfrom(String shipfrom) {
        this.shipfrom = shipfrom;
    }

    public String getOriginstreet() {
        return originstreet;
    }

    public void setOriginstreet(String originstreet) {
        this.originstreet = originstreet;
    }

    public String getOrigincity() {
        return origincity;
    }

    public void setOrigincity(String origincity) {
        this.origincity = origincity;
    }

    public String getOriginstate() {
        return originstate;
    }

    public void setOriginstate(String originstate) {
        this.originstate = originstate;
    }

    public String getOrigincountry() {
        return origincountry;
    }

    public void setOrigincountry(String origincountry) {
        this.origincountry = origincountry;
    }

    public String getPickupstart() {
        return pickupstart;
    }

    public void setPickupstart(String pickupstart) {
        this.pickupstart = pickupstart;
    }

    public String getPickupend() {
        return pickupend;
    }

    public void setPickupend(String pickupend) {
        this.pickupend = pickupend;
    }

    public String getShipto() {
        return shipto;
    }

    public void setShipto(String shipto) {
        this.shipto = shipto;
    }

    public String getDestinationstreat() {
        return destinationstreat;
    }

    public void setDestinationstreat(String destinationstreat) {
        this.destinationstreat = destinationstreat;
    }

    public String getDestinationcity() {
        return destinationcity;
    }

    public void setDestinationcity(String destinationcity) {
        this.destinationcity = destinationcity;
    }

    public String getDestinationstate() {
        return destinationstate;
    }

    public void setDestinationstate(String destinationstate) {
        this.destinationstate = destinationstate;
    }

    public String getDestinationcountry() {
        return destinationcountry;
    }

    public void setDestinationcountry(String destinationcountry) {
        this.destinationcountry = destinationcountry;
    }

    public String getDeliverystart() {
        return deliverystart;
    }

    public void setDeliverystart(String deliverystart) {
        this.deliverystart = deliverystart;
    }

    public String getDeliveryend() {
        return deliveryend;
    }

    public void setDeliveryend(String deliveryend) {
        this.deliveryend = deliveryend;
    }



    public PurchaseOrderForm(Integer id, String poNumber, String status, String priority, String poissuedate, String duedate, String seller, String transresp, String incoterms, String billto, String designatedmode, String carrier, String shiptogether, String shipfrom, String originstreet, String origincity, String originstate, String origincountry, String pickupstart, String pickupend, String shipto, String destinationstreat, String destinationcity, String destinationstate, String destinationcountry, String deliverystart, String deliveryend) {
        this.id = id;
        this.ponumber = ponumber;
        this.status = status;
        this.priority = priority;
        this.poissuedate = poissuedate;
        this.duedate = duedate;
        this.seller = seller;
        this.transresp = transresp;
        this.incoterms = incoterms;
        this.billto = billto;
        this.designatedmode = designatedmode;
        this.carrier = carrier;
        this.shiptogether = shiptogether;
        this.shipfrom = shipfrom;
        this.originstreet = originstreet;
        this.origincity = origincity;
        this.originstate = originstate;
        this.origincountry = origincountry;
        this.pickupstart = pickupstart;
        this.pickupend = pickupend;
        this.shipto = shipto;
        this.destinationstreat = destinationstreat;
        this.destinationcity = destinationcity;
        this.destinationstate = destinationstate;
        this.destinationcountry = destinationcountry;
        this.deliverystart = deliverystart;
        this.deliveryend = deliveryend;

    }

    public PurchaseOrderForm() {
    }

    @Override
    public String toString() {
        return "PurchaseOrderForm{" +
                "id=" + id +
                ", ponumber='" + ponumber + '\'' +
                ", status='" + status + '\'' +
                ", priority='" + priority + '\'' +
                ", poissuedate='" + poissuedate + '\'' +
                ", duedate='" + duedate + '\'' +
                ", seller='" + seller + '\'' +
                ", transresp='" + transresp + '\'' +
                ", incoterms='" + incoterms + '\'' +
                ", billto='" + billto + '\'' +
                ", designatedmode='" + designatedmode + '\'' +
                ", carrier='" + carrier + '\'' +
                ", shiptogether='" + shiptogether + '\'' +
                ", shipfrom='" + shipfrom + '\'' +
                ", originstreet='" + originstreet + '\'' +
                ", origincity='" + origincity + '\'' +
                ", originstate='" + originstate + '\'' +
                ", origincountry='" + origincountry + '\'' +
                ", pickupstart='" + pickupstart + '\'' +
                ", pickupend='" + pickupend + '\'' +
                ", shipto='" + shipto + '\'' +
                ", destinationstreat='" + destinationstreat + '\'' +
                ", destinationcity='" + destinationcity + '\'' +
                ", destinationstate='" + destinationstate + '\'' +
                ", destinationcountry='" + destinationcountry + '\'' +
                ", deliverystart='" + deliverystart + '\'' +
                ", deliveryend='" + deliveryend + '\'' +

                '}';

    }
}
