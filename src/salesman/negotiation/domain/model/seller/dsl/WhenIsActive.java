package salesman.negotiation.domain.model.seller.dsl;


import salesman.negotiation.domain.model.seller.Seller;

public class WhenIsActive {

  private final Seller seller;

  public WhenIsActive(Seller seller) {
    this.seller = seller;
  }

  public static WhenIsActive when(Seller seller) {
    return new WhenIsActive(seller);
  }

  public WhenIsActive isActive() {
    return this;
  }

}
