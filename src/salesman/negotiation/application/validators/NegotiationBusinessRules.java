package salesman.negotiation.application.validators;



import salesman.negotiation.domain.model.negotiation.Negotiation;
import salesman.negotiation.domain.model.negotiation.NegotiationDomainValue;
import salesman.negotiation.domain.model.negotiation.NegotiationDomainValue.NewNegotiation;
import salesman.negotiation.domain.model.negotiation.NegotiationValidator;
import salesman.negotiation.domain.model.seller.Seller;
import salesman.negotiation.domain.model.seller.SellerRepository;
import salesman.negotiation.domain.model.seller.dsl.WhenIsActive;
import org.apache.commons.lang.StringUtils;
import salesman.negotiation.infrastructure.libraries.ValidationException;


import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import static org.apache.commons.lang.StringUtils.isBlank;
import static salesman.negotiation.domain.model.seller.dsl.WhenIsActive.when;
import static salesman.negotiation.infrastructure.libraries.HandlerErrors.hasErrors;

public class NegotiationBusinessRules implements NegotiationValidator {

  private SellerRepository sellerRepository;


  private Map<String, CheckRule<NewNegotiation>> rules = new HashMap<>();

  {
    rules.put("Negotiation not informed", newNegotiation -> newNegotiation.getNegotiation() == null);

    rules.put("Negotiation without description", newNegotiation -> {
        Negotiation negotiation = newNegotiation.getNegotiation();
        return isBlank(negotiation.getDescription());
    });

    rules.put("Seller is not active", newNegotiation -> {
        Seller seller = newNegotiation.getSeller();
        return !sellerRepository.findOne(when(seller).isActive()).isPresent();
    });

    //...
  }

  public void checkRules(NewNegotiation newNegotiation) {

    Set<String> errors = rules.entrySet()
        .stream()
        .filter(e -> e.getValue().check(newNegotiation))
        .map(Map.Entry::getKey).collect(Collectors.toSet());

    hasErrors(errors).throwing(ValidationException.class);
  }


  private interface CheckRule <Y>{
    Boolean check(Y y);
  }

}
