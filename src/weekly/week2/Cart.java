package weekly.week2;

import weekly.week2.product.Product;

import java.math.BigDecimal;

import static weekly.week2.config.ShippingCalcConst.*;

public class Cart {
    private final Product[] products;

    public Cart(Product[] products) {
        this.products = products;
    }

    public BigDecimal calculateDeliveryCharge() {

        double weight = getTotalWeight();
        BigDecimal price = getTotalPrice();

        BigDecimal charge;
        if (weight < WEIGHT_3KG) {
            charge = CHARGE_UNDER_3KG;
        } else if (weight < WEIGHT_10KG) {
            charge = CHARGE_3_TO_10KG;
        } else {
            charge = CHARGE_OVER_10KG;
        }

        if (0 <= price.compareTo(DISCOUNT_LOWER) && price.compareTo(DISCOUNT_UPPER) < 0) {
            charge = charge.subtract(CHARGE_DISCOUNT);
        } else if (0 <= price.compareTo(DISCOUNT_UPPER)) {
            charge = FREE_DELIVERY;
        }
        return charge;
    }


    private double getTotalWeight() {
        double weight = 0;
        for (Product product : products) {
            weight += product.getWeight();
        }
        return weight;
    }

    private BigDecimal getTotalPrice() {
        BigDecimal price = BigDecimal.ZERO;
        for (Product product : products) {
            BigDecimal promotionPrice = product.getPrice().subtract(product.getDiscountAmount());
            price = price.add(promotionPrice);
        }
        return price;
    }
}
