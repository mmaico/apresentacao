package salesman.negotiation.domain.model.negotiation;


import salesman.negotiation.domain.model.customer.Customer;
import salesman.negotiation.domain.model.negotiation.items.Item;
import salesman.negotiation.domain.model.seller.Seller;

import java.util.Collection;
import java.util.Date;

public class Negotiation {

    private Long id;
    private String description;
    private Date created;
    private Seller seller;
    private Customer customer;
    private Collection<Item> items;


}
