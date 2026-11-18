package tests;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import productapp.IProductCalculations;
import productapp.ProductCalculations;

//This is a Test class to check if my productcalculations class is working correctly
//It works automatically

public class ProductCalculationsTest {

    @Test
    public void GetVat_WithValidData_ReturnsCorrectValue() {
        IProductCalculations calc = new ProductCalculations(3500);

        double actual = calc.GetVat();

        assertEquals(525.0, actual, 0.001);
    }

    @Test
    public void GetTotal_WithValidData_ReturnsCorrectValue() {
        IProductCalculations calc = new ProductCalculations(3500);

        double actual = calc.GetTotal();

        assertEquals(4200.0, actual, 0.001);
    }
}