package cristianmartucci.U5_W1_D3;

import cristianmartucci.U5_W1_D3.entities.Menu;
import cristianmartucci.U5_W1_D3.entities.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Component;

@Component
public class MyRunner implements CommandLineRunner {

    @Autowired
    private Menu menu;

    @Override
    public void run(String... args) throws Exception {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(U5W1D3Application.class);

        System.out.println(menu + "\n");

        Order order1 = (Order) context.getBean("order1");
        System.out.println(order1);

        Order order2 = (Order) context.getBean("order2");
        System.out.println(order2);

        context.close();
    }
}
