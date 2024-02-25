package middletest.q1.shape;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class Triangle implements IShape {
    private final BigDecimal base;
    private final BigDecimal height;

    public Triangle(BigDecimal base, BigDecimal height) {
        validateDimension(base);
        validateDimension(height);
        this.base = base;
        this.height = height;
    }

    private void validateDimension(BigDecimal dimension) {
        if (dimension.compareTo(BigDecimal.ZERO) <= 0) {
            throw new IllegalArgumentException("밑변과 높이는 0보다 커야 합니다.");
        }
    }

    @Override
    public BigDecimal getArea() {
        return base.multiply(height).divide(new BigDecimal("2"), 20, RoundingMode.HALF_UP).stripTrailingZeros();
    }
}