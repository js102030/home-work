package middletest.q1.shape;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class Circle implements IShape {
    private final BigDecimal radius;

    public Circle(BigDecimal radius) {
        validateDimension(radius);
        this.radius = radius;
    }

    private void validateDimension(BigDecimal dimension) {
        if (dimension.compareTo(BigDecimal.ZERO) <= 0) {
            throw new IllegalArgumentException("반지름은 0보다 커야 합니다.");
        }
    }

    @Override
    public BigDecimal getArea() {
        BigDecimal pi = new BigDecimal("3.14159265358979323846");
        return pi.multiply(radius.pow(2)).setScale(20, RoundingMode.HALF_UP).stripTrailingZeros();
    }
}
