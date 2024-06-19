package cristianmartucci.U5_W1_D3.entities;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@AllArgsConstructor
@Getter
@Setter
public class Menu {
    private List<Pizza> pizzas;
    private List<Topping> toppings;
    private List<Drink> drinks;

    @Override
    public String toString() {
        return "Menu:" +
                "\n\tPizzas:" + pizzas +
                "\n\tToppings:" + toppings +
                "\n\tDrinks:" + drinks +
                '}';
    }
}
