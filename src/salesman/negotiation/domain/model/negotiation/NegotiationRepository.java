package salesman.negotiation.domain.model.negotiation;


import salesman.negotiation.domain.model.negotiation.NegotiationDomainValue.OnlyOpenNegotiation;

import java.util.Collection;

public interface NegotiationRepository {

  Negotiation register(Negotiation negotiation);

  Negotiation update(Negotiation negotiation);

  Collection<Negotiation> findAll(OnlyOpenNegotiation onlyOpenNegotiation);
}
