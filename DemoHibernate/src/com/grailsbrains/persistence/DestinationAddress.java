package com.grailsbrains.persistence;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;
import java.util.Date;

/**
 * Created by Ajeet on 5/5/2017.
 */
@Entity
@Table(name="destination_address")
@PrimaryKeyJoinColumn(name="ID")
public class DestinationAddress extends POAddress {
    @Column
    private Date deliveryStart;
    @Column
    private Date deliveryEnd;

    public Date getDeliveryStart() {
        return deliveryStart;
    }

    public void setDeliveryStart(Date deliveryStart) {
        this.deliveryStart = deliveryStart;
    }

    public Date getDeliveryEnd() {
        return deliveryEnd;
    }

    public void setDeliveryEnd(Date deliveryEnd) {
        this.deliveryEnd = deliveryEnd;
    }

    @Override
    public String toString() {
        return "DestinationAddress{" +
                "deliveryStart=" + deliveryStart +
                ", deliveryEnd=" + deliveryEnd +
                '}';
    }
}
