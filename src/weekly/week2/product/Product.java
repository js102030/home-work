package weekly.week2.product;

import weekly.week2.Promotion;

import java.math.BigDecimal;

public abstract class Product implements Promotion {

    private final String name;
    private BigDecimal price;
    private final double weight;

    public Product(String name, BigDecimal price, double weight) {
        this.name = name;
        this.price = price;
        this.weight = weight;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public double getWeight() {
        return weight;
    }
}
