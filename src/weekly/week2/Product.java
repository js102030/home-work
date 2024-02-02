package weekly.week2;

import java.math.BigDecimal;

public class Product implements DeliveryChargeCalculator {

    private final String name;
    private BigDecimal price;
    private final double weight;

    public Product(String name, BigDecimal price, double weight) {
        this.name = name;
        this.price = price;
        this.weight = weight;
    }

    @Override
    public BigDecimal getDeliveryCharge() {
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
}
