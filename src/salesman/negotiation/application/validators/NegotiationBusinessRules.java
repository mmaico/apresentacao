package salesman.negotiation.application.validators;



import salesman.negotiation.domain.model.negotiation.Negotiation;
import salesman.negotiation.domain.model.negotiation.NegotiationDomainValue;
import salesman.negotiation.domain.model.negotiation.NegotiationDomainValue.NewNegotiation;
import salesman.negotiation.domain.model.negotiation.NegotiationValidator;
import salesman.negotiation.domain.model.seller.Seller;
import salesman.negotiation.domain.model.seller.SellerRepository;
import salesman.negotiation.domain.model.seller.dsl.WhenIsActive;

import java.util.HashMap;
import java.util.Map;

import static salesman.negotiation.domain.model.seller.dsl.WhenIsActive.when;

public class NegotiationBusinessRules implements NegotiationValidator {

  private SellerRepository sellerRepository;


  private Map<String, CheckRule<NewNegotiation>> rules = new HashMap<>();

  {
    rules.put("Negotiation not informed", newNegotiation -> newNegotiation.getNegotiation() == null);

    rules.put("Negotiation without description", newNegotiation -> {
        Negotiation negotiation = newNegotiation.getNegotiation();
        return  isEmpty(negotiation.getDescription());
    });

    rules.put("Seller has to be active", newNegotiation -> {
        Seller seller = newNegotiation.getSeller();
        return !sellerRepository.findOne(when(seller).isActive()).isPresent();
    });


  }


  private interface CheckRule <Y>{
    Boolean check(Y y);
  }

}
