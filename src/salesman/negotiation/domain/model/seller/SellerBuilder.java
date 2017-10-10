package salesman.negotiation.domain.model.seller;


public class SellerBuilder {

    private Seller seller;

    public SellerBuilder() {
        this.seller = new Seller();
    }

    public SellerBuilder(Long id) {
        this();
        this.seller.setId(id);
    }

    public static SellerBuilder createSeller(Long id) {
        return new SellerBuilder(id);
    }

    public Seller build() {
        return this.seller;
    }

}
