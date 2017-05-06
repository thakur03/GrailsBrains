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
@Table(name="origin_address")
@PrimaryKeyJoinColumn(name="ID")
public class OriginAddress extends POAddress {
    @Column
    private Date pickupStart;
    @Column
    private Date pickupEnd;

    public Date getPickupStart() {
        return pickupStart;
    }

    public void setPickupStart(Date pickupStart) {
        this.pickupStart = pickupStart;
    }

    public Date getPickupEnd() {
        return pickupEnd;
    }

    public void setPickupEnd(Date pickupEnd) {
        this.pickupEnd = pickupEnd;
    }

    @Override
    public String toString() {
        return "OriginAddress{" +
                "pickupStart=" + pickupStart +
                ", pickupEnd=" + pickupEnd +
                '}';
    }
}
