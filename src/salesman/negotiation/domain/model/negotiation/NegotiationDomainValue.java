package salesman.negotiation.domain.model.negotiation;


import salesman.negotiation.domain.model.customer.Customer;
import salesman.negotiation.domain.model.seller.Seller;

public class NegotiationDomainValue {

  public static class ChangedNegotiation {

    private final Negotiation negotiation;
    private final Seller seller;

    public ChangedNegotiation(Negotiation negotiation, Seller seller) {
      this.negotiation = negotiation;
      this.seller = seller;
    }

    public static ChangedNegotiation newNegotiationWith(Negotiation negotiation, Seller seller) {
      return new ChangedNegotiation(negotiation, seller);
    }

    public Negotiation getNegotiation() {
      return negotiation;
    }

    public Seller getSeller() {
      return seller;
    }
  }

  public static class NewNegotiation {

    private final Negotiation negotiation;
    private final Customer customer;
    private final Seller seller;

    public NewNegotiation(Negotiation negotiation, Customer customer,
        Seller seller) {
      this.negotiation = negotiation;
      this.customer = customer;
      this.seller = seller;
    }

    public static NewNegotiation newNegotiationWith(Negotiation negotiation, Customer customer, Seller seller) {
      return new NewNegotiation(negotiation, customer, seller);
    }

    public Negotiation getNegotiation() {
      return negotiation;
    }

    public Customer getCustomer() {
      return customer;
    }

    public Seller getSeller() {
      return seller;
    }
  }

  public static class OnlyOpenNegotiation {

    public static OnlyOpenNegotiation onlyOpenNegotiation() {
      return new OnlyOpenNegotiation();
    }
  }

  public static class ChangeStatus {
    private final Negotiation negotiation;
    private final Negotiation.Status newStatus;

    public ChangeStatus(Negotiation negotiation,
        Negotiation.Status newStatus) {
      this.negotiation = negotiation;
      this.newStatus = newStatus;
    }

    public static ChangeStatus changeStatus(Negotiation negotiation, Negotiation.Status newStatus) {
      return new ChangeStatus(negotiation, newStatus);
    }

    public Negotiation getNegotiation() {
      return negotiation;
    }

    public Negotiation.Status getNewStatus() {
      return newStatus;
    }
  }
}
