package weekly.week2;

import weekly.week2.product.Product;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class Cart implements DeliveryChargeCalculator {
    private final List<Product> products = new ArrayList<>();

    public void addProduct(Product product) {
        products.add(product);
    }

    @Override
    public BigDecimal getDeliveryCharge() {

        double weight = getTotalWeight();
        BigDecimal price = getTotalPrice();

        BigDecimal charge;
        if (weight < 3) {
            charge = BigDecimal.valueOf(1000);
        } else if (weight < 10) {
            charge = BigDecimal.valueOf(5000);
        } else {
            charge = BigDecimal.valueOf(10000);
        }

        BigDecimal lower = BigDecimal.valueOf(30000);
        BigDecimal upper = BigDecimal.valueOf(100000);
        BigDecimal discount = BigDecimal.valueOf(1000);

        if (0 <= price.compareTo(lower) && price.compareTo(upper) < 0) {
            charge = charge.subtract(discount);
        } else if (0 <= price.compareTo(upper)) {
            charge = BigDecimal.ZERO;
        }
        return charge;
    }

    private BigDecimal getTotalPrice() {
        BigDecimal price = BigDecimal.ZERO;
        for (Product product : products) {
            price = price.add(product.getPrice());
        }
        return price;

    }

    private double getTotalWeight() {
        double weight = 0;
        for (Product product : products) {
            weight += product.getWeight();
        }
        return weight;
    }
}
