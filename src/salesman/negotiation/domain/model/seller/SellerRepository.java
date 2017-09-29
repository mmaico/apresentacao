package salesman.negotiation.domain.model.seller;


import salesman.negotiation.domain.model.seller.dsl.WhenIsActive;

import java.util.Optional;

public interface SellerRepository {

  Optional<Seller> findOne(WhenIsActive dsl);
}
