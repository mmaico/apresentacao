package salesman.negotiation.infrastructure.persistence.springdata.hibernate;


import salesman.negotiation.infrastructure.persistence.entities.PrePedidoDescricaoEntity;

import java.util.Optional;

public interface PrePedidoDescricaoRepositorySpringData {

    Optional<PrePedidoDescricaoEntity> findOne(Long id);
}
