package middletest.q3;

import java.math.BigDecimal;

public class Main {
    public static void main(String[] args) {
        KrwCurrencyConverter.exchange(new BigDecimal("3000000"));
        KrwCurrencyConverter.exchange(new BigDecimal("-3000000")); // "0 이하의 금액은 환전할 수 없습니다."
        KrwCurrencyConverter.exchange(new BigDecimal("0")); // "0 이하의 금액은 환전할 수 없습니다."
    }
}
