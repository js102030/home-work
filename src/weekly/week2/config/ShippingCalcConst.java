package weekly.week2.config;

import java.math.BigDecimal;

public abstract class ShippingCalcConst {
    public static final BigDecimal CHARGE_UNDER_3KG = BigDecimal.valueOf(1000);
    public static final BigDecimal CHARGE_3_TO_10KG = BigDecimal.valueOf(5000);
    public static final BigDecimal CHARGE_OVER_10KG = BigDecimal.valueOf(10000);
    public static final BigDecimal DISCOUNT_LOWER = BigDecimal.valueOf(30000);
    public static final BigDecimal DISCOUNT_UPPER = BigDecimal.valueOf(100000);
    public static final BigDecimal CHARGE_DISCOUNT = BigDecimal.valueOf(1000);
    public static final BigDecimal FREE_DELIVERY = BigDecimal.ZERO;

    public static final int WEIGHT_3KG = 3;
    public static final int WEIGHT_10KG = 10;
}
