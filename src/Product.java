import java.math.BigDecimal;

public class Product {
    private String name;
    private BigDecimal price;
    private Double weight;

    protected BigDecimal deliveryCharge;


    public Product() {
    }

    public Product(String name, BigDecimal price, Double weight) {
        this.name = name;
        this.price = price;
        this.weight = weight;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public Double getWeight() {
        return weight;
    }

    public void setWeight(Double weight) {
        this.weight = weight;
    }

    public BigDecimal getDeliveryCharge() {
        return deliveryCharge;
    }

    public void setDeliveryCharge(BigDecimal deliveryCharge) {
        this.deliveryCharge = deliveryCharge;
    }

    public BigDecimal calculateDeliveryCharge(Double weight, BigDecimal price)
    {
        BigDecimal weightDeliveryCharge;
        BigDecimal deliveryCharge;

        if(weight < DeliveryChargeProvider.LIGHT_WEIGHT_CUT)
        {
            weightDeliveryCharge = DeliveryChargeProvider.LIGHT_WEIGHT_CHARGE;
        }
        else if(weight < DeliveryChargeProvider.HEAVY_WEIGHT_CUT)
        {
            weightDeliveryCharge = DeliveryChargeProvider.MEDIUM_WEIGHT_CHARGE;
        }
        else
        {
            weightDeliveryCharge = DeliveryChargeProvider.HEAVY_WEIGHT_CHARGE;
        }


        if(price.compareTo(DeliveryChargeProvider.CHEAP_PRICE_CUT) < 0)
        {
            deliveryCharge = weightDeliveryCharge;
        }
        else if(price.compareTo(DeliveryChargeProvider.EXPENSIVE_PRICE_CUT) < 0)
        {
            deliveryCharge = weightDeliveryCharge.subtract(DeliveryChargeProvider.PRICE_CHARGE_DISCOUNT);
        }
        else
        {
            deliveryCharge = BigDecimal.ZERO;
        }

        return deliveryCharge;
    }
}
