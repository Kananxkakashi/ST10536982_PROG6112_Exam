package productapp;

import java.awt.GridLayout;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;

//This is the Main GUI window for the mattress sales application
//it captures the sale details and calculates the ammounts

public class ProductApp extends JFrame {

    private static final String FILE_NAME = "data.txt";

    private final JTextField txtCustomer = new JTextField(20);
    private final JComboBox<String> cmbProduct = new JComboBox<>(new String[]{
        "Cozy Nights Monarch",
        "Restonic Barbados",
        "Sealy Phuket"
    });
    private final JTextField txtPrice = new JTextField(20);
    private final JButton btnProcess = new JButton("PROCESS");

    public ProductApp() {
        setTitle("Product App");
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        buildMenu();
        buildForm();

        btnProcess.addActionListener(e -> processSale());

        pack();
        setLocationRelativeTo(null);
    }

    // Q.2.4 - Menu system
    private void buildMenu() {
        JMenuBar menuBar = new JMenuBar();

        JMenu fileMenu = new JMenu("File");
        JMenuItem exitItem = new JMenuItem("Exit");
        exitItem.addActionListener(e -> System.exit(0));
        fileMenu.add(exitItem);

        JMenu toolsMenu = new JMenu("Tools");
        JMenuItem processItem = new JMenuItem("Process");
        processItem.addActionListener(e -> processSale());   // same logic as the button
        JMenuItem clearItem = new JMenuItem("Clear");
        clearItem.addActionListener(e -> clearForm());
        toolsMenu.add(processItem);
        toolsMenu.add(clearItem);

        menuBar.add(fileMenu);
        menuBar.add(toolsMenu);
        setJMenuBar(menuBar);
    }

    // Q.2.2 - Form controls
    private void buildForm() {
        JPanel panel = new JPanel(new GridLayout(4, 2, 10, 15));
        panel.setBorder(BorderFactory.createEmptyBorder(30, 30, 30, 30));

        panel.add(new JLabel("Customer Name:"));
        panel.add(txtCustomer);
        panel.add(new JLabel("Select Product:"));
        panel.add(cmbProduct);
        panel.add(new JLabel("Enter Price:"));
        panel.add(txtPrice);
        panel.add(new JLabel(""));
        panel.add(btnProcess);

        add(panel);
    }

    // Q.2.3 - Process logic
    private void processSale() {
        String customer = txtCustomer.getText().trim();
        String product = (String) cmbProduct.getSelectedItem();

        if (customer.isEmpty()) {
            showError("Please enter the customer's name.");
            return;
        }

        double price;
        try {
            price = Double.parseDouble(txtPrice.getText().trim());
        } catch (NumberFormatException ex) {
            showError("Please enter a valid numeric price.");
            return;
        }

        if (price <= 0) {
            showError("The price must be greater than zero.");
            return;
        }

        IProductCalculations calc = new ProductCalculations(price);
        double vat = calc.GetVat();
        double commission = calc.GetCommission();
        double total = calc.GetTotal();

        String message = "Customer Name: " + customer + "\n"
                + "Product: " + product + "\n"
                + "VAT: R " + vat + "\n"
                + "COMMISSION: R " + commission + "\n"
                + "TOTAL: R " + total;

        JOptionPane.showMessageDialog(this, message, "Message",
                JOptionPane.INFORMATION_MESSAGE);

        saveToFile(customer, product, vat, commission, total);
    }

    private void saveToFile(String customer, String product,
                            double vat, double commission, double total) {
        String stars = "***********************************";

        // true = append, so earlier sales are not overwritten
        try (PrintWriter out = new PrintWriter(new FileWriter(FILE_NAME, true))) {
            out.println("DATA LOG");
            out.println(stars);
            out.println();
            out.println("Customer Name: " + customer);
            out.println("Product: " + product);
            out.println("VAT: R " + vat);
            out.println("COMMISSION: R " + commission);
            out.println("TOTAL: R " + total);
            out.println(stars);
            out.println();
        } catch (IOException ex) {
            showError("Could not save to " + FILE_NAME + ": " + ex.getMessage());
        }
    }

    private void clearForm() {
        txtCustomer.setText("");
        txtPrice.setText("");
        cmbProduct.setSelectedIndex(0);
    }

    private void showError(String message) {
        JOptionPane.showMessageDialog(this, message, "Error",
                JOptionPane.ERROR_MESSAGE);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new ProductApp().setVisible(true));
    }
}