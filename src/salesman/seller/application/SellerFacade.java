package salesman.seller.application;


import salesman.seller.domain.model.seller.Seller;

import java.util.Optional;

public interface SellerFacade {

    Optional<Seller> findOne(Long id);


}
