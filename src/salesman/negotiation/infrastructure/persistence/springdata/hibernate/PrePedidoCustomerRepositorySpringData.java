package salesman.negotiation.infrastructure.persistence.springdata.hibernate;


import salesman.negotiation.infrastructure.persistence.entities.PrePedidoCustomerEntity;

import java.util.Optional;

public interface PrePedidoCustomerRepositorySpringData {

    Optional<PrePedidoCustomerEntity> findOne(Long id);
}
