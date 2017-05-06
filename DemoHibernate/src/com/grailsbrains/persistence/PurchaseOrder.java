package com.grailsbrains.persistence;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

/**
 * Created by Ajeet on 5/5/2017.
 */
@Entity
public class PurchaseOrder {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column
    private Integer poNumber;
    @Column
    private String status;
    @Column
    private String priority;
    @Column
    private Date issueDate;
    @Column
    private Date dueDate;
    @Column
    private String seller_vendor;
    @Column
    private String billTo;
    @Column
    private String transResp;
    @Column
    private String incoTerms;
    @Column
    private String designatedMode;
    @Column
    private String carrier;
    @Column
    private boolean shipTogether;

    @OneToMany(cascade = CascadeType.ALL)
    List<OriginAddress> originAddresses;

    @OneToMany(cascade = CascadeType.ALL)
    List<DestinationAddress> destinationAddresses;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getPoNumber() {
        return poNumber;
    }

    public void setPoNumber(Integer poNumber) {
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

    public String getSeller_vendor() {
        return seller_vendor;
    }

    public void setSeller_vendor(String seller_vendor) {
        this.seller_vendor = seller_vendor;
    }

    public String getBillTo() {
        return billTo;
    }

    public void setBillTo(String billTo) {
        this.billTo = billTo;
    }

    public String getTransResp() {
        return transResp;
    }

    public void setTransResp(String transResp) {
        this.transResp = transResp;
    }

    public String getIncoTerms() {
        return incoTerms;
    }

    public void setIncoTerms(String incoTerms) {
        this.incoTerms = incoTerms;
    }

    public String getDesignatedMode() {
        return designatedMode;
    }

    public void setDesignatedMode(String designatedMode) {
        this.designatedMode = designatedMode;
    }

    public String getCarrier() {
        return carrier;
    }

    public void setCarrier(String carrier) {
        this.carrier = carrier;
    }

    public boolean isShipTogether() {
        return shipTogether;
    }

    public void setShipTogether(boolean shipTogether) {
        this.shipTogether = shipTogether;
    }

    public List<OriginAddress> getOriginAddresses() {
        return originAddresses;
    }

    public void setOriginAddresses(List<OriginAddress> originAddresses) {
        this.originAddresses = originAddresses;
    }

    public List<DestinationAddress> getDestinationAddresses() {
        return destinationAddresses;
    }

    public void setDestinationAddresses(List<DestinationAddress> destinationAddresses) {
        this.destinationAddresses = destinationAddresses;
    }

    @Override
    public String toString() {
        return "PurchaseOrder{" +
                "id=" + id +
                ", poNumber=" + poNumber +
                ", status='" + status + '\'' +
                ", priority='" + priority + '\'' +
                ", issueDate=" + issueDate +
                ", dueDate=" + dueDate +
                ", seller_vendor='" + seller_vendor + '\'' +
                ", billTo='" + billTo + '\'' +
                ", transResp='" + transResp + '\'' +
                ", incoTerms='" + incoTerms + '\'' +
                ", designatedMode='" + designatedMode + '\'' +
                ", carrier='" + carrier + '\'' +
                ", shipTogether=" + shipTogether +
                ", originAddresses=" + originAddresses +
                ", destinationAddresses=" + destinationAddresses +
                '}';
    }
}
