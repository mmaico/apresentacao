package salesman.negotiation.infrastructure.persistence.predicates;


import salesman.seller.domain.model.seller.Seller;

public class SellerPredicates {


    public static class SellerActivePredicate {

        private final Seller seller;

        public SellerActivePredicate(Seller seller) {
            this.seller = seller;
        }

        public static SellerActivePredicate sellerPredicate(Seller seller) {
            return new SellerActivePredicate(seller);
        }

        public Boolean isActive() {
            return Seller.Status.ACTIVE.equals(seller.getStatus());
        }
    }
}
