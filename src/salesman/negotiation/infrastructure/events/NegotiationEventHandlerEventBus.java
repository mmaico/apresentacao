package salesman.negotiation.infrastructure.events;


import com.google.common.eventbus.EventBus;
import salesman.infrastructure.events.NegotiationClosedWon;
import salesman.negotiation.domain.model.negotiation.Negotiation;
import salesman.negotiation.domain.model.negotiation.NegotiationDomainValue.ClosedWon;
import salesman.negotiation.domain.model.negotiation.NegotiationEventHandler;

public class NegotiationEventHandlerEventBus implements NegotiationEventHandler {


    private EventBus eventBus;

    public NegotiationEventHandlerEventBus(EventBus eventBus) {
        this.eventBus = eventBus;
    }


    @Override
    public void sendEvent(ClosedWon closedWon) {
        Negotiation negotiation = closedWon.getNegotiation();

        eventBus.post(NegotiationClosedWon.createBy(negotiation.getId()));
    }
}
