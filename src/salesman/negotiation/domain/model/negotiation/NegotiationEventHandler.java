package salesman.negotiation.domain.model.negotiation;


import salesman.negotiation.domain.model.negotiation.NegotiationDomainValue.ClosedWon;

public interface NegotiationEventHandler {

    void sendEvent(ClosedWon closedWon);
}
