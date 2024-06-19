package cristianmartucci.U5_W1_D3.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
public class Topping extends Product {

    public Topping(String name, int calories, double price) {
        super(name, calories, price);
    }

    @Override
    public String toString() {
        return  "\n\t\t"+name +
                "\t\t calories= " + calories +
                "\t\t price= " + price;
    }
}
