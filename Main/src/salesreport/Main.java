package salesreport;

import java.util.Scanner;

//Entry point of the application
//Captures the sales for each product then prints the sales report

public class Main {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        final int NUM_PRODUCTS = 3;
        final int NUM_MONTHS = 3;

        String[] products = {
            "Cozy Nights Monarch",
            "Restonic Barbados",
            "Sealy Phuket"
        };

        int[][] sales = new int[NUM_PRODUCTS][NUM_MONTHS];

        for (int p = 0; p < NUM_PRODUCTS; p++) {
            for (int m = 0; m < NUM_MONTHS; m++) {
                System.out.print("Enter number of sales for month " + (m + 1)
                        + " for " + products[p] + " mattress: ");
                sales[p][m] = input.nextInt();
            }
            System.out.println();
        }

        IProduct product = new Product(products, sales);
        PrintProduct printer = new PrintProduct(product);

        System.out.println();
        System.out.println("PRODUCT SALES REPORT - 2026");
        System.out.println();
        System.out.println("*****************************************************");
        printer.PrintTotalProductSales();
        printer.PrintAverageProductSales();
        printer.PrintMostPopularProductSale();

        input.close();
    }
}