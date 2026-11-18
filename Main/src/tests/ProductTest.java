package tests;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import salesreport.IProduct;
import salesreport.Product;

//Unit tests for the product class 
//uses the sample data from the exam paper

public class ProductTest {

    private final String[] names = {
        "Cozy Nights Monarch", "Restonic Barbados", "Sealy Phuket"
    };

    private final int[][] sales = {
        {25, 18, 20},
        {15, 10, 12},
        {18, 15, 20}
    };

    @Test
    public void GetTotalProductSales_WithValidData_ReturnsCorrectValue() {
        IProduct product = new Product(names, sales);

        int actual = product.GetTotalProductsSold();

        assertEquals(153, actual);
    }

    @Test
    public void GetAverageSales_WithValidData_ReturnsCorrectValue() {
        IProduct product = new Product(names, sales);

        double actual = product.GetAverageProductSold();

        assertEquals(17.0, actual, 0.001);
    }
}