package cristianmartucci.U5_W1_D3.entities;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@AllArgsConstructor
@Getter
@Setter
public class Pizza extends Product{
    private List<Topping> toppings;

    public Pizza(String name, List<Topping> toppings, int calories, double price) {
        super(name, calories, price);
        this.toppings = toppings;
    }

    @Override
    public String toString(){
        StringBuilder result = new StringBuilder("\n\t\t" + name + " (");
        for (int i = 0; i < toppings.size(); i++) {
            if (i < toppings.size() - 1) result.append(toppings.get(i).getName() + ", ");
            else result.append(toppings.get(i).getName());
        }
        result.append(")\t\tcalories= " + calories + "\t\tprice= " + price);
        return result.toString();
    }
}
