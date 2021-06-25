package com.ss.adminservice.entity;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class BookingPaymentEnt {

    @Column(nullable = false)
    private String stripeId;
    @Column(nullable = false)
    private boolean refunded;

    public String getStripeId() {
        return stripeId;
    }

    public BookingPaymentEnt setStripeId(String stripeId) {
        this.stripeId = stripeId;
        return this;
    }

    public boolean isRefunded() {
        return refunded;
    }

    public BookingPaymentEnt setRefunded(boolean refunded) {
        this.refunded = refunded;
        return this;
    }
}
