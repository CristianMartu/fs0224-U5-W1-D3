package cristianmartucci.U5_W1_D3;

import cristianmartucci.U5_W1_D3.entities.*;
import cristianmartucci.U5_W1_D3.enums.OrderState;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.UUID;

@Configuration
@PropertySource("application.properties")
public class BeansConfigurations {
    @Value("${cost.covered}")
    private double covered;

    @Bean(name = "tomato")
    public Topping getTomato(){
        return new Topping("Tomato", 50, 0.59);
    }

    @Bean(name = "cheese")
    public Topping getCheese(){
        return new Topping("Cheese", 92, 0.69);
    }

    @Bean(name = "ham")
    public Topping getHam(){
        return new Topping("Ham", 35, 0.99);
    }

    @Bean(name = "onions")
    public Topping getOnions(){
        return new Topping("Onions", 22, 0.69);
    }

    @Bean(name = "pineapple")
    public Topping getPineapple(){
        return new Topping("Pineapple", 24, 0.79);
    }

    @Bean(name = "salami")
    public Topping getSalami(){
        return new Topping("Salami", 86, 0.99);
    }

    @Bean(name = "lemonade")
    public Drink getLemonade(){
        return new Drink("Lemonade (0.33l)", 128, 1.29);
    }

    @Bean(name = "water")
    public Drink getWater(){
        return new Drink("Water (0.5l)", 0, 1.29);
    }

    @Bean(name = "wine")
    public Drink getWine(){
        return new Drink("Wine (0.75l, 13%)", 607, 7.49);
    }

    @Bean(name = "pizza margherita")
    public Pizza getPizzaMargherita(){
        return new Pizza("Pizza Margherita", Arrays.asList(getTomato(), getCheese()), 1104, 4.99);
    }

    @Bean(name = "hawaiian pizza")
    public Pizza getHawaiianPizza(){
        return new Pizza("Hawaiian Pizza", Arrays.asList(getTomato(), getCheese(), getHam(), getPineapple()), 1024, 6.49);
    }

    @Bean(name = "salami pizza")
    public Pizza getSalamiPizza(){
        return new Pizza("Salami Pizza", Arrays.asList(getTomato(), getCheese(), getSalami()), 1160, 5.99);
    }

    @Bean(name ="table1")
    public Table getTable1(){
        return new Table(1, 6, true);
    }

    @Bean(name ="table2")
    public Table getTable2(){
        return new Table(2, 3, true);
    }

    @Bean(name ="table3")
    public Table getTable3(){
        return new Table(3, 2, false);
    }

    @Bean(name = "order1")
    public Order getOrder1(){
        return new Order(UUID.fromString("10c5a836-9c63-4738-8592-f2252cdfc9a8"), getTable1(), Arrays.asList(getHawaiianPizza(),getSalamiPizza(), getWater(), getLemonade()), OrderState.IN_PROGRESS, 2, LocalDateTime.now(), covered);
    }

    @Bean(name = "order2")
    public Order getOrder2(){
        return new Order(UUID.fromString("37d98088-3f68-47ec-81e1-0beeea7a3bcb"), getTable2(), Arrays.asList(getHawaiianPizza(),getSalamiPizza(), getPizzaMargherita(), getWater(), getLemonade(), getWine()), OrderState.IN_PROGRESS, 3, LocalDateTime.now(), covered);
    }
}
