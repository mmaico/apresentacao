package salesman.negotiation.domain.model.seller;


import salesman.negotiation.domain.model.customer.Customer;
import salesman.negotiation.domain.model.negotiation.Negotiation;
import salesman.negotiation.domain.model.negotiation.NegotiationDomainValue.OnlyOpenNegotiation;
import salesman.negotiation.domain.model.negotiation.NegotiationRepository;
import salesman.negotiation.domain.model.negotiation.items.Item;
import salesman.negotiation.domain.model.negotiation.items.ItemRepository;

import java.util.Collection;

public class Seller {

    private Long id;

    private NegotiationRepository negotiationRepository;
    private ItemRepository itemRepository;

    public Seller() {
        //this.negotiationRepository = ServiceLocator.getBean(NegotiationRepository.class);
        //this.itemRepository = ServiceLocator.getBean(ItemRepository.class);
    }

    public ToTheCustomer registerNew(Negotiation negotiation) {
        return customer ->
            negotiationRepository.register(negotiation.madeBy(this).toThe(customer));
    }

    public Negotiation update(Negotiation negotiation) {
        return negotiationRepository.update(negotiation.updatedBy(this));
    }

    public Collection<Negotiation> findAll(OnlyOpenNegotiation onlyOpenNegotiation) {
        return negotiationRepository.findAll(onlyOpenNegotiation);
    }

    public InThe addNew(Item item) {
        return negotiation -> itemRepository.register(item.inThe(negotiation).registeredBy(this));
    }

    public FromThe update(Item item) {
        return negotiation -> itemRepository.update(item);
    }

    public ToTheNew changes(Negotiation negotiation) {
        return status -> negotiationRepository.update(negotiation.withNew(status));
    }

    public static Seller seller() {
        return new Seller();
    }

    @FunctionalInterface
    public interface ToTheCustomer {
        Negotiation toThe(Customer customer);
    }

    @FunctionalInterface
    public interface InThe {
        Item inThe(Negotiation negotiation);
    }

    @FunctionalInterface
    public interface FromThe {
        Item fromThe(Negotiation negotiation);
    }

    @FunctionalInterface
    public interface ToTheNew {
        Negotiation toTheNew(Negotiation.Status status);
    }

}
