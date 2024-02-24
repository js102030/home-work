package middletest.q1.shape;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class Rectangle implements Shape {
    private final BigDecimal width;
    private final BigDecimal height;

    public Rectangle(BigDecimal width, BigDecimal height) {
        validateDimension(width);
        validateDimension(height);
        this.width = width;
        this.height = height;
    }

    private void validateDimension(BigDecimal dimension) {
        if (dimension.compareTo(BigDecimal.ZERO) <= 0) {
            throw new IllegalArgumentException("너비와 높이는 0보다 커야 합니다.");
        }
    }

    @Override
    public BigDecimal getArea() {
        return width.multiply(height).setScale(20, RoundingMode.HALF_UP).stripTrailingZeros();
    }
}
