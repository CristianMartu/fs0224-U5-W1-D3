package cristianmartucci.U5_W1_D3;

import cristianmartucci.U5_W1_D3.entities.Order;
import cristianmartucci.U5_W1_D3.entities.Product;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;


import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
class U5W1D3ApplicationTests {
	@Autowired
	private AnnotationConfigApplicationContext ctx;

	@Test
	void addProductToOrder() {
		Order order1 = (Order) ctx.getBean("order1");
		order1.setProducts(List.of((Product) ctx.getBean("pizza margherita")));
		assertEquals(1, order1.getProducts().size());
	}

	@ParameterizedTest
	@CsvSource({"1.50, 3, 4.50", "2, 6, 12", "1,20,20"})
	void testSumCovered(double covered_price, int number_covered, double result){
		assertEquals(covered_price * number_covered, result);
	}

	@ParameterizedTest
	@CsvSource({"pizza margherita, 4.99", "lemonade, 1.29", "wine, 7.49" })
	void testMenuPrice(String productName, double productPrice){
		Product product = (Product) ctx.getBean(productName);
		assertEquals(product.getPrice(), productPrice);
	}

	@ParameterizedTest
	@CsvSource({"order1, 18.06", "order2, 32.04"})
	void testTotalPriceOrder(String orderName, double price){
		Order order = (Order) ctx.getBean(orderName);
		double total = 0;
		for(Product product: order.getProducts()){
			total += product.getPrice();
		}
		total += order.getCost_covered() * order.getNumbered_covered();
		assertEquals(total, price);
	}

	@ParameterizedTest
	@CsvSource({"pizza margherita, hawaiian pizza, salami pizza, 17.47"})
	void testSum3Product(String product1, String product2, String product3, double result){
		Product p1 = (Product) ctx.getBean(product1);
		Product p2 = (Product) ctx.getBean(product2);
		Product p3 = (Product) ctx.getBean(product3);
		double sumTotal = p1.getPrice() + p2.getPrice() + p3.getPrice();
		assertEquals(sumTotal,result);
	}
}
