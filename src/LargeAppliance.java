import java.math.BigDecimal;

public class LargeAppliance extends Product implements DeliveryChargeCalculator{

    private BigDecimal totalCharge;

    public LargeAppliance(String name, BigDecimal price, Double weight) {
        super(name, price, weight);
        getDeliveryCharge(weight,price);
    }

    public BigDecimal getTotalCharge() {
        return totalCharge;
    }

    public void setTotalCharge(BigDecimal totalCharge) {
        this.totalCharge = totalCharge;
    }

    @Override
    public BigDecimal getDeliveryCharge(Double weight, BigDecimal price) {
        deliveryCharge = this.calculateDeliveryCharge(weight,price);
        totalCharge = price.add(deliveryCharge);
        return totalCharge;
    }

    @Override
    public String toString() {
        BigDecimal totalDeliveryCharge = getDeliveryCharge(getWeight(),getPrice());
        String output = String.format("%s\n무게 : %skg\n상품 가격 : %s원\n배송료 : %s원\n총 가격 : %s원",getName(),getWeight(),getPrice(),getDeliveryCharge(),getTotalCharge());

        return output;
    }
}
