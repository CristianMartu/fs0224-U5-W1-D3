package cristianmartucci.U5_W1_D3.entities;

import cristianmartucci.U5_W1_D3.enums.OrderState;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Getter
@Setter
@ToString
public class Order {
    private UUID order_id;
    private Table table;
    private List<Product> products;
    private OrderState order_state;
    private int numbered_covered;
    private LocalDateTime time_order;
    @Setter(AccessLevel.NONE)
    private double totale_price;
    private double cost_covered;

    public Order(UUID order_id, Table table, List<Product> products, OrderState order_state, int numbered_covered, LocalDateTime time_order, double cost_covered) {
        this.order_id = order_id;
        this.table = table;
        this.products = products;
        this.order_state = order_state;
        this.numbered_covered = numbered_covered;
        this.time_order = time_order;
        this.cost_covered = cost_covered;
        this.setTotale_price();
    }

    public void setTotale_price() {
        this.totale_price += this.numbered_covered * cost_covered;
        for (Product product: products){
            this.totale_price += product.getPrice();
        }
    }
}
