package weekly.week2.product;

import java.math.BigDecimal;

public class Beauty extends Product{
    public Beauty(String name, BigDecimal price, double weight) {
        super(name, price, weight);
    }

    @Override
    public BigDecimal getDiscountAmount() {
        return BigDecimal.valueOf(10000);
    }
}
