package cristianmartucci.U5_W1_D3.entities;


import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Drink extends Product {

    public Drink(String name, int calories, double price) {
        super(name, calories, price);
    }

    @Override
    public String toString() {
        return "\n\t\t" + name +
                "\t\t calories= " + calories +
                "\t\t price= " + price;
    }
}