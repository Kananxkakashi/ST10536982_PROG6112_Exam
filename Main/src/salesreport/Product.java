package salesreport;

//Stores the sales data and performs the report calculations
//implements the Iproduct interfaces

public class Product implements IProduct {

    private final String[] productNames;   // 1D array
    private final int[][] sales;           // 2D array [product][month]

    public Product(String[] productNames, int[][] sales) {
        this.productNames = productNames;
        this.sales = sales;
    }

    private int getProductTotal(int productIndex) {
        int total = 0;
        for (int m = 0; m < sales[productIndex].length; m++) {
            total += sales[productIndex][m];
        }
        return total;
    }

    @Override
    public int GetTotalProductsSold() {
        int total = 0;
        for (int p = 0; p < sales.length; p++) {
            total += getProductTotal(p);
        }
        return total;
    }

    @Override
    public double GetAverageProductSold() {
        int entries = 0;
        for (int p = 0; p < sales.length; p++) {
            entries += sales[p].length;
        }
        return entries == 0 ? 0 : (double) GetTotalProductsSold() / entries;
    }

    @Override
    public String GetMostPopularProduct() {
        int bestIndex = 0;
        for (int p = 1; p < sales.length; p++) {
            if (getProductTotal(p) > getProductTotal(bestIndex)) {
                bestIndex = p;
            }
        }
        return productNames[bestIndex] + "(" + getProductTotal(bestIndex) + ")";
    }
}