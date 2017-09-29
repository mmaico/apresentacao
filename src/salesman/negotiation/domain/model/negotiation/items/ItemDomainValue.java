package salesman.negotiation.domain.model.negotiation.items;


import salesman.negotiation.domain.model.negotiation.Negotiation;
import salesman.negotiation.domain.model.product.Product;
import salesman.negotiation.domain.model.seller.Seller;

public class ItemDomainValue {

  public static class NewItem {

    private final Item item;
    private final Negotiation negotiation;
    private final Seller seller;
    private final Product product;

    public NewItem(Item item, Negotiation negotiation, Seller seller, Product product) {
      this.item = item;
      this.negotiation = negotiation;
      this.seller = seller;
      this.product = product;
    }

    public static NewItem newItem(Item item, Negotiation negotiation, Seller seller, Product product) {
      return new NewItem(item, negotiation, seller, product);
    }

    public Negotiation getNegotiation() {
      return negotiation;
    }

    public Seller getSeller() {
      return seller;
    }

    public Item getItem() {
      return item;
    }

    public Product getProduct() {
      return product;
    }
  }

}
