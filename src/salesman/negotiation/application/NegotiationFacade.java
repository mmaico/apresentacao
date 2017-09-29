package salesman.negotiation.application;


import salesman.negotiation.domain.model.negotiation.Negotiation;
import salesman.negotiation.domain.model.negotiation.NegotiationDomainValue.ChangedNegotiation;
import salesman.negotiation.domain.model.negotiation.NegotiationDomainValue.NewNegotiation;



public interface NegotiationFacade {

  Negotiation register(NewNegotiation newNegotiation);

  Negotiation update(ChangedNegotiation changedNegotiation);
}
