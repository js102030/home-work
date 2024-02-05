package weekly.week2.product;
import java.math.BigDecimal;
import static weekly.week2.config.DiscountConstants.BEAUTY_PROMOTION_DISCOUNT;

public class Beauty extends Product{
    public Beauty(String name, BigDecimal price, double weight) {
        super(name, price, weight);
    }

    @Override
    public BigDecimal getDiscountAmount() {
        return BigDecimal.valueOf(BEAUTY_PROMOTION_DISCOUNT);
    }
}
