package weekly.week2.product;

import java.math.BigDecimal;

import static weekly.week2.config.DiscountConstants.GROCERY_PROMOTION_DISCOUNT;

public class Grocery extends Product {
    public Grocery(String name, BigDecimal price, double weight) {
        super(name, price, weight);
    }

    @Override
    public BigDecimal getDiscountAmount() {
        return BigDecimal.valueOf(GROCERY_PROMOTION_DISCOUNT);
    }
}
