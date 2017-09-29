package salesman.negotiation.domain.model.negotiation.items;

import salesman.negotiation.domain.model.negotiation.Negotiation;
import salesman.negotiation.domain.model.product.Product;
import salesman.negotiation.domain.model.seller.Seller;

import java.math.BigDecimal;


public class Item {

    private Long id;
    private Integer quantity;
    private BigDecimal price;
    private Product product;

    private Negotiation belongsTo;
    private Seller createdBy;

    public Item inThe(Negotiation negotiation) {
        this.belongsTo = negotiation;
        return this;
    }

    public Item registeredBy(Seller seller) {
        this.createdBy = seller;
        return this;
    }

    public Item with(Product product) {
        this.product = product;
        return this;
    }


    public Product getProduct() {
        return product;
    }
}
