package org.example.entity.bank;

import jakarta.persistence.*;

@Entity
@Table(name ="credit_cards" )
public class CreditCard extends BillingDetail {
    private CardType cardType;
    private Integer expirationMonth;
    private Integer expirationYear;

    public CreditCard() {
    }
@Enumerated(EnumType.STRING)
    public CardType getCardType() {
        return cardType;
    }

    public void setCardType(CardType cardType) {
        this.cardType = cardType;
    }
@Column(name = "expiration_month",nullable = false)
    public Integer getExpirationMonth() {
        return expirationMonth;
    }

    public void setExpirationMonth(Integer expirationMonth) {
        this.expirationMonth = expirationMonth;
    }
    @Column(name = "expiration_year",nullable = false)
    public Integer getExpirationYear() {
        return expirationYear;
    }

    public void setExpirationYear(Integer expirationYear) {
        this.expirationYear = expirationYear;
    }
}
