package salesman.negotiation.application.impl;

import salesman.negotiation.application.ItemFacade;
import salesman.negotiation.domain.model.negotiation.Negotiation;
import salesman.negotiation.domain.model.negotiation.items.Item;
import salesman.negotiation.domain.model.negotiation.items.ItemDomainValue.NewItem;
import salesman.negotiation.domain.model.product.Product;
import salesman.negotiation.domain.model.seller.Seller;

import static salesman.negotiation.domain.model.negotiation.Negotiation.negotiation;
import static salesman.negotiation.domain.model.seller.Seller.seller;


public class ItemService implements ItemFacade {

  @Override
  public Item register(NewItem newItem) {
    final Item item = newItem.getItem();
    final Negotiation negotiation = newItem.getNegotiation();
    final Seller seller = newItem.getSeller();
    final Product product = newItem.getProduct();


    return seller.addNew(item.with(product)).inThe(negotiation);
  }

  @Override
  public Item update(Item item) {

    return seller().update(item).fromThe(negotiation());
  }

}
