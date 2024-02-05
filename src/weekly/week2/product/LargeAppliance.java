package weekly.week2.product;

import java.math.BigDecimal;

import static weekly.week2.config.DiscountConst.LARGE_APPLIANCE_PROMOTION_DISCOUNT;

public class LargeAppliance extends Product {
    public LargeAppliance(String name, BigDecimal price, double weight) {
        super(name, price, weight);
    }

    @Override
    public BigDecimal getDiscountAmount() {
        return BigDecimal.valueOf(LARGE_APPLIANCE_PROMOTION_DISCOUNT);
    }
}
