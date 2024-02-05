package weekly.week2.product;

import java.math.BigDecimal;

public class LargeAppliance extends Product{
    public LargeAppliance(String name, BigDecimal price, double weight) {
        super(name, price, weight);
    }

    @Override
    public BigDecimal getDiscountAmount() {
        return BigDecimal.ZERO;
    }


}
