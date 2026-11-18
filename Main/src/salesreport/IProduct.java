package salesreport;

//interface that defines the methods every product sales class must implement

public interface IProduct {
    int GetTotalProductsSold();
    double GetAverageProductSold();
    String GetMostPopularProduct();
}