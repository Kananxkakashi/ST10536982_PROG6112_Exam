package productapp;

//Interface that defines the calculations required for a sale

public interface IProductCalculations {
    double GetVat();
    double GetCommission();
    double GetTotal();
}