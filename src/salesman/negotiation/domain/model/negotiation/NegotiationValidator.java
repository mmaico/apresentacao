package salesman.negotiation.domain.model.negotiation;


import salesman.negotiation.domain.model.negotiation.NegotiationDomainValue.NewNegotiation;

public interface NegotiationValidator {

  void checkRules(NewNegotiation newNegotiation);
}
