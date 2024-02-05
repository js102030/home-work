package weekly.week2;

import java.math.BigDecimal;

public interface Promotion {
    default BigDecimal getDiscountAmount(){
        return BigDecimal.ZERO;
    }
}
