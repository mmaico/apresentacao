package salesman.negotiation.domain.model.negotiation;


import salesman.negotiation.domain.model.customer.Customer;
import salesman.negotiation.domain.model.negotiation.items.Item;
import salesman.negotiation.domain.model.seller.Seller;

import java.util.Collection;
import java.util.Date;

public class Negotiation {

    public enum Status {COLD, WARM, HOT, CLOSED_WON}

    private Long id;
    private String description;
    private Date created;
    private Seller seller;
    private Customer customer;
    private Collection<Item> items;
    private Status status;


    public Negotiation madeBy(Seller seller) {
        this.seller = seller;
        return this;
    }

    public Negotiation updatedBy(Seller seller) {
        this.seller = seller;
        return this;
    }


    public Negotiation toThe(Customer customer) {
        this.customer = customer;
        return this;
    }

    public Negotiation withNew(Status status) {
        this.status = status;
        return this;
    }

    public static Negotiation negotiation() {
        return new Negotiation();
    }

    public Boolean wasClosedWon() {
        return Status.CLOSED_WON.equals(this.status);
    }

    public String getDescription() {
        return description;
    }
}
