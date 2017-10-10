package salesman.negotiation.infrastructure.persistence.springdata.hibernate;


import salesman.negotiation.infrastructure.persistence.entities.PrePedidoDetalheEntity;

import java.util.Optional;

public interface PrePedidoDetalheRepositorySpringData {

    Optional<PrePedidoDetalheEntity> findOne(Long id);
}


