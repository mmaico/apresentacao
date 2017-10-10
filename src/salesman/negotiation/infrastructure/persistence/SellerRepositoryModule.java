package salesman.negotiation.infrastructure.persistence;

import salesman.negotiation.domain.model.seller.Seller;
import salesman.negotiation.domain.model.seller.SellerBuilder;
import salesman.negotiation.domain.model.seller.SellerRepository;
import salesman.negotiation.domain.model.seller.dsl.WhenIsActive;
import salesman.negotiation.infrastructure.persistence.predicates.SellerPredicates;
import salesman.seller.application.impl.SellerService;

import java.util.Optional;


import static java.util.Optional.of;
import static salesman.negotiation.domain.model.seller.SellerBuilder.createSeller;
import static salesman.negotiation.infrastructure.persistence.predicates.SellerPredicates.SellerActivePredicate.sellerPredicate;


public class SellerRepositoryModule implements SellerRepository {

    private final SellerService sellerService;

    public SellerRepositoryModule(SellerService sellerService) {
        this.sellerService = sellerService;
    }

    @Override
    public Optional<Seller> findOne(WhenIsActive dsl) {

        Optional<salesman.seller.domain.model.seller.Seller> result =
                sellerService.findOne(dsl.getSeller().getId());

        if (!result.isPresent()) return Optional.empty();

        return sellerPredicate(result.get()).isActive()
                ? of(createSeller(result.get().getId()).build())
                : Optional.empty();
    }
}
