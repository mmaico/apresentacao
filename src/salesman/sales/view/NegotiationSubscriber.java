package salesman.sales.view;


import com.google.common.eventbus.Subscribe;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import salesman.infrastructure.events.NegotiationClosedWon;
import salesman.sales.application.SalesFacade;
import salesman.sales.domain.model.negotiation.Negotiation;
import salesman.sales.domain.model.negotiation.NegotiationBuilder;

import static salesman.sales.domain.model.negotiation.NegotiationBuilder.createNegotiation;

@Component
public class NegotiationSubscriber {

    private final SalesFacade salesFacade;

    @Autowired
    public NegotiationSubscriber(SalesFacade salesFacade) {
        this.salesFacade = salesFacade;
    }


    @Subscribe
    public void receiveNegotiation(NegotiationClosedWon negotiationClosedWon) {
        Negotiation negotiation = createNegotiation(negotiationClosedWon.getId()).build();
        salesFacade.generatedBy(negotiation);
    }
}



