package middletest.q3;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.DecimalFormat;

public abstract class Currency {
    private static final BigDecimal RATE_USD_KRW = new BigDecimal("1338.00");
    private static final BigDecimal RATE_JPY_KRW = new BigDecimal("9.0354");

    public static void exchange(BigDecimal krw) {
        if (krw.compareTo(BigDecimal.ZERO) <= 0) {
            System.out.println("0 이하의 금액은 환전할 수 없습니다.");
            return;
        }

        System.out.println("KRW 원 (₩) = " + formatCurrency(krw));
        System.out.println("USD 달러 ($) = " + formatCurrency(convertKrwToUsd(krw)) + " / JPY 엔 (¥) = " + formatCurrency(convertKrwToJpy(krw)));
    }

    private static BigDecimal convertKrwToUsd(BigDecimal krw) {
        return krw.divide(RATE_USD_KRW, 2, RoundingMode.HALF_UP);
    }

    private static BigDecimal convertKrwToJpy(BigDecimal krw) {
        return krw.divide(RATE_JPY_KRW, 2, RoundingMode.HALF_UP);
    }

    private static String formatCurrency(BigDecimal amount) {
        DecimalFormat decimalFormat = new DecimalFormat("#,##0.00");
        return decimalFormat.format(amount);
    }
}
