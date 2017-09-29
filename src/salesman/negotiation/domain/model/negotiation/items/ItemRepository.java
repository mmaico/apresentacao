package salesman.negotiation.domain.model.negotiation.items;


public interface ItemRepository {

  Item register(Item item);

  Item update(Item item);
}
