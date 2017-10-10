package salesman.negotiation.infrastructure.persistence;


import salesman.negotiation.domain.model.negotiation.Negotiation;
import salesman.negotiation.domain.model.negotiation.NegotiationDomainValue.OnlyOpenNegotiation;
import salesman.negotiation.domain.model.negotiation.NegotiationRepository;
import salesman.negotiation.infrastructure.persistence.entities.PrePedidoCustomerEntity;
import salesman.negotiation.infrastructure.persistence.entities.PrePedidoDescricaoEntity;
import salesman.negotiation.infrastructure.persistence.entities.PrePedidoDetalheEntity;
import salesman.negotiation.infrastructure.persistence.springdata.hibernate.PrePedidoCustomerRepositorySpringData;
import salesman.negotiation.infrastructure.persistence.springdata.hibernate.PrePedidoDescricaoRepositorySpringData;
import salesman.negotiation.infrastructure.persistence.springdata.hibernate.PrePedidoDetalheRepositorySpringData;
import salesman.negotiation.infrastructure.persistence.translate.NegotiationToPrePedido;

import java.util.Collection;
import java.util.Optional;

public class NegotiationRepositoryOracle implements NegotiationRepository {


    private final PrePedidoCustomerRepositorySpringData prePedidoCustomerRepository;
    private final PrePedidoDescricaoRepositorySpringData prePedidoDescricaoRepository;
    private final PrePedidoDetalheRepositorySpringData prePedidoDetalheRepository;
    private final NegotiationToPrePedido translate;

    public NegotiationRepositoryOracle(PrePedidoCustomerRepositorySpringData prePedidoCustomerRepository,
                                       PrePedidoDescricaoRepositorySpringData prePedidoDescricaoRepository,
                                       PrePedidoDetalheRepositorySpringData prePedidoDetalheRepository,
                                       NegotiationToPrePedido translate) {
        this.prePedidoCustomerRepository = prePedidoCustomerRepository;
        this.prePedidoDescricaoRepository = prePedidoDescricaoRepository;
        this.prePedidoDetalheRepository = prePedidoDetalheRepository;
        this.translate = translate;
    }



    @Override
    public Optional<Negotiation> findOne(Long id) {

        Optional<PrePedidoDetalheEntity> detalhe = prePedidoDetalheRepository.findOne(id);

        if (!detalhe.isPresent()) return Optional.empty();

        Optional<PrePedidoDescricaoEntity> description = prePedidoDescricaoRepository.findOne(detalhe.get().getId());
        Optional<PrePedidoCustomerEntity> customer = prePedidoCustomerRepository.findOne(description.get().getId());

        Negotiation negotiation = this.translate.translate(detalhe.get(), description.get(), customer.get());

        return Optional.of(negotiation);
    }

    @Override
    public Negotiation register(Negotiation negotiation) {

        return null;
    }

    @Override
    public Negotiation update(Negotiation negotiation) {
        return null;
    }

    @Override
    public Collection<Negotiation> findAll(OnlyOpenNegotiation onlyOpenNegotiation) {
        return null;
    }


}
