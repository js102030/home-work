package weekly.week2;

import weekly.week2.product.Beauty;
import weekly.week2.product.Grocery;
import weekly.week2.product.LargeAppliance;
import weekly.week2.product.Product;

import java.math.BigDecimal;

public class Main {
    public static void main(String[] args) {
        Product beauty = new Beauty("beauty", BigDecimal.valueOf(30000), 2);
        Product grocery = new Grocery("grocery", BigDecimal.valueOf(20000), 3);
        Product largeAppliance = new LargeAppliance("largeAppliance", BigDecimal.valueOf(50000), 5);

        Cart cart = new Cart(new Product[]{beauty, grocery, largeAppliance});
        System.out.println(cart.calculateDeliveryCharge());
    }
}
