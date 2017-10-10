package salesman.infrastructure.events;

/**
 * Created by mmaico on 10/8/17.
 */
public class NegotiationClosedWon {

    private final Long id;


    public NegotiationClosedWon(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public static NegotiationClosedWon createBy(Long id) {
        return new NegotiationClosedWon(id);
    }
}
