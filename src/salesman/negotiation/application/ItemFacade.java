package salesman.negotiation.application;


import salesman.negotiation.domain.model.negotiation.items.Item;
import salesman.negotiation.domain.model.negotiation.items.ItemDomainValue.NewItem;

public interface ItemFacade {


  Item register(NewItem newItem);

  Item update(Item item);
}
