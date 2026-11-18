package salesreport;

//Responsible only for printing the report data to the screen
//The calculations are done by the product class

public class PrintProduct {

    private final IProduct product;

    public PrintProduct(IProduct product) {
        this.product = product;
    }

    public void PrintTotalProductSales() {
        System.out.println("TOTAL PRODUCT SALES: " + product.GetTotalProductsSold());
    }

    public void PrintAverageProductSales() {
        System.out.println("AVERAGE PRODUCT SALES: "
                + String.format("%.0f", product.GetAverageProductSold()));
    }

    public void PrintMostPopularProductSale() {
        System.out.println("MOST POPULAR PRODUCT: " + product.GetMostPopularProduct());
    }
}