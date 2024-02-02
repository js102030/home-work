package weekly.week2;

import weekly.week2.product.Beauty;
import weekly.week2.product.LargeAppliance;

import java.math.BigDecimal;

public class Main {
    public static void main(String[] args) {
        Cart cart = new Cart();

        Beauty beauty = new Beauty("b1", new BigDecimal(30000), 2.8);
        LargeAppliance appliance = new LargeAppliance("a1", new BigDecimal(20000), 0.21);

        cart.addProduct(beauty);
        cart.addProduct(appliance);

        System.out.println("deliveryCharge = " + cart.getDeliveryCharge());
    }
}
