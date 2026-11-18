package productapp;

//it Performs rhe VAT commission and total calculations of product sales
//it implements the IproductsCalculation iterface

public class ProductCalculations implements IProductCalculations {

    private static final double VAT_PERCENT = 15;
    private static final double COMMISSION_PERCENT = 5;

    private final double price;

    public ProductCalculations(double price) {
        this.price = price;
    }

    // VAT: 15% of the product price
    @Override
    public double GetVat() {
        return price * VAT_PERCENT / 100;
    }

    // Commission: 5% of the product price
    @Override
    public double GetCommission() {
        return price * COMMISSION_PERCENT / 100;
    }

    // Total: price + VAT + commission
    @Override
    public double GetTotal() {
        return price + GetVat() + GetCommission();
    }
}