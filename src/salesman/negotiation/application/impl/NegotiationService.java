package salesman.negotiation.application.impl;


import salesman.negotiation.application.NegotiationFacade;
import salesman.negotiation.domain.model.customer.Customer;
import salesman.negotiation.domain.model.negotiation.Negotiation;
import salesman.negotiation.domain.model.negotiation.NegotiationDomainValue;
import salesman.negotiation.domain.model.negotiation.NegotiationDomainValue.ChangeStatus;
import salesman.negotiation.domain.model.negotiation.NegotiationDomainValue.ChangedNegotiation;
import salesman.negotiation.domain.model.negotiation.NegotiationDomainValue.NewNegotiation;
import salesman.negotiation.domain.model.negotiation.NegotiationEventHandler;
import salesman.negotiation.domain.model.negotiation.NegotiationValidator;
import salesman.negotiation.domain.model.seller.Seller;

import java.util.Collection;

import static salesman.negotiation.domain.model.negotiation.NegotiationDomainValue.ClosedWon.closedWon;
import static salesman.negotiation.domain.model.negotiation.NegotiationDomainValue.OnlyOpenNegotiation.onlyOpenNegotiation;
import static salesman.negotiation.domain.model.seller.Seller.seller;

public class NegotiationService implements NegotiationFacade {


  private NegotiationValidator validator;
  private NegotiationEventHandler eventHandler;

  public NegotiationService(NegotiationValidator validator, NegotiationEventHandler eventHandler) {
    this.validator = validator;
    this.eventHandler = eventHandler;
  }

  public Negotiation register(NewNegotiation newNegotiation) {
    final Seller seller = newNegotiation.getSeller();
    final Negotiation negotiation = newNegotiation.getNegotiation();
    final Customer customer = newNegotiation.getCustomer();

    validator.checkRules(newNegotiation);

    return seller.registerNew(negotiation).toThe(customer);
  }

  public Negotiation update(ChangedNegotiation changedNegotiation) {
    final Seller seller = changedNegotiation.getSeller();
    final Negotiation negotiation = changedNegotiation.getNegotiation();

    return seller.update(negotiation);
  }

  public Collection<Negotiation> findAll() {

    return seller().findAll(onlyOpenNegotiation());
  }

  public Negotiation updateStatus(ChangeStatus changeStatus) {
    Negotiation negotiation = changeStatus.getNegotiation();
    Negotiation.Status status = changeStatus.getNewStatus();

    Negotiation changedNegotiation = seller().changes(negotiation).toTheNew(status);

    if (changedNegotiation.wasClosedWon()) {
      eventHandler.sendEvent(closedWon(changedNegotiation));
    }

    return changedNegotiation;
  }

}
