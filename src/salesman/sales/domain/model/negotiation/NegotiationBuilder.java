package salesman.sales.domain.model.negotiation;


public class NegotiationBuilder {

    private Negotiation negotiation;

    public NegotiationBuilder() {
        this.negotiation = new Negotiation();
    }

    public NegotiationBuilder(Long id) {
        this();
        this.negotiation.setId(id);
    }

    public static NegotiationBuilder createNegotiation(Long id) {
        return new NegotiationBuilder(id);
    }

    public Negotiation build() {
        return this.negotiation;
    }

}
