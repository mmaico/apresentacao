package salesman.negotiation.application.impl;


import salesman.negotiation.application.NegotiationFacade;
import salesman.negotiation.domain.model.customer.Customer;
import salesman.negotiation.domain.model.negotiation.Negotiation;
import salesman.negotiation.domain.model.negotiation.NegotiationDomainValue;
import salesman.negotiation.domain.model.negotiation.NegotiationDomainValue.ChangeStatus;
import salesman.negotiation.domain.model.negotiation.NegotiationDomainValue.ChangedNegotiation;
import salesman.negotiation.domain.model.negotiation.NegotiationDomainValue.NewNegotiation;
import salesman.negotiation.domain.model.negotiation.NegotiationValidator;
import salesman.negotiation.domain.model.seller.Seller;

import java.util.Collection;

import static salesman.negotiation.domain.model.negotiation.NegotiationDomainValue.OnlyOpenNegotiation.onlyOpenNegotiation;
import static salesman.negotiation.domain.model.seller.Seller.seller;

public class NegotiationService implements NegotiationFacade {


  private NegotiationValidator validator;

  public NegotiationService(NegotiationValidator validator) {
    this.validator = validator;
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
      // gerar uma venda
      // mandar notificacao para o cliente
      // gerar comissionamento para o vendedor
      // gerar bonus para a proxima compra do cliente
      // ...
    }

    return changedNegotiation;
  }

}
